import android.text.TextUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleChatUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import qqcircle.QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp;

class aifp
  implements VSDispatchObserver.onVSRspCallBack<QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp>
{
  aifp(aifl paramaifl) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCirclePrivateMsgAIO.StGetPMBeginShowMsgRsp paramStGetPMBeginShowMsgRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetPMBeginShowMsgRsp == null)) {
      QLog.e(this.a.tag, 1, "requestNewestShowFuelTips error:" + paramLong + "  errorMsg:" + paramString);
    }
    label259:
    label277:
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramStGetPMBeginShowMsgRsp.pmBeginShow.has());
        paramVSBaseRequest = paramStGetPMBeginShowMsgRsp.pmBeginShow.get();
        if (aifl.a(this.a) == null) {
          break label277;
        }
        if ((TextUtils.isEmpty(aifl.a(this.a))) || (aifl.a(this.a).equals(paramVSBaseRequest))) {
          break label259;
        }
        aifl.a(this.a, paramVSBaseRequest);
        if (TextUtils.isEmpty(aifl.a(this.a))) {
          break;
        }
      } while (!QCircleChatUtil.updateExpiredShowFuelTipMsg(this.a.app, aifl.a(this.a), aifl.a(this.a)));
      this.a.refreshListItem(aifl.a(this.a), 0);
      QCircleLpReportDc05504.report(this.a.sessionInfo.curFriendUin, 45, 3, 1);
      return;
      this.a.app.getMessageFacade().removeMsgFromCacheByUniseq(this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, aifl.a(this.a).msgtype, aifl.a(this.a).uniseq);
      this.a.refresh(131072);
      return;
      QCircleLpReportDc05504.report(this.a.sessionInfo.curFriendUin, 45, 3, 1);
      return;
      aifl.a(this.a, paramVSBaseRequest);
    } while (TextUtils.isEmpty(aifl.a(this.a)));
    aifl.a(this.a, QCircleChatUtil.addShowFuelTipsGrayMessage(this.a.app, this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, aifl.a(this.a), aifl.a(this.a)));
    QCircleLpReportDc05504.report(this.a.sessionInfo.curFriendUin, 45, 3, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifp
 * JD-Core Version:    0.7.0.1
 */