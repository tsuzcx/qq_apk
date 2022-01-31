import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import java.net.MalformedURLException;
import java.net.URL;

public class afqa
  extends BaseBubbleBuilder
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afqb(this);
  float b;
  
  public afqa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 2.0F;
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private Drawable a()
  {
    Bitmap localBitmap1 = bcwc.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130839433);
    if (localBitmap1 == null) {
      return null;
    }
    int i = localBitmap1.getWidth();
    int j = localBitmap1.getHeight();
    Bitmap localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    localBitmap2.setDensity(160);
    Canvas localCanvas = new Canvas(localBitmap2);
    Paint localPaint = new Paint(1);
    localPaint.setColor(-16777216);
    Rect localRect = new Rect(0, 0, i, j);
    RectF localRectF = new RectF(localRect);
    float f = 11.0F * this.jdField_b_of_type_Float;
    localCanvas.drawRoundRect(localRectF, f, f, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(localBitmap1, localRect, localRect, localPaint);
    if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
      localBitmap1.recycle();
    }
    return new BitmapDrawable(localBitmap2);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afqe(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramView = (afqe)paramChatMessage.getTag();
    paramInt1 = aekt.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = paramView.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramView.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int j = paramView.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int k = paramView.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramView.jdField_a_of_type_AndroidViewView.setPadding(paramInt2 + paramInt1, j + paramInt1, i + paramInt1, paramInt1 + k);
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afqe localafqe = (afqe)paramaelt;
    paramBaseChatItemLayout = (MessageForText)paramChatMessage;
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558773, null);
      localafqe.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaelt.findViewById(2131364174));
      localafqe.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramaelt.findViewById(2131364170));
    }
    paramView = paramBaseChatItemLayout.location;
    if ((paramView == null) || (paramView.length() == 0)) {
      localafqe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      paramView = paramBaseChatItemLayout.locationUrl;
      try
      {
        paramBaseChatItemLayout = new URL("location", paramView.getAuthority(), paramView.getFile());
        paramView = paramBaseChatItemLayout;
      }
      catch (MalformedURLException paramBaseChatItemLayout)
      {
        for (;;)
        {
          paramBaseChatItemLayout.printStackTrace();
        }
      }
      paramView = URLDrawable.getDrawable(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramView.setTag(paramChatMessage);
      localafqe.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      paramaelt.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramaelt.setOnLongClickListener(paramaeov);
      paramaelt.setOnTouchListener(paramaeov);
      return paramaelt;
      localafqe.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localafqe.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131706680);
  }
  
  String a(MessageForText paramMessageForText)
  {
    return aljq.cc + paramMessageForText.latitude + "_" + paramMessageForText.longitude + ".png";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131366750)
    {
      paramChatMessage = (MessageForText)paramChatMessage;
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -2);
      paramContext.putString("forward_latitude", paramChatMessage.latitude);
      paramContext.putString("forward_longitude", paramChatMessage.longitude);
      paramContext.putString("forward_location", paramChatMessage.location);
      paramContext.putString("forward_filepath", paramChatMessage.url);
      paramContext.putString("forward_thumb", a(paramChatMessage));
      paramContext.putString("forward_location_string", paramChatMessage.location);
      paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 2131365069)
      {
        acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131370842)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131366015)
      {
        paramContext = (MessageForText)paramChatMessage;
        biqt.a(Float.valueOf(paramContext.latitude).floatValue(), Float.valueOf(paramContext.longitude).floatValue(), null, paramContext.location, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
        return;
      }
    } while (paramInt != 2131370831);
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aekt.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)aekt.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690042);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131690043);
    } while (!paramView.isSendFromLocal());
    bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new afqc(this, paramView), new afqd(this)).show();
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    paramView.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    acex.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (aekt.a(5) == 1) {
      paramView.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
    }
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqa
 * JD-Core Version:    0.7.0.1
 */