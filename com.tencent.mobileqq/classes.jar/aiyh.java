import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aiyh
  extends aiyf
  implements aixo, View.OnClickListener
{
  private aixn jdField_a_of_type_Aixn;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aiyi(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView.OnEditorActionListener jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener = new aiyj(this);
  
  public aiyh(aixy paramaixy, QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    super(paramQQAppInterface, paramaixy);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Aixn = new aixn();
  }
  
  private void i()
  {
    SpannableString localSpannableString;
    if (a().a())
    {
      localSpannableString = this.jdField_a_of_type_Aixn.a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
    }
    do
    {
      return;
      if (a().b())
      {
        localSpannableString = this.jdField_a_of_type_Aixn.a(a().b());
        this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_Aixn.a(), this.jdField_a_of_type_Aixn.a());
        return;
      }
    } while (!a().c());
    k();
  }
  
  private void j()
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor("#777777"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor("#03081a"));
  }
  
  private void k()
  {
    Object localObject = a().b();
    if (bhsr.a((String)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      a().a(5);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_a_of_type_Aixn.b();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131715630), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if (this.jdField_a_of_type_Aixn.a((String)localObject))
    {
      j();
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_Aixn.b();
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      a().a(5);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject).length(), ((String)localObject).length());
      return;
    }
    localObject = this.jdField_a_of_type_Aixn.a((String)localObject);
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_Aixn.a(), this.jdField_a_of_type_Aixn.a());
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextEditViewHelper.3(this));
  }
  
  public void a(aixv paramaixv)
  {
    super.a(paramaixv);
    this.jdField_a_of_type_Aixn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167074), this);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramVoiceTextPanel.findViewById(2131365815));
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setLines(100);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aixn.a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Aixn.b();
  }
  
  public void onClick(View paramView)
  {
    if ((a().a()) || (a().b())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, anzj.a(2131715637), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiyh
 * JD-Core Version:    0.7.0.1
 */