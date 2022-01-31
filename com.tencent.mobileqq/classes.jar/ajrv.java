import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.ImageItem.ImageViewHolder;
import com.tencent.mobileqq.widget.MessageProgressView;
import java.lang.ref.WeakReference;

class ajrv
  implements Runnable
{
  ajrv(ajrt paramajrt, int paramInt) {}
  
  public void run()
  {
    ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).e = this.jdField_a_of_type_Int;
    Object localObject = (XMediaEditor)ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).get();
    if (localObject != null)
    {
      localObject = ((XMediaEditor)localObject).findViewHolderForLayoutPosition(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).c);
      if ((localObject instanceof ImageItem.ImageViewHolder))
      {
        localObject = (ImageItem.ImageViewHolder)localObject;
        if (ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).d.equals(((ImageItem.ImageViewHolder)localObject).a.getTag()))
        {
          ((ImageItem.ImageViewHolder)localObject).a.setVisibility(0);
          ((ImageItem.ImageViewHolder)localObject).a.setDrawStatus(1);
          ((ImageItem.ImageViewHolder)localObject).a.setAnimProgress(ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).e, ImageInfo.UploadMediaSegment.a(this.jdField_a_of_type_Ajrt.a).d);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajrv
 * JD-Core Version:    0.7.0.1
 */