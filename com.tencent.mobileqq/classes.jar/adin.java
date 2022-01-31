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

public class adin
  extends BaseBubbleBuilder
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = a();
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new adio(this);
  float b;
  
  public adin(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = 2.0F;
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  }
  
  private Drawable a()
  {
    Bitmap localBitmap1 = azvq.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130839328);
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
  
  public acju a()
  {
    return new adir(this);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramView = (adir)paramChatMessage.getTag();
    paramInt1 = aciy.a(1.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = paramView.jdField_a_of_type_AndroidViewView.getPaddingLeft();
    int i = paramView.jdField_a_of_type_AndroidViewView.getPaddingRight();
    int j = paramView.jdField_a_of_type_AndroidViewView.getPaddingTop();
    int k = paramView.jdField_a_of_type_AndroidViewView.getPaddingBottom();
    paramView.jdField_a_of_type_AndroidViewView.setPadding(paramInt2 + paramInt1, j + paramInt1, i + paramInt1, paramInt1 + k);
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adir localadir = (adir)paramacju;
    paramBaseChatItemLayout = (MessageForText)paramChatMessage;
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493181, null);
      localadir.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacju.findViewById(2131298555));
      localadir.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacju.findViewById(2131298551));
    }
    paramView = paramBaseChatItemLayout.location;
    if ((paramView == null) || (paramView.length() == 0)) {
      localadir.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
      localadir.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(paramView);
      paramacju.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramacju.setOnLongClickListener(paramacmv);
      paramacju.setOnTouchListener(paramacmv);
      return paramacju;
      localadir.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localadir.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131640512);
  }
  
  String a(MessageForText paramMessageForText)
  {
    return ajed.bT + paramMessageForText.latitude + "_" + paramMessageForText.longitude + ".png";
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131301021)
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
      aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 2131299417)
      {
        aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
        return;
      }
      if (paramInt == 2131304871)
      {
        super.d(paramChatMessage);
        return;
      }
      if (paramInt == 2131300328)
      {
        paramContext = (MessageForText)paramChatMessage;
        bfhl.a(Float.valueOf(paramContext.latitude).floatValue(), Float.valueOf(paramContext.longitude).floatValue(), null, paramContext.location, null).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 7);
        return;
      }
    } while (paramInt != 2131304860);
    super.d(paramChatMessage);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (aciy.a(paramView).isMultiMsg) {}
    String str1;
    String str2;
    do
    {
      return;
      paramView = (MessageForText)aciy.a(paramView);
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131624443);
      str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131624444);
    } while (!paramView.isSendFromLocal());
    babr.a(this.jdField_a_of_type_AndroidContentContext, 230, str1, str2, new adip(this, paramView), new adiq(this)).show();
  }
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    paramView.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
    aael.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (aciy.a(5) == 1) {
      paramView.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
    }
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.d(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adin
 * JD-Core Version:    0.7.0.1
 */