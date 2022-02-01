import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class agzp
  implements bjoe
{
  agzp(agzo paramagzo, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bjnw.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(agzo.a(this.jdField_a_of_type_Agzo).getResources().getString(2131689901))) {
          break label199;
        }
        paramInt = this.jdField_a_of_type_Agzo.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Agzo.r();
        this.jdField_a_of_type_Agzo.a("Multi_Forward_Contacts", this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label199:
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Agzo.jdField_a_of_type_Ahap.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((aham)this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Agzo.jdField_a_of_type_Ahap.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Agzo.c);
        if (paramView != null)
        {
          atky.a(agzo.b(this.jdField_a_of_type_Agzo), paramView);
          continue;
          if (paramView.equals(agzo.c(this.jdField_a_of_type_Agzo).getResources().getString(2131693018)))
          {
            if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Agzo.b, -1, Long.valueOf(this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaLangString).longValue()) == 0)
            {
              paramView = new QQCustomDialog(agzo.d(this.jdField_a_of_type_Agzo), 2131755826);
              paramView.setContentView(2131559016);
              paramView.setTitle(agzo.e(this.jdField_a_of_type_Agzo).getString(2131697137));
              paramView.setMessage(agzo.f(this.jdField_a_of_type_Agzo).getString(2131697135));
              paramView.setNegativeButton(agzo.g(this.jdField_a_of_type_Agzo).getString(2131697136), new agzq(this));
              paramView.setCanceledOnTouchOutside(false);
              paramView.setCancelable(false);
              paramView.show();
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaLangString, "40", "1");
            }
            else if (this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaUtilArrayList.size() > 20)
            {
              QQToast.a(agzo.i(this.jdField_a_of_type_Agzo), 2131692457, 0).a();
            }
            else
            {
              this.jdField_a_of_type_Agzo.s();
            }
          }
          else if (paramView.equals(agzo.j(this.jdField_a_of_type_Agzo).getResources().getString(2131693024))) {
            if (this.jdField_a_of_type_Agzo.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
              QQToast.a(agzo.k(this.jdField_a_of_type_Agzo), 2131692457, 0).a();
            } else {
              this.jdField_a_of_type_Agzo.u();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzp
 * JD-Core Version:    0.7.0.1
 */