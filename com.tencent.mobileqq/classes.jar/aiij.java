import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgItemLive;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;

public class aiij
  implements View.OnClickListener
{
  public aiij(StructMsgItemLive paramStructMsgItemLive) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((!TextUtils.isEmpty(this.a.a.mMsgActionData)) && (this.a.a.mMsgActionData.startsWith("story:"))) {
      localObject1 = this.a.a.mMsgActionData.substring("story:".length(), this.a.a.mMsgActionData.length() - 1);
    }
    for (int i = 1;; i = 2)
    {
      JumpParser.a(localQQAppInterface, paramView.getContext(), (String)localObject1).b();
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgQ.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "actionType:" + i + "|uri:" + (String)localObject1);
      }
      return;
      localObject1 = "0";
      localObject2 = "-1";
      String[] arrayOfString1 = this.a.w.substring(this.a.w.indexOf("?") + 1).split("&");
      i = 0;
      while (i < arrayOfString1.length)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("=");
        localObject5 = localObject2;
        Object localObject3 = localObject1;
        if (arrayOfString2.length == 2)
        {
          if ("roomid".equals(arrayOfString2[0])) {
            localObject1 = arrayOfString2[1];
          }
          localObject5 = localObject2;
          localObject3 = localObject1;
        }
        try
        {
          if ("from".equals(arrayOfString2[0]))
          {
            localObject5 = arrayOfString2[1];
            localObject3 = localObject1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            localObject5 = localObject2;
            Object localObject4 = localObject1;
          }
        }
        i += 1;
        localObject2 = localObject5;
        localObject1 = localObject3;
      }
      localObject1 = String.format("mqqapi://now/openroom?src_type=app&version=1&roomid=%s&fromid=%s", new Object[] { localObject1, localObject2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiij
 * JD-Core Version:    0.7.0.1
 */