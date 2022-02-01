package com.tencent.mm.plugin.webcanvas;

import android.content.MutableContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webcanvas/WebCanvasJsEngine$CanvasElement;", "", "id", "", "context", "Landroid/content/MutableContextWrapper;", "(ILandroid/content/MutableContextWrapper;)V", "getContext", "()Landroid/content/MutableContextWrapper;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "webview-sdk_release"})
final class b$f
{
  final MutableContextWrapper Dyz;
  final int id;
  
  public b$f(int paramInt, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(214047);
    this.id = paramInt;
    this.Dyz = paramMutableContextWrapper;
    AppMethodBeat.o(214047);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(214050);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((this.id != paramObject.id) || (!p.i(this.Dyz, paramObject.Dyz))) {}
      }
    }
    else
    {
      AppMethodBeat.o(214050);
      return true;
    }
    AppMethodBeat.o(214050);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(214049);
    int j = this.id;
    MutableContextWrapper localMutableContextWrapper = this.Dyz;
    if (localMutableContextWrapper != null) {}
    for (int i = localMutableContextWrapper.hashCode();; i = 0)
    {
      AppMethodBeat.o(214049);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(214048);
    String str = "CanvasElement(id=" + this.id + ", context=" + this.Dyz + ")";
    AppMethodBeat.o(214048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.f
 * JD-Core Version:    0.7.0.1
 */