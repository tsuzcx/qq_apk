import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;

public final class aibq
  implements aice
{
  private aicc jdField_a_of_type_Aicc;
  private aicd jdField_a_of_type_Aicd;
  private aicg jdField_a_of_type_Aicg;
  private boolean jdField_a_of_type_Boolean = true;
  private aicd b;
  
  private aibn a()
  {
    aibn localaibn = aibn.a();
    if (this != localaibn.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localaibn;
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
  
  public void a(@NonNull aicc paramaicc)
  {
    this.jdField_a_of_type_Aicc = paramaicc;
    this.jdField_a_of_type_Aicc.bind(this);
  }
  
  public void a(@NonNull aicd paramaicd1, @NonNull aicd paramaicd2)
  {
    this.jdField_a_of_type_Aicd = paramaicd1;
    this.jdField_a_of_type_Aicd.a(this);
    this.b = paramaicd2;
    this.b.a(this);
  }
  
  public void a(@NonNull aicg paramaicg)
  {
    this.jdField_a_of_type_Aicg = paramaicg;
    this.jdField_a_of_type_Aicg.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    aibn localaibn = aibn.a();
    aibq localaibq = localaibn.a();
    if (localaibq != null)
    {
      if (this == localaibq) {}
      localaibn.d();
    }
    localaibn.a(this);
    localaibn.a(this.jdField_a_of_type_Aicc);
    localaibn.a(this.jdField_a_of_type_Aicd, this.b);
    localaibn.a(this.jdField_a_of_type_Aicg);
    localaibn.a(paramChatMessage);
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
    aibn.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    aibn localaibn;
    do
    {
      do
      {
        do
        {
          return;
          localaibn = aibn.a();
        } while ((!localaibn.c()) || (localaibn.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localaibn.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localaibn.a());
      localaibn.f();
      return;
    } while (this == localaibn.a());
    localaibn.a(this);
    localaibn.a(this.jdField_a_of_type_Aicc);
    localaibn.a(this.jdField_a_of_type_Aicd, this.b);
    if (localaibn.jdField_a_of_type_Aicg != null) {
      a(localaibn.jdField_a_of_type_Aicg);
    }
    localaibn.e();
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
    aibn.a().c();
  }
  
  public void c(int paramInt)
  {
    aibn.a().c(paramInt);
  }
  
  public boolean c()
  {
    aibn localaibn = aibn.a();
    return (this == localaibn.a()) && (localaibn.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    aibn localaibn = aibn.a();
    if (this == localaibn.a()) {
      localaibn.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibq
 * JD-Core Version:    0.7.0.1
 */