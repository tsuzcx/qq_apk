import Wallet.AcsMsg;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afnh
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  TextView c;
  
  public afnh(ReminderListFragment paramReminderListFragment, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376512));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376511));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.c = ((TextView)paramView.findViewById(2131376516));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376513));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370207));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370206));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376514));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131376515));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
  }
  
  private void a(View paramView, AcsMsg paramAcsMsg)
  {
    if ((paramView instanceof FrameLayout))
    {
      paramView = ((FrameLayout)paramView).getChildAt(0);
      if ((paramView instanceof Button))
      {
        paramView = (Button)paramView;
        paramView.setTag(paramAcsMsg);
        paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
        paramAcsMsg = new Rect();
        this.jdField_a_of_type_AndroidWidgetImageView.getLocalVisibleRect(paramAcsMsg);
        paramView.rightMargin = paramAcsMsg.right;
        this.jdField_a_of_type_AndroidWidgetImageView.getGlobalVisibleRect(paramAcsMsg);
        paramView.topMargin = (paramAcsMsg.top - paramView.width);
      }
    }
  }
  
  public void a(afny paramafny)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTag(paramafny.jdField_a_of_type_WalletAcsMsg);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramafny.jdField_a_of_type_WalletAcsMsg.title);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setTag(paramafny.jdField_a_of_type_WalletAcsMsg.jump_url);
    Object localObject1 = paramafny.jdField_a_of_type_WalletAcsMsg.busi_icon;
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_b_of_type_AndroidWidgetImageView.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_b_of_type_AndroidWidgetImageView.getWidth();
    localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
    if (localObject1 != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    }
    String str = afmj.a(paramafny.jdField_a_of_type_WalletAcsMsg.notice_time * 1000L, "yyyy.MM.dd");
    localObject2 = afmj.a(paramafny.jdField_a_of_type_WalletAcsMsg.notice_time * 1000L, "HH:mm");
    localObject1 = localObject2;
    if (paramafny.jdField_a_of_type_Int == 0) {
      localObject1 = (String)localObject2 + "　　　开启时提醒";
    }
    localObject1 = str + "　　　" + (String)localObject1;
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = this.c;
    if (!StringUtil.isEmpty(paramafny.jdField_a_of_type_JavaLangString))
    {
      ((TextView)localObject1).setText(paramafny.jdField_a_of_type_JavaLangString);
      ((TextView)localObject1).setVisibility(0);
      return;
    }
    ((TextView)localObject1).setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!StringUtil.isEmpty((String)paramView.getTag()))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment.getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)paramView.getTag());
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment.startActivity(localIntent);
        continue;
        if (ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment) != null)
        {
          a(ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).getContentView(), (AcsMsg)this.jdField_a_of_type_AndroidWidgetFrameLayout.getTag());
          ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment).showAtLocation(ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment), 17, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afnh
 * JD-Core Version:    0.7.0.1
 */