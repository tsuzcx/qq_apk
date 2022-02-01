import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogic;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogic;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogic;

public class ajta
{
  public static AlbumListLogic a(int paramInt, AlbumListFragment paramAlbumListFragment)
  {
    switch (paramInt)
    {
    default: 
      return new ajqk(paramAlbumListFragment);
    case 1: 
      return new ajrq(paramAlbumListFragment);
    case 7: 
      return new ajrs(paramAlbumListFragment);
    case 4: 
      return new ajrr(paramAlbumListFragment);
    case 3: 
      return new aoxv(paramAlbumListFragment);
    }
    return new ajrt(paramAlbumListFragment);
  }
  
  public static PhotoListLogic a(int paramInt, NewPhotoListActivity paramNewPhotoListActivity)
  {
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
    case 35: 
    case 36: 
    case 37: 
    case 38: 
    case 39: 
    case 42: 
    default: 
      return new ajqv(paramNewPhotoListActivity);
    case 1: 
      return new ajsb(paramNewPhotoListActivity);
    case 7: 
      return new ajsn(paramNewPhotoListActivity);
    case 4: 
      return new ajsj(paramNewPhotoListActivity);
    case 30: 
      return new ajsk(paramNewPhotoListActivity);
    case 3: 
      return new aoyb(paramNewPhotoListActivity);
    case 2: 
      return new ajsg(paramNewPhotoListActivity);
    case 23: 
      return new ajsa(paramNewPhotoListActivity);
    case 26: 
      return new ajru(paramNewPhotoListActivity);
    case 29: 
      return new ajrz(paramNewPhotoListActivity);
    case 24: 
      return new ajsv(paramNewPhotoListActivity);
    case 25: 
      return new ajsr(paramNewPhotoListActivity);
    case 28: 
      return new ajsz(paramNewPhotoListActivity);
    case 27: 
      return new ajsu(paramNewPhotoListActivity);
    case 40: 
      return new ajsc(paramNewPhotoListActivity);
    case 41: 
      return new ajsx(paramNewPhotoListActivity);
    case 43: 
      return new ajsh(paramNewPhotoListActivity);
    case 44: 
      return new ajsm(paramNewPhotoListActivity);
    case 45: 
      return new ajst(paramNewPhotoListActivity);
    case 46: 
      return new ajsi(paramNewPhotoListActivity);
    }
    return new ajsy(paramNewPhotoListActivity);
  }
  
  public static PhotoPreviewLogic a(int paramInt, NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    switch (paramInt)
    {
    default: 
      return new ajrg(paramNewPhotoPreviewActivity);
    case 1: 
      return new ajtd(paramNewPhotoPreviewActivity);
    case 7: 
      return new ajtq(paramNewPhotoPreviewActivity);
    case 2: 
      return new ajtm(paramNewPhotoPreviewActivity);
    case 23: 
      return new ajtb(paramNewPhotoPreviewActivity);
    case 24: 
      return new ajtw(paramNewPhotoPreviewActivity);
    case 25: 
      return new ajtr(paramNewPhotoPreviewActivity);
    case 3: 
      return new aoyc(paramNewPhotoPreviewActivity);
    case 28: 
      return new ajtx(paramNewPhotoPreviewActivity);
    case 40: 
      return new ajtl(paramNewPhotoPreviewActivity);
    case 42: 
      return new ajti(paramNewPhotoPreviewActivity);
    case 45: 
      return new ajtv(paramNewPhotoPreviewActivity);
    case 50: 
      return new ajto(paramNewPhotoPreviewActivity);
    case 29: 
      return new ajre(paramNewPhotoPreviewActivity);
    }
    return new ajtp(paramNewPhotoPreviewActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajta
 * JD-Core Version:    0.7.0.1
 */