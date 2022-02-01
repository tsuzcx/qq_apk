import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class aksx
  implements DialogInterface.OnClickListener
{
  aksx(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialogWtihInputAndChoose)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      aksv.a((SelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaUtilArrayList, (QQCustomDialogWtihInputAndChoose)paramDialogInterface);
    } while ((aksv.a == null) || (aksv.a.vecRec == null) || (aksv.a.vecRec.size() <= 0));
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
      if (i < aksv.a.vecRec.size())
      {
        if (((ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).uin.equals(((PfaFriend)aksv.a.vecRec.get(i)).uin)) {
          paramDialogInterface = "friendpay.selectpage.recommendfriclick";
        }
      }
      else
      {
        bdla.b(albw.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
        paramInt += 1;
        break label79;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksx
 * JD-Core Version:    0.7.0.1
 */