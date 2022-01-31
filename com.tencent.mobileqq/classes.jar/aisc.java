import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class aisc
  implements DialogInterface.OnClickListener
{
  aisc(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof bdhc)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      aisa.a((SelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaUtilArrayList, (bdhc)paramDialogInterface);
    } while ((aisa.a == null) || (aisa.a.vecRec == null) || (aisa.a.vecRec.size() <= 0));
    paramInt = 0;
    label79:
    String str;
    int i;
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      str = "friendpay.selectpage.unrecomchoosefriclick";
      i = 0;
    }
    for (;;)
    {
      paramDialogInterface = str;
      if (i < aisa.a.vecRec.size())
      {
        if (((ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a.equals(((PfaFriend)aisa.a.vecRec.get(i)).uin)) {
          paramDialogInterface = "friendpay.selectpage.recommendfriclick";
        }
      }
      else
      {
        azmj.b(ajaf.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
        paramInt += 1;
        break label79;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisc
 * JD-Core Version:    0.7.0.1
 */