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
  b OD = null;
  private MenuInflater gd;
  public ActionBar mActionBar;
  final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private b startSupportActionMode(b.a parama)
  {
    if (this.OD != null) {
      this.OD.finish();
    }
    parama = new a(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      this.OD = localActionBar.a(parama);
    }
    return this.OD;
  }
  
  abstract ActionBar dDu();
  
  public final MenuInflater getMenuInflater()
  {
    ActionBar localActionBar;
    if (this.gd == null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        break label36;
      }
    }
    label36:
    for (this.gd = new g(localActionBar.getThemedContext());; this.gd = new g(this.mActivity)) {
      return this.gd;
    }
  }
  
  final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = dDu();
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
    private b.a Pl;
    
    public a(b.a parama)
    {
      this.Pl = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(106148);
      this.Pl.a(paramb);
      a.this.OD = null;
      AppMethodBeat.o(106148);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(106145);
      boolean bool = this.Pl.a(paramb, paramMenu);
      AppMethodBeat.o(106145);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(106147);
      boolean bool = this.Pl.a(paramb, paramMenuItem);
      AppMethodBeat.o(106147);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(106146);
      boolean bool = this.Pl.b(paramb, paramMenu);
      AppMethodBeat.o(106146);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */