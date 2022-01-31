import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.base.http.AvatarUpdateService;
import com.tencent.open.base.http.AvatarUpdateService.AvatarUpdateTask;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask;
import com.tencent.open.base.http.HttpImageDownloadAsyncTask.TaskCompleteCallback;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class akpw
  implements Runnable
{
  public akpw(AvatarUpdateService paramAvatarUpdateService, String paramString1, String paramString2, String paramString3, String paramString4, Context paramContext, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback) {}
  
  public void run()
  {
    Object localObject1 = new DefaultHttpClient();
    label346:
    try
    {
      ??? = new HttpGet(MsfSdkUtils.insertMtype("yingyongbao", this.jdField_a_of_type_JavaLangString));
      ((HttpGet)???).addHeader("Cookie", this.b);
      localObject1 = EntityUtils.toString(((HttpClient)localObject1).execute((HttpUriRequest)???).getEntity(), "utf-8");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.e("AvatarUpdateService", 1, "-->updateAvatar--jsonp is empty");
        }
      }
      else
      {
        i = ((String)localObject1).indexOf('{');
        j = ((String)localObject1).lastIndexOf('}');
        if ((i < 0) || (i > j) || (j < 0))
        {
          if (!QLog.isColorLevel()) {
            break label346;
          }
          QLog.e("AvatarUpdateService", 1, "-->updateAvatar--can not find json string");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      int j;
      if (QLog.isColorLevel())
      {
        QLog.e("AvatarUpdateService", 1, "-->updateAvatar--parse json failed");
        return;
        String str = new JSONObject(localJSONException.substring(i, j + 1)).getString(this.c);
        if (TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AvatarUpdateService", 1, "-->updateAvatar--image url is empty");
          }
        }
        else
        {
          ??? = this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.c, "");
          if ((!FileUtil.a(this.d)) || (!str.equals(???)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarUpdateService", 2, "-->updateAvatar--avatar not exist or need update, will download new avatar");
            }
            synchronized (this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService.jdField_a_of_type_JavaUtilHashMap)
            {
              if (!this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService.jdField_a_of_type_JavaUtilHashMap.containsKey(this.c))
              {
                this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService.jdField_a_of_type_JavaUtilHashMap.put(this.c, new AvatarUpdateService.AvatarUpdateTask(this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService, this.jdField_a_of_type_AndroidContentContext, this.c, this.d, str, this.jdField_a_of_type_ComTencentOpenBaseHttpHttpImageDownloadAsyncTask$TaskCompleteCallback));
                new HttpImageDownloadAsyncTask(this.c, str, null, "GET", this.jdField_a_of_type_ComTencentOpenBaseHttpAvatarUpdateService).execute(new Void[0]);
              }
              return;
            }
          }
        }
      }
    }
    catch (ParseException localParseException) {}catch (IndexOutOfBoundsException localIndexOutOfBoundsException) {}catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akpw
 * JD-Core Version:    0.7.0.1
 */