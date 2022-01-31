import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class afix<T>
  extends afjb<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public afix(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new afiy(this, paramInt));
  }
  
  public afjh a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return b(paramContext, paramViewGroup, paramInt);
  }
  
  protected abstract void a(afjh paramafjh, T paramT, int paramInt);
  
  protected abstract afjh b(Context paramContext, ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afix
 * JD-Core Version:    0.7.0.1
 */