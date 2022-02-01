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

public class aeru
  extends aliy
{
  protected LayoutInflater a;
  public ArrayList<aert> a;
  
  public aeru(Context paramContext, ArrayList<String> paramArrayList)
  {
    super(paramArrayList, paramContext.app, paramContext.a, 1, true);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    aert localaert;
    int i;
    ArrayList localArrayList;
    int j;
    label71:
    Object localObject;
    if (localaert == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label272;
      }
      localObject = (String)localaert.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject))) {
        break label125;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = localaert.size();
      break;
      label125:
      int k = ((String)localObject).indexOf('|');
      String str = ((String)localObject).substring(0, k);
      k = Integer.parseInt(((String)localObject).substring(k + 1));
      if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
      {
        localObject = new aert();
        ((aert)localObject).jdField_a_of_type_Int = 1;
        ((aert)localObject).jdField_a_of_type_JavaLangString = str;
        ((aert)localObject).jdField_b_of_type_Int = k;
        localArrayList.add(localObject);
      }
      else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
      {
        localObject = new aert();
        ((aert)localObject).jdField_a_of_type_Int = 1;
        ((aert)localObject).jdField_a_of_type_JavaLangString = str;
        ((aert)localObject).jdField_b_of_type_Int = k;
        paramArrayList.add(localObject);
      }
    }
    label272:
    if (localArrayList.size() > 0)
    {
      localaert = new aert();
      localaert.jdField_a_of_type_Int = 0;
      localaert.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, localaert);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramArrayList.size() > 0)
    {
      localaert = new aert();
      localaert.jdField_a_of_type_Int = 0;
      localaert.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localaert);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, paramContext), 8, null, false);
  }
  
  public aert a(String paramString)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      aert localaert = (aert)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localaert == null) || (!bftf.a(localaert.jdField_a_of_type_JavaLangString, paramString))) {
        break label61;
      }
      localObject = localaert;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public List<aert> a()
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
        localObject1 = (aert)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    aert localaert = (aert)getItem(paramInt);
    if ((localaert != null) && (localaert.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localaert != null) && (localaert.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    aert localaert = (aert)getItem(paramInt);
    Object localObject1;
    if (i == 0) {
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559319, paramViewGroup, false);
        paramView = new aerv(null);
        paramView.c = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        ((View)localObject1).setTag(paramView);
        paramView.jdField_a_of_type_Aert = localaert;
        if ((localaert == null) || (localaert.jdField_b_of_type_Int != 1)) {
          break label156;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131693571);
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
      Object localObject2 = (aerv)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label156:
      if ((localaert != null) && (localaert.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131719125);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562927, paramViewGroup, false);
            paramView.findViewById(2131379457).setVisibility(8);
            paramView.findViewById(2131363868).setVisibility(8);
            localObject1 = new aerv(null);
            ((aerv)localObject1).c = ((ImageView)paramView.findViewById(2131369251));
            ((aerv)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379724));
            paramView.setTag(localObject1);
            ((aerv)localObject1).jdField_a_of_type_Aert = localaert;
            if (localaert == null) {
              break label376;
            }
            localObject2 = localaert.jdField_a_of_type_JavaLangString;
            label300:
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("0"))) {
              break label382;
            }
            ((aerv)localObject1).c.setImageDrawable(bfvo.b());
            label329:
            if (localaert == null) {
              break label410;
            }
          }
          for (localObject2 = localaert.jdField_b_of_type_JavaLangString;; localObject2 = "")
          {
            ((aerv)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
            break;
            localObject1 = (aerv)paramView.getTag();
            break label281;
            label376:
            localObject2 = null;
            break label300;
            label382:
            ((aerv)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((aerv)localObject1).c.setImageBitmap(a(1, localaert.jdField_a_of_type_JavaLangString));
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
 * Qualified Name:     aeru
 * JD-Core Version:    0.7.0.1
 */