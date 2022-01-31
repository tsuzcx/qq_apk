import android.annotation.TargetApi;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConverterImpl;
import java.io.File;
import java.lang.ref.WeakReference;

@TargetApi(18)
public class aiiw
  implements VideoConverter.VideoConverterImpl
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Thread localThread = (Thread)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localThread != null) {
        localThread.interrupt();
      }
    }
    return true;
  }
  
  public boolean a(File paramFile, VideoConverter.Processor paramProcessor, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      paramFile = new Thread(new aiix(this, paramFile, paramProcessor), "VideoConvert");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramFile);
      paramFile.start();
      if (paramBoolean) {}
      try
      {
        paramFile.join();
        return true;
      }
      catch (InterruptedException paramFile)
      {
        paramFile.printStackTrace();
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aiiw
 * JD-Core Version:    0.7.0.1
 */