package com.tencent.mm.ui.chatting.component.api;

import android.text.SpannableString;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.component.aj;

public abstract interface ad
  extends aj
{
  public abstract void LZ(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, View.OnClickListener paramOnClickListener, String paramString);
  
  public abstract void aCe(int paramInt);
  
  public abstract void b(SpannableString paramSpannableString);
  
  public abstract ab joS();
  
  public abstract void jrB();
  
  public abstract void jsB();
  
  public abstract void jsG();
  
  public abstract void jsI();
  
  public abstract void jsK();
  
  public abstract void jsM();
  
  public abstract int jsS();
  
  public abstract int jsT();
  
  public abstract ImageView jsU();
  
  public abstract void lk(View paramView);
  
  public abstract void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener);
  
  public abstract void setMMSubTitle(String paramString);
  
  public abstract void setMMTitle(int paramInt);
  
  public abstract void setMMTitle(CharSequence paramCharSequence);
  
  public abstract void setTitleMuteIconVisibility(int paramInt);
  
  public abstract void setTitlePhoneIconVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.api.ad
 * JD-Core Version:    0.7.0.1
 */