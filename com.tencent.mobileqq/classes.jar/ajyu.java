import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ajyu
  extends ajey
{
  public ajyu(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString)
  {
    paramString = this.a.getActivity();
    String str1 = HiddenChatFragment.a(this.a).getCurrentAccountUin();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      paramInt1 = 0;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramInt2 = ((Integer)paramMap.get(str2)).intValue();
        if (paramInt2 == 4000) {
          baig.j(paramString, str1, str2);
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt2 != 0)
      {
        paramInt1 = 1;
        continue;
        if (paramInt1 == 0) {
          baig.j(this.a.getActivity(), HiddenChatFragment.a(this.a).getCurrentAccountUin());
        }
        return;
      }
    }
  }
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.a.getActivity().isFinishing())
      {
        paramString1 = paramString2;
        if (!"troop_delete_top_from_conversation".equals(paramString3))
        {
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = this.a.getResources().getString(2131629250);
          }
          bbmy.a(this.a.getActivity(), 1, paramString1, 0).a();
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onSetCommonUsedTroop, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
      this.a.a();
      paramString1 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajyu
 * JD-Core Version:    0.7.0.1
 */