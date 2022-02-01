import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

public class afly
  extends anvi
{
  public afly(ActivateFriendGrid paramActivateFriendGrid) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      if (i < ActivateFriendGrid.a(this.a).size())
      {
        String str = String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin);
        if (paramString.equals(str))
        {
          paramString = ContactUtils.getBuddyName(ActivateFriendGrid.a(this.a), str, false);
          ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setNickName(paramString);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    while (i < ActivateFriendGrid.a(this.a).size())
    {
      String str = ContactUtils.getFriendDisplayName(ActivateFriendGrid.a(this.a), String.valueOf(((ActivateFriendItem)ActivateFriendGrid.a(this.a).get(i)).uin));
      ((ActivateFriendGridItem)ActivateFriendGrid.b(this.a).get(i)).setNickName(str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afly
 * JD-Core Version:    0.7.0.1
 */