import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class aelz
  implements View.OnClickListener
{
  public aelz(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    Object localObject1;
    if (this.a.jdField_a_of_type_Int == 105)
    {
      localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      if (localObject1 != null)
      {
        localObject1 = localObject1.toString().trim();
        if (((String)localObject1).length() != 0) {
          break label78;
        }
        QQToast.a(this.a, this.a.getString(2131691752), 0).a();
        break label179;
      }
    }
    label179:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label78:
      if (EditActivity.a(this.a, (String)localObject1))
      {
        QQToast.a(this.a, this.a.getString(2131691753), 0).a();
      }
      else
      {
        Object localObject2 = (ashc)this.a.app.getManager(149);
        ashd localashd = (ashd)this.a.app.getManager(103);
        localObject2 = ((ashc)localObject2).a();
        if ((EditActivity.a(this.a) != -1) && (localObject2 != null))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject2).next();
            if (EditActivity.a(this.a) != localCustomEmotionData.emoId) {
              break;
            }
            EditActivity.c(this.a);
            localashd.a(localCustomEmotionData, (String)localObject1);
            continue;
            EditActivity.b(this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aelz
 * JD-Core Version:    0.7.0.1
 */