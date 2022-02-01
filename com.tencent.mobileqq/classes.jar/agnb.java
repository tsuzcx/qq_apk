import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class agnb
  extends agni
{
  private boolean c;
  
  public agnb(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public int a()
  {
    return 2130846204;
  }
  
  protected void a()
  {
    if (!this.c) {
      return;
    }
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.c) {
      return;
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.c) {
      return;
    }
    super.a(paramTextView);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (!this.c) {
      return;
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.c) {
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    this.b = true;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.c = true;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.c = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.c) {}
    boolean bool;
    do
    {
      return;
      super.b(paramBoolean);
      bool = c();
      if (!paramBoolean) {
        break;
      }
    } while (bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setBackgroundResource(2130838172);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.setBackgroundResource(2130838172);
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void d()
  {
    if (!this.c) {
      return;
    }
    super.d();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(null, "dc00898", "", "", "0X800A48A", "0X800A48A", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnb
 * JD-Core Version:    0.7.0.1
 */