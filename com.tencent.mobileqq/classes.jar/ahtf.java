import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahtf
  implements View.OnClickListener
{
  ahtf(ahte paramahte) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (paramView == this.a.a)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof StructMsgForImageShare)) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (ahte.a(((StructMsgForImageShare)localObject1).mMsgActionData))
      {
        this.a.b((StructMsgForImageShare)localObject1, "5");
      }
      else if (ahte.b(((StructMsgForImageShare)localObject1).mMsgActionData))
      {
        ahte.a(this.a, (StructMsgForImageShare)localObject1);
        Object localObject3 = ahte.b(((StructMsgForImageShare)localObject1).mMsgActionData);
        if ((localObject3 != null) && (localObject3.length > 2))
        {
          localObject1 = "";
          Object localObject2 = Uri.parse(localObject3[1]);
          try
          {
            localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              localException.printStackTrace();
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          localObject1 = "";
          if (localObject3.length > 3)
          {
            localObject3 = localObject3[3];
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              if (((String)localObject3).equals("1")) {}
            }
            else
            {
              localObject1 = "";
            }
          }
          oat.a(null, "", "0X800712E", "0X800712E", 0, 0, (String)localObject2, (String)localObject1, "", "");
          oat.a("0X800712E", "", (String)localObject2, (String)localObject1, "", "");
          continue;
          if (paramView == this.a.b)
          {
            localObject1 = paramView.getTag();
            if ((localObject1 instanceof StructMsgForImageShare)) {
              this.a.c((StructMsgForImageShare)localObject1, "5");
            }
          }
          else if (paramView == this.a.c)
          {
            localObject1 = paramView.getTag();
            if ((localObject1 instanceof StructMsgForImageShare)) {
              localObject1 = (StructMsgForImageShare)localObject1;
            }
            this.a.c(4);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtf
 * JD-Core Version:    0.7.0.1
 */