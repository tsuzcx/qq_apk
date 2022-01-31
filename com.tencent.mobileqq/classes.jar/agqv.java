import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class agqv
  extends Handler
{
  private agqv(agqu paramagqu) {}
  
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
                    agqu.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
                    }
                    if (this.a.jdField_a_of_type_Agqw != null) {
                      this.a.jdField_a_of_type_Agqw.a(this.a.jdField_a_of_type_Agrc, this.a.b());
                    }
                    if (this.a.a())
                    {
                      this.a.m();
                      this.a.a(false);
                      return;
                    }
                    agqu.a(this.a, 3);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_Agqw == null);
                  this.a.jdField_a_of_type_Agqw.v();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                  }
                  agqu.a(this.a, true);
                  this.a.a(0);
                  this.a.b(0);
                  if (this.a.jdField_a_of_type_Agqw != null) {
                    this.a.jdField_a_of_type_Agqw.c(this.a.jdField_a_of_type_Agrc);
                  }
                  agqu.a(this.a, 0);
                  return;
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_Agmg == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_Agmg.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            agqu.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_Agqw == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_Agqw.d(this.a.jdField_a_of_type_Agrc);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_Agqw.a(this.a.jdField_a_of_type_Agrc, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + agqu.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_Agqw == null) || (!agqu.a(this.a)));
      this.a.jdField_a_of_type_Agqw.b(this.a.jdField_a_of_type_Agrc, paramMessage.arg1);
    } while (agqu.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqv
 * JD-Core Version:    0.7.0.1
 */