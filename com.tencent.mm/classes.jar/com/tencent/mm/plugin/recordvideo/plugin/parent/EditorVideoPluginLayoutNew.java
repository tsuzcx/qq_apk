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
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.gc;
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
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final EditorVideoPluginLayoutNew.a xTO;
  
  static
  {
    AppMethodBeat.i(75779);
    xTO = new EditorVideoPluginLayoutNew.a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private final void dJX()
  {
    AppMethodBeat.i(75776);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).ydv;
      switch (c.gpL[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).dLk();
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75776);
          throw ((Throwable)localObject1);
        }
        localObject2 = (bwm)localObject2;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.dKc();
        String str1 = ((bwm)localObject2).yew;
        d.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((bwm)localObject2).jGd;
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
          ((fr)localObject3).oV(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKc().oW(String.valueOf(((bwm)localObject2).dzE));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKc().oX(String.valueOf(((bwm)localObject2).dBu));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.dKc().Tw();
        break;
      case 5: 
        label348:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
        com.tencent.mm.plugin.recordvideo.d.c.dKc().Tx();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKc().kz(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    com.tencent.mm.plugin.recordvideo.d.c.dKc().kA(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKc();
    if (getMoreMenuPlugin().xQk) {}
    for (long l = 1L;; l = 0L)
    {
      ((fr)localObject1).kF(l);
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void dJY()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).hwK;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKc().oZ(localStringBuilder.substring(0, i).toString());
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
    //   19: invokestatic 318	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 320	com/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;)V
    //   27: aload_1
    //   28: ifnull +1672 -> 1700
    //   31: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:yha	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   34: astore 5
    //   36: iconst_0
    //   37: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:OB	(I)V
    //   40: aload_1
    //   41: invokevirtual 332	com/tencent/mm/media/widget/camerarecordview/b/b:axR	()Z
    //   44: ifeq +16 -> 60
    //   47: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:yha	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   50: astore 5
    //   52: invokestatic 335	com/tencent/mm/plugin/recordvideo/e/a:dLI	()I
    //   55: iconst_1
    //   56: iadd
    //   57: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:OB	(I)V
    //   60: aload_1
    //   61: invokevirtual 338	com/tencent/mm/media/widget/camerarecordview/b/b:axQ	()Z
    //   64: ifeq +16 -> 80
    //   67: getstatic 326	com/tencent/mm/plugin/recordvideo/e/a:yha	Lcom/tencent/mm/plugin/recordvideo/e/a;
    //   70: astore 5
    //   72: invokestatic 335	com/tencent/mm/plugin/recordvideo/e/a:dLI	()I
    //   75: iconst_1
    //   76: iadd
    //   77: invokestatic 329	com/tencent/mm/plugin/recordvideo/e/a:OB	(I)V
    //   80: invokestatic 344	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   83: lstore_3
    //   84: aload_0
    //   85: invokevirtual 348	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getBgPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/q;
    //   88: astore 8
    //   90: aload_0
    //   91: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   94: astore 7
    //   96: aload 7
    //   98: ifnonnull +6 -> 104
    //   101: invokestatic 351	d/g/b/p:gkB	()V
    //   104: aload_0
    //   105: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   108: astore 6
    //   110: aload 7
    //   112: ldc_w 356
    //   115: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   118: aload 8
    //   120: getfield 361	com/tencent/mm/plugin/recordvideo/plugin/q:TAG	Ljava/lang/String;
    //   123: ldc_w 363
    //   126: invokestatic 318	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 6
    //   131: ifnull +1217 -> 1348
    //   134: aload 6
    //   136: getfield 369	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xOk	Ljava/lang/Boolean;
    //   139: astore 5
    //   141: aload 5
    //   143: getstatic 374	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   146: invokestatic 377	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   149: ifeq +168 -> 317
    //   152: getstatic 383	com/tencent/mm/plugin/recordvideo/e/c:yho	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   155: astore 5
    //   157: aload 7
    //   159: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axS	()Ljava/lang/String;
    //   162: invokestatic 390	com/tencent/mm/plugin/recordvideo/e/c:axr	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   165: astore 5
    //   167: aload 5
    //   169: ifnull +148 -> 317
    //   172: aload 5
    //   174: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dHi	I
    //   177: ifeq +14 -> 191
    //   180: aload 5
    //   182: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dHi	I
    //   185: sipush 180
    //   188: if_icmpne +1171 -> 1359
    //   191: aload 5
    //   193: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   196: aload 5
    //   198: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   201: if_icmple +1153 -> 1354
    //   204: iconst_1
    //   205: istore_2
    //   206: iload_2
    //   207: ifeq +1362 -> 1569
    //   210: aload 6
    //   212: getfield 404	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   215: iconst_3
    //   216: if_icmpne +1353 -> 1569
    //   219: aconst_null
    //   220: astore 6
    //   222: new 406	com/tencent/mm/ui/blur/e
    //   225: dup
    //   226: aload 8
    //   228: getfield 408	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   231: invokespecial 411	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   234: astore 5
    //   236: aload 7
    //   238: getfield 414	com/tencent/mm/media/widget/camerarecordview/b/b:hwB	Ljava/lang/String;
    //   241: aload 7
    //   243: getfield 417	com/tencent/mm/media/widget/camerarecordview/b/b:dez	I
    //   246: i2l
    //   247: ldc2_w 418
    //   250: lmul
    //   251: invokestatic 425	com/tencent/mm/plugin/mmsight/d:aZ	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
    //   254: astore 7
    //   256: aload 7
    //   258: ifnonnull +1124 -> 1382
    //   261: aconst_null
    //   262: astore 6
    //   264: aload 6
    //   266: ifnull +31 -> 297
    //   269: aload 8
    //   271: aload 5
    //   273: aload 6
    //   275: ldc_w 426
    //   278: invokevirtual 430	com/tencent/mm/ui/blur/e:d	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   281: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xQW	Landroid/graphics/Bitmap;
    //   284: aload 8
    //   286: getfield 438	com/tencent/mm/plugin/recordvideo/plugin/q:xQX	Landroid/widget/ImageView;
    //   289: aload 8
    //   291: getfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xQW	Landroid/graphics/Bitmap;
    //   294: invokevirtual 444	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   297: aload 5
    //   299: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   302: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   305: astore 5
    //   307: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dKc	()Lcom/tencent/mm/g/b/a/fr;
    //   310: ldc2_w 448
    //   313: invokevirtual 452	com/tencent/mm/g/b/a/fr:kI	(J)Lcom/tencent/mm/g/b/a/fr;
    //   316: pop
    //   317: aload_0
    //   318: invokevirtual 456	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getPreviewPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/s;
    //   321: astore 6
    //   323: aload_0
    //   324: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   327: astore 7
    //   329: aload 7
    //   331: ifnonnull +6 -> 337
    //   334: invokestatic 351	d/g/b/p:gkB	()V
    //   337: aload_0
    //   338: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   341: astore 8
    //   343: aload 7
    //   345: ldc_w 356
    //   348: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   351: ldc_w 458
    //   354: ldc_w 460
    //   357: aload 7
    //   359: invokestatic 309	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   362: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   365: invokestatic 318	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 6
    //   370: aload 7
    //   372: putfield 466	com/tencent/mm/plugin/recordvideo/plugin/s:xQs	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   375: aload 8
    //   377: ifnull +1214 -> 1591
    //   380: aload 8
    //   382: getfield 469	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xOp	I
    //   385: istore_2
    //   386: aload 6
    //   388: iload_2
    //   389: putfield 472	com/tencent/mm/plugin/recordvideo/plugin/s:xRe	I
    //   392: aload 6
    //   394: new 474	com/tencent/mm/compatible/util/b
    //   397: dup
    //   398: aload 6
    //   400: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   403: invokevirtual 484	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:getContext	()Landroid/content/Context;
    //   406: invokespecial 485	com/tencent/mm/compatible/util/b:<init>	(Landroid/content/Context;)V
    //   409: putfield 489	com/tencent/mm/plugin/recordvideo/plugin/s:iAr	Lcom/tencent/mm/compatible/util/b;
    //   412: aload 6
    //   414: getfield 489	com/tencent/mm/plugin/recordvideo/plugin/s:iAr	Lcom/tencent/mm/compatible/util/b;
    //   417: astore 5
    //   419: aload 5
    //   421: ifnull +9 -> 430
    //   424: aload 5
    //   426: invokevirtual 492	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   429: pop
    //   430: aload 6
    //   432: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   435: iconst_0
    //   436: invokevirtual 495	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVisibility	(I)V
    //   439: aload 6
    //   441: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   444: fconst_0
    //   445: invokevirtual 499	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setAlpha	(F)V
    //   448: aload 6
    //   450: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   453: aload 7
    //   455: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axS	()Ljava/lang/String;
    //   458: invokevirtual 502	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoPath	(Ljava/lang/String;)V
    //   461: aload 8
    //   463: ifnull +1135 -> 1598
    //   466: aload 8
    //   468: getfield 369	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xOk	Ljava/lang/Boolean;
    //   471: astore 5
    //   473: aload 5
    //   475: getstatic 374	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   478: invokestatic 377	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   481: ifeq +94 -> 575
    //   484: getstatic 383	com/tencent/mm/plugin/recordvideo/e/c:yho	Lcom/tencent/mm/plugin/recordvideo/e/c;
    //   487: astore 5
    //   489: aload 7
    //   491: invokevirtual 386	com/tencent/mm/media/widget/camerarecordview/b/b:axS	()Ljava/lang/String;
    //   494: invokestatic 390	com/tencent/mm/plugin/recordvideo/e/c:axr	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/c$a;
    //   497: astore 5
    //   499: aload 5
    //   501: ifnull +74 -> 575
    //   504: aload 5
    //   506: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dHi	I
    //   509: ifeq +14 -> 523
    //   512: aload 5
    //   514: getfield 395	com/tencent/mm/plugin/recordvideo/e/c$a:dHi	I
    //   517: sipush 180
    //   520: if_icmpne +1089 -> 1609
    //   523: aload 5
    //   525: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   528: aload 5
    //   530: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   533: if_icmple +1071 -> 1604
    //   536: iconst_1
    //   537: istore_2
    //   538: aload 8
    //   540: ifnull +14 -> 554
    //   543: aload 8
    //   545: getfield 506	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xOi	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   548: getstatic 511	com/tencent/mm/pluginsdk/ui/i$e:Flh	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   551: if_acmpne +1104 -> 1655
    //   554: iload_2
    //   555: ifeq +1077 -> 1632
    //   558: aload 6
    //   560: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   563: getstatic 511	com/tencent/mm/pluginsdk/ui/i$e:Flh	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   566: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   569: aload 6
    //   571: iconst_1
    //   572: putfield 518	com/tencent/mm/plugin/recordvideo/plugin/s:xRg	Z
    //   575: aload 6
    //   577: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   580: aload 6
    //   582: getfield 522	com/tencent/mm/plugin/recordvideo/plugin/s:xRj	Lcom/tencent/mm/plugin/recordvideo/plugin/s$d;
    //   585: checkcast 524	com/tencent/mm/pluginsdk/ui/tools/h$a
    //   588: invokevirtual 528	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoCallback	(Lcom/tencent/mm/pluginsdk/ui/tools/h$a;)V
    //   591: aload 6
    //   593: aload 7
    //   595: getfield 417	com/tencent/mm/media/widget/camerarecordview/b/b:dez	I
    //   598: putfield 529	com/tencent/mm/plugin/recordvideo/plugin/s:dez	I
    //   601: aload 6
    //   603: aload 7
    //   605: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:hwE	I
    //   608: putfield 533	com/tencent/mm/plugin/recordvideo/plugin/s:hwE	I
    //   611: aload 6
    //   613: getfield 537	com/tencent/mm/plugin/recordvideo/plugin/s:xRk	Landroid/widget/TextView;
    //   616: astore 5
    //   618: aload 5
    //   620: ifnull +10 -> 630
    //   623: aload 5
    //   625: bipush 8
    //   627: invokevirtual 540	android/widget/TextView:setVisibility	(I)V
    //   630: aload 6
    //   632: getfield 537	com/tencent/mm/plugin/recordvideo/plugin/s:xRk	Landroid/widget/TextView;
    //   635: astore 5
    //   637: aload 5
    //   639: ifnull +26 -> 665
    //   642: invokestatic 545	com/tencent/mm/sdk/platformtools/bv:fpT	()Z
    //   645: ifeq +20 -> 665
    //   648: new 547	com/tencent/mm/plugin/recordvideo/plugin/s$c
    //   651: dup
    //   652: aload 5
    //   654: aload 6
    //   656: invokespecial 550	com/tencent/mm/plugin/recordvideo/plugin/s$c:<init>	(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/s;)V
    //   659: checkcast 552	java/lang/Runnable
    //   662: invokestatic 558	com/tencent/mm/plugin/mmsight/model/j:ad	(Ljava/lang/Runnable;)V
    //   665: ldc_w 304
    //   668: new 161	java/lang/StringBuilder
    //   671: dup
    //   672: ldc_w 560
    //   675: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   678: lload_3
    //   679: invokestatic 565	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   682: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   685: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 570	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload_0
    //   692: invokevirtual 574	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getReMuxPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/ab;
    //   695: astore 5
    //   697: aload_0
    //   698: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   701: astore 6
    //   703: aload 6
    //   705: ifnonnull +6 -> 711
    //   708: invokestatic 351	d/g/b/p:gkB	()V
    //   711: aload 5
    //   713: aload_1
    //   714: aload 6
    //   716: invokevirtual 579	com/tencent/mm/plugin/recordvideo/plugin/ab:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   719: ldc_w 304
    //   722: new 161	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 581
    //   729: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: lload_3
    //   733: invokestatic 565	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   736: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 570	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: aload_0
    //   746: invokevirtual 585	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCropVideoPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/a;
    //   749: astore 5
    //   751: aload_0
    //   752: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   755: astore 6
    //   757: aload 6
    //   759: ifnonnull +6 -> 765
    //   762: invokestatic 351	d/g/b/p:gkB	()V
    //   765: aload_0
    //   766: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   769: astore 7
    //   771: aload 7
    //   773: ifnonnull +6 -> 779
    //   776: invokestatic 351	d/g/b/p:gkB	()V
    //   779: aload 6
    //   781: ldc_w 587
    //   784: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   787: aload 7
    //   789: ldc_w 589
    //   792: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   795: aload 5
    //   797: aload 6
    //   799: putfield 594	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:xSr	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   802: aload 5
    //   804: aload 7
    //   806: putfield 598	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:sYT	Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   809: ldc_w 304
    //   812: new 161	java/lang/StringBuilder
    //   815: dup
    //   816: ldc_w 600
    //   819: invokespecial 561	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   822: lload_3
    //   823: invokestatic 565	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   826: invokevirtual 568	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 570	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload_1
    //   836: getfield 603	com/tencent/mm/media/widget/camerarecordview/b/b:hwN	Landroid/os/Bundle;
    //   839: ifnull +231 -> 1070
    //   842: aload_1
    //   843: getfield 603	com/tencent/mm/media/widget/camerarecordview/b/b:hwN	Landroid/os/Bundle;
    //   846: astore 5
    //   848: aload 5
    //   850: ifnonnull +6 -> 856
    //   853: invokestatic 351	d/g/b/p:gkB	()V
    //   856: getstatic 609	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:xPl	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   859: astore 6
    //   861: aload 5
    //   863: invokestatic 612	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:dJh	()Ljava/lang/String;
    //   866: invokevirtual 618	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   869: astore 5
    //   871: aload_1
    //   872: getfield 603	com/tencent/mm/media/widget/camerarecordview/b/b:hwN	Landroid/os/Bundle;
    //   875: astore 6
    //   877: aload 6
    //   879: ifnonnull +6 -> 885
    //   882: invokestatic 351	d/g/b/p:gkB	()V
    //   885: getstatic 609	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:xPl	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   888: astore 7
    //   890: aload 6
    //   892: invokestatic 621	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:dJg	()Ljava/lang/String;
    //   895: iconst_0
    //   896: invokevirtual 625	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   899: istore_2
    //   900: aload 5
    //   902: ifnull +168 -> 1070
    //   905: aload 5
    //   907: invokevirtual 629	java/util/ArrayList:isEmpty	()Z
    //   910: ifne +160 -> 1070
    //   913: aload_0
    //   914: invokevirtual 633	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getAddMusicPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/a/a;
    //   917: astore 6
    //   919: aload 5
    //   921: ldc_w 635
    //   924: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   927: aload 6
    //   929: getfield 641	com/tencent/mm/plugin/recordvideo/plugin/a/a:xTd	Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;
    //   932: astore 6
    //   934: aload 5
    //   936: checkcast 643	java/util/List
    //   939: astore 5
    //   941: aload 5
    //   943: ldc_w 635
    //   946: invokestatic 73	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   949: aload 6
    //   951: getfield 649	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:ybc	Lcom/tencent/mm/plugin/recordvideo/ui/a/a;
    //   954: aload 5
    //   956: invokevirtual 655	com/tencent/mm/plugin/recordvideo/ui/a/a:fn	(Ljava/util/List;)V
    //   959: aload 5
    //   961: invokeinterface 658 1 0
    //   966: iload_2
    //   967: if_icmple +97 -> 1064
    //   970: aload 6
    //   972: getfield 662	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:yak	Landroid/support/v7/widget/RecyclerView;
    //   975: astore 5
    //   977: iload_2
    //   978: new 664	com/tencent/mm/hellhoundlib/b/a
    //   981: dup
    //   982: invokespecial 665	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   985: invokestatic 670	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   988: astore 7
    //   990: aload 5
    //   992: aload 7
    //   994: invokevirtual 674	com/tencent/mm/hellhoundlib/b/a:ahE	()[Ljava/lang/Object;
    //   997: ldc_w 675
    //   1000: ldc_w 677
    //   1003: ldc_w 679
    //   1006: ldc_w 681
    //   1009: ldc_w 683
    //   1012: ldc_w 684
    //   1015: invokestatic 689	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload 5
    //   1020: aload 7
    //   1022: iconst_0
    //   1023: invokevirtual 693	com/tencent/mm/hellhoundlib/b/a:mt	(I)Ljava/lang/Object;
    //   1026: checkcast 695	java/lang/Integer
    //   1029: invokevirtual 698	java/lang/Integer:intValue	()I
    //   1032: invokevirtual 703	android/support/v7/widget/RecyclerView:ca	(I)V
    //   1035: aload 5
    //   1037: ldc_w 675
    //   1040: ldc_w 677
    //   1043: ldc_w 679
    //   1046: ldc_w 681
    //   1049: ldc_w 683
    //   1052: ldc_w 684
    //   1055: invokestatic 706	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1058: aload 6
    //   1060: iload_2
    //   1061: invokestatic 709	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:a	(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;I)V
    //   1064: aload 6
    //   1066: iconst_1
    //   1067: putfield 712	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:ybf	Z
    //   1070: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1073: astore 5
    //   1075: ldc_w 714
    //   1078: iconst_2
    //   1079: invokestatic 717	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: invokestatic 721	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1085: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1088: astore 5
    //   1090: ldc_w 723
    //   1093: aload_1
    //   1094: getfield 532	com/tencent/mm/media/widget/camerarecordview/b/b:hwE	I
    //   1097: invokestatic 717	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1100: invokestatic 721	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1103: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1106: astore 5
    //   1108: ldc_w 725
    //   1111: invokestatic 730	java/lang/System:currentTimeMillis	()J
    //   1114: invokestatic 735	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1117: invokestatic 721	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1120: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1123: astore 5
    //   1125: ldc_w 737
    //   1128: invokestatic 730	java/lang/System:currentTimeMillis	()J
    //   1131: invokestatic 735	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1134: invokestatic 721	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1137: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1140: astore 5
    //   1142: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dKc	()Lcom/tencent/mm/g/b/a/fr;
    //   1145: invokestatic 730	java/lang/System:currentTimeMillis	()J
    //   1148: invokevirtual 740	com/tencent/mm/g/b/a/fr:kv	(J)Lcom/tencent/mm/g/b/a/fr;
    //   1151: pop
    //   1152: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1155: astore 5
    //   1157: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dKc	()Lcom/tencent/mm/g/b/a/fr;
    //   1160: astore 5
    //   1162: aload_1
    //   1163: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:hwK	Ljava/util/ArrayList;
    //   1166: checkcast 742	java/util/Collection
    //   1169: astore 6
    //   1171: aload 6
    //   1173: ifnull +13 -> 1186
    //   1176: aload 6
    //   1178: invokeinterface 743 1 0
    //   1183: ifeq +488 -> 1671
    //   1186: iconst_1
    //   1187: istore_2
    //   1188: iload_2
    //   1189: ifne +487 -> 1676
    //   1192: lconst_1
    //   1193: lstore_3
    //   1194: aload 5
    //   1196: lload_3
    //   1197: invokevirtual 746	com/tencent/mm/g/b/a/fr:kG	(J)Lcom/tencent/mm/g/b/a/fr;
    //   1200: pop
    //   1201: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1204: astore 5
    //   1206: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dKc	()Lcom/tencent/mm/g/b/a/fr;
    //   1209: aload_1
    //   1210: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:hwK	Ljava/util/ArrayList;
    //   1213: invokevirtual 747	java/util/ArrayList:size	()I
    //   1216: i2l
    //   1217: invokevirtual 750	com/tencent/mm/g/b/a/fr:kH	(J)Lcom/tencent/mm/g/b/a/fr;
    //   1220: pop
    //   1221: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1224: astore 5
    //   1226: invokestatic 754	com/tencent/mm/plugin/recordvideo/d/c:dKd	()Lcom/tencent/mm/g/b/a/gc;
    //   1229: astore 5
    //   1231: aload_1
    //   1232: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:hwK	Ljava/util/ArrayList;
    //   1235: checkcast 742	java/util/Collection
    //   1238: astore 6
    //   1240: aload 6
    //   1242: ifnull +13 -> 1255
    //   1245: aload 6
    //   1247: invokeinterface 743 1 0
    //   1252: ifeq +431 -> 1683
    //   1255: iconst_1
    //   1256: istore_2
    //   1257: iload_2
    //   1258: ifne +430 -> 1688
    //   1261: lconst_1
    //   1262: lstore_3
    //   1263: aload 5
    //   1265: lload_3
    //   1266: invokevirtual 760	com/tencent/mm/g/b/a/gc:lI	(J)Lcom/tencent/mm/g/b/a/gc;
    //   1269: pop
    //   1270: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1273: astore 5
    //   1275: invokestatic 754	com/tencent/mm/plugin/recordvideo/d/c:dKd	()Lcom/tencent/mm/g/b/a/gc;
    //   1278: aload_1
    //   1279: getfield 258	com/tencent/mm/media/widget/camerarecordview/b/b:hwK	Ljava/util/ArrayList;
    //   1282: invokevirtual 747	java/util/ArrayList:size	()I
    //   1285: i2l
    //   1286: invokevirtual 763	com/tencent/mm/g/b/a/gc:lJ	(J)Lcom/tencent/mm/g/b/a/gc;
    //   1289: pop
    //   1290: aload_0
    //   1291: invokevirtual 252	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   1294: astore_1
    //   1295: aload_1
    //   1296: ifnonnull +6 -> 1302
    //   1299: invokestatic 351	d/g/b/p:gkB	()V
    //   1302: aload_1
    //   1303: getfield 766	com/tencent/mm/media/widget/camerarecordview/b/b:hwD	Z
    //   1306: ifne +35 -> 1341
    //   1309: aload_0
    //   1310: invokevirtual 355	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   1313: astore_1
    //   1314: aload_1
    //   1315: ifnull +380 -> 1695
    //   1318: aload_1
    //   1319: getfield 404	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   1322: istore_2
    //   1323: iload_2
    //   1324: ifle +17 -> 1341
    //   1327: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1330: astore_1
    //   1331: ldc_w 768
    //   1334: iconst_0
    //   1335: invokestatic 717	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: invokestatic 721	com/tencent/mm/plugin/recordvideo/d/c:u	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1341: ldc_w 302
    //   1344: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1347: return
    //   1348: aconst_null
    //   1349: astore 5
    //   1351: goto -1210 -> 141
    //   1354: iconst_0
    //   1355: istore_2
    //   1356: goto -1150 -> 206
    //   1359: aload 5
    //   1361: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1364: aload 5
    //   1366: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1369: if_icmple +8 -> 1377
    //   1372: iconst_1
    //   1373: istore_2
    //   1374: goto -1168 -> 206
    //   1377: iconst_0
    //   1378: istore_2
    //   1379: goto -1173 -> 206
    //   1382: aload 7
    //   1384: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1387: aload 7
    //   1389: invokevirtual 776	android/graphics/Bitmap:getHeight	()I
    //   1392: getstatic 782	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1395: invokestatic 786	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1398: astore 6
    //   1400: aload 7
    //   1402: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1405: aload 7
    //   1407: invokevirtual 776	android/graphics/Bitmap:getHeight	()I
    //   1410: imul
    //   1411: newarray int
    //   1413: astore 9
    //   1415: aload 7
    //   1417: aload 9
    //   1419: iconst_0
    //   1420: aload 7
    //   1422: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1425: iconst_0
    //   1426: iconst_0
    //   1427: aload 7
    //   1429: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1432: aload 7
    //   1434: invokevirtual 776	android/graphics/Bitmap:getHeight	()I
    //   1437: invokevirtual 790	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1440: aload 6
    //   1442: ldc_w 792
    //   1445: invokestatic 154	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1448: aload 6
    //   1450: aload 9
    //   1452: iconst_0
    //   1453: aload 6
    //   1455: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1458: iconst_0
    //   1459: iconst_0
    //   1460: aload 6
    //   1462: invokevirtual 773	android/graphics/Bitmap:getWidth	()I
    //   1465: aload 6
    //   1467: invokevirtual 776	android/graphics/Bitmap:getHeight	()I
    //   1470: invokevirtual 795	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   1473: goto -1209 -> 264
    //   1476: astore 7
    //   1478: aload 6
    //   1480: astore 5
    //   1482: aload 7
    //   1484: astore 6
    //   1486: ldc_w 458
    //   1489: aload 6
    //   1491: checkcast 797	java/lang/Throwable
    //   1494: ldc_w 799
    //   1497: iconst_0
    //   1498: anewarray 801	java/lang/Object
    //   1501: invokestatic 805	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1504: invokestatic 808	com/tencent/mm/sdk/platformtools/ae:getLogLevel	()I
    //   1507: ifle +21 -> 1528
    //   1510: aload 8
    //   1512: getfield 408	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   1515: ldc_w 810
    //   1518: checkcast 165	java/lang/CharSequence
    //   1521: iconst_0
    //   1522: invokestatic 816	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1525: invokevirtual 819	android/widget/Toast:show	()V
    //   1528: aload 8
    //   1530: aconst_null
    //   1531: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xQW	Landroid/graphics/Bitmap;
    //   1534: aload 5
    //   1536: ifnull -1234 -> 302
    //   1539: aload 5
    //   1541: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   1544: goto -1242 -> 302
    //   1547: astore_1
    //   1548: aconst_null
    //   1549: astore 5
    //   1551: aload 5
    //   1553: ifnull +8 -> 1561
    //   1556: aload 5
    //   1558: invokevirtual 447	com/tencent/mm/ui/blur/e:destroy	()V
    //   1561: ldc_w 302
    //   1564: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1567: aload_1
    //   1568: athrow
    //   1569: aload 8
    //   1571: aconst_null
    //   1572: putfield 434	com/tencent/mm/plugin/recordvideo/plugin/q:xQW	Landroid/graphics/Bitmap;
    //   1575: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:xWV	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1578: astore 5
    //   1580: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:dKc	()Lcom/tencent/mm/g/b/a/fr;
    //   1583: lconst_1
    //   1584: invokevirtual 452	com/tencent/mm/g/b/a/fr:kI	(J)Lcom/tencent/mm/g/b/a/fr;
    //   1587: pop
    //   1588: goto -1271 -> 317
    //   1591: sipush 10000
    //   1594: istore_2
    //   1595: goto -1209 -> 386
    //   1598: aconst_null
    //   1599: astore 5
    //   1601: goto -1128 -> 473
    //   1604: iconst_0
    //   1605: istore_2
    //   1606: goto -1068 -> 538
    //   1609: aload 5
    //   1611: getfield 401	com/tencent/mm/plugin/recordvideo/e/c$a:height	I
    //   1614: aload 5
    //   1616: getfield 398	com/tencent/mm/plugin/recordvideo/e/c$a:width	I
    //   1619: if_icmple +8 -> 1627
    //   1622: iconst_1
    //   1623: istore_2
    //   1624: goto -1086 -> 538
    //   1627: iconst_0
    //   1628: istore_2
    //   1629: goto -1091 -> 538
    //   1632: aload 6
    //   1634: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1637: iconst_1
    //   1638: invokevirtual 823	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setForceScaleFullScreen	(Z)V
    //   1641: aload 6
    //   1643: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1646: getstatic 826	com/tencent/mm/pluginsdk/ui/i$e:Flk	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1649: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1652: goto -1083 -> 569
    //   1655: aload 6
    //   1657: getfield 478	com/tencent/mm/plugin/recordvideo/plugin/s:wdv	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1660: aload 8
    //   1662: getfield 506	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:xOi	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1665: invokevirtual 515	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1668: goto -1099 -> 569
    //   1671: iconst_0
    //   1672: istore_2
    //   1673: goto -485 -> 1188
    //   1676: ldc2_w 448
    //   1679: lstore_3
    //   1680: goto -486 -> 1194
    //   1683: iconst_0
    //   1684: istore_2
    //   1685: goto -428 -> 1257
    //   1688: ldc2_w 448
    //   1691: lstore_3
    //   1692: goto -429 -> 1263
    //   1695: iconst_0
    //   1696: istore_2
    //   1697: goto -374 -> 1323
    //   1700: ldc_w 302
    //   1703: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1706: return
    //   1707: astore_1
    //   1708: goto -157 -> 1551
    //   1711: astore_1
    //   1712: goto -161 -> 1551
    //   1715: astore 6
    //   1717: goto -231 -> 1486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1720	0	this	EditorVideoPluginLayoutNew
    //   0	1720	1	paramb	b
    //   205	1492	2	i	int
    //   83	1609	3	l	long
    //   34	1581	5	localObject1	Object
    //   108	1548	6	localObject2	Object
    //   1715	1	6	localException1	java.lang.Exception
    //   94	1339	7	localObject3	Object
    //   1476	7	7	localException2	java.lang.Exception
    //   88	1573	8	localObject4	Object
    //   1413	38	9	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   222	236	1476	java/lang/Exception
    //   222	236	1547	finally
    //   236	256	1707	finally
    //   269	297	1707	finally
    //   1382	1473	1707	finally
    //   1486	1528	1711	finally
    //   1528	1534	1711	finally
    //   236	256	1715	java/lang/Exception
    //   269	297	1715	java/lang/Exception
    //   1382	1473	1715	java/lang/Exception
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(75774);
    d.g.b.p.h(paramc, "status");
    if (paramc != d.c.xUM) {
      ae.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (c.cqt[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.xUM) {
        ae.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75774);
      return;
    }
    paramc = getBgPlugin().dJP();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().xQk) {
      i = 1;
    }
    paramBundle = CaptureDataManager.xNV;
    d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bxN == 2)
    {
      paramBundle = CaptureDataManager.xNV;
      d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().dJJ());
      boolean bool = getAddMusicPlugin().xTd.getMuteOrigin();
      paramBundle = getAddMusicPlugin().xNg;
      ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin());
      ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
      float[] arrayOfFloat = getItemContainerPlugin().dJC();
      i = getPreviewPlugin().dez;
      int j = getPreviewPlugin().hwE;
      ArrayList localArrayList3 = new ArrayList();
      getItemContainerPlugin();
      paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, paramBundle, localArrayList1, localArrayList2, arrayOfFloat, i, j, localArrayList3, paramc, com.tencent.mm.plugin.recordvideo.plugin.h.dJD());
      ae.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dJF()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().dJG()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      if (getAddMusicPlugin().xNg != null) {
        break label575;
      }
      i = 0;
      label404:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      if (!getAddMusicPlugin().xTd.getMuteOrigin()) {
        break label580;
      }
      i = 0;
      label433:
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      dJX();
      dJY();
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.Ot(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKc().kw(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.xWV;
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
      com.tencent.mm.plugin.recordvideo.d.c.Ou(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.xPA;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.dJw();
      if (paramc == null) {
        break label590;
      }
      paramc.dJs();
      AppMethodBeat.o(75774);
      return;
      if (getMoreMenuPlugin().bxN != 3) {
        break;
      }
      paramBundle = CaptureDataManager.xNV;
      d.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().dJJ());
      break;
      i = 1;
      break label404;
      i = 1;
      break label433;
    }
    label590:
    AppMethodBeat.o(75774);
  }
  
  public final boolean aoQ()
  {
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.aoQ())
    {
      ae.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.u("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().xQe.getAllItemViews()).iterator();
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
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKd().TY();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.dKd().Ua();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.dKd();
      if (!getMoreMenuPlugin().xQk) {
        break label295;
      }
    }
    label295:
    for (long l = 1L;; l = 0L)
    {
      ((gc)localObject1).lH(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKd().lD(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.xWV;
      com.tencent.mm.plugin.recordvideo.d.c.dKd().lE(j);
      localObject1 = getCaptureInfo();
      if ((localObject1 != null) && (((b)localObject1).hwD == true)) {
        com.tencent.e.h.MqF.aO((Runnable)new b(this));
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
    ae.i("MicroMsg.EditorVideoPluginLayoutNew", "playerView :".concat(String.valueOf(localObject)));
    setPreviewPlugin(new com.tencent.mm.plugin.recordvideo.plugin.s((VideoPlayerTextureView)localObject, (d)this, (TextView)findViewById(2131306323)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(169939);
      Object localObject1 = this.xTP.getCaptureInfo();
      if (localObject1 != null) {}
      for (localObject1 = ((b)localObject1).hwF;; localObject1 = null)
      {
        o.deleteFile((String)localObject1);
        b localb = this.xTP.getCaptureInfo();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.hwB;
        }
        o.deleteFile((String)localObject1);
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