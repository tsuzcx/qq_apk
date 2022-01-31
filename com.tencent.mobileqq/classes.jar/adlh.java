import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;

public class adlh
  implements Runnable
{
  public adlh(ForwardSdkBaseOption paramForwardSdkBaseOption, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    int i2 = 1;
    int j = -1;
    long l1 = System.currentTimeMillis();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.c;
    int i1 = 0;
    int k = 0;
    int n = j;
    long l2 = l1;
    int i = i1;
    int m = i2;
    try
    {
      localObject1 = new Bundle();
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ((Bundle)localObject1).putString("report_type", "102");
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ((Bundle)localObject1).putString("act_type", "53");
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ((Bundle)localObject1).putString("intext_3", "0");
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ((Bundle)localObject1).putString("intext_2", "" + i3);
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ((Bundle)localObject1).putString("stringext_1", this.jdField_a_of_type_JavaLangString);
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      localObject2 = ShareProcessorUtil.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      l1 = System.currentTimeMillis() - l1;
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      j = ((Integer)localObject2[0]).intValue();
      if (j != 0) {
        break label1197;
      }
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      Object localObject3 = (String)localObject2[1];
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      localObject1 = (String)localObject2[2];
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      localObject2 = (String)localObject2[3];
      i2 = 0;
      n = j;
      l2 = l1;
      i = i1;
      m = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        i1 = 4;
        k = i1;
        n = j;
        l2 = l1;
        i = i1;
        m = i2;
        if (TextUtils.isEmpty(this.b))
        {
          n = j;
          l2 = l1;
          i = i1;
          m = i2;
          ForwardSdkBaseOption localForwardSdkBaseOption = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption;
          n = j;
          l2 = l1;
          i = i1;
          m = i2;
          localForwardSdkBaseOption.c &= 0xFFFFFFFB;
          n = j;
          l2 = l1;
          i = i1;
          m = i2;
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("title", (String)localObject3);
          k = i1;
        }
      }
      i1 = k;
      n = j;
      l2 = l1;
      i = k;
      m = i2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        k |= 0x2;
        i1 = k;
        n = j;
        l2 = l1;
        i = k;
        m = i2;
        if (TextUtils.isEmpty(this.c))
        {
          n = j;
          l2 = l1;
          i = k;
          m = i2;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption;
          n = j;
          l2 = l1;
          i = k;
          m = i2;
          ((ForwardSdkBaseOption)localObject3).c &= 0xFFFFFFFD;
          n = j;
          l2 = l1;
          i = k;
          m = i2;
          this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("desc", (String)localObject1);
          i1 = k;
        }
      }
      i = i1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        label762:
        j = n;
        label1141:
        l1 = l2;
        k = m;
        label1165:
        localException1.printStackTrace();
      }
      label1173:
      QLog.d("ForwardOption.ForwardSdkBaseOption", 2, localException1);
      return;
    }
    try
    {
      if (!TextUtils.isEmpty(this.d)) {
        break label1141;
      }
      i = i1;
      localObject1 = this.e;
      i = i1;
      k = i1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1194;
      }
      m = i1 | 0x1;
      i = m;
      k = m;
      if (!TextUtils.isEmpty(this.d)) {
        break label1194;
      }
      i = m;
      k = m;
      if (!TextUtils.isEmpty(this.e)) {
        break label1194;
      }
      i = m;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption;
      i = m;
      ((ForwardSdkBaseOption)localObject1).c &= 0xFFFFFFFE;
      i = m;
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", (String)localObject2);
      localObject1 = localObject2;
      k = m;
    }
    catch (Exception localException2)
    {
      k = 0;
      break label1165;
      label1194:
      break label762;
    }
    i = k;
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      i = k;
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.updateTitleSummaryAndCover(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.getString("title"), this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.getString("desc"), (String)localObject1);
      i = k;
      ForwardSdkBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption).sendEmptyMessage(2);
    }
    i = k;
    for (k = 0;; k = 1)
    {
      if (j != -1) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.l = true;
        if (!ForwardSdkBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption)) {
          ForwardSdkBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption).sendEmptyMessage(1);
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("report_type", "102");
        ((Bundle)localObject1).putString("act_type", "13");
        ((Bundle)localObject1).putString("intext_3", "0");
        ((Bundle)localObject1).putString("intext_1", "" + k);
        ((Bundle)localObject1).putString("stringext_2", "" + j);
        ((Bundle)localObject1).putString("intext_5", "" + l1);
        ((Bundle)localObject1).putString("intext_2", "" + i3);
        ((Bundle)localObject1).putString("intext_4", "" + i);
        if (k > 0) {
          ((Bundle)localObject1).putString("stringext_1", this.jdField_a_of_type_JavaLangString);
        }
        ReportCenter.a().a((Bundle)localObject1, "", this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
        if (QLog.isColorLevel())
        {
          localObject1 = "OnRichMsg, errCode = " + k + ", cost = " + l1 + ", targetUrl = " + this.jdField_a_of_type_JavaLangString;
          if ((k != 1) && (l1 <= 3000L)) {
            break label1173;
          }
          QLog.e("ForwardOption.ForwardSdkBaseOption", 2, (String)localObject1);
        }
        return;
      }
      catch (Exception localException3)
      {
        break label1165;
      }
      i = i1;
      localObject1 = this.d;
      break;
      label1197:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlh
 * JD-Core Version:    0.7.0.1
 */