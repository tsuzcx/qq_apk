import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.qphone.base.util.QLog;

public class alzj
  implements VideoDrawable.OnPlayRepeatListener
{
  public alzj(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void onPlayRepeat(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.dynamicAvatar", 2, "onPlayRepeat: " + paramInt);
    }
    if ((this.a.b) || (paramInt < 1)) {}
    while (this.a.a == null) {
      return;
    }
    Object localObject = this.a.a.jdField_a_of_type_ComTencentImageURLDrawable;
    if ((localObject instanceof URLDrawable))
    {
      localObject = ((URLDrawable)localObject).getCurrDrawable();
      if ((localObject instanceof VideoDrawable))
      {
        ((VideoDrawable)localObject).removeOnPlayRepeatListener(this);
        this.a.a.jdField_a_of_type_Alyy.a(this.a.a, true);
        if (QLog.isColorLevel()) {
          QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.03");
        }
      }
    }
    this.a.a.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzj
 * JD-Core Version:    0.7.0.1
 */