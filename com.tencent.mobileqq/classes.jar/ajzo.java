import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqprotect.qsec.QSecFramework;

public class ajzo
  extends ajzq
{
  protected View a;
  protected String a;
  protected boolean a;
  
  public ajzo(View paramView, String paramString)
  {
    super(null);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    try
    {
      if (QSecFramework.a().a(1001).booleanValue())
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label106;
        }
        View localView = this.jdField_a_of_type_AndroidViewView;
        QSecFramework.a().a(5, 0, 1, new Object[] { Integer.valueOf(80), localView }, null);
        this.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.i("MainFragment", 2, "附近人机上报: lebaView onCreate, from=" + this.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label106:
        QSecFramework.a().a(5, 0, 2, new Object[] { Integer.valueOf(80), Integer.valueOf(1), Integer.valueOf(6), "lebaClick", null }, null);
        if (QLog.isColorLevel()) {
          QLog.i("MainFragment", 2, "附近人机上报: lebaView onClick, from=" + this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MainFragment", 2, "ABotDragClickListener onClick exp=", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzo
 * JD-Core Version:    0.7.0.1
 */