import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class agtt
  implements aguj
{
  public agtq a;
  
  public agtt(agtq paramagtq)
  {
    this.a = paramagtq;
  }
  
  public void a(List<agtk> paramList, String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "data=" + paramList.size());
      }
      agtq.a(this.a);
      ThreadManager.getUIHandler().post(new StickerRecBarAdapter.ImgUpdateListener.1(this, paramString1, paramList, paramString2));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("StickerRecBarAdapter", 2, "mAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtt
 * JD-Core Version:    0.7.0.1
 */