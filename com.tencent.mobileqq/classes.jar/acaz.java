import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.7;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class acaz
{
  public int a;
  protected acbg a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new acbc(this);
  protected Bundle a;
  public aouj a;
  private ayvz jdField_a_of_type_Ayvz = new acba(this);
  public bbgg a;
  public BaseActivity a;
  public QQAppInterface a;
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  public String a;
  public ArrayList<acbg> a;
  List<FileManagerEntity> jdField_a_of_type_JavaUtilList = null;
  protected boolean a;
  public int b;
  DialogInterface.OnClickListener b;
  public String b;
  protected boolean b;
  public int c;
  DialogInterface.OnClickListener c;
  protected String c;
  protected boolean c;
  public String d;
  public boolean d;
  
  public acaz(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Aouj = new acbb(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new acbd(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new acbe(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719282);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (bbdj.a(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 10002) && (paramInt != 3000)) {
        break label192;
      }
      bbdr.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = bbdr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      bbdr.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.jdField_b_of_type_JavaLangString;
    }
    label192:
    for (;;)
    {
      long l1;
      if (!bbdr.a(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
        l1 = 0L;
      }
      long l2;
      do
      {
        return l1;
        l2 = a(paramString1, paramString2, paramString3, paramInt);
        a(paramInt, paramString3, paramString1, l2, 1009);
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("streamptt", 2, "ChatActivity.handleForwardData uploadImage,uniseq:" + l2 + ",filePath:" + paramString1 + ",curType:" + paramInt);
      return l2;
      return 0L;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    long l = 0L;
    if (paramString1 != null)
    {
      paramString2 = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = aunt.a();
      paramString2.md5 = bbdm.a(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString + paramLong);
    if ((paramString instanceof ayoz)) {
      ((ayoz)paramString).c();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    aywa localaywa = new aywa();
    localaywa.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localaywa.jdField_c_of_type_JavaLangString = paramString1;
    localaywa.jdField_a_of_type_Int = paramInt1;
    localaywa.jdField_b_of_type_Int = 1;
    localaywa.jdField_a_of_type_Long = paramLong;
    localaywa.jdField_a_of_type_Boolean = true;
    localaywa.e = paramInt2;
    localaywa.i = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
  }
  
  private void e()
  {
    ayoz localayoz = (ayoz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long);
    if (localayoz != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.w("SendMultiPictureHelper", 2, this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long + "has error");
        localayoz.j();
        a();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long);
        return;
        localayoz.b();
      }
    }
    QLog.w("SendMultiPictureHelper", 2, "processor null");
    if (this.jdField_c_of_type_Boolean) {
      a();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Acbg.jdField_a_of_type_Long == -1L) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
    }
    do
    {
      do
      {
        return;
        ayoz localayoz = (ayoz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long);
        if (localayoz == null) {
          break;
        }
        localayoz.j();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Acbg.jdField_a_of_type_Long);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("SendMultiPictureHelper", 2, "processor null");
  }
  
  private void g() {}
  
  void a()
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        }
        if (QLog.isColorLevel()) {
          QLog.e("SendMultiPictureHelper", 2, "sendNext " + (this.jdField_a_of_type_Int + 1));
        }
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
          break label261;
        }
        acbg localacbg = (acbg)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject2 = localacbg.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Acbg = localacbg;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.jdField_c_of_type_Boolean = true;
          Toast.makeText(BaseApplicationImpl.getApplication(), ((File)localObject2).getName() + ajyc.a(2131713823), 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692536), 0).show();
          }
        }
        else
        {
          a(localacbg, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695164), 0).show();
      continue;
      label261:
      if (this.jdField_a_of_type_Bbgg != null) {
        this.jdField_a_of_type_Bbgg.cancel();
      }
      c();
    }
  }
  
  public void a(acbg paramacbg, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new SendMultiPictureHelper.7(this, paramacbg, paramInt, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Ayvz);
    this.jdField_a_of_type_Ayvz.addFilter(new Class[] { aypf.class, aypj.class, ayrd.class, ayqp.class });
    this.jdField_a_of_type_Bbgg = bbcv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691046), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_Bbgg.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbgg.setCancelable(false);
    this.jdField_a_of_type_Bbgg.show();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramString3 = new acbg(this);
      paramString3.jdField_a_of_type_JavaLangString = paramString2;
      paramString3.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
    }
    paramString1 = ((acbg)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_Acbg = ((acbg)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    if (!bbev.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aouj);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Bbgg.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
        a((acbg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        paramInt += 1;
      }
      c();
      return;
    }
    this.jdField_a_of_type_Bbgg.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label521;
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692536), 0).show();
    }
    for (;;)
    {
      a((acbg)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new acbf(this);
      }
      AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      return;
      label521:
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695164), 0).show();
    }
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691048);
    localObject = bbcv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720249), (String)localObject, 2131693063, 2131694647, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    ((bbgg)localObject).setCancelable(false);
    ((bbgg)localObject).show();
  }
  
  public void c()
  {
    Intent localIntent = actn.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Ayvz);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aouj);
    try
    {
      this.jdField_a_of_type_Bbgg.dismiss();
      label35:
      this.jdField_a_of_type_Bbgg = null;
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
        AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acaz
 * JD-Core Version:    0.7.0.1
 */