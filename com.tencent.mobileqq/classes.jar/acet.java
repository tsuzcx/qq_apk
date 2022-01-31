import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class acet
  extends aqnl
{
  private acet(BaseChatPie paramBaseChatPie) {}
  
  protected void a()
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    arni.a(paramLong, paramInt, paramString);
    bkif.a(null, paramInt);
    if (this.a.jdField_a_of_type_Aelz != null) {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      arni.a(paramString2);
      return;
    }
    arni.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      arni.a(paramString);
    }
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(aqxx paramaqxx)
  {
    if (paramaqxx == null) {}
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
          } while (!(paramaqxx.a instanceof FileManagerEntity));
          localFileManagerEntity = (FileManagerEntity)paramaqxx.a;
          if ((paramaqxx.b == null) || (paramaqxx.b.length() <= 0)) {
            break;
          }
          localFileManagerEntity.strThumbPath = paramaqxx.b;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
        } while (this.a.jdField_a_of_type_Aelz == null);
        this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
        return;
      } while (localFileManagerEntity.thumbInvalidCode != 1);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localFileManagerEntity);
    } while (this.a.jdField_a_of_type_Aelz == null);
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    if (this.a.jdField_a_of_type_Aelz != null) {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
    }
    arni.a(paramLong, paramInteger.intValue(), paramString);
    bkif.a(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (bkev.a(paramInt2))
      {
        if (!paramBoolean) {
          break label154;
        }
        bkfr.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.a());
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
      return;
      label154:
      if (bkev.b())
      {
        bkev.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramString2, 1).b(this.a.a());
        }
        for (;;)
        {
          bkif.a(null, paramInt2);
          break;
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692911, 1).b(this.a.a());
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          arni.a(paramLong2, paramInt2, paramString2);
          bkif.a(null, paramInt2);
        }
      }
    }
  }
  
  protected void b()
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void c()
  {
    this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
  }
  
  protected void d()
  {
    if (this.a.jdField_a_of_type_Aelz != null) {
      this.a.jdField_a_of_type_Aelz.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acet
 * JD-Core Version:    0.7.0.1
 */