package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "bgView", "Landroid/widget/ImageView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/widget/ImageView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "getBgView", "()Landroid/widget/ImageView;", "setBgView", "(Landroid/widget/ImageView;)V", "blurBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "initLogic", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "release", "reset", "saveBgBitmap", "setBlackBg", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  implements v
{
  public ImageView Esh;
  private Bitmap NKD;
  private String TAG;
  private Context context;
  
  public s(ImageView paramImageView, a parama)
  {
    AppMethodBeat.i(75578);
    this.Esh = paramImageView;
    this.TAG = "MicroMsg.EditVideoBgPlugin";
    this.context = this.Esh.getContext();
    AppMethodBeat.o(75578);
  }
  
  /* Error */
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, RecordConfigProvider paramRecordConfigProvider)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: ldc 90
    //   10: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   13: aload_1
    //   14: ldc 91
    //   16: invokestatic 56	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 73	com/tencent/mm/plugin/recordvideo/plugin/s:TAG	Ljava/lang/String;
    //   23: ldc 92
    //   25: invokestatic 97	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_2
    //   29: ifnonnull +161 -> 190
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: ifeq +363 -> 400
    //   40: getstatic 103	com/tencent/mm/plugin/recordvideo/util/g:Obu	Lcom/tencent/mm/plugin/recordvideo/util/g;
    //   43: astore 7
    //   45: aload_1
    //   46: invokevirtual 109	com/tencent/mm/media/widget/camerarecordview/b/b:bug	()Ljava/lang/String;
    //   49: invokestatic 113	com/tencent/mm/plugin/recordvideo/util/g:aTF	(Ljava/lang/String;)Lcom/tencent/mm/plugin/recordvideo/util/g$a;
    //   52: astore 7
    //   54: aload 7
    //   56: ifnull +344 -> 400
    //   59: aload 7
    //   61: getfield 119	com/tencent/mm/plugin/recordvideo/util/g$a:hYK	I
    //   64: ifeq +14 -> 78
    //   67: aload 7
    //   69: getfield 119	com/tencent/mm/plugin/recordvideo/util/g$a:hYK	I
    //   72: sipush 180
    //   75: if_icmpne +135 -> 210
    //   78: aload 7
    //   80: getfield 122	com/tencent/mm/plugin/recordvideo/util/g$a:width	I
    //   83: aload 7
    //   85: getfield 125	com/tencent/mm/plugin/recordvideo/util/g$a:height	I
    //   88: if_icmple +117 -> 205
    //   91: iload_3
    //   92: ifeq +292 -> 384
    //   95: aload_2
    //   96: getfield 130	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:scene	I
    //   99: iconst_3
    //   100: if_icmpne +284 -> 384
    //   103: new 132	com/tencent/mm/ui/blur/e
    //   106: dup
    //   107: aload_0
    //   108: getfield 81	com/tencent/mm/plugin/recordvideo/plugin/s:context	Landroid/content/Context;
    //   111: invokespecial 135	com/tencent/mm/ui/blur/e:<init>	(Landroid/content/Context;)V
    //   114: astore_2
    //   115: aload_1
    //   116: getfield 138	com/tencent/mm/media/widget/camerarecordview/b/b:nJU	Ljava/lang/String;
    //   119: aload_1
    //   120: getfield 141	com/tencent/mm/media/widget/camerarecordview/b/b:startTime	I
    //   123: i2l
    //   124: ldc2_w 142
    //   127: lmul
    //   128: invokestatic 149	com/tencent/mm/plugin/mmsight/d:bl	(Ljava/lang/String;J)Landroid/graphics/Bitmap;
    //   131: astore 6
    //   133: aload 6
    //   135: ifnonnull +93 -> 228
    //   138: aload 5
    //   140: astore_1
    //   141: aload_1
    //   142: ifnull +25 -> 167
    //   145: aload_0
    //   146: aload_2
    //   147: aload_1
    //   148: ldc 150
    //   150: invokevirtual 154	com/tencent/mm/ui/blur/e:c	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   153: putfield 156	com/tencent/mm/plugin/recordvideo/plugin/s:NKD	Landroid/graphics/Bitmap;
    //   156: aload_0
    //   157: getfield 69	com/tencent/mm/plugin/recordvideo/plugin/s:Esh	Landroid/widget/ImageView;
    //   160: aload_0
    //   161: getfield 156	com/tencent/mm/plugin/recordvideo/plugin/s:NKD	Landroid/graphics/Bitmap;
    //   164: invokevirtual 160	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   167: aload_2
    //   168: invokevirtual 163	com/tencent/mm/ui/blur/e:destroy	()V
    //   171: getstatic 169	com/tencent/mm/plugin/recordvideo/f/c:NRf	Lcom/tencent/mm/plugin/recordvideo/f/c;
    //   174: astore_1
    //   175: invokestatic 173	com/tencent/mm/plugin/recordvideo/f/c:gJf	()Lcom/tencent/mm/autogen/mmdata/rpt/oo;
    //   178: ldc2_w 174
    //   181: putfield 181	com/tencent/mm/autogen/mmdata/rpt/oo:jjP	J
    //   184: ldc 90
    //   186: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: aload_2
    //   191: getfield 185	com/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider:NHU	Ljava/lang/Boolean;
    //   194: getstatic 190	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   197: invokestatic 194	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   200: istore 4
    //   202: goto -167 -> 35
    //   205: iconst_0
    //   206: istore_3
    //   207: goto -116 -> 91
    //   210: aload 7
    //   212: getfield 125	com/tencent/mm/plugin/recordvideo/util/g$a:height	I
    //   215: aload 7
    //   217: getfield 122	com/tencent/mm/plugin/recordvideo/util/g$a:width	I
    //   220: if_icmpgt -129 -> 91
    //   223: iconst_0
    //   224: istore_3
    //   225: goto -134 -> 91
    //   228: aload 6
    //   230: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   233: aload 6
    //   235: invokevirtual 203	android/graphics/Bitmap:getHeight	()I
    //   238: getstatic 209	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   241: invokestatic 213	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   244: astore_1
    //   245: aload 6
    //   247: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   250: aload 6
    //   252: invokevirtual 203	android/graphics/Bitmap:getHeight	()I
    //   255: imul
    //   256: newarray int
    //   258: astore 5
    //   260: aload 6
    //   262: aload 5
    //   264: iconst_0
    //   265: aload 6
    //   267: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   270: iconst_0
    //   271: iconst_0
    //   272: aload 6
    //   274: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   277: aload 6
    //   279: invokevirtual 203	android/graphics/Bitmap:getHeight	()I
    //   282: invokevirtual 217	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   285: aload_1
    //   286: aload 5
    //   288: iconst_0
    //   289: aload_1
    //   290: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   293: iconst_0
    //   294: iconst_0
    //   295: aload_1
    //   296: invokevirtual 200	android/graphics/Bitmap:getWidth	()I
    //   299: aload_1
    //   300: invokevirtual 203	android/graphics/Bitmap:getHeight	()I
    //   303: invokevirtual 220	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   306: goto -165 -> 141
    //   309: astore_2
    //   310: aload 6
    //   312: astore_1
    //   313: ldc 222
    //   315: aload_2
    //   316: checkcast 224	java/lang/Throwable
    //   319: ldc 226
    //   321: iconst_0
    //   322: anewarray 4	java/lang/Object
    //   325: invokestatic 230	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:getLogLevel	()I
    //   331: ifle +19 -> 350
    //   334: aload_0
    //   335: getfield 81	com/tencent/mm/plugin/recordvideo/plugin/s:context	Landroid/content/Context;
    //   338: ldc 235
    //   340: checkcast 237	java/lang/CharSequence
    //   343: iconst_0
    //   344: invokestatic 243	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   347: invokevirtual 246	android/widget/Toast:show	()V
    //   350: aload_0
    //   351: aconst_null
    //   352: putfield 156	com/tencent/mm/plugin/recordvideo/plugin/s:NKD	Landroid/graphics/Bitmap;
    //   355: aload_1
    //   356: ifnull -185 -> 171
    //   359: aload_1
    //   360: invokevirtual 163	com/tencent/mm/ui/blur/e:destroy	()V
    //   363: goto -192 -> 171
    //   366: astore_1
    //   367: aconst_null
    //   368: astore_2
    //   369: aload_2
    //   370: ifnull +7 -> 377
    //   373: aload_2
    //   374: invokevirtual 163	com/tencent/mm/ui/blur/e:destroy	()V
    //   377: ldc 90
    //   379: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload_1
    //   383: athrow
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 156	com/tencent/mm/plugin/recordvideo/plugin/s:NKD	Landroid/graphics/Bitmap;
    //   389: getstatic 169	com/tencent/mm/plugin/recordvideo/f/c:NRf	Lcom/tencent/mm/plugin/recordvideo/f/c;
    //   392: astore_1
    //   393: invokestatic 173	com/tencent/mm/plugin/recordvideo/f/c:gJf	()Lcom/tencent/mm/autogen/mmdata/rpt/oo;
    //   396: lconst_1
    //   397: putfield 181	com/tencent/mm/autogen/mmdata/rpt/oo:jjP	J
    //   400: ldc 90
    //   402: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: return
    //   406: astore_1
    //   407: goto -38 -> 369
    //   410: astore 5
    //   412: aload_1
    //   413: astore_2
    //   414: aload 5
    //   416: astore_1
    //   417: goto -48 -> 369
    //   420: astore 5
    //   422: aload_2
    //   423: astore_1
    //   424: aload 5
    //   426: astore_2
    //   427: goto -114 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	s
    //   0	430	1	paramb	com.tencent.mm.media.widget.camerarecordview.b.b
    //   0	430	2	paramRecordConfigProvider	RecordConfigProvider
    //   1	224	3	i	int
    //   33	168	4	bool	boolean
    //   6	281	5	arrayOfInt	int[]
    //   410	5	5	localObject1	Object
    //   420	5	5	localException	java.lang.Exception
    //   3	308	6	localBitmap	Bitmap
    //   43	173	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   103	115	309	java/lang/Exception
    //   103	115	366	finally
    //   115	133	406	finally
    //   145	167	406	finally
    //   228	306	406	finally
    //   313	350	410	finally
    //   350	355	410	finally
    //   115	133	420	java/lang/Exception
    //   145	167	420	java/lang/Exception
    //   228	306	420	java/lang/Exception
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280767);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280767);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280797);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280797);
  }
  
  public final String gID()
  {
    AppMethodBeat.i(163434);
    if (this.NKD != null)
    {
      Object localObject = f.Obq;
      localObject = f.aTA(String.valueOf(System.currentTimeMillis()));
      BitmapUtil.saveBitmapToImage(this.NKD, 100, Bitmap.CompressFormat.JPEG, (String)localObject, false);
      AppMethodBeat.o(163434);
      return localObject;
    }
    AppMethodBeat.o(163434);
    return null;
  }
  
  public final String name()
  {
    AppMethodBeat.i(280778);
    String str = v.a.b(this);
    AppMethodBeat.o(280778);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280787);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280787);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(280808);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280808);
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280817);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280817);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280826);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280826);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280833);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280833);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280841);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280841);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75577);
    kotlin.g.b.s.u((v)this, "this");
    Bitmap localBitmap = this.NKD;
    if ((localBitmap != null) && (!localBitmap.isRecycled())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localBitmap = this.NKD;
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        this.NKD = null;
      }
      AppMethodBeat.o(75577);
      return;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75576);
    kotlin.g.b.s.u((v)this, "this");
    this.Esh.setBackgroundColor(this.Esh.getContext().getResources().getColor(b.b.transparent));
    AppMethodBeat.o(75576);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(280848);
    kotlin.g.b.s.u(this, "this");
    AppMethodBeat.o(280848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.s
 * JD-Core Version:    0.7.0.1
 */