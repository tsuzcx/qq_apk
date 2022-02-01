package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMFragment;

public abstract interface n
{
  public abstract AbsStoryGallery a(Context paramContext, n.a parama, String paramString);
  
  public abstract void a(ViewGroup paramViewGroup, View paramView, int paramInt);
  
  public abstract void eZ(View paramView);
  
  public abstract void fa(View paramView);
  
  public abstract void fb(View paramView);
  
  public abstract AbsStoryMuteView gc(Context paramContext);
  
  public abstract AbsStoryHeaderTipView gd(Context paramContext);
  
  public abstract i ge(Context paramContext);
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
  
  public abstract Drawable qD(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.n
 * JD-Core Version:    0.7.0.1
 */