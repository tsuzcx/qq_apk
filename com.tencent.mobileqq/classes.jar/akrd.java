import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class akrd
  implements acag
{
  akrd(akrc paramakrc, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(acaf paramacaf)
  {
    try
    {
      akrc.a(this.jdField_a_of_type_Akrc, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramacaf + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((paramacaf == null) || (paramacaf.a() == null) || (paramacaf.a().a == null) || (!paramacaf.a().a.ret.has()) || (paramacaf.a().a.ret.get() != 0))
      {
        akrc.a(this.jdField_a_of_type_Akrc, paramacaf);
        akrc.a(this.jdField_a_of_type_Akrc);
        return;
      }
      paramacaf = paramacaf.a().a;
      if ((!paramacaf.pos_ads_info.has()) || (paramacaf.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacaf.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacaf.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacaf.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        akrc.a(this.jdField_a_of_type_Akrc);
        return;
      }
    }
    catch (Throwable paramacaf)
    {
      QLog.e("QWalletGdtAdManager", 1, paramacaf, new Object[0]);
      return;
    }
    if ((!akrc.a(this.jdField_a_of_type_Akrc)) && (akrc.a(this.jdField_a_of_type_Akrc) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      akrc.a(this.jdField_a_of_type_Akrc);
      return;
    }
    akrc.a(this.jdField_a_of_type_Akrc, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramacaf.pos_ads_info.get(0)).ads_info.get(0)));
    akrc.a(this.jdField_a_of_type_Akrc, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if (akrc.b(this.jdField_a_of_type_Akrc)) {
      acam.a().a(akrc.a(this.jdField_a_of_type_Akrc));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + akrc.b(this.jdField_a_of_type_Akrc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrd
 * JD-Core Version:    0.7.0.1
 */