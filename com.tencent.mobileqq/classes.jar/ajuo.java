import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class ajuo
  implements apeb
{
  ajuo(ajum paramajum, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    aptx.c(BaseApplicationImpl.getContext().getString(2131692688));
    ((ajum)this.jdField_a_of_type_Ajum.app.a(8)).OnSessionComplete(this.jdField_a_of_type_Long, 41, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = (String)paramObject;
    paramObject = (ajum)this.jdField_a_of_type_Ajum.app.a(8);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject.OnSessionComplete(this.jdField_a_of_type_Long, 0, -999);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
        int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Long);
        localDataLineMsgRecord = this.jdField_a_of_type_Ajum.app.a().a(i).a(this.jdField_a_of_type_Long);
      } while (localDataLineMsgRecord == null);
      localDataLineMsgRecord.serverPath = ((String)localObject);
      localDataLineMsgRecord.nOpType = 1;
      localDataLineMsgRecord.bIsSended = true;
      localDataLineMsgRecord.bIsTransfering = false;
      if (localDataLineMsgRecord.entityID != 0L)
      {
        localObject = this.jdField_a_of_type_Ajum.app.a().a(localDataLineMsgRecord.entityID);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).Uuid = localDataLineMsgRecord.serverPath;
        }
      }
    } while (!paramObject.a(localDataLineMsgRecord));
    paramObject.a(localDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajuo
 * JD-Core Version:    0.7.0.1
 */