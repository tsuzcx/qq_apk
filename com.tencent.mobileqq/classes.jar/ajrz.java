import android.os.Bundle;

class ajrz
  extends ajxj
{
  ajrz(ajry paramajry) {}
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(1, paramString);
    }
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean) {
      this.a.a(1, paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      this.a.a(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajrz
 * JD-Core Version:    0.7.0.1
 */