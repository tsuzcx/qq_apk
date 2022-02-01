import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

class aast
  implements biyn
{
  aast(aasr paramaasr, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_Aasr.o == null) || (!this.jdField_a_of_type_Aasr.o.equals(paramBaseResp.transaction))) {}
    int i;
    String str1;
    String str2;
    String str3;
    for (;;)
    {
      return;
      BaseApplicationImpl.getContext();
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        znl.a(1, 2131718766);
        return;
      }
      znl.a(2, 2131718784);
      if ((this.jdField_a_of_type_Aasr.a instanceof biex))
      {
        paramBaseResp = ((biex)this.jdField_a_of_type_Aasr.a).a();
        if (this.jdField_a_of_type_Aasr.e == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.msgid;
          str2 = paramBaseResp.publicUin;
          str3 = AccountDetailActivity.a(paramBaseResp.mUrl);
          String str4 = paramBaseResp.sourcePuin;
          if ((str4 == null) || ("".equals(str4))) {
            break label200;
          }
          olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.mUrl, str3, false);
          return;
        }
      }
    }
    label200:
    if (this.jdField_a_of_type_Aasr.e == 1) {
      i = 1003;
    }
    olh.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aast
 * JD-Core Version:    0.7.0.1
 */