import com.tencent.qphone.base.util.QLog;

class alxb
  extends bead
{
  alxb(alxa paramalxa) {}
  
  public void onDone(beae parambeae)
  {
    super.onDone(parambeae);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambeae.f + ", url: " + parambeae.a);
    }
    int i = parambeae.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambeae.a;
      if (!alwz.a.contains(str)) {
        break label105;
      }
      this.a.a(parambeae);
    }
    label105:
    do
    {
      return;
      str = parambeae.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambeae);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambeae.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alxb
 * JD-Core Version:    0.7.0.1
 */