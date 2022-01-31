import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.PlusPanelAdapter.ViewHolder;
import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.troop.widget.PublishItemContainer;

public class aiyu
  implements View.OnClickListener
{
  public aiyu(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((PlusPanelAdapter.ViewHolder)paramView.getTag()).a)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.a.k) {
                TroopBarUtils.a(this.a.m, this.a.n, "Clk_photo", this.a.o, "", "", "");
              }
            } while (this.a.a(1));
            if ((this.a.a.a() != 0) && (this.a.a.a() != 1))
            {
              this.a.a(1);
              return;
            }
            this.a.g();
            return;
            if (this.a.k) {
              TroopBarUtils.a(this.a.m, this.a.n, "Clk_shoot", this.a.o, "", "", "");
            }
          } while (this.a.a(1));
          if ((this.a.a.a() != 0) && (this.a.a.a() != 1))
          {
            this.a.a(0);
            return;
          }
          this.a.h();
          return;
          if (this.a.k)
          {
            TroopBarUtils.a(this.a.m, this.a.n, "Clk_record", this.a.o, "", "", "");
            TroopBarUtils.b("reply_page_new", "Clk_record", this.a.o, "", "", "");
          }
        } while (this.a.a(2));
        if ((this.a.a.a() != 0) && (this.a.a.a() != 2))
        {
          this.a.a(2);
          return;
        }
        if (this.a.a.a() == 2)
        {
          this.a.a(5);
          return;
        }
        TroopBarReplyActivity.a(this.a, 4);
        return;
        if (this.a.k)
        {
          TroopBarUtils.a(this.a.m, this.a.n, "Clk_music", this.a.o, "", "", "");
          TroopBarUtils.b("reply_page_new", "Clk_music", this.a.o, "", "", "");
        }
      } while (this.a.a(4));
      if ((this.a.a.a() != 0) && (this.a.a.a() != 3))
      {
        this.a.a(3);
        return;
      }
      this.a.b(4);
      return;
      if (this.a.k)
      {
        TroopBarUtils.a(this.a.m, this.a.n, "Clk_video", this.a.o, "", "", "");
        TroopBarUtils.b("reply_page_new", "Clk_video", this.a.o, "", "", "");
      }
    } while (this.a.a(8));
    if ((this.a.a.a() != 0) && (this.a.a.a() != 4))
    {
      this.a.a(7);
      return;
    }
    this.a.b(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyu
 * JD-Core Version:    0.7.0.1
 */