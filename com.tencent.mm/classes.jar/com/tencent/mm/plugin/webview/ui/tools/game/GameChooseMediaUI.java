package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.ui.q.b;

public class GameChooseMediaUI
  extends AlbumPreviewUI
{
  public final void PE(String paramString)
  {
    AppMethodBeat.i(153318);
    ((f)g.E(f.class)).ap(this, paramString);
    AppMethodBeat.o(153318);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, View.OnLongClickListener paramOnLongClickListener, q.b paramb)
  {
    AppMethodBeat.i(153317);
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, paramOnLongClickListener, q.b.zbI);
    AppMethodBeat.o(153317);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(153316);
    super.onCreate(paramBundle);
    AppMethodBeat.o(153316);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChooseMediaUI
 * JD-Core Version:    0.7.0.1
 */