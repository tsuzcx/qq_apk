import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class ahid
  extends asbj
{
  ahid(ahia paramahia) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiForwardActivity", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (ahia.a(this.a) != null) {
      ahia.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (ahia.a(this.a) != null) {
      ahia.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (ahia.a(this.a) != null) {
      ahia.a(this.a).notifyDataSetChanged();
    }
  }
  
  protected void onThumbDownLoadSuccess(aslv paramaslv)
  {
    if (paramaslv == null) {}
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          return;
        } while (!(paramaslv.a instanceof FileManagerEntity));
        localFileManagerEntity = (FileManagerEntity)paramaslv.a;
      } while ((paramaslv.b == null) || (paramaslv.b.length() <= 0));
      localFileManagerEntity.strThumbPath = paramaslv.b;
      this.a.app.getFileManagerDataCenter().c(localFileManagerEntity);
    } while (ahia.a(this.a) == null);
    ahia.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahid
 * JD-Core Version:    0.7.0.1
 */