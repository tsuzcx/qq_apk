package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.i;

public final class k
  extends i<j>
  implements w
{
  private final Status JH;
  
  public k(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.JH = new Status(paramDataHolder.getStatusCode());
  }
  
  public final Status gM()
  {
    return this.JH;
  }
  
  protected final String gZ()
  {
    return "path";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.k
 * JD-Core Version:    0.7.0.1
 */