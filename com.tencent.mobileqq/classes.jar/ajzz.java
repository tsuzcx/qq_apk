import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.utils.StringUtil;
import org.json.JSONObject;

public class ajzz
{
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 == 1)
    {
      paramInt1 = i;
      if (paramInt2 == 1) {
        paramInt1 = 0;
      }
      return paramInt1;
    }
    return RedPacketManager.getEnterType(paramInt1);
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {
      i = paramString.replaceAll("[\\u4e00-\\u9fa5]", "aa").length() - paramString.length();
    }
    return i;
  }
  
  public static String a(int paramInt, bkwf parambkwf, ajzx paramajzx, String paramString)
  {
    int i = 2;
    if (parambkwf != null)
    {
      int j = bkvx.a(parambkwf.bus_type, 2);
      i = j;
      if (!StringUtil.isEmpty(parambkwf.biz_params)) {
        try
        {
          String str = new JSONObject(parambkwf.biz_params).optString("memo", "");
          parambkwf = str;
          if (a(str) >= 18) {
            parambkwf = str.substring(0, 18) + "...";
          }
          boolean bool = StringUtil.isEmpty(parambkwf);
          i = j;
          if (!bool) {
            return parambkwf;
          }
        }
        catch (Exception parambkwf)
        {
          parambkwf.printStackTrace();
          i = j;
        }
      }
    }
    return paramajzx.a(paramInt, i, paramString);
  }
  
  public static String a(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = paramEditText.getResources().getString(2131696287);
      }
    }
    else
    {
      return localObject;
    }
    return ((CharSequence)localObject).toString();
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString.replaceAll("[\\u4e00-\\u9fa5,，。、 ]", "");
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzz
 * JD-Core Version:    0.7.0.1
 */