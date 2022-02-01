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

class ahsp
  implements bkzq
{
  ahsp(ahso paramahso, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bkzi.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(ahso.a(this.jdField_a_of_type_Ahso).getResources().getString(2131689930))) {
          break label199;
        }
        paramInt = this.jdField_a_of_type_Ahso.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Ahso.r();
        this.jdField_a_of_type_Ahso.a("Multi_Forward_Contacts", this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label199:
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Ahso.jdField_a_of_type_Ahtp.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((ahtm)this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Ahso.jdField_a_of_type_Ahtp.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Ahso.c);
        if (paramView != null)
        {
          aupt.a(ahso.b(this.jdField_a_of_type_Ahso), paramView);
          continue;
          if (paramView.equals(ahso.c(this.jdField_a_of_type_Ahso).getResources().getString(2131693154)))
          {
            if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Ahso.b, -1, Long.valueOf(this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaLangString).longValue()) == 0)
            {
              paramView = new QQCustomDialog(ahso.d(this.jdField_a_of_type_Ahso), 2131755829);
              paramView.setContentView(2131559043);
              paramView.setTitle(ahso.e(this.jdField_a_of_type_Ahso).getString(2131697414));
              paramView.setMessage(ahso.f(this.jdField_a_of_type_Ahso).getString(2131697412));
              paramView.setNegativeButton(ahso.g(this.jdField_a_of_type_Ahso).getString(2131697413), new ahsq(this));
              paramView.setCanceledOnTouchOutside(false);
              paramView.setCancelable(false);
              paramView.show();
              QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaLangString, "40", "1");
            }
            else if (this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaUtilArrayList.size() > 20)
            {
              QQToast.a(ahso.i(this.jdField_a_of_type_Ahso), 2131692559, 0).a();
            }
            else
            {
              this.jdField_a_of_type_Ahso.s();
            }
          }
          else if (paramView.equals(ahso.j(this.jdField_a_of_type_Ahso).getResources().getString(2131693160))) {
            if (this.jdField_a_of_type_Ahso.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
              QQToast.a(ahso.k(this.jdField_a_of_type_Ahso), 2131692559, 0).a();
            } else {
              this.jdField_a_of_type_Ahso.u();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsp
 * JD-Core Version:    0.7.0.1
 */