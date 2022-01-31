import java.util.ArrayList;
import java.util.Arrays;

public class alct
{
  private int jdField_a_of_type_Int;
  private ArrayList<Long> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int b;
  
  public alct(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private int a(float paramFloat)
  {
    if ((paramFloat > 1.0F) || (paramFloat <= 0.0F)) {
      throw new IndexOutOfBoundsException("the percent out of index");
    }
    int j = (int)(this.jdField_a_of_type_JavaUtilArrayList.size() * paramFloat - 1.0F);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public alcu a()
  {
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    double d;
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        localObject = new alcu(-1L, -1L, -1L, -1L, -1L, -1.0D, null, 0);
        return localObject;
      }
      Object localObject = new long[this.jdField_a_of_type_JavaUtilArrayList.size()];
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject[i] = ((Long)this.jdField_a_of_type_JavaUtilArrayList.get(i)).longValue();
        i += 1;
      }
      Arrays.sort((long[])localObject);
      l1 = localObject[a(0.9F)];
      l2 = localObject[a(0.8F)];
      l3 = localObject[a(0.7F)];
      l4 = localObject[0];
      l5 = localObject[(localObject.length - 1)];
      d = 0.0D;
      i = 0;
      if (i < localObject.length)
      {
        d += localObject[i];
        i += 1;
      }
    }
    return new alcu(l1, l2, l3, l4, l5, d / arrayOfLong.length, arrayOfLong, this.b);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b = 0;
  }
  
  public boolean a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramLong))) {
      return false;
    }
    this.b += 1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     alct
 * JD-Core Version:    0.7.0.1
 */