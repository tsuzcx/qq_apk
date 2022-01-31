import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aerc
  extends aoun
{
  aerc(aeqz paramaeqz) {}
  
  protected void a(apez paramapez)
  {
    if (paramapez == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramapez.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramapez.a;
      } while ((paramapez.b == null) || (paramapez.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramapez.b;
      this.a.a.a().c(localFileManagerEntity);
    } while (aeqz.a(this.a) == null);
    aeqz.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aeqz.a(this.a) != null) {
      aeqz.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (aeqz.a(this.a) != null) {
      aeqz.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (aeqz.a(this.a) != null) {
      aeqz.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aerc
 * JD-Core Version:    0.7.0.1
 */