import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ajdm<T>
  extends ajdq<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public ajdm(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new ajdn(this, paramInt));
  }
  
  protected abstract ajdw a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(ajdw paramajdw, T paramT, int paramInt);
  
  public ajdw b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdm
 * JD-Core Version:    0.7.0.1
 */