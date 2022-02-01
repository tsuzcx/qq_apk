package com.tencent.mm.ui.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.f.a;
import android.support.v7.view.g;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class a
{
  private MenuInflater VF;
  b VJ = null;
  public ActionBar mActionBar;
  final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private b startSupportActionMode(b.a parama)
  {
    if (this.VJ != null) {
      this.VJ.finish();
    }
    parama = new a(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      this.VJ = localActionBar.a(parama);
    }
    return this.VJ;
  }
  
  abstract ActionBar eSg();
  
  public final MenuInflater getMenuInflater()
  {
    ActionBar localActionBar;
    if (this.VF == null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        break label36;
      }
    }
    label36:
    for (this.VF = new g(localActionBar.getThemedContext());; this.VF = new g(this.mActivity)) {
      return this.VF;
    }
  }
  
  final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = eSg();
    }
    return this.mActionBar;
  }
  
  @TargetApi(11)
  public final ActionMode startActionMode(ActionMode.Callback paramCallback)
  {
    paramCallback = new f.a(this.mActivity, paramCallback);
    b localb = startSupportActionMode(paramCallback);
    if (localb != null) {
      return paramCallback.b(localb);
    }
    return null;
  }
  
  final class a
    implements b.a
  {
    private b.a Wq;
    
    public a(b.a parama)
    {
      this.Wq = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(141508);
      this.Wq.a(paramb);
      a.this.VJ = null;
      AppMethodBeat.o(141508);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(141505);
      boolean bool = this.Wq.a(paramb, paramMenu);
      AppMethodBeat.o(141505);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(141507);
      boolean bool = this.Wq.a(paramb, paramMenuItem);
      AppMethodBeat.o(141507);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(141506);
      boolean bool = this.Wq.b(paramb, paramMenu);
      AppMethodBeat.o(141506);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */