import com.tencent.mobileqq.activity.SearchFriendListActivity;

public class aevo
  extends anvi
{
  public aevo(SearchFriendListActivity paramSearchFriendListActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null)) {
      SearchFriendListActivity.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevo
 * JD-Core Version:    0.7.0.1
 */