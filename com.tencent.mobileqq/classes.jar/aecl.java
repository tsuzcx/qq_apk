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

public class aecl
  extends actm
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new aecm(this, Looper.getMainLooper());
  bbwt jdField_a_of_type_Bbwt = new aeco(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bbww jdField_a_of_type_Bbww;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public aecl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bbww = ((bbww)paramQQAppInterface.getManager(47));
  }
  
  protected actn a()
  {
    return new aecp(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramacxj = (aecp)paramactn;
    int i = 0;
    paramactn = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramactn)) {
        i = Integer.parseInt(paramactn);
      }
      paramactn = paramView;
      if (paramView == null)
      {
        paramactn = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558730, null);
        paramacxj.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramactn.findViewById(2131364402));
        paramacxj.b = ((TextView)paramactn.findViewById(2131364405));
        paramacxj.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramactn.findViewById(2131364401));
        paramacxj.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new aecn(this, i));
      }
      str = bbcz.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bbdx.a(paramView)) {}
      }
    }
    catch (Exception paramactn)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramacxj.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramacxj.b.setText(str + ajya.a(2131714938) + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { paramView }));
            return paramactn;
          }
          if (2 != i) {
            break;
          }
          paramacxj.b.setText(str + ajya.a(2131714937) + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { paramView }));
          return paramactn;
          paramactn = paramactn;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramactn.getMessage());
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
        paramacxj.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846175));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bbzh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bbwu(paramView, localFile);
        this.jdField_a_of_type_Bbww.a(1).a(paramView, this.jdField_a_of_type_Bbwt, paramLinearLayout);
      }
    }
    paramacxj.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846175));
    paramacxj.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690588) }));
    return paramactn;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bbmh[] a(View paramView)
  {
    return new bbmh[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecl
 * JD-Core Version:    0.7.0.1
 */