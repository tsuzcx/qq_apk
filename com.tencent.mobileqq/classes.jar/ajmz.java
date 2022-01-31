import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

public final class ajmz
  implements XMPCoreUtil.XMPCoreJarLoadListener
{
  public ajmz(LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(boolean paramBoolean)
  {
    Integer localInteger;
    int i;
    if (paramBoolean)
    {
      localInteger = DecodeImageTask.getImagePath2Rotation(this.a.path);
      if (localInteger != null) {
        break label102;
      }
      i = JpegExifReader.getRotationDegree(this.a.path);
      DecodeImageTask.putImagePath2Rotation(this.a.path, i);
    }
    while ((i == 90) && (this.a.mediaWidth < this.a.mediaHeight))
    {
      i = this.a.mediaHeight;
      this.a.mediaHeight = this.a.mediaWidth;
      this.a.mediaWidth = i;
      this.a.setPanoramaType();
      return;
      label102:
      i = localInteger.intValue();
    }
    this.a.setPanoramaType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ajmz
 * JD-Core Version:    0.7.0.1
 */