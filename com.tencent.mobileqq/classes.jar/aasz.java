import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.arcard.ARCardShareHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class aasz
  implements AdapterView.OnItemClickListener
{
  public aasz(ARCardShareHelper paramARCardShareHelper) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label80;
      }
    }
    label80:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ARCardShareHelper", 2, bool);
      if (this.a.a.a().isShowing()) {
        this.a.a.a().dismiss();
      }
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.c;
    if (!this.a.a())
    {
      QRUtils.a(1, 2131433149);
      return;
    }
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
      ThreadManager.postImmediately(new aata(this, i), null, true);
      return;
    case 3: 
      ThreadManager.postImmediately(new aatc(this), null, true);
      return;
    }
    if (!WXShareHelper.a().a()) {
      paramInt = 2131435335;
    }
    for (;;)
    {
      if (paramInt != -1)
      {
        QRUtils.a(1, paramInt);
        return;
        if (!WXShareHelper.a().b()) {
          paramInt = 2131435336;
        }
      }
      else
      {
        ThreadManager.postImmediately(new aate(this, i), null, true);
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasz
 * JD-Core Version:    0.7.0.1
 */