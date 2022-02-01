import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.1;
import com.tencent.qphone.base.util.QLog;

public class akdx
  implements akbj
{
  public akdx(DrawClassifier.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "tryPreDownLoadModel finished:" + paramInt);
    }
    if (paramInt == 0) {
      akdw.a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdx
 * JD-Core Version:    0.7.0.1
 */