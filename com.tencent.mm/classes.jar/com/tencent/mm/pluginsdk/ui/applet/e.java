package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", "contentType", "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"})
public final class e
  implements com.tencent.mm.av.a.c.a
{
  public static final e.a FnC;
  private long FnA;
  private long FnB;
  private long Fny;
  private long Fnz;
  private String contentType;
  private int from;
  private String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124838);
    FnC = new e.a((byte)0);
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
  
  private final boolean ffX()
  {
    AppMethodBeat.i(124836);
    if (this.from == 2)
    {
      g localg = g.FnF;
      if (g.Zu(this.scene))
      {
        AppMethodBeat.o(124836);
        return true;
      }
    }
    AppMethodBeat.o(124836);
    return false;
  }
  
  public final void Gn(String paramString)
  {
    AppMethodBeat.i(124832);
    this.url = paramString;
    this.Fny = System.currentTimeMillis();
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      ae.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
      com.tencent.mm.pluginsdk.model.a.cJ(5, paramString);
    }
    AppMethodBeat.o(124832);
  }
  
  public final void K(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(124835);
    this.FnB = System.currentTimeMillis();
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
      com.tencent.mm.pluginsdk.model.a.cK(6, this.url);
    }
    if (ffX())
    {
      String str = this.id;
      long l1 = this.FnB;
      long l2 = this.FnA;
      if (paramBitmap != null) {
        break label211;
      }
      bool1 = true;
      if (paramBitmap == null) {
        break label216;
      }
      localObject = Boolean.valueOf(paramBitmap.isRecycled());
      label87:
      ae.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeEnd id: %s, decode cost: %d ms, bitmap == null: %b, recycled: %s", new Object[] { str, Long.valueOf(l1 - l2), Boolean.valueOf(bool1), localObject });
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label222;
      }
    }
    label211:
    label216:
    label222:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBitmap = f.FnD;
      f.cF(this.contentType, bool1);
      paramBitmap = f.FnD;
      f.bR(this.contentType, this.FnB - this.FnA);
      paramBitmap = g.FnF;
      if ((g.aOi(this.contentType)) && (!bool1))
      {
        paramBitmap = f.FnD;
        f.aJ(this.url, 2, this.scene);
      }
      AppMethodBeat.o(124835);
      return;
      bool1 = false;
      break;
      localObject = null;
      break label87;
    }
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
      this.FnA = System.currentTimeMillis();
      paramb = g.FnF;
      if (g.Zv(this.scene))
      {
        ae.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
        paramb = com.tencent.mm.pluginsdk.model.a.Fdw;
        com.tencent.mm.pluginsdk.model.a.cJ(6, paramString);
      }
      if (ffX())
      {
        ae.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", new Object[] { this.id, this.contentType, paramString });
        paramString = f.FnD;
        f.aOf(this.contentType);
      }
      AppMethodBeat.o(124834);
      return;
      str = null;
      break;
    }
  }
  
  public final void aJw()
  {
    AppMethodBeat.i(124833);
    this.Fnz = System.currentTimeMillis();
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      ae.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.Fdw;
      com.tencent.mm.pluginsdk.model.a.cK(5, this.url);
    }
    AppMethodBeat.o(124833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */