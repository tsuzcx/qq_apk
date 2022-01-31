import com.tencent.qphone.base.util.QLog;

class akax
  extends bbwt
{
  akax(akaw paramakaw) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambbwu.f + ", url: " + parambbwu.a);
    }
    int i = parambbwu.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambbwu.a;
      if (!akav.a.contains(str)) {
        break label105;
      }
      this.a.a(parambbwu);
    }
    label105:
    do
    {
      return;
      str = parambbwu.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambbwu);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambbwu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akax
 * JD-Core Version:    0.7.0.1
 */