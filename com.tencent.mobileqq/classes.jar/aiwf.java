import com.tencent.mobileqq.activity.history.ChatHistoryC2CFileFragment;

public class aiwf
  extends asbj
{
  public aiwf(ChatHistoryC2CFileFragment paramChatHistoryC2CFileFragment) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
  }
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    ChatHistoryC2CFileFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwf
 * JD-Core Version:    0.7.0.1
 */