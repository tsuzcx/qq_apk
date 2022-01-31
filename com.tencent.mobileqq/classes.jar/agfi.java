import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.widget.AdapterView;

public class agfi
  implements behi
{
  private agfi(AlbumListFragment paramAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_Agfp.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      bbmy.a(this.a.getActivity(), 2131624466, 0).a();
      return;
    }
    this.a.jdField_a_of_type_Agfk.a(paramAdapterView, paramInt, paramView);
    this.a.jdField_a_of_type_Agfj.a(paramAdapterView, paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfi
 * JD-Core Version:    0.7.0.1
 */