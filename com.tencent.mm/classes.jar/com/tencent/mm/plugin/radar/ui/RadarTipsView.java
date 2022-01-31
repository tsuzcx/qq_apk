package com.tencent.mm.plugin.radar.ui;

import a.b;
import a.c;
import a.d.a.a;
import a.d.b.g;
import a.d.b.h;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class RadarTipsView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.RadarTipsView";
  private static final int nnl = 3;
  private static final int nnm = 0;
  static final int nnn = 1;
  static final int nno = 2;
  private static final int nnp = 3;
  public static final RadarTipsView.a nnq = new RadarTipsView.a((byte)0);
  private final RadarTipsView.b nmR = new RadarTipsView.b(this);
  private final b nmS = c.f((a)new RadarTipsView.d(this));
  private final b nmT = c.f((a)new e(this));
  private final b nmU = i.N(this, a.c.radar_tips_tv);
  private final b nmV = i.N(this, a.c.radar_text_tips);
  private final b nmW = i.N(this, a.c.radar_user_education_tips);
  private final int nmX;
  final int nmY = 1;
  final int nmZ = 2;
  private final int nna = 3;
  private final int nnb = 3;
  final f nnc = new f(this, Looper.getMainLooper());
  boolean nnd;
  private boolean nne = true;
  boolean nnf;
  boolean nng;
  private int nnh;
  private long nni;
  private boolean nnj;
  int nnk = nnm;
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RadarTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void buQ()
  {
    this.nnd = false;
    f localf = this.nnc;
    localf.removeMessages(this.nmY);
    localf.removeMessages(this.nmZ);
    localf.removeMessages(this.nna);
  }
  
  private void ck(String paramString, int paramInt)
  {
    g.k(paramString, "msg");
    this.nnd = true;
    getNoviceEducationTips().setVisibility(8);
    getNoviceEducationTips().clearAnimation();
    getTvTextTips().setText((CharSequence)paramString);
    setVisibility(0);
    getTextTipsContainer().setVisibility(0);
    getTextTipsContainer().startAnimation(getTipsFadeIn());
    this.nnc.removeMessages(this.nmX);
    this.nnc.removeMessages(this.nmZ);
    if (paramInt > 0) {
      this.nnc.sendEmptyMessageDelayed(this.nmX, paramInt);
    }
  }
  
  private final Animation getTipsFadeOut()
  {
    return (Animation)this.nmT.getValue();
  }
  
  private final TextView getTvTextTips()
  {
    return (TextView)this.nmU.getValue();
  }
  
  private final void setPressing(boolean paramBoolean)
  {
    this.nng = paramBoolean;
  }
  
  public final void Lz(String paramString)
  {
    g.k(paramString, "msg");
    this.nnk = nnp;
    ck(paramString, 5000);
  }
  
  public final void buO()
  {
    this.nnd = false;
    this.nnk = nnm;
    y.d(TAG, "hidNoviceEducation");
    this.nnc.removeMessages(this.nna);
    if ((getVisibility() == 0) && (getNoviceEducationTips().getVisibility() == 0))
    {
      getNoviceEducationTips().clearAnimation();
      if (getTextTipsContainer().getAnimation() == getTipsFadeOut()) {
        getTextTipsContainer().clearAnimation();
      }
      y.d(TAG, "hideNoviceEducation real");
      getNoviceEducationTips().startAnimation(getTipsFadeOut());
    }
  }
  
  public final void buP()
  {
    y.d(TAG, "hideRadarTips");
    if ((getVisibility() == 0) && (getTextTipsContainer().getVisibility() == 0))
    {
      if (getNoviceEducationTips().getAnimation() == getTipsFadeOut()) {
        getNoviceEducationTips().clearAnimation();
      }
      getTextTipsContainer().clearAnimation();
      y.d(TAG, "hideRadarTips real");
      this.nnk = nnm;
      this.nnd = false;
      getTextTipsContainer().startAnimation(getTipsFadeOut());
    }
  }
  
  final LinearLayout getNoviceEducationTips()
  {
    return (LinearLayout)this.nmW.getValue();
  }
  
  final View getTextTipsContainer()
  {
    return (View)this.nmV.getValue();
  }
  
  final Animation getTipsFadeIn()
  {
    return (Animation)this.nmS.getValue();
  }
  
  public final void setNoMember(boolean paramBoolean)
  {
    this.nne = paramBoolean;
    if (!this.nne)
    {
      buP();
      buQ();
      buO();
    }
  }
  
  public final void setPressingDown(boolean paramBoolean)
  {
    if (this.nni != 0L)
    {
      this.nnk = nnm;
      buQ();
      buP();
      getTextTipsContainer().setVisibility(8);
      getNoviceEducationTips().setVisibility(8);
      setVisibility(8);
    }
    this.nng = true;
    this.nni = bk.UZ();
    this.nnj = paramBoolean;
    this.nnh += 1;
  }
  
  static final class e
    extends h
    implements a<Animation>
  {
    e(RadarTipsView paramRadarTipsView)
    {
      super();
    }
  }
  
  public static final class f
    extends ah
  {
    f(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      g.k(paramMessage, "msg");
      int i = paramMessage.what;
      if (i == RadarTipsView.c(this.nnr)) {
        this.nnr.buP();
      }
      do
      {
        do
        {
          return;
          if (i != RadarTipsView.d(this.nnr)) {
            break;
          }
        } while ((!RadarTipsView.e(this.nnr)) || (!this.nnr.nng));
        RadarTipsView.a(this.nnr, a.f.radar_tips_nomember);
        return;
        if (i == RadarTipsView.f(this.nnr))
        {
          paramMessage = this.nnr;
          paramMessage.nnd = true;
          RadarTipsView.a locala = RadarTipsView.nnq;
          paramMessage.nnk = RadarTipsView.nno;
          locala = RadarTipsView.nnq;
          y.d(RadarTipsView.access$getTAG$cp(), "showNoviceEducation");
          paramMessage.nnf = true;
          paramMessage.getTextTipsContainer().setVisibility(8);
          paramMessage.getTextTipsContainer().clearAnimation();
          paramMessage.setVisibility(0);
          paramMessage.getNoviceEducationTips().setVisibility(0);
          paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
          paramMessage.getNoviceEducationTips().requestFocus();
          return;
        }
      } while (i != RadarTipsView.g(this.nnr));
      this.nnr.buO();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView
 * JD-Core Version:    0.7.0.1
 */