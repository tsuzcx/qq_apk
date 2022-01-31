import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;

public final class ahpa
  implements ahpo
{
  private ahpm jdField_a_of_type_Ahpm;
  private ahpn jdField_a_of_type_Ahpn;
  private ahpq jdField_a_of_type_Ahpq;
  private boolean jdField_a_of_type_Boolean = true;
  private ahpn b;
  
  private ahox a()
  {
    ahox localahox = ahox.a();
    if (this != localahox.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localahox;
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
  
  public void a(@NonNull ahpm paramahpm)
  {
    this.jdField_a_of_type_Ahpm = paramahpm;
    this.jdField_a_of_type_Ahpm.a(this);
  }
  
  public void a(@NonNull ahpn paramahpn1, @NonNull ahpn paramahpn2)
  {
    this.jdField_a_of_type_Ahpn = paramahpn1;
    this.jdField_a_of_type_Ahpn.a(this);
    this.b = paramahpn2;
    this.b.a(this);
  }
  
  public void a(@NonNull ahpq paramahpq)
  {
    this.jdField_a_of_type_Ahpq = paramahpq;
    this.jdField_a_of_type_Ahpq.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    ahox localahox = ahox.a();
    ahpa localahpa = localahox.a();
    if (localahpa != null)
    {
      if (this == localahpa) {}
      localahox.d();
    }
    localahox.a(this);
    localahox.a(this.jdField_a_of_type_Ahpm);
    localahox.a(this.jdField_a_of_type_Ahpn, this.b);
    localahox.a(this.jdField_a_of_type_Ahpq);
    localahox.a(paramChatMessage);
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
    ahox.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ahox localahox;
    do
    {
      do
      {
        do
        {
          return;
          localahox = ahox.a();
        } while ((!localahox.c()) || (localahox.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localahox.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localahox.a());
      localahox.f();
      return;
    } while (this == localahox.a());
    localahox.a(this);
    localahox.a(this.jdField_a_of_type_Ahpm);
    localahox.a(this.jdField_a_of_type_Ahpn, this.b);
    if (localahox.jdField_a_of_type_Ahpq != null) {
      a(localahox.jdField_a_of_type_Ahpq);
    }
    localahox.e();
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
    ahox.a().c();
  }
  
  public void c(int paramInt)
  {
    ahox.a().c(paramInt);
  }
  
  public boolean c()
  {
    ahox localahox = ahox.a();
    return (this == localahox.a()) && (localahox.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    ahox localahox = ahox.a();
    if (this == localahox.a()) {
      localahox.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpa
 * JD-Core Version:    0.7.0.1
 */