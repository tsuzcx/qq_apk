import ProfileLogic.QC.setUserProfileRsp;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class alpp
  extends ajrp
{
  public alpp(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof setUserProfileRsp)))
    {
      i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mSvipObserver: [setUserProfileRsp] ret=" + i);
      }
      if (i == 0)
      {
        if (this.a.app != null)
        {
          paramObject = new ProfileActivity.AllInOne(this.a.app.getCurrentAccountUin(), 0);
          paramObject.g = 1;
          paramObject.h = 8;
          ProfileActivity.b(this.a, paramObject);
          bbmy.a(this.a, 0, 2131654640, 0).a();
        }
        this.a.finish();
      }
    }
    while (!"profilelogic.setUserProfile".equals(paramObject))
    {
      int i;
      return;
      bbmy.a(this.a, 1, 2131654637, 0).a();
      return;
    }
    bbmy.a(this.a, 1, 2131654637, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     alpp
 * JD-Core Version:    0.7.0.1
 */