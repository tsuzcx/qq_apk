import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseSystemActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.AppConstants;

public class adxu
  extends CursorAdapter
{
  adxz jdField_a_of_type_Adxz;
  
  public adxu(QQBroadcastActivity paramQQBroadcastActivity, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    paramQQBroadcastActivity.a(paramCursor);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity, SplashActivity.class), null);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.trim().length() != 0) {}
    }
    else
    {
      str = paramString1;
    }
    localIntent.putExtra("uinname", str);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.startActivity(localIntent);
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    Object localObject = paramCursor.getString(paramCursor.getColumnIndex("msg"));
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
    this.jdField_a_of_type_Adxz = ((adxz)paramView.getTag());
    if (this.jdField_a_of_type_Adxz == null)
    {
      this.jdField_a_of_type_Adxz = new adxz(null);
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379441));
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131378096));
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379412));
      this.jdField_a_of_type_Adxz.c = ((TextView)paramView.findViewById(2131379444));
      this.jdField_a_of_type_Adxz.d = ((TextView)paramView.findViewById(2131379440));
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371704));
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363706);
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363618));
      paramView.setTag(this.jdField_a_of_type_Adxz);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.a(l2) != -1L)
    {
      this.jdField_a_of_type_Adxz.d.setVisibility(0);
      this.jdField_a_of_type_Adxz.d.setText(BaseSystemActivity.a(1000L * l1, false));
      label274:
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(new adxv(this, l2));
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getSharedPreferences(String.valueOf(AppConstants.QQBROADCAST_MSG_UIN), 0);
      paramCursor = "QQBROADCAST_MSG_UIN" + l2 + l1;
      if (!paramView.contains(paramCursor)) {
        break label450;
      }
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
        this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
        this.jdField_a_of_type_Adxz.d.setVisibility(8);
        break label274;
        label450:
        this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.jdField_a_of_type_Adxz.c.setVisibility(8);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131718750));
    this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 12);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new adxx(this, paramView, paramCursor));
    return;
    localObject = apta.b((String)localObject);
    if (localObject == null)
    {
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_Adxz.c.setVisibility(8);
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if ((localObject != null) && (((aqmc)localObject).b.length() > 0))
    {
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetTextView.setText(((aqmc)localObject).b);
      if ((localObject == null) || (((aqmc)localObject).a.length() <= 0)) {
        break label870;
      }
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setText(((aqmc)localObject).a);
      label732:
      if ((localObject == null) || (((aqmc)localObject).f.length() <= 0)) {
        break label910;
      }
      this.jdField_a_of_type_Adxz.c.setVisibility(0);
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((localObject == null) || (((aqmc)localObject).d.length() <= 0)) {
        break label885;
      }
      paramContext = ((aqmc)localObject).d;
      this.jdField_a_of_type_Adxz.c.setText(paramContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new adxy(this, (aqmc)localObject, paramView, paramCursor));
      return;
      this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131718750));
      break;
      label870:
      this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label732;
      label885:
      paramContext = paramContext.getResources().getString(2131718757);
      this.jdField_a_of_type_Adxz.c.setText(paramContext);
    }
    label910:
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    this.jdField_a_of_type_Adxz.c.setVisibility(8);
    this.jdField_a_of_type_Adxz.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Adxz.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    notifyDataSetChanged();
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getLayoutInflater().inflate(2131558896, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxu
 * JD-Core Version:    0.7.0.1
 */