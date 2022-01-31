import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.5;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.6;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.wiget.LabelLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Random;
import mqq.os.MqqHandler;

public class aefv
  extends BaseChatPie
  implements Handler.Callback, azwh
{
  private boolean T;
  private boolean U;
  private boolean V;
  private boolean W;
  private ajjh jdField_a_of_type_Ajjh = new aega(this);
  private ajmm jdField_a_of_type_Ajmm = new aefz(this);
  anoj jdField_a_of_type_Anoj = new aegd(this);
  private azwg jdField_a_of_type_Azwg;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private LabelLayout jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout;
  private Comparator<MessageRecord> jdField_a_of_type_JavaUtilComparator = new aefw(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new aefy(this);
  private long jdField_g_of_type_Long = -1L;
  private String jdField_g_of_type_JavaLangString = "";
  private long jdField_h_of_type_Long;
  private String jdField_h_of_type_JavaLangString = "0";
  private TextView l;
  private View o;
  private ImageView p;
  private int q = 0;
  private int r = 0;
  private int s;
  private volatile int t;
  private int u;
  private int v;
  private int w;
  private int x = 0;
  
  public aefv(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean D()
  {
    boolean bool1 = false;
    int j = 0;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      int i = j;
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
        {
          i = j;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a()) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
      }
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (this.jdField_a_of_type_Wmm != null)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Wmm.a())
      {
        this.jdField_a_of_type_Wmm.a();
        bool2 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkConsumeBackEvent, comsumed:" + bool2);
    }
    return bool2;
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject;
    if (this.jdField_a_of_type_Azwg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "mFaceDecoder null");
      }
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = this.jdField_a_of_type_Azwg.a(1, paramString, 0, (byte)3);
      localObject = localBitmap;
    } while (localBitmap != null);
    if (!this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    return null;
  }
  
  private void a(anor paramanor)
  {
    if ((this.l != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout != null))
    {
      Object localObject2 = "";
      if (!TextUtils.isEmpty(paramanor.b)) {
        localObject2 = "" + paramanor.b;
      }
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramanor.c))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = (String)localObject2 + " · ";
        }
        localObject1 = (String)localObject1 + paramanor.c;
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramanor.d))
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = (String)localObject1 + " · ";
        }
        localObject2 = (String)localObject2 + paramanor.d;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramanor.e))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = (String)localObject2 + " · ";
        }
        localObject1 = (String)localObject1 + paramanor.e;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.l.setText((CharSequence)localObject1);
        this.l.setVisibility(0);
      }
      for (;;)
      {
        localObject2 = null;
        localObject1 = localObject2;
        if (paramanor.a == null) {
          break;
        }
        localObject1 = localObject2;
        if (paramanor.a.isEmpty()) {
          break;
        }
        localObject1 = new ArrayList(paramanor.a.size());
        int i = new Random().nextInt(7);
        paramanor = paramanor.a.iterator();
        while (paramanor.hasNext())
        {
          localObject2 = (String)paramanor.next();
          int j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            anuv localanuv = new anuv();
            j = i + 1;
            localanuv.jdField_a_of_type_Int = b(j % 7);
            localanuv.b = -1;
            localanuv.jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((ArrayList)localObject1).add(localanuv);
          }
          i = j;
        }
        this.l.setVisibility(8);
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout.setLabels((List)localObject1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout.setVisibility(8);
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return -14823;
    case 1: 
      return -9210881;
    case 2: 
      return -3836929;
    case 3: 
      return -24768;
    case 4: 
      return -16725252;
    case 5: 
      return -15998858;
    }
    return -32566;
  }
  
  private void bo()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "gotoFriendAio : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    Intent localIntent = aciy.a(new Intent(a(), SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", 0);
    a().startActivity(localIntent);
  }
  
  private void bp()
  {
    if (badq.d(this.jdField_a_of_type_AndroidContentContext)) {
      ((anod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      this.jdField_h_of_type_JavaLangString = antc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      ThreadManager.getSubThreadHandler().post(new LimitChatPie.6(this));
      this.u = antc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      return;
    }
  }
  
  private void bq()
  {
    Object localObject = this.n.getLayoutParams();
    if (localObject != null) {
      ((ViewGroup.LayoutParams)localObject).height = 0;
    }
    if (this.jdField_a_of_type_Acka != null) {
      this.jdField_a_of_type_Acka.a = Boolean.valueOf(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(0);
    bs();
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_Boolean = false;
    c(true);
    localObject = (LinearLayout.LayoutParams)this.jdField_h_of_type_AndroidWidgetImageView.getLayoutParams();
    this.jdField_h_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = vms.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    int i = bajq.a(20.0F);
    aciy.a(this.jdField_h_of_type_AndroidWidgetImageView, i, i, i, i * 3);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(new aegb(this));
    br();
  }
  
  private void br()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      int i;
      if (this.V)
      {
        i = 2130843181;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!awnu.b()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label180;
        }
        ((Drawable)localObject).setColorFilter(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getColor(2131101257), PorterDuff.Mode.MULTIPLY);
        label63:
        if (localObject != null)
        {
          this.jdField_h_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
          this.jdField_h_of_type_AndroidWidgetImageView.setClickable(true);
          if (!this.V) {
            break label212;
          }
          this.f.setText(2131633346);
        }
      }
      for (;;)
      {
        this.f.setClickable(false);
        i = (int)a().getResources().getDimension(2131167766);
        if (!this.V) {
          break label225;
        }
        this.o.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), i + this.s, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
        return;
        i = 2130843188;
        break;
        label180:
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label63;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label63;
        label212:
        this.f.setText(2131633347);
      }
      label225:
      this.o.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), i, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void bs()
  {
    this.s = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getDimensionPixelSize(2131166069);
    this.o = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131493622, null);
    int i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getColor(2131101317);
    this.o.setBackgroundColor(i);
    Object localObject = new RelativeLayout.LayoutParams(-1, this.s);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131309578);
    this.d.addView(this.o, (ViewGroup.LayoutParams)localObject);
    this.p = ((ImageView)this.o.findViewById(2131297409));
    this.l = ((TextView)this.o.findViewById(2131304147));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetLabelLayout = ((LabelLayout)this.o.findViewById(2131303205));
    localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (localObject != null) {
      this.p.setImageBitmap((Bitmap)localObject);
    }
    this.p.setOnClickListener(new aegc(this));
  }
  
  private void bt()
  {
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 96);
    ProfileActivity.a(this.jdField_a_of_type_AndroidContentContext, localAllInOne, this.x, 2);
  }
  
  public void G()
  {
    super.G();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy, userfinish:" + this.U);
    }
    ((ajnf)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    this.jdField_a_of_type_JavaUtilObserver = null;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)
    {
      if (this.jdField_a_of_type_Azwg != null) {
        this.jdField_a_of_type_Azwg.d();
      }
      if (this.W)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_h_of_type_Long;
        if ((this.v <= 0) || (this.w <= 0)) {
          break label198;
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A695", "0X800A695", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A692", "0X800A692", 0, 0, String.valueOf(l1 - l2), "", this.jdField_h_of_type_JavaLangString, "");
      return;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break;
      label198:
      if ((this.v > 0) || (this.w > 0)) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A694", "0X800A694", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void I()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    localIntent.putExtra("key_limit_chat_result_action", this.r);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "chat pie finish, finishaction:" + this.r);
    }
    this.U = true;
  }
  
  public void J()
  {
    super.J();
    ((anod)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(127)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnStart");
    }
  }
  
  public void K()
  {
    super.K();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnStop");
    }
  }
  
  public void L()
  {
    super.L();
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnPause ");
    }
  }
  
  public void O()
  {
    super.O();
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnResume");
    }
    if (((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      bo();
    }
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPreThemeChanged" + this.I);
    }
  }
  
  public void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPostThemeChanged" + this.I);
    }
    aV();
  }
  
  public List<ChatMessage> a()
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
  }
  
  public List<ChatMessage> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = super.a(paramQQAppInterface, paramBoolean);
    Collections.sort(paramQQAppInterface, this.jdField_a_of_type_JavaUtilComparator);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)paramQQAppInterface.get(paramQQAppInterface.size() - 1));
    }
    return paramQQAppInterface;
  }
  
  public List<ChatMessage> a(boolean paramBoolean)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "LimitChatPie";
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onPanelChanged, old:" + paramInt1 + " new:" + paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    super.a(paramMessage);
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 4: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AA", "0X80096AA", this.x, 0, "", "", "", "");
      return;
    case 2: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A9", "0X80096A9", this.x, 0, "", "", "", "");
      return;
    case 5: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AB", "0X80096AB", this.x, 0, "", "", "", "");
      return;
    case 24: 
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AC", "0X80096AC", this.x, 0, "", "", "", "");
      return;
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096AD", "0X80096AD", this.x, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramChatMessage, paramBoolean2);
    if (this.jdField_a_of_type_Acka != null) {
      this.jdField_a_of_type_Acka.a = Boolean.valueOf(false);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((this.I) || (ThemeUtil.isSimpleDayTheme(false))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(boolean paramBoolean)
  {
    paramBoolean = super.a(paramBoolean);
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azwg.a(this);
    this.V = antc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (this.V) {
      antc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    bq();
    ((ajnf)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(34)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    bp();
    return paramBoolean;
  }
  
  public void aV()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateUI_titleBarForTheme" + this.I);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    super.aV();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void af()
  {
    super.af();
  }
  
  public void an()
  {
    super.an();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anoj);
  }
  
  public void ao()
  {
    super.ao();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anoj);
  }
  
  public void aq()
  {
    super.aq();
  }
  
  public void b(Intent paramIntent)
  {
    super.b(paramIntent);
    this.e.setOnClickListener(new aefx(this));
  }
  
  public void bm()
  {
    int i = 1;
    Object localObject = (anoe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    int k = ((anoe)localObject).b();
    int j;
    if (k > 0)
    {
      j = this.t / k + 1;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkShowGrayTips " + this.t + " " + j + " " + this.u);
      }
      if (this.t % k != 0) {
        break label171;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        String str = ((anoe)localObject).c();
        localObject = ((anoe)localObject).d();
        if (!TextUtils.isEmpty(str))
        {
          antc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, j);
          this.u = j;
          ThreadManager.getSubThreadHandler().post(new LimitChatPie.5(this, str, (String)localObject));
        }
      }
      return;
      label171:
      if (j - this.u <= 1) {
        i = 0;
      }
    }
  }
  
  public void bn()
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A693", "0X800A693", 0, 0, "", "", "", "");
  }
  
  public void c(Intent paramIntent)
  {
    super.c(paramIntent);
    this.x = paramIntent.getIntExtra("key_limitchat_from_type", 0);
    this.W = paramIntent.getBooleanExtra("key_limitchat_auto_open", false);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "updateSession, mfromType:" + this.x);
    }
  }
  
  public int e()
  {
    int i = adlr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000 - 200;
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i);
    return i + 200;
  }
  
  public void e(Intent paramIntent)
  {
    this.c = true;
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public boolean e()
  {
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return super.handleMessage(paramMessage);
  }
  
  public boolean i()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onBackEvent begin");
    }
    if (D()) {
      return true;
    }
    return super.i();
  }
  
  public void j() {}
  
  public void l(boolean paramBoolean) {}
  
  public void n()
  {
    super.n();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131304841)
    {
      super.onClick(paramView);
      return;
    }
    super.onClick(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramString != null) && (paramBitmap != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.p != null)) {
      this.p.setImageBitmap(paramBitmap);
    }
  }
  
  public void x()
  {
    if ((azzz.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (azzz.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str2 = this.jdField_g_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
    }
    localIntent.putExtra("uinname", str1);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("ExtendFriendLimitChatFromeType", this.x);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void y() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefv
 * JD-Core Version:    0.7.0.1
 */