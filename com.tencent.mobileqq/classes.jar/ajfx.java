import android.text.TextUtils;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.fragment.TroopMoreDetailFragment;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajfx
  extends TroopObserver
{
  public ajfx(TroopMoreDetailFragment paramTroopMoreDetailFragment) {}
  
  protected void b(boolean paramBoolean, long paramLong1, int paramInt1, List paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.b(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if ((this.a.b) || (!TextUtils.equals(this.a.jdField_a_of_type_JavaLangString, String.valueOf(paramLong1))) || (paramInt1 != 2)) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
      } while ((paramList == null) || (paramList.isEmpty()) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null));
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(paramList);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("TroopMoreDetailFragment", 2, "onOIDB0X899_0_Ret, result = " + paramInt2 + "strErrorMsg = " + paramString);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfx
 * JD-Core Version:    0.7.0.1
 */