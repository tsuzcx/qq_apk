import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.SimpleTextView;
import com.tencent.mobileqq.activity.contacts.fragment.PhoneContactFragment;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahrz
  extends akis
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private PhoneContactFragment jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment;
  private PhoneContactManagerImp jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<akmm> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public ahrz(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean, PhoneContactFragment paramPhoneContactFragment)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment = paramPhoneContactFragment;
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
      int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      if ((i == 9) || (i == 8) || (i == 4) || (i == 2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.k()) {
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
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(new int[] { 7, 2, 3, 4 });
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
          ((List)localObject1).add(akmh.a(1, localPhoneContact, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject1);
    } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.size() != 0));
    Object localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    if (QLog.isColorLevel()) {
      QLog.d("contacts.PhoneContactAdapter", 2, "needDoubleCheck onAppRunForeground");
    }
    if (localObject1 != null) {
      ((PhoneContactManagerImp)localObject1).a(true);
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
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11));
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment = null;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (a()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPhoneContactFragment.a())) {
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
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558878, null);
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839217);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131368775).setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.findViewById(2131368868).setVisibility(8);
        paramView = (SingleLineTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367351);
        paramView.setText(alud.a(2131708388));
        paramViewGroup = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
        paramViewGroup.leftMargin /= 2;
        paramView.setLayoutParams(paramViewGroup);
        ((SimpleTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364710)).setText("0");
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    paramView = ((akmm)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, this);
    if (paramView != null)
    {
      paramViewGroup = (akmp)paramView.getTag();
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView != null) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(a(paramViewGroup.jdField_a_of_type_Int, paramViewGroup.jdField_a_of_type_JavaLangString)));
      }
      paramView.setOnClickListener(this);
      if ((paramViewGroup instanceof akmr)) {
        ((akmr)paramViewGroup).a.setOnClickListener(this);
      }
    }
    return paramView;
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
    if ((paramView != null) && (paramView.getId() == 2131375716) && ((paramView.getTag() instanceof PhoneContact)))
    {
      paramView = (PhoneContact)paramView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()) {
        break label351;
      }
    }
    for (;;)
    {
      paramView.isNewRecommend = false;
      paramView = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, paramView.unifiedCode, null, 3006, i, paramView.name, null, null, alud.a(2131708383), null);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "contact", "", "addbook", "add_friend", 0, 0, "", "", "", "");
      do
      {
        do
        {
          return;
        } while ((paramView == null) || (!(paramView.getTag() instanceof akmp)));
        paramView = (akmp)paramView.getTag();
      } while (!(paramView.jdField_a_of_type_JavaLangObject instanceof PhoneContact));
      PhoneContact localPhoneContact = (PhoneContact)paramView.jdField_a_of_type_JavaLangObject;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.PhoneContactAdapter", 2, "onItemClick:" + localPhoneContact.name + localPhoneContact.mobileCode + "--[" + localPhoneContact.detalStatusFlag + "] [" + localPhoneContact.iTermType + "]");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()) {
        paramView = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 34);
      }
      for (;;)
      {
        paramView.jdField_h_of_type_Int = 59;
        paramView.jdField_h_of_type_JavaLangString = localPhoneContact.name;
        paramView.j = 2;
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, paramView);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
        return;
        paramView = new ProfileActivity.AllInOne(localPhoneContact.unifiedCode, 29);
        paramView.l = 17;
      }
      label351:
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
 * Qualified Name:     ahrz
 * JD-Core Version:    0.7.0.1
 */