import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.ImgUpdateListener.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aisv
  implements aitl
{
  public aiss a;
  
  public aisv(aiss paramaiss)
  {
    this.a = paramaiss;
  }
  
  public void a(List<aism> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "data=" + paramList.size());
      }
      aiss.a(this.a);
      ThreadManager.getUIHandler().post(new StickerRecBarAdapter.ImgUpdateListener.1(this, paramInt, paramString3, paramString1, paramList, paramString2));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("StickerRecBarAdapter", 2, "mAdapter is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisv
 * JD-Core Version:    0.7.0.1
 */