package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.m;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends m
{
  public List<Fragment> oJM = new ArrayList();
  
  public c(j paramj, List<Fragment> paramList)
  {
    super(paramj);
    this.oJM = paramList;
  }
  
  public final void a(Fragment paramFragment, int paramInt)
  {
    this.oJM.remove(paramFragment);
    if (paramInt >= this.oJM.size())
    {
      this.oJM.add(paramFragment);
      return;
    }
    this.oJM.add(paramInt, paramFragment);
  }
  
  public final Fragment ae(int paramInt)
  {
    return (Fragment)this.oJM.get(paramInt);
  }
  
  public final CharSequence dj()
  {
    return "";
  }
  
  public final int getCount()
  {
    return this.oJM.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c
 * JD-Core Version:    0.7.0.1
 */