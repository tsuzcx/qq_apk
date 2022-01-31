import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.fragment.GroupItemClickListeneer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.SingleLineTextView;
import java.io.File;
import java.util.LinkedList;

public class acqp
  extends RecyclerView.Adapter
{
  private int jdField_a_of_type_Int;
  private GroupItemClickListeneer jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  
  public acqp(ExtendFriendGroupFragment paramExtendFriendGroupFragment, GroupItemClickListeneer paramGroupItemClickListeneer, LinkedList paramLinkedList)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer = paramGroupItemClickListeneer;
    this.jdField_a_of_type_JavaUtilLinkedList = paramLinkedList;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilLinkedList.size() + 1;
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size() + 2;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0) {
      return 2;
    }
    if (paramInt == 0) {
      return 3;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size() + 1) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    switch (getItemViewType(paramInt))
    {
    default: 
    case 2: 
      do
      {
        return;
        paramViewHolder = (acqi)paramViewHolder;
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment).getHeight();
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.a;
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = URLDrawableHelper.a;
        localObject1 = ExtendFriendResourceUtil.a("expand_square_blank.png");
      } while (!new File((String)localObject1).exists());
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
      localObject1 = ExtendFriendResourceUtil.a((String)localObject1, (BitmapFactory.Options)localObject2);
      paramViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable((Bitmap)localObject1));
      return;
    case 0: 
      localObject1 = (acqm)paramViewHolder;
      localObject2 = (GroupInfo)this.jdField_a_of_type_JavaUtilLinkedList.get(paramInt - 1);
      ((acqm)localObject1).jdField_a_of_type_AndroidViewView.setTag(2131362846, Integer.valueOf(paramInt - 1));
      ((acqm)localObject1).jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((GroupInfo)localObject2).groupName);
      if (TextUtils.isEmpty(((GroupInfo)localObject2).groupDesc))
      {
        paramViewHolder = "群主很懒，还没有群介绍哦~";
        if (!paramViewHolder.equals(((acqm)localObject1).b.a())) {
          ((acqm)localObject1).b.setText(paramViewHolder);
        }
        paramViewHolder = (acqq)((acqm)localObject1).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
        if (paramViewHolder != null) {
          break label325;
        }
        paramViewHolder = new acqq(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, ((GroupInfo)localObject2).labels);
        ((acqm)localObject1).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(paramViewHolder);
      }
      for (;;)
      {
        paramViewHolder = URLDrawable.URLDrawableOptions.obtain();
        paramViewHolder.mLoadingDrawable = ImageUtil.c();
        paramViewHolder.mFailedDrawable = URLDrawableHelper.a;
        paramViewHolder = URLDrawable.getDrawable(((GroupInfo)localObject2).groupFace, paramViewHolder);
        paramViewHolder.setTag(URLDrawableDecodeHandler.a(140, 140));
        paramViewHolder.setDecodeHandler(URLDrawableDecodeHandler.k);
        ((acqm)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewHolder);
        return;
        paramViewHolder = ((GroupInfo)localObject2).groupDesc;
        break;
        label325:
        paramViewHolder.a(((GroupInfo)localObject2).labels);
        paramViewHolder.notifyDataSetChanged();
      }
    }
    paramViewHolder = (acqj)paramViewHolder;
    paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Int);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970344, paramViewGroup, false);
      return new acqi(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    if (paramInt == 1)
    {
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendGroupFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment));
      paramViewGroup.findViewById(2131362837).getLayoutParams().height = AIOUtils.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment.getResources());
      return new acqj(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer);
    }
    if (paramInt == 3)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970349, paramViewGroup, false);
      return new acqk(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup);
    }
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970347, paramViewGroup, false);
    return new acqm(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqp
 * JD-Core Version:    0.7.0.1
 */