import android.graphics.drawable.Drawable;

public class alkb
{
  public final int a;
  public final Drawable a;
  public final boolean a;
  public final boolean b;
  
  private alkb(int paramInt, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  static alkb a()
  {
    return new alkb(2, null, false, false);
  }
  
  static alkb a(Drawable paramDrawable, boolean paramBoolean)
  {
    return new alkb(0, paramDrawable, paramBoolean, false);
  }
  
  static alkb a(boolean paramBoolean)
  {
    return new alkb(1, null, false, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alkb
 * JD-Core Version:    0.7.0.1
 */