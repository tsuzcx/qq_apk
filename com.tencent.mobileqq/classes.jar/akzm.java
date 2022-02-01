import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class akzm
  implements DialogInterface.OnClickListener
{
  akzm(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof bhqp)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      akzk.a((SelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaUtilArrayList, (bhqp)paramDialogInterface);
    } while ((akzk.a == null) || (akzk.a.vecRec == null) || (akzk.a.vecRec.size() <= 0));
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
      if (i < akzk.a.vecRec.size())
      {
        if (((ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a.equals(((PfaFriend)akzk.a.vecRec.get(i)).uin)) {
          paramDialogInterface = "friendpay.selectpage.recommendfriclick";
        }
      }
      else
      {
        bdll.b(alil.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
        paramInt += 1;
        break label79;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */