import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;

class aedl
  implements axfu<asre>
{
  aedl(aede paramaede, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(asre paramasre)
  {
    Object localObject;
    int i;
    if (paramasre != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramasre);
      String str2 = asos.z.replace("[epId]", paramasre.a.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = awxv.a((String)localObject);
      if ((!bhmi.a(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramasre.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_Aede.a.getResources().getDrawable(2130847134);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_Aede.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_Aede.a.a * 100.0F));
        this.jdField_a_of_type_Aede.a(this.b, i, paramasre, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramasre.d())
        {
          i = 2;
          break;
        }
        if (!paramasre.e()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_Aede.a.getResources().getDrawable(2130838011);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedl
 * JD-Core Version:    0.7.0.1
 */