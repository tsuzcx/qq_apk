import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;

public final class aibs
  implements aicg
{
  private aice jdField_a_of_type_Aice;
  private aicf jdField_a_of_type_Aicf;
  private aici jdField_a_of_type_Aici;
  private boolean jdField_a_of_type_Boolean = true;
  private aicf b;
  
  private aibp a()
  {
    aibp localaibp = aibp.a();
    if (this != localaibp.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localaibp;
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
  
  public void a(@NonNull aice paramaice)
  {
    this.jdField_a_of_type_Aice = paramaice;
    this.jdField_a_of_type_Aice.bind(this);
  }
  
  public void a(@NonNull aicf paramaicf1, @NonNull aicf paramaicf2)
  {
    this.jdField_a_of_type_Aicf = paramaicf1;
    this.jdField_a_of_type_Aicf.a(this);
    this.b = paramaicf2;
    this.b.a(this);
  }
  
  public void a(@NonNull aici paramaici)
  {
    this.jdField_a_of_type_Aici = paramaici;
    this.jdField_a_of_type_Aici.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    aibp localaibp = aibp.a();
    aibs localaibs = localaibp.a();
    if (localaibs != null)
    {
      if (this == localaibs) {}
      localaibp.d();
    }
    localaibp.a(this);
    localaibp.a(this.jdField_a_of_type_Aice);
    localaibp.a(this.jdField_a_of_type_Aicf, this.b);
    localaibp.a(this.jdField_a_of_type_Aici);
    localaibp.a(paramChatMessage);
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
    aibp.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    aibp localaibp;
    do
    {
      do
      {
        do
        {
          return;
          localaibp = aibp.a();
        } while ((!localaibp.c()) || (localaibp.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localaibp.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localaibp.a());
      localaibp.f();
      return;
    } while (this == localaibp.a());
    localaibp.a(this);
    localaibp.a(this.jdField_a_of_type_Aice);
    localaibp.a(this.jdField_a_of_type_Aicf, this.b);
    if (localaibp.jdField_a_of_type_Aici != null) {
      a(localaibp.jdField_a_of_type_Aici);
    }
    localaibp.e();
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
    aibp.a().c();
  }
  
  public void c(int paramInt)
  {
    aibp.a().c(paramInt);
  }
  
  public boolean c()
  {
    aibp localaibp = aibp.a();
    return (this == localaibp.a()) && (localaibp.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    aibp localaibp = aibp.a();
    if (this == localaibp.a()) {
      localaibp.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibs
 * JD-Core Version:    0.7.0.1
 */