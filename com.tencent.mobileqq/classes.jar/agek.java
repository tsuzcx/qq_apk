import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;

class agek
  implements View.OnClickListener
{
  agek(ageg paramageg) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    default: 
    case 2131364824: 
    case 2131366632: 
      do
      {
        do
        {
          do
          {
            return;
          } while (this.a.jdField_a_of_type_Agep == null);
          ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Agep.a.msg);
          return;
        } while (this.a.jdField_a_of_type_Agep == null);
        paramView = this.a.jdField_a_of_type_Agep.a;
      } while (!(paramView instanceof MessageForText));
    }
    for (paramView = (MessageForText)paramView;; paramView = null)
    {
      try
      {
        paramView = azjx.a(paramView.msgData);
        if (paramView == null) {
          continue;
        }
        paramView = (TroopLinkElement)paramView;
        Object localObject = new Bundle();
        if (paramView != null)
        {
          ((Bundle)localObject).putString("image_url_remote", paramView.url);
          ((Bundle)localObject).putString("detail_url", paramView.iconUrl);
          ((Bundle)localObject).putString("title", paramView.title);
          ((Bundle)localObject).putString("desc", paramView.title);
          ((Bundle)localObject).putString("req_create_time", paramView.timeSecond);
        }
        paramView = axva.a((Bundle)localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("forward_type", -3);
        ((Intent)localObject).putExtra("stuctmsg_bytes", paramView.getBytes());
        aqbe.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
        return;
      }
      catch (Exception paramView)
      {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      this.a.c = false;
      ageg.a(this.a).setVisibility(8);
      ageg.a(this.a, 0, null);
      this.a.jdField_a_of_type_Agbo.a(ageg.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_Agbo.notifyDataSetChanged();
      this.a.b = 1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agek
 * JD-Core Version:    0.7.0.1
 */