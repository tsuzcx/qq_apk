import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;

public class agne
  extends agmy
{
  public aerc a;
  public Bitmap a;
  public boolean a;
  public Drawable[] a;
  
  public agne(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      this.jdField_a_of_type_Aerc = paramRedPacketInfo.jdField_a_of_type_Aerc;
      this.jdField_a_of_type_Boolean = paramRedPacketInfo.b;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidGraphicsBitmap != null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agne
 * JD-Core Version:    0.7.0.1
 */