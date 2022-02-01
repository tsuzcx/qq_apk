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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class agqs
  extends aexf
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new agqt(this, Looper.getMainLooper());
  bgod jdField_a_of_type_Bgod = new agqv(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bgog jdField_a_of_type_Bgog;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public agqs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bgog = ((bgog)paramQQAppInterface.getManager(47));
  }
  
  protected aexg a()
  {
    return new agqw(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramafce = (agqw)paramaexg;
    int i = 0;
    paramaexg = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramaexg)) {
        i = Integer.parseInt(paramaexg);
      }
      paramaexg = paramView;
      if (paramView == null)
      {
        paramaexg = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558837, null);
        paramafce.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramaexg.findViewById(2131364758));
        paramafce.b = ((TextView)paramaexg.findViewById(2131364761));
        paramafce.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramaexg.findViewById(2131364757));
        paramafce.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new agqu(this, i));
      }
      str = ContactUtils.getFriendNickName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bgqr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!FileUtils.fileExists(paramView)) {}
      }
    }
    catch (Exception paramaexg)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramafce.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramafce.b.setText(str + amtj.a(2131713962) + this.jdField_a_of_type_AndroidContentContext.getString(2131690816, new Object[] { paramView }));
            return paramaexg;
          }
          if (2 != i) {
            break;
          }
          paramafce.b.setText(str + amtj.a(2131713961) + this.jdField_a_of_type_AndroidContentContext.getString(2131690816, new Object[] { paramView }));
          return paramaexg;
          paramaexg = paramaexg;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramaexg.getMessage());
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
        paramafce.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846994));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bgqr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bgoe(paramView, localFile);
        this.jdField_a_of_type_Bgog.a(1).a(paramView, this.jdField_a_of_type_Bgod, paramLinearLayout);
      }
    }
    paramafce.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846994));
    paramafce.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690816, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690614) }));
    return paramaexg;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqs
 * JD-Core Version:    0.7.0.1
 */