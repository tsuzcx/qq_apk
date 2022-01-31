import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aere
  extends aouj
{
  aere(aerb paramaerb) {}
  
  protected void a(apev paramapev)
  {
    if (paramapev == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramapev.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramapev.a;
      } while ((paramapev.b == null) || (paramapev.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramapev.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (aerb.a(this.a) == null);
    aerb.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aerb.a(this.a) != null) {
      aerb.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aerb.a(this.a) != null) {
      aerb.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aerb.a(this.a) != null) {
      aerb.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aere
 * JD-Core Version:    0.7.0.1
 */