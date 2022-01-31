import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.Map;

public class aaui
  extends ajxj
{
  public aaui(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    super.onSetGenralSettingsTroopFilter(paramBoolean, paramMap);
    if ((paramMap == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null)) {
      return;
    }
    if (!paramBoolean) {
      if (paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin) != null) {
        bcql.a(this.a.app.getApp(), 1, this.a.getString(2131720549), 0).b(this.a.getTitleBarHeight());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
      paramMap = (Integer)paramMap.get(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
      if (paramMap != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask = paramMap.intValue();
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      l = Long.valueOf(paramString).longValue();
      if (l != 0L) {
        this.a.a(l);
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        long l = 0L;
      }
    }
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaui
 * JD-Core Version:    0.7.0.1
 */