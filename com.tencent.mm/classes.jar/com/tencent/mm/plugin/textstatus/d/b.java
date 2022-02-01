package com.tencent.mm.plugin.textstatus.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.c.e;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusSameTopicsActivity.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnLike", "Landroid/widget/ImageView;", "getBtnLike", "()Landroid/widget/ImageView;", "setBtnLike", "(Landroid/widget/ImageView;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivBrand", "getIvBrand", "setIvBrand", "ivNick", "getIvNick", "setIvNick", "ivSecurityClose", "Landroid/view/View;", "getIvSecurityClose", "()Landroid/view/View;", "setIvSecurityClose", "(Landroid/view/View;)V", "lastPopupLikeDismissTime", "", "getLastPopupLikeDismissTime", "()J", "setLastPopupLikeDismissTime", "(J)V", "layoutAvatarSameFriends", "Landroid/widget/LinearLayout;", "getLayoutAvatarSameFriends", "()Landroid/widget/LinearLayout;", "setLayoutAvatarSameFriends", "(Landroid/widget/LinearLayout;)V", "layoutBrand", "getLayoutBrand", "setLayoutBrand", "layoutBrandSpecialLayout", "Landroid/widget/FrameLayout;", "getLayoutBrandSpecialLayout", "()Landroid/widget/FrameLayout;", "setLayoutBrandSpecialLayout", "(Landroid/widget/FrameLayout;)V", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutSecurity", "getLayoutSecurity", "setLayoutSecurity", "loadParam", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "getLoadParam", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;", "setLoadParam", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic$LoadLogicParam;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "getShowParam", "()Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "statusId", "", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvBrand", "Landroid/widget/TextView;", "getTvBrand", "()Landroid/widget/TextView;", "setTvBrand", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvNick", "getTvNick", "setTvNick", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvSecurity", "getTvSecurity", "setTvSecurity", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "handleBrand", "", "handleLike", "handleSecurity", "init", "contentView", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setLoadLogicParam", "loadLogicParam", "setThumb", "bitmap", "Landroid/graphics/Bitmap;", "update", "", "item", "updateLikeNum", "updateOtherUserLocalState", "isLike", "Companion", "plugin-textstatus_release"})
public class b
  implements com.tencent.mm.ak.i, d
{
  public static final b.a FYB;
  private final com.tencent.mm.plugin.textstatus.a.n FYA;
  private TextView FYd;
  private TextView FYe;
  private String FYf;
  private TextView FYg;
  private ImageView FYh;
  private View FYi;
  private TextView FYj;
  private LinearLayout FYk;
  private LinearLayout FYl;
  private ImageView FYm;
  private TextView FYn;
  public ImageView FYo;
  private ImageView FYp;
  public TextView FYq;
  private ImageView FYr;
  private TextView FYs;
  FrameLayout FYt;
  private TextView FYu;
  View FYv;
  private View FYw;
  com.tencent.mm.plugin.textstatus.f.f.a FYx;
  long FYy;
  private d.a FYz;
  public Context context;
  private String username;
  
  static
  {
    AppMethodBeat.i(216152);
    FYB = new b.a((byte)0);
    AppMethodBeat.o(216152);
  }
  
  public b(com.tencent.mm.plugin.textstatus.a.n paramn)
  {
    AppMethodBeat.i(216151);
    this.FYA = paramn;
    this.FYf = "";
    this.FYz = new d.a();
    AppMethodBeat.o(216151);
  }
  
  private void a(final com.tencent.mm.plugin.textstatus.f.f.a parama)
  {
    AppMethodBeat.i(216146);
    p.h(parama, "info");
    parama = parama.fvU();
    Object localObject = (CharSequence)parama.Gao;
    int i;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject)))
    {
      i = 1;
      if (i != 0) {
        break label183;
      }
      localObject = this.FYl;
      if (localObject != null) {
        ((LinearLayout)localObject).setVisibility(0);
      }
      localObject = this.FYn;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)parama.Gal);
      }
      localObject = (CharSequence)parama.Gam;
      if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
        break label160;
      }
      i = 1;
      label98:
      if (i != 0) {
        break label165;
      }
      localObject = this.FYm;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        com.tencent.mm.av.q.bcV().loadImage(parama.Gam, (ImageView)localObject);
      }
    }
    for (;;)
    {
      h.RTc.aX((Runnable)new b(this, parama));
      AppMethodBeat.o(216146);
      return;
      i = 0;
      break;
      label160:
      i = 0;
      break label98;
      label165:
      localObject = this.FYm;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
    }
    label183:
    parama = this.FYl;
    if (parama != null)
    {
      parama.setVisibility(8);
      AppMethodBeat.o(216146);
      return;
    }
    AppMethodBeat.o(216146);
  }
  
  private final void aTg(final String paramString)
  {
    AppMethodBeat.i(216148);
    final com.tencent.mm.plugin.textstatus.f.f.a locala = this.FYx;
    if (locala == null)
    {
      AppMethodBeat.o(216148);
      return;
    }
    fvQ();
    ImageView localImageView = this.FYo;
    if (localImageView == null) {
      p.btv("btnLike");
    }
    localImageView.setOnClickListener((View.OnClickListener)new c(this, paramString, locala));
    AppMethodBeat.o(216148);
  }
  
  private void fvP()
  {
    AppMethodBeat.i(216145);
    Object localObject = this.FYx;
    if (localObject == null)
    {
      AppMethodBeat.o(216145);
      return;
    }
    TextView localTextView;
    switch (((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_state)
    {
    default: 
      localObject = this.FYv;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        AppMethodBeat.o(216145);
        return;
      }
      break;
    case 5: 
      localObject = this.FYv;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.context;
      if (localObject == null) {
        p.btv("context");
      }
      localObject = ((Context)localObject).getResources().getString(2131766743);
      p.g(localObject, "context.resources.getStr….text_status_tips_resend)");
      localTextView = this.FYu;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      localObject = this.FYw;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.FYv;
      if (localObject != null)
      {
        ((View)localObject).setOnClickListener((View.OnClickListener)new d(this));
        AppMethodBeat.o(216145);
        return;
      }
      AppMethodBeat.o(216145);
      return;
    case 6: 
      localObject = this.FYv;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.FYw;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
      localObject = com.tencent.mm.plugin.textstatus.f.h.c.fwd();
      localTextView = this.FYu;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject);
      }
      localObject = this.FYv;
      if (localObject != null)
      {
        ((View)localObject).setOnClickListener((View.OnClickListener)new e(this));
        AppMethodBeat.o(216145);
        return;
      }
      AppMethodBeat.o(216145);
      return;
    }
    AppMethodBeat.o(216145);
  }
  
  @SuppressLint({"ResourceType"})
  private final void fvQ()
  {
    AppMethodBeat.i(216149);
    Object localObject1 = this.FYx;
    if (localObject1 == null)
    {
      AppMethodBeat.o(216149);
      return;
    }
    Object localObject2;
    Context localContext;
    if (p.j(this.username, com.tencent.mm.plugin.auth.a.a.ceA()))
    {
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      int i = com.tencent.mm.plugin.textstatus.b.f.fvN().aTj(((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_StatusID);
      if (i > 0)
      {
        localObject1 = this.FYq;
        if (localObject1 == null) {
          p.btv("tvLikeNum");
        }
        ((TextView)localObject1).setText((CharSequence)String.valueOf(i));
        localObject1 = this.FYq;
        if (localObject1 == null) {
          p.btv("tvLikeNum");
        }
        ((TextView)localObject1).setVisibility(0);
        localObject1 = this.FYo;
        if (localObject1 == null) {
          p.btv("btnLike");
        }
        ((ImageView)localObject1).setVisibility(0);
        localObject1 = this.FYo;
        if (localObject1 == null) {
          p.btv("btnLike");
        }
        localObject2 = this.context;
        if (localObject2 == null) {
          p.btv("context");
        }
        localObject2 = ((Context)localObject2).getResources().getDrawable(2131690284);
        localContext = this.context;
        if (localContext == null) {
          p.btv("context");
        }
        ((ImageView)localObject1).setImageDrawable(ar.e((Drawable)localObject2, localContext.getResources().getColor(2131099844)));
        label201:
        localObject1 = SecDataUIC.CWq;
        localObject1 = this.context;
        if (localObject1 == null) {
          p.btv("context");
        }
        localObject2 = (y)SecDataUIC.a.a((Context)localObject1, 9, y.class);
        if (localObject2 == null) {
          break label562;
        }
        localObject1 = this.FYo;
        if (localObject1 == null) {
          p.btv("btnLike");
        }
        if (((ImageView)localObject1).getVisibility() != 0) {
          break label555;
        }
      }
    }
    label555:
    for (localObject1 = "1";; localObject1 = "0")
    {
      ((y)localObject2).UrV = ((String)localObject1);
      AppMethodBeat.o(216149);
      return;
      localObject1 = this.FYq;
      if (localObject1 == null) {
        p.btv("tvLikeNum");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = this.FYo;
      if (localObject1 == null) {
        p.btv("btnLike");
      }
      ((ImageView)localObject1).setVisibility(8);
      break;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      boolean bool = com.tencent.mm.plugin.textstatus.b.f.fvN().aTi(((com.tencent.mm.plugin.textstatus.f.f.a)localObject1).field_StatusID);
      localObject1 = this.FYq;
      if (localObject1 == null) {
        p.btv("tvLikeNum");
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = this.FYo;
      if (localObject1 == null) {
        p.btv("btnLike");
      }
      ((ImageView)localObject1).setTag(Boolean.valueOf(bool));
      if (bool)
      {
        localObject1 = this.FYo;
        if (localObject1 == null) {
          p.btv("btnLike");
        }
        localObject2 = this.context;
        if (localObject2 == null) {
          p.btv("context");
        }
        localObject2 = ((Context)localObject2).getResources().getDrawable(2131690436);
        localContext = this.context;
        if (localContext == null) {
          p.btv("context");
        }
        ((ImageView)localObject1).setImageDrawable(ar.e((Drawable)localObject2, localContext.getResources().getColor(2131099824)));
        break label201;
      }
      localObject1 = this.FYo;
      if (localObject1 == null) {
        p.btv("btnLike");
      }
      localObject2 = this.context;
      if (localObject2 == null) {
        p.btv("context");
      }
      localObject2 = ((Context)localObject2).getResources().getDrawable(2131690822);
      localContext = this.context;
      if (localContext == null) {
        p.btv("context");
      }
      ((ImageView)localObject1).setImageDrawable(ar.e((Drawable)localObject2, localContext.getResources().getColor(2131099844)));
      break label201;
    }
    label562:
    AppMethodBeat.o(216149);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(216147);
    p.h(parama, "loadLogicParam");
    this.FYz = parama;
    AppMethodBeat.o(216147);
  }
  
  public final boolean aNc(String paramString)
  {
    AppMethodBeat.i(216143);
    p.h(paramString, "username");
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    boolean bool = b(paramString, com.tencent.mm.plugin.textstatus.b.f.aTf(paramString));
    AppMethodBeat.o(216143);
    return bool;
  }
  
  public final boolean b(String paramString, final com.tencent.mm.plugin.textstatus.f.f.a parama)
  {
    AppMethodBeat.i(216144);
    p.h(paramString, "username");
    this.username = paramString;
    this.FYx = parama;
    Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", "[update status]info:%s", new Object[] { this.FYx });
    if (parama == null)
    {
      AppMethodBeat.o(216144);
      return false;
    }
    Object localObject1 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
    localObject1 = com.tencent.mm.plugin.textstatus.j.b.getName(parama.field_IconID);
    Object localObject2 = parama.field_StatusID;
    p.g(localObject2, "info.field_StatusID");
    this.FYf = ((String)localObject2);
    Object localObject3 = parama.field_Description;
    localObject2 = parama.field_IconID;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      Object localObject4 = this.FYe;
      if (localObject4 != null) {
        ((TextView)localObject4).setText((CharSequence)localObject3);
      }
      localObject3 = this.FYe;
      if (localObject3 != null) {
        ((TextView)localObject3).setVisibility(0);
      }
      if ((!this.FYA.abM(8)) || (localObject2 == null)) {
        break label756;
      }
      localObject3 = this.FYp;
      if (localObject3 != null) {
        ((ImageView)localObject3).setVisibility(0);
      }
      localObject3 = this.FYp;
      if (localObject3 != null)
      {
        localObject4 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        ((ImageView)localObject3).setImageDrawable(com.tencent.mm.plugin.textstatus.j.b.a((String)localObject2, a.c.FXp, a.a.FXd));
      }
      label216:
      localObject2 = this.FYd;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      aTg(paramString);
      if (this.FYz.FYG)
      {
        localObject1 = this.FYh;
        if (localObject1 != null)
        {
          if (!this.FYA.FXv) {
            break label777;
          }
          localObject2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
          localObject2 = this.context;
          if (localObject2 == null) {
            p.btv("context");
          }
          com.tencent.mm.plugin.textstatus.e.a.a((Context)localObject2, (ImageView)localObject1, paramString, parama);
        }
      }
      label304:
      localObject1 = (CharSequence)parama.field_TopicId;
      if ((localObject1 != null) && (!kotlin.n.n.aL((CharSequence)localObject1))) {
        break label812;
      }
      i = 1;
      label328:
      if (i != 0) {
        break label926;
      }
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    }
    label389:
    label412:
    label926:
    for (int i = com.tencent.mm.plugin.textstatus.b.f.fvM().m(parama.field_TopicId, j.ac(new String[] { paramString })).size();; i = 0)
    {
      localObject1 = (CharSequence)parama.field_PoiName;
      int j;
      if ((localObject1 == null) || (kotlin.n.n.aL((CharSequence)localObject1)))
      {
        j = 1;
        if (j == 0) {
          break label823;
        }
        localObject1 = this.FYj;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = this.FYk;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).removeAllViews();
        }
        if ((!this.FYA.abM(4)) || (i <= 0)) {
          break label866;
        }
        Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", "sametsize ".concat(String.valueOf(i)));
        localObject1 = this.FYg;
        if (localObject1 != null)
        {
          localObject2 = this.context;
          if (localObject2 == null) {
            p.btv("context");
          }
          localObject2 = ((Context)localObject2).getResources();
          localObject3 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
          ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(2131766723, new Object[] { Integer.valueOf(i), com.tencent.mm.plugin.textstatus.j.b.getName(parama.field_IconID) }));
        }
        localObject1 = this.FYg;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = this.FYg;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener((View.OnClickListener)new g(this, parama));
        }
        localObject1 = SecDataUIC.CWq;
        localObject1 = this.context;
        if (localObject1 == null) {
          p.btv("context");
        }
        localObject1 = (y)SecDataUIC.a.a((Context)localObject1, 9, y.class);
        if (localObject1 != null) {
          ((y)localObject1).UrW = i;
        }
        label629:
        if (!this.FYA.abM(1)) {
          break label887;
        }
        localObject1 = this.FYr;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        a.b.c(this.FYr, paramString);
        if (!this.FYA.abM(2)) {
          break label908;
        }
        localObject1 = this.FYs;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        paramString = aa.getDisplayName(paramString);
        localObject1 = this.FYs;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)paramString);
        }
      }
      for (;;)
      {
        a(parama);
        fvP();
        AppMethodBeat.o(216144);
        return true;
        localObject3 = this.FYe;
        if (localObject3 == null) {
          break;
        }
        ((TextView)localObject3).setVisibility(8);
        break;
        label756:
        localObject2 = this.FYp;
        if (localObject2 == null) {
          break label216;
        }
        ((ImageView)localObject2).setVisibility(8);
        break label216;
        localObject2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
        localObject3 = this.context;
        if (localObject3 == null) {
          p.btv("context");
        }
        com.tencent.mm.plugin.textstatus.e.a.a((com.tencent.mm.plugin.textstatus.e.a)localObject2, (Context)localObject3, paramString, (ImageView)localObject1);
        break label304;
        label812:
        i = 0;
        break label328;
        j = 0;
        break label389;
        label823:
        localObject1 = this.FYj;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = this.FYj;
        if (localObject1 == null) {
          break label412;
        }
        ((TextView)localObject1).setText((CharSequence)parama.field_PoiName);
        break label412;
        label866:
        localObject1 = this.FYg;
        if (localObject1 == null) {
          break label629;
        }
        ((TextView)localObject1).setVisibility(8);
        break label629;
        label887:
        localObject1 = this.FYr;
        if (localObject1 == null) {
          break label665;
        }
        ((ImageView)localObject1).setVisibility(8);
        break label665;
        paramString = this.FYs;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
      }
    }
  }
  
  public void ba(View paramView)
  {
    AppMethodBeat.i(216142);
    p.h(paramView, "contentView");
    Object localObject = paramView.getContext();
    p.g(localObject, "contentView.context");
    this.context = ((Context)localObject);
    this.FYd = ((TextView)paramView.findViewById(2131309533));
    this.FYg = ((TextView)paramView.findViewById(2131309519));
    this.FYe = ((TextView)paramView.findViewById(2131309471));
    this.FYj = ((TextView)paramView.findViewById(2131309512));
    localObject = paramView.findViewById(2131297836);
    p.g(localObject, "contentView.findViewById(R.id.btn_like)");
    this.FYo = ((ImageView)localObject);
    this.FYp = ((ImageView)paramView.findViewById(2131302508));
    localObject = paramView.findViewById(2131309500);
    p.g(localObject, "contentView.findViewById(R.id.tv_like_num)");
    this.FYq = ((TextView)localObject);
    this.FYh = ((ImageView)paramView.findViewById(2131309661));
    this.FYk = ((LinearLayout)paramView.findViewById(2131303078));
    this.FYi = paramView.findViewById(2131303084);
    this.FYl = ((LinearLayout)paramView.findViewById(2131303082));
    this.FYm = ((ImageView)paramView.findViewById(2131302883));
    this.FYn = ((TextView)paramView.findViewById(2131309457));
    this.FYr = ((ImageView)paramView.findViewById(2131302901));
    this.FYs = ((TextView)paramView.findViewById(2131309509));
    this.FYt = ((FrameLayout)paramView.findViewById(2131303083));
    this.FYv = paramView.findViewById(2131303097);
    this.FYw = paramView.findViewById(2131302907);
    this.FYu = ((TextView)paramView.findViewById(2131309521));
    paramView = this.FYl;
    if (paramView != null)
    {
      paramView.setOnClickListener((View.OnClickListener)new f(this));
      AppMethodBeat.o(216142);
      return;
    }
    AppMethodBeat.o(216142);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(216141);
    Context localContext = this.context;
    if (localContext == null) {
      p.btv("context");
    }
    AppMethodBeat.o(216141);
    return localContext;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216150);
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.i))
    {
      g.azz().b(((com.tencent.mm.plugin.textstatus.f.i)paramq).getType(), (com.tencent.mm.ak.i)this);
      fvQ();
    }
    AppMethodBeat.o(216150);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(216135);
      final z.f localf = new z.f();
      localf.SYG = null;
      Object localObject1 = com.tencent.mm.plugin.textstatus.i.d.Gcq;
      localObject1 = parama.Gao;
      p.g(localObject1, "topicInfo.source_id");
      Object localObject2 = parama.Gbe;
      p.g(localObject2, "topicInfo.jump_infos");
      localObject2 = ((LinkedList)localObject2).getFirst();
      p.g(localObject2, "topicInfo.jump_infos.first");
      localf.SYG = com.tencent.mm.plugin.textstatus.i.d.a((String)localObject1, (r)localObject2);
      h.RTc.aV((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216134);
          Object localObject = this.FYE.FYC.FYt;
          if (localObject != null) {
            ((FrameLayout)localObject).removeAllViews();
          }
          if ((View)localf.SYG != null)
          {
            localObject = this.FYE.FYC.FYt;
            if (localObject != null) {
              ((FrameLayout)localObject).setVisibility(0);
            }
            localObject = (View)localf.SYG;
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
            localLayoutParams.width = at.aH(this.FYE.FYC.getContext(), 2131165296);
            localLayoutParams.height = at.aH(this.FYE.FYC.getContext(), 2131165296);
            ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
            localObject = this.FYE.FYC.FYt;
            if (localObject != null) {
              ((FrameLayout)localObject).addView((View)localf.SYG);
            }
            ((View)localf.SYG).invalidate();
            AppMethodBeat.o(216134);
            return;
          }
          localObject = this.FYE.FYC.FYt;
          if (localObject != null)
          {
            ((FrameLayout)localObject).setVisibility(8);
            AppMethodBeat.o(216134);
            return;
          }
          AppMethodBeat.o(216134);
        }
      });
      AppMethodBeat.o(216135);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, String paramString, com.tencent.mm.plugin.textstatus.f.f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216136);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      if (p.j(com.tencent.mm.plugin.auth.a.a.ceA(), paramString))
      {
        paramView = TextStatusLikeListActivity.Gfx;
        paramView = this.FYC.getContext();
        localObject = locala.field_StatusID;
        p.h(paramView, "context");
        Intent localIntent = new Intent(paramView, TextStatusLikeListActivity.class);
        localIntent.putExtra("status_id", (String)localObject);
        localIntent.putExtra("scene", 0);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForHistory", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(14L, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216136);
        return;
      }
      if (Math.abs(System.currentTimeMillis() - this.FYC.FYy) < 500L)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216136);
        return;
      }
      paramView = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      localObject = com.tencent.mm.plugin.textstatus.b.f.fvN();
      paramView = locala;
      if (paramView != null)
      {
        paramView = paramView.field_StatusID;
        boolean bool = ((com.tencent.mm.plugin.textstatus.f.f.c)localObject).aTi(paramView);
        paramView = this.FYC.FYo;
        if (paramView == null) {
          p.btv("btnLike");
        }
        localObject = paramView.getTag();
        paramView = (View)localObject;
        if (!(localObject instanceof Boolean)) {
          paramView = null;
        }
        paramView = (Boolean)paramView;
        Log.i("MicroMsg.TxtStatus.BaseStatusLoadLogic", "isLikeOther:" + bool + " localIsLike:" + paramView);
        if (!p.j(paramView, Boolean.TRUE)) {
          break label516;
        }
        paramView = locala.field_TopicId;
        p.g(paramView, "info.field_TopicId");
        localObject = locala.field_StatusID;
        p.g(localObject, "info.field_StatusID");
        paramView = new com.tencent.mm.plugin.textstatus.f.i(paramView, (String)localObject, paramString, 1, 1);
        g.azz().a(paramView.getType(), (com.tencent.mm.ak.i)new f((com.tencent.mm.ak.i)this.FYC));
        g.azz().b((com.tencent.mm.ak.q)paramView);
        b.a(this.FYC, false);
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(12L, paramView);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleLike$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216136);
        return;
        paramView = null;
        break;
        label516:
        b.a(this.FYC, true);
        paramView = locala.field_TopicId;
        p.g(paramView, "info.field_TopicId");
        localObject = locala.field_StatusID;
        p.g(localObject, "info.field_StatusID");
        paramView = new com.tencent.mm.plugin.textstatus.f.i(paramView, (String)localObject, paramString, 0, 1);
        g.azz().a(paramView.getType(), (com.tencent.mm.ak.i)new f((com.tencent.mm.ak.i)this.FYC));
        g.azz().b((com.tencent.mm.ak.q)paramView);
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(13L, "1", paramView);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216137);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
      com.tencent.mm.plugin.textstatus.f.h.c.fwc();
      paramView = this.FYC.FYv;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216137);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216138);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.FYC.FYv;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$handleSecurity$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216138);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216139);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      Object localObject2 = this.FYC.FYx;
      if (localObject2 != null)
      {
        paramView = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).fvU();
        localObject1 = e.FYb;
        localObject1 = paramView.Gao;
        p.g(localObject1, "topicInfo.source_id");
        localObject2 = Util.nullAs(((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_StatusID, "");
        p.g(localObject2, "Util.nullAs(info.field_StatusID, \"\")");
        paramView = paramView.Gbe;
        p.g(paramView, "topicInfo.jump_infos");
        e.h((String)localObject1, (String)localObject2, (List)paramView);
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
        if (paramView != null)
        {
          localObject1 = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(23L, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216139);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(b paramb, com.tencent.mm.plugin.textstatus.f.f.a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216140);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = TextStatusSameTopicsActivity.GfI;
      TextStatusSameTopicsActivity.a.bE(this.FYC.getContext(), parama.field_TopicId);
      paramView = SecDataUIC.CWq;
      paramView = (y)SecDataUIC.a.a(this.FYC.getContext(), 9, y.class);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.a(21L, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic$update$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.b
 * JD-Core Version:    0.7.0.1
 */