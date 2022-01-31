package com.tencent.mm.plugin.voip.widget;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.support.v4.app.s.c;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.an;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.a.a;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private byte[] buffer;
  private int mStatus;
  private boolean oTI;
  private int tDS;
  private PowerManager.WakeLock tDZ;
  private ap tFb;
  private boolean tJA;
  a.a tJB;
  private View.OnClickListener tJC;
  private ap tJD;
  private c tJw;
  private BaseSmallView tJx;
  private long tJy;
  private boolean tJz;
  private int txM;
  private int txY;
  private int txZ;
  private CaptureView txe;
  private ad txj;
  private boolean txk;
  private boolean txl;
  private int txp;
  private long txq;
  private boolean tzd;
  
  public b(c paramc, int paramInt, ad paramad, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(5180);
    this.mStatus = -1;
    this.txq = -1L;
    this.txp = 1;
    this.tJy = -1L;
    this.tJz = false;
    this.tzd = false;
    this.txM = 0;
    this.txY = 0;
    this.txZ = 0;
    this.oTI = false;
    this.tJA = false;
    this.tJC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(5171);
        if (b.a(b.this) != null) {
          b.a(b.this).setOnClickListener(null);
        }
        b.this.cNc();
        b.b(b.this);
        paramAnonymousView = new Intent(ah.getContext(), VideoActivity.class);
        paramAnonymousView.setFlags(268435456);
        paramAnonymousView = PendingIntent.getActivity(ah.getContext(), 0, paramAnonymousView, 0);
        try
        {
          paramAnonymousView.send();
          AppMethodBeat.o(5171);
          return;
        }
        catch (PendingIntent.CanceledException paramAnonymousView)
        {
          ab.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
          AppMethodBeat.o(5171);
        }
      }
    };
    ab.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(paramInt), paramad.field_username, Boolean.valueOf(paramBoolean1) });
    this.txj = paramad;
    this.tJw = paramc;
    this.txl = paramBoolean1;
    this.txk = paramBoolean2;
    this.tzd = paramBoolean3;
    gl(0, paramInt);
    this.tDZ = ((PowerManager)ah.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.tDZ.acquire();
    paramc = com.tencent.mm.plugin.voip.model.s.tyN;
    com.tencent.mm.plugin.voip.model.s.cNM();
    AppMethodBeat.o(5180);
  }
  
  private static String Bm()
  {
    AppMethodBeat.i(5208);
    String str2 = av.flM.Y("login_weixin_username", "");
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = av.flM.Y("login_user_name", "never_login_crash");
    }
    AppMethodBeat.o(5208);
    return str1;
  }
  
  private void HZ(int paramInt)
  {
    AppMethodBeat.i(5182);
    switch (paramInt)
    {
    default: 
      cOQ();
      nh(true);
      AppMethodBeat.o(5182);
      return;
    case 4106: 
      paramInt = 2131304736;
    }
    for (;;)
    {
      Ia(paramInt);
      break;
      paramInt = 2131304715;
      continue;
      if (this.txl) {
        paramInt = 2131304748;
      } else {
        paramInt = 2131304613;
      }
    }
  }
  
  private static void Ia(int paramInt)
  {
    AppMethodBeat.i(5183);
    Context localContext = ah.getContext();
    Toast.makeText(localContext, localContext.getString(paramInt), 1).show();
    AppMethodBeat.o(5183);
  }
  
  private void Ib(int paramInt)
  {
    AppMethodBeat.i(5187);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
    if (-1L == this.tJy) {
      this.tJy = System.currentTimeMillis();
    }
    if (2 == this.txp) {
      Ia(2131304614);
    }
    nh(false);
    if (this.tJw != null) {
      this.tJw.a(this, 2);
    }
    String str = cQg();
    f(str, com.tencent.mm.model.s.nE(this.txj.field_username), str, false);
    cQf();
    if (4101 == paramInt) {
      Ia(2131304741);
    }
    AppMethodBeat.o(5187);
  }
  
  public static int bYt()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return 2130839845;
    }
    return 2130839847;
  }
  
  private void cPf()
  {
    AppMethodBeat.i(5184);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
    this.tJz = true;
    if (-1L == this.tJy) {
      this.tJy = System.currentTimeMillis();
    }
    if (this.tJw != null)
    {
      this.tJw.a(this, 2);
      this.tJw.cMR();
    }
    Object localObject;
    if (!com.tencent.mm.compatible.f.b.bK(ah.getContext()))
    {
      ab.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
      localObject = ah.getContext();
      RequestFloatWindowPermissionDialog.a(ah.getContext(), ((Context)localObject).getString(2131304682), new RequestFloatWindowPermissionDialog.a()
      {
        public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(5172);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          paramAnonymousRequestFloatWindowPermissionDialog = ah.getContext().getString(2131304749);
          b.this.f(paramAnonymousRequestFloatWindowPermissionDialog, com.tencent.mm.model.s.nE(b.c(b.this).field_username), paramAnonymousRequestFloatWindowPermissionDialog, false);
          if ((com.tencent.mm.plugin.voip.a.b.HS(b.d(b.this))) || (com.tencent.mm.plugin.voip.a.b.HQ(b.d(b.this))))
          {
            b.e(b.this);
            AppMethodBeat.o(5172);
            return;
          }
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          b.b(b.this);
          AppMethodBeat.o(5172);
        }
        
        public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
        {
          AppMethodBeat.i(5173);
          paramAnonymousRequestFloatWindowPermissionDialog.finish();
          AppMethodBeat.o(5173);
        }
      });
      if (!com.tencent.mm.plugin.voip.b.cLC().tzb)
      {
        com.tencent.mm.plugin.voip.b.cLC().tzb = true;
        long l = com.tencent.mm.kernel.g.RL().Ru().Ns(327950);
        if (System.currentTimeMillis() - l > 86400000L) {
          qc("have not permission to showing floating window\n");
        }
      }
    }
    for (;;)
    {
      localObject = ah.getContext().getString(2131304749);
      f((String)localObject, com.tencent.mm.model.s.nE(this.txj.field_username), (String)localObject, false);
      AppMethodBeat.o(5184);
      return;
      cQc();
    }
  }
  
  private void cQc()
  {
    AppMethodBeat.i(5185);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
    nh(false);
    Context localContext = ah.getContext();
    com.tencent.mm.plugin.voip.b.cLC();
    this.tJx = new a(localContext, t.mW(false));
    this.tJx.setConnectSec(this.txq);
    this.tJx.setVoipUIListener(this.tJw);
    localContext = ah.getContext();
    com.tencent.mm.plugin.voip.b.cLC();
    float f1 = t.mW(true);
    int i = ((WindowManager)localContext.getSystemService("window")).getDefaultDisplay().getHeight() / 5 + BackwardSupportUtil.b.b(localContext, 7.0F);
    float f2 = i;
    int j = (int)(BackwardSupportUtil.b.b(localContext, 7.0F) + f1 * f2);
    this.tJx.eh(j, i);
    this.tJx.setOnClickListener(this.tJC);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
    h(new Point(j, i));
    ab.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.tDS), Integer.valueOf(this.txM) });
    setHWDecMode(this.tDS);
    setVoipBeauty(this.txM);
    if ((this.txY != 0) && (this.txZ != 0)) {
      gj(this.txY, this.txZ);
    }
    AppMethodBeat.o(5185);
  }
  
  private void cQd()
  {
    AppMethodBeat.i(5186);
    if (2 == this.txp) {
      Ia(2131304614);
    }
    nh(false);
    String str = ah.getContext().getString(2131304757);
    f(str, com.tencent.mm.model.s.nE(this.txj.field_username), str, false);
    cQf();
    if (this.tJw != null) {
      this.tJw.a(this, 2);
    }
    AppMethodBeat.o(5186);
  }
  
  private void cQf()
  {
    AppMethodBeat.i(5190);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    boolean bool = false;
    if ((this.mStatus == 261) || (this.mStatus == 7))
    {
      this.tJD = new ap(new b.3(this), true);
      this.tJD.ag(1000L, 1000L);
      bool = true;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(ah.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.txj.field_username);
    localIntent.putExtra("Voip_Outcall", this.txk);
    localIntent.putExtra("Voip_VideoCall", this.txl);
    localIntent.putExtra("Voip_Is_Talking", bool);
    com.tencent.mm.plugin.voip.b.cLD().a(localIntent, new b.4(this));
    AppMethodBeat.o(5190);
  }
  
  private static String cQg()
  {
    AppMethodBeat.i(5191);
    String str = ah.getContext().getString(2131304757);
    AppMethodBeat.o(5191);
    return str;
  }
  
  private void cQh()
  {
    AppMethodBeat.i(5192);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
    if (this.tJx == null) {}
    for (Object localObject = null; (localObject != null) && ((256 == ((Integer)localObject).intValue()) || (258 == ((Integer)localObject).intValue())); localObject = (Integer)this.tJx.getTag())
    {
      AppMethodBeat.o(5192);
      return;
    }
    localObject = ah.getContext().getString(2131304749);
    if (com.tencent.mm.model.s.nE(this.txj.field_username) != null) {
      f((String)localObject, (String)localObject, com.tencent.mm.model.s.nE(this.txj.field_username), false);
    }
    for (;;)
    {
      if (this.tJw != null)
      {
        this.tJw.a(this, 2);
        this.tJw.cMR();
      }
      AppMethodBeat.o(5192);
      return;
      f((String)localObject, (String)localObject, "", true);
    }
  }
  
  private void cQi()
  {
    AppMethodBeat.i(5193);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
    if (this.tJx == null) {}
    for (Object localObject = null; (localObject != null) && ((((Integer)localObject).intValue() == 0) || (2 == ((Integer)localObject).intValue()) || (4 == ((Integer)localObject).intValue())); localObject = (Integer)this.tJx.getTag())
    {
      AppMethodBeat.o(5193);
      return;
    }
    localObject = ah.getContext().getString(2131304749);
    if (com.tencent.mm.model.s.nE(this.txj.field_username) != null) {
      f((String)localObject, com.tencent.mm.model.s.nE(this.txj.field_username), (String)localObject, false);
    }
    for (;;)
    {
      if (this.tJw != null)
      {
        this.tJw.a(this, 2);
        this.tJw.cMR();
      }
      AppMethodBeat.o(5193);
      return;
      f((String)localObject, (String)localObject, "", true);
    }
  }
  
  private void h(Point paramPoint)
  {
    AppMethodBeat.i(5195);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!com.tencent.mm.plugin.voip.a.b.HS(this.mStatus)) && (!com.tencent.mm.plugin.voip.a.b.HQ(this.mStatus)))
    {
      ab.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      AppMethodBeat.o(5195);
      return;
    }
    if (this.tJD != null) {
      this.tJD.stopTimer();
    }
    if (this.tFb != null) {
      this.tFb.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    WindowManager localWindowManager = (WindowManager)ah.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    int i;
    int j;
    if (com.tencent.mm.compatible.util.d.fv(26))
    {
      localLayoutParams.type = 2038;
      localLayoutParams.format = 1;
      localLayoutParams.flags = 40;
      localLayoutParams.gravity = 51;
      Context localContext = ah.getContext();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
      localLayoutParams.width = paramPoint.x;
      localLayoutParams.height = paramPoint.y;
      paramPoint = com.tencent.mm.plugin.voip.b.cLC().tza;
      if (paramPoint != null) {
        break label364;
      }
      i = com.tencent.mm.kernel.g.RL().Ru().getInt(327947, 0);
      j = BackwardSupportUtil.b.b(localContext, 5.0F);
      localLayoutParams.x = (localDisplayMetrics.widthPixels - localLayoutParams.width - j);
    }
    for (localLayoutParams.y = (j + i);; localLayoutParams.y = paramPoint.y)
    {
      if (this.txe != null)
      {
        if ((this.txe.getParent() != null) && ((this.txe.getParent() instanceof ViewGroup))) {
          ((ViewGroup)this.txe.getParent()).removeView(this.txe);
        }
        this.tJx.setCaptureView(this.txe);
      }
      this.tJx.setTag(Integer.valueOf(this.mStatus));
      try
      {
        localWindowManager.addView(this.tJx, localLayoutParams);
        AppMethodBeat.o(5195);
        return;
      }
      catch (Exception paramPoint)
      {
        label364:
        ab.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[] { paramPoint.getMessage() });
        AppMethodBeat.o(5195);
      }
      localLayoutParams.type = 2002;
      break;
      localLayoutParams.x = paramPoint.x;
    }
  }
  
  private void nh(boolean paramBoolean)
  {
    AppMethodBeat.i(5196);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
    ab.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    Object localObject;
    if (this.tJx != null)
    {
      localObject = (WindowManager.LayoutParams)this.tJx.getLayoutParams();
      com.tencent.mm.plugin.voip.b.cLC().tza = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y);
      this.tJx.uninit();
      localObject = (WindowManager)ah.getContext().getSystemService("window");
    }
    try
    {
      ((WindowManager)localObject).removeView(this.tJx);
      this.tJx = null;
      if (paramBoolean) {
        com.tencent.mm.plugin.voip.b.cLD().aeI(ah.getContext().getString(2131304702));
      }
      if (this.tJD != null) {
        this.tJD.stopTimer();
      }
      com.tencent.mm.plugin.voip.b.cLD().dismiss();
      AppMethodBeat.o(5196);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        ab.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[] { localIllegalArgumentException });
      }
    }
  }
  
  private static void qc(String paramString)
  {
    AppMethodBeat.i(5207);
    com.tencent.mm.kernel.g.RL().Ru().setLong(327950, System.currentTimeMillis());
    ab.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.whH).append("\n");
    localStringBuilder.append("#accinfo.revision=").append(f.REV).append("\n");
    localStringBuilder.append("#accinfo.build=").append(f.TIME).append(":").append(f.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.g.bWu).append("\n");
    Object localObject = new Date();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    localStringBuilder.append("#accinfo.uploadTime=" + localSimpleDateFormat.format((Date)localObject)).append("\n");
    localStringBuilder.append("#accinfo.content:\n");
    localObject = new Intent();
    ((Intent)localObject).setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
    ((Intent)localObject).setAction("uncatch_exception");
    ((Intent)localObject).putExtra("exceptionWriteSdcard", false);
    ((Intent)localObject).putExtra("exceptionPid", Process.myPid());
    ((Intent)localObject).putExtra("userName", Bm());
    ((Intent)localObject).putExtra("tag", "float_window_permission");
    ((Intent)localObject).putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + paramString).getBytes(), 2));
    ah.getContext().sendBroadcast((Intent)localObject);
    AppMethodBeat.o(5207);
  }
  
  public final void HF(int paramInt) {}
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140271);
    if (this.tJx != null) {
      this.tJx.a(paramSurfaceTexture, paramInt);
    }
    AppMethodBeat.o(140271);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(5202);
    if ((260 != this.mStatus) && (6 != this.mStatus))
    {
      AppMethodBeat.o(5202);
      return;
    }
    if (this.tJx != null) {
      this.tJx.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    AppMethodBeat.o(5202);
  }
  
  public final void aeH(String paramString) {}
  
  public final void bKF() {}
  
  public final void br(int paramInt, String paramString)
  {
    AppMethodBeat.i(5197);
    if (paramInt == 241) {
      Toast.makeText(ah.getContext(), paramString, 1).show();
    }
    ab.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode ".concat(String.valueOf(paramInt)));
    if (paramInt == 235) {
      paramInt = 2131304677;
    }
    while (paramInt == 0)
    {
      Ia(2131304675);
      AppMethodBeat.o(5197);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.b.cLC().cNW();
        paramInt = 2131304676;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.au.b.aih()) || (this.txl)) {
          paramInt = 2131304678;
        } else {
          paramInt = 2131304680;
        }
      }
      else if (paramInt == 236)
      {
        paramInt = 2131304694;
      }
      else if (paramInt == 211)
      {
        paramInt = 2131304679;
      }
      else
      {
        paramInt = 0;
      }
    }
    Ia(paramInt);
    AppMethodBeat.o(5197);
  }
  
  public final void cNc()
  {
    AppMethodBeat.i(5199);
    if (this.tJx != null) {
      this.tJx.cNc();
    }
    AppMethodBeat.o(5199);
  }
  
  public final Context cOO()
  {
    return null;
  }
  
  public final void cOP() {}
  
  public final void cOQ()
  {
    AppMethodBeat.i(140273);
    if (this.tJx != null) {
      this.tJx.cOQ();
    }
    AppMethodBeat.o(140273);
  }
  
  public final byte[] cOR()
  {
    AppMethodBeat.i(5209);
    if ((this.tJx != null) && (this.tJx.getFilterData() != null)) {
      this.tJx.getFilterData().a(new b.5(this));
    }
    byte[] arrayOfByte = this.buffer;
    AppMethodBeat.o(5209);
    return arrayOfByte;
  }
  
  public final a.a cOS()
  {
    AppMethodBeat.i(140274);
    if ((this.tJx != null) && (this.tJx.getBeautyData() != null)) {
      this.tJx.getBeautyData().a(new b.6(this));
    }
    a.a locala = this.tJB;
    AppMethodBeat.o(140274);
    return locala;
  }
  
  public final String cQe()
  {
    AppMethodBeat.i(5189);
    int i = (int)(System.currentTimeMillis() / 1000L - this.txq);
    if (this.txq == -1L) {
      i = 0;
    }
    if (i >= 3600) {}
    for (String str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });; str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }))
    {
      String str2 = str1;
      if (bo.isNullOrNil(str1)) {
        str2 = "00:00";
      }
      AppMethodBeat.o(5189);
      return str2;
    }
  }
  
  public final void f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140269);
    if ((260 != this.mStatus) && (6 != this.mStatus))
    {
      AppMethodBeat.o(140269);
      return;
    }
    if (this.tJx != null) {
      this.tJx.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(140269);
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(5194);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:" + paramBoolean);
    ab.a("MicroMsg.Voip.VoipSmallWindow", "breathEffect ".concat(String.valueOf(paramBoolean)), new Object[0]);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(ah.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_User", this.txj.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.txk);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.txl);
    localObject = PendingIntent.getActivity(ah.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(paramString1).g(System.currentTimeMillis()).e(paramString2).f(paramString3);
    paramString1.ya = ((PendingIntent)localObject);
    paramString1 = paramString1.Y(bYt());
    paramString1.g(2, true);
    paramString1 = com.tencent.mm.plugin.voip.a.d.c(paramString1);
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
    AppMethodBeat.o(5194);
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140270);
    this.txY = paramInt1;
    this.txZ = paramInt2;
    if (this.tJx != null) {
      this.tJx.gj(paramInt1, paramInt2);
    }
    AppMethodBeat.o(140270);
  }
  
  public final void gl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5181);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { com.tencent.mm.plugin.voip.a.b.HN(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      ab.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
      AppMethodBeat.o(5181);
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(5181);
      return;
      cQi();
      AppMethodBeat.o(5181);
      return;
      cPf();
      AppMethodBeat.o(5181);
      return;
      cQh();
      AppMethodBeat.o(5181);
      return;
      HZ(paramInt1);
      AppMethodBeat.o(5181);
      return;
      cQd();
      AppMethodBeat.o(5181);
      return;
      Ib(paramInt1);
    }
  }
  
  public final void mY(boolean paramBoolean)
  {
    AppMethodBeat.i(5205);
    if (paramBoolean)
    {
      Toast.makeText(ah.getContext(), 2131304711, 1).show();
      AppMethodBeat.o(5205);
      return;
    }
    Toast.makeText(ah.getContext(), 2131304710, 1).show();
    AppMethodBeat.o(5205);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void requestRender()
  {
    AppMethodBeat.i(140272);
    if (this.tJx != null) {
      this.tJx.requestRender();
    }
    AppMethodBeat.o(140272);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    AppMethodBeat.i(5206);
    this.txe = paramCaptureView;
    if ((this.tJx != null) && (this.txe != null))
    {
      if ((this.txe.getParent() != null) && ((this.txe.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.txe.getParent()).removeView(this.txe);
      }
      this.tJx.setCaptureView(paramCaptureView);
    }
    AppMethodBeat.o(5206);
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(5204);
    this.txq = paramLong;
    if (this.tJx != null)
    {
      this.tJx.setConnectSec(paramLong);
      AppMethodBeat.o(5204);
      return;
    }
    if ((261 == this.mStatus) || (7 == this.mStatus))
    {
      String str = cQg();
      f(str, com.tencent.mm.model.s.nE(this.txj.field_username), str, false);
    }
    AppMethodBeat.o(5204);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(5201);
    if (this.tJx != null) {
      this.tJx.setHWDecMode(paramInt);
    }
    this.tDS = paramInt;
    AppMethodBeat.o(5201);
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(5200);
    if (this.tJx != null) {
      this.tJx.setVoipBeauty(paramInt);
    }
    this.txM = paramInt;
    AppMethodBeat.o(5200);
  }
  
  public final void uninit()
  {
    int i = 3;
    AppMethodBeat.i(5203);
    ab.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
    Object localObject;
    long l;
    if (-1L != this.tJy)
    {
      localObject = h.qsU;
      if (this.tJz) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.tJy) / 1000L;
      if (!this.tzd) {
        break label180;
      }
    }
    label180:
    for (int j = 1;; j = 2)
    {
      ((h)localObject).e(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.tDZ != null) && (this.tDZ.isHeld()))
      {
        ab.i("MicroMsg.Voip.VoipSmallWindow", "release waklock");
        this.tDZ.release();
      }
      nh(false);
      this.tJA = true;
      if (this.tJD != null) {
        this.tJD.stopTimer();
      }
      ab.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      this.txe = null;
      localObject = com.tencent.mm.plugin.voip.model.s.tyN;
      com.tencent.mm.plugin.voip.model.s.cNN();
      AppMethodBeat.o(5203);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */