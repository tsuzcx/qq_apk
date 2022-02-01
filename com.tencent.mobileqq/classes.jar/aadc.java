import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aadc
  implements View.OnClickListener
{
  aadc(aadb paramaadb, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.has())) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.get());; str1 = "")
    {
      if (aacp.d(this.jdField_a_of_type_Aadb.a) == 0) {
        blyl.a().a(str1 + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), str1 + "");
      }
      for (;;)
      {
        String str3 = "";
        String str2 = str3;
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null)
        {
          str2 = str3;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL != null)
          {
            str2 = str3;
            if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.has()) {
              str2 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.get();
            }
          }
        }
        this.jdField_a_of_type_Aadb.a.a(this.jdField_a_of_type_Aadb.itemView.getContext(), str1, str2, this.jdField_a_of_type_Aadb.a.a());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (aacp.d(this.jdField_a_of_type_Aadb.a) == 1) {
          blyl.a().a(str1 + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        } else if (aacp.d(this.jdField_a_of_type_Aadb.a) == 2) {
          blyl.a().a(str1 + "", "25", "qq_live", "shopcart_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadc
 * JD-Core Version:    0.7.0.1
 */