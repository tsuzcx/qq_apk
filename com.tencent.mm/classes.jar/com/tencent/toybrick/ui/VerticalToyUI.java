package com.tencent.toybrick.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;

public abstract class VerticalToyUI<T extends com.tencent.toybrick.g.a>
  extends BaseToyUI<g>
{
  private a.a Min;
  private b MjN;
  private com.tencent.toybrick.d.a MjO;
  protected T MjP = null;
  
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
      this.MjO = new com.tencent.toybrick.d.a(this);
      this.Min = this.MjO.Min;
      paramBundle = (RecyclerView)findViewById(2131306297);
      getBaseContext();
      Object localObject = new LinearLayoutManager();
      ((LinearLayoutManager)localObject).aqs = 4;
      ((LinearLayoutManager)localObject).aw(true);
      paramBundle.setLayoutManager((RecyclerView.i)localObject);
      localObject = new b(this, this.Min);
      this.MjN = ((b)localObject);
      paramBundle.setAdapter((RecyclerView.a)localObject);
      paramBundle.setRecycledViewPool(com.tencent.toybrick.b.a.fYG());
      paramBundle.setViewCacheExtension(new RecyclerView.u() {});
      localObject = new c(this);
      ((c)localObject).Min = this.Min;
      paramBundle.a((RecyclerView.h)localObject);
      if (this.MjN != null) {
        this.MjN.asY.notifyChanged();
      }
      return;
    }
    catch (InstantiationException paramBundle)
    {
      for (;;)
      {
        ap.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        ap.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
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