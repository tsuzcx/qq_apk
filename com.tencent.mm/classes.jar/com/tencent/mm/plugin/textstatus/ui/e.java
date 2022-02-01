package com.tencent.mm.plugin.textstatus.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.f.a;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.d.d.a;
import com.tencent.mm.plugin.textstatus.f.k.e;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/ProfileCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "extraPadding", "", "(Landroid/content/Context;Landroid/widget/RelativeLayout;Landroid/widget/LinearLayout;I)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconAvatarNotify", "getIconAvatarNotify", "setIconAvatarNotify", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "lastExposedSessionId", "", "layoutCardContent", "getLayoutCardContent", "()Landroid/widget/RelativeLayout;", "setLayoutCardContent", "(Landroid/widget/RelativeLayout;)V", "layoutNotify", "getLayoutNotify", "()Landroid/widget/LinearLayout;", "setLayoutNotify", "(Landroid/widget/LinearLayout;)V", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "oriColorMap", "Ljava/util/HashMap;", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "Lkotlin/collections/HashMap;", "getOriColorMap", "()Ljava/util/HashMap;", "setOriColorMap", "(Ljava/util/HashMap;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "tvChatCount", "getTvChatCount", "()Landroid/widget/TextView;", "setTvChatCount", "(Landroid/widget/TextView;)V", "tvDesc", "getTvDesc", "setTvDesc", "tvDescNotify", "getTvDescNotify", "setTvDescNotify", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "vBack", "getVBack", "setVBack", "fixLayout", "", "hasStatus", "", "getLayoutId", "getView", "goDetail", "handleNotify", "init", "initData", "isSelf", "onClick", "v", "onCoordinationViewClosing", "offset", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "onPreClose", "onPreOpen", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "setEventListener", "l", "setItemClickListener", "update", "Companion", "plugin-textstatus_release"})
public final class e
  implements View.OnClickListener, i, com.tencent.mm.plugin.textstatus.a.d
{
  public static final e.a Gdh;
  private static final String TAG = "MicroMsg.TxtStatus.StatusCardView";
  private f.a FXT;
  private TextView FYd;
  private TextView FYe;
  private TextView FYg;
  private ImageView FYh;
  private TextView FYj;
  private ImageView FYo;
  private ImageView FYp;
  private TextView FYq;
  private com.tencent.mm.plugin.textstatus.f.f.a FYx;
  private RelativeLayout GcI;
  private ImageView GcJ;
  private ImageView GcO;
  private TextView GcP;
  private LinearLayout GcQ;
  private com.tencent.mm.plugin.textstatus.d.c GcV;
  private HashMap<TextView, ColorStateList> GcW;
  private final LinearLayout GcZ;
  private final int Gda;
  private String UsP;
  private View.OnClickListener dec;
  private com.tencent.mm.ui.base.q gut;
  private final RelativeLayout hOX;
  private Context mContext;
  private String sessionId;
  private final View tlx;
  private String username;
  
  static
  {
    AppMethodBeat.i(216417);
    Gdh = new e.a((byte)0);
    TAG = "MicroMsg.TxtStatus.StatusCardView";
    AppMethodBeat.o(216417);
  }
  
  public e(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt)
  {
    AppMethodBeat.i(216416);
    this.hOX = paramRelativeLayout;
    this.GcZ = paramLinearLayout;
    this.Gda = paramInt;
    paramRelativeLayout = LayoutInflater.from(paramContext).inflate(2131496697, null, false);
    p.g(paramRelativeLayout, "LayoutInflater.from(cont…tLayoutId(), null, false)");
    this.tlx = paramRelativeLayout;
    this.mContext = paramContext;
    this.GcW = new HashMap();
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.d.e.FYH;
    this.GcV = com.tencent.mm.plugin.textstatus.d.e.fvR();
    this.GcV.ba(this.tlx);
    this.FYd = ((TextView)this.tlx.findViewById(2131309533));
    this.FYg = ((TextView)this.tlx.findViewById(2131309519));
    this.FYe = ((TextView)this.tlx.findViewById(2131309471));
    this.FYj = ((TextView)this.tlx.findViewById(2131309512));
    this.GcJ = ((ImageView)this.tlx.findViewById(2131297834));
    paramRelativeLayout = this.tlx.findViewById(2131297836);
    p.g(paramRelativeLayout, "cardView.findViewById(R.id.btn_like)");
    this.FYo = ((ImageView)paramRelativeLayout);
    this.FYp = ((ImageView)this.tlx.findViewById(2131302508));
    paramRelativeLayout = this.tlx.findViewById(2131302480);
    p.g(paramRelativeLayout, "cardView.findViewById(R.id.icon_avatar_notify)");
    this.GcO = ((ImageView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309472);
    p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_desc_notify)");
    this.GcP = ((TextView)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131303093);
    p.g(paramRelativeLayout, "cardView.findViewById(R.id.layout_notify)");
    this.GcQ = ((LinearLayout)paramRelativeLayout);
    paramRelativeLayout = this.tlx.findViewById(2131309500);
    p.g(paramRelativeLayout, "cardView.findViewById(R.id.tv_like_num)");
    this.FYq = ((TextView)paramRelativeLayout);
    this.FYh = ((ImageView)this.tlx.findViewById(2131309661));
    this.GcI = ((RelativeLayout)this.tlx.findViewById(2131303084));
    paramRelativeLayout = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    com.tencent.mm.plugin.textstatus.j.f.B((View)this.GcO, com.tencent.mm.cb.a.fromDPToPix(paramContext, 10.0F));
    paramContext = com.tencent.mm.plugin.fts.a.d.Nj(1);
    p.g(paramContext, "FTSApiLogic.getUnsignedM…atus.SessionScene.NORMAL)");
    this.sessionId = paramContext;
    this.UsP = "";
    AppMethodBeat.o(216416);
  }
  
  public final void DV(String paramString)
  {
    AppMethodBeat.i(216401);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216401);
      return;
    }
    new k.e(paramString, (j)this);
    localObject = com.tencent.mm.ui.component.a.PRN;
    ((SecDataUIC)com.tencent.mm.ui.component.a.ko(this.mContext).get(SecDataUIC.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(y.class, 9, (byte)0));
    localObject = SecDataUIC.CWq;
    localObject = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
    if (localObject != null)
    {
      ((y)localObject).sessionId = this.sessionId;
      ((y)localObject).username = paramString;
      ((y)localObject).UrY = 4;
    }
    this.username = paramString;
    new k.e(paramString, (j)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    this.GcV.a(new d.a(false));
    boolean bool = this.GcV.aNc(paramString);
    if (!bool)
    {
      paramString = this.GcZ;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 32));
      }
      paramString = this.hOX;
      if (paramString != null)
      {
        paramString = paramString.getLayoutParams();
        if (paramString == null) {}
      }
    }
    for (paramString.height = -2; !bool; this.hOX.getLayoutParams().height = i)
    {
      this.tlx.setVisibility(8);
      paramString = com.tencent.mm.plugin.textstatus.j.f.Ggk;
      com.tencent.mm.plugin.textstatus.j.f.aT((Map)this.GcW);
      AppMethodBeat.o(216401);
      return;
      i = ah.jS(this.mContext).width;
      paramString = this.GcZ;
      if (paramString != null) {
        paramString.setPadding(paramString.getPaddingLeft(), paramString.getPaddingTop(), paramString.getPaddingRight(), com.tencent.mm.cb.a.fromDPToPix(this.mContext, 16));
      }
    }
    this.tlx.setVisibility(0);
    com.tencent.mm.plugin.textstatus.j.f.Ggk.a((View)this.GcZ, -1, (Map)this.GcW);
    paramString = com.tencent.mm.plugin.textstatus.j.b.GfZ;
    paramString = this.FYx;
    if (paramString != null) {}
    for (paramString = paramString.field_IconID;; paramString = null)
    {
      paramString = com.tencent.mm.plugin.textstatus.j.b.getName(paramString);
      localObject = this.FYd;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)(this.mContext.getString(2131766739) + paramString));
      }
      this.tlx.setOnClickListener((View.OnClickListener)this);
      paramString = SecDataUIC.CWq;
      paramString = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
      if ((paramString == null) || (TextUtils.equals((CharSequence)paramString.sessionId, (CharSequence)this.UsP))) {
        break;
      }
      localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.a(1L, paramString);
      paramString = paramString.sessionId;
      p.g(paramString, "it.sessionId");
      this.UsP = paramString;
      AppMethodBeat.o(216401);
      return;
    }
    AppMethodBeat.o(216401);
  }
  
  public final void UC(int paramInt)
  {
    AppMethodBeat.i(216411);
    this.GcV.UC(paramInt);
    AppMethodBeat.o(216411);
  }
  
  public final void UD(int paramInt)
  {
    AppMethodBeat.i(216412);
    this.GcV.UD(paramInt);
    AppMethodBeat.o(216412);
  }
  
  public final void UE(int paramInt)
  {
    AppMethodBeat.i(216413);
    this.GcV.UE(paramInt);
    AppMethodBeat.o(216413);
  }
  
  public final void a(f.a parama)
  {
    this.FXT = parama;
  }
  
  public final void cd(float paramFloat) {}
  
  public final void eEk()
  {
    AppMethodBeat.i(216407);
    this.GcV.eEk();
    AppMethodBeat.o(216407);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(216408);
    this.GcV.eEl();
    AppMethodBeat.o(216408);
  }
  
  public final void eEm()
  {
    AppMethodBeat.i(216409);
    this.GcV.eEm();
    AppMethodBeat.o(216409);
  }
  
  public final void eEn()
  {
    AppMethodBeat.i(216410);
    this.GcV.eEn();
    AppMethodBeat.o(216410);
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.dec = paramOnClickListener;
  }
  
  public final void fvv()
  {
    AppMethodBeat.i(216402);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216402);
    throw localThrowable;
  }
  
  public final void fvw()
  {
    AppMethodBeat.i(216403);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216403);
    throw localThrowable;
  }
  
  public final void fvx()
  {
    AppMethodBeat.i(216404);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216404);
    throw localThrowable;
  }
  
  public final View getView()
  {
    return this.tlx;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216414);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = this.dec;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/ProfileCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216414);
  }
  
  public final void onPostClose()
  {
    AppMethodBeat.i(216406);
    this.GcV.onPostClose();
    AppMethodBeat.o(216406);
  }
  
  public final void onPostOpen(boolean paramBoolean)
  {
    AppMethodBeat.i(216405);
    this.GcV.onPostOpen(paramBoolean);
    AppMethodBeat.o(216405);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216415);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.b))
    {
      g.azz().b(((com.tencent.mm.plugin.textstatus.f.b)paramq).getType(), (i)this);
      bool = false;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label86;
      }
      bool = true;
    }
    for (;;)
    {
      paramString = this.FXT;
      if (paramString != null) {
        paramString.dV(Boolean.valueOf(bool));
      }
      paramString = this.gut;
      if (paramString == null) {
        break;
      }
      paramString.dismiss();
      AppMethodBeat.o(216415);
      return;
      label86:
      com.tencent.mm.ui.base.h.X(this.mContext, this.mContext.getString(2131766714), "");
    }
    AppMethodBeat.o(216415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.e
 * JD-Core Version:    0.7.0.1
 */