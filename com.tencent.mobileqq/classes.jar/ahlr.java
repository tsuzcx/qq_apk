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

public class ahlr
  extends avoy
{
  public HashMap<Long, Integer> a;
  
  public ahlr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected agen a()
  {
    return new ahls(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    Object localObject1 = paramView;
    try
    {
      if (!(paramagen instanceof ahls))
      {
        localObject1 = paramView;
        QLog.e("LoverChattingGrayTipItemBuilder", 1, "diffclashh =" + paramagen.getClass());
      }
      localObject1 = paramView;
      localahls = (ahls)paramagen;
      paramagen = paramView;
      if (paramView == null)
      {
        localObject1 = paramView;
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558620, null);
        localObject1 = paramView;
        localahls.b = ((TextView)paramView.findViewById(2131367670));
        localObject1 = paramView;
        localahls.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370418));
        localObject1 = paramView;
        localObject2 = localahls.b.getLayoutParams();
        paramagen = paramView;
        localObject1 = paramView;
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
        {
          localObject1 = paramView;
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          paramagen = paramView;
          localObject1 = paramView;
          if (((ViewGroup.MarginLayoutParams)localObject2).rightMargin != BaseChatItemLayout.y)
          {
            localObject1 = paramView;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = BaseChatItemLayout.y;
            paramagen = paramView;
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        ahls localahls;
        Object localObject2;
        paramagen = (agen)localObject1;
      }
    }
    try
    {
      localahls.b.setLineSpacing(0.0F, 1.0F);
      localahls.b.setIncludeFontPadding(true);
      localahls.b.setMovementMethod(null);
      localahls.b.setTextColor(paramagen.getResources().getColorStateList(2131167274));
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      }
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageRecord.uniseq)))
      {
        paramView = ObjectAnimator.ofFloat(localahls.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
        localObject1 = ObjectAnimator.ofFloat(localahls.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.0F, 0.8F, 1.0F, 0.8F, 1.0F });
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
        long l2 = localahls.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("LoverChattingGrayTipItemBuilder", 2, new Object[] { "revoke msg grayTipItemBuilder msg uinseq=", Long.valueOf(l1), ",holder.mPosition=", Long.valueOf(l2) });
        }
        paramView = paramMessageRecord.getHightlightMsgText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLinearLayout.getContext(), false, localahls.b);
        paramMessageRecord = paramMessageRecord.tipParam.a;
        localahls.b.setText(paramView);
        localahls.b.setClickable(true);
        localahls.b.setFocusable(true);
        localahls.b.setMovementMethod(LinkMovementMethod.getInstance());
        return paramagen;
      }
      localahls.b.setText(paramMessageRecord.msg);
      localahls.b.setOnTouchListener(paramagjk);
      localahls.b.setOnLongClickListener(paramagjk);
      if (AppSetting.c)
      {
        localahls.b.setAccessibilityDelegate(null);
        return paramagen;
      }
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e("LoverChattingGrayTipItemBuilder", 2, "LoverChattingGrayTipItemBuilder  exception " + paramMessageRecord.toString());
      return paramagen;
    }
    return paramagen;
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt) {}
  
  public bhum[] a(View paramView)
  {
    return new bhuk().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlr
 * JD-Core Version:    0.7.0.1
 */