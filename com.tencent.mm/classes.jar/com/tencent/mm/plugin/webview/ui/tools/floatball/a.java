package com.tencent.mm.plugin.webview.ui.tools.floatball;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/floatball/JSApiInfo;", "", "id", "", "bundle", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final Bundle bundle;
  public final int id;
  
  public a(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(296283);
    this.id = paramInt;
    this.bundle = paramBundle;
    AppMethodBeat.o(296283);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(296302);
    if (this == paramObject)
    {
      AppMethodBeat.o(296302);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(296302);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(296302);
      return false;
    }
    if (!s.p(this.bundle, paramObject.bundle))
    {
      AppMethodBeat.o(296302);
      return false;
    }
    AppMethodBeat.o(296302);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(296299);
    int i = this.id;
    int j = this.bundle.hashCode();
    AppMethodBeat.o(296299);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(296291);
    String str = "JSApiInfo(id=" + this.id + ", bundle=" + this.bundle + ')';
    AppMethodBeat.o(296291);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.floatball.a
 * JD-Core Version:    0.7.0.1
 */