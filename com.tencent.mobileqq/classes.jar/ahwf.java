import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog.MenuItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;

public class ahwf
  extends FriendListObserver
{
  public ahwf(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (this.a.a == null) || (this.a.a.isFinishing()) || (this.a.a.app == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountOptPopBar", 2, "onUpdateCustomHead uin = " + paramString);
        }
        localObject = AssociatedAccountOptPopBar.a(this.a, paramString);
      } while (localObject == null);
      localObject = (FixSizeImageView)((View)localObject).findViewById(2131362701);
    } while (localObject == null);
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.a.a.app, 1, paramString);
    ((FixSizeImageView)localObject).setTag(paramString);
    ((FixSizeImageView)localObject).setImageDrawable(localFaceDrawable);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    TextView localTextView;
    LeftPopupMenuDialog.MenuItem localMenuItem;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountOptPopBar", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
          }
        } while ((this.a.a == null) || (this.a.a.isFinishing()) || (this.a.a.app == null));
        localView = AssociatedAccountOptPopBar.a(this.a, paramString);
      } while (localView == null);
      localTextView = (TextView)localView.findViewById(2131363360);
      localMenuItem = (LeftPopupMenuDialog.MenuItem)localView.getTag();
    } while ((localTextView == null) || (localMenuItem == null));
    Object localObject;
    if ((localMenuItem.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))
    {
      if (!TextUtils.equals(paramString, ((SubAccountInfo)localMenuItem.jdField_a_of_type_JavaLangObject).subuin)) {
        break label474;
      }
      localObject = ContactUtils.b(this.a.a.app, paramString, false);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label479;
      }
    }
    for (;;)
    {
      if (!paramString.equals(localMenuItem.jdField_a_of_type_JavaLangString))
      {
        localMenuItem.jdField_a_of_type_JavaLangString = paramString;
        paramBoolean = true;
      }
      for (;;)
      {
        label207:
        if (paramBoolean)
        {
          localTextView.setText(localMenuItem.jdField_a_of_type_JavaLangString);
          if (AppSetting.b) {
            if (localMenuItem.c != 0) {
              break label409;
            }
          }
        }
        label409:
        for (localMenuItem.b = (this.a.a.getString(2131436399, new Object[] { localMenuItem.jdField_a_of_type_JavaLangString }) + " " + this.a.a.getString(2131437109));; localMenuItem.b = (this.a.a.getString(2131436400, new Object[] { localMenuItem.jdField_a_of_type_JavaLangString }) + " " + this.a.a.getString(2131437109)))
        {
          AssociatedAccountOptPopBar.a(this.a, localView, localMenuItem);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AssociatedAccountOptPopBar", 2, "onUpdateFriendInfo needUpdate = " + paramBoolean);
          return;
          if (!(localMenuItem.jdField_a_of_type_JavaLangObject instanceof SimpleAccount)) {
            break label474;
          }
          localObject = (SimpleAccount)localMenuItem.jdField_a_of_type_JavaLangObject;
          if (!TextUtils.equals(paramString, ((SimpleAccount)localObject).getUin())) {
            break label474;
          }
          paramString = SubAccountControll.a(this.a.a.app, (SimpleAccount)localObject);
          if (paramString.equals(localMenuItem.jdField_a_of_type_JavaLangString)) {
            break label474;
          }
          localMenuItem.jdField_a_of_type_JavaLangString = paramString;
          paramBoolean = true;
          break label207;
        }
        label474:
        paramBoolean = false;
      }
      label479:
      paramString = (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahwf
 * JD-Core Version:    0.7.0.1
 */