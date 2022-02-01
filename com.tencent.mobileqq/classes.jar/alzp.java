import android.text.TextUtils;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import java.util.List;

public class alzp
  extends aofu
{
  public alzp(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.b)) && (!this.a.b.equals(paramString))) {
      return;
    }
    ThreadManager.post(new TroopMemberListInnerFrame.7.1(this, paramList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alzp
 * JD-Core Version:    0.7.0.1
 */