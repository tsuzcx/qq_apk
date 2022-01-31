import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class agqt
  extends Handler
{
  private agqt(agqs paramagqs) {}
  
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
                    agqs.a(this.a, 2);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onPrepared  getAutoPlayFlag=" + this.a.a());
                    }
                    if (this.a.jdField_a_of_type_Agqu != null) {
                      this.a.jdField_a_of_type_Agqu.a(this.a.jdField_a_of_type_Agra, this.a.b());
                    }
                    if (this.a.a())
                    {
                      this.a.m();
                      this.a.a(false);
                      return;
                    }
                    agqs.a(this.a, 3);
                    return;
                    if (QLog.isColorLevel()) {
                      QLog.d("carverW VideoPlayController", 2, "onSeekComplete");
                    }
                  } while (this.a.jdField_a_of_type_Agqu == null);
                  this.a.jdField_a_of_type_Agqu.v();
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("carverW VideoPlayController", 2, "onPlaybackComplete");
                  }
                  agqs.a(this.a, true);
                  this.a.a(0);
                  this.a.b(0);
                  if (this.a.jdField_a_of_type_Agqu != null) {
                    this.a.jdField_a_of_type_Agqu.c(this.a.jdField_a_of_type_Agra);
                  }
                  agqs.a(this.a, 0);
                  return;
                } while (!QLog.isColorLevel());
                QLog.d("carverW VideoPlayController", 2, "onVideoSizeChanged");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("carverW VideoPlayController", 2, "MEDIA_INSTALL_SUCCESS");
                }
              } while ((this.a.jdField_a_of_type_Agme == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
              this.a.jdField_a_of_type_AndroidViewView = this.a.jdField_a_of_type_Agme.a(this.a.jdField_a_of_type_AndroidAppActivity);
            } while ((this.a.jdField_a_of_type_AndroidViewView == null) || (this.a.jdField_a_of_type_AndroidAppActivity == null));
            agqs.a(this.a, this.a.jdField_a_of_type_AndroidAppActivity);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("carverW VideoPlayController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
            }
            this.a.a(paramMessage.arg1, paramMessage.arg2);
            return;
          } while (this.a.jdField_a_of_type_Agqu == null);
          if (paramMessage.arg1 == 929)
          {
            this.a.jdField_a_of_type_Agqu.d(this.a.jdField_a_of_type_Agra);
            this.a.b(8);
            return;
          }
        } while (paramMessage.arg1 != 92);
        this.a.jdField_a_of_type_Agqu.a(this.a.jdField_a_of_type_Agra, paramMessage.arg2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("carverW VideoPlayController", 2, "onDownloading isClickToStart=" + agqs.a(this.a));
        }
      } while ((this.a.jdField_a_of_type_Agqu == null) || (!agqs.a(this.a)));
      this.a.jdField_a_of_type_Agqu.b(this.a.jdField_a_of_type_Agra, paramMessage.arg1);
    } while (agqs.a(this.a) == 4);
    this.a.b(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqt
 * JD-Core Version:    0.7.0.1
 */