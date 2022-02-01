import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

class ajvk
  implements abkq
{
  ajvk(ajvj paramajvj, long paramLong, BaseChatPie paramBaseChatPie) {}
  
  public void onResponse(abkp paramabkp)
  {
    try
    {
      ajvj.a(this.jdField_a_of_type_Ajvj, null);
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse :" + paramabkp + ",cost:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
      }
      if ((paramabkp == null) || (paramabkp.a() == null) || (paramabkp.a().a == null) || (!paramabkp.a().a.ret.has()) || (paramabkp.a().a.ret.get() != 0))
      {
        ajvj.a(this.jdField_a_of_type_Ajvj, paramabkp);
        ajvj.a(this.jdField_a_of_type_Ajvj);
        return;
      }
      paramabkp = paramabkp.a().a;
      if ((!paramabkp.pos_ads_info.has()) || (paramabkp.pos_ads_info.size() <= 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramabkp.pos_ads_info.get(0)).ret.has()) || (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramabkp.pos_ads_info.get(0)).ret.get() != 0) || (!((qq_ad_get.QQAdGetRsp.PosAdInfo)paramabkp.pos_ads_info.get(0)).ads_info.has()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : getAdInfo is null");
        }
        ajvj.a(this.jdField_a_of_type_Ajvj);
        return;
      }
    }
    catch (Throwable paramabkp)
    {
      QLog.e("QWalletGdtAdManager", 1, paramabkp, new Object[0]);
      return;
    }
    if ((!ajvj.a(this.jdField_a_of_type_Ajvj)) && (ajvj.a(this.jdField_a_of_type_Ajvj) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse but mPvFlag is 1,will not display ad");
      }
      ajvj.a(this.jdField_a_of_type_Ajvj);
      return;
    }
    ajvj.a(this.jdField_a_of_type_Ajvj, new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramabkp.pos_ads_info.get(0)).ads_info.get(0)));
    ajvj.a(this.jdField_a_of_type_Ajvj, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if (ajvj.b(this.jdField_a_of_type_Ajvj)) {
      abkw.a().a(ajvj.a(this.jdField_a_of_type_Ajvj));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletGdtAdManager", 2, "reqAds onResponse : notifyDataSetChanged,mHasTailMsg:" + ajvj.b(this.jdField_a_of_type_Ajvj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvk
 * JD-Core Version:    0.7.0.1
 */