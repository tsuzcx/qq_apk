import android.content.Intent;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

public class afit
  extends aofu
{
  public afit(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void onModifyTroopInfoPushResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void onOIDB0X89E_0_Ret(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((!bhbx.a(String.valueOf(paramLong), this.a.jdField_a_of_type_JavaLangString)) || (!bhbx.a(paramString1, this.a.app.getCurrentAccountUin()))) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Biso != null) {
        this.a.jdField_a_of_type_Biso.b();
      }
      paramString1 = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      paramString3 = paramString1.b(paramLong + "");
      if (paramString3 != null)
      {
        paramString3.dwAdditionalFlag = 0L;
        paramString1.b(paramString3);
      }
      paramString1 = new Intent();
      paramString1.putExtra("isNeedFinish", true);
      paramString1.putExtra("fin_tip_msg", this.a.getString(2131719534));
      paramString1.putExtra("uin", paramString2);
      this.a.setResult(-1, paramString1);
      this.a.finish();
      return;
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      paramString1 = this.a.getString(2131719520);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Biso == null) {
        this.a.jdField_a_of_type_Biso = new biso(this.a);
      }
      this.a.jdField_a_of_type_Biso.a(2, paramString1, 1500);
      return;
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 7) || (paramInt == 16) || (paramInt == 19))
      {
        paramString1 = this.a.getString(2131719522);
      }
      else if ((paramInt == 5) || (paramInt == 17) || (paramInt == 18))
      {
        paramString1 = this.a.getString(2131719521);
      }
      else
      {
        if (paramInt == 12)
        {
          if (this.a.jdField_a_of_type_Biso != null) {
            this.a.jdField_a_of_type_Biso.b();
          }
          paramString1 = bhdj.a(this.a, 230);
          paramString1.setTitle(this.a.getString(2131695952));
          paramString1.setMessage(this.a.getString(2131695953));
          paramString1.setNegativeButton(this.a.getString(2131695897), new afiu(this, paramString1));
          paramString1.setPositiveButton(this.a.getString(2131718822), new afiv(this, paramString1));
          paramString1.show();
          return;
        }
        paramString1 = this.a.getString(2131719521);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afit
 * JD-Core Version:    0.7.0.1
 */