import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.HashMap;

public class aduc
  extends aquw
{
  public HashMap<Long, Integer> a;
  
  public aduc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected actn a()
  {
    return new adud(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    Object localObject1 = paramView;
    try
    {
      if (!(paramactn instanceof adud))
      {
        localObject1 = paramView;
        QLog.e("LoverChattingGrayTipItemBuilder", 1, "diffclashh =" + paramactn.getClass());
      }
      localObject1 = paramView;
      localadud = (adud)paramactn;
      paramactn = paramView;
      if (paramView == null)
      {
        localObject1 = paramView;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558560, null);
        localObject1 = paramView;
        localadud.b = ((TextView)paramView.findViewById(2131367154));
        localObject1 = paramView;
        localadud.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369593));
        localObject1 = paramView;
        localObject2 = localadud.b.getLayoutParams();
        paramactn = paramView;
        localObject1 = paramView;
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
        {
          localObject1 = paramView;
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          paramactn = paramView;
          localObject1 = paramView;
          if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != BaseChatItemLayout.x)
          {
            localObject1 = paramView;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = BaseChatItemLayout.x;
            paramactn = paramView;
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        adud localadud;
        Object localObject2;
        paramactn = (actn)localObject1;
      }
    }
    try
    {
      localadud.b.setLineSpacing(0.0F, 1.0F);
      localadud.b.setIncludeFontPadding(true);
      localadud.b.setMovementMethod(null);
      localadud.b.setTextColor(paramactn.getResources().getColorStateList(2131167108));
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageRecord.uniseq)))
      {
        paramView = ObjectAnimator.ofFloat(localadud.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject1 = ObjectAnimator.ofFloat(localadud.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play(paramView).with((Animator)localObject1);
        ((AnimatorSet)localObject2).setDuration(3000L);
        ((AnimatorSet)localObject2).start();
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageRecord.uniseq), Integer.valueOf(1));
        localObject1 = paramMessageRecord.getExtInfoFromExtStr("love_c2c_aio_businessSubtype");
        paramView = (View)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramView = "1";
        }
        LpReportInfo_dc03950.report(new LpReportInfo_dc03950("16", paramView, "", "1"));
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, "revoke msg grayTipItemBuilder msg uinseq=  message" + paramMessageRecord.msg.hashCode());
        }
      }
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if ((paramMessageRecord.tipParam != null) && (paramMessageRecord.tipParam.a != null))
      {
        long l1 = paramMessageRecord.uniseq;
        long l2 = localadud.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
        }
        paramView = paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localadud.b);
        paramMessageRecord = paramMessageRecord.tipParam.a;
        localadud.b.setText(paramView);
        localadud.b.setClickable(true);
        localadud.b.setFocusable(true);
        localadud.b.setMovementMethod(LinkMovementMethod.getInstance());
        return paramactn;
      }
      localadud.b.setText(paramMessageRecord.msg);
      localadud.b.setOnTouchListener(paramacxj);
      localadud.b.setOnLongClickListener(paramacxj);
      if (AppSetting.d)
      {
        localadud.b.setAccessibilityDelegate(null);
        return paramactn;
      }
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("LoverChattingGrayTipItemBuilder", 2, "LoverChattingGrayTipItemBuilder  exception " + paramMessageRecord.toString());
      return paramactn;
    }
    return paramactn;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  public bbmh[] a(View paramView)
  {
    return new bbmf().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduc
 * JD-Core Version:    0.7.0.1
 */