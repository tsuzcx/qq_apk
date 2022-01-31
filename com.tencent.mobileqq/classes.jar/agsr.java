import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class agsr
  extends aqru
{
  agsr(agso paramagso) {}
  
  protected void a(arcg paramarcg)
  {
    if (paramarcg == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramarcg.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramarcg.a;
      } while ((paramarcg.b == null) || (paramarcg.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramarcg.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (agso.a(this.a) == null);
    agso.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (agso.a(this.a) != null) {
      agso.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (agso.a(this.a) != null) {
      agso.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (agso.a(this.a) != null) {
      agso.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsr
 * JD-Core Version:    0.7.0.1
 */