package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNI;
import com.tencent.map.lib.gl.JNICallback.a;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.map.lib.util.SystemUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class jc
  implements JNICallback.a, JNICallback.e, JNICallback.h, ku
{
  private static boolean i = true;
  private JNI a = new JNI();
  private long b;
  private jq c;
  private kw d = new kw();
  private ku e;
  private JNICallback.e f;
  private jh g;
  private long h = 0L;
  private int j = 0;
  private float k = 1.0F;
  
  public jc(Context paramContext, jh paramjh)
  {
    this.d.a(this);
    this.g = paramjh;
    this.k = paramContext.getResources().getDisplayMetrics().density;
    if (i) {
      ky.a(paramContext, "txmapengine");
    }
  }
  
  public int A()
  {
    if (0L == this.b) {
      return 1;
    }
    try
    {
      int m = this.a.nativeGetMapMode(this.b);
      return m;
    }
    finally {}
  }
  
  public void B()
  {
    if (this.f != null) {
      this.f.B();
    }
  }
  
  public void C()
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeClearRouteNameSegments(this.b);
      return;
    }
    finally {}
  }
  
  public int D()
  {
    if (this.b == 0L) {
      return 0;
    }
    try
    {
      int m = this.a.nativeGetLanguage(this.b);
      return m;
    }
    finally {}
  }
  
  public String E()
  {
    if (this.b == 0L) {
      return "";
    }
    return this.a.nativeGetDataEngineVersion(this.b);
  }
  
  public double a(Rect paramRect1, Rect paramRect2)
  {
    if (0L == this.b) {
      return 1.0D;
    }
    try
    {
      double d1 = this.a.nativeGetTargetScale(this.b, paramRect1, paramRect2);
      return d1;
    }
    finally {}
  }
  
  public int a(MaskLayer paramMaskLayer)
  {
    if (this.b == 0L) {
      return 0;
    }
    return this.a.nativeAddMaskLayer(this.b, paramMaskLayer);
  }
  
  public int a(Polygon2D paramPolygon2D)
  {
    if (this.b == 0L) {
      return 0;
    }
    try
    {
      int m = this.a.nativeAddPolygon(this.b, paramPolygon2D);
      return m;
    }
    finally {}
  }
  
  public int a(kd paramkd)
  {
    if (this.b == 0L) {
      return -1;
    }
    for (;;)
    {
      int m;
      boolean bool2;
      Object localObject1;
      try
      {
        n = paramkd.m();
        boolean bool1 = false;
        m = n;
        if (n == 3)
        {
          m = 0;
          bool1 = true;
        }
        bool2 = false;
        localObject1 = paramkd.c();
        if (localObject1[0] == 33)
        {
          n = 2;
          localObject1 = new int[0];
          if (paramkd.y() != null)
          {
            localObject2 = new int[paramkd.y().size()];
            m = 0;
            localObject1 = localObject2;
            if (m < paramkd.y().size())
            {
              localObject2[m] = ((Integer)paramkd.y().get(m)).intValue();
              m += 1;
              continue;
            }
          }
          Object localObject2 = new int[0];
          if (paramkd.f() != null)
          {
            int[] arrayOfInt = new int[paramkd.f().length];
            m = 0;
            localObject2 = arrayOfInt;
            if (m < paramkd.f().length)
            {
              arrayOfInt[m] = paramkd.f()[m];
              m += 1;
              continue;
            }
          }
          m = this.a.nativeCreateLine(this.b, paramkd.c(), paramkd.b(), (GeoPoint[])paramkd.a().toArray(new GeoPoint[0]), paramkd.q(), paramkd.n(), n, bool1, bool2, paramkd.l(), paramkd.j(), paramkd.t(), paramkd.d(), paramkd.e(), (int[])localObject2, paramkd.g(), (int[])localObject1, paramkd.o());
          return m;
        }
      }
      finally {}
      int n = m;
      if (localObject1[0] == 20)
      {
        bool2 = true;
        n = m;
      }
    }
  }
  
  public int a(String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    if (0L == this.b) {
      return 0;
    }
    try
    {
      paramInt = this.a.nativeAddMarker(this.b, paramString, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt);
      return paramInt;
    }
    finally {}
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (this.b == 0L) {
        return -1;
      }
      paramInt = this.a.nativeRefreshTrafficData(this.b, paramArrayOfByte, paramInt, paramBoolean1, paramBoolean2);
      return paramInt;
    }
    finally {}
  }
  
  public PointF a(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2)
  {
    if (this.b == 0L) {
      return new PointF();
    }
    try
    {
      float[] arrayOfFloat = new float[2];
      this.a.nativeToScreenLocation(this.b, paramArrayOfByte, paramDouble1, paramDouble2, arrayOfFloat);
      paramArrayOfByte = new PointF(arrayOfFloat[0], arrayOfFloat[1]);
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public GeoPoint a(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2)
  {
    if (this.b == 0L) {
      return new GeoPoint();
    }
    try
    {
      double[] arrayOfDouble = new double[2];
      this.a.nativeFromScreenLocation(this.b, paramArrayOfByte, paramFloat1, paramFloat2, arrayOfDouble);
      int m = (int)(arrayOfDouble[0] * 1000000.0D);
      paramArrayOfByte = new GeoPoint((int)(arrayOfDouble[1] * 1000000.0D), m);
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public TappedElement a(float paramFloat1, float paramFloat2)
  {
    if (this.b == 0L) {
      return null;
    }
    try
    {
      byte[] arrayOfByte1 = this.a.nativeOnTap(this.b, paramFloat1, paramFloat2);
      if (arrayOfByte1 == null) {
        return null;
      }
    }
    finally {}
    try
    {
      TappedElement localTappedElement = TappedElement.fromBytes(arrayOfByte2);
      return localTappedElement;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    if (this.b == 0L) {
      return "";
    }
    paramGeoPoint = this.a.nativeGetCityName(this.b, paramGeoPoint);
    if (paramGeoPoint != null) {
      try
      {
        paramGeoPoint = new String(paramGeoPoint, "GBK").trim();
        return paramGeoPoint;
      }
      catch (UnsupportedEncodingException paramGeoPoint) {}
    }
    return "";
  }
  
  public List<Integer> a(Rect paramRect, int paramInt)
  {
    if (0L == this.b) {
      return null;
    }
    try
    {
      int[] arrayOfInt = new int[100];
      int m = this.a.nativeQueryCityCodeList(this.b, paramRect, paramInt, arrayOfInt, 100);
      if (m > 0)
      {
        paramRect = new ArrayList(m);
        paramInt = 0;
        while (paramInt < m)
        {
          paramRect.add(Integer.valueOf(arrayOfInt[paramInt]));
          paramInt += 1;
        }
        return paramRect;
      }
    }
    finally {}
    return null;
  }
  
  public void a()
  {
    this.d.a();
    if (this.d != null) {
      this.d.a(null);
    }
    if (this.b != 0L) {
      try
      {
        this.a.nativeDestroyEngine(this.b);
        this.b = 0L;
        return;
      }
      finally {}
    }
  }
  
  public void a(double paramDouble)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.a.nativeSetScale(this.b, paramDouble, false);
  }
  
  public void a(final double paramDouble, boolean paramBoolean)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jh.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        jc.b(jc.this).nativeSetScale(jc.a(jc.this), paramDouble, this.b);
      }
    });
  }
  
  public void a(float paramFloat)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetRotate(this.b, paramFloat, false);
      return;
    }
    finally {}
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.5(this, paramFloat1, paramFloat2, paramBoolean));
  }
  
  public void a(int paramInt)
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeRemoveMaskLayer(this.b, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.b == 0L) || (paramInt1 < 0) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.1(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.b == 0L) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.16(this, paramInt1, paramInt2, paramInt3));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.13(this, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.b != 0L) {
      try
      {
        this.a.nativeCheckTrafficBlockCache(this.b, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        return;
      }
      finally {}
    }
  }
  
  public void a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2)
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.26(this, paramInt1, paramString, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt2));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.b == 0L) {}
    while (paramInt == -1) {
      return;
    }
    try
    {
      this.a.nativeDeleteLine(this.b, paramInt, paramBoolean);
      return;
    }
    finally {}
  }
  
  public void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.29(this, paramRect1, paramRect2, paramBoolean));
  }
  
  public void a(final GeoPoint paramGeoPoint, final boolean paramBoolean)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jh.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        jc.b(jc.this).nativeSetCenter(jc.a(jc.this), paramGeoPoint, paramBoolean);
      }
    });
  }
  
  public void a(JNICallback.b paramb)
  {
    this.a.setHandDrawTileLoadCallback(paramb);
  }
  
  public void a(JNICallback.c paramc)
  {
    this.a.setHandDrawTileWriteCallback(paramc);
  }
  
  public void a(JNICallback.d paramd)
  {
    this.a.setHeatTileLoadCallback(paramd);
  }
  
  public void a(JNICallback.e parame)
  {
    this.f = parame;
  }
  
  public void a(JNICallback.f paramf)
  {
    this.a.setMapCallbackGetGLContext(paramf);
  }
  
  public void a(JNICallback.j paramj)
  {
    this.a.setWorldTileLoadCallback(paramj);
  }
  
  public void a(JNICallback.k paramk)
  {
    this.a.setTileWriteCallback(paramk);
  }
  
  public void a(jq paramjq)
  {
    this.c = paramjq;
  }
  
  public void a(kt paramkt)
  {
    this.d.a(paramkt);
  }
  
  public void a(String paramString)
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jc.21(this, paramString));
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.b == 0L) {}
    do
    {
      return;
      this.a.nativeSetBuildingToSpecificFloor(this.b, paramString1, paramString2);
    } while (this.f == null);
    this.f.B();
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    this.g.a(new jc.22(this, paramString, paramArrayOfByte));
    if (this.e != null) {
      this.e.a(paramString, paramArrayOfByte);
    }
  }
  
  public void a(List<BlockRouteCityData> paramList)
  {
    if (0L == this.b) {
      return;
    }
    if (paramList != null) {}
    try
    {
      if (paramList.isEmpty()) {
        return;
      }
    }
    finally {}
    int n = paramList.size();
    int[] arrayOfInt1 = new int[n];
    int[] arrayOfInt2 = new int[n];
    int m = 0;
    for (;;)
    {
      if (m < n)
      {
        BlockRouteCityData localBlockRouteCityData = (BlockRouteCityData)paramList.get(m);
        if (localBlockRouteCityData != null)
        {
          arrayOfInt1[m] = localBlockRouteCityData.cityCode;
          arrayOfInt2[m] = localBlockRouteCityData.version;
        }
      }
      else
      {
        this.a.nativeLoadBlockRouteCityList(this.b, arrayOfInt1, arrayOfInt2, n);
        return;
      }
      m += 1;
    }
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    if (0L == this.b) {
      return;
    }
    if (paramList != null) {}
    for (;;)
    {
      int m;
      try
      {
        if ((!paramList.isEmpty()) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          int n = paramList.size();
          byte[][] arrayOfByte = new byte[n][];
          m = 0;
          if (m < n)
          {
            MapRouteSectionWithName localMapRouteSectionWithName = (MapRouteSectionWithName)paramList.get(m);
            if (localMapRouteSectionWithName != null) {
              arrayOfByte[m] = localMapRouteSectionWithName.toBytes();
            }
          }
          else
          {
            m = paramList1.size();
            this.a.nativeAddRouteNameSegments(this.b, arrayOfByte, n, (GeoPoint[])paramList1.toArray(new GeoPoint[m]), m);
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      m += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jc.6(this, paramBoolean));
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeDeleteIcons(this.b, paramArrayOfInt, paramInt);
      return;
    }
    finally {}
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (this.b == 0L) {
      return;
    }
    try
    {
      this.a.nativeSetShowIndoorBuildingWhiteList(this.b, paramArrayOfString);
      return;
    }
    finally {}
  }
  
  public boolean a(Context paramContext, jr paramjr, String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    boolean bool = ji.a();
    int[] arrayOfInt = new int[1];
    this.b = this.a.nativeInitEngine(paramString1, paramString2, paramString3, SystemUtil.getDensity(paramContext), 256, SystemUtil.getDensity(paramContext), arrayOfInt, bool, MapLanguage.LAN_CHINESE.ordinal());
    if (arrayOfInt[0] != 0)
    {
      d.a("init engine fail:" + arrayOfInt[0]);
      this.b = 0L;
      return false;
    }
    this.a.initCallback(paramjr, this, this, this, this.g.a(), this.b);
    this.a.nativeSetTrafficColor(this.b, -14803236, -15611905, -11088785, -16777063);
    return true;
  }
  
  public String b(GeoPoint paramGeoPoint)
  {
    if (0L == this.b) {
      return null;
    }
    try
    {
      paramGeoPoint = this.a.nativeGetCurIndoorName(this.b, paramGeoPoint);
      return paramGeoPoint;
    }
    finally {}
  }
  
  public void b(float paramFloat)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetSkew(this.b, paramFloat, false);
      return;
    }
    finally {}
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.9(this, paramFloat1, paramFloat2));
  }
  
  public void b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.12(this, paramBoolean, paramFloat1, paramFloat2));
  }
  
  public void b(int paramInt)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.3(this, paramInt));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeUpdateMaskLayer(this.b, paramInt1, paramInt2);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.14(this, paramInt, paramBoolean));
  }
  
  public void b(Polygon2D paramPolygon2D)
  {
    if (this.b == 0L) {
      return;
    }
    try
    {
      this.a.nativeUpdatePolygon(this.b, paramPolygon2D.polygonId, paramPolygon2D.borldLineId, paramPolygon2D);
      return;
    }
    finally {}
  }
  
  public void b(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    try
    {
      paramkd = paramkd.p();
      if (paramkd == null) {
        return;
      }
    }
    finally {}
    this.a.nativeSetTurnArrow(this.b, m, paramkd.a, paramkd.b);
  }
  
  public void b(String paramString)
  {
    this.j += 1;
    if (this.j >= 30)
    {
      m();
      this.j = 0;
    }
    this.g.a(new jc.24(this, paramString));
    if (this.e != null) {
      this.e.b(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (0L != this.b) {
      try
      {
        this.a.nativeSetBuilding3DEffect(this.b, paramBoolean);
        return;
      }
      finally {}
    }
  }
  
  public boolean b()
  {
    if (this.b == 0L) {
      return false;
    }
    return this.a.nativeGenerateTextures(this.b);
  }
  
  public int c(int paramInt, boolean paramBoolean)
  {
    if (this.b == 0L) {
      return -1;
    }
    try
    {
      paramInt = this.a.nativeAddHeatTileOverlay(this.b, paramInt, paramBoolean);
      return paramInt;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetMaxScaleLevel(this.b, paramInt);
      return;
    }
    finally {}
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.28(this, paramInt1, paramInt2));
  }
  
  public void c(GeoPoint paramGeoPoint)
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.a.nativeSetCenter(this.b, paramGeoPoint, false);
  }
  
  public void c(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    paramkd = paramkd.w();
    this.g.a(new jc.23(this, m, paramkd));
  }
  
  public void c(String paramString)
  {
    this.d.a(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.27(this, paramBoolean));
  }
  
  public boolean c()
  {
    if (this.b == 0L) {
      return false;
    }
    this.a.nativeDrawFrame(this.b);
    return true;
  }
  
  public int d()
  {
    if (this.b == 0L) {
      return -1;
    }
    return this.a.nativeClearCache(this.b);
  }
  
  public void d(int paramInt)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetMinScaleLevel(this.b, paramInt);
      return;
    }
    finally {}
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeBringElementAbove(this.b, paramInt1, paramInt2);
  }
  
  public void d(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    try
    {
      this.a.nativeSetLineDrawArrow(this.b, m, paramkd.j());
      return;
    }
    finally {}
  }
  
  public void d(String paramString)
  {
    if (this.b == 0L) {
      return;
    }
    try
    {
      this.a.nativeMapLoadKMLFile(this.b, paramString);
      return;
    }
    finally {}
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.b == 0L) || (this.g == null)) {
      return;
    }
    try
    {
      this.a.nativeIndoorBuildingEnabled(this.b, paramBoolean);
      return;
    }
    finally {}
  }
  
  public void e()
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeLockEngine(this.b);
  }
  
  public void e(int paramInt)
  {
    if ((this.b == 0L) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.17(this, paramInt));
  }
  
  public void e(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    try
    {
      this.a.nativeSetLineDirectionArrowTextureName(this.b, m, paramkd.u());
      return;
    }
    finally {}
  }
  
  public void e(final String paramString)
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jh.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        jc.b(jc.this).nativeSetServerHost(jc.a(jc.this), paramString);
      }
    });
  }
  
  public void e(boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.4(this, paramBoolean));
  }
  
  public void f()
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeUnlockEngine(this.b);
  }
  
  public void f(final int paramInt)
  {
    if ((this.b == 0L) || (this.g == null)) {
      return;
    }
    this.g.a(new jh.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        jc.b(jc.this).nativeReloadHeatTileOverlay(jc.a(jc.this), paramInt);
      }
    });
  }
  
  public void f(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    try
    {
      this.a.nativeSetDrawCap(this.b, m, paramkd.k());
      return;
    }
    finally {}
  }
  
  public void f(boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetNeedDisplay(this.b, paramBoolean);
      return;
    }
    finally {}
  }
  
  public void g(int paramInt)
  {
    if (this.g != null)
    {
      jo localjo = this.g.e();
      if (localjo != null) {
        localjo.a();
      }
    }
  }
  
  public void g(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    GeoPoint localGeoPoint;
    try
    {
      localGeoPoint = paramkd.h();
      if (localGeoPoint == null) {
        return;
      }
    }
    finally {}
    this.a.nativeLineInsertPoint(this.b, m, localGeoPoint, paramkd.i());
  }
  
  public void g(boolean paramBoolean)
  {
    if (0L == this.b) {
      return;
    }
    try
    {
      this.a.nativeSetBlockRouteVisible(this.b, paramBoolean);
      return;
    }
    finally {}
  }
  
  public boolean g()
  {
    if (this.b == 0L) {
      return true;
    }
    try
    {
      boolean bool = this.a.nativeIsMapDrawFinished(this.b);
      return bool;
    }
    finally {}
  }
  
  public void h(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while (m == -1);
    GeoPoint localGeoPoint;
    try
    {
      localGeoPoint = paramkd.h();
      if (localGeoPoint == null) {
        return;
      }
    }
    finally {}
    this.a.nativeLineClearPoint(this.b, m, localGeoPoint, paramkd.i());
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeEnablePOI(this.b, paramBoolean);
  }
  
  public TrafficRequestItem[] h()
  {
    if (this.b == 0L) {
      return null;
    }
    try
    {
      int[] arrayOfInt = this.a.nativeFetchLackedTrafficBlocks(this.b);
      if ((arrayOfInt == null) || (arrayOfInt.length == 0)) {
        return null;
      }
    }
    finally {}
    TrafficRequestItem[] arrayOfTrafficRequestItem = new TrafficRequestItem[localObject.length / 6];
    int m = 0;
    while (m < localObject.length / 6)
    {
      arrayOfTrafficRequestItem[m] = new TrafficRequestItem();
      arrayOfTrafficRequestItem[m].level = localObject[(m * 6)];
      arrayOfTrafficRequestItem[m].blockNo = localObject[(m * 6 + 1)];
      arrayOfTrafficRequestItem[m].minLon = localObject[(m * 6 + 2)];
      arrayOfTrafficRequestItem[m].minLat = localObject[(m * 6 + 3)];
      arrayOfTrafficRequestItem[m].maxLon = localObject[(m * 6 + 4)];
      arrayOfTrafficRequestItem[m].maxLat = localObject[(m * 6 + 5)];
      m += 1;
    }
    return arrayOfTrafficRequestItem;
  }
  
  public void i()
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jc.2(this));
  }
  
  public void i(kd paramkd)
  {
    if (this.b == 0L) {}
    int m;
    do
    {
      return;
      m = paramkd.r();
    } while ((m == -1) || (paramkd.v() < 0.0F));
    int n = paramkd.m();
    if ((n == 3) || (n == 0)) {
      try
      {
        this.a.nativeSetLineArrowSpacing(this.b, m, paramkd.v());
        return;
      }
      finally {}
    }
    try
    {
      this.a.nativeSetLineFootPrintSpacing(this.b, m, paramkd.v());
      return;
    }
    finally {}
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.b == 0L) {
      return;
    }
    this.a.nativeEnableVectorMap(this.b, paramBoolean);
  }
  
  public void j()
  {
    if (this.b != 0L) {
      try
      {
        this.a.nativeHideStreetRoad(this.b);
        return;
      }
      finally {}
    }
  }
  
  public void k()
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jc.15(this));
  }
  
  public void l()
  {
    if (this.b == 0L) {
      return;
    }
    this.g.a(new jc.20(this));
  }
  
  public void m()
  {
    if (this.b != 0L) {
      this.g.a(new jc.11(this));
    }
  }
  
  public void n()
  {
    if (0L == this.b) {
      return;
    }
    this.g.a(new jc.25(this));
  }
  
  public int o()
  {
    if (0L == this.b) {
      return -1;
    }
    try
    {
      int m = this.a.nativeGetIndoorCurrentFloorId(this.b);
      return m;
    }
    finally {}
  }
  
  public String[] p()
  {
    if (0L == this.b) {
      return null;
    }
    try
    {
      String[] arrayOfString = this.a.nativeGetIndoorFloorNames(this.b);
      return arrayOfString;
    }
    finally {}
  }
  
  public kc q()
  {
    if (0L == this.b) {
      return null;
    }
    try
    {
      this.a.nativeLockEngine(this.b);
      Object localObject1 = this.a.nativeGetActiveIndoorBuildingGUID(this.b);
      String str = this.a.nativeGetCurIndoorName(this.b, new GeoPoint(0, 0));
      int m = this.a.nativeGetIndoorCurrentFloorId(this.b);
      String[] arrayOfString = this.a.nativeGetIndoorFloorNames(this.b);
      this.a.nativeUnlockEngine(this.b);
      localObject1 = new kc((String)localObject1, str, arrayOfString, m);
      return localObject1;
    }
    finally {}
  }
  
  public String r()
  {
    if (this.b == 0L) {
      return null;
    }
    try
    {
      String str = this.a.nativeGetActiveIndoorBuildingGUID(this.b);
      return str;
    }
    finally {}
  }
  
  public GeoPoint s()
  {
    if (0L == this.b) {
      return null;
    }
    try
    {
      GeoPoint localGeoPoint = new GeoPoint();
      this.a.nativeGetCenterMapPoint(this.b, localGeoPoint);
      return localGeoPoint;
    }
    finally {}
  }
  
  public float t()
  {
    if (0L == this.b) {
      return 1.0F;
    }
    try
    {
      float f1 = (float)this.a.nativeGetScale(this.b);
      return f1;
    }
    finally {}
  }
  
  public int u()
  {
    if (0L == this.b) {
      return 20;
    }
    try
    {
      int m = this.a.nativeGetScaleLevel(this.b);
      return m;
    }
    finally {}
  }
  
  public void v()
  {
    if ((0L == this.b) || (this.g == null)) {
      return;
    }
    this.g.a(new jc.10(this));
  }
  
  public void w()
  {
    if (0L == this.b) {
      return;
    }
    for (;;)
    {
      long l;
      try
      {
        l = System.currentTimeMillis();
        if (this.h == 0L)
        {
          this.a.nativeUpdateFrame(this.b, 0.0D);
          this.h = l;
          return;
        }
      }
      finally {}
      this.a.nativeUpdateFrame(this.b, l - this.h);
    }
  }
  
  public boolean x()
  {
    if (0L == this.b) {
      return false;
    }
    try
    {
      boolean bool = this.a.nativeNeedDispaly(this.b);
      return bool;
    }
    finally {}
  }
  
  public float y()
  {
    if (0L == this.b) {
      return 0.0F;
    }
    return this.a.nativeGetSkew(this.b);
  }
  
  public float z()
  {
    if (0L == this.b) {
      return 0.0F;
    }
    return this.a.nativeGetRotate(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jc
 * JD-Core Version:    0.7.0.1
 */