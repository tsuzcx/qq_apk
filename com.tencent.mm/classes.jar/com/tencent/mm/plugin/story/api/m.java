package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMFragment;

public abstract interface m
{
  public abstract AbsStoryGallery a(Context paramContext, m.a parama, String paramString);
  
  public abstract void d(ViewGroup paramViewGroup, View paramView);
  
  public abstract void eh(View paramView);
  
  public abstract void ei(View paramView);
  
  public abstract void ej(View paramView);
  
  public abstract AbsStoryMuteView fb(Context paramContext);
  
  public abstract i fc(Context paramContext);
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
  
  public abstract Drawable lO(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.m
 * JD-Core Version:    0.7.0.1
 */