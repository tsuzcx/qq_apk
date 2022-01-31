import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ajwd
{
  private List<ajwf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public static ajwd a()
  {
    return ajwg.a();
  }
  
  public List<ajwf> a()
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
    wpt.a().a(new ForeBackgroundEvent(true));
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    smy.a().a();
    arza.b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ajwf)localIterator.next()).b();
    }
  }
  
  public void a(ajwf paramajwf)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramajwf);
      return;
    }
    finally
    {
      paramajwf = finally;
      throw paramajwf;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppForeground: invoked. " + paramString);
    }
    if (xop.b <= 0L)
    {
      xop.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(xop.b) });
    }
    arza.a();
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
        ((ajwf)paramString.next()).a();
      }
      paramString = new ForeBackgroundEvent(false);
      wpt.a().a(paramString);
      continue;
      paramString = new ForeBackgroundEvent(false);
      wpt.a().a(paramString);
    }
  }
  
  public void b(ajwf paramajwf)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramajwf);
      return;
    }
    finally
    {
      paramajwf = finally;
      throw paramajwf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwd
 * JD-Core Version:    0.7.0.1
 */