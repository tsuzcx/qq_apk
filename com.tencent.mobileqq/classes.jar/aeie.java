import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class aeie
  implements bfph
{
  aeie(aeid paramaeid, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bfpc.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(aeid.c(this.jdField_a_of_type_Aeid).getResources().getString(2131689936))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Aeid.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Aeid.q();
        this.jdField_a_of_type_Aeid.a("Multi_Forward_Contacts", this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Aeid.jdField_a_of_type_Aejb.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((aeiy)this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Aeid.jdField_a_of_type_Aejb.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Aeid.c);
        aqbe.a(aeid.d(this.jdField_a_of_type_Aeid), paramView);
        continue;
        if (paramView.equals(aeid.e(this.jdField_a_of_type_Aeid).getResources().getString(2131693385)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Aeid.b, -1, Long.valueOf(this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bbgu(aeid.f(this.jdField_a_of_type_Aeid), 2131755791);
            paramView.setContentView(2131558906);
            paramView.setTitle(aeid.g(this.jdField_a_of_type_Aeid).getString(2131697920));
            paramView.setMessage(aeid.h(this.jdField_a_of_type_Aeid).getString(2131697918));
            paramView.setNegativeButton(aeid.i(this.jdField_a_of_type_Aeid).getString(2131697919), new aeif(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            bcql.a(aeid.k(this.jdField_a_of_type_Aeid), 2131692767, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Aeid.r();
          }
        }
        else if (paramView.equals(aeid.l(this.jdField_a_of_type_Aeid).getResources().getString(2131693397))) {
          if (this.jdField_a_of_type_Aeid.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            bcql.a(aeid.m(this.jdField_a_of_type_Aeid), 2131692767, 0).a();
          } else {
            this.jdField_a_of_type_Aeid.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeie
 * JD-Core Version:    0.7.0.1
 */