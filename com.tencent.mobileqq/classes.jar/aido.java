import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class aido
{
  private BufferedReader jdField_a_of_type_JavaIoBufferedReader;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private InputStreamReader jdField_a_of_type_JavaIoInputStreamReader;
  public Process a;
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangProcess != null)
    {
      this.jdField_a_of_type_JavaIoInputStream = this.jdField_a_of_type_JavaLangProcess.getInputStream();
      this.jdField_a_of_type_JavaIoInputStreamReader = new InputStreamReader(this.jdField_a_of_type_JavaIoInputStream);
      this.jdField_a_of_type_JavaIoBufferedReader = new BufferedReader(this.jdField_a_of_type_JavaIoInputStreamReader);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangProcess != null) {}
    try
    {
      for (;;)
      {
        String str = this.jdField_a_of_type_JavaIoBufferedReader.readLine();
        if (str == null) {
          break;
        }
        HwVideoMerge.a("[@] compressVideo log:" + str, null);
      }
      label177:
      return;
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_JavaIoInputStream != null) {
            this.jdField_a_of_type_JavaIoInputStream.close();
          }
          if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
            this.jdField_a_of_type_JavaIoInputStreamReader.close();
          }
          if (this.jdField_a_of_type_JavaIoBufferedReader != null) {
            this.jdField_a_of_type_JavaIoBufferedReader.close();
          }
          return;
        }
        catch (IOException localIOException3) {}
        try
        {
          if (this.jdField_a_of_type_JavaIoInputStream != null) {
            this.jdField_a_of_type_JavaIoInputStream.close();
          }
          if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
            this.jdField_a_of_type_JavaIoInputStreamReader.close();
          }
          if (this.jdField_a_of_type_JavaIoBufferedReader == null) {
            continue;
          }
          this.jdField_a_of_type_JavaIoBufferedReader.close();
          return;
        }
        catch (IOException localIOException2)
        {
          return;
        }
      }
    }
    finally
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoInputStream != null) {
          this.jdField_a_of_type_JavaIoInputStream.close();
        }
        if (this.jdField_a_of_type_JavaIoInputStreamReader != null) {
          this.jdField_a_of_type_JavaIoInputStreamReader.close();
        }
        if (this.jdField_a_of_type_JavaIoBufferedReader != null) {
          this.jdField_a_of_type_JavaIoBufferedReader.close();
        }
      }
      catch (IOException localIOException4)
      {
        break label177;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aido
 * JD-Core Version:    0.7.0.1
 */