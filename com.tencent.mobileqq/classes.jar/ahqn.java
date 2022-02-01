import android.content.Context;
import android.view.View;
import com.tencent.widget.XPanelContainer;

class ahqn
  implements ahqf<View>
{
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "chatPie change";
    case 2: 
      return "chatPie change EXT_PANEL_AUDIO";
    }
    return "chatPie change SOFT_INPUT_PANEL";
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 1);
  }
  
  public int a()
  {
    return 39;
  }
  
  public View a()
  {
    return null;
  }
  
  public View a(Context paramContext)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool1 = a(paramInt1);
    boolean bool2 = a(paramInt2);
    if (bool2) {
      banp.a().b(a(paramInt2));
    }
    if ((bool1) && (!bool2)) {
      banp.a().a(a(paramInt1));
    }
  }
  
  public void a(XPanelContainer paramXPanelContainer) {}
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahqn
 * JD-Core Version:    0.7.0.1
 */