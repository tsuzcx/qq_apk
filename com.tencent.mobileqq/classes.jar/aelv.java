import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aelv
  implements aeml
{
  public aels a;
  
  public aelv(aels paramaels)
  {
    this.a = paramaels;
  }
  
  public void a(List<aelm> paramList, String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "data=" + paramList.size());
      }
      aels.a(this.a);
      ThreadManager.getUIHandler().post(new StickerRecBarAdapter.ImgUpdateListener.1(this, paramString1, paramList, paramString2));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("StickerRecBarAdapter", 2, "mAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelv
 * JD-Core Version:    0.7.0.1
 */