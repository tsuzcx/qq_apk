import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class aiim
  extends andd
{
  public aiim(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  protected void onGetTroopRecommendGrayTipsPerson(boolean paramBoolean1, String paramString1, ArrayList<aihw> paramArrayList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopRecommendGrayTipsPerson ").append(paramBoolean1).append(" ").append(paramString1).append(" ");
      if (paramArrayList == null)
      {
        localObject = "";
        QLog.i("TroopRecommendFriendFragment", 2, localObject + " " + paramBoolean2 + " " + paramString2);
      }
    }
    else if ((paramBoolean1) && (TroopRecommendFriendFragment.a(this.a).equals(paramString1)))
    {
      TroopRecommendFriendFragment.a(this.a).setVisibility(8);
      if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
        break label167;
      }
      TroopRecommendFriendFragment.a(this.a, paramArrayOfByte);
      TroopRecommendFriendFragment.a(this.a).a(paramArrayList);
      TroopRecommendFriendFragment.a(this.a).notifyDataSetChanged();
    }
    label167:
    do
    {
      do
      {
        return;
        localObject = Integer.valueOf(paramArrayList.size());
        break;
      } while (TextUtils.isEmpty(paramString2));
      if (QLog.isColorLevel()) {
        QLog.i("TroopRecommendFriendFragment", 2, "onGetTroopRecommendGrayTipsPerson no data");
      }
      TroopRecommendFriendFragment.a(this.a).setVisibility(0);
      paramString1 = TroopRecommendFriendFragment.a(this.a).findViewById(2131373009);
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      paramString1 = (TextView)TroopRecommendFriendFragment.a(this.a).findViewById(2131379944);
    } while (paramString1 == null);
    paramString1.setText(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiim
 * JD-Core Version:    0.7.0.1
 */