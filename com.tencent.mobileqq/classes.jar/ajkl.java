import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ajkl
  implements Runnable
{
  public ajkl(VideoInfo.GenerateVideoPosterSegment paramGenerateVideoPosterSegment, VideoInfo paramVideoInfo, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.e = 5;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.g = -2147483646;
    XMediaEditor localXMediaEditor = (XMediaEditor)VideoInfo.GenerateVideoPosterSegment.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo$GenerateVideoPosterSegment).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.c);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(((VideoItem.VideoViewHolder)localObject).a.getTag()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GeneratePoster before notify. vh hash=", Integer.valueOf(localObject.hashCode()) });
          }
          ((VideoItem)((XMediaEditorAdapter)localXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkl
 * JD-Core Version:    0.7.0.1
 */