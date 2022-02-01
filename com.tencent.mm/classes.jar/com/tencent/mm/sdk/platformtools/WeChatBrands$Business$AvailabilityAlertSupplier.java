package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import androidx.core.f.a;

public class WeChatBrands$Business$AvailabilityAlertSupplier
{
  public static final int ON_DISMISS = -1;
  public static final int ON_NO = 0;
  public static final int ON_YES = 1;
  protected String mBody;
  protected a<Integer> mCallback;
  protected String mNegativeBtnText;
  protected DialogInterface.OnClickListener mOnDismissListener;
  protected DialogInterface.OnClickListener mOnNegativeClickListener;
  protected DialogInterface.OnClickListener mOnPositiveClickListener;
  protected String mPositiveBtnText;
  protected String mTilte;
  
  public AvailabilityAlertSupplier attach(a<Integer> parama)
  {
    this.mCallback = parama;
    return this;
  }
  
  public String getBody()
  {
    return this.mBody;
  }
  
  public a<Integer> getCallback()
  {
    return this.mCallback;
  }
  
  public String getNegativeBtnText()
  {
    return this.mNegativeBtnText;
  }
  
  public DialogInterface.OnClickListener getOnDismissListener()
  {
    return this.mOnDismissListener;
  }
  
  public DialogInterface.OnClickListener getOnNegativeClickListener()
  {
    return this.mOnNegativeClickListener;
  }
  
  public DialogInterface.OnClickListener getOnPositiveClickListener()
  {
    return this.mOnPositiveClickListener;
  }
  
  public String getPositiveBtnText()
  {
    return this.mPositiveBtnText;
  }
  
  public String getTilte()
  {
    return this.mTilte;
  }
  
  public AvailabilityAlertSupplier setBody(String paramString)
  {
    this.mBody = paramString;
    return this;
  }
  
  public AvailabilityAlertSupplier setNegativeBtnText(String paramString)
  {
    this.mNegativeBtnText = paramString;
    return this;
  }
  
  public AvailabilityAlertSupplier setOnDismissListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.mOnDismissListener = paramOnClickListener;
    return this;
  }
  
  public AvailabilityAlertSupplier setOnNegativeClickListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.mOnNegativeClickListener = paramOnClickListener;
    return this;
  }
  
  public AvailabilityAlertSupplier setOnPositiveClickListener(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.mOnPositiveClickListener = paramOnClickListener;
    return this;
  }
  
  public AvailabilityAlertSupplier setPositiveBtnText(String paramString)
  {
    this.mPositiveBtnText = paramString;
    return this;
  }
  
  public AvailabilityAlertSupplier setTilte(String paramString)
  {
    this.mTilte = paramString;
    return this;
  }
  
  public void showDialog(Context paramContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier
 * JD-Core Version:    0.7.0.1
 */