import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AddRequestActivity.13.1;
import com.tencent.mobileqq.activity.AddRequestActivity.13.2;
import com.tencent.mobileqq.activity.AddRequestActivity.13.3;
import java.util.ArrayList;

public class acdo
  extends alrl
{
  public acdo(AddRequestActivity paramAddRequestActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.b) && (this.a.b != 0L)) {
      this.a.runOnUiThread(new AddRequestActivity.13.3(this));
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.b != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.b)))) {
      this.a.runOnUiThread(new AddRequestActivity.13.2(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b != 0L) && (String.valueOf(this.a.b).equals(paramString))) {
      this.a.runOnUiThread(new AddRequestActivity.13.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdo
 * JD-Core Version:    0.7.0.1
 */