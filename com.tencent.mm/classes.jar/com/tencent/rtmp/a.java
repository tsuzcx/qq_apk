package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.g;
import com.tencent.liteav.i;
import com.tencent.liteav.i.a;
import com.tencent.liteav.m;
import com.tencent.liteav.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONObject;

public class a
  implements com.tencent.liteav.basic.c.a
{
  private int A;
  private Vector<String> B;
  private long C;
  private TXLivePlayer.ITXAudioVolumeEvaluationListener D;
  private int E;
  private a F;
  private TXLivePlayer.ITXAudioRawDataListener G;
  private TXCloudVideoView a;
  private Surface b;
  private int c;
  private int d;
  private ITXLivePlayListener e;
  private TXLivePlayConfig f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private String k;
  private boolean l;
  private int m;
  private TXLivePlayer.ITXVideoRawDataListener n;
  private byte[] o;
  private Context p;
  private Handler q;
  private m r;
  private boolean s;
  private float t;
  private boolean u;
  private int v;
  private i w;
  private boolean x;
  private long y;
  private String z;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(14062);
    this.g = false;
    this.h = true;
    this.k = "";
    this.l = false;
    this.m = 100;
    this.n = null;
    this.o = null;
    this.s = true;
    this.t = 1.0F;
    this.u = false;
    this.v = 0;
    this.A = -1;
    this.B = new Vector();
    this.C = 0L;
    this.D = null;
    this.E = 0;
    this.F = null;
    this.e = null;
    this.p = paramContext.getApplicationContext();
    TXCCommonUtil.setAppContext(this.p);
    TXCLog.init();
    this.q = new Handler(Looper.getMainLooper());
    TXCCommonUtil.setAppContext(this.p);
    TXCLog.init();
    AppMethodBeat.o(14062);
  }
  
  private void a(final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(14099);
    if (paramITXSnapshotListener == null)
    {
      AppMethodBeat.o(14099);
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(14239);
        if (paramITXSnapshotListener != null) {
          paramITXSnapshotListener.onSnapshot(paramBitmap);
        }
        a.a(a.this, false);
        AppMethodBeat.o(14239);
      }
    });
    AppMethodBeat.o(14099);
  }
  
  private String c(String paramString, int paramInt)
  {
    AppMethodBeat.i(14098);
    Object localObject = paramString;
    if (paramInt != 6) {}
    label63:
    label88:
    label222:
    label228:
    for (;;)
    {
      StringBuilder localStringBuilder;
      int i1;
      try
      {
        localObject = paramString.getBytes("UTF-8");
        localStringBuilder = new StringBuilder(localObject.length);
        paramInt = 0;
        if (paramInt >= localObject.length) {
          break label118;
        }
        if (localObject[paramInt] >= 0) {
          break label222;
        }
        i1 = localObject[paramInt] + 256;
      }
      catch (Exception localException)
      {
        str = paramString;
      }
      localStringBuilder.append(String.format("%%%02X", new Object[] { Integer.valueOf(i1) }));
      break label215;
      localStringBuilder.append((char)i1);
      break label215;
      String str;
      for (;;)
      {
        paramString = str.trim();
        AppMethodBeat.o(14098);
        return paramString;
        label118:
        str = localStringBuilder.toString();
      }
      for (;;)
      {
        if ((i1 <= 32) || (i1 >= 127) || (i1 == 34) || (i1 == 37) || (i1 == 60) || (i1 == 62) || (i1 == 91) || (i1 == 125) || (i1 == 92) || (i1 == 93) || (i1 == 94) || (i1 == 96) || (i1 == 123)) {
          break label228;
        }
        if (i1 != 124) {
          break label88;
        }
        break label63;
        paramInt += 1;
        break;
        i1 = str[paramInt];
      }
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(14082);
    m localm;
    if (this.r != null)
    {
      localm = this.r;
      if (this.E <= 0) {
        break label112;
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      localm.d(bool);
      if (this.E > 0)
      {
        if (this.F == null) {
          this.F = new a(null);
        }
        this.F.a(this.E);
        if (this.q != null)
        {
          this.q.removeCallbacks(this.F);
          this.q.postDelayed(this.F, this.E);
        }
      }
      AppMethodBeat.o(14082);
      return;
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(14083);
    if (this.r != null) {
      this.r.d(false);
    }
    if (this.q != null) {
      this.q.removeCallbacks(this.F);
    }
    this.F = null;
    this.E = 0;
    AppMethodBeat.o(14083);
  }
  
  private boolean h()
  {
    AppMethodBeat.i(14097);
    if ((Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) && (Build.MODEL.equalsIgnoreCase("Che2-TL00")))
    {
      AppMethodBeat.o(14097);
      return true;
    }
    AppMethodBeat.o(14097);
    return false;
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(14079);
    if (this.r != null)
    {
      int i1 = this.r.a(paramString);
      AppMethodBeat.o(14079);
      return i1;
    }
    AppMethodBeat.o(14079);
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(14066);
    TXCLog.i("TXLivePlayer", "liteav_api startPlay ".concat(String.valueOf(this)));
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("TXLivePlayer", "start play error when url is empty ".concat(String.valueOf(this)));
      AppMethodBeat.o(14066);
      return -1;
    }
    if (!TextUtils.isEmpty(this.k))
    {
      if ((this.k.equalsIgnoreCase(paramString)) && (a()))
      {
        TXCLog.e("TXLivePlayer", "start play error when new url is the same with old url  ".concat(String.valueOf(this)));
        if (this.x) {
          onNotifyEvent(2004, new Bundle());
        }
        if (this.x)
        {
          AppMethodBeat.o(14066);
          return 0;
        }
        AppMethodBeat.o(14066);
        return -1;
      }
      TXCLog.w("TXLivePlayer", " stop old play when new url is not the same with old url  ".concat(String.valueOf(this)));
      if (this.r != null) {
        this.r.a(false);
      }
      this.k = "";
    }
    TXCDRApi.initCrashReport(this.p);
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "=====  StartPlay url = " + paramString + " playType = " + paramInt + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    TXCLog.i("TXLivePlayer", "===========================================================================================================================================================");
    if ((this.A == -1) || (this.A != paramInt)) {
      this.r = com.tencent.liteav.o.a(this.p, paramInt);
    }
    this.A = paramInt;
    if (this.r == null)
    {
      AppMethodBeat.o(14066);
      return -2;
    }
    this.k = c(paramString, paramInt);
    a(this.f);
    if (this.a != null)
    {
      this.a.clearLog();
      this.a.setVisibility(0);
    }
    this.r.a(this.a);
    this.r.a(this);
    this.r.e(this.s);
    if (this.b != null)
    {
      this.r.a(this.b);
      this.r.a(this.c, this.d);
    }
    this.r.a(this.k, paramInt);
    this.r.b(this.l);
    this.r.c(this.m);
    this.r.a(this.t);
    this.r.b(this.j);
    this.r.a(this.i);
    d(this.v);
    this.r.a(this.G);
    a(this.n);
    if (this.r.e())
    {
      this.z = this.k;
      if (this.w == null) {
        break label632;
      }
    }
    label632:
    for (long l1 = this.w.a();; l1 = 0L)
    {
      this.y = l1;
      if (this.y > 0L) {
        this.r.f();
      }
      paramString = this.B.iterator();
      while (paramString.hasNext())
      {
        String str = (String)paramString.next();
        TXCDRApi.reportEvent40003(this.k, 92007, 0, str, "");
      }
    }
    this.B.clear();
    TXCDRApi.reportEvent40003(this.k, 92007, 0, "startPlay:".concat(String.valueOf(paramInt)), "");
    f();
    AppMethodBeat.o(14066);
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    AppMethodBeat.i(14067);
    TXCLog.i("TXLivePlayer", "liteav_api stopPlay " + paramBoolean + ", " + this);
    if ((this.k != null) && (this.k.length() > 0)) {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, "stopPlay", "");
    }
    if ((paramBoolean) && (this.a != null)) {
      this.a.setVisibility(8);
    }
    g();
    if (this.r != null)
    {
      this.r.a(null);
      this.r.a(paramBoolean);
    }
    this.k = "";
    this.y = 0L;
    this.w = null;
    this.x = false;
    AppMethodBeat.o(14067);
    return 0;
  }
  
  @Deprecated
  public void a(float paramFloat)
  {
    AppMethodBeat.i(14095);
    TXCLog.i("TXLivePlayer", "liteav_api setRate ".concat(String.valueOf(paramFloat)));
    this.t = paramFloat;
    if (this.r != null) {
      this.r.a(paramFloat);
    }
    AppMethodBeat.o(14095);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(14073);
    TXCLog.i("TXLivePlayer", "liteav_api setRenderMode ".concat(String.valueOf(paramInt)));
    this.i = paramInt;
    if (this.r != null) {
      this.r.a(paramInt);
    }
    AppMethodBeat.o(14073);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14072);
    TXCLog.i("TXLivePlayer", "liteav_api setSurfaceSize " + paramInt1 + "x" + paramInt2 + ", " + this);
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.r != null) {
      this.r.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(14072);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(14071);
    TXCLog.i("TXLivePlayer", "liteav_api setSurface old : " + this.b + ", new : " + paramSurface + ", " + this);
    this.b = paramSurface;
    if (this.r != null) {
      this.r.a(this.b);
    }
    AppMethodBeat.o(14071);
  }
  
  public void a(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(14064);
    TXCLog.i("TXLivePlayer", "liteav_api setPlayListener ".concat(String.valueOf(this)));
    this.e = paramITXLivePlayListener;
    AppMethodBeat.o(14064);
  }
  
  public void a(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(14063);
    TXCLog.i("TXLivePlayer", "liteav_api setConfig ".concat(String.valueOf(this)));
    this.f = paramTXLivePlayConfig;
    if (this.f == null) {
      this.f = new TXLivePlayConfig();
    }
    if (this.r != null)
    {
      g localg = this.r.i();
      paramTXLivePlayConfig = localg;
      if (localg == null) {
        paramTXLivePlayConfig = new g();
      }
      paramTXLivePlayConfig.a = this.f.mCacheTime;
      paramTXLivePlayConfig.g = this.f.mAutoAdjustCacheTime;
      paramTXLivePlayConfig.c = this.f.mMinAutoAdjustCacheTime;
      paramTXLivePlayConfig.b = this.f.mMaxAutoAdjustCacheTime;
      paramTXLivePlayConfig.d = this.f.mVideoBlockThreshold;
      paramTXLivePlayConfig.e = this.f.mConnectRetryCount;
      paramTXLivePlayConfig.f = this.f.mConnectRetryInterval;
      paramTXLivePlayConfig.i = this.f.mEnableNearestIP;
      paramTXLivePlayConfig.l = this.f.mRtmpChannelType;
      paramTXLivePlayConfig.h = this.g;
      paramTXLivePlayConfig.m = this.f.mCacheFolderPath;
      paramTXLivePlayConfig.n = this.f.mMaxCacheItems;
      paramTXLivePlayConfig.j = this.f.mEnableMessage;
      paramTXLivePlayConfig.k = this.f.mEnableMetaData;
      paramTXLivePlayConfig.o = this.f.mHeaders;
      this.r.a(paramTXLivePlayConfig);
    }
    paramTXLivePlayConfig = "setConfig:" + this.f.mCacheTime + ":" + this.f.mAutoAdjustCacheTime + ":" + this.f.mMinAutoAdjustCacheTime + ":" + this.f.mMaxAutoAdjustCacheTime;
    if ((this.k != null) && (this.k.length() > 0))
    {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, paramTXLivePlayConfig, "");
      AppMethodBeat.o(14063);
      return;
    }
    this.B.add(paramTXLivePlayConfig);
    AppMethodBeat.o(14063);
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(14090);
    TXCLog.i("TXLivePlayer", "liteav_api setAudioRawDataListener ".concat(String.valueOf(paramITXAudioRawDataListener)));
    this.G = paramITXAudioRawDataListener;
    if (this.r != null) {
      this.r.a(paramITXAudioRawDataListener);
    }
    AppMethodBeat.o(14090);
  }
  
  public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.D = paramITXAudioVolumeEvaluationListener;
  }
  
  public void a(final TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(14087);
    TXCLog.i("TXLivePlayer", "liteav_api snapshot ".concat(String.valueOf(paramITXSnapshotListener)));
    if ((this.u) || (paramITXSnapshotListener == null))
    {
      AppMethodBeat.o(14087);
      return;
    }
    this.u = true;
    if (this.r != null)
    {
      this.r.a(new com.tencent.liteav.basic.d.o()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(182238);
          a.a(a.this, paramITXSnapshotListener, paramAnonymousBitmap);
          AppMethodBeat.o(182238);
        }
      });
      AppMethodBeat.o(14087);
      return;
    }
    this.u = false;
    AppMethodBeat.o(14087);
  }
  
  public void a(TXLivePlayer.ITXVideoRawDataListener paramITXVideoRawDataListener)
  {
    AppMethodBeat.i(14089);
    TXCLog.i("TXLivePlayer", "liteav_api setVideoRawDataListener ".concat(String.valueOf(paramITXVideoRawDataListener)));
    this.n = paramITXVideoRawDataListener;
    if (this.r == null)
    {
      AppMethodBeat.o(14089);
      return;
    }
    if (paramITXVideoRawDataListener != null)
    {
      this.r.a(new n()
      {
        public void onRenderVideoFrame(String paramAnonymousString, int paramAnonymousInt, TXSVideoFrame paramAnonymousTXSVideoFrame)
        {
          AppMethodBeat.i(13944);
          if ((paramAnonymousTXSVideoFrame == null) || (paramAnonymousTXSVideoFrame.width <= 0) || (paramAnonymousTXSVideoFrame.height <= 0))
          {
            AppMethodBeat.o(13944);
            return;
          }
          paramAnonymousString = a.e(a.this);
          a.a(a.this, null);
          TXLivePlayer.ITXVideoRawDataListener localITXVideoRawDataListener = a.f(a.this);
          if ((localITXVideoRawDataListener != null) && (paramAnonymousString != null))
          {
            if (paramAnonymousString.length >= paramAnonymousTXSVideoFrame.width * paramAnonymousTXSVideoFrame.height * 3 / 2)
            {
              paramAnonymousTXSVideoFrame.loadYUVArray(paramAnonymousString);
              localITXVideoRawDataListener.onVideoRawDataAvailable(paramAnonymousString, paramAnonymousTXSVideoFrame.width, paramAnonymousTXSVideoFrame.height, (int)paramAnonymousTXSVideoFrame.pts);
              paramAnonymousTXSVideoFrame.release();
              AppMethodBeat.o(13944);
              return;
            }
            TXCLog.e("TXLivePlayer", "raw data buffer length is too large");
          }
          AppMethodBeat.o(13944);
        }
      });
      AppMethodBeat.o(14089);
      return;
    }
    this.r.a(null);
    AppMethodBeat.o(14089);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(14065);
    TXCLog.i("TXLivePlayer", "liteav_api setPlayerView old view : " + this.a + ", new view : " + paramTXCloudVideoView + ", " + this);
    this.a = paramTXCloudVideoView;
    if (this.r != null) {
      this.r.a(paramTXCloudVideoView);
    }
    AppMethodBeat.o(14065);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    AppMethodBeat.i(14084);
    TXCLog.i("TXLivePlayer", "liteav_api setVideoRecordListener");
    if (this.r != null) {
      this.r.a(paramITXVideoRecordListener);
    }
    AppMethodBeat.o(14084);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(14068);
    if (this.r != null)
    {
      boolean bool = this.r.c();
      AppMethodBeat.o(14068);
      return bool;
    }
    AppMethodBeat.o(14068);
    return false;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(14088);
    if ((this.k == null) || (this.k.isEmpty()))
    {
      AppMethodBeat.o(14088);
      return false;
    }
    if (this.g)
    {
      TXLog.e("TXLivePlayer", "can not addVideoRawData because of hw decode has set!");
      AppMethodBeat.o(14088);
      return false;
    }
    if (this.r == null)
    {
      TXCLog.e("TXLivePlayer", "player hasn't created or not instanceof live player");
      AppMethodBeat.o(14088);
      return false;
    }
    this.o = paramArrayOfByte;
    AppMethodBeat.o(14088);
    return true;
  }
  
  public int b(String paramString, int paramInt)
  {
    AppMethodBeat.i(14091);
    TXCLog.i("TXLivePlayer", "liteav_api prepareLiveSeek ".concat(String.valueOf(this)));
    if (this.w == null) {
      this.w = new i();
    }
    if (this.w != null)
    {
      paramInt = this.w.a(this.k, paramString, paramInt, new i.a()
      {
        public void a(long paramAnonymousLong)
        {
          AppMethodBeat.i(14004);
          a.a(a.this, paramAnonymousLong);
          if (a.a(a.this) != null) {
            a.a(a.this).f();
          }
          AppMethodBeat.o(14004);
        }
      });
      AppMethodBeat.o(14091);
      return paramInt;
    }
    AppMethodBeat.o(14091);
    return -1;
  }
  
  public void b()
  {
    AppMethodBeat.i(14069);
    TXCLog.i("TXLivePlayer", "liteav_api pause ".concat(String.valueOf(this)));
    if ((this.k != null) && (this.k.length() > 0)) {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, "pause", "");
    }
    if (this.r != null)
    {
      TXCLog.w("TXLivePlayer", "pause play");
      this.r.a();
    }
    AppMethodBeat.o(14069);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(14074);
    TXCLog.i("TXLivePlayer", "liteav_api setRenderRotation ".concat(String.valueOf(paramInt)));
    this.j = paramInt;
    if (this.r != null) {
      this.r.b(paramInt);
    }
    AppMethodBeat.o(14074);
  }
  
  public void b(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(14081);
    String str;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        if (!localJSONObject.has("api"))
        {
          TXCLog.e("TXLivePlayer", "callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(paramString)));
          AppMethodBeat.o(14081);
          return;
        }
        str = localJSONObject.getString("api");
        Object localObject = null;
        if (localJSONObject.has("params")) {
          localObject = localJSONObject.getJSONObject("params");
        }
        if (!str.equals("muteRemoteAudioInSpeaker")) {
          break;
        }
        if (localObject == null)
        {
          TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]");
          AppMethodBeat.o(14081);
          return;
        }
        if (!((JSONObject)localObject).has("enable"))
        {
          TXCLog.e("TXLivePlayer", "muteRemoteAudioInSpeaker[lack parameter]: enable");
          AppMethodBeat.o(14081);
          return;
        }
        int i1 = ((JSONObject)localObject).getInt("enable");
        if (this.r != null)
        {
          localObject = this.r;
          if (i1 == 1) {
            ((m)localObject).c(bool);
          }
        }
        else
        {
          AppMethodBeat.o(14081);
          return;
        }
      }
      catch (Exception localException)
      {
        TXCLog.e("TXLivePlayer", "callExperimentalAPI[failed]: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(14081);
        return;
      }
      bool = false;
    }
    TXCLog.e("TXLivePlayer", "callExperimentalAPI[illegal api]: ".concat(String.valueOf(str)));
    AppMethodBeat.o(14081);
  }
  
  public boolean b(boolean paramBoolean)
  {
    AppMethodBeat.i(14075);
    TXCLog.i("TXLivePlayer", "liteav_api enableHardwareDecode ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT < 18)
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
        AppMethodBeat.o(14075);
        return false;
      }
      if (h())
      {
        TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
        AppMethodBeat.o(14075);
        return false;
      }
    }
    this.g = paramBoolean;
    if (this.r != null)
    {
      g localg2 = this.r.i();
      g localg1 = localg2;
      if (localg2 == null) {
        localg1 = new g();
      }
      localg1.h = this.g;
      this.r.a(localg1);
    }
    AppMethodBeat.o(14075);
    return true;
  }
  
  public void c()
  {
    AppMethodBeat.i(14070);
    TXCLog.i("TXLivePlayer", "liteav_api resume ".concat(String.valueOf(this)));
    if ((this.k != null) && (this.k.length() > 0)) {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, "resume", "");
    }
    if (this.r != null)
    {
      TXCLog.w("TXLivePlayer", "resume play");
      this.r.b();
      if (this.r.e()) {
        if (this.w == null) {
          break label139;
        }
      }
    }
    label139:
    for (long l1 = this.w.a();; l1 = 0L)
    {
      this.y = l1;
      if (this.y > 0L) {
        this.r.f();
      }
      d(this.v);
      AppMethodBeat.o(14070);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    int i1 = 100;
    AppMethodBeat.i(14077);
    if (paramInt < 0) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 100) {
        paramInt = i1;
      }
      for (;;)
      {
        TXCLog.i("TXLivePlayer", "liteav_api setVolume volume = ".concat(String.valueOf(paramInt)));
        this.m = paramInt;
        if ((this.k != null) && (this.k.length() > 0)) {
          TXCDRApi.reportEvent40003(this.k, 92007, 0, "setVolume:".concat(String.valueOf(paramInt)), "");
        }
        for (;;)
        {
          if (this.r != null) {
            this.r.c(paramInt);
          }
          AppMethodBeat.o(14077);
          return;
          this.B.add("setVolume:".concat(String.valueOf(paramInt)));
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(14076);
    TXCLog.i("TXLivePlayer", "liteav_api setMute ".concat(String.valueOf(paramBoolean)));
    this.l = paramBoolean;
    if ((this.k != null) && (this.k.length() > 0)) {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, "setMute:".concat(String.valueOf(paramBoolean)), "");
    }
    for (;;)
    {
      if (this.r != null) {
        this.r.b(paramBoolean);
      }
      AppMethodBeat.o(14076);
      return;
      this.B.add("setMute:".concat(String.valueOf(paramBoolean)));
    }
  }
  
  public int d()
  {
    AppMethodBeat.i(14086);
    TXCLog.i("TXLivePlayer", "liteav_api stopRecord ".concat(String.valueOf(this)));
    if (this.r != null)
    {
      int i1 = this.r.d();
      AppMethodBeat.o(14086);
      return i1;
    }
    AppMethodBeat.o(14086);
    return -1;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(14078);
    TXCLog.i("TXLivePlayer", "liteav_api setAudioRoute ".concat(String.valueOf(paramInt)));
    this.v = paramInt;
    if (this.r != null) {
      this.r.a(this.p, this.v);
    }
    AppMethodBeat.o(14078);
  }
  
  @Deprecated
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(14094);
    TXCLog.i("TXLivePlayer", "liteav_api setAutoPlay ".concat(String.valueOf(paramBoolean)));
    this.s = paramBoolean;
    AppMethodBeat.o(14094);
  }
  
  public int e()
  {
    AppMethodBeat.i(14093);
    TXCLog.i("TXLivePlayer", "liteav_api resumeLive ".concat(String.valueOf(this)));
    if (this.x)
    {
      this.x = false;
      int i1 = a(this.z, 1);
      AppMethodBeat.o(14093);
      return i1;
    }
    AppMethodBeat.o(14093);
    return -1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(14080);
    TXCLog.i("TXLivePlayer", "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(paramInt)));
    if ((this.k != null) && (this.k.length() > 0)) {
      TXCDRApi.reportEvent40003(this.k, 92007, 0, "enableAudioVolumeEvaluation:".concat(String.valueOf(paramInt)), "");
    }
    while (paramInt > 0)
    {
      int i1 = paramInt;
      if (paramInt < 100) {
        i1 = 100;
      }
      this.E = i1;
      f();
      AppMethodBeat.o(14080);
      return;
      this.B.add("enableAudioVolumeEvaluation:".concat(String.valueOf(paramInt)));
    }
    this.E = 0;
    g();
    AppMethodBeat.o(14080);
  }
  
  public int f(int paramInt)
  {
    AppMethodBeat.i(14085);
    TXCLog.i("TXLivePlayer", "liteav_api startRecord ".concat(String.valueOf(this)));
    if (Build.VERSION.SDK_INT < 18)
    {
      TXCLog.e("TXLivePlayer", "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
      AppMethodBeat.o(14085);
      return -3;
    }
    if (!a())
    {
      TXCLog.e("TXLivePlayer", "startRecord: there is no playing stream");
      AppMethodBeat.o(14085);
      return -1;
    }
    if (this.r != null)
    {
      paramInt = this.r.d(paramInt);
      AppMethodBeat.o(14085);
      return paramInt;
    }
    AppMethodBeat.o(14085);
    return -1;
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(14092);
    TXCLog.d("TXLivePlayer", "liteav_api seek ".concat(String.valueOf(paramInt)));
    if (this.r != null)
    {
      if ((this.r.e()) || (this.x))
      {
        String str;
        if (this.w != null)
        {
          str = this.w.a(paramInt);
          if (TextUtils.isEmpty(str)) {
            break label121;
          }
          if (a(str, 3) != 0) {
            break label116;
          }
        }
        label116:
        for (boolean bool = true;; bool = false)
        {
          this.x = bool;
          if (!this.x) {
            break label147;
          }
          this.y = (paramInt * 1000);
          AppMethodBeat.o(14092);
          return;
          str = "";
          break;
        }
        label121:
        if (this.e != null) {
          this.e.onPlayEvent(-2301, new Bundle());
        }
        label147:
        AppMethodBeat.o(14092);
        return;
      }
      this.r.e(paramInt);
    }
    AppMethodBeat.o(14092);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(14096);
    int i1;
    if (paramInt == 15001)
    {
      if (this.a != null) {
        this.a.setLogText(paramBundle, null, 0);
      }
      if (this.e != null)
      {
        this.e.onNetStatus(paramBundle);
        AppMethodBeat.o(14096);
      }
    }
    else
    {
      long l1;
      if (paramInt == 2005)
      {
        l1 = paramBundle.getInt("EVT_PLAY_PROGRESS_MS") + this.y;
        if (l1 > 0L)
        {
          paramBundle.putInt("EVT_PLAY_PROGRESS", (int)(l1 / 1000L));
          paramBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)l1);
          if (this.e != null) {
            this.e.onPlayEvent(paramInt, paramBundle);
          }
        }
        AppMethodBeat.o(14096);
        return;
      }
      if (paramInt != 2026)
      {
        l1 = System.currentTimeMillis();
        if (paramInt == 2101)
        {
          if (l1 - this.C < 5000L)
          {
            AppMethodBeat.o(14096);
            return;
          }
          this.C = l1;
        }
        if ((paramInt != 2005) && (paramInt != 2012) && (this.k != null) && (this.k.length() > 0))
        {
          String str2 = paramBundle.getString("EVT_MSG");
          String str3 = this.k;
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          TXCDRApi.reportEvent40003(str3, 92008, paramInt, str1, "");
        }
        i1 = paramInt;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14096);
          return;
        case 2007: 
          i1 = 2007;
        }
      }
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.setLogText(null, paramBundle, i1);
      }
      if (this.e != null) {
        this.e.onPlayEvent(i1, paramBundle);
      }
      AppMethodBeat.o(14096);
      return;
      i1 = 2004;
      continue;
      i1 = 2008;
      continue;
      i1 = 2106;
      continue;
      AppMethodBeat.o(14096);
      return;
      i1 = 2101;
      continue;
      i1 = -2304;
      continue;
      i1 = 2001;
      continue;
      i1 = 3003;
      continue;
      i1 = 3002;
      continue;
      i1 = 2103;
      continue;
      i1 = 2002;
      continue;
      i1 = 3002;
      continue;
      i1 = -2301;
      continue;
      i1 = -2302;
      continue;
      i1 = -2301;
      continue;
      i1 = 3005;
      continue;
      i1 = 2012;
      continue;
      i1 = 2015;
      continue;
      i1 = -2307;
      continue;
      i1 = 2005;
      continue;
      i1 = 2009;
      continue;
      i1 = 2028;
      continue;
      i1 = 2013;
    }
  }
  
  class a
    implements Runnable
  {
    private int b = 300;
    
    private a() {}
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      AppMethodBeat.i(14240);
      if ((a.a(a.this) != null) && (a.a(a.this).c()))
      {
        int i = a.a(a.this).h();
        if (a.b(a.this) != null) {
          a.b(a.this).onAudioVolumeEvaluationNotify(i);
        }
      }
      if ((a.c(a.this) != null) && (this.b > 0)) {
        a.c(a.this).postDelayed(a.d(a.this), this.b);
      }
      AppMethodBeat.o(14240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.rtmp.a
 * JD-Core Version:    0.7.0.1
 */