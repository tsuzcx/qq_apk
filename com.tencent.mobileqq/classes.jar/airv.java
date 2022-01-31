import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.ReqInfo;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.Request;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.RspInfo;

public class airv
  implements CmdTaskManger.CommandCallback
{
  public airv(SendArithHomeResultSegment paramSendArithHomeResultSegment) {}
  
  public void a(@NonNull SendArithHomeResultSegment.Request paramRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramErrorMessage.isFail())
    {
      SLog.e("QQ.Troop.homework.SendArithHomeResultSegment", "onCmdRespond failed :" + paramErrorMessage);
      SendArithHomeResultSegment.a(this.a, paramErrorMessage);
      return;
    }
    if (paramBaseResponse.a == 0)
    {
      paramRequest = new SendArithHomeResultSegment.RspInfo();
      paramRequest.a = SendArithHomeResultSegment.a(this.a);
      paramRequest.b = SendArithHomeResultSegment.a(this.a).b;
      SendArithHomeResultSegment.a(this.a, paramRequest);
      return;
    }
    SLog.e("QQ.Troop.homework.SendArithHomeResultSegment", "baseResponse failed :" + paramBaseResponse.b);
    SendArithHomeResultSegment.b(this.a, new ErrorMessage(paramBaseResponse.a, paramBaseResponse.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     airv
 * JD-Core Version:    0.7.0.1
 */