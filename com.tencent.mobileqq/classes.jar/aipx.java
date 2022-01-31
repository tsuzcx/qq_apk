import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.ForwardSdkShareProcessor;
import com.tencent.mobileqq.transfile.TransferRequest.AppInfo;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class aipx
  extends aipl
{
  private AtomicInteger a;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  
  public aipx(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangString = "UrlExchangeStep";
  }
  
  protected boolean a()
  {
    return (ForwardSdkShareProcessor.c(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) || (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != -1) || (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 2);
  }
  
  protected void d()
  {
    if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      f();
      return;
    }
    if ((!TextUtils.isEmpty(ForwardSdkShareProcessor.e(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) && (ForwardSdkShareProcessor.e(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).length() > 150)) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).put("targetUrl", ForwardSdkShareProcessor.e(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    }
    if (!TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).c)) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).put("sourceUrl", ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).c);
    }
    if (!TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).d)) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).put("sourceIcon", ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).d);
    }
    if ((ForwardSdkShareProcessor.e(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor) == 2) && (HttpUtil.a(ForwardSdkShareProcessor.h(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)))) {
      ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).put("audioUrl", ForwardSdkShareProcessor.h(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
    }
    Bundle localBundle;
    if (TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)))
    {
      ForwardSdkShareProcessor.c(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor, ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).e);
      ForwardSdkShareProcessor.b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(false);
      QLog.i("Q.share.ForwardSdkShareProcessor", 1, "UrlExchangeStep|use app icon:" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
      localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "18");
      if (!TextUtils.isEmpty(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor))) {
        break label464;
      }
    }
    label464:
    for (String str = "1";; str = "0")
    {
      localBundle.putString("intext_1", str);
      ReportCenter.a().a(localBundle, "" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor), this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor.a.c(), false);
      if ((!ForwardSdkShareProcessor.b(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).get()) && (HttpUtil.a(ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor)))) {
        ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).put("imageUrl", ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, "UrlExchangeStep|process|url=" + ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).toString());
      }
      if (!ForwardSdkShareProcessor.a(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).isEmpty()) {
        break;
      }
      ForwardSdkShareProcessor.c(this.jdField_b_of_type_ComTencentMobileqqTransfileForwardSdkShareProcessor).set(true);
      b();
      return;
    }
    ThreadManager.post(new aipy(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipx
 * JD-Core Version:    0.7.0.1
 */