import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class agdo
  extends aepl
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new agdp(this, Looper.getMainLooper());
  bead jdField_a_of_type_Bead = new agdr(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private beag jdField_a_of_type_Beag;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public agdo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Beag = ((beag)paramQQAppInterface.getManager(47));
  }
  
  protected aepm a()
  {
    return new agds(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    paramaetk = (agds)paramaepm;
    int i = 0;
    paramaepm = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramaepm)) {
        i = Integer.parseInt(paramaepm);
      }
      paramaepm = paramView;
      if (paramView == null)
      {
        paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558765, null);
        paramaetk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramaepm.findViewById(2131364475));
        paramaetk.b = ((TextView)paramaepm.findViewById(2131364478));
        paramaetk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramaepm.findViewById(2131364474));
        paramaetk.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new agdq(this, i));
      }
      str = bdgc.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = becr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bdhb.a(paramView)) {}
      }
    }
    catch (Exception paramaepm)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramaetk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
          paramView = paramMessageRecord.getExtInfoFromExtStr("name");
          if (!TextUtils.isEmpty(paramView)) {
            j = 2;
          }
          try
          {
            paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("tipsType");
            i = j;
            if (!TextUtils.isEmpty(paramMessageRecord)) {
              i = Integer.parseInt(paramMessageRecord);
            }
          }
          catch (Exception paramMessageRecord)
          {
            QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView tipsType err:" + paramMessageRecord.getMessage());
            i = j;
            continue;
            paramaetk.b.setText(str + alud.a(2131715322) + this.jdField_a_of_type_AndroidContentContext.getString(2131690933, new Object[] { paramView }));
            return paramaepm;
          }
          if (2 != i) {
            break;
          }
          paramaetk.b.setText(str + alud.a(2131715321) + this.jdField_a_of_type_AndroidContentContext.getString(2131690933, new Object[] { paramView }));
          return paramaepm;
          paramaepm = paramaepm;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramaepm.getMessage());
          i = 0;
        }
        catch (OutOfMemoryError paramView)
        {
          QLog.e("ChatItemBuilder", 1, "decodeFile funcall thum Bitmap OOM.");
          continue;
        }
        catch (Exception paramView)
        {
          QLog.e("ChatItemBuilder", 1, "colorRingCover err:" + paramView.getMessage());
          continue;
        }
        paramaetk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846627));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = becr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new beae(paramView, localFile);
        this.jdField_a_of_type_Beag.a(1).a(paramView, this.jdField_a_of_type_Bead, paramLinearLayout);
      }
    }
    paramaetk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846627));
    paramaetk.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690933, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690639) }));
    return paramaepm;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return new bdpk[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdo
 * JD-Core Version:    0.7.0.1
 */