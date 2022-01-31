import android.os.AsyncTask;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwThumbGen;
import com.tencent.mobileqq.utils.FileUtils;

class ahnt
  extends AsyncTask
{
  ahnt(ahns paramahns) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    long l = System.currentTimeMillis();
    paramVarArgs = ahns.a(this.a) + "shortvideo_thumb.jpg";
    int j = this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.a(ahns.b(this.a), SVHwEncoder.f(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.g(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), SVHwEncoder.b(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder), paramVarArgs);
    int i = j;
    String str;
    if (j == 0)
    {
      str = ShortVideoUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_JavaLangString, "jpg");
      if (!FileUtils.c(paramVarArgs, str)) {
        break label177;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.b = str;
      i = j;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
      this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwThumbGen.jdField_a_of_type_Int = i;
      ahns.a(this.a, true);
      return Integer.valueOf(i);
      label177:
      i = j;
      if (!FileUtils.b(str))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a("doInBackground()", "rename failure, mThumbFilePath = " + paramVarArgs + ",thumbPath=" + str);
        i = -3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnt
 * JD-Core Version:    0.7.0.1
 */