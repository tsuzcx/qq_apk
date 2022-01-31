import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;

public class agzz
  implements HWEncodeListener
{
  public agzz(MergeEditVideo paramMergeEditVideo, int[] paramArrayOfInt) {}
  
  public void a() {}
  
  public void a(String arg1)
  {
    StoryReportor.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { ??? });
    synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo))
    {
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable arg2)
  {
    String str;
    if (??? != null) {
      str = ???.getMessage();
    }
    for (;;)
    {
      StoryReportor.b("video_edit", "reEncodeResult", this.jdField_a_of_type_ArrayOfInt[0], 0, new String[] { "", str });
      SLog.e("MergeEditVideo", "encode error errorCode = " + paramInt + " Exception = " + ???);
      MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, paramInt);
      synchronized (MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo))
      {
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo, true);
        MergeEditVideo.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecMergeEditVideo).notifyAll();
        return;
        str = "UNKNOWN ERROR";
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzz
 * JD-Core Version:    0.7.0.1
 */