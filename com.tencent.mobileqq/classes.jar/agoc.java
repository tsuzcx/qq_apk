import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class agoc
  extends aqnl
{
  agoc(agnz paramagnz) {}
  
  protected void a(aqxx paramaqxx)
  {
    if (paramaqxx == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramaqxx.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramaqxx.a;
      } while ((paramaqxx.b == null) || (paramaqxx.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramaqxx.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (agnz.a(this.a) == null);
    agnz.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (agnz.a(this.a) != null) {
      agnz.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (agnz.a(this.a) != null) {
      agnz.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (agnz.a(this.a) != null) {
      agnz.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoc
 * JD-Core Version:    0.7.0.1
 */