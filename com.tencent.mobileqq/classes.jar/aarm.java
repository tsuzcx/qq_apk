import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;

class aarm
  implements askq<aobp>
{
  aarm(aarf paramaarf, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(aobp paramaobp)
  {
    Object localObject;
    int i;
    if (paramaobp != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaobp);
      String str2 = anzr.z.replace("[epId]", paramaobp.a.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = ascl.a((String)localObject);
      if ((!bbdx.a(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramaobp.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_Aarf.a.getResources().getDrawable(2130846223);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_Aarf.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_Aarf.a.a * 100.0F));
        this.jdField_a_of_type_Aarf.a(this.b, i, paramaobp, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramaobp.d())
        {
          i = 2;
          break;
        }
        if (!paramaobp.e()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_Aarf.a.getResources().getDrawable(2130837711);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aarm
 * JD-Core Version:    0.7.0.1
 */