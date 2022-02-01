import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class ackm
  implements acke
{
  public ackm(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(ackd paramackd)
  {
    if ((paramackd != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()) || (this.a.getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet == null))
    {
      acqy.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new ackn(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramackd == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramackd = null;
    }
    ackn localackn;
    for (;;)
    {
      i = this.a.getErrorCode(paramackd, k, j, i);
      localackn = new ackn(i);
      acqy.b("GdtAd", localackn.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a = paramackd;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramackd.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramackd = null;
      }
      else
      {
        long l = paramackd.a().jdField_a_of_type_Long;
        i = paramackd.a().jdField_a_of_type_Int;
        if (paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramackd = null;
        }
        else
        {
          j = paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramackd = null;
          }
          else if (paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramackd = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramackd = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramackd = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramackd = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramackd.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localackn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ackm
 * JD-Core Version:    0.7.0.1
 */