import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.Conversation.42.1;
import com.tencent.mobileqq.activity.Conversation.42.2;
import com.tencent.mobileqq.activity.Conversation.42.3;
import com.tencent.mobileqq.activity.Conversation.42.4;
import com.tencent.mobileqq.activity.Conversation.42.5;
import com.tencent.mobileqq.activity.Conversation.42.6;
import com.tencent.mobileqq.app.QQAppInterface;

public class aein
  extends lnc
{
  public aein(Conversation paramConversation) {}
  
  protected void a(int paramInt, long paramLong)
  {
    paramInt = mvd.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void a(int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = mvd.c(paramInt);
    this.a.a(8, Long.toString(paramLong1), paramInt);
    this.a.b(paramLong1);
    this.a.a(new Conversation.42.1(this, paramLong1));
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, paramInt);
    this.a.a(new Conversation.42.4(this));
  }
  
  protected void a(String paramString)
  {
    super.a(paramString);
    this.a.a(new Conversation.42.6(this));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    if (!this.a.f) {
      return;
    }
    this.a.a(new Conversation.42.5(this));
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void b(int paramInt, long paramLong)
  {
    paramInt = mvd.c(paramInt);
    this.a.a(8, Long.toString(paramLong), paramInt);
  }
  
  protected void b(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.a(new Conversation.42.2(this, paramLong1));
    }
  }
  
  protected void c(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.valueOf(this.a.a.getCurrentAccountUin()).longValue()) {
      this.a.a(new Conversation.42.3(this, paramLong1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aein
 * JD-Core Version:    0.7.0.1
 */