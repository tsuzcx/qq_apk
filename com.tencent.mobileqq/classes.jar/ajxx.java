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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajxx
  implements View.OnClickListener
{
  ajxx(ajxt paramajxt) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onClick, id = " + i);
    }
    switch (i)
    {
    default: 
    case 2131365147: 
    case 2131367027: 
      do
      {
        do
        {
          for (;;)
          {
            EventCollector.getInstance().onViewClicked(paramView);
            return;
            if (this.a.jdField_a_of_type_Ajyc != null) {
              ((ClipboardManager)this.a.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_Ajyc.a.msg);
            }
          }
        } while (this.a.jdField_a_of_type_Ajyc == null);
        localObject1 = this.a.jdField_a_of_type_Ajyc.a;
      } while (!(localObject1 instanceof MessageForText));
    }
    Object localObject2;
    for (Object localObject1 = (MessageForText)localObject1;; localObject2 = null)
    {
      try
      {
        localObject1 = bend.a(((MessageForText)localObject1).msgData);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = (TroopLinkElement)localObject1;
        Object localObject3 = new Bundle();
        if (localObject1 != null)
        {
          ((Bundle)localObject3).putString("image_url_remote", ((TroopLinkElement)localObject1).url);
          ((Bundle)localObject3).putString("detail_url", ((TroopLinkElement)localObject1).iconUrl);
          ((Bundle)localObject3).putString("title", ((TroopLinkElement)localObject1).title);
          ((Bundle)localObject3).putString("desc", ((TroopLinkElement)localObject1).title);
          ((Bundle)localObject3).putString("req_create_time", ((TroopLinkElement)localObject1).timeSecond);
        }
        localObject1 = bcwd.a((Bundle)localObject3);
        localObject3 = new Intent();
        ((Intent)localObject3).putExtra("forward_type", -3);
        ((Intent)localObject3).putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject1).getBytes());
        aufz.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Intent)localObject3, 21);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "OnClickListener, setMessageItems");
      }
      this.a.c = false;
      ajxt.a(this.a).setVisibility(8);
      ajxt.a(this.a, 0, null);
      this.a.jdField_a_of_type_Ajuu.a(ajxt.a(this.a), this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_Ajuu.notifyDataSetChanged();
      this.a.b = 1;
      break;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */