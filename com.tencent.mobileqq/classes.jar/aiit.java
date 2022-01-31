import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;
import java.util.List;

public class aiit
  extends ahai
{
  public aiit(HotChatCenterFragment paramHotChatCenterFragment, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, ahab paramahab, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramahab, paramInt);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloActivityHotChatCenterFragment.a(paramRecentBaseData, paramString);
  }
  
  public void b(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramRecentBaseData);
      notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiit
 * JD-Core Version:    0.7.0.1
 */