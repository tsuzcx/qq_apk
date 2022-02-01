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
import com.tencent.mm.app.j;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements c.b
{
  private double AhA = 0.0D;
  protected x AhB;
  protected v.a AhC;
  protected int AhD;
  protected int AhE;
  private boolean AhF = false;
  private long AhG = 0L;
  private boolean AhH = false;
  boolean AhI = false;
  private String AhJ;
  private String AhK;
  private String AhL;
  private String AhM;
  private String AhN;
  private String AhO;
  private String AhP;
  private String AhQ;
  private long AhR;
  private int AhS = 0;
  private boolean AhT = false;
  private a AhU = new a();
  private com.tencent.mm.sdk.b.c AhV = new com.tencent.mm.sdk.b.c() {};
  private double Ahz = 0.0D;
  private Context context;
  private int dov;
  private int dow;
  protected aq handler;
  private long hiI = 0L;
  protected int infoType = -1;
  private ScanCodeSheetItemLogic lAg;
  private e nMW;
  private com.tencent.mm.sdk.b.c rFa = new com.tencent.mm.sdk.b.c() {};
  protected bk zul = bk.JgC;
  
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
  
  private void edp()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.AhD = localDisplayMetrics.widthPixels;
    this.AhE = localDisplayMetrics.heightPixels;
  }
  
  /* Error */
  public static String g(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +117 -> 120
    //   6: aload_0
    //   7: ldc_w 291
    //   10: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +107 -> 120
    //   16: new 299	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 306	com/tencent/mm/loader/j/b:asv	()Ljava/lang/String;
    //   26: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 312
    //   32: iconst_3
    //   33: anewarray 314	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 316
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 320	java/lang/String:hashCode	()I
    //   48: invokestatic 326	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 328
    //   57: aastore
    //   58: invokestatic 332	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 310	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 337	com/tencent/mm/vfs/k
    //   72: dup
    //   73: invokestatic 343	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   76: invokevirtual 349	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 299	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 351
    //   86: invokespecial 353	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 359	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 362	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 335	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 365	com/tencent/mm/vfs/k:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 369	com/tencent/mm/vfs/k:fTh	()Landroid/net/Uri;
    //   104: invokestatic 375	com/tencent/mm/vfs/w:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: aload 6
    //   112: invokestatic 381	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +5 -> 122
    //   120: aconst_null
    //   121: areturn
    //   122: aload 6
    //   124: invokestatic 386	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   127: ifeq +216 -> 343
    //   130: aload 6
    //   132: invokestatic 390	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +197 -> 336
    //   142: aload 7
    //   144: iconst_0
    //   145: invokestatic 394	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   148: astore_3
    //   149: aload_3
    //   150: astore 4
    //   152: aload 5
    //   154: getstatic 400	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   157: bipush 80
    //   159: aload_3
    //   160: invokevirtual 406	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   163: pop
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 411	java/io/OutputStream:close	()V
    //   172: aload 6
    //   174: invokestatic 414	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   177: pop
    //   178: iload_2
    //   179: ifne +14 -> 193
    //   182: aload_0
    //   183: aload 7
    //   185: invokestatic 381	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt -70 -> 120
    //   193: aload 7
    //   195: aload_1
    //   196: invokestatic 420	com/tencent/mm/sdk/f/b:k	(Ljava/lang/String;Landroid/content/Context;)V
    //   199: aload 7
    //   201: areturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: astore 4
    //   209: ldc_w 422
    //   212: aload 5
    //   214: ldc_w 291
    //   217: iconst_0
    //   218: anewarray 314	java/lang/Object
    //   221: invokestatic 428	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 411	java/io/OutputStream:close	()V
    //   232: aload 6
    //   234: invokestatic 414	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   237: pop
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -62 -> 178
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore 4
    //   250: ldc_w 422
    //   253: aload 5
    //   255: ldc_w 291
    //   258: iconst_0
    //   259: anewarray 314	java/lang/Object
    //   262: invokestatic 428	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 411	java/io/OutputStream:close	()V
    //   273: aload 6
    //   275: invokestatic 414	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
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
    //   295: invokevirtual 411	java/io/OutputStream:close	()V
    //   298: aload 6
    //   300: invokestatic 414	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
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
    this.handler = new aq();
    edp();
    com.tencent.mm.sdk.b.a.IvT.c(this.rFa);
    com.tencent.mm.sdk.b.a.IvT.c(this.AhV);
    this.lAg = new ScanCodeSheetItemLogic(paramContext);
  }
  
  public final void E(bzh parambzh)
  {
    if (parambzh == null) {}
    String str;
    do
    {
      return;
      str = ap.jv(ah.getAccSnsPath(), parambzh.Id);
      parambzh = r.k(parambzh);
    } while (!o.fB(str + parambzh));
    aBS(str + parambzh);
  }
  
  public final void aBS(String paramString)
  {
    if (o.fB(paramString))
    {
      paramString = RecordConfigProvider.iO(paramString, "");
      if (this.zul != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).roH = -1;
        paramString.xOx = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xOE;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, 2130772137, -1, paramString, 1, 2);
    }
  }
  
  public final void azJ(String paramString) {}
  
  public void bQ(String paramString, boolean paramBoolean) {}
  
  public void bR(String paramString, boolean paramBoolean) {}
  
  public final void dWB() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ae.d("MicroMsg.FlipView", "onTouchEvent down");
      this.Ahz = paramMotionEvent.getX();
      this.AhA = paramMotionEvent.getY();
      this.hiI = System.currentTimeMillis();
      if (f.ab(paramMotionEvent) == 1) {
        this.AhF = false;
      }
    }
    if (f.ab(paramMotionEvent) > 1) {
      this.AhF = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.AhF))
    {
      ae.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hiI));
      long l = bu.HQ();
      ae.d("MicroMsg.FlipView", "deltTime: " + (l - this.AhG));
      if (l - this.AhG < 300L)
      {
        this.handler.removeCallbacks(this.AhU);
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
      this.AhG = l;
      if ((System.currentTimeMillis() - this.hiI < 500L) && (Math.abs(paramMotionEvent.getX() - this.Ahz) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.AhA) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.AhE - 100))
      {
        a locala = this.AhU;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.AhU, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected final void e(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    p localp = ah.dXE().aBr(paramString2);
    if (localp == null)
    {
      ae.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (localp.field_type == 21)
    {
      if (!localp.field_userName.equals(v.aAC()))
      {
        localArrayList1.add(this.context.getString(2131763823));
        localArrayList2.add(Integer.valueOf(3));
      }
      if ((this.nMW == null) || (!this.AhT)) {
        break label691;
      }
      this.AhT = false;
    }
    for (;;)
    {
      this.nMW.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(97872);
          FlipView.a(FlipView.this).setFooterView(null);
          paramAnonymousl.clear();
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
              paramAnonymousl.d(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
            }
          }
          AppMethodBeat.o(97872);
        }
      };
      this.nMW.KtV = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97873);
          av localav = new av();
          localav.dmJ.dmK = FlipView.b(FlipView.this);
          localav.dmJ.filePath = FlipView.c(FlipView.this);
          com.tencent.mm.sdk.b.a.IvT.l(localav);
          FlipView.d(FlipView.this);
          FlipView.e(FlipView.this);
          FlipView.f(FlipView.this);
          FlipView.g(FlipView.this);
          FlipView.h(FlipView.this);
          FlipView.i(FlipView.this);
          FlipView.a(FlipView.this, "");
          FlipView.j(FlipView.this);
          FlipView.b(FlipView.this, null);
          FlipView.a(FlipView.this, FlipView.b(FlipView.this, 0));
          FlipView.k(FlipView.this);
          FlipView.l(FlipView.this).onDismiss();
          AppMethodBeat.o(97873);
        }
      };
      this.nMW.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          Object localObject1 = ah.dXE().aBr(paramString2);
          if (localObject1 == null)
          {
            ae.i("MicroMsg.FlipView", "error beacause info null");
            AppMethodBeat.o(97874);
            return;
          }
          switch (paramAnonymousMenuItem.getItemId())
          {
          case 4: 
          default: 
            AppMethodBeat.o(97874);
            return;
          case 0: 
            if (((p)localObject1).field_type != 15)
            {
              if (r.aou(paramString1) == 4)
              {
                paramAnonymousMenuItem = o.k(paramString1, false) + "_tmp";
                o.aZI(o.aZU(paramAnonymousMenuItem));
                ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(o.k(paramString1, false), paramAnonymousMenuItem);
                com.tencent.mm.pluginsdk.ui.tools.q.j(paramAnonymousMenuItem, FlipView.m(FlipView.this));
              }
              for (;;)
              {
                FlipView.n(FlipView.this);
                AppMethodBeat.o(97874);
                return;
                com.tencent.mm.pluginsdk.ui.tools.q.j(paramString1, FlipView.m(FlipView.this));
              }
            }
            FlipView.aBT(paramString2);
            AppMethodBeat.o(97874);
            return;
          case 1: 
            if (((p)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new Intent();
              paramAnonymousMenuItem.putExtra("Retr_File_Name", paramString1);
              paramAnonymousMenuItem.putExtra("Retr_Compress_Type", 0);
              paramAnonymousMenuItem.putExtra("Retr_Msg_Type", 0);
              if (localObject1 != null)
              {
                paramAnonymousMenuItem.putExtra("Retr_FromMainTimeline", FlipView.this.edq());
                paramAnonymousMenuItem.putExtra("Retr_KSnsId", r.o((p)localObject1));
              }
              com.tencent.mm.plugin.sns.c.a.iUz.k(paramAnonymousMenuItem, FlipView.m(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            new StringBuilder().append(ap.jv(ah.getAccSnsPath(), paramString3)).append(r.d((bzh)((p)localObject1).ebP().HUG.Gtx.get(0)));
            FlipView.aBU(paramString2);
            AppMethodBeat.o(97874);
            return;
          case 2: 
            if (((p)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new cw();
              Object localObject2 = paramString2;
              String str = paramString3;
              if ((str == null) || (bu.isNullOrNil((String)localObject2)))
              {
                ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                paramAnonymousMenuItem.doL.doQ = 2131758885;
              }
              for (;;)
              {
                paramAnonymousMenuItem.doL.doR = 13;
                paramAnonymousMenuItem.doL.activity = ((Activity)FlipView.m(FlipView.this));
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                if (FlipView.this.edq())
                {
                  paramAnonymousMenuItem = new ul();
                  paramAnonymousMenuItem.dJT.dAg = r.o((p)localObject1);
                  paramAnonymousMenuItem.dJT.dqc = ((p)localObject1).eco();
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                }
                AppMethodBeat.o(97874);
                return;
                if (ah.dXn())
                {
                  ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  paramAnonymousMenuItem.doL.doQ = 2131758903;
                }
                else
                {
                  localObject2 = ah.dXE().aBr((String)localObject2);
                  if (localObject2 == null)
                  {
                    ae.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                    paramAnonymousMenuItem.doL.doQ = 2131758886;
                  }
                  else
                  {
                    com.tencent.mm.plugin.sns.k.a.a(paramAnonymousMenuItem, (p)localObject2, str);
                  }
                }
              }
            }
            if (localObject1 == null)
            {
              AppMethodBeat.o(97874);
              return;
            }
            if (!((p)localObject1).Rt(32)) {
              FlipView.F(FlipView.this.edq(), ((p)localObject1).eco());
            }
            for (;;)
            {
              if (FlipView.this.edq())
              {
                paramAnonymousMenuItem = new ul();
                paramAnonymousMenuItem.dJT.dAg = r.o((p)localObject1);
                paramAnonymousMenuItem.dJT.dqc = ((p)localObject1).eco();
                com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
              }
              AppMethodBeat.o(97874);
              return;
              paramAnonymousMenuItem = new cw();
              com.tencent.mm.plugin.sns.k.a.a(paramAnonymousMenuItem, (p)localObject1);
              paramAnonymousMenuItem.doL.doR = 14;
              paramAnonymousMenuItem.doL.activity = ((Activity)FlipView.m(FlipView.this));
              com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
            }
          case 3: 
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("k_expose_msg_id", FlipView.this.getSnsId());
            paramAnonymousMenuItem = ah.dXE().AG(FlipView.this.getSnsId());
            if (paramAnonymousMenuItem == null) {}
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = paramAnonymousMenuItem.field_userName)
            {
              ((Intent)localObject1).putExtra("k_username", paramAnonymousMenuItem);
              ((Intent)localObject1).putExtra("showShare", false);
              ((Intent)localObject1).putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
              ((Intent)localObject1).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
              d.b(FlipView.m(FlipView.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              AppMethodBeat.o(97874);
              return;
            }
          case 5: 
            if (((p)localObject1).ebP().HUG.Gtx.size() == 0)
            {
              AppMethodBeat.o(97874);
              return;
            }
            paramAnonymousMenuItem = new Intent();
            if (((p)localObject1).field_type == 1)
            {
              localObject1 = FlipView.g(paramString1, FlipView.m(FlipView.this));
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
            d.f(FlipView.m(FlipView.this), ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
            AppMethodBeat.o(97874);
            return;
          case 6: 
            FlipView.this.aBS(paramString1);
            AppMethodBeat.o(97874);
            return;
          }
          paramAnonymousMenuItem = new vj();
          paramAnonymousMenuItem.dKG.mediaId = paramString3;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
          paramAnonymousMenuItem = new ce();
          paramAnonymousMenuItem.dQB = 3L;
          if (FlipView.this.edq()) {}
          for (paramAnonymousMenuItem.edv = 6L;; paramAnonymousMenuItem.edv = 7L)
          {
            paramAnonymousMenuItem.aLH();
            break;
          }
        }
      };
      this.nMW.cPF();
      if ((!this.AhH) || (true != paramBoolean)) {
        break;
      }
      com.tencent.mm.kernel.g.ajS();
      if (com.tencent.mm.kernel.g.ajQ().gDv.aFd() == 0) {
        break;
      }
      this.AhJ = paramString1;
      this.AhK = paramString2;
      this.AhL = paramString3;
      paramString2 = new qd();
      this.AhR = System.currentTimeMillis();
      paramString2.dFH.dmK = this.AhR;
      paramString2.dFH.filePath = paramString1;
      com.tencent.mm.sdk.b.a.IvT.l(paramString2);
      return;
      localArrayList1.add(this.context.getString(2131763948));
      localArrayList2.add(Integer.valueOf(1));
      if (d.aJN("favorite"))
      {
        localArrayList1.add(this.context.getString(2131761941));
        localArrayList2.add(Integer.valueOf(2));
      }
      if ((localp.field_type == 15) || (localp.field_type == 5))
      {
        localArrayList1.add(this.context.getString(2131762784));
        localArrayList2.add(Integer.valueOf(0));
      }
      for (;;)
      {
        Object localObject = new ec();
        ((ec)localObject).dql.dqc = paramString2;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        if (((ec)localObject).dqm.dpK)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!com.tencent.mm.plugin.sns.storage.x.aBM(paramString2)) && (localp.field_type == 1))
        {
          localArrayList1.add(this.context.getString(2131757183));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.AhM == null) {
          break;
        }
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(4));
        break;
        if (localp.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131762781));
          localArrayList2.add(Integer.valueOf(0));
          if (this.AhI)
          {
            localArrayList1.add(this.context.getString(2131757184));
            localArrayList2.add(Integer.valueOf(7));
            localObject = new ce();
            ((ce)localObject).dQB = 2L;
            if (edq()) {}
            for (((ce)localObject).edv = 6L;; ((ce)localObject).edv = 7L)
            {
              ((ce)localObject).aLH();
              break;
            }
          }
        }
        else
        {
          localArrayList1.add(this.context.getString(2131763953));
          localArrayList2.add(Integer.valueOf(0));
        }
      }
      label691:
      this.nMW = new e(this.context, 1, false);
    }
  }
  
  public abstract boolean edq();
  
  public bzh getCntMedia()
  {
    return null;
  }
  
  public abstract MMViewPager getGallery();
  
  public abstract int getPosition();
  
  public abstract String getSelectedMediaId();
  
  public abstract long getSnsId();
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.IvT.d(this.rFa);
    com.tencent.mm.sdk.b.a.IvT.d(this.AhV);
    qr localqr = new qr();
    localqr.dGr.activity = ((Activity)this.context);
    com.tencent.mm.sdk.b.a.IvT.l(localqr);
  }
  
  protected void onPause()
  {
    this.AhJ = null;
    this.AhK = "";
    this.AhL = null;
    if (this.AhM != null)
    {
      au localau = new au();
      localau.dmH.activity = ((Activity)this.context);
      localau.dmH.dmI = this.AhM;
      com.tencent.mm.sdk.b.a.IvT.l(localau);
      this.AhM = null;
      this.dow = 0;
      this.dov = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.AhH = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.AhI = paramBoolean;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */