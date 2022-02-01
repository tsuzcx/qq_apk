import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;

public class aitk
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<Drawable> jdField_a_of_type_JavaUtilList;
  private int b;
  
  public aitk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(List<Drawable> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.b = (paramInt * 2);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      localDrawable = ((bgga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(localDrawable, this.jdField_a_of_type_Int);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, this.b, this.b);
        localDrawable.draw(paramCanvas);
        paramCanvas.translate(this.jdField_a_of_type_Int, 0.0F);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aitk
 * JD-Core Version:    0.7.0.1
 */