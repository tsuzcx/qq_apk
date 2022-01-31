import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class aiyi
  implements ValueCallback<String>
{
  aiyi(aiyh paramaiyh) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloJSContext", 2, "[onReceiveValue] s " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyi
 * JD-Core Version:    0.7.0.1
 */