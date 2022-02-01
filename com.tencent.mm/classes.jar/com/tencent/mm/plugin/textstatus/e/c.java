package com.tencent.mm.plugin.textstatus.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.b.b;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.d;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.g;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.k.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.al;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnLike", "Landroid/widget/ImageView;", "getBtnLike", "()Landroid/widget/ImageView;", "setBtnLike", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "descExtraClickListener", "Lkotlin/Function0;", "", "getDescExtraClickListener", "()Lkotlin/jvm/functions/Function0;", "setDescExtraClickListener", "(Lkotlin/jvm/functions/Function0;)V", "extraShowParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "getExtraShowParam", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "setExtraShowParam", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;)V", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivBrand", "getIvBrand", "setIvBrand", "ivNick", "getIvNick", "setIvNick", "ivSecurityClose", "Landroid/view/View;", "getIvSecurityClose", "()Landroid/view/View;", "setIvSecurityClose", "(Landroid/view/View;)V", "lastGetCustomPartsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomPartsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomPartsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastPopupLikeDismissTime", "", "getLastPopupLikeDismissTime", "()J", "setLastPopupLikeDismissTime", "(J)V", "layoutAvatarSameFriends", "Landroid/widget/LinearLayout;", "getLayoutAvatarSameFriends", "()Landroid/widget/LinearLayout;", "setLayoutAvatarSameFriends", "(Landroid/widget/LinearLayout;)V", "layoutBrand", "getLayoutBrand", "setLayoutBrand", "layoutBrandAndPoi", "getLayoutBrandAndPoi", "setLayoutBrandAndPoi", "layoutBrandSpecialLayout", "Landroid/widget/FrameLayout;", "getLayoutBrandSpecialLayout", "()Landroid/widget/FrameLayout;", "setLayoutBrandSpecialLayout", "(Landroid/widget/FrameLayout;)V", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutCenter", "getLayoutCenter", "setLayoutCenter", "layoutLike", "getLayoutLike", "setLayoutLike", "layoutSecurity", "getLayoutSecurity", "setLayoutSecurity", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "getShowParam", "()Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "statusId", "", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvBrand", "Landroid/widget/TextView;", "getTvBrand", "()Landroid/widget/TextView;", "setTvBrand", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNick", "getTvNick", "setTvNick", "tvPoi", "getTvPoi", "setTvPoi", "tvRefBack", "getTvRefBack", "setTvRefBack", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvSecurity", "getTvSecurity", "setTvSecurity", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "vSplitBrandPoi", "getVSplitBrandPoi", "setVSplitBrandPoi", "vSplitBrandStatus", "getVSplitBrandStatus", "setVSplitBrandStatus", "brandClick", "checkCurCustomPartsValid", "", "topicInfo", "destroyCustomPartsManual", "getCustomParts", "getStatusIconDefAlpha", "", "imgResId", "goTopicMiniApp", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "handleBrand", "handleBrandAndPoiVisibility", "handleDesc", "textStatusDesc", "handleLike", "handleSecurity", "iconStatusClick", "init", "contentView", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preloadMiniProgram", "setDescExtraSpaceClickCallback", "callback", "setThumb", "bitmap", "Landroid/graphics/Bitmap;", "update", "item", "extraParam", "updateBrandStatusSplitLine", "updateLikeNum", "updateOtherUserLocalState", "isLike", "isShowCustomBrand", "Companion", "DescSpan", "TextStatusMovementMethod", "plugin-textstatus_release"})
public class c
  implements com.tencent.mm.an.i, e
{
  public static final c.a MCA;
  private static long MCz;
  private TextView MBS;
  private TextView MBT;
  private String MBU;
  private TextView MBV;
  private ImageView MBW;
  private View MBX;
  private TextView MBY;
  private LinearLayout MBZ;
  private LinearLayout MCa;
  private ImageView MCb;
  private TextView MCc;
  private TextView MCd;
  public ImageView MCe;
  private View MCf;
  ImageView MCg;
  public TextView MCh;
  private ImageView MCi;
  private TextView MCj;
  private FrameLayout MCk;
  private TextView MCl;
  View MCm;
  private View MCn;
  private View MCo;
  private View MCp;
  LinearLayout MCq;
  private View MCr;
  com.tencent.mm.plugin.textstatus.g.e.a MCs;
  private com.tencent.mm.plugin.textstatus.proto.i MCt;
  long MCu;
  private com.tencent.mm.plugin.textstatus.a.c MCv;
  private TextStatusTopicInfo MCw;
  kotlin.g.a.a<x> MCx;
  private final r MCy;
  public Context context;
  private String username;
  
  static
  {
    AppMethodBeat.i(233656);
    MCA = new c.a((byte)0);
    AppMethodBeat.o(233656);
  }
  
  public c(r paramr)
  {
    AppMethodBeat.i(233655);
    this.MCy = paramr;
    this.username = "";
    this.MBU = "";
    AppMethodBeat.o(233655);
  }
  
  protected static float ber(String paramString)
  {
    AppMethodBeat.i(233634);
    p.k(paramString, "imgResId");
    if (p.h(paramString, "2021"))
    {
      AppMethodBeat.o(233634);
      return 1.0F;
    }
    AppMethodBeat.o(233634);
    return 0.6F;
  }
  
  @SuppressLint({"ResourceType"})
  private final void glT()
  {
    AppMethodBeat.i(233650);
    Object localObject1 = this.MCs;
    if (localObject1 == null)
    {
      AppMethodBeat.o(233650);
      return;
    }
    Object localObject2;
    int i;
    label71:
    Context localContext;
    if (p.h(this.username, com.tencent.mm.plugin.auth.a.a.crN()))
    {
      localObject2 = this.MCt;
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.plugin.textstatus.proto.i)localObject2).MFk;
        if (i == -1) {
          break label338;
        }
        localObject1 = this.MCt;
        if (localObject1 == null) {
          break label333;
        }
        i = ((com.tencent.mm.plugin.textstatus.proto.i)localObject1).MFk;
        localObject1 = this.MCf;
        if (localObject1 != null) {
          ((View)localObject1).setBackground(null);
        }
        if (i <= 0) {
          break label375;
        }
        localObject1 = this.MCh;
        if (localObject1 == null) {
          p.bGy("tvLikeNum");
        }
        ((TextView)localObject1).setText((CharSequence)String.valueOf(i));
        localObject1 = this.MCh;
        if (localObject1 == null) {
          p.bGy("tvLikeNum");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this.MCe;
        if (localObject1 == null) {
          p.bGy("btnLike");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.MCf;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        label169:
        localObject1 = this.MCe;
        if (localObject1 == null) {
          p.bGy("btnLike");
        }
        localObject2 = this.context;
        if (localObject2 == null) {
          p.bGy("context");
        }
        localObject2 = ((Context)localObject2).getResources().getDrawable(b.g.finder_filled_like_private);
        localContext = this.context;
        if (localContext == null) {
          p.bGy("context");
        }
        ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(b.b.White)));
        label251:
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
        localObject1 = this.context;
        if (localObject1 == null) {
          p.bGy("context");
        }
        localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject1, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
        if (localObject2 == null) {
          break label766;
        }
        localObject1 = this.MCe;
        if (localObject1 == null) {
          p.bGy("btnLike");
        }
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label759;
        }
      }
    }
    label333:
    label338:
    label759:
    for (localObject1 = "1";; localObject1 = "0")
    {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).MEW = ((String)localObject1);
      AppMethodBeat.o(233650);
      return;
      i = -1;
      break;
      i = 0;
      break label71;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      i = com.tencent.mm.plugin.textstatus.b.f.glz().bev(((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_StatusID);
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      i += com.tencent.mm.plugin.textstatus.b.f.glB().bev(((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_StatusID);
      break label71;
      label375:
      localObject1 = this.MCh;
      if (localObject1 == null) {
        p.bGy("tvLikeNum");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = this.MCe;
      if (localObject1 == null) {
        p.bGy("btnLike");
      }
      ((ImageView)localObject1).setVisibility(8);
      localObject1 = this.MCf;
      if (localObject1 == null) {
        break label169;
      }
      ((View)localObject1).setVisibility(8);
      break label169;
      localObject2 = this.MCf;
      if (localObject2 != null)
      {
        localContext = this.context;
        if (localContext == null) {
          p.bGy("context");
        }
        ((View)localObject2).setBackground(localContext.getResources().getDrawable(b.d.MuL));
      }
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      boolean bool = com.tencent.mm.plugin.textstatus.b.f.glz().beu(((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_StatusID);
      localObject1 = this.MCe;
      if (localObject1 == null) {
        p.bGy("btnLike");
      }
      ((ImageView)localObject1).setTag(Boolean.valueOf(bool));
      localObject1 = this.MCh;
      if (localObject1 == null) {
        p.bGy("tvLikeNum");
      }
      localObject2 = this.context;
      if (localObject2 == null) {
        p.bGy("context");
      }
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(b.h.MyU));
      localObject1 = this.MCh;
      if (localObject1 == null) {
        p.bGy("tvLikeNum");
      }
      ((TextView)localObject1).setVisibility(0);
      if (bool)
      {
        localObject1 = this.MCe;
        if (localObject1 == null) {
          p.bGy("btnLike");
        }
        localObject2 = this.context;
        if (localObject2 == null) {
          p.bGy("context");
        }
        localObject2 = ((Context)localObject2).getResources().getDrawable(b.g.icon_filled_awesome);
        localContext = this.context;
        if (localContext == null) {
          p.bGy("context");
        }
        ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(b.b.Red_100)));
        break label251;
      }
      localObject1 = this.MCe;
      if (localObject1 == null) {
        p.bGy("btnLike");
      }
      localObject2 = this.context;
      if (localObject2 == null) {
        p.bGy("context");
      }
      localObject2 = ((Context)localObject2).getResources().getDrawable(b.g.icons_outlined_like);
      localContext = this.context;
      if (localContext == null) {
        p.bGy("context");
      }
      ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(b.b.White)));
      break label251;
    }
    label766:
    AppMethodBeat.o(233650);
  }
  
  public final boolean aUx(String paramString)
  {
    AppMethodBeat.i(233612);
    p.k(paramString, "username");
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.MAm;
    boolean bool = b(paramString, com.tencent.mm.plugin.textstatus.b.f.bep(paramString), new com.tencent.mm.plugin.textstatus.proto.i());
    AppMethodBeat.o(233612);
    return bool;
  }
  
  public final void ag(kotlin.g.a.a<x> parama)
  {
    this.MCx = parama;
  }
  
  public final boolean b(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(233636);
    p.k(paramTextStatusTopicInfo, "$this$isShowCustomBrand");
    paramTextStatusTopicInfo = (CharSequence)paramTextStatusTopicInfo.sourceId;
    if ((paramTextStatusTopicInfo == null) || (kotlin.n.n.ba(paramTextStatusTopicInfo))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(233636);
      return false;
    }
    paramTextStatusTopicInfo = glQ();
    if ((paramTextStatusTopicInfo != null) && (paramTextStatusTopicInfo.dDL() == true))
    {
      AppMethodBeat.o(233636);
      return false;
    }
    AppMethodBeat.o(233636);
    return true;
  }
  
  public boolean b(final String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama, final com.tencent.mm.plugin.textstatus.proto.i parami)
  {
    AppMethodBeat.i(233626);
    p.k(paramString, "username");
    this.username = paramString;
    this.MCs = parama;
    this.MCt = parami;
    Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", "[update status]info:%s", new Object[] { this.MCs });
    if (parama == null)
    {
      AppMethodBeat.o(233626);
      return false;
    }
    if ((!TextUtils.isEmpty((CharSequence)this.MCy.MzN)) && (!TextUtils.equals((CharSequence)this.MCy.MzN, (CharSequence)parama.field_TopicId)))
    {
      AppMethodBeat.o(233626);
      return false;
    }
    parami = com.tencent.mm.plugin.secdata.ui.a.JbV;
    parami = this.context;
    if (parami == null) {
      p.bGy("context");
    }
    parami = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(parami, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    if (parami != null) {
      parami.MFf = this.MCy.MzO;
    }
    Object localObject1 = com.tencent.mm.plugin.textstatus.k.c.gnz().d(parama.glY());
    parami = parama.field_StatusID;
    p.j(parami, "info.field_StatusID");
    this.MBU = parami;
    Object localObject3 = parama.field_Description;
    Object localObject2 = parama.field_IconID;
    parami = this.MBT;
    if (parami != null) {
      parami.setMovementMethod(null);
    }
    boolean bool;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      parami = this.context;
      if (parami == null) {
        p.bGy("context");
      }
      Object localObject4 = (CharSequence)localObject3;
      Object localObject5 = this.MBT;
      float f;
      if (localObject5 != null)
      {
        f = ((TextView)localObject5).getTextSize();
        localObject4 = new SpannableString(com.tencent.mm.ui.h.c.b.c(parami, (CharSequence)localObject4, f));
        if (!p.h(this.username, com.tencent.mm.plugin.auth.a.a.crN())) {
          break label396;
        }
        bool = com.tencent.mm.plugin.textstatus.a.t.gls();
      }
      for (;;)
      {
        if (bool)
        {
          int k = Color.parseColor("#ADBACC");
          localObject5 = new f(this);
          parami = m.MOX;
          Matcher localMatcher = m.gnM().matcher((CharSequence)localObject3);
          i = 0;
          if (localMatcher.find())
          {
            int m = localMatcher.start();
            int n = localMatcher.end();
            if (localObject3 != null)
            {
              if (localObject3 == null)
              {
                paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(233626);
                throw paramString;
                f = 0.0F;
                break;
                label396:
                bool = com.tencent.mm.plugin.textstatus.a.t.glt();
                continue;
              }
              parami = ((String)localObject3).substring(m + 1, n);
              p.j(parami, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              label423:
              CharSequence localCharSequence = (CharSequence)parami;
              if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
                break label489;
              }
            }
            label489:
            for (int j = 1;; j = 0)
            {
              if (j == 0)
              {
                i = 1;
                ((SpannableString)localObject4).setSpan(new c.b(parami, k, k, (j)localObject5), m, n, 33);
              }
              break;
              parami = null;
              break label423;
            }
          }
          if (i != 0)
          {
            parami = this.MBT;
            if (parami != null) {
              parami.setMovementMethod((MovementMethod)new c.c(this.MCx));
            }
            ((com.tencent.mm.plugin.appbrand.service.f)h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.qPk);
            long l = cm.bfE();
            if (Math.abs(l - MCz) > 3600000L)
            {
              ((w)h.ae(w.class)).bu("gh_390359b3fd13@app", 0);
              MCz = l;
            }
          }
        }
      }
      parami = this.MBT;
      if (parami != null) {
        parami.setOnClickListener((View.OnClickListener)new c.e(this));
      }
      parami = this.MBT;
      if (parami != null) {
        parami.setText((CharSequence)localObject4);
      }
      parami = this.MBT;
      if (parami != null)
      {
        localObject3 = this.context;
        if (localObject3 == null) {
          p.bGy("context");
        }
        parami.setTextSize(0, ((Context)localObject3).getResources().getDimensionPixelSize(b.c.Muy));
      }
      if ((!this.MCy.ajh(8)) || (localObject2 == null)) {
        break label1448;
      }
      parami = this.MCg;
      if (parami != null) {
        parami.setAlpha(ber((String)localObject2));
      }
      if (!p.h(localObject2, "2021")) {
        break label1429;
      }
      parami = this.MCg;
      if (parami != null) {
        parami.setAlpha(1.0F);
      }
      label733:
      parami = this.MCg;
      if (parami != null) {
        parami.setVisibility(0);
      }
      com.tencent.mm.plugin.textstatus.k.c.gnz().a(this.MCg, (String)localObject2, a.c.MzI, com.tencent.mm.plugin.textstatus.a.a.a.Mzu, parama);
      parami = this.MCg;
      if (parami != null) {
        parami.setOnClickListener((View.OnClickListener)new c.k(this));
      }
      label790:
      parami = this.MBS;
      if (parami != null) {
        parami.setText((CharSequence)localObject1);
      }
      parami = this.MCs;
      if (parami != null) {
        break label1466;
      }
      label817:
      if (this.MCy.MzP)
      {
        parami = this.MBW;
        if (parami != null)
        {
          if (!this.MCy.MzM) {
            break label1560;
          }
          localObject1 = com.tencent.mm.plugin.textstatus.f.a.MCH;
          localObject1 = this.context;
          if (localObject1 == null) {
            p.bGy("context");
          }
          com.tencent.mm.plugin.textstatus.f.a.a((Context)localObject1, parami, paramString, parama);
        }
      }
      label876:
      parami = (CharSequence)parama.field_PoiName;
      if ((parami != null) && (!kotlin.n.n.ba(parami))) {
        break label1594;
      }
      i = 1;
      label898:
      if (i == 0) {
        break label1600;
      }
      parami = this.MBY;
      if (parami != null) {
        parami.setVisibility(8);
      }
      label918:
      parami = this.MBZ;
      if (parami != null) {
        parami.removeAllViews();
      }
      if (!this.MCy.ajh(1)) {
        break label1637;
      }
      parami = this.MCi;
      if (parami != null) {
        parami.setVisibility(0);
      }
      a.b.c(this.MCi, paramString);
      label964:
      if (!this.MCy.ajh(2)) {
        break label1655;
      }
      parami = this.MCj;
      if (parami != null) {
        parami.setVisibility(0);
      }
      paramString = aa.PJ(paramString);
      parami = this.MCj;
      if (parami != null) {
        parami.setText((CharSequence)paramString);
      }
      label1011:
      p.k(parama, "info");
      paramString = parama.glY();
      if (!b(paramString)) {
        break label1790;
      }
      parami = new StringBuilder("[handleBrand] ");
      localObject1 = (CharSequence)paramString.sourceIcon;
      if ((localObject1 != null) && (!kotlin.n.n.ba((CharSequence)localObject1))) {
        break label1673;
      }
      bool = true;
      label1067:
      Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", bool + ',' + paramString.sourceName);
      parami = this.MCa;
      if (parami != null) {
        parami.setVisibility(0);
      }
      parami = this.MCc;
      if (parami != null) {
        parami.setText((CharSequence)paramString.sourceName);
      }
      parami = glQ();
      localObject1 = this.MCk;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).removeAllViews();
      }
      if ((parami == null) || (parami.e(this.MCk) != true)) {
        break label1679;
      }
      i = 1;
      label1168:
      if (i == 0) {
        break label1685;
      }
      paramString = this.MCk;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.MCb;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      label1202:
      paramString = this.MCa;
      if ((paramString == null) || (paramString.getVisibility() != 0)) {
        break label1808;
      }
      paramString = this.MBY;
      if ((paramString == null) || (paramString.getVisibility() != 0)) {
        break label1808;
      }
      paramString = this.MCo;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      label1248:
      paramString = this.MCa;
      if ((paramString == null) || (paramString.getVisibility() != 0))
      {
        paramString = this.MBY;
        if ((paramString == null) || (paramString.getVisibility() != 0)) {
          break label1826;
        }
      }
      paramString = this.MCp;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      label1294:
      paramString = this.MCs;
      if (paramString != null) {
        break label1844;
      }
      paramString = this.MCd;
      if (paramString != null)
      {
        p.k(parama, "$this$isReference");
        parama = (CharSequence)parama.field_referenceUserName;
        if ((parama != null) && (!kotlin.n.n.ba(parama))) {
          break label2087;
        }
        i = 1;
        label1341:
        if (i != 0) {
          break label2093;
        }
        i = 1;
        label1349:
        if (i == 0) {
          break label2105;
        }
        parama = this.MCa;
        if ((parama == null) || (parama.getVisibility() != 0)) {
          break label2099;
        }
        i = 8;
      }
    }
    label1429:
    label1448:
    label2093:
    label2099:
    for (;;)
    {
      paramString.setVisibility(i);
      glD();
      AppMethodBeat.o(233626);
      return true;
      parami = this.MBT;
      if (parami != null) {
        parami.setText((CharSequence)"");
      }
      parami = this.MBT;
      if (parami == null) {
        break;
      }
      parami.setTextSize(0, 0.0F);
      break;
      parami = this.MCg;
      if (parami == null) {
        break label733;
      }
      parami.setAlpha(0.6F);
      break label733;
      parami = this.MCg;
      if (parami == null) {
        break label790;
      }
      parami.setVisibility(8);
      break label790;
      label1466:
      glT();
      parami = (View.OnClickListener)new g(this, paramString, parami);
      localObject1 = this.MCf;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(parami);
      }
      localObject1 = this.MCe;
      if (localObject1 == null) {
        p.bGy("btnLike");
      }
      if (localObject1 != null) {
        ((ImageView)localObject1).setOnClickListener(parami);
      }
      localObject1 = this.MCh;
      if (localObject1 == null) {
        p.bGy("tvLikeNum");
      }
      if (localObject1 == null) {
        break label817;
      }
      ((TextView)localObject1).setOnClickListener(parami);
      break label817;
      localObject1 = com.tencent.mm.plugin.textstatus.f.a.MCH;
      localObject2 = this.context;
      if (localObject2 == null) {
        p.bGy("context");
      }
      com.tencent.mm.plugin.textstatus.f.a.a((com.tencent.mm.plugin.textstatus.f.a)localObject1, (Context)localObject2, paramString, parami);
      break label876;
      label1594:
      i = 0;
      break label898;
      label1600:
      parami = this.MBY;
      if (parami != null) {
        parami.setVisibility(0);
      }
      parami = this.MBY;
      if (parami == null) {
        break label918;
      }
      parami.setText((CharSequence)parama.field_PoiName);
      break label918;
      label1637:
      parami = this.MCi;
      if (parami == null) {
        break label964;
      }
      parami.setVisibility(8);
      break label964;
      label1655:
      paramString = this.MCj;
      if (paramString == null) {
        break label1011;
      }
      paramString.setVisibility(8);
      break label1011;
      bool = false;
      break label1067;
      i = 0;
      break label1168;
      parami = this.MCk;
      if (parami != null) {
        parami.setVisibility(8);
      }
      parami = (CharSequence)paramString.sourceIcon;
      if ((parami == null) || (kotlin.n.n.ba(parami))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1772;
        }
        parami = this.MCb;
        if (parami == null) {
          break;
        }
        parami.setVisibility(0);
        com.tencent.mm.ay.q.bml().loadImage(paramString.sourceIcon, parami);
        paramString = com.tencent.mm.plugin.textstatus.k.n.MOY;
        com.tencent.mm.plugin.textstatus.k.n.hb((View)parami);
        break;
      }
      label1772:
      paramString = this.MCb;
      if (paramString == null) {
        break label1202;
      }
      paramString.setVisibility(8);
      break label1202;
      label1790:
      paramString = this.MCa;
      if (paramString == null) {
        break label1202;
      }
      paramString.setVisibility(8);
      break label1202;
      paramString = this.MCo;
      if (paramString == null) {
        break label1248;
      }
      paramString.setVisibility(8);
      break label1248;
      paramString = this.MCp;
      if (paramString == null) {
        break label1294;
      }
      paramString.setVisibility(8);
      break label1294;
      label1844:
      switch (paramString.field_state)
      {
      default: 
        paramString = this.MCm;
        if (paramString == null) {
          break;
        }
        paramString.setVisibility(8);
        break;
      case 5: 
        paramString = this.MCm;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.context;
        if (paramString == null) {
          p.bGy("context");
        }
        paramString = paramString.getResources().getString(b.h.Mze);
        p.j(paramString, "context.resources.getStr….text_status_tips_resend)");
        parami = this.MCl;
        if (parami != null) {
          parami.setText((CharSequence)paramString);
        }
        paramString = this.MCn;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.MCm;
        if (paramString == null) {
          break;
        }
        paramString.setOnClickListener((View.OnClickListener)new h(this));
        break;
      case 6: 
        paramString = this.MCm;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.MCn;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = com.tencent.mm.plugin.textstatus.g.g.c.MEt;
        paramString = null;
        parami = com.tencent.mm.plugin.textstatus.g.g.c.gmk();
        if (parami != null) {
          paramString = parami.errMsg;
        }
        parami = this.MCl;
        if (parami != null) {
          parami.setText((CharSequence)paramString);
        }
        paramString = this.MCm;
        if (paramString == null) {
          break;
        }
        paramString.setOnClickListener((View.OnClickListener)new c.i(this));
        break;
        i = 0;
        break label1341;
        i = 0;
        break label1349;
        i = 0;
        continue;
        label2105:
        i = 8;
      }
    }
  }
  
  public void g(View paramView)
  {
    AppMethodBeat.i(233610);
    p.k(paramView, "contentView");
    Object localObject = paramView.getContext();
    p.j(localObject, "contentView.context");
    this.context = ((Context)localObject);
    this.MBS = ((TextView)paramView.findViewById(b.e.Mxj));
    this.MBV = ((TextView)paramView.findViewById(b.e.Mxh));
    this.MBT = ((TextView)paramView.findViewById(b.e.MwQ));
    this.MBY = ((TextView)paramView.findViewById(b.e.Mxf));
    localObject = paramView.findViewById(b.e.MuO);
    p.j(localObject, "contentView.findViewById(R.id.btn_like)");
    this.MCe = ((ImageView)localObject);
    this.MCf = paramView.findViewById(b.e.MvT);
    this.MCg = ((ImageView)paramView.findViewById(b.e.Mvi));
    localObject = paramView.findViewById(b.e.MwY);
    p.j(localObject, "contentView.findViewById(R.id.tv_like_num)");
    this.MCh = ((TextView)localObject);
    this.MBW = ((ImageView)paramView.findViewById(b.e.Mxr));
    this.MBX = paramView.findViewById(b.e.MvM);
    this.MCa = ((LinearLayout)paramView.findViewById(b.e.MvK));
    this.MCb = ((ImageView)paramView.findViewById(b.e.Mvs));
    this.MCc = ((TextView)paramView.findViewById(b.e.MwP));
    this.MCi = ((ImageView)paramView.findViewById(b.e.Mvv));
    this.MCj = ((TextView)paramView.findViewById(b.e.Mxc));
    this.MCk = ((FrameLayout)paramView.findViewById(b.e.MvL));
    this.MCm = paramView.findViewById(b.e.Mwb);
    this.MCn = paramView.findViewById(b.e.Mvz);
    this.MCl = ((TextView)paramView.findViewById(b.e.Mxi));
    this.MCq = ((LinearLayout)paramView.findViewById(b.e.MvN));
    this.MCr = paramView.findViewById(b.e.Mxy);
    paramView = this.MCa;
    if (paramView != null)
    {
      paramView.setOnClickListener((View.OnClickListener)new c.j(this));
      AppMethodBeat.o(233610);
      return;
    }
    AppMethodBeat.o(233610);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(233600);
    Context localContext = this.context;
    if (localContext == null) {
      p.bGy("context");
    }
    AppMethodBeat.o(233600);
    return localContext;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public void glD()
  {
    AppMethodBeat.i(233630);
    View localView = this.MCr;
    if (localView != null)
    {
      Object localObject = this.MCa;
      if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0))
      {
        localObject = this.MCg;
        if ((localObject == null) || (((ImageView)localObject).getVisibility() != 0)) {}
      }
      for (int i = 0;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(233630);
        return;
      }
    }
    AppMethodBeat.o(233630);
  }
  
  public boolean glE()
  {
    AppMethodBeat.i(233632);
    Object localObject = this.MCs;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_IconID; p.h(localObject, "2021"); localObject = null)
    {
      localObject = (com.tencent.mm.plugin.festival.a.a)h.ae(com.tencent.mm.plugin.festival.a.a.class);
      Context localContext = this.context;
      if (localContext == null) {
        p.bGy("context");
      }
      ((com.tencent.mm.plugin.festival.a.a)localObject).fp(localContext);
      localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
      localObject = this.context;
      if (localObject == null) {
        p.bGy("context");
      }
      com.tencent.mm.plugin.textstatus.h.a.a((Context)localObject, 25L, null, this.MCs, 4);
      AppMethodBeat.o(233632);
      return true;
    }
    AppMethodBeat.o(233632);
    return false;
  }
  
  public void glG()
  {
    AppMethodBeat.i(233611);
    Object localObject1 = this.MCs;
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
      localObject1 = com.tencent.mm.plugin.textstatus.d.a.MBv;
      localObject1 = this.context;
      if (localObject1 == null) {
        p.bGy("context");
      }
      com.tencent.mm.plugin.textstatus.a.i locali = (com.tencent.mm.plugin.textstatus.a.i)glQ();
      localObject2 = ((TextStatusTopicInfo)localObject2).sourceJumpInfos;
      p.j(localObject2, "topicInfo.sourceJumpInfos");
      localObject2 = (List)localObject2;
      p.k(localObject1, "context");
      p.k(localObject2, "jumpInfos");
      if (locali != null) {}
      for (boolean bool = locali.fz((Context)localObject1);; bool = false)
      {
        com.tencent.mm.plugin.textstatus.d.a.a((Context)localObject1, bool, (List)localObject2);
        localObject1 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        localObject1 = this.context;
        if (localObject1 == null) {
          p.bGy("context");
        }
        com.tencent.mm.plugin.textstatus.h.a.a((Context)localObject1, 23L, null, this.MCs, 4);
        AppMethodBeat.o(233611);
        return;
      }
    }
    AppMethodBeat.o(233611);
  }
  
  public final TextView glI()
  {
    return this.MBT;
  }
  
  public final TextView glJ()
  {
    return this.MBV;
  }
  
  public final TextView glK()
  {
    return this.MBY;
  }
  
  public final LinearLayout glL()
  {
    return this.MCa;
  }
  
  public final ImageView glM()
  {
    AppMethodBeat.i(233606);
    ImageView localImageView = this.MCe;
    if (localImageView == null) {
      p.bGy("btnLike");
    }
    AppMethodBeat.o(233606);
    return localImageView;
  }
  
  public final View glN()
  {
    return this.MCf;
  }
  
  public final TextView glO()
  {
    AppMethodBeat.i(233607);
    TextView localTextView = this.MCh;
    if (localTextView == null) {
      p.bGy("tvLikeNum");
    }
    AppMethodBeat.o(233607);
    return localTextView;
  }
  
  public final View glP()
  {
    return this.MCr;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.c glQ()
  {
    Object localObject5 = null;
    AppMethodBeat.i(233639);
    Object localObject1 = this.MCs;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
    }
    for (;;)
    {
      int i;
      if (this.MCv == null)
      {
        i = 0;
        label32:
        if (i == 0) {
          glS();
        }
      }
      try
      {
        Object localObject2 = com.tencent.mm.plugin.textstatus.j.d.MIW;
        localObject2 = com.tencent.mm.plugin.textstatus.j.d.gmo();
        this.MCv = ((com.tencent.mm.plugin.textstatus.a.c)localObject2);
        com.tencent.mm.plugin.textstatus.a.c localc = this.MCv;
        if (localc != null)
        {
          localObject2 = this.MCs;
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_StatusID;
            if (localObject1 == null) {
              break label255;
            }
            localObject4 = ((TextStatusTopicInfo)localObject1).sourceJumpInfos;
            List localList = (List)localObject4;
            if (localObject1 == null) {
              break label261;
            }
            localObject4 = ((TextStatusTopicInfo)localObject1).jumpInfos;
            localc.c((String)localObject2, localList, (List)localObject4);
          }
        }
        else
        {
          this.MCw = ((TextStatusTopicInfo)localObject1);
          localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
          localObject1 = this.context;
          if (localObject1 == null) {
            p.bGy("context");
          }
          localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a((Context)localObject1, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
          if (localObject2 != null)
          {
            localObject4 = this.MCv;
            localObject1 = localObject5;
            if (localObject4 != null) {
              localObject1 = ((com.tencent.mm.plugin.textstatus.a.c)localObject4).dDG();
            }
            ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).lVU = ((String)localObject1);
          }
          localObject1 = this.MCv;
          AppMethodBeat.o(233639);
          return localObject1;
          localObject1 = null;
          continue;
          localObject2 = this.MCw;
          if ((localObject2 == null) || (com.tencent.mm.plugin.textstatus.ui.b.a((TextStatusTopicInfo)localObject2, (TextStatusTopicInfo)localObject1) != true))
          {
            i = 0;
            break label32;
          }
          i = 1;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.TextStatus.BaseStatusLoadLogic", localThrowable, "customps err", new Object[0]);
          Object localObject3 = null;
          continue;
          localObject3 = null;
          continue;
          label255:
          Object localObject4 = null;
          continue;
          label261:
          localObject4 = null;
        }
      }
    }
  }
  
  public final void glS()
  {
    AppMethodBeat.i(233643);
    com.tencent.mm.plugin.textstatus.a.c localc = this.MCv;
    if (localc != null) {
      localc.onDetach();
    }
    this.MCv = null;
    this.MCw = null;
    AppMethodBeat.o(233643);
  }
  
  public final r glU()
  {
    return this.MCy;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(233652);
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.l))
    {
      h.aGY().b(((com.tencent.mm.plugin.textstatus.g.l)paramq).getType(), (com.tencent.mm.an.i)this);
      glT();
    }
    AppMethodBeat.o(233652);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "toJsonString"})
  static final class d
    implements com.tencent.mm.plugin.appbrand.api.d
  {
    d(c paramc, u paramu) {}
    
    public final String bFa()
    {
      AppMethodBeat.i(234351);
      JSONObject localJSONObject = new JSONObject();
      com.tencent.mm.plugin.textstatus.g.e.a locala = this.MCD.MCs;
      Object localObject;
      if (locala != null)
      {
        p.k(locala, "$this$convertToPb");
        localObject = new TextStatusExtInfo();
        ((TextStatusExtInfo)localObject).description = locala.field_Description;
        ((TextStatusExtInfo)localObject).mediaType = locala.field_MediaType;
        ((TextStatusExtInfo)localObject).mediaUrl = locala.field_MediaUrl;
        ((TextStatusExtInfo)localObject).mediaAesKey = locala.field_MediaAESKey;
        ((TextStatusExtInfo)localObject).mediaThumbUrl = locala.field_MediaThumbUrl;
        ((TextStatusExtInfo)localObject).mediaThumbAesKey = locala.field_MediaThumbAESKey;
        ((TextStatusExtInfo)localObject).poiId = locala.field_PoiID;
        ((TextStatusExtInfo)localObject).poiName = locala.field_PoiName;
        ((TextStatusExtInfo)localObject).latitude = locala.field_Latitude;
        ((TextStatusExtInfo)localObject).longitude = locala.field_Longitude;
        ((TextStatusExtInfo)localObject).visibility = locala.field_Visibility;
        ((TextStatusExtInfo)localObject).expireTime = locala.field_ExpireTime;
        ((TextStatusExtInfo)localObject).createTime = locala.field_CreateTime;
        ((TextStatusExtInfo)localObject).backgroundId = locala.field_backgroundId;
        Long localLong = locala.field_option;
        p.j(localLong, "field_option");
        ((TextStatusExtInfo)localObject).option = localLong.longValue();
        ((TextStatusExtInfo)localObject).mediaWidth = locala.field_mediaWidth;
        ((TextStatusExtInfo)localObject).mediaHeight = locala.field_mediaHeight;
        ((TextStatusExtInfo)localObject).referenceUsername = locala.field_referenceUserName;
        ((TextStatusExtInfo)localObject).referenceTextStatusId = locala.field_referenceTextStatusId;
        ((TextStatusExtInfo)localObject).topicInfo = locala.glY();
        localJSONObject.put("textStateModelInfo", com.tencent.mm.ae.g.bN(localObject).toString());
        if (this.MCE != null)
        {
          localObject = (CharSequence)this.MCE.btD();
          if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
            break label333;
          }
        }
      }
      label333:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          localJSONObject.put("clickTagName", this.MCE.btD());
        }
        localJSONObject.put("clickTagTime", cm.bfD());
        localObject = localJSONObject.toString();
        p.j(localObject, "jsonObj.toString()");
        AppMethodBeat.o(234351);
        return localObject;
        localObject = "";
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleDesc$topicClickListener$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-textstatus_release"})
  public static final class f
    extends j
  {
    public final void a(View paramView, u paramu)
    {
      AppMethodBeat.i(232178);
      c.a(this.MCD, paramu);
      AppMethodBeat.o(232178);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(c paramc, String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235336);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      if (p.h(com.tencent.mm.plugin.auth.a.a.crN(), paramString))
      {
        paramView = TextStatusLikeListActivity.MNs;
        paramView = this.MCD.getContext();
        localObject = parami.field_StatusID;
        p.k(paramView, "context");
        Intent localIntent = new Intent(paramView, TextStatusLikeListActivity.class);
        localIntent.putExtra("status_id", (String)localObject);
        localIntent.putExtra("scene", 0);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MCD.getContext(), 14L, null, parami, 4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235336);
        return;
      }
      if (Math.abs(System.currentTimeMillis() - this.MCD.MCu) < 500L)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235336);
        return;
      }
      paramView = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject = com.tencent.mm.plugin.textstatus.b.f.glz();
      paramView = parami;
      if (paramView != null)
      {
        paramView = paramView.field_StatusID;
        boolean bool = ((com.tencent.mm.plugin.textstatus.g.e.c)localObject).beu(paramView);
        localObject = this.MCD.glM().getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof Boolean)) {
          paramView = null;
        }
        paramView = (Boolean)paramView;
        Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", "isLikeOther:" + bool + " localIsLike:" + paramView);
        if (!p.h(paramView, Boolean.TRUE)) {
          break label477;
        }
        paramView = parami.field_TopicId;
        p.j(paramView, "info.field_TopicId");
        localObject = parami.field_StatusID;
        p.j(localObject, "info.field_StatusID");
        paramView = new com.tencent.mm.plugin.textstatus.g.l(paramView, (String)localObject, paramString, 1, 1);
        h.aGY().a(paramView.getType(), (com.tencent.mm.an.i)new g((com.tencent.mm.an.i)this.MCD));
        h.aGY().b((com.tencent.mm.an.q)paramView);
        c.a(this.MCD, false);
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MCD.getContext(), 12L, null, parami, 4);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$likeClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235336);
        return;
        paramView = null;
        break;
        label477:
        c.a(this.MCD, true);
        paramView = parami.field_TopicId;
        p.j(paramView, "info.field_TopicId");
        localObject = parami.field_StatusID;
        p.j(localObject, "info.field_StatusID");
        paramView = new com.tencent.mm.plugin.textstatus.g.l(paramView, (String)localObject, paramString, 0, 1);
        h.aGY().a(paramView.getType(), (com.tencent.mm.an.i)new g((com.tencent.mm.an.i)this.MCD));
        h.aGY().b((com.tencent.mm.an.q)paramView);
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(this.MCD.getContext(), 13L, "1", parami);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232376);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.textstatus.g.g.c.MEt;
      com.tencent.mm.plugin.textstatus.g.g.c.gmj();
      paramView = this.MCD.MCm;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232376);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.c
 * JD-Core Version:    0.7.0.1
 */