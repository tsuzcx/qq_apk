import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import java.util.ArrayList;
import java.util.List;

public class airw
  extends aiqq
{
  private List<String> a;
  
  airw(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (AlbumListFragment)this.mFragment;
    if ((paramViewGroup != null) && (paramViewGroup.isAdded()) && (!paramViewGroup.isDetached()) && (!paramViewGroup.isRemoving()))
    {
      paramViewGroup = paramViewGroup.listAdapter;
      if (paramViewGroup != null)
      {
        paramViewGroup = paramViewGroup.getItem(paramInt);
        if ((paramViewGroup != null) && ((paramView instanceof TextView))) {
          ((TextView)paramView).setText(paramViewGroup.name);
        }
      }
    }
    return paramView;
  }
  
  public void initData(Intent paramIntent)
  {
    if (paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0) == 5) {
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    }
    super.initData(paramIntent);
    this.mPhotoCommonData.albumName = paramIntent.getStringExtra("ALBUM_NAME");
    paramIntent = (AlbumListFragment)this.mFragment;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()))
    {
      paramIntent = bkmc.a(paramIntent.getActivity().getApplicationContext(), this.mPhotoCommonData.myUin, "pref_select_album");
      if (!TextUtils.isEmpty(paramIntent)) {
        break label173;
      }
    }
    label173:
    for (paramIntent = new ArrayList();; paramIntent = bkmc.a(paramIntent))
    {
      this.a = paramIntent;
      if ((this.a != null) && (!this.a.isEmpty())) {
        this.mPhotoCommonData.albumId = ((String)this.a.get(0));
      }
      if (TextUtils.isEmpty(this.mPhotoCommonData.albumId)) {
        this.mPhotoCommonData.albumId = "$RecentAlbumId";
      }
      return;
    }
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    boolean bool = super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
    if (!TextUtils.isEmpty(this.mPhotoCommonData.albumName)) {
      paramIntent.putExtra("ALBUM_NAME", this.mPhotoCommonData.albumName);
    }
    paramIntent = (AlbumListFragment)this.mFragment;
    if ((paramIntent != null) && (paramIntent.isAdded()) && (!paramIntent.isDetached()) && (!paramIntent.isRemoving()) && (this.a != null)) {
      if (!TextUtils.isEmpty(paramQQAlbumInfo._id))
      {
        if ((this.a.contains(paramQQAlbumInfo._id)) && (!TextUtils.equals(paramQQAlbumInfo._id, (CharSequence)this.a.get(0)))) {
          this.a.remove(paramQQAlbumInfo._id);
        }
        if (!this.a.isEmpty()) {
          break label199;
        }
        this.a.add(paramQQAlbumInfo._id);
      }
    }
    for (;;)
    {
      bkmc.a(paramIntent.getActivity().getApplicationContext(), this.mPhotoCommonData.myUin, "pref_select_album", bkmc.a(this.a.iterator()));
      return bool;
      label199:
      this.a.set(0, paramQQAlbumInfo._id);
    }
  }
  
  public void queryAlbumList(int paramInt)
  {
    super.queryAlbumList(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airw
 * JD-Core Version:    0.7.0.1
 */