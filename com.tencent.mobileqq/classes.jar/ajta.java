import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;

public final class ajta
  implements ajto
{
  private ajtm jdField_a_of_type_Ajtm;
  private ajtn jdField_a_of_type_Ajtn;
  private ajtq jdField_a_of_type_Ajtq;
  private boolean jdField_a_of_type_Boolean = true;
  private ajtn b;
  
  private ajsx a()
  {
    ajsx localajsx = ajsx.a();
    if (this != localajsx.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localajsx;
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return a().a(paramInt1, paramInt2);
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a().a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a().a(paramInt, paramBoolean);
  }
  
  public void a(@NonNull ajtm paramajtm)
  {
    this.jdField_a_of_type_Ajtm = paramajtm;
    this.jdField_a_of_type_Ajtm.bind(this);
  }
  
  public void a(@NonNull ajtn paramajtn1, @NonNull ajtn paramajtn2)
  {
    this.jdField_a_of_type_Ajtn = paramajtn1;
    this.jdField_a_of_type_Ajtn.a(this);
    this.b = paramajtn2;
    this.b.a(this);
  }
  
  public void a(@NonNull ajtq paramajtq)
  {
    this.jdField_a_of_type_Ajtq = paramajtq;
    this.jdField_a_of_type_Ajtq.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    ajsx localajsx = ajsx.a();
    ajta localajta = localajsx.a();
    if (localajta != null)
    {
      if (this == localajta) {}
      localajsx.d();
    }
    localajsx.a(this);
    localajsx.a(this.jdField_a_of_type_Ajtm);
    localajsx.a(this.jdField_a_of_type_Ajtn, this.b);
    localajsx.a(this.jdField_a_of_type_Ajtq);
    localajsx.a(paramChatMessage);
  }
  
  public boolean a()
  {
    return a().a();
  }
  
  public int b()
  {
    return a().b();
  }
  
  public void b()
  {
    a().b();
  }
  
  public void b(int paramInt)
  {
    ajsx.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ajsx localajsx;
    do
    {
      do
      {
        do
        {
          return;
          localajsx = ajsx.a();
        } while ((!localajsx.c()) || (localajsx.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localajsx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localajsx.a());
      localajsx.f();
      return;
    } while (this == localajsx.a());
    localajsx.a(this);
    localajsx.a(this.jdField_a_of_type_Ajtm);
    localajsx.a(this.jdField_a_of_type_Ajtn, this.b);
    if (localajsx.jdField_a_of_type_Ajtq != null) {
      a(localajsx.jdField_a_of_type_Ajtq);
    }
    localajsx.e();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return a().c();
  }
  
  public void c()
  {
    ajsx.a().c();
  }
  
  public void c(int paramInt)
  {
    ajsx.a().c(paramInt);
  }
  
  public boolean c()
  {
    ajsx localajsx = ajsx.a();
    return (this == localajsx.a()) && (localajsx.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    ajsx localajsx = ajsx.a();
    if (this == localajsx.a()) {
      localajsx.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajta
 * JD-Core Version:    0.7.0.1
 */