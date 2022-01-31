package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.LinearLayout;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.al;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView
  extends LinearLayout
  implements View.OnTouchListener, b.b
{
  private int bIj;
  private int bIk;
  Context context;
  private long dXA = 0L;
  protected ah handler;
  protected int infoType = -1;
  private c kbV = new FlipView.5(this);
  private double oOB = 0.0D;
  private double oOC = 0.0D;
  protected u oOD;
  protected s.a oOE;
  protected int oOF;
  protected int oOG;
  private boolean oOH = false;
  private long oOI = 0L;
  private boolean oOJ = false;
  private com.tencent.mm.ui.widget.a.d oOK;
  private String oOL;
  private String oOM;
  private String oON;
  private String oOO;
  private boolean oOP = false;
  private FlipView.a oOQ = new FlipView.a(this);
  float oOR = 0.0F;
  float oOS = 0.0F;
  boolean oOT = false;
  float oOU = 1.0F;
  private c oOV = new FlipView.6(this);
  
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
  
  /* Error */
  public static String g(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +109 -> 112
    //   6: aload_0
    //   7: ldc 172
    //   9: invokevirtual 178	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifne +100 -> 112
    //   15: new 180	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 181	java/lang/StringBuilder:<init>	()V
    //   22: getstatic 186	com/tencent/mm/compatible/util/e:dzD	Ljava/lang/String;
    //   25: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 192
    //   30: iconst_3
    //   31: anewarray 194	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc 196
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: invokevirtual 200	java/lang/String:hashCode	()I
    //   45: invokestatic 206	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc 208
    //   53: aastore
    //   54: invokestatic 212	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 7
    //   65: new 218	java/io/File
    //   68: dup
    //   69: invokestatic 224	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   72: invokevirtual 230	android/content/Context:getCacheDir	()Ljava/io/File;
    //   75: new 180	java/lang/StringBuilder
    //   78: dup
    //   79: ldc 232
    //   81: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: invokestatic 240	java/lang/System:currentTimeMillis	()J
    //   87: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 246	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   96: invokevirtual 249	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   99: astore 6
    //   101: aload_0
    //   102: aload 6
    //   104: invokestatic 255	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   107: lconst_0
    //   108: lcmp
    //   109: ifge +5 -> 114
    //   112: aconst_null
    //   113: areturn
    //   114: aload 6
    //   116: invokestatic 261	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   119: ifeq +227 -> 346
    //   122: aload 6
    //   124: invokestatic 265	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   127: astore 5
    //   129: aload 5
    //   131: ifnull +208 -> 339
    //   134: aload 7
    //   136: iconst_0
    //   137: invokestatic 268	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   140: astore_3
    //   141: aload_3
    //   142: astore 4
    //   144: aload 5
    //   146: getstatic 274	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   149: bipush 80
    //   151: aload_3
    //   152: invokevirtual 280	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   155: pop
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 285	java/io/OutputStream:close	()V
    //   164: aload 6
    //   166: invokestatic 288	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   169: pop
    //   170: iload_2
    //   171: ifne +14 -> 185
    //   174: aload_0
    //   175: aload 7
    //   177: invokestatic 255	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   180: lconst_0
    //   181: lcmp
    //   182: iflt -70 -> 112
    //   185: aload_1
    //   186: new 290	android/content/Intent
    //   189: dup
    //   190: ldc_w 292
    //   193: aload 7
    //   195: invokestatic 296	com/tencent/mm/vfs/e:aeP	(Ljava/lang/String;)Landroid/net/Uri;
    //   198: invokespecial 299	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   201: invokevirtual 303	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   204: aload 7
    //   206: areturn
    //   207: astore 5
    //   209: aconst_null
    //   210: astore_3
    //   211: aload_3
    //   212: astore 4
    //   214: ldc_w 305
    //   217: aload 5
    //   219: ldc 172
    //   221: iconst_0
    //   222: anewarray 194	java/lang/Object
    //   225: invokestatic 311	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload_3
    //   229: ifnull +7 -> 236
    //   232: aload_3
    //   233: invokevirtual 285	java/io/OutputStream:close	()V
    //   236: aload 6
    //   238: invokestatic 288	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   241: pop
    //   242: iconst_0
    //   243: istore_2
    //   244: goto -74 -> 170
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_3
    //   251: aload_3
    //   252: astore 4
    //   254: ldc_w 305
    //   257: aload 5
    //   259: ldc 172
    //   261: iconst_0
    //   262: anewarray 194	java/lang/Object
    //   265: invokestatic 311	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload_3
    //   269: ifnull +7 -> 276
    //   272: aload_3
    //   273: invokevirtual 285	java/io/OutputStream:close	()V
    //   276: aload 6
    //   278: invokestatic 288	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   281: pop
    //   282: iconst_0
    //   283: istore_2
    //   284: goto -114 -> 170
    //   287: astore_0
    //   288: aconst_null
    //   289: astore 4
    //   291: aload 4
    //   293: ifnull +8 -> 301
    //   296: aload 4
    //   298: invokevirtual 285	java/io/OutputStream:close	()V
    //   301: aload 6
    //   303: invokestatic 288	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   306: pop
    //   307: aload_0
    //   308: athrow
    //   309: astore_3
    //   310: goto -146 -> 164
    //   313: astore_3
    //   314: goto -78 -> 236
    //   317: astore_3
    //   318: goto -42 -> 276
    //   321: astore_1
    //   322: goto -21 -> 301
    //   325: astore_0
    //   326: goto -35 -> 291
    //   329: astore 5
    //   331: goto -80 -> 251
    //   334: astore 5
    //   336: goto -125 -> 211
    //   339: aconst_null
    //   340: astore_3
    //   341: iconst_0
    //   342: istore_2
    //   343: goto -187 -> 156
    //   346: iconst_0
    //   347: istore_2
    //   348: goto -178 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString	String
    //   0	351	1	paramContext	Context
    //   1	347	2	i	int
    //   140	133	3	localOutputStream1	java.io.OutputStream
    //   309	1	3	localException1	java.lang.Exception
    //   313	1	3	localException2	java.lang.Exception
    //   317	1	3	localException3	java.lang.Exception
    //   340	1	3	localObject	Object
    //   142	155	4	localOutputStream2	java.io.OutputStream
    //   127	18	5	localBitmap	android.graphics.Bitmap
    //   207	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   247	11	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   329	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   334	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   99	203	6	str1	String
    //   63	142	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   122	129	207	java/io/FileNotFoundException
    //   134	141	207	java/io/FileNotFoundException
    //   122	129	247	java/lang/OutOfMemoryError
    //   134	141	247	java/lang/OutOfMemoryError
    //   122	129	287	finally
    //   134	141	287	finally
    //   160	164	309	java/lang/Exception
    //   232	236	313	java/lang/Exception
    //   272	276	317	java/lang/Exception
    //   296	301	321	java/lang/Exception
    //   144	156	325	finally
    //   214	228	325	finally
    //   254	268	325	finally
    //   144	156	329	java/lang/OutOfMemoryError
    //   144	156	334	java/io/FileNotFoundException
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.handler = new ah();
    paramContext = new DisplayMetrics();
    ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    this.oOF = paramContext.widthPixels;
    this.oOG = paramContext.heightPixels;
    com.tencent.mm.sdk.b.a.udP.c(this.kbV);
    com.tencent.mm.sdk.b.a.udP.c(this.oOV);
  }
  
  public final void Ni(String paramString) {}
  
  public final void Pa(String paramString)
  {
    if (e.bK(paramString))
    {
      Intent localIntent = new Intent();
      y.i("MicroMsg.FlipView", "edit image path:%s", new Object[] { paramString });
      localIntent.putExtra("before_photo_edit", paramString);
      localIntent.putExtra("from_scene", 293);
      localIntent.putExtra("after_photo_edit", "");
      localIntent.putExtra("Retr_Compress_Type", 0);
      localIntent.putExtra("Retr_Msg_Type", 0);
      localIntent.putExtra("Retr_FromMainTimeline", bHt());
      localIntent.setClass(this.context, MMNewPhotoEditUI.class);
      this.context.startActivity(localIntent);
    }
  }
  
  public final void bCt() {}
  
  public abstract boolean bHt();
  
  public void ba(String paramString, boolean paramBoolean) {}
  
  public void bb(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      y.d("MicroMsg.FlipView", "onTouchEvent down");
      this.oOB = paramMotionEvent.getX();
      this.oOC = paramMotionEvent.getY();
      this.dXA = System.currentTimeMillis();
      if (f.J(paramMotionEvent) == 1) {
        this.oOH = false;
      }
    }
    if (f.J(paramMotionEvent) > 1) {
      this.oOH = true;
    }
    if ((paramMotionEvent.getAction() == 1) && (!this.oOH))
    {
      y.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.dXA));
      long l = bk.UZ();
      y.d("MicroMsg.FlipView", "deltTime: " + (l - this.oOI));
      if (l - this.oOI < 300L)
      {
        this.handler.removeCallbacks(this.oOQ);
        this.handler.post(new FlipView.1(this));
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.oOI = l;
      if ((System.currentTimeMillis() - this.dXA < 500L) && (Math.abs(paramMotionEvent.getX() - this.oOB) <= 10.0D) && (Math.abs(paramMotionEvent.getY() - this.oOC) <= 10.0D) && (paramMotionEvent.getY() > 110.0F) && (paramMotionEvent.getY() < this.oOG - 100))
      {
        FlipView.a locala = this.oOQ;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        locala.x = f1;
        locala.y = f2;
        this.handler.postDelayed(this.oOQ, 10L);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected final void e(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    n localn = af.bDF().OB(paramString2);
    if (localn == null)
    {
      y.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
      return;
    }
    if (localn.field_type == 21)
    {
      if (!localn.field_userName.equals(q.Gj()))
      {
        localArrayList1.add(this.context.getString(i.j.sns_expose_sns));
        localArrayList2.add(Integer.valueOf(3));
      }
      label96:
      if ((this.oOK == null) || (!this.oOP)) {
        break label688;
      }
      this.oOP = false;
    }
    for (;;)
    {
      this.oOK.phH = new FlipView.2(this, localArrayList1, localArrayList2);
      this.oOK.wmU = new FlipView.3(this);
      this.oOK.phI = new FlipView.4(this, paramString2, paramString1, paramString3);
      this.oOK.cfU();
      if ((!this.oOJ) || (true != paramBoolean)) {
        break;
      }
      g.DQ();
      if (g.DO().dJT.KG() == 0) {
        break;
      }
      this.oOL = paramString1;
      this.oOM = paramString2;
      this.oON = paramString3;
      paramString2 = new mz();
      paramString2.bWF.filePath = paramString1;
      com.tencent.mm.sdk.b.a.udP.m(paramString2);
      return;
      localArrayList1.add(this.context.getString(i.j.sns_post_to));
      localArrayList2.add(Integer.valueOf(1));
      if (com.tencent.mm.br.d.SP("favorite"))
      {
        localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
        localArrayList2.add(Integer.valueOf(2));
      }
      if ((localn.field_type == 15) || (localn.field_type == 5))
      {
        localArrayList1.add(this.context.getString(i.j.save_video_to_local));
        localArrayList2.add(Integer.valueOf(0));
        label361:
        do localdo = new do();
        localdo.bJZ.bJQ = paramString2;
        com.tencent.mm.sdk.b.a.udP.m(localdo);
        if (localdo.bKa.bJy)
        {
          localArrayList1.add(this.context.getString(i.j.app_open));
          localArrayList2.add(Integer.valueOf(5));
        }
        if ((!v.OT(paramString2)) && (localn.field_type == 1))
        {
          localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_photo_edit));
          localArrayList2.add(Integer.valueOf(6));
        }
        if (this.oOO == null) {
          break label96;
        }
        if (!com.tencent.mm.plugin.scanner.a.wM(this.bIj)) {
          break label601;
        }
        localArrayList1.add(this.context.getString(i.j.sns_scan_image));
      }
      for (;;)
      {
        localArrayList2.add(Integer.valueOf(4));
        break;
        if (localn.field_type == 1)
        {
          localArrayList1.add(this.context.getString(i.j.save_img_to_local));
          localArrayList2.add(Integer.valueOf(0));
          break label361;
        }
        localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
        localArrayList2.add(Integer.valueOf(0));
        break label361;
        label601:
        if (com.tencent.mm.plugin.scanner.a.aD(this.bIj, this.oOO)) {
          localArrayList1.add(this.context.getString(i.j.sns_scan_wxcode_image));
        } else if (com.tencent.mm.plugin.scanner.a.wL(this.bIj)) {
          localArrayList1.add(this.context.getString(i.j.sns_scan_barcode_image));
        } else {
          localArrayList1.add(this.context.getString(i.j.sns_scan_image));
        }
      }
      label688:
      this.oOK = new com.tencent.mm.ui.widget.a.d(this.context, 1, false);
    }
  }
  
  public awd getCntMedia()
  {
    return null;
  }
  
  public abstract Gallery getGallery();
  
  public abstract int getPosition();
  
  public abstract long getSnsId();
  
  protected final void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.kbV);
    com.tencent.mm.sdk.b.a.udP.d(this.oOV);
  }
  
  protected void onPause()
  {
    this.oOL = null;
    this.oOM = "";
    this.oON = null;
    if (this.oOO != null)
    {
      al localal = new al();
      localal.bGD.activity = ((Activity)this.context);
      localal.bGD.bGE = this.oOO;
      com.tencent.mm.sdk.b.a.udP.m(localal);
      this.oOO = null;
      this.bIk = 0;
      this.bIj = 0;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!f.cAr()) {}
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setNeedScanImage(boolean paramBoolean)
  {
    this.oOJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.FlipView
 * JD-Core Version:    0.7.0.1
 */