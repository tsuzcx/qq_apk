import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class abcy
  implements abdc
{
  abcy(abcu paramabcu) {}
  
  public void a(int paramInt, abdg paramabdg)
  {
    if (abcu.a(this.a)) {
      abcu.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = abcu.a(this.a).a(paramInt);
    if ((abcu.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      abcu.b(this.a);
      abcu.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      abcu.a(this.a, localVsMusicItemInfo, paramInt, paramabdg);
    }
    abcu.c(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    abcu.a(this.a).setHasAutoSet(false);
    if (abcu.a(this.a) != null)
    {
      paramVsMusicItemInfo = abcu.a(this.a);
      if (!abcu.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      abcu.a(this.a).b();
    }
    abcu.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (abcu.a(this.a) != null) && (abcu.a(this.a).mSongMid != null) && (abcu.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      abcu.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abcy
 * JD-Core Version:    0.7.0.1
 */