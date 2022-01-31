package com.tencent.toybrick.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;

public abstract class VerticalToyUI<T extends com.tencent.toybrick.g.a>
  extends BaseToyUI<g>
{
  private a.a BwX;
  protected T ByA = null;
  private b Byy;
  private com.tencent.toybrick.d.a Byz;
  
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
      this.Byz = new com.tencent.toybrick.d.a(this);
      this.BwX = this.Byz.BwX;
      paramBundle = (RecyclerView)findViewById(2131828680);
      getBaseContext();
      Object localObject = new LinearLayoutManager();
      ((LinearLayoutManager)localObject).agy = 4;
      ((LinearLayoutManager)localObject).ao(true);
      paramBundle.setLayoutManager((RecyclerView.i)localObject);
      localObject = new b(this, this.BwX);
      this.Byy = ((b)localObject);
      paramBundle.setAdapter((RecyclerView.a)localObject);
      paramBundle.setRecycledViewPool(com.tencent.toybrick.b.a.dWN());
      paramBundle.setViewCacheExtension(new VerticalToyUI.1(this));
      localObject = new c(this);
      ((c)localObject).BwX = this.BwX;
      paramBundle.a((RecyclerView.h)localObject);
      if (this.Byy != null) {
        this.Byy.ajb.notifyChanged();
      }
      return;
    }
    catch (InstantiationException paramBundle)
    {
      for (;;)
      {
        ak.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        ak.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.toybrick.ui.VerticalToyUI
 * JD-Core Version:    0.7.0.1
 */