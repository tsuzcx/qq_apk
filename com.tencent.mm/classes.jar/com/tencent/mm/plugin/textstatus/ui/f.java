package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.plugin.textstatus.d.e;
import com.tencent.mm.plugin.textstatus.f.k.e;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.plugin.thumbplayer.view.MMTPRecyclerVideoLayout;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/StatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusInfoUpdate;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "btnJoin", "Landroid/widget/ImageView;", "getBtnJoin", "()Landroid/widget/ImageView;", "setBtnJoin", "(Landroid/widget/ImageView;)V", "btnLike", "getBtnLike", "setBtnLike", "cardView", "Landroid/view/View;", "clickListener", "eventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "iconStatus", "getIconStatus", "setIconStatus", "info", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getInfo", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setInfo", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "ivMask", "getIvMask", "()Landroid/view/View;", "setIvMask", "(Landroid/view/View;)V", "lastExposedSessionId", "", "layoutCardContent", "getLayoutCardContent", "setLayoutCardContent", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "loadLogic", "Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "getLoadLogic", "()Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;", "setLoadLogic", "(Lcom/tencent/mm/plugin/textstatus/logic/IStatusLoadLogic;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "sessionId", "statusId", "getStatusId", "()Ljava/lang/String;", "setStatusId", "(Ljava/lang/String;)V", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "setTvDesc", "(Landroid/widget/TextView;)V", "tvLikeNum", "getTvLikeNum", "setTvLikeNum", "tvPoi", "getTvPoi", "setTvPoi", "tvSameFriendsTips", "getTvSameFriendsTips", "setTvSameFriendsTips", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "username", "getUsername", "setUsername", "vBack", "getVBack", "setVBack", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "getVideoLayout", "()Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;", "setVideoLayout", "(Lcom/tencent/mm/plugin/thumbplayer/view/MMTPRecyclerVideoLayout;)V", "destoryVideo", "", "getView", "handleVideo", "initData", "onClick", "v", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onStatusShowDestroy", "onStatusShowPause", "onStatusShowResume", "onTransAnim", "persent", "", "pauseVideo", "playVideo", "setEventListener", "l", "setItemClickListener", "update", "updateMask", "Companion", "plugin-textstatus_release"})
public final class f
  implements View.OnClickListener, i, com.tencent.mm.plugin.textstatus.a.f, com.tencent.mm.plugin.textstatus.a.g
{
  public static final f.a Gdx;
  private MMTPRecyclerVideoLayout AuG;
  private com.tencent.mm.plugin.textstatus.a.f.a FXT;
  private final com.tencent.mm.plugin.textstatus.a.n FYA;
  private TextView FYd;
  private TextView FYe;
  private String FYf;
  private TextView FYg;
  private ImageView FYh;
  private TextView FYj;
  private ImageView FYo;
  private ImageView FYp;
  private TextView FYq;
  private com.tencent.mm.plugin.textstatus.f.f.a FYx;
  private ImageView GcJ;
  private FrameLayout Gcu;
  private com.tencent.mm.plugin.textstatus.d.d Gdv;
  private View Gdw;
  private String UsP;
  View.OnClickListener dec;
  private com.tencent.mm.ui.base.q gut;
  private Context mContext;
  private String sessionId;
  public final View tlx;
  private String username;
  
  static
  {
    AppMethodBeat.i(216459);
    Gdx = new f.a((byte)0);
    AppMethodBeat.o(216459);
  }
  
  public f(Context paramContext, com.tencent.mm.plugin.textstatus.a.n paramn)
  {
    AppMethodBeat.i(216457);
    this.FYA = paramn;
    paramn = LayoutInflater.from(paramContext).inflate(2131496677, null, false);
    p.g(paramn, "LayoutInflater.from(cont…tus_card_ui, null, false)");
    this.tlx = paramn;
    this.mContext = paramContext;
    this.FYf = "";
    paramContext = e.FYH;
    this.Gdv = e.a(this.FYA);
    this.Gdv.ba(this.tlx);
    this.FYd = ((TextView)this.tlx.findViewById(2131309533));
    this.FYg = ((TextView)this.tlx.findViewById(2131309519));
    this.FYe = ((TextView)this.tlx.findViewById(2131309471));
    this.FYj = ((TextView)this.tlx.findViewById(2131309512));
    this.GcJ = ((ImageView)this.tlx.findViewById(2131297834));
    paramContext = this.tlx.findViewById(2131297836);
    p.g(paramContext, "cardView.findViewById(R.id.btn_like)");
    this.FYo = ((ImageView)paramContext);
    this.FYp = ((ImageView)this.tlx.findViewById(2131302508));
    paramContext = this.tlx.findViewById(2131309500);
    p.g(paramContext, "cardView.findViewById(R.id.tv_like_num)");
    this.FYq = ((TextView)paramContext);
    this.FYh = ((ImageView)this.tlx.findViewById(2131309661));
    this.Gdw = this.tlx.findViewById(2131302900);
    this.Gcu = ((FrameLayout)this.tlx.findViewById(2131303103));
    int i = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12.0F);
    paramContext = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    com.tencent.mm.plugin.textstatus.j.f.B(this.tlx, i);
    paramContext = com.tencent.mm.plugin.fts.a.d.Nj(1);
    p.g(paramContext, "FTSApiLogic.getUnsignedM…atus.SessionScene.NORMAL)");
    this.sessionId = paramContext;
    this.UsP = "";
    AppMethodBeat.o(216457);
  }
  
  private void PF()
  {
    AppMethodBeat.i(216452);
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).fwU();
        AppMethodBeat.o(216452);
        return;
      }
    }
    AppMethodBeat.o(216452);
  }
  
  @SuppressLint({"ResourceType"})
  private final void aDj(String paramString)
  {
    AppMethodBeat.i(216445);
    this.username = paramString;
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    this.FYx = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    a(paramString, this.FYx);
    AppMethodBeat.o(216445);
  }
  
  private void fwi()
  {
    AppMethodBeat.i(216454);
    Object localObject = this.FYx;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_MediaThumbUrl;
      localObject = (CharSequence)localObject;
      if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.FYx;
        if ((localObject == null) || (((com.tencent.mm.plugin.textstatus.f.f.a)localObject).fvV() != true)) {
          break label98;
        }
      }
      localObject = this.Gdw;
      if (localObject == null) {
        break label91;
      }
      ((View)localObject).setVisibility(8);
      AppMethodBeat.o(216454);
      return;
      localObject = null;
      break;
    }
    label91:
    AppMethodBeat.o(216454);
    return;
    label98:
    localObject = this.Gdw;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(216454);
      return;
    }
    AppMethodBeat.o(216454);
  }
  
  private void fwm()
  {
    AppMethodBeat.i(216451);
    String str = this.username;
    if (str == null)
    {
      AppMethodBeat.o(216451);
      return;
    }
    com.tencent.mm.plugin.textstatus.f.f.a locala = this.FYx;
    if (locala == null)
    {
      AppMethodBeat.o(216451);
      return;
    }
    if ((locala.field_MediaType == 2) && (this.FYA.abM(16)))
    {
      Object localObject1 = this.Gcu;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).removeAllViews();
      }
      MMTPRecyclerVideoLayout localMMTPRecyclerVideoLayout = new MMTPRecyclerVideoLayout(this.mContext);
      localMMTPRecyclerVideoLayout.fxf();
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject1).gravity = 17;
      Object localObject2 = this.Gcu;
      if (localObject2 != null) {
        ((FrameLayout)localObject2).addView((View)localMMTPRecyclerVideoLayout, (ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.Gcu;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setVisibility(0);
      }
      if (locala.field_MediaUrl != null)
      {
        localObject1 = locala.field_MediaUrl;
        p.g(localObject1, "info.field_MediaUrl");
        localObject2 = kotlin.n.d.UTF_8;
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(216451);
          throw ((Throwable)localObject1);
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject2 = com.tencent.xweb.util.d.getMessageDigest((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      if (locala.field_MediaUrl != null)
      {
        localObject3 = locala.field_MediaUrl;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Object localObject3 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject3 = com.tencent.mm.plugin.textstatus.j.a.lf("video", str);
      int j = locala.field_mediaWidth;
      int k = locala.field_mediaHeight;
      int i;
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        j = ah.jS(this.mContext).width;
        i = ah.jS(this.mContext).height;
      }
      localObject1 = new com.tencent.mm.plugin.thumbplayer.d.a((String)localObject1, (String)localObject3, (String)localObject2, j, i);
      if (s.YS((String)localObject3)) {
        ((com.tencent.mm.plugin.thumbplayer.d.a)localObject1).dLQ = true;
      }
      localMMTPRecyclerVideoLayout.setMediaInfo((com.tencent.mm.plugin.thumbplayer.d.a)localObject1);
      localObject1 = localMMTPRecyclerVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).wcA = true;
      }
      localObject1 = localMMTPRecyclerVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).fwW();
      }
      localObject1 = localMMTPRecyclerVideoLayout.getPlayer();
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setLoop(true);
      }
      if (locala.fvV()) {
        localMMTPRecyclerVideoLayout.getEffector().fwM();
      }
      this.AuG = localMMTPRecyclerVideoLayout;
      PF();
      AppMethodBeat.o(216451);
      return;
    }
    fwn();
    AppMethodBeat.o(216451);
  }
  
  private void fwn()
  {
    AppMethodBeat.i(216453);
    Object localObject = this.Gcu;
    if (localObject != null) {
      ((FrameLayout)localObject).removeAllViews();
    }
    localObject = this.Gcu;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(8);
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
      }
    }
    localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
        AppMethodBeat.o(216453);
        return;
      }
    }
    AppMethodBeat.o(216453);
  }
  
  public final void DV(String paramString)
  {
    AppMethodBeat.i(216447);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (kotlin.n.n.aL(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216447);
      return;
    }
    new k.e(paramString, (j)this);
    aDj(paramString);
    AppMethodBeat.o(216447);
  }
  
  public final void a(com.tencent.mm.plugin.textstatus.a.f.a parama)
  {
    this.FXT = parama;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.textstatus.f.f.a parama)
  {
    AppMethodBeat.i(216446);
    p.h(paramString, "username");
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    ((SecDataUIC)com.tencent.mm.ui.component.a.ko(this.mContext).get(SecDataUIC.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(y.class, 9, (byte)0));
    localObject = SecDataUIC.CWq;
    localObject = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
    if (localObject != null)
    {
      ((y)localObject).sessionId = this.sessionId;
      ((y)localObject).username = paramString;
      ((y)localObject).UrY = this.FYA.scene;
    }
    if (!this.Gdv.b(paramString, parama))
    {
      this.tlx.setVisibility(8);
      AppMethodBeat.o(216446);
      return;
    }
    this.tlx.setVisibility(0);
    try
    {
      fwm();
      label142:
      fwi();
      this.tlx.setOnClickListener((View.OnClickListener)this);
      paramString = SecDataUIC.CWq;
      paramString = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
      if (paramString != null)
      {
        if (TextUtils.equals((CharSequence)paramString.sessionId, (CharSequence)this.UsP))
        {
          AppMethodBeat.o(216446);
          return;
        }
        parama = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.a(1L, paramString);
        paramString = paramString.sessionId;
        p.g(paramString, "it.sessionId");
        this.UsP = paramString;
        AppMethodBeat.o(216446);
        return;
      }
      AppMethodBeat.o(216446);
      return;
    }
    catch (Throwable paramString)
    {
      break label142;
    }
  }
  
  public final void cd(float paramFloat) {}
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    this.dec = paramOnClickListener;
  }
  
  public final void fvv()
  {
    AppMethodBeat.i(216448);
    com.tencent.e.f.h.hkS();
    fwn();
    AppMethodBeat.o(216448);
  }
  
  public final void fvw()
  {
    AppMethodBeat.i(216449);
    com.tencent.e.f.h.hkS();
    PF();
    AppMethodBeat.o(216449);
  }
  
  public final void fvx()
  {
    AppMethodBeat.i(216450);
    com.tencent.e.f.h.hkS();
    Object localObject = this.AuG;
    if (localObject != null)
    {
      localObject = ((MMTPRecyclerVideoLayout)localObject).getPlayer();
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).pause();
        AppMethodBeat.o(216450);
        return;
      }
    }
    AppMethodBeat.o(216450);
  }
  
  public final View getView()
  {
    return this.tlx;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216455);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = this.dec;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label99;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216455);
      return;
      paramView = null;
      break;
      label99:
      if (paramView.intValue() == 2131309012)
      {
        if (this.FYA.scene == 6)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusCardView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216455);
          return;
        }
        paramView = new Intent();
        paramView.putExtra("Contact_User", this.username);
        paramView.putExtra("CONTACT_INFO_UI_SOURCE", 2);
        com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", paramView, 213);
        paramView = SecDataUIC.CWq;
        paramView = (y)SecDataUIC.a.a(this.mContext, 9, y.class);
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.a(22L, paramView);
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216456);
    boolean bool;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.b))
    {
      com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.b)paramq).getType(), (i)this);
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
      AppMethodBeat.o(216456);
      return;
      label86:
      com.tencent.mm.ui.base.h.X(this.mContext, this.mContext.getString(2131766714), "");
    }
    AppMethodBeat.o(216456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.f
 * JD-Core Version:    0.7.0.1
 */