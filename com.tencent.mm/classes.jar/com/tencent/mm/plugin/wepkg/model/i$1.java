package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$1
  extends a
{
  i$1(i parami, boolean paramBoolean, String paramString) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    AppMethodBeat.i(63590);
    if ((this.object instanceof String))
    {
      i.bY((String)this.object, paramBaseWepkgProcessTask.cmX);
      i.a(this.vGG, (String)this.object, this.vGF);
      AppMethodBeat.o(63590);
      return;
    }
    i.y(this.vGF, this.nom);
    AppMethodBeat.o(63590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i.1
 * JD-Core Version:    0.7.0.1
 */