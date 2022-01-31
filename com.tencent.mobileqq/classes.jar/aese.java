import com.tencent.mobileqq.music.QQPlayerService;

public class aese
  implements Runnable
{
  public aese(QQPlayerService paramQQPlayerService) {}
  
  public void run()
  {
    if (QQPlayerService.h() == 2) {
      QQPlayerService.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aese
 * JD-Core Version:    0.7.0.1
 */