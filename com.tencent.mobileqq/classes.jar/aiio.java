import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import org.json.JSONObject;

class aiio
  implements aiiq
{
  aiio(aiin paramaiin) {}
  
  public void a(List<aihq> paramList, String paramString1, String paramString2, int paramInt, String paramString3)
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
    paramList = QzoneIPCModule.parseSticker2Json(paramList);
    if (paramList == null)
    {
      QLog.i("StickerRecManager", 2, "OnImgUpdated: failed to parse img data");
      return;
    }
    QzoneIPCModule.getInstance().onGetStickerRecResp(paramString1, paramList.toString(), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiio
 * JD-Core Version:    0.7.0.1
 */