package com.tencent.tencentmap.mapsdk.a;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class uw
  extends Activity
{
  private List<uy> a = new ArrayList();
  private Bundle b;
  
  protected void a(uy paramuy)
  {
    this.a.add(paramuy);
    paramuy.a(this.b);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = paramBundle;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uy localuy = (uy)localIterator.next();
      if (localuy != null) {
        localuy.e();
      }
    }
    this.a.clear();
  }
  
  protected void onPause()
  {
    super.onPause();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uy localuy = (uy)localIterator.next();
      if (localuy != null) {
        localuy.b();
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uy localuy = (uy)localIterator.next();
      if (localuy != null) {
        localuy.a();
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uy localuy = (uy)localIterator.next();
      if (localuy != null) {
        localuy.b(paramBundle);
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      uy localuy = (uy)localIterator.next();
      if (localuy != null) {
        localuy.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uw
 * JD-Core Version:    0.7.0.1
 */