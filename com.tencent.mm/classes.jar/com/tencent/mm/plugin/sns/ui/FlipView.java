package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.app.l;
import com.tencent.mm.app.l.a;
import com.tencent.mm.app.l.b;
import com.tencent.mm.autogen.a.be;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.df.a;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.pv;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.to;
import com.tencent.mm.autogen.a.tz;
import com.tencent.mm.autogen.mmdata.rpt.hj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ah;
import kotlin.r;

public abstract class FlipView
  extends LinearLayout
  implements c.b
{
  private IListener Ahp = new IListener(f.hfK) {};
  public ArrayList<ImageQBarDataBean> GYe = new ArrayList();
  public Long GYk = Long.valueOf(0L);
  public Long GYl = Long.valueOf(0L);
  private Long GYm = Long.valueOf(0L);
  protected br Qob = br.adkd;
  private double RcT = 0.0D;
  private double RcU = 0.0D;
  protected ab RcV;
  protected z.a RcW;
  protected int RcX;
  protected int RcY;
  private boolean RcZ = false;
  private long Rda = 0L;
  private boolean Rdb = false;
  boolean Rdc = false;
  boolean Rdd = false;
  com.tencent.mm.plugin.sns.ui.d.c Rde;
  private String Rdf;
  private String Rdg;
  private String Rdh;
  private String Rdi;
  private String Rdj;
  private String Rdk;
  private String Rdl;
  private long Rdm;
  private int Rdn = 0;
  public ImageQBarDataBean Rdo = null;
  public int Rdp = 0;
  private b Rdq;
  private c Rdr;
  private a Rds = new a();
  private IListener Rdt = new IListener(f.hfK) {};
  private Context context;
  protected MMHandler handler;
  protected int infoType = -1;
  private long mJI = 0L;
  protected View.OnLongClickListener onLongClickListener;
  
  public FlipView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public FlipView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private ImageQBarDataBean getQBarDataOnCurrentDisplay()
  {
    r localr = i.a(this.context, getCurrentImageView(), this.GYe, 0);
    if (((ArrayList)localr.bsC).size() == 1) {
      return (ImageQBarDataBean)((ArrayList)localr.bsC).get(0);
    }
    return null;
  }
  
  private SnsInfo getSnsInfo()
  {
    if ((this instanceof SnsInfoFlip))
    {
      if (((SnsInfoFlip)this).getFromScene().tag.equals(br.adjV.tag)) {
        return al.hgB().aZL(this.Rdg);
      }
      Log.e("MicroMsg.FlipView", "getFetchCodeInfoParam of SnsInfoFlip, getSnsInfo failed: " + Util.nullAsNil(this.Rdg));
    }
    return null;
  }
  
  private void hlW()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.RcX = localDisplayMetrics.widthPixels;
    this.RcY = localDisplayMetrics.heightPixels;
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.handler = new MMHandler();
    hlW();
    this.Ahp.alive();
    this.Rdt.alive();
  }
  
  /* Error */
  public static String j(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +118 -> 121
    //   6: aload_0
    //   7: ldc_w 488
    //   10: invokevirtual 746	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +108 -> 121
    //   16: new 222	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 812	com/tencent/mm/loader/i/b:bmL	()Ljava/lang/String;
    //   26: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 814
    //   32: iconst_3
    //   33: anewarray 504	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 816
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 819	java/lang/String:hashCode	()I
    //   48: invokestatic 509	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 821
    //   57: aastore
    //   58: invokestatic 515	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 823	com/tencent/mm/vfs/u
    //   72: dup
    //   73: invokestatic 826	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   76: invokevirtual 832	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 222	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 834
    //   86: invokespecial 750	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 839	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 842	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 845	com/tencent/mm/vfs/u:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 849	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   104: invokestatic 855	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: aload 6
    //   112: iconst_0
    //   113: invokestatic 859	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   116: lconst_0
    //   117: lcmp
    //   118: ifge +5 -> 123
    //   121: aconst_null
    //   122: areturn
    //   123: aload 6
    //   125: invokestatic 864	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   128: ifeq +215 -> 343
    //   131: aload 6
    //   133: invokestatic 868	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   136: astore 5
    //   138: aload 5
    //   140: ifnull +196 -> 336
    //   143: aload 7
    //   145: iconst_0
    //   146: invokestatic 872	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   149: astore_3
    //   150: aload_3
    //   151: astore 4
    //   153: aload 5
    //   155: getstatic 878	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   158: bipush 80
    //   160: aload_3
    //   161: invokevirtual 884	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   164: pop
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 889	java/io/OutputStream:close	()V
    //   173: aload 6
    //   175: invokestatic 892	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   178: pop
    //   179: iload_2
    //   180: ifne +15 -> 195
    //   183: aload_0
    //   184: aload 7
    //   186: iconst_0
    //   187: invokestatic 859	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   190: lconst_0
    //   191: lcmp
    //   192: iflt -71 -> 121
    //   195: aload 7
    //   197: aload_1
    //   198: invokestatic 897	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
    //   201: aload 7
    //   203: areturn
    //   204: astore 5
    //   206: aconst_null
    //   207: astore_3
    //   208: aload_3
    //   209: astore 4
    //   211: ldc 195
    //   213: aload 5
    //   215: ldc_w 488
    //   218: iconst_0
    //   219: anewarray 504	java/lang/Object
    //   222: invokestatic 901	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 889	java/io/OutputStream:close	()V
    //   233: aload 6
    //   235: invokestatic 892	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   238: pop
    //   239: iconst_0
    //   240: istore_2
    //   241: goto -62 -> 179
    //   244: astore 5
    //   246: aconst_null
    //   247: astore_3
    //   248: aload_3
    //   249: astore 4
    //   251: ldc 195
    //   253: aload 5
    //   255: ldc_w 488
    //   258: iconst_0
    //   259: anewarray 504	java/lang/Object
    //   262: invokestatic 901	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 889	java/io/OutputStream:close	()V
    //   273: aload 6
    //   275: invokestatic 892	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   278: pop
    //   279: iconst_0
    //   280: istore_2
    //   281: goto -102 -> 179
    //   284: astore_0
    //   285: aconst_null
    //   286: astore 4
    //   288: aload 4
    //   290: ifnull +8 -> 298
    //   293: aload 4
    //   295: invokevirtual 889	java/io/OutputStream:close	()V
    //   298: aload 6
    //   300: invokestatic 892	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   303: pop
    //   304: aload_0
    //   305: athrow
    //   306: astore_3
    //   307: goto -134 -> 173
    //   310: astore_3
    //   311: goto -78 -> 233
    //   314: astore_3
    //   315: goto -42 -> 273
    //   318: astore_1
    //   319: goto -21 -> 298
    //   322: astore_0
    //   323: goto -35 -> 288
    //   326: astore 5
    //   328: goto -80 -> 248
    //   331: astore 5
    //   333: goto -125 -> 208
    //   336: aconst_null
    //   337: astore_3
    //   338: iconst_0
    //   339: istore_2
    //   340: goto -175 -> 165
    //   343: iconst_0
    //   344: istore_2
    //   345: goto -166 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramString	String
    //   0	348	1	paramContext	Context
    //   1	344	2	i	int
    //   149	121	3	localOutputStream1	java.io.OutputStream
    //   306	1	3	localException1	java.lang.Exception
    //   310	1	3	localException2	java.lang.Exception
    //   314	1	3	localException3	java.lang.Exception
    //   337	1	3	localObject	Object
    //   151	143	4	localOutputStream2	java.io.OutputStream
    //   136	18	5	localBitmap	android.graphics.Bitmap
    //   204	10	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   244	10	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   326	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   331	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   107	192	6	str1	String
    //   67	135	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   131	138	204	java/io/FileNotFoundException
    //   143	150	204	java/io/FileNotFoundException
    //   131	138	244	java/lang/OutOfMemoryError
    //   143	150	244	java/lang/OutOfMemoryError
    //   131	138	284	finally
    //   143	150	284	finally
    //   169	173	306	java/lang/Exception
    //   229	233	310	java/lang/Exception
    //   269	273	314	java/lang/Exception
    //   293	298	318	java/lang/Exception
    //   153	165	322	finally
    //   211	225	322	finally
    //   251	265	322	finally
    //   153	165	326	java/lang/OutOfMemoryError
    //   153	165	331	java/io/FileNotFoundException
  }
  
  public final void EE(String paramString) {}
  
  public final void F(dmz paramdmz)
  {
    if (paramdmz == null) {}
    String str;
    do
    {
      return;
      str = com.tencent.mm.plugin.sns.model.as.mg(al.getAccSnsPath(), paramdmz.Id);
      paramdmz = t.k(paramdmz);
    } while (!y.ZC(str + paramdmz));
    bau(str + paramdmz);
  }
  
  public final void a(ImageQBarDataBean paramImageQBarDataBean, SnsInfo paramSnsInfo, String paramString)
  {
    this.Rdo = paramImageQBarDataBean;
    Log.i("MicroMsg.FlipView", "request deal QBAR string");
    if (paramImageQBarDataBean == null) {
      return;
    }
    df localdf = new df();
    localdf.hDa.activity = ((Activity)this.context);
    localdf.hDa.hBi = paramImageQBarDataBean.OGQ;
    localdf.hDa.hDb = paramImageQBarDataBean.hDb;
    localdf.hDa.hDc = paramImageQBarDataBean.hDc;
    localdf.hDa.hDg = paramImageQBarDataBean.filePath;
    paramImageQBarDataBean = com.tencent.mm.plugin.sns.model.ap.a(paramSnsInfo, paramString);
    if (paramImageQBarDataBean != null)
    {
      localdf.hDa.imagePath = paramImageQBarDataBean.Url;
      localdf.hDa.hDe = paramImageQBarDataBean.aaTA;
    }
    localdf.hDa.scene = 38;
    if ((this.context instanceof Activity)) {
      localdf.hDa.hDf = ((Activity)this.context).getIntent().getBundleExtra("_stat_obj");
    }
    paramSnsInfo = localdf.hDa.hDf;
    paramImageQBarDataBean = paramSnsInfo;
    if (paramSnsInfo == null)
    {
      Log.i("MicroMsg.FlipView", "addStatInfo4AppBrand, statObj is null");
      paramImageQBarDataBean = new Bundle();
      localdf.hDa.hDf = paramImageQBarDataBean;
    }
    Log.i("MicroMsg.FlipView", "addStatInfo4AppBrand, from sns");
    paramImageQBarDataBean.putInt("LaunchCodeScene_ScanScene", 2);
    if ((this instanceof SnsInfoFlip))
    {
      paramImageQBarDataBean = (SnsInfoFlip)this;
      paramSnsInfo = paramImageQBarDataBean.getFromScene();
      Log.d("MicroMsg.FlipView", "from Scene: %s", new Object[] { paramSnsInfo.tag });
      if ((!paramSnsInfo.tag.equals(br.adjW.tag)) && (!paramSnsInfo.tag.equals(br.adjX.tag)) && (!paramSnsInfo.tag.equals(br.adjY.tag))) {
        break label361;
      }
      localdf.hDa.sourceType = 5;
      if (Util.isNullOrNil(paramImageQBarDataBean.username))
      {
        Log.i("MicroMsg.FlipView", "empty username");
        paramImageQBarDataBean.username = "";
      }
      localdf.hDa.source = paramImageQBarDataBean.username;
    }
    for (;;)
    {
      localdf.publish();
      return;
      label361:
      if (paramSnsInfo.tag.equals(br.adjV.tag)) {
        localdf.hDa.sourceType = 3;
      } else {
        Log.i("MicroMsg.FlipView", "other scene_from: %s", new Object[] { paramSnsInfo.tag });
      }
    }
  }
  
  public final void aXr() {}
  
  public final void bau(String paramString)
  {
    if (y.ZC(paramString))
    {
      paramString = RecordConfigProvider.lj(paramString, "");
      if (this.Qob != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).ybL = -1;
        paramString.NIi = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.NIr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, b.a.sight_slide_bottom_in, -1, paramString, 1, 2);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent down");
      this.RcT = paramMotionEvent.getX();
      this.RcU = paramMotionEvent.getY();
      this.mJI = System.currentTimeMillis();
      if (com.tencent.mm.ui.base.g.au(paramMotionEvent) == 1) {
        this.RcZ = false;
      }
    }
    if (com.tencent.mm.ui.base.g.au(paramMotionEvent) > 1) {
      this.RcZ = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.RcZ))
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.mJI));
      long l = Util.currentTicks();
      Log.d("MicroMsg.FlipView", "deltTime: " + (l - this.Rda));
      if (l - this.Rda < 300L)
      {
        this.handler.removeCallbacks(this.Rds);
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97871);
            AppMethodBeat.o(97871);
          }
        });
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.Rda = l;
      if ((System.currentTimeMillis() - this.mJI < 500L) && (Math.abs(paramMotionEvent.getX() - this.RcT) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.RcU) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.RcY - 100))
      {
        a locala = this.Rds;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.Rds, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public dmz getCntMedia()
  {
    return null;
  }
  
  public View getCurrentImageView()
  {
    return null;
  }
  
  public abstract MMViewPager getGallery();
  
  public abstract int getPosition();
  
  public abstract String getSelectedMediaId();
  
  public abstract long getSnsId();
  
  public abstract boolean hlX();
  
  protected final void j(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = al.hgB().aZL(paramString2);
    if (localObject3 == null)
    {
      Log.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    int i;
    label45:
    int j;
    label53:
    ArrayList localArrayList2;
    label141:
    Object localObject1;
    Object localObject2;
    if (((SnsInfo)localObject3).getTypeFlag() == 21)
    {
      i = 1;
      if (i == 0) {
        break label500;
      }
      j = 1;
      if (this.Rde == null) {
        this.Rde = new com.tencent.mm.plugin.sns.ui.d.c((Activity)this.context, 4, j);
      }
      this.Rde.b((SnsInfo)localObject3, getCntMedia());
      localArrayList2 = new ArrayList();
      if (((SnsInfo)localObject3).getTypeFlag() != 21) {
        break label506;
      }
      if (!((SnsInfo)localObject3).getUserName().equals(z.bAM())) {
        localArrayList2.add(Integer.valueOf(1004));
      }
      localObject1 = new ArrayList();
      localArrayList1.addAll(localArrayList2);
      if (i == 0)
      {
        localObject2 = new ArrayList();
        if ((((SnsInfo)localObject3).field_type != 15) && (((SnsInfo)localObject3).field_type != 5)) {
          break label713;
        }
        ((List)localObject2).add(Integer.valueOf(1002));
      }
    }
    for (;;)
    {
      localObject1 = new ex();
      ((ex)localObject1).hFc.hES = paramString2;
      ((ex)localObject1).publish();
      if (((ex)localObject1).hFd.hEn) {
        ((List)localObject2).add(Integer.valueOf(1008));
      }
      localArrayList1.addAll((Collection)localObject2);
      localObject1 = localObject2;
      if (!Util.isNullOrNil(this.GYe))
      {
        com.tencent.mm.plugin.sns.ui.d.a.a(this.Rde, getCurrentImageView(), this.GYe);
        localObject1 = localObject2;
      }
      this.Rde.a(localArrayList2, (List)localObject1, new kotlin.g.a.a() {});
      this.Rde.bM(new kotlin.g.a.a() {});
      this.Rde.d(new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          FlipView.a(FlipView.this, paramString2, paramString3);
          AppMethodBeat.o(97874);
        }
      });
      this.Rde.e(new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(308106);
          FlipView.a(FlipView.this, paramAnonymousMenuItem, paramString2, paramString1, paramString3);
          AppMethodBeat.o(308106);
        }
      });
      this.Rde.dDn();
      if (this.Rdq != null) {
        this.Rdq.kJ(localArrayList1);
      }
      if ((!this.Rdb) || (!paramBoolean)) {
        break;
      }
      com.tencent.mm.kernel.h.baF();
      if (com.tencent.mm.kernel.h.baD().mCm.bFQ() == 0) {
        break;
      }
      this.Rdf = paramString1;
      this.Rdg = paramString2;
      this.Rdh = paramString3;
      paramString2 = new tm();
      this.Rdm = System.currentTimeMillis();
      paramString2.hXd.hBk = this.Rdm;
      paramString2.hXd.filePath = paramString1;
      paramString2.hXd.hXf = true;
      paramString2.publish();
      this.GYm = Long.valueOf(System.currentTimeMillis());
      return;
      i = 0;
      break label45;
      label500:
      j = 0;
      break label53;
      label506:
      localArrayList2.add(Integer.valueOf(1003));
      if (com.tencent.mm.br.c.blq("favorite")) {
        localArrayList2.add(Integer.valueOf(1006));
      }
      if ((((SnsInfo)localObject3).field_type != 1) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) || (!t.akt(this.Rdp)) || (aj.aBu())) {
        break label141;
      }
      localArrayList2.add(Integer.valueOf(1010));
      if (this.Rde.RdW) {
        break label141;
      }
      localObject1 = new com.tencent.mm.autogen.mmdata.rpt.ap();
      localObject2 = ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).kC("").kD(t.uA(getSnsId()));
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject2).ioZ = t.aku(this.Rdp);
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject2).ilm = 1;
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject2).imW = 81;
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).kE("");
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).kF("");
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).kG(com.tencent.mm.b.g.getMD5(paramString1));
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).ipe = System.currentTimeMillis();
      ((com.tencent.mm.autogen.mmdata.rpt.ap)localObject1).bMH();
      com.tencent.mm.plugin.websearch.api.as.a((com.tencent.mm.plugin.report.a)localObject1);
      break label141;
      label713:
      if (((SnsInfo)localObject3).field_type == 1)
      {
        ((List)localObject2).add(Integer.valueOf(1002));
        if (!ai.bao(paramString2)) {
          ((List)localObject2).add(Integer.valueOf(1012));
        }
        if (this.Rdc)
        {
          ((List)localObject2).add(Integer.valueOf(1009));
          localObject1 = new hj();
          ((hj)localObject1).ikE = 2L;
          if (!hlX()) {
            break label862;
          }
        }
        label862:
        for (((hj)localObject1).iOd = 6L;; ((hj)localObject1).iOd = 7L)
        {
          localObject3 = getCntMedia();
          if (localObject3 != null) {
            ((hj)localObject1).rq(((dmz)localObject3).Url);
          }
          ((hj)localObject1).bMH();
          if (!this.Rdd) {
            break;
          }
          ((List)localObject2).add(Integer.valueOf(1011));
          break;
        }
      }
      ((List)localObject2).add(Integer.valueOf(1014));
    }
  }
  
  protected void onDestroy()
  {
    this.Ahp.dead();
    this.Rdt.dead();
    tz localtz = new tz();
    localtz.hXO.activity = ((Activity)this.context);
    localtz.publish();
  }
  
  protected void onPause()
  {
    this.Rdf = null;
    this.Rdg = "";
    this.Rdh = null;
    if (this.Rdo != null)
    {
      be localbe = new be();
      localbe.hBh.activity = ((Activity)this.context);
      localbe.hBh.hBi = this.Rdo.OGQ;
      localbe.publish();
      this.Rdo = null;
    }
    this.GYe.clear();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedOCRImg(boolean paramBoolean)
  {
    this.Rdd = paramBoolean;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.Rdb = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.Rdc = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnMenuShowListener(b paramb)
  {
    this.Rdq = paramb;
  }
  
  public void setOnMultiCodeListener(c paramc)
  {
    this.Rdr = paramc;
  }
  
  public void w(String paramString, boolean paramBoolean) {}
  
  public void x(String paramString, boolean paramBoolean) {}
  
  final class a
    implements Runnable
  {
    float x;
    float y;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(97879);
      AppMethodBeat.o(97879);
    }
  }
  
  public static abstract interface b
  {
    public abstract void hlY();
    
    public abstract void kJ(List<Integer> paramList);
  }
  
  public static abstract interface c
  {
    public abstract boolean a(ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<PointF> paramArrayList, ArrayList<ImageQBarDataBean> paramArrayList2, SnsInfo paramSnsInfo, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */