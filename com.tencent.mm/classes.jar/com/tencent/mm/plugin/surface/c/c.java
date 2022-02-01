package com.tencent.mm.plugin.surface.c;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.aa;
import kotlin.z;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/render/FrameSet;", "", "name", "", "root", "Landroid/view/ViewGroup;", "(Ljava/lang/String;Landroid/view/ViewGroup;)V", "id", "getId", "()Ljava/lang/String;", "getName", "setName", "(Ljava/lang/String;)V", "getRoot", "()Landroid/view/ViewGroup;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final String id;
  public final ViewGroup mJe;
  public String name;
  
  public c(String paramString, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(265037);
    this.name = paramString;
    this.mJe = paramViewGroup;
    this.id = aa.aMB(z.aKc(hashCode()));
    AppMethodBeat.o(265037);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(265067);
    if (this == paramObject)
    {
      AppMethodBeat.o(265067);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(265067);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(265067);
      return false;
    }
    if (!s.p(this.mJe, paramObject.mJe))
    {
      AppMethodBeat.o(265067);
      return false;
    }
    AppMethodBeat.o(265067);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(265060);
    int i = this.name.hashCode();
    int j = this.mJe.hashCode();
    AppMethodBeat.o(265060);
    return i * 31 + j;
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(265044);
    s.u(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(265044);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(265053);
    String str = "FrameSet(name=" + this.name + ", root=" + this.mJe + ')';
    AppMethodBeat.o(265053);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.c.c
 * JD-Core Version:    0.7.0.1
 */