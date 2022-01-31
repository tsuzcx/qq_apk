import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class adxh
  implements begw
{
  adxh(adxg paramadxg, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Begr.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(adxg.c(this.jdField_a_of_type_Adxg).getResources().getString(2131624388))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Adxg.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Adxg.q();
        this.jdField_a_of_type_Adxg.a("Multi_Forward_Contacts", this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Adxg.jdField_a_of_type_Adye.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((adyb)this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Adxg.jdField_a_of_type_Adye.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Adxg.c);
        aphp.a(adxg.d(this.jdField_a_of_type_Adxg), paramView);
        continue;
        if (paramView.equals(adxg.e(this.jdField_a_of_type_Adxg).getResources().getString(2131627743)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Adxg.b, -1, Long.valueOf(this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bafb(adxg.f(this.jdField_a_of_type_Adxg), 2131690181);
            paramView.setContentView(2131493345);
            paramView.setTitle(adxg.g(this.jdField_a_of_type_Adxg).getString(2131632185));
            paramView.setMessage(adxg.h(this.jdField_a_of_type_Adxg).getString(2131632183));
            paramView.setNegativeButton(adxg.i(this.jdField_a_of_type_Adxg).getString(2131632184), new adxi(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            bbmy.a(adxg.k(this.jdField_a_of_type_Adxg), 2131627128, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Adxg.r();
          }
        }
        else if (paramView.equals(adxg.l(this.jdField_a_of_type_Adxg).getResources().getString(2131627755))) {
          if (this.jdField_a_of_type_Adxg.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            bbmy.a(adxg.m(this.jdField_a_of_type_Adxg), 2131627128, 0).a();
          } else {
            this.jdField_a_of_type_Adxg.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxh
 * JD-Core Version:    0.7.0.1
 */