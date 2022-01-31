import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.List;

public class acvh
  implements View.OnClickListener
{
  public acvh(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    if (this.a.jdField_a_of_type_Int == 105)
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText();
      if (paramView != null)
      {
        paramView = paramView.toString().trim();
        if (paramView.length() != 0) {
          break label71;
        }
      }
      label71:
      apoo localapoo;
      CustomEmotionData localCustomEmotionData;
      do
      {
        QQToast.a(this.a, this.a.getString(2131692109), 0).a();
        return;
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (EditActivity.a(this.a, paramView))
            {
              QQToast.a(this.a, this.a.getString(2131692110), 0).a();
              return;
            }
            localObject = (apon)this.a.app.getManager(149);
            localapoo = (apoo)this.a.app.getManager(103);
            localObject = ((apon)localObject).a();
          } while ((EditActivity.a(this.a) == -1) || (localObject == null));
          localObject = ((List)localObject).iterator();
        }
        localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
      } while (EditActivity.a(this.a) != localCustomEmotionData.emoId);
      EditActivity.c(this.a);
      localapoo.a(localCustomEmotionData, paramView);
      return;
    }
    EditActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acvh
 * JD-Core Version:    0.7.0.1
 */