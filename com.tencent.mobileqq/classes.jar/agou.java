import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.OnUseResListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.widget.ActionSheet;

public class agou
  implements AdapterView.OnItemClickListener
{
  public agou(ShareHelper paramShareHelper) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().isShowing()) {
      this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a().dismiss();
    }
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        paramInt = 2131435319;
      }
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        QRUtils.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435320;
        }
      }
      else
      {
        if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          QRUtils.a(1, 2131439090);
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener.a(true);
        switch ((int)paramLong)
        {
        default: 
          return;
        case 0: 
          ThreadManager.postImmediately(new agov(this), null, true);
          return;
        case 1: 
          ThreadManager.postImmediately(new agox(this), null, true);
          return;
        }
        ThreadManager.postImmediately(new agoz(this, paramLong), null, true);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agou
 * JD-Core Version:    0.7.0.1
 */