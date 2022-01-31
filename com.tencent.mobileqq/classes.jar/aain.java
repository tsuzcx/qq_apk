import android.os.SystemClock;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.gdt.qq_ad_get.QQAdGetRsp;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.PosAdInfo;

public class aain
  implements aaif
{
  public aain(com.tencent.gdtad.api.GdtAd paramGdtAd) {}
  
  public void onResponse(aaie paramaaie)
  {
    if ((paramaaie != com.tencent.gdtad.api.GdtAd.access$100(this.a)) || (!this.a.isValid()))
    {
      aanp.d("GdtAd", "onResponse error");
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
      com.tencent.gdtad.api.GdtAd.access$300(this.a, new aaio(1));
      return;
    }
    int j;
    int k;
    int i;
    if (paramaaie == null)
    {
      j = -2147483648;
      k = -2147483648;
      i = -2147483648;
      paramaaie = null;
    }
    aaio localaaio;
    for (;;)
    {
      i = this.a.getErrorCode(paramaaie, k, j, i);
      localaaio = new aaio(i);
      aanp.b("GdtAd", localaaio.a());
      if (i != 0) {
        break;
      }
      com.tencent.gdtad.api.GdtAd.access$202(this.a, 2);
      this.a.getParams().a.a = paramaaie;
      com.tencent.gdtad.api.GdtAd.access$402(this.a, SystemClock.elapsedRealtime());
      com.tencent.gdtad.api.GdtAd.access$500(this.a);
      return;
      if (paramaaie.a() == null)
      {
        j = -2147483648;
        k = -2147483648;
        i = -2147483648;
        paramaaie = null;
      }
      else
      {
        long l = paramaaie.a().jdField_a_of_type_Long;
        i = paramaaie.a().jdField_a_of_type_Int;
        if (paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp == null)
        {
          j = -2147483648;
          k = i;
          i = -2147483648;
          paramaaie = null;
        }
        else
        {
          j = paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.ret.get();
          if (j != 0)
          {
            k = i;
            i = -2147483648;
            paramaaie = null;
          }
          else if (paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.size() <= 0)
          {
            k = i;
            i = -2147483648;
            paramaaie = null;
          }
          else
          {
            k = ((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ret.get();
            int m;
            if (k != 0)
            {
              paramaaie = null;
              m = i;
              i = k;
              k = m;
            }
            else if (((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.size() <= 0)
            {
              paramaaie = null;
              m = i;
              i = k;
              k = m;
            }
            else
            {
              paramaaie = new com.tencent.gdtad.aditem.GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)((qq_ad_get.QQAdGetRsp.PosAdInfo)paramaaie.a().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGetRsp.pos_ads_info.get(0)).ads_info.get(0));
              m = i;
              i = k;
              k = m;
            }
          }
        }
      }
    }
    com.tencent.gdtad.api.GdtAd.access$202(this.a, 3);
    com.tencent.gdtad.api.GdtAd.access$300(this.a, localaaio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aain
 * JD-Core Version:    0.7.0.1
 */