import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class aaaj
  extends AsyncTask<Void, Void, Void>
{
  aaaj(aaai paramaaai) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = aaai.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    aaai.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaj
 * JD-Core Version:    0.7.0.1
 */