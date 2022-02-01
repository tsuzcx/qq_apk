import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AddRequestActivity.13.1;
import com.tencent.mobileqq.activity.AddRequestActivity.13.2;
import com.tencent.mobileqq.activity.AddRequestActivity.13.3;
import java.util.ArrayList;

public class acqp
  extends amrc
{
  public acqp(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onAddDiscussionMember(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if ((paramBoolean) && (paramLong == this.a.b) && (this.a.b != 0L)) {
      this.a.runOnUiThread(new AddRequestActivity.13.3(this));
    }
  }
  
  protected void onChangeDiscussionName(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.b != 0L) && (String.valueOf(this.a.b).equals(paramString))) {
      this.a.runOnUiThread(new AddRequestActivity.13.1(this));
    }
  }
  
  protected void updateDiscussionInfo(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.b != 0L) && (paramBoolean) && ((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).contains(Long.valueOf(this.a.b)))) {
      this.a.runOnUiThread(new AddRequestActivity.13.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */