import android.graphics.Rect;

public class afqm
{
  public int a;
  public Rect a;
  public int b;
  public Rect b = new Rect();
  public int c;
  public Rect c;
  public int d;
  public int e;
  public int f;
  
  public afqm()
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("currAlpha = ").append(this.e).append("\n").append("currRect = ");
    if (this.jdField_c_of_type_AndroidGraphicsRect != null)
    {
      str = this.jdField_c_of_type_AndroidGraphicsRect.toShortString();
      localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("radomAreaIndex = ").append(this.f).append("\n").append("radomRect = ");
      if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
        break label182;
      }
      str = this.jdField_a_of_type_AndroidGraphicsRect.toShortString();
      label95:
      localStringBuilder2 = localStringBuilder2.append(str).append("\n").append("gapDuration = ").append(this.jdField_c_of_type_Int).append("\n").append("startRect = ");
      if (this.b == null) {
        break label188;
      }
    }
    label182:
    label188:
    for (String str = this.b.toShortString();; str = "")
    {
      localStringBuilder2.append(str).append("\n").append("edageWidth = ").append(this.jdField_a_of_type_Int).append("\n");
      return localStringBuilder1.toString();
      str = "";
      break;
      str = "";
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afqm
 * JD-Core Version:    0.7.0.1
 */