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

public class ahzf
  extends ahyz
{
  private static ahzf a;
  public WeakReference<ahzh> a;
  public final ArrayList<avsp> a;
  public final ArrayList<avsq> b = new ArrayList();
  public int c;
  
  private ahzf()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final ahzf a()
  {
    try
    {
      if (jdField_a_of_type_Ahzf == null) {
        jdField_a_of_type_Ahzf = new ahzf();
      }
      return jdField_a_of_type_Ahzf;
    }
    finally {}
  }
  
  private String a()
  {
    return ahzb.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(avsq paramavsq)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      avsp localavsp = (avsp)localIterator.next();
      if (localavsp.jdField_a_of_type_Avsq == paramavsq) {
        return localavsp.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<avsp> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ahzg(this));
  }
  
  private boolean a(avsq paramavsq)
  {
    if (paramavsq == null) {
      return false;
    }
    String str = a() + paramavsq.jdField_a_of_type_JavaLangString;
    if (bbdx.a(str))
    {
      paramavsq.f = str;
      paramavsq.jdField_d_of_type_Int = 2;
      return true;
    }
    paramavsq.f = null;
    paramavsq.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, avsq paramavsq)
  {
    paramString = a(paramString, paramavsq.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bbdx.d(paramString, a() + paramavsq.jdField_a_of_type_JavaLangString);
      a(paramavsq);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, paramavsq));
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
        avsq localavsq = new avsq();
        localavsq.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localavsq.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localavsq.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localavsq.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localavsq.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localavsq.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localavsq.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localavsq);
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
    int i = ayta.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      avsq localavsq = (avsq)localIterator.next();
      a(localavsq);
      if ((i == 1) && (localavsq.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localavsq.jdField_b_of_type_JavaLangString);
        }
        a(a(localavsq), localavsq);
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
      avsp localavsp;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localavsp = new avsp();
        localavsp.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!ahya.a(localavsp.jdField_a_of_type_Int)) {
          break label295;
        }
        localavsp.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          avsq localavsq = (avsq)localIterator.next();
          if (localavsq.jdField_a_of_type_Int != j) {
            continue;
          }
          localavsp.jdField_a_of_type_Avsq = localavsq;
        }
        localavsp.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localavsp.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localavsp.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localavsp.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localavsp.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localavsp.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localavsp);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localavsp.jdField_a_of_type_Boolean = false;
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
      paramString1 = ahvy.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bbdx.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<avsp> a()
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
    ahyb.a().a(axim.q, axim.o, axim.p);
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
      paramString2 = (avsq)localIterator.next();
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
          paramString1 = (ahzh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            avsp localavsp = (avsp)localIterator.next();
            if ((localavsp.jdField_a_of_type_Avsq == paramString2) && (localavsp.jdField_a_of_type_Avsq != null)) {
              paramString1.a(localavsp.jdField_a_of_type_Int, paramInt2, localavsp.jdField_a_of_type_Avsq.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(ahzh paramahzh)
  {
    if (paramahzh == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramahzh);
  }
  
  public void a(String paramString, avsq paramavsq)
  {
    if (paramavsq == null) {}
    do
    {
      do
      {
        return;
      } while ((paramavsq.jdField_d_of_type_Int == 1) || (paramavsq.jdField_d_of_type_Int == 2));
      paramavsq.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, paramavsq), 5, null, true);
        return;
      }
    } while (a(paramString, paramavsq));
    paramavsq.jdField_c_of_type_Int = a(paramavsq.jdField_c_of_type_JavaLangString, a() + paramavsq.jdField_d_of_type_JavaLangString, paramavsq.jdField_d_of_type_JavaLangString, a());
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
    avsq localavsq;
    while (((Iterator)localObject).hasNext())
    {
      localavsq = (avsq)((Iterator)localObject).next();
      if (localavsq.jdField_c_of_type_Int == paramInt1) {
        localavsq.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localavsq != null))
      {
        localObject = (ahzh)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          avsp localavsp = (avsp)localIterator.next();
          if (localavsp.jdField_a_of_type_Avsq == localavsq) {
            ((ahzh)localObject).a(localavsp.jdField_a_of_type_Int, localavsp.jdField_a_of_type_Avsq.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localavsq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahzf
 * JD-Core Version:    0.7.0.1
 */