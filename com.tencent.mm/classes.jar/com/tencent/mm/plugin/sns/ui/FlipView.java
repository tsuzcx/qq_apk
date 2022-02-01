package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.j;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
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
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements c.b
{
  protected bp DEv = bp.Oqt;
  private double EpZ = 0.0D;
  private double Eqa = 0.0D;
  protected y Eqb;
  protected w.a Eqc;
  protected int Eqd;
  protected int Eqe;
  private boolean Eqf = false;
  private long Eqg = 0L;
  private boolean Eqh = false;
  boolean Eqi = false;
  boolean Eqj = false;
  private String Eqk;
  private String Eql;
  private String Eqm;
  private String Eqn;
  private String Eqo;
  private String Eqp;
  private String Eqq;
  private String Eqr;
  private long Eqs;
  private int Eqt = 0;
  private boolean Equ = false;
  public int Eqv = 0;
  private b Eqw;
  private a Eqx = new a();
  private IListener Eqy = new IListener() {};
  private Context context;
  private int dFL;
  private int dFM;
  protected MMHandler handler;
  private long hwQ = 0L;
  protected int infoType = -1;
  private ScanCodeSheetItemLogic mHu;
  e oXS;
  private IListener teF = new IListener() {};
  
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
  
  private void ffG()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.Eqd = localDisplayMetrics.widthPixels;
    this.Eqe = localDisplayMetrics.heightPixels;
  }
  
  /* Error */
  public static String i(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +117 -> 120
    //   6: aload_0
    //   7: ldc_w 306
    //   10: invokevirtual 312	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +107 -> 120
    //   16: new 314	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 321	com/tencent/mm/loader/j/b:aKV	()Ljava/lang/String;
    //   26: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 327
    //   32: iconst_3
    //   33: anewarray 329	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 331
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 335	java/lang/String:hashCode	()I
    //   48: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 343
    //   57: aastore
    //   58: invokestatic 347	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 352	com/tencent/mm/vfs/o
    //   72: dup
    //   73: invokestatic 358	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   76: invokevirtual 364	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 314	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 366
    //   86: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 377	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 350	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 380	com/tencent/mm/vfs/o:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 384	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   104: invokestatic 390	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: aload 6
    //   112: invokestatic 396	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +5 -> 122
    //   120: aconst_null
    //   121: areturn
    //   122: aload 6
    //   124: invokestatic 401	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   127: ifeq +216 -> 343
    //   130: aload 6
    //   132: invokestatic 405	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +197 -> 336
    //   142: aload 7
    //   144: iconst_0
    //   145: invokestatic 409	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   148: astore_3
    //   149: aload_3
    //   150: astore 4
    //   152: aload 5
    //   154: getstatic 415	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   157: bipush 80
    //   159: aload_3
    //   160: invokevirtual 421	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   163: pop
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 426	java/io/OutputStream:close	()V
    //   172: aload 6
    //   174: invokestatic 429	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   177: pop
    //   178: iload_2
    //   179: ifne +14 -> 193
    //   182: aload_0
    //   183: aload 7
    //   185: invokestatic 396	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt -70 -> 120
    //   193: aload 7
    //   195: aload_1
    //   196: invokestatic 435	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScanner	(Ljava/lang/String;Landroid/content/Context;)V
    //   199: aload 7
    //   201: areturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: astore 4
    //   209: ldc_w 437
    //   212: aload 5
    //   214: ldc_w 306
    //   217: iconst_0
    //   218: anewarray 329	java/lang/Object
    //   221: invokestatic 443	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 426	java/io/OutputStream:close	()V
    //   232: aload 6
    //   234: invokestatic 429	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   237: pop
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -62 -> 178
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore 4
    //   250: ldc_w 437
    //   253: aload 5
    //   255: ldc_w 306
    //   258: iconst_0
    //   259: anewarray 329	java/lang/Object
    //   262: invokestatic 443	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 426	java/io/OutputStream:close	()V
    //   273: aload 6
    //   275: invokestatic 429	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   278: pop
    //   279: iconst_0
    //   280: istore_2
    //   281: goto -103 -> 178
    //   284: astore_0
    //   285: aconst_null
    //   286: astore 4
    //   288: aload 4
    //   290: ifnull +8 -> 298
    //   293: aload 4
    //   295: invokevirtual 426	java/io/OutputStream:close	()V
    //   298: aload 6
    //   300: invokestatic 429	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   303: pop
    //   304: aload_0
    //   305: athrow
    //   306: astore_3
    //   307: goto -135 -> 172
    //   310: astore_3
    //   311: goto -79 -> 232
    //   314: astore_3
    //   315: goto -42 -> 273
    //   318: astore_1
    //   319: goto -21 -> 298
    //   322: astore_0
    //   323: goto -35 -> 288
    //   326: astore 5
    //   328: goto -81 -> 247
    //   331: astore 5
    //   333: goto -127 -> 206
    //   336: aconst_null
    //   337: astore_3
    //   338: iconst_0
    //   339: istore_2
    //   340: goto -176 -> 164
    //   343: iconst_0
    //   344: istore_2
    //   345: goto -167 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramString	String
    //   0	348	1	paramContext	Context
    //   1	344	2	i	int
    //   148	122	3	localOutputStream1	java.io.OutputStream
    //   306	1	3	localException1	java.lang.Exception
    //   310	1	3	localException2	java.lang.Exception
    //   314	1	3	localException3	java.lang.Exception
    //   337	1	3	localObject	Object
    //   150	144	4	localOutputStream2	java.io.OutputStream
    //   135	18	5	localBitmap	android.graphics.Bitmap
    //   202	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   243	11	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   326	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   331	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   107	192	6	str1	String
    //   67	133	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   130	137	202	java/io/FileNotFoundException
    //   142	149	202	java/io/FileNotFoundException
    //   130	137	243	java/lang/OutOfMemoryError
    //   142	149	243	java/lang/OutOfMemoryError
    //   130	137	284	finally
    //   142	149	284	finally
    //   168	172	306	java/lang/Exception
    //   228	232	310	java/lang/Exception
    //   269	273	314	java/lang/Exception
    //   293	298	318	java/lang/Exception
    //   152	164	322	finally
    //   209	224	322	finally
    //   250	265	322	finally
    //   152	164	326	java/lang/OutOfMemoryError
    //   152	164	331	java/io/FileNotFoundException
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.handler = new MMHandler();
    ffG();
    EventCenter.instance.addListener(this.teF);
    EventCenter.instance.addListener(this.Eqy);
    this.mHu = new ScanCodeSheetItemLogic(paramContext);
  }
  
  public final void F(cnb paramcnb)
  {
    if (paramcnb == null) {}
    String str;
    do
    {
      return;
      str = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id);
      paramcnb = r.l(paramcnb);
    } while (!com.tencent.mm.vfs.s.YS(str + paramcnb));
    aQN(str + paramcnb);
  }
  
  public final void aOG(String paramString) {}
  
  public final void aQN(String paramString)
  {
    if (com.tencent.mm.vfs.s.YS(paramString))
    {
      paramString = RecordConfigProvider.jA(paramString, "");
      if (this.DEv != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).sQn = -1;
        paramString.BOE = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.BOL;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, 2130772161, -1, paramString, 1, 2);
    }
  }
  
  public void ci(String paramString, boolean paramBoolean) {}
  
  public void cj(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent down");
      this.EpZ = paramMotionEvent.getX();
      this.Eqa = paramMotionEvent.getY();
      this.hwQ = System.currentTimeMillis();
      if (f.ai(paramMotionEvent) == 1) {
        this.Eqf = false;
      }
    }
    if (f.ai(paramMotionEvent) > 1) {
      this.Eqf = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.Eqf))
    {
      Log.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hwQ));
      long l = Util.currentTicks();
      Log.d("MicroMsg.FlipView", "deltTime: " + (l - this.Eqg));
      if (l - this.Eqg < 300L)
      {
        this.handler.removeCallbacks(this.Eqx);
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
      this.Eqg = l;
      if ((System.currentTimeMillis() - this.hwQ < 500L) && (Math.abs(paramMotionEvent.getX() - this.EpZ) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.Eqa) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.Eqe - 100))
      {
        a locala = this.Eqx;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.Eqx, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void eZJ() {}
  
  public abstract boolean ffH();
  
  protected final void g(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = aj.faO().aQm(paramString2);
    if (localObject1 == null)
    {
      Log.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (((SnsInfo)localObject1).getTypeFlag() == 21)
    {
      if (!((SnsInfo)localObject1).getUserName().equals(z.aTY()))
      {
        localArrayList1.add(this.context.getString(2131766047));
        localArrayList2.add(Integer.valueOf(3));
      }
      if (this.oXS == null) {
        break label944;
      }
      if (this.Equ) {
        this.Equ = false;
      }
    }
    for (;;)
    {
      this.oXS.HLX = new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(97872);
          FlipView.a(FlipView.this).setFooterView(null);
          paramAnonymousm.clear();
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
              paramAnonymousm.d(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
            }
          }
          AppMethodBeat.o(97872);
        }
      };
      this.oXS.PGl = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97873);
          if (FlipView.b(FlipView.this) != null) {
            FlipView.b(FlipView.this).ffI();
          }
          ax localax = new ax();
          localax.dDY.dDZ = FlipView.c(FlipView.this);
          localax.dDY.filePath = FlipView.d(FlipView.this);
          EventCenter.instance.publish(localax);
          FlipView.e(FlipView.this);
          FlipView.f(FlipView.this);
          FlipView.g(FlipView.this);
          FlipView.h(FlipView.this);
          FlipView.i(FlipView.this);
          FlipView.j(FlipView.this);
          FlipView.a(FlipView.this, "");
          FlipView.k(FlipView.this);
          FlipView.b(FlipView.this, null);
          FlipView.a(FlipView.this, FlipView.b(FlipView.this, 0));
          FlipView.l(FlipView.this);
          FlipView.m(FlipView.this).onDismiss();
          AppMethodBeat.o(97873);
        }
      };
      this.oXS.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          if (FlipView.b(FlipView.this) != null) {
            FlipView.b(FlipView.this).ffI();
          }
          Object localObject1 = aj.faO().aQm(paramString2);
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
              if (r.aBO(paramString1) == 4)
              {
                paramAnonymousMenuItem = com.tencent.mm.vfs.s.k(paramString1, false) + "_tmp";
                com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(paramAnonymousMenuItem));
                ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(com.tencent.mm.vfs.s.k(paramString1, false), paramAnonymousMenuItem);
                com.tencent.mm.pluginsdk.ui.tools.s.l(paramAnonymousMenuItem, FlipView.n(FlipView.this));
              }
              for (;;)
              {
                FlipView.o(FlipView.this);
                AppMethodBeat.o(97874);
                return;
                com.tencent.mm.pluginsdk.ui.tools.s.l(paramString1, FlipView.n(FlipView.this));
              }
            }
            FlipView.aQO(paramString2);
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
                paramAnonymousMenuItem.putExtra("Retr_FromMainTimeline", FlipView.this.ffH());
                paramAnonymousMenuItem.putExtra("Retr_KSnsId", r.v((SnsInfo)localObject1));
              }
              com.tencent.mm.plugin.sns.c.a.jRt.k(paramAnonymousMenuItem, FlipView.n(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            new StringBuilder().append(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramString3)).append(r.e((cnb)((SnsInfo)localObject1).getTimeLine().ContentObj.LoV.get(0)));
            FlipView.aQP(paramString2);
            AppMethodBeat.o(97874);
            return;
            if (((SnsInfo)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new cz();
              Object localObject2 = paramString2;
              String str = paramString3;
              if ((str == null) || (Util.isNullOrNil((String)localObject2)))
              {
                Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                paramAnonymousMenuItem.dFZ.dGe = 2131759209;
              }
              for (;;)
              {
                paramAnonymousMenuItem.dFZ.dGf = 13;
                paramAnonymousMenuItem.dFZ.activity = ((Activity)FlipView.n(FlipView.this));
                EventCenter.instance.publish(paramAnonymousMenuItem);
                if (FlipView.this.ffH())
                {
                  paramAnonymousMenuItem = new vj();
                  paramAnonymousMenuItem.ebG.dRS = r.v((SnsInfo)localObject1);
                  paramAnonymousMenuItem.ebG.dHp = ((SnsInfo)localObject1).getLocalid();
                  EventCenter.instance.publish(paramAnonymousMenuItem);
                }
                AppMethodBeat.o(97874);
                return;
                if (aj.isInValid())
                {
                  Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  paramAnonymousMenuItem.dFZ.dGe = 2131759227;
                }
                else
                {
                  localObject2 = aj.faO().aQm((String)localObject2);
                  if (localObject2 == null)
                  {
                    Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                    paramAnonymousMenuItem.dFZ.dGe = 2131759210;
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
              FlipView.G(FlipView.this.ffH(), ((SnsInfo)localObject1).getLocalid());
            }
            for (;;)
            {
              if (FlipView.this.ffH())
              {
                paramAnonymousMenuItem = new vj();
                paramAnonymousMenuItem.ebG.dRS = r.v((SnsInfo)localObject1);
                paramAnonymousMenuItem.ebG.dHp = ((SnsInfo)localObject1).getLocalid();
                EventCenter.instance.publish(paramAnonymousMenuItem);
              }
              AppMethodBeat.o(97874);
              return;
              paramAnonymousMenuItem = new cz();
              com.tencent.mm.plugin.sns.l.a.a(paramAnonymousMenuItem, (SnsInfo)localObject1);
              paramAnonymousMenuItem.dFZ.dGf = 14;
              paramAnonymousMenuItem.dFZ.activity = ((Activity)FlipView.n(FlipView.this));
              EventCenter.instance.publish(paramAnonymousMenuItem);
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("k_expose_msg_id", FlipView.this.getSnsId());
            paramAnonymousMenuItem = aj.faO().JJ(FlipView.this.getSnsId());
            if (paramAnonymousMenuItem == null) {}
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = paramAnonymousMenuItem.field_userName)
            {
              ((Intent)localObject1).putExtra("k_username", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("showShare", false);
              ((Intent)localObject1).putExtra("rawUrl", e.e.OyU + 33);
              ((Intent)localObject1).putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
              com.tencent.mm.br.c.b(FlipView.n(FlipView.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              AppMethodBeat.o(97874);
              return;
            }
            if (((SnsInfo)localObject1).getTimeLine().ContentObj.LoV.size() == 0)
            {
              AppMethodBeat.o(97874);
              return;
            }
            paramAnonymousMenuItem = new Intent();
            if (((SnsInfo)localObject1).field_type == 1)
            {
              localObject1 = FlipView.i(paramString1, FlipView.n(FlipView.this));
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
            com.tencent.mm.br.c.f(FlipView.n(FlipView.this), ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
            AppMethodBeat.o(97874);
            return;
            FlipView.this.aQN(paramString1);
            AppMethodBeat.o(97874);
            return;
            if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext()))
            {
              paramAnonymousMenuItem = new wj();
              paramAnonymousMenuItem.ecv.mediaId = paramString3;
              EventCenter.instance.publish(paramAnonymousMenuItem);
              paramAnonymousMenuItem = new ep();
              paramAnonymousMenuItem.ejA = 3L;
              if (FlipView.this.ffH()) {}
              for (paramAnonymousMenuItem.eDV = 6L;; paramAnonymousMenuItem.eDV = 7L)
              {
                localObject1 = FlipView.this.getCntMedia();
                if (localObject1 != null) {
                  paramAnonymousMenuItem.rK(((cnb)localObject1).Url);
                }
                paramAnonymousMenuItem.bfK();
                AppMethodBeat.o(97874);
                return;
              }
              paramAnonymousMenuItem = aj.faO().aQm(paramString2);
              localObject1 = new o();
              ((o)localObject1).context = FlipView.n(FlipView.this);
              ((o)localObject1).dHq = paramString1;
              ((o)localObject1).IDs = paramAnonymousMenuItem.field_userName;
              ((o)localObject1).dRS = r.Jb(FlipView.this.getSnsId());
              ((o)localObject1).dGf = r.Yo(FlipView.this.Eqv);
              ((o)localObject1).DIq = FlipView.this.getCntMedia();
              ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch((o)localObject1);
              AppMethodBeat.o(97874);
              return;
              if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(FlipView.this.getContext()))
              {
                paramAnonymousMenuItem = new vw();
                paramAnonymousMenuItem.ebW.mediaId = paramString3;
                paramAnonymousMenuItem.ebW.dkU = ((SnsInfo)localObject1).getUserName();
                EventCenter.instance.publish(paramAnonymousMenuItem);
              }
            }
          }
        }
      };
      this.oXS.dGm();
      if (this.Eqw != null) {
        this.Eqw.ha(localArrayList2);
      }
      if ((!this.Eqh) || (true != paramBoolean)) {
        break;
      }
      com.tencent.mm.kernel.g.aAi();
      if (com.tencent.mm.kernel.g.aAg().hqi.aYS() == 0) {
        break;
      }
      this.Eqk = paramString1;
      this.Eql = paramString2;
      this.Eqm = paramString3;
      paramString2 = new qx();
      this.Eqs = System.currentTimeMillis();
      paramString2.dXu.dDZ = this.Eqs;
      paramString2.dXu.filePath = paramString1;
      EventCenter.instance.publish(paramString2);
      return;
      localArrayList1.add(this.context.getString(2131766179));
      localArrayList2.add(Integer.valueOf(1));
      if (com.tencent.mm.br.c.aZU("favorite"))
      {
        localArrayList1.add(this.context.getString(2131763947));
        localArrayList2.add(Integer.valueOf(2));
      }
      if ((((SnsInfo)localObject1).field_type == 15) || (((SnsInfo)localObject1).field_type == 5))
      {
        localArrayList1.add(this.context.getString(2131764871));
        localArrayList2.add(Integer.valueOf(0));
      }
      for (;;)
      {
        Object localObject2 = new ef();
        ((ef)localObject2).dHy.dHp = paramString2;
        EventCenter.instance.publish((IEvent)localObject2);
        if (((ef)localObject2).dHz.dGX)
        {
          localArrayList1.add(this.context.getString(2131755922));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!com.tencent.mm.plugin.sns.storage.y.aQH(paramString2)) && (((SnsInfo)localObject1).field_type == 1))
        {
          localArrayList1.add(this.context.getString(2131757388));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.Eqn != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(4));
        }
        if ((((SnsInfo)localObject1).field_type != 1) || (!((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) || (!r.Yn(this.Eqv))) {
          break;
        }
        localArrayList1.add(this.context.getString(2131759440));
        localArrayList2.add(Integer.valueOf(8));
        if (this.Equ) {
          break;
        }
        localObject1 = new ab();
        localObject2 = ((ab)localObject1).ie("").jdMethod_if(r.Jb(getSnsId()));
        ((ab)localObject2).enp = r.Yo(this.Eqv);
        ((ab)localObject2).eki = 1;
        ((ab)localObject2).enq = 81;
        ((ab)localObject1).ig("");
        ((ab)localObject1).ih("");
        ((ab)localObject1).ii(com.tencent.mm.b.g.getMD5(paramString1));
        ((ab)localObject1).enx = System.currentTimeMillis();
        ((ab)localObject1).bfK();
        com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject1);
        break;
        if (((SnsInfo)localObject1).field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131764866));
          localArrayList2.add(Integer.valueOf(0));
          if (this.Eqi)
          {
            localArrayList1.add(this.context.getString(2131757389));
            localArrayList2.add(Integer.valueOf(7));
            localObject2 = new ep();
            ((ep)localObject2).ejA = 2L;
            if (!ffH()) {
              break label900;
            }
          }
          label900:
          for (((ep)localObject2).eDV = 6L;; ((ep)localObject2).eDV = 7L)
          {
            cnb localcnb = getCntMedia();
            if (localcnb != null) {
              ((ep)localObject2).rK(localcnb.Url);
            }
            ((ep)localObject2).bfK();
            if (!this.Eqj) {
              break;
            }
            localArrayList1.add(this.context.getString(2131757387));
            localArrayList2.add(Integer.valueOf(9));
            break;
          }
        }
        localArrayList1.add(this.context.getString(2131766187));
        localArrayList2.add(Integer.valueOf(0));
      }
      label944:
      this.oXS = new e(this.context, 1, false);
    }
  }
  
  public cnb getCntMedia()
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
  
  protected void onDestroy()
  {
    EventCenter.instance.removeListener(this.teF);
    EventCenter.instance.removeListener(this.Eqy);
    rl localrl = new rl();
    localrl.dYc.activity = ((Activity)this.context);
    EventCenter.instance.publish(localrl);
  }
  
  protected void onPause()
  {
    this.Eqk = null;
    this.Eql = "";
    this.Eqm = null;
    if (this.Eqn != null)
    {
      aw localaw = new aw();
      localaw.dDW.activity = ((Activity)this.context);
      localaw.dDW.dDX = this.Eqn;
      EventCenter.instance.publish(localaw);
      this.Eqn = null;
      this.dFM = 0;
      this.dFL = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedOCRImg(boolean paramBoolean)
  {
    this.Eqj = paramBoolean;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.Eqh = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.Eqi = paramBoolean;
  }
  
  public void setOnMenuShowListener(b paramb)
  {
    this.Eqw = paramb;
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
    public abstract void ffI();
    
    public abstract void ha(List<Integer> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */