import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class agyi
  implements agyy
{
  public agyf a;
  
  public agyi(agyf paramagyf)
  {
    this.a = paramagyf;
  }
  
  public void a(List<agxz> paramList, String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "data=" + paramList.size());
      }
      agyf.a(this.a);
      ThreadManager.getUIHandler().post(new StickerRecBarAdapter.ImgUpdateListener.1(this, paramString1, paramList, paramString2));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("StickerRecBarAdapter", 2, "mAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyi
 * JD-Core Version:    0.7.0.1
 */