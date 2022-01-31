import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;

public class akie
{
  private int a;
  private int b;
  
  public akie(QQAppInterface paramQQAppInterface)
  {
    TroopManager.a(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    String str;
    if (paramEditText != null)
    {
      str = "";
      if (paramInt != 0) {
        break label166;
      }
      this.a = ((int)(Math.random() * TroopManager.c.size()));
      if (TroopManager.c.size() != 1) {
        break label124;
      }
      str = (String)TroopManager.c.get(0);
      TroopManager.a(paramQQAppInterface);
    }
    label166:
    for (;;)
    {
      Object localObject = (ajxl)paramQQAppInterface.getManager(51);
      localObject = bbcz.h(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      paramEditText.setText(bafv.a(paramQQAppInterface, paramContext, paramString, paramChatMessage.senderuin, (String)localObject, false, paramEditText, true, true));
      paramEditText.append(str);
      paramEditText.setSelection(paramEditText.getText().length());
      return;
      label124:
      if (this.a < TroopManager.c.size())
      {
        str = (String)TroopManager.c.get(this.a);
        TroopManager.c.remove(this.a);
        continue;
        if (this.b < TroopManager.d.size())
        {
          str = (String)TroopManager.d.get(this.b);
          this.b = ((this.b + 1) % TroopManager.d.size());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akie
 * JD-Core Version:    0.7.0.1
 */