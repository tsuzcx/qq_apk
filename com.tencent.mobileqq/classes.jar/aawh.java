import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.mini.entry.MiniAppPullInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class aawh
  implements ahgm
{
  public aawh(Conversation paramConversation) {}
  
  public void a()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a();
    }
  }
  
  public void a(int paramInt)
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).b(paramInt);
    }
  }
  
  public void a(Bitmap paramBitmap, String paramString, List<Bitmap> paramList)
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(paramBitmap, paramString, paramList);
    }
  }
  
  public void a(ViewGroup paramViewGroup, Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ahgl.a().a(this.a.a, paramViewGroup, paramString1, paramString2, paramString3, paramString4, paramBitmap);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((Conversation.a(this.a).hasOpenDesktop()) || (AppSetting.d))
    {
      QLog.i("Q.recent", 2, "mini app opened, enableTalkBack: " + AppSetting.d);
      throw new IllegalStateException("mini app opened or accessibility enabled");
    }
    if (Conversation.a(this.a) == null) {
      Conversation.a(this.a, new ahgn(this.a));
    }
    Conversation.a(this.a).a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, SpringFestivalRedpakcetPreviewConfBean.BreathLight paramBreathLight)
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(paramBoolean, paramBreathLight);
    }
  }
  
  public void b()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(true);
    }
  }
  
  public void c()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a(false);
    }
  }
  
  public void d()
  {
    if (Conversation.a(this.a) != null) {
      Conversation.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aawh
 * JD-Core Version:    0.7.0.1
 */