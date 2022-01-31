import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;

public class aelt
  extends aels
{
  public Bitmap a;
  public AnimationView.AnimationInfo a;
  
  public aelt(String paramString)
  {
    super(paramString);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if (paramRedPacketInfo != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramRedPacketInfo.specialBackground;
      this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo = paramRedPacketInfo.specailBackgroundAnimInfo;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView$AnimationInfo != null) || (this.jdField_a_of_type_AndroidGraphicsBitmap != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelt
 * JD-Core Version:    0.7.0.1
 */