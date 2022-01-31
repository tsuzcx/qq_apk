import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class agxd
{
  public static Typeface a;
  public static SparseArray<String> a;
  public static final String a;
  public static ArrayList<agxc> a;
  public static volatile boolean a;
  public static final String b;
  public static volatile boolean b;
  public static final String c;
  public static final String d;
  public static final String e;
  public static final String f;
  public static String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = bdzf.a(alof.bD) + File.separator;
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "res/";
    c = jdField_a_of_type_JavaLangString + "lottie/";
    d = jdField_a_of_type_JavaLangString + "font/";
    e = jdField_a_of_type_JavaLangString + "summary/";
    f = d + "sticker_bubble_animation.ttf";
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static agxc a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
      return (agxc)jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public static Drawable a(int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    String str = b(paramInt);
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130841162);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130841162);
    localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    return localObject;
  }
  
  public static String a(int paramInt)
  {
    if (jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      a();
    }
    String str2 = (String)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = alud.a(2131708304);
    }
    return str1;
  }
  
  public static List<agxc> a(String paramString)
  {
    if ((paramString != null) && (paramString.equals(g))) {
      return jdField_a_of_type_JavaUtilArrayList;
    }
    jdField_a_of_type_JavaUtilArrayList.clear();
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        for (;;)
        {
          if (i < j) {
            try
            {
              int k = Integer.parseInt(paramString[i]);
              agxc localagxc = new agxc();
              localagxc.jdField_a_of_type_Int = k;
              localagxc.jdField_a_of_type_JavaLangString = b(k);
              jdField_a_of_type_JavaUtilArrayList.add(localagxc);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    return jdField_a_of_type_JavaUtilArrayList;
  }
  
  public static void a()
  {
    label162:
    for (;;)
    {
      Object localObject1;
      try
      {
        bool = jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        localObject1 = new File(e);
        if (!((File)localObject1).exists()) {
          continue;
        }
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 == null) || (localObject1.length <= 0)) {
          continue;
        }
        localObject1 = localObject1[0];
      }
      finally {}
      try
      {
        localObject1 = bdhb.b((File)localObject1);
        if (localObject1 == null) {
          break label162;
        }
        localObject1 = new String((byte[])localObject1, "UTF-8");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Object localObject3 = null;
        continue;
        jdField_a_of_type_Boolean = true;
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          Iterator localIterator = ((JSONObject)localObject1).keys();
          if (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = (String)((JSONObject)localObject1).get(str1);
            int i = Integer.parseInt(str1);
            jdField_a_of_type_AndroidUtilSparseArray.put(i, str2);
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!new File(jdField_a_of_type_JavaLangString).exists()) {}
    while (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = paramString.split(",");
    boolean bool1;
    if ((paramString != null) && (paramString.length > 0))
    {
      int j = paramString.length;
      int i = 0;
      bool1 = true;
      for (;;)
      {
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break label125;
          }
          try
          {
            bool2 = new File(b(Integer.parseInt(paramString[i]))).exists();
            if (!bool2) {
              break;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.d("PokeEmo", 1, "checkPEResValid + exception :" + localException);
              bool1 = false;
            }
          }
        }
        i += 1;
      }
    }
    boolean bool2 = true;
    label125:
    return bool2;
  }
  
  public static agxc b(int paramInt)
  {
    Object localObject;
    agxc localagxc;
    if (jdField_a_of_type_JavaUtilArrayList.size() != 0)
    {
      localObject = jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localagxc = (agxc)((Iterator)localObject).next();
      } while (localagxc.jdField_a_of_type_Int != paramInt);
    }
    for (;;)
    {
      localObject = localagxc;
      if (localagxc == null)
      {
        localObject = new agxc();
        ((agxc)localObject).jdField_a_of_type_Int = paramInt;
        ((agxc)localObject).jdField_a_of_type_JavaLangString = b(paramInt);
      }
      return localObject;
      localagxc = null;
    }
  }
  
  public static String b(int paramInt)
  {
    return String.format("%spe_%d.gif", new Object[] { jdField_b_of_type_JavaLangString, Integer.valueOf(paramInt) });
  }
  
  public static void b()
  {
    if (jdField_a_of_type_AndroidGraphicsTypeface != null) {
      return;
    }
    try
    {
      File localFile = new File(f);
      if (localFile.exists()) {
        jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(localFile);
      }
      QLog.e("PokeEmo", 1, "loadFont success ");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PokeEmo", 1, "loadFont failed " + localException.getMessage());
      jdField_a_of_type_AndroidGraphicsTypeface = null;
      jdField_b_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxd
 * JD-Core Version:    0.7.0.1
 */