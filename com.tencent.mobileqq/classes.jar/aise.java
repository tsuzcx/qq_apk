import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloManager.20.1;
import com.tencent.mobileqq.apollo.data.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class aise
  extends bbwf
{
  aise(airz paramairz) {}
  
  public void onDoneFile(bbwg parambbwg)
  {
    if ((parambbwg == null) || (this.a.a == null)) {}
    String str1;
    do
    {
      return;
      if (parambbwg.a != 0)
      {
        QLog.e("ApolloManager", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(parambbwg.a()) });
        return;
      }
      str1 = parambbwg.c;
      parambbwg = parambbwg.a();
    } while (parambbwg == null);
    ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)parambbwg.getSerializable(str1);
    if (localApolloPreDownloadData == null)
    {
      QLog.e("ApolloManager", 1, "preDownloadListener res onDoneFile but preDownload data is null");
      return;
    }
    if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
    for (parambbwg = ApolloUtil.e(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; parambbwg = ajmu.t + localApolloPreDownloadData.resId + ".zip")
    {
      String str2 = ApolloUtil.e(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.dir;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str1 });
      }
      ThreadManager.getSubThreadHandler().post(new ApolloManager.20.1(this, localApolloPreDownloadData, parambbwg, str2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aise
 * JD-Core Version:    0.7.0.1
 */