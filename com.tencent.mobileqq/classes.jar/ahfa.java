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
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.PicProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.net.URL;
import java.util.List;

public class ahfa
  extends ahfc
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.f;
  
  public ahfa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.f * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new agoq(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(bdzx.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)bdzx.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new arnh(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((bdzx.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)bdzx.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(ahfb paramahfb)
  {
    Object localObject = this.jdField_a_of_type_Atcc.b();
    if (bgmg.b((String)localObject))
    {
      i = this.jdField_a_of_type_Atcc.a();
      int j = this.jdField_a_of_type_Atcc.b();
      if ((i == 0) || (j == 0)) {
        a(paramahfb, (String)localObject);
      }
      Drawable localDrawable1 = a(paramahfb.e, paramahfb.f);
      Drawable localDrawable2 = a(paramahfb.e, paramahfb.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramahfb = localDrawable1;
      if (localObject != null) {
        paramahfb = bdzx.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramahfb;
    }
    int i = this.jdField_a_of_type_Atcc.f();
    if (i == 1)
    {
      a(paramahfb, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Atcc.a();
      return a(paramahfb.e, paramahfb.f);
    }
    this.jdField_a_of_type_Atcc.a();
    paramahfb.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(ahfb paramahfb)
  {
    FrameLayout localFrameLayout = paramahfb.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368730);
      localTextView.setText(2131692944);
      localTextView.setCompoundDrawablePadding(afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849753, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahfb.e, paramahfb.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahfb paramahfb, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramahfb.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368730);
      localTextView.setText(2131692189);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(afur.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844819);
      localDrawable.setBounds(0, 0, afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramahfb.e, paramahfb.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(ahfb paramahfb, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramahfb.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramahfb.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramahfb);
    paramahfb.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramahfb);
    paramahfb.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bgmg.a(this.jdField_a_of_type_Atcc.a());
    a(this.jdField_a_of_type_Atcc.a(), (String)localObject, paramahfb);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramahfb, paramBaseChatItemLayout);
  }
  
  private void a(ahfb paramahfb, String paramString)
  {
    if (!bgmg.b(paramString)) {
      return;
    }
    paramString = atvo.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramahfb.e = i;
      paramahfb.f = j;
      this.jdField_a_of_type_Atcc.a(i, j);
    }
    b(paramahfb);
  }
  
  private void a(ahfb paramahfb, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131372517);
        localLayoutParams.addRule(8, 2131372517);
        localLayoutParams.addRule(5, 2131372517);
        localLayoutParams.addRule(7, 2131372517);
        ((RelativeLayout)paramahfb.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramahfb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Atcc.e());
      }
    }
    if (!paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramahfb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahfb.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramahfb.jdField_a_of_type_AndroidViewView).removeView(paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramahfb.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, ahfb paramahfb)
  {
    if (paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramahfb.jdField_a_of_type_AndroidViewView).removeView(paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366577);
    localRelativeLayout.setBackgroundResource(2130839113);
    paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, afur.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131372517);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131372517);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131372517);
    ((RelativeLayout)paramahfb.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = atwt.a(paramahfb.e, paramahfb.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364347);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364350);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = afur.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364347);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = atwt.a(this.jdField_a_of_type_AndroidContentContext, i, paramahfb.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(ahfb paramahfb)
  {
    Object localObject = this.jdField_a_of_type_Atcc.b();
    localObject = atwg.a(this.jdField_a_of_type_Atcc.a(), this.jdField_a_of_type_Atcc.b(), (String)localObject);
    int i = ((atwh)localObject).jdField_a_of_type_Int;
    int j = ((atwh)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramahfb.e = i;
      paramahfb.f = j;
      localObject = paramahfb.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramahfb.e, paramahfb.f);
      paramahfb.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramahfb.e) && (((ViewGroup.LayoutParams)localObject).height == paramahfb.f))
    {
      return;
      paramahfb.e = this.jdField_c_of_type_Int;
      paramahfb.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramahfb.e;
    ((ViewGroup.LayoutParams)localObject).height = paramahfb.f;
    paramahfb.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(ahfb paramahfb, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Atcc.c();
    if (i == 1)
    {
      if (!bgmg.b(this.jdField_a_of_type_Atcc.b()))
      {
        b(paramahfb);
        a(paramahfb);
        paramahfb.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramahfb.jdField_a_of_type_AndroidViewView).removeView(paramahfb.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramahfb, true);
      paramahfb.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramahfb, false);
      return;
    }
    a(paramahfb, false);
  }
  
  public afwq a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (ahfb.class.isInstance(paramView))) {
        return ((ahfb)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    Object localObject1;
    if ((paramafwr instanceof ahfb))
    {
      localObject1 = (ahfb)paramafwr;
      paramafwr = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramafwr;
      if (paramafwr == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafwr = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramafwr.e = true;
        }
        paramafwr.setId(2131372517);
        paramafwr.setAdjustViewBounds(true);
        paramafwr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramafwr.setRadius(15.0F);
        paramafwr.d(false);
        paramafwr.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramafwr, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramafwr;
        paramafwr = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368730);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramafwr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramafwr.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramafwr, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramafwr;
        paramafwr = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramafwr.setOrientation(1);
        paramafwr.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramafwr, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramafwr;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839402);
        paramafwr.addView((View)localObject2, new LinearLayout.LayoutParams(afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), afur.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692191);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = afur.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramafwr.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramafzq);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new ahfb(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramafwr.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramafwr.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramafwr.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Apwt = paramafwr.jdField_a_of_type_Apwt;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramafwr.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramafwr.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramafwr.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramafwr.jdField_c_of_type_Int;
      paramView.d = paramafwr.d;
      paramView.jdField_a_of_type_JavaLangString = paramafwr.jdField_a_of_type_JavaLangString;
      paramafwr = null;
    }
  }
  
  protected List<Integer> a(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atcc.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371380: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected afwr b()
  {
    return new ahfb(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bgnr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692186);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692183);
  }
  
  protected List<Integer> b(bguh parambguh, afxj paramafxj)
  {
    return this.jdField_a_of_type_Atcc.b(2);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364379)
    {
      paramView = afur.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!ahfb.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (ahfb)paramView;
    this.jdField_a_of_type_Atcc.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfa
 * JD-Core Version:    0.7.0.1
 */