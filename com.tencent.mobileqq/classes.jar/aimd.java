import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;

public final class aimd
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.findViewById(2131361855);
    if (localObject2 == null) {}
    for (;;)
    {
      return;
      Object localObject1 = ((View)localObject2).getTag(2131361855);
      if ((localObject1 != null) && ((localObject1 instanceof StructMsgForAudioShare)))
      {
        localObject1 = (StructMsgForAudioShare)localObject1;
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof StructingMsgItemBuilder.StructingMsgViewHolder)))
        {
          paramView = (StructingMsgItemBuilder.StructingMsgViewHolder)paramView;
          localObject2 = ((View)localObject2).getContext();
        }
      }
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(((StructMsgForAudioShare)localObject1).currentAccountUin);
        if (((StructMsgForAudioShare)localObject1).msgId > 0L)
        {
          ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((StructMsgForAudioShare)localObject1).uin, "mp_msg_msgpic_click", "aio_morpic_click", 0, 0, "", "", Long.toString(((StructMsgForAudioShare)localObject1).msgId), "");
          ThreadManager.getSubThreadHandler().postDelayed(new aime(this, (StructMsgForAudioShare)localObject1, localQQAppInterface), 0L);
          AbsShareMsg.doReport(localQQAppInterface, (AbsShareMsg)localObject1);
          if (localQQAppInterface == null) {
            continue;
          }
          Util.a(localQQAppInterface, "", "click", ((StructMsgForAudioShare)localObject1).mSourceAppid, ((StructMsgForAudioShare)localObject1).mMsgServiceID, Util.a(paramView.a.a));
          MediaPlayerManager.a(localQQAppInterface).a(true);
        }
      }
      catch (AccountNotMatchException paramView)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, paramView.getStackTrace().toString());
          }
        }
      }
    }
    ReportController.b(null, "CliOper", "", "", "0X800567A", "0X800567A", 0, 0, ((StructMsgForAudioShare)localObject1).mMsgServiceID + "", "", "", "");
    ReportController.b(null, "CliOper", "", "", "0X8004B5C", "0X8004B5C", 1, 0, "", "", "", "");
    StructMsgForAudioShare.onClickEvent((Context)localObject2, (StructMsgForAudioShare)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimd
 * JD-Core Version:    0.7.0.1
 */