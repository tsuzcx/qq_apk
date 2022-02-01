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

class aicz
  implements bliz
{
  aicz(aicy paramaicy, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Blir.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(aicy.a(this.jdField_a_of_type_Aicy).getResources().getString(2131689887))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Aicy.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Aicy.r();
        this.jdField_a_of_type_Aicy.a("Multi_Forward_Contacts", this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Blir.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Aicy.jdField_a_of_type_Aidz.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((aidw)this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Aicy.jdField_a_of_type_Aidz.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Aicy.c);
        auxu.a(aicy.b(this.jdField_a_of_type_Aicy), paramView);
        continue;
        if (paramView.equals(aicy.c(this.jdField_a_of_type_Aicy).getResources().getString(2131692963)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Aicy.b, -1, Long.valueOf(this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bhpc(aicy.d(this.jdField_a_of_type_Aicy), 2131755824);
            paramView.setContentView(2131559008);
            paramView.setTitle(aicy.e(this.jdField_a_of_type_Aicy).getString(2131696995));
            paramView.setMessage(aicy.f(this.jdField_a_of_type_Aicy).getString(2131696993));
            paramView.setNegativeButton(aicy.g(this.jdField_a_of_type_Aicy).getString(2131696994), new aida(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(aicy.i(this.jdField_a_of_type_Aicy), 2131692409, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Aicy.s();
          }
        }
        else if (paramView.equals(aicy.j(this.jdField_a_of_type_Aicy).getResources().getString(2131692969))) {
          if (this.jdField_a_of_type_Aicy.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(aicy.k(this.jdField_a_of_type_Aicy), 2131692409, 0).a();
          } else {
            this.jdField_a_of_type_Aicy.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicz
 * JD-Core Version:    0.7.0.1
 */