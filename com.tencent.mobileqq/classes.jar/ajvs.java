import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.FaceDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;
import mqq.os.MqqHandler;

public class ajvs
  extends MqqHandler
{
  public ajvs(FaceDownloader paramFaceDownloader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    while (paramMessage.what != 100) {
      return;
    }
    int i = 0;
    label16:
    if (i < this.a.b.size())
    {
      paramMessage = (ajvv)this.a.b.get(i);
      if (paramMessage != null) {
        break label56;
      }
    }
    for (;;)
    {
      i += 1;
      break label16;
      break;
      label56:
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "handle download finish task.faceInfo=" + paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo + ",bitmap=" + paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if ((paramMessage != null) && (paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo != null) && (paramMessage.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.a.a.size() > 0))
      {
        int j = 0;
        while (j < this.a.a.size())
        {
          ((ajvt)this.a.a.get(j)).a(true, paramMessage.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramMessage.jdField_a_of_type_AndroidGraphicsBitmap);
          j += 1;
        }
      }
      this.a.b.remove(i);
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajvs
 * JD-Core Version:    0.7.0.1
 */