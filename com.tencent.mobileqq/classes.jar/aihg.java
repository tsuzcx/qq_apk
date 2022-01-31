import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aihg
  extends MqqHandler
{
  public aihg(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          bcql.a(this.a, 2131719565, 0).a();
          return;
          String str = this.a.getString(2131719566);
          paramMessage = (String)paramMessage.obj;
          bcql.a(this.a.jdField_a_of_type_AndroidContentContext, 2, str + paramMessage, 0).a();
          bbef.a(this.a, paramMessage);
          return;
          paramMessage = bbdj.a(this.a.jdField_a_of_type_AndroidContentContext, 232, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719598), this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719597), 2131719580, 2131718724, new aihh(this), new aihi(this));
          ShortVideoPlayActivity.a(this.a, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
          }
        } while ((this.a.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
        ((TVK_IMediaPlayer)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setDownloadNetworkChange(1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
        }
        if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((TVK_IMediaPlayer)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setDownloadNetworkChange(2);
        }
        if ((this.a.b != 1) && (this.a.b != 2)) {
          break;
        }
      } while (!this.a.b());
      this.a.j();
      this.a.r();
      return;
    } while ((this.a.b != 0) && (this.a.b != 5));
    ShortVideoPlayActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aihg
 * JD-Core Version:    0.7.0.1
 */