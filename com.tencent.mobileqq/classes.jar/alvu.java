import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class alvu
  implements alwi
{
  private alwg jdField_a_of_type_Alwg;
  private alwh jdField_a_of_type_Alwh;
  private alwk jdField_a_of_type_Alwk;
  private boolean jdField_a_of_type_Boolean = true;
  private alwh b;
  
  private alvr a()
  {
    alvr localalvr = alvr.a();
    if (this != localalvr.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localalvr;
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    alvr localalvr = alvr.a();
    if (this == localalvr.a()) {
      return localalvr.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
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
  
  public void a(@NonNull alwg paramalwg)
  {
    this.jdField_a_of_type_Alwg = paramalwg;
    this.jdField_a_of_type_Alwg.bind(this);
  }
  
  public void a(@NonNull alwh paramalwh1, @NonNull alwh paramalwh2)
  {
    this.jdField_a_of_type_Alwh = paramalwh1;
    this.jdField_a_of_type_Alwh.a(this);
    this.b = paramalwh2;
    this.b.a(this);
  }
  
  public void a(@NonNull alwk paramalwk)
  {
    this.jdField_a_of_type_Alwk = paramalwk;
    this.jdField_a_of_type_Alwk.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    alvr localalvr = alvr.a();
    alvu localalvu = localalvr.a();
    if (localalvu != null)
    {
      if (this == localalvu) {}
      localalvr.d();
    }
    localalvr.a(this);
    localalvr.a(this.jdField_a_of_type_Alwg);
    localalvr.a(this.jdField_a_of_type_Alwh, this.b);
    localalvr.a(this.jdField_a_of_type_Alwk);
    localalvr.a(paramChatMessage);
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
    alvr.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    alvr localalvr;
    do
    {
      do
      {
        do
        {
          return;
          localalvr = alvr.a();
        } while ((!localalvr.c()) || (localalvr.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localalvr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localalvr.a());
      localalvr.f();
      return;
    } while (this == localalvr.a());
    localalvr.a(this);
    localalvr.a(this.jdField_a_of_type_Alwg);
    localalvr.a(this.jdField_a_of_type_Alwh, this.b);
    if (localalvr.jdField_a_of_type_Alwk != null) {
      a(localalvr.jdField_a_of_type_Alwk);
    }
    localalvr.e();
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
    alvr.a().c();
  }
  
  public void c(int paramInt)
  {
    alvr.a().c(paramInt);
  }
  
  public boolean c()
  {
    alvr localalvr = alvr.a();
    return (this == localalvr.a()) && (localalvr.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    alvr localalvr = alvr.a();
    if (this == localalvr.a()) {
      localalvr.d();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Alwh != null) && (this.jdField_a_of_type_Alwh.a(1));
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
 * Qualified Name:     alvu
 * JD-Core Version:    0.7.0.1
 */