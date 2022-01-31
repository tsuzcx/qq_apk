package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class b$a
{
  int id;
  public WeakReference<View> iyQ;
  int parent;
  int z;
  
  public b$a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5917);
    this.iyQ = new WeakReference(paramView);
    this.id = paramInt1;
    this.parent = paramInt2;
    this.z = paramInt3;
    AppMethodBeat.o(5917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */