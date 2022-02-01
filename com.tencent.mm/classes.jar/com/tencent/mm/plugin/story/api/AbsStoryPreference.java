package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.preference.Preference;

public abstract class AbsStoryPreference
  extends Preference
{
  public AbsStoryPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsStoryPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a(d paramd);
  
  public abstract void egO();
  
  public abstract void egP();
  
  public abstract void egQ();
  
  public abstract void onCreate(String paramString);
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.AbsStoryPreference
 * JD-Core Version:    0.7.0.1
 */