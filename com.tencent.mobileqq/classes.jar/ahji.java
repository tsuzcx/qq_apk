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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahji
  extends afor
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahjj(this, Looper.getMainLooper());
  bhyn jdField_a_of_type_Bhyn = new ahjl(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bhyq jdField_a_of_type_Bhyq;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ahji(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bhyq = ((bhyq)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
  }
  
  protected afos a()
  {
    return new ahjm(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramaftk = (ahjm)paramafos;
    int i = 0;
    paramafos = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramafos)) {
        i = Integer.parseInt(paramafos);
      }
      paramafos = paramView;
      if (paramView == null)
      {
        paramafos = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558862, null);
        paramaftk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramafos.findViewById(2131364845));
        paramaftk.b = ((TextView)paramafos.findViewById(2131364848));
        paramaftk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramafos.findViewById(2131364844));
        paramaftk.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new ahjk(this, i));
      }
      str = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bibh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!FileUtils.fileExists(paramView)) {}
      }
    }
    catch (Exception paramafos)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramaftk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramaftk.b.setText(str + anvx.a(2131714309) + this.jdField_a_of_type_AndroidContentContext.getString(2131690901, new Object[] { paramView }));
            return paramafos;
          }
          if (2 != i) {
            break;
          }
          paramaftk.b.setText(str + anvx.a(2131714308) + this.jdField_a_of_type_AndroidContentContext.getString(2131690901, new Object[] { paramView }));
          return paramafos;
          paramafos = paramafos;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramafos.getMessage());
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
        paramaftk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847091));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bibh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bhyo(paramView, localFile);
        this.jdField_a_of_type_Bhyq.a(1).a(paramView, this.jdField_a_of_type_Bhyn, paramLinearLayout);
      }
    }
    paramaftk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847091));
    paramaftk.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690901, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690691) }));
    return paramafos;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahji
 * JD-Core Version:    0.7.0.1
 */