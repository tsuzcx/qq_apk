import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aanv
  extends aoun
{
  private aanv(BaseChatPie paramBaseChatPie) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    apug.a(paramLong, paramInt, paramString);
    bigj.a(null, paramInt);
    if (this.a.jdField_a_of_type_Acup != null) {
      this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      apug.a(paramString2);
      return;
    }
    apug.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      apug.a(paramString);
    }
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(apez paramapez)
  {
    if (paramapez == null) {}
    label4:
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        do
        {
          break label4;
          do
          {
            return;
          } while (!(paramapez.a instanceof FileManagerEntity));
          localFileManagerEntity = (FileManagerEntity)paramapez.a;
          if ((paramapez.b == null) || (paramapez.b.length() <= 0)) {
            break;
          }
          localFileManagerEntity.strThumbPath = paramapez.b;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        } while (this.a.jdField_a_of_type_Acup == null);
        this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
        return;
      } while (localFileManagerEntity.thumbInvalidCode != 1);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    } while (this.a.jdField_a_of_type_Acup == null);
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_Acup != null) {
      this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
    }
    apug.a(paramLong, paramInteger.intValue(), paramString);
    bigj.a(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (bicz.a(paramInt2))
      {
        if (!paramBoolean) {
          break label154;
        }
        bidv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.a());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
      return;
      label154:
      if (bicz.b())
      {
        bicz.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString2, 1).b(this.a.a());
        }
        for (;;)
        {
          bigj.a(null, paramInt2);
          break;
          bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692829, 1).b(this.a.a());
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          apug.a(paramLong2, paramInt2, paramString2);
          bigj.a(null, paramInt2);
        }
      }
    }
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void c()
  {
    this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_Acup != null) {
      this.a.jdField_a_of_type_Acup.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aanv
 * JD-Core Version:    0.7.0.1
 */