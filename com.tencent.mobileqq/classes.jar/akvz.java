import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.ShoppingPhotoItemInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class akvz
  implements Runnable
{
  akvz(akvy paramakvy, ProfileShoppingPhotoInfo paramProfileShoppingPhotoInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo == null) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidViewLayoutInflater == null) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {
      return;
    }
    Object localObject1 = new ArrayList();
    Object localObject3 = (View)this.jdField_a_of_type_Akvy.a.jdField_a_of_type_JavaUtilHashMap.get("map_key_shopping_photo");
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970566, null);
      this.jdField_a_of_type_Akvy.a.jdField_a_of_type_JavaUtilHashMap.put("map_key_shopping_photo", localObject2);
    }
    localObject3 = (TextView)((View)localObject2).findViewById(2131371168);
    if ((this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)))
    {
      localObject3 = (TextView)((View)localObject2).findViewById(2131371168);
      ((TextView)localObject3).setText(this.jdField_a_of_type_Akvy.a.a(2131435728));
    }
    Object localObject4;
    Object localObject5;
    int j;
    int i;
    label418:
    Object localObject6;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo.getPhotoFromRawData();
      if (localObject1 == null) {
        break label500;
      }
      localObject4 = (LinearLayout)((View)localObject2).findViewById(2131371170);
      localObject5 = (LinearLayout)((View)localObject2).findViewById(2131371172);
      if (((List)localObject1).size() <= 0)
      {
        ((LinearLayout)localObject4).setVisibility(0);
        ((LinearLayout)localObject5).setVisibility(8);
        localObject4 = (TextView)((View)localObject2).findViewById(2131371171);
        ((TextView)localObject4).setText(this.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo.shopName);
        ProfileCardTemplate.a((View)localObject4, "color", this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
      }
    }
    else
    {
      j = this.jdField_a_of_type_Akvy.a.getResources().getDimensionPixelSize(2131559165);
      localObject5 = new ImageView[3];
      localObject5[0] = ((ImageView)((View)localObject2).findViewById(2131371173));
      localObject5[1] = ((ImageView)((View)localObject2).findViewById(2131371174));
      localObject5[2] = ((ImageView)((View)localObject2).findViewById(2131371175));
      i = 0;
      if (i >= localObject5.length) {
        break label660;
      }
      localObject6 = localObject5[i];
      if ((localObject1 == null) || (((List)localObject1).size() <= i)) {
        break label503;
      }
      localObject4 = ((ShoppingPhotoItemInfo)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString;
      label460:
      if ((!TextUtils.isEmpty((CharSequence)localObject4)) || (localObject6 == null)) {
        break label509;
      }
      localObject6.setVisibility(8);
    }
    for (;;)
    {
      i += 1;
      break label418;
      ((LinearLayout)localObject4).setVisibility(8);
      ((LinearLayout)localObject5).setVisibility(0);
      label500:
      break;
      label503:
      localObject4 = null;
      break label460;
      label509:
      if (localObject6 != null)
      {
        if (this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
          this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(this.jdField_a_of_type_Akvy.a.getResources().getColor(2131493015));
        }
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_Akvy.a.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localURLDrawableOptions.mRequestHeight = j;
          localURLDrawableOptions.mRequestWidth = j;
          localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
          localObject6.setVisibility(0);
          localObject6.setImageDrawable((Drawable)localObject4);
        }
        catch (Exception localException)
        {
          localObject6.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
        }
      }
    }
    label660:
    ((View)localObject2).setTag(new DataTag(41, null));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_Akvy.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    ((View)localObject2).setContentDescription(this.jdField_a_of_type_Akvy.a.a(2131427376));
    localObject1 = (ImageView)((View)localObject2).findViewById(2131371169);
    this.jdField_a_of_type_Akvy.a.a("map_key_shopping_photo", (TextView)localObject3, null, (ImageView)localObject1);
    this.jdField_a_of_type_Akvy.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvz
 * JD-Core Version:    0.7.0.1
 */