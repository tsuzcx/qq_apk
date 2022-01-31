package com.tencent.tinker.lib.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.tencent.tinker.lib.e.a;

@TargetApi(21)
public class TinkerPatchService$JobServiceRunner
  extends JobService
{
  private b ajQ = null;
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    this.ajQ = new b(this);
    this.ajQ.execute(new JobParameters[] { paramJobParameters });
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    a.b("Tinker.TinkerPatchService", "Stopping TinkerPatchJob service.", new Object[0]);
    if (this.ajQ != null)
    {
      this.ajQ.cancel(true);
      this.ajQ = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.JobServiceRunner
 * JD-Core Version:    0.7.0.1
 */