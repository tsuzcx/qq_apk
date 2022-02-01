package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final a vnp;
  
  static
  {
    AppMethodBeat.i(75779);
    vnp = new a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private final void diu()
  {
    AppMethodBeat.i(75776);
    Object localObject1 = ((Iterable)getItemContainerPlugin().did()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.media.editor.a.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.media.editor.a.a)localObject2).goB;
      switch (c.fPQ[localObject3.ordinal()])
      {
      default: 
        break;
      case 1: 
        i += 1;
        break;
      case 2: 
        j += 1;
        break;
      case 3: 
        localObject2 = (bmp)((com.tencent.mm.media.editor.a.a)localObject2).ajx();
        localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.b.diy();
        String str1 = ((bmp)localObject2).goP;
        k.g(str1, "poiData.cityName");
        String str2 = ((bmp)localObject2).goQ;
        k.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.h(str1, ",", " ", true));
        }
        if (!TextUtils.isEmpty((CharSequence)str2)) {
          if (((CharSequence)localStringBuilder).length() <= 0) {
            break label320;
          }
        }
        for (int k = 1;; k = 0)
        {
          if (k != 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append(n.h(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          k.g(str1, "reportPositionString.toString()");
          ((dc)localObject3).jx(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().jy(String.valueOf(((bmp)localObject2).dpb));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diy().jz(String.valueOf(((bmp)localObject2).dqQ));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().QH();
        break;
      case 5: 
        label320:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().QI();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fp(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    com.tencent.mm.plugin.recordvideo.d.b.diy().fq(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diy();
    if (getMoreMenuPlugin().vjK) {}
    for (long l = 1L;; l = 0L)
    {
      ((dc)localObject1).fv(l);
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void div()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject).gBs;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapFactory.decodeFile(str, localOptions);
          i = localOptions.outWidth;
          int j = localOptions.outHeight;
          localStringBuilder.append(j + ':' + i + "||");
        }
      }
    }
    int i = localStringBuilder.lastIndexOf("||");
    if (i >= 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diy().jB(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75777);
  }
  
  /* Error */
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    // Byte code:
    //   0: ldc_w 295
    //   3: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 297
    //   9: ldc_w 299
    //   12: aload_1
    //   13: invokestatic 302	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 311	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 313	com/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;)V
    //   27: aload_1
    //   28: ifnull +1855 -> 1883
    //   31: getstatic 319	com/tencent/mm/plugin/recordvideo/e/a:vtA	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   34: astore 6
    //   36: iconst_0
    //   37: invokestatic 322	com/tencent/mm/plugin/recordvideo/e/a:Ku	(I)V
    //   40: aload_1
    //   41: invokevirtual 325	com/tencent/mm/media/widget/camerarecordview/b/b:anZ	()Z
    //   44: ifeq +16 -> 60
    //   47: getstatic 319	com/tencent/mm/plugin/recordvideo/e/a:vtA	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   50: astore 6
    //   52: invokestatic 328	com/tencent/mm/plugin/recordvideo/e/a:djc	()I
    //   55: iconst_1
    //   56: iadd
    //   57: invokestatic 322	com/tencent/mm/plugin/recordvideo/e/a:Ku	(I)V
    //   60: aload_1
    //   61: invokevirtual 331	com/tencent/mm/media/widget/camerarecordview/b/b:anY	()Z
    //   64: ifeq +16 -> 80
    //   67: getstatic 319	com/tencent/mm/plugin/recordvideo/e/a:vtA	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   70: astore 6
    //   72: invokestatic 328	com/tencent/mm/plugin/recordvideo/e/a:djc	()I
    //   75: iconst_1
    //   76: iadd
    //   77: invokestatic 322	com/tencent/mm/plugin/recordvideo/e/a:Ku	(I)V
    //   80: invokestatic 337	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   83: lstore 4
    //   85: aload_0
    //   86: invokevirtual 341	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getBgPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/q;
    //   89: astore 9
    //   91: aload_0
    //   92: invokevirtual 246	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   95: astore 8
    //   97: aload 8
    //   99: ifnonnull +6 -> 105
    //   102: invokestatic 344	d/g/b/k:fvU	()V
    //   105: aload_0
    //   106: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   109: astore 7
    //   111: aload 8
    //   113: ldc_w 349
    //   116: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   119: aload 9
    //   121: getfield 354	com/tencent/mm/plugin/recordvideo/plugin/q:TAG	Ljava/lang/String;
    //   124: ldc_w 356
    //   127: invokestatic 311	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 7
    //   132: ifnull +1392 -> 1524
    //   135: aload 7
    //   137: getfield 362	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhL	Ljava/lang/Boolean;
    //   140: astore 6
    //   142: aload 6
    //   144: getstatic 367	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   147: invokestatic 370	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   150: ifeq +168 -> 318
    //   153: getstatic 376	com/tencent/mm/plugin/recordvideo/e/c:vtL	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   156: astore 6
    //   158: aload 8
    //   160: invokevirtual 379	com/tencent/mm/media/widget/camerarecordview/b/b:aoa	()Ljava/lang/String;
    //   163: invokestatic 383	com/tencent/mm/plugin/recordvideo/e/c:alZ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   166: astore 6
    //   168: aload 6
    //   170: ifnull +148 -> 318
    //   173: aload 6
    //   175: getfield 388	com/tencent/mm/plugin/recordvideo/e/c$a:dwp	I
    //   178: ifeq +14 -> 192
    //   181: aload 6
    //   183: getfield 388	com/tencent/mm/plugin/recordvideo/e/c$a:dwp	I
    //   186: sipush 180
    //   189: if_icmpne +1346 -> 1535
    //   192: aload 6
    //   194: getfield 391	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   197: aload 6
    //   199: getfield 394	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   202: if_icmple +1328 -> 1530
    //   205: iconst_1
    //   206: istore_2
    //   207: iload_2
    //   208: ifeq +1537 -> 1745
    //   211: aload 7
    //   213: getfield 397	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   216: iconst_3
    //   217: if_icmpne +1528 -> 1745
    //   220: aconst_null
    //   221: astore 7
    //   223: new 399	com/tencent/mm/ui/blur/e
    //   226: dup
    //   227: aload 9
    //   229: getfield 401	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   232: invokespecial 404	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   235: astore 6
    //   237: aload 8
    //   239: getfield 407	com/tencent/mm/media/widget/camerarecordview/b/b:gBj	Ljava/lang/String;
    //   242: aload 8
    //   244: getfield 410	com/tencent/mm/media/widget/camerarecordview/b/b:cUL	I
    //   247: i2l
    //   248: ldc2_w 411
    //   251: lmul
    //   252: invokestatic 418	com/tencent/mm/plugin/mmsight/d:aV	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
    //   255: astore 8
    //   257: aload 8
    //   259: ifnonnull +1299 -> 1558
    //   262: aconst_null
    //   263: astore 7
    //   265: aload 7
    //   267: ifnull +31 -> 298
    //   270: aload 9
    //   272: aload 6
    //   274: aload 7
    //   276: ldc_w 419
    //   279: invokevirtual 423	com/tencent/mm/ui/blur/e:d	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   282: putfield 427	com/tencent/mm/plugin/recordvideo/plugin/q:vkz	Landroid/graphics/Bitmap;
    //   285: aload 9
    //   287: getfield 431	com/tencent/mm/plugin/recordvideo/plugin/q:vkA	Landroid/widget/ImageView;
    //   290: aload 9
    //   292: getfield 427	com/tencent/mm/plugin/recordvideo/plugin/q:vkz	Landroid/graphics/Bitmap;
    //   295: invokevirtual 437	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   298: aload 6
    //   300: invokevirtual 440	com/tencent/mm/ui/blur/e:destroy	()V
    //   303: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   306: astore 6
    //   308: invokestatic 139	com/tencent/mm/plugin/recordvideo/d/b:diy	()Lcom/tencent/mm/g/b/a/dc;
    //   311: ldc2_w 441
    //   314: invokevirtual 445	com/tencent/mm/g/b/a/dc:fy	(J)Lcom/tencent/mm/g/b/a/dc;
    //   317: pop
    //   318: aload_0
    //   319: invokevirtual 449	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getPreviewPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/s;
    //   322: astore 7
    //   324: aload_0
    //   325: invokevirtual 246	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   328: astore 8
    //   330: aload 8
    //   332: ifnonnull +6 -> 338
    //   335: invokestatic 344	d/g/b/k:fvU	()V
    //   338: aload_0
    //   339: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   342: astore 9
    //   344: aload 8
    //   346: ldc_w 349
    //   349: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   352: ldc_w 451
    //   355: ldc_w 453
    //   358: aload 8
    //   360: invokestatic 302	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   363: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokestatic 311	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 7
    //   371: aload 8
    //   373: putfield 459	com/tencent/mm/plugin/recordvideo/plugin/s:vjS	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   376: aload 9
    //   378: ifnull +1389 -> 1767
    //   381: aload 9
    //   383: getfield 462	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhQ	I
    //   386: istore_2
    //   387: aload 7
    //   389: iload_2
    //   390: putfield 465	com/tencent/mm/plugin/recordvideo/plugin/s:vkH	I
    //   393: aload 7
    //   395: new 467	com/tencent/mm/compatible/util/b
    //   398: dup
    //   399: aload 7
    //   401: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   404: invokevirtual 477	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:getContext	()Landroid/content/Context;
    //   407: invokespecial 478	com/tencent/mm/compatible/util/b:<init>	(Landroid/content/Context;)V
    //   410: putfield 482	com/tencent/mm/plugin/recordvideo/plugin/s:hDB	Lcom/tencent/mm/compatible/util/b;
    //   413: aload 7
    //   415: getfield 482	com/tencent/mm/plugin/recordvideo/plugin/s:hDB	Lcom/tencent/mm/compatible/util/b;
    //   418: astore 6
    //   420: aload 6
    //   422: ifnull +9 -> 431
    //   425: aload 6
    //   427: invokevirtual 485	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   430: pop
    //   431: aload 7
    //   433: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   436: iconst_0
    //   437: invokevirtual 488	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVisibility	(I)V
    //   440: aload 7
    //   442: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   445: fconst_0
    //   446: invokevirtual 492	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setAlpha	(F)V
    //   449: aload 7
    //   451: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   454: aload 8
    //   456: invokevirtual 379	com/tencent/mm/media/widget/camerarecordview/b/b:aoa	()Ljava/lang/String;
    //   459: invokevirtual 496	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoPath	(Ljava/lang/String;)V
    //   462: aload 9
    //   464: ifnull +1310 -> 1774
    //   467: aload 9
    //   469: getfield 362	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhL	Ljava/lang/Boolean;
    //   472: astore 6
    //   474: aload 6
    //   476: getstatic 367	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   479: invokestatic 370	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   482: ifeq +94 -> 576
    //   485: getstatic 376	com/tencent/mm/plugin/recordvideo/e/c:vtL	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   488: astore 6
    //   490: aload 8
    //   492: invokevirtual 379	com/tencent/mm/media/widget/camerarecordview/b/b:aoa	()Ljava/lang/String;
    //   495: invokestatic 383	com/tencent/mm/plugin/recordvideo/e/c:alZ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   498: astore 6
    //   500: aload 6
    //   502: ifnull +74 -> 576
    //   505: aload 6
    //   507: getfield 388	com/tencent/mm/plugin/recordvideo/e/c$a:dwp	I
    //   510: ifeq +14 -> 524
    //   513: aload 6
    //   515: getfield 388	com/tencent/mm/plugin/recordvideo/e/c$a:dwp	I
    //   518: sipush 180
    //   521: if_icmpne +1264 -> 1785
    //   524: aload 6
    //   526: getfield 391	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   529: aload 6
    //   531: getfield 394	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   534: if_icmple +1246 -> 1780
    //   537: iconst_1
    //   538: istore_2
    //   539: aload 9
    //   541: ifnull +14 -> 555
    //   544: aload 9
    //   546: getfield 500	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhJ	Lcom/tencent/mm/pluginsdk/ui/h$e;
    //   549: getstatic 505	com/tencent/mm/pluginsdk/ui/h$e:BVq	Lcom/tencent/mm/pluginsdk/ui/h$e;
    //   552: if_acmpne +1279 -> 1831
    //   555: iload_2
    //   556: ifeq +1252 -> 1808
    //   559: aload 7
    //   561: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   564: getstatic 505	com/tencent/mm/pluginsdk/ui/h$e:BVq	Lcom/tencent/mm/pluginsdk/ui/h$e;
    //   567: invokevirtual 509	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/h$e;)V
    //   570: aload 7
    //   572: iconst_1
    //   573: putfield 512	com/tencent/mm/plugin/recordvideo/plugin/s:vkJ	Z
    //   576: aload 7
    //   578: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   581: aload 7
    //   583: getfield 516	com/tencent/mm/plugin/recordvideo/plugin/s:vkK	Lcom/tencent/mm/plugin/recordvideo/plugin/s$d;
    //   586: checkcast 518	com/tencent/mm/pluginsdk/ui/tools/h$a
    //   589: invokevirtual 522	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoCallback	(Lcom/tencent/mm/pluginsdk/ui/tools/h$a;)V
    //   592: aload 7
    //   594: aload 8
    //   596: getfield 410	com/tencent/mm/media/widget/camerarecordview/b/b:cUL	I
    //   599: putfield 523	com/tencent/mm/plugin/recordvideo/plugin/s:cUL	I
    //   602: aload 7
    //   604: aload 8
    //   606: getfield 526	com/tencent/mm/media/widget/camerarecordview/b/b:gBm	I
    //   609: putfield 527	com/tencent/mm/plugin/recordvideo/plugin/s:gBm	I
    //   612: aload 7
    //   614: getfield 531	com/tencent/mm/plugin/recordvideo/plugin/s:vkL	Landroid/widget/TextView;
    //   617: astore 6
    //   619: aload 6
    //   621: ifnull +10 -> 631
    //   624: aload 6
    //   626: bipush 8
    //   628: invokevirtual 534	android/widget/TextView:setVisibility	(I)V
    //   631: aload 7
    //   633: getfield 531	com/tencent/mm/plugin/recordvideo/plugin/s:vkL	Landroid/widget/TextView;
    //   636: astore 6
    //   638: aload 6
    //   640: ifnull +26 -> 666
    //   643: invokestatic 539	com/tencent/mm/sdk/platformtools/bu:eGT	()Z
    //   646: ifeq +20 -> 666
    //   649: new 541	com/tencent/mm/plugin/recordvideo/plugin/s$c
    //   652: dup
    //   653: aload 6
    //   655: aload 7
    //   657: invokespecial 544	com/tencent/mm/plugin/recordvideo/plugin/s$c:<init>	(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/s;)V
    //   660: checkcast 546	java/lang/Runnable
    //   663: invokestatic 552	com/tencent/mm/plugin/mmsight/model/j:ae	(Ljava/lang/Runnable;)V
    //   666: ldc_w 297
    //   669: new 155	java/lang/StringBuilder
    //   672: dup
    //   673: ldc_w 554
    //   676: invokespecial 556	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   679: lload 4
    //   681: invokestatic 560	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   684: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   687: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 565	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: aload_0
    //   694: invokevirtual 569	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getReMuxPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/ab;
    //   697: astore 6
    //   699: aload_0
    //   700: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   703: astore 7
    //   705: aload 7
    //   707: ifnonnull +6 -> 713
    //   710: invokestatic 344	d/g/b/k:fvU	()V
    //   713: aload 6
    //   715: aload_1
    //   716: aload 7
    //   718: invokevirtual 574	com/tencent/mm/plugin/recordvideo/plugin/ab:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   721: ldc_w 297
    //   724: new 155	java/lang/StringBuilder
    //   727: dup
    //   728: ldc_w 576
    //   731: invokespecial 556	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   734: lload 4
    //   736: invokestatic 560	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   739: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   742: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 565	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 580	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCropVideoPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/a;
    //   752: astore 6
    //   754: aload_0
    //   755: invokevirtual 246	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   758: astore 7
    //   760: aload 7
    //   762: ifnonnull +6 -> 768
    //   765: invokestatic 344	d/g/b/k:fvU	()V
    //   768: aload_0
    //   769: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   772: astore 8
    //   774: aload 8
    //   776: ifnonnull +6 -> 782
    //   779: invokestatic 344	d/g/b/k:fvU	()V
    //   782: aload 7
    //   784: ldc_w 349
    //   787: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   790: aload 8
    //   792: ldc_w 582
    //   795: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   798: aload 6
    //   800: aload 7
    //   802: putfield 587	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:vlU	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   805: aload 6
    //   807: aload 8
    //   809: putfield 591	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:vcC	Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   812: aload 6
    //   814: getfield 595	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:vlQ	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;
    //   817: astore 9
    //   819: aload 7
    //   821: getfield 407	com/tencent/mm/media/widget/camerarecordview/b/b:gBj	Ljava/lang/String;
    //   824: astore 10
    //   826: aload 8
    //   828: getfield 462	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhQ	I
    //   831: aload 7
    //   833: getfield 526	com/tencent/mm/media/widget/camerarecordview/b/b:gBm	I
    //   836: invokestatic 599	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:gL	(II)I
    //   839: istore_3
    //   840: aload 8
    //   842: getfield 603	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhH	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   845: astore 11
    //   847: aload 11
    //   849: ifnull +998 -> 1847
    //   852: aload 11
    //   854: getfield 608	com/tencent/mm/modelcontrol/VideoTransPara:minDuration	I
    //   857: istore_2
    //   858: aload 10
    //   860: ldc_w 610
    //   863: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   866: aload 9
    //   868: getfield 615	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:hasInit	Z
    //   871: ifne +68 -> 939
    //   874: aload 9
    //   876: iconst_1
    //   877: putfield 615	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:hasInit	Z
    //   880: aload 9
    //   882: getfield 619	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:tLG	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   885: aload 10
    //   887: invokevirtual 624	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:ahg	(Ljava/lang/String;)V
    //   890: new 605	com/tencent/mm/modelcontrol/VideoTransPara
    //   893: dup
    //   894: invokespecial 625	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   897: astore 10
    //   899: aload 10
    //   901: iload_3
    //   902: sipush 1000
    //   905: idiv
    //   906: putfield 628	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   909: aload 10
    //   911: iload_2
    //   912: putfield 608	com/tencent/mm/modelcontrol/VideoTransPara:minDuration	I
    //   915: aload 9
    //   917: getfield 619	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:tLG	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   920: aload 10
    //   922: invokevirtual 632	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:setVideoTransPara	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   925: aload 9
    //   927: getfield 619	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:tLG	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   930: getstatic 638	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$b:vmc	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$b;
    //   933: checkcast 640	com/tencent/mm/plugin/mmsight/segment/c$a
    //   936: invokevirtual 644	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:setOnPreparedListener	(Lcom/tencent/mm/plugin/mmsight/segment/c$a;)V
    //   939: aload 6
    //   941: getfield 595	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:vlQ	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;
    //   944: aload 6
    //   946: checkcast 646	com/tencent/mm/plugin/mmsight/segment/c$b
    //   949: invokevirtual 650	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:setThumbBarSeekListener	(Lcom/tencent/mm/plugin/mmsight/segment/c$b;)V
    //   952: aload 6
    //   954: aload 8
    //   956: getfield 462	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhQ	I
    //   959: aload 7
    //   961: getfield 526	com/tencent/mm/media/widget/camerarecordview/b/b:gBm	I
    //   964: invokestatic 599	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:gL	(II)I
    //   967: i2f
    //   968: fconst_1
    //   969: fmul
    //   970: aload 7
    //   972: getfield 526	com/tencent/mm/media/widget/camerarecordview/b/b:gBm	I
    //   975: i2f
    //   976: fdiv
    //   977: putfield 653	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:vlX	F
    //   980: ldc_w 297
    //   983: new 155	java/lang/StringBuilder
    //   986: dup
    //   987: ldc_w 655
    //   990: invokespecial 556	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   993: lload 4
    //   995: invokestatic 560	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   998: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 565	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_1
    //   1008: getfield 658	com/tencent/mm/media/widget/camerarecordview/b/b:Cos	Landroid/os/Bundle;
    //   1011: ifnull +231 -> 1242
    //   1014: aload_1
    //   1015: getfield 658	com/tencent/mm/media/widget/camerarecordview/b/b:Cos	Landroid/os/Bundle;
    //   1018: astore 6
    //   1020: aload 6
    //   1022: ifnonnull +6 -> 1028
    //   1025: invokestatic 344	d/g/b/k:fvU	()V
    //   1028: getstatic 664	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:viM	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   1031: astore 7
    //   1033: aload 6
    //   1035: invokestatic 667	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:fYc	()Ljava/lang/String;
    //   1038: invokevirtual 673	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1041: astore 6
    //   1043: aload_1
    //   1044: getfield 658	com/tencent/mm/media/widget/camerarecordview/b/b:Cos	Landroid/os/Bundle;
    //   1047: astore 7
    //   1049: aload 7
    //   1051: ifnonnull +6 -> 1057
    //   1054: invokestatic 344	d/g/b/k:fvU	()V
    //   1057: getstatic 664	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:viM	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   1060: astore 8
    //   1062: aload 7
    //   1064: invokestatic 676	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:fYb	()Ljava/lang/String;
    //   1067: iconst_0
    //   1068: invokevirtual 680	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1071: istore_2
    //   1072: aload 6
    //   1074: ifnull +168 -> 1242
    //   1077: aload 6
    //   1079: invokevirtual 684	java/util/ArrayList:isEmpty	()Z
    //   1082: ifne +160 -> 1242
    //   1085: aload_0
    //   1086: invokevirtual 688	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getAddMusicPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/a/a;
    //   1089: astore 7
    //   1091: aload 6
    //   1093: ldc_w 690
    //   1096: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1099: aload 7
    //   1101: getfield 696	com/tencent/mm/plugin/recordvideo/plugin/a/a:vmE	Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;
    //   1104: astore 7
    //   1106: aload 6
    //   1108: checkcast 698	java/util/List
    //   1111: astore 6
    //   1113: aload 6
    //   1115: ldc_w 690
    //   1118: invokestatic 74	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1121: aload 7
    //   1123: getfield 704	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:vqR	Lcom/tencent/mm/plugin/recordvideo/ui/a/a;
    //   1126: aload 6
    //   1128: invokevirtual 710	com/tencent/mm/plugin/recordvideo/ui/a/a:eL	(Ljava/util/List;)V
    //   1131: aload 6
    //   1133: invokeinterface 713 1 0
    //   1138: iload_2
    //   1139: if_icmple +97 -> 1236
    //   1142: aload 7
    //   1144: getfield 717	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:vqH	Landroid/support/v7/widget/RecyclerView;
    //   1147: astore 6
    //   1149: iload_2
    //   1150: new 719	com/tencent/mm/hellhoundlib/b/a
    //   1153: dup
    //   1154: invokespecial 720	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1157: invokestatic 725	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1160: astore 8
    //   1162: aload 6
    //   1164: aload 8
    //   1166: invokevirtual 729	com/tencent/mm/hellhoundlib/b/a:adn	()[Ljava/lang/Object;
    //   1169: ldc_w 730
    //   1172: ldc_w 732
    //   1175: ldc_w 734
    //   1178: ldc_w 736
    //   1181: ldc_w 738
    //   1184: ldc_w 739
    //   1187: invokestatic 744	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1190: aload 6
    //   1192: aload 8
    //   1194: iconst_0
    //   1195: invokevirtual 748	com/tencent/mm/hellhoundlib/b/a:lS	(I)Ljava/lang/Object;
    //   1198: checkcast 750	java/lang/Integer
    //   1201: invokevirtual 753	java/lang/Integer:intValue	()I
    //   1204: invokevirtual 758	android/support/v7/widget/RecyclerView:ca	(I)V
    //   1207: aload 6
    //   1209: ldc_w 730
    //   1212: ldc_w 732
    //   1215: ldc_w 734
    //   1218: ldc_w 736
    //   1221: ldc_w 738
    //   1224: ldc_w 739
    //   1227: invokestatic 761	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1230: aload 7
    //   1232: iload_2
    //   1233: invokestatic 764	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:a	(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;I)V
    //   1236: aload 7
    //   1238: iconst_1
    //   1239: putfield 767	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:vqU	Z
    //   1242: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1245: astore 6
    //   1247: ldc_w 769
    //   1250: iconst_2
    //   1251: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/b:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1257: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1260: astore 6
    //   1262: ldc_w 778
    //   1265: aload_1
    //   1266: getfield 526	com/tencent/mm/media/widget/camerarecordview/b/b:gBm	I
    //   1269: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1272: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/b:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1275: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1278: astore 6
    //   1280: ldc_w 780
    //   1283: invokestatic 785	java/lang/System:currentTimeMillis	()J
    //   1286: invokestatic 790	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1289: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/b:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1292: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1295: astore 6
    //   1297: ldc_w 792
    //   1300: invokestatic 785	java/lang/System:currentTimeMillis	()J
    //   1303: invokestatic 790	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1306: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/b:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1309: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1312: astore 6
    //   1314: invokestatic 139	com/tencent/mm/plugin/recordvideo/d/b:diy	()Lcom/tencent/mm/g/b/a/dc;
    //   1317: invokestatic 785	java/lang/System:currentTimeMillis	()J
    //   1320: invokevirtual 795	com/tencent/mm/g/b/a/dc:fl	(J)Lcom/tencent/mm/g/b/a/dc;
    //   1323: pop
    //   1324: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1327: astore 6
    //   1329: invokestatic 139	com/tencent/mm/plugin/recordvideo/d/b:diy	()Lcom/tencent/mm/g/b/a/dc;
    //   1332: astore 6
    //   1334: aload_1
    //   1335: getfield 252	com/tencent/mm/media/widget/camerarecordview/b/b:gBs	Ljava/util/ArrayList;
    //   1338: checkcast 797	java/util/Collection
    //   1341: astore 7
    //   1343: aload 7
    //   1345: ifnull +13 -> 1358
    //   1348: aload 7
    //   1350: invokeinterface 798 1 0
    //   1355: ifeq +497 -> 1852
    //   1358: iconst_1
    //   1359: istore_2
    //   1360: iload_2
    //   1361: ifne +496 -> 1857
    //   1364: lconst_1
    //   1365: lstore 4
    //   1367: aload 6
    //   1369: lload 4
    //   1371: invokevirtual 801	com/tencent/mm/g/b/a/dc:fw	(J)Lcom/tencent/mm/g/b/a/dc;
    //   1374: pop
    //   1375: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1378: astore 6
    //   1380: invokestatic 139	com/tencent/mm/plugin/recordvideo/d/b:diy	()Lcom/tencent/mm/g/b/a/dc;
    //   1383: aload_1
    //   1384: getfield 252	com/tencent/mm/media/widget/camerarecordview/b/b:gBs	Ljava/util/ArrayList;
    //   1387: invokevirtual 802	java/util/ArrayList:size	()I
    //   1390: i2l
    //   1391: invokevirtual 805	com/tencent/mm/g/b/a/dc:fx	(J)Lcom/tencent/mm/g/b/a/dc;
    //   1394: pop
    //   1395: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1398: astore 6
    //   1400: invokestatic 809	com/tencent/mm/plugin/recordvideo/d/b:diz	()Lcom/tencent/mm/g/b/a/dn;
    //   1403: astore 6
    //   1405: aload_1
    //   1406: getfield 252	com/tencent/mm/media/widget/camerarecordview/b/b:gBs	Ljava/util/ArrayList;
    //   1409: checkcast 797	java/util/Collection
    //   1412: astore 7
    //   1414: aload 7
    //   1416: ifnull +13 -> 1429
    //   1419: aload 7
    //   1421: invokeinterface 798 1 0
    //   1426: ifeq +439 -> 1865
    //   1429: iconst_1
    //   1430: istore_2
    //   1431: iload_2
    //   1432: ifne +438 -> 1870
    //   1435: lconst_1
    //   1436: lstore 4
    //   1438: aload 6
    //   1440: lload 4
    //   1442: invokevirtual 815	com/tencent/mm/g/b/a/dn:gy	(J)Lcom/tencent/mm/g/b/a/dn;
    //   1445: pop
    //   1446: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1449: astore 6
    //   1451: invokestatic 809	com/tencent/mm/plugin/recordvideo/d/b:diz	()Lcom/tencent/mm/g/b/a/dn;
    //   1454: aload_1
    //   1455: getfield 252	com/tencent/mm/media/widget/camerarecordview/b/b:gBs	Ljava/util/ArrayList;
    //   1458: invokevirtual 802	java/util/ArrayList:size	()I
    //   1461: i2l
    //   1462: invokevirtual 818	com/tencent/mm/g/b/a/dn:gz	(J)Lcom/tencent/mm/g/b/a/dn;
    //   1465: pop
    //   1466: aload_0
    //   1467: invokevirtual 246	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   1470: astore_1
    //   1471: aload_1
    //   1472: ifnonnull +6 -> 1478
    //   1475: invokestatic 344	d/g/b/k:fvU	()V
    //   1478: aload_1
    //   1479: getfield 821	com/tencent/mm/media/widget/camerarecordview/b/b:gBl	Z
    //   1482: ifne +35 -> 1517
    //   1485: aload_0
    //   1486: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   1489: astore_1
    //   1490: aload_1
    //   1491: ifnull +387 -> 1878
    //   1494: aload_1
    //   1495: getfield 397	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   1498: istore_2
    //   1499: iload_2
    //   1500: ifle +17 -> 1517
    //   1503: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1506: astore_1
    //   1507: ldc_w 823
    //   1510: iconst_0
    //   1511: invokestatic 772	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1514: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/b:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1517: ldc_w 295
    //   1520: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1523: return
    //   1524: aconst_null
    //   1525: astore 6
    //   1527: goto -1385 -> 142
    //   1530: iconst_0
    //   1531: istore_2
    //   1532: goto -1325 -> 207
    //   1535: aload 6
    //   1537: getfield 394	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1540: aload 6
    //   1542: getfield 391	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1545: if_icmple +8 -> 1553
    //   1548: iconst_1
    //   1549: istore_2
    //   1550: goto -1343 -> 207
    //   1553: iconst_0
    //   1554: istore_2
    //   1555: goto -1348 -> 207
    //   1558: aload 8
    //   1560: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1563: aload 8
    //   1565: invokevirtual 831	android/graphics/Bitmap:getHeight	()I
    //   1568: getstatic 837	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1571: invokestatic 841	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1574: astore 7
    //   1576: aload 8
    //   1578: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1581: aload 8
    //   1583: invokevirtual 831	android/graphics/Bitmap:getHeight	()I
    //   1586: imul
    //   1587: newarray int
    //   1589: astore 10
    //   1591: aload 8
    //   1593: aload 10
    //   1595: iconst_0
    //   1596: aload 8
    //   1598: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1601: iconst_0
    //   1602: iconst_0
    //   1603: aload 8
    //   1605: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1608: aload 8
    //   1610: invokevirtual 831	android/graphics/Bitmap:getHeight	()I
    //   1613: invokevirtual 845	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1616: aload 7
    //   1618: ldc_w 847
    //   1621: invokestatic 148	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1624: aload 7
    //   1626: aload 10
    //   1628: iconst_0
    //   1629: aload 7
    //   1631: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1634: iconst_0
    //   1635: iconst_0
    //   1636: aload 7
    //   1638: invokevirtual 828	android/graphics/Bitmap:getWidth	()I
    //   1641: aload 7
    //   1643: invokevirtual 831	android/graphics/Bitmap:getHeight	()I
    //   1646: invokevirtual 850	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   1649: goto -1384 -> 265
    //   1652: astore 8
    //   1654: aload 7
    //   1656: astore 6
    //   1658: aload 8
    //   1660: astore 7
    //   1662: ldc_w 451
    //   1665: aload 7
    //   1667: checkcast 852	java/lang/Throwable
    //   1670: ldc_w 854
    //   1673: iconst_0
    //   1674: anewarray 856	java/lang/Object
    //   1677: invokestatic 860	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1680: invokestatic 863	com/tencent/mm/sdk/platformtools/ad:getLogLevel	()I
    //   1683: ifle +21 -> 1704
    //   1686: aload 9
    //   1688: getfield 401	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   1691: ldc_w 865
    //   1694: checkcast 159	java/lang/CharSequence
    //   1697: iconst_0
    //   1698: invokestatic 871	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1701: invokevirtual 874	android/widget/Toast:show	()V
    //   1704: aload 9
    //   1706: aconst_null
    //   1707: putfield 427	com/tencent/mm/plugin/recordvideo/plugin/q:vkz	Landroid/graphics/Bitmap;
    //   1710: aload 6
    //   1712: ifnull -1409 -> 303
    //   1715: aload 6
    //   1717: invokevirtual 440	com/tencent/mm/ui/blur/e:destroy	()V
    //   1720: goto -1417 -> 303
    //   1723: astore_1
    //   1724: aconst_null
    //   1725: astore 6
    //   1727: aload 6
    //   1729: ifnull +8 -> 1737
    //   1732: aload 6
    //   1734: invokevirtual 440	com/tencent/mm/ui/blur/e:destroy	()V
    //   1737: ldc_w 295
    //   1740: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1743: aload_1
    //   1744: athrow
    //   1745: aload 9
    //   1747: aconst_null
    //   1748: putfield 427	com/tencent/mm/plugin/recordvideo/plugin/q:vkz	Landroid/graphics/Bitmap;
    //   1751: getstatic 135	com/tencent/mm/plugin/recordvideo/d/b:vpp	Lcom/tencent/mm/plugin/recordvideo/d/b;
    //   1754: astore 6
    //   1756: invokestatic 139	com/tencent/mm/plugin/recordvideo/d/b:diy	()Lcom/tencent/mm/g/b/a/dc;
    //   1759: lconst_1
    //   1760: invokevirtual 445	com/tencent/mm/g/b/a/dc:fy	(J)Lcom/tencent/mm/g/b/a/dc;
    //   1763: pop
    //   1764: goto -1446 -> 318
    //   1767: sipush 10000
    //   1770: istore_2
    //   1771: goto -1384 -> 387
    //   1774: aconst_null
    //   1775: astore 6
    //   1777: goto -1303 -> 474
    //   1780: iconst_0
    //   1781: istore_2
    //   1782: goto -1243 -> 539
    //   1785: aload 6
    //   1787: getfield 394	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1790: aload 6
    //   1792: getfield 391	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1795: if_icmple +8 -> 1803
    //   1798: iconst_1
    //   1799: istore_2
    //   1800: goto -1261 -> 539
    //   1803: iconst_0
    //   1804: istore_2
    //   1805: goto -1266 -> 539
    //   1808: aload 7
    //   1810: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1813: iconst_1
    //   1814: invokevirtual 878	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setForceScaleFullScreen	(Z)V
    //   1817: aload 7
    //   1819: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1822: getstatic 881	com/tencent/mm/pluginsdk/ui/h$e:BVt	Lcom/tencent/mm/pluginsdk/ui/h$e;
    //   1825: invokevirtual 509	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/h$e;)V
    //   1828: goto -1258 -> 570
    //   1831: aload 7
    //   1833: getfield 471	com/tencent/mm/plugin/recordvideo/plugin/s:tFN	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1836: aload 9
    //   1838: getfield 500	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:vhJ	Lcom/tencent/mm/pluginsdk/ui/h$e;
    //   1841: invokevirtual 509	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/h$e;)V
    //   1844: goto -1274 -> 570
    //   1847: iconst_0
    //   1848: istore_2
    //   1849: goto -991 -> 858
    //   1852: iconst_0
    //   1853: istore_2
    //   1854: goto -494 -> 1360
    //   1857: ldc2_w 441
    //   1860: lstore 4
    //   1862: goto -495 -> 1367
    //   1865: iconst_0
    //   1866: istore_2
    //   1867: goto -436 -> 1431
    //   1870: ldc2_w 441
    //   1873: lstore 4
    //   1875: goto -437 -> 1438
    //   1878: iconst_0
    //   1879: istore_2
    //   1880: goto -381 -> 1499
    //   1883: ldc_w 295
    //   1886: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1889: return
    //   1890: astore_1
    //   1891: goto -164 -> 1727
    //   1894: astore_1
    //   1895: goto -168 -> 1727
    //   1898: astore 7
    //   1900: goto -238 -> 1662
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1903	0	this	EditorVideoPluginLayoutNew
    //   0	1903	1	paramb	com.tencent.mm.media.widget.camerarecordview.b.b
    //   206	1674	2	i	int
    //   839	67	3	j	int
    //   83	1791	4	l	long
    //   34	1757	6	localObject1	Object
    //   109	1723	7	localObject2	Object
    //   1898	1	7	localException1	java.lang.Exception
    //   95	1514	8	localObject3	Object
    //   1652	7	8	localException2	java.lang.Exception
    //   89	1748	9	localObject4	Object
    //   824	803	10	localObject5	Object
    //   845	8	11	localVideoTransPara	com.tencent.mm.modelcontrol.VideoTransPara
    // Exception table:
    //   from	to	target	type
    //   223	237	1652	java/lang/Exception
    //   223	237	1723	finally
    //   237	257	1890	finally
    //   270	298	1890	finally
    //   1558	1649	1890	finally
    //   1662	1704	1894	finally
    //   1704	1710	1894	finally
    //   237	257	1898	java/lang/Exception
    //   270	298	1898	java/lang/Exception
    //   1558	1649	1898	java/lang/Exception
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(75774);
    k.h(paramc, "status");
    if (paramc != d.c.vob) {
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (c.ciE[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.vob) {
        ad.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75774);
      return;
    }
    paramc = getBgPlugin().diq();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    if (getMoreMenuPlugin().vjK) {}
    for (int i = 1;; i = 0)
    {
      paramBundle = CaptureDataManager.vhw;
      k.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putInt("key_extra_feature_flag", i);
      if (getMoreMenuPlugin().boX == 2)
      {
        paramBundle = CaptureDataManager.vhw;
        k.g(paramBundle, "CaptureDataManager.INSTANCE");
        paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().dik());
        paramc = new com.tencent.mm.plugin.recordvideo.b.f(getAddMusicPlugin().vmE.getMuteOrigin(), getAddMusicPlugin().vgH, com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin()), getItemContainerPlugin().did(), getItemContainerPlugin().die(), getPreviewPlugin().cUL, getPreviewPlugin().gBm, new ArrayList(), paramc);
        ad.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
        getReMuxPlugin().a(paramc);
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dig()));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dih()));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        if (getAddMusicPlugin().vgH != null) {
          break label544;
        }
        i = 0;
        label370:
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        if (!getAddMusicPlugin().vmE.getMuteOrigin()) {
          break label549;
        }
      }
      label544:
      label549:
      for (i = 0;; i = 1)
      {
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
        diu();
        div();
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.Kp(13);
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        com.tencent.mm.plugin.recordvideo.d.b.diy().fm(System.currentTimeMillis());
        paramc = com.tencent.mm.plugin.recordvideo.d.b.vpp;
        paramc = getConfigProvider();
        i = j;
        if (paramc != null) {
          i = paramc.scene;
        }
        com.tencent.mm.plugin.recordvideo.d.b.Kq(i);
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.vjb;
        paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.dhW();
        if (paramc == null) {
          break label554;
        }
        paramc.dhT();
        AppMethodBeat.o(75774);
        return;
        if (getMoreMenuPlugin().boX != 3) {
          break;
        }
        paramBundle = CaptureDataManager.vhw;
        k.g(paramBundle, "CaptureDataManager.INSTANCE");
        paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().dik());
        break;
        i = 1;
        break label370;
      }
      label554:
      AppMethodBeat.o(75774);
      return;
    }
  }
  
  public final boolean dia()
  {
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.dia())
    {
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.v("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().vjE.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.media.editor.a.h)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.c))
        {
          i += 1;
        }
        else if ((localObject2 instanceof g))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diz().Rj();
        }
        else if ((!(localObject2 instanceof e)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.h)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
          com.tencent.mm.plugin.recordvideo.d.b.diz().Rl();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.diz();
      if (!getMoreMenuPlugin().vjK) {
        break label295;
      }
    }
    label295:
    for (long l = 1L;; l = 0L)
    {
      ((dn)localObject1).gx(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diz().gt(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.b.vpp;
      com.tencent.mm.plugin.recordvideo.d.b.diz().gu(j);
      localObject1 = getCaptureInfo();
      if ((localObject1 != null) && (((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBl == true)) {
        com.tencent.e.h.Iye.aP((Runnable)new b(this));
      }
      getPreviewPlugin().reset();
      localObject1 = getNavigator();
      if (localObject1 != null) {
        a.a.a((com.tencent.mm.plugin.recordvideo.activity.a)localObject1);
      }
      AppMethodBeat.o(75775);
      return true;
    }
  }
  
  public View getPlayerView()
  {
    AppMethodBeat.i(75772);
    Object localObject = new EditorVideoPlayView(getContext());
    ad.i("MicroMsg.EditorVideoPluginLayoutNew", "playerView :".concat(String.valueOf(localObject)));
    setPreviewPlugin(new s((VideoPlayerTextureView)localObject, (d)this, (TextView)findViewById(2131306323)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(169939);
      Object localObject1 = this.vnq.getCaptureInfo();
      if (localObject1 != null) {}
      for (localObject1 = ((com.tencent.mm.media.widget.camerarecordview.b.b)localObject1).gBn;; localObject1 = null)
      {
        com.tencent.mm.vfs.i.deleteFile((String)localObject1);
        com.tencent.mm.media.widget.camerarecordview.b.b localb = this.vnq.getCaptureInfo();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.gBj;
        }
        com.tencent.mm.vfs.i.deleteFile((String)localObject1);
        AppMethodBeat.o(169939);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */