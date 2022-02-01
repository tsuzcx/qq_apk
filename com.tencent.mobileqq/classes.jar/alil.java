import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class alil
  extends alif
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  public alip a;
  private amsw jdField_a_of_type_Amsw;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PhoneContact jdField_a_of_type_ComTencentMobileqqDataPhoneContact = null;
  public IndexView a;
  private LinkedHashMap<String, List<PhoneContact>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List<PhoneContact> a;
  boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 0;
  private List<PhoneContact> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<PhoneContact> c = new ArrayList();
  
  public alil(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, List<PhoneContact> paramList)
  {
    super(paramContext, paramQQAppInterface, paramXListView, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131298141);
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelOffset(2131298142);
    a(paramList);
  }
  
  public static alio a(List<PhoneContact> paramList, ArrayList<PhoneContact> paramArrayList, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    alio localalio = new alio();
    localalio.jdField_a_of_type_JavaUtilList = ((List)localObject);
    label52:
    label53:
    PhoneContact localPhoneContact;
    if (paramArrayList != null)
    {
      paramList = (List)paramArrayList.clone();
      Iterator localIterator = ((List)localObject).iterator();
      break label193;
      if (!localIterator.hasNext()) {
        break label307;
      }
      localPhoneContact = (PhoneContact)localIterator.next();
      if (!TextUtils.isEmpty(localPhoneContact.pinyinFirst)) {
        break label285;
      }
      paramArrayList = "#";
      label89:
      i = paramArrayList.charAt(0);
      if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
        break label301;
      }
    }
    label285:
    label301:
    for (paramArrayList = paramArrayList.toUpperCase();; paramArrayList = "#")
    {
      if (localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList) == null) {
        localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramArrayList, new ArrayList());
      }
      ((List)localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList)).add(localPhoneContact);
      if ((paramList == null) || (!paramBoolean)) {
        break label53;
      }
      paramArrayList = paramList.iterator();
      label193:
      if (!paramArrayList.hasNext()) {
        break label53;
      }
      if (!TextUtils.equals(((PhoneContact)paramArrayList.next()).unifiedCode, localPhoneContact.unifiedCode)) {
        break label52;
      }
      if (localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
        localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
      }
      ((List)localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).add(localPhoneContact);
      break label53;
      paramList = null;
      break;
      paramArrayList = String.valueOf(localPhoneContact.pinyinFirst.charAt(0));
      break label89;
    }
    label307:
    if (paramList != null)
    {
      localalio.jdField_b_of_type_JavaUtilList = paramList;
      if (!paramBoolean)
      {
        if (localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get("★") == null) {
          localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", new ArrayList());
        }
        ((List)localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get("★")).addAll(paramList);
      }
    }
    paramArrayList = localalio.jdField_a_of_type_JavaUtilLinkedHashMap;
    localalio.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (paramArrayList.get(String.valueOf(c1)) != null) {
        localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c1), paramArrayList.get(String.valueOf(c1)));
      }
    }
    if (paramArrayList.get("#") != null) {
      localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", paramArrayList.get("#"));
    }
    if ((paramList != null) && ((((List)localObject).size() > 10) || (!paramBoolean)) && (paramArrayList.get("★") != null)) {
      localalio.jdField_a_of_type_JavaUtilLinkedHashMap.put("★", paramList);
    }
    paramArrayList.clear();
    localalio.jdField_a_of_type_ArrayOfInt = new int[localalio.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
    localalio.jdField_a_of_type_ArrayOfJavaLangString = new String[localalio.jdField_a_of_type_ArrayOfInt.length];
    paramList = new ArrayList(localalio.jdField_a_of_type_JavaUtilLinkedHashMap.keySet());
    Collections.sort(paramList, new alim());
    paramArrayList = paramList.iterator();
    if (localalio.jdField_a_of_type_ArrayOfInt.length == 0) {
      return localalio;
    }
    localalio.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < localalio.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject = localalio.jdField_a_of_type_ArrayOfInt;
      int j = localObject[i];
      int k = localalio.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject[i] = (((List)localalio.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramArrayList.next())).size() + k + 1 + j);
      i += 1;
    }
    paramList = paramList.iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localalio.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)paramList.next());
      i += 1;
    }
    return localalio;
  }
  
  private boolean a(PhoneContact paramPhoneContact)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
        if (TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
      return 2131559319;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void a(alio paramalio)
  {
    this.jdField_b_of_type_JavaUtilList = paramalio.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramalio.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_JavaUtilLinkedHashMap = paramalio.jdField_a_of_type_JavaUtilLinkedHashMap;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramalio.jdField_a_of_type_ArrayOfJavaLangString;
    this.c = paramalio.jdField_b_of_type_JavaUtilList;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt < this.jdField_a_of_type_ArrayOfJavaLangString.length) && (paramInt >= 0)) {
      ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
    }
  }
  
  public void a(PhoneContact paramPhoneContact, boolean paramBoolean)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PhoneContact localPhoneContact = (PhoneContact)this.jdField_a_of_type_JavaUtilList.get(i);
      if (!TextUtils.equals(paramPhoneContact.unifiedCode, localPhoneContact.unifiedCode)) {}
    }
    for (;;)
    {
      if (paramBoolean) {
        if (i == -1)
        {
          this.jdField_a_of_type_JavaUtilList.add(paramPhoneContact);
          notifyDataSetChanged();
        }
      }
      while (i == -1)
      {
        return;
        i += 1;
        break;
      }
      this.jdField_a_of_type_JavaUtilList.remove(i);
      notifyDataSetChanged();
      return;
      i = -1;
    }
  }
  
  public void a(List<PhoneContact> paramList)
  {
    a(a(paramList, null, true));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      localObject2 = new alin();
      Object localObject3 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561014, null);
      ((alin)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131371791));
      ((alin)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject3).findViewById(2131361795));
      ((alin)localObject2).b = ((TextView)((View)localObject3).findViewById(2131376354));
      ((alin)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject3).findViewById(2131377631));
      ((alin)localObject2).jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject3).findViewById(2131376341));
      ((alin)localObject2).d = ((TextView)((View)localObject3).findViewById(2131376351));
      ((alin)localObject2).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject3).findViewById(2131364526));
      ((alin)localObject2).e = ((TextView)((View)localObject3).findViewById(2131379673));
      ((alin)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject3).findViewById(2131374108);
      ((View)localObject3).setBackgroundDrawable(null);
      ((View)localObject3).setTag(localObject2);
      paramView = (View)localObject2;
      localObject1 = localObject3;
      if ((((alin)localObject2).jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView))
      {
        ((ThemeImageView)((alin)localObject2).jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(false);
        localObject1 = localObject3;
        paramView = (View)localObject2;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.getVisibility() != 0)) {
        break label779;
      }
      ((View)localObject1).findViewById(2131376347).setPadding(0, 0, this.jdField_a_of_type_Int, 0);
      label265:
      if (i >= 0) {
        break label1072;
      }
      i = -(i + 1) - 1;
      localObject2 = (PhoneContact)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      paramView.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject2);
      if ((this.c.isEmpty()) || ("★".equals(this.jdField_a_of_type_ArrayOfJavaLangString[i])) || (!((PhoneContact)localObject2).isNewRecommend)) {
        break label800;
      }
      aiea.a((View)localObject1, true);
      aiea.b(paramView.jdField_a_of_type_AndroidViewView, true);
      label372:
      localObject3 = new StringBuilder(256);
      if (TextUtils.isEmpty(((PhoneContact)localObject2).name)) {
        break label817;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((PhoneContact)localObject2).name);
      if (AppSetting.c)
      {
        bfpm.a(paramView.jdField_a_of_type_AndroidWidgetTextView, false);
        ((StringBuilder)localObject3).append(((PhoneContact)localObject2).name);
      }
      label440:
      paramView.b.setVisibility(8);
      if (((PhoneContact)localObject2).samFriend <= 0) {
        break label829;
      }
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      Object localObject4 = String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690981), new Object[] { Integer.valueOf(((PhoneContact)localObject2).samFriend) });
      paramView.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject4);
      paramView.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      if (AppSetting.c) {
        ((StringBuilder)localObject3).append(",").append((String)localObject4);
      }
      label538:
      if ((TextUtils.isEmpty(((PhoneContact)localObject2).uin)) || (((PhoneContact)localObject2).uin.equals("0"))) {
        break label841;
      }
      paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramView.d.setVisibility(0);
      paramView.d.setText(amtj.a(2131701606));
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.jdField_a_of_type_AndroidViewView.setEnabled(false);
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      }
      if (AppSetting.c) {
        paramView.d.setContentDescription(amtj.a(2131701601));
      }
      label643:
      localObject4 = paramView.jdField_a_of_type_AndroidWidgetCheckBox;
      if (!this.jdField_a_of_type_Boolean) {
        break label1065;
      }
      i = 0;
      label659:
      ((CheckBox)localObject4).setVisibility(i);
      if (AppSetting.c) {
        ((View)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
      }
      paramView.e.setVisibility(8);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramView.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject2).unifiedCode;
      paramView.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(((PhoneContact)localObject2).unifiedCode, 11, (byte)0));
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidViewView.setTag(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject2 = (alin)paramView.getTag();
      localObject1 = paramView;
      paramView = (View)localObject2;
      break;
      label779:
      ((View)localObject1).findViewById(2131376347).setPadding(0, 0, this.jdField_b_of_type_Int, 0);
      break label265;
      label800:
      aiea.a((View)localObject1, false);
      aiea.b(paramView.jdField_a_of_type_AndroidViewView, false);
      break label372;
      label817:
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label440;
      label829:
      paramView.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label538;
      label841:
      if (this.jdField_a_of_type_Amsw.a(((PhoneContact)localObject2).unifiedCode, true))
      {
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView.d.setVisibility(0);
        paramView.d.setText(amtj.a(2131701604));
        if (this.jdField_a_of_type_Boolean)
        {
          paramView.jdField_a_of_type_AndroidViewView.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
          paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        }
        if (!AppSetting.c) {
          break label643;
        }
        paramView.d.setContentDescription(amtj.a(2131701610));
        break label643;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(a((PhoneContact)localObject2));
        paramView.jdField_a_of_type_AndroidWidgetCheckBox.setTag(paramView);
      }
      for (;;)
      {
        paramView.jdField_a_of_type_AndroidViewView.setEnabled(true);
        paramView.d.setVisibility(8);
        break;
        paramView.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131689550));
        paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject2);
        paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
        if (AppSetting.c) {
          paramView.jdField_a_of_type_AndroidWidgetButton.setContentDescription(amtj.a(2131689550));
        }
      }
      label1065:
      i = 8;
      break label659;
      label1072:
      paramView.jdField_a_of_type_AndroidViewView.setTag(null);
      paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramView.e.setVisibility(0);
      paramView.e.setText(String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]));
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {}
    boolean bool1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity)) {
        ((ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext).d();
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131374108: 
        if (!this.jdField_a_of_type_Boolean) {
          break label744;
        }
        localObject1 = (alin)localObject1;
        boolean bool2 = a(((alin)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact);
        localObject2 = ((alin)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        if (bool2) {
          break label732;
        }
        bool1 = true;
        label111:
        a((PhoneContact)localObject2, bool1);
        if (this.jdField_a_of_type_Alip != null)
        {
          localObject2 = this.jdField_a_of_type_Alip;
          localObject1 = ((alin)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
          if (bool2) {
            break label738;
          }
          bool1 = true;
          label147:
          ((alip)localObject2).a((PhoneContact)localObject1, bool1);
        }
        break;
      }
    }
    Object localObject2 = (PhoneContact)localObject1;
    localObject1 = (avsy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
    int j;
    if (((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent().getBooleanExtra("from_babyq", false)) {
      j = 1;
    }
    for (int i = 3084;; i = 3006)
    {
      label268:
      label311:
      ContactBindedActivity localContactBindedActivity;
      if (!((avsy)localObject1).i()) {
        if (this.c.contains(localObject2))
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 1, 0, "", "", "", "");
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
          j = 16;
          i = 3006;
          ((PhoneContact)localObject2).isNewRecommend = false;
          if ((this.jdField_a_of_type_AndroidContentContext instanceof ContactBindedActivity))
          {
            localContactBindedActivity = (ContactBindedActivity)this.jdField_a_of_type_AndroidContentContext;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).pinyinFirst)) {
              break label712;
            }
          }
        }
      }
      label712:
      for (localObject1 = "#";; localObject1 = String.valueOf(((PhoneContact)localObject2).pinyinFirst.charAt(0)).toUpperCase())
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localContactBindedActivity.jdField_a_of_type_Int = ((List)localObject1).indexOf(localObject2);
          if (localContactBindedActivity.jdField_a_of_type_Int != -1) {
            localContactBindedActivity.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((PhoneContact)localObject2);
          }
        }
        localObject1 = AddFriendLogicActivity.a(this.jdField_a_of_type_AndroidContentContext, 2, ((PhoneContact)localObject2).unifiedCode, null, i, j, ((PhoneContact)localObject2).name, null, null, amtj.a(2131701607), null);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A75", "0X8006A75", 0, 0, "", "", "", "");
        notifyDataSetChanged();
        break;
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 2, 0, "", "", "", "");
        break label268;
        if (this.c.isEmpty())
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D0", "0X80077D0", 0, 0, "", "", "", "");
          break label311;
        }
        if (this.c.contains(localObject2)) {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 1, 0, "", "", "", "");
        }
        for (;;)
        {
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
          break;
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 2, 0, "", "", "", "");
        }
      }
      label732:
      bool1 = false;
      break label111;
      label738:
      bool1 = false;
      break label147;
      label744:
      this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = ((alin)localObject1).jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.isNewRecommend = false;
        localObject2 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))) {
          break label899;
        }
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin, 30);
        ((ProfileActivity.AllInOne)localObject1).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        label844:
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
        if ((!((PhoneContactManagerImp)localObject2).i()) || (!this.c.isEmpty())) {
          break label956;
        }
        ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 104;
      }
      for (;;)
      {
        ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject1);
        notifyDataSetChanged();
        break;
        label899:
        if (((PhoneContactManagerImp)localObject2).i())
        {
          localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 34);
          break label844;
        }
        localObject1 = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, 29);
        ((ProfileActivity.AllInOne)localObject1).l = 16;
        break label844;
        label956:
        if (this.c.contains(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact)) {
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 101;
        } else {
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 102;
        }
      }
      j = 13;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alil
 * JD-Core Version:    0.7.0.1
 */