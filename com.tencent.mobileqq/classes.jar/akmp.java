import com.tencent.mobileqq.activity.ProfileActivity;
import mqq.app.QQPermissionCallback;

class akmp
  implements QQPermissionCallback
{
  akmp(akmn paramakmn) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a.a = ProfileActivity.a(this.a.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmp
 * JD-Core Version:    0.7.0.1
 */