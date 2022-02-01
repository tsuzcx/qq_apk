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

class aexs
  implements BusinessObserver
{
  aexs(aexr paramaexr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleUIChoiceView", 1, new Object[] { "loadSimpleThemeListData isSuccess: ", Boolean.valueOf(paramBoolean) });
    }
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      int i = Integer.decode(bdfk.a(bdfk.c())).intValue();
      bdfk.a.clear();
      aexr.a().clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        aexu localaexu = new aexu(this.a, localItemDisDetail.itemId + "", localItemDisDetail.image, paramInt);
        if (i == localItemDisDetail.itemId) {
          localaexu.a = true;
        }
        aexr.a(this.a, null, localaexu);
        bdfk.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bdfk.c = paramInt;
        }
        aexr.a().add(localaexu);
        MobileReportManager.getInstance().reportAction(bdfk.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        bdla.b(aexr.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(bdfk.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
        paramInt += 1;
      }
      paramInt = bdfk.a(i + "");
      bdfk.a(aexr.a(this.a).getCurrentAccountUin(), paramInt, 3);
      aexr.a(this.a).a(aexr.a());
      aexr.a(this.a).notifyDataSetChanged();
      if (paramInt < bdfk.a.size()) {
        aexr.a(this.a).scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexs
 * JD-Core Version:    0.7.0.1
 */