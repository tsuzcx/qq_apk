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

public class aecn
  extends actq
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new aeco(this, Looper.getMainLooper());
  bbwf jdField_a_of_type_Bbwf = new aecq(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bbwi jdField_a_of_type_Bbwi;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public aecn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bbwi = ((bbwi)paramQQAppInterface.getManager(47));
  }
  
  protected actr a()
  {
    return new aecr(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramacxn = (aecr)paramactr;
    int i = 0;
    paramactr = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramactr)) {
        i = Integer.parseInt(paramactr);
      }
      paramactr = paramView;
      if (paramView == null)
      {
        paramactr = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558730, null);
        paramacxn.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramactr.findViewById(2131364403));
        paramacxn.b = ((TextView)paramactr.findViewById(2131364406));
        paramacxn.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramactr.findViewById(2131364402));
        paramacxn.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new aecp(this, i));
      }
      str = bbcl.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bbyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bbdj.a(paramView)) {}
      }
    }
    catch (Exception paramactr)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramacxn.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramacxn.b.setText(str + ajyc.a(2131714927) + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { paramView }));
            return paramactr;
          }
          if (2 != i) {
            break;
          }
          paramacxn.b.setText(str + ajyc.a(2131714926) + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { paramView }));
          return paramactr;
          paramactr = paramactr;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramactr.getMessage());
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
        paramacxn.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846169));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bbyt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bbwg(paramView, localFile);
        this.jdField_a_of_type_Bbwi.a(1).a(paramView, this.jdField_a_of_type_Bbwf, paramLinearLayout);
      }
    }
    paramacxn.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846169));
    paramacxn.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690879, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690588) }));
    return paramactr;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bblt[] a(View paramView)
  {
    return new bblt[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aecn
 * JD-Core Version:    0.7.0.1
 */