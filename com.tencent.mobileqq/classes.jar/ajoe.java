import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ajoe<T>
  extends ajoi<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public ajoe(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new ajof(this, paramInt));
  }
  
  protected abstract ajoo a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(ajoo paramajoo, T paramT, int paramInt);
  
  public ajoo b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajoe
 * JD-Core Version:    0.7.0.1
 */