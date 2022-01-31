import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import mqq.app.AppRuntime;

public class agkz
  extends atzq
{
  public agkz(AlbumListActivity paramAlbumListActivity) {}
  
  protected void c(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof get_albumlist_num_rsp)))
    {
      this.a.jdField_a_of_type_Long = ((get_albumlist_num_rsp)paramBundle).album_num;
      if (this.a.jdField_a_of_type_Agla != null)
      {
        this.a.jdField_a_of_type_Agla.a(this.a.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_Agla.a();
        if ((this.a.jdField_a_of_type_Long > 0L) && (this.a.q)) {
          LpReportInfo_pf00064.allReport(96, 1, 1);
        }
      }
    }
    BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(AlbumListActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agkz
 * JD-Core Version:    0.7.0.1
 */