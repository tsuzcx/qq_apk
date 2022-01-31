import Wallet.PfaFriend;
import Wallet.PfaFriendRsp;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class agyc
  implements DialogInterface.OnClickListener
{
  agyc(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof bbig)) {
      switch (paramInt)
      {
      }
    }
    do
    {
      return;
      agya.a((SelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaUtilArrayList, (bbig)paramDialogInterface);
    } while ((agya.a == null) || (agya.a.vecRec == null) || (agya.a.vecRec.size() <= 0));
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
      if (i < agya.a.vecRec.size())
      {
        if (((ResultRecord)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a.equals(((PfaFriend)agya.a.vecRec.get(i)).uin)) {
          paramDialogInterface = "friendpay.selectpage.recommendfriclick";
        }
      }
      else
      {
        axqy.b(ahiw.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramDialogInterface, 0, 0, "", "", "", "");
        paramInt += 1;
        break label79;
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agyc
 * JD-Core Version:    0.7.0.1
 */