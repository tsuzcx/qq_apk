import android.graphics.Bitmap;
import mqq.app.QQPermissionCallback;

class afsu
  implements QQPermissionCallback
{
  afsu(afsr paramafsr, Bitmap paramBitmap) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(afsr.a(this.jdField_a_of_type_Afsr), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Afsr.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsu
 * JD-Core Version:    0.7.0.1
 */