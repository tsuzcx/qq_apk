import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.phone.PhoneContactFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aiqi
  extends aliy
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private PhoneContactFragment jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ainj> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public aiqi(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, PhoneContactFragment paramPhoneContactFragment)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment = paramPhoneContactFragment;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return true;
    }
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
      if ((i == 9) || (i == 8) || (i == 4) || (i == 2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.m()) {
          break label85;
        }
        if (QLog.isColorLevel()) {
          QLog.d("contacts.PhoneContactAdapter", 2, "load data: no permission");
        }
      }
    }
    label85:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_JavaUtilList.clear();
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(new int[] { 7, 2, 3, 4 });
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "load data:" + ((List)localObject2).size());
      }
      localObject1 = new ArrayList(((List)localObject2).size());
      Object localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)((Iterator)localObject2).next();
        if (!localPhoneContact.isHiden) {
          ((List)localObject1).add(aini.a(1, localPhoneContact, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.size() != 0));
    Object localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (QLog.isColorLevel()) {
      QLog.d("contacts.PhoneContactAdapter", 2, "needDoubleCheck onAppRunForeground");
    }
    if (localObject1 != null) {
      ((PhoneContactManagerImp)localObject1).a(true, 1);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.PhoneContactAdapter", 2, "checkResetApp, need change app!");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment = null;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (a()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsPhonePhoneContactFragment.a())) {
      return 1;
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558956, null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839437);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131369232).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131369334).setVisibility(8);
        localObject1 = (SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367758);
        ((SingleLineTextView)localObject1).setText(amtj.a(2131707106));
        localObject2 = (ViewGroup.MarginLayoutParams)((SingleLineTextView)localObject1).getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin /= 2;
        ((SingleLineTextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((SimpleTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365010)).setText("0");
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = ((ainj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, this);
      if (localObject1 != null)
      {
        localObject2 = (ainm)((View)localObject1).getTag();
        if (((ainm)localObject2).d != null) {
          ((ainm)localObject2).d.setBackgroundDrawable(new BitmapDrawable(a(((ainm)localObject2).b, ((ainm)localObject2).jdField_a_of_type_JavaLangString)));
        }
        ((View)localObject1).setOnClickListener(this);
        if ((localObject2 instanceof aiqh)) {
          ((aiqh)localObject2).a.setOnClickListener(this);
        }
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    int i = 17;
    Object localObject;
    if ((paramView != null) && (paramView.getId() == 2131376341) && ((paramView.getTag() instanceof PhoneContact)))
    {
      localObject = (PhoneContact)paramView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.i()) {
        break label368;
      }
    }
    for (;;)
    {
      ((PhoneContact)localObject).isNewRecommend = false;
      localObject = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject).unifiedCode, null, 3006, i, ((PhoneContact)localObject).name, null, null, amtj.a(2131707101), null);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "contact", "", "addbook", "add_friend", 0, 0, "", "", "", "");
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        } while ((paramView == null) || (!(paramView.getTag() instanceof ainm)));
        localObject = (ainm)paramView.getTag();
      } while (!(((ainm)localObject).jdField_a_of_type_JavaLangObject instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)((ainm)localObject).jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "onItemClick:" + localPhoneContact.name + localPhoneContact.mobileCode + "--[" + localPhoneContact.detalStatusFlag + "] [" + localPhoneContact.iTermType + "]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.i()) {
        localObject = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 34);
      }
      for (;;)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 59;
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = localPhoneContact.name;
        ((ProfileActivity.AllInOne)localObject).j = 2;
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
        break;
        localObject = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 29);
        ((ProfileActivity.AllInOne)localObject).l = 17;
      }
      label368:
      i = 15;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqi
 * JD-Core Version:    0.7.0.1
 */