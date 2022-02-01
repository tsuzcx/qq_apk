import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class aaov
  implements aaoz
{
  aaov(aaor paramaaor) {}
  
  public void a(int paramInt, aapd paramaapd)
  {
    if (aaor.a(this.a)) {
      aaor.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = aaor.a(this.a).a(paramInt);
    if ((aaor.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      aaor.b(this.a);
      aaor.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      aaor.a(this.a, localVsMusicItemInfo, paramInt, paramaapd);
    }
    aaor.c(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    aaor.a(this.a).setHasAutoSet(false);
    if (aaor.a(this.a) != null)
    {
      paramVsMusicItemInfo = aaor.a(this.a);
      if (!aaor.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      aaor.a(this.a).b();
    }
    aaor.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (aaor.a(this.a) != null) && (aaor.a(this.a).mSongMid != null) && (aaor.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      aaor.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaov
 * JD-Core Version:    0.7.0.1
 */