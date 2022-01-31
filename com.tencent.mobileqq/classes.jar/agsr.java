import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.commonsdk.cache.Sizeable;

public class agsr
  implements Sizeable
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private BitmapDrawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private int b;
  
  public agsr(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = paramArrayOfBitmapDrawable;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  private void a()
  {
    int i = 0;
    this.b = 0;
    BitmapDrawable[] arrayOfBitmapDrawable = this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
    int j = arrayOfBitmapDrawable.length;
    while (i < j)
    {
      BitmapDrawable localBitmapDrawable = arrayOfBitmapDrawable[i];
      if ((localBitmapDrawable != null) && (localBitmapDrawable.getBitmap() != null))
      {
        int k = this.b;
        this.b = (localBitmapDrawable.getBitmap().getByteCount() + k);
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public BitmapDrawable[] a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  }
  
  public int getByteSize()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsr
 * JD-Core Version:    0.7.0.1
 */