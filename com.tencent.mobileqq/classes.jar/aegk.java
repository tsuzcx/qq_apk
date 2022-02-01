import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.List;

class aegk
  implements BusinessObserver
{
  aegk(aegj paramaegj) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 1, new Object[] { "loadSimpleThemeListData isSuccess: ", Boolean.valueOf(paramBoolean) });
    }
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      int i = Integer.decode(bbyp.a(bbyp.c())).intValue();
      bbyp.a.clear();
      aegj.a().clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        aegm localaegm = new aegm(this.a, localItemDisDetail.itemId + "", localItemDisDetail.image, paramInt);
        if (i == localItemDisDetail.itemId) {
          localaegm.a = true;
        }
        aegj.a(this.a, null, localaegm);
        bbyp.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bbyp.c = paramInt;
        }
        aegj.a().add(localaegm);
        MobileReportManager.getInstance().reportAction(bbyp.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        bcef.b(aegj.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(bbyp.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
        paramInt += 1;
      }
      paramInt = bbyp.a(i + "");
      bbyp.a(aegj.a(this.a).getCurrentAccountUin(), paramInt, 3);
      aegj.a(this.a).a(aegj.a());
      aegj.a(this.a).notifyDataSetChanged();
      if (paramInt < bbyp.a.size()) {
        aegj.a(this.a).scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aegk
 * JD-Core Version:    0.7.0.1
 */