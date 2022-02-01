import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class adld
  extends AsyncTask<Void, Void, Void>
{
  adld(adlc paramadlc) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = adlc.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    adlc.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adld
 * JD-Core Version:    0.7.0.1
 */