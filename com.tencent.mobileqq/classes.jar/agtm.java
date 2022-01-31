import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class agtm
  extends agrk
{
  private List<String> a;
  
  private agtm(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public static agrh b(AlbumListFragment paramAlbumListFragment)
  {
    if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {}
    try
    {
      if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {
        jdField_a_of_type_Agrh = new agtm(paramAlbumListFragment);
      }
      return jdField_a_of_type_Agrh;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = (AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((paramViewGroup != null) && (paramViewGroup.isAdded()) && (!paramViewGroup.isDetached()) && (!paramViewGroup.isRemoving()))
    {
      paramViewGroup = paramViewGroup.a;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.a(paramInt);
        if ((paramViewGroup != null) && ((paramView instanceof TextView))) {
          ((TextView)paramView).setText(paramViewGroup.name);
        }
      }
    }
    return paramView;
  }
  
  public void a(int paramInt)
  {
    super.a(-1);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0) == 5) {
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    }
    super.a(paramIntent);
    this.jdField_a_of_type_Agrz.b = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = (AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()))
    {
      paramIntent = bifz.a(paramIntent.getActivity().getApplicationContext(), this.jdField_a_of_type_Agrz.a, "pref_select_album");
      if (!TextUtils.isEmpty(paramIntent)) {
        break label176;
      }
    }
    label176:
    for (paramIntent = new ArrayList();; paramIntent = bifz.a(paramIntent))
    {
      this.jdField_a_of_type_JavaUtilList = paramIntent;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        this.jdField_a_of_type_Agrz.c = ((String)this.jdField_a_of_type_JavaUtilList.get(0));
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_Agrz.c)) {
        this.jdField_a_of_type_Agrz.c = "$RecentAlbumId";
      }
      return;
    }
  }
  
  protected void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    super.a(paramQQAlbumInfo, paramInt, paramIntent);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Agrz.b)) {
      paramIntent.putExtra("ALBUM_NAME", this.jdField_a_of_type_Agrz.b);
    }
    paramIntent = (AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()) && (this.jdField_a_of_type_JavaUtilList != null)) {
      if (!TextUtils.isEmpty(paramQQAlbumInfo._id))
      {
        if ((this.jdField_a_of_type_JavaUtilList.contains(paramQQAlbumInfo._id)) && (!TextUtils.equals(paramQQAlbumInfo._id, (CharSequence)this.jdField_a_of_type_JavaUtilList.get(0)))) {
          this.jdField_a_of_type_JavaUtilList.remove(paramQQAlbumInfo._id);
        }
        if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          break label198;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramQQAlbumInfo._id);
      }
    }
    for (;;)
    {
      bifz.a(paramIntent.getActivity().getApplicationContext(), this.jdField_a_of_type_Agrz.a, "pref_select_album", bifz.a(this.jdField_a_of_type_JavaUtilList.iterator()));
      return;
      label198:
      this.jdField_a_of_type_JavaUtilList.set(0, paramQQAlbumInfo._id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agtm
 * JD-Core Version:    0.7.0.1
 */