import com.tencent.mobileqq.activity.ProfileActivity;
import mqq.app.QQPermissionCallback;

class aifv
  implements QQPermissionCallback
{
  aifv(aift paramaift) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifv
 * JD-Core Version:    0.7.0.1
 */