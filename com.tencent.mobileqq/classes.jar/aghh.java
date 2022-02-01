import android.graphics.Rect;
import java.util.List;

public class aghh
{
  private int jdField_a_of_type_Int = -1;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public aghh(int paramInt)
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
      int i = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return i;
    }
    return -1;
  }
  
  private final void b(int paramInt)
  {
    a(aggi.a(paramInt), false);
  }
  
  public float a()
  {
    int i = b();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.b >= this.jdField_a_of_type_Int + 4) && (i == 4))
    {
      i = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
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
      i = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
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
      long l = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 8;
      return l;
    }
    return -1L;
  }
  
  public aghi a()
  {
    aghi localaghi = new aghi(this);
    localaghi.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaghi.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = -1;
    return localaghi;
  }
  
  public Rect a()
  {
    int i = b();
    if (i == -1) {}
    while ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Int + 16 > this.b) || (i != 16)) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.top = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.right = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.bottom = aggi.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    return localRect;
  }
  
  public final <T> Object a(aghk<T> paramaghk)
  {
    b();
    return paramaghk.a(this);
  }
  
  public final void a(float paramFloat)
  {
    a(aggi.a(Float.floatToIntBits(paramFloat)), true);
  }
  
  public final void a(int paramInt)
  {
    a(aggi.a(paramInt), true);
  }
  
  public final void a(long paramLong)
  {
    a(aggi.a(paramLong), true);
  }
  
  public final void a(aghj paramaghj)
  {
    if (paramaghj != null)
    {
      int i = this.jdField_a_of_type_Int;
      b(0);
      paramaghj.a(this, 0);
      int j = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        System.arraycopy(aggi.a(j - i - 4), 0, this.jdField_a_of_type_ArrayOfByte, i, 4);
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
    byte[] arrayOfByte2 = aggi.a(paramRect.left);
    byte[] arrayOfByte3 = aggi.a(paramRect.top);
    byte[] arrayOfByte4 = aggi.a(paramRect.right);
    paramRect = aggi.a(paramRect.bottom);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 4, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 8, 4);
    System.arraycopy(paramRect, 0, arrayOfByte1, 12, 4);
    a(arrayOfByte1, true);
  }
  
  public final <T extends aghj> void a(List<T> paramList)
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
      aghj localaghj = (aghj)paramList.get(i);
      if (localaghj == null) {
        break label67;
      }
      b(1);
      localaghj.a(this, 0);
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
  
  public final <T> void a(List<T> paramList, aghk<T> paramaghk)
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
          paramList.set(j, paramaghk.a(this));
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
        paramList.add(paramaghk.a(this));
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
 * Qualified Name:     aghh
 * JD-Core Version:    0.7.0.1
 */