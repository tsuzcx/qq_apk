package com.tencent.tinker.lib.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tinker.lib.a.a;

public class TinkerPatchForeService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    new a.a() {};
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchForeService
 * JD-Core Version:    0.7.0.1
 */