import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class afiv<T>
  extends afiz<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public afiv(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new afiw(this, paramInt));
  }
  
  public afjf a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return b(paramContext, paramViewGroup, paramInt);
  }
  
  protected abstract void a(afjf paramafjf, T paramT, int paramInt);
  
  protected abstract afjf b(Context paramContext, ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afiv
 * JD-Core Version:    0.7.0.1
 */