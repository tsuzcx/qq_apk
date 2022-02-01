package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import org.json.JSONObject;

public abstract interface f
  extends a
{
  public abstract CharSequence attachTextStatusSpanSync(TextView paramTextView, String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat);
  
  public abstract void clearTextStatus(TextView paramTextView, String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract b getBackPreview(Context paramContext, Runnable paramRunnable, boolean paramBoolean);
  
  public abstract MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle);
  
  public abstract g getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout);
  
  public abstract g getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt);
  
  public abstract long getResVersion();
  
  public abstract j getStatusCardView(Context paramContext, x paramx);
  
  public abstract JSONObject getStrangerInfos(JSONObject paramJSONObject);
  
  public abstract String getTextStatusIconId(String paramString);
  
  public abstract String getTextStatusId(String paramString);
  
  public abstract ImageSpan getTextStatusSpanSync(TextView paramTextView, String paramString, a.b paramb, float paramFloat);
  
  public abstract void getVerifyInfoForWeRun(String paramString, int paramInt, Context paramContext, f.a parama);
  
  public abstract void goLikeListFromSelfHistory(Context paramContext);
  
  public abstract void goUnReadMsgPage(Context paramContext);
  
  public abstract boolean hasStatus(String paramString);
  
  public abstract void hideCardDialog();
  
  public abstract boolean openTextStateChatting(Context paramContext, JSONObject paramJSONObject);
  
  public abstract void report22208(long paramLong, String paramString);
  
  public abstract void report22210(String paramString, long paramLong);
  
  public abstract void setIcon(ImageView paramImageView, String paramString, a.c paramc, a.a parama);
  
  public abstract void setTextStatusWithDesc(TextView paramTextView, String paramString, a.b paramb, a.c paramc);
  
  public abstract void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc);
  
  public abstract void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb);
  
  public abstract void showCardDialog(Activity paramActivity, String paramString);
  
  public abstract void showStatusDetail(Context paramContext, String paramString);
  
  public abstract void tryAttachStatusIconSpan(View paramView, CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.f
 * JD-Core Version:    0.7.0.1
 */