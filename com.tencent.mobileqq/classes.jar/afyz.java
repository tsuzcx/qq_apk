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

public class afyz
  extends aekw
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new afza(this, Looper.getMainLooper());
  bdvu jdField_a_of_type_Bdvu = new afzc(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bdvx jdField_a_of_type_Bdvx;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public afyz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bdvx = ((bdvx)paramQQAppInterface.getManager(47));
  }
  
  protected aekx a()
  {
    return new afzd(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramaeov = (afzd)paramaekx;
    int i = 0;
    paramaekx = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramaekx)) {
        i = Integer.parseInt(paramaekx);
      }
      paramaekx = paramView;
      if (paramView == null)
      {
        paramaekx = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558766, null);
        paramaeov.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramaekx.findViewById(2131364473));
        paramaeov.b = ((TextView)paramaekx.findViewById(2131364476));
        paramaeov.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramaekx.findViewById(2131364472));
        paramaeov.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new afzb(this, i));
      }
      str = bdbt.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bdyi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bdcs.a(paramView)) {}
      }
    }
    catch (Exception paramaekx)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramaeov.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramaeov.b.setText(str + alpo.a(2131715310) + this.jdField_a_of_type_AndroidContentContext.getString(2131690932, new Object[] { paramView }));
            return paramaekx;
          }
          if (2 != i) {
            break;
          }
          paramaeov.b.setText(str + alpo.a(2131715309) + this.jdField_a_of_type_AndroidContentContext.getString(2131690932, new Object[] { paramView }));
          return paramaekx;
          paramaekx = paramaekx;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramaekx.getMessage());
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
        paramaeov.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846554));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bdyi.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bdvv(paramView, localFile);
        this.jdField_a_of_type_Bdvx.a(1).a(paramView, this.jdField_a_of_type_Bdvu, paramLinearLayout);
      }
    }
    paramaeov.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846554));
    paramaeov.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690932, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690639) }));
    return paramaekx;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdlb[] a(View paramView)
  {
    return new bdlb[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyz
 * JD-Core Version:    0.7.0.1
 */