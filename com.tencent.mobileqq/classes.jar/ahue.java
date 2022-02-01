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

public class ahue
  extends agem
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new ahuf(this, Looper.getMainLooper());
  biht jdField_a_of_type_Biht = new ahuh(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bihw jdField_a_of_type_Bihw;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public ahue(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bihw = ((bihw)paramQQAppInterface.getManager(47));
  }
  
  protected agen a()
  {
    return new ahui(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramagjk = (ahui)paramagen;
    int i = 0;
    paramagen = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramagen)) {
        i = Integer.parseInt(paramagen);
      }
      paramagen = paramView;
      if (paramView == null)
      {
        paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558829, null);
        paramagjk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramagen.findViewById(2131364727));
        paramagjk.b = ((TextView)paramagen.findViewById(2131364730));
        paramagjk.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramagen.findViewById(2131364726));
        paramagjk.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new ahug(this, i));
      }
      str = bhlg.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = biki.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bhmi.a(paramView)) {}
      }
    }
    catch (Exception paramagen)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramagjk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramagjk.b.setText(str + anzj.a(2131713730) + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { paramView }));
            return paramagen;
          }
          if (2 != i) {
            break;
          }
          paramagjk.b.setText(str + anzj.a(2131713729) + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { paramView }));
          return paramagen;
          paramagen = paramagen;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramagen.getMessage());
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
        paramagjk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847086));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = biki.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new bihu(paramView, localFile);
        this.jdField_a_of_type_Bihw.a(1).a(paramView, this.jdField_a_of_type_Biht, paramLinearLayout);
      }
    }
    paramagjk.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847086));
    paramagjk.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131690776, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690574) }));
    return paramagen;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhum[] a(View paramView)
  {
    return new bhum[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahue
 * JD-Core Version:    0.7.0.1
 */