package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements b.b
{
  private Context context;
  private int deB;
  private int deC;
  private long glk = 0L;
  protected ap handler;
  protected int infoType = -1;
  private ScanCodeSheetItemLogic kxs;
  private e mET;
  private c qej = new c() {};
  protected bc wBg = bc.FzF;
  private String xmA;
  private long xmB;
  private int xmC = 0;
  private boolean xmD = false;
  private a xmE = new a();
  private c xmF = new c() {};
  private double xmj = 0.0D;
  private double xmk = 0.0D;
  protected w xml;
  protected u.a xmm;
  protected int xmn;
  protected int xmo;
  private boolean xmp = false;
  private long xmq = 0L;
  private boolean xmr = false;
  boolean xms = false;
  private String xmt;
  private String xmu;
  private String xmv;
  private String xmw;
  private String xmx;
  private String xmy;
  private String xmz;
  
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
  
  private void dyX()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.xmn = localDisplayMetrics.widthPixels;
    this.xmo = localDisplayMetrics.heightPixels;
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
    //   7: ldc_w 281
    //   10: invokevirtual 287	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +107 -> 120
    //   16: new 289	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 296	com/tencent/mm/loader/j/b:ais	()Ljava/lang/String;
    //   26: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 302
    //   32: iconst_3
    //   33: anewarray 304	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 306
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 310	java/lang/String:hashCode	()I
    //   48: invokestatic 316	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 318
    //   57: aastore
    //   58: invokestatic 322	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 327	com/tencent/mm/vfs/e
    //   72: dup
    //   73: invokestatic 333	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   76: invokevirtual 339	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 289	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 341
    //   86: invokespecial 343	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 349	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 352	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 355	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 359	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   104: invokestatic 365	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: aload 6
    //   112: invokestatic 371	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +5 -> 122
    //   120: aconst_null
    //   121: areturn
    //   122: aload 6
    //   124: invokestatic 376	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   127: ifeq +216 -> 343
    //   130: aload 6
    //   132: invokestatic 380	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +197 -> 336
    //   142: aload 7
    //   144: iconst_0
    //   145: invokestatic 384	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   148: astore_3
    //   149: aload_3
    //   150: astore 4
    //   152: aload 5
    //   154: getstatic 390	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   157: bipush 80
    //   159: aload_3
    //   160: invokevirtual 396	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   163: pop
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 401	java/io/OutputStream:close	()V
    //   172: aload 6
    //   174: invokestatic 404	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   177: pop
    //   178: iload_2
    //   179: ifne +14 -> 193
    //   182: aload_0
    //   183: aload 7
    //   185: invokestatic 371	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt -70 -> 120
    //   193: aload 7
    //   195: aload_1
    //   196: invokestatic 410	com/tencent/mm/sdk/f/b:k	(Ljava/lang/String;Landroid/content/Context;)V
    //   199: aload 7
    //   201: areturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: astore 4
    //   209: ldc_w 412
    //   212: aload 5
    //   214: ldc_w 281
    //   217: iconst_0
    //   218: anewarray 304	java/lang/Object
    //   221: invokestatic 418	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 401	java/io/OutputStream:close	()V
    //   232: aload 6
    //   234: invokestatic 404	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   237: pop
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -62 -> 178
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore 4
    //   250: ldc_w 412
    //   253: aload 5
    //   255: ldc_w 281
    //   258: iconst_0
    //   259: anewarray 304	java/lang/Object
    //   262: invokestatic 418	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 401	java/io/OutputStream:close	()V
    //   273: aload 6
    //   275: invokestatic 404	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
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
    //   295: invokevirtual 401	java/io/OutputStream:close	()V
    //   298: aload 6
    //   300: invokestatic 404	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
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
    this.handler = new ap();
    dyX();
    com.tencent.mm.sdk.b.a.ESL.c(this.qej);
    com.tencent.mm.sdk.b.a.ESL.c(this.xmF);
    this.kxs = new ScanCodeSheetItemLogic(paramContext);
  }
  
  public final void E(bpi parambpi)
  {
    if (parambpi == null) {}
    String str;
    do
    {
      return;
      str = an.iF(af.getAccSnsPath(), parambpi.Id);
      parambpi = com.tencent.mm.plugin.sns.data.q.k(parambpi);
    } while (!i.eK(str + parambpi));
    aql(str + parambpi);
  }
  
  public final void aob(String paramString) {}
  
  public final void aql(String paramString)
  {
    if (i.eK(paramString))
    {
      paramString = RecordConfigProvider.ic(paramString, "");
      if (this.wBg != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).pOf = -1;
        paramString.vhY = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, 2130772137, -1, paramString, 1, 2);
    }
  }
  
  public void by(String paramString, boolean paramBoolean) {}
  
  public void bz(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ad.d("MicroMsg.FlipView", "onTouchEvent down");
      this.xmj = paramMotionEvent.getX();
      this.xmk = paramMotionEvent.getY();
      this.glk = System.currentTimeMillis();
      if (f.ab(paramMotionEvent) == 1) {
        this.xmp = false;
      }
    }
    if (f.ab(paramMotionEvent) > 1) {
      this.xmp = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.xmp))
    {
      ad.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.glk));
      long l = bt.GC();
      ad.d("MicroMsg.FlipView", "deltTime: " + (l - this.xmq));
      if (l - this.xmq < 300L)
      {
        this.handler.removeCallbacks(this.xmE);
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
      this.xmq = l;
      if ((System.currentTimeMillis() - this.glk < 500L) && (Math.abs(paramMotionEvent.getX() - this.xmj) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.xmk) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.xmo - 100))
      {
        a locala = this.xmE;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.xmE, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void dsp() {}
  
  public abstract boolean dyY();
  
  protected final void e(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    p localp = af.dtu().apK(paramString2);
    if (localp == null)
    {
      ad.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (localp.field_type == 21)
    {
      if (!localp.field_userName.equals(u.aqG()))
      {
        localArrayList1.add(this.context.getString(2131763823));
        localArrayList2.add(Integer.valueOf(3));
      }
      if ((this.mET == null) || (!this.xmD)) {
        break label691;
      }
      this.xmD = false;
    }
    for (;;)
    {
      this.mET.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
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
              paramAnonymousl.c(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
            }
          }
          AppMethodBeat.o(97872);
        }
      };
      this.mET.GHn = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97873);
          as localas = new as();
          localas.dcP.dcQ = FlipView.b(FlipView.this);
          localas.dcP.filePath = FlipView.c(FlipView.this);
          com.tencent.mm.sdk.b.a.ESL.l(localas);
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
          FlipView.l(FlipView.this).vLD = null;
          AppMethodBeat.o(97873);
        }
      };
      this.mET.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          Object localObject1 = af.dtu().apK(paramString2);
          if (localObject1 == null)
          {
            ad.i("MicroMsg.FlipView", "error beacause info null");
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
              com.tencent.mm.pluginsdk.ui.tools.q.j(paramString1, FlipView.m(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            FlipView.aqm(paramString2);
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
                paramAnonymousMenuItem.putExtra("Retr_FromMainTimeline", FlipView.this.dyY());
                paramAnonymousMenuItem.putExtra("Retr_KSnsId", com.tencent.mm.plugin.sns.data.q.l((p)localObject1));
              }
              com.tencent.mm.plugin.sns.d.a.hYt.k(paramAnonymousMenuItem, FlipView.m(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            new StringBuilder().append(an.iF(af.getAccSnsPath(), paramString3)).append(com.tencent.mm.plugin.sns.data.q.d((bpi)((p)localObject1).dxy().Etm.DaC.get(0)));
            FlipView.aqn(paramString2);
            AppMethodBeat.o(97874);
            return;
          case 2: 
            if (((p)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new cs();
              Object localObject2 = paramString2;
              String str = paramString3;
              if ((str == null) || (bt.isNullOrNil((String)localObject2)))
              {
                ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                paramAnonymousMenuItem.deQ.deV = 2131758885;
              }
              for (;;)
              {
                paramAnonymousMenuItem.deQ.deW = 13;
                paramAnonymousMenuItem.deQ.activity = ((Activity)FlipView.m(FlipView.this));
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                if (FlipView.this.dyY())
                {
                  paramAnonymousMenuItem = new tf();
                  paramAnonymousMenuItem.dyH.dpC = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
                  paramAnonymousMenuItem.dyH.dgg = ((p)localObject1).dxX();
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                }
                AppMethodBeat.o(97874);
                return;
                if (af.dtd())
                {
                  ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  paramAnonymousMenuItem.deQ.deV = 2131758903;
                }
                else
                {
                  localObject2 = af.dtu().apK((String)localObject2);
                  if (localObject2 == null)
                  {
                    ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                    paramAnonymousMenuItem.deQ.deV = 2131758886;
                  }
                  else
                  {
                    com.tencent.mm.plugin.sns.l.a.a(paramAnonymousMenuItem, (p)localObject2, str);
                  }
                }
              }
            }
            if (localObject1 == null)
            {
              AppMethodBeat.o(97874);
              return;
            }
            if (!((p)localObject1).Nb(32)) {
              FlipView.x(FlipView.this.dyY(), ((p)localObject1).dxX());
            }
            for (;;)
            {
              if (FlipView.this.dyY())
              {
                paramAnonymousMenuItem = new tf();
                paramAnonymousMenuItem.dyH.dpC = com.tencent.mm.plugin.sns.data.q.l((p)localObject1);
                paramAnonymousMenuItem.dyH.dgg = ((p)localObject1).dxX();
                com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
              }
              AppMethodBeat.o(97874);
              return;
              paramAnonymousMenuItem = new cs();
              com.tencent.mm.plugin.sns.l.a.a(paramAnonymousMenuItem, (p)localObject1);
              paramAnonymousMenuItem.deQ.deW = 14;
              paramAnonymousMenuItem.deQ.activity = ((Activity)FlipView.m(FlipView.this));
              com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
            }
          case 3: 
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("k_expose_msg_id", FlipView.this.getSnsId());
            paramAnonymousMenuItem = af.dtu().th(FlipView.this.getSnsId());
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
            if (((p)localObject1).dxy().Etm.DaC.size() == 0)
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
            d.e(FlipView.m(FlipView.this), ".ui.chatting.ChattingSendDataToDeviceUI", paramAnonymousMenuItem);
            AppMethodBeat.o(97874);
            return;
          case 6: 
            FlipView.this.aql(paramString1);
            AppMethodBeat.o(97874);
            return;
          }
          paramAnonymousMenuItem = new uc();
          paramAnonymousMenuItem.dzu.mediaId = paramString3;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
          paramAnonymousMenuItem = new ao();
          paramAnonymousMenuItem.dFd = 3L;
          if (FlipView.this.dyY()) {}
          for (paramAnonymousMenuItem.dMB = 6L;; paramAnonymousMenuItem.dMB = 7L)
          {
            paramAnonymousMenuItem.aBj();
            break;
          }
        }
      };
      this.mET.csG();
      if ((!this.xmr) || (true != paramBoolean)) {
        break;
      }
      g.afC();
      if (g.afA().gcy.auR() == 0) {
        break;
      }
      this.xmt = paramString1;
      this.xmu = paramString2;
      this.xmv = paramString3;
      paramString2 = new pj();
      this.xmB = System.currentTimeMillis();
      paramString2.duX.dcQ = this.xmB;
      paramString2.duX.filePath = paramString1;
      com.tencent.mm.sdk.b.a.ESL.l(paramString2);
      return;
      localArrayList1.add(this.context.getString(2131763948));
      localArrayList2.add(Integer.valueOf(1));
      if (d.axB("favorite"))
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
        Object localObject = new dx();
        ((dx)localObject).dgp.dgg = paramString2;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        if (((dx)localObject).dgq.dfO)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!x.aqf(paramString2)) && (localp.field_type == 1))
        {
          localArrayList1.add(this.context.getString(2131757183));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.xmw == null) {
          break;
        }
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(4));
        break;
        if (localp.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131762781));
          localArrayList2.add(Integer.valueOf(0));
          if (this.xms)
          {
            localArrayList1.add(this.context.getString(2131757184));
            localArrayList2.add(Integer.valueOf(7));
            localObject = new ao();
            ((ao)localObject).dFd = 2L;
            if (dyY()) {}
            for (((ao)localObject).dMB = 6L;; ((ao)localObject).dMB = 7L)
            {
              ((ao)localObject).aBj();
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
      this.mET = new e(this.context, 1, false);
    }
  }
  
  public bpi getCntMedia()
  {
    return null;
  }
  
  public abstract MMViewPager getGallery();
  
  public abstract int getPosition();
  
  public abstract String getSelectedMediaId();
  
  public abstract long getSnsId();
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.ESL.d(this.qej);
    com.tencent.mm.sdk.b.a.ESL.d(this.xmF);
    pw localpw = new pw();
    localpw.dvy.activity = ((Activity)this.context);
    com.tencent.mm.sdk.b.a.ESL.l(localpw);
  }
  
  protected void onPause()
  {
    this.xmt = null;
    this.xmu = "";
    this.xmv = null;
    if (this.xmw != null)
    {
      ar localar = new ar();
      localar.dcN.activity = ((Activity)this.context);
      localar.dcN.dcO = this.xmw;
      com.tencent.mm.sdk.b.a.ESL.l(localar);
      this.xmw = null;
      this.deC = 0;
      this.deB = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.xmr = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.xms = paramBoolean;
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