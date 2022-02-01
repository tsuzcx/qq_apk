import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.data.ChatMessage;

public final class ambx
  implements amcl
{
  private amcj jdField_a_of_type_Amcj;
  private amck jdField_a_of_type_Amck;
  private amcn jdField_a_of_type_Amcn;
  private boolean jdField_a_of_type_Boolean = true;
  private amck b;
  
  private ambu a()
  {
    ambu localambu = ambu.a();
    if (this != localambu.a()) {
      throw new IllegalStateException("The proxy has been not attached.");
    }
    return localambu;
  }
  
  public int a()
  {
    return a().a();
  }
  
  public int a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    ambu localambu = ambu.a();
    if (this == localambu.a()) {
      return localambu.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
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
  
  public void a(@NonNull amcj paramamcj)
  {
    this.jdField_a_of_type_Amcj = paramamcj;
    this.jdField_a_of_type_Amcj.bind(this);
  }
  
  public void a(@NonNull amck paramamck1, @NonNull amck paramamck2)
  {
    this.jdField_a_of_type_Amck = paramamck1;
    this.jdField_a_of_type_Amck.a(this);
    this.b = paramamck2;
    this.b.a(this);
  }
  
  public void a(@NonNull amcn paramamcn)
  {
    this.jdField_a_of_type_Amcn = paramamcn;
    this.jdField_a_of_type_Amcn.a(this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    ambu localambu = ambu.a();
    ambx localambx = localambu.a();
    if (localambx != null)
    {
      if (this == localambx) {}
      localambu.d();
    }
    localambu.a(this);
    localambu.a(this.jdField_a_of_type_Amcj);
    localambu.a(this.jdField_a_of_type_Amck, this.b);
    localambu.a(this.jdField_a_of_type_Amcn);
    localambu.a(paramChatMessage);
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
    ambu.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a().b(paramInt1, paramInt2);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    ambu localambu;
    do
    {
      do
      {
        do
        {
          return;
          localambu = ambu.a();
        } while ((!localambu.c()) || (localambu.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null));
        if (paramChatMessage.uniseq == localambu.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) {
          break;
        }
      } while (this != localambu.a());
      localambu.f();
      return;
    } while (this == localambu.a());
    localambu.a(this);
    localambu.a(this.jdField_a_of_type_Amcj);
    localambu.a(this.jdField_a_of_type_Amck, this.b);
    if (localambu.jdField_a_of_type_Amcn != null) {
      a(localambu.jdField_a_of_type_Amcn);
    }
    localambu.e();
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
    ambu.a().c();
  }
  
  public void c(int paramInt)
  {
    ambu.a().c(paramInt);
  }
  
  public boolean c()
  {
    ambu localambu = ambu.a();
    return (this == localambu.a()) && (localambu.c());
  }
  
  public int d()
  {
    return a().d();
  }
  
  public void d()
  {
    ambu localambu = ambu.a();
    if (this == localambu.a()) {
      localambu.d();
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Amck != null) && (this.jdField_a_of_type_Amck.a(1));
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
 * Qualified Name:     ambx
 * JD-Core Version:    0.7.0.1
 */