import android.annotation.SuppressLint;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.tencent.TMG.utils.QLog;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class abwj
  extends abwk
{
  private static final String jdField_a_of_type_JavaLangString = "/proc/" + jdField_a_of_type_ArrayOfInt[0] + "/stat";
  private static final int[] jdField_a_of_type_ArrayOfInt = { Process.myPid() };
  @Nullable
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  @NonNull
  private long[] jdField_a_of_type_ArrayOfLong = new long[5];
  @Nullable
  private RandomAccessFile b;
  private boolean d = new File("/proc/stat").canRead();
  private boolean e = new File(jdField_a_of_type_JavaLangString).canRead();
  
  @SuppressLint({"InstanceMethodCanBeStatic"})
  @VisibleForTesting
  private RandomAccessFile a(String paramString)
  {
    return new RandomAccessFile(paramString, "r");
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.close();
      label19:
      if (this.jdField_b_of_type_JavaIoRandomAccessFile != null) {}
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile.close();
        return;
      }
      catch (IOException localIOException1) {}
    }
    catch (IOException localIOException2)
    {
      break label19;
    }
  }
  
  @Nullable
  public long[] a()
  {
    long l1;
    long l2;
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      long[] arrayOfLong1;
      if (!bool) {
        arrayOfLong1 = null;
      }
      for (;;)
      {
        return arrayOfLong1;
        Arrays.fill(this.jdField_a_of_type_ArrayOfLong, 0L);
        try
        {
          if (!this.d) {
            break label240;
          }
          if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
            this.jdField_b_of_type_JavaIoRandomAccessFile = a("/proc/stat");
          }
          this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
          Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)-1);
          if (this.jdField_b_of_type_JavaIoRandomAccessFile.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length) != -1) {
            break;
          }
          throw new IOException("read sys stats error");
        }
        catch (IOException localIOException)
        {
          this.jdField_a_of_type_Boolean = true;
          QLog.d("StatFileInfoCollector", 1, "", localIOException);
          a();
          Object localObject1 = null;
        }
      }
      this.c = 0;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = true;
      if (a())
      {
        a(' ');
        a(' ');
        l1 = a();
        l2 = a();
        long l3 = a();
        long l4 = a();
        long l5 = a();
        long l6 = a();
        long l7 = a();
        this.jdField_a_of_type_ArrayOfLong[0] = (l1 + l2 + l3 + l4 + l5 + l6 + l7);
        this.jdField_a_of_type_ArrayOfLong[1] = (this.jdField_a_of_type_ArrayOfLong[0] - l4);
      }
      label240:
      if (!this.e) {
        break label543;
      }
      if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
        this.jdField_a_of_type_JavaIoRandomAccessFile = a(jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
      Arrays.fill(this.jdField_a_of_type_ArrayOfByte, (byte)-1);
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length) == -1) {
        throw new IOException("read pid stats error");
      }
    }
    finally {}
    this.c = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
    int i = 0;
    while ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (a()) && (i < 13))
    {
      a(' ');
      i += 1;
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      l1 = a();
      l2 = a();
      this.jdField_a_of_type_ArrayOfLong[2] = (l1 + l2);
      break label557;
      label414:
      while ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (a()) && (i < 4))
      {
        a(' ');
        i += 1;
      }
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break label562;
      }
      this.jdField_a_of_type_ArrayOfLong[3] = a();
      break label562;
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (a()) && (i < 3))
      {
        a(' ');
        i += 1;
      }
      else
      {
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_a_of_type_ArrayOfLong[4] = a();
        }
        label543:
        this.jdField_a_of_type_Boolean = true;
        long[] arrayOfLong2 = this.jdField_a_of_type_ArrayOfLong;
        break;
        label557:
        i = 0;
        break label414;
        label562:
        i = 0;
      }
    }
  }
  
  protected void finalize()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwj
 * JD-Core Version:    0.7.0.1
 */