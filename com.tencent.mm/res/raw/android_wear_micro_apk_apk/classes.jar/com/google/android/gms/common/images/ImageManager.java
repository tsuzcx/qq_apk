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
  private static final Object Kn = new Object();
  private static HashSet<Uri> Ko = new HashSet();
  private final ExecutorService Kp;
  private final b Kq;
  private final bt Kr;
  private final Map<e, ImageManager.ImageReceiver> Ks;
  private final Map<Uri, ImageManager.ImageReceiver> Kt;
  private final Map<Uri, Long> Ku;
  private final Handler dG;
  private final Context mContext;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager
 * JD-Core Version:    0.7.0.1
 */