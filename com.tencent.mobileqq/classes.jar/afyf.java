import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public abstract class afyf
  extends BaseBubbleBuilder
{
  public afyf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, String paramString1, String paramString2, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setBackgroundResource(2130842259);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setEnabled(paramBoolean);
      localTextView.setText(paramString1);
      localTextView.setId(2131364201);
      if (!TextUtils.isEmpty(paramString2))
      {
        Drawable localDrawable = localResources.getDrawable(2130849861);
        localDrawable.setBounds(0, 0, aepi.a(12.0F, localResources), aepi.a(12.0F, localResources));
        paramString1 = localResources.getDrawable(2130849862);
        paramString1.setBounds(0, 0, aepi.a(12.0F, localResources), aepi.a(12.0F, localResources));
        try
        {
          paramString2 = URLDrawable.getDrawable(paramString2, localDrawable, paramString1);
          if (bayu.a(paramContext)) {
            break label259;
          }
          paramBoolean = true;
          ((URLDrawable)paramString2).setAutoDownload(paramBoolean);
          paramContext = paramString2;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, paramContext.getMessage(), paramContext);
            paramContext = paramString1;
          }
        }
        localTextView.setCompoundDrawablePadding(aepi.a(3.0F, localResources));
        paramContext.setBounds(0, 0, aepi.a(12.0F, localResources), aepi.a(12.0F, localResources));
        localTextView.setCompoundDrawables(paramContext, null, null, null);
      }
      for (;;)
      {
        localTextView.setPadding(aepi.a(5.0F, localResources), 0, aepi.a(5.0F, localResources), 0);
        paramView.setTag(paramMessageRecord);
        paramView.setOnClickListener(paramOnClickListener);
        return paramView;
        label259:
        paramBoolean = false;
        break;
        if (paramInt != -1)
        {
          localTextView.setCompoundDrawablePadding(aepi.a(3.0F, localResources));
          paramContext = localResources.getDrawable(paramInt);
          paramContext.setBounds(0, 0, aepi.a(12.0F, localResources), aepi.a(12.0F, localResources));
          localTextView.setCompoundDrawables(paramContext, null, null, null);
        }
        else
        {
          localTextView.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
  
  public View a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener)
  {
    paramSessionInfo = paramBaseChatItemLayout.getContext();
    boolean bool = "2".equals(paramMessageRecord.getExtInfoFromExtStr("app_tail_id"));
    RelativeLayout localRelativeLayout = (RelativeLayout)paramBaseChatItemLayout.findViewById(2131377120);
    arwd localarwd = ((FlashChatManager)paramQQAppInterface.getManager(217)).a;
    int i = FlashChatManager.a(paramMessageRecord);
    if (i == -1) {}
    do
    {
      return paramBaseChatItemLayout;
      String str = paramMessageRecord.getExtInfoFromExtStr("qim_source");
      if ((!TextUtils.isEmpty(localarwd.b)) && (bool) && ("1".equals(str))) {
        break;
      }
    } while (localRelativeLayout == null);
    paramBaseChatItemLayout.removeView(localRelativeLayout);
    return paramBaseChatItemLayout;
    azqs.b(paramQQAppInterface, "dc00898", "", "", "0X8008279", "0X8008279", i, 0, "", "", "", "");
    a(paramBaseChatItemLayout, paramMessageRecord, paramOnClickListener, paramSessionInfo, localRelativeLayout, localarwd.b, localarwd.d, -1, true);
    return paramBaseChatItemLayout;
  }
  
  protected void a(BaseChatItemLayout paramBaseChatItemLayout, MessageRecord paramMessageRecord, View.OnClickListener paramOnClickListener, Context paramContext, RelativeLayout paramRelativeLayout, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramRelativeLayout == null)
    {
      paramRelativeLayout = new RelativeLayout(paramBaseChatItemLayout.getContext());
      paramRelativeLayout.setId(2131377120);
    }
    for (int i = 1;; i = 0)
    {
      Object localObject2 = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      }
      localObject2 = paramBaseChatItemLayout.getResources();
      boolean bool = paramMessageRecord.isSend();
      ((RelativeLayout.LayoutParams)localObject1).topMargin = aepi.a(-2.0F, (Resources)localObject2);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = aepi.a(0.0F, (Resources)localObject2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131364173);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131364173);
      int j;
      if (bool)
      {
        j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (aepi.a(18.0F, (Resources)localObject2) + j);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 0);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364182);
        paramRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = paramRelativeLayout.getChildAt(0);
        if (localObject1 != null) {
          break label248;
        }
        paramRelativeLayout.addView(a(paramContext, (View)localObject1, paramMessageRecord, paramString1, paramString2, paramInt, paramBoolean, paramOnClickListener));
      }
      for (;;)
      {
        if (i != 0) {
          paramBaseChatItemLayout.addView(paramRelativeLayout);
        }
        paramBaseChatItemLayout.requestLayout();
        return;
        j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (aepi.a(9.0F, (Resources)localObject2) + j);
        ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131364173);
        break;
        label248:
        a(paramContext, (View)localObject1, paramMessageRecord, paramString1, paramString2, paramInt, paramBoolean, paramOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyf
 * JD-Core Version:    0.7.0.1
 */