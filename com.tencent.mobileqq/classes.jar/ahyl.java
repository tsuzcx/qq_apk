import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;

public class ahyl
  extends aruk
{
  public ahyl(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131365851) {
      ChatHistoryBaseTenDocFragment.a(this.a);
    }
    while ((paramView.getTag() instanceof String)) {
      return;
    }
    TencentDocItem localTencentDocItem = ((ahyi)paramView.getTag()).a;
    if (this.a.c)
    {
      this.a.jdField_a_of_type_Aidt.a(localTencentDocItem);
      ChatHistoryBaseTenDocFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    paramView = "unknown";
    if (arbq.b(localTencentDocItem.mUrl)) {
      paramView = "doc";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", localTencentDocItem.mUrl);
      localBundle.putString("tdsourcetag", "s_qq_history_tab");
      localBundle.putString("tdsourcetype", paramView + ChatHistoryBaseTenDocFragment.a(this.a));
      TeamWorkDocEditBrowserActivity.a(ChatHistoryBaseTenDocFragment.a(this.a), localBundle, false);
      azqs.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A16B", "0X800A16B", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", paramView);
      return;
      if (arbq.e(localTencentDocItem.mUrl)) {
        paramView = "form";
      } else if (arbq.d(localTencentDocItem.mUrl)) {
        paramView = "ppt";
      } else if (arbq.c(localTencentDocItem.mUrl)) {
        paramView = "sheet";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyl
 * JD-Core Version:    0.7.0.1
 */