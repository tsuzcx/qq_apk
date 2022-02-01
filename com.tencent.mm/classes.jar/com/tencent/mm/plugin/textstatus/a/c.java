package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;

public abstract interface c
  extends a
{
  public abstract CharSequence attachTextStatusSpanSync(String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat);
  
  public abstract void clearTextStatus(TextView paramTextView, String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract b getBackPreview(Context paramContext);
  
  public abstract MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle);
  
  public abstract d getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout);
  
  public abstract d getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt);
  
  public abstract f getStatusCardView(Context paramContext, n paramn);
  
  public abstract ImageSpan getTextStatusSpanSync(String paramString, a.b paramb, float paramFloat);
  
  public abstract void goLikeListFromSelfHistory(Context paramContext);
  
  public abstract void goUnReadMsgPage(Context paramContext);
  
  public abstract boolean hasStatus(String paramString);
  
  public abstract boolean isHasStatusThumb(String paramString);
  
  public abstract void report22208(long paramLong, String paramString);
  
  public abstract void report22210(String paramString, long paramLong);
  
  public abstract void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc);
  
  public abstract void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb);
  
  public abstract void showCardDialog(Activity paramActivity, String paramString);
  
  public abstract void showStatusDetail(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.c
 * JD-Core Version:    0.7.0.1
 */