package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.a;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", "contentType", "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements a
{
  public static final e.a Ybj;
  private long Ybk;
  private long Ybl;
  private long Ybm;
  private long Ybn;
  private String contentType;
  private int from;
  private String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124838);
    Ybj = new e.a((byte)0);
    AppMethodBeat.o(124838);
  }
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    AppMethodBeat.i(124837);
    this.from = -1;
    this.id = "";
    this.url = "";
    this.scene = paramInt;
    this.id = String.valueOf(hashCode());
    AppMethodBeat.o(124837);
  }
  
  private final boolean iKW()
  {
    AppMethodBeat.i(124836);
    if (this.from == 2)
    {
      g localg = g.Ybp;
      if (g.awl(this.scene))
      {
        AppMethodBeat.o(124836);
        return true;
      }
    }
    AppMethodBeat.o(124836);
    return false;
  }
  
  public final void Ow(String paramString)
  {
    AppMethodBeat.i(124832);
    this.url = paramString;
    this.Ybk = System.currentTimeMillis();
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.e.XQp;
      com.tencent.mm.pluginsdk.model.e.dV(5, paramString);
    }
    AppMethodBeat.o(124832);
  }
  
  public final void T(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(124835);
    this.Ybn = System.currentTimeMillis();
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      localObject = com.tencent.mm.pluginsdk.model.e.XQp;
      com.tencent.mm.pluginsdk.model.e.dW(6, this.url);
    }
    if (iKW())
    {
      String str = this.id;
      long l1 = this.Ybn;
      long l2 = this.Ybm;
      if (paramBitmap != null) {
        break label205;
      }
      bool1 = true;
      if (paramBitmap != null) {
        break label210;
      }
      localObject = null;
      label81:
      Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeEnd id: %s, decode cost: %d ms, bitmap == null: %b, recycled: %s", new Object[] { str, Long.valueOf(l1 - l2), Boolean.valueOf(bool1), localObject });
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label222;
      }
    }
    label205:
    label210:
    label222:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBitmap = f.Ybo;
      f.dX(this.contentType, bool1);
      paramBitmap = f.Ybo;
      f.cl(this.contentType, this.Ybn - this.Ybm);
      paramBitmap = g.Ybp;
      if ((g.bqU(this.contentType)) && (!bool1))
      {
        paramBitmap = f.Ybo;
        f.aV(this.url, 2, this.scene);
      }
      AppMethodBeat.o(124835);
      return;
      bool1 = false;
      break;
      localObject = Boolean.valueOf(paramBitmap.isRecycled());
      break label81;
    }
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(124834);
    String str;
    if (paramb == null)
    {
      str = null;
      this.contentType = str;
      if (paramb != null) {
        break label149;
      }
    }
    label149:
    for (int i = -1;; i = paramb.from)
    {
      this.from = i;
      this.Ybm = System.currentTimeMillis();
      paramb = g.Ybp;
      if (g.awm(this.scene))
      {
        Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
        paramb = com.tencent.mm.pluginsdk.model.e.XQp;
        com.tencent.mm.pluginsdk.model.e.dV(6, paramString);
      }
      if (iKW())
      {
        Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", new Object[] { this.id, this.contentType, paramString });
        paramString = f.Ybo;
        f.bqR(this.contentType);
      }
      AppMethodBeat.o(124834);
      return;
      str = paramb.contentType;
      break;
    }
  }
  
  public final void bKA()
  {
    AppMethodBeat.i(124833);
    this.Ybl = System.currentTimeMillis();
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.e.XQp;
      com.tencent.mm.pluginsdk.model.e.dW(5, this.url);
    }
    AppMethodBeat.o(124833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */