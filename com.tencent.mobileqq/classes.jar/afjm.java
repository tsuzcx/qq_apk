import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import java.util.List;

public class afjm
  extends anvi
{
  public afjm(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
      return;
    }
    this.a.a(2131718554, 1);
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if (paramBoolean)
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.a(2131691434, 2);
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean3))
    {
      UncommonlyUsedContactsActivity.a(this.a);
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjm
 * JD-Core Version:    0.7.0.1
 */