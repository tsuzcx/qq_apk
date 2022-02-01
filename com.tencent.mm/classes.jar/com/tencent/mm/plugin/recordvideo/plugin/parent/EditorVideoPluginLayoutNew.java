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
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.g;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final EditorVideoPluginLayoutNew.a xDT;
  
  static
  {
    AppMethodBeat.i(75779);
    xDT = new EditorVideoPluginLayoutNew.a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private final void dGG()
  {
    AppMethodBeat.i(75776);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).xNC;
      switch (c.gnp[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).dHT();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75776);
          throw ((Throwable)localObject1);
        }
        localObject2 = (bvs)localObject2;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.dGL();
        String str1 = ((bvs)localObject2).xOD;
        d.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((bvs)localObject2).jDf;
        d.g.b.p.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.h(str1, ",", " ", true));
        }
        if (!TextUtils.isEmpty((CharSequence)str2)) {
          if (((CharSequence)localStringBuilder).length() <= 0) {
            break label348;
          }
        }
        for (int k = 1;; k = 0)
        {
          if (k != 0) {
            localStringBuilder.append("|");
          }
          localStringBuilder.append(n.h(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          d.g.b.p.g(str1, "reportPositionString.toString()");
          ((fp)localObject3).oA(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.dGL().oB(String.valueOf(((bvs)localObject2).dyz));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.dGL().oC(String.valueOf(((bvs)localObject2).dAp));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.dGL().Tq();
        break;
      case 5: 
        label348:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
        com.tencent.mm.plugin.recordvideo.d.c.dGL().Tr();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGL().ko(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    com.tencent.mm.plugin.recordvideo.d.c.dGL().kp(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dGL();
    if (getMoreMenuPlugin().xAo) {}
    for (long l = 1L;; l = 0L)
    {
      ((fp)localObject1).ku(l);
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void dGH()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).htW;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGL().oE(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75777);
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: ldc_w 302
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 304
    //   9: ldc_w 306
    //   12: aload_1
    //   13: invokestatic 309	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 318	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 320	com/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;)V
    //   27: aload_1
    //   28: ifnull +1855 -> 1883
    //   31: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:xRh	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   34: astore 6
    //   36: iconst_0
    //   37: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:NV	(I)V
    //   40: aload_1
    //   41: invokevirtual 332	com/tencent/mm/media/widget/camerarecordview/b/b:axC	()Z
    //   44: ifeq +16 -> 60
    //   47: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:xRh	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   50: astore 6
    //   52: invokestatic 335	com/tencent/mm/plugin/recordvideo/e/a:dIr	()I
    //   55: iconst_1
    //   56: iadd
    //   57: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:NV	(I)V
    //   60: aload_1
    //   61: invokevirtual 338	com/tencent/mm/media/widget/camerarecordview/b/b:axB	()Z
    //   64: ifeq +16 -> 80
    //   67: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:xRh	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   70: astore 6
    //   72: invokestatic 335	com/tencent/mm/plugin/recordvideo/e/a:dIr	()I
    //   75: iconst_1
    //   76: iadd
    //   77: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:NV	(I)V
    //   80: invokestatic 344	com/tencent/mm/sdk/platformtools/bt:HI	()J
    //   83: lstore 4
    //   85: aload_0
    //   86: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getBgPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/q;
    //   89: astore 9
    //   91: aload_0
    //   92: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   95: astore 8
    //   97: aload 8
    //   99: ifnonnull +6 -> 105
    //   102: invokestatic 351	d/g/b/p:gfZ	()V
    //   105: aload_0
    //   106: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   109: astore 7
    //   111: aload 8
    //   113: ldc_w 356
    //   116: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   119: aload 9
    //   121: getfield 361	com/tencent/mm/plugin/recordvideo/plugin/q:TAG	Ljava/lang/String;
    //   124: ldc_w 363
    //   127: invokestatic 318	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 7
    //   132: ifnull +1392 -> 1524
    //   135: aload 7
    //   137: getfield 369	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyn	Ljava/lang/Boolean;
    //   140: astore 6
    //   142: aload 6
    //   144: getstatic 374	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   147: invokestatic 377	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   150: ifeq +168 -> 318
    //   153: getstatic 383	com/tencent/mm/plugin/recordvideo/e/c:xRv	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   156: astore 6
    //   158: aload 8
    //   160: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axD	()Ljava/lang/String;
    //   163: invokestatic 390	com/tencent/mm/plugin/recordvideo/e/c:awc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   166: astore 6
    //   168: aload 6
    //   170: ifnull +148 -> 318
    //   173: aload 6
    //   175: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dGc	I
    //   178: ifeq +14 -> 192
    //   181: aload 6
    //   183: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dGc	I
    //   186: sipush 180
    //   189: if_icmpne +1346 -> 1535
    //   192: aload 6
    //   194: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   197: aload 6
    //   199: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   202: if_icmple +1328 -> 1530
    //   205: iconst_1
    //   206: istore_2
    //   207: iload_2
    //   208: ifeq +1537 -> 1745
    //   211: aload 7
    //   213: getfield 404	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   216: iconst_3
    //   217: if_icmpne +1528 -> 1745
    //   220: aconst_null
    //   221: astore 7
    //   223: new 406	com/tencent/mm/ui/blur/e
    //   226: dup
    //   227: aload 9
    //   229: getfield 408	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   232: invokespecial 411	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   235: astore 6
    //   237: aload 8
    //   239: getfield 414	com/tencent/mm/media/widget/camerarecordview/b/b:htN	Ljava/lang/String;
    //   242: aload 8
    //   244: getfield 417	com/tencent/mm/media/widget/camerarecordview/b/b:ddx	I
    //   247: i2l
    //   248: ldc2_w 418
    //   251: lmul
    //   252: invokestatic 425	com/tencent/mm/plugin/mmsight/d:aY	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
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
    //   276: ldc_w 426
    //   279: invokevirtual 430	com/tencent/mm/ui/blur/e:d	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   282: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xBb	Landroid/graphics/Bitmap;
    //   285: aload 9
    //   287: getfield 438	com/tencent/mm/plugin/recordvideo/plugin/q:xBc	Landroid/widget/ImageView;
    //   290: aload 9
    //   292: getfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xBb	Landroid/graphics/Bitmap;
    //   295: invokevirtual 444	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   298: aload 6
    //   300: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   303: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   306: astore 6
    //   308: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dGL	()Lcom/tencent/mm/g/b/a/fp;
    //   311: ldc2_w 448
    //   314: invokevirtual 452	com/tencent/mm/g/b/a/fp:kx	(J)Lcom/tencent/mm/g/b/a/fp;
    //   317: pop
    //   318: aload_0
    //   319: invokevirtual 456	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getPreviewPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/s;
    //   322: astore 7
    //   324: aload_0
    //   325: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   328: astore 8
    //   330: aload 8
    //   332: ifnonnull +6 -> 338
    //   335: invokestatic 351	d/g/b/p:gfZ	()V
    //   338: aload_0
    //   339: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   342: astore 9
    //   344: aload 8
    //   346: ldc_w 356
    //   349: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   352: ldc_w 458
    //   355: ldc_w 460
    //   358: aload 8
    //   360: invokestatic 309	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   363: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   366: invokestatic 318	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: aload 7
    //   371: aload 8
    //   373: putfield 466	com/tencent/mm/plugin/recordvideo/plugin/s:xAw	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   376: aload 9
    //   378: ifnull +1389 -> 1767
    //   381: aload 9
    //   383: getfield 469	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyt	I
    //   386: istore_2
    //   387: aload 7
    //   389: iload_2
    //   390: putfield 472	com/tencent/mm/plugin/recordvideo/plugin/s:xBj	I
    //   393: aload 7
    //   395: new 474	com/tencent/mm/compatible/util/b
    //   398: dup
    //   399: aload 7
    //   401: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   404: invokevirtual 484	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:getContext	()Landroid/content/Context;
    //   407: invokespecial 485	com/tencent/mm/compatible/util/b:<init>	(Landroid/content/Context;)V
    //   410: putfield 489	com/tencent/mm/plugin/recordvideo/plugin/s:ixy	Lcom/tencent/mm/compatible/util/b;
    //   413: aload 7
    //   415: getfield 489	com/tencent/mm/plugin/recordvideo/plugin/s:ixy	Lcom/tencent/mm/compatible/util/b;
    //   418: astore 6
    //   420: aload 6
    //   422: ifnull +9 -> 431
    //   425: aload 6
    //   427: invokevirtual 492	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   430: pop
    //   431: aload 7
    //   433: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   436: iconst_0
    //   437: invokevirtual 495	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVisibility	(I)V
    //   440: aload 7
    //   442: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   445: fconst_0
    //   446: invokevirtual 499	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setAlpha	(F)V
    //   449: aload 7
    //   451: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   454: aload 8
    //   456: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axD	()Ljava/lang/String;
    //   459: invokevirtual 502	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoPath	(Ljava/lang/String;)V
    //   462: aload 9
    //   464: ifnull +1310 -> 1774
    //   467: aload 9
    //   469: getfield 369	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyn	Ljava/lang/Boolean;
    //   472: astore 6
    //   474: aload 6
    //   476: getstatic 374	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   479: invokestatic 377	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   482: ifeq +94 -> 576
    //   485: getstatic 383	com/tencent/mm/plugin/recordvideo/e/c:xRv	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   488: astore 6
    //   490: aload 8
    //   492: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axD	()Ljava/lang/String;
    //   495: invokestatic 390	com/tencent/mm/plugin/recordvideo/e/c:awc	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   498: astore 6
    //   500: aload 6
    //   502: ifnull +74 -> 576
    //   505: aload 6
    //   507: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dGc	I
    //   510: ifeq +14 -> 524
    //   513: aload 6
    //   515: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dGc	I
    //   518: sipush 180
    //   521: if_icmpne +1264 -> 1785
    //   524: aload 6
    //   526: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   529: aload 6
    //   531: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   534: if_icmple +1246 -> 1780
    //   537: iconst_1
    //   538: istore_2
    //   539: aload 9
    //   541: ifnull +14 -> 555
    //   544: aload 9
    //   546: getfield 506	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyl	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   549: getstatic 511	com/tencent/mm/pluginsdk/ui/i$e:ESM	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   552: if_acmpne +1279 -> 1831
    //   555: iload_2
    //   556: ifeq +1252 -> 1808
    //   559: aload 7
    //   561: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   564: getstatic 511	com/tencent/mm/pluginsdk/ui/i$e:ESM	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   567: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   570: aload 7
    //   572: iconst_1
    //   573: putfield 518	com/tencent/mm/plugin/recordvideo/plugin/s:xBl	Z
    //   576: aload 7
    //   578: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   581: aload 7
    //   583: getfield 522	com/tencent/mm/plugin/recordvideo/plugin/s:xBo	Lcom/tencent/mm/plugin/recordvideo/plugin/s$d;
    //   586: checkcast 524	com/tencent/mm/pluginsdk/ui/tools/h$a
    //   589: invokevirtual 528	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoCallback	(Lcom/tencent/mm/pluginsdk/ui/tools/h$a;)V
    //   592: aload 7
    //   594: aload 8
    //   596: getfield 417	com/tencent/mm/media/widget/camerarecordview/b/b:ddx	I
    //   599: putfield 529	com/tencent/mm/plugin/recordvideo/plugin/s:ddx	I
    //   602: aload 7
    //   604: aload 8
    //   606: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:htQ	I
    //   609: putfield 533	com/tencent/mm/plugin/recordvideo/plugin/s:htQ	I
    //   612: aload 7
    //   614: getfield 537	com/tencent/mm/plugin/recordvideo/plugin/s:xBp	Landroid/widget/TextView;
    //   617: astore 6
    //   619: aload 6
    //   621: ifnull +10 -> 631
    //   624: aload 6
    //   626: bipush 8
    //   628: invokevirtual 540	android/widget/TextView:setVisibility	(I)V
    //   631: aload 7
    //   633: getfield 537	com/tencent/mm/plugin/recordvideo/plugin/s:xBp	Landroid/widget/TextView;
    //   636: astore 6
    //   638: aload 6
    //   640: ifnull +26 -> 666
    //   643: invokestatic 545	com/tencent/mm/sdk/platformtools/bu:flY	()Z
    //   646: ifeq +20 -> 666
    //   649: new 547	com/tencent/mm/plugin/recordvideo/plugin/s$c
    //   652: dup
    //   653: aload 6
    //   655: aload 7
    //   657: invokespecial 550	com/tencent/mm/plugin/recordvideo/plugin/s$c:<init>	(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/s;)V
    //   660: checkcast 552	java/lang/Runnable
    //   663: invokestatic 558	com/tencent/mm/plugin/mmsight/model/j:af	(Ljava/lang/Runnable;)V
    //   666: ldc_w 304
    //   669: new 161	java/lang/StringBuilder
    //   672: dup
    //   673: ldc_w 560
    //   676: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   679: lload 4
    //   681: invokestatic 565	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   684: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   687: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 570	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   693: aload_0
    //   694: invokevirtual 574	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getReMuxPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/ab;
    //   697: astore 6
    //   699: aload_0
    //   700: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   703: astore 7
    //   705: aload 7
    //   707: ifnonnull +6 -> 713
    //   710: invokestatic 351	d/g/b/p:gfZ	()V
    //   713: aload 6
    //   715: aload_1
    //   716: aload 7
    //   718: invokevirtual 579	com/tencent/mm/plugin/recordvideo/plugin/ab:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   721: ldc_w 304
    //   724: new 161	java/lang/StringBuilder
    //   727: dup
    //   728: ldc_w 581
    //   731: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   734: lload 4
    //   736: invokestatic 565	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   739: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   742: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 570	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 585	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCropVideoPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/a;
    //   752: astore 6
    //   754: aload_0
    //   755: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   758: astore 7
    //   760: aload 7
    //   762: ifnonnull +6 -> 768
    //   765: invokestatic 351	d/g/b/p:gfZ	()V
    //   768: aload_0
    //   769: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   772: astore 8
    //   774: aload 8
    //   776: ifnonnull +6 -> 782
    //   779: invokestatic 351	d/g/b/p:gfZ	()V
    //   782: aload 7
    //   784: ldc_w 356
    //   787: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   790: aload 8
    //   792: ldc_w 587
    //   795: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   798: aload 6
    //   800: aload 7
    //   802: putfield 592	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:xCw	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   805: aload 6
    //   807: aload 8
    //   809: putfield 596	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:sNI	Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   812: aload 6
    //   814: getfield 600	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:xCs	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;
    //   817: astore 9
    //   819: aload 7
    //   821: getfield 414	com/tencent/mm/media/widget/camerarecordview/b/b:htN	Ljava/lang/String;
    //   824: astore 10
    //   826: aload 8
    //   828: getfield 469	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyt	I
    //   831: aload 7
    //   833: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:htQ	I
    //   836: invokestatic 604	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:hk	(II)I
    //   839: istore_3
    //   840: aload 8
    //   842: getfield 608	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyj	Lcom/tencent/mm/modelcontrol/VideoTransPara;
    //   845: astore 11
    //   847: aload 11
    //   849: ifnull +998 -> 1847
    //   852: aload 11
    //   854: getfield 613	com/tencent/mm/modelcontrol/VideoTransPara:minDuration	I
    //   857: istore_2
    //   858: aload 10
    //   860: ldc_w 615
    //   863: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   866: aload 9
    //   868: getfield 620	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:hasInit	Z
    //   871: ifne +68 -> 939
    //   874: aload 9
    //   876: iconst_1
    //   877: putfield 620	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:hasInit	Z
    //   880: aload 9
    //   882: getfield 624	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:vXu	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   885: aload 10
    //   887: invokevirtual 629	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:aqQ	(Ljava/lang/String;)V
    //   890: new 610	com/tencent/mm/modelcontrol/VideoTransPara
    //   893: dup
    //   894: invokespecial 630	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   897: astore 10
    //   899: aload 10
    //   901: iload_3
    //   902: sipush 1000
    //   905: idiv
    //   906: putfield 633	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   909: aload 10
    //   911: iload_2
    //   912: putfield 613	com/tencent/mm/modelcontrol/VideoTransPara:minDuration	I
    //   915: aload 9
    //   917: getfield 624	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:vXu	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   920: aload 10
    //   922: invokevirtual 637	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:setVideoTransPara	(Lcom/tencent/mm/modelcontrol/VideoTransPara;)V
    //   925: aload 9
    //   927: getfield 624	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:vXu	Lcom/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar;
    //   930: getstatic 643	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$b:xCE	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView$b;
    //   933: checkcast 645	com/tencent/mm/plugin/mmsight/segment/c$a
    //   936: invokevirtual 649	com/tencent/mm/plugin/mmsight/segment/RecyclerThumbSeekBar:setOnPreparedListener	(Lcom/tencent/mm/plugin/mmsight/segment/c$a;)V
    //   939: aload 6
    //   941: getfield 600	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:xCs	Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView;
    //   944: aload 6
    //   946: checkcast 651	com/tencent/mm/plugin/mmsight/segment/c$b
    //   949: invokevirtual 655	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditVideoSeekBarView:setThumbBarSeekListener	(Lcom/tencent/mm/plugin/mmsight/segment/c$b;)V
    //   952: aload 6
    //   954: aload 8
    //   956: getfield 469	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyt	I
    //   959: aload 7
    //   961: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:htQ	I
    //   964: invokestatic 604	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:hk	(II)I
    //   967: i2f
    //   968: fconst_1
    //   969: fmul
    //   970: aload 7
    //   972: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:htQ	I
    //   975: i2f
    //   976: fdiv
    //   977: putfield 658	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:xCz	F
    //   980: ldc_w 304
    //   983: new 161	java/lang/StringBuilder
    //   986: dup
    //   987: ldc_w 660
    //   990: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   993: lload 4
    //   995: invokestatic 565	com/tencent/mm/sdk/platformtools/bt:aO	(J)J
    //   998: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 570	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_1
    //   1008: getfield 663	com/tencent/mm/media/widget/camerarecordview/b/b:htZ	Landroid/os/Bundle;
    //   1011: ifnull +231 -> 1242
    //   1014: aload_1
    //   1015: getfield 663	com/tencent/mm/media/widget/camerarecordview/b/b:htZ	Landroid/os/Bundle;
    //   1018: astore 6
    //   1020: aload 6
    //   1022: ifnonnull +6 -> 1028
    //   1025: invokestatic 351	d/g/b/p:gfZ	()V
    //   1028: getstatic 669	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:xzp	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   1031: astore 7
    //   1033: aload 6
    //   1035: invokestatic 672	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:dFQ	()Ljava/lang/String;
    //   1038: invokevirtual 678	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1041: astore 6
    //   1043: aload_1
    //   1044: getfield 663	com/tencent/mm/media/widget/camerarecordview/b/b:htZ	Landroid/os/Bundle;
    //   1047: astore 7
    //   1049: aload 7
    //   1051: ifnonnull +6 -> 1057
    //   1054: invokestatic 351	d/g/b/p:gfZ	()V
    //   1057: getstatic 669	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:xzp	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   1060: astore 8
    //   1062: aload 7
    //   1064: invokestatic 681	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:dFP	()Ljava/lang/String;
    //   1067: iconst_0
    //   1068: invokevirtual 685	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   1071: istore_2
    //   1072: aload 6
    //   1074: ifnull +168 -> 1242
    //   1077: aload 6
    //   1079: invokevirtual 689	java/util/ArrayList:isEmpty	()Z
    //   1082: ifne +160 -> 1242
    //   1085: aload_0
    //   1086: invokevirtual 693	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getAddMusicPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/a/a;
    //   1089: astore 7
    //   1091: aload 6
    //   1093: ldc_w 695
    //   1096: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1099: aload 7
    //   1101: getfield 701	com/tencent/mm/plugin/recordvideo/plugin/a/a:xDi	Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;
    //   1104: astore 7
    //   1106: aload 6
    //   1108: checkcast 703	java/util/List
    //   1111: astore 6
    //   1113: aload 6
    //   1115: ldc_w 695
    //   1118: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1121: aload 7
    //   1123: getfield 709	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:xLh	Lcom/tencent/mm/plugin/recordvideo/ui/a/a;
    //   1126: aload 6
    //   1128: invokevirtual 715	com/tencent/mm/plugin/recordvideo/ui/a/a:ff	(Ljava/util/List;)V
    //   1131: aload 6
    //   1133: invokeinterface 718 1 0
    //   1138: iload_2
    //   1139: if_icmple +97 -> 1236
    //   1142: aload 7
    //   1144: getfield 722	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:xKp	Landroid/support/v7/widget/RecyclerView;
    //   1147: astore 6
    //   1149: iload_2
    //   1150: new 724	com/tencent/mm/hellhoundlib/b/a
    //   1153: dup
    //   1154: invokespecial 725	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   1157: invokestatic 730	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   1160: astore 8
    //   1162: aload 6
    //   1164: aload 8
    //   1166: invokevirtual 734	com/tencent/mm/hellhoundlib/b/a:ahp	()[Ljava/lang/Object;
    //   1169: ldc_w 735
    //   1172: ldc_w 737
    //   1175: ldc_w 739
    //   1178: ldc_w 741
    //   1181: ldc_w 743
    //   1184: ldc_w 744
    //   1187: invokestatic 749	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1190: aload 6
    //   1192: aload 8
    //   1194: iconst_0
    //   1195: invokevirtual 753	com/tencent/mm/hellhoundlib/b/a:mq	(I)Ljava/lang/Object;
    //   1198: checkcast 755	java/lang/Integer
    //   1201: invokevirtual 758	java/lang/Integer:intValue	()I
    //   1204: invokevirtual 763	android/support/v7/widget/RecyclerView:ca	(I)V
    //   1207: aload 6
    //   1209: ldc_w 735
    //   1212: ldc_w 737
    //   1215: ldc_w 739
    //   1218: ldc_w 741
    //   1221: ldc_w 743
    //   1224: ldc_w 744
    //   1227: invokestatic 766	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1230: aload 7
    //   1232: iload_2
    //   1233: invokestatic 769	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:a	(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;I)V
    //   1236: aload 7
    //   1238: iconst_1
    //   1239: putfield 772	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:xLk	Z
    //   1242: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1245: astore 6
    //   1247: ldc_w 774
    //   1250: iconst_2
    //   1251: invokestatic 777	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: invokestatic 781	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1257: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1260: astore 6
    //   1262: ldc_w 783
    //   1265: aload_1
    //   1266: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:htQ	I
    //   1269: invokestatic 777	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1272: invokestatic 781	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1275: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1278: astore 6
    //   1280: ldc_w 785
    //   1283: invokestatic 790	java/lang/System:currentTimeMillis	()J
    //   1286: invokestatic 795	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1289: invokestatic 781	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1292: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1295: astore 6
    //   1297: ldc_w 797
    //   1300: invokestatic 790	java/lang/System:currentTimeMillis	()J
    //   1303: invokestatic 795	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1306: invokestatic 781	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1309: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1312: astore 6
    //   1314: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dGL	()Lcom/tencent/mm/g/b/a/fp;
    //   1317: invokestatic 790	java/lang/System:currentTimeMillis	()J
    //   1320: invokevirtual 800	com/tencent/mm/g/b/a/fp:kk	(J)Lcom/tencent/mm/g/b/a/fp;
    //   1323: pop
    //   1324: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1327: astore 6
    //   1329: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dGL	()Lcom/tencent/mm/g/b/a/fp;
    //   1332: astore 6
    //   1334: aload_1
    //   1335: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:htW	Ljava/util/ArrayList;
    //   1338: checkcast 802	java/util/Collection
    //   1341: astore 7
    //   1343: aload 7
    //   1345: ifnull +13 -> 1358
    //   1348: aload 7
    //   1350: invokeinterface 803 1 0
    //   1355: ifeq +497 -> 1852
    //   1358: iconst_1
    //   1359: istore_2
    //   1360: iload_2
    //   1361: ifne +496 -> 1857
    //   1364: lconst_1
    //   1365: lstore 4
    //   1367: aload 6
    //   1369: lload 4
    //   1371: invokevirtual 806	com/tencent/mm/g/b/a/fp:kv	(J)Lcom/tencent/mm/g/b/a/fp;
    //   1374: pop
    //   1375: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1378: astore 6
    //   1380: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dGL	()Lcom/tencent/mm/g/b/a/fp;
    //   1383: aload_1
    //   1384: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:htW	Ljava/util/ArrayList;
    //   1387: invokevirtual 807	java/util/ArrayList:size	()I
    //   1390: i2l
    //   1391: invokevirtual 810	com/tencent/mm/g/b/a/fp:kw	(J)Lcom/tencent/mm/g/b/a/fp;
    //   1394: pop
    //   1395: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1398: astore 6
    //   1400: invokestatic 814	com/tencent/mm/plugin/recordvideo/d/c:dGM	()Lcom/tencent/mm/g/b/a/ga;
    //   1403: astore 6
    //   1405: aload_1
    //   1406: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:htW	Ljava/util/ArrayList;
    //   1409: checkcast 802	java/util/Collection
    //   1412: astore 7
    //   1414: aload 7
    //   1416: ifnull +13 -> 1429
    //   1419: aload 7
    //   1421: invokeinterface 803 1 0
    //   1426: ifeq +439 -> 1865
    //   1429: iconst_1
    //   1430: istore_2
    //   1431: iload_2
    //   1432: ifne +438 -> 1870
    //   1435: lconst_1
    //   1436: lstore 4
    //   1438: aload 6
    //   1440: lload 4
    //   1442: invokevirtual 820	com/tencent/mm/g/b/a/ga:lx	(J)Lcom/tencent/mm/g/b/a/ga;
    //   1445: pop
    //   1446: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1449: astore 6
    //   1451: invokestatic 814	com/tencent/mm/plugin/recordvideo/d/c:dGM	()Lcom/tencent/mm/g/b/a/ga;
    //   1454: aload_1
    //   1455: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:htW	Ljava/util/ArrayList;
    //   1458: invokevirtual 807	java/util/ArrayList:size	()I
    //   1461: i2l
    //   1462: invokevirtual 823	com/tencent/mm/g/b/a/ga:ly	(J)Lcom/tencent/mm/g/b/a/ga;
    //   1465: pop
    //   1466: aload_0
    //   1467: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   1470: astore_1
    //   1471: aload_1
    //   1472: ifnonnull +6 -> 1478
    //   1475: invokestatic 351	d/g/b/p:gfZ	()V
    //   1478: aload_1
    //   1479: getfield 826	com/tencent/mm/media/widget/camerarecordview/b/b:htP	Z
    //   1482: ifne +35 -> 1517
    //   1485: aload_0
    //   1486: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   1489: astore_1
    //   1490: aload_1
    //   1491: ifnull +387 -> 1878
    //   1494: aload_1
    //   1495: getfield 404	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   1498: istore_2
    //   1499: iload_2
    //   1500: ifle +17 -> 1517
    //   1503: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1506: astore_1
    //   1507: ldc_w 828
    //   1510: iconst_0
    //   1511: invokestatic 777	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1514: invokestatic 781	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1517: ldc_w 302
    //   1520: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1523: return
    //   1524: aconst_null
    //   1525: astore 6
    //   1527: goto -1385 -> 142
    //   1530: iconst_0
    //   1531: istore_2
    //   1532: goto -1325 -> 207
    //   1535: aload 6
    //   1537: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1540: aload 6
    //   1542: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1545: if_icmple +8 -> 1553
    //   1548: iconst_1
    //   1549: istore_2
    //   1550: goto -1343 -> 207
    //   1553: iconst_0
    //   1554: istore_2
    //   1555: goto -1348 -> 207
    //   1558: aload 8
    //   1560: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1563: aload 8
    //   1565: invokevirtual 836	android/graphics/Bitmap:getHeight	()I
    //   1568: getstatic 842	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1571: invokestatic 846	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1574: astore 7
    //   1576: aload 8
    //   1578: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1581: aload 8
    //   1583: invokevirtual 836	android/graphics/Bitmap:getHeight	()I
    //   1586: imul
    //   1587: newarray int
    //   1589: astore 10
    //   1591: aload 8
    //   1593: aload 10
    //   1595: iconst_0
    //   1596: aload 8
    //   1598: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1601: iconst_0
    //   1602: iconst_0
    //   1603: aload 8
    //   1605: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1608: aload 8
    //   1610: invokevirtual 836	android/graphics/Bitmap:getHeight	()I
    //   1613: invokevirtual 850	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1616: aload 7
    //   1618: ldc_w 852
    //   1621: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1624: aload 7
    //   1626: aload 10
    //   1628: iconst_0
    //   1629: aload 7
    //   1631: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1634: iconst_0
    //   1635: iconst_0
    //   1636: aload 7
    //   1638: invokevirtual 833	android/graphics/Bitmap:getWidth	()I
    //   1641: aload 7
    //   1643: invokevirtual 836	android/graphics/Bitmap:getHeight	()I
    //   1646: invokevirtual 855	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   1649: goto -1384 -> 265
    //   1652: astore 8
    //   1654: aload 7
    //   1656: astore 6
    //   1658: aload 8
    //   1660: astore 7
    //   1662: ldc_w 458
    //   1665: aload 7
    //   1667: checkcast 857	java/lang/Throwable
    //   1670: ldc_w 859
    //   1673: iconst_0
    //   1674: anewarray 861	java/lang/Object
    //   1677: invokestatic 865	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1680: invokestatic 868	com/tencent/mm/sdk/platformtools/ad:getLogLevel	()I
    //   1683: ifle +21 -> 1704
    //   1686: aload 9
    //   1688: getfield 408	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   1691: ldc_w 870
    //   1694: checkcast 165	java/lang/CharSequence
    //   1697: iconst_0
    //   1698: invokestatic 876	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1701: invokevirtual 879	android/widget/Toast:show	()V
    //   1704: aload 9
    //   1706: aconst_null
    //   1707: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xBb	Landroid/graphics/Bitmap;
    //   1710: aload 6
    //   1712: ifnull -1409 -> 303
    //   1715: aload 6
    //   1717: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   1720: goto -1417 -> 303
    //   1723: astore_1
    //   1724: aconst_null
    //   1725: astore 6
    //   1727: aload 6
    //   1729: ifnull +8 -> 1737
    //   1732: aload 6
    //   1734: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   1737: ldc_w 302
    //   1740: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1743: aload_1
    //   1744: athrow
    //   1745: aload 9
    //   1747: aconst_null
    //   1748: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xBb	Landroid/graphics/Bitmap;
    //   1751: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xHa	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1754: astore 6
    //   1756: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dGL	()Lcom/tencent/mm/g/b/a/fp;
    //   1759: lconst_1
    //   1760: invokevirtual 452	com/tencent/mm/g/b/a/fp:kx	(J)Lcom/tencent/mm/g/b/a/fp;
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
    //   1787: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1790: aload 6
    //   1792: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1795: if_icmple +8 -> 1803
    //   1798: iconst_1
    //   1799: istore_2
    //   1800: goto -1261 -> 539
    //   1803: iconst_0
    //   1804: istore_2
    //   1805: goto -1266 -> 539
    //   1808: aload 7
    //   1810: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1813: iconst_1
    //   1814: invokevirtual 883	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setForceScaleFullScreen	(Z)V
    //   1817: aload 7
    //   1819: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1822: getstatic 886	com/tencent/mm/pluginsdk/ui/i$e:ESP	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1825: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1828: goto -1258 -> 570
    //   1831: aload 7
    //   1833: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:vRr	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1836: aload 9
    //   1838: getfield 506	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xyl	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1841: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1844: goto -1274 -> 570
    //   1847: iconst_0
    //   1848: istore_2
    //   1849: goto -991 -> 858
    //   1852: iconst_0
    //   1853: istore_2
    //   1854: goto -494 -> 1360
    //   1857: ldc2_w 448
    //   1860: lstore 4
    //   1862: goto -495 -> 1367
    //   1865: iconst_0
    //   1866: istore_2
    //   1867: goto -436 -> 1431
    //   1870: ldc2_w 448
    //   1873: lstore 4
    //   1875: goto -437 -> 1438
    //   1878: iconst_0
    //   1879: istore_2
    //   1880: goto -381 -> 1499
    //   1883: ldc_w 302
    //   1886: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	1903	1	paramb	b
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
    AppMethodBeat.i(75774);
    d.g.b.p.h(paramc, "status");
    if (paramc != d.c.xER) {
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (c.cpQ[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.xER) {
        ad.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75774);
      return;
    }
    paramc = getBgPlugin().dGy();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().xAo) {
      i = 1;
    }
    paramBundle = CaptureDataManager.xxY;
    d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bxN == 2)
    {
      paramBundle = CaptureDataManager.xxY;
      d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().dGs());
      boolean bool = getAddMusicPlugin().xDi.getMuteOrigin();
      paramBundle = getAddMusicPlugin().xxj;
      ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin());
      ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
      float[] arrayOfFloat = getItemContainerPlugin().dGl();
      i = getPreviewPlugin().ddx;
      int j = getPreviewPlugin().htQ;
      ArrayList localArrayList3 = new ArrayList();
      getItemContainerPlugin();
      paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, paramBundle, localArrayList1, localArrayList2, arrayOfFloat, i, j, localArrayList3, paramc, com.tencent.mm.plugin.recordvideo.plugin.h.dGm());
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGo()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dGp()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      if (getAddMusicPlugin().xxj != null) {
        break label575;
      }
      i = 0;
      label404:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      if (!getAddMusicPlugin().xDi.getMuteOrigin()) {
        break label580;
      }
      i = 0;
      label433:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      dGG();
      dGH();
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.NN(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGL().kl(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label585;
      }
    }
    label575:
    label580:
    label585:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.NO(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.xzE;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.dGf();
      if (paramc == null) {
        break label590;
      }
      paramc.dGb();
      AppMethodBeat.o(75774);
      return;
      if (getMoreMenuPlugin().bxN != 3) {
        break;
      }
      paramBundle = CaptureDataManager.xxY;
      d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().dGs());
      break;
      i = 1;
      break label404;
      i = 1;
      break label433;
    }
    label590:
    AppMethodBeat.o(75774);
  }
  
  public final boolean aoB()
  {
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.aoB())
    {
      ad.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().xAi.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f))
        {
          i += 1;
        }
        else if ((localObject2 instanceof r))
        {
          j += 1;
        }
        else if ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.dGM().TS();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
          com.tencent.mm.plugin.recordvideo.d.c.dGM().TU();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dGM();
      if (!getMoreMenuPlugin().xAo) {
        break label295;
      }
    }
    label295:
    for (long l = 1L;; l = 0L)
    {
      ((ga)localObject1).lw(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGM().ls(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xHa;
      com.tencent.mm.plugin.recordvideo.d.c.dGM().lt(j);
      localObject1 = getCaptureInfo();
      if ((localObject1 != null) && (((b)localObject1).htP == true)) {
        com.tencent.e.h.LTJ.aR((Runnable)new b(this));
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
    setPreviewPlugin(new com.tencent.mm.plugin.recordvideo.plugin.s((VideoPlayerTextureView)localObject, (d)this, (TextView)findViewById(2131306323)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(169939);
      Object localObject1 = this.xDU.getCaptureInfo();
      if (localObject1 != null) {}
      for (localObject1 = ((b)localObject1).htR;; localObject1 = null)
      {
        com.tencent.mm.vfs.i.deleteFile((String)localObject1);
        b localb = this.xDU.getCaptureInfo();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.htN;
        }
        com.tencent.mm.vfs.i.deleteFile((String)localObject1);
        AppMethodBeat.o(169939);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */