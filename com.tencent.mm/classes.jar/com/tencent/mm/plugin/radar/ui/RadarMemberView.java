package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.d.b.o;
import a.h.e;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.a.c;
import java.util.Arrays;

public final class RadarMemberView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarMemberView";
  private static final int nme = 0;
  private static final int nmf = 1;
  public static final RadarMemberView.a nmg = new RadarMemberView.a((byte)0);
  private ad dnp;
  private View feu;
  private c few;
  private TextView kCv;
  private EditText nge;
  private View nlN;
  private final b nlO = i.N(this, a.c.radar_popup_holder);
  private final b nlP = i.N(this, a.c.radar_avatar_copy_iv);
  private final b nlQ = i.N(this, a.c.radar_avatar_container);
  private final b nlR = i.N(this, a.c.radar_confirm_btn);
  private final b nlS = i.N(this, a.c.radar_confirm_btn_disabled);
  private final b nlT = i.N(this, a.c.radar_member_nickname);
  private final b nlU = i.N(this, a.c.radar_member_modify_name);
  private final b nlV = i.N(this, a.c.radar_say_hi);
  private int[] nlW;
  private final b nlX = i.N(this, a.c.expose_radar_user);
  private boolean nlY;
  private bv nlZ;
  private bio nlt;
  private c.e nlu;
  private RadarMemberView.b nma;
  private final View.OnClickListener nmb = (View.OnClickListener)new RadarMemberView.h(this);
  private final RadarMemberView.d nmc = new RadarMemberView.d(this);
  private TextView nmd;
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarMemberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(c.e parame)
  {
    getExposeTv().setVisibility(0);
    if (parame == null) {
      return;
    }
    switch (c.fHS[parame.ordinal()])
    {
    default: 
      return;
    case 1: 
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtn().setText(a.f.radar_send_verify);
      getConfirmBtn().setVisibility(0);
      getConfirmBtnDisabled().setVisibility(8);
      getSayHiTv().setVisibility(8);
      return;
    case 2: 
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.f.radar_waiting_for_verify);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      return;
    case 3: 
      getMemberNameTv().setVisibility(0);
      getModifyNameBtn().setVisibility(0);
      getConfirmBtnDisabled().setText(a.f.radar_already_added);
      getConfirmBtn().setVisibility(8);
      getConfirmBtnDisabled().setVisibility(0);
      getSayHiTv().setVisibility(8);
      return;
    }
    getMemberNameTv().setVisibility(0);
    getModifyNameBtn().setVisibility(0);
    getConfirmBtn().setText(a.f.radar_add_friend);
    getConfirmBtn().setVisibility(0);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setText((CharSequence)getContext().getString(a.f.radar_say_hi));
    getSayHiTv().setVisibility(0);
  }
  
  private final ImageView getAvatarCopy()
  {
    return (ImageView)this.nlP.getValue();
  }
  
  private final View getAvatarCopyContainer()
  {
    return (View)this.nlQ.getValue();
  }
  
  private final View getAvatarHolder()
  {
    return (View)this.nlO.getValue();
  }
  
  private final Button getConfirmBtn()
  {
    return (Button)this.nlR.getValue();
  }
  
  private final TextView getConfirmBtnDisabled()
  {
    return (TextView)this.nlS.getValue();
  }
  
  private final TextView getExposeTv()
  {
    return (TextView)this.nlX.getValue();
  }
  
  private final TextView getMemberNameTv()
  {
    return (TextView)this.nlT.getValue();
  }
  
  private final Button getModifyNameBtn()
  {
    return (Button)this.nlU.getValue();
  }
  
  private final TextView getSayHiTv()
  {
    return (TextView)this.nlV.getValue();
  }
  
  private final void reset()
  {
    getAvatarCopyContainer().setVisibility(8);
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
  }
  
  public final void a(View paramView, bio parambio, c.e parame)
  {
    a.d.b.g.k(paramView, "view");
    a.d.b.g.k(parambio, "member");
    y.d(TAG, "popup");
    this.nlu = parame;
    this.nlt = parambio;
    parame = getConfirmBtn();
    if (parame != null) {
      parame.setOnClickListener((View.OnClickListener)new RadarMemberView.e(this, parambio));
    }
    getModifyNameBtn().setOnClickListener(this.nmb);
    setOnTouchListener((View.OnTouchListener)new RadarMemberView.f(this));
    getExposeTv().setOnClickListener((View.OnClickListener)new g(this));
    parame = g.nnt;
    parame = g.b(parambio);
    if (!e.X((CharSequence)parame))
    {
      localObject = com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.d.b.g.j(localObject, "service(IMessengerStorage::class.java)");
      this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).Fw().abl(parame);
    }
    Object localObject = this.dnp;
    if ((localObject != null) && (((ad)localObject).Bd() == true))
    {
      parame = this.dnp;
      if (parame != null)
      {
        parame = parame.vl();
        localObject = getMemberNameTv();
        if ((this.dnp == null) || (bk.bl(parame))) {
          break label599;
        }
      }
    }
    label599:
    for (parambio = (CharSequence)com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), (CharSequence)parame, getMemberNameTv().getTextSize());; parambio = (CharSequence)com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), (CharSequence)parambio.hRf, getMemberNameTv().getTextSize()))
    {
      ((TextView)localObject).setText(parambio);
      getMemberNameTv().setVisibility(4);
      getModifyNameBtn().setVisibility(4);
      reset();
      this.nlN = paramView;
      paramView = this.nlN;
      if (paramView == null) {
        a.d.b.g.cUk();
      }
      paramView = paramView.findViewById(a.c.radar_result_item_avatar_iv);
      a.d.b.g.j(paramView, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
      parambio = (ImageView)paramView;
      paramView = this.nlN;
      if (paramView == null) {
        a.d.b.g.cUk();
      }
      paramView = paramView.findViewById(a.c.radar_avatar_container);
      a.d.b.g.j(paramView, "avatarItem!!.findViewByI…d.radar_avatar_container)");
      parame = this.nlN;
      if (parame == null) {
        a.d.b.g.cUk();
      }
      parame.setVisibility(4);
      getAvatarCopy().setImageDrawable(parambio.getDrawable());
      getAvatarCopyContainer().setVisibility(0);
      parame = new int[2];
      paramView.getLocationInWindow(parame);
      localObject = new int[2];
      getAvatarHolder().getLocationInWindow((int[])localObject);
      this.nlW = ((int[])localObject);
      setVisibility(0);
      parambio = new AnimationSet(true);
      parambio.setFillAfter(true);
      parambio.setRepeatCount(1);
      parambio.setDuration(500L);
      float f1 = getAvatarHolder().getHeight() / paramView.getHeight();
      float f2 = (paramView.getWidth() - paramView.getHeight()) / 2;
      paramView = new TranslateAnimation(parame[0], localObject[0] - f2 * f1, parame[1], localObject[1]);
      parambio.addAnimation((Animation)new ScaleAnimation(1.0F, f1, 1.0F, f1));
      parambio.addAnimation((Animation)paramView);
      parambio.setAnimationListener((Animation.AnimationListener)new RadarMemberView.i(this));
      getAvatarCopyContainer().startAnimation((Animation)parambio);
      return;
      parame = null;
      break;
      localObject = com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class);
      a.d.b.g.j(localObject, "service(IMessengerStorage::class.java)");
      this.nlZ = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).Fx().Id(parame);
      parame = this.nlZ;
      if (parame != null)
      {
        parame = parame.vl();
        break;
      }
      parame = null;
      break;
    }
  }
  
  public final void c(String paramString, c.e parame)
  {
    Object localObject2 = null;
    a.d.b.g.k(paramString, "username");
    a.d.b.g.k(parame, "state");
    if ((!isShowing()) || (this.nlY)) {
      return;
    }
    Object localObject1 = this.nlt;
    if (localObject1 != null) {}
    for (localObject1 = ((bio)localObject1).sUr;; localObject1 = null)
    {
      if (!a.d.b.g.e(paramString, localObject1))
      {
        bio localbio = this.nlt;
        localObject1 = localObject2;
        if (localbio != null) {
          localObject1 = localbio.hPY;
        }
        if (!a.d.b.g.e(paramString, localObject1)) {
          break;
        }
      }
      a(parame);
      return;
    }
  }
  
  public final void dismiss()
  {
    y.d(TAG, "dismiss");
    if (this.nlY) {
      return;
    }
    this.nlY = true;
    Object localObject1 = this.nlN;
    if (localObject1 == null) {
      a.d.b.g.cUk();
    }
    Object localObject2 = ((View)localObject1).findViewById(a.c.radar_avatar_container);
    a.d.b.g.j(localObject2, "avatarItem!!.findViewByI…d.radar_avatar_container)");
    localObject1 = new AnimationSet(true);
    ((AnimationSet)localObject1).setFillAfter(true);
    ((AnimationSet)localObject1).setRepeatCount(1);
    ((AnimationSet)localObject1).setDuration(500L);
    int[] arrayOfInt1 = this.nlW;
    int[] arrayOfInt2 = new int[2];
    ((View)localObject2).getLocationInWindow(arrayOfInt2);
    float f1 = getAvatarHolder().getHeight() / ((View)localObject2).getHeight();
    float f2 = (((View)localObject2).getWidth() - ((View)localObject2).getHeight()) / 2;
    if (arrayOfInt1 == null) {
      a.d.b.g.cUk();
    }
    localObject2 = new TranslateAnimation(arrayOfInt1[0] - f2 * f1, arrayOfInt2[0], arrayOfInt1[1], arrayOfInt2[1]);
    ((AnimationSet)localObject1).addAnimation((Animation)new ScaleAnimation(f1, 1.0F, f1, 1.0F));
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).setAnimationListener((Animation.AnimationListener)new RadarMemberView.c(this));
    getMemberNameTv().setVisibility(4);
    getModifyNameBtn().setVisibility(4);
    getConfirmBtn().setVisibility(8);
    getConfirmBtnDisabled().setVisibility(8);
    getSayHiTv().setVisibility(8);
    getExposeTv().setVisibility(8);
    getAvatarCopyContainer().startAnimation((Animation)localObject1);
  }
  
  public final bio getMember()
  {
    return this.nlt;
  }
  
  public final c.e getState()
  {
    return this.nlu;
  }
  
  public final boolean isShowing()
  {
    return getVisibility() == 0;
  }
  
  public final void setListener(RadarMemberView.b paramb)
  {
    a.d.b.g.k(paramb, "listener");
    this.nma = paramb;
  }
  
  public final void setMember(bio parambio)
  {
    this.nlt = parambio;
  }
  
  public final void setState(c.e parame)
  {
    this.nlu = parame;
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(RadarMemberView paramRadarMemberView) {}
    
    public final void onClick(View paramView)
    {
      Intent localIntent = new Intent();
      paramView = RadarMemberView.c(this.nmh);
      if (paramView != null) {}
      for (paramView = paramView.getUsername();; paramView = null)
      {
        localIntent.putExtra("k_username", paramView);
        localIntent.putExtra("showShare", false);
        paramView = o.xoy;
        paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
        a.d.b.g.j(paramView, "java.lang.String.format(format, *args)");
        localIntent.putExtra("rawUrl", paramView);
        d.b(this.nmh.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView
 * JD-Core Version:    0.7.0.1
 */