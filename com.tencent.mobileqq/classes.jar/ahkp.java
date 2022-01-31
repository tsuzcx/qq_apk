import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ahkp<T>
  extends ahkt<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public ahkp(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new ahkq(this, paramInt));
  }
  
  public ahkz a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return b(paramContext, paramViewGroup, paramInt);
  }
  
  protected abstract void a(ahkz paramahkz, T paramT, int paramInt);
  
  protected abstract ahkz b(Context paramContext, ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkp
 * JD-Core Version:    0.7.0.1
 */