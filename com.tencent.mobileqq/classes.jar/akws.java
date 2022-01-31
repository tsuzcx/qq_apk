import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

public class akws
  extends akwr
{
  private akwt a;
  protected QQAppInterface a;
  
  public akws(akwt paramakwt)
  {
    this.jdField_a_of_type_Akwt = paramakwt;
  }
  
  public akws(akwt paramakwt, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Akwt = paramakwt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "removeObserver  " + this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Akwt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (4 != this.jdField_a_of_type_Akwt.a()) {
      return;
    }
    this.jdField_a_of_type_Akwt.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, this + "      Follow isSuccess:" + paramBoolean);
    }
    oidb_cmd0xc96.RspBody localRspBody;
    if (paramBoolean)
    {
      localRspBody = new oidb_cmd0xc96.RspBody();
      if (!(paramObject instanceof byte[])) {}
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        this.jdField_a_of_type_Akwt.a(localRspBody);
        this.jdField_a_of_type_Akwt.b(paramBoolean, paramObject);
        a();
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        this.jdField_a_of_type_Akwt.b(paramObject);
        continue;
      }
      catch (Exception localException)
      {
        QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
        this.jdField_a_of_type_Akwt.b(paramObject);
        continue;
      }
      this.jdField_a_of_type_Akwt.b(paramObject);
      continue;
      this.jdField_a_of_type_Akwt.b(paramObject);
    }
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Akwt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (5 != this.jdField_a_of_type_Akwt.a()) {
      return;
    }
    this.jdField_a_of_type_Akwt.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, this + "      unFollow isSuccess:" + paramBoolean);
    }
    oidb_cmd0xc96.RspBody localRspBody;
    if (paramBoolean)
    {
      localRspBody = new oidb_cmd0xc96.RspBody();
      if (!(paramObject instanceof byte[])) {}
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        this.jdField_a_of_type_Akwt.a(localRspBody);
        this.jdField_a_of_type_Akwt.b(paramBoolean, paramObject);
        a();
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.w("AppletsObserver", 4, localInvalidProtocolBufferMicroException.getMessage(), localInvalidProtocolBufferMicroException);
        this.jdField_a_of_type_Akwt.b(paramObject);
        continue;
      }
      catch (Exception localException)
      {
        QLog.w("AppletsObserver", 4, localException.getMessage(), localException);
        this.jdField_a_of_type_Akwt.b(paramObject);
        continue;
      }
      this.jdField_a_of_type_Akwt.b(paramObject);
      continue;
      this.jdField_a_of_type_Akwt.b(paramObject);
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Akwt == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AppletsObserver", 2, "No Set ResponseResultListener, ignore Response!");
      }
    }
    while (7 != this.jdField_a_of_type_Akwt.a()) {
      return;
    }
    this.jdField_a_of_type_Akwt.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("AppletsObserver", 2, "PublicAccountNotifySetting isSuccess:" + paramBoolean);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Akwt.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Akwt.b(paramBoolean, paramObject);
      a();
      return;
      this.jdField_a_of_type_Akwt.b(paramObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      super.onUpdate(paramInt, paramBoolean, paramObject);
    case 6: 
      return;
    case 4: 
      a(paramBoolean, paramObject);
      return;
    case 5: 
      b(paramBoolean, paramObject);
      return;
    }
    c(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akws
 * JD-Core Version:    0.7.0.1
 */