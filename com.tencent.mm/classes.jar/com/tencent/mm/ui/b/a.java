package com.tencent.mm.ui.b;

import android.annotation.TargetApi;
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
  private MenuInflater fX;
  b gb = null;
  public ActionBar mActionBar;
  final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  private b startSupportActionMode(b.a parama)
  {
    if (this.gb != null) {
      this.gb.finish();
    }
    parama = new a(parama);
    ActionBar localActionBar = getSupportActionBar();
    if (localActionBar != null) {
      this.gb = localActionBar.a(parama);
    }
    return this.gb;
  }
  
  @TargetApi(11)
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
    if (this.fX == null)
    {
      localActionBar = getSupportActionBar();
      if (localActionBar == null) {
        break label36;
      }
    }
    label36:
    for (this.fX = new g(localActionBar.aD());; this.fX = new g(this.mActivity)) {
      return this.fX;
    }
  }
  
  final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = hJi();
    }
    return this.mActionBar;
  }
  
  abstract ActionBar hJi();
  
  final class a
    implements b.a
  {
    private b.a gI;
    
    public a(b.a parama)
    {
      this.gI = parama;
    }
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(196006);
      this.gI.a(paramb);
      a.this.gb = null;
      AppMethodBeat.o(196006);
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(195999);
      boolean bool = this.gI.a(paramb, paramMenu);
      AppMethodBeat.o(195999);
      return bool;
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(196003);
      boolean bool = this.gI.a(paramb, paramMenuItem);
      AppMethodBeat.o(196003);
      return bool;
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      AppMethodBeat.i(196000);
      boolean bool = this.gI.b(paramb, paramMenu);
      AppMethodBeat.o(196000);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */