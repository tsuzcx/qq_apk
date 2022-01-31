import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TableLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;

public class aict
  extends Handler
{
  public aict(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      CreateFaceToFaceDiscussionActivity.a(this.a, 3);
      paramMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, this.a.jdField_a_of_type_Long);
    }
    do
    {
      do
      {
        return;
        if (1 != paramMessage.what) {
          break;
        }
      } while (this.a.jdField_c_of_type_Boolean);
      this.a.jdField_a_of_type_JavaLangStringBuffer.delete(0, this.a.jdField_a_of_type_JavaLangStringBuffer.length());
      this.a.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(this.a.a());
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844400);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844400);
      this.a.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844400);
      this.a.d.setImageResource(2130844400);
      this.a.e.setEnabled(true);
      this.a.f.setEnabled(true);
      this.a.g.setEnabled(true);
      this.a.h.setEnabled(true);
      this.a.i.setEnabled(true);
      this.a.j.setEnabled(true);
      this.a.k.setEnabled(true);
      this.a.l.setEnabled(true);
      this.a.m.setEnabled(true);
      this.a.n.setEnabled(true);
      this.a.o.setEnabled(true);
      return;
    } while (2 != paramMessage.what);
    bcql.a(BaseApplicationImpl.getContext(), paramMessage.arg1, paramMessage.arg2, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aict
 * JD-Core Version:    0.7.0.1
 */