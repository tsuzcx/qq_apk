import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfigManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class ahfq
  implements Manager
{
  private long jdField_a_of_type_Long;
  private ahfp jdField_a_of_type_Ahfp;
  private Context jdField_a_of_type_AndroidContentContext;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public ahfq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_Ahfp = new ahfp(paramQQAppInterface);
  }
  
  private void a(SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig paramHtmlOfflineCheckConfig, int paramInt1, int paramInt2)
  {
    if (paramHtmlOfflineCheckConfig == null) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "config is empty, not process!!!");
        }
        return;
      }
      finally {}
      Object localObject = paramHtmlOfflineCheckConfig.bids;
      if (bbjw.a((String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "bids is empty, not process!!!");
        }
      }
      else
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length > 0))
        {
          paramInt2 = localObject.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            String str = localObject[paramInt1];
            if (!a(str))
            {
              if (QLog.isColorLevel()) {
                QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "should not check offline package!!!");
              }
            }
            else
            {
              int i = bbjn.e(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), str);
              if (i >= paramHtmlOfflineCheckConfig.total_cnt)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "already bigger than total cnt!!!");
                }
              }
              else
              {
                long l = bbjn.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), str);
                if (Math.abs(NetConnInfoCenter.getServerTimeMillis() - l) < paramHtmlOfflineCheckConfig.time_interval * 60 * 60 * 1000)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "time interval not bigger than time interval in config!!!");
                  }
                }
                else if (!ahfn.a(this.jdField_a_of_type_AndroidContentContext, paramHtmlOfflineCheckConfig.net_type))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "current network is not allow download!!!");
                  }
                }
                else {
                  mze.b(str, this.jdField_a_of_type_ComTencentCommonAppAppInterface, new ahfr(this, str, i), true, 0, true);
                }
              }
            }
            paramInt1 += 1;
          }
        }
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_Ahfp != null) {
      i = this.jdField_a_of_type_Ahfp.a();
    }
    return i;
  }
  
  public SpringFestivalRedpacketConfBean a()
  {
    if (this.jdField_a_of_type_Ahfp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringFestivalRedpacketConfigManager", 2, "getSpringFestivalRedpacketConfBean mEntryConfigProcessor is empty!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ahfp.a();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new SpringFestivalRedpacketConfigManager.1(this), 16, null, true);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_AndroidContentContext, ahft.class);
      localNewIntent.putExtra("k_cmd", 1);
      localNewIntent.putExtra("k_req_occasion", paramInt1);
      localNewIntent.putExtra("k_offset", paramInt3);
      localNewIntent.putExtra("k_id", paramInt4);
      localNewIntent.putExtra("k_version", paramInt2);
      localNewIntent.putExtra("k_cookie", paramArrayOfByte1);
      localNewIntent.putExtra("k_buff", paramArrayOfByte2);
      if (paramInt3 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localNewIntent.putExtra("k_new_page", bool);
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
        return;
      }
      return;
    }
    catch (Exception paramArrayOfByte1)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfigManager", 1, "getEntryConfig fail.", paramArrayOfByte1);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfigByPush app=%s pushVersion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt) }));
    }
    if ((paramQQAppInterface != null) && (paramInt >= 0)) {
      try
      {
        if (this.jdField_a_of_type_Ahfp != null)
        {
          int i = this.jdField_a_of_type_Ahfp.a();
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfigByPush app=%s localVersion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(i) }));
          }
          if (i != paramInt)
          {
            b(paramQQAppInterface, 2);
            return;
          }
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, "getEntryConfigByPush push version is same as local.");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("springHb_SpringFestivalRedpacketConfigManager", 1, "getEntryConfigByPush fail.", paramQQAppInterface);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = true;
    if (bbjw.a(paramString)) {
      return false;
    }
    boolean bool2 = ahfn.a(paramString);
    int i;
    if (bool2)
    {
      i = 0;
      ahic.a(paramString, i, 0);
      if (bool2) {
        break label42;
      }
    }
    for (;;)
    {
      return bool1;
      i = 1;
      break;
      label42:
      bool1 = false;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, List<Integer> paramList, int paramInt3)
  {
    try
    {
      if (this.jdField_a_of_type_Ahfp != null)
      {
        paramBoolean = this.jdField_a_of_type_Ahfp.a(paramBoolean, paramInt1, paramInt2, paramString, paramList, paramInt3);
        return paramBoolean;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("springHb_SpringFestivalRedpacketConfigManager", 1, paramString, new Object[0]);
    }
    return true;
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_Ahfp != null) {
      i = this.jdField_a_of_type_Ahfp.b();
    }
    return i;
  }
  
  public void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = false;
    QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig app=%s reqOccasion=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt) }));
    if (paramQQAppInterface != null)
    {
      if (paramInt == 1) {}
      try
      {
        long l = NetConnInfoCenter.getServerTimeMillis();
        if (Math.abs(l - this.jdField_a_of_type_Long) <= 3600000L) {}
        for (;;)
        {
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig needReq=%s", new Object[] { Boolean.valueOf(bool) }));
          if (!bool) {
            break;
          }
          int i = a();
          QLog.i("springHb_SpringFestivalRedpacketConfigManager", 1, String.format("getEntryConfig localVersion=%s", new Object[] { Integer.valueOf(i) }));
          a(paramInt, i, 0, 0, null, null);
          return;
          this.jdField_a_of_type_Long = l;
          bool = true;
        }
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("springHb_SpringFestivalRedpacketConfigManager", 1, "getEntryConfig fail.", paramQQAppInterface);
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfq
 * JD-Core Version:    0.7.0.1
 */