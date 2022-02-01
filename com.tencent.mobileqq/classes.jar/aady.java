import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aady
  extends QQCustomDialog
{
  protected EditText a;
  
  protected aady(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static aady a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    aady localaady = new aady(paramContext, 2131755826);
    localaady.setContentView(2131559016);
    localaady.setTitle(paramString1);
    localaady.setMessage(paramString2);
    localaady.a(paramInt1, paramOnClickListener2);
    localaady.b(paramInt2, paramOnClickListener1);
    localaady.setCanceledOnTouchOutside(false);
    paramString1 = new EditText(paramContext);
    paramString1.setSingleLine();
    paramString1.setFilters(new InputFilter[] { new InputFilter.LengthFilter(120) });
    paramString1.setBackgroundResource(2130843755);
    paramString1.setPadding(20, 0, 20, 0);
    paramString1.setHeight(AIOUtils.dp2px(37.0F, paramContext.getResources()));
    paramString1.setTextSize(1, 14.0F);
    paramString2 = new LinearLayout.LayoutParams(-1, AIOUtils.dp2px(37.0F, paramContext.getResources()));
    paramString2.topMargin = AIOUtils.dp2px(11.0F, paramContext.getResources());
    paramString1.setLayoutParams(paramString2);
    localaady.a(paramString1);
    return localaady;
  }
  
  public aady a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramInt);
    this.lBtn.setContentDescription(getContext().getString(paramInt));
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new aadz(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  protected void a(EditText paramEditText)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.dp2px(16.0F, getContext().getResources());
    localLayoutParams.topMargin = AIOUtils.dp2px(8.0F, getContext().getResources());
    ((RelativeLayout.LayoutParams)this.title.getLayoutParams()).bottomMargin = AIOUtils.dp2px(5.0F, getContext().getResources());
    addView(paramEditText);
    this.a = paramEditText;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      this.text.setText(paramString);
      this.text.setTextSize(1, 16.0F);
      this.text.setGravity(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(9.0F, getContext().getResources());
      this.text.setLayoutParams(localLayoutParams);
      this.text.setContentDescription(paramString);
      this.text.setVisibility(0);
      this.text.setTextColor(paramInt);
      ((RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams()).topMargin = 0;
      return;
    }
    this.text.setVisibility(8);
  }
  
  public aady b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramInt);
    this.rBtn.setContentDescription(getContext().getString(paramInt));
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new aaea(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public EditText getEditText()
  {
    return this.a;
  }
  
  public String getInputValue()
  {
    return this.a.getText().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aady
 * JD-Core Version:    0.7.0.1
 */