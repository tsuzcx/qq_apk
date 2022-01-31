package com.tencent.mm.plugin.voip.widget;

import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.al;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b
  implements ServiceConnection, com.tencent.mm.plugin.voip.ui.b
{
  private static final String bwK;
  private static final String bwL;
  private byte[] buffer;
  private int mStatus = -1;
  private CaptureView pRW;
  private int pSD = 0;
  private ad pSb;
  private boolean pSc;
  private boolean pSd;
  private int pSh = 1;
  private long pSi = -1L;
  private boolean pTC = false;
  private int pYt;
  private am pZB;
  private c qcG;
  private BaseSmallView qcH;
  private am qcI;
  private PowerManager.WakeLock qcJ;
  private long qcK = -1L;
  private boolean qcL = false;
  private boolean qcM = false;
  private View.OnClickListener qcN = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (b.a(b.this) != null) {
        b.a(b.this).setOnClickListener(null);
      }
      b.b(b.this);
      paramAnonymousView = new Intent(ae.getContext(), VideoActivity.class);
      paramAnonymousView.setFlags(268435456);
      paramAnonymousView = PendingIntent.getActivity(ae.getContext(), 0, paramAnonymousView, 0);
      try
      {
        paramAnonymousView.send();
        return;
      }
      catch (PendingIntent.CanceledException paramAnonymousView)
      {
        y.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", paramAnonymousView, "send pending intent error: %s", new Object[] { paramAnonymousView.getMessage() });
      }
    }
  };
  private am qcO;
  
  static
  {
    String str = q.zg();
    bwK = str;
    bwL = o.getString(str.hashCode());
  }
  
  public b(c paramc, int paramInt, ad paramad, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[] { com.tencent.mm.plugin.voip.a.b.At(paramInt), paramad.field_username, Boolean.valueOf(paramBoolean1) });
    this.pSb = paramad;
    this.qcG = paramc;
    this.pSd = paramBoolean1;
    this.pSc = paramBoolean2;
    this.pTC = paramBoolean3;
    en(0, paramInt);
    this.qcJ = ((PowerManager)ae.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
    this.qcJ.acquire();
  }
  
  private static void AA(int paramInt)
  {
    Context localContext = ae.getContext();
    Toast.makeText(localContext, localContext.getString(paramInt), 1).show();
  }
  
  private void bSH()
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "show mini..");
    bSM();
    Object localObject = ae.getContext();
    com.tencent.mm.plugin.voip.b.bPx();
    this.qcH = new a((Context)localObject, com.tencent.mm.plugin.voip.model.r.ka(false));
    this.qcH.setConnectSec(this.pSi);
    this.qcH.setVoipUIListener(this.qcG);
    localObject = ae.getContext();
    com.tencent.mm.plugin.voip.b.bPx();
    float f1 = com.tencent.mm.plugin.voip.model.r.ka(true);
    int i = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getHeight() / 5 + BackwardSupportUtil.b.b((Context)localObject, 7.0F);
    float f2 = i;
    int j = (int)(BackwardSupportUtil.b.b((Context)localObject, 7.0F) + f1 * f2);
    this.qcH.cK(j, i);
    this.qcH.setOnClickListener(this.qcN);
    y.i("MicroMsg.Voip.VoipSmallWindow", "now add to view..");
    Point localPoint = new Point(j, i);
    y.i("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
    if ((!com.tencent.mm.plugin.voip.a.b.Ay(this.mStatus)) && (!com.tencent.mm.plugin.voip.a.b.Aw(this.mStatus)))
    {
      y.i("MicroMsg.Voip.VoipSmallWindow", "not in voip talking or inviting,now return..");
      y.i("MicroMsg.Voip.VoipSmallWindow", "steve: showMiniSmallView decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.pYt), Integer.valueOf(this.pSD) });
      setHWDecMode(this.pYt);
      setVoipBeauty(this.pSD);
      return;
    }
    if (this.qcI != null) {
      this.qcI.stopTimer();
    }
    if (this.qcO != null) {
      this.qcO.stopTimer();
    }
    if (this.pZB != null) {
      this.pZB.stopTimer();
    }
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    localObject = (WindowManager)ae.getContext().getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.type = 2002;
    localLayoutParams.format = 1;
    localLayoutParams.flags = 40;
    localLayoutParams.gravity = 51;
    Context localContext = ae.getContext();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localLayoutParams.width = localPoint.x;
    localLayoutParams.height = localPoint.y;
    localPoint = com.tencent.mm.plugin.voip.b.bPx().pTz;
    if (localPoint == null)
    {
      i = com.tencent.mm.kernel.g.DP().Dz().getInt(327947, 0);
      j = BackwardSupportUtil.b.b(localContext, 5.0F);
      localLayoutParams.x = (localDisplayMetrics.widthPixels - localLayoutParams.width - j);
    }
    for (localLayoutParams.y = (j + i);; localLayoutParams.y = localPoint.y)
    {
      for (;;)
      {
        if (this.pRW != null)
        {
          if ((this.pRW.getParent() != null) && ((this.pRW.getParent() instanceof ViewGroup))) {
            ((ViewGroup)this.pRW.getParent()).removeView(this.pRW);
          }
          this.qcH.setCaptureView(this.pRW);
        }
        this.qcH.setTag(Integer.valueOf(this.mStatus));
        try
        {
          ((WindowManager)localObject).addView(this.qcH, localLayoutParams);
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[] { localException.getMessage() });
        }
      }
      break;
      localLayoutParams.x = localPoint.x;
    }
  }
  
  private void bSJ()
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
    boolean bool = false;
    if ((this.mStatus == 261) || (this.mStatus == 7))
    {
      this.qcO = new am(new b.4(this), true);
      this.qcO.S(1000L, 1000L);
      bool = true;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(ae.getContext(), VideoActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("Voip_User", this.pSb.field_username);
    localIntent.putExtra("Voip_Outcall", this.pSc);
    localIntent.putExtra("Voip_VideoCall", this.pSd);
    localIntent.putExtra("Voip_Is_Talking", bool);
    com.tencent.mm.plugin.voip.b.bPy().a(localIntent, new b.5(this));
  }
  
  private String bSK()
  {
    int i = (int)(System.currentTimeMillis() / 1000L - this.pSi);
    if (this.pSi == -1L) {
      i = 0;
    }
    String str = ae.getContext().getString(a.e.voip_voice_is_talking_tip);
    if (i >= 3600) {
      return str + String.format(Locale.US, "    %d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });
    }
    return str + String.format(Locale.US, "    %d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) });
  }
  
  public static int bSL()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return a.a.notification_icon;
    }
    return a.a.notification_icon_gray;
  }
  
  private void bSM()
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
    if (this.qcI != null) {
      this.qcI.stopTimer();
    }
    y.i("MicroMsg.Voip.VoipSmallWindow", "remove small view..cancel notification first..");
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
    Object localObject;
    if (this.qcH != null)
    {
      localObject = (WindowManager.LayoutParams)this.qcH.getLayoutParams();
      com.tencent.mm.plugin.voip.b.bPx().pTz = new Point(((WindowManager.LayoutParams)localObject).x, ((WindowManager.LayoutParams)localObject).y);
      this.qcH.uninit();
      localObject = (WindowManager)ae.getContext().getSystemService("window");
    }
    try
    {
      ((WindowManager)localObject).removeView(this.qcH);
      this.qcH = null;
      com.tencent.mm.plugin.voip.b.bPy().Qb(ae.getContext().getString(a.e.voip_multitalk_end_wording));
      if (this.qcO != null) {
        this.qcO.stopTimer();
      }
      com.tencent.mm.plugin.voip.b.bPy().dismiss();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        y.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[] { localIllegalArgumentException });
      }
    }
  }
  
  public final void Ap(int paramInt) {}
  
  public final void Qa(String paramString) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((260 != this.mStatus) && (6 != this.mStatus)) {}
    while (this.qcH == null) {
      return;
    }
    this.qcH.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public final void aN(int paramInt, String paramString)
  {
    if (paramInt == 241) {
      Toast.makeText(ae.getContext(), paramString, 1).show();
    }
    y.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + paramInt);
    if (paramInt == 235) {
      paramInt = a.e.voip_errorhint_notsupport;
    }
    while (paramInt == 0)
    {
      AA(a.e.voip_disconnect_tip);
      return;
      if (paramInt == 233)
      {
        com.tencent.mm.plugin.voip.b.bPx().bRi();
        paramInt = a.e.voip_errorhint_notcontact;
      }
      else if (paramInt == 237)
      {
        if ((!com.tencent.mm.at.b.Pf()) || (this.pSd)) {
          paramInt = a.e.voip_errorhint_plugclose;
        } else {
          paramInt = a.e.voip_errorhint_voice_plugclose_for_oversea;
        }
      }
      else if (paramInt == 236)
      {
        paramInt = a.e.voip_inblacklist;
      }
      else if (paramInt == 211)
      {
        paramInt = a.e.voip_errorhint_userbusy;
      }
      else
      {
        paramInt = 0;
      }
    }
    AA(paramInt);
  }
  
  public final void bQK()
  {
    if (this.qcH != null) {
      this.qcH.bQK();
    }
  }
  
  public final Context bRR()
  {
    return null;
  }
  
  public final void bRS() {}
  
  public final void bRT()
  {
    Toast.makeText(ae.getContext(), a.e.voip_net_status_warning_hint, 1).show();
  }
  
  public final byte[] bRU()
  {
    if ((this.qcH != null) && (this.qcH.getFilterData() != null)) {
      this.qcH.getFilterData().a(new b.7(this));
    }
    return this.buffer;
  }
  
  public final String bSI()
  {
    int i = (int)(System.currentTimeMillis() / 1000L - this.pSi);
    if (this.pSi == -1L) {
      i = 0;
    }
    if (i >= 3600) {}
    for (String str1 = String.format(Locale.US, "%d:%02d:%02d", new Object[] { Integer.valueOf(i / 3600), Integer.valueOf(i % 3600 / 60), Integer.valueOf(i % 60) });; str1 = String.format(Locale.US, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }))
    {
      String str2 = str1;
      if (bk.bl(str1)) {
        str2 = "00:00";
      }
      return str2;
    }
  }
  
  public final void bdl() {}
  
  public final void c(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((260 != this.mStatus) && (6 != this.mStatus)) {}
    while (this.qcH == null) {
      return;
    }
    this.qcH.c(paramInt1, paramInt2, paramArrayOfInt);
  }
  
  public final void en(int paramInt1, int paramInt2)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    y.i("MicroMsg.Voip.VoipSmallWindow", "newState: %s ", new Object[] { com.tencent.mm.plugin.voip.a.b.At(paramInt2) });
    if (paramInt2 == this.mStatus)
    {
      y.i("MicroMsg.Voip.VoipSmallWindow", "state unchange");
      return;
    }
    this.mStatus = paramInt2;
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
    case 2: 
    case 4: 
      y.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
      if (this.qcH == null) {}
      while ((localObject1 == null) || ((((Integer)localObject1).intValue() != 0) && (2 != ((Integer)localObject1).intValue()) && (4 != ((Integer)localObject1).intValue())))
      {
        localObject1 = ae.getContext().getString(a.e.voip_video_is_talking_tip);
        f((String)localObject1, (String)localObject1, "", true);
        if (this.qcG == null) {
          break;
        }
        this.qcG.a(this, 2);
        return;
        localObject1 = (Integer)this.qcH.getTag();
      }
    case 6: 
    case 260: 
      y.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
      this.qcL = true;
      if (-1L == this.qcK) {
        this.qcK = System.currentTimeMillis();
      }
      if (this.qcG != null) {
        this.qcG.a(this, 2);
      }
      if (!com.tencent.mm.compatible.f.b.bg(ae.getContext()))
      {
        y.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
        localObject1 = ae.getContext();
        RequestFloatWindowPermissionDialog.a(ae.getContext(), ((Context)localObject1).getString(a.e.voip_float_permission_alert_content), new RequestFloatWindowPermissionDialog.a()
        {
          public final void a(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
          {
            paramAnonymousRequestFloatWindowPermissionDialog.finish();
            paramAnonymousRequestFloatWindowPermissionDialog = ae.getContext().getString(a.e.voip_video_is_talking_tip);
            b.this.f(paramAnonymousRequestFloatWindowPermissionDialog, com.tencent.mm.model.r.gV(b.c(b.this).field_username), paramAnonymousRequestFloatWindowPermissionDialog, false);
            if ((com.tencent.mm.plugin.voip.a.b.Ay(b.d(b.this))) || (com.tencent.mm.plugin.voip.a.b.Aw(b.d(b.this)))) {
              b.e(b.this);
            }
          }
          
          public final void b(RequestFloatWindowPermissionDialog paramAnonymousRequestFloatWindowPermissionDialog)
          {
            paramAnonymousRequestFloatWindowPermissionDialog.finish();
          }
        });
        if (!com.tencent.mm.plugin.voip.b.bPx().pTA)
        {
          com.tencent.mm.plugin.voip.b.bPx().pTA = true;
          long l = com.tencent.mm.kernel.g.DP().Dz().Fm(327950);
          if (System.currentTimeMillis() - l > 86400000L)
          {
            com.tencent.mm.kernel.g.DP().Dz().setLong(327950, System.currentTimeMillis());
            y.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + "have not permission to showing floating window\n".length());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.spa).append("\n");
            localStringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.d.REV).append("\n");
            localStringBuilder.append("#accinfo.uin=").append(at.dVC.L("last_login_uin", bwL)).append("\n");
            localStringBuilder.append("#accinfo.dev=").append(bwK).append("\n");
            localStringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.d.TIME).append(":").append(com.tencent.mm.sdk.platformtools.d.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.e.bvj).append("\n");
            localObject1 = new Date();
            localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
            localStringBuilder.append("#accinfo.uploadTime=" + ((SimpleDateFormat)localObject3).format((Date)localObject1)).append("\n");
            localStringBuilder.append("#accinfo.content:\n");
            Intent localIntent = new Intent();
            localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
            localIntent.setAction("uncatch_exception");
            localIntent.putExtra("exceptionWriteSdcard", false);
            localIntent.putExtra("exceptionPid", Process.myPid());
            localObject3 = at.dVC.L("login_weixin_username", "");
            localObject1 = localObject3;
            if (bk.bl((String)localObject3)) {
              localObject1 = at.dVC.L("login_user_name", "never_login_crash");
            }
            localIntent.putExtra("userName", (String)localObject1);
            localIntent.putExtra("tag", "float_window_permission");
            localIntent.putExtra("exceptionMsg", Base64.encodeToString((localStringBuilder.toString() + "have not permission to showing floating window\n").getBytes(), 2));
            ae.getContext().startService(localIntent);
          }
        }
        label847:
        localObject1 = ae.getContext().getString(a.e.voip_video_is_talking_tip);
        f((String)localObject1, com.tencent.mm.model.r.gV(this.pSb.field_username), (String)localObject1, false);
      }
      break;
    }
    for (;;)
    {
      try
      {
        if (!com.tencent.mm.compatible.util.d.gF(28)) {
          break;
        }
        this.qcM = true;
        localObject1 = new Intent();
        ((Intent)localObject1).setClass(ae.getContext(), VoipSmallService.class);
        ae.getContext().bindService((Intent)localObject1, this, 1);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", localException, "bindSmallServiceIfNeed error: %s", new Object[] { localException.getMessage() });
        return;
      }
      bSH();
      break label847;
      y.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
      if (this.qcH == null) {}
      for (Object localObject2 = localObject3; (localObject2 == null) || ((256 != ((Integer)localObject2).intValue()) && (258 != ((Integer)localObject2).intValue())); localObject2 = (Integer)this.qcH.getTag())
      {
        localObject2 = ae.getContext().getString(a.e.voip_video_is_talking_tip);
        f((String)localObject2, (String)localObject2, "", true);
        if (this.qcG == null) {
          break;
        }
        this.qcG.a(this, 2);
        return;
      }
      switch (paramInt1)
      {
      default: 
        bSM();
        return;
      case 4106: 
        paramInt1 = a.e.voip_shutdown_tip;
      }
      for (;;)
      {
        AA(paramInt1);
        break;
        paramInt1 = a.e.voip_no_resp;
        continue;
        if (this.pSd) {
          paramInt1 = a.e.voip_video_call_rejected;
        } else {
          paramInt1 = a.e.voip_audio_call_rejected;
        }
      }
      if (2 == this.pSh) {
        AA(a.e.voip_audio_talking_hint);
      }
      bSM();
      localObject2 = ae.getContext().getString(a.e.voip_voice_is_talking_tip);
      f((String)localObject2, com.tencent.mm.model.r.gV(this.pSb.field_username), (String)localObject2, true);
      bSJ();
      if (this.qcG == null) {
        break;
      }
      this.qcG.a(this, 2);
      return;
      y.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
      if (-1L == this.qcK) {
        this.qcK = System.currentTimeMillis();
      }
      if (2 == this.pSh) {
        AA(a.e.voip_audio_talking_hint);
      }
      bSM();
      if (this.qcG != null) {
        this.qcG.a(this, 2);
      }
      this.qcI = new am(new b.3(this), true);
      this.qcI.S(5000L, 5000L);
      localObject2 = bSK();
      f((String)localObject2, com.tencent.mm.model.r.gV(this.pSb.field_username), (String)localObject2, false);
      bSJ();
      if (4101 == paramInt1) {
        AA(a.e.voip_switch_to_voice_hint);
      }
    }
  }
  
  public final void f(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    y.i("MicroMsg.Voip.VoipSmallWindow", "showNotification..show notification..tickContent:" + paramString1 + ",title:" + paramString2 + ",content:" + paramString3 + ",breathEffect:" + paramBoolean);
    y.b("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + paramBoolean, new Object[0]);
    if (paramBoolean)
    {
      this.qcI = new am(new b.6(this, paramString1, paramString2, paramString3), true);
      this.qcI.S(5000L, 5000L);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setClass(ae.getContext(), VideoActivity.class);
    ((Intent)localObject).putExtra("Voip_User", this.pSb.field_username);
    ((Intent)localObject).putExtra("Voip_Outcall", this.pSc);
    ((Intent)localObject).putExtra("Voip_VideoCall", this.pSd);
    localObject = PendingIntent.getActivity(ae.getContext(), 40, (Intent)localObject, 134217728);
    paramString1 = com.tencent.mm.plugin.voip.a.d.a(new Notification.Builder(ae.getContext()).setTicker(paramString1).setWhen(System.currentTimeMillis()).setContentTitle(paramString2).setContentText(paramString3).setContentIntent((PendingIntent)localObject).setOngoing(true));
    paramString1.icon = bSL();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(40, paramString1, false);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void setCaptureView(CaptureView paramCaptureView)
  {
    this.pRW = paramCaptureView;
    if ((this.qcH != null) && (this.pRW != null))
    {
      if ((this.pRW.getParent() != null) && ((this.pRW.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.pRW.getParent()).removeView(this.pRW);
      }
      this.qcH.setCaptureView(paramCaptureView);
    }
  }
  
  public final void setConnectSec(long paramLong)
  {
    this.pSi = paramLong;
    if (this.qcH != null) {
      this.qcH.setConnectSec(paramLong);
    }
    while ((261 != this.mStatus) && (7 != this.mStatus)) {
      return;
    }
    String str = bSK();
    f(str, com.tencent.mm.model.r.gV(this.pSb.field_username), str, false);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    if (this.qcH != null) {
      this.qcH.setHWDecMode(paramInt);
    }
    this.pYt = paramInt;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean) {}
  
  public final void setVoipBeauty(int paramInt)
  {
    if (this.qcH != null) {
      this.qcH.setVoipBeauty(paramInt);
    }
    this.pSD = paramInt;
  }
  
  public final void uninit()
  {
    int i = 3;
    y.i("MicroMsg.Voip.VoipSmallWindow", "uninit");
    h localh;
    long l;
    int j;
    if (-1L != this.qcK)
    {
      localh = h.nFQ;
      if (this.qcL) {
        i = 2;
      }
      l = (System.currentTimeMillis() - this.qcK) / 1000L;
      if (!this.pTC) {
        break label208;
      }
      j = 1;
    }
    for (;;)
    {
      localh.f(11620, new Object[] { Integer.valueOf(i), Long.valueOf(l), Integer.valueOf(j) });
      if ((this.qcJ != null) && (this.qcJ.isHeld())) {
        this.qcJ.release();
      }
      bSM();
      if (this.qcI != null) {
        this.qcI.stopTimer();
      }
      if (this.qcO != null) {
        this.qcO.stopTimer();
      }
      y.i("MicroMsg.Voip.VoipSmallWindow", "uninit..cancel notification..");
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
      try
      {
        if ((com.tencent.mm.compatible.util.d.gF(28)) && (this.qcM))
        {
          ae.getContext().unbindService(this);
          this.qcM = false;
        }
        this.pRW = null;
        return;
        label208:
        j = 2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Voip.VoipSmallWindow", localException, "unBind VoipSmallService error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b
 * JD-Core Version:    0.7.0.1
 */