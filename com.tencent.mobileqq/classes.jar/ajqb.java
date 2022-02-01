import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class ajqb
  extends Handler
{
  private ajqb(ajqa paramajqa) {}
  
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
                    ajqa.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
                    }
                    if (this.a.jdField_a_of_type_Ajqc != null) {
                      this.a.jdField_a_of_type_Ajqc.a(this.a.jdField_a_of_type_Ajqi, this.a.b());
                    }
                    if (this.a.a())
                    {
                      this.a.l();
                      this.a.a(false);
                      return;
                    }
                    ajqa.a(this.a, 3);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_Ajqc == null);
                  this.a.jdField_a_of_type_Ajqc.v();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                  }
                  ajqa.a(this.a, true);
                  this.a.a(0);
                  this.a.b(0);
                  if (this.a.jdField_a_of_type_Ajqc != null) {
                    this.a.jdField_a_of_type_Ajqc.c(this.a.jdField_a_of_type_Ajqi);
                  }
                  ajqa.a(this.a, 0);
                  return;
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_Ajoe == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_Ajoe.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            ajqa.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_Ajqc == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_Ajqc.d(this.a.jdField_a_of_type_Ajqi);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_Ajqc.a(this.a.jdField_a_of_type_Ajqi, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + ajqa.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_Ajqc == null) || (!ajqa.a(this.a)));
      this.a.jdField_a_of_type_Ajqc.b(this.a.jdField_a_of_type_Ajqi, paramMessage.arg1);
    } while (ajqa.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqb
 * JD-Core Version:    0.7.0.1
 */