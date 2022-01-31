import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy;
import com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoyManager;
import java.util.Comparator;

public class aife
  implements Comparator
{
  public aife(GLLittleBoyManager paramGLLittleBoyManager) {}
  
  public int a(GLLittleBoy paramGLLittleBoy1, GLLittleBoy paramGLLittleBoy2)
  {
    int i = (int)paramGLLittleBoy1.b().centerY();
    paramGLLittleBoy1.c = i;
    int j = (int)paramGLLittleBoy2.b().centerY();
    paramGLLittleBoy2.c = j;
    if (i < j) {
      return -1;
    }
    if (i > j) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aife
 * JD-Core Version:    0.7.0.1
 */