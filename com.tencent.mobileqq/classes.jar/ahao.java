import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import org.json.JSONObject;

public class ahao
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
  
  public static String a(int paramInt, bgws parambgws, ahan paramahan, String paramString)
  {
    int i = 2;
    if (parambgws != null)
    {
      int j = bgwk.a(parambgws.bus_type, 2);
      i = j;
      if (!bbjw.a(parambgws.biz_params)) {
        try
        {
          String str = new JSONObject(parambgws.biz_params).optString("memo", "");
          parambgws = str;
          if (a(str) >= 18) {
            parambgws = str.substring(0, 18) + "...";
          }
          boolean bool = bbjw.a(parambgws);
          i = j;
          if (!bool) {
            return parambgws;
          }
        }
        catch (Exception parambgws)
        {
          parambgws.printStackTrace();
          i = j;
        }
      }
    }
    return paramahan.a(paramInt, i, paramString);
  }
  
  public static String a(EditText paramEditText)
  {
    String str = paramEditText.getText().toString();
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      localObject = paramEditText.getHint();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = paramEditText.getResources().getString(2131697097);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahao
 * JD-Core Version:    0.7.0.1
 */