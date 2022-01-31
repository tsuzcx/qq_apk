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

public class abjx
  extends CursorAdapter
{
  abkc jdField_a_of_type_Abkc;
  
  public abjx(QQBroadcastActivity paramQQBroadcastActivity, Context paramContext, Cursor paramCursor)
  {
    super(paramContext, paramCursor);
    paramQQBroadcastActivity.a(paramCursor);
  }
  
  protected void a(String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = aciy.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity, SplashActivity.class), null);
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
    this.jdField_a_of_type_Abkc = ((abkc)paramView.getTag());
    if (this.jdField_a_of_type_Abkc == null)
    {
      this.jdField_a_of_type_Abkc = new abkc(null);
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312207));
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131310969));
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312185));
      this.jdField_a_of_type_Abkc.c = ((TextView)paramView.findViewById(2131312210));
      this.jdField_a_of_type_Abkc.d = ((TextView)paramView.findViewById(2131312206));
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131305070));
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131297870);
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131297787));
      paramView.setTag(this.jdField_a_of_type_Abkc);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.a(l2) != -1L)
    {
      this.jdField_a_of_type_Abkc.d.setVisibility(0);
      this.jdField_a_of_type_Abkc.d.setText(BaseSystemActivity.a(1000L * l1, false));
      label274:
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(new abjy(this, l2));
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getSharedPreferences(String.valueOf(ajed.J), 0);
      paramCursor = "QQBROADCAST_MSG_UIN" + l2 + l1;
      if (!paramView.contains(paramCursor)) {
        break label450;
      }
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
        this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
        this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        return;
        this.jdField_a_of_type_Abkc.d.setVisibility(8);
        break label274;
        label450:
        this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    this.jdField_a_of_type_Abkc.c.setVisibility(8);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131654084));
    this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, 0, 0, 12);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new abka(this, paramView, paramCursor));
    return;
    localObject = alyy.b((String)localObject);
    if (localObject == null)
    {
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
      this.jdField_a_of_type_Abkc.c.setVisibility(8);
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if ((localObject != null) && (((amnn)localObject).b.length() > 0))
    {
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetTextView.setText(((amnn)localObject).b);
      if ((localObject == null) || (((amnn)localObject).a.length() <= 0)) {
        break label870;
      }
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setText(((amnn)localObject).a);
      label732:
      if ((localObject == null) || (((amnn)localObject).f.length() <= 0)) {
        break label910;
      }
      this.jdField_a_of_type_Abkc.c.setVisibility(0);
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((localObject == null) || (((amnn)localObject).d.length() <= 0)) {
        break label885;
      }
      paramContext = ((amnn)localObject).d;
      this.jdField_a_of_type_Abkc.c.setText(paramContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new abkb(this, (amnn)localObject, paramView, paramCursor));
      return;
      this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetTextView.setText(paramContext.getResources().getString(2131654084));
      break;
      label870:
      this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      break label732;
      label885:
      paramContext = paramContext.getResources().getString(2131654093);
      this.jdField_a_of_type_Abkc.c.setText(paramContext);
    }
    label910:
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    this.jdField_a_of_type_Abkc.c.setVisibility(8);
    this.jdField_a_of_type_Abkc.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Abkc.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void changeCursor(Cursor paramCursor)
  {
    super.changeCursor(paramCursor);
    notifyDataSetChanged();
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getLayoutInflater().inflate(2131493227, paramViewGroup, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abjx
 * JD-Core Version:    0.7.0.1
 */