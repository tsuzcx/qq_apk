import com.tencent.mobileqq.utils.SendMessageHandler;

class ajkh
  extends amwl
{
  ajkh(ajkg paramajkg) {}
  
  public void onMsgStartSendingUI(String paramString)
  {
    if (ajkg.a(this.a) != null) {
      ajkg.a(this.a).a(paramString);
    }
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    onSendResult(paramBoolean, paramString, paramLong, null);
  }
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, amwf paramamwf)
  {
    if (ajkg.a(this.a) != null) {
      ajkg.a(this.a).a(paramString);
    }
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    if (ajkg.a(this.a) != null) {
      ajkg.a(this.a).a(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajkh
 * JD-Core Version:    0.7.0.1
 */