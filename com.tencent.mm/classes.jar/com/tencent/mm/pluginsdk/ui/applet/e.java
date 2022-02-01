package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", "contentType", "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"})
public final class e
  implements com.tencent.mm.aw.a.c.a
{
  public static final e.a BXN;
  private long BXJ;
  private long BXK;
  private long BXL;
  private long BXM;
  private String bxn;
  private int from;
  private String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124838);
    BXN = new e.a((byte)0);
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
  
  private final boolean exQ()
  {
    AppMethodBeat.i(124836);
    if (this.from == 2)
    {
      g localg = g.BXQ;
      if (g.UI(this.scene))
      {
        AppMethodBeat.o(124836);
        return true;
      }
    }
    AppMethodBeat.o(124836);
    return false;
  }
  
  public final void J(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(124835);
    this.BXM = System.currentTimeMillis();
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.BOa;
      com.tencent.mm.pluginsdk.model.a.cA(6, this.url);
    }
    if (exQ())
    {
      String str = this.id;
      long l1 = this.BXM;
      long l2 = this.BXL;
      if (paramBitmap != null) {
        break label211;
      }
      bool1 = true;
      if (paramBitmap == null) {
        break label216;
      }
      localObject = Boolean.valueOf(paramBitmap.isRecycled());
      label87:
      ad.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeEnd id: %s, decode cost: %d ms, bitmap == null: %b, recycled: %s", new Object[] { str, Long.valueOf(l1 - l2), Boolean.valueOf(bool1), localObject });
      if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
        break label222;
      }
    }
    label211:
    label216:
    label222:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramBitmap = f.BXO;
      f.cq(this.bxn, bool1);
      paramBitmap = f.BXO;
      f.bK(this.bxn, this.BXM - this.BXL);
      paramBitmap = g.BXQ;
      if ((g.aBR(this.bxn)) && (!bool1))
      {
        paramBitmap = f.BXO;
        f.aA(this.url, 2, this.scene);
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
      str = paramb.bxn;
      this.bxn = str;
      if (paramb == null) {
        break label152;
      }
    }
    label152:
    for (int i = paramb.from;; i = -1)
    {
      this.from = i;
      this.BXL = System.currentTimeMillis();
      paramb = g.BXQ;
      if (g.UJ(this.scene))
      {
        ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
        paramb = com.tencent.mm.pluginsdk.model.a.BOa;
        com.tencent.mm.pluginsdk.model.a.cz(6, paramString);
      }
      if (exQ())
      {
        ad.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", new Object[] { this.id, this.bxn, paramString });
        paramString = f.BXO;
        f.aBO(this.bxn);
      }
      AppMethodBeat.o(124834);
      return;
      str = null;
      break;
    }
  }
  
  public final void aze()
  {
    AppMethodBeat.i(124833);
    this.BXK = System.currentTimeMillis();
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.BOa;
      com.tencent.mm.pluginsdk.model.a.cA(5, this.url);
    }
    AppMethodBeat.o(124833);
  }
  
  public final void yC(String paramString)
  {
    AppMethodBeat.i(124832);
    this.url = paramString;
    this.BXJ = System.currentTimeMillis();
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.BOa;
      com.tencent.mm.pluginsdk.model.a.cz(5, paramString);
    }
    AppMethodBeat.o(124832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */