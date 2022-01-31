import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class afwh
  extends aepl
{
  View.OnClickListener a;
  
  public afwh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afwi(this);
  }
  
  protected aepm a()
  {
    return new afwj(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364173);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.i, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)paramView).setOrientation(1);
    paramLinearLayout = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = paramLinearLayout.mPAMessage;
    int k = (int)(0.5D * BaseChatItemLayout.d);
    ArrayList localArrayList = localPAMessage.items;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    Object localObject1;
    if (localPAMessage.grayTips != null)
    {
      paramaepm = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaepm.setText(localPAMessage.grayTips);
      paramaepm.setGravity(17);
      paramaepm.setSingleLine();
      paramaepm.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramaepm.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramaepm.setBackgroundResource(2130844377);
      paramaepm.setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bdaq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramaepm.setTextColor(-1);
      paramaepm.setTextSize(12.0F);
      localViewGroup.addView(paramaepm);
    }
    int i = 0;
    label365:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new afwj(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((afwj)localObject1).jdField_b_of_type_Int = 5;
      ((afwj)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((afwj)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((afwj)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((afwj)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((afwj)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((afwj)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558776, null);
        localObject3 = (TextView)paramaepm.findViewById(2131371519);
        localObject2 = (ImageView)paramaepm.findViewById(2131371518);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296357));
        }
        String str = ndq.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label937;
          }
          j = 2130842303;
          label467:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
          SpannableString localSpannableString = new SpannableString(str + "1");
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject4, 0), str.length(), str.length() + 1, 17);
          ((TextView)localObject3).setText(localSpannableString);
        }
      }
      for (;;)
      {
        try
        {
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = null;
          ((URLDrawable.URLDrawableOptions)localObject3).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject3).mGifRoundCorner = 0.0F;
          ((URLDrawable.URLDrawableOptions)localObject3).mExtraInfo = paramMessageRecord;
          if (i != 0) {
            continue;
          }
          j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
          int m = aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = aepi.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(swu.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label937:
          ((ImageView)localObject2).setImageResource(2130837968);
          continue;
        }
        localViewGroup.addView(paramaepm);
        paramaepm.setTag(localObject1);
        paramaepm.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaepm.setOnTouchListener(paramaetk);
        paramaepm.setOnLongClickListener(paramaetk);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramaepm = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramaepm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramaepm.setBackgroundResource(2131165855);
          localViewGroup.addView(paramaepm);
          paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558774, null);
          break label365;
        }
        if (i != 1)
        {
          paramaepm = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramaepm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramaepm.setBackgroundResource(2131165855);
          localViewGroup.addView(paramaepm);
        }
        paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558775, null);
        break label365;
        j = 2130842304;
        break label467;
        j = aepi.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838193);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((alzl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      zaj.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
    }
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    paramContext = acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      syb.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = new bdpi();
    paramView.a(2131365071, this.jdField_a_of_type_AndroidContentContext.getString(2131690760), 2130838673);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afwh
 * JD-Core Version:    0.7.0.1
 */