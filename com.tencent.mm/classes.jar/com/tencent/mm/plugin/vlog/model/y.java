package com.tencent.mm.plugin.vlog.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vfs.i;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.URLAsset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "", "path", "", "type", "", "fromCamera", "(Ljava/lang/String;II)V", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getCropInfo", "()Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "durationMs", "", "getDurationMs", "()J", "editInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "getEditInfo", "()Lcom/tencent/mm/plugin/recordvideo/jumper/MediaEditReportInfo$EditItem;", "endTimeMs", "getEndTimeMs", "setEndTimeMs", "(J)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "id", "getId", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "sourceDuration", "getSourceDuration", "setSourceDuration", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceScale", "", "getSourceScale", "()F", "setSourceScale", "(F)V", "sourceWidth", "getSourceWidth", "setSourceWidth", "startTimeMs", "getStartTimeMs", "setStartTimeMs", "trackEndTimeMs", "getTrackEndTimeMs", "setTrackEndTimeMs", "trackStartTimeMs", "getTrackStartTimeMs", "setTrackStartTimeMs", "getType", "setType", "buildClip", "Lcom/tencent/tavkit/composition/TAVClip;", "buildComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "buildImageClip", "buildImageThumbClip", "buildThumbSource", "Lcom/tencent/tavkit/composition/TAVSource;", "buildVideoClip", "buildVideoThumbClip", "createRescaleBitmap", "Landroid/graphics/Bitmap;", "getThumbCache", "resizeBitmap", "bitmap", "Companion", "plugin-vlog_release"})
public final class y
{
  private static final SparseArray<Bitmap> Lrw;
  public static final a Lrx;
  int LqD;
  public long Lro;
  public long Lrp;
  long Lrq;
  public int Lrr;
  public int Lrs;
  float Lrt;
  public final n Lru;
  public final MediaEditReportInfo.EditItem Lrv;
  public long bxw;
  public long gnO;
  public final int id;
  public String path;
  public int type;
  
  static
  {
    AppMethodBeat.i(200935);
    Lrx = new a((byte)0);
    Lrw = new SparseArray();
    AppMethodBeat.o(200935);
  }
  
  public y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200934);
    this.path = paramString;
    this.type = paramInt1;
    this.LqD = paramInt2;
    this.id = hashCode();
    this.Lrt = 1.0F;
    this.Lru = new n();
    this.Lrv = new MediaEditReportInfo.EditItem();
    ad.i("MicroMsg.VLogCompositionTrack", "create VLogCompositionTrack path:" + this.path + ", type:" + this.type + ", id:" + this.id);
    AppMethodBeat.o(200934);
  }
  
  /* Error */
  private final Bitmap aVV(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 199
    //   8: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: invokestatic 204	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   14: lstore 5
    //   16: ldc 169
    //   18: new 171	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   25: aload_0
    //   26: getfield 155	com/tencent/mm/plugin/vlog/model/y:id	I
    //   29: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 207
    //   34: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: new 209	android/graphics/BitmapFactory$Options
    //   50: dup
    //   51: invokespecial 210	android/graphics/BitmapFactory$Options:<init>	()V
    //   54: astore 7
    //   56: aload 7
    //   58: iconst_1
    //   59: putfield 214	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   62: aload_1
    //   63: aload 7
    //   65: invokestatic 220	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   68: pop
    //   69: aload 7
    //   71: getfield 223	android/graphics/BitmapFactory$Options:outWidth	I
    //   74: istore_3
    //   75: aload 7
    //   77: getfield 226	android/graphics/BitmapFactory$Options:outHeight	I
    //   80: istore 4
    //   82: aload 7
    //   84: iload_3
    //   85: iload 4
    //   87: sipush 1080
    //   90: sipush 1080
    //   93: invokestatic 232	com/tencent/mm/sdk/platformtools/f:M	(IIII)I
    //   96: putfield 235	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   99: aload 7
    //   101: iconst_0
    //   102: putfield 214	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   105: aload_1
    //   106: aload 7
    //   108: invokestatic 220	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   111: astore 7
    //   113: aload 7
    //   115: ifnull +276 -> 391
    //   118: aload 7
    //   120: invokevirtual 241	android/graphics/Bitmap:isRecycled	()Z
    //   123: ifne +268 -> 391
    //   126: aload 7
    //   128: invokevirtual 244	android/graphics/Bitmap:getWidth	()I
    //   131: iconst_2
    //   132: irem
    //   133: iconst_1
    //   134: if_icmpne +254 -> 388
    //   137: aload 7
    //   139: invokevirtual 244	android/graphics/Bitmap:getWidth	()I
    //   142: iconst_1
    //   143: iadd
    //   144: aload 7
    //   146: invokevirtual 247	android/graphics/Bitmap:getHeight	()I
    //   149: getstatic 253	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   152: invokestatic 257	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   155: astore 10
    //   157: aload 10
    //   159: ifnonnull +6 -> 165
    //   162: invokestatic 260	d/g/b/k:fvU	()V
    //   165: new 262	android/graphics/Canvas
    //   168: dup
    //   169: aload 10
    //   171: invokespecial 265	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   174: astore 11
    //   176: aload 11
    //   178: iconst_0
    //   179: iconst_0
    //   180: iconst_0
    //   181: iconst_0
    //   182: invokevirtual 269	android/graphics/Canvas:drawARGB	(IIII)V
    //   185: aload 11
    //   187: aload 7
    //   189: fconst_0
    //   190: fconst_0
    //   191: aconst_null
    //   192: invokevirtual 273	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   195: aload 10
    //   197: astore 7
    //   199: aload 7
    //   201: ifnonnull +6 -> 207
    //   204: invokestatic 260	d/g/b/k:fvU	()V
    //   207: aload_1
    //   208: invokestatic 279	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +209 -> 422
    //   216: aload_1
    //   217: checkcast 281	java/io/Closeable
    //   220: astore 10
    //   222: new 283	android/support/d/a
    //   225: dup
    //   226: aload 10
    //   228: checkcast 285	java/io/InputStream
    //   231: invokespecial 288	android/support/d/a:<init>	(Ljava/io/InputStream;)V
    //   234: astore_1
    //   235: getstatic 294	d/y:JfV	Ld/y;
    //   238: astore 11
    //   240: aload 10
    //   242: aconst_null
    //   243: invokestatic 299	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: ifnull +15 -> 262
    //   250: aload_1
    //   251: ldc_w 301
    //   254: invokevirtual 305	android/support/d/a:l	(Ljava/lang/String;)I
    //   257: invokestatic 311	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: astore 8
    //   262: aload 8
    //   264: ifnonnull +163 -> 427
    //   267: aload 8
    //   269: ifnonnull +182 -> 451
    //   272: aload 8
    //   274: ifnonnull +201 -> 475
    //   277: iconst_0
    //   278: istore_2
    //   279: iload_2
    //   280: ifle +228 -> 508
    //   283: aload 7
    //   285: iload_2
    //   286: i2f
    //   287: invokestatic 314	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   290: astore_1
    //   291: aload_1
    //   292: ldc_w 316
    //   295: invokestatic 319	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   298: ldc 169
    //   300: new 171	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   307: aload_0
    //   308: getfield 155	com/tencent/mm/plugin/vlog/model/y:id	I
    //   311: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc_w 321
    //   317: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 244	android/graphics/Bitmap:getWidth	()I
    //   324: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 323
    //   330: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_1
    //   334: invokevirtual 247	android/graphics/Bitmap:getHeight	()I
    //   337: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 325
    //   343: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_3
    //   347: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 323
    //   353: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: iload 4
    //   358: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 327
    //   364: invokevirtual 179	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: lload 5
    //   369: invokestatic 331	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   372: invokevirtual 334	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: ldc 199
    //   383: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: aload_1
    //   387: areturn
    //   388: goto -189 -> 199
    //   391: aconst_null
    //   392: astore 7
    //   394: goto -195 -> 199
    //   397: astore 7
    //   399: ldc 199
    //   401: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 7
    //   406: athrow
    //   407: astore_1
    //   408: aload 10
    //   410: aload 7
    //   412: invokestatic 299	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   415: ldc 199
    //   417: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aload_1
    //   421: athrow
    //   422: aconst_null
    //   423: astore_1
    //   424: goto -178 -> 246
    //   427: aload 8
    //   429: invokevirtual 337	java/lang/Integer:intValue	()I
    //   432: bipush 6
    //   434: if_icmpne -167 -> 267
    //   437: ldc 169
    //   439: ldc_w 339
    //   442: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: bipush 90
    //   447: istore_2
    //   448: goto -169 -> 279
    //   451: aload 8
    //   453: invokevirtual 337	java/lang/Integer:intValue	()I
    //   456: iconst_3
    //   457: if_icmpne -185 -> 272
    //   460: ldc 169
    //   462: ldc_w 341
    //   465: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   468: sipush 180
    //   471: istore_2
    //   472: goto -193 -> 279
    //   475: aload 8
    //   477: invokevirtual 337	java/lang/Integer:intValue	()I
    //   480: bipush 8
    //   482: if_icmpne -205 -> 277
    //   485: ldc 169
    //   487: ldc_w 343
    //   490: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: sipush 270
    //   496: istore_2
    //   497: goto -218 -> 279
    //   500: astore_1
    //   501: aload 9
    //   503: astore 7
    //   505: goto -97 -> 408
    //   508: aload 7
    //   510: astore_1
    //   511: goto -213 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	y
    //   0	514	1	paramString	String
    //   278	219	2	i	int
    //   74	273	3	j	int
    //   80	277	4	k	int
    //   14	354	5	l	long
    //   54	339	7	localObject1	Object
    //   397	14	7	localThrowable	Throwable
    //   503	6	7	localObject2	Object
    //   4	472	8	localInteger	java.lang.Integer
    //   1	501	9	localObject3	Object
    //   155	254	10	localObject4	Object
    //   174	65	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   222	240	397	java/lang/Throwable
    //   399	407	407	finally
    //   222	240	500	finally
  }
  
  private final TAVClip fYN()
  {
    AppMethodBeat.i(200930);
    TAVClip localTAVClip = new TAVClip((TAVResource)new TAVImageResource(new CIImage(fYP()), CMTime.fromMs(cuR())));
    localTAVClip.setStartTime(CMTime.fromMs(this.bxw));
    localTAVClip.setDuration(CMTime.fromMs(cuR()));
    ad.i("MicroMsg.VLogCompositionTrack", this.id + " buildClip buildImageClip, path:" + this.path + ", material startEnd:[" + this.bxw + ", " + this.gnO + ']');
    AppMethodBeat.o(200930);
    return localTAVClip;
  }
  
  private final TAVClip fYO()
  {
    AppMethodBeat.i(200931);
    TAVClip localTAVClip = new TAVClip((Asset)new URLAsset(i.k(this.path, false)));
    localTAVClip.setDuration(CMTime.fromMs(cuR()));
    TAVResource localTAVResource = localTAVClip.getResource();
    k.g(localTAVResource, "clip.resource");
    localTAVResource.setSourceTimeRange(new CMTimeRange(CMTime.fromMs(this.Lro), CMTime.fromMs(this.Lrp - this.Lro)));
    localTAVClip.setStartTime(CMTime.fromMs(this.bxw));
    ad.i("MicroMsg.VLogCompositionTrack", this.id + " buildClip buildVideoClip, path:" + this.path + ", video startEnd:[" + this.Lro + ", " + this.Lrp + "], material startEnd:[" + this.bxw + ", " + this.gnO + ']');
    AppMethodBeat.o(200931);
    return localTAVClip;
  }
  
  public final long cuR()
  {
    return this.gnO - this.bxw;
  }
  
  public final TAVClip fYM()
  {
    AppMethodBeat.i(200929);
    if (this.type == 1)
    {
      localTAVClip = fYN();
      AppMethodBeat.o(200929);
      return localTAVClip;
    }
    if (this.type == 2)
    {
      localTAVClip = fYO();
      AppMethodBeat.o(200929);
      return localTAVClip;
    }
    TAVClip localTAVClip = new TAVClip((TAVResource)new TAVEmptyResource(CMTime.CMTimeZero));
    AppMethodBeat.o(200929);
    return localTAVClip;
  }
  
  public final Bitmap fYP()
  {
    AppMethodBeat.i(200932);
    Object localObject = this.path;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(200932);
      throw ((Throwable)localObject);
    }
    int i = d.n.n.trim((CharSequence)localObject).toString().hashCode();
    localObject = (Bitmap)Lrw.get(i);
    if (localObject != null)
    {
      AppMethodBeat.o(200932);
      return localObject;
    }
    localObject = aVV(this.path);
    Lrw.put(i, localObject);
    AppMethodBeat.o(200932);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack$Companion;", "", "()V", "IMAGE_SIZE_LIMIT", "", "TAG", "", "TypeImage", "TypeUnknown", "TypeVideo", "bitmapCache", "Landroid/util/SparseArray;", "Landroid/graphics/Bitmap;", "releaseBitmapCache", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */