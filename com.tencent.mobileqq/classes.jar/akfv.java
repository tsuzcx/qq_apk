import com.tencent.mobileqq.utils.SendMessageHandler;

class akfv
  extends anyz
{
  akfv(akfu paramakfu) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (akfu.a(this.a) != null) {
      akfu.a(this.a).a(paramString);
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, anyt paramanyt)
  {
    if (akfu.a(this.a) != null) {
      akfu.a(this.a).a(paramString);
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (akfu.a(this.a) != null) {
      akfu.a(this.a).a(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akfv
 * JD-Core Version:    0.7.0.1
 */