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
  
  public abstract void b(ViewGroup paramViewGroup, View paramView, int paramInt);
  
  public abstract void fA(View paramView);
  
  public abstract void fB(View paramView);
  
  public abstract void fz(View paramView);
  
  public abstract AbsStoryMuteView gr(Context paramContext);
  
  public abstract AbsStoryHeaderTipView gs(Context paramContext);
  
  public abstract i gt(Context paramContext);
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
  
  public abstract Drawable sh(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.n
 * JD-Core Version:    0.7.0.1
 */