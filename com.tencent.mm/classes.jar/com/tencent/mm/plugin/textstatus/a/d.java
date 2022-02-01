package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import org.json.JSONObject;

public abstract interface d
  extends a
{
  public abstract CharSequence attachTextStatusSpanSync(TextView paramTextView, String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat);
  
  public abstract void clearTextStatus(TextView paramTextView, String paramString);
  
  public abstract q createGetBrandInfoScene(String paramString);
  
  public abstract void execSQL(String paramString);
  
  public abstract b getBackPreview(Context paramContext, Runnable paramRunnable, boolean paramBoolean);
  
  public abstract MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle);
  
  public abstract e getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout);
  
  public abstract e getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt);
  
  public abstract long getResVersion();
  
  public abstract h getStatusCardView(Context paramContext, r paramr);
  
  public abstract JSONObject getStrangerInfos(JSONObject paramJSONObject);
  
  public abstract String getTextStatusId(String paramString);
  
  public abstract ImageSpan getTextStatusSpanSync(TextView paramTextView, String paramString, a.b paramb, float paramFloat);
  
  public abstract String getUserNameByCommHashName(String paramString);
  
  public abstract void goLikeListFromSelfHistory(Context paramContext);
  
  public abstract void goUnReadMsgPage(Context paramContext);
  
  public abstract void handleGetBrandResult(Activity paramActivity, q paramq, int paramInt);
  
  public abstract boolean hasStatus(String paramString);
  
  public abstract void report22208(long paramLong, String paramString);
  
  public abstract void report22210(String paramString, long paramLong);
  
  public abstract void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc);
  
  public abstract void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb);
  
  public abstract void showCardDialog(Activity paramActivity, String paramString);
  
  public abstract void showStatusDetail(Context paramContext, String paramString);
  
  public abstract void tryAttachStatusIconSpan(View paramView, CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.d
 * JD-Core Version:    0.7.0.1
 */