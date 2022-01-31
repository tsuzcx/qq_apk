import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class aexc
  implements aexe
{
  aexc(aexb paramaexb) {}
  
  public void a(List<aewf> paramList, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder().append("OnImgUpdated: empty data or text ").append(paramString1).append(" ");
      if (paramList == null) {}
      for (paramList = "null";; paramList = Integer.valueOf(paramList.size()))
      {
        QLog.i("StickerRecManager", 2, paramList);
        return;
      }
    }
    paramList = bhah.a(paramList);
    if (paramList == null)
    {
      QLog.i("StickerRecManager", 2, "OnImgUpdated: failed to parse img data");
      return;
    }
    bhah.a().a(paramString1, paramList.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexc
 * JD-Core Version:    0.7.0.1
 */