import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;

class acik
  implements aubp<aptm>
{
  acik(acid paramacid, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(aptm paramaptm)
  {
    Object localObject;
    int i;
    if (paramaptm != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaptm);
      String str2 = apro.z.replace("[epId]", paramaptm.a.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = attl.a((String)localObject);
      if ((!bdcs.a(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramaptm.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_Acid.a.getResources().getDrawable(2130846602);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_Acid.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_Acid.a.a * 100.0F));
        this.jdField_a_of_type_Acid.a(this.b, i, paramaptm, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramaptm.d())
        {
          i = 2;
          break;
        }
        if (!paramaptm.e()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_Acid.a.getResources().getDrawable(2130837907);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acik
 * JD-Core Version:    0.7.0.1
 */