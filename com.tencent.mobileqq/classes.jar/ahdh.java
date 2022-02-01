import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;

public class ahdh
  extends afuu
{
  View.OnClickListener a;
  
  public ahdh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahdi(this);
  }
  
  private void a(MessageForPubAccount paramMessageForPubAccount, ahdj paramahdj, long paramLong, String paramString)
  {
    if ((paramahdj == null) || (paramMessageForPubAccount == null)) {}
    do
    {
      return;
      if (paramLong > 0L) {
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      oda localoda = (oda)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      odu localodu = (odu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if ((localoda != null) && (localodu != null) && (localoda.a(paramMessageForPubAccount.senderuin))) {
        localodu.a(false, paramMessageForPubAccount, paramahdj.d + 1, paramString);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) == null) || (!((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (paramMessageForPubAccount.mPAMessage.items == null) || (paramMessageForPubAccount.mPAMessage.items.size() <= 0));
    aaxb.a(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
  }
  
  private void a(PAMessage.Item paramItem, ahdj paramahdj, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bgmp localbgmp = bgng.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
      int i;
      if (localbgmp == null) {
        if (paramItem.appId != 0L)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
          if (ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            break label132;
          }
          ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahdj.jdField_a_of_type_JavaLangString, paramahdj.jdField_b_of_type_JavaLangString, paramahdj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        }
      }
      for (;;)
      {
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_35", "singlepic_allclick");
        return;
        i = 0;
        break;
        label132:
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
        continue;
        label155:
        ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahdj.jdField_a_of_type_JavaLangString, paramahdj.jdField_b_of_type_JavaLangString, paramahdj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        continue;
        if (TextUtils.isEmpty(localbgmp.a()))
        {
          if (!ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahdj.jdField_a_of_type_JavaLangString, paramahdj.jdField_b_of_type_JavaLangString, paramahdj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else if (!localbgmp.a()) {
          ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahdj.jdField_a_of_type_JavaLangString, paramahdj.jdField_b_of_type_JavaLangString, paramahdj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
        }
      }
    }
    ahdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahdj.jdField_a_of_type_JavaLangString, paramahdj.jdField_b_of_type_JavaLangString, paramahdj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
  }
  
  protected afuv a()
  {
    return new ahdj(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364379);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
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
      paramafuv = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramafuv.setText(localPAMessage.grayTips);
      paramafuv.setGravity(17);
      paramafuv.setSingleLine();
      paramafuv.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramafuv.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramafuv.setBackgroundResource(2130844771);
      paramafuv.setPadding(bggq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bggq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), bggq.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bggq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramafuv.setTextColor(-1);
      paramafuv.setTextSize(12.0F);
      localViewGroup.addView(paramafuv);
    }
    int i = 0;
    label376:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new ahdj(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((ahdj)localObject1).jdField_b_of_type_Int = 5;
      ((ahdj)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((ahdj)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((ahdj)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((ahdj)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((ahdj)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((ahdj)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramafuv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558841, null);
        localObject3 = (TextView)paramafuv.findViewById(2131372090);
        localObject2 = (ImageView)paramafuv.findViewById(2131372089);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296391));
        }
        String str = nmj.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label953;
          }
          j = 2130842613;
          label481:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = bggq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, bggq.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, bggq.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
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
          int m = afur.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = afur.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(tyc.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label953:
          ((ImageView)localObject2).setImageResource(2130838062);
          continue;
        }
        localViewGroup.addView(paramafuv);
        paramafuv.setTag(localObject1);
        paramafuv.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramafuv.setOnTouchListener(paramafzq);
        paramafuv.setOnLongClickListener(paramafzq);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramafuv = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bggq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramafuv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramafuv.setBackgroundResource(2131165910);
          localViewGroup.addView(paramafuv);
          paramafuv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558839, null);
          break label376;
        }
        if (i != 1)
        {
          paramafuv = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bggq.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramafuv.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramafuv.setBackgroundResource(2131165910);
          localViewGroup.addView(paramafuv);
        }
        paramafuv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558840, null);
        break label376;
        j = 2130842614;
        break label481;
        j = afur.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838306);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((anrs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      aaxb.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
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
    paramContext = adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      adrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      tzo.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bguj[] a(View paramView)
  {
    paramView = new bguh();
    paramView.a(2131365308, this.jdField_a_of_type_AndroidContentContext.getString(2131690641), 2130838924);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdh
 * JD-Core Version:    0.7.0.1
 */