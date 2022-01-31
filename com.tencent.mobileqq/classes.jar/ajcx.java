import android.content.res.Resources;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView;
import com.tencent.mobileqq.app.QQAppInterface;

public class ajcx
  implements ajdg
{
  public ajcx(ApolloPanel paramApolloPanel) {}
  
  public void a(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    ApolloPanel.e(this.a);
    if (!ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip"))
    {
      ApolloPanel.a(this.a, "sp_key_apollo_show_guide_tip");
      ApolloPanel.a(this.a, ApolloPanel.a(this.a), 49, this.a.getResources().getString(2131624562), 5);
    }
  }
  
  public void b(ApolloPanelGuideView paramApolloPanelGuideView)
  {
    ApolloPanel.e(this.a);
    paramApolloPanelGuideView = (baot)this.a.a.a.a(71);
    paramApolloPanelGuideView.a(new ajcy(this, paramApolloPanelGuideView));
    paramApolloPanelGuideView.c("guide_page", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajcx
 * JD-Core Version:    0.7.0.1
 */