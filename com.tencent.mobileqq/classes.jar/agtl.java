import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import mqq.util.WeakReference;

public class agtl
  extends agrm
{
  protected agtl(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agrj b(AlbumListFragment paramAlbumListFragment)
  {
    if ((jdField_a_of_type_Agrj == null) || (jdField_a_of_type_Agrj.a.get() != paramAlbumListFragment)) {}
    try
    {
      if ((jdField_a_of_type_Agrj == null) || (jdField_a_of_type_Agrj.a.get() != paramAlbumListFragment)) {
        jdField_a_of_type_Agrj = new agtl(paramAlbumListFragment);
      }
      return jdField_a_of_type_Agrj;
    }
    finally {}
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Agre.a.a(true);
  }
  
  protected void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    int i;
    if (paramQQAlbumInfo._id.equals("$RecentAlbumId")) {
      i = 1;
    }
    for (;;)
    {
      axqw.b(null, "CliOper", "", this.jdField_a_of_type_Agsb.a, "0X800A917", "0X800A917", i, 0, "", "", "", "");
      super.a(paramQQAlbumInfo, paramInt, paramIntent);
      return;
      if (paramQQAlbumInfo._id.equals("qzone_album")) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtl
 * JD-Core Version:    0.7.0.1
 */