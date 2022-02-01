import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp;
import NS_COMM.COMM.StCommonExt;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.activity.shopping.ShoppingFragment;
import com.tencent.mobileqq.activity.shopping.ShoppingHeadView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class alzx
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedListRsp>
{
  public alzx(ShoppingFragment paramShoppingFragment, zsx paramzsx) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d(ShoppingFragment.a, 2, "refreshAliveList:" + paramBoolean + " " + paramLong + " " + paramString);
    }
    boolean bool2 = VSNetworkHelper.isProtocolCache(paramString);
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFeedListRsp == null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        QQToast.a(ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment), 1, paramString, 0).a();
      }
      if (!bool2) {
        VSBaseRequest.reMoveCache(paramVSBaseRequest);
      }
      if (this.jdField_a_of_type_Zsx.getItemCount() == 0) {
        ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
      }
      this.jdField_a_of_type_Zsx.a(paramBoolean);
      return;
    }
    ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(false);
    this.jdField_a_of_type_Zsx.a().b(paramStGetFeedListRsp.livePageInfo.get());
    paramVSBaseRequest = paramStGetFeedListRsp.hotLive.get();
    if ((paramVSBaseRequest != null) && (paramVSBaseRequest.size() > 0))
    {
      paramString = this.jdField_a_of_type_Zsx;
      COMM.StCommonExt localStCommonExt = paramStGetFeedListRsp.extInfo;
      if (paramStGetFeedListRsp.isFinish.get() == 1) {
        paramString.a(paramVSBaseRequest, localStCommonExt, bool1);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Zsx.a(paramBoolean);
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_Zsx.e();
      ShoppingFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityShoppingShoppingFragment).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzx
 * JD-Core Version:    0.7.0.1
 */