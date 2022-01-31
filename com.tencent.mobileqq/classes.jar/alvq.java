import android.util.Log;
import cooperation.plugin.Dex2Oat;
import cooperation.plugin.Dex2Oat.ResultCallback;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class alvq
  implements Runnable
{
  private static String jdField_a_of_type_JavaLangString;
  private final Dex2Oat.ResultCallback jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback;
  private final File jdField_a_of_type_JavaIoFile;
  private final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private final boolean jdField_a_of_type_Boolean;
  private final File b;
  
  public alvq(File paramFile1, File paramFile2, boolean paramBoolean, String paramString, AtomicInteger paramAtomicInteger, CountDownLatch paramCountDownLatch, Dex2Oat.ResultCallback paramResultCallback)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile1;
    this.b = paramFile2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = paramAtomicInteger;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = paramCountDownLatch;
    this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback = paramResultCallback;
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    try
    {
      if ((!Dex2Oat.a(this.jdField_a_of_type_JavaIoFile)) && (this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback != null)) {
        this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback.a(this.jdField_a_of_type_JavaIoFile, this.b, new IOException("dex file " + this.jdField_a_of_type_JavaIoFile.getAbsolutePath() + " is not exist!"));
      }
      if (this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback != null) {
        this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback.a(this.jdField_a_of_type_JavaIoFile, this.b);
      }
      String str = Dex2Oat.a(this.jdField_a_of_type_JavaIoFile, this.b);
      DexFile.loadDex(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), str, 0);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      if (this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback != null) {
        this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback.a(this.jdField_a_of_type_JavaIoFile, this.b, new File(str));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("plugin_tag.Dex2Oat", "Failed to optimize dex: " + this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), localThrowable);
      if (this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback != null) {
        this.jdField_a_of_type_CooperationPluginDex2Oat$ResultCallback.a(this.jdField_a_of_type_JavaIoFile, this.b, localThrowable);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvq
 * JD-Core Version:    0.7.0.1
 */