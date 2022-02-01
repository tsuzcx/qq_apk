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

public class ahku
  extends afuu
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahkv(this, Looper.getMainLooper());
  bhhe jdField_a_of_type_Bhhe = new ahkx(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bhhh jdField_a_of_type_Bhhh;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ahku(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bhhh = ((bhhh)paramQQAppInterface.getManager(47));
  }
  
  protected afuv a()
  {
    return new ahky(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramafzq = (ahky)paramafuv;
    int i = 0;
    paramafuv = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramafuv)) {
        i = Integer.parseInt(paramafuv);
      }
      paramafuv = paramView;
      if (paramView == null)
      {
        paramafuv = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558831, null);
        paramafzq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramafuv.findViewById(2131364681));
        paramafzq.b = ((TextView)paramafuv.findViewById(2131364684));
        paramafzq.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramafuv.findViewById(2131364680));
        paramafzq.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new ahkw(this, i));
      }
      str = bglf.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bhjt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bgmg.a(paramView)) {}
      }
    }
    catch (Exception paramafuv)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramafzq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramafzq.b.setText(str + anni.a(2131713621) + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { paramView }));
            return paramafuv;
          }
          if (2 != i) {
            break;
          }
          paramafzq.b.setText(str + anni.a(2131713620) + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { paramView }));
          return paramafuv;
          paramafuv = paramafuv;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramafuv.getMessage());
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
        paramafzq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847069));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bhjt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bhhf(paramView, localFile);
        this.jdField_a_of_type_Bhhh.a(1).a(paramView, this.jdField_a_of_type_Bhhe, paramLinearLayout);
      }
    }
    paramafzq.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847069));
    paramafzq.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690576) }));
    return paramafuv;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahku
 * JD-Core Version:    0.7.0.1
 */