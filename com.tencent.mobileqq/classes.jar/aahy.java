import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;

class aahy
  implements arok<anla>
{
  aahy(aahr paramaahr, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(anla paramanla)
  {
    Object localObject;
    int i;
    if (paramanla != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramanla);
      String str2 = anjd.z.replace("[epId]", paramanla.a.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = argh.a((String)localObject);
      if ((!bace.a(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramanla.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_Aahr.a.getResources().getDrawable(2130846036);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_Aahr.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_Aahr.a.a * 100.0F));
        this.jdField_a_of_type_Aahr.a(this.b, i, paramanla, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramanla.d())
        {
          i = 2;
          break;
        }
        if (!paramanla.e()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_Aahr.a.getResources().getDrawable(2130837701);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aahy
 * JD-Core Version:    0.7.0.1
 */