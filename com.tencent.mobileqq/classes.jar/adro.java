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

public class adro
  extends acjb
{
  public static int a;
  Handler jdField_a_of_type_AndroidOsHandler = new adrp(this, Looper.getMainLooper());
  batl jdField_a_of_type_Batl = new adrr(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private bato jdField_a_of_type_Bato;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public adro(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Bato = ((bato)paramQQAppInterface.getManager(47));
  }
  
  protected acjc a()
  {
    return new adrs(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramacmv = (adrs)paramacjc;
    int i = 0;
    paramacjc = paramMessageRecord.getExtInfoFromExtStr("callId");
    String str;
    int j;
    try
    {
      if (!TextUtils.isEmpty(paramacjc)) {
        i = Integer.parseInt(paramacjc);
      }
      paramacjc = paramView;
      if (paramView == null)
      {
        paramacjc = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493174, null);
        paramacmv.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView = ((AnyScaleTypeImageView)paramacjc.findViewById(2131298843));
        paramacmv.b = ((TextView)paramacjc.findViewById(2131298846));
        paramacmv.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramacjc.findViewById(2131298842));
        paramacmv.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(new adrq(this, i));
      }
      str = babh.i(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin);
      if (i != 0)
      {
        paramLinearLayout = paramMessageRecord.getExtInfoFromExtStr("url_call_thum");
        paramView = bavz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, paramLinearLayout);
        localFile = new File(paramView);
        if (!bace.a(paramView)) {}
      }
    }
    catch (Exception paramacjc)
    {
      for (;;)
      {
        File localFile;
        try
        {
          paramacmv.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageBitmap(BitmapFactory.decodeFile(paramView));
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
            paramacmv.b.setText(str + ajjy.a(2131649138) + this.jdField_a_of_type_AndroidContentContext.getString(2131625307, new Object[] { paramView }));
            return paramacjc;
          }
          if (2 != i) {
            break;
          }
          paramacmv.b.setText(str + ajjy.a(2131649137) + this.jdField_a_of_type_AndroidContentContext.getString(2131625307, new Object[] { paramView }));
          return paramacjc;
          paramacjc = paramacjc;
          QLog.e("ChatItemBuilder", 1, "ThumbItemBuilder getItemView err:" + paramacjc.getMessage());
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
        paramacmv.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845988));
        paramView = paramLinearLayout;
        if (TextUtils.isEmpty(paramLinearLayout)) {
          paramView = bavz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, 8, null);
        }
        paramLinearLayout = new Bundle();
        paramLinearLayout.putInt("type", 1);
        paramView = new batm(paramView, localFile);
        this.jdField_a_of_type_Bato.a(1).a(paramView, this.jdField_a_of_type_Batl, paramLinearLayout);
      }
    }
    paramacmv.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845988));
    paramacmv.b.setText(str + this.jdField_a_of_type_AndroidContentContext.getString(2131625307, new Object[] { this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131625027) }));
    return paramacjc;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bakj[] a(View paramView)
  {
    return new bakj[0];
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adro
 * JD-Core Version:    0.7.0.1
 */