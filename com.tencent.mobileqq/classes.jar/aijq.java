import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.miniaio.MiniPie.11;
import com.tencent.mobileqq.activity.miniaio.MiniPie.2;
import com.tencent.mobileqq.activity.miniaio.MiniPie.3;
import com.tencent.mobileqq.activity.miniaio.MiniPie.4;
import com.tencent.mobileqq.activity.miniaio.MiniPie.5;
import com.tencent.mobileqq.activity.miniaio.MiniPie.8;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public abstract class aijq
  implements aiip, Handler.Callback, TextWatcher, View.OnClickListener, bhtu, bhtv, bhzf, Observer
{
  static int e;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  protected long a;
  abts jdField_a_of_type_Abts;
  aiiq jdField_a_of_type_Aiiq;
  aiit jdField_a_of_type_Aiit;
  private altm jdField_a_of_type_Altm = new aijv(this);
  public Context a;
  public MovementMethod a;
  View jdField_a_of_type_AndroidViewView;
  public ViewGroup a;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  WindowManager jdField_a_of_type_AndroidViewWindowManager;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  protected ImageView a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdni jdField_a_of_type_Bdni;
  bdnk jdField_a_of_type_Bdnk = new aijs(this);
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public QQAppInterface a;
  public ChatXListView a;
  public MessageForReplyText.SourceMsgInfo a;
  public EmoticonMainPanel a;
  public XEditTextEx a;
  protected XPanelContainer a;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public String a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public boolean a;
  int jdField_b_of_type_Int = 0;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  protected TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 2;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  protected boolean c;
  int jdField_d_of_type_Int = 0;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  protected boolean d;
  protected boolean e;
  protected int f;
  private boolean f;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  
  public aijq(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "MiniPie";
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    MiniChatConstants.SCREEN_HEIGHT = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels;
    if (MiniChatConstants.SCREEN_HEIGHT <= 0)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 1, "SCREEN_HEIGHT <= 0 reset to 1080");
      MiniChatConstants.SCREEN_HEIGHT = 1080;
    }
    y();
  }
  
  private void A()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849273);
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(Color.argb(255, 3, 8, 26));
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackground(null);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
  }
  
  private void B()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844445);
      localImageView = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368638);
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849576));
      localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368053);
      Object localObject = localImageView.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = aepi.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = aepi.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850060));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166900));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166900));
      this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.8F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.8F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844444);
    ImageView localImageView = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368638);
    localImageView.setBackgroundResource(0);
    if (azmk.b()) {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844382));
    }
    for (;;)
    {
      localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368053);
      localImageView.setBackgroundResource(0);
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850061));
      return;
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130849577));
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onAudioVideoBtnClick curType=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " curFriendUin= " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    }
    mte.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3);
  }
  
  private void D()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void E()
  {
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.post(new MiniPie.4(this));
  }
  
  private void F()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshListAdaper dirty " + this.jdField_f_of_type_Int);
    }
    List localList1 = this.jdField_a_of_type_Aiiq.a();
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, -1L, true);
    EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1, localList2);
    a(localList1, localList2);
    b(localList1, localList2);
    this.jdField_f_of_type_Int = 0;
  }
  
  private int a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1];
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "updateListUnRead: " + paramInt);
    }
    if ((paramInt == 0) && (this.jdField_c_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0) {
      return;
    }
    if (this.jdField_c_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setId(2131370829);
      ((TextView)localObject1).setBackgroundResource(2130838256);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 16.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131368344);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localObject1);
    }
    Object localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3000) || (paramInt == 1);
  }
  
  private boolean c()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public <T extends afez> T a(int paramInt)
  {
    return this.jdField_a_of_type_Aiit.a(paramInt);
  }
  
  public SpannableString a(boolean paramBoolean)
  {
    int k = 0;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((((SessionInfo)localObject).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject).jdField_a_of_type_Int != 3000)) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName))) {
      return null;
    }
    boolean bool1;
    String str1;
    Context localContext;
    String str2;
    String str3;
    XEditTextEx localXEditTextEx;
    if (((HotChatManager)localQQAppInterface.getManager(60)).a(((SessionInfo)localObject).jdField_a_of_type_JavaLangString) != null)
    {
      bool1 = true;
      str1 = bdgc.a(localQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_Int, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
      localContext = this.jdField_a_of_type_AndroidContentContext;
      str2 = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "";
      localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (((SessionInfo)localObject).jdField_a_of_type_Int != 1) {
        break label224;
      }
    }
    label224:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = bciq.a(localQQAppInterface, localContext, str2, str3, str1, bool1, localXEditTextEx, bool2, true);
      if ((localObject != null) && (((SpannableString)localObject).length() > 0)) {
        break label230;
      }
      return null;
      bool1 = false;
      break;
    }
    label230:
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject);
      return localObject;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(k, (CharSequence)localObject);
      return localObject;
      k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramLayoutInflater = paramLayoutInflater.inflate(2131558794, paramViewGroup, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.findViewById(2131362208));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364139));
      return paramLayoutInflater;
      paramLayoutInflater = paramView;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setCustomRootView() called hit cache convertView = [" + paramView + "]");
        paramLayoutInflater = paramView;
      }
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Altm);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refresh with dirty: " + paramInt + "|dirty " + this.jdField_f_of_type_Int + " delay " + paramLong);
    }
    if (this.jdField_f_of_type_Int == paramInt) {}
    do
    {
      return;
      int k = paramInt & 0xFFFF0000;
      if ((paramInt & 0xFFFF) > (this.jdField_f_of_type_Int & 0xFFFF)) {
        paramInt &= 0xFFFF;
      }
      for (;;)
      {
        this.jdField_f_of_type_Int = (k | paramInt);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refresh with refreshFlag: " + k + " scrollFlag: " + paramInt);
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
        localMessage.what = 6;
        if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(localMessage.what)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(localMessage.what);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, paramLong);
        return;
        paramInt = this.jdField_f_of_type_Int & 0xFFFF;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update hold for not in Resuming ");
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onNotCompleteVisable");
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_d_of_type_Int = ((Activity)paramContext).getWindow().getAttributes().y;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-1, bdni.a(0), 2, 32, -1);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 81;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.windowAnimations = 2131755184;
    this.jdField_a_of_type_Bdni = new bdni(((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().findViewById(16908290)).getChildAt(0), this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight(), this.jdField_a_of_type_Bdnk);
    this.jdField_j_of_type_Int = this.jdField_a_of_type_Bdni.a();
    this.jdField_j_of_type_Int = bdni.a(this.jdField_j_of_type_Int);
    paramContext = new aijt(this);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559056, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a((QQAppInterface)localAppRuntime, 100003, this.jdField_a_of_type_AndroidContentContext, k, null, null, false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = this.jdField_j_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setDispatchKeyEventListener(new aiju(this));
      return;
    }
    QLog.e(this.jdField_a_of_type_JavaLangString, 1, "get QQAppInterface fail");
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage == null) {}
    do
    {
      return;
      if (paramLong == 0L) {
        afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, Long.parseLong(paramChatMessage.senderuin));
      }
      paramString = agws.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramInt, paramLong, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramString;
    paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
    int k = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
    paramString = bcit.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, paramInt - k, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), null);
    if (paramString != null)
    {
      Drawable localDrawable = paramString.getDrawable();
      Rect localRect = localDrawable.getBounds();
      localDrawable.setBounds(localRect.left, localRect.top + 20, localRect.right, localRect.bottom + 20);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(30);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131373121, paramString);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(bcis.a());
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin)))) {
        a(false);
      }
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredHeight();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMinHeight(paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.11(this), 200L);
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
      return;
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString))) {
      a(131073, 0L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onlyRefreshData not me");
  }
  
  protected void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int k = this.jdField_f_of_type_Int & 0xFFFF0000;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "listViewSrollPosition tempBindType " + k);
    }
    switch (k)
    {
    case 65536: 
    default: 
      return;
    }
    this.jdField_a_of_type_Aiiq.a(paramList2, null, 0);
    this.jdField_a_of_type_AndroidViewViewGroup.invalidate();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558860, null);
        }
        ViewParent localViewParent = this.jdField_a_of_type_AndroidViewView.getParent();
        if (localViewParent != null) {
          ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_a_of_type_AndroidViewView);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aiit = new aiit(this);
    this.jdField_a_of_type_Aiit.a(2);
    b();
    e();
    g();
    d();
    h();
    if (!this.jdField_d_of_type_Boolean)
    {
      w();
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    c();
    u();
    x();
    a();
    this.jdField_a_of_type_Abts = new abts();
    this.jdField_a_of_type_Abts.a = new aeqr(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Abts.jdField_h_of_type_Boolean = true;
    return true;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewCompleteVisableAndReleased");
    }
    v();
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (a(paramMessageRecord.istroop)) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (paramEditable.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    if (localBundle != null)
    {
      this.jdField_h_of_type_Boolean = localBundle.getBoolean("KEY_DELAY_SET_READ", false);
      this.jdField_d_of_type_Boolean = localBundle.getBoolean("KEY_IS_IN_MULTI_AIO", false);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewCompleteVisable");
    }
  }
  
  protected void b(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    int k = 0xFFFF & this.jdField_f_of_type_Int;
    aike localaike = (aike)a(1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "listViewSrollPosition tempScrollType " + k);
    }
    switch (k)
    {
    case 5: 
    case 6: 
    case 7: 
    default: 
      if (localaike != null) {
        this.jdField_g_of_type_Int = localaike.a(paramList1, paramList2, this.jdField_g_of_type_Int);
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "listViewSrollPosition mReadedCnt " + this.jdField_g_of_type_Int + " newSize " + paramList2.size());
      }
      return;
      k = aike.b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_g_of_type_Int, paramList1, paramList2);
      if (k != 0)
      {
        this.jdField_f_of_type_Int = (k + this.jdField_f_of_type_Int);
        b(paramList1, paramList2);
      }
      if (localaike != null)
      {
        this.jdField_g_of_type_Int = localaike.a(paramList1, paramList2, this.jdField_g_of_type_Int);
        continue;
        if (!c()) {
          this.jdField_a_of_type_MqqOsMqqHandler.post(new MiniPie.5(this));
        }
        for (;;)
        {
          this.jdField_g_of_type_Int = paramList2.size();
          break;
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "listViewSrollPosition: disableScrollBottom");
        }
        if (localaike != null)
        {
          this.jdField_g_of_type_Int = localaike.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_g_of_type_Int, paramList1, paramList2);
          continue;
          if (localaike != null)
          {
            localaike.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, 0, paramList1, paramList2);
            k = paramList1.size();
            this.jdField_g_of_type_Int = (paramList2.size() + this.jdField_g_of_type_Int - k);
          }
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      paramCharSequence = (bciq[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, bciq.class);
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, "find beforeTextChanged atTroopMemberSpan1 ..." + paramCharSequence.length + ",start = " + paramInt1 + ",before = " + paramInt2);
      }
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        this.jdField_j_of_type_Boolean = true;
        aiiu.a("0X800A9AC", "1");
      }
    }
  }
  
  protected void c()
  {
    if (jdField_e_of_type_Int == 0) {
      jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131427342);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onViewNotCompleteVisableAndReleased");
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 5)) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.8(this), 200L);
      }
    }
  }
  
  protected void d()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))) {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849473);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849669);
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setDelaySetRead() called with: delaySetRead = [" + paramBoolean + "]");
    }
    this.jdField_h_of_type_Boolean = paramBoolean;
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369527));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() == 0)
    {
      localObject = new View(this.jdField_a_of_type_AndroidContentContext);
      int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, k));
      ((View)localObject).setId(2131362335);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView((View)localObject, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(k);
    }
    a(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_Aiiq = new aiiq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_Aiiq.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    Object localObject = this.jdField_a_of_type_Aiiq;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 3) {}
    for (boolean bool = true;; bool = false)
    {
      ((aiiq)localObject).a(bool);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_Aiiq);
      return;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131375863));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377938));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375874));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378022));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    ImageView localImageView1 = (ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368638);
    localImageView1.setOnClickListener(this);
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131368633));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      A();
    }
    if (this.jdField_d_of_type_Boolean) {
      B();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 5))
    {
      ImageView localImageView2 = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131368053);
      Object localObject = localImageView2.getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        localObject = (RelativeLayout.LayoutParams)localObject;
        ((RelativeLayout.LayoutParams)localObject).width = aepi.a(13.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((RelativeLayout.LayoutParams)localObject).height = aepi.a(13.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localImageView2.setImageResource(2130849541);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localImageView1.setImageResource(2130849664);
      if (Build.VERSION.SDK_INT >= 16) {
        localImageView1.setBackground(null);
      }
    }
    else
    {
      return;
    }
    localImageView1.setBackgroundDrawable(null);
  }
  
  protected void h()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368344));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376034));
    i();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368343));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(bamz.a);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367006));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      Object localObject = (PanelIconLinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371574);
      ((PanelIconLinearLayout)localObject).setPanelIconListener(new aijr(this));
      if (this.jdField_d_of_type_Boolean)
      {
        ((PanelIconLinearLayout)localObject).setCustomHeight(aepi.a(50.0F, ((PanelIconLinearLayout)localObject).getContext().getResources()));
        ((PanelIconLinearLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, this.jdField_d_of_type_Boolean);
        if ((this.jdField_d_of_type_Boolean) && (("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId))))
        {
          localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368352);
          if (localObject != null) {
            ((View)localObject).setBackgroundResource(2130849280);
          }
          this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundResource(2130849280);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setBackgroundResource(2130849281);
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130838155);
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166889));
        }
        localObject = new aijw(this, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener((TextView.OnEditorActionListener)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener((View.OnKeyListener)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "input set error", localException);
        continue;
        localException.setCustomHeight(0);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      F();
      continue;
      a(paramMessage.arg1);
      continue;
      agda.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      continue;
      boolean bool = bdom.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MSG_EFRESH_FONT_BUBBLE, needRefresh=" + bool);
      }
      if (bool) {
        this.jdField_a_of_type_Aiiq.notifyDataSetChanged();
      }
    }
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnResume() called");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(MiniChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Aiit.a(4);
    if (!this.jdField_f_of_type_Boolean) {
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      afih.a(1);
      ArkFlashChatContainerWrapper.a(1);
      ApngImage.playByTag(0);
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_AndroidContentContext);
      QQLiveImage.onForeground((Activity)this.jdField_a_of_type_AndroidContentContext);
      NativeVideoImage.resumeAll();
      AbstractGifImage.resumeAll();
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      AbstractVideoImage.resumeAll();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) {
        aiiu.a("0X8009C2F");
      }
      return;
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  public void l()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      abta localabta = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((localabta != null) && (localabta.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int) > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "resumeOthersForMultiAIO() called");
        }
        a(131075, 0L);
      }
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause() called");
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Aiit.a(8);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(MiniChatActivity.class);
    }
    ApngImage.pauseByTag(0);
    QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    agai.e();
    ShortVideoRealItemBuilder.e();
    afih.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void n()
  {
    this.jdField_a_of_type_Aiit.a(3);
  }
  
  public void o()
  {
    QQLiveImage.onBackground((Activity)this.jdField_a_of_type_AndroidContentContext);
    agai.g();
    ShortVideoRealItemBuilder.g();
    this.jdField_a_of_type_Aiit.a(9);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131368624: 
    case 2131368638: 
      do
      {
        return;
        r();
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int == 2) {
          aiiu.a("0X8009C31");
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_f_of_type_Int != 5));
      Intent localIntent = aepi.a(new Intent(paramView.getContext(), SplashActivity.class), new int[] { 0, 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        ((aijd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(147)).a();
      }
      aijf.a().d();
      paramView.getContext().startActivity(localIntent);
      r();
      return;
    case 2131367006: 
      paramView = (aike)a(1);
      if (paramView != null) {
        paramView.c();
      }
      this.jdField_j_of_type_Boolean = false;
      int k = 200;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a() != null) {
        k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a().getInt("key_mini_msgtab_businame");
      }
      azqs.b(null, "dc00898", "", "", "0X800A194", "0X800A194", k, 1, "", "", "", "");
      return;
    case 2131368343: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick case R.id.input");
      }
      s();
      return;
    case 2131362283: 
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onClick case aio_input_right_btn");
      }
      paramView = (ImageButton)paramView;
      if (this.jdField_i_of_type_Int == 0)
      {
        this.jdField_i_of_type_Int = 1;
        paramView.setImageResource(2130839718);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        t();
        return;
      }
      this.jdField_i_of_type_Int = 0;
      paramView.setImageResource(2130839717);
      s();
      return;
    case 2131370829: 
      this.jdField_g_of_type_Int = this.jdField_a_of_type_Aiiq.getCount();
      if (this.jdField_g_of_type_Int > 0) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      return;
    }
    C();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = (aike)a(1);
    if (paramAbsListView != null) {
      paramAbsListView.a(paramInt1, paramInt2, paramInt3);
    }
    this.jdField_a_of_type_Aiit.a(17);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      agmq.a(false);
      this.jdField_a_of_type_Aiiq.b();
      VasFaceManager.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      QQLiveImage.resumeAll((Activity)this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    AbstractGifImage.pauseAll();
    agmq.a(true);
    if (paramInt == 2) {
      this.jdField_a_of_type_Aiiq.a();
    }
    for (;;)
    {
      VasFaceManager.a();
      URLDrawable.pause();
      AbstractGifImage.pauseAll();
      ApngImage.pauseByTag(0);
      com.etrump.mixlayout.ETTextView.enableAnimation = false;
      AbstractVideoImage.pauseAll();
      QQLiveImage.pauseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
      return;
      this.jdField_a_of_type_Aiiq.b();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_j_of_type_Boolean) && (paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@'))) {
      aiiu.a("0X800A9AE");
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Aiit.a(11);
    ((MediaPlayerManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(24)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_Aiiq.c();
    q();
    QQLiveImage.releaseAll((Activity)this.jdField_a_of_type_AndroidContentContext);
    agai.g();
    ShortVideoRealItemBuilder.g();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
    }
    if (this.jdField_a_of_type_Bdni != null) {
      this.jdField_a_of_type_Bdni.a();
    }
    afih.a(2);
    ArkFlashChatContainerWrapper.a(2);
  }
  
  protected void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Altm);
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    this.jdField_a_of_type_Aiit.a(10);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)) {
      D();
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.2(this), 200L);
  }
  
  protected void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        D();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new MiniPie.3(this), 200L);
  }
  
  protected void u()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, -1L, false);
    if ((localList != null) && (localList.size() > 0))
    {
      EmojiStickerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 1, localList);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadFirstData() called size = [" + localList.size() + "]");
      }
      this.jdField_a_of_type_Aiiq.a(localList, null, 0);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, hashCode() + " update");
    }
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof ChatMessage)) {
              break;
            }
            paramObservable = (MessageRecord)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + paramObservable.extraflag);
            }
            if (a(paramObservable))
            {
              x();
              ((ChatMessage)paramObject).mMsgAnimFlag = true;
              if (paramObservable.isSendFromLocal())
              {
                a(131075, 0L);
                return;
              }
              a(131072, 0L);
              return;
            }
          } while (!QLog.isColorLevel());
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update--> isNeedUpdate false  isResume " + this.jdField_b_of_type_Boolean);
          return;
          if (!(paramObject instanceof abts)) {
            break;
          }
          paramObservable = (abts)paramObject;
          paramObject = (aeqr)paramObservable.a;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.a())));
        if ((this.jdField_a_of_type_Long == paramObject.a()) && (paramObservable.jdField_h_of_type_Boolean) && (paramObservable.jdField_d_of_type_Boolean))
        {
          long l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
          if (l > 0L) {}
          for (;;)
          {
            a(131076, l);
            return;
            l = 0L;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageContext sync theSameUinAIO return");
      return;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update--> do nothing");
  }
  
  protected void v()
  {
    if ((this.jdField_a_of_type_Aiiq != null) && (this.jdField_a_of_type_Aiiq.getCount() > 0))
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      ((aeqr)this.jdField_a_of_type_Abts.a).a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Abts.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Abts.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_Abts);
      return;
    }
    a(false);
  }
  
  protected void w()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362283));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    aepi.a(this.jdField_a_of_type_AndroidWidgetImageButton, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), 0, 0);
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    }
  }
  
  public void x()
  {
    if (this.jdField_h_of_type_Boolean) {
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    if ((k != 1033) && (k != 1034))
    {
      k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      azpz.a(1, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, k);
    }
    acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
  }
  
  protected abstract void y();
  
  public void y(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "MiniPie onScrollToButtom");
    }
  }
  
  public void z()
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Long);
    if (localChatMessage != null) {
      a(localChatMessage, 0, afzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, Long.parseLong(localChatMessage.senderuin)), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijq
 * JD-Core Version:    0.7.0.1
 */