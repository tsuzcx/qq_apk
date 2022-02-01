import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40.1;
import com.tencent.mobileqq.widget.QQToast;

public class ajvg
  extends antq
{
  public ajvg(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void onCollectDiscussion(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
  
  protected void onGetDiscAtAllRemianCount(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.40.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void onKickoutDiscussionMember(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      bdla.b(this.a.b, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_Ajvt != null) {
        this.a.jdField_a_of_type_Ajvt.a();
      }
      if (this.a.k)
      {
        this.a.d(paramLong2 + "");
        if (this.a.jdField_a_of_type_Ajvv != null) {
          this.a.jdField_a_of_type_Ajvv.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      return;
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131693426), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
  
  protected void onUncollectDiscussion(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvg
 * JD-Core Version:    0.7.0.1
 */