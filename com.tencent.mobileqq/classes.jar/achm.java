import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.Iterator;
import java.util.List;

public class achm
  extends ajsy
{
  public achm(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (paramLong1 != 0L) {}
    this.a.jdField_a_of_type_Long = paramLong2;
    this.a.jdField_b_of_type_Long = paramLong3;
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (paramBoolean))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2) {}
      TroopManager localTroopManager;
      TroopInfo localTroopInfo;
      StringBuffer localStringBuffer;
      for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = 3;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopTypeExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt)
      {
        localTroopManager = (TroopManager)this.a.app.getManager(52);
        localTroopInfo = localTroopManager.c(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        if (localTroopInfo == null) {
          break label359;
        }
        localTroopInfo.troopname = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName;
        localTroopInfo.dwGroupClassExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt;
        localTroopInfo.mGroupClassExtText = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopClassExtText;
        localTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
        localTroopInfo.hasSetNewTroopName = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopName;
        localTroopInfo.strLocation = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation;
        localTroopInfo.troopLat = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat;
        localTroopInfo.troopLon = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.size() <= 0)) {
          break label352;
        }
        localStringBuffer = new StringBuffer();
        Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuffer.append(str + "\n");
        }
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localTroopInfo.mTags = localStringBuffer.toString();
      label352:
      localTroopManager.b(localTroopInfo);
    }
    label359:
    if ((this.a.jdField_a_of_type_Int == 0) || (1 == this.a.jdField_a_of_type_Int)) {
      axqy.b(this.a.app, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.a.jdField_b_of_type_JavaLangString, "", "");
    }
    TroopInfoActivity.a(this.a, paramBoolean, paramLong, paramString, 0L, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     achm
 * JD-Core Version:    0.7.0.1
 */