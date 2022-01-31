import com.tencent.qphone.base.util.QLog;

class akaz
  extends bbwf
{
  akaz(akay paramakay) {}
  
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambbwg.f + ", url: " + parambbwg.a);
    }
    int i = parambbwg.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambbwg.a;
      if (!akax.a.contains(str)) {
        break label105;
      }
      this.a.a(parambbwg);
    }
    label105:
    do
    {
      return;
      str = parambbwg.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambbwg);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambbwg.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akaz
 * JD-Core Version:    0.7.0.1
 */