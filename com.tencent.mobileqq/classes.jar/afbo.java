import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;

public final class afbo
  implements AdapterView.OnItemClickListener
{
  public afbo(ShareActionSheetBuilder paramShareActionSheetBuilder, BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
    if ((i == 9) || (i == 10)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131435335;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(paramInt), 0).b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDimensionPixelSize(2131558448));
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435336;
        }
      }
      else
      {
        paramAdapterView = this.jdField_a_of_type_JavaLangString;
        switch (i)
        {
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          return;
        case 2: 
          ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.b, paramAdapterView, this.c, this.d, this.e, false);
          return;
        case 3: 
          ShortVideoShareUtil.c(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.b, paramAdapterView, this.c, this.d, this.e);
          return;
        case 9: 
          ShortVideoShareUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.b, paramAdapterView, this.c, this.d, this.f);
          return;
        }
        ShortVideoShareUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.b, paramAdapterView, this.c, this.d, this.f);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afbo
 * JD-Core Version:    0.7.0.1
 */