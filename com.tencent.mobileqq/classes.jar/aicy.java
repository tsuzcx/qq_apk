import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aicy
  extends asyw
{
  aicy(aicv paramaicv) {}
  
  protected void a(athr paramathr)
  {
    if (paramathr == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramathr.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramathr.a;
      } while ((paramathr.b == null) || (paramathr.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramathr.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (aicv.a(this.a) == null);
    aicv.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aicv.a(this.a) != null) {
      aicv.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aicv.a(this.a) != null) {
      aicv.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aicv.a(this.a) != null) {
      aicv.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicy
 * JD-Core Version:    0.7.0.1
 */