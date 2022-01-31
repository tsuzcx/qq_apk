import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder;

public class airp
  implements Runnable
{
  public airp(TeamWorkShareActionSheetBuilder paramTeamWorkShareActionSheetBuilder) {}
  
  public void run()
  {
    if (this.a.a.getWidth() < TeamWorkShareActionSheetBuilder.a(this.a)) {
      this.a.a.setMove(true);
    }
    while (this.a.b.getWidth() < TeamWorkShareActionSheetBuilder.b(this.a))
    {
      this.a.b.setMove(true);
      return;
      this.a.a.setMove(false);
    }
    this.a.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airp
 * JD-Core Version:    0.7.0.1
 */