import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;

public final class ajxp
  implements ajyd
{
  private ajyb jdField_a_of_type_Ajyb;
  private ajyc jdField_a_of_type_Ajyc;
  private ajyf jdField_a_of_type_Ajyf;
  private boolean jdField_a_of_type_Boolean = true;
  private ajyc b;
  
  private ajxm a()
  {
    ajxm localajxm = ajxm.a();
    if (this != localajxm.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localajxm;
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
  
  public void a(@NonNull ajyb paramajyb)
  {
    this.jdField_a_of_type_Ajyb = paramajyb;
    this.jdField_a_of_type_Ajyb.bind(this);
  }
  
  public void a(@NonNull ajyc paramajyc1, @NonNull ajyc paramajyc2)
  {
    this.jdField_a_of_type_Ajyc = paramajyc1;
    this.jdField_a_of_type_Ajyc.a(this);
    this.b = paramajyc2;
    this.b.a(this);
  }
  
  public void a(@NonNull ajyf paramajyf)
  {
    this.jdField_a_of_type_Ajyf = paramajyf;
    this.jdField_a_of_type_Ajyf.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    ajxm localajxm = ajxm.a();
    ajxp localajxp = localajxm.a();
    if (localajxp != null)
    {
      if (this == localajxp) {}
      localajxm.d();
    }
    localajxm.a(this);
    localajxm.a(this.jdField_a_of_type_Ajyb);
    localajxm.a(this.jdField_a_of_type_Ajyc, this.b);
    localajxm.a(this.jdField_a_of_type_Ajyf);
    localajxm.a(paramChatMessage);
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
    ajxm.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ajxm localajxm;
    do
    {
      do
      {
        do
        {
          return;
          localajxm = ajxm.a();
        } while ((!localajxm.c()) || (localajxm.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localajxm.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localajxm.a());
      localajxm.f();
      return;
    } while (this == localajxm.a());
    localajxm.a(this);
    localajxm.a(this.jdField_a_of_type_Ajyb);
    localajxm.a(this.jdField_a_of_type_Ajyc, this.b);
    if (localajxm.jdField_a_of_type_Ajyf != null) {
      a(localajxm.jdField_a_of_type_Ajyf);
    }
    localajxm.e();
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
    ajxm.a().c();
  }
  
  public void c(int paramInt)
  {
    ajxm.a().c(paramInt);
  }
  
  public boolean c()
  {
    ajxm localajxm = ajxm.a();
    return (this == localajxm.a()) && (localajxm.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    ajxm localajxm = ajxm.a();
    if (this == localajxm.a()) {
      localajxm.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxp
 * JD-Core Version:    0.7.0.1
 */