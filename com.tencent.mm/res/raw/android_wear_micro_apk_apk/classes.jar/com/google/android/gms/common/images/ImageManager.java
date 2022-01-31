package com.google.android.gms.common.images;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import com.google.android.gms.internal.bt;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager
{
  private static final Object Iy = new Object();
  private static HashSet<Uri> Iz = new HashSet();
  private final ExecutorService IA;
  private final b IB;
  private final bt IC;
  private final Map<e, ImageManager.ImageReceiver> ID;
  private final Map<Uri, ImageManager.ImageReceiver> IE;
  private final Map<Uri, Long> IF;
  private final Context mContext;
  private final Handler mHandler;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */