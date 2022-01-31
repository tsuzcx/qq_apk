package com.tencent.tinker.lib.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import java.lang.ref.WeakReference;

final class TinkerPatchService$JobServiceRunner$a
  extends AsyncTask<JobParameters, Void, Void>
{
  private final WeakReference<JobService> wWg;
  
  TinkerPatchService$JobServiceRunner$a(JobService paramJobService)
  {
    this.wWg = new WeakReference(paramJobService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.JobServiceRunner.a
 * JD-Core Version:    0.7.0.1
 */