import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.utilities.BusinessCardUtils.2;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class alqg
{
  public static BusinessCard a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (alov)paramQQAppInterface.getManager(112);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.a();; paramQQAppInterface = null)
    {
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = new BusinessCard();
      }
      return localObject;
    }
  }
  
  public static BusinessCard a(QQAppInterface paramQQAppInterface, atwx paramatwx)
  {
    alov localalov = (alov)paramQQAppInterface.getManager(112);
    if (paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
      paramQQAppInterface = localalov.a();
    }
    for (;;)
    {
      paramatwx = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramatwx = new BusinessCard();
      }
      return paramatwx;
      if (paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard != null)
      {
        paramQQAppInterface = paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.getCardInfo();
        if ((paramatwx.jdField_a_of_type_ComTencentMobileqqDataCard.hasCardInfo()) && (!TextUtils.isEmpty(paramQQAppInterface.cardId))) {
          localalov.a(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramQQAppInterface);
        } else {
          paramQQAppInterface = localalov.b(paramatwx.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = 1000;
      localURLDrawableOptions.mRequestHeight = 600;
      ThreadManager.post(new BusinessCardUtils.2(URLDrawable.getDrawable(paramString, localURLDrawableOptions)), 8, null, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorCode", String.valueOf(paramInt));
    awrn.a(BaseApplicationImpl.getContext()).a(paramString, "ocr_user_edit_action_report", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramURLImageView == null)) {}
    do
    {
      return;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
        localURLDrawableOptions.mLoadingDrawable = paramURLImageView.getContext().getResources().getDrawable(2130844048);
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
        paramURLImageView.setURLDrawableDownListener(new alqh(paramURLImageView));
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("BusinessCard", 2, "error " + paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     alqg
 * JD-Core Version:    0.7.0.1
 */