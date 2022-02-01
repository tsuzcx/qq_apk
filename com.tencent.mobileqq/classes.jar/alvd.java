import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class alvd
  implements zxa<CertifiedAccountRead.StGetFeedListRsp>
{
  public alvd(ShoppingFragment paramShoppingFragment, aacp paramaacp) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(ShoppingFragment.a, 2, "loadMore:" + paramBoolean + " " + paramLong + " " + paramString);
    }
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment), 1, paramString, 0).a();
      }
      return;
    }
    this.jdField_a_of_type_Aacp.getLoadInfo().d(paramStGetFeedListRsp.livePageInfo.get());
    paramString = paramStGetFeedListRsp.hotLive.get();
    aacp localaacp = this.jdField_a_of_type_Aacp;
    COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
    if (paramStGetFeedListRsp.isFinish.get() == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localaacp.b(paramString, localStCommonExt, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alvd
 * JD-Core Version:    0.7.0.1
 */