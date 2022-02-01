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
import com.tencent.mm.ui.an;
import com.tencent.toybrick.b.b;
import com.tencent.toybrick.b.c;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;

public abstract class VerticalToyUI<T extends com.tencent.toybrick.g.a>
  extends BaseToyUI<g>
{
  private a.a Ksm;
  private b KtM;
  private com.tencent.toybrick.d.a KtN;
  protected T KtO = null;
  
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
      this.KtN = new com.tencent.toybrick.d.a(this);
      this.Ksm = this.KtN.Ksm;
      paramBundle = (RecyclerView)findViewById(2131306297);
      getBaseContext();
      Object localObject = new LinearLayoutManager();
      ((LinearLayoutManager)localObject).aoA = 4;
      ((LinearLayoutManager)localObject).aw(true);
      paramBundle.setLayoutManager((RecyclerView.i)localObject);
      localObject = new b(this, this.Ksm);
      this.KtM = ((b)localObject);
      paramBundle.setAdapter((RecyclerView.a)localObject);
      paramBundle.setRecycledViewPool(com.tencent.toybrick.b.a.fHp());
      paramBundle.setViewCacheExtension(new RecyclerView.u() {});
      localObject = new c(this);
      ((c)localObject).Ksm = this.Ksm;
      paramBundle.a((RecyclerView.h)localObject);
      if (this.KtM != null) {
        this.KtM.arg.notifyChanged();
      }
      return;
    }
    catch (InstantiationException paramBundle)
    {
      for (;;)
      {
        an.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
      }
    }
    catch (IllegalAccessException paramBundle)
    {
      for (;;)
      {
        an.printErrStackTrace("VerticalToyUI", paramBundle, "", new Object[0]);
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