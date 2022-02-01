import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aicw
  extends atfq
{
  aicw(aict paramaict) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aict.a(this.a) != null) {
      aict.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(atqb paramatqb)
  {
    if (paramatqb == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramatqb.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramatqb.a;
      } while ((paramatqb.b == null) || (paramatqb.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramatqb.b;
      this.a.app.getFileManagerDataCenter().c(localFileManagerEntity);
    } while (aict.a(this.a) == null);
    aict.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aict.a(this.a) != null) {
      aict.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aict.a(this.a) != null) {
      aict.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicw
 * JD-Core Version:    0.7.0.1
 */