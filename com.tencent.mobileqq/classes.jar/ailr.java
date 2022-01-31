import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ailr
  extends Handler
{
  private ailr(ailq paramailq) {}
  
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
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "MEDIA_PREPAREING ");
                    }
                    ailq.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
                    }
                    if (this.a.jdField_a_of_type_Ails != null) {
                      this.a.jdField_a_of_type_Ails.a(this.a.jdField_a_of_type_Ailz, this.a.b());
                    }
                    if (this.a.a())
                    {
                      this.a.m();
                      this.a.a(false);
                      return;
                    }
                    ailq.a(this.a, 3);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_Ails == null);
                  this.a.jdField_a_of_type_Ails.v();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                  }
                  ailq.a(this.a, true);
                  this.a.a(0);
                  this.a.b(0);
                  if (this.a.jdField_a_of_type_Ails != null) {
                    this.a.jdField_a_of_type_Ails.c(this.a.jdField_a_of_type_Ailz);
                  }
                  ailq.a(this.a, 0);
                  return;
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_Aijm == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_Aijm.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            ailq.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_Ails == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_Ails.d(this.a.jdField_a_of_type_Ailz);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_Ails.a(this.a.jdField_a_of_type_Ailz, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + ailq.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_Ails == null) || (!ailq.a(this.a)));
      this.a.jdField_a_of_type_Ails.b(this.a.jdField_a_of_type_Ailz, paramMessage.arg1);
    } while (ailq.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailr
 * JD-Core Version:    0.7.0.1
 */