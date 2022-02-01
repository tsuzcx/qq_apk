import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.face.FaceDrawable;

class aiep
  extends anvi
{
  aiep(aido paramaido, ImageView paramImageView) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_Aido.getSessionInfo().curFriendUin))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_Aido.app, paramString, (byte)3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiep
 * JD-Core Version:    0.7.0.1
 */