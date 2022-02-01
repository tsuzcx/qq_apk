import NS_MOBILE_OPERATION.PicInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.util.ArrayList;
import java.util.HashMap;

public class akmq
  implements OtherCommonData
{
  public int a = (int)PicUploadFileSizeLimit.getLimitC2C();
  public long a;
  public HashMap<String, PicInfo> a;
  public boolean a;
  private boolean b;
  
  public int a(PhotoCommonBaseData<akmq> paramPhotoCommonBaseData, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (a(paramPhotoCommonBaseData, paramString) == null)) {
      return -1;
    }
    return AlbumUtil.getMediaType(a(paramPhotoCommonBaseData, paramString));
  }
  
  public LocalMediaInfo a(PhotoCommonBaseData<akmq> paramPhotoCommonBaseData, String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = null;
    if (paramPhotoCommonBaseData.selectedMediaInfoHashMap != null) {
      localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.selectedMediaInfoHashMap.get(paramString);
    }
    if ((localLocalMediaInfo == null) && (paramPhotoCommonBaseData.allMediaInfoHashMap != null)) {
      localLocalMediaInfo = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
    }
    for (;;)
    {
      if ((localLocalMediaInfo != null) && ((localLocalMediaInfo.mediaWidth == 0) || (localLocalMediaInfo.mediaHeight == 0)))
      {
        bptj localbptj = new bptj();
        bpti.a(paramString, localbptj);
        localLocalMediaInfo.mediaWidth = localbptj.a[0];
        localLocalMediaInfo.mediaHeight = localbptj.a[1];
        localLocalMediaInfo.rotation = localbptj.a[2];
        if (paramPhotoCommonBaseData.allMediaInfoHashMap != null)
        {
          paramPhotoCommonBaseData = (LocalMediaInfo)paramPhotoCommonBaseData.allMediaInfoHashMap.get(paramString);
          if ((paramPhotoCommonBaseData != null) && ((paramPhotoCommonBaseData.mediaWidth == 0) || (paramPhotoCommonBaseData.mediaHeight == 0)))
          {
            paramPhotoCommonBaseData.mediaWidth = localLocalMediaInfo.mediaWidth;
            paramPhotoCommonBaseData.mediaHeight = localLocalMediaInfo.mediaHeight;
            paramPhotoCommonBaseData.rotation = localLocalMediaInfo.rotation;
          }
        }
      }
      return localLocalMediaInfo;
    }
  }
  
  public void a(boolean paramBoolean, PhotoCommonBaseData<akmq> paramPhotoCommonBaseData)
  {
    this.b = paramBoolean;
    if (paramBoolean)
    {
      paramPhotoCommonBaseData.needMediaInfo = true;
      SvEffectSdkInitor.init();
    }
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return false;
    }
    return this.b;
  }
  
  public boolean a(PhotoCommonBaseData<akmq> paramPhotoCommonBaseData)
  {
    int i = 0;
    while (i < paramPhotoCommonBaseData.selectedPhotoList.size())
    {
      String str = (String)paramPhotoCommonBaseData.selectedPhotoList.get(i);
      if (ImageManager.isNetworkUrl(str)) {}
      while (a(paramPhotoCommonBaseData, str) != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmq
 * JD-Core Version:    0.7.0.1
 */