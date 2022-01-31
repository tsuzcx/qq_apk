import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class ageu
  implements bhqd
{
  ageu(aget paramaget, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bhpy.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(aget.c(this.jdField_a_of_type_Aget).getResources().getString(2131689983))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Aget.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Aget.q();
        this.jdField_a_of_type_Aget.a("Multi_Forward_Contacts", this.jdField_a_of_type_Aget.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Aget.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Aget.jdField_a_of_type_Agft.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((agfq)this.jdField_a_of_type_Aget.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Aget.jdField_a_of_type_Agft.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Aget.c);
        arum.a(aget.d(this.jdField_a_of_type_Aget), paramView);
        continue;
        if (paramView.equals(aget.e(this.jdField_a_of_type_Aget).getResources().getString(2131693486)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aget.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Aget.b, -1, Long.valueOf(this.jdField_a_of_type_Aget.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bdfq(aget.f(this.jdField_a_of_type_Aget), 2131755801);
            paramView.setContentView(2131558943);
            paramView.setTitle(aget.g(this.jdField_a_of_type_Aget).getString(2131698097));
            paramView.setMessage(aget.h(this.jdField_a_of_type_Aget).getString(2131698095));
            paramView.setNegativeButton(aget.i(this.jdField_a_of_type_Aget).getString(2131698096), new agev(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aget.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Aget.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(aget.k(this.jdField_a_of_type_Aget), 2131692849, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Aget.r();
          }
        }
        else if (paramView.equals(aget.l(this.jdField_a_of_type_Aget).getResources().getString(2131693498))) {
          if (this.jdField_a_of_type_Aget.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(aget.m(this.jdField_a_of_type_Aget), 2131692849, 0).a();
          } else {
            this.jdField_a_of_type_Aget.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ageu
 * JD-Core Version:    0.7.0.1
 */