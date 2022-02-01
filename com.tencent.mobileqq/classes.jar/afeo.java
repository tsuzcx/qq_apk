import QC.GetConciseThemeRsp;
import QC.ItemDisDetail;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import java.util.ArrayList;
import java.util.List;

class afeo
  implements anil
{
  afeo(afen paramafen) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetConciseThemeRsp)))
    {
      paramObject = (GetConciseThemeRsp)paramObject;
      int i = Integer.decode(bcnj.a(bcnj.c())).intValue();
      bcnj.a.clear();
      afen.a().clear();
      paramInt = 0;
      while (paramInt < paramObject.vItems.size())
      {
        ItemDisDetail localItemDisDetail = (ItemDisDetail)paramObject.vItems.get(paramInt);
        afeq localafeq = new afeq(this.a, localItemDisDetail.itemId + "", localItemDisDetail.image, paramInt);
        if (i == localItemDisDetail.itemId) {
          localafeq.a = true;
        }
        afen.a(this.a, null, localafeq);
        bcnj.a.add(localItemDisDetail.itemId + "");
        if (TextUtils.equals("2920", localItemDisDetail.itemId + "")) {
          bcnj.c = paramInt;
        }
        afen.a().add(localafeq);
        blyl.a().a(bcnj.a(localItemDisDetail.itemId), "4", "platform898", "4", "1", 101, 1, System.currentTimeMillis());
        bcst.b(afen.a(this.a).app, "dc00898", "", "", "qq_vip", "0X800B15B", Integer.decode(bcnj.a(localItemDisDetail.itemId)).intValue(), 0, "", "", "", "");
        paramInt += 1;
      }
      paramInt = bcnj.a(i + "");
      bcnj.a(afen.a(this.a).getCurrentAccountUin(), paramInt, 3);
      afen.a(this.a).a(afen.a());
      afen.a(this.a).notifyDataSetChanged();
      if (paramInt < bcnj.a.size()) {
        afen.a(this.a).scrollToPosition(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afeo
 * JD-Core Version:    0.7.0.1
 */