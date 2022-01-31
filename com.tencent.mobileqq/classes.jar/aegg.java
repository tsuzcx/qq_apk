import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aegg
  extends aodp
{
  aegg(aege paramaege) {}
  
  protected void a(aooa paramaooa)
  {
    if (paramaooa == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramaooa.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramaooa.a;
      } while ((paramaooa.b == null) || (paramaooa.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramaooa.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (aege.a(this.a) == null);
    aege.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aege.a(this.a) != null) {
      aege.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aege.a(this.a) != null) {
      aege.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aege.a(this.a) != null) {
      aege.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegg
 * JD-Core Version:    0.7.0.1
 */