package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;

public abstract interface n
{
  public abstract AbsStoryGallery a(Context paramContext, a parama, String paramString);
  
  public abstract void c(ViewGroup paramViewGroup, View paramView, int paramInt);
  
  public abstract void gW(View paramView);
  
  public abstract void gX(View paramView);
  
  public abstract void gY(View paramView);
  
  public abstract AbsStoryMuteView ii(Context paramContext);
  
  public abstract AbsStoryHeaderTipView ij(Context paramContext);
  
  public abstract i ik(Context paramContext);
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
  
  public abstract Drawable zn(boolean paramBoolean);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118419);
      LEz = new a("SelfTabGallery", 0);
      LEA = new a("SelfGallery", 1);
      LEB = new a("ProfileGallery", 2);
      LEC = new a("SingleGallery", 3);
      LED = new a("MultiUserGallery", 4);
      LEE = new a("HistoryGallery", 5);
      LEF = new a("AllFriendGallery", 6);
      LEG = new a("FavSelfStoryGallery", 7);
      LEH = new a("FavOtherStoryGallery", 8);
      LEI = new a("FavSelfStoryGalleryMulti", 9);
      LEJ = new a[] { LEz, LEA, LEB, LEC, LED, LEE, LEF, LEG, LEH, LEI };
      AppMethodBeat.o(118419);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.n
 * JD-Core Version:    0.7.0.1
 */