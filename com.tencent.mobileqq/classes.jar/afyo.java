import android.content.Intent;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import java.util.ArrayList;

public class afyo
  extends aojs
{
  public afyo(TroopTransferActivity paramTroopTransferActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if ((!bhjx.a(String.valueOf(paramLong), this.a.jdField_a_of_type_JavaLangString)) || (!bhjx.a(paramString1, this.a.app.getCurrentAccountUin()))) {
      return;
    }
    this.a.jdField_a_of_type_Boolean = false;
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Bjbv != null) {
        this.a.jdField_a_of_type_Bjbv.b();
      }
      paramString1 = (TroopManager)this.a.app.getManager(52);
      paramString3 = paramString1.b(paramLong + "");
      if (paramString3 != null)
      {
        paramString3.dwAdditionalFlag = 0L;
        paramString1.b(paramString3);
      }
      paramString1 = new Intent();
      paramString1.putExtra("isNeedFinish", true);
      paramString1.putExtra("fin_tip_msg", this.a.getString(2131718870));
      paramString1.putExtra("uin", paramString2);
      this.a.setResult(-1, paramString1);
      this.a.finish();
      return;
    }
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 6) || (paramInt == 8) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
      paramString1 = this.a.getString(2131718856);
    }
    for (;;)
    {
      if (this.a.jdField_a_of_type_Bjbv == null) {
        this.a.jdField_a_of_type_Bjbv = new bjbv(this.a);
      }
      this.a.jdField_a_of_type_Bjbv.a(2, paramString1, 1500);
      return;
      if ((paramInt == 3) || (paramInt == 4) || (paramInt == 7) || (paramInt == 16) || (paramInt == 19))
      {
        paramString1 = this.a.getString(2131718858);
      }
      else if ((paramInt == 5) || (paramInt == 17) || (paramInt == 18))
      {
        paramString1 = this.a.getString(2131718857);
      }
      else
      {
        if (paramInt == 12)
        {
          if (this.a.jdField_a_of_type_Bjbv != null) {
            this.a.jdField_a_of_type_Bjbv.b();
          }
          paramString1 = bhlq.a(this.a, 230);
          paramString1.setTitle(this.a.getString(2131695561));
          paramString1.setMessage(this.a.getString(2131695562));
          paramString1.setNegativeButton(this.a.getString(2131695506), new afyp(this, paramString1));
          paramString1.setPositiveButton(this.a.getString(2131718195), new afyq(this, paramString1));
          paramString1.show();
          return;
        }
        paramString1 = this.a.getString(2131718857);
      }
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void a(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
  
  protected void c(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.a.b(paramArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyo
 * JD-Core Version:    0.7.0.1
 */