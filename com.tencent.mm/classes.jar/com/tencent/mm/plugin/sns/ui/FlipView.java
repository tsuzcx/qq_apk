package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements View.OnTouchListener, b.b
{
  private Context context;
  private int cpE;
  private int cpF;
  private long ePF = 0L;
  protected ak handler;
  protected int infoType = -1;
  private c mwt = new FlipView.6(this);
  private String rGA;
  private String rGB;
  private boolean rGC = false;
  private FlipView.a rGD = new FlipView.a(this);
  float rGE = 0.0F;
  float rGF = 0.0F;
  boolean rGG = false;
  float rGH = 1.0F;
  private c rGI = new c() {};
  private double rGm = 0.0D;
  private double rGn = 0.0D;
  protected u rGo;
  protected s.a rGp;
  protected int rGq;
  protected int rGr;
  private boolean rGs = false;
  private long rGt = 0L;
  private boolean rGu = false;
  private com.tencent.mm.ui.widget.b.d rGv;
  private String rGw;
  private String rGx;
  private String rGy;
  private String rGz;
  protected az rbm = az.yNU;
  
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
  
  private void ctx()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.rGq = localDisplayMetrics.widthPixels;
    this.rGr = localDisplayMetrics.heightPixels;
  }
  
  /* Error */
  public static String h(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +114 -> 117
    //   6: aload_0
    //   7: ldc_w 308
    //   10: invokevirtual 314	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +104 -> 117
    //   16: new 316	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 317	java/lang/StringBuilder:<init>	()V
    //   23: getstatic 322	com/tencent/mm/compatible/util/e:esr	Ljava/lang/String;
    //   26: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 328
    //   32: iconst_3
    //   33: anewarray 330	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 332
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 336	java/lang/String:hashCode	()I
    //   48: invokestatic 342	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 344
    //   57: aastore
    //   58: invokestatic 348	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 326	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 354	java/io/File
    //   72: dup
    //   73: invokestatic 360	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   76: invokevirtual 364	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 316	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 366
    //   86: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 377	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 380	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 383	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   104: astore 6
    //   106: aload_0
    //   107: aload 6
    //   109: invokestatic 389	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   112: lconst_0
    //   113: lcmp
    //   114: ifge +5 -> 119
    //   117: aconst_null
    //   118: areturn
    //   119: aload 6
    //   121: invokestatic 394	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   124: ifeq +229 -> 353
    //   127: aload 6
    //   129: invokestatic 398	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   132: astore 5
    //   134: aload 5
    //   136: ifnull +210 -> 346
    //   139: aload 7
    //   141: iconst_0
    //   142: invokestatic 402	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   145: astore_3
    //   146: aload_3
    //   147: astore 4
    //   149: aload 5
    //   151: getstatic 408	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   154: bipush 80
    //   156: aload_3
    //   157: invokevirtual 414	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   160: pop
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 419	java/io/OutputStream:close	()V
    //   169: aload 6
    //   171: invokestatic 422	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   174: pop
    //   175: iload_2
    //   176: ifne +14 -> 190
    //   179: aload_0
    //   180: aload 7
    //   182: invokestatic 389	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   185: lconst_0
    //   186: lcmp
    //   187: iflt -70 -> 117
    //   190: aload_1
    //   191: new 424	android/content/Intent
    //   194: dup
    //   195: ldc_w 426
    //   198: aload 7
    //   200: invokestatic 430	com/tencent/mm/vfs/e:avH	(Ljava/lang/String;)Landroid/net/Uri;
    //   203: invokespecial 433	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   206: invokevirtual 437	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   209: aload 7
    //   211: areturn
    //   212: astore 5
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: astore 4
    //   219: ldc_w 439
    //   222: aload 5
    //   224: ldc_w 308
    //   227: iconst_0
    //   228: anewarray 330	java/lang/Object
    //   231: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload_3
    //   235: ifnull +7 -> 242
    //   238: aload_3
    //   239: invokevirtual 419	java/io/OutputStream:close	()V
    //   242: aload 6
    //   244: invokestatic 422	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   247: pop
    //   248: iconst_0
    //   249: istore_2
    //   250: goto -75 -> 175
    //   253: astore 5
    //   255: aconst_null
    //   256: astore_3
    //   257: aload_3
    //   258: astore 4
    //   260: ldc_w 439
    //   263: aload 5
    //   265: ldc_w 308
    //   268: iconst_0
    //   269: anewarray 330	java/lang/Object
    //   272: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: aload_3
    //   276: ifnull +7 -> 283
    //   279: aload_3
    //   280: invokevirtual 419	java/io/OutputStream:close	()V
    //   283: aload 6
    //   285: invokestatic 422	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   288: pop
    //   289: iconst_0
    //   290: istore_2
    //   291: goto -116 -> 175
    //   294: astore_0
    //   295: aconst_null
    //   296: astore 4
    //   298: aload 4
    //   300: ifnull +8 -> 308
    //   303: aload 4
    //   305: invokevirtual 419	java/io/OutputStream:close	()V
    //   308: aload 6
    //   310: invokestatic 422	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   313: pop
    //   314: aload_0
    //   315: athrow
    //   316: astore_3
    //   317: goto -148 -> 169
    //   320: astore_3
    //   321: goto -79 -> 242
    //   324: astore_3
    //   325: goto -42 -> 283
    //   328: astore_1
    //   329: goto -21 -> 308
    //   332: astore_0
    //   333: goto -35 -> 298
    //   336: astore 5
    //   338: goto -81 -> 257
    //   341: astore 5
    //   343: goto -127 -> 216
    //   346: aconst_null
    //   347: astore_3
    //   348: iconst_0
    //   349: istore_2
    //   350: goto -189 -> 161
    //   353: iconst_0
    //   354: istore_2
    //   355: goto -180 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	paramString	String
    //   0	358	1	paramContext	Context
    //   1	354	2	i	int
    //   145	135	3	localOutputStream1	java.io.OutputStream
    //   316	1	3	localException1	java.lang.Exception
    //   320	1	3	localException2	java.lang.Exception
    //   324	1	3	localException3	java.lang.Exception
    //   347	1	3	localObject	Object
    //   147	157	4	localOutputStream2	java.io.OutputStream
    //   132	18	5	localBitmap	android.graphics.Bitmap
    //   212	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   253	11	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   336	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   341	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   104	205	6	str1	String
    //   67	143	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   127	134	212	java/io/FileNotFoundException
    //   139	146	212	java/io/FileNotFoundException
    //   127	134	253	java/lang/OutOfMemoryError
    //   139	146	253	java/lang/OutOfMemoryError
    //   127	134	294	finally
    //   139	146	294	finally
    //   165	169	316	java/lang/Exception
    //   238	242	320	java/lang/Exception
    //   279	283	324	java/lang/Exception
    //   303	308	328	java/lang/Exception
    //   149	161	332	finally
    //   219	234	332	finally
    //   260	275	332	finally
    //   149	161	336	java/lang/OutOfMemoryError
    //   149	161	341	java/io/FileNotFoundException
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.handler = new ak();
    ctx();
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    com.tencent.mm.sdk.b.a.ymk.c(this.rGI);
  }
  
  public final void E(bcs parambcs)
  {
    if (parambcs == null) {}
    String str;
    do
    {
      return;
      str = ao.gl(ag.getAccSnsPath(), parambcs.Id);
      parambcs = i.l(parambcs);
    } while (!e.cN(str + parambcs));
    abU(str + parambcs);
  }
  
  public final void ZU(String paramString) {}
  
  public final void abU(String paramString)
  {
    if (e.cN(paramString))
    {
      paramString = RecordConfigProvider.fS(paramString, "");
      if (this.rbm != null)
      {
        localObject = new VideoCaptureReportInfo();
        if (this.rbm.equals(az.yNO)) {
          ((VideoCaptureReportInfo)localObject).mhr = 2;
        }
        if ((this.rbm.equals(az.yNN)) || (this.rbm.equals(az.yNM))) {
          ((VideoCaptureReportInfo)localObject).mhr = 1;
        }
        paramString.qbE = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, paramString, 1, 2);
    }
  }
  
  public void bp(String paramString, boolean paramBoolean) {}
  
  public void bq(String paramString, boolean paramBoolean) {}
  
  public final void cnV() {}
  
  public abstract boolean cty();
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ab.d("MicroMsg.FlipView", "onTouchEvent down");
      this.rGm = paramMotionEvent.getX();
      this.rGn = paramMotionEvent.getY();
      this.ePF = System.currentTimeMillis();
      if (f.T(paramMotionEvent) == 1) {
        this.rGs = false;
      }
    }
    if (f.T(paramMotionEvent) > 1) {
      this.rGs = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.rGs))
    {
      ab.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.ePF));
      long l = bo.yB();
      ab.d("MicroMsg.FlipView", "deltTime: " + (l - this.rGt));
      if (l - this.rGt < 300L)
      {
        this.handler.removeCallbacks(this.rGD);
        this.handler.post(new FlipView.1(this));
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.rGt = l;
      if ((System.currentTimeMillis() - this.ePF < 500L) && (Math.abs(paramMotionEvent.getX() - this.rGm) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.rGn) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.rGr - 100))
      {
        FlipView.a locala = this.rGD;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.rGD, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected final void e(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    n localn = ag.cpf().abv(paramString2);
    if (localn == null)
    {
      ab.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (localn.field_type == 21)
    {
      if (!localn.field_userName.equals(r.Zn()))
      {
        localArrayList1.add(this.context.getString(2131303814));
        localArrayList2.add(Integer.valueOf(3));
      }
      if ((this.rGv == null) || (!this.rGC)) {
        break label586;
      }
      this.rGC = false;
    }
    for (;;)
    {
      this.rGv.sao = new FlipView.2(this, localArrayList1, localArrayList2, paramString2, paramString3);
      this.rGv.AGQ = new FlipView.3(this);
      this.rGv.sap = new FlipView.4(this, paramString2, paramString1, paramString3);
      this.rGv.crd();
      if ((!this.rGu) || (true != paramBoolean)) {
        break;
      }
      g.RM();
      if (g.RK().eHt.adt() == 0) {
        break;
      }
      this.rGw = paramString1;
      this.rGx = paramString2;
      this.rGy = paramString3;
      paramString2 = new nw();
      paramString2.cEv.filePath = paramString1;
      com.tencent.mm.sdk.b.a.ymk.l(paramString2);
      return;
      localArrayList1.add(this.context.getString(2131303934));
      localArrayList2.add(Integer.valueOf(1));
      if (com.tencent.mm.bq.d.ahR("favorite"))
      {
        localArrayList1.add(this.context.getString(2131302102));
        localArrayList2.add(Integer.valueOf(2));
      }
      if ((localn.field_type == 15) || (localn.field_type == 5))
      {
        localArrayList1.add(this.context.getString(2131302872));
        localArrayList2.add(Integer.valueOf(0));
      }
      for (;;)
      {
        dr localdr = new dr();
        localdr.crt.crk = paramString2;
        com.tencent.mm.sdk.b.a.ymk.l(localdr);
        if (localdr.cru.cqS)
        {
          localArrayList1.add(this.context.getString(2131297019));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!v.abN(paramString2)) && (localn.field_type == 1))
        {
          localArrayList1.add(this.context.getString(2131298194));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.rGz == null) {
          break;
        }
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(4));
        break;
        if (localn.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131302869));
          localArrayList2.add(Integer.valueOf(0));
        }
        else
        {
          localArrayList1.add(this.context.getString(2131303939));
          localArrayList2.add(Integer.valueOf(0));
        }
      }
      label586:
      this.rGv = new com.tencent.mm.ui.widget.b.d(this.context, 1, false);
    }
  }
  
  public bcs getCntMedia()
  {
    return null;
  }
  
  public abstract Gallery getGallery();
  
  public abstract int getPosition();
  
  public abstract long getSnsId();
  
  protected final void onDestroy()
  {
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    com.tencent.mm.sdk.b.a.ymk.d(this.rGI);
  }
  
  protected void onPause()
  {
    this.rGw = null;
    this.rGx = "";
    this.rGy = null;
    if (this.rGz != null)
    {
      an localan = new an();
      localan.cnQ.activity = ((Activity)this.context);
      localan.cnQ.cnR = this.rGz;
      com.tencent.mm.sdk.b.a.ymk.l(localan);
      this.rGz = null;
      this.cpF = 0;
      this.cpE = 0;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!f.dDB()) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.rGu = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */