import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SendMultiPictureHelper.7;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

public class adsd
{
  public int a;
  protected adsk a;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new adsg(this);
  protected Bundle a;
  public aqnl a;
  private baua jdField_a_of_type_Baua = new adse(this);
  public bdfq a;
  public BaseActivity a;
  public QQAppInterface a;
  INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  public String a;
  public ArrayList<adsk> a;
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
  
  public adsd(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Aqnl = new adsf(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new adsh(this);
    this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener = new adsi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719774);
  }
  
  private long a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (bdcs.a(paramString1))
    {
      if ((paramInt != 1) && (paramInt != 0) && (paramInt != 1001) && (paramInt != 10002) && (paramInt != 3000)) {
        break label192;
      }
      bdda.a(-1L, paramInt, true, "compress_start", "SendMultiPictureHelper.doSendPictues");
      String str = bdda.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, paramInt);
      ImageInfo localImageInfo = new ImageInfo();
      bdda.a(4, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString1, str, true, localImageInfo, paramInt);
      paramString1 = localImageInfo.jdField_b_of_type_JavaLangString;
    }
    label192:
    for (;;)
    {
      long l1;
      if (!bdda.a(null, paramString1, 1, null, "SendMultiPictureHelper.doSendPictues")) {
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
      paramString2 = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = awfc.a();
      paramString2.md5 = bdcv.a(MD5.getFileMd5(paramString2.path));
      paramString2.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l = paramString2.uniseq;
    }
    return l;
  }
  
  private void a(int paramInt, String paramString, long paramLong)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString + paramLong);
    if ((paramString instanceof bamw)) {
      ((bamw)paramString).c();
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2)
  {
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localbaub.jdField_c_of_type_JavaLangString = paramString1;
    localbaub.jdField_a_of_type_Int = paramInt1;
    localbaub.jdField_b_of_type_Int = 1;
    localbaub.jdField_a_of_type_Long = paramLong;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.e = paramInt2;
    localbaub.i = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
  }
  
  private void e()
  {
    bamw localbamw = (bamw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long);
    if (localbamw != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        QLog.w("SendMultiPictureHelper", 2, this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long + "has error");
        localbamw.j();
        a();
      }
      for (;;)
      {
        QLog.w("SendMultiPictureHelper", 2, "continue send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long);
        return;
        localbamw.b();
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
    if (this.jdField_a_of_type_Adsk.jdField_a_of_type_Long == -1L) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "uniseq -1");
      }
    }
    do
    {
      do
      {
        return;
        bamw localbamw = (bamw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long);
        if (localbamw == null) {
          break;
        }
        localbamw.j();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long);
      } while (!QLog.isColorLevel());
      QLog.d("SendMultiPictureHelper", 2, "stop send " + this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_Adsk.jdField_a_of_type_Long);
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
        adsk localadsk = (adsk)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        Object localObject2 = localadsk.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Adsk = localadsk;
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists())
        {
          this.jdField_c_of_type_Boolean = true;
          Toast.makeText(BaseApplicationImpl.getApplication(), ((File)localObject2).getName() + alpo.a(2131714206), 0).show();
          if (!this.jdField_b_of_type_Boolean) {
            a();
          }
          return;
        }
        if (((File)localObject2).length() == 0L)
        {
          if (this.jdField_c_of_type_Int == 0) {
            Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692613), 0).show();
          }
        }
        else
        {
          a(localadsk, this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695323), 0).show();
      continue;
      label261:
      if (this.jdField_a_of_type_Bdfq != null) {
        this.jdField_a_of_type_Bdfq.cancel();
      }
      c();
    }
  }
  
  public void a(adsk paramadsk, int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.getFileThreadHandler().post(new SendMultiPictureHelper.7(this, paramadsk, paramInt, paramString1, paramString2));
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle, ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Baua);
    this.jdField_a_of_type_Baua.addFilter(new Class[] { banc.class, bang.class, bapa.class, baom.class });
    this.jdField_a_of_type_Bdfq = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691099), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
    this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bdfq.setCancelable(false);
    this.jdField_a_of_type_Bdfq.show();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramString1 = paramArrayList.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (String)paramString1.next();
      paramString3 = new adsk(this);
      paramString3.jdField_a_of_type_JavaLangString = paramString2;
      paramString3.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString3);
    }
    paramString1 = ((adsk)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
    this.jdField_a_of_type_Adsk = ((adsk)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    this.jdField_a_of_type_Int = 0;
    if (!bdee.d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_Bdfq.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
        a((adsk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
        paramInt += 1;
      }
      c();
      return;
    }
    this.jdField_a_of_type_Bdfq.setMessage(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(0) }));
    if (new File(paramString1).length() == 0L)
    {
      if (this.jdField_c_of_type_Int != 0) {
        break label521;
      }
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692613), 0).show();
    }
    for (;;)
    {
      a((adsk)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new adsj(this);
      }
      AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
      return;
      label521:
      Toast.makeText(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695323), 0).show();
    }
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691101);
    localObject = bdcd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720796), (String)localObject, 2131693165, 2131694804, this.jdField_c_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
    ((bdfq)localObject).setCancelable(false);
    ((bdfq)localObject).show();
  }
  
  public void c()
  {
    Intent localIntent = aekt.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class), new int[] { 2 });
    localIntent.putExtra("isFromShare", true);
    localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Baua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_Aqnl);
    try
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      label35:
      this.jdField_a_of_type_Bdfq = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsd
 * JD-Core Version:    0.7.0.1
 */