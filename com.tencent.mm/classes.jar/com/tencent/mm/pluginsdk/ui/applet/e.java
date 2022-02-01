package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", "contentType", "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"})
public final class e
  implements com.tencent.mm.av.a.c.a
{
  public static final e.a Kes;
  private long Keo;
  private long Kep;
  private long Keq;
  private long Ker;
  private String contentType;
  private int from;
  private String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124838);
    Kes = new e.a((byte)0);
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
  
  private final boolean gpg()
  {
    AppMethodBeat.i(124836);
    if (this.from == 2)
    {
      g localg = g.Kev;
      if (g.aif(this.scene))
      {
        AppMethodBeat.o(124836);
        return true;
      }
    }
    AppMethodBeat.o(124836);
    return false;
  }
  
  public final void N(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(124835);
    this.Ker = System.currentTimeMillis();
    Object localObject = g.Kev;
    if (g.aig(this.scene))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.JUl;
      com.tencent.mm.pluginsdk.model.a.de(6, this.url);
    }
    if (gpg())
    {
      String str = this.id;
      long l1 = this.Ker;
      long l2 = this.Keq;
      if (paramBitmap != null) {
        break label211;
      }
      bool1 = true;
      if (paramBitmap == null) {
        break label216;
      }
      localObject = Boolean.valueOf(paramBitmap.isRecycled());
      label87:
      Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeEnd id: %s, decode cost: %d ms, bitmap == null: %b, recycled: %s", new Object[] { str, Long.valueOf(l1 - l2), Boolean.valueOf(bool1), localObject });
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label222;
      }
    }
    label211:
    label216:
    label222:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBitmap = f.Ket;
      f.da(this.contentType, bool1);
      paramBitmap = f.Ket;
      f.bS(this.contentType, this.Ker - this.Keq);
      paramBitmap = g.Kev;
      if ((g.beK(this.contentType)) && (!bool1))
      {
        paramBitmap = f.Ket;
        f.aL(this.url, 2, this.scene);
      }
      AppMethodBeat.o(124835);
      return;
      bool1 = false;
      break;
      localObject = null;
      break label87;
    }
  }
  
  public final void OZ(String paramString)
  {
    AppMethodBeat.i(124832);
    this.url = paramString;
    this.Keo = System.currentTimeMillis();
    Object localObject = g.Kev;
    if (g.aig(this.scene))
    {
      Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.JUl;
      com.tencent.mm.pluginsdk.model.a.dd(5, paramString);
    }
    AppMethodBeat.o(124832);
  }
  
  public final void a(String paramString, b paramb)
  {
    AppMethodBeat.i(124834);
    String str;
    if (paramb != null)
    {
      str = paramb.contentType;
      this.contentType = str;
      if (paramb == null) {
        break label152;
      }
    }
    label152:
    for (int i = paramb.from;; i = -1)
    {
      this.from = i;
      this.Keq = System.currentTimeMillis();
      paramb = g.Kev;
      if (g.aig(this.scene))
      {
        Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
        paramb = com.tencent.mm.pluginsdk.model.a.JUl;
        com.tencent.mm.pluginsdk.model.a.dd(6, paramString);
      }
      if (gpg())
      {
        Log.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", new Object[] { this.id, this.contentType, paramString });
        paramString = f.Ket;
        f.beH(this.contentType);
      }
      AppMethodBeat.o(124834);
      return;
      str = null;
      break;
    }
  }
  
  public final void bdx()
  {
    AppMethodBeat.i(124833);
    this.Kep = System.currentTimeMillis();
    Object localObject = g.Kev;
    if (g.aig(this.scene))
    {
      Log.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.JUl;
      com.tencent.mm.pluginsdk.model.a.de(5, this.url);
    }
    AppMethodBeat.o(124833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */