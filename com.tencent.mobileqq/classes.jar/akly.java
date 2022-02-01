import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class akly
  extends AlbumListLogicBase<AlbumListFragment, akmq>
  implements AlbumListLogic.IalbumListAdapterCallBack
{
  protected aklx a;
  
  public akly(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.mAlbumListAdapterCallBack = this;
    this.mAlbumListData = new aklx();
    this.a = ((aklx)this.mAlbumListData);
  }
  
  protected akmb a()
  {
    return (akmb)super.getAlbumListAdapter();
  }
  
  protected akmq a()
  {
    return new aklz(this);
  }
  
  public String adapterGenerateSelection()
  {
    return super.adapterGenerateSelection();
  }
  
  public AlbumListAdapter generateAlbumListAdapter()
  {
    return new akmb((AlbumListFragment)this.mFragment);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    Object localObject1 = a();
    Object localObject2 = ((akmb)localObject1).getItem(paramInt);
    paramViewGroup = (TextView)paramView;
    if (((QQAlbumInfo)localObject2)._id.equals("qzone_album"))
    {
      localObject2 = ((akmb)localObject1).mResources.getDrawable(2130847669);
      ((Drawable)localObject2).setBounds(0, 0, ((akmb)localObject1).mCoverWidth, ((akmb)localObject1).mCoverHeight);
      localObject1 = this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(((akmb)localObject1).mResources);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      paramViewGroup.setCompoundDrawables((Drawable)localObject2, null, (Drawable)localObject1, null);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundColor(-16777216);
      paramViewGroup.setTextColor(-9211021);
    }
    return paramView;
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    String str2 = paramIntent.getStringExtra("peak.myUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = bofz.a().getCurrentAccountUin();
    }
    if (str1 != null) {
      this.mPhotoCommonData.myUin = str1;
    }
    if (this.mPhotoCommonData.myUin == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    a().a(((akmq)this.mOtherCommonData).jdField_a_of_type_Long);
    this.mPhotoCommonData.mIsDisableTroopAlbum = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.mPhotoCommonData.mIsDisableTroopAlbum);
    if ((this.mPhotoCommonData.isShowQzoneAlbum) && (!((akmq)this.mOtherCommonData).jdField_a_of_type_Boolean))
    {
      this.a.jdField_a_of_type_Ayrb = new akma(this);
      paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), bcvp.class);
      paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.a.jdField_a_of_type_Ayrb);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
      this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState = this.mActivity.getResources().getDrawable(2130839337).getConstantState();
    }
  }
  
  public boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo._id.equals("qzone_album")) && (paramBoolean);
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (paramQQAlbumInfo._id.equals("qzone_album"))
    {
      localObject = paramIntent.getExtras();
      ((Bundle)localObject).putInt("key_personal_album_enter_model", 1);
      ((Bundle)localObject).putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      ((Bundle)localObject).putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      ((Bundle)localObject).putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
      ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.forwardToPersonalAlbumSelect(((AlbumListFragment)this.mFragment).getActivity(), localUserInfo, (Bundle)localObject, 100016);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
    {
      localObject = yzz.a().b();
      if (((List)localObject).size() > 0) {
        paramIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName);
      }
      paramIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
      paramIntent.putExtra("report_first_exposure", true);
      paramIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", false);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo._id)) {
      bdla.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  public void postInitUI() {}
  
  public List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akly
 * JD-Core Version:    0.7.0.1
 */