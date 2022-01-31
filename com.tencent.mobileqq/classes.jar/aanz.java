import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aanz
  extends aouj
{
  private aanz(BaseChatPie paramBaseChatPie) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    apue.a(paramLong, paramInt, paramString);
    bifs.a(null, paramInt);
    if (this.a.jdField_a_of_type_Acut != null) {
      this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      apue.a(paramString2);
      return;
    }
    apue.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      apue.a(paramString);
    }
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(apev paramapev)
  {
    if (paramapev == null) {}
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
          } while (!(paramapev.a instanceof FileManagerEntity));
          localFileManagerEntity = (FileManagerEntity)paramapev.a;
          if ((paramapev.b == null) || (paramapev.b.length() <= 0)) {
            break;
          }
          localFileManagerEntity.strThumbPath = paramapev.b;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        } while (this.a.jdField_a_of_type_Acut == null);
        this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
        return;
      } while (localFileManagerEntity.thumbInvalidCode != 1);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    } while (this.a.jdField_a_of_type_Acut == null);
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_Acut != null) {
      this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
    }
    apue.a(paramLong, paramInteger.intValue(), paramString);
    bifs.a(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (bici.a(paramInt2))
      {
        if (!paramBoolean) {
          break label154;
        }
        bide.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.a());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
      return;
      label154:
      if (bici.b())
      {
        bici.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          bcpw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString2, 1).b(this.a.a());
        }
        for (;;)
        {
          bifs.a(null, paramInt2);
          break;
          bcpw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692828, 1).b(this.a.a());
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          apue.a(paramLong2, paramInt2, paramString2);
          bifs.a(null, paramInt2);
        }
      }
    }
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void c()
  {
    this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_Acut != null) {
      this.a.jdField_a_of_type_Acut.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aanz
 * JD-Core Version:    0.7.0.1
 */