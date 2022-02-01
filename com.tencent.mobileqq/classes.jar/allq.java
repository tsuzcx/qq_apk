import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class allq
  implements View.OnClickListener
{
  allq(aljw paramaljw, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void onClick(View paramView)
  {
    aoie.a(this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, this.c, aljw.a(this.jdField_a_of_type_Aljw));
    bdll.b(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(this.c), "", "", "");
    aljw.a(this.jdField_a_of_type_Aljw).obtainMessage(16).sendToTarget();
    bdll.a(aljw.a(this.jdField_a_of_type_Aljw).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 15, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allq
 * JD-Core Version:    0.7.0.1
 */