import android.graphics.Rect;
import java.util.List;

public class afav
{
  private int jdField_a_of_type_Int = -1;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public afav(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      this.jdField_a_of_type_Int = 0;
      this.b = paramInt;
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {}
    while (this.jdField_a_of_type_ArrayOfByte == null) {
      return;
    }
    int j = paramArrayOfByte.length;
    int i = j;
    if (paramBoolean) {
      i = j + 4;
    }
    if (this.jdField_a_of_type_ArrayOfByte.length > this.jdField_a_of_type_Int + i)
    {
      if (paramBoolean) {
        b(paramArrayOfByte.length);
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte.length);
      this.jdField_a_of_type_Int += paramArrayOfByte.length;
      return;
    }
    byte[] arrayOfByte = new byte[i + this.jdField_a_of_type_ArrayOfByte.length * 2];
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    this.b = arrayOfByte.length;
    if (paramBoolean) {
      b(paramArrayOfByte.length);
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte.length);
    this.jdField_a_of_type_Int += paramArrayOfByte.length;
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int + 4 <= this.b))
    {
      int i = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return i;
    }
    return -1;
  }
  
  private final void b(int paramInt)
  {
    a(aezw.a(paramInt), false);
  }
  
  public float a()
  {
    int i = b();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.b >= this.jdField_a_of_type_Int + 4) && (i == 4))
    {
      i = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return Float.intBitsToFloat(i);
    }
    return -1.0F;
  }
  
  public int a()
  {
    int i = b();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int + 4 <= this.b) && (i == 4))
    {
      i = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return i;
    }
    return -1;
  }
  
  public long a()
  {
    int i = b();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.b >= this.jdField_a_of_type_Int + 8) && (i == 8))
    {
      long l = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 8;
      return l;
    }
    return -1L;
  }
  
  public afaw a()
  {
    afaw localafaw = new afaw(this);
    localafaw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localafaw.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = -1;
    return localafaw;
  }
  
  public Rect a()
  {
    int i = b();
    if (i == -1) {}
    while ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Int + 16 > this.b) || (i != 16)) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.top = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.right = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.bottom = aezw.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    return localRect;
  }
  
  public final <T> Object a(afay<T> paramafay)
  {
    b();
    return paramafay.a(this);
  }
  
  public final void a(float paramFloat)
  {
    a(aezw.a(Float.floatToIntBits(paramFloat)), true);
  }
  
  public final void a(int paramInt)
  {
    a(aezw.a(paramInt), true);
  }
  
  public final void a(long paramLong)
  {
    a(aezw.a(paramLong), true);
  }
  
  public final void a(afax paramafax)
  {
    if (paramafax != null)
    {
      int i = this.jdField_a_of_type_Int;
      b(0);
      paramafax.a(this, 0);
      int j = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        System.arraycopy(aezw.a(j - i - 4), 0, this.jdField_a_of_type_ArrayOfByte, i, 4);
      }
    }
  }
  
  public final void a(Rect paramRect)
  {
    if (paramRect == null)
    {
      b(-1);
      return;
    }
    byte[] arrayOfByte1 = new byte[16];
    byte[] arrayOfByte2 = aezw.a(paramRect.left);
    byte[] arrayOfByte3 = aezw.a(paramRect.top);
    byte[] arrayOfByte4 = aezw.a(paramRect.right);
    paramRect = aezw.a(paramRect.bottom);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 4, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 8, 4);
    System.arraycopy(paramRect, 0, arrayOfByte1, 12, 4);
    a(arrayOfByte1, true);
  }
  
  public final <T extends afax> void a(List<T> paramList)
  {
    if (paramList == null)
    {
      b(-1);
      return;
    }
    int j = paramList.size();
    b(j);
    int i = 0;
    label24:
    if (i < j)
    {
      afax localafax = (afax)paramList.get(i);
      if (localafax == null) {
        break label67;
      }
      b(1);
      localafax.a(this, 0);
    }
    for (;;)
    {
      i += 1;
      break label24;
      break;
      label67:
      b(0);
    }
  }
  
  public final <T> void a(List<T> paramList, afay<T> paramafay)
  {
    int k = paramList.size();
    int m = b();
    int j = 0;
    int i = j;
    if (j < k)
    {
      i = j;
      if (j < m)
      {
        if (b() != 0) {
          paramList.set(j, paramafay.a(this));
        }
        for (;;)
        {
          j += 1;
          break;
          paramList.set(j, null);
        }
      }
    }
    j = i;
    if (i < m)
    {
      if (b() != 0) {
        paramList.add(paramafay.a(this));
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.add(null);
      }
    }
    while (j < k)
    {
      paramList.remove(m);
      j += 1;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afav
 * JD-Core Version:    0.7.0.1
 */