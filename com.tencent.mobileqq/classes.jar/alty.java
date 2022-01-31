import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class alty
{
  private alrw jdField_a_of_type_Alrw;
  private alsd jdField_a_of_type_Alsd;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private bafb jdField_a_of_type_Bafb;
  
  public alty(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Alrw = new alrw();
    this.jdField_a_of_type_Alrw.a(new alry());
  }
  
  private ColorNote a()
  {
    if (this.jdField_a_of_type_Alsd != null) {
      return this.jdField_a_of_type_Alsd.getColorNote();
    }
    return null;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = new bafb(this.jdField_a_of_type_AndroidContentContext, 2131690181);
      this.jdField_a_of_type_Bafb.setContentView(2131493345);
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bafb.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131625297));
      this.jdField_a_of_type_Bafb.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131625296), new altz(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_Bafb.show();
      TextView localTextView = this.jdField_a_of_type_Bafb.getTitleTextView();
      localTextView.setClickable(true);
      localTextView.setFocusable(true);
      localTextView.setFocusableInTouchMode(true);
      azve.a(localTextView, true);
      return;
      if (this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
    }
  }
  
  public alsd a()
  {
    return this.jdField_a_of_type_Alsd;
  }
  
  public void a()
  {
    ColorNote localColorNote = a();
    if (localColorNote != null)
    {
      this.jdField_a_of_type_Alrw.a(localColorNote.parseBundle());
      awqx.b(null, "dc00898", "", "", "0X800A743", "0X800A743", alru.a(this.jdField_a_of_type_Alsd.getColorNote().mServiceType), 0, "", "", "", "");
    }
  }
  
  public void a(alry paramalry)
  {
    this.jdField_a_of_type_Alrw.a(paramalry);
  }
  
  public void a(alsd paramalsd)
  {
    this.jdField_a_of_type_Alsd = paramalsd;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(ColorNote paramColorNote)
  {
    this.jdField_a_of_type_Alrw.a(paramColorNote);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Alrw.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Alsd != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType());
        awqx.b(null, "dc00898", "", "", "0X800A748", "0X800A748", alru.a(this.jdField_a_of_type_Alsd.getColorNote().mServiceType), 0, "", "", "", "");
      }
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Alsd != null)
    {
      ColorNote localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
      if (localColorNote != null) {
        return this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType());
      }
    }
    return false;
  }
  
  public void c()
  {
    d();
    awqx.b(null, "dc00898", "", "", "0X800A6CF", "0X800A6CF", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alty
 * JD-Core Version:    0.7.0.1
 */