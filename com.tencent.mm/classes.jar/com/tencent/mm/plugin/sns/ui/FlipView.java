package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.f.a.ay;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.sk;
import com.tencent.mm.f.a.wo;
import com.tencent.mm.f.a.xb;
import com.tencent.mm.f.a.xp;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.f.b.a.fo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements c.b
{
  public ArrayList<ImageQBarDataBean> BrI = new ArrayList();
  public Long BrO = Long.valueOf(0L);
  public Long BrP = Long.valueOf(0L);
  private Long BrQ = Long.valueOf(0L);
  protected bp JRq = bp.VGp;
  private String KDA;
  private String KDB;
  private String KDC;
  private String KDD;
  private String KDE;
  private String KDF;
  private String KDG;
  private long KDH;
  private int KDI = 0;
  public ImageQBarDataBean KDJ = null;
  private boolean KDK = false;
  public int KDL = 0;
  private b KDM;
  private c KDN;
  private a KDO = new a();
  private IListener KDP = new IListener() {};
  private double KDp = 0.0D;
  private double KDq = 0.0D;
  protected aa KDr;
  protected y.a KDs;
  protected int KDt;
  protected int KDu;
  private boolean KDv = false;
  private long KDw = 0L;
  private boolean KDx = false;
  boolean KDy = false;
  boolean KDz = false;
  protected View.OnLongClickListener aHT;
  private Context context;
  protected MMHandler handler;
  protected int infoType = -1;
  private long kje = 0L;
  private ScanCodeSheetItemLogic oxq;
  e rZT;
  private IListener wKS = new IListener() {};
  
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
  
  private void fTD()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.KDt = localDisplayMetrics.widthPixels;
    this.KDu = localDisplayMetrics.heightPixels;
  }
  
  private ImageQBarDataBean getQBarDataOnCurrentDisplay()
  {
    kotlin.o localo = i.a(this.context, getCurrentImageView(), this.BrI, 0);
    if (((ArrayList)localo.Mx).size() == 1) {
      return (ImageQBarDataBean)((ArrayList)localo.Mx).get(0);
    }
    return null;
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.handler = new MMHandler();
    fTD();
    EventCenter.instance.addListener(this.wKS);
    EventCenter.instance.addListener(this.KDP);
    this.oxq = new ScanCodeSheetItemLogic(paramContext);
  }
  
  /* Error */
  public static String k(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +114 -> 117
    //   6: aload_0
    //   7: ldc_w 361
    //   10: invokevirtual 367	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +104 -> 117
    //   16: new 369	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 370	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 376	com/tencent/mm/loader/j/b:aSX	()Ljava/lang/String;
    //   26: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 382
    //   32: iconst_3
    //   33: anewarray 384	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 386
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 389	java/lang/String:hashCode	()I
    //   48: invokestatic 394	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 396
    //   57: aastore
    //   58: invokestatic 400	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 405	com/tencent/mm/vfs/q
    //   72: dup
    //   73: invokestatic 411	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   76: invokevirtual 417	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 369	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 419
    //   86: invokespecial 421	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 427	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 430	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 403	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 433	com/tencent/mm/vfs/q:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 436	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   104: astore 6
    //   106: aload_0
    //   107: aload 6
    //   109: invokestatic 442	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifge +5 -> 119
    //   117: aconst_null
    //   118: areturn
    //   119: aload 6
    //   121: invokestatic 448	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   124: ifeq +215 -> 339
    //   127: aload 6
    //   129: invokestatic 452	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   132: astore 5
    //   134: aload 5
    //   136: ifnull +196 -> 332
    //   139: aload 7
    //   141: invokestatic 456	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   144: astore_3
    //   145: aload_3
    //   146: astore 4
    //   148: aload 5
    //   150: getstatic 462	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   153: bipush 80
    //   155: aload_3
    //   156: invokevirtual 468	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   159: pop
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 473	java/io/OutputStream:close	()V
    //   168: aload 6
    //   170: invokestatic 476	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   173: pop
    //   174: iload_2
    //   175: ifne +14 -> 189
    //   178: aload_0
    //   179: aload 7
    //   181: invokestatic 442	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   184: lconst_0
    //   185: lcmp
    //   186: iflt -69 -> 117
    //   189: aload 7
    //   191: aload_1
    //   192: invokestatic 482	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
    //   195: aload 7
    //   197: areturn
    //   198: astore 5
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: astore 4
    //   205: ldc_w 484
    //   208: aload 5
    //   210: ldc_w 361
    //   213: iconst_0
    //   214: anewarray 384	java/lang/Object
    //   217: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_3
    //   221: ifnull +7 -> 228
    //   224: aload_3
    //   225: invokevirtual 473	java/io/OutputStream:close	()V
    //   228: aload 6
    //   230: invokestatic 476	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   233: pop
    //   234: iconst_0
    //   235: istore_2
    //   236: goto -62 -> 174
    //   239: astore 5
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: astore 4
    //   246: ldc_w 484
    //   249: aload 5
    //   251: ldc_w 361
    //   254: iconst_0
    //   255: anewarray 384	java/lang/Object
    //   258: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 473	java/io/OutputStream:close	()V
    //   269: aload 6
    //   271: invokestatic 476	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   274: pop
    //   275: iconst_0
    //   276: istore_2
    //   277: goto -103 -> 174
    //   280: astore_0
    //   281: aconst_null
    //   282: astore 4
    //   284: aload 4
    //   286: ifnull +8 -> 294
    //   289: aload 4
    //   291: invokevirtual 473	java/io/OutputStream:close	()V
    //   294: aload 6
    //   296: invokestatic 476	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   299: pop
    //   300: aload_0
    //   301: athrow
    //   302: astore_3
    //   303: goto -135 -> 168
    //   306: astore_3
    //   307: goto -79 -> 228
    //   310: astore_3
    //   311: goto -42 -> 269
    //   314: astore_1
    //   315: goto -21 -> 294
    //   318: astore_0
    //   319: goto -35 -> 284
    //   322: astore 5
    //   324: goto -81 -> 243
    //   327: astore 5
    //   329: goto -127 -> 202
    //   332: aconst_null
    //   333: astore_3
    //   334: iconst_0
    //   335: istore_2
    //   336: goto -176 -> 160
    //   339: iconst_0
    //   340: istore_2
    //   341: goto -167 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramString	String
    //   0	344	1	paramContext	Context
    //   1	340	2	i	int
    //   144	122	3	localOutputStream1	java.io.OutputStream
    //   302	1	3	localException1	java.lang.Exception
    //   306	1	3	localException2	java.lang.Exception
    //   310	1	3	localException3	java.lang.Exception
    //   333	1	3	localObject	Object
    //   146	144	4	localOutputStream2	java.io.OutputStream
    //   132	17	5	localBitmap	android.graphics.Bitmap
    //   198	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   239	11	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   322	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   327	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   104	191	6	str1	String
    //   67	129	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   127	134	198	java/io/FileNotFoundException
    //   139	145	198	java/io/FileNotFoundException
    //   127	134	239	java/lang/OutOfMemoryError
    //   139	145	239	java/lang/OutOfMemoryError
    //   127	134	280	finally
    //   139	145	280	finally
    //   164	168	302	java/lang/Exception
    //   224	228	306	java/lang/Exception
    //   265	269	310	java/lang/Exception
    //   289	294	314	java/lang/Exception
    //   148	160	318	finally
    //   205	220	318	finally
    //   246	261	318	finally
    //   148	160	322	java/lang/OutOfMemoryError
    //   148	160	327	java/io/FileNotFoundException
  }
  
  public final void F(cvt paramcvt)
  {
    if (paramcvt == null) {}
    String str;
    do
    {
      return;
      str = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
      paramcvt = com.tencent.mm.plugin.sns.data.t.k(paramcvt);
    } while (!com.tencent.mm.vfs.u.agG(str + paramcvt));
    bbN(str + paramcvt);
  }
  
  public final void a(ImageQBarDataBean paramImageQBarDataBean, SnsInfo paramSnsInfo, String paramString)
  {
    Log.i("MicroMsg.FlipView", "request deal QBAR string");
    if (paramImageQBarDataBean == null) {
      return;
    }
    cv localcv = new cv();
    localcv.fyr.activity = ((Activity)this.context);
    localcv.fyr.fwI = paramImageQBarDataBean.IAH;
    localcv.fyr.fys = paramImageQBarDataBean.fys;
    localcv.fyr.fyt = paramImageQBarDataBean.fyt;
    localcv.fyr.fyx = paramImageQBarDataBean.filePath;
    paramImageQBarDataBean = an.a(paramSnsInfo, paramString);
    if (paramImageQBarDataBean != null)
    {
      localcv.fyr.imagePath = paramImageQBarDataBean.Url;
      localcv.fyr.fyv = paramImageQBarDataBean.TDU;
    }
    localcv.fyr.scene = 38;
    if ((this.context instanceof Activity)) {
      localcv.fyr.fyw = ((Activity)this.context).getIntent().getBundleExtra("_stat_obj");
    }
    if ((this instanceof SnsInfoFlip))
    {
      paramImageQBarDataBean = (SnsInfoFlip)this;
      paramSnsInfo = paramImageQBarDataBean.getFromScene();
      Log.d("MicroMsg.FlipView", "from Scene: %s", new Object[] { paramSnsInfo.tag });
      if ((!paramSnsInfo.tag.equals(bp.VGi.tag)) && (!paramSnsInfo.tag.equals(bp.VGj.tag)) && (!paramSnsInfo.tag.equals(bp.VGk.tag))) {
        break label306;
      }
      localcv.fyr.sourceType = 5;
      if (Util.isNullOrNil(paramImageQBarDataBean.username))
      {
        Log.i("MicroMsg.FlipView", "empty username");
        paramImageQBarDataBean.username = "";
      }
      localcv.fyr.source = paramImageQBarDataBean.username;
    }
    for (;;)
    {
      EventCenter.instance.publish(localcv);
      return;
      label306:
      if (paramSnsInfo.tag.equals(bp.VGh.tag)) {
        localcv.fyr.sourceType = 3;
      } else {
        Log.i("MicroMsg.FlipView", "other scene_from: %s", new Object[] { paramSnsInfo.tag });
      }
    }
  }
  
  public final void aYK(String paramString) {}
  
  public final void bbN(String paramString)
  {
    if (com.tencent.mm.vfs.u.agG(paramString))
    {
      paramString = RecordConfigProvider.jO(paramString, "");
      if (this.JRq != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).wwk = -1;
        paramString.HLk = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.HLr;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, i.a.sight_slide_bottom_in, -1, paramString, 1, 2);
    }
  }
  
  public void cq(String paramString, boolean paramBoolean) {}
  
  public void cr(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent down");
      this.KDp = paramMotionEvent.getX();
      this.KDq = paramMotionEvent.getY();
      this.kje = System.currentTimeMillis();
      if (f.ar(paramMotionEvent) == 1) {
        this.KDv = false;
      }
    }
    if (f.ar(paramMotionEvent) > 1) {
      this.KDv = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.KDv))
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.kje));
      long l = Util.currentTicks();
      Log.d("MicroMsg.FlipView", "deltTime: " + (l - this.KDw));
      if (l - this.KDw < 300L)
      {
        this.handler.removeCallbacks(this.KDO);
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
      this.KDw = l;
      if ((System.currentTimeMillis() - this.kje < 500L) && (Math.abs(paramMotionEvent.getX() - this.KDp) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.KDq) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.KDu - 100))
      {
        a locala = this.KDO;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.KDO, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void fLL() {}
  
  public abstract boolean fTE();
  
  public cvt getCntMedia()
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
  
  protected final void i(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = aj.fOI().bbl(paramString2);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (((SnsInfo)localObject1).getTypeFlag() == 21)
    {
      if (!((SnsInfo)localObject1).getUserName().equals(z.bcZ()))
      {
        localArrayList1.add(this.context.getString(i.j.sns_expose_sns));
        localArrayList2.add(Integer.valueOf(3));
      }
      if (this.rZT == null) {
        break label965;
      }
      if (this.KDK) {
        this.KDK = false;
      }
    }
    for (;;)
    {
      this.rZT.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(97872);
          FlipView.a(FlipView.this).setFooterView(null);
          paramAnonymouso.clear();
          int i = 0;
          if (i < localArrayList1.size())
          {
            if (((Integer)localArrayList2.get(i)).intValue() == 4) {
              FlipView.a(FlipView.this).setFooterView(FlipView.a(FlipView.this, paramString2, paramString3));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymouso.d(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
            }
          }
          AppMethodBeat.o(97872);
        }
      };
      this.rZT.XbB = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97873);
          if (FlipView.b(FlipView.this) != null) {
            FlipView.b(FlipView.this).fTF();
          }
          az localaz = new az();
          localaz.fwJ.fwK = FlipView.c(FlipView.this);
          localaz.fwJ.filePath = FlipView.d(FlipView.this);
          EventCenter.instance.publish(localaz);
          FlipView.e(FlipView.this);
          FlipView.f(FlipView.this);
          FlipView.g(FlipView.this);
          FlipView.h(FlipView.this);
          FlipView.i(FlipView.this);
          FlipView.j(FlipView.this);
          FlipView.a(FlipView.this, "");
          FlipView.k(FlipView.this);
          FlipView.this.KDJ = null;
          FlipView.this.BrI.clear();
          FlipView.l(FlipView.this);
          FlipView.m(FlipView.this).onDismiss();
          AppMethodBeat.o(97873);
        }
      };
      this.rZT.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          if (FlipView.b(FlipView.this) != null) {
            FlipView.b(FlipView.this).fTF();
          }
          Object localObject1 = aj.fOI().bbl(paramString2);
          if (localObject1 == null)
          {
            Log.i("MicroMsg.FlipView", "error beacause info null");
            AppMethodBeat.o(97874);
            return;
          }
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97874);
            return;
            if (((SnsInfo)localObject1).field_type != 15)
            {
              if (com.tencent.mm.plugin.sns.data.t.aLV(paramString1) == 4)
              {
                paramAnonymousMenuItem = com.tencent.mm.vfs.u.n(paramString1, false) + "_tmp";
                com.tencent.mm.vfs.u.bBD(com.tencent.mm.vfs.u.bBT(paramAnonymousMenuItem));
                ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(com.tencent.mm.vfs.u.n(paramString1, false), paramAnonymousMenuItem);
                com.tencent.mm.pluginsdk.ui.tools.u.n(paramAnonymousMenuItem, FlipView.n(FlipView.this));
              }
              for (;;)
              {
                FlipView.o(FlipView.this);
                AppMethodBeat.o(97874);
                return;
                com.tencent.mm.pluginsdk.ui.tools.u.n(paramString1, FlipView.n(FlipView.this));
              }
            }
            FlipView.bbO(paramString2);
            AppMethodBeat.o(97874);
            return;
            if (((SnsInfo)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Retr_File_Name", paramString1);
              paramAnonymousMenuItem.putExtra("Retr_Compress_Type", 0);
              paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 0);
              if (localObject1 != null)
              {
                paramAnonymousMenuItem.putExtra("Retr_FromMainTimeline", FlipView.this.fTE());
                paramAnonymousMenuItem.putExtra("Retr_KSnsId", com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1));
              }
              paramAnonymousMenuItem.putExtra("scene_from", 15);
              com.tencent.mm.plugin.sns.c.a.mIG.j(paramAnonymousMenuItem, FlipView.n(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            new StringBuilder().append(aq.kD(aj.getAccSnsPath(), paramString3)).append(com.tencent.mm.plugin.sns.data.t.d((cvt)((SnsInfo)localObject1).getTimeLine().ContentObj.Sqr.get(0)));
            FlipView.bbP(paramString2);
            AppMethodBeat.o(97874);
            return;
            if (((SnsInfo)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new dd();
              Object localObject2 = paramString2;
              String str = paramString3;
              if ((str == null) || (Util.isNullOrNil((String)localObject2)))
              {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                paramAnonymousMenuItem.fyI.fyO = i.j.favorite_fail_argument_error;
              }
              for (;;)
              {
                paramAnonymousMenuItem.fyI.fyP = 13;
                paramAnonymousMenuItem.fyI.activity = ((Activity)FlipView.n(FlipView.this));
                EventCenter.instance.publish(paramAnonymousMenuItem);
                if (FlipView.this.fTE())
                {
                  paramAnonymousMenuItem = new wo();
                  paramAnonymousMenuItem.fVI.fLp = com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1);
                  paramAnonymousMenuItem.fVI.fAg = ((SnsInfo)localObject1).getLocalid();
                  EventCenter.instance.publish(paramAnonymousMenuItem);
                }
                AppMethodBeat.o(97874);
                return;
                if (aj.isInValid())
                {
                  Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  paramAnonymousMenuItem.fyI.fyO = i.j.favorite_fail_system_error;
                }
                else
                {
                  localObject2 = aj.fOI().bbl((String)localObject2);
                  if (localObject2 == null)
                  {
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                    paramAnonymousMenuItem.fyI.fyO = i.j.favorite_fail_attachment_not_exists;
                  }
                  else
                  {
                    com.tencent.mm.plugin.sns.l.a.a(paramAnonymousMenuItem, (SnsInfo)localObject2, str);
                  }
                }
              }
            }
            if (localObject1 == null)
            {
              AppMethodBeat.o(97874);
              return;
            }
            if (!((SnsInfo)localObject1).isAd()) {
              FlipView.L(FlipView.this.fTE(), ((SnsInfo)localObject1).getLocalid());
            }
            for (;;)
            {
              if (FlipView.this.fTE())
              {
                paramAnonymousMenuItem = new wo();
                paramAnonymousMenuItem.fVI.fLp = com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1);
                paramAnonymousMenuItem.fVI.fAg = ((SnsInfo)localObject1).getLocalid();
                EventCenter.instance.publish(paramAnonymousMenuItem);
              }
              AppMethodBeat.o(97874);
              return;
              paramAnonymousMenuItem = new dd();
              com.tencent.mm.plugin.sns.l.a.a(paramAnonymousMenuItem, (SnsInfo)localObject1);
              paramAnonymousMenuItem.fyI.fyP = 14;
              paramAnonymousMenuItem.fyI.activity = ((Activity)FlipView.n(FlipView.this));
              EventCenter.instance.publish(paramAnonymousMenuItem);
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("k_expose_msg_id", FlipView.this.getSnsId());
            paramAnonymousMenuItem = aj.fOI().Rd(FlipView.this.getSnsId());
            if (paramAnonymousMenuItem == null) {}
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = paramAnonymousMenuItem.field_userName)
            {
              ((Intent)localObject1).putExtra("k_username", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("showShare", false);
              ((Intent)localObject1).putExtra("rawUrl", f.e.VRX + 33);
              ((Intent)localObject1).putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
              com.tencent.mm.by.c.b(FlipView.n(FlipView.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              AppMethodBeat.o(97874);
              return;
            }
            if (((SnsInfo)localObject1).getTimeLine().ContentObj.Sqr.size() == 0)
            {
              AppMethodBeat.o(97874);
              return;
            }
            paramAnonymousMenuItem = new Intent();
            if (((SnsInfo)localObject1).field_type == 1)
            {
              localObject1 = FlipView.k(paramString1, FlipView.n(FlipView.this));
              if (localObject1 == null)
              {
                AppMethodBeat.o(97874);
                return;
              }
              paramAnonymousMenuItem.putExtra("sns_send_data_ui_image_path", (String)localObject1);
              paramAnonymousMenuItem.putExtra("sns_send_data_ui_image_media_id", FlipView.this.getSelectedMediaId());
            }
            paramAnonymousMenuItem.putExtra("sns_send_data_ui_activity", true);
            paramAnonymousMenuItem.putExtra("sns_local_id", paramString2);
            com.tencent.mm.by.c.f(FlipView.n(FlipView.this), ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
            AppMethodBeat.o(97874);
            return;
            FlipView.this.bbN(paramString1);
            AppMethodBeat.o(97874);
            return;
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext()))
            {
              paramAnonymousMenuItem = new xp();
              paramAnonymousMenuItem.fWz.mediaId = paramString3;
              EventCenter.instance.publish(paramAnonymousMenuItem);
              paramAnonymousMenuItem = new fo();
              paramAnonymousMenuItem.gef = 3L;
              if (FlipView.this.fTE()) {}
              for (paramAnonymousMenuItem.gBe = 6L;; paramAnonymousMenuItem.gBe = 7L)
              {
                localObject1 = FlipView.this.getCntMedia();
                if (localObject1 != null) {
                  paramAnonymousMenuItem.uU(((cvt)localObject1).Url);
                }
                paramAnonymousMenuItem.bpa();
                AppMethodBeat.o(97874);
                return;
              }
              paramAnonymousMenuItem = aj.fOI().bbl(paramString2);
              localObject1 = new com.tencent.mm.plugin.websearch.api.o();
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).context = FlipView.n(FlipView.this);
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).fAh = paramString1;
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).PxI = paramAnonymousMenuItem.field_userName;
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).fLp = com.tencent.mm.plugin.sns.data.t.Qu(FlipView.this.getSnsId());
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).fyP = com.tencent.mm.plugin.sns.data.t.afF(FlipView.this.KDL);
              ((com.tencent.mm.plugin.websearch.api.o)localObject1).JVq = FlipView.this.getCntMedia();
              ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch((com.tencent.mm.plugin.websearch.api.o)localObject1);
              AppMethodBeat.o(97874);
              return;
              if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext()))
              {
                paramAnonymousMenuItem = new xb();
                paramAnonymousMenuItem.fVY.requestType = com.tencent.mm.plugin.sns.data.t.afG(FlipView.this.KDL);
                paramAnonymousMenuItem.fVY.mediaId = paramString3;
                paramAnonymousMenuItem.fVY.fcC = ((SnsInfo)localObject1).getUserName();
                EventCenter.instance.publish(paramAnonymousMenuItem);
              }
            }
          }
        }
      };
      this.rZT.eik();
      if (this.KDM != null) {
        this.KDM.hI(localArrayList2);
      }
      if ((!this.KDx) || (true != paramBoolean)) {
        break;
      }
      com.tencent.mm.kernel.h.aHH();
      if (com.tencent.mm.kernel.h.aHF().kcd.bih() == 0) {
        break;
      }
      this.KDA = paramString1;
      this.KDB = paramString2;
      this.KDC = paramString3;
      paramString2 = new rx();
      this.KDH = System.currentTimeMillis();
      paramString2.fRg.fwK = this.KDH;
      paramString2.fRg.filePath = paramString1;
      paramString2.fRg.fRi = true;
      EventCenter.instance.publish(paramString2);
      this.BrQ = Long.valueOf(System.currentTimeMillis());
      return;
      localArrayList1.add(this.context.getString(i.j.sns_post_to));
      localArrayList2.add(Integer.valueOf(1));
      if (com.tencent.mm.by.c.blP("favorite"))
      {
        localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
        localArrayList2.add(Integer.valueOf(2));
      }
      if ((((SnsInfo)localObject1).field_type == 15) || (((SnsInfo)localObject1).field_type == 5))
      {
        localArrayList1.add(this.context.getString(i.j.save_video_to_local));
        localArrayList2.add(Integer.valueOf(0));
      }
      for (;;)
      {
        Object localObject2 = new em();
        ((em)localObject2).fAp.fAg = paramString2;
        EventCenter.instance.publish((IEvent)localObject2);
        if (((em)localObject2).fAq.fzO)
        {
          localArrayList1.add(this.context.getString(i.j.app_open));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!y.bbH(paramString2)) && (((SnsInfo)localObject1).field_type == 1))
        {
          localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_photo_edit));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (!Util.isNullOrNil(this.BrI))
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(4));
        }
        if ((((SnsInfo)localObject1).field_type != 1) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) || (!com.tencent.mm.plugin.sns.data.t.afE(this.KDL))) {
          break;
        }
        localArrayList1.add(this.context.getString(i.j.find_friends_search));
        localArrayList2.add(Integer.valueOf(8));
        if (this.KDK) {
          break;
        }
        localObject1 = new ah();
        localObject2 = ((ah)localObject1).iX("").iY(com.tencent.mm.plugin.sns.data.t.Qu(getSnsId()));
        ((ah)localObject2).giu = com.tencent.mm.plugin.sns.data.t.afF(this.KDL);
        ((ah)localObject2).geN = 1;
        ((ah)localObject2).ggl = 81;
        ((ah)localObject1).iZ("");
        ((ah)localObject1).ja("");
        ((ah)localObject1).jb(com.tencent.mm.b.g.getMD5(paramString1));
        ((ah)localObject1).giA = System.currentTimeMillis();
        ((ah)localObject1).bpa();
        ar.a((com.tencent.mm.plugin.report.a)localObject1);
        break;
        if (((SnsInfo)localObject1).field_type == 1)
        {
          localArrayList1.add(this.context.getString(i.j.save_img_to_local));
          localArrayList2.add(Integer.valueOf(0));
          if (this.KDy)
          {
            localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_photo_trans));
            localArrayList2.add(Integer.valueOf(7));
            localObject2 = new fo();
            ((fo)localObject2).gef = 2L;
            if (!fTE()) {
              break label921;
            }
          }
          label921:
          for (((fo)localObject2).gBe = 6L;; ((fo)localObject2).gBe = 7L)
          {
            cvt localcvt = getCntMedia();
            if (localcvt != null) {
              ((fo)localObject2).uU(localcvt.Url);
            }
            ((fo)localObject2).bpa();
            if (!this.KDz) {
              break;
            }
            localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_image_ocr));
            localArrayList2.add(Integer.valueOf(9));
            break;
          }
        }
        localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
        localArrayList2.add(Integer.valueOf(0));
      }
      label965:
      this.rZT = new e(this.context, 1, false);
    }
  }
  
  protected void onDestroy()
  {
    EventCenter.instance.removeListener(this.wKS);
    EventCenter.instance.removeListener(this.KDP);
    sk localsk = new sk();
    localsk.fRT.activity = ((Activity)this.context);
    EventCenter.instance.publish(localsk);
  }
  
  protected void onPause()
  {
    this.KDA = null;
    this.KDB = "";
    this.KDC = null;
    if (this.KDJ != null)
    {
      ay localay = new ay();
      localay.fwH.activity = ((Activity)this.context);
      localay.fwH.fwI = this.KDJ.IAH;
      EventCenter.instance.publish(localay);
      this.KDJ = null;
    }
    this.BrI.clear();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedOCRImg(boolean paramBoolean)
  {
    this.KDz = paramBoolean;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.KDx = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.KDy = paramBoolean;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.aHT = paramOnLongClickListener;
  }
  
  public void setOnMenuShowListener(b paramb)
  {
    this.KDM = paramb;
  }
  
  public void setOnMultiCodeListener(c paramc)
  {
    this.KDN = paramc;
  }
  
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
    public abstract void fTF();
    
    public abstract void hI(List<Integer> paramList);
  }
  
  public static abstract interface c
  {
    public abstract boolean a(ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<PointF> paramArrayList, ArrayList<ImageQBarDataBean> paramArrayList2, SnsInfo paramSnsInfo, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */