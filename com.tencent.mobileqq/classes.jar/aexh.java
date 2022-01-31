import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class aexh<T>
  extends aexl<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public aexh(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new aexi(this, paramInt));
  }
  
  public aexr a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return b(paramContext, paramViewGroup, paramInt);
  }
  
  protected abstract void a(aexr paramaexr, T paramT, int paramInt);
  
  protected abstract aexr b(Context paramContext, ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexh
 * JD-Core Version:    0.7.0.1
 */