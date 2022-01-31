import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

public class aizb
  extends bbgu
  implements Handler.Callback, View.OnClickListener
{
  public int a;
  public long a;
  private aenl jdField_a_of_type_Aenl;
  public Context a;
  private Handler jdField_a_of_type_AndroidOsHandler = new bfob(this);
  public View.OnClickListener a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  private baxy jdField_a_of_type_Baxy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public CornerImageView a;
  public String a;
  public int b;
  public ImageView b;
  public TextView b;
  public CornerImageView b;
  private int c;
  public ImageView c;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public aizb(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, 2131755195);
    getWindow().requestFeature(1);
    setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Baxy = new baxy(paramQQAppInterface);
    a();
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return ApolloUtil.a(this.jdField_a_of_type_JavaLangString, "robotOpenId");
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmGamePlayAgainDialog", 0, "[initView] init dialog view.");
    }
    View localView = getLayoutInflater().inflate(2131558791, null);
    this.g = ((TextView)localView.findViewById(2131378096));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368676));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131375378));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378286));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378039));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378320));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131368489));
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(muc.a(this.jdField_a_of_type_AndroidContentContext, 76.0F));
    this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)localView.findViewById(2131368491));
    this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(muc.a(this.jdField_a_of_type_AndroidContentContext, 76.0F));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368523));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368524));
    this.d = ((TextView)localView.findViewById(2131378237));
    this.e = ((TextView)localView.findViewById(2131378328));
    this.f = ((TextView)localView.findViewById(2131378126));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.g.setTextColor(aize.a(Color.parseColor("#ffffff"), Color.parseColor("#80ffec00")));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(aize.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(aize.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(aize.a(Color.parseColor("#ffec00"), Color.parseColor("#80ffec00")));
    this.f.setBackgroundDrawable(new anpa(Color.parseColor("#4d000000"), muc.a(this.jdField_a_of_type_AndroidContentContext, 20.0F), (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 250.0F), (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 29.0F)));
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(aize.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)bbdh.i() - muc.a(this.jdField_a_of_type_AndroidContentContext, 54.0F)), (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#000000"));
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(aize.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)bbdh.i() - muc.a(this.jdField_a_of_type_AndroidContentContext, 64.0F)) / 2, (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#000000"));
    this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundDrawable(aize.a(this.jdField_a_of_type_AndroidContentContext, (int)((float)bbdh.i() - muc.a(this.jdField_a_of_type_AndroidContentContext, 64.0F)) / 2, (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), "#3e3f40"));
    setContentView(localView);
    getWindow().setLayout(-1, -1);
    getWindow().getDecorView().setBackgroundColor(Color.parseColor("#9f000000"));
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131702110));
      this.g.setVisibility(0);
      return;
    }
    if (paramInt == 1)
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).arg1 = 30;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.f.setVisibility(0);
      this.f.setText(ajya.a(2131702111));
      this.g.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Aenl != null)
    {
      this.f.setVisibility(0);
      String str = this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString;
      localObject = str;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString))
      {
        TextPaint localTextPaint = new TextPaint();
        paramInt = this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString.length();
        float f1 = localTextPaint.measureText(this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString);
        localObject = str;
        while (f1 > 60.0F)
        {
          localObject = this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString;
          paramInt -= 1;
          localObject = ((String)localObject).substring(0, paramInt);
          f1 = localTextPaint.measureText((String)localObject);
        }
        if (paramInt < this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString.length()) {
          localObject = this.jdField_a_of_type_Aenl.jdField_a_of_type_JavaLangString.substring(0, paramInt - 1) + "...";
        }
      }
      this.f.setText((String)localObject + ajya.a(2131702109));
    }
    this.g.setVisibility(4);
    Object localObject = Message.obtain();
    ((Message)localObject).what = 2;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 30000L);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(aenl paramaenl, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aenl = paramaenl;
    this.d.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    this.e.setText(paramaenl.jdField_a_of_type_JavaLangString);
    paramString = URLDrawable.URLDrawableOptions.obtain();
    paramString.mRequestWidth = ((int)muc.a(getContext(), 173.0F));
    paramString.mRequestHeight = ((int)muc.a(getContext(), 97.0F));
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_fail.png", paramString);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
    }
    for (;;)
    {
      paramString = this.jdField_a_of_type_Baxy.a(3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0, (byte)3);
      this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString));
      this.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setImageURL(paramaenl.d);
      a(0);
      return;
      if (paramInt2 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_success.png", paramString);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        paramString = URLDrawable.getDrawable("https://cmshow.gtimg.cn/client/img/cmgame_aio_draw.png", paramString);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void dismiss()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.dismiss();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if (paramMessage.arg1 >= 0) {
          break;
        }
      } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage.arg1 + "s");
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      int i = paramMessage.arg1 - 1;
      paramMessage.arg1 = i;
      localMessage.arg1 = i;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1000L);
      return true;
    } while (this.jdField_a_of_type_AndroidViewView$OnClickListener == null);
    this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
    return true;
  }
  
  public void onClick(View paramView)
  {
    QLog.e("CmGamePlayAgainDialog", 1, "[onclick] " + paramView.getClass().toString() + ",id:" + paramView.getId());
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.g);
      }
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizb
 * JD-Core Version:    0.7.0.1
 */