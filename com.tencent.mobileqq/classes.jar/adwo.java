import com.tencent.mobileqq.music.QQPlayerService;

public class adwo
  implements Runnable
{
  public adwo(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.h() == 2) {
      QQPlayerService.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adwo
 * JD-Core Version:    0.7.0.1
 */