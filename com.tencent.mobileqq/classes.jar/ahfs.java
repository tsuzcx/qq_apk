import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class ahfs
  implements Manager
{
  private ahfq jdField_a_of_type_Ahfq;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahfs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ahfq = ((ahfq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(341));
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject1 instanceof QQAppInterface));
    Object localObject1 = (ahfs)((QQAppInterface)localObject1).getManager(343);
    if ((localObject1 == null) || (((ahfs)localObject1).a() == null))
    {
      localObject1 = null;
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = "https://i.qianbao.qq.com/2020-hebao/";
      }
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!paramString.startsWith((String)localObject2))) {
        break label92;
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      localObject1 = ((ahfs)localObject1).a().activityPrefix;
      break;
    }
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((bbjw.a(paramString)) || (paramString.length() < 2) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str1 = (String)paramArrayList.next();
      if ((!bbjw.a(str1)) && (str1.length() >= 2))
      {
        str1 = str1.substring(0, 2);
        String str2 = paramString.substring(0, 2);
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "currFirtstTwoChar: " + str1 + " firstTwoChar: " + str2);
        }
        if (str1.equals(str2)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Ahfq != null) {
      return this.jdField_a_of_type_Ahfq.b();
    }
    return 0;
  }
  
  public long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong <= 0L) {
      l = 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (paramLong = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();; paramLong = 0L)
    {
      Object localObject = (ahfx)ampm.a().a(540);
      if ((localObject == null) || (((ahfx)localObject).jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat == null) || (((ahfx)localObject).jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.size() == 0))
      {
        paramLong = l % 60000 + (int)(paramLong % 13L) * 60 * 1000;
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "not find config, so return default finalDelay:" + paramLong);
        }
        return paramLong;
      }
      int i = ((ahfx)localObject).jdField_a_of_type_Int;
      int j = i;
      if (i <= 0) {
        j = 60;
      }
      SparseArrayCompat localSparseArrayCompat = ((ahfx)localObject).jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat;
      int k = (int)(paramLong % localSparseArrayCompat.size());
      String str;
      try
      {
        localObject = akug.b();
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "getDelayBeginTime adcode: " + (String)localObject);
        }
        if (bbjw.a((String)localObject))
        {
          ahic.a(0);
          k = j * k * 1000;
          i = k;
          if (QLog.isColorLevel())
          {
            QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "can't get current user's adcode , so return randon region time interval: " + k);
            i = k;
          }
          paramLong = l % (j * 1000) + i;
          if (QLog.isColorLevel()) {
            QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "current adcode :" + (String)localObject + " time interval: " + j * 1000 + ",configDelay:" + l + ",adDelay:" + i + ",finalDelay:" + paramLong);
          }
          return paramLong;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("springHb_SpringFestivalRedpacketConfigProvider", 1, localException, new Object[0]);
          ahic.a(1);
          str = null;
        }
        i = 0;
      }
      if (i < localSparseArrayCompat.size())
      {
        ArrayList localArrayList = (ArrayList)localSparseArrayCompat.get(i);
        if ((localArrayList == null) || (localArrayList.isEmpty())) {}
        while (!a(str, localArrayList))
        {
          i += 1;
          break;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("springHb_SpringFestivalRedpacketConfigProvider", 2, "matchRegionIndex: " + i);
        }
        i = j * i * 1000;
        break;
        i = k;
      }
    }
  }
  
  public SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig a()
  {
    if (this.jdField_a_of_type_Ahfq != null)
    {
      SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = this.jdField_a_of_type_Ahfq.a();
      if (localSpringFestivalRedpacketConfBean != null) {
        return localSpringFestivalRedpacketConfBean.htmlOfflineCheckConfig;
      }
    }
    return null;
  }
  
  public SpringFestivalRedpacketConfBean.SpringFestivalHbEntryInfo a()
  {
    if (this.jdField_a_of_type_Ahfq != null)
    {
      SpringFestivalRedpacketConfBean localSpringFestivalRedpacketConfBean = this.jdField_a_of_type_Ahfq.a();
      if (localSpringFestivalRedpacketConfBean != null) {
        return localSpringFestivalRedpacketConfBean.springFestivalHbEntryInfo;
      }
    }
    return null;
  }
  
  public SpringFestivalRedpakcetPreviewConfBean a()
  {
    return (SpringFestivalRedpakcetPreviewConfBean)ampm.a().a(548);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Ahfq != null)
    {
      Object localObject = this.jdField_a_of_type_Ahfq.a();
      if (localObject != null)
      {
        localObject = ((SpringFestivalRedpacketConfBean)localObject).htmlOfflineCheckConfig;
        if (localObject != null) {
          return ((SpringFestivalRedpacketConfBean.HtmlOfflineCheckConfig)localObject).checkDomain;
        }
      }
    }
    return "";
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Ahfq != null) {
      return this.jdField_a_of_type_Ahfq.a();
    }
    return -1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */