import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class aksl
  extends Handler
{
  private aksl(aksk paramaksk) {}
  
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
                    aksk.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
                    }
                    if (this.a.jdField_a_of_type_Aksm != null) {
                      this.a.jdField_a_of_type_Aksm.a(this.a.jdField_a_of_type_Akss, this.a.b());
                    }
                    if (this.a.a())
                    {
                      this.a.l();
                      this.a.a(false);
                      return;
                    }
                    aksk.a(this.a, 3);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_Aksm == null);
                  this.a.jdField_a_of_type_Aksm.v();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                  }
                  aksk.a(this.a, true);
                  this.a.a(0);
                  this.a.b(0);
                  if (this.a.jdField_a_of_type_Aksm != null) {
                    this.a.jdField_a_of_type_Aksm.c(this.a.jdField_a_of_type_Akss);
                  }
                  aksk.a(this.a, 0);
                  return;
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_Akqg == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_Akqg.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            aksk.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_Aksm == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_Aksm.d(this.a.jdField_a_of_type_Akss);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_Aksm.a(this.a.jdField_a_of_type_Akss, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + aksk.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_Aksm == null) || (!aksk.a(this.a)));
      this.a.jdField_a_of_type_Aksm.b(this.a.jdField_a_of_type_Akss, paramMessage.arg1);
    } while (aksk.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksl
 * JD-Core Version:    0.7.0.1
 */