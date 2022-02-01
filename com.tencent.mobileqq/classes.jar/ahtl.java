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

class ahtl
  implements bkhw
{
  ahtl(ahtk paramahtk, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bkho.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(ahtk.a(this.jdField_a_of_type_Ahtk).getResources().getString(2131689881))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Ahtk.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Ahtk.r();
        this.jdField_a_of_type_Ahtk.a("Multi_Forward_Contacts", this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Bkho.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Ahtk.jdField_a_of_type_Ahul.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((ahui)this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Ahtk.jdField_a_of_type_Ahul.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Ahtk.c);
        aufz.a(ahtk.b(this.jdField_a_of_type_Ahtk), paramView);
        continue;
        if (paramView.equals(ahtk.c(this.jdField_a_of_type_Ahtk).getResources().getString(2131692954)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Ahtk.b, -1, Long.valueOf(this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bgpa(ahtk.d(this.jdField_a_of_type_Ahtk), 2131755823);
            paramView.setContentView(2131559009);
            paramView.setTitle(ahtk.e(this.jdField_a_of_type_Ahtk).getString(2131696946));
            paramView.setMessage(ahtk.f(this.jdField_a_of_type_Ahtk).getString(2131696944));
            paramView.setNegativeButton(ahtk.g(this.jdField_a_of_type_Ahtk).getString(2131696945), new ahtm(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(ahtk.i(this.jdField_a_of_type_Ahtk), 2131692403, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Ahtk.s();
          }
        }
        else if (paramView.equals(ahtk.j(this.jdField_a_of_type_Ahtk).getResources().getString(2131692960))) {
          if (this.jdField_a_of_type_Ahtk.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(ahtk.k(this.jdField_a_of_type_Ahtk), 2131692403, 0).a();
          } else {
            this.jdField_a_of_type_Ahtk.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtl
 * JD-Core Version:    0.7.0.1
 */