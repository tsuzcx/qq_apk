import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class alnr
{
  private List<alnt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static alnr a()
  {
    return alnu.a();
  }
  
  public List<alnt> a()
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
    yej.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    tld.a().a();
    atpw.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((alnt)localIterator.next()).b();
    }
  }
  
  public void a(alnt paramalnt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramalnt);
      return;
    }
    finally
    {
      paramalnt = finally;
      throw paramalnt;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (zdi.b <= 0L)
    {
      zdi.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(zdi.b) });
    }
    atpw.a();
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
        ((alnt)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      yej.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      yej.a().a(paramString);
    }
  }
  
  public void b(alnt paramalnt)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramalnt);
      return;
    }
    finally
    {
      paramalnt = finally;
      throw paramalnt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alnr
 * JD-Core Version:    0.7.0.1
 */