package com.tencent.tinker.lib.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

final class b
  extends AsyncTask<JobParameters, Void, Void>
{
  private final WeakReference<JobService> ajR;
  
  b(JobService paramJobService)
  {
    this.ajR = new WeakReference(paramJobService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.b
 * JD-Core Version:    0.7.0.1
 */