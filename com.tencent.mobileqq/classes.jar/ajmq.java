import com.tencent.qphone.base.util.QLog;

class ajmq
  extends batl
{
  ajmq(ajmp paramajmp) {}
  
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambatm.f + ", url: " + parambatm.a);
    }
    int i = parambatm.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambatm.a;
      if (!ajmo.a.contains(str)) {
        break label105;
      }
      this.a.a(parambatm);
    }
    label105:
    do
    {
      return;
      str = parambatm.a.substring(0, i - 1);
      break;
      if ("http://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambatm);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambatm.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajmq
 * JD-Core Version:    0.7.0.1
 */