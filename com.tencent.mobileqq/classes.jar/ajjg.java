import android.os.CountDownTimer;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;

public class ajjg
  extends CountDownTimer
{
  public ajjg(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    ReciteRecordLayout.a(this.a);
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjg
 * JD-Core Version:    0.7.0.1
 */