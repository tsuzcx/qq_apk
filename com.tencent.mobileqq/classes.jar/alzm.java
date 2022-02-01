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

public class alzm
  extends alzg
{
  private static alzm a;
  public WeakReference<alzo> a;
  public final ArrayList<bbfq> a;
  public final ArrayList<bbfr> b = new ArrayList();
  public int c;
  
  private alzm()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final alzm a()
  {
    try
    {
      if (jdField_a_of_type_Alzm == null) {
        jdField_a_of_type_Alzm = new alzm();
      }
      return jdField_a_of_type_Alzm;
    }
    finally {}
  }
  
  private String a()
  {
    return alzi.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(bbfr parambbfr)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bbfq localbbfq = (bbfq)localIterator.next();
      if (localbbfq.jdField_a_of_type_Bbfr == parambbfr) {
        return localbbfq.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<bbfq> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new alzn(this));
  }
  
  private boolean a(bbfr parambbfr)
  {
    if (parambbfr == null) {
      return false;
    }
    String str = a() + parambbfr.jdField_a_of_type_JavaLangString;
    if (bhmi.a(str))
    {
      parambbfr.f = str;
      parambbfr.jdField_d_of_type_Int = 2;
      return true;
    }
    parambbfr.f = null;
    parambbfr.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, bbfr parambbfr)
  {
    paramString = a(paramString, parambbfr.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bhmi.d(paramString, a() + parambbfr.jdField_a_of_type_JavaLangString);
      a(parambbfr);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, parambbfr));
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
        bbfr localbbfr = new bbfr();
        localbbfr.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localbbfr.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localbbfr.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localbbfr.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localbbfr.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localbbfr.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localbbfr.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localbbfr);
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
    int i = bevn.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bbfr localbbfr = (bbfr)localIterator.next();
      a(localbbfr);
      if ((i == 1) && (localbbfr.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localbbfr.jdField_b_of_type_JavaLangString);
        }
        a(a(localbbfr), localbbfr);
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
      bbfq localbbfq;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localbbfq = new bbfq();
        localbbfq.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!alyh.a(localbbfq.jdField_a_of_type_Int)) {
          break label295;
        }
        localbbfq.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          bbfr localbbfr = (bbfr)localIterator.next();
          if (localbbfr.jdField_a_of_type_Int != j) {
            continue;
          }
          localbbfq.jdField_a_of_type_Bbfr = localbbfr;
        }
        localbbfq.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localbbfq.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localbbfq.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localbbfq.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localbbfq.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localbbfq.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localbbfq);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localbbfq.jdField_a_of_type_Boolean = false;
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
      paramString1 = alwf.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bhmi.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<bbfq> a()
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
    alyi.a().a(bdbt.q, bdbt.o, bdbt.p);
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
      paramString2 = (bbfr)localIterator.next();
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
          paramString1 = (alzo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            bbfq localbbfq = (bbfq)localIterator.next();
            if ((localbbfq.jdField_a_of_type_Bbfr == paramString2) && (localbbfq.jdField_a_of_type_Bbfr != null)) {
              paramString1.a(localbbfq.jdField_a_of_type_Int, paramInt2, localbbfq.jdField_a_of_type_Bbfr.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(alzo paramalzo)
  {
    if (paramalzo == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalzo);
  }
  
  public void a(String paramString, bbfr parambbfr)
  {
    if (parambbfr == null) {}
    do
    {
      do
      {
        return;
      } while ((parambbfr.jdField_d_of_type_Int == 1) || (parambbfr.jdField_d_of_type_Int == 2));
      parambbfr.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, parambbfr), 5, null, true);
        return;
      }
    } while (a(paramString, parambbfr));
    parambbfr.jdField_c_of_type_Int = a(parambbfr.jdField_c_of_type_JavaLangString, a() + parambbfr.jdField_d_of_type_JavaLangString, parambbfr.jdField_d_of_type_JavaLangString, a());
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
    bbfr localbbfr;
    while (((Iterator)localObject).hasNext())
    {
      localbbfr = (bbfr)((Iterator)localObject).next();
      if (localbbfr.jdField_c_of_type_Int == paramInt1) {
        localbbfr.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localbbfr != null))
      {
        localObject = (alzo)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bbfq localbbfq = (bbfq)localIterator.next();
          if (localbbfq.jdField_a_of_type_Bbfr == localbbfr) {
            ((alzo)localObject).a(localbbfq.jdField_a_of_type_Int, localbbfq.jdField_a_of_type_Bbfr.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localbbfr = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzm
 * JD-Core Version:    0.7.0.1
 */