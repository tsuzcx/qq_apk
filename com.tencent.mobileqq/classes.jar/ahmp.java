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

public class ahmp
  extends ahmj
{
  private static ahmp a;
  public WeakReference<ahmr> a;
  public final ArrayList<aute> a;
  public final ArrayList<autf> b = new ArrayList();
  public int c;
  
  private ahmp()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final ahmp a()
  {
    try
    {
      if (jdField_a_of_type_Ahmp == null) {
        jdField_a_of_type_Ahmp = new ahmp();
      }
      return jdField_a_of_type_Ahmp;
    }
    finally {}
  }
  
  private String a()
  {
    return ahml.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(autf paramautf)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aute localaute = (aute)localIterator.next();
      if (localaute.jdField_a_of_type_Autf == paramautf) {
        return localaute.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<aute> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ahmq(this));
  }
  
  private boolean a(autf paramautf)
  {
    if (paramautf == null) {
      return false;
    }
    String str = a() + paramautf.jdField_a_of_type_JavaLangString;
    if (bace.a(str))
    {
      paramautf.f = str;
      paramautf.jdField_d_of_type_Int = 2;
      return true;
    }
    paramautf.f = null;
    paramautf.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, autf paramautf)
  {
    paramString = a(paramString, paramautf.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bace.d(paramString, a() + paramautf.jdField_a_of_type_JavaLangString);
      a(paramautf);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, paramautf));
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
        autf localautf = new autf();
        localautf.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localautf.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localautf.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localautf.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localautf.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localautf.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localautf.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localautf);
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
    int i = axsr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      autf localautf = (autf)localIterator.next();
      a(localautf);
      if ((i == 1) && (localautf.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localautf.jdField_b_of_type_JavaLangString);
        }
        a(a(localautf), localautf);
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
      aute localaute;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localaute = new aute();
        localaute.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!ahlk.a(localaute.jdField_a_of_type_Int)) {
          break label295;
        }
        localaute.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          autf localautf = (autf)localIterator.next();
          if (localautf.jdField_a_of_type_Int != j) {
            continue;
          }
          localaute.jdField_a_of_type_Autf = localautf;
        }
        localaute.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localaute.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localaute.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localaute.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localaute.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localaute.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localaute);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localaute.jdField_a_of_type_Boolean = false;
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
      paramString1 = ajed.aU + "qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bace.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<aute> a()
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
    ahll.a().a(awje.q, awje.o, awje.p);
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
      paramString2 = (autf)localIterator.next();
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
          paramString1 = (ahmr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            aute localaute = (aute)localIterator.next();
            if ((localaute.jdField_a_of_type_Autf == paramString2) && (localaute.jdField_a_of_type_Autf != null)) {
              paramString1.a(localaute.jdField_a_of_type_Int, paramInt2, localaute.jdField_a_of_type_Autf.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(ahmr paramahmr)
  {
    if (paramahmr == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahmr);
  }
  
  public void a(String paramString, autf paramautf)
  {
    if (paramautf == null) {}
    do
    {
      do
      {
        return;
      } while ((paramautf.jdField_d_of_type_Int == 1) || (paramautf.jdField_d_of_type_Int == 2));
      paramautf.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, paramautf), 5, null, true);
        return;
      }
    } while (a(paramString, paramautf));
    paramautf.jdField_c_of_type_Int = a(paramautf.jdField_c_of_type_JavaLangString, a() + paramautf.jdField_d_of_type_JavaLangString, paramautf.jdField_d_of_type_JavaLangString, a());
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
    autf localautf;
    while (((Iterator)localObject).hasNext())
    {
      localautf = (autf)((Iterator)localObject).next();
      if (localautf.jdField_c_of_type_Int == paramInt1) {
        localautf.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localautf != null))
      {
        localObject = (ahmr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          aute localaute = (aute)localIterator.next();
          if (localaute.jdField_a_of_type_Autf == localautf) {
            ((ahmr)localObject).a(localaute.jdField_a_of_type_Int, localaute.jdField_a_of_type_Autf.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localautf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahmp
 * JD-Core Version:    0.7.0.1
 */