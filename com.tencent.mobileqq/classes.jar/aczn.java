class aczn
  extends asbj
{
  aczn(aczh paramaczh) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a.a.notifyDataSetChanged();
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.a.notifyDataSetChanged();
  }
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczn
 * JD-Core Version:    0.7.0.1
 */