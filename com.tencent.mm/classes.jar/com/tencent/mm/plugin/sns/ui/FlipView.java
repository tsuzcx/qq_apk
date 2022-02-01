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
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.uh;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private int dnt;
  private int dnu;
  protected ap handler;
  private long hfU = 0L;
  protected int infoType = -1;
  private ScanCodeSheetItemLogic lvI;
  private e nHu;
  private com.tencent.mm.sdk.b.c rwO = new com.tencent.mm.sdk.b.c() {};
  private boolean zQA = false;
  boolean zQB = false;
  private String zQC;
  private String zQD;
  private String zQE;
  private String zQF;
  private String zQG;
  private String zQH;
  private String zQI;
  private String zQJ;
  private long zQK;
  private int zQL = 0;
  private boolean zQM = false;
  private a zQN = new a();
  private com.tencent.mm.sdk.b.c zQO = new com.tencent.mm.sdk.b.c() {};
  private double zQs = 0.0D;
  private double zQt = 0.0D;
  protected x zQu;
  protected v.a zQv;
  protected int zQw;
  protected int zQx;
  private boolean zQy = false;
  private long zQz = 0L;
  protected bj zdv = bj.ILV;
  
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
  
  private void dZJ()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.zQw = localDisplayMetrics.widthPixels;
    this.zQx = localDisplayMetrics.heightPixels;
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
    //   7: ldc_w 288
    //   10: invokevirtual 294	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +107 -> 120
    //   16: new 296	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 297	java/lang/StringBuilder:<init>	()V
    //   23: invokestatic 303	com/tencent/mm/loader/j/b:asg	()Ljava/lang/String;
    //   26: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 309
    //   32: iconst_3
    //   33: anewarray 311	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 313
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_0
    //   45: invokevirtual 317	java/lang/String:hashCode	()I
    //   48: invokestatic 323	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: ldc_w 325
    //   57: aastore
    //   58: invokestatic 329	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 334	com/tencent/mm/vfs/e
    //   72: dup
    //   73: invokestatic 340	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   76: invokevirtual 346	android/content/Context:getCacheDir	()Ljava/io/File;
    //   79: new 296	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 348
    //   86: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 356	java/lang/System:currentTimeMillis	()J
    //   92: invokevirtual 359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokespecial 362	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   101: invokevirtual 366	com/tencent/mm/vfs/e:fOK	()Landroid/net/Uri;
    //   104: invokestatic 372	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   107: astore 6
    //   109: aload_0
    //   110: aload 6
    //   112: invokestatic 378	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +5 -> 122
    //   120: aconst_null
    //   121: areturn
    //   122: aload 6
    //   124: invokestatic 383	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   127: ifeq +216 -> 343
    //   130: aload 6
    //   132: invokestatic 387	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   135: astore 5
    //   137: aload 5
    //   139: ifnull +197 -> 336
    //   142: aload 7
    //   144: iconst_0
    //   145: invokestatic 391	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   148: astore_3
    //   149: aload_3
    //   150: astore 4
    //   152: aload 5
    //   154: getstatic 397	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   157: bipush 80
    //   159: aload_3
    //   160: invokevirtual 403	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   163: pop
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 408	java/io/OutputStream:close	()V
    //   172: aload 6
    //   174: invokestatic 411	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   177: pop
    //   178: iload_2
    //   179: ifne +14 -> 193
    //   182: aload_0
    //   183: aload 7
    //   185: invokestatic 378	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   188: lconst_0
    //   189: lcmp
    //   190: iflt -70 -> 120
    //   193: aload 7
    //   195: aload_1
    //   196: invokestatic 417	com/tencent/mm/sdk/f/b:k	(Ljava/lang/String;Landroid/content/Context;)V
    //   199: aload 7
    //   201: areturn
    //   202: astore 5
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: astore 4
    //   209: ldc_w 419
    //   212: aload 5
    //   214: ldc_w 288
    //   217: iconst_0
    //   218: anewarray 311	java/lang/Object
    //   221: invokestatic 425	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: aload_3
    //   225: ifnull +7 -> 232
    //   228: aload_3
    //   229: invokevirtual 408	java/io/OutputStream:close	()V
    //   232: aload 6
    //   234: invokestatic 411	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   237: pop
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -62 -> 178
    //   243: astore 5
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore 4
    //   250: ldc_w 419
    //   253: aload 5
    //   255: ldc_w 288
    //   258: iconst_0
    //   259: anewarray 311	java/lang/Object
    //   262: invokestatic 425	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: ifnull +7 -> 273
    //   269: aload_3
    //   270: invokevirtual 408	java/io/OutputStream:close	()V
    //   273: aload 6
    //   275: invokestatic 411	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
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
    //   295: invokevirtual 408	java/io/OutputStream:close	()V
    //   298: aload 6
    //   300: invokestatic 411	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
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
    dZJ();
    com.tencent.mm.sdk.b.a.IbL.c(this.rwO);
    com.tencent.mm.sdk.b.a.IbL.c(this.zQO);
    this.lvI = new ScanCodeSheetItemLogic(paramContext);
  }
  
  public final void E(byn parambyn)
  {
    if (parambyn == null) {}
    String str;
    do
    {
      return;
      str = ao.jo(ag.getAccSnsPath(), parambyn.Id);
      parambyn = com.tencent.mm.plugin.sns.data.q.k(parambyn);
    } while (!i.fv(str + parambyn));
    aAB(str + parambyn);
  }
  
  public final void aAB(String paramString)
  {
    if (i.fv(paramString))
    {
      paramString = RecordConfigProvider.iI(paramString, "");
      if (this.zdv != null)
      {
        localObject = new VideoCaptureReportInfo();
        ((VideoCaptureReportInfo)localObject).rgD = -1;
        paramString.xyB = ((VideoCaptureReportInfo)localObject);
      }
      Object localObject = com.tencent.mm.plugin.recordvideo.jumper.a.xyI;
      com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 0, 2130772137, -1, paramString, 1, 2);
    }
  }
  
  public final void ays(String paramString) {}
  
  public void bM(String paramString, boolean paramBoolean) {}
  
  public void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
  
  public abstract boolean dZK();
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      ad.d("MicroMsg.FlipView", "onTouchEvent down");
      this.zQs = paramMotionEvent.getX();
      this.zQt = paramMotionEvent.getY();
      this.hfU = System.currentTimeMillis();
      if (f.ad(paramMotionEvent) == 1) {
        this.zQy = false;
      }
    }
    if (f.ad(paramMotionEvent) > 1) {
      this.zQy = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.zQy))
    {
      ad.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hfU));
      long l = bt.HI();
      ad.d("MicroMsg.FlipView", "deltTime: " + (l - this.zQz));
      if (l - this.zQz < 300L)
      {
        this.handler.removeCallbacks(this.zQN);
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
      this.zQz = l;
      if ((System.currentTimeMillis() - this.hfU < 500L) && (Math.abs(paramMotionEvent.getX() - this.zQs) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.zQt) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.zQx - 100))
      {
        a locala = this.zQN;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.zQN, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected final void e(final String paramString1, final String paramString2, final String paramString3, boolean paramBoolean)
  {
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    p localp = ag.dUe().aAa(paramString2);
    if (localp == null)
    {
      ad.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (localp.field_type == 21)
    {
      if (!localp.field_userName.equals(u.aAm()))
      {
        localArrayList1.add(this.context.getString(2131763823));
        localArrayList2.add(Integer.valueOf(3));
      }
      if ((this.nHu == null) || (!this.zQM)) {
        break label691;
      }
      this.zQM = false;
    }
    for (;;)
    {
      this.nHu.KJy = new n.d()
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
              paramAnonymousl.c(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
            }
          }
          AppMethodBeat.o(97872);
        }
      };
      this.nHu.JXC = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97873);
          av localav = new av();
          localav.dlH.dlI = FlipView.b(FlipView.this);
          localav.dlH.filePath = FlipView.c(FlipView.this);
          com.tencent.mm.sdk.b.a.IbL.l(localav);
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
      this.nHu.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97874);
          Object localObject1 = ag.dUe().aAa(paramString2);
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
              if (com.tencent.mm.plugin.sns.data.q.ans(paramString1) == 4)
              {
                paramAnonymousMenuItem = i.k(paramString1, false) + "_tmp";
                i.aYg(i.aYr(paramAnonymousMenuItem));
                ((com.tencent.mm.plugin.emoji.b.c)g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(i.k(paramString1, false), paramAnonymousMenuItem);
                com.tencent.mm.pluginsdk.ui.tools.q.j(paramAnonymousMenuItem, FlipView.m(FlipView.this));
                AppMethodBeat.o(97874);
                return;
              }
              com.tencent.mm.pluginsdk.ui.tools.q.j(paramString1, FlipView.m(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            FlipView.aAC(paramString2);
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
                paramAnonymousMenuItem.putExtra("Retr_FromMainTimeline", FlipView.this.dZK());
                paramAnonymousMenuItem.putExtra("Retr_KSnsId", com.tencent.mm.plugin.sns.data.q.n((p)localObject1));
              }
              com.tencent.mm.plugin.sns.c.a.iRG.k(paramAnonymousMenuItem, FlipView.m(FlipView.this));
              AppMethodBeat.o(97874);
              return;
            }
            new StringBuilder().append(ao.jo(ag.getAccSnsPath(), paramString3)).append(com.tencent.mm.plugin.sns.data.q.d((byn)((p)localObject1).dYl().HAT.GaQ.get(0)));
            FlipView.aAD(paramString2);
            AppMethodBeat.o(97874);
            return;
          case 2: 
            if (((p)localObject1).field_type != 15)
            {
              paramAnonymousMenuItem = new cv();
              Object localObject2 = paramString2;
              String str = paramString3;
              if ((str == null) || (bt.isNullOrNil((String)localObject2)))
              {
                ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or position errro");
                paramAnonymousMenuItem.dnG.dnL = 2131758885;
              }
              for (;;)
              {
                paramAnonymousMenuItem.dnG.dnM = 13;
                paramAnonymousMenuItem.dnG.activity = ((Activity)FlipView.m(FlipView.this));
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                if (FlipView.this.dZK())
                {
                  paramAnonymousMenuItem = new uh();
                  paramAnonymousMenuItem.dIF.dzb = com.tencent.mm.plugin.sns.data.q.n((p)localObject1);
                  paramAnonymousMenuItem.dIF.doX = ((p)localObject1).dYK();
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                }
                AppMethodBeat.o(97874);
                return;
                if (ag.dTN())
                {
                  ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                  paramAnonymousMenuItem.dnG.dnL = 2131758903;
                }
                else
                {
                  localObject2 = ag.dUe().aAa((String)localObject2);
                  if (localObject2 == null)
                  {
                    ad.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, snsInfo is null");
                    paramAnonymousMenuItem.dnG.dnL = 2131758886;
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
            if (!((p)localObject1).QM(32)) {
              FlipView.D(FlipView.this.dZK(), ((p)localObject1).dYK());
            }
            for (;;)
            {
              if (FlipView.this.dZK())
              {
                paramAnonymousMenuItem = new uh();
                paramAnonymousMenuItem.dIF.dzb = com.tencent.mm.plugin.sns.data.q.n((p)localObject1);
                paramAnonymousMenuItem.dIF.doX = ((p)localObject1).dYK();
                com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
              }
              AppMethodBeat.o(97874);
              return;
              paramAnonymousMenuItem = new cv();
              com.tencent.mm.plugin.sns.k.a.a(paramAnonymousMenuItem, (p)localObject1);
              paramAnonymousMenuItem.dnG.dnM = 14;
              paramAnonymousMenuItem.dnG.activity = ((Activity)FlipView.m(FlipView.this));
              com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
            }
          case 3: 
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("k_expose_msg_id", FlipView.this.getSnsId());
            paramAnonymousMenuItem = ag.dUe().Ai(FlipView.this.getSnsId());
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
            if (((p)localObject1).dYl().HAT.GaQ.size() == 0)
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
            FlipView.this.aAB(paramString1);
            AppMethodBeat.o(97874);
            return;
          }
          paramAnonymousMenuItem = new vf();
          paramAnonymousMenuItem.dJs.mediaId = paramString3;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
          paramAnonymousMenuItem = new ce();
          paramAnonymousMenuItem.dPl = 3L;
          if (FlipView.this.dZK()) {}
          for (paramAnonymousMenuItem.eca = 6L;; paramAnonymousMenuItem.eca = 7L)
          {
            paramAnonymousMenuItem.aLk();
            break;
          }
        }
      };
      this.nHu.cMW();
      if ((!this.zQA) || (true != paramBoolean)) {
        break;
      }
      g.ajD();
      if (g.ajB().gAO.aEN() == 0) {
        break;
      }
      this.zQC = paramString1;
      this.zQD = paramString2;
      this.zQE = paramString3;
      paramString2 = new qc();
      this.zQK = System.currentTimeMillis();
      paramString2.dEC.dlI = this.zQK;
      paramString2.dEC.filePath = paramString1;
      com.tencent.mm.sdk.b.a.IbL.l(paramString2);
      return;
      localArrayList1.add(this.context.getString(2131763948));
      localArrayList2.add(Integer.valueOf(1));
      if (d.aIu("favorite"))
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
        Object localObject = new eb();
        ((eb)localObject).dpg.doX = paramString2;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if (((eb)localObject).dph.doF)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!com.tencent.mm.plugin.sns.storage.x.aAv(paramString2)) && (localp.field_type == 1))
        {
          localArrayList1.add(this.context.getString(2131757183));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.zQF == null) {
          break;
        }
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(4));
        break;
        if (localp.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131762781));
          localArrayList2.add(Integer.valueOf(0));
          if (this.zQB)
          {
            localArrayList1.add(this.context.getString(2131757184));
            localArrayList2.add(Integer.valueOf(7));
            localObject = new ce();
            ((ce)localObject).dPl = 2L;
            if (dZK()) {}
            for (((ce)localObject).eca = 6L;; ((ce)localObject).eca = 7L)
            {
              ((ce)localObject).aLk();
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
      this.nHu = new e(this.context, 1, false);
    }
  }
  
  public byn getCntMedia()
  {
    return null;
  }
  
  public abstract MMViewPager getGallery();
  
  public abstract int getPosition();
  
  public abstract String getSelectedMediaId();
  
  public abstract long getSnsId();
  
  protected void onDestroy()
  {
    com.tencent.mm.sdk.b.a.IbL.d(this.rwO);
    com.tencent.mm.sdk.b.a.IbL.d(this.zQO);
    qq localqq = new qq();
    localqq.dFm.activity = ((Activity)this.context);
    com.tencent.mm.sdk.b.a.IbL.l(localqq);
  }
  
  protected void onPause()
  {
    this.zQC = null;
    this.zQD = "";
    this.zQE = null;
    if (this.zQF != null)
    {
      au localau = new au();
      localau.dlF.activity = ((Activity)this.context);
      localau.dlF.dlG = this.zQF;
      com.tencent.mm.sdk.b.a.IbL.l(localau);
      this.zQF = null;
      this.dnu = 0;
      this.dnt = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.zQA = paramBoolean;
  }
  
  public void setNeedTranslationImg(boolean paramBoolean)
  {
    this.zQB = paramBoolean;
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