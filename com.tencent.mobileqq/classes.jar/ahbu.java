import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.nio.ByteBuffer;
import mqq.os.MqqHandler;

class ahbu
  implements Runnable
{
  ahbu(ahbt paramahbt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject3 = (FriendsManager)StatusManager.a(this.jdField_a_of_type_Ahbt.a).getManager(50);
    Object localObject2;
    int i;
    Object localObject4;
    if (localObject3 != null)
    {
      localObject2 = ((FriendsManager)localObject3).a(StatusManager.a(this.jdField_a_of_type_Ahbt.a).getAccount());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ExtensionInfo();
        ((ExtensionInfo)localObject1).uin = StatusManager.a(this.jdField_a_of_type_Ahbt.a).getAccount();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_AndroidOsBundle.getByteArray("k_rspbody");
        if (localObject2 != null)
        {
          localObject2 = ByteBuffer.wrap((byte[])localObject2);
          ((ByteBuffer)localObject2).get();
          i = ((ByteBuffer)localObject2).getInt();
          localObject4 = new byte[((ByteBuffer)localObject2).getShort()];
          ((ByteBuffer)localObject2).get((byte[])localObject4);
          if (((ExtensionInfo)localObject1).timestamp != i)
          {
            ((ExtensionInfo)localObject1).setRichBuffer((byte[])localObject4, i);
            ((FriendsManager)localObject3).a((ExtensionInfo)localObject1);
          }
        }
      }
      localObject2 = ((ExtensionInfo)localObject1).getRichStatus();
      if (this.jdField_a_of_type_Boolean)
      {
        if (((RichStatus)localObject2).tplId != 0) {
          break label507;
        }
        localObject1 = "1";
        ReportController.b(null, "CliOper", "", "", "signiture", "set_clk_save_succ", 0, 0, (String)localObject1, "", "", "");
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      i = 100;
      localObject2 = new TipsInfo();
      int j = i;
      int k;
      label281:
      String str1;
      String str2;
      if (!this.jdField_a_of_type_Boolean)
      {
        j = i;
        if (this.jdField_a_of_type_AndroidOsBundle != null)
        {
          j = this.jdField_a_of_type_AndroidOsBundle.getInt("k_auth_code", -1);
          k = this.jdField_a_of_type_AndroidOsBundle.getInt("cRet", 0);
          if (k != 2) {
            break label514;
          }
          i = 103;
          j = i;
          if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("valid"))
          {
            j = this.jdField_a_of_type_AndroidOsBundle.getInt("type", -1);
            localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("titleWording");
            localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("wording");
            str1 = this.jdField_a_of_type_AndroidOsBundle.getString("rightBtnWording");
            str2 = this.jdField_a_of_type_AndroidOsBundle.getString("leftBtnWording");
            String str3 = this.jdField_a_of_type_AndroidOsBundle.getString("vipType");
            k = this.jdField_a_of_type_AndroidOsBundle.getInt("vipMonth");
            String str4 = this.jdField_a_of_type_AndroidOsBundle.getString("url");
            ((TipsInfo)localObject2).jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("ret");
            ((TipsInfo)localObject2).jdField_b_of_type_Int = j;
            ((TipsInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject3);
            ((TipsInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject4);
            ((TipsInfo)localObject2).jdField_c_of_type_JavaLangString = str1;
            ((TipsInfo)localObject2).d = str2;
            ((TipsInfo)localObject2).e = str3;
            ((TipsInfo)localObject2).jdField_c_of_type_Int = k;
            ((TipsInfo)localObject2).f = str4;
            switch (j)
            {
            default: 
              j = i;
            }
          }
        }
      }
      for (;;)
      {
        StatusManager.a(this.jdField_a_of_type_Ahbt.a, null);
        ThreadManager.getUIHandler().post(new ahbv(this, j, (RichStatus)localObject1, (TipsInfo)localObject2));
        return;
        label507:
        localObject1 = "0";
        break;
        label514:
        i = k;
        if (k != 0) {
          break label281;
        }
        i = j;
        break label281;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          ((TipsInfo)localObject2).jdField_a_of_type_JavaLangString = "温馨提示";
        }
        if (TextUtils.isEmpty(str2)) {
          ((TipsInfo)localObject2).d = "取消";
        }
        j = i;
        if (TextUtils.isEmpty(str1))
        {
          ((TipsInfo)localObject2).jdField_c_of_type_JavaLangString = "立即开通";
          j = i;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            ((TipsInfo)localObject2).jdField_a_of_type_JavaLangString = "温馨提示";
          }
          if (TextUtils.isEmpty(str2)) {
            ((TipsInfo)localObject2).d = "取消";
          }
          j = i;
          if (TextUtils.isEmpty(str1))
          {
            ((TipsInfo)localObject2).jdField_c_of_type_JavaLangString = "活动详情";
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahbu
 * JD-Core Version:    0.7.0.1
 */