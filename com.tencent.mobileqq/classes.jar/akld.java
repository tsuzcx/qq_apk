import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akld
  extends akis
{
  aklg jdField_a_of_type_Aklg;
  ameq jdField_a_of_type_Ameq = new akle(this);
  Context jdField_a_of_type_AndroidContentContext;
  protected View.OnClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected String a;
  protected List<aklh> a;
  protected boolean a;
  protected List<awge> b;
  protected boolean b;
  List<ShowExternalTroop> c;
  
  public akld(Context paramContext, QQAppInterface paramQQAppInterface, aklg paramaklg, XListView paramXListView, boolean paramBoolean, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aklf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aklg = paramaklg;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ameq);
  }
  
  public void a(List<ShowExternalTroop> paramList)
  {
    this.jdField_b_of_type_Boolean = true;
    if (paramList != null)
    {
      this.c = paramList;
      notifyDataSetChanged();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ameq);
    super.c();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560432, null);
    }
    aklh localaklh = (aklh)getItem(paramInt);
    if (localaklh == null) {
      return null;
    }
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = nau.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, 5, false, 1);
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    paramView = (bbph)localView.getTag();
    paramView.jdField_c_of_type_Int = 4;
    paramViewGroup = localaklh.a;
    nau.a(localView, this.jdField_a_of_type_AndroidContentContext, paramViewGroup);
    paramView.e.setVisibility(8);
    paramView.jdField_a_of_type_JavaLangString = localaklh.a.troopUin;
    paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.troopUin));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.c != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (!this.c.isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          ShowExternalTroop localShowExternalTroop = (ShowExternalTroop)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(new aklh(1, localShowExternalTroop));
        }
      }
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akld
 * JD-Core Version:    0.7.0.1
 */