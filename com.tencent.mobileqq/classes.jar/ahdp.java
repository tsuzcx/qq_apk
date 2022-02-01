import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.util.List;

public class ahdp
  extends ahdr
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.f;
  
  public ahdp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.f * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agmx(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(URLDrawableHelper.getLoadingDrawable() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new asbe(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      }
    }
  }
  
  private Drawable a(ahdq paramahdq)
  {
    Object localObject = this.jdField_a_of_type_Atkn.b();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      i = this.jdField_a_of_type_Atkn.a();
      int j = this.jdField_a_of_type_Atkn.b();
      if ((i == 0) || (j == 0)) {
        a(paramahdq, (String)localObject);
      }
      Drawable localDrawable1 = a(paramahdq.e, paramahdq.f);
      Drawable localDrawable2 = a(paramahdq.e, paramahdq.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramahdq = localDrawable1;
      if (localObject != null) {
        paramahdq = URLDrawableHelper.getDrawable((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramahdq;
    }
    int i = this.jdField_a_of_type_Atkn.f();
    if (i == 1)
    {
      a(paramahdq, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Atkn.a();
      return a(paramahdq.e, paramahdq.f);
    }
    this.jdField_a_of_type_Atkn.a();
    paramahdq.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(ahdq paramahdq)
  {
    FrameLayout localFrameLayout = paramahdq.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368987);
      localTextView.setText(2131693144);
      localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849774, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahdq.e, paramahdq.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahdq paramahdq, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramahdq.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368987);
      localTextView.setText(2131692332);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844778);
      localDrawable.setBounds(0, 0, AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahdq.e, paramahdq.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahdq paramahdq, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramahdq.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramahdq.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramahdq);
    paramahdq.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramahdq);
    paramahdq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = FileUtils.getFileSize(this.jdField_a_of_type_Atkn.a());
    a(this.jdField_a_of_type_Atkn.a(), (String)localObject, paramahdq);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramahdq, paramBaseChatItemLayout);
  }
  
  private void a(ahdq paramahdq, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = auea.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahdq.e = i;
      paramahdq.f = j;
      this.jdField_a_of_type_Atkn.a(i, j);
    }
    b(paramahdq);
  }
  
  private void a(ahdq paramahdq, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131372790);
        localLayoutParams.addRule(8, 2131372790);
        localLayoutParams.addRule(5, 2131372790);
        localLayoutParams.addRule(7, 2131372790);
        ((RelativeLayout)paramahdq.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahdq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Atkn.e());
      }
    }
    if (!paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramahdq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahdq.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramahdq.jdField_a_of_type_AndroidViewView).removeView(paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramahdq.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, ahdq paramahdq)
  {
    if (paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahdq.jdField_a_of_type_AndroidViewView).removeView(paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366765);
    localRelativeLayout.setBackgroundResource(2130839176);
    paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131372790);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131372790);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131372790);
    ((RelativeLayout)paramahdq.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = aufd.a(paramahdq.e, paramahdq.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364490);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364493);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364490);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = aufd.a(this.jdField_a_of_type_AndroidContentContext, i, paramahdq.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
      switch (i)
      {
      }
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramString1);
      ((TextView)localObject1).setText(paramString2);
      return;
      localLayoutParams.addRule(12);
      break;
      ((TextView)localObject2).setLines(2);
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setGravity(3);
      continue;
      ((TextView)localObject2).setLines(1);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject1).setGravity(5);
    }
  }
  
  private void b(ahdq paramahdq)
  {
    Object localObject = this.jdField_a_of_type_Atkn.b();
    localObject = aues.a(this.jdField_a_of_type_Atkn.a(), this.jdField_a_of_type_Atkn.b(), (String)localObject);
    int i = ((auet)localObject).jdField_a_of_type_Int;
    int j = ((auet)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramahdq.e = i;
      paramahdq.f = j;
      localObject = paramahdq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramahdq.e, paramahdq.f);
      paramahdq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramahdq.e) && (((ViewGroup.LayoutParams)localObject).height == paramahdq.f))
    {
      return;
      paramahdq.e = this.jdField_c_of_type_Int;
      paramahdq.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramahdq.e;
    ((ViewGroup.LayoutParams)localObject).height = paramahdq.f;
    paramahdq.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(ahdq paramahdq, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Atkn.c();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atkn.b()))
      {
        b(paramahdq);
        a(paramahdq);
        paramahdq.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramahdq.jdField_a_of_type_AndroidViewView).removeView(paramahdq.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramahdq, true);
      paramahdq.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramahdq, false);
      return;
    }
    a(paramahdq, false);
  }
  
  public afqq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (ahdq.class.isInstance(paramView))) {
        return ((ahdq)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject1;
    if ((paramafqr instanceof ahdq))
    {
      localObject1 = (ahdq)paramafqr;
      paramafqr = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramafqr;
      if (paramafqr == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafqr = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramafqr.e = true;
        }
        paramafqr.setId(2131372790);
        paramafqr.setAdjustViewBounds(true);
        paramafqr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramafqr.setRadius(15.0F);
        paramafqr.d(false);
        paramafqr.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramafqr, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramafqr;
        paramafqr = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368987);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramafqr.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramafqr, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramafqr;
        paramafqr = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafqr.setOrientation(1);
        paramafqr.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramafqr, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramafqr;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839466);
        paramafqr.addView((View)localObject2, new LinearLayout.LayoutParams(AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692334);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramafqr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramaftk);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new ahdq(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramafqr.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramafqr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramafqr.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Aqhi = paramafqr.jdField_a_of_type_Aqhi;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramafqr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramafqr.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramafqr.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramafqr.jdField_c_of_type_Int;
      paramView.d = paramafqr.d;
      paramView.jdField_a_of_type_JavaLangString = paramafqr.jdField_a_of_type_JavaLangString;
      paramafqr = null;
    }
  }
  
  protected List<Integer> a(bhjq parambhjq, afrk paramafrk)
  {
    return this.jdField_a_of_type_Atkn.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atkn.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371641: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected afqr b()
  {
    return new ahdq(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bhfj.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692329);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692326);
  }
  
  protected List<Integer> b(bhjq parambhjq, afrk paramafrk)
  {
    return this.jdField_a_of_type_Atkn.b(2);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364522)
    {
      paramView = AIOUtils.getHolder(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!ahdq.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (ahdq)paramView;
    this.jdField_a_of_type_Atkn.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdp
 * JD-Core Version:    0.7.0.1
 */