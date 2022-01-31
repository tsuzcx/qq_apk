import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class akuh
  implements ValueCallback<String>
{
  akuh(akug paramakug) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJSContext", 2, "[onReceiveValue] s " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akuh
 * JD-Core Version:    0.7.0.1
 */