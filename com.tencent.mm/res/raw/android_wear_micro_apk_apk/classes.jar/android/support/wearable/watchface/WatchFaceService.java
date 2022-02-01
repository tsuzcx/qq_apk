package android.support.wearable.watchface;

import android.annotation.TargetApi;
import android.service.wallpaper.WallpaperService;

@TargetApi(21)
public abstract class WatchFaceService
  extends WallpaperService
{
  private static final String[] Ho = { "charging", "airplane_mode", "connected", "theater_mode", "gps_active", "interruption_filter" };
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.watchface.WatchFaceService
 * JD-Core Version:    0.7.0.1
 */