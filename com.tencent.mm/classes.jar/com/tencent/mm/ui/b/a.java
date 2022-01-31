package com.tencent.mm.ui.b;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public abstract class a
{
  public b Pp = null;
  public MenuInflater fe;
  public ActionBar mActionBar;
  public final Activity mActivity;
  
  public a(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  abstract ActionBar cAk();
  
  public final ActionBar getSupportActionBar()
  {
    if (this.mActionBar == null) {
      this.mActionBar = cAk();
    }
    return this.mActionBar;
  }
  
  public final class a
    implements b.a
  {
    private b.a PK;
    
    public a(b.a parama)
    {
      this.PK = parama;
    }
    
    public final void a(b paramb)
    {
      this.PK.a(paramb);
      a.this.Pp = null;
    }
    
    public final boolean a(b paramb, Menu paramMenu)
    {
      return this.PK.a(paramb, paramMenu);
    }
    
    public final boolean a(b paramb, MenuItem paramMenuItem)
    {
      return this.PK.a(paramb, paramMenuItem);
    }
    
    public final boolean b(b paramb, Menu paramMenu)
    {
      return this.PK.b(paramb, paramMenu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.a
 * JD-Core Version:    0.7.0.1
 */