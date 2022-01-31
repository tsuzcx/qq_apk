import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import org.json.JSONObject;

public class aizd
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
  
  public static String a(int paramInt, bjcn parambjcn, aizc paramaizc, String paramString)
  {
    int i = 2;
    if (parambjcn != null)
    {
      int j = bjcf.a(parambjcn.bus_type, 2);
      i = j;
      if (!bdnn.a(parambjcn.biz_params)) {
        try
        {
          String str = new JSONObject(parambjcn.biz_params).optString("memo", "");
          parambjcn = str;
          if (a(str) >= 18) {
            parambjcn = str.substring(0, 18) + "...";
          }
          boolean bool = bdnn.a(parambjcn);
          i = j;
          if (!bool) {
            return parambjcn;
          }
        }
        catch (Exception parambjcn)
        {
          parambjcn.printStackTrace();
          i = j;
        }
      }
    }
    return paramaizc.a(paramInt, i, paramString);
  }
  
  public static String a(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = paramEditText.getResources().getString(2131697275);
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
 * Qualified Name:     aizd
 * JD-Core Version:    0.7.0.1
 */