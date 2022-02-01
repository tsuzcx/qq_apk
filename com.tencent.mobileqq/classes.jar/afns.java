import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.ArrayList;
import java.util.List;

class afns
  implements anui
{
  afns(afnr paramafnr) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      int i = Integer.decode(bdgb.a(bdgb.c())).intValue();
      bdgb.a.clear();
      afnr.a().clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        afnu localafnu = new afnu(this.a, localItemDisDetail.itemId + "", localItemDisDetail.image, paramInt);
        if (i == localItemDisDetail.itemId) {
          localafnu.a = true;
        }
        afnr.a(this.a, null, localafnu);
        bdgb.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bdgb.c = paramInt;
        }
        afnr.a().add(localafnu);
        bmzn.a().a(bdgb.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        bdll.b(afnr.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(bdgb.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
        paramInt += 1;
      }
      paramInt = bdgb.a(i + "");
      bdgb.a(afnr.a(this.a).getCurrentAccountUin(), paramInt, 3);
      afnr.a(this.a).a(afnr.a());
      afnr.a(this.a).notifyDataSetChanged();
      if (paramInt < bdgb.a.size()) {
        afnr.a(this.a).scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afns
 * JD-Core Version:    0.7.0.1
 */