import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidl
  implements View.OnClickListener
{
  aidl(aidf paramaidf) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.a.a.jdField_a_of_type_JavaLangString;
      if (this.a.a.jdField_a_of_type_Int == 1006) {
        str = this.a.a.f;
      }
      aidf.a(this.a, (Integer)localObject, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidl
 * JD-Core Version:    0.7.0.1
 */