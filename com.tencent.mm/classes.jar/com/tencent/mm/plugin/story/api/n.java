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
  public abstract Drawable EE(boolean paramBoolean);
  
  public abstract AbsStoryGallery a(Context paramContext, a parama, String paramString);
  
  public abstract void c(ViewGroup paramViewGroup, View paramView, int paramInt);
  
  public abstract MMFragment instantiateAlbumFragment(Context paramContext, Bundle paramBundle);
  
  public abstract AbsStoryMuteView jY(Context paramContext);
  
  public abstract AbsStoryHeaderTipView jZ(Context paramContext);
  
  public abstract i ka(Context paramContext);
  
  public abstract void kc(View paramView);
  
  public abstract void kd(View paramView);
  
  public abstract void ke(View paramView);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(118419);
      Sik = new a("SelfTabGallery", 0);
      Sil = new a("SelfGallery", 1);
      Sim = new a("ProfileGallery", 2);
      Sin = new a("SingleGallery", 3);
      Sio = new a("MultiUserGallery", 4);
      Sip = new a("HistoryGallery", 5);
      Siq = new a("AllFriendGallery", 6);
      Sir = new a("FavSelfStoryGallery", 7);
      Sis = new a("FavOtherStoryGallery", 8);
      Sit = new a("FavSelfStoryGalleryMulti", 9);
      Siu = new a[] { Sik, Sil, Sim, Sin, Sio, Sip, Siq, Sir, Sis, Sit };
      AppMethodBeat.o(118419);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.api.n
 * JD-Core Version:    0.7.0.1
 */