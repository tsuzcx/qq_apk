import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amax
{
  public int a;
  public ArraySet<String> a;
  public boolean a;
  public int b;
  private ArraySet<String> b;
  private ArraySet<String> c = new ArraySet();
  
  public amax()
  {
    this.jdField_a_of_type_Int = 10000;
    this.jdField_b_of_type_Int = 5000;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
    this.jdField_b_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TeleScreenConfig", 2, "telescreen config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidSupportV4UtilArraySet.clear();
      this.jdField_b_of_type_AndroidSupportV4UtilArraySet.clear();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_Int = ((int)(paramString.optDouble("download_timeout") * 1000.0D));
        if (this.jdField_a_of_type_Int <= 0)
        {
          i = 10000;
          this.jdField_a_of_type_Int = i;
          this.jdField_b_of_type_Int = ((int)(paramString.optDouble("jump_timeout") * 1000.0D));
          if (this.jdField_b_of_type_Int <= 0)
          {
            i = 5000;
            this.jdField_b_of_type_Int = i;
            if (paramString.optInt("use_block_mode", 1) != 0) {
              break label385;
            }
            bool = true;
            this.jdField_a_of_type_Boolean = bool;
            localJSONArray = paramString.optJSONArray("check_white_list");
            this.jdField_a_of_type_AndroidSupportV4UtilArraySet.clear();
            if (localJSONArray == null) {
              continue;
            }
            i = localJSONArray.length() - 1;
            if (i < 0) {
              continue;
            }
            if (TextUtils.isEmpty(localJSONArray.getString(i))) {
              break label378;
            }
            this.jdField_a_of_type_AndroidSupportV4UtilArraySet.add(localJSONArray.getString(i));
            break label378;
          }
        }
        else
        {
          i = this.jdField_a_of_type_Int;
          continue;
        }
        i = this.jdField_b_of_type_Int;
        continue;
        JSONArray localJSONArray = paramString.optJSONArray("scheme_white_list");
        this.jdField_b_of_type_AndroidSupportV4UtilArraySet.clear();
        if (localJSONArray != null)
        {
          i = localJSONArray.length() - 1;
          if (i >= 0)
          {
            if (TextUtils.isEmpty(localJSONArray.getString(i))) {
              break label390;
            }
            this.jdField_b_of_type_AndroidSupportV4UtilArraySet.add(localJSONArray.getString(i));
            break label390;
          }
        }
        paramString = paramString.optJSONArray("md5");
        this.c.clear();
        if (paramString == null) {
          break;
        }
        i = paramString.length() - 1;
        if (i < 0) {
          break;
        }
        if (!TextUtils.isEmpty(paramString.getString(i))) {
          this.c.add(new String(Base64.decode(paramString.getString(i), 0)));
        }
        i -= 1;
        continue;
        i -= 1;
      }
      catch (JSONException paramString)
      {
        QLog.e("TeleScreenConfig", 1, paramString, new Object[0]);
        return;
      }
      label378:
      continue;
      label385:
      boolean bool = false;
      continue;
      label390:
      i -= 1;
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.startsWith((String)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(paramString1)) {
      return true;
    }
    if (paramString2 != null)
    {
      paramString1 = this.jdField_b_of_type_AndroidSupportV4UtilArraySet.iterator();
      while (paramString1.hasNext()) {
        if (paramString2.startsWith((String)paramString1.next())) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amax
 * JD-Core Version:    0.7.0.1
 */