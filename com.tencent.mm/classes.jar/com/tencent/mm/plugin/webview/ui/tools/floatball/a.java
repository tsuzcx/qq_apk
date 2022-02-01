package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "", "id", "", "bundle", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-webview_release"})
public final class a
{
  public final Bundle bundle;
  public final int id;
  
  public a(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(210486);
    this.id = paramInt;
    this.bundle = paramBundle;
    AppMethodBeat.o(210486);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210489);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.id != paramObject.id) || (!p.j(this.bundle, paramObject.bundle))) {}
      }
    }
    else
    {
      AppMethodBeat.o(210489);
      return true;
    }
    AppMethodBeat.o(210489);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(210488);
    int j = this.id;
    Bundle localBundle = this.bundle;
    if (localBundle != null) {}
    for (int i = localBundle.hashCode();; i = 0)
    {
      AppMethodBeat.o(210488);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210487);
    String str = "JSApiInfo(id=" + this.id + ", bundle=" + this.bundle + ")";
    AppMethodBeat.o(210487);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.a
 * JD-Core Version:    0.7.0.1
 */