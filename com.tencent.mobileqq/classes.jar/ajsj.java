import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioViewHolder;

class ajsj
  implements Runnable
{
  ajsj(ajsh paramajsh) {}
  
  public void run()
  {
    AudioItem.AudioViewHolder localAudioViewHolder = (AudioItem.AudioViewHolder)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem.a.findViewHolderForAdapterPosition(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.c);
    if (localAudioViewHolder != null)
    {
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelAudioInfo.a) {
        break label103;
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)AudioItem.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiAudioItem).getResources().getDrawable(2131034360);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
    }
    for (;;)
    {
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localAudioViewHolder.c.setVisibility(0);
      return;
      label103:
      localAudioViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843969);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsj
 * JD-Core Version:    0.7.0.1
 */