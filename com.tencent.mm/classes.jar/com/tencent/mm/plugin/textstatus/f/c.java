package com.tencent.mm.plugin.textstatus.f;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.h.m;
import com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.plugin.textstatus.proto.t;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.util.l;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.component.k.b;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnLike", "Landroid/widget/ImageView;", "getBtnLike", "()Landroid/widget/ImageView;", "setBtnLike", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "descExtraClickListener", "Lkotlin/Function0;", "", "getDescExtraClickListener", "()Lkotlin/jvm/functions/Function0;", "setDescExtraClickListener", "(Lkotlin/jvm/functions/Function0;)V", "emojiView", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getEmojiView", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "setEmojiView", "(Lcom/tencent/mm/emoji/view/EmojiStatusView;)V", "extraShowParam", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "getExtraShowParam", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;", "setExtraShowParam", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusCardShowExtraParam;)V", "flowLayout", "Lcom/tencent/mm/ui/base/FlowLayout;", "getFlowLayout", "()Lcom/tencent/mm/ui/base/FlowLayout;", "setFlowLayout", "(Lcom/tencent/mm/ui/base/FlowLayout;)V", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivBigIcon", "getIvBigIcon", "setIvBigIcon", "ivBrand", "getIvBrand", "setIvBrand", "ivNick", "getIvNick", "setIvNick", "ivSecurityClose", "Landroid/view/View;", "getIvSecurityClose", "()Landroid/view/View;", "setIvSecurityClose", "(Landroid/view/View;)V", "lastGetCustomElementsTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getLastGetCustomElementsTopicInfo", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "setLastGetCustomElementsTopicInfo", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)V", "lastGetCustomPartsTopicInfo", "getLastGetCustomPartsTopicInfo", "setLastGetCustomPartsTopicInfo", "lastPopupLikeDismissTime", "", "getLastPopupLikeDismissTime", "()J", "setLastPopupLikeDismissTime", "(J)V", "layoutAuthor", "Landroid/widget/LinearLayout;", "getLayoutAuthor", "()Landroid/widget/LinearLayout;", "setLayoutAuthor", "(Landroid/widget/LinearLayout;)V", "layoutAvatarSameFriends", "getLayoutAvatarSameFriends", "setLayoutAvatarSameFriends", "layoutBrand", "getLayoutBrand", "setLayoutBrand", "layoutBrandAndPoi", "getLayoutBrandAndPoi", "setLayoutBrandAndPoi", "layoutBrandSpecialLayout", "Landroid/widget/FrameLayout;", "getLayoutBrandSpecialLayout", "()Landroid/widget/FrameLayout;", "setLayoutBrandSpecialLayout", "(Landroid/widget/FrameLayout;)V", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutDesContent", "getLayoutDesContent", "setLayoutDesContent", "layoutFillWindow", "Landroid/view/ViewGroup;", "getLayoutFillWindow", "()Landroid/view/ViewGroup;", "setLayoutFillWindow", "(Landroid/view/ViewGroup;)V", "layoutLike", "getLayoutLike", "setLayoutLike", "layoutLuckyMoney", "getLayoutLuckyMoney", "setLayoutLuckyMoney", "layoutNick", "getLayoutNick", "setLayoutNick", "layoutSecurity", "getLayoutSecurity", "setLayoutSecurity", "mCustomElements", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;", "getMCustomElements", "()Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;", "setMCustomElements", "(Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;)V", "mCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "getMCustomParts", "()Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "setMCustomParts", "(Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "getShowParam", "()Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "statusCardEventListener", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "getStatusCardEventListener", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;", "setStatusCardEventListener", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$StatusCardEventListener;)V", "statusId", "", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvBrand", "Landroid/widget/TextView;", "getTvBrand", "()Landroid/widget/TextView;", "setTvBrand", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvLuckyMoney", "getTvLuckyMoney", "setTvLuckyMoney", "tvNick", "getTvNick", "setTvNick", "tvNickTime", "getTvNickTime", "setTvNickTime", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvSecurity", "getTvSecurity", "setTvSecurity", "tvStatus", "getTvStatus", "setTvStatus", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "vSplitBrandPoi", "getVSplitBrandPoi", "setVSplitBrandPoi", "vSplitBrandStatus", "getVSplitBrandStatus", "setVSplitBrandStatus", "brandClick", "checkCurCustomElementsValid", "", "topicInfo", "checkCurCustomPartsValid", "destroyCustomElementsManual", "destroyCustomPartsManual", "getCustomElements", "getCustomParts", "getIsLikeInRecord", "getSetStatusParams", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getStatusIconDefAlpha", "", "imgResId", "getTimeStr", "goProfile", "goReferenceEdit", "goTopicMiniApp", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "gotoChattingUI", "FinishDirect", "handleAccessibility", "handleBrand", "handleBrandAndPoiVisibility", "handleDesc", "textStatusDesc", "handleEmojiInfo", "handleIconTipsClick", "handleLike", "handleSameFriendsTip", "handleSecurity", "iconStatusClick", "init", "contentView", "isUseDefaultImgBackground", "loadBigIcon", "iv", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusPause", "resetLikeNumTag", "sendLuckyMoney", "setDescExtraSpaceClickCallback", "callback", "setThumb", "bitmap", "Landroid/graphics/Bitmap;", "update", "item", "extraParam", "updateBrandStatusSplitLine", "updateEmojiSize", "updateIsLikeInRecord", "isLike", "updateLikeNum", "updateOtherUserLocalState", "isCustomIcon", "isShowCustomBrand", "Companion", "DescSpan", "TextStatusMovementMethod", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public class c
  implements com.tencent.mm.am.h, e
{
  public static final c.a Tlu;
  private EmojiStatusView Rum;
  private ImageView TlA;
  private ImageView TlB;
  private View TlC;
  private TextView TlD;
  private LinearLayout TlE;
  private LinearLayout TlF;
  private LinearLayout TlG;
  private ImageView TlH;
  private TextView TlI;
  private ViewGroup TlJ;
  private View TlK;
  public ImageView TlL;
  private View TlM;
  ImageView TlN;
  private TextView TlO;
  public TextView TlP;
  private ImageView TlQ;
  private TextView TlR;
  private TextView TlS;
  private View TlT;
  private FrameLayout TlU;
  private TextView TlV;
  private View TlW;
  private View TlX;
  private View TlY;
  private View TlZ;
  private final x Tlv;
  private TextView Tlw;
  private TextView Tlx;
  private String Tly;
  private TextView Tlz;
  private View Tma;
  com.tencent.mm.plugin.textstatus.h.f.b Tmb;
  private t Tmc;
  private long Tmd;
  private ViewGroup Tme;
  private TextView Tmf;
  private FlowLayout Tmg;
  private com.tencent.mm.plugin.textstatus.a.e Tmh;
  private TextStatusTopicInfo Tmi;
  private com.tencent.mm.plugin.textstatus.a.d Tmj;
  private TextStatusTopicInfo Tmk;
  private kotlin.g.a.a<ah> Tml;
  e.a Tmm;
  public Context context;
  private String username;
  
  static
  {
    AppMethodBeat.i(289921);
    Tlu = new c.a((byte)0);
    AppMethodBeat.o(289921);
  }
  
  public c(x paramx)
  {
    AppMethodBeat.i(289780);
    this.Tlv = paramx;
    this.username = "";
    this.Tly = "";
    AppMethodBeat.o(289780);
  }
  
  private final void Fy(boolean paramBoolean)
  {
    AppMethodBeat.i(289824);
    hHk().setTag(Boolean.valueOf(paramBoolean));
    a(this.Tmb, paramBoolean);
    View localView = this.TlM;
    if (localView != null) {
      localView.setBackground(getContext().getResources().getDrawable(a.d.TbW));
    }
    if (paramBoolean)
    {
      hHk().setImageDrawable(bb.e(getContext().getResources().getDrawable(a.g.icon_filled_awesome), getContext().getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.Red_100)));
      com.tencent.mm.ui.anim.b.a.a((View)hHk(), (com.tencent.mm.ui.anim.b.b)com.tencent.mm.ui.anim.b.c.adMn, 2.0F, null);
      AppMethodBeat.o(289824);
      return;
    }
    hHk().setImageDrawable(bb.e(getContext().getResources().getDrawable(a.g.icon_filled_awesome), getContext().getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.White)));
    AppMethodBeat.o(289824);
  }
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(289872);
    kotlin.g.b.s.u(paramc, "this$0");
    View localView = paramc.TlK;
    if (localView != null)
    {
      Object localObject = paramc.TlF;
      if ((localObject == null) || (((LinearLayout)localObject).getVisibility() != 0)) {
        break label125;
      }
      i = 1;
      if (i == 0)
      {
        localObject = paramc.TlG;
        if ((localObject == null) || (((LinearLayout)localObject).getVisibility() != 0)) {
          break label130;
        }
        i = 1;
        label62:
        if (i == 0) {
          break label151;
        }
      }
      localObject = paramc.TlN;
      if ((localObject == null) || (((ImageView)localObject).getVisibility() != 0)) {
        break label135;
      }
      i = 1;
      label84:
      if (i == 0) {
        break label151;
      }
      paramc = paramc.Tmg;
      if (paramc != null) {
        break label140;
      }
      paramc = null;
      label99:
      kotlin.g.b.s.checkNotNull(paramc);
      if (paramc.intValue() > 1) {
        break label151;
      }
    }
    label130:
    label135:
    label140:
    label151:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(289872);
      return;
      label125:
      i = 0;
      break;
      i = 0;
      break label62;
      i = 0;
      break label84;
      paramc = Integer.valueOf(paramc.getRealLineCount());
      break label99;
    }
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(289827);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.hHc();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289827);
  }
  
  private final void a(com.tencent.mm.plugin.textstatus.h.f.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(289814);
    if (paramb == null)
    {
      AppMethodBeat.o(289814);
      return;
    }
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (com.tencent.mm.plugin.textstatus.ui.a.a)com.tencent.mm.ui.component.k.nq(getContext()).cp(com.tencent.mm.plugin.textstatus.ui.a.a.class);
    if (localObject != null)
    {
      localObject = (Map)((com.tencent.mm.plugin.textstatus.ui.a.a)localObject).TAF;
      paramb = paramb.field_StatusID;
      kotlin.g.b.s.s(paramb, "info.field_StatusID");
      ((Map)localObject).put(paramb, Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(289814);
  }
  
  private static final void a(String paramString, c paramc, com.tencent.mm.plugin.textstatus.h.f.b paramb, View paramView)
  {
    AppMethodBeat.i(289912);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramString);
    localb.cH(paramc);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramString, "$username");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramb, "$info");
    if (kotlin.g.b.s.p(com.tencent.mm.plugin.auth.a.a.cUx(), paramString))
    {
      paramString = TextStatusLikeListActivity.Tzn;
      paramString = paramc.getContext();
      paramView = paramb.field_StatusID;
      kotlin.g.b.s.u(paramString, "context");
      localObject = new Intent(paramString, TextStatusLikeListActivity.class);
      ((Intent)localObject).putExtra("status_id", paramView);
      ((Intent)localObject).putExtra("scene", 0);
      ((Intent)localObject).putExtra("reportEnterScene", 9);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, paramView.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSingleStatusHistory", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSingleStatusHistory", "(Landroid/content/Context;Ljava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(paramc.getContext(), 14L, paramc.hHn().getText().toString(), paramb, 0L, 0L, 0L, 112);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289912);
      return;
    }
    if (Math.abs(System.currentTimeMillis() - paramc.Tmd) < 500L)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289912);
      return;
    }
    paramView = paramc.hHk().getTag();
    if ((paramView instanceof Boolean))
    {
      paramView = (Boolean)paramView;
      Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", kotlin.g.b.s.X("localIsLike:", paramView));
      if (!kotlin.g.b.s.p(paramView, Boolean.TRUE)) {
        break label500;
      }
      paramView = paramb.field_TopicId;
      kotlin.g.b.s.s(paramView, "info.field_TopicId");
      localObject = paramb.field_StatusID;
      kotlin.g.b.s.s(localObject, "info.field_StatusID");
      paramString = new m(paramView, (String)localObject, paramString, 1, 1);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      paramc.Fy(false);
      paramString = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(paramc.getContext(), 12L, null, paramb, 0L, 0L, 0L, 116);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289912);
      return;
      paramView = null;
      break;
      label500:
      paramc.Fy(true);
      paramView = paramb.field_TopicId;
      kotlin.g.b.s.s(paramView, "info.field_TopicId");
      localObject = paramb.field_StatusID;
      kotlin.g.b.s.s(localObject, "info.field_StatusID");
      paramString = new m(paramView, (String)localObject, paramString, 0, 1);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramString, 0);
      paramString = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(paramc.getContext(), 13L, "1", paramb, 0L, 0L, 0L, 112);
    }
  }
  
  private final boolean a(com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(289808);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (com.tencent.mm.plugin.textstatus.ui.a.a)com.tencent.mm.ui.component.k.nq(getContext()).cp(com.tencent.mm.plugin.textstatus.ui.a.a.class);
    if ((localObject == null) || (!((com.tencent.mm.plugin.textstatus.ui.a.a)localObject).TAF.containsKey(paramb.field_StatusID)))
    {
      localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      bool = com.tencent.mm.plugin.textstatus.b.f.hGI().bdV(paramb.field_StatusID);
      AppMethodBeat.o(289808);
      return bool;
    }
    localObject = (Boolean)((com.tencent.mm.plugin.textstatus.ui.a.a)localObject).TAF.get(paramb.field_StatusID);
    paramb = (com.tencent.mm.plugin.textstatus.h.f.b)localObject;
    if (localObject == null) {
      paramb = Boolean.FALSE;
    }
    boolean bool = paramb.booleanValue();
    AppMethodBeat.o(289808);
    return bool;
  }
  
  private static final void b(c paramc, View paramView)
  {
    AppMethodBeat.i(289839);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramView = new Intent();
    paramView.putExtra("Contact_User", paramc.username);
    if (paramc.Tlv.scene == 2) {}
    for (int i = 52;; i = 51)
    {
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", i);
      com.tencent.mm.br.c.b(paramc.getContext(), "profile", ".ui.ContactInfoUI", paramView, 213);
      paramView = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(paramc.getContext(), 22L, null, paramc.Tmb, 0L, 0L, 0L, 116);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289839);
      return;
    }
  }
  
  protected static float bdR(String paramString)
  {
    AppMethodBeat.i(289794);
    kotlin.g.b.s.u(paramString, "imgResId");
    AppMethodBeat.o(289794);
    return 1.0F;
  }
  
  private static final void c(c paramc, View paramView)
  {
    AppMethodBeat.i(289847);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.hHb();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289847);
  }
  
  public static boolean c(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(289788);
    kotlin.g.b.s.u(paramTextStatusTopicInfo, "<this>");
    boolean bool = kotlin.g.b.s.p(paramTextStatusTopicInfo.iconId, "userdefine");
    AppMethodBeat.o(289788);
    return bool;
  }
  
  private static final void d(c paramc, View paramView)
  {
    AppMethodBeat.i(289853);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.hGZ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289853);
  }
  
  public static boolean d(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(289804);
    kotlin.g.b.s.u(paramTextStatusTopicInfo, "<this>");
    paramTextStatusTopicInfo = (CharSequence)paramTextStatusTopicInfo.sourceId;
    if ((paramTextStatusTopicInfo == null) || (kotlin.n.n.bp(paramTextStatusTopicInfo))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289804);
      return false;
    }
    AppMethodBeat.o(289804);
    return true;
  }
  
  private static final void e(c paramc, View paramView)
  {
    AppMethodBeat.i(289859);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.hHa();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289859);
  }
  
  private static final void f(c paramc, View paramView)
  {
    AppMethodBeat.i(289878);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.Tml;
    if (paramc != null) {
      paramc.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289878);
  }
  
  private static final void g(c paramc, View paramView)
  {
    AppMethodBeat.i(289884);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramView = com.tencent.mm.plugin.textstatus.h.h.c.Tob;
    com.tencent.mm.plugin.textstatus.h.h.c.hHT();
    paramc = paramc.TlW;
    if (paramc != null) {
      paramc.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289884);
  }
  
  private static final void h(c paramc, View paramView)
  {
    AppMethodBeat.i(289891);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc = paramc.TlW;
    if (paramc != null) {
      paramc.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(289891);
  }
  
  public final void Fx(boolean paramBoolean)
  {
    AppMethodBeat.i(290070);
    Intent localIntent = new Intent();
    Object localObject = this.Tmb;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_UserName)
    {
      localIntent.putExtra("Chat_User", (String)localObject);
      localIntent.putExtra("Chat_Mode", 1);
      localIntent.putExtra("finish_direct", paramBoolean);
      com.tencent.mm.br.c.b(getContext(), "luckymoney", "com.tencent.mm.ui.chatting.ChattingUI", localIntent);
      AppMethodBeat.o(290070);
      return;
    }
  }
  
  public final void a(e.a parama)
  {
    this.Tmm = parama;
  }
  
  public final boolean aRF(String paramString)
  {
    AppMethodBeat.i(290036);
    kotlin.g.b.s.u(paramString, "username");
    Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
    boolean bool = ((e)this).b(paramString, (com.tencent.mm.plugin.textstatus.h.f.b)localObject, new t());
    AppMethodBeat.o(290036);
    return bool;
  }
  
  public boolean b(String paramString, com.tencent.mm.plugin.textstatus.h.f.b paramb, t paramt)
  {
    AppMethodBeat.i(290063);
    kotlin.g.b.s.u(paramString, "username");
    this.username = paramString;
    this.Tmb = paramb;
    this.Tmc = paramt;
    Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", "[update status]info:%s %s", new Object[] { this.Tmb, Boolean.valueOf(ac.hFT()) });
    if (paramb == null)
    {
      AppMethodBeat.o(290063);
      return false;
    }
    if ((!TextUtils.isEmpty((CharSequence)this.Tlv.ThU)) && (!TextUtils.equals((CharSequence)this.Tlv.ThU, (CharSequence)paramb.field_TopicId)))
    {
      AppMethodBeat.o(290063);
      return false;
    }
    paramt = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramt = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    if (paramt != null) {
      paramt.Tpm = this.Tlv.ThV;
    }
    String str1 = com.tencent.mm.plugin.textstatus.util.b.hKh().f(com.tencent.mm.plugin.textstatus.h.f.b.b(paramb));
    paramt = paramb.field_StatusID;
    kotlin.g.b.s.s(paramt, "info.field_StatusID");
    this.Tly = paramt;
    String str3 = paramb.field_Description;
    String str2 = paramb.field_IconID;
    paramt = this.Tlx;
    if (paramt != null) {
      paramt.setMovementMethod(null);
    }
    paramt = this.Tlx;
    if (paramt != null) {
      paramt.setVisibility(0);
    }
    label324:
    label353:
    int j;
    label375:
    boolean bool;
    if (!TextUtils.isEmpty((CharSequence)str3))
    {
      paramt = getContext();
      Object localObject1 = (CharSequence)str3;
      Object localObject2 = this.Tlx;
      float f;
      int k;
      d locald;
      Matcher localMatcher;
      if (localObject2 == null)
      {
        f = 0.0F;
        localObject2 = new SpannableString(com.tencent.mm.ui.i.c.b.c(paramt, (CharSequence)localObject1, f));
        kotlin.g.b.s.p(this.username, com.tencent.mm.plugin.auth.a.a.cUx());
        k = Color.parseColor("#ADBACC");
        locald = new d(this);
        paramt = com.tencent.mm.plugin.textstatus.util.k.TBx;
        localMatcher = com.tencent.mm.plugin.textstatus.util.k.hKz().matcher((CharSequence)str3);
        i = 0;
      }
      label465:
      label469:
      label471:
      label480:
      for (;;)
      {
        if (!localMatcher.find()) {
          break label482;
        }
        int m = localMatcher.start();
        int n = localMatcher.end();
        if (str3 == null)
        {
          paramt = null;
          localObject1 = (CharSequence)paramt;
          if ((localObject1 != null) && (!kotlin.n.n.bp((CharSequence)localObject1))) {
            break label465;
          }
          j = 1;
          if (j != 0) {
            break label469;
          }
          localObject1 = hHs();
          if (localObject1 != null) {
            break label471;
          }
        }
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.textstatus.a.d)localObject1).bdo(paramt))
        {
          if (localObject1 == null) {
            break label480;
          }
          i = 1;
          ((SpannableString)localObject2).setSpan(new c.b(paramt, k, k, (com.tencent.mm.pluginsdk.ui.span.n)locald), m, n, 33);
          break label324;
          f = ((TextView)localObject2).getTextSize();
          break;
          paramt = str3.substring(m + 1, n);
          kotlin.g.b.s.s(paramt, "(this as java.lang.Strin…ing(startIndex, endIndex)");
          break label353;
          j = 0;
          break label375;
          break label324;
        }
      }
      label482:
      if (i != 0)
      {
        paramt = this.Tlx;
        if (paramt != null) {
          paramt.setMovementMethod((MovementMethod)new c.c(this.Tml));
        }
      }
      paramt = this.Tlx;
      if (paramt != null) {
        paramt.setOnClickListener(new c..ExternalSyntheticLambda6(this));
      }
      paramt = this.Tlx;
      if (paramt != null) {
        paramt.setText((CharSequence)localObject2);
      }
      paramt = this.Tlx;
      if (paramt != null) {
        paramt.setTextSize(0, getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.textstatus.a.c.TbG));
      }
      paramt = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb);
      if (((!this.Tlv.aom(8)) && (!c(paramt))) || (str2 == null)) {
        break label1992;
      }
      paramt = this.TlN;
      if (paramt != null) {
        paramt.setAlpha(bdR(str2));
      }
      paramt = this.TlN;
      if (paramt != null) {
        paramt.setAlpha(1.0F);
      }
      paramt = this.TlN;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      com.tencent.mm.plugin.textstatus.util.b.hKh().a(this.TlN, str2, com.tencent.mm.plugin.textstatus.a.a.c.ThP, com.tencent.mm.plugin.textstatus.a.a.a.Ths, paramb);
      paramt = this.TlO;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      paramt = this.TlO;
      if (paramt != null) {
        paramt.setText((CharSequence)com.tencent.mm.plugin.textstatus.util.b.hKh().f(com.tencent.mm.plugin.textstatus.h.f.b.b(paramb)));
      }
      paramt = this.TlN;
      if (paramt != null) {
        paramt.setOnClickListener(new c..ExternalSyntheticLambda1(this));
      }
      label736:
      Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", "update: iconId:" + com.tencent.mm.plugin.textstatus.h.f.b.b(paramb).iconId + " username:" + paramb.field_UserName);
      if ((com.tencent.mm.plugin.auth.a.a.cUx().equals(paramb.field_UserName)) || (!ac.hGm()) || (!kotlin.g.b.s.p("2022_hb", com.tencent.mm.plugin.textstatus.h.f.b.b(paramb).iconId))) {
        break label2010;
      }
      paramt = this.Tme;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      paramt = this.Tme;
      if (paramt != null) {
        paramt.setOnClickListener(new c..ExternalSyntheticLambda5(this));
      }
      label848:
      paramt = this.Tlw;
      if (paramt != null) {
        paramt.setText((CharSequence)str1);
      }
      paramt = this.Tmb;
      if (paramt != null)
      {
        hHv();
        paramt = new c..ExternalSyntheticLambda8(paramString, this, paramt);
        localObject1 = this.TlM;
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener(paramt);
        }
        localObject1 = hHk();
        if (localObject1 != null) {
          ((ImageView)localObject1).setOnClickListener(paramt);
        }
        localObject1 = hHn();
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener(paramt);
        }
      }
      if (this.Tlv.ThW)
      {
        paramt = this.TlA;
        if (paramt != null)
        {
          if (!this.Tlv.ThT) {
            break label2028;
          }
          localObject1 = com.tencent.mm.plugin.textstatus.g.a.Tmr;
          com.tencent.mm.plugin.textstatus.g.a.a(getContext(), paramt, paramString, paramb);
        }
        label985:
        paramt = this.TlB;
        if (paramt != null)
        {
          kotlin.g.b.s.u(paramt, "iv");
          kotlin.g.b.s.u(paramb, "info");
          kotlin.g.b.s.u(paramb, "info");
          localObject1 = paramb.field_UserName;
          kotlin.g.b.s.s(localObject1, "info.field_UserName");
          if (com.tencent.mm.plugin.textstatus.ui.b.a((String)localObject1, (com.tencent.mm.plugin.textstatus.a.k)hHr(), paramb)) {
            break label2044;
          }
          i = 1;
          label1048:
          if (i == 0) {
            break label2050;
          }
          paramt.setVisibility(0);
          com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh(), paramt, paramb.field_IconID);
        }
      }
      label1069:
      paramt = (CharSequence)paramb.field_PoiName;
      if ((paramt != null) && (!kotlin.n.n.bp(paramt))) {
        break label2059;
      }
      i = 1;
      label1091:
      if (i == 0) {
        break label2065;
      }
      paramt = this.TlD;
      if (paramt != null) {
        paramt.setVisibility(8);
      }
      label1111:
      paramt = this.TlE;
      if (paramt != null) {
        paramt.removeAllViews();
      }
      if (!this.Tlv.aom(1)) {
        break label2102;
      }
      paramt = this.TlQ;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      com.tencent.mm.pluginsdk.ui.a.b.g(this.TlQ, paramString);
      label1157:
      if (!this.Tlv.aom(2)) {
        break label2120;
      }
      paramt = this.TlR;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      paramString = aa.getDisplayName(paramString);
      paramt = this.TlR;
      if (paramt != null) {
        paramt.setText((CharSequence)paramString);
      }
      label1204:
      if (!this.Tlv.aom(1024)) {
        break label2190;
      }
      paramString = this.TlS;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramt = this.TlS;
      if (paramt != null)
      {
        j = cn.getSyncServerTimeSecond() - paramb.field_CreateTime;
        i = j;
        if (j < 0) {
          i = 0;
        }
        j = i / 60;
        i = j;
        if (j <= 0) {
          i = 1;
        }
        if (i >= 60) {
          break label2138;
        }
        paramString = getContext().getString(a.h.Thd, new Object[] { Integer.valueOf(i) });
        kotlin.g.b.s.s(paramString, "context.getString(R.stri…iutes, durationInMinutes)");
        label1318:
        paramt.setText((CharSequence)paramString);
      }
      label1326:
      kotlin.g.b.s.u(paramb, "info");
      paramString = com.tencent.mm.plugin.textstatus.h.f.b.b(paramb);
      if (!d(paramString)) {
        break label2325;
      }
      paramb = new StringBuilder("[handleBrand] ");
      paramt = (CharSequence)paramString.sourceIcon;
      if ((paramt != null) && (!kotlin.n.n.bp(paramt))) {
        break label2208;
      }
      bool = true;
      label1378:
      Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", bool + ',' + paramString.sourceName);
      paramb = this.TlF;
      if (paramb != null) {
        paramb.setVisibility(0);
      }
      paramb = this.TlI;
      if (paramb != null) {
        paramb.setText((CharSequence)paramString.sourceName);
      }
      paramb = hHr();
      paramt = this.TlU;
      if (paramt != null) {
        paramt.removeAllViews();
      }
      if ((paramb == null) || (paramb.e(this.TlU) != true)) {
        break label2214;
      }
      i = 1;
      label1476:
      if (i == 0) {
        break label2220;
      }
      paramString = this.TlU;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.TlH;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      label1510:
      paramString = this.TlF;
      if ((paramString == null) || (paramString.getVisibility() != 0)) {
        break label2343;
      }
      i = 1;
      label1529:
      if (i == 0) {
        break label2355;
      }
      paramString = this.TlD;
      if ((paramString == null) || (paramString.getVisibility() != 0)) {
        break label2349;
      }
      i = 1;
      label1553:
      if (i == 0) {
        break label2355;
      }
      paramString = this.TlY;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      label1572:
      paramString = this.TlF;
      if ((paramString == null) || (paramString.getVisibility() != 0)) {
        break label2373;
      }
      i = 1;
      label1591:
      if (i == 0)
      {
        paramString = this.TlD;
        if ((paramString == null) || (paramString.getVisibility() != 0)) {
          break label2379;
        }
        i = 1;
        label1615:
        if (i == 0) {
          break label2385;
        }
      }
      paramString = this.TlZ;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      label1634:
      paramString = this.Tmb;
      if (paramString != null) {}
      switch (paramString.field_state)
      {
      default: 
        paramString = this.TlW;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        label1683:
        paramString = this.Tlz;
        if (paramString != null) {
          paramString.setText((CharSequence)"");
        }
        paramString = this.Tlz;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Tlz;
        if (paramString != null) {
          paramString.setOnClickListener(new c..ExternalSyntheticLambda4(this));
        }
        paramString = this.Rum;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Tmb;
        if (paramString != null)
        {
          paramt = paramString.hHD();
          if (paramt != null)
          {
            paramString = (CharSequence)paramt.Md5;
            if ((paramString != null) && (!kotlin.n.n.bp(paramString))) {
              break label2582;
            }
            i = 1;
            label1793:
            if (i == 0)
            {
              paramb = bl.jba().adju.bza(paramt.Md5);
              paramString = paramb;
              if (paramb == null) {
                paramString = com.tencent.mm.plugin.textstatus.d.a.a.a(paramt);
              }
              paramb = this.Rum;
              if (paramb != null) {
                paramb.setEmojiInfo(paramString);
              }
              paramString = this.Rum;
              if (paramString != null) {
                paramString.setVisibility(0);
              }
              paramString = this.Tlx;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
            }
          }
        }
        hHq();
        paramb = com.tencent.mm.plugin.textstatus.util.b.hKh();
        paramString = this.Tmb;
        if (paramString == null)
        {
          paramString = null;
          label1885:
          paramString = paramb.f(paramString);
          if (paramString != null) {
            if (!kotlin.n.n.bp((CharSequence)paramString)) {
              break label2596;
            }
          }
        }
        break;
      }
    }
    label2050:
    label2059:
    label2065:
    label2208:
    label2596:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramb = this.TlN;
        if (paramb != null) {
          paramb.setContentDescription((CharSequence)getContext().getString(a.h.TgG, new Object[] { paramString }));
        }
      }
      AppMethodBeat.o(290063);
      return true;
      paramt = this.Tlx;
      if (paramt != null) {
        paramt.setText((CharSequence)"");
      }
      paramt = this.Tlx;
      if (paramt == null) {
        break;
      }
      paramt.setTextSize(0, 0.0F);
      break;
      label1992:
      paramt = this.TlN;
      if (paramt == null) {
        break label736;
      }
      paramt.setVisibility(8);
      break label736;
      label2010:
      paramt = this.Tme;
      if (paramt == null) {
        break label848;
      }
      paramt.setVisibility(8);
      break label848;
      label2028:
      com.tencent.mm.plugin.textstatus.g.a.Tmr.a(getContext(), paramString, paramt, false);
      break label985;
      label2044:
      i = 0;
      break label1048;
      paramt.setVisibility(8);
      break label1069;
      i = 0;
      break label1091;
      paramt = this.TlD;
      if (paramt != null) {
        paramt.setVisibility(0);
      }
      paramt = this.TlD;
      if (paramt == null) {
        break label1111;
      }
      paramt.setText((CharSequence)paramb.field_PoiName);
      break label1111;
      label2102:
      paramt = this.TlQ;
      if (paramt == null) {
        break label1157;
      }
      paramt.setVisibility(8);
      break label1157;
      label2120:
      paramString = this.TlR;
      if (paramString == null) {
        break label1204;
      }
      paramString.setVisibility(8);
      break label1204;
      label2138:
      j = i / 60;
      i = j;
      if (j <= 0) {
        i = 1;
      }
      paramString = getContext().getString(a.h.Thc, new Object[] { Integer.valueOf(i) });
      kotlin.g.b.s.s(paramString, "context.getString(R.stri…ps_hours, durationInHour)");
      break label1318;
      paramString = this.TlS;
      if (paramString == null) {
        break label1326;
      }
      paramString.setVisibility(8);
      break label1326;
      bool = false;
      break label1378;
      label2214:
      i = 0;
      break label1476;
      label2220:
      paramb = this.TlU;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      paramb = (CharSequence)paramString.sourceIcon;
      if ((paramb == null) || (kotlin.n.n.bp(paramb))) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label2307;
        }
        paramb = this.TlH;
        if (paramb == null) {
          break;
        }
        paramb.setVisibility(0);
        r.bKe().loadImage(paramString.sourceIcon, paramb);
        paramString = l.TBz;
        l.km((View)paramb);
        break;
      }
      paramString = this.TlH;
      if (paramString == null) {
        break label1510;
      }
      paramString.setVisibility(8);
      break label1510;
      paramString = this.TlF;
      if (paramString == null) {
        break label1510;
      }
      paramString.setVisibility(8);
      break label1510;
      label2343:
      i = 0;
      break label1529;
      label2349:
      i = 0;
      break label1553;
      label2355:
      paramString = this.TlY;
      if (paramString == null) {
        break label1572;
      }
      paramString.setVisibility(8);
      break label1572;
      label2373:
      i = 0;
      break label1591;
      label2379:
      i = 0;
      break label1615;
      label2385:
      paramString = this.TlZ;
      if (paramString == null) {
        break label1634;
      }
      paramString.setVisibility(8);
      break label1634;
      paramString = this.TlW;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = getContext().getResources().getString(a.h.The);
      kotlin.g.b.s.s(paramString, "context.resources.getStr….text_status_tips_resend)");
      paramb = this.TlV;
      if (paramb != null) {
        paramb.setText((CharSequence)paramString);
      }
      paramString = this.TlX;
      if (paramString != null) {
        paramString.setVisibility(8);
      }
      paramString = this.TlW;
      if (paramString == null) {
        break label1683;
      }
      paramString.setOnClickListener(new c..ExternalSyntheticLambda7(this));
      break label1683;
      paramString = this.TlW;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = this.TlX;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      paramString = com.tencent.mm.plugin.textstatus.h.h.c.Tob;
      paramString = null;
      paramb = com.tencent.mm.plugin.textstatus.h.h.c.hHU();
      if (paramb != null) {
        paramString = paramb.errMsg;
      }
      paramb = this.TlV;
      if (paramb != null) {
        paramb.setText((CharSequence)paramString);
      }
      paramString = this.TlW;
      if (paramString == null) {
        break label1683;
      }
      paramString.setOnClickListener(new c..ExternalSyntheticLambda2(this));
      break label1683;
      i = 0;
      break label1793;
      paramString = com.tencent.mm.plugin.textstatus.h.f.b.b(paramString);
      break label1885;
    }
  }
  
  public final void bO(kotlin.g.a.a<ah> parama)
  {
    this.Tml = parama;
  }
  
  public void g(View paramView)
  {
    AppMethodBeat.i(290026);
    kotlin.g.b.s.u(paramView, "contentView");
    Object localObject = paramView.getContext();
    kotlin.g.b.s.s(localObject, "contentView.context");
    kotlin.g.b.s.u(localObject, "<set-?>");
    this.context = ((Context)localObject);
    this.Tlw = ((TextView)paramView.findViewById(a.e.TeC));
    this.Tlz = ((TextView)paramView.findViewById(a.e.Tey));
    this.Tlx = ((TextView)paramView.findViewById(a.e.gaN));
    this.TlD = ((TextView)paramView.findViewById(a.e.Tew));
    localObject = paramView.findViewById(a.e.Tcb);
    kotlin.g.b.s.s(localObject, "contentView.findViewById(R.id.btn_like)");
    localObject = (ImageView)localObject;
    kotlin.g.b.s.u(localObject, "<set-?>");
    this.TlL = ((ImageView)localObject);
    this.TlM = paramView.findViewById(a.e.Tdj);
    this.TlN = ((ImageView)paramView.findViewById(a.e.Tcu));
    this.TlO = ((TextView)paramView.findViewById(a.e.TeB));
    localObject = paramView.findViewById(a.e.Tep);
    kotlin.g.b.s.s(localObject, "contentView.findViewById(R.id.tv_like_num)");
    localObject = (TextView)localObject;
    kotlin.g.b.s.u(localObject, "<set-?>");
    this.TlP = ((TextView)localObject);
    this.TlA = ((ImageView)paramView.findViewById(a.e.TeJ));
    this.TlB = ((ImageView)paramView.findViewById(a.e.TcA));
    this.TlC = paramView.findViewById(a.e.Tdb);
    this.TlF = ((LinearLayout)paramView.findViewById(a.e.TcZ));
    this.TlG = ((LinearLayout)paramView.findViewById(a.e.TcU));
    this.TlH = ((ImageView)paramView.findViewById(a.e.TcE));
    this.TlI = ((TextView)paramView.findViewById(a.e.Teh));
    this.TlQ = ((ImageView)paramView.findViewById(a.e.TcI));
    this.TlR = ((TextView)paramView.findViewById(a.e.Teu));
    this.TlT = paramView.findViewById(a.e.Tdl);
    this.TlS = ((TextView)paramView.findViewById(a.e.Tev));
    this.TlU = ((FrameLayout)paramView.findViewById(a.e.Tda));
    this.TlW = paramView.findViewById(a.e.Tdq);
    this.TlX = paramView.findViewById(a.e.TcM);
    this.TlV = ((TextView)paramView.findViewById(a.e.Tez));
    this.Tma = paramView.findViewById(a.e.Tdd);
    this.Rum = ((EmojiStatusView)paramView.findViewById(a.e.Tcl));
    this.TlJ = ((ViewGroup)paramView.findViewById(a.e.Tdh));
    this.TlK = paramView.findViewById(a.e.TeV);
    this.Tmg = ((FlowLayout)paramView.findViewById(a.e.fIn));
    localObject = this.TlF;
    if (localObject != null) {
      ((LinearLayout)localObject).setOnClickListener(new c..ExternalSyntheticLambda0(this));
    }
    localObject = this.TlT;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new c..ExternalSyntheticLambda3(this));
    }
    this.Tme = ((ViewGroup)paramView.findViewById(a.e.Tdk));
    this.Tmf = ((TextView)paramView.findViewById(a.e.Teq));
    paramView = this.Tmf;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.getPaint())
    {
      aw.d((Paint)paramView);
      AppMethodBeat.o(290026);
      return;
    }
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(289982);
    Context localContext = this.context;
    if (localContext != null)
    {
      AppMethodBeat.o(289982);
      return localContext;
    }
    kotlin.g.b.s.bIx("context");
    AppMethodBeat.o(289982);
    return null;
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public void hGZ()
  {
    AppMethodBeat.i(290069);
    if (this.Tlv.scene == 8) {
      Fx(true);
    }
    ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hideCardDialog();
    Intent localIntent = new Intent();
    Object localObject = this.Tmb;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_UserName)
    {
      localIntent.putExtra("key_username", (String)localObject);
      localIntent.putExtra("key_way", 8);
      localIntent.putExtra("pay_channel", 11);
      com.tencent.mm.br.c.b(getContext(), "wallet_payu", ".remittance.ui.PayURemittanceAdapterUI", localIntent);
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 45L, null, null, 0L, 0L, 0L, 124);
      AppMethodBeat.o(290069);
      return;
    }
  }
  
  public void hHa()
  {
    AppMethodBeat.i(290075);
    hHb();
    AppMethodBeat.o(290075);
  }
  
  public boolean hHb()
  {
    AppMethodBeat.i(290085);
    Object localObject = this.Tmb;
    if (localObject == null) {}
    for (localObject = null; kotlin.g.b.s.p(localObject, "2021"); localObject = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_IconID)
    {
      ((com.tencent.mm.plugin.festival.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.festival.a.a.class)).gn(getContext());
      localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 28L, null, this.Tmb, 0L, 0L, 0L, 116);
      AppMethodBeat.o(290085);
      return true;
    }
    AppMethodBeat.o(290085);
    return false;
  }
  
  public void hHc()
  {
    AppMethodBeat.i(290030);
    Object localObject1 = this.Tmb;
    if (localObject1 != null)
    {
      Object localObject2 = this.Tmm;
      if (localObject2 != null) {
        ((e.a)localObject2).gpi();
      }
      com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      localObject2 = this.username;
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("userName", (String)localObject2);
      localObject2 = com.tencent.mm.plugin.textstatus.e.a.Tlb;
      com.tencent.mm.plugin.textstatus.e.a.a(getContext(), (com.tencent.mm.plugin.textstatus.a.k)hHr(), (Bundle)localObject1);
      localObject1 = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(getContext(), 23L, null, this.Tmb, 0L, 0L, 0L, 116);
    }
    AppMethodBeat.o(290030);
  }
  
  public final x hHe()
  {
    return this.Tlv;
  }
  
  public final TextView hHf()
  {
    return this.Tlx;
  }
  
  public final TextView hHg()
  {
    return this.Tlz;
  }
  
  public final TextView hHh()
  {
    return this.TlD;
  }
  
  public final LinearLayout hHi()
  {
    return this.TlF;
  }
  
  public final LinearLayout hHj()
  {
    return this.TlG;
  }
  
  public final ImageView hHk()
  {
    AppMethodBeat.i(290005);
    ImageView localImageView = this.TlL;
    if (localImageView != null)
    {
      AppMethodBeat.o(290005);
      return localImageView;
    }
    kotlin.g.b.s.bIx("btnLike");
    AppMethodBeat.o(290005);
    return null;
  }
  
  public final View hHl()
  {
    return this.TlM;
  }
  
  public final TextView hHm()
  {
    return this.TlO;
  }
  
  public final TextView hHn()
  {
    AppMethodBeat.i(290014);
    TextView localTextView = this.TlP;
    if (localTextView != null)
    {
      AppMethodBeat.o(290014);
      return localTextView;
    }
    kotlin.g.b.s.bIx("tvLikeNum");
    AppMethodBeat.o(290014);
    return null;
  }
  
  public final View hHo()
  {
    return this.Tma;
  }
  
  public final ViewGroup hHp()
  {
    return this.Tme;
  }
  
  public final void hHq()
  {
    AppMethodBeat.i(290078);
    View localView = this.TlK;
    if (localView != null) {
      localView.post(new c..ExternalSyntheticLambda9(this));
    }
    AppMethodBeat.o(290078);
  }
  
  /* Error */
  public final com.tencent.mm.plugin.textstatus.a.e hHr()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1677
    //   6: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 462	com/tencent/mm/plugin/textstatus/f/c:Tmb	Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +150 -> 165
    //   18: aconst_null
    //   19: astore_2
    //   20: aload_0
    //   21: getfield 1679	com/tencent/mm/plugin/textstatus/f/c:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   24: ifnonnull +149 -> 173
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: ifne +122 -> 152
    //   33: aload_0
    //   34: invokevirtual 1682	com/tencent/mm/plugin/textstatus/f/c:hHu	()V
    //   37: getstatic 1688	com/tencent/mm/plugin/textstatus/third/i:TuX	Lcom/tencent/mm/plugin/textstatus/third/i;
    //   40: astore_3
    //   41: invokestatic 1691	com/tencent/mm/plugin/textstatus/third/i:hIb	()Lcom/tencent/mm/plugin/textstatus/a/e;
    //   44: astore_3
    //   45: aload_0
    //   46: aload_3
    //   47: putfield 1679	com/tencent/mm/plugin/textstatus/f/c:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   50: aload_0
    //   51: getfield 1679	com/tencent/mm/plugin/textstatus/f/c:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +48 -> 106
    //   61: aload_0
    //   62: getfield 462	com/tencent/mm/plugin/textstatus/f/c:Tmb	Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnonnull +165 -> 232
    //   70: aconst_null
    //   71: astore_3
    //   72: aload_2
    //   73: ifnonnull +167 -> 240
    //   76: aconst_null
    //   77: astore 4
    //   79: aload 4
    //   81: checkcast 1693	java/util/List
    //   84: astore 7
    //   86: aload_2
    //   87: ifnonnull +162 -> 249
    //   90: aconst_null
    //   91: astore 4
    //   93: aload 6
    //   95: aload_3
    //   96: aload 7
    //   98: aload 4
    //   100: checkcast 1693	java/util/List
    //   103: invokevirtual 1696	com/tencent/mm/plugin/textstatus/a/e:d	(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V
    //   106: aload_0
    //   107: aload_2
    //   108: putfield 1698	com/tencent/mm/plugin/textstatus/f/c:Tmi	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   111: getstatic 984	com/tencent/mm/plugin/secdata/ui/a:PlI	Lcom/tencent/mm/plugin/secdata/ui/a$a;
    //   114: astore_2
    //   115: aload_0
    //   116: invokevirtual 469	com/tencent/mm/plugin/textstatus/f/c:getContext	()Landroid/content/Context;
    //   119: bipush 9
    //   121: ldc_w 986
    //   124: invokestatic 991	com/tencent/mm/plugin/secdata/ui/a$a:a	(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/bx/a;
    //   127: checkcast 986	com/tencent/mm/plugin/textstatus/proto/p
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +20 -> 152
    //   135: aload_0
    //   136: getfield 1679	com/tencent/mm/plugin/textstatus/f/c:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnonnull +117 -> 258
    //   144: aload 5
    //   146: astore_2
    //   147: aload_3
    //   148: aload_2
    //   149: putfield 1701	com/tencent/mm/plugin/textstatus/proto/p:oOW	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 1679	com/tencent/mm/plugin/textstatus/f/c:Tmh	Lcom/tencent/mm/plugin/textstatus/a/e;
    //   156: astore_2
    //   157: ldc_w 1677
    //   160: invokestatic 369	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: areturn
    //   165: aload_2
    //   166: invokestatic 1006	com/tencent/mm/plugin/textstatus/h/f/b:b	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   169: astore_2
    //   170: goto -150 -> 20
    //   173: aload_0
    //   174: getfield 1698	com/tencent/mm/plugin/textstatus/f/c:Tmi	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   177: astore_3
    //   178: aload_3
    //   179: ifnull +23 -> 202
    //   182: aload_3
    //   183: aload_2
    //   184: invokestatic 1704	com/tencent/mm/plugin/textstatus/ui/b:a	(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;)Z
    //   187: iconst_1
    //   188: if_icmpne +14 -> 202
    //   191: iconst_1
    //   192: istore_1
    //   193: iload_1
    //   194: ifne +13 -> 207
    //   197: iconst_0
    //   198: istore_1
    //   199: goto -170 -> 29
    //   202: iconst_0
    //   203: istore_1
    //   204: goto -11 -> 193
    //   207: iconst_1
    //   208: istore_1
    //   209: goto -180 -> 29
    //   212: astore_3
    //   213: ldc_w 754
    //   216: aload_3
    //   217: ldc_w 1706
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 1710	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -184 -> 45
    //   232: aload_3
    //   233: getfield 629	com/tencent/mm/plugin/textstatus/h/f/b:field_StatusID	Ljava/lang/String;
    //   236: astore_3
    //   237: goto -165 -> 72
    //   240: aload_2
    //   241: getfield 1714	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceJumpInfos	Ljava/util/LinkedList;
    //   244: astore 4
    //   246: goto -167 -> 79
    //   249: aload_2
    //   250: getfield 1717	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpInfos	Ljava/util/LinkedList;
    //   253: astore 4
    //   255: goto -162 -> 93
    //   258: aload_2
    //   259: invokevirtual 1720	com/tencent/mm/plugin/textstatus/a/e:etP	()Ljava/lang/String;
    //   262: astore_2
    //   263: goto -116 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	c
    //   28	181	1	i	int
    //   13	250	2	localObject1	Object
    //   40	143	3	localObject2	Object
    //   212	5	3	localThrowable	java.lang.Throwable
    //   228	9	3	str	String
    //   77	177	4	localLinkedList	java.util.LinkedList
    //   1	144	5	localObject3	Object
    //   54	40	6	locale	com.tencent.mm.plugin.textstatus.a.e
    //   84	13	7	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   37	45	212	finally
  }
  
  /* Error */
  public final com.tencent.mm.plugin.textstatus.a.d hHs()
  {
    // Byte code:
    //   0: ldc_w 1721
    //   3: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 462	com/tencent/mm/plugin/textstatus/f/c:Tmb	Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +100 -> 112
    //   15: aconst_null
    //   16: astore_3
    //   17: aload_0
    //   18: getfield 1723	com/tencent/mm/plugin/textstatus/f/c:Tmj	Lcom/tencent/mm/plugin/textstatus/a/d;
    //   21: ifnonnull +99 -> 120
    //   24: iconst_0
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +72 -> 99
    //   30: aload_0
    //   31: invokevirtual 1726	com/tencent/mm/plugin/textstatus/f/c:hHt	()V
    //   34: getstatic 1688	com/tencent/mm/plugin/textstatus/third/i:TuX	Lcom/tencent/mm/plugin/textstatus/third/i;
    //   37: astore 4
    //   39: invokestatic 1729	com/tencent/mm/plugin/textstatus/third/i:hIc	()Lcom/tencent/mm/plugin/textstatus/a/d;
    //   42: astore 4
    //   44: aload_0
    //   45: aload 4
    //   47: putfield 1723	com/tencent/mm/plugin/textstatus/f/c:Tmj	Lcom/tencent/mm/plugin/textstatus/a/d;
    //   50: aload_0
    //   51: getfield 1723	com/tencent/mm/plugin/textstatus/f/c:Tmj	Lcom/tencent/mm/plugin/textstatus/a/d;
    //   54: astore 6
    //   56: aload 6
    //   58: ifnull +36 -> 94
    //   61: aload_0
    //   62: getfield 462	com/tencent/mm/plugin/textstatus/f/c:Tmb	Lcom/tencent/mm/plugin/textstatus/h/f/b;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnonnull +394 -> 463
    //   72: aconst_null
    //   73: astore 4
    //   75: aload_3
    //   76: ifnonnull +397 -> 473
    //   79: aconst_null
    //   80: astore 5
    //   82: aload 6
    //   84: aload 4
    //   86: aload 5
    //   88: checkcast 1693	java/util/List
    //   91: invokevirtual 1733	com/tencent/mm/plugin/textstatus/a/d:y	(Ljava/lang/String;Ljava/util/List;)V
    //   94: aload_0
    //   95: aload_3
    //   96: putfield 1735	com/tencent/mm/plugin/textstatus/f/c:Tmk	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   99: aload_0
    //   100: getfield 1723	com/tencent/mm/plugin/textstatus/f/c:Tmj	Lcom/tencent/mm/plugin/textstatus/a/d;
    //   103: astore_3
    //   104: ldc_w 1721
    //   107: invokestatic 369	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_3
    //   111: areturn
    //   112: aload_3
    //   113: invokestatic 1006	com/tencent/mm/plugin/textstatus/h/f/b:b	(Lcom/tencent/mm/plugin/textstatus/h/f/b;)Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   116: astore_3
    //   117: goto -100 -> 17
    //   120: aload_0
    //   121: getfield 1735	com/tencent/mm/plugin/textstatus/f/c:Tmk	Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;
    //   124: astore 4
    //   126: aload 4
    //   128: ifnull +302 -> 430
    //   131: aload 4
    //   133: ldc_w 868
    //   136: invokestatic 432	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   139: aload_3
    //   140: ifnull +285 -> 425
    //   143: aload 4
    //   145: getfield 883	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   148: aload_3
    //   149: getfield 883	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:sourceId	Ljava/lang/String;
    //   152: invokestatic 652	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   155: ifeq +270 -> 425
    //   158: aload_3
    //   159: getfield 1738	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpElements	Ljava/util/LinkedList;
    //   162: astore 5
    //   164: aload 5
    //   166: ifnull +259 -> 425
    //   169: aload 5
    //   171: checkcast 1693	java/util/List
    //   174: astore 5
    //   176: aload 4
    //   178: getfield 1738	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpElements	Ljava/util/LinkedList;
    //   181: checkcast 1693	java/util/List
    //   184: astore 4
    //   186: aload 5
    //   188: ldc_w 868
    //   191: invokestatic 432	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   194: aload 4
    //   196: ifnonnull +28 -> 224
    //   199: iconst_0
    //   200: istore_1
    //   201: iload_1
    //   202: iconst_1
    //   203: if_icmpne +222 -> 425
    //   206: iconst_1
    //   207: istore_1
    //   208: iload_1
    //   209: iconst_1
    //   210: if_icmpne +220 -> 430
    //   213: iconst_1
    //   214: istore_1
    //   215: iload_1
    //   216: ifne +219 -> 435
    //   219: iconst_0
    //   220: istore_1
    //   221: goto -195 -> 26
    //   224: aload 5
    //   226: invokeinterface 1741 1 0
    //   231: aload 4
    //   233: invokeinterface 1741 1 0
    //   238: if_icmpeq +8 -> 246
    //   241: iconst_0
    //   242: istore_1
    //   243: goto -42 -> 201
    //   246: aload 5
    //   248: checkcast 1743	java/lang/Iterable
    //   251: invokeinterface 1747 1 0
    //   256: astore 5
    //   258: iconst_0
    //   259: istore_2
    //   260: aload 5
    //   262: invokeinterface 1752 1 0
    //   267: ifeq +153 -> 420
    //   270: aload 5
    //   272: invokeinterface 1755 1 0
    //   277: astore 6
    //   279: iload_2
    //   280: ifge +6 -> 286
    //   283: invokestatic 1760	kotlin/a/p:kkW	()V
    //   286: aload 6
    //   288: checkcast 1762	com/tencent/mm/plugin/textstatus/proto/au
    //   291: astore 7
    //   293: aload 4
    //   295: iload_2
    //   296: invokeinterface 1764 2 0
    //   301: checkcast 1762	com/tencent/mm/plugin/textstatus/proto/au
    //   304: astore 6
    //   306: aload 7
    //   308: ldc_w 868
    //   311: invokestatic 432	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   314: aload 6
    //   316: ifnonnull +14 -> 330
    //   319: iconst_0
    //   320: istore_1
    //   321: iload_1
    //   322: ifne +91 -> 413
    //   325: iconst_0
    //   326: istore_1
    //   327: goto -126 -> 201
    //   330: aload 7
    //   332: getfield 1767	com/tencent/mm/plugin/textstatus/proto/au:TpY	I
    //   335: aload 6
    //   337: getfield 1767	com/tencent/mm/plugin/textstatus/proto/au:TpY	I
    //   340: if_icmpeq +8 -> 348
    //   343: iconst_0
    //   344: istore_1
    //   345: goto -24 -> 321
    //   348: aload 7
    //   350: getfield 1770	com/tencent/mm/plugin/textstatus/proto/au:TpZ	Ljava/lang/String;
    //   353: aload 6
    //   355: getfield 1770	com/tencent/mm/plugin/textstatus/proto/au:TpZ	Ljava/lang/String;
    //   358: invokestatic 652	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   361: ifne +8 -> 369
    //   364: iconst_0
    //   365: istore_1
    //   366: goto -45 -> 321
    //   369: aload 7
    //   371: getfield 1771	com/tencent/mm/plugin/textstatus/proto/au:jumpInfos	Ljava/util/LinkedList;
    //   374: astore 7
    //   376: aload 7
    //   378: ldc_w 1772
    //   381: invokestatic 634	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   384: aload 7
    //   386: checkcast 1693	java/util/List
    //   389: aload 6
    //   391: getfield 1771	com/tencent/mm/plugin/textstatus/proto/au:jumpInfos	Ljava/util/LinkedList;
    //   394: checkcast 1693	java/util/List
    //   397: invokestatic 1778	com/tencent/mm/plugin/textstatus/d/b:O	(Ljava/util/List;Ljava/util/List;)Z
    //   400: ifne +8 -> 408
    //   403: iconst_0
    //   404: istore_1
    //   405: goto -84 -> 321
    //   408: iconst_1
    //   409: istore_1
    //   410: goto -89 -> 321
    //   413: iload_2
    //   414: iconst_1
    //   415: iadd
    //   416: istore_2
    //   417: goto -157 -> 260
    //   420: iconst_1
    //   421: istore_1
    //   422: goto -221 -> 201
    //   425: iconst_0
    //   426: istore_1
    //   427: goto -219 -> 208
    //   430: iconst_0
    //   431: istore_1
    //   432: goto -217 -> 215
    //   435: iconst_1
    //   436: istore_1
    //   437: goto -411 -> 26
    //   440: astore 4
    //   442: ldc_w 754
    //   445: aload 4
    //   447: ldc_w 1706
    //   450: iconst_0
    //   451: anewarray 4	java/lang/Object
    //   454: invokestatic 1710	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   457: aconst_null
    //   458: astore 4
    //   460: goto -416 -> 44
    //   463: aload 4
    //   465: getfield 629	com/tencent/mm/plugin/textstatus/h/f/b:field_StatusID	Ljava/lang/String;
    //   468: astore 4
    //   470: goto -395 -> 75
    //   473: aload_3
    //   474: getfield 1738	com/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo:jumpElements	Ljava/util/LinkedList;
    //   477: astore 5
    //   479: goto -397 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	c
    //   25	412	1	i	int
    //   259	158	2	j	int
    //   10	464	3	localObject1	Object
    //   37	257	4	localObject2	Object
    //   440	6	4	localThrowable	java.lang.Throwable
    //   458	11	4	str	String
    //   80	398	5	localObject3	Object
    //   54	336	6	localObject4	Object
    //   291	94	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   34	44	440	finally
  }
  
  public final void hHt()
  {
    AppMethodBeat.i(290116);
    com.tencent.mm.plugin.textstatus.a.d locald = this.Tmj;
    if (locald != null) {
      locald.onDetach();
    }
    this.Tmj = null;
    this.Tmk = null;
    AppMethodBeat.o(290116);
  }
  
  public final void hHu()
  {
    AppMethodBeat.i(290121);
    com.tencent.mm.plugin.textstatus.a.e locale = this.Tmh;
    if (locale != null) {
      locale.onDetach();
    }
    this.Tmh = null;
    this.Tmi = null;
    AppMethodBeat.o(290121);
  }
  
  public final void hHv()
  {
    AppMethodBeat.i(290143);
    com.tencent.mm.plugin.textstatus.h.f.b localb = this.Tmb;
    if (localb == null)
    {
      AppMethodBeat.o(290143);
      return;
    }
    label181:
    Object localObject2;
    if (kotlin.g.b.s.p(this.username, com.tencent.mm.plugin.auth.a.a.cUx()))
    {
      int i = localb.field_LikeCount;
      localObject1 = this.TlM;
      if (localObject1 != null) {
        ((View)localObject1).setBackground(null);
      }
      if (i > 0)
      {
        hHn().setText((CharSequence)String.valueOf(i));
        hHn().setVisibility(0);
        hHk().setVisibility(0);
        localObject1 = this.TlM;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = this.TlM;
        if (localObject1 != null) {
          ((View)localObject1).setBackground(getContext().getResources().getDrawable(a.d.TbX));
        }
        localObject1 = this.TlM;
        if (localObject1 != null) {
          ((View)localObject1).setBackground(null);
        }
        hHk().setImageDrawable(bb.e(getContext().getResources().getDrawable(a.g.finder_filled_like_private), getContext().getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.White)));
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject2 = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(getContext(), 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        if (localObject2 != null) {
          if (hHk().getVisibility() != 0) {
            break label525;
          }
        }
      }
    }
    label525:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpd = ((String)localObject1);
      AppMethodBeat.o(290143);
      return;
      hHn().setVisibility(8);
      hHk().setVisibility(8);
      localObject1 = this.TlM;
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(8);
      break;
      localObject1 = this.TlM;
      if (localObject1 != null) {
        ((View)localObject1).setBackground(getContext().getResources().getDrawable(a.d.TbW));
      }
      boolean bool = a(localb);
      hHn().setText((CharSequence)getContext().getString(a.h.TgI));
      hHn().setVisibility(8);
      StringBuilder localStringBuilder = new StringBuilder("update like num : tag=").append(hHk().getTag()).append(" isLike=").append(bool).append(" tvnick=");
      localObject1 = this.TlR;
      if (localObject1 == null) {
        localObject1 = (CharSequence)"";
      }
      for (;;)
      {
        Log.i("MicroMsg.TextStatus.BaseStatusLoadLogic", localObject1);
        hHk().setTag(Boolean.valueOf(bool));
        a(localb, bool);
        if (!bool) {
          break label486;
        }
        hHk().setImageDrawable(bb.e(getContext().getResources().getDrawable(a.g.icon_filled_awesome), getContext().getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.Red_100)));
        break;
        localObject2 = ((TextView)localObject1).getText();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (CharSequence)"";
        }
      }
      label486:
      hHk().setImageDrawable(bb.e(getContext().getResources().getDrawable(a.g.icon_filled_awesome), getContext().getResources().getColor(com.tencent.mm.plugin.textstatus.a.b.White)));
      break label181;
    }
  }
  
  public final void hHw()
  {
    AppMethodBeat.i(290158);
    hHk().setTag(null);
    AppMethodBeat.o(290158);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleDesc$topicClickListener$1", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "onClick", "", "widget", "Landroid/view/View;", "hrefInfo", "Lcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.pluginsdk.ui.span.n
  {
    d(c paramc) {}
    
    public final void a(View paramView, u paramu)
    {
      AppMethodBeat.i(289721);
      paramView = this.Tmp.Tmm;
      if (paramView != null) {
        paramView.gpi();
      }
      paramView = this.Tmp.Tmb;
      if (paramView == null) {}
      for (paramView = null; paramView == null; paramView = com.tencent.mm.plugin.textstatus.h.f.b.b(paramView))
      {
        AppMethodBeat.o(289721);
        return;
      }
      Object localObject2 = this.Tmp.hHs();
      Object localObject1;
      if (localObject2 == null)
      {
        localObject1 = null;
        Bundle localBundle = new Bundle();
        localObject2 = this.Tmp.Tmb;
        if (localObject2 != null) {
          break label223;
        }
        paramView = "";
        label97:
        localBundle.putString("textStatusModelInfoStr", com.tencent.mm.ae.f.dg(paramView).toString());
        if (paramu != null) {
          break label465;
        }
        paramView = "";
        label118:
        localBundle.putString("clickTagName", paramView);
        paramView = com.tencent.mm.plugin.textstatus.e.a.Tlb;
        com.tencent.mm.plugin.textstatus.e.a.a(this.Tmp.getContext(), (com.tencent.mm.plugin.textstatus.a.k)localObject1, localBundle);
        paramView = com.tencent.mm.plugin.textstatus.i.b.Trt;
        localObject1 = this.Tmp.getContext();
        if (paramu != null) {
          break label485;
        }
        paramView = "";
      }
      for (;;)
      {
        com.tencent.mm.plugin.textstatus.i.b.a((Context)localObject1, 26L, paramView, this.Tmp.Tmb, 0L, 0L, 0L, 112);
        AppMethodBeat.o(289721);
        return;
        if (paramu == null) {
          paramView = "";
        }
        for (;;)
        {
          localObject1 = ((com.tencent.mm.plugin.textstatus.a.d)localObject2).bdo(paramView);
          break;
          localObject1 = paramu.url;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
        }
        label223:
        kotlin.g.b.s.u(localObject2, "<this>");
        paramView = new TextStatusExtInfo();
        paramView.description = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Description;
        paramView.mediaType = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaType;
        paramView.mediaUrl = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaUrl;
        paramView.mediaAesKey = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaAESKey;
        paramView.mediaThumbUrl = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaThumbUrl;
        paramView.mediaThumbAesKey = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_MediaThumbAESKey;
        paramView.poiId = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_PoiID;
        paramView.poiName = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_PoiName;
        paramView.latitude = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Latitude;
        paramView.longitude = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Longitude;
        paramView.visibility = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_Visibility;
        paramView.expireTime = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_ExpireTime;
        paramView.createTime = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_CreateTime;
        paramView.backgroundId = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_backgroundId;
        Long localLong = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_option;
        kotlin.g.b.s.s(localLong, "field_option");
        paramView.option = ((Number)localLong).longValue();
        paramView.mediaWidth = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_mediaWidth;
        paramView.mediaHeight = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_mediaHeight;
        paramView.referenceUsername = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_referenceUserName;
        paramView.referenceTextStatusId = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_referenceTextStatusId;
        paramView.topicInfo = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject2);
        paramView.duplicateUsername = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_duplicateUserName;
        paramView.duplicateTextStatusId = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_duplicateTextStatusId;
        paramView.emojiInfo = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).hHD();
        break label97;
        label465:
        localObject2 = paramu.url;
        paramView = (View)localObject2;
        if (localObject2 != null) {
          break label118;
        }
        paramView = "";
        break label118;
        label485:
        paramu = paramu.url;
        paramView = paramu;
        if (paramu == null) {
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.c
 * JD-Core Version:    0.7.0.1
 */