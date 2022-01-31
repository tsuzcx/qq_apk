import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault.1;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault.2;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicDefault.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class agfo
  extends agfk
  implements agfm
{
  protected agfo(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.jdField_a_of_type_Agfm = this;
  }
  
  public static agfk a(AlbumListFragment paramAlbumListFragment)
  {
    if ((jdField_a_of_type_Agfk == null) || (jdField_a_of_type_Agfk.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {}
    try
    {
      if ((jdField_a_of_type_Agfk == null) || (jdField_a_of_type_Agfk.jdField_a_of_type_MqqUtilWeakReference.get() != paramAlbumListFragment)) {
        jdField_a_of_type_Agfk = new agfo(paramAlbumListFragment);
      }
      return jdField_a_of_type_Agfk;
    }
    finally {}
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    agfp localagfp = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp;
    View localView;
    QQAlbumInfo localQQAlbumInfo;
    Object localObject;
    if (paramView == null)
    {
      localView = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getLayoutInflater(null).inflate(2131495066, null);
      paramViewGroup = (TextView)localView;
      localQQAlbumInfo = localagfp.a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      paramViewGroup.setText(paramView);
      localObject = paramViewGroup.getCompoundDrawables()[0];
      if (localQQAlbumInfo._id.equals("qzone_album")) {
        break label488;
      }
      if (localagfp.getItemViewType(paramInt) != 1) {
        break label443;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label429;
      }
      paramView = baaf.a(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label225:
      LocalMediaInfo localLocalMediaInfo = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      localLocalMediaInfo.thumbWidth = 200;
      if ((localObject == null) || (!URLDrawable.class.isInstance(localObject))) {
        break label533;
      }
      localObject = (URLDrawable)localObject;
      if (!paramView.equals(((URLDrawable)localObject).getURL())) {
        break label533;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        if (!befo.d()) {
          break label455;
        }
        paramView = axwd.a(paramView, agfp.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, agfp.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        label307:
        paramView.setTag(localQQAlbumInfo.mCoverInfo);
        paramView.setBounds(0, 0, localagfp.jdField_a_of_type_Int, localagfp.jdField_b_of_type_Int);
        if (!localQQAlbumInfo._id.equals(this.jdField_a_of_type_Aggf.jdField_c_of_type_JavaLangString)) {
          break label527;
        }
        localObject = localagfp.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      }
      for (;;)
      {
        paramViewGroup.setCompoundDrawables(paramView, null, (Drawable)localObject, null);
        for (;;)
        {
          if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
          {
            localView.setBackgroundColor(-16777216);
            paramViewGroup.setTextColor(-9211021);
          }
          return localView;
          paramViewGroup = (TextView)paramView;
          localView = paramView;
          break;
          label429:
          paramView = baaf.a(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
          break label225;
          label443:
          paramView = baaf.a(localQQAlbumInfo.mCoverInfo);
          break label225;
          label455:
          localObject = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDrawable(2130842768);
          paramView = axwd.a(paramView, (Drawable)localObject, (Drawable)localObject);
          break label307;
          label488:
          paramView = localagfp.jdField_a_of_type_AndroidContentResResources.getDrawable(2130846556);
          paramView.setBounds(0, 0, localagfp.jdField_a_of_type_Int, localagfp.jdField_b_of_type_Int);
          paramViewGroup.setCompoundDrawables(paramView, null, null, null);
        }
        label527:
        localObject = null;
      }
      label533:
      localObject = null;
    }
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz;
    boolean bool1 = ((afzz)localObject).d();
    boolean bool2 = ((afzz)localObject).c();
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append("_size>0 and (mime_type='image/jpeg' or mime_type='image/gif' or (mime_type='*/*' and _display_name LIKE'%.jpg%' )  or (mime_type='*/*' and _display_name LIKE'%.jpeg%' )  or (mime_type='*/*' and _display_name LIKE'%.gif%' )  or (mime_type='*/*' and _display_name LIKE'%.bmp%' )  or (mime_type='*/*' and _display_name LIKE'%.png%' )  or mime_type LIKE'%bmp%' or mime_type LIKE'%bitmap%' or mime_type='image/png'");
    if (bool1) {
      ((StringBuffer)localObject).append(" or mime_type='image/heif' or mime_type='image/heic'");
    }
    if (bool2) {
      ((StringBuffer)localObject).append(" or mime_type='image/webp'");
    }
    ((StringBuffer)localObject).append(")) GROUP BY (1");
    return ((StringBuffer)localObject).toString();
  }
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, afzz paramafzz, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return baaf.a(paramContext, paramInt3, paramInt2, paramafzz, paramBoolean, paramInt1, paramArrayList, false);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    Object localObject;
    if ((paramList1 == null) && (paramList2 == null)) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      for (;;)
      {
        badi.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label659;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (agfp.a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if ((paramList1 != null) || (paramList2 == null)) {
          break;
        }
        localObject = paramList2;
      }
      if (paramList1 == null) {
        break;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label659:
    label790:
    for (;;)
    {
      localObject = paramList1;
      if (!paramList2.hasNext()) {
        break;
      }
      localObject = (QQAlbumInfo)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      QQAlbumInfo localQQAlbumInfo;
      while (localIterator.hasNext())
      {
        localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
        if (localQQAlbumInfo._id.equals(((QQAlbumInfo)localObject)._id)) {
          localQQAlbumInfo.mMediaFileCount += ((QQAlbumInfo)localObject).mMediaFileCount;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label790;
        }
        localIterator = paramList1.iterator();
        i = 0;
        label239:
        if (localIterator.hasNext())
        {
          localQQAlbumInfo = (QQAlbumInfo)localIterator.next();
          if (((QQAlbumInfo)localObject).coverDate > localQQAlbumInfo.coverDate)
          {
            j = 1;
            paramList1.add(i, localObject);
          }
        }
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label784;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label239;
          boolean bool;
          if (paramInt == -1)
          {
            paramList1 = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.b(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Agff.jdField_c_of_type_Int, this.jdField_a_of_type_Agff.jdField_b_of_type_Int, this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz, this.jdField_a_of_type_Agff.jdField_d_of_type_Int, this.jdField_a_of_type_Agff.jdField_d_of_type_Boolean, this.jdField_a_of_type_Agff.jdField_a_of_type_JavaUtilArrayList);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz != null) && (this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz.b()))
            {
              paramList1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
              paramList1 = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity().getContentResolver().query(paramList1, new String[] { "_id" }, "_size>0 ", null, null);
              i = 0;
              if (paramList1 != null)
              {
                i = paramList1.getCount();
                paramList1.close();
              }
              if (i <= 0) {
                break label707;
              }
              bool = true;
            }
          }
          for (;;)
          {
            label496:
            ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.jdField_a_of_type_Boolean = bool;
            if (bool)
            {
              if (paramInt != -1) {
                break label738;
              }
              paramList1 = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
            }
            for (;;)
            {
              ((List)localObject).add(1, paramList1);
              if ((paramInt == -1) && (((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.jdField_b_of_type_Boolean) && (((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.jdField_a_of_type_Long > 0L))
              {
                paramList1 = new QQAlbumInfo();
                paramList1._id = "qzone_album";
                paramList1.name = "空间相册";
                paramList1.mMediaFileCount = ((int)((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.jdField_a_of_type_Long);
                ((List)localObject).add(0, paramList1);
              }
              badi.a("PEAK", "compact.queryRecentBucket");
              return localObject;
              paramList1 = new QQAlbumInfo();
              paramList1._id = "$RecentAlbumId";
              paramList1.name = baae.l;
              paramList1.mCoverInfo = new LocalMediaInfo();
              break;
              label707:
              paramList1 = agak.a(BaseApplicationImpl.getContext());
              i = 0;
              if (paramList1 != null) {
                i = paramList1.a();
              }
              if (i <= 0) {
                break label774;
              }
              bool = true;
              break label496;
              label738:
              paramList1 = new QQAlbumInfo();
              paramList1._id = "$VideoAlbumId";
              paramList1.name = baae.n;
              paramList1.mCoverInfo = new LocalMediaInfo();
            }
            bool = false;
          }
        }
        break;
      }
    }
  }
  
  public void a(int paramInt)
  {
    int k = 1;
    int n = 0;
    agfp localagfp = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp;
    afzz localafzz = this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz;
    List localList;
    int i;
    if ((localafzz != null) && (localafzz.a()))
    {
      badi.a();
      localList = localagfp.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList != null) && (localList.size() == paramInt))
      {
        i = 1;
        badi.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      Object localObject;
      if ((localafzz != null) && (localafzz.b()))
      {
        badi.a();
        localObject = localagfp.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localafzz);
        if ((paramInt != -1) && (localObject != null) && (((List)localObject).size() == paramInt))
        {
          i = 1;
          badi.a("PEAK", "queryVideoBuckets");
        }
      }
      for (int j = i;; j = i)
      {
        badi.a();
        localList = this.jdField_a_of_type_Agfm.a(localList, (List)localObject, paramInt);
        if (localList != null) {
          for (i = 0;; i = m + i)
          {
            m = i;
            if (k >= localList.size()) {
              break;
            }
            m = ((QQAlbumInfo)localList.get(k)).mMediaFileCount;
            k += 1;
          }
        }
        int m = 0;
        localObject = new StringBuilder().append("compact(");
        if (localList == null) {}
        for (i = n;; i = localList.size() - 1)
        {
          badi.a("PEAK", i + "," + m + ")");
          localagfp.b(localList);
          if (paramInt != -1)
          {
            if (j == 0) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new AlbumListLogicDefault.2(this, localagfp));
          }
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AlbumListLogicDefault.3(this, localagfp, localafzz));
        return;
        break;
        localObject = null;
      }
      i = 0;
      break;
      localList = null;
      i = 0;
    }
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Agff.jdField_a_of_type_Atdk = new agfn(this);
    this.jdField_a_of_type_Agff.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    int i = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz = afzz.a(i);
    this.jdField_a_of_type_Agff.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.jdField_a_of_type_Agff.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agff.jdField_a_of_type_Afzz = new afzs(afzz.d);
      this.jdField_a_of_type_Agff.jdField_a_of_type_Int = 1;
    }
    String str = paramIntent.getStringExtra("peak.myUin");
    Object localObject = str;
    if (str == null) {
      localObject = bhfc.a().getCurrentAccountUin();
    }
    if (localObject != null) {
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString = ((String)localObject);
    }
    if (this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaLangString == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    this.jdField_a_of_type_Aggf.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.jdField_a_of_type_Aggf.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aggf.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.jdField_a_of_type_Aggf.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean)
    {
      localObject = new NewIntent(BaseApplicationImpl.getApplication(), awcx.class);
      ((NewIntent)localObject).putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.jdField_a_of_type_Agff.jdField_a_of_type_Atdk);
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
    }
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null)
    {
      if ((this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
        break label422;
      }
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap = paramIntent;
    }
    for (;;)
    {
      ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp = new agfp((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.a(this.jdField_a_of_type_Aggf.jdField_c_of_type_Boolean);
      ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agfp.a(this.jdField_a_of_type_Aggf.jdField_a_of_type_Long);
      ThreadManager.getFileThreadHandler().post(new AlbumListLogicDefault.1(this));
      return;
      label422:
      this.jdField_a_of_type_Aggf.jdField_a_of_type_JavaUtilHashMap.putAll(paramIntent);
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
      paramIntent = bfpy.a();
      paramIntent.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramQQAlbumInfo.putString("keyAction", "actionSelectPicture");
      paramQQAlbumInfo.putBoolean("key_need_change_to_jpg", true);
      bfpr.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramIntent, paramQQAlbumInfo, 100016);
      return;
    }
    if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
    {
      paramIntent.putExtra("from_qqstory_custom_data", true);
      paramQQAlbumInfo = vhg.a().b();
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
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    paramIntent.putExtra("album_enter_directly", false);
    XListView localXListView = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", localXListView.getFirstVisiblePosition());
    View localView = localXListView.getChildAt(0);
    if (localView == null) {}
    for (paramInt = 0;; paramInt = localView.getTop())
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + localXListView.getFirstVisiblePosition() + " top:" + paramInt);
      }
      this.jdField_a_of_type_Agff.jdField_c_of_type_Boolean = true;
      if (!"$VideoAlbumId".equals(paramQQAlbumInfo._id)) {
        break;
      }
      awqx.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
      return;
    }
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfo
 * JD-Core Version:    0.7.0.1
 */