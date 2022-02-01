import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class aayv
  implements aayz
{
  aayv(aayr paramaayr) {}
  
  public void a(int paramInt, aazd paramaazd)
  {
    if (aayr.a(this.a)) {
      aayr.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = aayr.a(this.a).a(paramInt);
    if ((aayr.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      aayr.b(this.a);
      aayr.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      aayr.a(this.a, localVsMusicItemInfo, paramInt, paramaazd);
    }
    aayr.c(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    aayr.a(this.a).setHasAutoSet(false);
    if (aayr.a(this.a) != null)
    {
      paramVsMusicItemInfo = aayr.a(this.a);
      if (!aayr.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      aayr.a(this.a).b();
    }
    aayr.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (aayr.a(this.a) != null) && (aayr.a(this.a).mSongMid != null) && (aayr.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      aayr.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aayv
 * JD-Core Version:    0.7.0.1
 */