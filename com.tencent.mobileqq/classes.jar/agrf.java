import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class agrf
  implements Runnable
{
  public agrf(ProfileHeaderView paramProfileHeaderView, int paramInt, ProfileActivity.AllInOne paramAllInOne, String paramString) {}
  
  public void run()
  {
    Object localObject1 = null;
    int i = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getResources().getDimensionPixelSize(2131558565);
    Object localObject2;
    if (3 != this.jdField_a_of_type_Int)
    {
      localObject2 = (ImageView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
      if ((localObject2 instanceof DynamicAvatarView)) {
        ((DynamicAvatarView)localObject2).e = "";
      }
    }
    if (this.jdField_a_of_type_Int == 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) || (!ProfileCardUtil.a())) {
        break label464;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ProfileCardUtil.b();
        Object localObject4 = new File((String)localObject1);
        localObject2 = new BitmapFactory.Options();
        localObject4 = new FileInputStream((File)localObject4);
        ((BitmapFactory.Options)localObject2).inSampleSize = ((int)ImageUtil.a((InputStream)localObject4, i, i));
        ((InputStream)localObject4).close();
        localObject2 = BitmapManager.a((String)localObject1, (BitmapFactory.Options)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {}
      }
      catch (Exception localException1)
      {
        localObject2 = null;
      }
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((Bitmap)localObject2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 80) {
          break label459;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.b(this.jdField_a_of_type_JavaLangString, 16);
      }
      catch (Exception localException2)
      {
        break label245;
        Object localObject3 = localObject1;
        continue;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a(this.jdField_a_of_type_JavaLangString, true);
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new agrg(this, (Bitmap)localObject1));
      }
      return;
      label245:
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, localException1.toString());
        localObject1 = localObject2;
        continue;
        if (1 == this.jdField_a_of_type_Int)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11, this.jdField_a_of_type_JavaLangString, (byte)3, true, 0);
        }
        else
        {
          if (3 == this.jdField_a_of_type_Int)
          {
            localObject2 = (ImageView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
            if ((localObject2 instanceof DynamicAvatarView))
            {
              localObject2 = (DynamicAvatarView)localObject2;
              ((DynamicAvatarView)localObject2).e = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k);
              if (!ContactUtils.a(((DynamicAvatarView)localObject2).e)) {
                break label406;
              }
              ((DynamicAvatarView)localObject2).setTextSize(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getContext().getResources().getDimensionPixelSize(2131558478));
            }
            for (;;)
            {
              label406:
              try
              {
                localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getContext().getResources(), 2130840189);
                localObject1 = localObject2;
              }
              catch (OutOfMemoryError localOutOfMemoryError) {}
              ((DynamicAvatarView)localObject2).setTextSize(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getContext().getResources().getDimensionPixelSize(2131558479));
            }
          }
          if (2 == this.jdField_a_of_type_Int)
          {
            localObject1 = ImageUtil.b();
          }
          else
          {
            localObject1 = ImageUtil.a();
            continue;
            continue;
            label459:
            label464:
            localObject1 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agrf
 * JD-Core Version:    0.7.0.1
 */