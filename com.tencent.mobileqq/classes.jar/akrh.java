import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class akrh
  implements QQPermissionCallback
{
  akrh(akrc paramakrc) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new akrk();
    paramArrayOfString.a = 2;
    aksc.a(this.a.a.recognitions, akrc.a(this.a), paramArrayOfString);
    if (akrc.a(this.a) != null) {
      akrc.a(this.a).a(0, akrc.a(this.a));
    }
    akrc.a(this.a, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akrh
 * JD-Core Version:    0.7.0.1
 */