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
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a.a;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew
  extends BaseEditVideoPluginLayout
  implements d
{
  public static final EditorVideoPluginLayoutNew.a BUn;
  
  static
  {
    AppMethodBeat.i(75779);
    BUn = new EditorVideoPluginLayoutNew.a((byte)0);
    AppMethodBeat.o(75779);
  }
  
  public EditorVideoPluginLayoutNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(75778);
    AppMethodBeat.o(75778);
  }
  
  private final void eKS()
  {
    AppMethodBeat.i(75776);
    Object localObject1 = ((Iterable)getItemContainerPlugin().getEditorDataList()).iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)((Iterator)localObject1).next();
      Object localObject3 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).Cex;
      switch (c.haE[localObject3.ordinal()])
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
        localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2).eMk();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
          AppMethodBeat.o(75776);
          throw ((Throwable)localObject1);
        }
        localObject2 = (cka)localObject2;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        localObject3 = com.tencent.mm.plugin.recordvideo.d.c.eKX();
        String str1 = ((cka)localObject2).Cfy;
        kotlin.g.b.p.g(str1, "poiData.cityName");
        String str2 = ((cka)localObject2).kHV;
        kotlin.g.b.p.g(str2, "poiData.poiName");
        StringBuilder localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)str1)) {
          localStringBuilder.append(n.j(str1, ",", " ", true));
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
          localStringBuilder.append(n.j(str2, ",", " ", true));
          str1 = localStringBuilder.toString();
          kotlin.g.b.p.g(str1, "reportPositionString.toString()");
          ((jf)localObject3).wE(str1);
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKX().wF(String.valueOf(((cka)localObject2).latitude));
          localObject3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKX().wG(String.valueOf(((cka)localObject2).dTj));
          break;
        }
      case 4: 
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().ahl();
        break;
      case 5: 
        label348:
        localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().ahm();
      }
    }
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKX().rB(i);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    com.tencent.mm.plugin.recordvideo.d.c.eKX().rC(j);
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
    localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKX();
    if (getMoreMenuPlugin().BQn) {}
    for (long l = 1L;; l = 0L)
    {
      ((jf)localObject1).rH(l);
      AppMethodBeat.o(75776);
      return;
    }
  }
  
  private final void eKT()
  {
    AppMethodBeat.i(75777);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getCaptureInfo();
    if (localObject != null)
    {
      localObject = ((b)localObject).iqm;
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
      localObject = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKX().wI(localStringBuilder.substring(0, i).toString());
    }
    AppMethodBeat.o(75777);
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 305
    //   9: ldc_w 307
    //   12: aload_1
    //   13: invokestatic 310	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 314	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokespecial 321	com/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;)V
    //   27: aload_1
    //   28: ifnull +1729 -> 1757
    //   31: getstatic 327	com/tencent/mm/plugin/recordvideo/e/b:ChY	Lcom/tencent/mm/plugin/recordvideo/e/b;
    //   34: astore 5
    //   36: iconst_0
    //   37: invokestatic 330	com/tencent/mm/plugin/recordvideo/e/b:VW	(I)V
    //   40: aload_1
    //   41: invokevirtual 333	com/tencent/mm/media/widget/camerarecordview/b/b:aQp	()Z
    //   44: ifeq +16 -> 60
    //   47: getstatic 327	com/tencent/mm/plugin/recordvideo/e/b:ChY	Lcom/tencent/mm/plugin/recordvideo/e/b;
    //   50: astore 5
    //   52: invokestatic 336	com/tencent/mm/plugin/recordvideo/e/b:eMG	()I
    //   55: iconst_1
    //   56: iadd
    //   57: invokestatic 330	com/tencent/mm/plugin/recordvideo/e/b:VW	(I)V
    //   60: aload_1
    //   61: invokevirtual 339	com/tencent/mm/media/widget/camerarecordview/b/b:aQo	()Z
    //   64: ifeq +16 -> 80
    //   67: getstatic 327	com/tencent/mm/plugin/recordvideo/e/b:ChY	Lcom/tencent/mm/plugin/recordvideo/e/b;
    //   70: astore 5
    //   72: invokestatic 336	com/tencent/mm/plugin/recordvideo/e/b:eMG	()I
    //   75: iconst_1
    //   76: iadd
    //   77: invokestatic 330	com/tencent/mm/plugin/recordvideo/e/b:VW	(I)V
    //   80: invokestatic 345	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   83: lstore_3
    //   84: aload_0
    //   85: invokevirtual 349	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getBgPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/q;
    //   88: astore 8
    //   90: aload_0
    //   91: invokevirtual 253	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   94: astore 7
    //   96: aload 7
    //   98: ifnonnull +6 -> 104
    //   101: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   104: aload_0
    //   105: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   108: astore 6
    //   110: aload 7
    //   112: ldc_w 357
    //   115: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   118: aload 8
    //   120: getfield 362	com/tencent/mm/plugin/recordvideo/plugin/q:TAG	Ljava/lang/String;
    //   123: ldc_w 364
    //   126: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 6
    //   131: ifnull +1259 -> 1390
    //   134: aload 6
    //   136: getfield 370	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:BOq	Ljava/lang/Boolean;
    //   139: astore 5
    //   141: aload 5
    //   143: getstatic 375	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   146: invokestatic 378	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   149: ifeq +168 -> 317
    //   152: getstatic 384	com/tencent/mm/plugin/recordvideo/e/d:Cin	Lcom/tencent/mm/plugin/recordvideo/e/d;
    //   155: astore 5
    //   157: aload 7
    //   159: invokevirtual 387	com/tencent/mm/media/widget/camerarecordview/b/b:aQq	()Ljava/lang/String;
    //   162: invokestatic 391	com/tencent/mm/plugin/recordvideo/e/d:aLQ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/d$a;
    //   165: astore 5
    //   167: aload 5
    //   169: ifnull +148 -> 317
    //   172: aload 5
    //   174: getfield 396	com/tencent/mm/plugin/recordvideo/e/d$a:dYT	I
    //   177: ifeq +14 -> 191
    //   180: aload 5
    //   182: getfield 396	com/tencent/mm/plugin/recordvideo/e/d$a:dYT	I
    //   185: sipush 180
    //   188: if_icmpne +1213 -> 1401
    //   191: aload 5
    //   193: getfield 399	com/tencent/mm/plugin/recordvideo/e/d$a:width	I
    //   196: aload 5
    //   198: getfield 402	com/tencent/mm/plugin/recordvideo/e/d$a:height	I
    //   201: if_icmple +1195 -> 1396
    //   204: iconst_1
    //   205: istore_2
    //   206: iload_2
    //   207: ifeq +1404 -> 1611
    //   210: aload 6
    //   212: getfield 405	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   215: iconst_3
    //   216: if_icmpne +1395 -> 1611
    //   219: aconst_null
    //   220: astore 6
    //   222: new 407	com/tencent/mm/ui/blur/e
    //   225: dup
    //   226: aload 8
    //   228: getfield 409	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   231: invokespecial 412	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   234: astore 5
    //   236: aload 7
    //   238: getfield 415	com/tencent/mm/media/widget/camerarecordview/b/b:iqd	Ljava/lang/String;
    //   241: aload 7
    //   243: getfield 418	com/tencent/mm/media/widget/camerarecordview/b/b:dvv	I
    //   246: i2l
    //   247: ldc2_w 419
    //   250: lmul
    //   251: invokestatic 426	com/tencent/mm/plugin/mmsight/d:ba	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
    //   254: astore 7
    //   256: aload 7
    //   258: ifnonnull +1166 -> 1424
    //   261: aconst_null
    //   262: astore 6
    //   264: aload 6
    //   266: ifnull +31 -> 297
    //   269: aload 8
    //   271: aload 5
    //   273: aload 6
    //   275: ldc_w 427
    //   278: invokevirtual 431	com/tencent/mm/ui/blur/e:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   281: putfield 435	com/tencent/mm/plugin/recordvideo/plugin/q:BQT	Landroid/graphics/Bitmap;
    //   284: aload 8
    //   286: getfield 439	com/tencent/mm/plugin/recordvideo/plugin/q:BQU	Landroid/widget/ImageView;
    //   289: aload 8
    //   291: getfield 435	com/tencent/mm/plugin/recordvideo/plugin/q:BQT	Landroid/graphics/Bitmap;
    //   294: invokevirtual 445	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   297: aload 5
    //   299: invokevirtual 448	com/tencent/mm/ui/blur/e:destroy	()V
    //   302: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   305: astore 5
    //   307: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:eKX	()Lcom/tencent/mm/g/b/a/jf;
    //   310: ldc2_w 449
    //   313: invokevirtual 453	com/tencent/mm/g/b/a/jf:rK	(J)Lcom/tencent/mm/g/b/a/jf;
    //   316: pop
    //   317: aload_0
    //   318: invokevirtual 457	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getPreviewPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/s;
    //   321: astore 6
    //   323: aload_0
    //   324: invokevirtual 253	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   327: astore 7
    //   329: aload 7
    //   331: ifnonnull +6 -> 337
    //   334: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   337: aload_0
    //   338: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   341: astore 8
    //   343: aload 7
    //   345: ldc_w 357
    //   348: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   351: ldc_w 459
    //   354: ldc_w 461
    //   357: aload 7
    //   359: invokestatic 310	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   362: invokevirtual 314	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   365: invokestatic 319	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 6
    //   370: aload 7
    //   372: putfield 467	com/tencent/mm/plugin/recordvideo/plugin/s:BQt	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   375: aload 8
    //   377: ifnull +1256 -> 1633
    //   380: aload 8
    //   382: getfield 470	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:BOv	I
    //   385: istore_2
    //   386: aload 6
    //   388: iload_2
    //   389: putfield 473	com/tencent/mm/plugin/recordvideo/plugin/s:BRb	I
    //   392: aload 6
    //   394: new 475	com/tencent/mm/compatible/util/b
    //   397: dup
    //   398: aload 6
    //   400: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   403: invokevirtual 485	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:getContext	()Landroid/content/Context;
    //   406: invokespecial 486	com/tencent/mm/compatible/util/b:<init>	(Landroid/content/Context;)V
    //   409: putfield 490	com/tencent/mm/plugin/recordvideo/plugin/s:jvG	Lcom/tencent/mm/compatible/util/b;
    //   412: aload 6
    //   414: getfield 490	com/tencent/mm/plugin/recordvideo/plugin/s:jvG	Lcom/tencent/mm/compatible/util/b;
    //   417: astore 5
    //   419: aload 5
    //   421: ifnull +9 -> 430
    //   424: aload 5
    //   426: invokevirtual 493	com/tencent/mm/compatible/util/b:requestFocus	()Z
    //   429: pop
    //   430: aload 6
    //   432: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   435: iconst_0
    //   436: invokevirtual 496	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVisibility	(I)V
    //   439: aload 6
    //   441: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   444: fconst_0
    //   445: invokevirtual 500	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setAlpha	(F)V
    //   448: aload 6
    //   450: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   453: aload 7
    //   455: invokevirtual 387	com/tencent/mm/media/widget/camerarecordview/b/b:aQq	()Ljava/lang/String;
    //   458: invokevirtual 503	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoPath	(Ljava/lang/String;)V
    //   461: aload 8
    //   463: ifnull +1177 -> 1640
    //   466: aload 8
    //   468: getfield 370	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:BOq	Ljava/lang/Boolean;
    //   471: astore 5
    //   473: aload 5
    //   475: getstatic 375	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   478: invokestatic 378	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   481: ifeq +94 -> 575
    //   484: getstatic 384	com/tencent/mm/plugin/recordvideo/e/d:Cin	Lcom/tencent/mm/plugin/recordvideo/e/d;
    //   487: astore 5
    //   489: aload 7
    //   491: invokevirtual 387	com/tencent/mm/media/widget/camerarecordview/b/b:aQq	()Ljava/lang/String;
    //   494: invokestatic 391	com/tencent/mm/plugin/recordvideo/e/d:aLQ	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/e/d$a;
    //   497: astore 5
    //   499: aload 5
    //   501: ifnull +74 -> 575
    //   504: aload 5
    //   506: getfield 396	com/tencent/mm/plugin/recordvideo/e/d$a:dYT	I
    //   509: ifeq +14 -> 523
    //   512: aload 5
    //   514: getfield 396	com/tencent/mm/plugin/recordvideo/e/d$a:dYT	I
    //   517: sipush 180
    //   520: if_icmpne +1131 -> 1651
    //   523: aload 5
    //   525: getfield 399	com/tencent/mm/plugin/recordvideo/e/d$a:width	I
    //   528: aload 5
    //   530: getfield 402	com/tencent/mm/plugin/recordvideo/e/d$a:height	I
    //   533: if_icmple +1113 -> 1646
    //   536: iconst_1
    //   537: istore_2
    //   538: aload 8
    //   540: ifnull +14 -> 554
    //   543: aload 8
    //   545: getfield 507	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:BOo	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   548: getstatic 512	com/tencent/mm/pluginsdk/ui/i$e:KbZ	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   551: if_acmpne +1146 -> 1697
    //   554: iload_2
    //   555: ifeq +1119 -> 1674
    //   558: aload 6
    //   560: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   563: getstatic 512	com/tencent/mm/pluginsdk/ui/i$e:KbZ	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   566: invokevirtual 516	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   569: aload 6
    //   571: iconst_1
    //   572: putfield 519	com/tencent/mm/plugin/recordvideo/plugin/s:BRd	Z
    //   575: aload 6
    //   577: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   580: aload 6
    //   582: getfield 523	com/tencent/mm/plugin/recordvideo/plugin/s:BRg	Lcom/tencent/mm/plugin/recordvideo/plugin/s$d;
    //   585: checkcast 525	com/tencent/mm/pluginsdk/ui/tools/j$a
    //   588: invokevirtual 529	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setVideoCallback	(Lcom/tencent/mm/pluginsdk/ui/tools/j$a;)V
    //   591: aload 6
    //   593: aload 7
    //   595: getfield 418	com/tencent/mm/media/widget/camerarecordview/b/b:dvv	I
    //   598: putfield 530	com/tencent/mm/plugin/recordvideo/plugin/s:dvv	I
    //   601: aload 6
    //   603: aload 7
    //   605: getfield 533	com/tencent/mm/media/widget/camerarecordview/b/b:iqg	I
    //   608: putfield 534	com/tencent/mm/plugin/recordvideo/plugin/s:iqg	I
    //   611: aload 6
    //   613: getfield 538	com/tencent/mm/plugin/recordvideo/plugin/s:BRh	Landroid/widget/TextView;
    //   616: astore 5
    //   618: aload 5
    //   620: ifnull +10 -> 630
    //   623: aload 5
    //   625: bipush 8
    //   627: invokevirtual 541	android/widget/TextView:setVisibility	(I)V
    //   630: aload 6
    //   632: getfield 538	com/tencent/mm/plugin/recordvideo/plugin/s:BRh	Landroid/widget/TextView;
    //   635: astore 5
    //   637: aload 5
    //   639: ifnull +26 -> 665
    //   642: invokestatic 546	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   645: ifeq +20 -> 665
    //   648: new 548	com/tencent/mm/plugin/recordvideo/plugin/s$c
    //   651: dup
    //   652: aload 5
    //   654: aload 6
    //   656: invokespecial 551	com/tencent/mm/plugin/recordvideo/plugin/s$c:<init>	(Landroid/widget/TextView;Lcom/tencent/mm/plugin/recordvideo/plugin/s;)V
    //   659: checkcast 553	java/lang/Runnable
    //   662: invokestatic 559	com/tencent/mm/plugin/mmsight/model/j:aj	(Ljava/lang/Runnable;)V
    //   665: ldc_w 305
    //   668: new 161	java/lang/StringBuilder
    //   671: dup
    //   672: ldc_w 561
    //   675: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   678: lload_3
    //   679: invokestatic 566	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   682: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   685: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   691: aload_0
    //   692: invokevirtual 576	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getReMuxPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/ab;
    //   695: astore 5
    //   697: aload_0
    //   698: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   701: astore 6
    //   703: aload 6
    //   705: ifnonnull +6 -> 711
    //   708: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   711: aload 5
    //   713: aload_1
    //   714: aload 6
    //   716: invokevirtual 581	com/tencent/mm/plugin/recordvideo/plugin/ab:a	(Lcom/tencent/mm/media/widget/camerarecordview/b/b;Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   719: ldc_w 305
    //   722: new 161	java/lang/StringBuilder
    //   725: dup
    //   726: ldc_w 583
    //   729: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: lload_3
    //   733: invokestatic 566	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   736: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: aload_0
    //   746: invokevirtual 587	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCropVideoPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/a;
    //   749: astore 5
    //   751: aload_0
    //   752: invokevirtual 253	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   755: astore 6
    //   757: aload 6
    //   759: ifnonnull +6 -> 765
    //   762: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   765: aload_0
    //   766: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   769: astore 7
    //   771: aload 7
    //   773: ifnonnull +6 -> 779
    //   776: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   779: aload 6
    //   781: ldc_w 589
    //   784: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   787: aload 7
    //   789: ldc_w 591
    //   792: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   795: aload 5
    //   797: aload 6
    //   799: putfield 596	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:BSx	Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   802: aload 5
    //   804: aload 7
    //   806: putfield 600	com/tencent/mm/plugin/recordvideo/plugin/cropvideo/a:wdm	Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   809: ldc_w 305
    //   812: new 161	java/lang/StringBuilder
    //   815: dup
    //   816: ldc_w 602
    //   819: invokespecial 562	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   822: lload_3
    //   823: invokestatic 566	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   826: invokevirtual 569	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   829: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload_1
    //   836: getfield 605	com/tencent/mm/media/widget/camerarecordview/b/b:iqp	Landroid/os/Bundle;
    //   839: ifnull +231 -> 1070
    //   842: aload_1
    //   843: getfield 605	com/tencent/mm/media/widget/camerarecordview/b/b:iqp	Landroid/os/Bundle;
    //   846: astore 5
    //   848: aload 5
    //   850: ifnonnull +6 -> 856
    //   853: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   856: getstatic 611	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:BPo	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   859: astore 6
    //   861: aload 5
    //   863: invokestatic 614	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:eJU	()Ljava/lang/String;
    //   866: invokevirtual 620	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   869: astore 5
    //   871: aload_1
    //   872: getfield 605	com/tencent/mm/media/widget/camerarecordview/b/b:iqp	Landroid/os/Bundle;
    //   875: astore 6
    //   877: aload 6
    //   879: ifnonnull +6 -> 885
    //   882: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   885: getstatic 611	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:BPo	Lcom/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo$a;
    //   888: astore 7
    //   890: aload 6
    //   892: invokestatic 623	com/tencent/mm/plugin/recordvideo/model/audio/AudioCacheInfo:eJT	()Ljava/lang/String;
    //   895: iconst_0
    //   896: invokevirtual 627	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   899: istore_2
    //   900: aload 5
    //   902: ifnull +168 -> 1070
    //   905: aload 5
    //   907: invokevirtual 631	java/util/ArrayList:isEmpty	()Z
    //   910: ifne +160 -> 1070
    //   913: aload_0
    //   914: invokevirtual 635	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getAddMusicPlugin	()Lcom/tencent/mm/plugin/recordvideo/plugin/a/a;
    //   917: astore 6
    //   919: aload 5
    //   921: ldc_w 637
    //   924: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   927: aload 6
    //   929: getfield 643	com/tencent/mm/plugin/recordvideo/plugin/a/a:wgL	Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;
    //   932: astore 6
    //   934: aload 5
    //   936: checkcast 645	java/util/List
    //   939: astore 5
    //   941: aload 5
    //   943: ldc_w 637
    //   946: invokestatic 73	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   949: aload 6
    //   951: getfield 651	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:Cce	Lcom/tencent/mm/plugin/recordvideo/ui/a/a;
    //   954: aload 5
    //   956: invokevirtual 657	com/tencent/mm/plugin/recordvideo/ui/a/a:gj	(Ljava/util/List;)V
    //   959: aload 5
    //   961: invokeinterface 660 1 0
    //   966: iload_2
    //   967: if_icmple +97 -> 1064
    //   970: aload 6
    //   972: getfield 664	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:Cbg	Landroid/support/v7/widget/RecyclerView;
    //   975: astore 5
    //   977: iload_2
    //   978: new 666	com/tencent/mm/hellhoundlib/b/a
    //   981: dup
    //   982: invokespecial 667	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   985: invokestatic 672	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   988: astore 7
    //   990: aload 5
    //   992: aload 7
    //   994: invokevirtual 676	com/tencent/mm/hellhoundlib/b/a:axQ	()[Ljava/lang/Object;
    //   997: ldc_w 677
    //   1000: ldc_w 679
    //   1003: ldc_w 681
    //   1006: ldc_w 683
    //   1009: ldc_w 685
    //   1012: ldc_w 686
    //   1015: invokestatic 691	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1018: aload 5
    //   1020: aload 7
    //   1022: iconst_0
    //   1023: invokevirtual 695	com/tencent/mm/hellhoundlib/b/a:pG	(I)Ljava/lang/Object;
    //   1026: checkcast 697	java/lang/Integer
    //   1029: invokevirtual 700	java/lang/Integer:intValue	()I
    //   1032: invokevirtual 704	android/support/v7/widget/RecyclerView:scrollToPosition	(I)V
    //   1035: aload 5
    //   1037: ldc_w 677
    //   1040: ldc_w 679
    //   1043: ldc_w 681
    //   1046: ldc_w 683
    //   1049: ldc_w 685
    //   1052: ldc_w 686
    //   1055: invokestatic 707	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1058: aload 6
    //   1060: iload_2
    //   1061: invokestatic 710	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:a	(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView;I)V
    //   1064: aload 6
    //   1066: iconst_1
    //   1067: putfield 713	com/tencent/mm/plugin/recordvideo/ui/editor/EditorAudioView:Cch	Z
    //   1070: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1073: astore 5
    //   1075: ldc_w 715
    //   1078: iconst_2
    //   1079: invokestatic 718	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1082: invokestatic 722	com/tencent/mm/plugin/recordvideo/d/c:x	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1085: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1088: astore 5
    //   1090: ldc_w 724
    //   1093: aload_1
    //   1094: getfield 533	com/tencent/mm/media/widget/camerarecordview/b/b:iqg	I
    //   1097: invokestatic 718	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1100: invokestatic 722	com/tencent/mm/plugin/recordvideo/d/c:x	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1103: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1106: astore 5
    //   1108: ldc_w 726
    //   1111: invokestatic 731	java/lang/System:currentTimeMillis	()J
    //   1114: invokestatic 736	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1117: invokestatic 722	com/tencent/mm/plugin/recordvideo/d/c:x	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1120: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1123: astore 5
    //   1125: ldc_w 738
    //   1128: invokestatic 731	java/lang/System:currentTimeMillis	()J
    //   1131: invokestatic 736	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1134: invokestatic 722	com/tencent/mm/plugin/recordvideo/d/c:x	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1137: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1140: astore 5
    //   1142: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:eKX	()Lcom/tencent/mm/g/b/a/jf;
    //   1145: invokestatic 731	java/lang/System:currentTimeMillis	()J
    //   1148: invokevirtual 741	com/tencent/mm/g/b/a/jf:rx	(J)Lcom/tencent/mm/g/b/a/jf;
    //   1151: pop
    //   1152: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1155: astore 5
    //   1157: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:eKX	()Lcom/tencent/mm/g/b/a/jf;
    //   1160: astore 5
    //   1162: aload_1
    //   1163: getfield 259	com/tencent/mm/media/widget/camerarecordview/b/b:iqm	Ljava/util/ArrayList;
    //   1166: checkcast 743	java/util/Collection
    //   1169: astore 6
    //   1171: aload 6
    //   1173: ifnull +13 -> 1186
    //   1176: aload 6
    //   1178: invokeinterface 744 1 0
    //   1183: ifeq +530 -> 1713
    //   1186: iconst_1
    //   1187: istore_2
    //   1188: iload_2
    //   1189: ifne +529 -> 1718
    //   1192: lconst_1
    //   1193: lstore_3
    //   1194: aload 5
    //   1196: lload_3
    //   1197: invokevirtual 747	com/tencent/mm/g/b/a/jf:rI	(J)Lcom/tencent/mm/g/b/a/jf;
    //   1200: pop
    //   1201: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1204: astore 5
    //   1206: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:eKX	()Lcom/tencent/mm/g/b/a/jf;
    //   1209: aload_1
    //   1210: getfield 259	com/tencent/mm/media/widget/camerarecordview/b/b:iqm	Ljava/util/ArrayList;
    //   1213: invokevirtual 748	java/util/ArrayList:size	()I
    //   1216: i2l
    //   1217: invokevirtual 751	com/tencent/mm/g/b/a/jf:rJ	(J)Lcom/tencent/mm/g/b/a/jf;
    //   1220: pop
    //   1221: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1224: astore 5
    //   1226: invokestatic 755	com/tencent/mm/plugin/recordvideo/d/c:eKY	()Lcom/tencent/mm/g/b/a/jq;
    //   1229: astore 5
    //   1231: aload_1
    //   1232: getfield 259	com/tencent/mm/media/widget/camerarecordview/b/b:iqm	Ljava/util/ArrayList;
    //   1235: checkcast 743	java/util/Collection
    //   1238: astore 6
    //   1240: aload 6
    //   1242: ifnull +13 -> 1255
    //   1245: aload 6
    //   1247: invokeinterface 744 1 0
    //   1252: ifeq +473 -> 1725
    //   1255: iconst_1
    //   1256: istore_2
    //   1257: iload_2
    //   1258: ifne +472 -> 1730
    //   1261: lconst_1
    //   1262: lstore_3
    //   1263: aload 5
    //   1265: lload_3
    //   1266: invokevirtual 761	com/tencent/mm/g/b/a/jq:sK	(J)Lcom/tencent/mm/g/b/a/jq;
    //   1269: pop
    //   1270: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1273: astore 5
    //   1275: invokestatic 755	com/tencent/mm/plugin/recordvideo/d/c:eKY	()Lcom/tencent/mm/g/b/a/jq;
    //   1278: aload_1
    //   1279: getfield 259	com/tencent/mm/media/widget/camerarecordview/b/b:iqm	Ljava/util/ArrayList;
    //   1282: invokevirtual 748	java/util/ArrayList:size	()I
    //   1285: i2l
    //   1286: invokevirtual 764	com/tencent/mm/g/b/a/jq:sL	(J)Lcom/tencent/mm/g/b/a/jq;
    //   1289: pop
    //   1290: aload_1
    //   1291: getfield 767	com/tencent/mm/media/widget/camerarecordview/b/b:iqf	Z
    //   1294: ifeq +443 -> 1737
    //   1297: getstatic 773	com/tencent/mm/plugin/recordvideo/d/g:BXY	Lcom/tencent/mm/plugin/recordvideo/d/g;
    //   1300: astore 5
    //   1302: aload_1
    //   1303: getfield 415	com/tencent/mm/media/widget/camerarecordview/b/b:iqd	Ljava/lang/String;
    //   1306: invokestatic 776	com/tencent/mm/plugin/recordvideo/d/g:aLx	(Ljava/lang/String;)V
    //   1309: getstatic 773	com/tencent/mm/plugin/recordvideo/d/g:BXY	Lcom/tencent/mm/plugin/recordvideo/d/g;
    //   1312: astore 5
    //   1314: aload_1
    //   1315: getfield 779	com/tencent/mm/media/widget/camerarecordview/b/b:iqh	Ljava/lang/String;
    //   1318: invokestatic 782	com/tencent/mm/plugin/recordvideo/d/g:aLy	(Ljava/lang/String;)V
    //   1321: getstatic 773	com/tencent/mm/plugin/recordvideo/d/g:BXY	Lcom/tencent/mm/plugin/recordvideo/d/g;
    //   1324: astore_1
    //   1325: aload_0
    //   1326: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   1329: invokestatic 786	com/tencent/mm/plugin/recordvideo/d/g:setConfigProvider	(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V
    //   1332: aload_0
    //   1333: invokevirtual 253	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getCaptureInfo	()Lcom/tencent/mm/media/widget/camerarecordview/b/b;
    //   1336: astore_1
    //   1337: aload_1
    //   1338: ifnonnull +6 -> 1344
    //   1341: invokestatic 352	kotlin/g/b/p:hyc	()V
    //   1344: aload_1
    //   1345: getfield 767	com/tencent/mm/media/widget/camerarecordview/b/b:iqf	Z
    //   1348: ifne +35 -> 1383
    //   1351: aload_0
    //   1352: invokevirtual 356	com/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew:getConfigProvider	()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;
    //   1355: astore_1
    //   1356: aload_1
    //   1357: ifnull +395 -> 1752
    //   1360: aload_1
    //   1361: getfield 405	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   1364: istore_2
    //   1365: iload_2
    //   1366: ifle +17 -> 1383
    //   1369: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1372: astore_1
    //   1373: ldc_w 788
    //   1376: iconst_0
    //   1377: invokestatic 718	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1380: invokestatic 722	com/tencent/mm/plugin/recordvideo/d/c:x	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1383: ldc_w 303
    //   1386: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1389: return
    //   1390: aconst_null
    //   1391: astore 5
    //   1393: goto -1252 -> 141
    //   1396: iconst_0
    //   1397: istore_2
    //   1398: goto -1192 -> 206
    //   1401: aload 5
    //   1403: getfield 402	com/tencent/mm/plugin/recordvideo/e/d$a:height	I
    //   1406: aload 5
    //   1408: getfield 399	com/tencent/mm/plugin/recordvideo/e/d$a:width	I
    //   1411: if_icmple +8 -> 1419
    //   1414: iconst_1
    //   1415: istore_2
    //   1416: goto -1210 -> 206
    //   1419: iconst_0
    //   1420: istore_2
    //   1421: goto -1215 -> 206
    //   1424: aload 7
    //   1426: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1429: aload 7
    //   1431: invokevirtual 796	android/graphics/Bitmap:getHeight	()I
    //   1434: getstatic 802	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1437: invokestatic 806	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1440: astore 6
    //   1442: aload 7
    //   1444: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1447: aload 7
    //   1449: invokevirtual 796	android/graphics/Bitmap:getHeight	()I
    //   1452: imul
    //   1453: newarray int
    //   1455: astore 9
    //   1457: aload 7
    //   1459: aload 9
    //   1461: iconst_0
    //   1462: aload 7
    //   1464: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1467: iconst_0
    //   1468: iconst_0
    //   1469: aload 7
    //   1471: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1474: aload 7
    //   1476: invokevirtual 796	android/graphics/Bitmap:getHeight	()I
    //   1479: invokevirtual 810	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1482: aload 6
    //   1484: ldc_w 812
    //   1487: invokestatic 154	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1490: aload 6
    //   1492: aload 9
    //   1494: iconst_0
    //   1495: aload 6
    //   1497: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1500: iconst_0
    //   1501: iconst_0
    //   1502: aload 6
    //   1504: invokevirtual 793	android/graphics/Bitmap:getWidth	()I
    //   1507: aload 6
    //   1509: invokevirtual 796	android/graphics/Bitmap:getHeight	()I
    //   1512: invokevirtual 815	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   1515: goto -1251 -> 264
    //   1518: astore 7
    //   1520: aload 6
    //   1522: astore 5
    //   1524: aload 7
    //   1526: astore 6
    //   1528: ldc_w 459
    //   1531: aload 6
    //   1533: checkcast 817	java/lang/Throwable
    //   1536: ldc_w 819
    //   1539: iconst_0
    //   1540: anewarray 821	java/lang/Object
    //   1543: invokestatic 825	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1546: invokestatic 828	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   1549: ifle +21 -> 1570
    //   1552: aload 8
    //   1554: getfield 409	com/tencent/mm/plugin/recordvideo/plugin/q:context	Landroid/content/Context;
    //   1557: ldc_w 830
    //   1560: checkcast 165	java/lang/CharSequence
    //   1563: iconst_0
    //   1564: invokestatic 836	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   1567: invokevirtual 839	android/widget/Toast:show	()V
    //   1570: aload 8
    //   1572: aconst_null
    //   1573: putfield 435	com/tencent/mm/plugin/recordvideo/plugin/q:BQT	Landroid/graphics/Bitmap;
    //   1576: aload 5
    //   1578: ifnull -1276 -> 302
    //   1581: aload 5
    //   1583: invokevirtual 448	com/tencent/mm/ui/blur/e:destroy	()V
    //   1586: goto -1284 -> 302
    //   1589: astore_1
    //   1590: aconst_null
    //   1591: astore 5
    //   1593: aload 5
    //   1595: ifnull +8 -> 1603
    //   1598: aload 5
    //   1600: invokevirtual 448	com/tencent/mm/ui/blur/e:destroy	()V
    //   1603: ldc_w 303
    //   1606: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1609: aload_1
    //   1610: athrow
    //   1611: aload 8
    //   1613: aconst_null
    //   1614: putfield 435	com/tencent/mm/plugin/recordvideo/plugin/q:BQT	Landroid/graphics/Bitmap;
    //   1617: getstatic 141	com/tencent/mm/plugin/recordvideo/d/c:BXI	Lcom/tencent/mm/plugin/recordvideo/d/c;
    //   1620: astore 5
    //   1622: invokestatic 145	com/tencent/mm/plugin/recordvideo/d/c:eKX	()Lcom/tencent/mm/g/b/a/jf;
    //   1625: lconst_1
    //   1626: invokevirtual 453	com/tencent/mm/g/b/a/jf:rK	(J)Lcom/tencent/mm/g/b/a/jf;
    //   1629: pop
    //   1630: goto -1313 -> 317
    //   1633: sipush 10000
    //   1636: istore_2
    //   1637: goto -1251 -> 386
    //   1640: aconst_null
    //   1641: astore 5
    //   1643: goto -1170 -> 473
    //   1646: iconst_0
    //   1647: istore_2
    //   1648: goto -1110 -> 538
    //   1651: aload 5
    //   1653: getfield 402	com/tencent/mm/plugin/recordvideo/e/d$a:height	I
    //   1656: aload 5
    //   1658: getfield 399	com/tencent/mm/plugin/recordvideo/e/d$a:width	I
    //   1661: if_icmple +8 -> 1669
    //   1664: iconst_1
    //   1665: istore_2
    //   1666: goto -1128 -> 538
    //   1669: iconst_0
    //   1670: istore_2
    //   1671: goto -1133 -> 538
    //   1674: aload 6
    //   1676: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1679: iconst_1
    //   1680: invokevirtual 843	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setForceScaleFullScreen	(Z)V
    //   1683: aload 6
    //   1685: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1688: getstatic 846	com/tencent/mm/pluginsdk/ui/i$e:Kcc	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1691: invokevirtual 516	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1694: goto -1125 -> 569
    //   1697: aload 6
    //   1699: getfield 479	com/tencent/mm/plugin/recordvideo/plugin/s:zyd	Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;
    //   1702: aload 8
    //   1704: getfield 507	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:BOo	Lcom/tencent/mm/pluginsdk/ui/i$e;
    //   1707: invokevirtual 516	com/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView:setScaleType	(Lcom/tencent/mm/pluginsdk/ui/i$e;)V
    //   1710: goto -1141 -> 569
    //   1713: iconst_0
    //   1714: istore_2
    //   1715: goto -527 -> 1188
    //   1718: ldc2_w 449
    //   1721: lstore_3
    //   1722: goto -528 -> 1194
    //   1725: iconst_0
    //   1726: istore_2
    //   1727: goto -470 -> 1257
    //   1730: ldc2_w 449
    //   1733: lstore_3
    //   1734: goto -471 -> 1263
    //   1737: getstatic 773	com/tencent/mm/plugin/recordvideo/d/g:BXY	Lcom/tencent/mm/plugin/recordvideo/d/g;
    //   1740: astore 5
    //   1742: aload_1
    //   1743: getfield 415	com/tencent/mm/media/widget/camerarecordview/b/b:iqd	Ljava/lang/String;
    //   1746: invokestatic 849	com/tencent/mm/plugin/recordvideo/d/g:aLz	(Ljava/lang/String;)V
    //   1749: goto -428 -> 1321
    //   1752: iconst_0
    //   1753: istore_2
    //   1754: goto -389 -> 1365
    //   1757: ldc_w 303
    //   1760: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1763: return
    //   1764: astore_1
    //   1765: goto -172 -> 1593
    //   1768: astore_1
    //   1769: goto -176 -> 1593
    //   1772: astore 6
    //   1774: goto -246 -> 1528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1777	0	this	EditorVideoPluginLayoutNew
    //   0	1777	1	paramb	b
    //   205	1549	2	i	int
    //   83	1651	3	l	long
    //   34	1707	5	localObject1	Object
    //   108	1590	6	localObject2	Object
    //   1772	1	6	localException1	java.lang.Exception
    //   94	1381	7	localObject3	Object
    //   1518	7	7	localException2	java.lang.Exception
    //   88	1615	8	localObject4	Object
    //   1455	38	9	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   222	236	1518	java/lang/Exception
    //   222	236	1589	finally
    //   236	256	1764	finally
    //   269	297	1764	finally
    //   1424	1515	1764	finally
    //   1528	1570	1768	finally
    //   1570	1576	1768	finally
    //   236	256	1772	java/lang/Exception
    //   269	297	1772	java/lang/Exception
    //   1424	1515	1772	java/lang/Exception
  }
  
  public void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(75774);
    kotlin.g.b.p.h(paramc, "status");
    if (paramc != d.c.BVq) {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + paramc + " ,param : " + paramBundle);
    }
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      if (paramc != d.c.BVq) {
        Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(paramc)));
      }
      super.a(paramc, paramBundle);
      AppMethodBeat.o(75774);
      return;
    }
    paramc = getBgPlugin().eKD();
    getPreviewPlugin().release();
    getItemContainerPlugin().onPause();
    getAddMusicPlugin().onPause();
    int i = 0;
    if (getMoreMenuPlugin().BQn) {
      i = 1;
    }
    paramBundle = CaptureDataManager.BOb;
    kotlin.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
    paramBundle.getExtData().putInt("key_extra_feature_flag", i);
    if (getMoreMenuPlugin().bxP == 2)
    {
      paramBundle = CaptureDataManager.BOb;
      kotlin.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
      boolean bool = getAddMusicPlugin().wgL.getMuteOrigin();
      paramBundle = getAddMusicPlugin().wgG;
      ArrayList localArrayList1 = com.tencent.mm.plugin.recordvideo.plugin.h.a(getItemContainerPlugin());
      ArrayList localArrayList2 = getItemContainerPlugin().getEditorDataList();
      float[] arrayOfFloat = getItemContainerPlugin().eKr();
      i = getPreviewPlugin().dvv;
      int j = getPreviewPlugin().iqg;
      ArrayList localArrayList3 = new ArrayList();
      getItemContainerPlugin();
      paramc = new com.tencent.mm.plugin.recordvideo.b.f(bool, paramBundle, localArrayList1, localArrayList2, arrayOfFloat, i, j, localArrayList3, paramc, com.tencent.mm.plugin.recordvideo.plugin.h.eKs());
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(paramc)));
      paramBundle = com.tencent.mm.plugin.recordvideo.d.g.BXY;
      j = getItemContainerPlugin().eKu();
      int k = getItemContainerPlugin().eKv();
      if (getAddMusicPlugin().wgG != null) {
        break label629;
      }
      i = 0;
      label374:
      com.tencent.mm.plugin.recordvideo.d.g.J(new int[] { j, k, i });
      getReMuxPlugin().a(paramc);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKu()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKv()));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      if (getAddMusicPlugin().wgG != null) {
        break label634;
      }
      i = 0;
      label458:
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      if (!getAddMusicPlugin().wgL.getMuteOrigin()) {
        break label639;
      }
      i = 0;
      label487:
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i));
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(1));
      eKS();
      eKT();
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.VI(13);
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKX().ry(System.currentTimeMillis());
      paramc = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      paramc = getConfigProvider();
      if (paramc == null) {
        break label644;
      }
    }
    label644:
    for (i = paramc.scene;; i = 0)
    {
      com.tencent.mm.plugin.recordvideo.d.c.VJ(i);
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
      paramc = com.tencent.mm.plugin.recordvideo.model.audio.c.eKi();
      if (paramc == null) {
        break label649;
      }
      paramc.eKe();
      AppMethodBeat.o(75774);
      return;
      if (getMoreMenuPlugin().bxP != 3) {
        break;
      }
      paramBundle = CaptureDataManager.BOb;
      kotlin.g.b.p.g(paramBundle, "CaptureDataManager.INSTANCE");
      paramBundle.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
      break;
      label629:
      i = 1;
      break label374;
      label634:
      i = 1;
      break label458;
      label639:
      i = 1;
      break label487;
    }
    label649:
    AppMethodBeat.o(75774);
  }
  
  public View getPlayerView()
  {
    AppMethodBeat.i(75772);
    Object localObject = new EditorVideoPlayView(getContext());
    Log.i("MicroMsg.EditorVideoPluginLayoutNew", "playerView :".concat(String.valueOf(localObject)));
    setPreviewPlugin(new com.tencent.mm.plugin.recordvideo.plugin.s((VideoPlayerTextureView)localObject, (d)this, (TextView)findViewById(2131309744)));
    getPluginList().add(getPreviewPlugin());
    localObject = (View)localObject;
    AppMethodBeat.o(75772);
    return localObject;
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75775);
    Object localObject1;
    int j;
    int i;
    if (!super.onBackPress())
    {
      Log.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", Integer.valueOf(0));
      localObject1 = ((Iterable)getItemContainerPlugin().BQh.getAllItemViews()).iterator();
      j = 0;
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.g)((Iterator)localObject1).next();
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
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKY().ahN();
        }
        else if ((!(localObject2 instanceof m)) && ((localObject2 instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s)))
        {
          localObject2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.eKY().ahP();
        }
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.eKY();
      if (!getMoreMenuPlugin().BQn) {
        break label295;
      }
    }
    label295:
    for (long l = 1L;; l = 0L)
    {
      ((jq)localObject1).sJ(l);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKY().sF(i);
      localObject1 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
      com.tencent.mm.plugin.recordvideo.d.c.eKY().sG(j);
      localObject1 = getCaptureInfo();
      if ((localObject1 != null) && (((b)localObject1).iqf == true)) {
        com.tencent.f.h.RTc.aX((Runnable)new b(this));
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(EditorVideoPluginLayoutNew paramEditorVideoPluginLayoutNew) {}
    
    public final void run()
    {
      Object localObject2 = null;
      AppMethodBeat.i(169939);
      Object localObject1 = this.BUo.getCaptureInfo();
      if (localObject1 != null) {}
      for (localObject1 = ((b)localObject1).iqh;; localObject1 = null)
      {
        com.tencent.mm.vfs.s.deleteFile((String)localObject1);
        b localb = this.BUo.getCaptureInfo();
        localObject1 = localObject2;
        if (localb != null) {
          localObject1 = localb.iqd;
        }
        com.tencent.mm.vfs.s.deleteFile((String)localObject1);
        AppMethodBeat.o(169939);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
 * JD-Core Version:    0.7.0.1
 */