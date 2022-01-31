import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class ahrz
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private int jdField_a_of_type_Int;
  private ahsf jdField_a_of_type_Ahsf = new ahsc(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apjs jdField_a_of_type_Apjs;
  private apju jdField_a_of_type_Apju;
  private EmoticonGroupStoreFragment jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment;
  private ImgPreviewAdapter jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Map<String, List<EmoticonFromGroupEntity>> jdField_a_of_type_JavaUtilMap;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private Map<Integer, Integer> c = new HashMap();
  private Map<Integer, String> d = new HashMap();
  private Map<Integer, List<EmoticonFromGroupEntity>> e = new TreeMap();
  
  public ahrz(QQAppInterface paramQQAppInterface, EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment, int paramInt, View paramView, ViewPager paramViewPager, Button paramButton)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment = paramEmoticonGroupStoreFragment;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.getActivity();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363601));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368088));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379078));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPageMargin(2);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter = new ImgPreviewAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new ahsa(this));
    this.jdField_b_of_type_AndroidWidgetButton = paramButton;
    this.jdField_a_of_type_Apjs = ((apjs)paramQQAppInterface.getManager(259));
    this.jdField_a_of_type_Apju = ((bdqa)paramQQAppInterface.getManager(235)).jdField_a_of_type_Apju;
    this.jdField_a_of_type_Apju.a();
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    int m = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      this.d.put(Integer.valueOf(m), str);
      this.c.put(Integer.valueOf(m), Integer.valueOf(0));
      localObject = (List)((Map.Entry)localObject).getValue();
      int n = ((List)localObject).size();
      int i1 = (int)Math.ceil(n / 3.0D);
      int k = 0;
      int j = 0;
      int i = m + 1;
      m = i;
      if (k < i1)
      {
        ArrayList localArrayList = new ArrayList();
        m = 0;
        for (;;)
        {
          if ((j + m >= n) || (m >= 3))
          {
            this.d.put(Integer.valueOf(i), str);
            this.e.put(Integer.valueOf(i), localArrayList);
            this.c.put(Integer.valueOf(i), Integer.valueOf(1));
            k += 1;
            i += 1;
            j = m + j;
            break;
          }
          localArrayList.add(((List)localObject).get(j + m));
          m += 1;
        }
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      paramInt2 = -1;
    }
    Object localObject;
    for (;;)
    {
      localObject = (EmoticonFromGroupEntity)((List)this.e.get(Integer.valueOf(paramInt1))).get(paramInt2);
      if (!this.jdField_b_of_type_Boolean) {
        break label473;
      }
      if (-1 == ((EmoticonFromGroupEntity)localObject).status) {
        break label234;
      }
      paramInt1 = ((EmoticonFromGroupEntity)localObject).status;
      if (((EmoticonFromGroupEntity)localObject).status == 0) {
        break label178;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.remove(localObject);
      ((EmoticonFromGroupEntity)localObject).status = -1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)((Iterator)localObject).next();
        if (localEmoticonFromGroupEntity.status > paramInt1) {
          localEmoticonFromGroupEntity.status -= 1;
        }
      }
      paramInt2 = 0;
      continue;
      paramInt2 = 1;
      continue;
      paramInt2 = 2;
    }
    notifyDataSetChanged();
    label178:
    while (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size() > 0)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843938));
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      return;
      label234:
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size();
      if (this.jdField_a_of_type_Apjs.jdField_b_of_type_Int <= paramInt1)
      {
        if (300 == apkc.jdField_a_of_type_Int)
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131689690, 0).b(2131298914);
        }
        else if (144 == apkc.jdField_a_of_type_Int)
        {
          localObject = new ahsb(this);
          localObject = bdcd.a(this.jdField_a_of_type_AndroidContentContext, 0, alpo.a(2131708541), this.jdField_a_of_type_AndroidContentContext.getString(2131689689), alpo.a(2131708542), alpo.a(2131708544), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
          if (localObject != null) {
            ((bdfq)localObject).show();
          }
        }
      }
      else if (20 > this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.add(localObject);
        ((EmoticonFromGroupEntity)localObject).status = this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a.size();
        notifyDataSetChanged();
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, "单次最多收藏20个表情哦~", 0).b(2131298914);
      }
    }
    this.jdField_b_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBFBFBF"));
    this.jdField_b_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843939));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    return;
    label473:
    a((EmoticonFromGroupEntity)localObject, paramInt2, paramInt1);
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Object localObject1 = null;
    if (1 == paramEmoticonFromGroupEntity.fromType)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4, paramEmoticonFromGroupEntity.troopUin, (byte)2, false, (byte)1, 0);
      paramEmoticonFromGroupEntity = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonFromGroupEntity.troopUin, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramEmoticonFromGroupEntity);
      return;
      if (3000 == paramEmoticonFromGroupEntity.fromType)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(101, paramEmoticonFromGroupEntity.troopUin, (byte)3, false, (byte)1, 0);
        paramEmoticonFromGroupEntity = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramEmoticonFromGroupEntity.troopUin);
      }
      else
      {
        Object localObject2 = null;
        paramEmoticonFromGroupEntity = (EmoticonFromGroupEntity)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  private void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2)
  {
    AbstractGifImage.resumeAll();
    a(paramEmoticonFromGroupEntity);
    int i;
    int j;
    if (-1 != paramEmoticonFromGroupEntity.status)
    {
      if (paramEmoticonFromGroupEntity.status == 0)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131708538));
        this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843939));
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      if (!this.e.containsKey(Integer.valueOf(paramInt2))) {
        break label265;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot != this.jdField_a_of_type_AndroidViewView.getParent())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.titleRoot.addView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreEmoticonGroupStoreFragment.a(false);
      }
      i = 0;
      j = 0;
      label138:
      if (j >= paramInt2) {
        break label253;
      }
      if (!this.e.containsKey(Integer.valueOf(j))) {
        break label309;
      }
      i = ((List)this.e.get(Integer.valueOf(j))).size() + i;
    }
    label265:
    label309:
    for (;;)
    {
      j += 1;
      break label138;
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131708539));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843938));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      break;
      label253:
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i + paramInt1, false);
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "ClickPreview", "0", 1, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
  
  private void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity.status == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131708545));
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFBBBBBB"));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843939));
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131708543));
    this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#FFFFFFFF"));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843938));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  public String a(int paramInt)
  {
    String str = (String)this.d.get(Integer.valueOf(paramInt));
    return (String)this.jdField_b_of_type_JavaUtilMap.get(str);
  }
  
  public void a(Map<String, List<EmoticonFromGroupEntity>> paramMap, List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.e.clear();
    this.d.clear();
    this.c.clear();
    a();
    this.jdField_b_of_type_JavaUtilMap.clear();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (List)((Map.Entry)localObject).getValue();
      this.jdField_b_of_type_JavaUtilMap.put(str, this.jdField_a_of_type_Apju.a(str, ((List)localObject).size(), "  "));
    }
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreImgPreviewAdapter.notifyDataSetChanged();
  }
  
  public boolean a(boolean paramBoolean)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    this.jdField_b_of_type_Boolean = paramBoolean;
    return bool;
  }
  
  public int getItemCount()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      int j = this.jdField_a_of_type_JavaUtilMap.size();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (i = 0; localIterator.hasNext(); i = (int)Math.ceil(((List)((Map.Entry)localIterator.next()).getValue()).size() / 3.0D) + i) {}
      i = j + i + 1;
    }
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 2;
    }
    return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ahsg))
    {
      ahsg localahsg = (ahsg)paramViewHolder;
      List localList = (List)this.e.get(Integer.valueOf(paramInt));
      int j = localList.size();
      int i = 0;
      if (i < 3)
      {
        RelativeLayout localRelativeLayout = (RelativeLayout)localahsg.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].getParent();
        if (i < j)
        {
          localRelativeLayout.setVisibility(0);
          localahsg.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i].setImageDrawable(this.jdField_a_of_type_Apju.a((EmoticonFromGroupEntity)localList.get(i), 65537, this.jdField_a_of_type_Int, null));
          this.jdField_b_of_type_Int = ((EmoticonFromGroupEntity)((List)this.e.get(Integer.valueOf(paramInt))).get(i)).status;
          if (this.jdField_b_of_type_Int == 0)
          {
            ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(4);
            ((ahsg)paramViewHolder).b[i].setVisibility(0);
            paramViewHolder.itemView.setClickable(false);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.jdField_a_of_type_Boolean)
          {
            ((ahsg)paramViewHolder).b[i].setVisibility(4);
            if (this.jdField_b_of_type_Int > 0)
            {
              ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(0);
              ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setCheckedNumber(this.jdField_b_of_type_Int);
            }
            else
            {
              ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setChecked(false);
              ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(0);
            }
          }
          else
          {
            ((ahsg)paramViewHolder).jdField_a_of_type_ArrayOfComTencentMobileqqWidgetNumberCheckBox[i].setVisibility(4);
            ((ahsg)paramViewHolder).b[i].setVisibility(4);
            continue;
            localRelativeLayout.setVisibility(4);
          }
        }
      }
      paramViewHolder.itemView.setTag(Integer.valueOf(paramInt));
    }
    do
    {
      return;
      if ((paramViewHolder instanceof ahsd))
      {
        ((ahsd)paramViewHolder).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)this.jdField_b_of_type_JavaUtilMap.get(this.d.get(Integer.valueOf(paramInt))));
        return;
      }
    } while (!(paramViewHolder instanceof ahse));
    ((ahse)paramViewHolder).jdField_a_of_type_AndroidWidgetTextView.setText("仅保留最新的300个聊天表情，\n更多表情请在消息记录中查找哦～");
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupEmoUI.PicSelectAdapter", 2, "view type: " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new ahsd(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561689, paramViewGroup, false));
    case 1: 
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561690, paramViewGroup, false);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramViewGroup.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_Int;
      paramViewGroup.setLayoutParams(localLayoutParams);
      paramViewGroup = new ahsg(paramViewGroup);
      paramViewGroup.a(this.jdField_a_of_type_Ahsf);
      return paramViewGroup;
    }
    return new ahse(this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561693, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrz
 * JD-Core Version:    0.7.0.1
 */