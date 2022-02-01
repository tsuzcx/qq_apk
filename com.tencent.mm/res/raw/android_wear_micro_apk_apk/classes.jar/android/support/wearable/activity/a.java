package android.support.wearable.activity;

import android.os.Bundle;
import com.google.android.wearable.compat.WearableActivityController.AmbientCallback;

class a
  extends WearableActivityController.AmbientCallback
{
  private a(WearableActivity paramWearableActivity) {}
  
  public void g(Bundle paramBundle)
  {
    WearableActivity.a(this.Au);
    this.Au.eU();
    if (!WearableActivity.b(this.Au)) {
      throw new IllegalStateException("Activity " + this.Au.toString() + " did not call through to super.onEnterAmbient()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.activity.a
 * JD-Core Version:    0.7.0.1
 */