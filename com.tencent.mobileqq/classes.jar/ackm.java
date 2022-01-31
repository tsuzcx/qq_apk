import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class ackm
  extends amab
{
  public ackm(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    ChatSettingForTroop.a(this.a, true);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
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
  
  protected void a(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString)
  {
    super.a(paramBoolean, paramInt, paramArrayList, paramString);
    if (!paramBoolean) {
      if (paramInt == 2) {
        QQToast.a(this.a, 1, alpo.a(2131702125), 0).b(this.a.getTitleBarHeight());
      }
    }
    Object localObject1;
    do
    {
      return;
      localObject2 = "";
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        localObject1 = localObject2;
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin != null) {
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
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
    this.a.a(this.a.e);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramString1 == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    while (paramInt2 != 512) {
      return;
    }
    if (paramBoolean)
    {
      amez.a(this.a.app, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo);
      return;
    }
    ChatSettingForTroop.b(this.a);
  }
  
  protected void b(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
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
  
  protected void b(boolean paramBoolean, String paramString)
  {
    super.b(paramBoolean, paramString);
    ChatSettingForTroop.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackm
 * JD-Core Version:    0.7.0.1
 */