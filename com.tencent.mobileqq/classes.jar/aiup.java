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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class aiup
  extends RecyclerView.Adapter
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = new aiuq(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private List<aivf> jdField_a_of_type_JavaUtilList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private boolean jdField_a_of_type_Boolean;
  
  public aiup(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramFragmentActivity, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener);
    this.jdField_a_of_type_Boolean = bdfk.b();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private String a(String paramString)
  {
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk == null) {}
    while (!localanvk.b(paramString)) {
      return paramString;
    }
    return ContactUtils.getFriendNick(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  private void a(String paramString)
  {
    paramString = new ProfileActivity.AllInOne(paramString, 113);
    paramString.h = 126;
    ProfileActivity.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private void a(boolean paramBoolean, RecyclerView.ViewHolder paramViewHolder, aivf paramaivf)
  {
    int i;
    if (paramBoolean)
    {
      paramaivf = (aius)paramViewHolder;
      paramViewHolder = paramaivf.jdField_a_of_type_AndroidWidgetImageView;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 2130840130;
        paramViewHolder.setImageResource(i);
        paramaivf.jdField_a_of_type_AndroidWidgetTextView.setText(null);
        paramaivf.jdField_a_of_type_JavaLangString = "";
        paramaivf.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label94;
        }
        paramViewHolder = "face2face/jianjie_loading.json";
        label63:
        paramaivf.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        paramaivf.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
        paramaivf.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      }
    }
    label94:
    aiur localaiur;
    do
    {
      return;
      i = 2130840131;
      break;
      paramViewHolder = "face2face/normal_loading.json";
      break label63;
      localaiur = (aiur)paramViewHolder;
    } while ((paramaivf == null) || (TextUtils.isEmpty(paramaivf.jdField_a_of_type_JavaLangString)));
    localaiur.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(paramaivf.jdField_a_of_type_JavaLangString));
    localaiur.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(mvk.a);
    localaiur.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(localaiur);
    if (TextUtils.isEmpty(paramaivf.b))
    {
      paramViewHolder = a(paramaivf.jdField_a_of_type_JavaLangString);
      localaiur.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramViewHolder));
      localaiur.jdField_a_of_type_JavaLangString = paramaivf.jdField_a_of_type_JavaLangString;
      if (!paramaivf.a()) {
        break label319;
      }
      if (!this.jdField_a_of_type_JavaUtilSet.contains(paramaivf.jdField_a_of_type_JavaLangString))
      {
        localaiur.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.5F);
        localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (!this.jdField_a_of_type_Boolean) {
          break label313;
        }
        paramViewHolder = "face2face/jianjie_avatar.json";
        label250:
        localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation(paramViewHolder);
        localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
        localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(localaiur);
      }
    }
    for (;;)
    {
      ViewCompat.setImportantForAccessibility(localaiur.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localaiur.jdField_a_of_type_AndroidWidgetImageView, 1);
      ViewCompat.setImportantForAccessibility(localaiur.itemView, 1);
      return;
      paramViewHolder = paramaivf.b;
      break;
      label313:
      paramViewHolder = "face2face/normal_avatar.json";
      break label250;
      label319:
      if ((localaiur.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < 1.0D) || (localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getVisibility() != 4))
      {
        localaiur.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
        localaiur.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
    }
  }
  
  protected Bitmap a(String paramString)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 1, false, (byte)1);
        localObject = localBitmap;
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = bheg.a();
    }
    return paramString;
  }
  
  public List<aivf> a()
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
    if ((paramViewHolder instanceof aius)) {
      a(true, paramViewHolder, null);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      a(false, paramViewHolder, (aivf)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561164, paramViewGroup, false);
    if (paramInt == 1) {
      return new aius(this, paramViewGroup);
    }
    return new aiur(this, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiup
 * JD-Core Version:    0.7.0.1
 */