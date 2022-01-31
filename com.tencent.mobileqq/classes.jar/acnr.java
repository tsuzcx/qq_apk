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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class acnr
  extends aims
{
  protected LayoutInflater a;
  public ArrayList<acnq> a;
  
  public acnr(Context paramContext, ArrayList<String> paramArrayList)
  {
    super(paramArrayList, paramContext.app, paramContext.a, 1, true);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramArrayList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    acnq localacnq;
    int i;
    ArrayList localArrayList;
    int j;
    label71:
    Object localObject;
    if (localacnq == null)
    {
      i = 0;
      localArrayList = new ArrayList();
      paramArrayList = new ArrayList();
      j = 0;
      if (j >= i) {
        break label272;
      }
      localObject = (String)localacnq.get(j);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (Pattern.matches("\\d{5,}+\\|+\\d{1,}", (CharSequence)localObject))) {
        break label125;
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      i = localacnq.size();
      break;
      label125:
      int k = ((String)localObject).indexOf('|');
      String str = ((String)localObject).substring(0, k);
      k = Integer.parseInt(((String)localObject).substring(k + 1));
      if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 1))
      {
        localObject = new acnq();
        ((acnq)localObject).jdField_a_of_type_Int = 1;
        ((acnq)localObject).jdField_a_of_type_JavaLangString = str;
        ((acnq)localObject).jdField_b_of_type_Int = k;
        localArrayList.add(localObject);
      }
      else if ((!TextUtils.isEmpty(str)) && ((k & 0x1) == 0))
      {
        localObject = new acnq();
        ((acnq)localObject).jdField_a_of_type_Int = 1;
        ((acnq)localObject).jdField_a_of_type_JavaLangString = str;
        ((acnq)localObject).jdField_b_of_type_Int = k;
        paramArrayList.add(localObject);
      }
    }
    label272:
    if (localArrayList.size() > 0)
    {
      localacnq = new acnq();
      localacnq.jdField_a_of_type_Int = 0;
      localacnq.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, localacnq);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    }
    if (paramArrayList.size() > 0)
    {
      localacnq = new acnq();
      localacnq.jdField_a_of_type_Int = 0;
      localacnq.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localacnq);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    ThreadManager.post(new TroopTransferActivity.TroopMemberListAdapter.1(this, paramContext), 8, null, false);
  }
  
  public acnq a(String paramString)
  {
    Object localObject = null;
    int i = 0;
    if ((localObject == null) && (i < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      acnq localacnq = (acnq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localacnq == null) || (!bbbr.a(localacnq.jdField_a_of_type_JavaLangString, paramString))) {
        break label61;
      }
      localObject = localacnq;
    }
    label61:
    for (;;)
    {
      i += 1;
      break;
      return localObject;
    }
  }
  
  public List<acnq> a()
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
        localObject1 = (acnq)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    acnq localacnq = (acnq)getItem(paramInt);
    if ((localacnq != null) && (localacnq.jdField_a_of_type_Int == 0)) {
      return 0;
    }
    if ((localacnq != null) && (localacnq.jdField_a_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    acnq localacnq = (acnq)getItem(paramInt);
    if (i == 0) {
      if (paramView == null)
      {
        paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559194, paramViewGroup, false);
        paramView = new acns(null);
        paramView.c = null;
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup);
        paramViewGroup.setTag(paramView);
        paramView.jdField_a_of_type_Acnq = localacnq;
        if ((localacnq == null) || (localacnq.jdField_b_of_type_Int != 1)) {
          break label135;
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131694078);
      }
    }
    label256:
    for (;;)
    {
      if ((paramView != null) && (paramView.jdField_a_of_type_AndroidWidgetTextView != null)) {
        paramViewGroup.setContentDescription(paramView.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      return paramViewGroup;
      Object localObject = (acns)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      break;
      label135:
      if ((localacnq != null) && (localacnq.jdField_b_of_type_Int == 0))
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(2131720451);
      }
      else
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText("");
        continue;
        if (i == 1)
        {
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562553, paramViewGroup, false);
            paramView.findViewById(2131378049).setVisibility(8);
            paramView.findViewById(2131363571).setVisibility(8);
            paramViewGroup = new acns(null);
            paramViewGroup.c = ((ImageView)paramView.findViewById(2131368583));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378265));
            paramView.setTag(paramViewGroup);
            paramViewGroup.jdField_a_of_type_Acnq = localacnq;
            if (localacnq == null) {
              break label345;
            }
            localObject = localacnq.jdField_a_of_type_JavaLangString;
            label274:
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("0"))) {
              break label351;
            }
            paramViewGroup.c.setImageDrawable(bbef.b());
            label302:
            if (localacnq == null) {
              break label377;
            }
          }
          label345:
          label351:
          label377:
          for (localObject = localacnq.jdField_b_of_type_JavaLangString;; localObject = "")
          {
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            localObject = paramView;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject;
            break;
            paramViewGroup = (acns)paramView.getTag();
            break label256;
            localObject = null;
            break label274;
            paramViewGroup.jdField_a_of_type_JavaLangString = ((String)localObject);
            paramViewGroup.c.setImageBitmap(a(1, localacnq.jdField_a_of_type_JavaLangString));
            break label302;
          }
        }
        localObject = null;
        paramViewGroup = paramView;
        paramView = (View)localObject;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acnr
 * JD-Core Version:    0.7.0.1
 */