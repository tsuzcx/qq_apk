import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditorAdapter;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.VideoItem.VideoViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

class aiwe
  implements Runnable
{
  aiwe(aiwd paramaiwd, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Aiwd.a).e = 95;
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Aiwd.a).g = -2147483648;
    XMediaEditor localXMediaEditor = (XMediaEditor)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Aiwd.a).get();
    if (localXMediaEditor != null)
    {
      Object localObject = localXMediaEditor.findViewHolderForLayoutPosition(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Aiwd.a).c);
      if ((localObject instanceof VideoItem.VideoViewHolder))
      {
        localObject = (VideoItem.VideoViewHolder)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelVideoInfo.d.equals(((VideoItem.VideoViewHolder)localObject).a.getTag())) {
          ((VideoItem)((XMediaEditorAdapter)localXMediaEditor.getAdapter()).a.a(2)).a((ImageItem.ImageViewHolder)localObject, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Aiwd.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiwe
 * JD-Core Version:    0.7.0.1
 */