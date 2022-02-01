import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tribe.async.async.JobSegment;

class ackm
  extends avrr<JobSegment>
{
  ackm(ackl paramackl, JobSegment paramJobSegment)
  {
    super(paramJobSegment);
  }
  
  public void a(JobSegment paramJobSegment, boolean paramBoolean, avro paramavro)
  {
    if (paramBoolean)
    {
      ackl.a(this.a, paramavro);
      return;
    }
    ackl.a(this.a, new AppInfoError(5, "appInfo error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackm
 * JD-Core Version:    0.7.0.1
 */