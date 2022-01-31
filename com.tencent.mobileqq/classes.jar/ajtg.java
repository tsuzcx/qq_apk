import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class ajtg
  extends Handler
{
  public ajtg(P2VEditMusicDialog paramP2VEditMusicDialog) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    case 4: 
    case 5: 
    case 10: 
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          this.a.b();
          if (this.a.jdField_a_of_type_Xki != null)
          {
            this.a.jdField_a_of_type_Xki.a(this.a.jdField_a_of_type_JavaUtilArrayList);
            this.a.jdField_a_of_type_Xki.notifyDataSetChanged();
          }
          paramMessage = this.a.jdField_a_of_type_Ajti.a();
          if (this.a.jdField_a_of_type_Xki != null) {
            this.a.jdField_a_of_type_Xki.a(paramMessage);
          }
          if (paramMessage == null) {
            break;
          }
          if (paramMessage.jdField_b_of_type_Int == 0)
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            return;
          }
          if (paramMessage.jdField_b_of_type_Int == 1)
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
            return;
          }
          if (!TextUtils.isEmpty(paramMessage.g))
          {
            this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
            return;
          }
        } while (!this.a.jdField_a_of_type_Boolean);
        this.a.jdField_a_of_type_Boolean = false;
        this.a.a(paramMessage);
        return;
        if (!this.a.jdField_a_of_type_Ajti.c())
        {
          this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          return;
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
        this.a.b();
        paramMessage = this.a.jdField_a_of_type_Ajti.a();
        if (paramMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(P2VEditMusicDialog.a(), 2, "MSG_PLAY_MUSIC music is NULL!!!!!");
      return;
      if (paramMessage.g == null)
      {
        QLog.e(P2VEditMusicDialog.a(), 2, "MSG_PLAY_MUSIC music.download_path is NULL!!!!!");
        return;
      }
      paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
      if (paramMessage.d < 0) {
        paramMessage.d = 0;
      }
      if (paramMessage.d + this.a.jdField_a_of_type_Int > paramMessage.f) {
        paramMessage.d = 0;
      }
      paramMessage.e = (paramMessage.d + this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_Ajti.a(3);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
      this.a.c();
      MusicHorizontalSeekView.a((this.a.a() + 500) / 1000, this.a.getContext().getResources().getDisplayMetrics().widthPixels - bdoo.a(8.0F));
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
      this.a.b(paramMessage.d, paramMessage.e);
      return;
    case 11: 
      this.a.b();
      paramMessage = this.a.jdField_a_of_type_Xkl;
      paramMessage.f = ((int)ShortVideoUtils.a(paramMessage.g));
      if (paramMessage.d < 0) {
        paramMessage.d = 0;
      }
      if (paramMessage.d + this.a.jdField_a_of_type_Int > paramMessage.f) {
        paramMessage.d = 0;
      }
      paramMessage.e = (paramMessage.d + this.a.jdField_a_of_type_Int);
      this.a.jdField_a_of_type_Ajti.a(paramMessage);
      this.a.jdField_a_of_type_Ajti.a(3);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.jdField_b_of_type_JavaLangString);
      this.a.c();
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setDurations((this.a.a() + 500) / 1000, (Math.max(paramMessage.f, this.a.jdField_a_of_type_Int) + 500) / 1000);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.a(paramMessage.d);
      this.a.b(paramMessage.d, paramMessage.e);
      return;
    case 3: 
      this.a.b();
      this.a.jdField_a_of_type_Ajti.a(xkl.jdField_a_of_type_Xkl);
      this.a.jdField_a_of_type_Ajti.a(0);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131708255));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    case 6: 
      this.a.b();
      this.a.jdField_a_of_type_Ajti.a(xkl.jdField_b_of_type_Xkl);
      this.a.jdField_a_of_type_Ajti.a(1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131708254));
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
      P2VEditMusicDialog.a(this.a);
      return;
    case 7: 
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a.getContext(), paramMessage, 0).a();
      return;
    case 8: 
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setPlayedPosition(this.a.jdField_b_of_type_Int);
      return;
    case 9: 
      if (this.a.jdField_a_of_type_AndroidWidgetProgressBar.getVisibility() != 0)
      {
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramMessage.arg1);
      return;
    }
    paramMessage = (xkl)paramMessage.obj;
    this.a.b(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtg
 * JD-Core Version:    0.7.0.1
 */