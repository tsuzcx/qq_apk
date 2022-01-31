import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class alsg
{
  private List<alsi> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static alsg a()
  {
    return alsj.a();
  }
  
  public List<alsi> a()
  {
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    yiw.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    tld.a().a();
    atuf.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((alsi)localIterator.next()).b();
    }
  }
  
  public void a(alsi paramalsi)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramalsi);
      return;
    }
    finally
    {
      paramalsi = finally;
      throw paramalsi;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (zhx.b <= 0L)
    {
      zhx.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(zhx.b) });
    }
    atuf.a();
    if ((TextUtils.equals("com.tencent.mobileqq:qzone", paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("mini")))) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext()) {
        ((alsi)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      yiw.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      yiw.a().a(paramString);
    }
  }
  
  public void b(alsi paramalsi)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalsi);
      return;
    }
    finally
    {
      paramalsi = finally;
      throw paramalsi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsg
 * JD-Core Version:    0.7.0.1
 */