import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class adri
  extends aofu
{
  public adri(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void onAddRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
    ChatSettingForTroop.a(this.a, true);
  }
  
  protected void onDelRobotByWeb(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    ChatSettingForTroop.a(this.a, true);
  }
  
  protected void onDeleteRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    if (!paramBoolean) {}
    String str;
    do
    {
      return;
      str = paramLong1 + "";
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!str.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)));
    ChatSettingForTroop.a(this.a, true);
  }
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    super.onDeleteTroopMember(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean) {
      if (paramInt == 2) {
        QQToast.a(this.a, 1, anvx.a(2131701250), 0).b(this.a.getTitleBarHeight());
      }
    }
    Object localObject1;
    do
    {
      return;
      localObject2 = "";
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        localObject1 = localObject2;
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null) {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
        }
      }
    } while (this.a.e == null);
    Object localObject2 = new HashSet();
    if ((paramString != null) && (paramString.equals(localObject1)))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (String)paramArrayList.next();
        localObject1 = this.a.e.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)((Iterator)localObject1).next();
          if (paramString.equals(localmemberlist.uint64_member_uin.get() + "")) {
            ((Collection)localObject2).add(localmemberlist);
          }
        }
      }
      paramArrayList = ((Collection)localObject2).iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (oidb_0x899.memberlist)paramArrayList.next();
        this.a.e.remove(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "onDeleteTroopMember,memberListForCard.size = " + this.a.e.size());
    }
    this.a.a(this.a.e);
  }
  
  protected void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    while (paramInt2 != 512) {
      return;
    }
    if (paramBoolean)
    {
      aomi.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      return;
    }
    ChatSettingForTroop.b(this.a);
  }
  
  protected void onTroopFileRedDotForTimShow(boolean paramBoolean, String paramString)
  {
    super.onTroopFileRedDotForTimShow(paramBoolean, paramString);
    ChatSettingForTroop.a(this.a);
  }
  
  protected void onTroopFlagExt4Changed(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramString = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          } while (paramString == null);
          bhdf.a(this.a.app.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramString.isTroopGameCardEnabled());
        } while (this.a.jdField_a_of_type_ArrayOfAndroidViewView == null);
        paramString = this.a.jdField_a_of_type_ArrayOfAndroidViewView[23];
      } while (paramString == null);
      paramString = (TextView)paramString.findViewById(2131376668);
    } while (paramString == null);
    TroopUtils.updateRedPoint(bhdf.b(this.a.app.getCurrentUin(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, false), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adri
 * JD-Core Version:    0.7.0.1
 */