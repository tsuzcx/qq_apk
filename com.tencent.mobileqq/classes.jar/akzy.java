import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.util.ArrayList;

class akzy
  implements bgso
{
  akzy(akzp paramakzp) {}
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if ((QLog.isColorLevel()) && (paramArrayList != null)) {
      QLog.i("ark.download.module", 2, "onQueryCallback:" + paramArrayList.toString());
    }
    if (akzp.a(this.a) != null)
    {
      yez.a(paramArrayList);
      akzp.a(this.a).a(paramArrayList);
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if ((QLog.isColorLevel()) && (paramArrayList != null)) {
      QLog.i("ark.download.module", 2, "onQueryCallbackVia:" + paramArrayList.toString());
    }
    if (akzp.a(this.a) != null)
    {
      yez.a(paramArrayList);
      akzp.a(this.a).a(paramArrayList);
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if (akzp.a(this.a) != null)
    {
      yez.a(paramWadlResult);
      akzp.a(this.a).a(paramWadlResult);
      if (paramWadlResult != null) {}
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ark.download.module", 2, "onWadlTaskStatusChanged:" + paramWadlResult.toString());
    }
    if (paramWadlResult.a != null) {}
    for (String str = paramWadlResult.a.a;; str = "") {
      switch (paramWadlResult.b)
      {
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        return;
      case 6: 
        awqx.a(null, "dc00898", "", "", "0X8009E14", "0X8009E14", 0, 0, "", "", str, "");
        return;
      }
    }
    awqx.a(null, "dc00898", "", "", "0X8009E15", "0X8009E15", 0, 0, "", "", str, "");
    return;
    awqx.a(null, "dc00898", "", "", "0X8009E17", "0X8009E17", 0, 0, "", "", str, "");
    return;
    awqx.a(null, "dc00898", "", "", "0X8009E18", "0X8009E18", 0, 0, "", "", str, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akzy
 * JD-Core Version:    0.7.0.1
 */