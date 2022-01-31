import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.1;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.2;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class agrj
  extends agrh
  implements agri
{
  protected agrj(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.jdField_a_of_type_Agri = this;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Resources localResources = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
    agrm localagrm = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm;
    View localView;
    QQAlbumInfo localQQAlbumInfo;
    Object localObject;
    if (paramView == null)
    {
      localView = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getLayoutInflater(null).inflate(2131560640, null);
      paramViewGroup = (TextView)localView;
      localQQAlbumInfo = localagrm.a(paramInt);
      localView.setContentDescription(localQQAlbumInfo.name + "，" + localQQAlbumInfo.mMediaFileCount + "张照片");
      paramView = localQQAlbumInfo.name;
      if (localQQAlbumInfo.mMediaFileCount > 0) {
        paramView = localQQAlbumInfo.name + String.format(" (%d)", new Object[] { Integer.valueOf(localQQAlbumInfo.mMediaFileCount) });
      }
      paramViewGroup.setText(paramView);
      localObject = paramViewGroup.getCompoundDrawables()[0];
      if (localagrm.getItemViewType(paramInt) != 1) {
        break label403;
      }
      if (!localQQAlbumInfo.mCoverInfo.isSystemMeidaStore) {
        break label389;
      }
      paramView = bbbx.a(localQQAlbumInfo.mCoverInfo, "VIDEO");
      label212:
      LocalMediaInfo localLocalMediaInfo = localQQAlbumInfo.mCoverInfo;
      localQQAlbumInfo.mCoverInfo.thumbHeight = 200;
      localLocalMediaInfo.thumbWidth = 200;
      if ((localObject == null) || (!URLDrawable.class.isInstance(localObject))) {
        break label453;
      }
      localObject = (URLDrawable)localObject;
      if (!paramView.equals(((URLDrawable)localObject).getURL())) {
        break label453;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        if (!bfnz.d()) {
          break label415;
        }
        paramView = aywm.a(paramView, agrm.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, agrm.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
        label294:
        paramView.setTag(localQQAlbumInfo.mCoverInfo);
        paramView.setBounds(0, 0, localagrm.jdField_a_of_type_Int, localagrm.jdField_b_of_type_Int);
        if (!localQQAlbumInfo._id.equals(this.jdField_a_of_type_Agrz.c)) {
          break label447;
        }
        localObject = localagrm.jdField_a_of_type_AndroidGraphicsDrawableDrawable$ConstantState.newDrawable(localResources);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      }
      for (;;)
      {
        paramViewGroup.setCompoundDrawables(paramView, null, (Drawable)localObject, null);
        return localView;
        paramViewGroup = (TextView)paramView;
        localView = paramView;
        break;
        label389:
        paramView = bbbx.a(localQQAlbumInfo.mCoverInfo, "APP_VIDEO");
        break label212;
        label403:
        paramView = bbbx.a(localQQAlbumInfo.mCoverInfo);
        break label212;
        label415:
        localObject = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getDrawable(2130842852);
        paramView = aywm.a(paramView, (Drawable)localObject, (Drawable)localObject);
        break label294;
        label447:
        localObject = null;
      }
      label453:
      localObject = null;
    }
  }
  
  public String a()
  {
    Object localObject = this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv;
    boolean bool1 = ((aglv)localObject).d();
    boolean bool2 = ((aglv)localObject).c();
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
  
  public List<LocalMediaInfo> a(Context paramContext, int paramInt1, int paramInt2, aglv paramaglv, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return bbbx.a(paramContext, paramInt3, paramInt2, paramaglv, paramBoolean, paramInt1, paramArrayList, false);
  }
  
  public List<QQAlbumInfo> a(List<QQAlbumInfo> paramList1, List<QQAlbumInfo> paramList2, int paramInt)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity() == null)) {
      return null;
    }
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
        bbfb.a();
        if ((localObject == null) || (((List)localObject).isEmpty())) {
          break label583;
        }
        j = ((List)localObject).size();
        i = 0;
        while (i < j)
        {
          paramList1 = (QQAlbumInfo)((List)localObject).get(i);
          if ((i != 0) && (agrm.a(paramList1.name)))
          {
            ((List)localObject).remove(paramList1);
            ((List)localObject).add(0, paramList1);
          }
          i += 1;
        }
        if (paramList1 != null) {
          break;
        }
        localObject = paramList2;
      }
      localObject = paramList1;
    } while (paramList2 == null);
    paramList2 = paramList2.iterator();
    label259:
    label516:
    label583:
    label714:
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
          break label714;
        }
        localIterator = paramList1.iterator();
        i = 0;
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
            break label708;
          }
          paramList1.add(localObject);
          break;
          i += 1;
          break label259;
          boolean bool;
          if (paramInt == -1)
          {
            paramList1 = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm.b(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), this.jdField_a_of_type_Agrb.c, this.jdField_a_of_type_Agrb.jdField_b_of_type_Int, this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv, this.jdField_a_of_type_Agrb.d, this.jdField_a_of_type_Agrb.jdField_b_of_type_Boolean, this.jdField_a_of_type_Agrb.jdField_a_of_type_JavaUtilArrayList);
            ((List)localObject).add(0, paramList1);
            if ((this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv != null) && (this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv.b()))
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
                break label631;
              }
              bool = true;
            }
          }
          for (;;)
          {
            ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm.jdField_a_of_type_Boolean = bool;
            if (bool)
            {
              if (paramInt != -1) {
                break label662;
              }
              paramList1 = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity());
            }
            for (;;)
            {
              ((List)localObject).add(1, paramList1);
              bbfb.a("PEAK", "compact.queryRecentBucket");
              return localObject;
              paramList1 = new QQAlbumInfo();
              paramList1._id = "$RecentAlbumId";
              paramList1.name = bbbw.l;
              paramList1.mCoverInfo = new LocalMediaInfo();
              break;
              label631:
              paramList1 = agmg.a(BaseApplicationImpl.getContext());
              i = 0;
              if (paramList1 != null) {
                i = paramList1.a();
              }
              if (i <= 0) {
                break label698;
              }
              bool = true;
              break label516;
              paramList1 = new QQAlbumInfo();
              paramList1._id = "$VideoAlbumId";
              paramList1.name = bbbw.n;
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
    int k = 0;
    int j = 1;
    agrm localagrm = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm;
    aglv localaglv = this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv;
    List localList1;
    int i;
    if ((localaglv != null) && (localaglv.a()))
    {
      bbfb.a();
      localList1 = localagrm.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt);
      if ((paramInt != -1) && (localList1 != null) && (localList1.size() == paramInt))
      {
        i = 1;
        bbfb.a("PEAK", "queryImageBuckets");
      }
    }
    for (;;)
    {
      List localList2;
      if ((localaglv != null) && (localaglv.b()))
      {
        bbfb.a();
        localList2 = localagrm.a(((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).getActivity(), paramInt, localaglv);
        if ((paramInt != -1) && (localList2 != null) && (localList2.size() == paramInt))
        {
          i = 1;
          bbfb.a("PEAK", "queryVideoBuckets");
        }
      }
      for (;;)
      {
        bbfb.a();
        localList1 = this.jdField_a_of_type_Agri.a(localList1, localList2, paramInt);
        if (localList1 != null) {
          while (j < localList1.size())
          {
            k += ((QQAlbumInfo)localList1.get(j)).mMediaFileCount;
            j += 1;
          }
        }
        bbfb.a("PEAK", "compact: medias ==null");
        do
        {
          return;
          bbfb.a("PEAK", "compact(" + (localList1.size() - 1) + "," + k + ")");
          localagrm.b(localList1);
        } while (paramInt == -1);
        if (i != 0)
        {
          ThreadManager.getFileThreadHandler().post(new AlbumListLogicBase.2(this, localagrm));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new AlbumListLogicBase.3(this, localagrm, localaglv));
        return;
        break;
        localList2 = null;
      }
      i = 0;
      break;
      localList1 = null;
      i = 0;
    }
  }
  
  void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0);
    this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv = aglv.a(i);
    this.jdField_a_of_type_Agrb.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    if (this.jdField_a_of_type_Agrb.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Agrb.jdField_a_of_type_Aglv = new aglo(aglv.d);
      this.jdField_a_of_type_Agrb.jdField_a_of_type_Int = 1;
    }
    this.jdField_a_of_type_Agrz.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.jdField_a_of_type_Agrz.jdField_a_of_type_Boolean);
    paramIntent = (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
    if (paramIntent != null)
    {
      if ((this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
        break label183;
      }
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap = paramIntent;
    }
    for (;;)
    {
      ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_Agrm = new agrm((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get());
      ThreadManager.getFileThreadHandler().post(new AlbumListLogicBase.1(this));
      return;
      label183:
      this.jdField_a_of_type_Agrz.jdField_a_of_type_JavaUtilHashMap.putAll(paramIntent);
    }
  }
  
  void a(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    paramIntent.putExtra("ALBUM_ID", paramQQAlbumInfo._id);
    paramIntent.putExtra("ALBUM_NAME", paramQQAlbumInfo.name);
    paramIntent.putExtra("album_enter_directly", false);
    paramQQAlbumInfo = ((AlbumListFragment)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentWidgetXListView;
    paramIntent.putExtra("PhotoConst.photo_selection_index", paramQQAlbumInfo.getFirstVisiblePosition());
    View localView = paramQQAlbumInfo.getChildAt(0);
    if (localView == null) {}
    for (paramInt = 0;; paramInt = localView.getTop())
    {
      paramIntent.putExtra("PhotoConst.photo_selection_y", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "save Scroll Position,index:" + paramQQAlbumInfo.getFirstVisiblePosition() + " top:" + paramInt);
      }
      return;
    }
  }
  
  void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrj
 * JD-Core Version:    0.7.0.1
 */