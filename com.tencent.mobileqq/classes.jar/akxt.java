import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class akxt
  implements acoi
{
  akxt(akxs paramakxs, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(acoh paramacoh)
  {
    try
    {
      akxs.a(this.jdField_a_of_type_Akxs, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramacoh + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((paramacoh == null) || (paramacoh.a() == null) || (paramacoh.a().a == null) || (!paramacoh.a().a.ret.has()) || (paramacoh.a().a.ret.get() != 0))
      {
        akxs.a(this.jdField_a_of_type_Akxs, paramacoh);
        akxs.a(this.jdField_a_of_type_Akxs);
        return;
      }
      paramacoh = paramacoh.a().a;
      if ((!paramacoh.pos_ads_info.has()) || (paramacoh.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacoh.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacoh.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacoh.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        akxs.a(this.jdField_a_of_type_Akxs);
        return;
      }
    }
    catch (Throwable paramacoh)
    {
      QLog.e("QWalletGdtAdManager", 1, paramacoh, new Object[0]);
      return;
    }
    if ((!akxs.a(this.jdField_a_of_type_Akxs)) && (akxs.a(this.jdField_a_of_type_Akxs) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      akxs.a(this.jdField_a_of_type_Akxs);
      return;
    }
    akxs.a(this.jdField_a_of_type_Akxs, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacoh.pos_ads_info.get(0)).ads_info.get(0)));
    akxs.a(this.jdField_a_of_type_Akxs, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    if (akxs.b(this.jdField_a_of_type_Akxs)) {
      acoo.a().a(akxs.a(this.jdField_a_of_type_Akxs));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + akxs.b(this.jdField_a_of_type_Akxs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxt
 * JD-Core Version:    0.7.0.1
 */