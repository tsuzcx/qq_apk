import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.Conversation.43.1;
import com.tencent.mobileqq.activity.home.Conversation.43.2;
import com.tencent.mobileqq.activity.home.Conversation.43.3;
import com.tencent.mobileqq.activity.home.Conversation.43.4;
import com.tencent.mobileqq.activity.home.Conversation.43.5;
import com.tencent.mobileqq.activity.home.Conversation.43.6;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajxx
  extends lng
{
  public ajxx(Conversation paramConversation) {}
  
  protected void onAudioChatting(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.b(new Conversation.43.4(this));
  }
  
  protected void onCallTimeUseUp(boolean paramBoolean, String paramString) {}
  
  protected void onMeetingCancel(int paramInt, long paramLong)
  {
    paramInt = mvk.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void onMeetingReady(int paramInt, long paramLong)
  {
    paramInt = mvk.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void onMemberInfo(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = mvk.c(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.b(paramLong1);
    this.a.b(new Conversation.43.1(this, paramLong1));
  }
  
  protected void onMemberJoin(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.43.2(this, paramLong1));
    }
  }
  
  protected void onMemberQuit(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.b(new Conversation.43.3(this, paramLong1));
    }
  }
  
  protected void onSmallScreenStateChange(String paramString)
  {
    super.onSmallScreenStateChange(paramString);
    this.a.b(new Conversation.43.6(this));
  }
  
  protected void onUpdateTime(String paramString1, String paramString2)
  {
    super.onUpdateTime(paramString1, paramString2);
    if (!this.a.f) {
      return;
    }
    this.a.b(new Conversation.43.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxx
 * JD-Core Version:    0.7.0.1
 */