import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ajcv<T>
  extends ajcz<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public ajcv(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new ajcw(this, paramInt));
  }
  
  protected abstract ajdf a(Context paramContext, ViewGroup paramViewGroup, int paramInt);
  
  protected abstract void a(ajdf paramajdf, T paramT, int paramInt);
  
  public ajdf b(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramContext, paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcv
 * JD-Core Version:    0.7.0.1
 */