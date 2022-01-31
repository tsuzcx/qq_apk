import android.text.TextUtils;
import com.tencent.qidian.PhotoWallViewForQiDianProfile.PhotoWallCallback;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.CompanyShowCaseInfo;

public class akxk
  implements PhotoWallViewForQiDianProfile.PhotoWallCallback
{
  public akxk(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void a(CompanyShowCaseInfo paramCompanyShowCaseInfo)
  {
    if (paramCompanyShowCaseInfo != null)
    {
      paramCompanyShowCaseInfo = paramCompanyShowCaseInfo.b;
      if (!TextUtils.isEmpty(paramCompanyShowCaseInfo)) {
        QidianProfileCardActivity.a(this.a, paramCompanyShowCaseInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akxk
 * JD-Core Version:    0.7.0.1
 */