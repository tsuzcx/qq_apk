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

class agjj
  implements bhuk
{
  agjj(agji paramagji, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bhuf.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(agji.c(this.jdField_a_of_type_Agji).getResources().getString(2131689983))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Agji.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Agji.q();
        this.jdField_a_of_type_Agji.a("Multi_Forward_Contacts", this.jdField_a_of_type_Agji.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Agji.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Agji.jdField_a_of_type_Agki.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((agkf)this.jdField_a_of_type_Agji.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Agji.jdField_a_of_type_Agki.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Agji.c);
        aryv.a(agji.d(this.jdField_a_of_type_Agji), paramView);
        continue;
        if (paramView.equals(agji.e(this.jdField_a_of_type_Agji).getResources().getString(2131693488)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Agji.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Agji.b, -1, Long.valueOf(this.jdField_a_of_type_Agji.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bdjz(agji.f(this.jdField_a_of_type_Agji), 2131755801);
            paramView.setContentView(2131558942);
            paramView.setTitle(agji.g(this.jdField_a_of_type_Agji).getString(2131698099));
            paramView.setMessage(agji.h(this.jdField_a_of_type_Agji).getString(2131698097));
            paramView.setNegativeButton(agji.i(this.jdField_a_of_type_Agji).getString(2131698098), new agjk(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Agji.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Agji.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            QQToast.a(agji.k(this.jdField_a_of_type_Agji), 2131692851, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Agji.r();
          }
        }
        else if (paramView.equals(agji.l(this.jdField_a_of_type_Agji).getResources().getString(2131693500))) {
          if (this.jdField_a_of_type_Agji.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            QQToast.a(agji.m(this.jdField_a_of_type_Agji), 2131692851, 0).a();
          } else {
            this.jdField_a_of_type_Agji.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjj
 * JD-Core Version:    0.7.0.1
 */