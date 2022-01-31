import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class ahga<T>
  extends ahge<T>
{
  protected int a;
  protected Context a;
  protected LayoutInflater a;
  
  public ahga(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a(new ahgb(this, paramInt));
  }
  
  public ahgk a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    return b(paramContext, paramViewGroup, paramInt);
  }
  
  protected abstract void a(ahgk paramahgk, T paramT, int paramInt);
  
  protected abstract ahgk b(Context paramContext, ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahga
 * JD-Core Version:    0.7.0.1
 */