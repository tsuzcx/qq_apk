import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.IPicDownloadListener;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class alpc
{
  public static Set<String> a = new HashSet();
  
  public static int a(String paramString)
  {
    String str2 = "0";
    String str1 = str2;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring("qto_".length() + i, paramString.length());
      }
    }
    try
    {
      i = Integer.parseInt(str1);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FunyPicHelper", 2, paramString.getMessage());
      }
    }
    return 0;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf("qto_");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    return str1;
  }
  
  public static void a(Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener) {}
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      Object localObject1 = bdcs.a(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), bdmy.f.a));
      Object localObject2 = "";
      String str = "";
      j = 1;
      i = j;
      localObject5 = str;
      localObject6 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = str;
        localObject4 = localObject2;
      }
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = j;
        localObject5 = str;
        localObject6 = localObject2;
        localObject3 = str;
        localObject4 = localObject2;
        if (((JSONObject)localObject1).has("data"))
        {
          localObject3 = str;
          localObject4 = localObject2;
          localObject1 = ((JSONObject)localObject1).getJSONObject("data");
          i = j;
          localObject5 = str;
          localObject6 = localObject2;
          localObject3 = str;
          localObject4 = localObject2;
          if (((JSONObject)localObject1).has("releaseZipInfo"))
          {
            localObject3 = str;
            localObject4 = localObject2;
            localObject1 = ((JSONObject)localObject1).getJSONArray("releaseZipInfo");
            i = j;
            localObject5 = str;
            localObject6 = localObject2;
            localObject3 = str;
            localObject4 = localObject2;
            if (((JSONArray)localObject1).length() > 0)
            {
              localObject3 = str;
              localObject4 = localObject2;
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(0);
              localObject1 = localObject2;
              localObject3 = str;
              localObject4 = localObject2;
              if (localJSONObject.has("zipID"))
              {
                localObject3 = str;
                localObject4 = localObject2;
                localObject1 = localJSONObject.getString("zipID");
              }
              localObject2 = str;
              localObject3 = str;
              localObject4 = localObject1;
              if (localJSONObject.has("img"))
              {
                localObject3 = str;
                localObject4 = localObject1;
                localObject2 = localJSONObject.getString("img");
              }
              i = j;
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject3 = localObject2;
              localObject4 = localObject1;
              if (localJSONObject.has("type"))
              {
                localObject3 = localObject2;
                localObject4 = localObject1;
                i = localJSONObject.getInt("type");
                localObject6 = localObject1;
                localObject5 = localObject2;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i = j;
          localObject5 = localObject3;
          localObject6 = localObject4;
          if (QLog.isColorLevel())
          {
            QLog.d("FunyPicHelper", 2, localException.getMessage());
            i = j;
            localObject5 = localObject3;
            localObject6 = localObject4;
          }
        }
      }
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("funny_pic_info", 0);
      if (!TextUtils.isEmpty(localObject6)) {
        paramQQAppInterface.edit().putString("funnypic_count_sp_key", localObject6).commit();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        paramQQAppInterface.edit().putString("funnypic_name_sp_key", (String)localObject5).commit();
      }
      paramQQAppInterface.edit().putInt("funnypic_type_sp_key", i).commit();
    } while (!QLog.isColorLevel());
    QLog.d("FunyPicHelper", 2, "funnypic zipID->" + localObject6 + ";imgName -> " + (String)localObject5 + ";type -> " + i);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, List<CustomEmotionData> paramList, AppInterface paramAppInterface, IPicDownloadListener paramIPicDownloadListener)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramList == null) || (paramList.isEmpty())) {}
    label124:
    do
    {
      bdwa localbdwa;
      do
      {
        return;
        if (!bdee.g(paramContext)) {
          break;
        }
        localbdwa = ((bdvx)paramAppInterface.getManager(47)).a(1);
      } while (localbdwa == null);
      apke localapke = (apke)paramAppInterface.getManager(149);
      apli localapli = (apli)paramAppInterface.getManager(141);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      AtomicInteger localAtomicInteger1 = new AtomicInteger(paramList.size());
      AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        CustomEmotionData localCustomEmotionData;
        if (localIterator.hasNext())
        {
          localCustomEmotionData = (CustomEmotionData)localIterator.next();
          if (!TextUtils.isEmpty(localCustomEmotionData.url))
          {
            if (localbdwa.a(localCustomEmotionData.url) != null)
            {
              localAtomicInteger1.decrementAndGet();
              continue;
            }
            paramList = aljq.bi;
            boolean bool1 = false;
            File localFile;
            if ((localapli != null) && (localapli.a(localCustomEmotionData))) {
              if ((!TextUtils.isEmpty(localCustomEmotionData.emoPath)) && (localCustomEmotionData.emoPath.startsWith(aljq.bi)))
              {
                paramList = localCustomEmotionData.emoPath;
                localFile = new File(paramList);
                if (!localFile.exists()) {
                  break label753;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("FunyPicHelper", 2, "download path is exsit->" + paramList);
                }
                localAtomicInteger1.decrementAndGet();
                localCustomEmotionData.emoPath = localFile.getAbsolutePath();
                if ("needDownload".equals(localCustomEmotionData.RomaingType)) {
                  localCustomEmotionData.RomaingType = "isUpdate";
                }
                if (bool1) {
                  localCustomEmotionData.eId = "";
                }
                if ((TextUtils.isEmpty(localCustomEmotionData.md5)) && (!TextUtils.isEmpty(localCustomEmotionData.emoPath))) {
                  localCustomEmotionData.md5 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
                }
                if (paramBoolean) {
                  localapke.b(localCustomEmotionData);
                }
                if (paramIPicDownloadListener != null) {
                  paramIPicDownloadListener.onFileDone(localCustomEmotionData, true);
                }
                localArrayList1.add(localCustomEmotionData);
                if (QLog.isColorLevel()) {
                  QLog.d("FunyPicHelper", 2, "update funnyPic eId->" + localCustomEmotionData.eId + " emoPath->" + localCustomEmotionData.emoPath + " download->sucess");
                }
              }
            }
            for (;;)
            {
              if ((localAtomicInteger1.get() != 0) || (paramIPicDownloadListener == null)) {
                break label903;
              }
              paramIPicDownloadListener.onDone(localArrayList1, localArrayList2);
              break;
              if (!TextUtils.isEmpty(localCustomEmotionData.md5))
              {
                paramList = localapli.a(localCustomEmotionData.md5);
                break label234;
              }
              if (!TextUtils.isEmpty(localCustomEmotionData.resid))
              {
                paramList = paramList + ammj.a(localCustomEmotionData.resid);
                break label234;
              }
              paramList = paramList + localCustomEmotionData.url.substring(localCustomEmotionData.url.lastIndexOf("/") + 1);
              break label234;
              if (localCustomEmotionData.url.contains("qto_"))
              {
                paramList = paramList + a(localCustomEmotionData.url);
                break label234;
              }
              if (!TextUtils.isEmpty(a(localCustomEmotionData.eId)))
              {
                paramAppInterface = paramList + localCustomEmotionData.eId;
                boolean bool2 = true;
                paramList = paramAppInterface;
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break label234;
                }
                QLog.d("FunyPicHelper", 2, "emotion is FunnyPic path download from server->" + localCustomEmotionData.eId);
                paramList = paramAppInterface;
                bool1 = bool2;
                break label234;
              }
              paramList = paramList + localCustomEmotionData.resid;
              break label234;
              bdvv localbdvv = new bdvv(localCustomEmotionData.url, localFile);
              localbdvv.p = false;
              localbdvv.f = "emotion_pic";
              localbdvv.b = 1;
              paramList = "";
              if (localCustomEmotionData.url.contains("qto_"))
              {
                paramAppInterface = a(localCustomEmotionData.url);
                paramList = paramAppInterface;
                if (!TextUtils.isEmpty(paramAppInterface))
                {
                  paramList = paramAppInterface;
                  if (paramAppInterface.length() > "qto_".length() + 8)
                  {
                    paramList = paramAppInterface.substring(0, "qto_".length() + 8);
                    a.add(paramList);
                  }
                }
              }
              localbdwa.a(localbdvv, new alpd(paramList, localFile, localCustomEmotionData, bool1, paramBoolean, localapke, paramIPicDownloadListener, localArrayList1, localArrayList2, paramContext, localAtomicInteger2, localAtomicInteger1), null);
            }
            continue;
          }
          if (paramIPicDownloadListener != null) {
            paramIPicDownloadListener.onFileDone(localCustomEmotionData, false);
          }
          if (!TextUtils.isEmpty(localCustomEmotionData.RomaingType)) {
            break label982;
          }
        }
        for (paramList = "null";; paramList = localCustomEmotionData.RomaingType)
        {
          if (!QLog.isColorLevel()) {
            break label989;
          }
          QLog.d("FunyPicHelper", 2, "checkLoadEmotionPic, url is null : " + localCustomEmotionData.resid + ", romaingType:" + paramList);
          break label124;
          break;
        }
      }
    } while (paramIPicDownloadListener == null);
    label234:
    label753:
    paramIPicDownloadListener.onDone(new ArrayList(), paramList);
    label903:
    label982:
    label989:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alpc
 * JD-Core Version:    0.7.0.1
 */