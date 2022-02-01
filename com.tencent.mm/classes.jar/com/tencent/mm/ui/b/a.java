package com.tencent.mm.ui.b;

import android.app.Activity;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.view.f.a;
import androidx.appcompat.view.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
{
  private MenuInflater gS;
  b gW = null;
  public ActionBar mActionBar;
  final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private b startSupportActionMode(b.a parama)
  {
    if (this.gW != null) {
      this.gW.finish();
    }
    parama = new a(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      this.gW = localActionBar.a(parama);
    }
    return this.gW;
  }
  
  public final ActionMode b(ActionMode.Callback paramCallback)
  {
    paramCallback = new f.a(this.mActivity, paramCallback);
    b localb = startSupportActionMode(paramCallback);
    if (localb != null) {
      return paramCallback.b(localb);
    }
    return null;
  }
  
  public final MenuInflater getMenuInflater()
  {
    ActionBar localActionBar;
    if (this.gS == null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        break label36;
      }
    }
    label36:
    for (this.gS = new g(localActionBar.bw());; this.gS = new g(this.mActivity)) {
      return this.gS;
    }
  }
  
  final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = jlx();
    }
    return this.mActionBar;
  }
  
  abstract ActionBar jlx();
  
  final class a
    implements b.a
  {
    private b.a hD;
    
    public a(b.a parama)
    {
      this.hD = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(250063);
      this.hD.a(paramb);
      a.this.gW = null;
      AppMethodBeat.o(250063);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(250043);
      boolean bool = this.hD.a(paramb, paramMenu);
      AppMethodBeat.o(250043);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(250055);
      boolean bool = this.hD.a(paramb, paramMenuItem);
      AppMethodBeat.o(250055);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(250049);
      boolean bool = this.hD.b(paramb, paramMenu);
      AppMethodBeat.o(250049);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */