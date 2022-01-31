import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.ArrayList;

public class aalv
  extends BaseAdapter
  implements azwh
{
  private Context jdField_a_of_type_AndroidContentContext;
  private final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  
  public aalv(ContactBindedActivity paramContactBindedActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844056);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public PhoneContact a(int paramInt)
  {
    return (PhoneContact)ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).get(paramInt);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity) != null) && (ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size() > 0))
      {
        PhoneContact localPhoneContact = (PhoneContact)ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).get(ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size() - 1);
        ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity, localPhoneContact, false);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Bitmap localBitmap = null;
    PhoneContact localPhoneContact = a(paramInt);
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity.getLayoutInflater().inflate(2131493590, null);
    }
    paramViewGroup.setTag(localPhoneContact);
    ImageView localImageView = (ImageView)paramViewGroup.findViewById(2131300226);
    paramView = localBitmap;
    if (paramInt == getCount() - 1)
    {
      paramView = localBitmap;
      if (this.jdField_a_of_type_Boolean) {
        paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
    localImageView.setImageDrawable(paramView);
    localBitmap = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).a(11, localPhoneContact.unifiedCode);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).a(localPhoneContact.unifiedCode, 11, true, (byte)0);
      paramView = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity);
    }
    localImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramView));
    if (AppSetting.c) {
      localImageView.setContentDescription(localPhoneContact.name);
    }
    return paramViewGroup;
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = false;
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity) == null) {}
    for (;;)
    {
      return;
      paramInt1 = 0;
      while (paramInt1 < ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).getChildCount())
      {
        View localView = ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactBindedActivity).getChildAt(paramInt1);
        Object localObject = localView.getTag();
        if ((localObject != null) && ((localObject instanceof PhoneContact)) && (paramString.equals(((PhoneContact)localObject).unifiedCode))) {
          ((ImageView)localView.findViewById(2131300226)).setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aalv
 * JD-Core Version:    0.7.0.1
 */