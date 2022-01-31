import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40.1;

public class afoj
  extends ajhi
{
  public afoj(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong1, Long paramLong2)
  {
    if (paramBoolean)
    {
      awqx.b(this.a.b, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_Afow != null) {
        this.a.jdField_a_of_type_Afow.a();
      }
      if (this.a.k)
      {
        this.a.d(paramLong2 + "");
        if (this.a.jdField_a_of_type_Afoy != null) {
          this.a.jdField_a_of_type_Afoy.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      return;
      bbmy.a(this.a.getActivity(), 1, this.a.getString(2131628069), 0).b(this.a.getActivity().getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3)
  {
    this.a.getActivity().runOnUiThread(new ChatHistoryTroopMemberFragment.40.1(this, paramBoolean1, paramString, paramBoolean2, paramInt1, paramInt2, paramBoolean3));
  }
  
  protected void b(boolean paramBoolean, Long paramLong)
  {
    if (this.a.c != null) {
      this.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afoj
 * JD-Core Version:    0.7.0.1
 */