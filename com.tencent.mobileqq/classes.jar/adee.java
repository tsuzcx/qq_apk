import android.graphics.Rect;
import java.util.List;

public class adee
{
  private int jdField_a_of_type_Int = -1;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public adee(int paramInt)
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
      int i = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return i;
    }
    return -1;
  }
  
  private final void b(int paramInt)
  {
    a(addf.a(paramInt), false);
  }
  
  public float a()
  {
    int i = b();
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.b >= this.jdField_a_of_type_Int + 4) && (i == 4))
    {
      i = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
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
      i = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
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
      long l = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 8;
      return l;
    }
    return -1L;
  }
  
  public adef a()
  {
    adef localadef = new adef(this);
    localadef.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localadef.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = -1;
    return localadef;
  }
  
  public Rect a()
  {
    int i = b();
    if (i == -1) {}
    while ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_Int + 16 > this.b) || (i != 16)) {
      return null;
    }
    Rect localRect = new Rect();
    localRect.left = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.top = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.right = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    localRect.bottom = addf.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int += 4;
    return localRect;
  }
  
  public final <T> Object a(adeh<T> paramadeh)
  {
    b();
    return paramadeh.a(this);
  }
  
  public final void a(float paramFloat)
  {
    a(addf.a(Float.floatToIntBits(paramFloat)), true);
  }
  
  public final void a(int paramInt)
  {
    a(addf.a(paramInt), true);
  }
  
  public final void a(long paramLong)
  {
    a(addf.a(paramLong), true);
  }
  
  public final void a(adeg paramadeg)
  {
    if (paramadeg != null)
    {
      int i = this.jdField_a_of_type_Int;
      b(0);
      paramadeg.a(this, 0);
      int j = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        System.arraycopy(addf.a(j - i - 4), 0, this.jdField_a_of_type_ArrayOfByte, i, 4);
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
    byte[] arrayOfByte2 = addf.a(paramRect.left);
    byte[] arrayOfByte3 = addf.a(paramRect.top);
    byte[] arrayOfByte4 = addf.a(paramRect.right);
    paramRect = addf.a(paramRect.bottom);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 4, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 8, 4);
    System.arraycopy(paramRect, 0, arrayOfByte1, 12, 4);
    a(arrayOfByte1, true);
  }
  
  public final <T extends adeg> void a(List<T> paramList)
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
      adeg localadeg = (adeg)paramList.get(i);
      if (localadeg == null) {
        break label67;
      }
      b(1);
      localadeg.a(this, 0);
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
  
  public final <T> void a(List<T> paramList, adeh<T> paramadeh)
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
          paramList.set(j, paramadeh.a(this));
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
        paramList.add(paramadeh.a(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adee
 * JD-Core Version:    0.7.0.1
 */