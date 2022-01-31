import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.widget.AdapterView;

public class agrh
  implements bfpc
{
  private agrh(AlbumListFragment paramAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_Agro.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      bcpw.a(this.a.getActivity(), 2131690020, 0).a();
      return;
    }
    this.a.jdField_a_of_type_Agrj.a(paramAdapterView, paramInt, paramView);
    this.a.jdField_a_of_type_Agri.a(paramAdapterView, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrh
 * JD-Core Version:    0.7.0.1
 */