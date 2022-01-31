import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;

public class afkh
  extends apfd
{
  public afkh(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131300167) {
      ChatHistoryBaseTenDocFragment.a(this.a);
    }
    while ((paramView.getTag() instanceof String)) {
      return;
    }
    TencentDocItem localTencentDocItem = ((afke)paramView.getTag()).a;
    if (this.a.c)
    {
      this.a.jdField_a_of_type_Afpf.a(localTencentDocItem);
      ChatHistoryBaseTenDocFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    paramView = "unknown";
    if (aonk.b(localTencentDocItem.mUrl)) {
      paramView = "doc";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", localTencentDocItem.mUrl);
      localBundle.putString("tdsourcetag", "s_qq_history_tab");
      localBundle.putString("tdsourcetype", paramView + ChatHistoryBaseTenDocFragment.a(this.a));
      TeamWorkDocEditBrowserActivity.a(ChatHistoryBaseTenDocFragment.a(this.a), localBundle, false);
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A16B", "0X800A16B", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", paramView);
      return;
      if (aonk.e(localTencentDocItem.mUrl)) {
        paramView = "form";
      } else if (aonk.d(localTencentDocItem.mUrl)) {
        paramView = "ppt";
      } else if (aonk.c(localTencentDocItem.mUrl)) {
        paramView = "sheet";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afkh
 * JD-Core Version:    0.7.0.1
 */