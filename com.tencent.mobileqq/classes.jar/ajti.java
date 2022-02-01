import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.40.1;
import com.tencent.mobileqq.widget.QQToast;

public class ajti
  extends ankx
{
  public ajti(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
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
      bcst.b(this.a.b, "CliOper", "", "", "0X80040F5", "0X80040F5", 0, 0, "", "", "", "");
      this.a.a(paramLong2 + "");
      if (this.a.jdField_a_of_type_Ajtv != null) {
        this.a.jdField_a_of_type_Ajtv.a();
      }
      if (this.a.k)
      {
        this.a.d(paramLong2 + "");
        if (this.a.jdField_a_of_type_Ajtx != null) {
          this.a.jdField_a_of_type_Ajtx.notifyDataSetChanged();
        }
      }
    }
    for (;;)
    {
      if (this.a.c != null) {
        this.a.c.dismiss();
      }
      return;
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131693171), 0).b(this.a.getActivity().getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajti
 * JD-Core Version:    0.7.0.1
 */