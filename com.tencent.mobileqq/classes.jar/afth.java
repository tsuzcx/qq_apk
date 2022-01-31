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

public class afth
  extends aftj
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.e;
  
  public afth(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.e * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afct(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      localBitmap = null;
      if (!(baul.b() instanceof SkinnableBitmapDrawable)) {
        break label59;
      }
      localBitmap = ((SkinnableBitmapDrawable)baul.b()).getBitmap();
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new apge(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((baul.b() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)baul.b()).getBitmap();
      }
    }
  }
  
  private Drawable a(afti paramafti)
  {
    Object localObject = this.jdField_a_of_type_Aqro.b();
    if (bdcs.b((String)localObject))
    {
      i = this.jdField_a_of_type_Aqro.a();
      int j = this.jdField_a_of_type_Aqro.b();
      if ((i == 0) || (j == 0)) {
        a(paramafti, (String)localObject);
      }
      Drawable localDrawable1 = a(paramafti.e, paramafti.f);
      Drawable localDrawable2 = a(paramafti.e, paramafti.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramafti = localDrawable1;
      if (localObject != null) {
        paramafti = baul.a((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramafti;
    }
    int i = this.jdField_a_of_type_Aqro.f();
    if (i == 1)
    {
      a(paramafti, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aqro.a();
      return a(paramafti.e, paramafti.f);
    }
    this.jdField_a_of_type_Aqro.a();
    paramafti.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(afti paramafti)
  {
    FrameLayout localFrameLayout = paramafti.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368418);
      localTextView.setText(2131693474);
      localTextView.setCompoundDrawablePadding(aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849131, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramafti.e, paramafti.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(afti paramafti, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramafti.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368418);
      localTextView.setText(2131692599);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(aekt.a(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844353);
      localDrawable.setBounds(0, 0, aekt.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramafti.e, paramafti.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(afti paramafti, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramafti.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramafti.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramafti);
    paramafti.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramafti);
    paramafti.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = bdcs.a(this.jdField_a_of_type_Aqro.a());
    a(this.jdField_a_of_type_Aqro.a(), (String)localObject, paramafti);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramafti, paramBaseChatItemLayout);
  }
  
  private void a(afti paramafti, String paramString)
  {
    if (!bdcs.b(paramString)) {
      return;
    }
    paramString = arni.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramafti.e = i;
      paramafti.f = j;
      this.jdField_a_of_type_Aqro.a(i, j);
    }
    b(paramafti);
  }
  
  private void a(afti paramafti, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131371925);
        localLayoutParams.addRule(8, 2131371925);
        localLayoutParams.addRule(5, 2131371925);
        localLayoutParams.addRule(7, 2131371925);
        ((RelativeLayout)paramafti.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramafti.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafti.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Aqro.e());
      }
    }
    if (!paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramafti.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafti.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramafti.jdField_a_of_type_AndroidViewView).removeView(paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramafti.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, afti paramafti)
  {
    if (paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramafti.jdField_a_of_type_AndroidViewView).removeView(paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366323);
    localRelativeLayout.setBackgroundResource(2130838946);
    paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, aekt.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131371925);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131371925);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131371925);
    ((RelativeLayout)paramafti.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = aroo.a(paramafti.e, paramafti.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364139);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364142);
    ((TextView)localObject2).setTextSize(2, 14.0F);
    ((TextView)localObject2).setTextColor(-1);
    ((TextView)localObject2).setSingleLine();
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.rightMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localLayoutParams.bottomMargin = aekt.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (i == 1)
    {
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(2, 2131364139);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = aroo.a(this.jdField_a_of_type_AndroidContentContext, i, paramafti.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(afti paramafti)
  {
    Object localObject = this.jdField_a_of_type_Aqro.b();
    localObject = aroa.a(this.jdField_a_of_type_Aqro.a(), this.jdField_a_of_type_Aqro.b(), (String)localObject);
    int i = ((arob)localObject).jdField_a_of_type_Int;
    int j = ((arob)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramafti.e = i;
      paramafti.f = j;
      localObject = paramafti.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramafti.e, paramafti.f);
      paramafti.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramafti.e) && (((ViewGroup.LayoutParams)localObject).height == paramafti.f))
    {
      return;
      paramafti.e = this.jdField_c_of_type_Int;
      paramafti.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramafti.e;
    ((ViewGroup.LayoutParams)localObject).height = paramafti.f;
    paramafti.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(afti paramafti, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Aqro.c();
    if (i == 1)
    {
      if (!bdcs.b(this.jdField_a_of_type_Aqro.b()))
      {
        b(paramafti);
        a(paramafti);
        paramafti.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramafti.jdField_a_of_type_AndroidViewView).removeView(paramafti.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramafti, true);
      paramafti.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramafti, false);
      return;
    }
    a(paramafti, false);
  }
  
  public aels a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (afti.class.isInstance(paramView))) {
        return ((afti)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Object localObject1;
    if ((paramaelt instanceof afti))
    {
      localObject1 = (afti)paramaelt;
      paramaelt = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramaelt;
      if (paramaelt == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaelt = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramaelt.e = true;
        }
        paramaelt.setId(2131371925);
        paramaelt.setAdjustViewBounds(true);
        paramaelt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaelt.setRadius(15.0F);
        paramaelt.d(false);
        paramaelt.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramaelt, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaelt;
        paramaelt = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368418);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramaelt.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaelt.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramaelt, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramaelt;
        paramaelt = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaelt.setOrientation(1);
        paramaelt.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramaelt, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramaelt;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839224);
        paramaelt.addView((View)localObject2, new LinearLayout.LayoutParams(aekt.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), aekt.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692601);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = aekt.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaelt.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramaeov);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new afti(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaelt.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaelt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaelt.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Ansf = paramaelt.jdField_a_of_type_Ansf;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaelt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaelt.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaelt.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramaelt.jdField_c_of_type_Int;
      paramView.d = paramaelt.d;
      paramView.jdField_a_of_type_JavaLangString = paramaelt.jdField_a_of_type_JavaLangString;
      paramaelt = null;
    }
  }
  
  protected List<Integer> a(bdkz parambdkz, aemk paramaemk)
  {
    return this.jdField_a_of_type_Aqro.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqro.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131370799: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aelt b()
  {
    return new afti(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bdec.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692596);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692593);
  }
  
  protected List<Integer> b(bdkz parambdkz, aemk paramaemk)
  {
    return this.jdField_a_of_type_Aqro.b(2);
  }
  
  protected void d(View paramView)
  {
    if (paramView.getId() == 2131364171)
    {
      paramView = aekt.a(paramView);
      if (paramView == null) {
        QLog.w("QFileImageItemBuilder", 1, "holder tag is null");
      }
    }
    else
    {
      return;
    }
    if (!afti.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (afti)paramView;
    this.jdField_a_of_type_Aqro.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afth
 * JD-Core Version:    0.7.0.1
 */