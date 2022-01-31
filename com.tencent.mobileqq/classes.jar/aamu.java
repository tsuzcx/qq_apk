import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aamu
  extends ajey
{
  public aamu(Conversation paramConversation) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString)
  {
    paramString = this.a.a();
    String str1 = this.a.a.getCurrentAccountUin();
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
          baig.j(this.a.a(), this.a.a.getCurrentAccountUin());
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
      if (!this.a.a().isFinishing())
      {
        paramString1 = paramString2;
        if (Conversation.a(this.a))
        {
          paramString1 = paramString2;
          if (!"troop_delete_top_from_conversation".equals(paramString3))
          {
            paramString1 = paramString2;
            if (TextUtils.isEmpty(paramString2)) {
              paramString1 = this.a.a().getString(2131629250);
            }
            bbmy.a(this.a.a(), 1, paramString1, 0).a();
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onSetCommonUsedTroop, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
      this.a.a(9, paramString1, 1);
      paramString1 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aamu
 * JD-Core Version:    0.7.0.1
 */