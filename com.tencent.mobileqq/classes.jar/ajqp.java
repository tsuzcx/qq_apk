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

public class ajqp
  extends ajqj
{
  private static ajqp a;
  public WeakReference<ajqr> a;
  public final ArrayList<axkn> a;
  public final ArrayList<axko> b = new ArrayList();
  public int c;
  
  private ajqp()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final ajqp a()
  {
    try
    {
      if (jdField_a_of_type_Ajqp == null) {
        jdField_a_of_type_Ajqp = new ajqp();
      }
      return jdField_a_of_type_Ajqp;
    }
    finally {}
  }
  
  private String a()
  {
    return ajql.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(axko paramaxko)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      axkn localaxkn = (axkn)localIterator.next();
      if (localaxkn.jdField_a_of_type_Axko == paramaxko) {
        return localaxkn.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<axkn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new ajqq(this));
  }
  
  private boolean a(axko paramaxko)
  {
    if (paramaxko == null) {
      return false;
    }
    String str = a() + paramaxko.jdField_a_of_type_JavaLangString;
    if (bdcs.a(str))
    {
      paramaxko.f = str;
      paramaxko.jdField_d_of_type_Int = 2;
      return true;
    }
    paramaxko.f = null;
    paramaxko.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, axko paramaxko)
  {
    paramString = a(paramString, paramaxko.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bdcs.d(paramString, a() + paramaxko.jdField_a_of_type_JavaLangString);
      a(paramaxko);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, paramaxko));
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
        axko localaxko = new axko();
        localaxko.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localaxko.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localaxko.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localaxko.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localaxko.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localaxko.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localaxko.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localaxko);
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
    int i = baqx.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      axko localaxko = (axko)localIterator.next();
      a(localaxko);
      if ((i == 1) && (localaxko.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localaxko.jdField_b_of_type_JavaLangString);
        }
        a(a(localaxko), localaxko);
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
      axkn localaxkn;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localaxkn = new axkn();
        localaxkn.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!ajpk.a(localaxkn.jdField_a_of_type_Int)) {
          break label295;
        }
        localaxkn.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          axko localaxko = (axko)localIterator.next();
          if (localaxko.jdField_a_of_type_Int != j) {
            continue;
          }
          localaxkn.jdField_a_of_type_Axko = localaxko;
        }
        localaxkn.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localaxkn.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localaxkn.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localaxkn.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localaxkn.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localaxkn.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localaxkn);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localaxkn.jdField_a_of_type_Boolean = false;
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
      paramString1 = ajni.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bdcs.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<axkn> a()
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
    ajpl.a().a(azds.q, azds.o, azds.p);
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
      paramString2 = (axko)localIterator.next();
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
          paramString1 = (ajqr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            axkn localaxkn = (axkn)localIterator.next();
            if ((localaxkn.jdField_a_of_type_Axko == paramString2) && (localaxkn.jdField_a_of_type_Axko != null)) {
              paramString1.a(localaxkn.jdField_a_of_type_Int, paramInt2, localaxkn.jdField_a_of_type_Axko.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(ajqr paramajqr)
  {
    if (paramajqr == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramajqr);
  }
  
  public void a(String paramString, axko paramaxko)
  {
    if (paramaxko == null) {}
    do
    {
      do
      {
        return;
      } while ((paramaxko.jdField_d_of_type_Int == 1) || (paramaxko.jdField_d_of_type_Int == 2));
      paramaxko.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, paramaxko), 5, null, true);
        return;
      }
    } while (a(paramString, paramaxko));
    paramaxko.jdField_c_of_type_Int = a(paramaxko.jdField_c_of_type_JavaLangString, a() + paramaxko.jdField_d_of_type_JavaLangString, paramaxko.jdField_d_of_type_JavaLangString, a());
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
    axko localaxko;
    while (((Iterator)localObject).hasNext())
    {
      localaxko = (axko)((Iterator)localObject).next();
      if (localaxko.jdField_c_of_type_Int == paramInt1) {
        localaxko.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localaxko != null))
      {
        localObject = (ajqr)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          axkn localaxkn = (axkn)localIterator.next();
          if (localaxkn.jdField_a_of_type_Axko == localaxko) {
            ((ajqr)localObject).a(localaxkn.jdField_a_of_type_Int, localaxkn.jdField_a_of_type_Axko.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localaxko = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqp
 * JD-Core Version:    0.7.0.1
 */