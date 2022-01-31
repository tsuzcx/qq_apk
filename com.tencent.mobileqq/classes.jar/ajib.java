import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ajib
{
  private List<ajid> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static ajib a()
  {
    return ajie.a();
  }
  
  public List<ajid> a()
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
    wcj.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    saf.a().a();
    ardg.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ajid)localIterator.next()).b();
    }
  }
  
  public void a(ajid paramajid)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramajid);
      return;
    }
    finally
    {
      paramajid = finally;
      throw paramajid;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (xfs.b <= 0L)
    {
      xfs.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(xfs.b) });
    }
    ardg.a();
    if (TextUtils.equals("com.tencent.mobileqq:qzone", paramString)) {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
      paramString = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString.hasNext()) {
        ((ajid)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      wcj.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      wcj.a().a(paramString);
    }
  }
  
  public void b(ajid paramajid)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajid);
      return;
    }
    finally
    {
      paramajid = finally;
      throw paramajid;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajib
 * JD-Core Version:    0.7.0.1
 */