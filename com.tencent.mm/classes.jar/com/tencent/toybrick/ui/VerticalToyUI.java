package com.tencent.toybrick.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;

public abstract class VerticalToyUI<T extends com.tencent.toybrick.g.a>
  extends BaseToyUI<g>
{
  private a.a Snl;
  private b SoK;
  private com.tencent.toybrick.d.a SoL;
  protected T SoM = null;
  
  static
  {
    if (!VerticalToyUI.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      throw new NullPointerException();
      this.SoL = new com.tencent.toybrick.d.a(this);
      this.Snl = this.SoL.Snl;
      paramBundle = (RecyclerView)findViewById(2131309710);
      getBaseContext();
      Object localObject = new LinearLayoutManager();
      ((LinearLayoutManager)localObject).aqE = 4;
      ((LinearLayoutManager)localObject).setItemPrefetchEnabled(true);
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject);
      localObject = new b(this, this.Snl);
      this.SoK = ((b)localObject);
      paramBundle.setAdapter((RecyclerView.a)localObject);
      paramBundle.setRecycledViewPool(com.tencent.toybrick.b.a.hpI());
      paramBundle.setViewCacheExtension(new RecyclerView.t() {});
      localObject = new c(this);
      ((c)localObject).Snl = this.Snl;
      paramBundle.a((RecyclerView.h)localObject);
      if (this.SoK != null) {
        this.SoK.atj.notifyChanged();
      }
      return;
    }
    catch (InstantiationException paramBundle)
    {
      for (;;)
      {
        as.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        as.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.ui.VerticalToyUI
 * JD-Core Version:    0.7.0.1
 */