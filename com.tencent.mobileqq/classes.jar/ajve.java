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

public class ajve
  extends ajuy
{
  private static ajve a;
  public WeakReference<ajvg> a;
  public final ArrayList<axow> a;
  public final ArrayList<axox> b = new ArrayList();
  public int c;
  
  private ajve()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final ajve a()
  {
    try
    {
      if (jdField_a_of_type_Ajve == null) {
        jdField_a_of_type_Ajve = new ajve();
      }
      return jdField_a_of_type_Ajve;
    }
    finally {}
  }
  
  private String a()
  {
    return ajva.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(axox paramaxox)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axow localaxow = (axow)localIterator.next();
      if (localaxow.jdField_a_of_type_Axox == paramaxox) {
        return localaxow.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<axow> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ajvf(this));
  }
  
  private boolean a(axox paramaxox)
  {
    if (paramaxox == null) {
      return false;
    }
    String str = a() + paramaxox.jdField_a_of_type_JavaLangString;
    if (bdhb.a(str))
    {
      paramaxox.f = str;
      paramaxox.jdField_d_of_type_Int = 2;
      return true;
    }
    paramaxox.f = null;
    paramaxox.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, axox paramaxox)
  {
    paramString = a(paramString, paramaxox.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bdhb.d(paramString, a() + paramaxox.jdField_a_of_type_JavaLangString);
      a(paramaxox);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, paramaxox));
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
        axox localaxox = new axox();
        localaxox.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localaxox.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localaxox.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localaxox.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localaxox.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localaxox.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localaxox.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localaxox);
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
    int i = bavg.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      axox localaxox = (axox)localIterator.next();
      a(localaxox);
      if ((i == 1) && (localaxox.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localaxox.jdField_b_of_type_JavaLangString);
        }
        a(a(localaxox), localaxox);
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
      axow localaxow;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localaxow = new axow();
        localaxow.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!ajtz.a(localaxow.jdField_a_of_type_Int)) {
          break label295;
        }
        localaxow.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          axox localaxox = (axox)localIterator.next();
          if (localaxox.jdField_a_of_type_Int != j) {
            continue;
          }
          localaxow.jdField_a_of_type_Axox = localaxox;
        }
        localaxow.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localaxow.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localaxow.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localaxow.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localaxow.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localaxow.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localaxow);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localaxow.jdField_a_of_type_Boolean = false;
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
      paramString1 = ajrx.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bdhb.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<axow> a()
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
    ajua.a().a(azib.q, azib.o, azib.p);
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
      paramString2 = (axox)localIterator.next();
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
          paramString1 = (ajvg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            axow localaxow = (axow)localIterator.next();
            if ((localaxow.jdField_a_of_type_Axox == paramString2) && (localaxow.jdField_a_of_type_Axox != null)) {
              paramString1.a(localaxow.jdField_a_of_type_Int, paramInt2, localaxow.jdField_a_of_type_Axox.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(ajvg paramajvg)
  {
    if (paramajvg == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajvg);
  }
  
  public void a(String paramString, axox paramaxox)
  {
    if (paramaxox == null) {}
    do
    {
      do
      {
        return;
      } while ((paramaxox.jdField_d_of_type_Int == 1) || (paramaxox.jdField_d_of_type_Int == 2));
      paramaxox.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, paramaxox), 5, null, true);
        return;
      }
    } while (a(paramString, paramaxox));
    paramaxox.jdField_c_of_type_Int = a(paramaxox.jdField_c_of_type_JavaLangString, a() + paramaxox.jdField_d_of_type_JavaLangString, paramaxox.jdField_d_of_type_JavaLangString, a());
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
    axox localaxox;
    while (((Iterator)localObject).hasNext())
    {
      localaxox = (axox)((Iterator)localObject).next();
      if (localaxox.jdField_c_of_type_Int == paramInt1) {
        localaxox.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localaxox != null))
      {
        localObject = (ajvg)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          axow localaxow = (axow)localIterator.next();
          if (localaxow.jdField_a_of_type_Axox == localaxox) {
            ((ajvg)localObject).a(localaxow.jdField_a_of_type_Int, localaxow.jdField_a_of_type_Axox.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localaxox = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajve
 * JD-Core Version:    0.7.0.1
 */