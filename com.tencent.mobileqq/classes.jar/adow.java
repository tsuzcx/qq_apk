import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class adow
  implements View.OnClickListener
{
  adow(ador paramador, PicEmoticonInfo paramPicEmoticonInfo) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = EmoticonUtils.emoticonSoundPath.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
      if (this.jdField_a_of_type_Ador.a.a == null) {
        this.jdField_a_of_type_Ador.a.a = new adpc(this.jdField_a_of_type_Ador.a);
      }
      this.jdField_a_of_type_Ador.a.a.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adow
 * JD-Core Version:    0.7.0.1
 */