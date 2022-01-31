import com.tencent.ark.ArkDebugger.DebuggerCallback;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.1;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.2;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.3;
import com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie.1.1.4;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class aebf
  implements ArkDebugger.DebuggerCallback
{
  public aebf(ArkDebugChatPie.1 param1) {}
  
  public void Accepted()
  {
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.1(this));
    QLog.d(this.a.this$0.a, 1, "ArkDebugger Accepted");
  }
  
  public boolean ReadyToRun(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArkAppCenter.a().postToMainThread(new ArkDebugChatPie.1.1.4(this, paramString4, paramString3, paramString1, paramString2));
    QLog.d(this.a.this$0.a, 1, String.format("ArkDebugger ReadyToRun viewId: %s, metaData: %s, mode: %s", new Object[] { paramString1, paramString2, paramString3 }));
    return true;
  }
  
  public void ReceivedPackage(String paramString1, String paramString2)
  {
    aebe.a(this.a.this$0, paramString1);
    aebe.b(this.a.this$0, paramString2);
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.3(this, paramString1, paramString2));
    QLog.d(this.a.this$0.a, 1, String.format("ArkDebugger ReceivedPackage appid: %s, appview: %s", new Object[] { paramString1, paramString2 }));
  }
  
  public void Stopped(int paramInt)
  {
    ArkDispatchTask.getInstance().postToMainThread(new ArkDebugChatPie.1.1.2(this, paramInt));
    QLog.d(this.a.this$0.a, 1, "ArkDebugger Stopped");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aebf
 * JD-Core Version:    0.7.0.1
 */