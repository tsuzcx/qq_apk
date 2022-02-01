package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "bgView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getBgView", "()Landroid/widget/ImageView;", "setBgView", "(Landroid/widget/ImageView;)V", "blurBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "initLogic", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "release", "reset", "saveBgBitmap", "setBlackBg", "plugin-recordvideo_release"})
public final class r
  implements u
{
  private Bitmap HNJ;
  private String TAG;
  private Context context;
  public ImageView zpB;
  
  public r(ImageView paramImageView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(75578);
    this.zpB = paramImageView;
    this.TAG = "MicroMsg.EditVideoBgPlugin";
    this.context = this.zpB.getContext();
    AppMethodBeat.o(75578);
  }
  
  /* Error */
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider paramRecordConfigProvider)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: ldc 87
    //   8: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: ldc 88
    //   14: invokestatic 53	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 70	com/tencent/mm/plugin/recordvideo/plugin/r:TAG	Ljava/lang/String;
    //   21: ldc 89
    //   23: invokestatic 94	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +173 -> 200
    //   30: aload_2
    //   31: getfield 100	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:HKW	Ljava/lang/Boolean;
    //   34: astore 4
    //   36: aload 4
    //   38: getstatic 105	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   41: invokestatic 109	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   44: ifeq +375 -> 419
    //   47: getstatic 115	com/tencent/mm/plugin/recordvideo/e/e:Ife	Lcom/tencent/mm/plugin/recordvideo/e/e;
    //   50: astore 4
    //   52: aload_1
    //   53: invokevirtual 121	com/tencent/mm/media/widget/camerarecordview/b/b:aZh	()Ljava/lang/String;
    //   56: invokestatic 125	com/tencent/mm/plugin/recordvideo/e/e:aWt	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/e$a;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +356 -> 419
    //   66: aload 4
    //   68: getfield 131	com/tencent/mm/plugin/recordvideo/e/e$a:fSM	I
    //   71: ifeq +14 -> 85
    //   74: aload 4
    //   76: getfield 131	com/tencent/mm/plugin/recordvideo/e/e$a:fSM	I
    //   79: sipush 180
    //   82: if_icmpne +129 -> 211
    //   85: aload 4
    //   87: getfield 134	com/tencent/mm/plugin/recordvideo/e/e$a:width	I
    //   90: aload 4
    //   92: getfield 137	com/tencent/mm/plugin/recordvideo/e/e$a:height	I
    //   95: if_icmple +111 -> 206
    //   98: iconst_1
    //   99: istore_3
    //   100: iload_3
    //   101: ifeq +295 -> 396
    //   104: aload_2
    //   105: getfield 140	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   108: iconst_3
    //   109: if_icmpne +287 -> 396
    //   112: new 142	com/tencent/mm/ui/blur/e
    //   115: dup
    //   116: aload_0
    //   117: getfield 78	com/tencent/mm/plugin/recordvideo/plugin/r:context	Landroid/content/Context;
    //   120: invokespecial 145	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   123: astore_2
    //   124: aload_1
    //   125: getfield 148	com/tencent/mm/media/widget/camerarecordview/b/b:lfj	Ljava/lang/String;
    //   128: aload_1
    //   129: getfield 151	com/tencent/mm/media/widget/camerarecordview/b/b:fod	I
    //   132: i2l
    //   133: ldc2_w 152
    //   136: lmul
    //   137: invokestatic 159	com/tencent/mm/plugin/mmsight/d:bb	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
    //   140: astore 4
    //   142: aload 4
    //   144: ifnonnull +90 -> 234
    //   147: aload 5
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +25 -> 176
    //   154: aload_0
    //   155: aload_2
    //   156: aload_1
    //   157: ldc 160
    //   159: invokevirtual 164	com/tencent/mm/ui/blur/e:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   162: putfield 166	com/tencent/mm/plugin/recordvideo/plugin/r:HNJ	Landroid/graphics/Bitmap;
    //   165: aload_0
    //   166: getfield 66	com/tencent/mm/plugin/recordvideo/plugin/r:zpB	Landroid/widget/ImageView;
    //   169: aload_0
    //   170: getfield 166	com/tencent/mm/plugin/recordvideo/plugin/r:HNJ	Landroid/graphics/Bitmap;
    //   173: invokevirtual 170	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   176: aload_2
    //   177: invokevirtual 173	com/tencent/mm/ui/blur/e:destroy	()V
    //   180: getstatic 179	com/tencent/mm/plugin/recordvideo/d/c:HUw	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   183: astore_1
    //   184: invokestatic 183	com/tencent/mm/plugin/recordvideo/d/c:fxq	()Lcom/tencent/mm/f/b/a/lo;
    //   187: ldc2_w 184
    //   190: invokevirtual 191	com/tencent/mm/f/b/a/lo:vM	(J)Lcom/tencent/mm/f/b/a/lo;
    //   193: pop
    //   194: ldc 87
    //   196: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: return
    //   200: aconst_null
    //   201: astore 4
    //   203: goto -167 -> 36
    //   206: iconst_0
    //   207: istore_3
    //   208: goto -108 -> 100
    //   211: aload 4
    //   213: getfield 137	com/tencent/mm/plugin/recordvideo/e/e$a:height	I
    //   216: aload 4
    //   218: getfield 134	com/tencent/mm/plugin/recordvideo/e/e$a:width	I
    //   221: if_icmple +8 -> 229
    //   224: iconst_1
    //   225: istore_3
    //   226: goto -126 -> 100
    //   229: iconst_0
    //   230: istore_3
    //   231: goto -131 -> 100
    //   234: aload 4
    //   236: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   239: aload 4
    //   241: invokevirtual 200	android/graphics/Bitmap:getHeight	()I
    //   244: getstatic 206	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   247: invokestatic 210	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   250: astore_1
    //   251: aload 4
    //   253: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   256: aload 4
    //   258: invokevirtual 200	android/graphics/Bitmap:getHeight	()I
    //   261: imul
    //   262: newarray int
    //   264: astore 5
    //   266: aload 4
    //   268: aload 5
    //   270: iconst_0
    //   271: aload 4
    //   273: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   276: iconst_0
    //   277: iconst_0
    //   278: aload 4
    //   280: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   283: aload 4
    //   285: invokevirtual 200	android/graphics/Bitmap:getHeight	()I
    //   288: invokevirtual 214	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   291: aload_1
    //   292: ldc 216
    //   294: invokestatic 219	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   297: aload_1
    //   298: aload 5
    //   300: iconst_0
    //   301: aload_1
    //   302: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   305: iconst_0
    //   306: iconst_0
    //   307: aload_1
    //   308: invokevirtual 197	android/graphics/Bitmap:getWidth	()I
    //   311: aload_1
    //   312: invokevirtual 200	android/graphics/Bitmap:getHeight	()I
    //   315: invokevirtual 222	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   318: goto -168 -> 150
    //   321: astore_2
    //   322: aload 6
    //   324: astore_1
    //   325: ldc 224
    //   327: aload_2
    //   328: checkcast 226	java/lang/Throwable
    //   331: ldc 228
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   343: ifle +19 -> 362
    //   346: aload_0
    //   347: getfield 78	com/tencent/mm/plugin/recordvideo/plugin/r:context	Landroid/content/Context;
    //   350: ldc 237
    //   352: checkcast 239	java/lang/CharSequence
    //   355: iconst_0
    //   356: invokestatic 245	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   359: invokevirtual 248	android/widget/Toast:show	()V
    //   362: aload_0
    //   363: aconst_null
    //   364: putfield 166	com/tencent/mm/plugin/recordvideo/plugin/r:HNJ	Landroid/graphics/Bitmap;
    //   367: aload_1
    //   368: ifnull -188 -> 180
    //   371: aload_1
    //   372: invokevirtual 173	com/tencent/mm/ui/blur/e:destroy	()V
    //   375: goto -195 -> 180
    //   378: astore_1
    //   379: aconst_null
    //   380: astore_2
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 173	com/tencent/mm/ui/blur/e:destroy	()V
    //   389: ldc 87
    //   391: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_1
    //   395: athrow
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 166	com/tencent/mm/plugin/recordvideo/plugin/r:HNJ	Landroid/graphics/Bitmap;
    //   401: getstatic 179	com/tencent/mm/plugin/recordvideo/d/c:HUw	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   404: astore_1
    //   405: invokestatic 183	com/tencent/mm/plugin/recordvideo/d/c:fxq	()Lcom/tencent/mm/f/b/a/lo;
    //   408: lconst_1
    //   409: invokevirtual 191	com/tencent/mm/f/b/a/lo:vM	(J)Lcom/tencent/mm/f/b/a/lo;
    //   412: pop
    //   413: ldc 87
    //   415: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: return
    //   419: ldc 87
    //   421: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: return
    //   425: astore_1
    //   426: goto -45 -> 381
    //   429: astore 4
    //   431: aload_1
    //   432: astore_2
    //   433: aload 4
    //   435: astore_1
    //   436: goto -55 -> 381
    //   439: astore 4
    //   441: aload_2
    //   442: astore_1
    //   443: aload 4
    //   445: astore_2
    //   446: goto -121 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	this	r
    //   0	449	1	paramb	com.tencent.mm.media.widget.camerarecordview.b.b
    //   0	449	2	paramRecordConfigProvider	com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider
    //   99	132	3	i	int
    //   34	250	4	localObject1	Object
    //   429	5	4	localObject2	Object
    //   439	5	4	localException	java.lang.Exception
    //   4	295	5	arrayOfInt	int[]
    //   1	322	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   112	124	321	java/lang/Exception
    //   112	124	378	finally
    //   124	142	425	finally
    //   154	176	425	finally
    //   234	318	425	finally
    //   325	362	429	finally
    //   362	367	429	finally
    //   124	142	439	java/lang/Exception
    //   154	176	439	java/lang/Exception
    //   234	318	439	java/lang/Exception
  }
  
  public final void bbp() {}
  
  public final String fwV()
  {
    AppMethodBeat.i(163434);
    if (this.HNJ != null)
    {
      Object localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      localObject = com.tencent.mm.plugin.recordvideo.e.d.aWr(String.valueOf(System.currentTimeMillis()));
      BitmapUtil.saveBitmapToImage(this.HNJ, 100, Bitmap.CompressFormat.JPEG, (String)localObject, false);
      AppMethodBeat.o(163434);
      return localObject;
    }
    AppMethodBeat.o(163434);
    return null;
  }
  
  public final String name()
  {
    AppMethodBeat.i(221931);
    String str = getClass().getName();
    AppMethodBeat.o(221931);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(221934);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(221934);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75577);
    Bitmap localBitmap = this.HNJ;
    if (localBitmap != null)
    {
      if (!localBitmap.isRecycled())
      {
        localBitmap = this.HNJ;
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        this.HNJ = null;
      }
      AppMethodBeat.o(75577);
      return;
    }
    AppMethodBeat.o(75577);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75576);
    ImageView localImageView = this.zpB;
    Context localContext = this.zpB.getContext();
    p.j(localContext, "bgView.context");
    localImageView.setBackgroundColor(localContext.getResources().getColor(b.b.transparent));
    AppMethodBeat.o(75576);
  }
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.r
 * JD-Core Version:    0.7.0.1
 */