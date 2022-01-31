import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class ahmo
{
  private int jdField_a_of_type_Int = -1;
  volatile boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  
  static
  {
    if (!ahmo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public ahmo(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("RDDataPipe : Pipe Size <= 0");
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("RDDataPipe", 2, "RDDataPipe init, size:" + paramInt);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      throw new IOException("RDDataPipe : Pipe closed");
    }
  }
  
  private void d()
  {
    while (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int)
    {
      c();
      notifyAll();
      try
      {
        wait(100L);
      }
      catch (InterruptedException localInterruptedException)
      {
        QLog.e("RDDataPipe", 2, "awaitSpace, wait exception:" + localInterruptedException.toString());
      }
    }
  }
  
  public int a()
  {
    int i = -1;
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        throw new IOException("RDDataPipe : Pipe closed");
      }
    }
    finally {}
    for (;;)
    {
      notifyAll();
      try
      {
        wait(1000L);
        if (this.jdField_a_of_type_Int < 0)
        {
          boolean bool = this.jdField_a_of_type_Boolean;
          if (!bool) {
            continue;
          }
          return i;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("RDDataPipe", 2, "read, wait exception:" + localInterruptedException);
            continue;
            byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
            i = this.jdField_b_of_type_Int;
            this.jdField_b_of_type_Int = (i + 1);
            int j = arrayOfByte[i] & 0xFF;
            if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ArrayOfByte.length) {
              this.jdField_b_of_type_Int = 0;
            }
            i = j;
            if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int)
            {
              this.jdField_a_of_type_Int = -1;
              i = j;
            }
          }
        }
      }
    }
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        c();
        i = paramInt2;
        j = paramInt1;
        if (i <= 0) {
          break label211;
        }
        if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
          d();
        }
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Int) {
          break label81;
        }
        paramInt1 = this.jdField_a_of_type_ArrayOfByte.length - this.jdField_a_of_type_Int;
      }
      finally {}
      if ((!jdField_b_of_type_Boolean) && (k <= 0))
      {
        throw new AssertionError();
        label81:
        if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int)
        {
          if (this.jdField_a_of_type_Int == -1)
          {
            this.jdField_b_of_type_Int = 0;
            this.jdField_a_of_type_Int = 0;
            paramInt1 = this.jdField_a_of_type_ArrayOfByte.length - this.jdField_a_of_type_Int;
            break label220;
          }
          paramInt1 = this.jdField_b_of_type_Int - this.jdField_a_of_type_Int;
          break label220;
        }
      }
      else
      {
        System.arraycopy(paramArrayOfByte, j, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, k);
        paramInt1 = i - k;
        int m = j + k;
        this.jdField_a_of_type_Int = (k + this.jdField_a_of_type_Int);
        i = paramInt1;
        j = m;
        if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfByte.length) {
          continue;
        }
        this.jdField_a_of_type_Int = 0;
        i = paramInt1;
        j = m;
        continue;
        label211:
        return paramInt2 - i;
      }
      paramInt1 = 0;
      label220:
      int k = paramInt1;
      if (paramInt1 > i) {
        k = i;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Int = -1;
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	ahmo:jdField_a_of_type_Int	I
    //   6: ifge +13 -> 19
    //   9: aload_0
    //   10: getfield 37	ahmo:jdField_a_of_type_ArrayOfByte	[B
    //   13: arraylength
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 28	ahmo:jdField_a_of_type_Int	I
    //   23: aload_0
    //   24: getfield 74	ahmo:jdField_b_of_type_Int	I
    //   27: if_icmpne +8 -> 35
    //   30: iconst_0
    //   31: istore_1
    //   32: goto -17 -> 15
    //   35: aload_0
    //   36: getfield 28	ahmo:jdField_a_of_type_Int	I
    //   39: aload_0
    //   40: getfield 74	ahmo:jdField_b_of_type_Int	I
    //   43: if_icmple +22 -> 65
    //   46: aload_0
    //   47: getfield 37	ahmo:jdField_a_of_type_ArrayOfByte	[B
    //   50: arraylength
    //   51: aload_0
    //   52: getfield 28	ahmo:jdField_a_of_type_Int	I
    //   55: aload_0
    //   56: getfield 74	ahmo:jdField_b_of_type_Int	I
    //   59: isub
    //   60: isub
    //   61: istore_1
    //   62: goto -47 -> 15
    //   65: aload_0
    //   66: getfield 74	ahmo:jdField_b_of_type_Int	I
    //   69: istore_1
    //   70: aload_0
    //   71: getfield 28	ahmo:jdField_a_of_type_Int	I
    //   74: istore_2
    //   75: iload_1
    //   76: iload_2
    //   77: isub
    //   78: istore_1
    //   79: goto -64 -> 15
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	ahmo
    //   14	65	1	i	int
    //   74	4	2	j	int
    //   82	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	82	finally
    //   19	30	82	finally
    //   35	62	82	finally
    //   65	75	82	finally
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramArrayOfByte == null) {
      try
      {
        throw new NullPointerException();
      }
      finally {}
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      paramInt2 = i;
    }
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return paramInt2;
          i = a();
          if (i >= 0) {
            break;
          }
          paramInt2 = -1;
        }
        paramInt2 = i;
      } while (this.jdField_a_of_type_Int < 0);
      paramInt2 = i;
    } while (j <= 1);
    if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int) {
      paramInt2 = Math.min(this.jdField_a_of_type_ArrayOfByte.length - this.jdField_b_of_type_Int, this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, paramArrayOfByte, paramInt1 + i, k);
      this.jdField_b_of_type_Int += k;
      paramInt2 = i + k;
      int k = j - k;
      if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ArrayOfByte.length) {
        this.jdField_b_of_type_Int = 0;
      }
      i = paramInt2;
      j = k;
      if (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int) {
        break;
      }
      this.jdField_a_of_type_Int = -1;
      i = paramInt2;
      j = k;
      break;
      paramInt2 = this.jdField_a_of_type_ArrayOfByte.length;
      k = this.jdField_b_of_type_Int;
      paramInt2 -= k;
      break label256;
      paramArrayOfByte[paramInt1] = ((byte)i);
      i = 1;
      j = paramInt2;
      break;
      label256:
      k = paramInt2;
      if (paramInt2 > j - 1) {
        k = j - 1;
      }
    }
  }
  
  public void b()
  {
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {}
    while ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0) || (paramInt2 == 0)) {
      return 0;
    }
    return a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahmo
 * JD-Core Version:    0.7.0.1
 */