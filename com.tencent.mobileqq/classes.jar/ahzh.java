import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.1;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.2;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.3;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleDataManager.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ahzh
  extends ahzb
{
  private static ahzh a;
  public WeakReference<ahzj> a;
  public final ArrayList<avsn> a;
  public final ArrayList<avso> b = new ArrayList();
  public int c;
  
  private ahzh()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final ahzh a()
  {
    try
    {
      if (jdField_a_of_type_Ahzh == null) {
        jdField_a_of_type_Ahzh = new ahzh();
      }
      return jdField_a_of_type_Ahzh;
    }
    finally {}
  }
  
  private String a()
  {
    return ahzd.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(avso paramavso)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      avsn localavsn = (avsn)localIterator.next();
      if (localavsn.jdField_a_of_type_Avso == paramavso) {
        return localavsn.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<avsn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ahzi(this));
  }
  
  private boolean a(avso paramavso)
  {
    if (paramavso == null) {
      return false;
    }
    String str = a() + paramavso.jdField_a_of_type_JavaLangString;
    if (bbdj.a(str))
    {
      paramavso.f = str;
      paramavso.jdField_d_of_type_Int = 2;
      return true;
    }
    paramavso.f = null;
    paramavso.jdField_d_of_type_Int = 0;
    return false;
  }
  
  private boolean a(String paramString)
  {
    boolean bool3 = false;
    bool1 = false;
    bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return bool2;
    }
    for (bool2 = bool1;; bool2 = false)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        bool2 = bool1;
        bool1 = b(localJSONObject);
      }
      catch (JSONException localJSONException1)
      {
        for (;;)
        {
          try
          {
            bool2 = a(localJSONObject);
            if ((bool2) && (bool1)) {
              bool2 = true;
            }
          }
          catch (JSONException localJSONException2)
          {
            JSONObject localJSONObject;
            boolean bool4;
            bool2 = bool1;
            continue;
          }
          try
          {
            bool4 = c(localJSONObject);
            bool1 = bool3;
            if (bool4)
            {
              bool1 = bool3;
              if (bool2) {
                bool1 = true;
              }
            }
            bool2 = bool1;
            if (!bool1) {
              break;
            }
            bool2 = bool1;
            b();
            return bool1;
          }
          catch (JSONException localJSONException3) {}
        }
        localJSONException1 = localJSONException1;
      }
      localJSONException1.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse failed.context = " + paramString);
      return bool2;
    }
  }
  
  private boolean a(String paramString, avso paramavso)
  {
    paramString = a(paramString, paramavso.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bbdj.d(paramString, a() + paramavso.jdField_a_of_type_JavaLangString);
      a(paramavso);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, paramavso));
      return true;
    }
    return false;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      paramJSONObject = paramJSONObject.getJSONArray("font");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        avso localavso = new avso();
        localavso.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localavso.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localavso.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localavso.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localavso.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localavso.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localavso.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localavso);
        i += 1;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse fonts exception:" + paramJSONObject);
    }
    return false;
  }
  
  private void b()
  {
    int i = aysy.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      avso localavso = (avso)localIterator.next();
      a(localavso);
      if ((i == 1) && (localavso.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localavso.jdField_b_of_type_JavaLangString);
        }
        a(a(localavso), localavso);
      }
    }
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      b("on".equalsIgnoreCase(paramJSONObject.getString("switch")));
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      QLog.e("SubtitleDataManager", 2, "parseConfig|parse switch exception " + paramJSONObject);
    }
    return false;
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    for (;;)
    {
      int i;
      avsn localavsn;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localavsn = new avsn();
        localavsn.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!ahyc.a(localavsn.jdField_a_of_type_Int)) {
          break label295;
        }
        localavsn.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          avso localavso = (avso)localIterator.next();
          if (localavso.jdField_a_of_type_Int != j) {
            continue;
          }
          localavsn.jdField_a_of_type_Avso = localavso;
        }
        localavsn.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localavsn.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localavsn.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localavsn.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localavsn.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localavsn.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localavsn);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localavsn.jdField_a_of_type_Boolean = false;
      continue;
      label285:
      a(this.jdField_a_of_type_JavaUtilArrayList);
      return true;
      label295:
      i += 1;
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      paramString1 = ahwa.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bbdj.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<avsn> a()
  {
    try
    {
      if (a() != 2) {
        return null;
      }
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
    ahyd.a().a(axik.q, axik.o, axik.p);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.b.clear();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadResult: nID:" + paramInt1 + " nResult:" + paramInt2 + " file:" + paramString1 + " unzipPath:" + paramString2);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      paramString2 = (avso)localIterator.next();
      if (paramString2.jdField_c_of_type_Int == paramInt1)
      {
        if (paramInt2 != 0)
        {
          paramString2.jdField_d_of_type_Int = 0;
          paramString2.jdField_e_of_type_Int = 0;
          paramString2.jdField_c_of_type_Int = -1;
        }
        while (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          paramString1 = (ahzj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            avsn localavsn = (avsn)localIterator.next();
            if ((localavsn.jdField_a_of_type_Avso == paramString2) && (localavsn.jdField_a_of_type_Avso != null)) {
              paramString1.a(localavsn.jdField_a_of_type_Int, paramInt2, localavsn.jdField_a_of_type_Avso.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(ahzj paramahzj)
  {
    if (paramahzj == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahzj);
  }
  
  public void a(String paramString, avso paramavso)
  {
    if (paramavso == null) {}
    do
    {
      do
      {
        return;
      } while ((paramavso.jdField_d_of_type_Int == 1) || (paramavso.jdField_d_of_type_Int == 2));
      paramavso.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, paramavso), 5, null, true);
        return;
      }
    } while (a(paramString, paramavso));
    paramavso.jdField_c_of_type_Int = a(paramavso.jdField_c_of_type_JavaLangString, a() + paramavso.jdField_d_of_type_JavaLangString, paramavso.jdField_d_of_type_JavaLangString, a());
  }
  
  public boolean a(int paramInt1, int paramInt2, String paramString)
  {
    return a(paramString);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onConfigEnd: nVersion:" + paramInt1 + " nTaskCount:" + paramInt2);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      ThreadManager.getUIHandler().post(new SubtitleDataManager.1(this));
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "onDownloadProgress: nID:" + paramInt1 + " progress:" + paramInt2);
    }
    Object localObject = this.b.iterator();
    avso localavso;
    while (((Iterator)localObject).hasNext())
    {
      localavso = (avso)((Iterator)localObject).next();
      if (localavso.jdField_c_of_type_Int == paramInt1) {
        localavso.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localavso != null))
      {
        localObject = (ahzj)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          avsn localavsn = (avsn)localIterator.next();
          if (localavsn.jdField_a_of_type_Avso == localavso) {
            ((ahzj)localObject).a(localavsn.jdField_a_of_type_Int, localavsn.jdField_a_of_type_Avso.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localavso = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzh
 * JD-Core Version:    0.7.0.1
 */