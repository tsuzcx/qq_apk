import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class aanc
  implements aamu
{
  public aanc(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(aamt paramaamt)
  {
    if ((paramaamt != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()))
    {
      aase.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new aand(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramaamt == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramaamt = null;
    }
    aand localaand;
    for (;;)
    {
      i = this.a.getErrorCode(paramaamt, k, j, i);
      localaand = new aand(i);
      aase.b("GdtAd", localaand.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().a.a = paramaamt;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramaamt.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramaamt = null;
      }
      else
      {
        long l = paramaamt.a().jdField_a_of_type_Long;
        i = paramaamt.a().jdField_a_of_type_Int;
        if (paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramaamt = null;
        }
        else
        {
          j = paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramaamt = null;
          }
          else if (paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramaamt = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramaamt = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramaamt = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramaamt = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaamt.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localaand);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanc
 * JD-Core Version:    0.7.0.1
 */