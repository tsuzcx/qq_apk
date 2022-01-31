package com.tencent.tinker.lib.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.tencent.tinker.lib.f.a;

@TargetApi(21)
public class TinkerPatchService$JobServiceRunner
  extends JobService
{
  private TinkerPatchService.JobServiceRunner.a wWf = null;
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    this.wWf = new TinkerPatchService.JobServiceRunner.a(this);
    this.wWf.execute(new JobParameters[] { paramJobParameters });
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    a.w("Tinker.TinkerPatchService", "Stopping TinkerPatchJob service.", new Object[0]);
    if (this.wWf != null)
    {
      this.wWf.cancel(true);
      this.wWf = null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.TinkerPatchService.JobServiceRunner
 * JD-Core Version:    0.7.0.1
 */