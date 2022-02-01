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

public class alnu
  extends alno
{
  private static alnu a;
  public WeakReference<alnw> a;
  public final ArrayList<bamx> a;
  public final ArrayList<bamy> b = new ArrayList();
  public int c;
  
  private alnu()
  {
    super(231, true, false);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static final alnu a()
  {
    try
    {
      if (jdField_a_of_type_Alnu == null) {
        jdField_a_of_type_Alnu = new alnu();
      }
      return jdField_a_of_type_Alnu;
    }
    finally {}
  }
  
  private String a()
  {
    return alnq.a(231, null) + File.separator + "fonts" + File.separator;
  }
  
  private String a(bamy parambamy)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bamx localbamx = (bamx)localIterator.next();
      if (localbamx.jdField_a_of_type_Bamy == parambamy) {
        return localbamx.jdField_c_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  private void a(ArrayList<bamx> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 2)) {
      return;
    }
    Collections.sort(paramArrayList, new alnv(this));
  }
  
  private boolean a(bamy parambamy)
  {
    if (parambamy == null) {
      return false;
    }
    String str = a() + parambamy.jdField_a_of_type_JavaLangString;
    if (bgmg.a(str))
    {
      parambamy.f = str;
      parambamy.jdField_d_of_type_Int = 2;
      return true;
    }
    parambamy.f = null;
    parambamy.jdField_d_of_type_Int = 0;
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
  
  private boolean a(String paramString, bamy parambamy)
  {
    paramString = a(paramString, parambamy.jdField_e_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString))
    {
      bgmg.d(paramString, a() + parambamy.jdField_a_of_type_JavaLangString);
      a(parambamy);
      ThreadManager.getUIHandler().post(new SubtitleDataManager.4(this, parambamy));
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
        bamy localbamy = new bamy();
        localbamy.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        localbamy.jdField_a_of_type_JavaLangString = localJSONObject.getString("title");
        localbamy.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        localbamy.jdField_c_of_type_JavaLangString = localJSONObject.getString("resurl");
        localbamy.jdField_d_of_type_JavaLangString = localJSONObject.getString("md5");
        localbamy.jdField_e_of_type_JavaLangString = localJSONObject.optString("md5_ttf");
        localbamy.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getInt("predown")).intValue();
        this.b.add(localbamy);
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
    int i = bdwu.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("SubtitleDataManager", 2, "checkFonts, netType:" + i);
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      bamy localbamy = (bamy)localIterator.next();
      a(localbamy);
      if ((i == 1) && (localbamy.jdField_b_of_type_Int == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SubtitleDataManager", 2, "predown font:" + localbamy.jdField_b_of_type_JavaLangString);
        }
        a(a(localbamy), localbamy);
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
      bamx localbamx;
      try
      {
        paramJSONObject = paramJSONObject.getJSONArray("content");
        i = 0;
        if (i >= paramJSONObject.length()) {
          break label285;
        }
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        localbamx = new bamx();
        localbamx.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getInt("id")).intValue();
        if (!almp.a(localbamx.jdField_a_of_type_Int)) {
          break label295;
        }
        localbamx.jdField_b_of_type_JavaLangString = localJSONObject.getString("name");
        int j = localJSONObject.getInt("fontid");
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          bamy localbamy = (bamy)localIterator.next();
          if (localbamy.jdField_a_of_type_Int != j) {
            continue;
          }
          localbamx.jdField_a_of_type_Bamy = localbamy;
        }
        localbamx.jdField_c_of_type_JavaLangString = localJSONObject.optString("avfontfolder");
        localbamx.jdField_b_of_type_Int = localJSONObject.optInt("position");
        localbamx.jdField_a_of_type_Boolean = false;
        j = localJSONObject.getInt("app");
        if ((j == 1) || (j == 3))
        {
          if (localJSONObject.getInt("show") == 1) {
            localbamx.jdField_a_of_type_Boolean = true;
          }
        }
        else
        {
          localbamx.jdField_a_of_type_JavaLangString = localJSONObject.getString("iconurl");
          if (!localbamx.jdField_a_of_type_Boolean) {
            break label295;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localbamx);
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("SubtitleDataManager", 2, "parseConfig|parse subtitleitem exception:" + paramJSONObject);
        return false;
      }
      localbamx.jdField_a_of_type_Boolean = false;
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
      paramString1 = alkn.jdField_a_of_type_JavaLangString + "/qav" + File.separator + "effect" + File.separator + "216" + File.separator + paramString1 + File.separator + "font.ttf";
      str = bgmg.c(paramString1);
    } while ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(paramString2)));
    return null;
  }
  
  public ArrayList<bamx> a()
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
    almq.a().a(bcjb.q, bcjb.o, bcjb.p);
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
      paramString2 = (bamy)localIterator.next();
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
          paramString1 = (alnw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (localIterator.hasNext())
          {
            bamx localbamx = (bamx)localIterator.next();
            if ((localbamx.jdField_a_of_type_Bamy == paramString2) && (localbamx.jdField_a_of_type_Bamy != null)) {
              paramString1.a(localbamx.jdField_a_of_type_Int, paramInt2, localbamx.jdField_a_of_type_Bamy.f);
            }
          }
          a(paramString2);
          ThreadManager.post(new SubtitleDataManager.2(this, paramString1), 5, null, true);
        }
      }
    }
  }
  
  public void a(alnw paramalnw)
  {
    if (paramalnw == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramalnw);
  }
  
  public void a(String paramString, bamy parambamy)
  {
    if (parambamy == null) {}
    do
    {
      do
      {
        return;
      } while ((parambamy.jdField_d_of_type_Int == 1) || (parambamy.jdField_d_of_type_Int == 2));
      parambamy.jdField_d_of_type_Int = 1;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.post(new SubtitleDataManager.3(this, paramString, parambamy), 5, null, true);
        return;
      }
    } while (a(paramString, parambamy));
    parambamy.jdField_c_of_type_Int = a(parambamy.jdField_c_of_type_JavaLangString, a() + parambamy.jdField_d_of_type_JavaLangString, parambamy.jdField_d_of_type_JavaLangString, a());
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
    bamy localbamy;
    while (((Iterator)localObject).hasNext())
    {
      localbamy = (bamy)((Iterator)localObject).next();
      if (localbamy.jdField_c_of_type_Int == paramInt1) {
        localbamy.jdField_e_of_type_Int = paramInt2;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (localbamy != null))
      {
        localObject = (alnw)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          bamx localbamx = (bamx)localIterator.next();
          if (localbamx.jdField_a_of_type_Bamy == localbamy) {
            ((alnw)localObject).a(localbamx.jdField_a_of_type_Int, localbamx.jdField_a_of_type_Bamy.jdField_e_of_type_Int);
          }
        }
      }
      return;
      localbamy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnu
 * JD-Core Version:    0.7.0.1
 */