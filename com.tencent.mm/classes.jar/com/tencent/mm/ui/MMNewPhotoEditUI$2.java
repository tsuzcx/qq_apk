package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.sdk.platformtools.ab;

final class MMNewPhotoEditUI$2
  implements r
{
  MMNewPhotoEditUI$2(MMNewPhotoEditUI paramMMNewPhotoEditUI) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(11920);
    ab.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", new Object[] { parame.name() });
    AppMethodBeat.o(11920);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(11921);
    ab.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parame.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(11921);
  }
  
  public final void bk(boolean paramBoolean)
  {
    AppMethodBeat.i(11922);
    if (paramBoolean)
    {
      this.zcs.showVKB();
      AppMethodBeat.o(11922);
      return;
    }
    this.zcs.hideVKB(this.zcs.getContentView());
    AppMethodBeat.o(11922);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MMNewPhotoEditUI.2
 * JD-Core Version:    0.7.0.1
 */