import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class acxl
{
  private String jdField_a_of_type_JavaLangString = "";
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private FileLock jdField_a_of_type_JavaNioChannelsFileLock;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public acxl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      acwx.a("KingKongUtils", "Initial FileChannel exception : " + paramString);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    acwx.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaNioChannelsFileLock != null) {}
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileLock.release();
      if (this.jdField_a_of_type_JavaNioChannelsFileChannel == null) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
        this.b = false;
        return;
        localIOException1 = localIOException1;
        acwx.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localIOException1);
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          acwx.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localIOException2);
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.b)) {
      return false;
    }
    acwx.a("KingKongUtils", "Do Inter-Process Lock " + this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileChannel = new RandomAccessFile(new File(this.jdField_a_of_type_JavaLangString), "rw").getChannel();
      this.jdField_a_of_type_JavaNioChannelsFileLock = this.jdField_a_of_type_JavaNioChannelsFileChannel.lock();
      this.b = true;
      acwx.a("KingKongUtils", "Do Inter-Process Lock OK " + this.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      acwx.a("KingKongUtils", "Do Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localException);
      if (this.jdField_a_of_type_JavaNioChannelsFileLock == null) {}
    }
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileLock.release();
      label166:
      if (this.jdField_a_of_type_JavaNioChannelsFileChannel != null) {}
      try
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
        label180:
        acwx.a("KingKongUtils", "Do Inter-Process Lock failed " + this.jdField_a_of_type_JavaLangString);
        return false;
      }
      catch (IOException localIOException1)
      {
        break label180;
      }
    }
    catch (IOException localIOException2)
    {
      break label166;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxl
 * JD-Core Version:    0.7.0.1
 */