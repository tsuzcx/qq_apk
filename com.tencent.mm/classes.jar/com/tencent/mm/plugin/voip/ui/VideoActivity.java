package com.tencent.mm.plugin.voip.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.an;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import java.lang.ref.WeakReference;

@i
@com.tencent.mm.ui.base.a(3)
@SuppressLint({"SimpleDateFormat"})
public class VideoActivity
  extends MMActivity
  implements ServiceConnection, VoipBaseFragment.d, b
{
  private String eaX;
  private ak iMP;
  private boolean mIsMute;
  private int mStatus;
  private boolean moQ;
  private com.tencent.mm.sdk.b.c oPY;
  private Point rhc;
  private VoipBaseFragment tCb;
  private WeakReference<c> tCc;
  private long tCd;
  private long tCe;
  private boolean tCf;
  private int tCg;
  private boolean tCh;
  private boolean tCi;
  private boolean tCj;
  private VideoActivity.ScreenActionReceiver tCk;
  private byte[] tCl;
  private boolean tCm;
  a.a tCn;
  private com.tencent.mm.sdk.b.c tCo;
  private long tCp;
  private CaptureView txe;
  private ad txj;
  private boolean txk;
  private boolean txl;
  private int txp;
  
  public VideoActivity()
  {
    AppMethodBeat.i(4803);
    this.tCd = -1L;
    this.moQ = false;
    this.tCe = 0L;
    this.tCf = false;
    this.txp = 1;
    this.mIsMute = false;
    this.tCg = 1;
    this.tCh = false;
    this.tCi = false;
    this.tCj = false;
    this.tCm = false;
    this.tCo = new VideoActivity.1(this);
    this.oPY = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(4803);
  }
  
  private int bJG()
  {
    AppMethodBeat.i(4826);
    int i;
    if (com.tencent.mm.compatible.b.g.KC().KH())
    {
      i = com.tencent.mm.compatible.b.g.KC().KU();
      AppMethodBeat.o(4826);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.a.b.HQ(this.mStatus))
    {
      i = 2;
      if (this.txk) {
        if (!this.txl)
        {
          if (ac.erv.enk < 0) {
            break label214;
          }
          i = ac.erv.enk;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.compatible.b.g.KC().KH())
      {
        j = i;
        if (ac.erv.enm < 0) {}
      }
      for (j = ac.erv.enm;; j = com.tencent.mm.plugin.voip.b.cLC().cLL())
      {
        ab.i("MicroMsg.Voip.VideoActivity", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(4826);
        return j;
        i = 3;
        if (com.tencent.mm.compatible.b.g.KC().KN())
        {
          if (ac.erv.enk < 0) {
            break label214;
          }
          i = ac.erv.enk;
          break;
        }
        if (ac.erv.enh < 0) {
          break;
        }
        i = ac.erv.enh;
        break;
        if (!com.tencent.mm.compatible.b.g.KC().KN()) {
          break;
        }
        if (ac.erv.enk < 0) {
          break label214;
        }
        i = ac.erv.enk;
        break;
      }
      label214:
      i = 0;
    }
  }
  
  private static boolean bTr()
  {
    AppMethodBeat.i(4806);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)ah.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          continue;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        ab.e("MicroMsg.Voip.VideoActivity", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        ab.i("MicroMsg.Voip.VideoActivity", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(4806);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private void cMY()
  {
    AppMethodBeat.i(4807);
    this.iMP.postDelayed(new VideoActivity.8(this), 2000L);
    AppMethodBeat.o(4807);
  }
  
  private void cOT()
  {
    AppMethodBeat.i(4810);
    if ((this.tCc != null) && (this.tCc.get() != null) && (!this.txk))
    {
      if (!this.txl) {
        break label91;
      }
      ((c)this.tCc.get()).cML();
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.voip.b.cLC().cif) && (this.txl)) {
        ((c)this.tCc.get()).cMU();
      }
      AppMethodBeat.o(4810);
      return;
      label91:
      ((c)this.tCc.get()).cMO();
    }
  }
  
  public final void HF(int paramInt)
  {
    AppMethodBeat.i(4827);
    this.txp = paramInt;
    if (this.tCb != null) {
      this.tCb.HF(paramInt);
    }
    AppMethodBeat.o(4827);
  }
  
  public final void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(4837);
    this.tCf = paramBoolean2;
    if (paramBoolean1)
    {
      cMY();
      AppMethodBeat.o(4837);
      return;
    }
    finish();
    AppMethodBeat.o(4837);
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140173);
    if (this.tCb != null) {
      this.tCb.a(paramSurfaceTexture, paramInt);
    }
    AppMethodBeat.o(140173);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(4821);
    if (this.tCb != null) {
      this.tCb.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }
    AppMethodBeat.o(4821);
  }
  
  public final void aeH(String paramString)
  {
    AppMethodBeat.i(4824);
    if (this.tCb != null) {
      this.iMP.post(new VideoActivity.14(this, paramString));
    }
    AppMethodBeat.o(4824);
  }
  
  public final void bKF()
  {
    AppMethodBeat.i(4836);
    ab.d("MicroMsg.Voip.VideoActivity", "dismissNetStatusWarning");
    if (this.tCb != null) {
      this.tCb.cOV();
    }
    AppMethodBeat.o(4836);
  }
  
  public final void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(4823);
    ab.i("MicroMsg.Voip.VideoActivity", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.txl) });
    this.moQ = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.h.b(this, paramString, null, true);
      AppMethodBeat.o(4823);
      return;
    }
    this.iMP.post(new VideoActivity.13(this, paramInt));
    AppMethodBeat.o(4823);
  }
  
  public final void cNc()
  {
    AppMethodBeat.i(4830);
    if (this.tCb != null) {
      this.tCb.cNc();
    }
    AppMethodBeat.o(4830);
  }
  
  public final Context cOO()
  {
    AppMethodBeat.i(140176);
    AppCompatActivity localAppCompatActivity = getContext();
    AppMethodBeat.o(140176);
    return localAppCompatActivity;
  }
  
  public final void cOP()
  {
    AppMethodBeat.i(4839);
    if ((this.tCb instanceof VoipVideoFragment)) {
      ((VoipVideoFragment)this.tCb).cOP();
    }
    AppMethodBeat.o(4839);
  }
  
  public final void cOQ()
  {
    AppMethodBeat.i(140175);
    if (this.tCb != null) {
      this.tCb.cOQ();
    }
    AppMethodBeat.o(140175);
  }
  
  public final byte[] cOR()
  {
    AppMethodBeat.i(4822);
    if ((this.tCb != null) && (this.tCb.getFilterData() != null)) {
      this.tCb.getFilterData().a(new VideoActivity.11(this));
    }
    byte[] arrayOfByte = this.tCl;
    AppMethodBeat.o(4822);
    return arrayOfByte;
  }
  
  public final a.a cOS()
  {
    AppMethodBeat.i(140170);
    if ((this.tCb != null) && (this.tCb.cOU() != null)) {
      this.tCb.cOU().a(new VideoActivity.12(this));
    }
    a.a locala = this.tCn;
    AppMethodBeat.o(140170);
    return locala;
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(4825);
    af.h(af.a(getWindow(), null), getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(paramView, 0);
    AppMethodBeat.o(4825);
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140171);
    if (this.tCb != null) {
      this.tCb.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(140171);
  }
  
  public void finish()
  {
    AppMethodBeat.i(4814);
    this.tCg = 3;
    ab.i("MicroMsg.Voip.VideoActivity", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.tCf), com.tencent.mm.plugin.voip.a.b.HN(this.mStatus) });
    Object localObject;
    if ((!this.tCf) && (com.tencent.mm.plugin.voip.a.b.HQ(this.mStatus)) && (4 != this.tCg))
    {
      ab.i("MicroMsg.Voip.VideoActivity", "finish VideoActivity, start ChattingUI");
      localObject = new Intent();
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.eaX);
      com.tencent.mm.plugin.voip.c.gmO.d((Intent)localObject, this);
    }
    int i;
    if (this.tCm)
    {
      this.tCm = false;
      int j = com.tencent.mm.plugin.voip.b.cLC().cNU();
      long l = com.tencent.mm.plugin.voip.b.cLC().cNV();
      if (this.txk)
      {
        i = 0;
        com.tencent.mm.plugin.voip.a.a.c(j, l, i, 5);
        com.tencent.mm.plugin.voip.a.a.HL(1);
      }
    }
    else
    {
      if (this.tCb == null) {
        break label320;
      }
      if (this.tCb.tCx != 4105) {
        break label315;
      }
      i = 1;
      label186:
      this.tCb.uninit();
      this.tCb = null;
    }
    for (;;)
    {
      this.tCc = null;
      this.txe = null;
      this.tCi = true;
      super.finish();
      if (i != 0)
      {
        localObject = new ir();
        ((ir)localObject).cyf.cyi = true;
        ((ir)localObject).cyf.cyh = this.tCp;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      for (;;)
      {
        VoipBaseFragment.tCy = -1;
        AppMethodBeat.o(4814);
        return;
        i = 1;
        break;
        localObject = new ir();
        ((ir)localObject).cyf.cyi = false;
        ((ir)localObject).cyf.cyh = 0L;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      }
      label315:
      i = 0;
      break label186;
      label320:
      i = 0;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971109;
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140172);
    if (this.tCb != null) {
      this.tCb.gj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(140172);
  }
  
  public final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4808);
    this.mStatus = paramInt2;
    if ((1 != this.tCg) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      ab.i("MicroMsg.Voip.VideoActivity", "activity is not normal, can't transform");
      AppMethodBeat.o(4808);
      return;
    }
    if (this.tCb == null)
    {
      ab.i("MicroMsg.Voip.VideoActivity", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(4808);
      return;
    }
    this.tCb.gl(paramInt1, paramInt2);
    Object localObject;
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(4808);
      return;
    case 1: 
    case 3: 
    case 7: 
    case 257: 
    case 261: 
      this.txl = false;
      if ((this.tCb == null) || (!(this.tCb instanceof VoipVoiceFragment)))
      {
        if (this.tCb != null)
        {
          this.tCb.uninit();
          getSupportFragmentManager().beginTransaction().b(this.tCb).commit();
          this.tCb = null;
        }
        ab.i("MicroMsg.Voip.VideoActivity", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.txj.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.txk);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.tCb = new VoipVoiceFragment();
        this.tCb.setArguments((Bundle)localObject);
        this.tCb.setVoipUIListener((c)this.tCc.get());
        this.tCb.ng(this.tCd);
        this.tCb.a(this);
        this.tCb.HF(this.txp);
        this.tCb.setMute(this.mIsMute);
        this.tCb.a(this.txe);
        getSupportFragmentManager().beginTransaction().b(2131828834, this.tCb).commit();
      }
      AppMethodBeat.o(4808);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      cMY();
      break;
      if (this.txk)
      {
        localObject = this.tCb;
        if (!this.txl) {
          break label483;
        }
      }
      label483:
      for (paramInt1 = 2131304748;; paramInt1 = 2131304613)
      {
        ((VoipBaseFragment)localObject).gm(paramInt1, -1);
        cMY();
        break;
      }
      this.iMP.post(new VideoActivity.2(this));
      continue;
      this.iMP.post(new VideoActivity.3(this));
      continue;
      this.iMP.postDelayed(new VideoActivity.9(this), 50L);
      continue;
      cMY();
      continue;
      finish();
    }
  }
  
  public final void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(4835);
    ab.d("MicroMsg.Voip.VideoActivity", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.tCb != null) {
      this.tCb.mZ(paramBoolean);
    }
    AppMethodBeat.o(4835);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(4805);
    super.onConfigurationChanged(paramConfiguration);
    if ((this.rhc != null) && (d.fv(17)))
    {
      paramConfiguration = new Point();
      getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.rhc)) && (this.tCb != null))
      {
        this.rhc = paramConfiguration;
        this.tCb.cOW();
      }
    }
    AppMethodBeat.o(4805);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: sipush 4804
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 686	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   11: getstatic 692	com/tencent/mm/plugin/voip/model/s:tyN	Lcom/tencent/mm/plugin/voip/model/s;
    //   14: astore_1
    //   15: invokestatic 695	com/tencent/mm/plugin/voip/model/s:cNx	()V
    //   18: aload_0
    //   19: aload_0
    //   20: invokevirtual 699	com/tencent/mm/plugin/voip/ui/VideoActivity:getResources	()Landroid/content/res/Resources;
    //   23: ldc_w 700
    //   26: invokevirtual 706	android/content/res/Resources:getColor	(I)I
    //   29: invokevirtual 709	com/tencent/mm/plugin/voip/ui/VideoActivity:setActionbarColor	(I)V
    //   32: aload_0
    //   33: invokevirtual 373	com/tencent/mm/plugin/voip/ui/VideoActivity:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   36: invokestatic 715	com/tencent/mm/plugin/voip/a/d:fj	(Landroid/content/Context;)Z
    //   39: ifne +11 -> 50
    //   42: aload_0
    //   43: invokevirtual 373	com/tencent/mm/plugin/voip/ui/VideoActivity:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   46: invokestatic 718	com/tencent/mm/plugin/voip/a/d:fk	(Landroid/content/Context;)Z
    //   49: pop
    //   50: ldc 118
    //   52: ldc_w 720
    //   55: invokestatic 453	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: invokevirtual 724	com/tencent/mm/plugin/voip/ui/VideoActivity:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   62: invokevirtual 729	android/support/v7/app/ActionBar:hide	()V
    //   65: aload_0
    //   66: invokevirtual 416	com/tencent/mm/plugin/voip/ui/VideoActivity:getWindow	()Landroid/view/Window;
    //   69: iconst_3
    //   70: invokevirtual 732	android/view/Window:setSoftInputMode	(I)V
    //   73: aload_0
    //   74: invokevirtual 416	com/tencent/mm/plugin/voip/ui/VideoActivity:getWindow	()Landroid/view/Window;
    //   77: ldc_w 733
    //   80: invokevirtual 735	android/view/Window:addFlags	(I)V
    //   83: invokestatic 740	com/tencent/mm/kernel/g:RG	()Z
    //   86: ifeq +11 -> 97
    //   89: invokestatic 151	com/tencent/mm/plugin/voip/b:cLC	()Lcom/tencent/mm/plugin/voip/model/t;
    //   92: iconst_0
    //   93: iconst_0
    //   94: invokevirtual 743	com/tencent/mm/plugin/voip/model/t:S	(ZZ)V
    //   97: invokestatic 189	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   100: invokevirtual 746	com/tencent/mm/compatible/b/g:KE	()I
    //   103: pop
    //   104: aload_0
    //   105: new 283	com/tencent/mm/sdk/platformtools/ak
    //   108: dup
    //   109: invokespecial 747	com/tencent/mm/sdk/platformtools/ak:<init>	()V
    //   112: putfield 276	com/tencent/mm/plugin/voip/ui/VideoActivity:iMP	Lcom/tencent/mm/sdk/platformtools/ak;
    //   115: new 749	com/tencent/mm/pointers/PBool
    //   118: dup
    //   119: invokespecial 750	com/tencent/mm/pointers/PBool:<init>	()V
    //   122: astore_1
    //   123: new 749	com/tencent/mm/pointers/PBool
    //   126: dup
    //   127: invokespecial 750	com/tencent/mm/pointers/PBool:<init>	()V
    //   130: astore_3
    //   131: new 752	com/tencent/mm/pointers/PString
    //   134: dup
    //   135: invokespecial 753	com/tencent/mm/pointers/PString:<init>	()V
    //   138: astore 4
    //   140: new 755	com/tencent/mm/pointers/PInt
    //   143: dup
    //   144: invokespecial 756	com/tencent/mm/pointers/PInt:<init>	()V
    //   147: astore 5
    //   149: aload 4
    //   151: aload_0
    //   152: invokevirtual 760	com/tencent/mm/plugin/voip/ui/VideoActivity:getIntent	()Landroid/content/Intent;
    //   155: ldc_w 762
    //   158: invokevirtual 765	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   161: putfield 767	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   164: aload_1
    //   165: aload_0
    //   166: invokevirtual 760	com/tencent/mm/plugin/voip/ui/VideoActivity:getIntent	()Landroid/content/Intent;
    //   169: ldc_w 769
    //   172: iconst_1
    //   173: invokevirtual 773	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   176: putfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   179: aload_3
    //   180: aload_0
    //   181: invokevirtual 760	com/tencent/mm/plugin/voip/ui/VideoActivity:getIntent	()Landroid/content/Intent;
    //   184: ldc_w 777
    //   187: iconst_1
    //   188: invokevirtual 773	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   191: putfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   194: aload_0
    //   195: aload_0
    //   196: invokevirtual 760	com/tencent/mm/plugin/voip/ui/VideoActivity:getIntent	()Landroid/content/Intent;
    //   199: ldc_w 779
    //   202: lconst_0
    //   203: invokevirtual 783	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   206: putfield 518	com/tencent/mm/plugin/voip/ui/VideoActivity:tCp	J
    //   209: aload 5
    //   211: aload_1
    //   212: getfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   215: aload_3
    //   216: getfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   219: invokestatic 787	com/tencent/mm/plugin/voip/a/b:V	(ZZ)I
    //   222: putfield 789	com/tencent/mm/pointers/PInt:value	I
    //   225: aload_0
    //   226: aconst_null
    //   227: putfield 177	com/tencent/mm/plugin/voip/ui/VideoActivity:tCl	[B
    //   230: aload_1
    //   231: getfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   234: istore_2
    //   235: iload_2
    //   236: ifeq +56 -> 292
    //   239: invokestatic 791	com/tencent/mm/plugin/voip/ui/VideoActivity:bTr	()Z
    //   242: ifeq +50 -> 292
    //   245: aload_0
    //   246: invokevirtual 794	com/tencent/mm/plugin/voip/ui/VideoActivity:isFinishing	()Z
    //   249: ifne +43 -> 292
    //   252: aload_0
    //   253: ldc_w 795
    //   256: iconst_0
    //   257: invokestatic 801	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   260: invokevirtual 804	android/widget/Toast:show	()V
    //   263: ldc 118
    //   265: ldc_w 806
    //   268: invokestatic 453	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: invokespecial 504	com/tencent/mm/ui/MMActivity:finish	()V
    //   275: sipush 4804
    //   278: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: astore 6
    //   284: ldc 118
    //   286: ldc_w 808
    //   289: invokestatic 810	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: invokestatic 151	com/tencent/mm/plugin/voip/b:cLC	()Lcom/tencent/mm/plugin/voip/model/t;
    //   295: aload_0
    //   296: aload 4
    //   298: aload_1
    //   299: aload_3
    //   300: aload 5
    //   302: invokevirtual 813	com/tencent/mm/plugin/voip/model/t:a	(Landroid/content/Context;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PBool;Lcom/tencent/mm/pointers/PBool;Lcom/tencent/mm/pointers/PInt;)Lcom/tencent/mm/plugin/voip/model/VoipMgr;
    //   305: astore 6
    //   307: aload 6
    //   309: ifnonnull +22 -> 331
    //   312: ldc 118
    //   314: ldc_w 815
    //   317: invokestatic 810	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: invokespecial 504	com/tencent/mm/ui/MMActivity:finish	()V
    //   324: sipush 4804
    //   327: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: return
    //   331: aload_0
    //   332: new 290	java/lang/ref/WeakReference
    //   335: dup
    //   336: aload 6
    //   338: invokespecial 818	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   341: putfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   344: aload_0
    //   345: aload 4
    //   347: getfield 767	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   350: putfield 465	com/tencent/mm/plugin/voip/ui/VideoActivity:eaX	Ljava/lang/String;
    //   353: aload_0
    //   354: aload_3
    //   355: getfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   358: putfield 165	com/tencent/mm/plugin/voip/ui/VideoActivity:txl	Z
    //   361: aload_0
    //   362: aload_1
    //   363: getfield 775	com/tencent/mm/pointers/PBool:value	Z
    //   366: putfield 203	com/tencent/mm/plugin/voip/ui/VideoActivity:txk	Z
    //   369: aload_0
    //   370: aload 5
    //   372: getfield 789	com/tencent/mm/pointers/PInt:value	I
    //   375: putfield 181	com/tencent/mm/plugin/voip/ui/VideoActivity:mStatus	I
    //   378: aload_0
    //   379: ldc_w 820
    //   382: invokestatic 824	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   385: checkcast 820	com/tencent/mm/plugin/messenger/foundation/a/j
    //   388: invokeinterface 828 1 0
    //   393: aload_0
    //   394: getfield 465	com/tencent/mm/plugin/voip/ui/VideoActivity:eaX	Ljava/lang/String;
    //   397: invokeinterface 834 2 0
    //   402: putfield 577	com/tencent/mm/plugin/voip/ui/VideoActivity:txj	Lcom/tencent/mm/storage/ad;
    //   405: new 572	android/os/Bundle
    //   408: dup
    //   409: invokespecial 573	android/os/Bundle:<init>	()V
    //   412: astore_1
    //   413: aload_1
    //   414: ldc_w 575
    //   417: aload_0
    //   418: getfield 577	com/tencent/mm/plugin/voip/ui/VideoActivity:txj	Lcom/tencent/mm/storage/ad;
    //   421: getfield 582	com/tencent/mm/g/c/aq:field_username	Ljava/lang/String;
    //   424: invokevirtual 585	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload_1
    //   428: ldc_w 587
    //   431: aload_0
    //   432: getfield 203	com/tencent/mm/plugin/voip/ui/VideoActivity:txk	Z
    //   435: invokevirtual 591	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   438: aload_1
    //   439: ldc_w 593
    //   442: aload_0
    //   443: getfield 203	com/tencent/mm/plugin/voip/ui/VideoActivity:txk	Z
    //   446: aload_0
    //   447: getfield 165	com/tencent/mm/plugin/voip/ui/VideoActivity:txl	Z
    //   450: invokestatic 787	com/tencent/mm/plugin/voip/a/b:V	(ZZ)I
    //   453: invokevirtual 597	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   456: aload_0
    //   457: getfield 181	com/tencent/mm/plugin/voip/ui/VideoActivity:mStatus	I
    //   460: invokestatic 837	com/tencent/mm/plugin/voip/a/b:HR	(I)Z
    //   463: ifeq +489 -> 952
    //   466: aload_0
    //   467: new 376	com/tencent/mm/plugin/voip/ui/VoipVideoFragment
    //   470: dup
    //   471: invokespecial 838	com/tencent/mm/plugin/voip/ui/VoipVideoFragment:<init>	()V
    //   474: putfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   477: aload_0
    //   478: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   481: aload_1
    //   482: invokevirtual 602	com/tencent/mm/plugin/voip/ui/VoipBaseFragment:setArguments	(Landroid/os/Bundle;)V
    //   485: aload_0
    //   486: invokevirtual 554	com/tencent/mm/plugin/voip/ui/VideoActivity:getSupportFragmentManager	()Landroid/support/v4/app/g;
    //   489: invokevirtual 560	android/support/v4/app/g:beginTransaction	()Landroid/support/v4/app/k;
    //   492: ldc_w 621
    //   495: aload_0
    //   496: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   499: invokevirtual 624	android/support/v4/app/k:b	(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/k;
    //   502: invokevirtual 568	android/support/v4/app/k:commit	()I
    //   505: pop
    //   506: aload_0
    //   507: bipush 8
    //   509: invokevirtual 841	com/tencent/mm/plugin/voip/ui/VideoActivity:setTitleVisibility	(I)V
    //   512: aload_0
    //   513: getfield 181	com/tencent/mm/plugin/voip/ui/VideoActivity:mStatus	I
    //   516: invokestatic 844	com/tencent/mm/plugin/voip/a/b:HS	(I)Z
    //   519: ifeq +29 -> 548
    //   522: aload_0
    //   523: getfield 203	com/tencent/mm/plugin/voip/ui/VideoActivity:txk	Z
    //   526: ifeq +22 -> 548
    //   529: aload_0
    //   530: getfield 276	com/tencent/mm/plugin/voip/ui/VideoActivity:iMP	Lcom/tencent/mm/sdk/platformtools/ak;
    //   533: new 846	com/tencent/mm/plugin/voip/ui/VideoActivity$7
    //   536: dup
    //   537: aload_0
    //   538: invokespecial 847	com/tencent/mm/plugin/voip/ui/VideoActivity$7:<init>	(Lcom/tencent/mm/plugin/voip/ui/VideoActivity;)V
    //   541: ldc2_w 848
    //   544: invokevirtual 287	com/tencent/mm/sdk/platformtools/ak:postDelayed	(Ljava/lang/Runnable;J)Z
    //   547: pop
    //   548: aload_0
    //   549: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   552: aload_0
    //   553: getfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   556: invokevirtual 294	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   559: checkcast 296	com/tencent/mm/plugin/voip/ui/c
    //   562: invokevirtual 606	com/tencent/mm/plugin/voip/ui/VoipBaseFragment:setVoipUIListener	(Lcom/tencent/mm/plugin/voip/ui/c;)V
    //   565: aload_0
    //   566: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   569: aload_0
    //   570: invokevirtual 613	com/tencent/mm/plugin/voip/ui/VoipBaseFragment:a	(Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment$d;)V
    //   573: aload_0
    //   574: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   577: aload_0
    //   578: getfield 84	com/tencent/mm/plugin/voip/ui/VideoActivity:txp	I
    //   581: invokevirtual 318	com/tencent/mm/plugin/voip/ui/VoipBaseFragment:HF	(I)V
    //   584: aload_0
    //   585: getfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   588: aload_0
    //   589: getfield 86	com/tencent/mm/plugin/voip/ui/VideoActivity:mIsMute	Z
    //   592: invokevirtual 617	com/tencent/mm/plugin/voip/ui/VoipBaseFragment:setMute	(Z)V
    //   595: invokestatic 151	com/tencent/mm/plugin/voip/b:cLC	()Lcom/tencent/mm/plugin/voip/model/t;
    //   598: getfield 853	com/tencent/mm/plugin/voip/model/t:tyS	Lcom/tencent/mm/plugin/voip/model/VoipMgr;
    //   601: getfield 858	com/tencent/mm/plugin/voip/model/VoipMgr:txI	Ljava/lang/String;
    //   604: ifnull +16 -> 620
    //   607: aload_0
    //   608: invokestatic 151	com/tencent/mm/plugin/voip/b:cLC	()Lcom/tencent/mm/plugin/voip/model/t;
    //   611: getfield 853	com/tencent/mm/plugin/voip/model/t:tyS	Lcom/tencent/mm/plugin/voip/model/VoipMgr;
    //   614: getfield 858	com/tencent/mm/plugin/voip/model/VoipMgr:txI	Ljava/lang/String;
    //   617: invokevirtual 860	com/tencent/mm/plugin/voip/ui/VideoActivity:aeH	(Ljava/lang/String;)V
    //   620: aload_0
    //   621: getfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   624: ifnull +30 -> 654
    //   627: aload_0
    //   628: getfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   631: invokevirtual 294	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   634: ifnull +20 -> 654
    //   637: aload_0
    //   638: getfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   641: invokevirtual 294	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   644: checkcast 296	com/tencent/mm/plugin/voip/ui/c
    //   647: aload_0
    //   648: iconst_1
    //   649: invokeinterface 863 3 0
    //   654: ldc 118
    //   656: ldc_w 865
    //   659: iconst_4
    //   660: anewarray 221	java/lang/Object
    //   663: dup
    //   664: iconst_0
    //   665: aload_0
    //   666: getfield 203	com/tencent/mm/plugin/voip/ui/VideoActivity:txk	Z
    //   669: invokestatic 356	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   672: aastore
    //   673: dup
    //   674: iconst_1
    //   675: aload_0
    //   676: getfield 165	com/tencent/mm/plugin/voip/ui/VideoActivity:txl	Z
    //   679: invokestatic 356	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   682: aastore
    //   683: dup
    //   684: iconst_2
    //   685: aload_0
    //   686: getfield 465	com/tencent/mm/plugin/voip/ui/VideoActivity:eaX	Ljava/lang/String;
    //   689: aastore
    //   690: dup
    //   691: iconst_3
    //   692: aload_0
    //   693: getfield 181	com/tencent/mm/plugin/voip/ui/VideoActivity:mStatus	I
    //   696: invokestatic 226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   699: aastore
    //   700: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   703: aload_0
    //   704: getfield 181	com/tencent/mm/plugin/voip/ui/VideoActivity:mStatus	I
    //   707: invokestatic 837	com/tencent/mm/plugin/voip/a/b:HR	(I)Z
    //   710: ifeq +281 -> 991
    //   713: aload_0
    //   714: ldc_w 867
    //   717: bipush 19
    //   719: ldc_w 869
    //   722: ldc_w 869
    //   725: invokestatic 874	com/tencent/mm/pluginsdk/permission/b:a	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    //   728: istore_2
    //   729: ldc 118
    //   731: ldc_w 876
    //   734: iconst_3
    //   735: anewarray 221	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: iload_2
    //   741: invokestatic 356	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: invokestatic 882	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   750: aastore
    //   751: dup
    //   752: iconst_2
    //   753: aload_0
    //   754: aastore
    //   755: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   758: iload_2
    //   759: ifne +18 -> 777
    //   762: aload_0
    //   763: getfield 114	com/tencent/mm/plugin/voip/ui/VideoActivity:tCc	Ljava/lang/ref/WeakReference;
    //   766: invokevirtual 294	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   769: checkcast 296	com/tencent/mm/plugin/voip/ui/c
    //   772: invokeinterface 885 1 0
    //   777: ldc 118
    //   779: ldc_w 887
    //   782: iconst_3
    //   783: anewarray 221	java/lang/Object
    //   786: dup
    //   787: iconst_0
    //   788: aload_0
    //   789: ldc_w 889
    //   792: bipush 19
    //   794: ldc_w 869
    //   797: ldc_w 869
    //   800: invokestatic 874	com/tencent/mm/pluginsdk/permission/b:a	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    //   803: invokestatic 356	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   806: aastore
    //   807: dup
    //   808: iconst_1
    //   809: invokestatic 882	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   812: aastore
    //   813: dup
    //   814: iconst_2
    //   815: aload_0
    //   816: aastore
    //   817: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   820: getstatic 527	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   823: aload_0
    //   824: getfield 103	com/tencent/mm/plugin/voip/ui/VideoActivity:tCo	Lcom/tencent/mm/sdk/b/c;
    //   827: invokevirtual 892	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   830: pop
    //   831: getstatic 527	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   834: aload_0
    //   835: getfield 106	com/tencent/mm/plugin/voip/ui/VideoActivity:oPY	Lcom/tencent/mm/sdk/b/c;
    //   838: invokevirtual 892	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   841: pop
    //   842: bipush 26
    //   844: invokestatic 657	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   847: ifeq +49 -> 896
    //   850: aload_0
    //   851: new 14	com/tencent/mm/plugin/voip/ui/VideoActivity$ScreenActionReceiver
    //   854: dup
    //   855: aload_0
    //   856: invokespecial 893	com/tencent/mm/plugin/voip/ui/VideoActivity$ScreenActionReceiver:<init>	(Lcom/tencent/mm/plugin/voip/ui/VideoActivity;)V
    //   859: putfield 895	com/tencent/mm/plugin/voip/ui/VideoActivity:tCk	Lcom/tencent/mm/plugin/voip/ui/VideoActivity$ScreenActionReceiver;
    //   862: new 897	android/content/IntentFilter
    //   865: dup
    //   866: invokespecial 898	android/content/IntentFilter:<init>	()V
    //   869: astore_1
    //   870: aload_1
    //   871: ldc_w 900
    //   874: invokevirtual 903	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   877: aload_1
    //   878: ldc_w 905
    //   881: invokevirtual 903	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   884: invokestatic 247	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   887: aload_0
    //   888: getfield 895	com/tencent/mm/plugin/voip/ui/VideoActivity:tCk	Lcom/tencent/mm/plugin/voip/ui/VideoActivity$ScreenActionReceiver;
    //   891: aload_1
    //   892: invokevirtual 909	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   895: pop
    //   896: bipush 17
    //   898: invokestatic 657	com/tencent/mm/compatible/util/d:fv	(I)Z
    //   901: ifeq +44 -> 945
    //   904: aload_0
    //   905: new 659	android/graphics/Point
    //   908: dup
    //   909: invokespecial 660	android/graphics/Point:<init>	()V
    //   912: putfield 652	com/tencent/mm/plugin/voip/ui/VideoActivity:rhc	Landroid/graphics/Point;
    //   915: aload_0
    //   916: invokevirtual 416	com/tencent/mm/plugin/voip/ui/VideoActivity:getWindow	()Landroid/view/Window;
    //   919: invokevirtual 434	android/view/Window:getDecorView	()Landroid/view/View;
    //   922: invokevirtual 914	android/view/View:getDisplay	()Landroid/view/Display;
    //   925: ifnull +20 -> 945
    //   928: aload_0
    //   929: invokevirtual 416	com/tencent/mm/plugin/voip/ui/VideoActivity:getWindow	()Landroid/view/Window;
    //   932: invokevirtual 434	android/view/Window:getDecorView	()Landroid/view/View;
    //   935: invokevirtual 914	android/view/View:getDisplay	()Landroid/view/Display;
    //   938: aload_0
    //   939: getfield 652	com/tencent/mm/plugin/voip/ui/VideoActivity:rhc	Landroid/graphics/Point;
    //   942: invokevirtual 676	android/view/Display:getRealSize	(Landroid/graphics/Point;)V
    //   945: sipush 4804
    //   948: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: return
    //   952: aload_0
    //   953: new 550	com/tencent/mm/plugin/voip/ui/VoipVoiceFragment
    //   956: dup
    //   957: invokespecial 598	com/tencent/mm/plugin/voip/ui/VoipVoiceFragment:<init>	()V
    //   960: putfield 139	com/tencent/mm/plugin/voip/ui/VideoActivity:tCb	Lcom/tencent/mm/plugin/voip/ui/VoipBaseFragment;
    //   963: goto -486 -> 477
    //   966: astore_1
    //   967: iconst_2
    //   968: invokestatic 495	com/tencent/mm/plugin/voip/a/a:HL	(I)V
    //   971: ldc 118
    //   973: aload_1
    //   974: ldc_w 869
    //   977: iconst_0
    //   978: anewarray 221	java/lang/Object
    //   981: invokestatic 918	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   984: sipush 4804
    //   987: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   990: return
    //   991: ldc 118
    //   993: ldc_w 887
    //   996: iconst_3
    //   997: anewarray 221	java/lang/Object
    //   1000: dup
    //   1001: iconst_0
    //   1002: aload_0
    //   1003: ldc_w 889
    //   1006: bipush 82
    //   1008: ldc_w 869
    //   1011: ldc_w 869
    //   1014: invokestatic 874	com/tencent/mm/pluginsdk/permission/b:a	(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    //   1017: invokestatic 356	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1020: aastore
    //   1021: dup
    //   1022: iconst_1
    //   1023: invokestatic 882	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_2
    //   1029: aload_0
    //   1030: aastore
    //   1031: invokestatic 229	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: goto -214 -> 820
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1037	0	this	VideoActivity
    //   0	1037	1	paramBundle	Bundle
    //   234	525	2	bool	boolean
    //   130	225	3	localPBool	com.tencent.mm.pointers.PBool
    //   138	208	4	localPString	com.tencent.mm.pointers.PString
    //   147	224	5	localPInt	com.tencent.mm.pointers.PInt
    //   282	1	6	localException	Exception
    //   305	32	6	localVoipMgr	com.tencent.mm.plugin.voip.model.VoipMgr
    // Exception table:
    //   from	to	target	type
    //   239	275	282	java/lang/Exception
    //   11	50	966	java/lang/Exception
    //   50	97	966	java/lang/Exception
    //   97	235	966	java/lang/Exception
    //   284	292	966	java/lang/Exception
    //   292	307	966	java/lang/Exception
    //   312	324	966	java/lang/Exception
    //   331	477	966	java/lang/Exception
    //   477	548	966	java/lang/Exception
    //   548	620	966	java/lang/Exception
    //   620	654	966	java/lang/Exception
    //   654	758	966	java/lang/Exception
    //   762	777	966	java/lang/Exception
    //   777	820	966	java/lang/Exception
    //   820	896	966	java/lang/Exception
    //   896	945	966	java/lang/Exception
    //   952	963	966	java/lang/Exception
    //   991	1034	966	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(4811);
    this.tCg = 4;
    ab.i("MicroMsg.Voip.VideoActivity", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(this.mStatus) });
    s locals = s.tyN;
    s.cNy();
    if (!this.tCi) {
      finish();
    }
    if ((this.tCc != null) && (this.tCc.get() != null)) {
      ((c)this.tCc.get()).a(this);
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.tCo);
    com.tencent.mm.sdk.b.a.ymk.d(this.oPY);
    setScreenEnable(true);
    if ((d.fv(26)) && (this.tCk != null)) {}
    try
    {
      ah.getContext().unregisterReceiver(this.tCk);
      this.tCk = null;
      super.onDestroy();
      AppMethodBeat.o(4811);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.i("MicroMsg.Voip.VideoActivity", "unregisterBatteryChange err:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(4809);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(4809);
      return true;
    }
    if (paramInt == 25)
    {
      if ((!com.tencent.mm.plugin.voip.b.cLC().tyR.cOm()) && (!this.txk))
      {
        com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
        AppMethodBeat.o(4809);
        return true;
      }
      if (com.tencent.mm.compatible.b.g.KC().KH()) {}
      for (paramInt = com.tencent.mm.compatible.b.g.KC().KU();; paramInt = bJG())
      {
        com.tencent.mm.compatible.b.g.KC().iG(paramInt);
        break;
      }
    }
    if (paramInt == 24)
    {
      if ((!com.tencent.mm.plugin.voip.b.cLC().tyR.cOm()) && (!this.txk))
      {
        com.tencent.mm.plugin.voip.b.cLC().tyR.stopRing();
        AppMethodBeat.o(4809);
        return true;
      }
      if (com.tencent.mm.compatible.b.g.KC().KH()) {}
      for (paramInt = com.tencent.mm.compatible.b.g.KC().KU();; paramInt = bJG())
      {
        com.tencent.mm.compatible.b.g.KC().iF(paramInt);
        break;
      }
    }
    if ((ac.eru.enT == 1) && (paramInt == 700))
    {
      cOT();
      AppMethodBeat.o(4809);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(4809);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(4818);
    ab.i("MicroMsg.Voip.VideoActivity", "onNewIntent");
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(4818);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(4819);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ah.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ah.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.tCh = bool1;
      ab.i("MicroMsg.Voip.VideoActivity", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(this.mStatus), Boolean.valueOf(this.tCh), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      o.La(2);
      AppMethodBeat.o(4819);
      return;
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4840);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(4840);
      return;
    }
    ab.i("MicroMsg.Voip.VideoActivity", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(4840);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
        for (paramInt = 2131302067;; paramInt = 2131302075)
        {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131296888), false, new VideoActivity.4(this), new VideoActivity.5(this));
          AppMethodBeat.o(4840);
          return;
        }
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(2131302075), getString(2131302083), getString(2131300996), getString(2131296888), false, new VideoActivity.6(this), null);
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(4820);
    ab.i("MicroMsg.Voip.VideoActivity", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    com.tencent.mm.plugin.voip.model.k localk = com.tencent.mm.plugin.voip.b.cLC().tyR.ttm;
    if (localk.tuV) {
      localk.tuV = false;
    }
    com.tencent.mm.plugin.voip.b.cLC().cNT();
    super.onResume();
    com.tencent.mm.plugin.voip.b.cLC();
    if ((this.tCc != null) && (this.tCc.get() != null)) {
      ((c)this.tCc.get()).cMR();
    }
    setScreenEnable(true);
    this.tCe = bo.yB();
    if ((this.txk) && (com.tencent.mm.plugin.voip.a.b.HS(this.mStatus)) && (com.tencent.mm.plugin.voip.b.cLC().tyR.cOm())) {
      if (!this.txl) {
        break label226;
      }
    }
    label226:
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.cLC().ap(i, this.txk);
      o.La(1);
      this.tCm = true;
      if ((this.tCc != null) && (this.tCc.get() != null)) {
        ((c)this.tCc.get()).cMS();
      }
      AppMethodBeat.o(4820);
      return;
    }
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public void onStart()
  {
    AppMethodBeat.i(4813);
    super.onStart();
    if (!this.tCi)
    {
      ab.i("MicroMsg.Voip.VideoActivity", "onStart");
      this.tCg = 1;
      gl(4096, this.mStatus);
    }
    AppMethodBeat.o(4813);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(4812);
    this.tCg = 2;
    ab.i("MicroMsg.Voip.VideoActivity", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(this.mStatus) });
    super.onStop();
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.tCh) && (!this.tCi) && (this.tCc != null) && (this.tCc.get() != null) && (((c)this.tCc.get()).mV(false)))
    {
      U(false, true);
      if (com.tencent.mm.plugin.voip.a.b.HQ(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.qsU;
        if (!com.tencent.mm.plugin.voip.a.b.HR(this.mStatus)) {
          break label170;
        }
      }
    }
    label170:
    for (int i = 2;; i = 3)
    {
      localh.e(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      AppMethodBeat.o(4812);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(140174);
    if (this.tCb != null) {
      this.tCb.requestRender();
    }
    AppMethodBeat.o(140174);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(4838);
    this.txe = paramCaptureView;
    if (this.tCb != null) {
      this.tCb.a(paramCaptureView);
    }
    AppMethodBeat.o(4838);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(4834);
    this.tCd = paramLong;
    if (this.tCb != null) {
      this.tCb.ng(this.tCd);
    }
    AppMethodBeat.o(4834);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(4832);
    if (this.tCb != null) {
      this.tCb.setHWDecMode(paramInt);
    }
    AppMethodBeat.o(4832);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(4828);
    this.mIsMute = paramBoolean;
    if (this.tCb != null) {
      this.tCb.setMute(paramBoolean);
    }
    AppMethodBeat.o(4828);
  }
  
  public void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(4817);
    super.setScreenEnable(paramBoolean);
    if (this.tCc != null) {
      this.tCc.get();
    }
    AppMethodBeat.o(4817);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(4831);
    if (this.tCb != null) {
      this.tCb.setVoipBeauty(paramInt);
    }
    AppMethodBeat.o(4831);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(4833);
    if (this.tCb != null) {
      this.tCb.uninit();
    }
    AppMethodBeat.o(4833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VideoActivity
 * JD-Core Version:    0.7.0.1
 */