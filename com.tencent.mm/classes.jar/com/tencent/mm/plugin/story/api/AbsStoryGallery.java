package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.widget.listview.PullDownListView;

public abstract class AbsStoryGallery
  extends RelativeLayout
{
  public AbsStoryGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsStoryGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsStoryGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void Lj(int paramInt);
  
  public abstract void Qp(int paramInt);
  
  public abstract void Qq(int paramInt);
  
  public abstract void a(PullDownListView paramPullDownListView);
  
  public abstract void ag(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void dUs();
  
  public abstract void dUt();
  
  public abstract void dUu();
  
  public abstract void dUv();
  
  public abstract boolean onBackPressed();
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void rA(boolean paramBoolean);
  
  public abstract void setCurrentHItem(int paramInt);
  
  public abstract void setCurrentVItem(int paramInt);
  
  public abstract void setDataSeed(Object paramObject);
  
  public abstract void setStoryBrowseUIListener(g paramg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.AbsStoryGallery
 * JD-Core Version:    0.7.0.1
 */