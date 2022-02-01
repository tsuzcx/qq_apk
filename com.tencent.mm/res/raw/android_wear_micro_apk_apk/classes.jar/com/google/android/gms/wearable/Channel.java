package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;

public abstract interface Channel
  extends Parcelable
{
  public abstract t<Status> a(p paramp);
  
  public abstract t<Status> a(p paramp, Uri paramUri);
  
  public abstract String getPath();
  
  public abstract String kz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.Channel
 * JD-Core Version:    0.7.0.1
 */