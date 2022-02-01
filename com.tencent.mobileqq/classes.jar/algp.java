import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class algp
  extends Handler
{
  public algp(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      paramMessage = (algz)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d(DrawRedpacketPannelPreviewFragment.jdField_a_of_type_JavaLangString, 2, "save path: " + paramMessage.c + " thread name: " + Thread.currentThread().getName());
      }
      localFragmentActivity = this.a.getActivity();
    } while (localFragmentActivity == null);
    Intent localIntent = new Intent(localFragmentActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessage.c);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", localArrayList.size());
    localIntent.putExtra("uin", paramMessage.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramMessage.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramMessage.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_confess_topicid", paramMessage.jdField_b_of_type_Int);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    if (localArrayList.size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", localArrayList);
    }
    localFragmentActivity.startActivity(localIntent);
    localFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algp
 * JD-Core Version:    0.7.0.1
 */