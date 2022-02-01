import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class acai
{
  private static int g = 1000000000;
  public int a;
  public long a;
  public SosoInterface.SosoLbsInfo a;
  public String a;
  public List<String> a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public byte[] b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public acai()
  {
    g += 1;
    this.c = g;
  }
  
  public static void a(byte[] paramArrayOfByte, acai paramacai)
  {
    try
    {
      paramacai.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      int j;
      int i;
      if (paramArrayOfByte.remaining() > 2)
      {
        j = paramArrayOfByte.get();
        if (j == 0) {
          return;
        }
        i = j;
        switch (paramArrayOfByte.get())
        {
        }
      }
      for (;;)
      {
        for (;;)
        {
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          while (i >= 2)
          {
            paramacai.jdField_a_of_type_JavaUtilList.add(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) }));
            i = (byte)(i - 2);
          }
          if (j > 10)
          {
            if (j > 11) {
              paramArrayOfByte.get(new byte[j - 1 - 10]);
            }
            paramacai.jdField_a_of_type_Int = paramArrayOfByte.getInt();
            paramacai.jdField_a_of_type_ArrayOfByte = new byte[6];
            paramArrayOfByte.get(paramacai.jdField_a_of_type_ArrayOfByte);
            break;
          }
          paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
          break;
          if (j <= 2) {
            break label254;
          }
          try
          {
            if (paramArrayOfByte.getShort() != 513) {
              break;
            }
            paramacai.f = paramArrayOfByte.getShort();
            paramacai.e = paramArrayOfByte.getShort();
          }
          catch (Exception localException) {}
        }
        break;
        label254:
        paramArrayOfByte.position(j + paramArrayOfByte.position() - 1);
        break;
        return;
      }
      return;
    }
    catch (Throwable paramArrayOfByte) {}
  }
  
  public String a()
  {
    return this.b.replaceAll(":", "") + "0000";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acai
 * JD-Core Version:    0.7.0.1
 */