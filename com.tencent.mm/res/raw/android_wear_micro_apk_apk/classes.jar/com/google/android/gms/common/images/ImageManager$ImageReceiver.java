package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

@KeepName
final class ImageManager$ImageReceiver
  extends ResultReceiver
{
  private final Uri Kv;
  private final ArrayList<e> Kw;
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
    ImageManager.f(this.Kx).execute(new c(this.Kx, this.Kv, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.ImageReceiver
 * JD-Core Version:    0.7.0.1
 */