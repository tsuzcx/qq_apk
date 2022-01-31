import android.app.Activity;
import android.text.TextUtils;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.sdk.AVView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.1;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.10;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.11;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.12;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.13;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.2;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.3;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.4;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.5;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.6;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.7;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.8;
import com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.9;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ajba
  implements aivp
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  public airm a;
  public begr a;
  private AVVideoCtrl.EnableCameraCompleteCallback jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$EnableCameraCompleteCallback = new ajbe(this);
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public ajba(int paramInt)
  {
    this.jdField_a_of_type_Begr = new ajbd(this);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(String[] paramArrayOfString, String paramString)
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals(paramString)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList1.add(paramArrayOfString[i]);
        AVView localAVView = new AVView();
        localAVView.videoSrcType = 1;
        localAVView.viewSizeType = 1;
        localArrayList2.add(localAVView);
      }
    }
    if (QLog.isColorLevel())
    {
      i = 0;
      while (i < localArrayList1.size())
      {
        QLog.d("CmGameAvHandler", 2, "requestVideo identifiers=" + ((String)localArrayList1.get(i)).toString());
        i += 1;
      }
    }
    paramArrayOfString = new ajbg(this);
    if (QLog.isColorLevel())
    {
      i = j;
      while (i < localArrayList1.size())
      {
        QLog.d("CmGameAvHandler", 2, "xxxx request iden=" + (String)localArrayList1.get(i));
        i += 1;
      }
    }
    if ((ajla.a(BaseApplicationImpl.getContext()).a() != null) && (ajla.a(BaseApplicationImpl.getContext()).a().getRoom() != null) && (localArrayList1.size() > 0)) {
      ajla.a(BaseApplicationImpl.getContext()).a().getRoom().requestViewList((String[])localArrayList1.toArray(new String[localArrayList1.size()]), (AVView[])localArrayList2.toArray(new AVView[localArrayList2.size()]), localArrayList1.size(), paramArrayOfString);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (GraphicRendererMgr.getInstance() != null)) {}
    this.f = paramBoolean;
    if ((ajac.b(this.jdField_a_of_type_Long) != null) && (ajac.b(this.jdField_a_of_type_Long).a != null))
    {
      AppActivity localAppActivity = (AppActivity)ajac.b(this.jdField_a_of_type_Long).a.get();
      localAppActivity.requestPermissions(new ajbf(this, localAppActivity), 1, new String[] { "android.permission.CAMERA" });
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public aivv a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    if ((!"cs.audioRoom_enter.local".equals(paramString1)) || (!TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString2);
        i = paramString1.optInt("avRoomId");
        paramLong = paramString1.optLong("gameRoomId");
        paramString1 = paramString1.optString("avRoleName", "lmxtest");
        ThreadManager.getUIHandler().post(new CmGameAvHandler.1(this, paramString1, paramLong, i));
        return null;
      }
      catch (Exception paramString1)
      {
        int i;
        return null;
      }
      if ("cs.audioRoom_exit.local".equals(paramString1))
      {
        ThreadManager.getUIHandler().post(new CmGameAvHandler.2(this));
        return null;
      }
      if ("cs.audioRoom_camera_enable.local".equals(paramString1)) {}
      try
      {
        bool = new JSONObject(paramString2).optBoolean("switch");
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          ThreadManager.getUIHandler().post(new CmGameAvHandler.3(this));
          return null;
        }
        ThreadManager.getUIHandler().post(new CmGameAvHandler.4(this));
        return null;
      }
      catch (Exception paramString1)
      {
        boolean bool;
        return null;
      }
      if ("cs.audioRoom_set_mic.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          bool = new JSONObject(paramString2).optBoolean("switch");
          ThreadManager.getUIHandler().post(new CmGameAvHandler.5(this, bool));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_speaker.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          bool = new JSONObject(paramString2).optBoolean("switch");
          ThreadManager.getUIHandler().post(new CmGameAvHandler.6(this, bool));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_init.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          a(paramString2);
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_local_video.local".equals(paramString1)) {}
      try
      {
        bool = new JSONObject(paramString2).optBoolean("switch");
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          ThreadManager.getUIHandler().post(new CmGameAvHandler.7(this));
          return null;
        }
        ThreadManager.getUIHandler().post(new CmGameAvHandler.8(this));
        return null;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      if ("cs.audioRoom_camera_switch.local".equals(paramString1)) {}
      try
      {
        i = new JSONObject(paramString2).optInt("cameraPos");
        if (!this.jdField_a_of_type_Boolean)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CmGameAvHandler", 2, "switch carmera but carma close");
          return null;
        }
        ThreadManager.getUIHandler().post(new CmGameAvHandler.9(this, i, paramLong));
        return null;
      }
      catch (Exception paramString1) {}
      if ("cs.audioRoom_change_qav_role.local".equals(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString2).optString("role", "user");
          ThreadManager.getUIHandler().post(new CmGameAvHandler.10(this, paramString1, paramLong));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_remote_video.local".equals(paramString1)) {
        try
        {
          paramString1 = Boolean.valueOf(new JSONObject(paramString2).optBoolean("switch"));
          this.d = paramString1.booleanValue();
          ThreadManager.getUIHandler().post(new CmGameAvHandler.11(this, paramString1));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_watch_remote_video.local".equals(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString2).optJSONArray("openIdList");
          if (paramString1 == null) {
            continue;
          }
          ThreadManager.getUIHandler().post(new CmGameAvHandler.12(this, paramString1));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      } else if ("cs.audioRoom_set_beauty.local".equals(paramString1)) {
        try
        {
          float f1 = (float)new JSONObject(paramString2).optDouble("beauty");
          ThreadManager.getUIHandler().post(new CmGameAvHandler.13(this, f1));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
    }
    return null;
  }
  
  AVVideoCtrl a()
  {
    AVContext localAVContext = ajla.a(BaseApplicationImpl.getContext()).a();
    if (localAVContext != null) {
      return localAVContext.getVideoCtrl();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("sdkAppId"))
        {
          i = paramString.optInt("sdkAppId");
          if (paramString.has("accountType")) {
            j = paramString.optInt("accountType");
          }
          ThreadManager.getUIHandler().post(new CmGameAvHandler.14(this, i, j));
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ajks.a().c();
      if (this.e)
      {
        if (!paramBoolean) {
          break label120;
        }
        if (this.jdField_b_of_type_Boolean) {
          ajks.a().a(paramBoolean);
        }
      }
      label35:
      if (this.e)
      {
        if (!paramBoolean) {
          break label130;
        }
        if (this.c) {
          ajks.a().b(paramBoolean);
        }
      }
      label60:
      if (this.d)
      {
        if (!paramBoolean) {
          break label140;
        }
        a((String[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new String[this.jdField_a_of_type_JavaUtilArrayList.size()]), "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        b(paramBoolean);
      }
      label120:
      do
      {
        return;
        ajks.a().b();
        break;
        ajks.a().a(paramBoolean);
        break label35;
        ajks.a().b(paramBoolean);
        break label60;
      } while ((ajla.a(BaseApplicationImpl.getContext()).a() == null) || (ajla.a(BaseApplicationImpl.getContext()).a().getRoom() == null));
      label130:
      label140:
      ajla.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new ajbh(this));
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void c()
  {
    a(true);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != -1)
    {
      ajks.a().a("" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Airm != null) {
        this.jdField_a_of_type_Airm.b();
      }
      b(false);
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    int i = 1;
    Object localObject = a();
    if (localObject != null) {
      i = ((AVVideoCtrl)localObject).enableCamera(0, this.f, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$EnableCameraCompleteCallback);
    }
    if (i == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("res", 0);
        ajac.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_camera_enable.local", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException2) {}
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("res", -1);
        ajac.a().callbackFromRequest(this.jdField_a_of_type_Long, i, "cs.audioRoom_camera_enable.local", ((JSONObject)localObject).toString());
        QLog.e("CmGameAvHandler", 1, "enableCamera error rescode = " + i);
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajba
 * JD-Core Version:    0.7.0.1
 */