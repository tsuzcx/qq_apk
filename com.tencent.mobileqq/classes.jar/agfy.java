import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QueryPhotoTask.1;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QueryPhotoTask.2;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QueryPhotoTask.3;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QueryPhotoTask.4;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class agfy
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  public agfy(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    paramVarArgs = this.a.jdField_a_of_type_Aggh.a;
    Object localObject2 = paramVarArgs.jdField_a_of_type_JavaUtilArrayList;
    Object localObject1 = paramVarArgs.jdField_a_of_type_JavaUtilHashMap;
    badi.a();
    List localList = this.a.jdField_a_of_type_Aggh.a();
    this.a.jdField_a_of_type_Aggg.jdField_f_of_type_Int = 0;
    this.a.jdField_a_of_type_Aggg.g = 0;
    long l1 = System.currentTimeMillis();
    long l2 = baaf.jdField_a_of_type_Long;
    if (baaf.jdField_a_of_type_JavaUtilHashMap.containsKey(paramVarArgs.jdField_c_of_type_JavaLangString)) {}
    label1048:
    for (int j = ((Integer)baaf.jdField_a_of_type_JavaUtilHashMap.get(paramVarArgs.jdField_c_of_type_JavaLangString)).intValue();; j = 0)
    {
      Object localObject3;
      Object localObject4;
      if ((this.a.jdField_a_of_type_Aggg.q) && (paramVarArgs.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
          if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
          {
            aggg.jdField_a_of_type_JavaUtilMap.remove(((LocalMediaInfo)localObject4).path);
            if (localObject1 != null) {
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
        }
        localList.addAll(0, aggg.jdField_a_of_type_JavaUtilMap.values());
      }
      int i;
      if ((this.a.jdField_a_of_type_Aggg.r) && (paramVarArgs.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId")))
      {
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
          if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
          {
            aggg.jdField_a_of_type_JavaUtilMap.remove(((LocalMediaInfo)localObject4).path);
            if (localObject1 != null) {
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
        }
        localObject3 = aggg.jdField_a_of_type_JavaUtilMap.values();
        if (localObject3 != null)
        {
          localObject3 = ((Collection)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject4).mMimeType))) {
              break label1112;
            }
            localList.add(i, localObject4);
            i += 1;
          }
        }
      }
      label933:
      label1066:
      label1112:
      for (;;)
      {
        break;
        agdo.a(localList, null, this.a.jdField_a_of_type_Aggg.c);
        int k = localList.size();
        localObject3 = new ArrayList(k);
        i = 0;
        if (i < localList.size())
        {
          localObject4 = (LocalMediaInfo)localList.get(i);
          if (((LocalMediaInfo)localObject4).path == null) {}
          for (;;)
          {
            i += 1;
            break;
            int m = baaf.a((LocalMediaInfo)localObject4);
            ((LocalMediaInfo)localObject4).position = Integer.valueOf(((ArrayList)localObject3).size());
            ((ArrayList)localObject3).add(((LocalMediaInfo)localObject4).path);
            if ((localObject2 != null) && (((ArrayList)localObject2).contains(((LocalMediaInfo)localObject4).path)))
            {
              ((LocalMediaInfo)localObject4).selectStatus = 1;
              if (!paramVarArgs.jdField_b_of_type_JavaUtilArrayList.contains(((LocalMediaInfo)localObject4).position)) {
                paramVarArgs.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject4).position);
              }
              if ((this.a.jdField_a_of_type_Aggg.s) && (m == 1))
              {
                aggg localaggg = this.a.jdField_a_of_type_Aggg;
                localaggg.jdField_f_of_type_Int += 1;
                if (this.a.jdField_a_of_type_Aggg.jdField_f_of_type_Int == 1) {
                  this.a.jdField_a_of_type_Aggg.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject4);
                }
              }
              if ((this.a.jdField_a_of_type_Aggg.q) && (localObject1 != null) && (!((HashMap)localObject1).containsKey(((LocalMediaInfo)localObject4).path))) {
                ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
              }
              if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject4).mMimeType)))
              {
                localObject4 = this.a.jdField_a_of_type_Aggg;
                ((aggg)localObject4).g += 1;
              }
            }
            else if ((localObject2 != null) && (((ArrayList)localObject2).size() < paramVarArgs.jdField_a_of_type_Int) && (((LocalMediaInfo)localObject4).path.equals(this.a.jdField_a_of_type_Aggg.jdField_f_of_type_JavaLangString)))
            {
              ((LocalMediaInfo)localObject4).selectStatus = 1;
              ((ArrayList)localObject2).add(((LocalMediaInfo)localObject4).path);
              paramVarArgs.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject4).position);
              if ((this.a.jdField_a_of_type_Aggg.w) || (paramVarArgs.a())) {
                ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
              }
            }
            else if ((this.a.jdField_a_of_type_Aggg.m) && (l1 - l2 <= 60000L) && (j == localList.size()) && (((LocalMediaInfo)localObject4).path.equals(baaf.jdField_a_of_type_JavaLangString)))
            {
              ((LocalMediaInfo)localObject4).selectStatus = 3;
            }
            else
            {
              ((LocalMediaInfo)localObject4).selectStatus = 2;
            }
          }
        }
        if (this.a.jdField_a_of_type_Aggh.a())
        {
          if (paramVarArgs.jdField_b_of_type_JavaUtilHashMap == null)
          {
            paramVarArgs.jdField_b_of_type_JavaUtilHashMap = new HashMap();
            i = 0;
            if (i >= k) {
              break label1066;
            }
            localObject1 = (LocalMediaInfo)localList.get(i);
            if (((LocalMediaInfo)localObject1).path != null) {
              break label1048;
            }
          }
          for (;;)
          {
            i += 1;
            break label933;
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (String)((Iterator)localObject2).next();
              if ((paramVarArgs.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject4)) && (!((HashMap)localObject1).containsKey(localObject4))) {
                ((HashMap)localObject1).put(localObject4, paramVarArgs.jdField_b_of_type_JavaUtilHashMap.get(localObject4));
              }
            }
            paramVarArgs.jdField_b_of_type_JavaUtilHashMap.clear();
            break;
            paramVarArgs.jdField_b_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
          }
        }
        paramVarArgs.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + localList.size());
        }
        return localList;
      }
    }
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    int m = 0;
    aggf localaggf = this.a.jdField_a_of_type_Aggh.a;
    this.a.runOnUiThread(new NewPhotoListActivity.QueryPhotoTask.2(this));
    Object localObject;
    if (paramList == null)
    {
      if ((!this.a.jdField_a_of_type_Aggg.q) || (!localaggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")))
      {
        localObject = paramList;
        if (this.a.jdField_a_of_type_Aggg.r)
        {
          localObject = paramList;
          if (!localaggf.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId")) {}
        }
      }
      else
      {
        paramList = new LocalMediaInfo();
        paramList.mMimeType = "mobileqq/camera";
        localObject = new ArrayList();
        ((List)localObject).add(0, paramList);
      }
      this.a.jdField_a_of_type_Agfv.a((List)localObject);
      this.a.jdField_a_of_type_Agfv.notifyDataSetChanged();
      this.a.jdField_a_of_type_Aggh.d();
      bbmy.a(this.a, "暂无媒体文件", 1000).a();
      return;
    }
    if (((this.a.jdField_a_of_type_Aggg.q) && (localaggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))) || ((this.a.jdField_a_of_type_Aggg.r) && (localaggf.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId"))))
    {
      localObject = new LocalMediaInfo();
      ((LocalMediaInfo)localObject).mMimeType = "mobileqq/camera";
      paramList.add(0, localObject);
    }
    this.a.jdField_a_of_type_Agfv.a(paramList);
    if (paramList.isEmpty()) {
      bbmy.a(this.a, "暂无媒体文件", 1000).a();
    }
    int i;
    label332:
    int k;
    int j;
    if (this.a.jdField_a_of_type_Aggg.d)
    {
      this.a.jdField_a_of_type_Aggg.d = false;
      if (this.a.jdField_a_of_type_Aggg.h != -1) {
        break label751;
      }
      i = aggg.jdField_a_of_type_Int;
      if (i != -1) {
        break label781;
      }
      localObject = (LinkedHashMap)baaf.jdField_b_of_type_JavaUtilHashMap.get(localaggf.jdField_c_of_type_JavaLangString);
      k = i;
      if (localObject != null)
      {
        j = ((LinkedHashMap)localObject).size();
        k = i;
        if (j > 0) {
          k = ((Integer)((LinkedHashMap)localObject).get(localObject.keySet().toArray()[(j - 1)])).intValue();
        }
      }
      j = k;
      if (k == -1)
      {
        j = k;
        if (this.a.jdField_a_of_type_Aggg.m)
        {
          localObject = paramList.iterator();
          i = 0;
          label436:
          j = k;
          if (((Iterator)localObject).hasNext())
          {
            if (((LocalMediaInfo)((Iterator)localObject).next()).selectStatus != 3) {
              break label765;
            }
            j = i;
          }
        }
      }
      localObject = localaggf.jdField_a_of_type_JavaUtilArrayList;
      i = j;
      if (j == -1)
      {
        i = j;
        if (localaggf.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId"))
        {
          i = j;
          if (!((ArrayList)localObject).isEmpty())
          {
            int n = paramList.size();
            localObject = (String)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            k = 0;
            label535:
            i = j;
            if (k < n)
            {
              if (!((String)localObject).equals(((LocalMediaInfo)paramList.get(k)).path)) {
                break label772;
              }
              i = k;
            }
          }
        }
      }
      label569:
      j = this.a.jdField_a_of_type_Agfv.getCount();
      if (j != 0) {
        break label788;
      }
      j = m;
      label587:
      if (!localaggf.a()) {
        break label814;
      }
      if ((localaggf.jdField_a_of_type_JavaUtilArrayList != null) && (localaggf.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        paramList = (String)localaggf.jdField_a_of_type_JavaUtilArrayList.get(localaggf.jdField_a_of_type_JavaUtilArrayList.size() - 1);
        i = localaggf.jdField_c_of_type_JavaUtilArrayList.indexOf(paramList);
        if ((i >= 0) && (i < this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.a().getCount())) {
          this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new NewPhotoListActivity.QueryPhotoTask.3(this, j));
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Agfv.notifyDataSetChanged();
      this.a.jdField_a_of_type_Aggh.d();
      if (!localaggf.a()) {
        break;
      }
      NewPhotoListActivity.a(this.a, localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_a_of_type_JavaUtilHashMap);
      vhg.a().b(localaggf.jdField_a_of_type_JavaUtilArrayList, localaggf.jdField_b_of_type_JavaUtilHashMap);
      return;
      label751:
      i = this.a.jdField_a_of_type_Aggg.h;
      break label332;
      label765:
      i += 1;
      break label436;
      label772:
      k += 1;
      break label535;
      label781:
      aggg.jdField_a_of_type_Int = -1;
      break label569;
      label788:
      if (i > j - 1)
      {
        j -= 1;
        break label587;
      }
      j = m;
      if (i < 0) {
        break label587;
      }
      j = i;
      break label587;
      label814:
      this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.post(new NewPhotoListActivity.QueryPhotoTask.4(this, j));
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.runOnUiThread(new NewPhotoListActivity.QueryPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agfy
 * JD-Core Version:    0.7.0.1
 */