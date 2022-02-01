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

public class ahmt
  extends agem
{
  View.OnClickListener a;
  
  public ahmt(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahmu(this);
  }
  
  private void a(MessageForPubAccount paramMessageForPubAccount, ahmv paramahmv, long paramLong, String paramString)
  {
    if ((paramahmv == null) || (paramMessageForPubAccount == null)) {}
    do
    {
      return;
      if (paramLong > 0L) {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramMessageForPubAccount.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramLong), "", "", "");
      }
      oek localoek = (oek)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      ofe localofe = (ofe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if ((localoek != null) && (localofe != null) && (localoek.a(paramMessageForPubAccount.senderuin))) {
        localofe.a(false, paramMessageForPubAccount, paramahmv.d + 1, paramString);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) == null) || (!((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (paramMessageForPubAccount.mPAMessage.items == null) || (paramMessageForPubAccount.mPAMessage.items.size() <= 0));
    abbe.a(paramMessageForPubAccount.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramMessageForPubAccount.mPAMessage.items.get(0)).title });
  }
  
  private void a(PAMessage.Item paramItem, ahmv paramahmv, String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      bhmr localbhmr = bhni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramString);
      int i;
      if (localbhmr == null) {
        if (paramItem.appId != 0L)
        {
          i = 1;
          if (i == 0) {
            break label155;
          }
          if (ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            break label132;
          }
          ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmv.jdField_a_of_type_JavaLangString, paramahmv.jdField_b_of_type_JavaLangString, paramahmv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
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
        ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmv.jdField_a_of_type_JavaLangString, paramahmv.jdField_b_of_type_JavaLangString, paramahmv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        continue;
        if (TextUtils.isEmpty(localbhmr.a()))
        {
          if (!ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramItem.nativeJumpString, paramItem.appId, paramString)) {
            ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmv.jdField_a_of_type_JavaLangString, paramahmv.jdField_b_of_type_JavaLangString, paramahmv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
          } else {
            PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_37", "singlepic_appclick");
          }
        }
        else if (!localbhmr.a()) {
          ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmv.jdField_a_of_type_JavaLangString, paramahmv.jdField_b_of_type_JavaLangString, paramahmv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
        } else {
          PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_36", "singlepic_mqqclick");
        }
      }
    }
    ahmw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramahmv.jdField_a_of_type_JavaLangString, paramahmv.jdField_b_of_type_JavaLangString, paramahmv.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, paramLong);
  }
  
  protected agen a()
  {
    return new ahmv(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    if (paramChatMessage != null)
    {
      paramChatMessage.setId(2131364423);
      paramChatMessage.setClickable(true);
      paramChatMessage.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.h, BaseChatItemLayout.k, BaseChatItemLayout.i);
    }
    return paramChatMessage;
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
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
      paramagen = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramagen.setText(localPAMessage.grayTips);
      paramagen.setGravity(17);
      paramagen.setSingleLine();
      paramagen.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      localObject1 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject1).leftMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).topMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).rightMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      ((LinearLayout.LayoutParams)localObject1).gravity = 17;
      paramagen.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramagen.setBackgroundResource(2130844785);
      paramagen.setPadding(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bhgr.a(this.jdField_a_of_type_AndroidContentContext, 4.0F), bhgr.a(this.jdField_a_of_type_AndroidContentContext, 9.0F), bhgr.a(this.jdField_a_of_type_AndroidContentContext, 4.0F));
      paramagen.setTextColor(-1);
      paramagen.setTextSize(12.0F);
      localViewGroup.addView(paramagen);
    }
    int i = 0;
    label376:
    Object localObject2;
    if (i < localArrayList.size())
    {
      localObject1 = new ahmv(this);
      PAMessage.Item localItem = (PAMessage.Item)localArrayList.get(i);
      ((ahmv)localObject1).jdField_b_of_type_Int = 5;
      ((ahmv)localObject1).jdField_c_of_type_JavaLangString = localItem.url;
      ((ahmv)localObject1).jdField_c_of_type_Int = localPAMessage.type;
      ((ahmv)localObject1).jdField_b_of_type_JavaLangString = localItem.actionUrl;
      ((ahmv)localObject1).jdField_a_of_type_JavaLangString = localItem.nativeJumpString;
      ((ahmv)localObject1).jdField_a_of_type_Long = paramLinearLayout.uniseq;
      ((ahmv)localObject1).d = i;
      Object localObject3;
      int j;
      if (i == 0)
      {
        paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558839, null);
        localObject3 = (TextView)paramagen.findViewById(2131372204);
        localObject2 = (ImageView)paramagen.findViewById(2131372203);
        if ((i == 0) && ((localObject2 instanceof PAImageView))) {
          ((PAImageView)localObject2).setUseRadiusRound(true, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296395));
        }
        String str = noe.c(localItem.title);
        ((TextView)localObject3).setText(str);
        if (localItem.mVideoFlag == 1)
        {
          Object localObject4 = this.jdField_a_of_type_AndroidContentContext.getResources();
          if (i != 0) {
            break label953;
          }
          j = 2130842626;
          label481:
          localObject4 = ((Resources)localObject4).getDrawable(j);
          j = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
          ((Drawable)localObject4).setBounds(j, 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 17.0F) + j, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
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
          int m = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          int n = agej.a(150.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = (j - m);
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = n;
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(tye.a(localItem.cover, 0), (URLDrawable.URLDrawableOptions)localObject3));
        }
        catch (Exception localException)
        {
          label953:
          ((ImageView)localObject2).setImageResource(2130838072);
          continue;
        }
        localViewGroup.addView(paramagen);
        paramagen.setTag(localObject1);
        paramagen.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramagen.setOnTouchListener(paramagjk);
        paramagen.setOnLongClickListener(paramagjk);
        i += 1;
        break;
        if (i == localArrayList.size() - 1)
        {
          paramagen = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramagen.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramagen.setBackgroundResource(2131165911);
          localViewGroup.addView(paramagen);
          paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558837, null);
          break label376;
        }
        if (i != 1)
        {
          paramagen = new ImageView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new ViewGroup.MarginLayoutParams(-1, k);
          j = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = j;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = j;
          paramagen.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          paramagen.setBackgroundResource(2131165911);
          localViewGroup.addView(paramagen);
        }
        paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558838, null);
        break label376;
        j = 2130842627;
        break label481;
        j = agej.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
      }
    }
    paramView.setBackgroundResource(2130838316);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((aody)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramLinearLayout.mPAMessage.items != null) && (paramLinearLayout.mPAMessage.items.size() > 0)) {
      abbe.a(paramLinearLayout.frienduin, "auth_aio", "exp", 0, 0, new String[] { "", "1", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, ((PAMessage.Item)paramLinearLayout.mPAMessage.items.get(0)).title });
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
    paramContext = aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      aean.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      tzq.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    paramView.a(2131365352, this.jdField_a_of_type_AndroidContentContext.getString(2131690639), 2130838934);
    a(paramView);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmt
 * JD-Core Version:    0.7.0.1
 */