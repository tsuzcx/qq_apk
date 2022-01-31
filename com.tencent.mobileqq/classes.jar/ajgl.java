import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;

public abstract class ajgl<T extends CustomEmotionBase>
  extends ajfb
{
  protected ajgl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public abstract void a();
  
  protected abstract void a(Object paramObject, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajgl
 * JD-Core Version:    0.7.0.1
 */