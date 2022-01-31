import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.util.WeakReference;

public class agrk
  extends agrj
  implements agri
{
  protected agrc a;
  
  protected agrk(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.jdField_a_of_type_Agri = this;
    this.a = new agrc();
    this.jdField_a_of_type_Agrc = ((agrc)this.a);
  }
  
  public static agrh a(AlbumListFragment paramAlbumListFragment)
  {
    if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {}
    try
    {
      if ((jdField_a_of_type_Agrh == null) || (jdField_a_of_type_Agrh.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {
        jdField_a_of_type_Agrh = new agrk(paramAlbumListFragment);
      }
      return jdField_a_of_type_Agrh;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.a(paramInt, paramView, paramViewGroup);
    paramViewGroup = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a;
    Object localObject = paramViewGroup.a(paramInt);
    TextView localTextView = (TextView)paramView;
    if (((QQAlbumInfo)localObject)._id.equals("qzone_album"))
    {
      localObject = paramViewGroup.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846750);
      ((Drawable)localObject).setBounds(0, 0, paramViewGroup.jdField_a_of_type_Int, paramViewGroup.jdField_b_of_type_Int);
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundColor(-16777216);
      localTextView.setTextColor(-9211021);
    }
    return paramView;
  }
  
  public String a()
  {
    return super.a();
  }
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, aglv paramaglv, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.a(paramContext, paramInt1, paramInt2, paramaglv, paramInt3, paramBoolean, paramArrayList);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    paramList1 = super.a(paramList1, paramList2, paramInt);
    if ((paramList1 != null) && (!paramList1.isEmpty()) && (paramInt == -1) && (((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.jdField_b_of_type_Boolean) && (((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.jdField_a_of_type_Long > 0L))
    {
      paramList2 = new QQAlbumInfo();
      paramList2._id = "qzone_album";
      paramList2.name = "空间相册";
      paramList2.mMediaFileCount = ((int)((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.jdField_a_of_type_Long);
      paramList1.add(0, paramList2);
    }
    return paramList1;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  protected void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.jdField_a_of_type_Agrc.a = new agrl(this);
    this.jdField_a_of_type_Agrc.c = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    this.jdField_a_of_type_Agrz.c = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    String str2 = paramIntent.getStringExtra("peak.myUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = bjal.a().getCurrentAccountUin();
    }
    if (str1 != null) {
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString = str1;
    }
    if (this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaLangString == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(this.jdField_a_of_type_Agrz.c);
    ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).a.a(this.jdField_a_of_type_Agrz.jdField_a_of_type_Long);
    this.jdField_a_of_type_Agrz.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_a_of_type_Agrz.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_Agrz.c)
    {
      paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), axch.class);
      paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.jdField_a_of_type_Agrc.a);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
    }
  }
  
  protected void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    if (paramQQAlbumInfo._id.equals("qzone_album"))
    {
      paramQQAlbumInfo = paramIntent.getExtras();
      paramQQAlbumInfo.putInt("key_personal_album_enter_model", 1);
      paramQQAlbumInfo.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramQQAlbumInfo.putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      paramQQAlbumInfo.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramQQAlbumInfo.putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      paramIntent = bgyw.a();
      paramIntent.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramQQAlbumInfo.putString("keyAction", "actionSelectPicture");
      paramQQAlbumInfo.putBoolean("key_need_change_to_jpg", true);
      bgyp.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramQQAlbumInfo, 100016);
    }
    do
    {
      return;
      if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
      {
        paramIntent.putExtra("from_qqstory_custom_data", true);
        paramQQAlbumInfo = vtz.a().b();
        if (paramQQAlbumInfo.size() > 0) {
          paramIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)paramQQAlbumInfo.get(0)).mAlbumName);
        }
        paramIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
        paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
        paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
        paramIntent.putExtra("from_qqstory_custom_data", true);
        paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
        paramIntent.putExtra("report_first_exposure", true);
        paramIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
        paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
        paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", false);
        return;
      }
      paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      super.a(paramQQAlbumInfo, paramInt, paramIntent);
    } while (!"$VideoAlbumId".equals(paramQQAlbumInfo._id));
    axqy.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrk
 * JD-Core Version:    0.7.0.1
 */