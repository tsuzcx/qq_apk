import android.content.Intent;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class aecq
  extends ameq
{
  public aecq(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 9)
    {
      Object localObject = this.a;
      ((TroopDisbandActivity)localObject).jdField_b_of_type_Int &= 0xFFFFFFFE;
      if (paramInt2 == 8)
      {
        if (this.a.jdField_a_of_type_Beub != null) {
          this.a.jdField_a_of_type_Beub.b();
        }
        localObject = bdgm.a(this.a, 230);
        ((bdjz)localObject).setTitle(this.a.getString(2131696606));
        ((bdjz)localObject).setMessage(this.a.getString(2131696607));
        ((bdjz)localObject).setNegativeButton(this.a.getString(2131696638), new aecr(this, (bdjz)localObject));
        ((bdjz)localObject).setPositiveButton(this.a.getString(2131720095), new aecs(this, (bdjz)localObject));
        ((bdjz)localObject).show();
      }
    }
    else
    {
      return;
    }
    if (this.a.jdField_a_of_type_Beub == null) {
      this.a.jdField_a_of_type_Beub = new beub(this.a);
    }
    this.a.jdField_a_of_type_Beub.b(2, 2131692289, 1500);
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (!bdeu.a(paramString, this.a.jdField_a_of_type_JavaLangString)) {}
    while (paramInt1 != 9) {
      return;
    }
    paramString = this.a;
    paramString.jdField_b_of_type_Int &= 0xFFFFFFFE;
    if (paramInt2 == 0)
    {
      if (this.a.jdField_a_of_type_Beub != null) {
        this.a.jdField_a_of_type_Beub.b();
      }
      paramString = new Intent();
      paramString.putExtra("isNeedFinish", true);
      paramString.putExtra("fin_tip_msg", this.a.getString(2131692292));
      this.a.setResult(-1, paramString);
      this.a.finish();
      return;
    }
    if (this.a.jdField_a_of_type_Beub == null) {
      this.a.jdField_a_of_type_Beub = new beub(this.a);
    }
    this.a.jdField_a_of_type_Beub.b(2, 2131692289, 1500);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!bdeu.a(String.valueOf(paramLong1), this.a.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    label132:
    label190:
    label320:
    label595:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(150);
          ((StringBuilder)localObject).append("onOIDB0X899_0_Ret").append("| isSuccess = ").append(paramBoolean).append("| troopuin = ").append(paramLong1).append("| nFlag = ").append(paramInt1).append("| strErorMsg = ").append(paramString);
          QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
        }
        switch (paramInt1)
        {
        default: 
          return;
        case 4: 
          if (paramBoolean)
          {
            if (paramList == null)
            {
              paramInt1 = 0;
              paramInt2 = 0;
              if (paramInt2 >= paramInt1) {
                break label320;
              }
              paramString = (oidb_0x899.memberlist)paramList.get(paramInt2);
              if ((paramString != null) && (paramString.uint64_member_uin.has())) {
                break label190;
              }
            }
            do
            {
              paramInt2 += 1;
              break label132;
              paramInt1 = paramList.size();
              break;
              localObject = String.valueOf(paramString.uint64_member_uin.get());
            } while ((this.a.jdField_a_of_type_JavaUtilArrayList.contains(localObject)) || (localObject == null) || ("".equals(((String)localObject).trim())) || (bdeu.a(this.a.d, localObject)));
            if (paramString.uint32_uin_flag.has()) {}
            for (int i = paramString.uint32_uin_flag.get();; i = 0)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.add((String)localObject + "|" + String.valueOf(i));
              break;
            }
          }
          if (this.a.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break label595;
          }
          paramList = (amdu)this.a.app.a(20);
          if ((paramList == null) || (!paramBoolean) || (paramLong2 <= 0L) || (this.a.jdField_b_of_type_Long != 0L)) {
            break label418;
          }
          this.a.jdField_b_of_type_Long = paramLong2;
          paramList.a(paramLong1, this.a.jdField_b_of_type_Long, 4, 0, 0);
        }
      } while (!QLog.isColorLevel());
      QLog.i("Q.troopdisband.", 2, "handle_oidb_0x899_0|need get another package");
      return;
      if (this.a.jdField_a_of_type_Beub != null) {
        this.a.jdField_a_of_type_Beub.b();
      }
      paramList = this.a;
      paramList.jdField_b_of_type_Int &= 0xFFFFFFFD;
      paramList = new Intent(this.a, TroopTransferActivity.class);
      paramList.putExtra("leftViewText", this.a.getString(2131717664));
      paramList.putExtra("TROOP_INFO_FLAG_EXT", this.a.jdField_a_of_type_Long);
      paramList.putExtra("troop_auth_submit_time", this.a.jdField_a_of_type_Int);
      paramList.putStringArrayListExtra("troopVipMembers", this.a.jdField_a_of_type_JavaUtilArrayList);
      paramList.putExtra("troop_uin", this.a.jdField_a_of_type_JavaLangString);
      paramList.putExtra("troop_code", this.a.c);
      paramList.putExtra("uinname", this.a.jdField_b_of_type_JavaLangString);
      this.a.startActivityForResult(paramList, 0);
      return;
      if (paramBoolean)
      {
        paramList = this.a;
        paramList.jdField_b_of_type_Int &= 0xFFFFFFFD;
        if (this.a.jdField_a_of_type_Beub == null) {
          this.a.jdField_a_of_type_Beub = new beub(this.a);
        }
        this.a.jdField_a_of_type_Beub.b(2, 2131721000, 1500);
        return;
      }
      paramList = this.a;
      paramList.jdField_b_of_type_Int &= 0xFFFFFFFD;
      if (this.a.jdField_a_of_type_Beub == null) {
        this.a.jdField_a_of_type_Beub = new beub(this.a);
      }
      this.a.jdField_a_of_type_Beub.b(2, 2131720995, 1500);
      return;
    } while (!paramBoolean);
    label418:
    if (paramList == null)
    {
      paramInt1 = 0;
      if ((paramInt1 > 0) && (paramInt1 < 6))
      {
        paramString = (TroopManager)this.a.app.getManager(52);
        localObject = this.a;
        if (paramString != null) {
          break label873;
        }
      }
    }
    label873:
    for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_JavaLangString))
    {
      ((TroopDisbandActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum != paramInt1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNum = paramList.size();
      }
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, false);
      this.a.jdField_a_of_type_Aecu.b(paramList);
      return;
      paramInt1 = paramList.size();
      break;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopdisband.disband", 2, "onGetTroopInfoResult, isSuc=" + paramBoolean + ", groupUin : " + paramString);
    }
    TroopDisbandActivity localTroopDisbandActivity;
    if ((paramBoolean) && (bdeu.a(paramString, this.a.jdField_a_of_type_JavaLangString)))
    {
      paramString = (TroopManager)this.a.app.getManager(52);
      localTroopDisbandActivity = this.a;
      if (paramString != null) {
        break label108;
      }
    }
    label108:
    for (paramString = null;; paramString = paramString.b(this.a.jdField_a_of_type_JavaLangString))
    {
      localTroopDisbandActivity.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramString;
      this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, false);
      return;
    }
  }
  
  protected void b(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    TroopInfo localTroopInfo = null;
    int i = 0;
    label21:
    if ((localTroopInfo == null) && (i < paramArrayList.size()))
    {
      localTroopInfo = (TroopInfo)paramArrayList.get(i);
      if (localTroopInfo != null) {
        break label56;
      }
    }
    label56:
    while (!bdeu.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_JavaLangString))
    {
      i += 1;
      break label21;
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = localTroopInfo;
    this.a.a(localTroopInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecq
 * JD-Core Version:    0.7.0.1
 */