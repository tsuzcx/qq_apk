import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aimq
  extends atpa
{
  aimq(aimn paramaimn) {}
  
  protected void a(atzl paramatzl)
  {
    if (paramatzl == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramatzl.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramatzl.a;
      } while ((paramatzl.b == null) || (paramatzl.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramatzl.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (aimn.a(this.a) == null);
    aimn.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aimn.a(this.a) != null) {
      aimn.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aimn.a(this.a) != null) {
      aimn.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aimn.a(this.a) != null) {
      aimn.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimq
 * JD-Core Version:    0.7.0.1
 */