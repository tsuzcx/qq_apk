import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class akzs
{
  private int jdField_a_of_type_Int;
  BufferedInputStream jdField_a_of_type_JavaIoBufferedInputStream;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public akzs(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoBufferedInputStream = new BufferedInputStream(new FileInputStream(paramString));
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = 0;
    if ((this.c != 8) && (this.c != 16)) {
      throw new RuntimeException(String.format("bit deepth must be 8 or 16, current is %s", new Object[] { Integer.valueOf(this.c) }));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoBufferedInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoBufferedInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public byte[] a(long paramLong)
  {
    int i = (int)(this.jdField_a_of_type_Int * paramLong / 1000L) * this.b * (this.c / 8);
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    i = this.jdField_a_of_type_JavaIoBufferedInputStream.read(arrayOfByte1, this.d, i);
    if (i != -1) {
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    }
    QLog.d("AudioGenerator", 4, String.format("read index:%s, len: %s", new Object[] { Integer.valueOf(this.e), Integer.valueOf(i) }));
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akzs
 * JD-Core Version:    0.7.0.1
 */