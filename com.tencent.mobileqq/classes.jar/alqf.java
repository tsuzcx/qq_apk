import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class alqf
  implements alqt
{
  private alqr jdField_a_of_type_Alqr;
  private alqs jdField_a_of_type_Alqs;
  private alqv jdField_a_of_type_Alqv;
  private boolean jdField_a_of_type_Boolean = true;
  private alqs b;
  
  private alqc a()
  {
    alqc localalqc = alqc.a();
    if (this != localalqc.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localalqc;
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    alqc localalqc = alqc.a();
    if (this == localalqc.a()) {
      return localalqc.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
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
  
  public void a(@NonNull alqr paramalqr)
  {
    this.jdField_a_of_type_Alqr = paramalqr;
    this.jdField_a_of_type_Alqr.bind(this);
  }
  
  public void a(@NonNull alqs paramalqs1, @NonNull alqs paramalqs2)
  {
    this.jdField_a_of_type_Alqs = paramalqs1;
    this.jdField_a_of_type_Alqs.a(this);
    this.b = paramalqs2;
    this.b.a(this);
  }
  
  public void a(@NonNull alqv paramalqv)
  {
    this.jdField_a_of_type_Alqv = paramalqv;
    this.jdField_a_of_type_Alqv.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    alqc localalqc = alqc.a();
    alqf localalqf = localalqc.a();
    if (localalqf != null)
    {
      if (this == localalqf) {}
      localalqc.d();
    }
    localalqc.a(this);
    localalqc.a(this.jdField_a_of_type_Alqr);
    localalqc.a(this.jdField_a_of_type_Alqs, this.b);
    localalqc.a(this.jdField_a_of_type_Alqv);
    localalqc.a(paramChatMessage);
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
    alqc.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    alqc localalqc;
    do
    {
      do
      {
        do
        {
          return;
          localalqc = alqc.a();
        } while ((!localalqc.c()) || (localalqc.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localalqc.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localalqc.a());
      localalqc.f();
      return;
    } while (this == localalqc.a());
    localalqc.a(this);
    localalqc.a(this.jdField_a_of_type_Alqr);
    localalqc.a(this.jdField_a_of_type_Alqs, this.b);
    if (localalqc.jdField_a_of_type_Alqv != null) {
      a(localalqc.jdField_a_of_type_Alqv);
    }
    localalqc.e();
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
    alqc.a().c();
  }
  
  public void c(int paramInt)
  {
    alqc.a().c(paramInt);
  }
  
  public boolean c()
  {
    alqc localalqc = alqc.a();
    return (this == localalqc.a()) && (localalqc.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    alqc localalqc = alqc.a();
    if (this == localalqc.a()) {
      localalqc.d();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Alqs != null) && (this.jdField_a_of_type_Alqs.a(1));
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
 * Qualified Name:     alqf
 * JD-Core Version:    0.7.0.1
 */