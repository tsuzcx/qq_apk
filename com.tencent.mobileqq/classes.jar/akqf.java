import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.1;
import com.tencent.mobileqq.apollo.CmShowRscUpdateHandler.2;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.BspatchUtil;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContInfo;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdReq;
import com.tencent.pb.clubcontent.CmShowContentUpdate.STContUpdRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class akqf
  implements BusinessObserver
{
  private static int jdField_a_of_type_Int = 180;
  private static akqf jdField_a_of_type_Akqf;
  private final SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("cmshow_rsc_update_sp", 4);
  private final SparseArray<WeakReference<akqj>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<akqi> jdField_a_of_type_JavaUtilList;
  
  private akqf()
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("json_content_update_interval", 0);
    if (i >= 10) {
      jdField_a_of_type_Int = i;
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "RscContentUpdateHandler sJsonContentUpdateInterval:" + jdField_a_of_type_Int);
  }
  
  public static akqf a()
  {
    try
    {
      if (jdField_a_of_type_Akqf == null) {
        jdField_a_of_type_Akqf = new akqf();
      }
      akqf localakqf = jdField_a_of_type_Akqf;
      return localakqf;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      ((akqj)localWeakReference.get()).a(false, null);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckFailed requestId:" + paramInt);
  }
  
  private void a(int paramInt, akqi paramakqi)
  {
    if (paramakqi == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess result" + paramakqi);
    }
    if ((paramakqi.jdField_a_of_type_Int == 100) && (paramakqi.jdField_a_of_type_Long == 1L))
    {
      if (1 == BaseApplicationImpl.sProcessId) {
        break label293;
      }
      if ("all_room3D".equals(paramakqi.jdField_a_of_type_JavaLangString)) {
        akqa.a().a();
      }
    }
    else
    {
      label79:
      a(paramakqi, paramakqi.jdField_b_of_type_Int);
      if (paramakqi.jdField_b_of_type_Boolean)
      {
        if (paramakqi.jdField_d_of_type_Int <= 0) {
          break label417;
        }
        if (jdField_a_of_type_Int == paramakqi.jdField_d_of_type_Int) {
          break label380;
        }
        jdField_a_of_type_Int = paramakqi.jdField_d_of_type_Int;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("json_content_update_interval", paramakqi.jdField_d_of_type_Int).commit();
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess interval != result.mCheckServerInterval:" + paramakqi.jdField_d_of_type_Int);
      }
    }
    label417:
    for (;;)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilList != null)
        {
          this.jdField_a_of_type_JavaUtilList.remove(paramakqi);
          if (this.jdField_a_of_type_JavaUtilList.isEmpty())
          {
            this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("last_json_content_update_ts", System.currentTimeMillis()).commit();
            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess save lastCheckContentUpdateTS");
          }
        }
        Object localObject = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if ((localObject == null) || (((WeakReference)localObject).get() == null)) {
          break;
        }
        ((akqj)((WeakReference)localObject).get()).a(true, paramakqi);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        return;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "check update from QQ process");
        break label79;
        label293:
        if (!akwd.a(BaseApplicationImpl.getContext())) {
          break label79;
        }
        localObject = new Intent();
        ((Intent)localObject).setAction("com.tencent.mobileqq.webprocess.launch_cmgame");
        ((Intent)localObject).putExtra("action_apollo_cmshow_content_update", true);
        ((Intent)localObject).putExtra("key_content_update_zip_name", "all_room3D");
        ((Intent)localObject).setPackage(BaseApplicationImpl.getContext().getPackageName());
        try
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "send sendBroadcast contentUpdate");
          BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
        }
        catch (Throwable localThrowable)
        {
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, localThrowable, new Object[0]);
        }
      }
      break label79;
      label380:
      if (QLog.isColorLevel())
      {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "onContentCheckSuccess interval == result.mCheckServerInterval:" + paramakqi.jdField_d_of_type_Int);
        continue;
        QLog.i("rscContent_CmShowRscUpdateHandler", 1, "onContentCheckSuccess result.mCheckServerInterval <= 0" + paramakqi.jdField_d_of_type_Int);
      }
    }
  }
  
  private void a(int paramInt, CmShowContentUpdate.STContUpdRsp paramSTContUpdRsp, boolean paramBoolean)
  {
    if (paramSTContUpdRsp != null) {
      ThreadManager.post(new CmShowRscUpdateHandler.2(this, paramSTContUpdRsp, paramBoolean, paramInt), 5, null, false);
    }
  }
  
  private void a(int paramInt, List<akqi> paramList)
  {
    if (paramList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource checkResults:" + paramList.size());
      }
      if (paramList.isEmpty()) {}
      for (;;)
      {
        return;
        Object localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localObject != null)
        {
          localObject = (beag)((AppInterface)localObject).getManager(47);
          if ((localObject != null) && (((beag)localObject).a(3) != null))
          {
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              akqi localakqi = (akqi)paramList.next();
              if (localakqi != null)
              {
                localObject = new File(localakqi.c());
                ((File)localObject).getParentFile().mkdirs();
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
                String str1 = localakqi.e();
                if ((localakqi.jdField_a_of_type_Boolean) && (!new File(str1).exists()))
                {
                  localakqi.jdField_a_of_type_Boolean = false;
                  QLog.e("rscContent_CmShowRscUpdateHandler", 1, "updateResource old version File no exist :" + str1);
                }
                if (localakqi.jdField_a_of_type_Boolean)
                {
                  if (localakqi.jdField_a_of_type_ArrayOfByte != null)
                  {
                    String str2 = localakqi.d();
                    if (bdhb.a(localakqi.jdField_a_of_type_ArrayOfByte, str2))
                    {
                      if (BspatchUtil.a(str1, str2, ((File)localObject).getAbsolutePath()))
                      {
                        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "BspatchUtil.patch success path:" + ((File)localObject).getAbsolutePath());
                        try
                        {
                          str1 = bflr.a(((File)localObject).getAbsolutePath());
                          if (QLog.isColorLevel()) {
                            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " updateResource onDone dstMd5:" + str1 + " result.mMd5:" + localakqi.jdField_d_of_type_JavaLangString);
                          }
                          if (!b(localakqi, str1)) {
                            break label640;
                          }
                          if (b(localakqi))
                          {
                            ndr.a((File)localObject, ((File)localObject).getParent() + File.separator);
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile ok file dstpath:" + ((File)localObject).getAbsolutePath());
                            }
                            a(localakqi.jdField_e_of_type_Int, localakqi);
                          }
                        }
                        catch (Exception localException)
                        {
                          for (;;)
                          {
                            ((File)localObject).delete();
                            if (QLog.isColorLevel()) {
                              QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localException.getMessage());
                            }
                            a(paramInt);
                            break;
                            boolean bool = bdhb.d(((File)localObject).getAbsolutePath(), localException.b() + localException.jdField_e_of_type_JavaLangString);
                            QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
                          }
                        }
                        catch (OutOfMemoryError localOutOfMemoryError)
                        {
                          ((File)localObject).delete();
                        }
                        if (QLog.isColorLevel())
                        {
                          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "updateResource unZipFile file error path->" + ((File)localObject).getAbsolutePath() + localOutOfMemoryError.getMessage());
                          continue;
                          label640:
                          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
                          b(localOutOfMemoryError);
                        }
                      }
                      else
                      {
                        QLog.e("rscContent_CmShowRscUpdateHandler", 1, "BspatchUtil.patch failed path:" + ((File)localObject).getAbsolutePath());
                        b(localOutOfMemoryError);
                      }
                    }
                    else {
                      b(localOutOfMemoryError);
                    }
                  }
                  else
                  {
                    a(localOutOfMemoryError);
                  }
                }
                else {
                  b(localOutOfMemoryError);
                }
              }
            }
          }
        }
      }
    }
    a(paramInt, null);
  }
  
  private void a(akqi paramakqi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result:" + paramakqi);
    }
    if (paramakqi == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (beag)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((beag)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramakqi.c))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadZipAndPatch result.mDownloadPatchFileUrl is empty result:" + paramakqi);
      return;
    }
    File localFile = new File(paramakqi.d());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    beae localbeae = new beae(paramakqi.c, localFile);
    localbeae.p = true;
    localbeae.n = true;
    localbeae.f = "apollo_res";
    localbeae.jdField_b_of_type_Int = 1;
    localbeae.q = true;
    localbeae.r = true;
    localbeae.jdField_a_of_type_JavaLangString = (paramakqi.jdField_b_of_type_JavaLangString + "_" + paramakqi.jdField_a_of_type_JavaLangString);
    ((beaj)localObject).a(localbeae, new akqg(this, localFile, paramakqi), null);
  }
  
  private void b(akqi paramakqi)
  {
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result:" + paramakqi);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (paramakqi == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while (localObject == null);
        localObject = (beag)((AppInterface)localObject).getManager(47);
      } while (localObject == null);
      localObject = ((beag)localObject).a(3);
    } while (localObject == null);
    if (TextUtils.isEmpty(paramakqi.jdField_b_of_type_JavaLangString))
    {
      QLog.e("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip result.mDownloadFileUrl is empty result:" + paramakqi);
      return;
    }
    File localFile = new File(paramakqi.c());
    localFile.getParentFile().mkdirs();
    if (localFile.exists()) {
      localFile.delete();
    }
    beae localbeae = new beae(paramakqi.jdField_b_of_type_JavaLangString, localFile);
    localbeae.p = true;
    localbeae.n = true;
    localbeae.f = "apollo_res";
    localbeae.jdField_b_of_type_Int = 1;
    localbeae.q = true;
    localbeae.r = true;
    localbeae.jdField_a_of_type_JavaLangString = (paramakqi.jdField_b_of_type_JavaLangString + "_" + paramakqi.jdField_a_of_type_JavaLangString);
    ((beaj)localObject).a(localbeae, new akqh(this, localFile, paramakqi), null);
  }
  
  private static boolean b(akqi paramakqi)
  {
    if (paramakqi == null) {}
    while ((TextUtils.isEmpty(paramakqi.jdField_e_of_type_JavaLangString)) || (!paramakqi.jdField_e_of_type_JavaLangString.endsWith(".zip"))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(akqi paramakqi, String paramString)
  {
    if (paramakqi == null) {}
    do
    {
      return false;
      if (TextUtils.isEmpty(paramakqi.jdField_d_of_type_JavaLangString)) {
        return true;
      }
    } while ((paramString == null) || (!paramString.equalsIgnoreCase(paramakqi.jdField_d_of_type_JavaLangString)));
    return true;
  }
  
  public int a(int paramInt, long paramLong, String paramString)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramInt + "_" + paramLong + "_" + paramString, 0);
  }
  
  public void a(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramInt1 + "_" + paramLong + "_" + paramString, paramInt2).commit();
  }
  
  public void a(int paramInt, akqj paramakqj)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramakqj));
      return;
    }
  }
  
  public void a(akqi paramakqi, int paramInt)
  {
    if (paramakqi != null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramakqi.a(), paramInt).commit();
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "saveContentVersion version:" + paramInt);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ThreadManagerV2.excute(new CmShowRscUpdateHandler.1(this, paramAppInterface), 16, null, false);
  }
  
  public void a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate forceCheck:" + paramBoolean);
    if (paramAppInterface == null) {}
    do
    {
      return;
      if (!akqi.a(100, 1L, "all_room3D", "all_room3D.json"))
      {
        a(100, 1L, "all_room3D", 0);
        paramBoolean = true;
      }
      if (!paramBoolean)
      {
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_json_content_update_ts", 0L);
        if (System.currentTimeMillis() - l < jdField_a_of_type_Int * 1000)
        {
          QLog.i("rscContent_CmShowRscUpdateHandler", 1, "checkCmShowContentUpdate in sJsonContentUpdateInterval:" + jdField_a_of_type_Int);
          return;
        }
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
      Object localObject1 = new CmShowContentUpdate.STContUpdReq();
      ((CmShowContentUpdate.STContUpdReq)localObject1).app_id.set(1);
      Object localObject2 = new ArrayList();
      Object localObject3 = new CmShowContentUpdate.STContInfo();
      ((CmShowContentUpdate.STContInfo)localObject3).biz_id.set(100);
      ((CmShowContentUpdate.STContInfo)localObject3).item_id.set(1L);
      ((CmShowContentUpdate.STContInfo)localObject3).name.set(ByteStringMicro.copyFromUtf8("all_room3D"));
      ((CmShowContentUpdate.STContInfo)localObject3).ver.set(a(100, 1L, "all_room3D"));
      ((List)localObject2).add(localObject3);
      ((CmShowContentUpdate.STContUpdReq)localObject1).cont_list.set((List)localObject2);
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject3).mqqver.set("8.3.5");
        localObject2 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set((MessageMicro)localObject3);
        ((WebSSOAgent.UniSsoServerReq)localObject2).pbReqData.set(ByteStringMicro.copyFrom(((CmShowContentUpdate.STContUpdReq)localObject1).toByteArray()));
        localObject1 = new NewIntent(BaseApplicationImpl.getContext(), atkg.class);
        ((NewIntent)localObject1).putExtra("extra_cmd", "cmshowar_content_update.check");
        ((NewIntent)localObject1).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
        ((NewIntent)localObject1).putExtra("extra_callbackid", String.valueOf(paramInt));
        ((NewIntent)localObject1).setObserver(this);
        paramAppInterface.startServlet((NewIntent)localObject1);
        return;
      }
      catch (Exception paramAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("rscContent_CmShowRscUpdateHandler", 2, "OpenPandora failed ", paramAppInterface);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    for (;;)
    {
      return;
      paramInt = paramBundle.getInt("extra_result_code");
      Object localObject = paramBundle.getString("extra_cmd");
      str = paramBundle.getString("extra_callbackid");
      QLog.i("rscContent_CmShowRscUpdateHandler", 1, "isSuccess:" + paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("rscContent_CmShowRscUpdateHandler", 2, "svrRet:" + paramInt + " cmd:" + (String)localObject + " requestIdStr:" + str);
      }
      if (!paramBoolean) {
        break label281;
      }
      try
      {
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom(arrayOfByte);
        long l = paramBundle.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "retCode:" + l + " isSuccess:" + paramBoolean + " cmd:" + (String)localObject);
        }
        if ("cmshowar_content_update.check".equals(localObject)) {
          if (l == 0L)
          {
            localObject = new CmShowContentUpdate.STContUpdRsp();
            ((CmShowContentUpdate.STContUpdRsp)localObject).mergeFrom(paramBundle.pbRsqData.get().toByteArray());
            a(ApolloUtil.b(str), (CmShowContentUpdate.STContUpdRsp)localObject, true);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("rscContent_CmShowRscUpdateHandler", 1, paramBundle, new Object[0]);
        return;
      }
    }
    a(ApolloUtil.b(str));
    return;
    label281:
    a(ApolloUtil.b(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqf
 * JD-Core Version:    0.7.0.1
 */