import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class adkp
  implements AsyncBack
{
  adkp(adko paramadko) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MonitorConfig", 2, "3136 offline loaded param:" + paramString + " code:" + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adkp
 * JD-Core Version:    0.7.0.1
 */