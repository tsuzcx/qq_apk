import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask.1;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class agnw
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  public agnw(PhotoListActivity paramPhotoListActivity) {}
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    bbfb.a();
    int i = -1;
    if (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))
    {
      i = 100;
      if (PhotoListActivity.c(this.a)) {
        i = QzoneConfig.getInstance().getConfig("PhotoAlbum", "MaxRecentPhotoNum", 200);
      }
    }
    int j;
    Object localObject1;
    if (((PhotoListActivity.c(this.a)) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId"))) || ((this.a.l) && (this.a.k)))
    {
      j = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitSize", 20480);
      k = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoLimitWidth", 100);
      localObject1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "RecentPhotoBlockPaths", "MagazineUnlock");
      paramVarArgs = null;
      if (localObject1 != null) {
        paramVarArgs = PhotoListActivity.a(this.a, (String)localObject1);
      }
      paramVarArgs = bbbx.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_Aglv, j, k, true, paramVarArgs, this.a.k, this.a.jdField_e_of_type_Long);
    }
    for (;;)
    {
      bbfb.a("PEAK", "getAlbumMedias");
      if (paramVarArgs != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "photoList is null");
      }
      localObject1 = null;
      return localObject1;
      if (PhotoListActivity.a(this.a))
      {
        if ((!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) && (this.a.jdField_b_of_type_JavaLangString.equals("$CustomAlbumId")))
        {
          paramVarArgs = new ArrayList();
          paramVarArgs.addAll(vtz.a().b());
        }
        else
        {
          paramVarArgs = bbbx.a(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_Aglv, 0, 0, true, null, false, this.a.jdField_e_of_type_Long, 1);
        }
      }
      else {
        paramVarArgs = bbbx.b(this.a, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString, i, this.a.jdField_a_of_type_Aglv, this.a.jdField_e_of_type_Long);
      }
    }
    if (((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a))) && (QzoneConfig.getInstance().getConfig("PhotoAlbum", "paranoramaOpenCheck", 1) != 0))
    {
      PhotoListActivity.a(this.a, paramVarArgs);
      if ((this.a.jdField_c_of_type_JavaUtilArrayList == null) || (this.a.jdField_c_of_type_JavaUtilArrayList.size() == 0)) {
        break label670;
      }
      i = 0;
      label446:
      if (i >= this.a.jdField_c_of_type_JavaUtilArrayList.size()) {
        break label670;
      }
      localObject1 = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(i);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label511;
      }
      QZLog.e("PhotoListActivity:QueryPhotoTask", "doInBackground: filter photo error, tempPath null");
      j = i;
    }
    for (;;)
    {
      i = j + 1;
      break label446;
      QLog.i("PhotoListActivity", 2, "@panoramatest isnot fromqzone");
      break;
      label511:
      j = i;
      if (!new File((String)localObject1).exists()) {
        if ((((String)localObject1).startsWith("http")) && (this.a.jdField_b_of_type_JavaUtilHashMap != null))
        {
          j = i;
          if (this.a.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject1)) {}
        }
        else
        {
          this.a.jdField_c_of_type_JavaUtilArrayList.remove(i);
          i -= 1;
          if ((!PhotoListActivity.f(this.a)) && (!PhotoListActivity.e(this.a)) && (!PhotoListActivity.d(this.a)))
          {
            j = i;
            if (!PhotoListActivity.a(this.a)) {}
          }
          else
          {
            j = i;
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null)
            {
              j = i;
              if (this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1))
              {
                this.a.jdField_c_of_type_JavaUtilHashMap.remove(localObject1);
                j = i;
              }
            }
          }
        }
      }
    }
    label670:
    if (this.a.L)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
        if ((!((LocalMediaInfo)localObject1).path.endsWith(".gif")) && ((((LocalMediaInfo)localObject1).mediaHeight < this.a.u) || (((LocalMediaInfo)localObject1).mediaWidth < this.a.t))) {
          paramVarArgs.remove(i);
        }
        if ((((LocalMediaInfo)localObject1).path.endsWith(".gif")) && (((LocalMediaInfo)localObject1).fileSize > this.a.jdField_v_of_type_Int)) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    if (this.a.N)
    {
      i = paramVarArgs.size() - 1;
      while (i >= 0)
      {
        if (!((LocalMediaInfo)paramVarArgs.get(i)).path.endsWith(".mp4")) {
          paramVarArgs.remove(i);
        }
        i -= 1;
      }
    }
    this.a.q = 0;
    this.a.r = 0;
    long l1 = System.currentTimeMillis();
    long l2 = bbbx.jdField_a_of_type_Long;
    if (bbbx.jdField_a_of_type_JavaUtilHashMap.containsKey(this.a.jdField_b_of_type_JavaLangString)) {}
    for (int k = ((Integer)bbbx.jdField_a_of_type_JavaUtilHashMap.get(this.a.jdField_b_of_type_JavaLangString)).intValue();; k = 0)
    {
      Object localObject2;
      if ((this.a.C) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListActivity.a().remove(((LocalMediaInfo)localObject2).path);
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null) {
              this.a.jdField_c_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject2).path);
            }
          }
        }
        paramVarArgs.addAll(0, PhotoListActivity.a().values());
      }
      if ((this.a.D) && (this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")))
      {
        localObject1 = paramVarArgs.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject2).path)))
          {
            PhotoListActivity.a().remove(((LocalMediaInfo)localObject2).path);
            if (this.a.jdField_c_of_type_JavaUtilHashMap != null) {
              this.a.jdField_c_of_type_JavaUtilHashMap.remove(((LocalMediaInfo)localObject2).path);
            }
          }
        }
        localObject1 = PhotoListActivity.a().values();
        if (localObject1 != null)
        {
          localObject1 = ((Collection)localObject1).iterator();
          i = 0;
          label1194:
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (LocalMediaInfo)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject2).mMimeType))) {
              break label2272;
            }
            paramVarArgs.add(i, localObject2);
            i += 1;
          }
        }
      }
      label2185:
      label2272:
      for (;;)
      {
        break label1194;
        agpk.a(paramVarArgs, null, PhotoListActivity.a(this.a));
        int n = paramVarArgs.size();
        localObject1 = new ArrayList(n);
        i = 0;
        int m = 0;
        Object localObject3;
        if (m < paramVarArgs.size())
        {
          localObject2 = (LocalMediaInfo)paramVarArgs.get(m);
          if (((LocalMediaInfo)localObject2).path == null) {
            j = i;
          }
          for (;;)
          {
            m += 1;
            i = j;
            break;
            int i1 = bbbx.a((LocalMediaInfo)localObject2);
            if (((PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.g(this.a)) || (PhotoListActivity.a(this.a))) && (this.a.K))
            {
              ((LocalMediaInfo)localObject2).position = Integer.valueOf(m);
              ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
              if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.contains(((LocalMediaInfo)localObject2).path)))
              {
                ((LocalMediaInfo)localObject2).selectStatus = 1;
                if (!this.a.d.contains(((LocalMediaInfo)localObject2).position)) {
                  this.a.d.add(((LocalMediaInfo)localObject2).position);
                }
                if ((this.a.K) && (i1 == 1))
                {
                  localObject3 = this.a;
                  ((PhotoListActivity)localObject3).q += 1;
                  if (this.a.q == 1) {
                    this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
                  }
                }
                if ((this.a.C) && (this.a.jdField_c_of_type_JavaUtilHashMap != null) && (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject2).path))) {
                  this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
                }
                j = i;
                if (TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) {
                  continue;
                }
                j = i;
                if (!"image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)) {
                  continue;
                }
                localObject2 = this.a;
                ((PhotoListActivity)localObject2).r += 1;
                j = i;
              }
            }
            else
            {
              if (i1 == 0) {
                j = i;
              }
              for (;;)
              {
                ((LocalMediaInfo)localObject2).position = Integer.valueOf(m);
                ((ArrayList)localObject1).add(((LocalMediaInfo)localObject2).path);
                i = j;
                break;
                j = i;
                if (i1 == 1) {
                  j = i + 1;
                }
              }
            }
            if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() < this.a.jdField_i_of_type_Int) && (this.a.m != null) && (((LocalMediaInfo)localObject2).path.equals(this.a.m)))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 1;
              this.a.jdField_c_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject2).path);
              this.a.d.add(((LocalMediaInfo)localObject2).position);
              if ((!PhotoListActivity.f(this.a)) && (!PhotoListActivity.e(this.a)) && (!PhotoListActivity.d(this.a)) && (!PhotoListActivity.h(this.a)))
              {
                j = i;
                if (!PhotoListActivity.a(this.a)) {}
              }
              else
              {
                this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
                j = i;
              }
            }
            else if ((this.a.jdField_v_of_type_Boolean) && (l1 - l2 <= 60000L) && (k == paramVarArgs.size()) && (((LocalMediaInfo)localObject2).path.equals(bbbx.jdField_a_of_type_JavaLangString)))
            {
              ((LocalMediaInfo)localObject2).selectStatus = 3;
              j = i;
            }
            else
            {
              j = i;
              if (!PhotoListActivity.i(this.a))
              {
                ((LocalMediaInfo)localObject2).selectStatus = 2;
                j = i;
              }
            }
          }
        }
        if (((PhotoListActivity.f(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)) || (PhotoListActivity.j(this.a)) || (PhotoListActivity.g(this.a)) || (PhotoListActivity.a(this.a))) && ((this.a.K) || (this.a.jdField_b_of_type_Boolean)))
        {
          System.currentTimeMillis();
          if (PhotoListActivity.jdField_a_of_type_JavaUtilHashMap == null)
          {
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap = new HashMap();
            i = 0;
            label2042:
            if (i >= n) {
              break label2185;
            }
            localObject2 = (LocalMediaInfo)paramVarArgs.get(i);
            if (((LocalMediaInfo)localObject2).path != null) {
              break label2168;
            }
          }
          for (;;)
          {
            i += 1;
            break label2042;
            localObject2 = this.a.jdField_c_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              if ((PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject3)) && (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject3))) {
                this.a.jdField_c_of_type_JavaUtilHashMap.put(localObject3, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.get(localObject3));
              }
            }
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.clear();
            break;
            label2168:
            PhotoListActivity.jdField_a_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject2).path, localObject2);
          }
          System.currentTimeMillis();
        }
        if (n > 1000) {
          PhotoListActivity.jdField_a_of_type_JavaUtilArrayList = (ArrayList)localObject1;
        }
        for (this.a.y = true;; this.a.y = false)
        {
          localObject1 = paramVarArgs;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
          return paramVarArgs;
          this.a.jdField_b_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
        }
      }
    }
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    int m = 0;
    this.a.runOnUiThread(new PhotoListActivity.QueryPhotoTask.2(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.a.C) || (!this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.a.D)
        {
          localObject = paramList;
          if (!this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.a.jdField_a_of_type_Agnt.a((List)localObject);
      this.a.jdField_a_of_type_Agnt.notifyDataSetChanged();
      this.a.g();
      bcql.a(this.a, ajya.a(2131708114), 1000).a();
      return;
    }
    if (((!this.a.C) && (!this.a.L)) || ((this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")) || ((this.a.D) && (this.a.jdField_b_of_type_JavaLangString.equals("$VideoAlbumId")))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Agnt.a(paramList);
    label289:
    int i;
    if (paramList.isEmpty())
    {
      bcql.a(this.a, ajya.a(2131708117), 1000).a();
      if (this.a.jdField_i_of_type_Boolean)
      {
        this.a.jdField_i_of_type_Boolean = false;
        if (this.a.s != -1) {
          break label800;
        }
        i = PhotoListActivity.n;
        label322:
        if (i != -1) {
          break label827;
        }
        localObject = (LinkedHashMap)bbbx.jdField_b_of_type_JavaUtilHashMap.get(this.a.jdField_b_of_type_JavaLangString);
        if (localObject == null) {
          break label877;
        }
        j = ((LinkedHashMap)localObject).size();
        if (j <= 0) {
          break label877;
        }
      }
    }
    label416:
    label547:
    label565:
    label827:
    label860:
    label877:
    for (int j = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();; j = i)
    {
      i = j;
      int k;
      if (j == -1)
      {
        i = j;
        if (this.a.jdField_v_of_type_Boolean)
        {
          localObject = paramList.iterator();
          k = 0;
          i = j;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label811;
            }
            i = k;
          }
        }
      }
      if ((i == -1) && (this.a.jdField_b_of_type_JavaLangString.equals("$RecentAlbumId")) && (!this.a.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
      {
        k = paramList.size();
        localObject = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(this.a.jdField_c_of_type_JavaUtilArrayList.size() - 1);
        j = 0;
        if (j < k) {
          if (((String)localObject).equals(((LocalMediaInfo)paramList.get(j)).path)) {
            i = j;
          }
        }
      }
      for (;;)
      {
        j = this.a.jdField_a_of_type_Agnt.getCount();
        if (j == 0)
        {
          j = m;
          if (!PhotoListActivity.a(this.a)) {
            break label860;
          }
          if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0))
          {
            paramList = (String)this.a.jdField_c_of_type_JavaUtilArrayList.get(this.a.jdField_c_of_type_JavaUtilArrayList.size() - 1);
            i = this.a.jdField_b_of_type_JavaUtilArrayList.indexOf(paramList);
            if ((i >= 0) && (i < this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.a().getCount())) {
              this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(i);
            }
          }
        }
        for (;;)
        {
          this.a.jdField_a_of_type_Agnt.notifyDataSetChanged();
          this.a.g();
          if (!PhotoListActivity.a(this.a)) {
            break;
          }
          PhotoListActivity.a(this.a, this.a.jdField_c_of_type_JavaUtilArrayList, this.a.jdField_c_of_type_JavaUtilHashMap);
          vtz.a().b(this.a.jdField_c_of_type_JavaUtilArrayList, PhotoListActivity.jdField_a_of_type_JavaUtilHashMap);
          return;
          if ((!this.a.L) || (paramList.size() != 1)) {
            break label289;
          }
          bcql.a(this.a, ajya.a(2131708095), 1000).a();
          if (this.a.jdField_e_of_type_AndroidWidgetTextView == null) {
            break label289;
          }
          this.a.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
          break label289;
          i = this.a.s;
          break label322;
          k += 1;
          break label416;
          j += 1;
          break label518;
          PhotoListActivity.n = -1;
          break label547;
          if (i > j - 1)
          {
            j -= 1;
            break label565;
          }
          j = m;
          if (i < 0) {
            break label565;
          }
          j = i;
          break label565;
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelection(j);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.runOnUiThread(new PhotoListActivity.QueryPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agnw
 * JD-Core Version:    0.7.0.1
 */