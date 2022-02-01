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
  private MenuInflater YC;
  b YG = null;
  public ActionBar mActionBar;
  final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private b startSupportActionMode(b.a parama)
  {
    if (this.YG != null) {
      this.YG.finish();
    }
    parama = new a(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      this.YG = localActionBar.a(parama);
    }
    return this.YG;
  }
  
  abstract ActionBar gKf();
  
  public final MenuInflater getMenuInflater()
  {
    ActionBar localActionBar;
    if (this.YC == null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        break label36;
      }
    }
    label36:
    for (this.YC = new g(localActionBar.getThemedContext());; this.YC = new g(this.mActivity)) {
      return this.YC;
    }
  }
  
  final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = gKf();
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
    private b.a Zn;
    
    public a(b.a parama)
    {
      this.Zn = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(141508);
      this.Zn.a(paramb);
      a.this.YG = null;
      AppMethodBeat.o(141508);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(141505);
      boolean bool = this.Zn.a(paramb, paramMenu);
      AppMethodBeat.o(141505);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(141507);
      boolean bool = this.Zn.a(paramb, paramMenuItem);
      AppMethodBeat.o(141507);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(141506);
      boolean bool = this.Zn.b(paramb, paramMenu);
      AppMethodBeat.o(141506);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */