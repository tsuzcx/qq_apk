import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberListAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class afza
  extends amoe
{
  protected LayoutInflater a;
  public ArrayList<afyz> a;
  
  public afza(Context paramContext, ArrayList<String> paramArrayList)
  {
    super(paramArrayList, paramContext.app, paramContext.a, 1, true);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    afyz localafyz;
    int i;
    ArrayList localArrayList;
    int j;
    label71:
    Object localObject;
    if (localafyz == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label272;
      }
      localObject = (String)localafyz.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject))) {
        break label125;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = localafyz.size();
      break;
      label125:
      int k = ((String)localObject).indexOf('|');
      String str = ((String)localObject).substring(0, k);
      k = Integer.parseInt(((String)localObject).substring(k + 1));
      if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
      {
        localObject = new afyz();
        ((afyz)localObject).jdField_a_of_type_Int = 1;
        ((afyz)localObject).jdField_a_of_type_JavaLangString = str;
        ((afyz)localObject).jdField_b_of_type_Int = k;
        localArrayList.add(localObject);
      }
      else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
      {
        localObject = new afyz();
        ((afyz)localObject).jdField_a_of_type_Int = 1;
        ((afyz)localObject).jdField_a_of_type_JavaLangString = str;
        ((afyz)localObject).jdField_b_of_type_Int = k;
        paramArrayList.add(localObject);
      }
    }
    label272:
    if (localArrayList.size() > 0)
    {
      localafyz = new afyz();
      localafyz.jdField_a_of_type_Int = 0;
      localafyz.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, localafyz);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramArrayList.size() > 0)
    {
      localafyz = new afyz();
      localafyz.jdField_a_of_type_Int = 0;
      localafyz.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localafyz);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, paramContext), 8, null, false);
  }
  
  public afyz a(String paramString)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      afyz localafyz = (afyz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localafyz == null) || (!bhjx.a(localafyz.jdField_a_of_type_JavaLangString, paramString))) {
        break label61;
      }
      localObject = localafyz;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public List<afyz> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        localObject1 = (afyz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    afyz localafyz = (afyz)getItem(paramInt);
    if ((localafyz != null) && (localafyz.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localafyz != null) && (localafyz.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    afyz localafyz = (afyz)getItem(paramInt);
    Object localObject1;
    if (i == 0) {
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559317, paramViewGroup, false);
        paramView = new afzb(null);
        paramView.c = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        ((View)localObject1).setTag(paramView);
        paramView.jdField_a_of_type_Afyz = localafyz;
        if ((localafyz == null) || (localafyz.jdField_b_of_type_Int != 1)) {
          break label156;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131693476);
      }
    }
    label281:
    label410:
    for (;;)
    {
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
        ((View)localObject1).setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      Object localObject2 = (afzb)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label156:
      if ((localafyz != null) && (localafyz.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131718866);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131563046, paramViewGroup, false);
            paramView.findViewById(2131379676).setVisibility(8);
            paramView.findViewById(2131363842).setVisibility(8);
            localObject1 = new afzb(null);
            ((afzb)localObject1).c = ((ImageView)paramView.findViewById(2131369234));
            ((afzb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379958));
            paramView.setTag(localObject1);
            ((afzb)localObject1).jdField_a_of_type_Afyz = localafyz;
            if (localafyz == null) {
              break label376;
            }
            localObject2 = localafyz.jdField_a_of_type_JavaLangString;
            label300:
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("0"))) {
              break label382;
            }
            ((afzb)localObject1).c.setImageDrawable(bhmq.b());
            label329:
            if (localafyz == null) {
              break label410;
            }
          }
          for (localObject2 = localafyz.jdField_b_of_type_JavaLangString;; localObject2 = "")
          {
            ((afzb)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
            break;
            localObject1 = (afzb)paramView.getTag();
            break label281;
            label376:
            localObject2 = null;
            break label300;
            label382:
            ((afzb)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((afzb)localObject1).c.setImageBitmap(a(1, localafyz.jdField_a_of_type_JavaLangString));
            break label329;
          }
        }
        localObject2 = null;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afza
 * JD-Core Version:    0.7.0.1
 */