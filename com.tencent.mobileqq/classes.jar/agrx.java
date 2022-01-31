import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity.QueryPhotoTask.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class agrx
  extends AsyncTask<Object, Object, List<LocalMediaInfo>>
{
  public agrx(NewPhotoListActivity paramNewPhotoListActivity) {}
  
  protected List<LocalMediaInfo> a(Object... paramVarArgs)
  {
    agsb localagsb = this.a.jdField_a_of_type_Agse.a;
    if (localagsb.jdField_a_of_type_JavaUtilArrayList == null) {
      localagsb.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject2 = localagsb.jdField_a_of_type_JavaUtilArrayList;
    if (localagsb.jdField_a_of_type_JavaUtilHashMap == null) {
      localagsb.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject1 = localagsb.jdField_a_of_type_JavaUtilHashMap;
    bben.a();
    paramVarArgs = this.a.jdField_a_of_type_Agse.a();
    if (paramVarArgs == null) {
      paramVarArgs = new ArrayList();
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Agsc.jdField_d_of_type_Int = 0;
      this.a.jdField_a_of_type_Agsc.e = 0;
      long l1 = System.currentTimeMillis();
      long l2 = bbbj.jdField_a_of_type_Long;
      if (bbbj.jdField_a_of_type_JavaUtilHashMap.containsKey(localagsb.jdField_c_of_type_JavaLangString)) {}
      label1059:
      for (int j = ((Integer)bbbj.jdField_a_of_type_JavaUtilHashMap.get(localagsb.jdField_c_of_type_JavaLangString)).intValue();; j = 0)
      {
        Object localObject3;
        Object localObject4;
        if ((this.a.jdField_a_of_type_Agsc.f) && (localagsb.jdField_c_of_type_JavaLangString.equals("$RecentAlbumId")))
        {
          localObject3 = paramVarArgs.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
            {
              agsd.a.remove(((LocalMediaInfo)localObject4).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
          paramVarArgs.addAll(0, agsd.a.values());
        }
        int i;
        if ((this.a.jdField_a_of_type_Agsc.g) && (localagsb.jdField_c_of_type_JavaLangString.equals("$VideoAlbumId")))
        {
          localObject3 = paramVarArgs.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((LocalMediaInfo)localObject4).path)))
            {
              agsd.a.remove(((LocalMediaInfo)localObject4).path);
              ((HashMap)localObject1).remove(((LocalMediaInfo)localObject4).path);
            }
          }
          localObject3 = agsd.a.values().iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (LocalMediaInfo)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!"video/mp4".equals(((LocalMediaInfo)localObject4).mMimeType))) {
              break label1123;
            }
            paramVarArgs.add(i, localObject4);
            i += 1;
          }
        }
        label942:
        label1078:
        label1123:
        for (;;)
        {
          break;
          agpm.a(paramVarArgs, null, this.a.jdField_a_of_type_Agsc.jdField_a_of_type_JavaUtilHashMap);
          int k = paramVarArgs.size();
          localObject3 = new ArrayList(k);
          i = 0;
          if (i < paramVarArgs.size())
          {
            localObject4 = (LocalMediaInfo)paramVarArgs.get(i);
            if (((LocalMediaInfo)localObject4).path == null) {}
            for (;;)
            {
              i += 1;
              break;
              int m = bbbj.a((LocalMediaInfo)localObject4);
              ((LocalMediaInfo)localObject4).position = Integer.valueOf(((ArrayList)localObject3).size());
              ((ArrayList)localObject3).add(((LocalMediaInfo)localObject4).path);
              if (((ArrayList)localObject2).contains(((LocalMediaInfo)localObject4).path))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 1;
                if (!localagsb.jdField_b_of_type_JavaUtilArrayList.contains(((LocalMediaInfo)localObject4).position)) {
                  localagsb.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject4).position);
                }
                if ((this.a.jdField_a_of_type_Agsc.h) && (m == 1))
                {
                  agsc localagsc = this.a.jdField_a_of_type_Agsc;
                  localagsc.jdField_d_of_type_Int += 1;
                  if (this.a.jdField_a_of_type_Agsc.jdField_d_of_type_Int == 1) {
                    this.a.jdField_a_of_type_Agsc.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject4);
                  }
                }
                if ((this.a.jdField_a_of_type_Agsc.f) && (!((HashMap)localObject1).containsKey(((LocalMediaInfo)localObject4).path))) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                }
                if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject4).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject4).mMimeType)))
                {
                  localObject4 = this.a.jdField_a_of_type_Agsc;
                  ((agsc)localObject4).e += 1;
                }
              }
              else if ((((ArrayList)localObject2).size() < localagsb.jdField_a_of_type_Int) && (((LocalMediaInfo)localObject4).path.equals(this.a.jdField_a_of_type_Agsc.b)))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 1;
                ((ArrayList)localObject2).add(((LocalMediaInfo)localObject4).path);
                localagsb.jdField_b_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject4).position);
                if (localagsb.jdField_d_of_type_Boolean) {
                  ((HashMap)localObject1).put(((LocalMediaInfo)localObject4).path, localObject4);
                }
              }
              else if ((this.a.jdField_a_of_type_Agsc.jdField_d_of_type_Boolean) && (l1 - l2 <= 60000L) && (j == paramVarArgs.size()) && (((LocalMediaInfo)localObject4).path.equals(bbbj.jdField_a_of_type_JavaLangString)))
              {
                ((LocalMediaInfo)localObject4).selectStatus = 3;
              }
              else
              {
                ((LocalMediaInfo)localObject4).selectStatus = 2;
              }
            }
          }
          if (this.a.jdField_a_of_type_Agse.a())
          {
            if (localagsb.jdField_b_of_type_JavaUtilHashMap == null)
            {
              localagsb.jdField_b_of_type_JavaUtilHashMap = new HashMap();
              i = 0;
              if (i >= k) {
                break label1078;
              }
              localObject1 = (LocalMediaInfo)paramVarArgs.get(i);
              if (((LocalMediaInfo)localObject1).path != null) {
                break label1059;
              }
            }
            for (;;)
            {
              i += 1;
              break label942;
              localObject2 = ((ArrayList)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                if ((localagsb.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject4)) && (!((HashMap)localObject1).containsKey(localObject4))) {
                  ((HashMap)localObject1).put(localObject4, localagsb.jdField_b_of_type_JavaUtilHashMap.get(localObject4));
                }
              }
              localagsb.jdField_b_of_type_JavaUtilHashMap.clear();
              break;
              localagsb.jdField_b_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject1).path, localObject1);
            }
          }
          localagsb.jdField_c_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + paramVarArgs.size());
          }
          return paramVarArgs;
        }
      }
    }
  }
  
  protected void a(List<LocalMediaInfo> paramList)
  {
    this.a.jdField_a_of_type_Agse.a(paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.runOnUiThread(new NewPhotoListActivity.QueryPhotoTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrx
 * JD-Core Version:    0.7.0.1
 */