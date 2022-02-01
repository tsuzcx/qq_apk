import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.5;
import com.tencent.biz.troopgift.TroopGiftPanel.GiftNumInputDialog.6;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class aajo
  implements View.OnClickListener, bips
{
  protected Dialog a;
  protected EditText a;
  protected TextView a;
  protected TextView b;
  
  @TargetApi(11)
  public aajo(TroopGiftPanel paramTroopGiftPanel, Context paramContext)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramContext, 2131755166);
    Window localWindow = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    localWindow.setSoftInputMode(16);
    View localView = localWindow.getDecorView();
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -2);
    paramContext = LayoutInflater.from(paramContext).inflate(2131560678, null);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramContext);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    paramContext = (InputMethodLinearLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367737);
    paramContext.setOnSizeChangedListenner(this);
    this.b = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365072));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131364257));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367743));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new aajp(this, paramTroopGiftPanel));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new aajq(this, paramTroopGiftPanel));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramContext.setOnClickListener(new aajr(this, paramTroopGiftPanel));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppDialog.setOnShowListener(new aajs(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new aajn(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, 5) });
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_Aajv.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
      ((BaseChatPie)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b.get()).showGiftPanel(false);
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method");
    View localView = this.jdField_a_of_type_AndroidAppDialog.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (nty.a().a(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()))
    {
      i = 2;
      switch (paramView.getId())
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      break;
      c();
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.5(this), 100L);
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4)
      {
        anzp.a("gift_store", "cancel_num", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
      }
      else
      {
        bdla.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numcancel", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString, "" + mvi.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
        continue;
        c();
        String str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(str);
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.postDelayed(new TroopGiftPanel.GiftNumInputDialog.6(this), 100L);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.k >= 4) {
          anzp.a("gift_store", "sure_num", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() + "", "", "");
        } else {
          bdla.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", i, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_c_of_type_JavaLangString, "" + mvi.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajo
 * JD-Core Version:    0.7.0.1
 */