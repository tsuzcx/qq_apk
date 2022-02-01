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

public class agkz
  extends aglb
{
  private Drawable a;
  private float jdField_b_of_type_Float = 0.5625F;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  private int d = BaseChatItemLayout.f;
  
  public agkz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_c_of_type_Int = ((int)(BaseChatItemLayout.f * this.jdField_b_of_type_Float));
  }
  
  private Drawable a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new afui(Color.argb(255, 242, 242, 242), 255, f * 14.0F);
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
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new aqwu(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap, paramInt1, paramInt2, -921103);
      return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      label59:
      if ((URLDrawableHelper.getLoadingDrawable() instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)URLDrawableHelper.getLoadingDrawable()).getBitmap();
      }
    }
  }
  
  private Drawable a(agla paramagla)
  {
    Object localObject = this.jdField_a_of_type_Asgh.b();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject))
    {
      i = this.jdField_a_of_type_Asgh.a();
      int j = this.jdField_a_of_type_Asgh.b();
      if ((i == 0) || (j == 0)) {
        a(paramagla, (String)localObject);
      }
      Drawable localDrawable1 = a(paramagla.e, paramagla.f);
      Drawable localDrawable2 = a(paramagla.e, paramagla.f);
      localObject = AsyncImageView.a((String)localObject, -1, -1, new File((String)localObject), false, false, true);
      paramagla = localDrawable1;
      if (localObject != null) {
        paramagla = URLDrawableHelper.getDrawable((URL)localObject, 0, 0, localDrawable1, localDrawable2, true, 0.0F);
      }
      return paramagla;
    }
    int i = this.jdField_a_of_type_Asgh.f();
    if (i == 1)
    {
      a(paramagla, i);
      return a();
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Asgh.a();
      return a(paramagla.e, paramagla.f);
    }
    this.jdField_a_of_type_Asgh.a();
    paramagla.jdField_c_of_type_AndroidViewView.setVisibility(0);
    return a();
  }
  
  private void a(agla paramagla)
  {
    FrameLayout localFrameLayout = paramagla.jdField_a_of_type_AndroidWidgetFrameLayout;
    localFrameLayout.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 16) {
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368829);
      localTextView.setText(2131693008);
      localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130849681, 0, 0);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramagla.e, paramagla.f));
      return;
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(agla paramagla, int paramInt)
  {
    FrameLayout localFrameLayout;
    if (paramInt == 1)
    {
      localFrameLayout = paramagla.jdField_a_of_type_AndroidWidgetFrameLayout;
      localFrameLayout.setVisibility(0);
      if (Build.VERSION.SDK_INT < 16) {
        break label158;
      }
      localFrameLayout.setBackground(a());
    }
    for (;;)
    {
      TextView localTextView = (TextView)localFrameLayout.findViewById(2131368829);
      localTextView.setText(2131692242);
      localTextView.setTextSize(12.0F);
      localTextView.setTextColor(Color.parseColor("#B0B3BF"));
      localTextView.setCompoundDrawablePadding(AIOUtils.dp2px(4.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844709);
      localDrawable.setBounds(0, 0, AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localTextView.setCompoundDrawables(null, localDrawable, null, null);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(paramagla.e, paramagla.f));
      return;
      label158:
      localFrameLayout.setBackgroundDrawable(a());
    }
  }
  
  private void a(agla paramagla, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramagla.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
      paramagla.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    }
    b(paramagla);
    paramagla.jdField_c_of_type_AndroidViewView.setVisibility(8);
    Object localObject = a(paramagla);
    paramagla.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    localObject = FileUtils.getFileSize(this.jdField_a_of_type_Asgh.a());
    a(this.jdField_a_of_type_Asgh.a(), (String)localObject, paramagla);
    paramBaseChatItemLayout.setFailedIconVisable(false, this);
    b(paramagla, paramBaseChatItemLayout);
  }
  
  private void a(agla paramagla, String paramString)
  {
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return;
    }
    paramString = aszt.a(paramString);
    int i = paramString[0];
    int j = paramString[1];
    if ((i != 0) && (j != 0))
    {
      paramagla.e = i;
      paramagla.f = j;
      this.jdField_a_of_type_Asgh.a(i, j);
    }
    b(paramagla);
  }
  
  private void a(agla paramagla, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null)
      {
        localPicProgressView = new PicProgressView(this.jdField_a_of_type_AndroidContentContext);
        localPicProgressView.setRadius(this.jdField_a_of_type_Float * 15.0F, false);
        localPicProgressView.setSharpCornerCor(BubbleImageView.a);
        localPicProgressView.setShowCorner(false);
        localPicProgressView.setProgressBackgroudColor(2130706432);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(6, 2131372596);
        localLayoutParams.addRule(8, 2131372596);
        localLayoutParams.addRule(5, 2131372596);
        localLayoutParams.addRule(7, 2131372596);
        ((RelativeLayout)paramagla.jdField_a_of_type_AndroidViewView).addView(localPicProgressView, localLayoutParams);
        localPicProgressView.setProgress(0);
        paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = localPicProgressView;
        paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgressKey(paramagla.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagla.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setVisibility(0);
      }
    }
    while (paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView == null) {
      for (;;)
      {
        PicProgressView localPicProgressView;
        RelativeLayout.LayoutParams localLayoutParams;
        return;
        paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(this.jdField_a_of_type_Asgh.e());
      }
    }
    if (!paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.a(paramagla.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramagla.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      ((RelativeLayout)paramagla.jdField_a_of_type_AndroidViewView).removeView(paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView);
      paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView = null;
      return;
    }
    paramagla.jdField_a_of_type_ComTencentMobileqqCustomviewsPicProgressView.setProgress(100);
  }
  
  private void a(String paramString1, String paramString2, agla paramagla)
  {
    if (paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      ((RelativeLayout)paramagla.jdField_a_of_type_AndroidViewView).removeView(paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    localRelativeLayout.setId(2131366654);
    localRelativeLayout.setBackgroundResource(2130839156);
    paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
    Object localObject1 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131372596);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131372596);
    ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131372596);
    ((RelativeLayout)paramagla.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    int i = ataw.a(paramagla.e, paramagla.f);
    localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject1).setId(2131364409);
    ((TextView)localObject1).setTextSize(2, 12.0F);
    ((TextView)localObject1).setTextColor(-1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = AIOUtils.dp2px(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext, null);
    ((TextView)localObject2).setId(2131364412);
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
      localLayoutParams.addRule(2, 2131364409);
      localRelativeLayout.addView((View)localObject2, localLayoutParams);
      paramString1 = ataw.a(this.jdField_a_of_type_AndroidContentContext, i, paramagla.e, (TextView)localObject2, (TextView)localObject1, paramString1, paramString2);
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
  
  private void b(agla paramagla)
  {
    Object localObject = this.jdField_a_of_type_Asgh.b();
    localObject = atal.a(this.jdField_a_of_type_Asgh.a(), this.jdField_a_of_type_Asgh.b(), (String)localObject);
    int i = ((atam)localObject).jdField_a_of_type_Int;
    int j = ((atam)localObject).jdField_b_of_type_Int;
    if ((i > 0) && (j > 0))
    {
      paramagla.e = i;
      paramagla.f = j;
      localObject = paramagla.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (localObject != null) {
        break label120;
      }
      localObject = new RelativeLayout.LayoutParams(paramagla.e, paramagla.f);
      paramagla.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label120:
    while ((((ViewGroup.LayoutParams)localObject).width == paramagla.e) && (((ViewGroup.LayoutParams)localObject).height == paramagla.f))
    {
      return;
      paramagla.e = this.jdField_c_of_type_Int;
      paramagla.f = this.d;
      break;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramagla.e;
    ((ViewGroup.LayoutParams)localObject).height = paramagla.f;
    paramagla.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void b(agla paramagla, BaseChatItemLayout paramBaseChatItemLayout)
  {
    int i = this.jdField_a_of_type_Asgh.c();
    if (i == 1)
    {
      if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Asgh.b()))
      {
        b(paramagla);
        a(paramagla);
        paramagla.jdField_c_of_type_AndroidViewView.setVisibility(8);
        if (paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
        {
          paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
          ((RelativeLayout)paramagla.jdField_a_of_type_AndroidViewView).removeView(paramagla.jdField_a_of_type_AndroidWidgetRelativeLayout);
        }
      }
      return;
    }
    if (i == 3)
    {
      a(paramagla, true);
      paramagla.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    if (i == 2)
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return;
    }
    if (i == 4)
    {
      a(paramagla, false);
      return;
    }
    a(paramagla, false);
  }
  
  public aeze a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = ((View)paramView.getParent()).getTag();
      if ((paramView != null) && (agla.class.isInstance(paramView))) {
        return ((agla)paramView).jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      }
    }
    return null;
  }
  
  protected View a(aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Object localObject1;
    if ((paramaezf instanceof agla))
    {
      localObject1 = (agla)paramaezf;
      paramaezf = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      localObject1 = paramaezf;
      if (paramaezf == null)
      {
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaezf = new BubbleImageView(this.jdField_a_of_type_AndroidContentContext);
        int i = Build.VERSION.SDK_INT;
        if ((i == 19) || (i == 18)) {
          paramaezf.e = true;
        }
        paramaezf.setId(2131372596);
        paramaezf.setAdjustViewBounds(true);
        paramaezf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramaezf.setRadius(15.0F);
        paramaezf.d(false);
        paramaezf.setShowEdge(true);
        ((RelativeLayout)localObject1).addView(paramaezf, new RelativeLayout.LayoutParams(-2, -2));
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = paramaezf;
        paramaezf = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131368829);
        ((TextView)localObject2).setGravity(17);
        ((TextView)localObject2).setTextColor(Color.rgb(178, 182, 195));
        Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject3).gravity = 17;
        paramaezf.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        paramaezf.setVisibility(8);
        ((RelativeLayout)localObject1).addView(paramaezf, new RelativeLayout.LayoutParams(-1, -1));
        paramView.jdField_a_of_type_AndroidWidgetFrameLayout = paramaezf;
        paramaezf = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
        paramaezf.setOrientation(1);
        paramaezf.setGravity(1);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        ((RelativeLayout)localObject1).addView(paramaezf, (ViewGroup.LayoutParams)localObject2);
        paramView.jdField_c_of_type_AndroidViewView = paramaezf;
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setImageResource(2130839445);
        paramaezf.addView((View)localObject2, new LinearLayout.LayoutParams(AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.dp2px(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources())));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setText(2131692244);
        ((TextView)localObject2).setTextSize(12.0F);
        ((TextView)localObject2).setTextColor(Color.parseColor("#B0B3BF"));
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramaezf.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setOnClickListener(this);
        super.a((View)localObject1, paramafce);
      }
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a(paramView, paramBaseChatItemLayout);
      return localObject1;
      paramView = new agla(this);
      paramView.jdField_b_of_type_JavaLangStringBuilder = paramaezf.jdField_b_of_type_JavaLangStringBuilder;
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramaezf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      paramView.jdField_a_of_type_AndroidViewView = paramaezf.jdField_a_of_type_AndroidViewView;
      paramView.jdField_a_of_type_Apee = paramaezf.jdField_a_of_type_Apee;
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramaezf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
      paramView.jdField_a_of_type_Int = paramaezf.jdField_a_of_type_Int;
      paramView.jdField_b_of_type_Int = paramaezf.jdField_b_of_type_Int;
      paramView.jdField_c_of_type_Int = paramaezf.jdField_c_of_type_Int;
      paramView.d = paramaezf.d;
      paramView.jdField_a_of_type_JavaLangString = paramaezf.jdField_a_of_type_JavaLangString;
      paramaezf = null;
    }
  }
  
  protected List<Integer> a(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.a(2);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Asgh.a(paramInt);
    switch (paramInt)
    {
    default: 
      return;
    case 2131371455: 
      a(paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  protected aezf b()
  {
    return new agla(this);
  }
  
  protected String b(ChatMessage paramChatMessage)
  {
    if (bfwr.a(paramChatMessage.issend)) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131692239);
    }
    return this.jdField_a_of_type_AndroidContentContext.getString(2131692236);
  }
  
  protected List<Integer> b(bgaz parambgaz, aezy paramaezy)
  {
    return this.jdField_a_of_type_Asgh.b(2);
  }
  
  protected void e(View paramView)
  {
    if (paramView.getId() == 2131364441)
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
    if (!agla.class.isInstance(paramView))
    {
      QLog.w("QFileImageItemBuilder", 1, "holder tag class[" + paramView.getClass().getName() + "] is not Holder");
      return;
    }
    paramView = (agla)paramView;
    this.jdField_a_of_type_Asgh.a(2, paramView.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkz
 * JD-Core Version:    0.7.0.1
 */