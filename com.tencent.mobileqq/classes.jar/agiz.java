import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;

class agiz
  implements View.OnClickListener
{
  agiz(agiy paramagiy) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a)
    {
      paramView = paramView.getTag();
      if ((paramView instanceof StructMsgForImageShare)) {}
    }
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            return;
            if (agiy.a(((StructMsgForImageShare)paramView).mMsgActionData))
            {
              this.a.b((StructMsgForImageShare)paramView, "5");
              return;
            }
          } while (!agiy.b(((StructMsgForImageShare)paramView).mMsgActionData));
          agiy.a(this.a, (StructMsgForImageShare)paramView);
          localObject2 = agiy.b(((StructMsgForImageShare)paramView).mMsgActionData);
        } while ((localObject2 == null) || (localObject2.length <= 2));
        paramView = "";
        Object localObject1 = Uri.parse(localObject2[1]);
        try
        {
          localObject1 = ((Uri)localObject1).getQueryParameter("article_id");
          paramView = (View)localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = "";
        }
        paramView = "";
        if (localObject2.length > 3)
        {
          localObject2 = localObject2[3];
          if (localObject2 != null)
          {
            paramView = (View)localObject2;
            if (((String)localObject2).equals("1")) {}
          }
          else
          {
            paramView = "";
          }
        }
        nrt.a(null, "", "0X800712E", "0X800712E", 0, 0, (String)localObject1, paramView, "", "");
        nrt.a("0X800712E", "", (String)localObject1, paramView, "", "");
        return;
        if (paramView != this.a.b) {
          break;
        }
        paramView = paramView.getTag();
      } while (!(paramView instanceof StructMsgForImageShare));
      this.a.c((StructMsgForImageShare)paramView, "5");
      return;
    } while (paramView != this.a.c);
    paramView = paramView.getTag();
    if ((paramView instanceof StructMsgForImageShare)) {
      paramView = (StructMsgForImageShare)paramView;
    }
    this.a.c(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiz
 * JD-Core Version:    0.7.0.1
 */