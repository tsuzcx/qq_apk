import com.tencent.qphone.base.util.QLog;

class alsm
  extends bdvu
{
  alsm(alsl paramalsl) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambdvv.f + ", url: " + parambdvv.a);
    }
    int i = parambdvv.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambdvv.a;
      if (!alsk.a.contains(str)) {
        break label105;
      }
      this.a.a(parambdvv);
    }
    label105:
    do
    {
      return;
      str = parambdvv.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambdvv);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambdvv.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alsm
 * JD-Core Version:    0.7.0.1
 */