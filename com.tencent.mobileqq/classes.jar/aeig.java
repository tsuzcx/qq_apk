import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class aeig
  implements bfoq
{
  aeig(aeif paramaeif, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_Bfol.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(aeif.c(this.jdField_a_of_type_Aeif).getResources().getString(2131689936))) {
          break label195;
        }
        paramInt = this.jdField_a_of_type_Aeif.a();
        if (paramInt != 1) {
          break label94;
        }
        this.jdField_a_of_type_Aeif.q();
        this.jdField_a_of_type_Aeif.a("Multi_Forward_Contacts", this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaUtilArrayList.size());
      }
    }
    label195:
    for (;;)
    {
      this.jdField_a_of_type_Bfol.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (this.jdField_a_of_type_Aeif.jdField_a_of_type_Aejd.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((aeja)this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaUtilArrayList.get(0)).a;
        paramView = this.jdField_a_of_type_Aeif.jdField_a_of_type_Aejd.a(paramView.jdField_f_of_type_Long, paramView.jdField_f_of_type_Int, this.jdField_a_of_type_Aeif.c);
        aqbc.a(aeif.d(this.jdField_a_of_type_Aeif), paramView);
        continue;
        if (paramView.equals(aeif.e(this.jdField_a_of_type_Aeif).getResources().getString(2131693384)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaLangString + "__qzone_pic_permission__" + this.jdField_a_of_type_Aeif.b, -1, Long.valueOf(this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaLangString).longValue()) == 0)
          {
            paramView = new bbgg(aeif.f(this.jdField_a_of_type_Aeif), 2131755791);
            paramView.setContentView(2131558906);
            paramView.setTitle(aeif.g(this.jdField_a_of_type_Aeif).getString(2131697910));
            paramView.setMessage(aeif.h(this.jdField_a_of_type_Aeif).getString(2131697908));
            paramView.setNegativeButton(aeif.i(this.jdField_a_of_type_Aeif).getString(2131697909), new aeih(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaLangString, "40", "1");
          }
          else if (this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaUtilArrayList.size() > 20)
          {
            bcpw.a(aeif.k(this.jdField_a_of_type_Aeif), 2131692766, 0).a();
          }
          else
          {
            this.jdField_a_of_type_Aeif.r();
          }
        }
        else if (paramView.equals(aeif.l(this.jdField_a_of_type_Aeif).getResources().getString(2131693396))) {
          if (this.jdField_a_of_type_Aeif.jdField_a_of_type_JavaUtilArrayList.size() > 20) {
            bcpw.a(aeif.m(this.jdField_a_of_type_Aeif), 2131692766, 0).a();
          } else {
            this.jdField_a_of_type_Aeif.u();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeig
 * JD-Core Version:    0.7.0.1
 */