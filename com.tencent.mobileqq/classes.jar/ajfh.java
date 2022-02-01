import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ajfh
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private aoof jdField_a_of_type_Aoof;
  private aoog jdField_a_of_type_Aoog = new ajfi(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<ajfx> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public ajfh(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_Aoof = new aoof(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this.jdField_a_of_type_Aoog);
    this.jdField_a_of_type_Boolean = bdgb.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localanyw == null) {}
    while (!localanyw.b(paramString)) {
      return paramString;
    }
    return bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, ajfx paramajfx)
  {
    int i;
    if (paramBoolean)
    {
      paramajfx = (ajfk)paramViewHolder;
      paramViewHolder = paramajfx.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130840072;
        paramViewHolder.setImageResource(i);
        paramajfx.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramajfx.jdField_a_of_type_JavaLangString = "";
        paramajfx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramajfx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramajfx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramajfx.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    ajfj localajfj;
    do
    {
      return;
      i = 2130840073;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localajfj = (ajfj)paramViewHolder;
    } while ((paramajfx == null) || (TextUtils.isEmpty(paramajfx.jdField_a_of_type_JavaLangString)));
    localajfj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramajfx.jdField_a_of_type_JavaLangString));
    localajfj.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mvd.a);
    localajfj.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localajfj);
    if (TextUtils.isEmpty(paramajfx.b))
    {
      paramViewHolder = a(paramajfx.jdField_a_of_type_JavaLangString);
      localajfj.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localajfj.jdField_a_of_type_JavaLangString = paramajfx.jdField_a_of_type_JavaLangString;
      if (!paramajfx.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramajfx.jdField_a_of_type_JavaLangString))
      {
        localajfj.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localajfj);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localajfj.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localajfj.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localajfj.itemView, 1);
      return;
      paramViewHolder = paramajfx.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localajfj.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localajfj.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localajfj.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_Aoof != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_Aoof.a(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_Aoof.a(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bhmq.a();
    }
    return paramString;
  }
  
  public List<ajfx> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilSet != null) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = null;
    a();
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.a(null);
      this.jdField_a_of_type_Aoog = null;
      this.jdField_a_of_type_Aoof.d();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      return 1;
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ajfk)) {
      a(true, paramViewHolder, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      a(false, paramViewHolder, (ajfx)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561229, paramViewGroup, false);
    if (paramInt == 1) {
      return new ajfk(this, paramViewGroup);
    }
    return new ajfj(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfh
 * JD-Core Version:    0.7.0.1
 */