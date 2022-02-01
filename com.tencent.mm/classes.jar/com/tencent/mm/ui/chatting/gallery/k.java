package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class k
{
  int Dzs;
  public b.b PAD;
  public HashMap<String, Boolean> PAE;
  public RelativeLayout PAF;
  public com.tencent.mm.pluginsdk.ui.tools.j PAG;
  public ImageView PAH;
  public ImageView PAI;
  public MMPinProgressBtn PAJ;
  public View PAK;
  public RelativeLayout PAL;
  public ImageView PAM;
  public ImageView PAN;
  public com.tencent.mm.pluginsdk.ui.tools.j PAO;
  public MMPinProgressBtn PAP;
  public TextView PAQ;
  public RelativeLayout PAR;
  public TextView PAS;
  public LinearLayout PAT;
  public TextView PAU;
  public TextView PAV;
  public ImageView PAW;
  public ProgressBar PAX;
  public ProgressBar PAY;
  public LinearLayout PAZ;
  public TextView PBa;
  public ImageView PBb;
  public MultiTouchImageView PBc;
  public WxImageView PBd;
  public boolean PBe;
  int PBf;
  int PBg;
  public b PwU;
  public View convertView;
  long createTime;
  String dRL;
  String fileId;
  public int mPosition;
  public TextView thO;
  
  @TargetApi(11)
  public k(b paramb, View paramView)
  {
    AppMethodBeat.i(36331);
    this.PAE = new HashMap();
    this.Dzs = 0;
    this.PBf = 0;
    this.PBg = 0;
    this.dRL = "";
    this.convertView = paramView;
    this.PwU = paramb;
    this.PBc = ((MultiTouchImageView)paramView.findViewById(2131302526));
    this.PBd = ((WxImageView)paramView.findViewById(2131310633));
    this.PAY = ((ProgressBar)paramView.findViewById(2131302561));
    if (this.PBd != null) {
      this.PBd.setForceTileFlag(c.hjT);
    }
    AppMethodBeat.o(36331);
  }
  
  public static void ai(View paramView, int paramInt)
  {
    AppMethodBeat.i(36332);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36332);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    this.Dzs = paramInt1;
    this.PBf = paramInt2;
    this.PBg = paramInt3;
    this.dRL = paramString1;
    this.fileId = paramString2;
    this.createTime = paramLong;
  }
  
  public final void d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(36337);
    Log.i("MicroMsg.ImageGalleryViewHolder", "%d switch video model isVideoPlay[%b] alpha[%f]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat) });
    if (paramBoolean)
    {
      View localView = (View)gTe().PAO;
      localView.setAlpha(paramFloat);
      ai(localView, 0);
      if (paramFloat >= 1.0D)
      {
        ai(gTe().PAM, 8);
        ai(gTe().PAN, 8);
      }
      AppMethodBeat.o(36337);
      return;
    }
    ai((View)gTe().PAO, 8);
    ai(gTe().PAM, 0);
    ai(gTe().PAN, 0);
    AppMethodBeat.o(36337);
  }
  
  public final k gTb()
  {
    AppMethodBeat.i(36333);
    if (this.PAT == null)
    {
      this.PAT = ((LinearLayout)((ViewStub)this.convertView.findViewById(2131302564)).inflate());
      this.PAX = ((ProgressBar)this.PAT.findViewById(2131299794));
      this.PAU = ((TextView)this.PAT.findViewById(2131299795));
      this.PAV = ((TextView)this.PAT.findViewById(2131299793));
      this.PAW = ((ImageView)this.PAT.findViewById(2131299796));
    }
    AppMethodBeat.o(36333);
    return this;
  }
  
  public final k gTc()
  {
    AppMethodBeat.i(36334);
    if (this.PAZ == null)
    {
      this.PAZ = ((LinearLayout)((ViewStub)this.convertView.findViewById(2131302562)).inflate());
      this.PBb = ((ImageView)this.PAZ.findViewById(2131299761));
      this.PBa = ((TextView)this.PAZ.findViewById(2131299762));
    }
    AppMethodBeat.o(36334);
    return this;
  }
  
  public final k gTd()
  {
    AppMethodBeat.i(36335);
    if (this.PAF == null)
    {
      this.PAF = ((RelativeLayout)((ViewStub)this.convertView.findViewById(2131307899)).inflate());
      this.PAG = v.iE(this.convertView.getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      this.PAF.addView((View)this.PAG, localLayoutParams);
      ((View)this.PAG).setVisibility(8);
      this.PAK = this.PAF.findViewById(2131309187);
      this.PAK.setVisibility(8);
      this.thO = ((TextView)this.PAF.findViewById(2131307859));
      this.PAJ = ((MMPinProgressBtn)this.PAF.findViewById(2131307888));
      this.PAJ.setVisibility(8);
      this.PAH = ((ImageView)this.PAF.findViewById(2131307895));
      this.PAI = ((ImageView)this.PAF.findViewById(2131309845));
      this.PAG.setVideoCallback(new k.1(this));
      this.thO.setOnClickListener(new k.2(this));
    }
    AppMethodBeat.o(36335);
    return this;
  }
  
  public final k gTe()
  {
    AppMethodBeat.i(36336);
    if (this.PAL == null)
    {
      if (this.PBd != null) {
        this.PBd.setVisibility(8);
      }
      if (this.PBc != null) {
        this.PBc.setVisibility(8);
      }
      this.PAL = ((RelativeLayout)((ViewStub)this.convertView.findViewById(2131309821)).inflate());
      this.PAM = ((ImageView)this.PAL.findViewById(2131309773));
      this.PAN = ((ImageView)this.PAL.findViewById(2131309844));
      this.PAN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(36323);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (k.this.PwU != null)
          {
            Log.i("MicroMsg.ImageGalleryViewHolder", "%d video wait play on click, play video %d", new Object[] { Integer.valueOf(k.this.hashCode()), Integer.valueOf(k.this.mPosition) });
            k.this.PwU.amS(k.this.mPosition);
          }
          a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36323);
        }
      });
      e.baZ();
      if (!e.bbm()) {
        break label309;
      }
      this.PAO = new VideoPlayerTextureView(this.convertView.getContext());
      h.CyF.idkeyStat(354L, 150L, 1L, false);
    }
    for (;;)
    {
      this.PAQ = ((TextView)this.convertView.findViewById(2131299433));
      this.PAO.setPlayProgressCallback(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.PAL.addView((View)this.PAO, 1, localLayoutParams);
      this.PAP = ((MMPinProgressBtn)this.PAL.findViewById(2131309753));
      this.PAP.setVisibility(8);
      ((View)this.PAO).setVisibility(8);
      this.PAR = ((RelativeLayout)this.convertView.findViewById(2131309763));
      this.PAS = ((TextView)this.convertView.findViewById(2131309764));
      this.PAO.setVideoCallback(new j.a()
      {
        public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fh(final int paramAnonymousInt1, final int paramAnonymousInt2)
        {
          AppMethodBeat.i(36329);
          Log.i("MicroMsg.ImageGalleryViewHolder", "dkvideo onplaytime:%d total:%d,%d size:%d cnt:%d user:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(k.this.Dzs), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(k.this.PBf), Integer.valueOf(k.this.PBg), k.this.dRL });
          bg.aAk().postToWorker(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36325);
              h localh = h.CyF;
              int j = k.this.PBf;
              if (paramAnonymousInt2 <= 0) {}
              for (int i = k.this.Dzs * 1000;; i = paramAnonymousInt2)
              {
                localh.a(12084, new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(1), k.this.dRL, Integer.valueOf(k.this.PBg), k.this.fileId, Long.valueOf(k.this.createTime) });
                AppMethodBeat.o(36325);
                return;
              }
            }
          });
          AppMethodBeat.o(36329);
          return 0;
        }
        
        public final void onCompletion()
        {
          AppMethodBeat.i(36328);
          k.this.PwU.Pwv.PyB.i(k.this.PwU.gSg(), 7);
          k.this.PwU.Pwv.PyB.jpW = 4;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36324);
              k.this.PwU.Pwv.setVideoStateIv(true);
              b localb = k.this.PwU;
              int i = k.this.mPosition;
              localb.PwB.ank(i);
              k.this.PwU.PwB.gSX();
              AppMethodBeat.o(36324);
            }
          });
          AppMethodBeat.o(36328);
        }
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(36327);
          Log.w("MicroMsg.ImageGalleryViewHolder", "play video error what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          if (k.this.PwU != null) {
            k.this.PwU.PwB.lh(paramAnonymousInt1, paramAnonymousInt2);
          }
          k.this.PwU.Pwv.PyB.jpW = 4;
          k.this.PwU.Pwv.PyB.pLD = ("what : " + paramAnonymousInt1 + " extra: " + paramAnonymousInt2);
          h.CyF.a(12084, new Object[] { Integer.valueOf(k.this.PBf), Integer.valueOf(k.this.Dzs * 1000), Integer.valueOf(0), Integer.valueOf(4), k.this.dRL, Integer.valueOf(k.this.PBg), k.this.fileId, Long.valueOf(k.this.createTime) });
          AppMethodBeat.o(36327);
        }
        
        public final void tf()
        {
          AppMethodBeat.i(36326);
          if (k.this.PwU != null) {
            k.this.PwU.PwB.gSW();
          }
          AppMethodBeat.o(36326);
        }
      });
      AppMethodBeat.o(36336);
      return this;
      label309:
      this.PAO = new VideoTextureView(this.convertView.getContext());
      h.CyF.idkeyStat(354L, 151L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */