import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadQueryListener;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class akok
  implements DownloadQueryListener
{
  public akok(DownloadInterface paramDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    LogUtility.e(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "innerQueryDownloadInfo ERROR");
  }
  
  public void b_(List paramList)
  {
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "innerQueryDownloadInfo onResult = " + paramList.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.b);
          localJSONObject.put("pro", localDownloadInfo.g);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.c);
          localJSONObject.put("download_from", localDownloadInfo.i);
          localJSONObject.put("writecodestate", localDownloadInfo.k);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.jdField_a_of_type_JavaLangString + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    LogUtility.c(this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.TAG, "querySucess : " + paramList);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akok
 * JD-Core Version:    0.7.0.1
 */