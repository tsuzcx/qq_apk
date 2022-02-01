package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageDecodeListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageDecodeListener;", "()V", "scene", "", "(I)V", "contentType", "", "decodeEnd", "", "decodeStart", "from", "id", "readFileEnd", "readFileStart", "url", "canReport", "", "onDecodeEnd", "", "bitmap", "Landroid/graphics/Bitmap;", "onDecodeStart", "response", "Lcom/tencent/mm/modelimage/loader/model/Response;", "onReadLocalFileEnd", "inputStream", "Ljava/io/InputStream;", "onReadLocalFileStart", "Companion", "plugin-biz_release"})
public final class e
  implements com.tencent.mm.aw.a.c.a
{
  public static final e.a EVh;
  private long EVd;
  private long EVe;
  private long EVf;
  private long EVg;
  private String contentType;
  private int from;
  private String id;
  private int scene;
  private String url;
  
  static
  {
    AppMethodBeat.i(124838);
    EVh = new e.a((byte)0);
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
  
  private final boolean fcj()
  {
    AppMethodBeat.i(124836);
    if (this.from == 2)
    {
      g localg = g.EVk;
      if (g.YO(this.scene))
      {
        AppMethodBeat.o(124836);
        return true;
      }
    }
    AppMethodBeat.o(124836);
    return false;
  }
  
  public final void FL(String paramString)
  {
    AppMethodBeat.i(124832);
    this.url = paramString;
    this.EVd = System.currentTimeMillis();
    Object localObject = g.EVk;
    if (g.YP(this.scene))
    {
      ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.EKY;
      com.tencent.mm.pluginsdk.model.a.cJ(5, paramString);
    }
    AppMethodBeat.o(124832);
  }
  
  public final void J(Bitmap paramBitmap)
  {
    boolean bool2 = true;
    AppMethodBeat.i(124835);
    this.EVg = System.currentTimeMillis();
    Object localObject = g.EVk;
    if (g.YP(this.scene))
    {
      localObject = com.tencent.mm.pluginsdk.model.a.EKY;
      com.tencent.mm.pluginsdk.model.a.cK(6, this.url);
    }
    if (fcj())
    {
      String str = this.id;
      long l1 = this.EVg;
      long l2 = this.EVf;
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
      paramBitmap = f.EVi;
      f.cB(this.contentType, bool1);
      paramBitmap = f.EVi;
      f.bQ(this.contentType, this.EVg - this.EVf);
      paramBitmap = g.EVk;
      if ((g.aMM(this.contentType)) && (!bool1))
      {
        paramBitmap = f.EVi;
        f.aH(this.url, 2, this.scene);
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
      this.EVf = System.currentTimeMillis();
      paramb = g.EVk;
      if (g.YP(this.scene))
      {
        ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onDecodeStart id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
        paramb = com.tencent.mm.pluginsdk.model.a.EKY;
        com.tencent.mm.pluginsdk.model.a.cJ(6, paramString);
      }
      if (fcj())
      {
        ad.d("MicroMsg.BizImageDecodeListener", "alvinluo BizImage onDecodeStart id: %s, contentType: %s, url: %s", new Object[] { this.id, this.contentType, paramString });
        paramString = f.EVi;
        f.aMJ(this.contentType);
      }
      AppMethodBeat.o(124834);
      return;
      str = null;
      break;
    }
  }
  
  public final void aJe()
  {
    AppMethodBeat.i(124833);
    this.EVe = System.currentTimeMillis();
    Object localObject = g.EVk;
    if (g.YP(this.scene))
    {
      ad.v("MicroMsg.BizImageDecodeListener", "alvinluo onReadLocalFileEnd id: %s, %d", new Object[] { this.id, Long.valueOf(System.currentTimeMillis()) });
      localObject = com.tencent.mm.pluginsdk.model.a.EKY;
      com.tencent.mm.pluginsdk.model.a.cK(5, this.url);
    }
    AppMethodBeat.o(124833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e
 * JD-Core Version:    0.7.0.1
 */