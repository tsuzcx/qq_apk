import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class akmi
  implements acke
{
  akmi(akmh paramakmh, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(ackd paramackd)
  {
    try
    {
      akmh.a(this.jdField_a_of_type_Akmh, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramackd + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((paramackd == null) || (paramackd.a() == null) || (paramackd.a().a == null) || (!paramackd.a().a.ret.has()) || (paramackd.a().a.ret.get() != 0))
      {
        akmh.a(this.jdField_a_of_type_Akmh, paramackd);
        akmh.a(this.jdField_a_of_type_Akmh);
        return;
      }
      paramackd = paramackd.a().a;
      if ((!paramackd.pos_ads_info.has()) || (paramackd.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        akmh.a(this.jdField_a_of_type_Akmh);
        return;
      }
    }
    catch (Throwable paramackd)
    {
      QLog.e("QWalletGdtAdManager", 1, paramackd, new Object[0]);
      return;
    }
    if ((!akmh.a(this.jdField_a_of_type_Akmh)) && (akmh.a(this.jdField_a_of_type_Akmh) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      akmh.a(this.jdField_a_of_type_Akmh);
      return;
    }
    akmh.a(this.jdField_a_of_type_Akmh, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.pos_ads_info.get(0)).ads_info.get(0)));
    akmh.a(this.jdField_a_of_type_Akmh, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    if (akmh.b(this.jdField_a_of_type_Akmh)) {
      ackk.a().a(akmh.a(this.jdField_a_of_type_Akmh));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + akmh.b(this.jdField_a_of_type_Akmh));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmi
 * JD-Core Version:    0.7.0.1
 */