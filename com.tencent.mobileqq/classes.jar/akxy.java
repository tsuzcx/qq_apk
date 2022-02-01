import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class akxy
  implements akym
{
  private akyk jdField_a_of_type_Akyk;
  private akyl jdField_a_of_type_Akyl;
  private akyo jdField_a_of_type_Akyo;
  private boolean jdField_a_of_type_Boolean = true;
  private akyl b;
  
  private akxv a()
  {
    akxv localakxv = akxv.a();
    if (this != localakxv.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localakxv;
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    akxv localakxv = akxv.a();
    if (this == localakxv.a()) {
      return localakxv.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return a().a(paramInt1, paramInt2);
  }
  
  @Nullable
  public String a()
  {
    return a().a();
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
  
  public void a(@NonNull akyk paramakyk)
  {
    this.jdField_a_of_type_Akyk = paramakyk;
    this.jdField_a_of_type_Akyk.bind(this);
  }
  
  public void a(@NonNull akyl paramakyl1, @NonNull akyl paramakyl2)
  {
    this.jdField_a_of_type_Akyl = paramakyl1;
    this.jdField_a_of_type_Akyl.a(this);
    this.b = paramakyl2;
    this.b.a(this);
  }
  
  public void a(@NonNull akyo paramakyo)
  {
    this.jdField_a_of_type_Akyo = paramakyo;
    this.jdField_a_of_type_Akyo.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    akxv localakxv = akxv.a();
    akxy localakxy = localakxv.a();
    if (localakxy != null)
    {
      if (this == localakxy) {}
      localakxv.d();
    }
    localakxv.a(this);
    localakxv.a(this.jdField_a_of_type_Akyk);
    localakxv.a(this.jdField_a_of_type_Akyl, this.b);
    localakxv.a(this.jdField_a_of_type_Akyo);
    localakxv.a(paramChatMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    a().a(paramBoolean);
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
    akxv.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    akxv localakxv;
    do
    {
      do
      {
        do
        {
          return;
          localakxv = akxv.a();
        } while ((!localakxv.c()) || (localakxv.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localakxv.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localakxv.a());
      localakxv.f();
      return;
    } while (this == localakxv.a());
    localakxv.a(this);
    localakxv.a(this.jdField_a_of_type_Akyk);
    localakxv.a(this.jdField_a_of_type_Akyl, this.b);
    if (localakxv.jdField_a_of_type_Akyo != null) {
      a(localakxv.jdField_a_of_type_Akyo);
    }
    localakxv.e();
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
    akxv.a().c();
  }
  
  public void c(int paramInt)
  {
    akxv.a().c(paramInt);
  }
  
  public boolean c()
  {
    akxv localakxv = akxv.a();
    return (this == localakxv.a()) && (localakxv.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    akxv localakxv = akxv.a();
    if (this == localakxv.a()) {
      localakxv.d();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Akyl != null) && (this.jdField_a_of_type_Akyl.a(1));
  }
  
  public boolean e()
  {
    return (this.b != null) && (this.b.a(2));
  }
  
  public boolean f()
  {
    return (d()) && (e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxy
 * JD-Core Version:    0.7.0.1
 */