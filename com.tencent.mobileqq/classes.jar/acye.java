import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class acye
  extends AsyncTask<Void, Void, Void>
{
  acye(acyd paramacyd) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = acyd.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    acyd.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acye
 * JD-Core Version:    0.7.0.1
 */