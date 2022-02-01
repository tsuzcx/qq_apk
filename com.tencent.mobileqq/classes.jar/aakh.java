import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.10;
import com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.11;
import com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.12;
import com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class aakh
  extends aake
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private aakf jdField_a_of_type_Aakf;
  private aakp jdField_a_of_type_Aakp;
  private aakq jdField_a_of_type_Aakq;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected View a;
  private AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public CommentEditText a;
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  private SystemAndEmojiEmoticonPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ImageButton jdField_b_of_type_AndroidWidgetImageButton;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public aakh(Activity paramActivity)
  {
    super(paramActivity, 2131755408);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131558764, null);
    b();
    setCancelable(true);
    d();
    setContentView(this.jdField_a_of_type_AndroidViewView);
    f();
    setOnDismissListener(this);
    L_();
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
    }
    d(this.jdField_b_of_type_AndroidViewView);
    if (paramBoolean) {
      a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    }
  }
  
  private void c(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364804));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363798));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText = ((CommentEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131378684));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnInputBackListener(new aaki(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setEditableFactory(behe.c);
    this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131363841));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363885));
    this.jdField_a_of_type_AndroidContentSharedPreferences = getContext().getSharedPreferences("weishi_comment_prefs_version", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("GroupSoftKeyboardHeight", agej.a(250.0F, getContext().getResources()));
    QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step1 :" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = bdep.a(250.0F);
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel initView() step2 :" + this.jdField_a_of_type_Int);
    }
    e();
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363548);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aakj(this));
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("input_method"));
    this.jdField_a_of_type_Boolean = true;
    g();
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void d(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    aakk localaakk = new aakk(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int i = getContext().getResources().getDimensionPixelSize(2131299011);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131365926));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(localaakk);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, getContext(), i, null, null, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
    }
    do
    {
      return;
      QLog.e("QCircleBaseInputPopupWindow", 1, "initEmojiPanel() runtime != QQAppInterface");
    } while ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = new SystemAndEmojiEmoticonPanel(this.jdField_a_of_type_AndroidAppActivity, localaakk);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    i();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getLayoutParams().height = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.invalidate();
      QLog.d("QCircleBaseInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.jdField_a_of_type_Int);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Aakf = new aakf(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Aakf.a(new aakm(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setImeOptions(268435456);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setOnEditorActionListener(new aakn(this));
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.addTextChangedListener(new aako(this));
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_Boolean) {
      c(this.jdField_b_of_type_AndroidViewView);
    }
    this.c = true;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
    }
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
  }
  
  @TargetApi(19)
  public void L_()
  {
    int i = 0;
    super.L_();
    Object localObject = getWindow();
    if (localObject == null) {}
    label102:
    for (;;)
    {
      return;
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        localObject = ((ViewGroup)localObject).getChildAt(0);
        if ((localObject instanceof ViewGroup))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          for (;;)
          {
            if (i >= j) {
              break label102;
            }
            View localView = ((ViewGroup)localObject).getChildAt(i);
            if ((localView == null) || (localView.getId() == 16908290)) {
              break;
            }
            if (!(localView instanceof ViewStub)) {
              localView.setAlpha(0.0F);
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return "";
    }
    String str = "";
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof behe))
    {
      localObject = (behe)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
      if (localObject == null) {
        break label147;
      }
      localObject = ((behe)localObject).a();
    }
    for (;;)
    {
      return bnqj.b(((String)localObject).replaceAll(anzj.a(2131704694), anzj.a(2131704696)).replaceAll(anzj.a(2131704693), "/MM").replaceAll(BaseApplicationImpl.sApplication.getResources().getString(2131716430), "/chigua")).trim();
      localObject = str;
      if ((this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText() instanceof begz))
      {
        begz localbegz = (begz)this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.getText();
        localObject = str;
        if (localbegz != null)
        {
          localObject = localbegz.a();
          continue;
          label147:
          localObject = "";
        }
      }
    }
  }
  
  public void a(aakp paramaakp)
  {
    this.jdField_a_of_type_Aakp = paramaakp;
  }
  
  public void a(aakq paramaakq)
  {
    this.jdField_a_of_type_Aakq = paramaakq;
  }
  
  public void a(View paramView)
  {
    paramView.requestFocus();
    paramView.post(new SubscribeCommentInputPopupWindow.9(this, paramView));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setText(paramString);
    this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setSelection(paramString.length());
  }
  
  public void a(boolean paramBoolean)
  {
    show();
    h();
    if (paramBoolean)
    {
      a().post(new SubscribeCommentInputPopupWindow.11(this));
      return;
    }
    a().post(new SubscribeCommentInputPopupWindow.12(this));
  }
  
  protected void b()
  {
    if ((getWindow() != null) && (getWindow().getAttributes() != null))
    {
      Window localWindow = getWindow();
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setSoftInputMode(16);
    }
  }
  
  public void b(View paramView)
  {
    paramView.post(new SubscribeCommentInputPopupWindow.10(this, paramView));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText.setHint(paramString);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(new aakl(this));
      this.jdField_a_of_type_AndroidViewView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.start();
    }
  }
  
  public void dismiss()
  {
    b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentEditText);
    b(false);
    super.dismiss();
  }
  
  public void onClick(View paramView)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onClick:" + paramView.getId());
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.d("QCircleBaseInputPopupWindow", 1, "btn_emotion");
      j();
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      continue;
      QLog.d("QCircleBaseInputPopupWindow", 1, "text_input");
      b(true);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      continue;
      if (this.jdField_a_of_type_Aakp != null)
      {
        this.jdField_a_of_type_Aakp.a();
        continue;
        QLog.d("QCircleBaseInputPopupWindow", 1, "btn_keyboard");
        b(true);
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Aakf != null)
    {
      this.jdField_a_of_type_Aakf.a();
      this.jdField_a_of_type_Aakf = null;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aakq != null) {
      this.jdField_a_of_type_Aakq.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aakh
 * JD-Core Version:    0.7.0.1
 */