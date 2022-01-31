import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class ailp
  implements ValueCallback<String>
{
  ailp(ailo paramailo) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJSContext", 2, "[onReceiveValue] s " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ailp
 * JD-Core Version:    0.7.0.1
 */