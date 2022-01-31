import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.10;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.SixCombolEffectView;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class afmy
  extends BaseBubbleBuilder
  implements agby
{
  private static Map<Long, MessageForPoke> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  protected static final Handler b;
  private static Map<Long, MessageForPoke> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static int e;
  private static int f;
  public static volatile boolean f;
  private LruCache<Long, MessageForPoke> jdField_a_of_type_AndroidUtilLruCache;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afnl(this, null);
  bdul jdField_a_of_type_Bdul = new afnd(this);
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  ViewAnimation jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new afnp(this);
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private float jdField_b_of_type_Float = 1.0F;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new afno(this);
  public QQAppInterface b;
  private VasQuickUpdateManager.CallBacker jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker;
  int jdField_c_of_type_Int = -1;
  private Map<Integer, Integer> jdField_c_of_type_JavaUtilMap;
  int d = 1;
  
  static
  {
    jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public afmy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramContext);
    b(paramContext);
  }
  
  private int a(afnk paramafnk)
  {
    switch (((MessageForPoke)paramafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage).interactType)
    {
    default: 
      return azkz.a(paramafnk.jdField_a_of_type_Float * 100.0F);
    case 0: 
    case 1: 
      if (paramafnk.jdField_a_of_type_Float == 2.0F) {
        return azkz.a(150.0F * paramafnk.jdField_a_of_type_Float);
      }
      return azkz.a(paramafnk.jdField_a_of_type_Float * 100.0F);
    case 2: 
      return azkz.a(280.0F * paramafnk.jdField_a_of_type_Float);
    case 3: 
      return azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    case 4: 
      return azkz.a(paramafnk.jdField_a_of_type_Float * 100.0F);
    case 6: 
      return 0;
    }
    return azkz.a(230.0F * paramafnk.jdField_a_of_type_Float);
  }
  
  public static AnimationSet a(Context paramContext, boolean paramBoolean)
  {
    int k = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    long l = 350L;
    int[] arrayOfInt = new int[4];
    int[] tmp25_23 = arrayOfInt;
    tmp25_23[0] = '';
    int[] tmp31_25 = tmp25_23;
    tmp31_25[1] = '';
    int[] tmp37_31 = tmp31_25;
    tmp37_31[2] = '';
    int[] tmp43_37 = tmp37_31;
    tmp43_37[3] = '';
    tmp43_37;
    int i;
    int j;
    if (paramBoolean)
    {
      i = aepi.a(22.0F, paramContext.getResources());
      j = aepi.a(30.0F, paramContext.getResources());
      if (!paramBoolean) {
        break label184;
      }
      paramContext = new int[4];
      paramContext[0] = (-i);
      paramContext[1] = i;
      paramContext[2] = (-j);
      paramContext[3] = j;
      label100:
      j = arrayOfInt.length;
      i = k;
      label107:
      if (i >= j) {
        break label437;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt[i];
      i += 1;
      break label107;
      i = aepi.a(15.0F, paramContext.getResources());
      j = aepi.a(20.0F, paramContext.getResources());
      break;
      label184:
      paramContext = new int[4];
      paramContext[0] = i;
      paramContext[1] = (-i);
      paramContext[2] = j;
      paramContext[3] = (-j);
      break label100;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, paramContext[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label437:
    return localAnimationSet;
  }
  
  private AnimationSet a(boolean paramBoolean)
  {
    AnimationSet localAnimationSet = a(this.jdField_a_of_type_AndroidContentContext, paramBoolean);
    long l = 1270L;
    int[] arrayOfInt2 = new int[6];
    int[] tmp23_21 = arrayOfInt2;
    tmp23_21[0] = 510;
    int[] tmp29_23 = tmp23_21;
    tmp29_23[1] = 120;
    int[] tmp34_29 = tmp29_23;
    tmp34_29[2] = 120;
    int[] tmp39_34 = tmp34_29;
    tmp39_34[3] = 120;
    int[] tmp44_39 = tmp39_34;
    tmp44_39[4] = 120;
    int[] tmp49_44 = tmp44_39;
    tmp49_44[5] = 120;
    tmp49_44;
    int[] arrayOfInt1;
    int i;
    if (paramBoolean)
    {
      arrayOfInt1 = new int[7];
      int[] tmp67_65 = arrayOfInt1;
      tmp67_65[0] = -160;
      int[] tmp73_67 = tmp67_65;
      tmp73_67[1] = -10;
      int[] tmp78_73 = tmp73_67;
      tmp78_73[2] = 'ð';
      int[] tmp84_78 = tmp78_73;
      tmp84_78[3] = -120;
      int[] tmp89_84 = tmp84_78;
      tmp89_84[4] = 70;
      int[] tmp94_89 = tmp89_84;
      tmp94_89[5] = -50;
      int[] tmp99_94 = tmp94_89;
      tmp99_94[6] = 30;
      tmp99_94;
      int j = arrayOfInt2.length;
      i = 0;
      label112:
      if (i >= j) {
        break label447;
      }
      switch (i)
      {
      }
    }
    for (;;)
    {
      l += arrayOfInt2[i];
      i += 1;
      break label112;
      arrayOfInt1 = new int[7];
      int[] tmp173_171 = arrayOfInt1;
      tmp173_171[0] = ' ';
      int[] tmp179_173 = tmp173_171;
      tmp179_173[1] = 10;
      int[] tmp184_179 = tmp179_173;
      tmp184_179[2] = -240;
      int[] tmp190_184 = tmp184_179;
      tmp190_184[3] = 120;
      int[] tmp195_190 = tmp190_184;
      tmp195_190[4] = -70;
      int[] tmp200_195 = tmp195_190;
      tmp200_195[5] = 50;
      int[] tmp205_200 = tmp200_195;
      tmp205_200[6] = -30;
      tmp205_200;
      break;
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      l += 80L;
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
      continue;
      localTranslateAnimation = new TranslateAnimation(0.0F, arrayOfInt1[i], 0.0F, 0.0F);
      localTranslateAnimation.setDuration(arrayOfInt2[i]);
      localTranslateAnimation.setStartOffset(l);
      localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
      localAnimationSet.addAnimation(localTranslateAnimation);
    }
    label447:
    return localAnimationSet;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "chat_item_for_qqpokenew";
    case 2: 
      return "chat_item_for_qqbixin_light";
    case 3: 
      return "chat_item_for_qqlikenew";
    case 4: 
      return "chat_item_for_qqheartbroken";
    }
    return "chat_item_for_qq666";
  }
  
  private void a(long paramLong, MessageForPoke paramMessageForPoke)
  {
    if (this.jdField_a_of_type_AndroidUtilLruCache == null) {
      this.jdField_a_of_type_AndroidUtilLruCache = new afmz(this, jdField_e_of_type_Int);
    }
    this.jdField_a_of_type_AndroidUtilLruCache.put(Long.valueOf(paramLong), paramMessageForPoke);
  }
  
  private void a(afnk paramafnk, MessageForPoke paramMessageForPoke)
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    Object localObject1 = (RelativeLayout.LayoutParams)((ViewGroup)paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getParent()).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    Object localObject2 = (RelativeLayout.LayoutParams)paramafnk.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject3 = (RelativeLayout.LayoutParams)paramafnk.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject4 = (RelativeLayout.LayoutParams)paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramafnk.jdField_c_of_type_AndroidViewView.getLayoutParams();
    paramafnk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramafnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafnk.jdField_c_of_type_AndroidViewView.setVisibility(8);
    int i;
    label415:
    label480:
    int j;
    switch (paramMessageForPoke.strength)
    {
    default: 
      paramafnk.jdField_a_of_type_Float = this.jdField_b_of_type_Float;
      f();
      if (126 != paramMessageForPoke.interactType) {
        break label1328;
      }
      localLayoutParams1.height = azkz.a(70.0F);
      localLayoutParams1.topMargin = azkz.a(10.0F);
      localLayoutParams1.bottomMargin = azkz.a(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).width = azkz.a(70.0F);
      ((RelativeLayout.LayoutParams)localObject2).height = azkz.a(70.0F);
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramafnk.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((RelativeLayout.LayoutParams)localObject1).height = azkz.a(90.0F);
      localLayoutParams2.leftMargin = 0;
      localLayoutParams2.rightMargin = 0;
      localLayoutParams2.width = azkz.a(90.0F);
      localLayoutParams2.height = azkz.a(90.0F);
      if ((this.jdField_c_of_type_JavaUtilMap != null) && (!this.jdField_c_of_type_JavaUtilMap.isEmpty()) && (this.jdField_c_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramMessageForPoke.subId))))
      {
        i = ((Integer)this.jdField_c_of_type_JavaUtilMap.get(Integer.valueOf(paramMessageForPoke.subId))).intValue();
        if ((4 == i) || (5 == i))
        {
          localObject1 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838114);
          localObject4 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838115);
          localObject1 = bhse.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
          paramafnk.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
      }
      else
      {
        if (!paramMessageForPoke.isSend()) {
          break label992;
        }
        paramafnk.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = azkz.a(20.0F);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = azkz.a(10.0F);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        localObject2 = new File(afxl.e + paramMessageForPoke.subId + "/pressed.png");
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846942);
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = new ColorDrawable();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject1);
        localObject2 = URLDrawable.getDrawable((File)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        localObject3 = new File(afxl.e + paramMessageForPoke.subId + "/normal.png");
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject1);
        localObject1 = URLDrawable.getDrawable((File)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject2);
        ((StateListDrawable)localObject3).addState(new int[] { 16842908 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[0], (Drawable)localObject1);
        ((URLDrawable)localObject1).setURLDrawableListener(new afni(this, (StateListDrawable)localObject3));
        if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        paramafnk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
        if (afxl.a("bubble", paramMessageForPoke.subId)) {
          break label1098;
        }
        i = 1;
        label774:
        if (afxl.a("/normal.png", paramMessageForPoke.subId)) {
          break label1103;
        }
        j = 1;
        label790:
        if ((i == 0) || (j == 0)) {
          break label1265;
        }
        if (!afxl.a.contains(Integer.valueOf(paramMessageForPoke.subId))) {
          break label1120;
        }
        if ((!afxl.c.contains(Integer.valueOf(paramMessageForPoke.subId))) && (!afxl.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          break label1109;
        }
        paramafnk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      }
      break;
    }
    for (;;)
    {
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable((Drawable)localObject1);
      paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(localLayoutParams1);
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAllAnimatorListener();
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new afnj(this, paramafnk, paramMessageForPoke));
      return;
      this.jdField_b_of_type_Float = 1.0F;
      break;
      this.jdField_b_of_type_Float = 1.3F;
      break;
      this.jdField_b_of_type_Float = 1.6F;
      break;
      this.jdField_b_of_type_Float = 2.0F;
      break;
      localObject1 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838112);
      localObject4 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838113);
      localObject1 = bhse.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
      break label415;
      label992:
      paramafnk.jdField_a_of_type_AndroidWidgetImageView.setScaleX(-1.0F);
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(-1.0F);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = azkz.a(20.0F);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject2).topMargin = azkz.a(10.0F);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + azkz.a(10.0F) - azkz.a(6.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(azkz.a(80.0F) * paramafnk.jdField_a_of_type_Float - azkz.a(34.0F)));
      break label480;
      label1098:
      i = 0;
      break label774;
      label1103:
      j = 0;
      break label790;
      label1109:
      paramafnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      continue;
      label1120:
      afxl.a.add(Integer.valueOf(paramMessageForPoke.subId));
      afxl.c.add(Integer.valueOf(paramMessageForPoke.subId));
      afxl.d.add(Integer.valueOf(paramMessageForPoke.subId));
      paramafnk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localObject2 = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
      ((VasQuickUpdateManager)localObject2).downloadItem(21L, "poke.item.effect." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).downloadItem(21L, "poke.item.res." + paramMessageForPoke.subId, "getbubbleview");
      ((VasQuickUpdateManager)localObject2).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      continue;
      label1265:
      if ((i != 0) || (j != 0)) {
        if ((afxl.c.contains(Integer.valueOf(paramMessageForPoke.subId))) || (afxl.d.contains(Integer.valueOf(paramMessageForPoke.subId)))) {
          paramafnk.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        } else {
          paramafnk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
    label1328:
    localLayoutParams1.height = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    localLayoutParams1.width = a(paramafnk);
    localLayoutParams1.topMargin = azkz.a(0.0F);
    localLayoutParams1.bottomMargin = azkz.a(0.0F);
    ((RelativeLayout.LayoutParams)localObject4).height = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    localLayoutParams2.width = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    localLayoutParams2.height = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    localLayoutParams3.width = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    localLayoutParams3.height = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).width = azkz.a(80.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).height = azkz.a(70.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = azkz.a(10.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = azkz.a(10.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject1).height = azkz.a(90.0F * paramafnk.jdField_a_of_type_Float);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = 0;
    paramafnk.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramafnk.jdField_a_of_type_AndroidWidgetImageView.setScaleX(1.0F);
    paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setScaleX(1.0F);
    localObject1 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838112);
    localObject4 = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838113);
    localObject1 = bhse.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject1, (Bitmap)localObject4);
    paramafnk.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    if (paramMessageForPoke.isSendFromLocal())
    {
      localLayoutParams2.rightMargin = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296295);
      localLayoutParams2.leftMargin = 0;
    }
    for (;;)
    {
      localObject1 = afxl.a(paramMessageForPoke.interactType, paramMessageForPoke.isSend(), this.jdField_a_of_type_AndroidContentContext.getResources());
      paramafnk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a(paramMessageForPoke, paramafnk.jdField_a_of_type_Float);
      break;
      if ((paramafnk.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(paramMessageForPoke)))
      {
        paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        if (!paramMessageForPoke.hasQuickBackShowed)
        {
          paramMessageForPoke.hasQuickBackShowed = true;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8008912", "0X8008912", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        localLayoutParams2.leftMargin = azkz.a(10.0F * paramafnk.jdField_a_of_type_Float);
        localLayoutParams2.rightMargin = 0;
        ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
        switch (paramMessageForPoke.strength)
        {
        default: 
          break;
        case 0: 
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - azkz.a(6.0F));
          ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(azkz.a(80.0F) * paramafnk.jdField_a_of_type_Float - azkz.a(34.0F)));
          break;
          paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - azkz.a(6.0F) - azkz.a(10.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(azkz.a(80.0F) * paramafnk.jdField_a_of_type_Float - azkz.a(35.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - azkz.a(6.0F) - azkz.a(20.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(azkz.a(80.0F) * paramafnk.jdField_a_of_type_Float - azkz.a(36.0F)));
      continue;
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = (((RelativeLayout.LayoutParams)localObject2).width + localLayoutParams2.leftMargin - azkz.a(6.0F) - azkz.a(40.0F));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(azkz.a(80.0F) * paramafnk.jdField_a_of_type_Float - azkz.a(38.0F)));
    }
  }
  
  @TargetApi(17)
  private void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeItemBuilder", 2, "startPokeWindowAnim " + paramBoolean1);
    }
    this.jdField_a_of_type_JavaLangRunnable = new GivingHeartItemBuilder.10(this, paramActivity, paramBoolean2, paramBoolean1);
    jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void a(Context paramContext)
  {
    if (jdField_e_of_type_Int == 0) {
      jdField_e_of_type_Int = (paramContext.getResources().getDisplayMetrics().heightPixels - azkz.a(50.0F) * 2) / azkz.a(90.0F);
    }
    if (jdField_e_of_type_Int <= 0) {
      jdField_e_of_type_Int = 10;
    }
  }
  
  private void a(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int n = 8;
    int i1 = 4;
    paramCustomFrameAnimationDrawable.i();
    String str = PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_";
    paramCustomFrameAnimationDrawable.a(0, 340, str + "01.png");
    int j = 0;
    int i = 0;
    while (j < 5)
    {
      paramCustomFrameAnimationDrawable.a(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    j = 4;
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.a(i, 30, str + "0" + (j + 1) + ".png");
      j -= 1;
      i += 1;
    }
    j = 0;
    int m;
    for (;;)
    {
      k = i1;
      m = i;
      if (j >= 5) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(i, 45, str + "0" + (j + 1) + ".png");
      j += 1;
      i += 1;
    }
    while (k > 0)
    {
      paramCustomFrameAnimationDrawable.a(m, 30, str + "0" + (k + 1) + ".png");
      k -= 1;
      m += 1;
    }
    paramCustomFrameAnimationDrawable.a(m, 240, str + "01.png");
    j = m + 1;
    int k = 0;
    for (;;)
    {
      m = n;
      i = j;
      if (k >= 8) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(j, 30, str + "0" + (k + 1) + ".png");
      k += 1;
      j += 1;
    }
    while (m < 10)
    {
      paramCustomFrameAnimationDrawable.a(i, 150, str + "0" + (m + 1) + ".png");
      m += 1;
      i += 1;
    }
    j = 9;
    if (j >= 0)
    {
      if (j % 2 != 0) {
        break label573;
      }
      k = i + 1;
      paramCustomFrameAnimationDrawable.a(i, 40, str + "0" + (j + 1) + ".png");
      i = k;
    }
    label573:
    for (;;)
    {
      j -= 1;
      break;
      paramCustomFrameAnimationDrawable.a(i, 330, str + "01.png");
      return;
    }
  }
  
  private static CustomFrameAnimationDrawable b(CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable)
  {
    int k = 5;
    paramCustomFrameAnimationDrawable.i();
    paramCustomFrameAnimationDrawable.a(0, 340, 2130838528);
    int i = 0;
    while (i < 6)
    {
      paramCustomFrameAnimationDrawable.a(i, 40, 2130838528 + i);
      i += 1;
    }
    i = 5;
    while (i > 0)
    {
      paramCustomFrameAnimationDrawable.a(i, 30, 2130838528 + i);
      i -= 1;
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= 6) {
        break;
      }
      paramCustomFrameAnimationDrawable.a(i, 40, 2130838528 + i);
      i += 1;
    }
    while (j > 0)
    {
      paramCustomFrameAnimationDrawable.a(j, 30, 2130838528 + j);
      j -= 1;
    }
    paramCustomFrameAnimationDrawable.a(0, 160, 2130838528);
    return paramCustomFrameAnimationDrawable;
  }
  
  private String b(ChatMessage paramChatMessage)
  {
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = alud.a(2131705670);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        return paramChatMessage;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return paramChatMessage;
  }
  
  private void b(afnk paramafnk, MessageForPoke paramMessageForPoke)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    UnlimitedBladeWorks localUnlimitedBladeWorks;
    if ((paramMessageForPoke.isPlayed) && (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))))
    {
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if ((paramafnk.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(paramMessageForPoke)))
      {
        paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
        if (paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.a())
        {
          localUnlimitedBladeWorks = paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
          if (paramMessageForPoke.isSend()) {
            break label193;
          }
          label149:
          localUnlimitedBladeWorks.setParams(bool1);
        }
        paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.d("fangdazhao", 2, "[showed]");
        }
      }
    }
    label193:
    label225:
    do
    {
      return;
      paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      bool1 = false;
      break label149;
      if (PokeBigResHandler.jdField_a_of_type_Boolean)
      {
        localUnlimitedBladeWorks = paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        if (!paramMessageForPoke.isSend())
        {
          bool1 = true;
          localUnlimitedBladeWorks.a(localContext, bool1, afxl.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface), paramafnk.jdField_a_of_type_Float);
        }
      }
      else
      {
        if (!paramMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean) {
          break label408;
        }
        paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        localUnlimitedBladeWorks = paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        if (paramMessageForPoke.isSend()) {
          break label398;
        }
        bool1 = true;
        localUnlimitedBladeWorks.setMirror(bool1);
        paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new afnb(this, paramafnk, paramMessageForPoke));
        localUnlimitedBladeWorks = paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks;
        if (paramMessageForPoke.isSend()) {
          break label403;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        localUnlimitedBladeWorks.a(paramMessageForPoke, bool1, paramafnk.jdField_a_of_type_Float);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("fangdazhao", 2, "[resume]");
        return;
        bool1 = false;
        break label225;
        bool1 = false;
        break label326;
      }
      if (paramMessageForPoke.mUnlimitedState.b)
      {
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((paramafnk.jdField_b_of_type_Int == f) && (!paramMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(paramMessageForPoke))) {
          paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          if (!paramMessageForPoke.isPlayed) {
            paramMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(paramMessageForPoke.uniseq))) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(paramMessageForPoke.uniseq));
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("fangdazhao", 2, "[show end]");
          return;
          paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    } while (aepi.k);
    label326:
    aepi.jdField_a_of_type_Int += 1;
    label398:
    label403:
    label408:
    paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(0);
    paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
    paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    paramafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
    paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
    paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setEndListener(new afnc(this, paramafnk, paramMessageForPoke));
    if (QLog.isColorLevel()) {
      QLog.i("fangdazhao", 2, "[start]");
    }
    paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.c();
    a(paramMessageForPoke.uniseq, paramMessageForPoke);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new afne(this));
    paramContext = new RelativeLayout.LayoutParams(1, 1);
    ViewGroup localViewGroup = (ViewGroup)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362208);
    if (localViewGroup != null) {
      localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, paramContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation = new ViewAnimation(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new afnf(this);
    e();
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdul);
    }
  }
  
  @Deprecated
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPoke)) {
      return (((MessageForPoke)paramMessageRecord).flag & 0x1) == 1;
    }
    return false;
  }
  
  private String c(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (TextUtils.isEmpty(paramChatMessage.msg)) {}
    for (paramChatMessage = alud.a(2131705669);; paramChatMessage = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1)) {
      try
      {
        Integer.parseInt(paramChatMessage);
        localStringBuilder.append("回复" + paramChatMessage + "动作");
        return localStringBuilder.toString();
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localStringBuilder.append("回复" + paramChatMessage + "动作");
      }
    }
    return localStringBuilder.toString();
  }
  
  private void e()
  {
    if ((this.jdField_c_of_type_JavaUtilMap == null) || (this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new GivingHeartItemBuilder.5(this));
  }
  
  private void f()
  {
    List localList;
    int i;
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && ((this.jdField_a_of_type_AndroidWidgetBaseAdapter instanceof aeqo)))
    {
      localList = ((aeqo)this.jdField_a_of_type_AndroidWidgetBaseAdapter).a();
      if (localList != null) {
        i = localList.size() - 1;
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)localList.get(i);
        if (((localChatMessage instanceof MessageForPoke)) && (!localChatMessage.isSend())) {
          f = i;
        }
      }
      else
      {
        return;
      }
      i -= 1;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return new afnk(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Object localObject1 = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForPoke)paramChatMessage;
    afnk localafnk = (afnk)paramaeqi;
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "type: " + paramBaseChatItemLayout.interactType + " strength: " + paramBaseChatItemLayout.strength);
    }
    paramaeqi = paramView;
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GivingHeart", 2, "[getBubbleView]:content is null");
      }
      paramaeqi = new RelativeLayout((Context)localObject1);
      paramaeqi.setId(2131376034);
      paramView = new RelativeLayout((Context)localObject1);
      Object localObject4 = new DiniFlyAnimationView((Context)localObject1);
      localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)localObject4);
      paramView.addView((View)localObject4);
      paramaeqi.addView(paramView, new RelativeLayout.LayoutParams(-2, -2));
      Object localObject3 = new ImageView((Context)localObject1);
      ((ImageView)localObject3).setId(2131373993);
      paramView = bdhj.a(((Context)localObject1).getResources(), 2130838112);
      Object localObject2 = bdhj.a(((Context)localObject1).getResources(), 2130838113);
      ((ImageView)localObject3).setImageDrawable(bhse.a(((Context)localObject1).getResources(), paramView, (Bitmap)localObject2));
      localafnk.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localObject3);
      paramaeqi.addView((View)localObject3);
      UnlimitedBladeWorks localUnlimitedBladeWorks = new UnlimitedBladeWorks((Context)localObject1);
      localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks = localUnlimitedBladeWorks;
      paramaeqi.addView(localUnlimitedBladeWorks);
      RelativeLayout localRelativeLayout = new RelativeLayout((Context)localObject1);
      localRelativeLayout.setId(2131372174);
      ImageView localImageView = new ImageView((Context)localObject1);
      localafnk.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      localRelativeLayout.addView(localImageView);
      localObject2 = new ProgressBar((Context)localObject1, null, 0);
      ((ProgressBar)localObject2).setIndeterminate(true);
      ((ProgressBar)localObject2).setIndeterminateDrawable(((Context)localObject1).getResources().getDrawable(2130839229));
      localafnk.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject2);
      localRelativeLayout.addView((View)localObject2);
      paramView = new ImageView((Context)localObject1);
      paramView.setId(2131377419);
      paramView.setImageResource(2130846943);
      localafnk.jdField_b_of_type_AndroidWidgetImageView = paramView;
      localRelativeLayout.addView(paramView);
      localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout = localRelativeLayout;
      paramaeqi.addView(localRelativeLayout);
      View localView = new View((Context)localObject1);
      paramaeqi.addView(localView);
      localafnk.jdField_c_of_type_AndroidViewView = localView;
      localObject4 = (RelativeLayout.LayoutParams)((DiniFlyAnimationView)localObject4).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = azkz.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject4).addRule(12, -1);
      localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject4).height = azkz.a(40.0F);
      ((RelativeLayout.LayoutParams)localObject4).width = azkz.a(40.0F);
      ((ImageView)localObject3).setPadding(azkz.a(6.0F), azkz.a(6.0F), azkz.a(6.0F), azkz.a(6.0F));
      localObject3 = (RelativeLayout.LayoutParams)localUnlimitedBladeWorks.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = -1;
      ((RelativeLayout.LayoutParams)localObject3).height = azkz.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).width = azkz.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).height = azkz.a(90.0F);
      ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
      localObject3 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject3).topMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296295);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((Context)localObject1).getResources().getDimensionPixelSize(2131296295);
      ((RelativeLayout.LayoutParams)localObject3).height = azkz.a(70.0F);
      ((RelativeLayout.LayoutParams)localObject3).width = azkz.a(80.0F);
      localObject1 = (RelativeLayout.LayoutParams)((ProgressBar)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(23.0F * this.jdField_a_of_type_Float));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = azkz.a(10.0F);
      paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      paramView.width = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.height = ((int)(23.0F * this.jdField_a_of_type_Float));
      paramView.addRule(12, -1);
      paramView.addRule(11, -1);
      paramView.bottomMargin = azkz.a(10.0F);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "[getBubbleView]set Holder's contentView");
    }
    paramaeqi.setTag(localafnk);
    a(localafnk, paramBaseChatItemLayout);
    localafnk.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    paramaeqi.setOnTouchListener(paramaetk);
    paramaeqi.setOnLongClickListener(paramaetk);
    paramaeqi.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localafnk.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(c(paramChatMessage));
    if (jdField_e_of_type_Boolean)
    {
      if ((localafnk.jdField_b_of_type_JavaLangStringBuilder != null) && (localafnk.jdField_b_of_type_JavaLangStringBuilder.length() > 0)) {
        localafnk.jdField_b_of_type_JavaLangStringBuilder.setLength(0);
      }
      paramaeqi.setContentDescription(b(paramChatMessage));
    }
    return paramaeqi;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramChatMessage.time > 0L) {
      localStringBuilder.append(bdns.a(this.jdField_a_of_type_AndroidContentContext, 3, paramChatMessage.time * 1000L)).append(" ");
    }
    Object localObject = paramChatMessage.msg.substring(1, paramChatMessage.msg.length() - 1);
    try
    {
      Integer.parseInt((String)localObject);
      String str = "";
      localObject = ((String)localObject).toCharArray();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        char c1 = localObject[i];
        str = str + c1 + " ";
        i += 1;
      }
      if (!paramChatMessage.isSend()) {
        break label289;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (paramChatMessage.isSend()) {
        localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发出动作" + (String)localObject);
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发来动作" + (String)localObject);
      }
    }
    localStringBuilder.append("我向" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发出动作" + localNumberFormatException);
    for (;;)
    {
      return localStringBuilder.toString();
      label289:
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d + "发来动作" + localNumberFormatException);
    }
  }
  
  public void a()
  {
    super.a();
    Object localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    MessageForPoke localMessageForPoke;
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localMessageForPoke.mFrameState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mUnlimitedState.b = true;
    }
    jdField_a_of_type_JavaUtilMap.clear();
    localObject = jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localMessageForPoke = (MessageForPoke)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (!localMessageForPoke.isPlayed) {
        localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      localMessageForPoke.mFrameState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mFrameState.c = true;
      localMessageForPoke.mUnlimitedState.jdField_a_of_type_Boolean = false;
      localMessageForPoke.mUnlimitedState.b = true;
    }
    jdField_b_of_type_JavaUtilMap.clear();
    if (this.jdField_a_of_type_AndroidUtilLruCache != null)
    {
      this.jdField_a_of_type_AndroidUtilLruCache.evictAll();
      this.jdField_a_of_type_AndroidUtilLruCache = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "HIDE_PLACEHOLDER destroy");
    }
    afxh.a().a(20);
    afxh.a().a(21);
    localObject = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(184);
    ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdul);
    }
    aepi.jdField_a_of_type_Int = 0;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365071: 
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.d(paramChatMessage);
  }
  
  public void a(afnk paramafnk)
  {
    if (paramafnk != null)
    {
      paramafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((paramafnk.jdField_b_of_type_Int != f) || (paramafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) || ((this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) || (b(paramafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
        break label106;
      }
      paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      paramafnk.jdField_c_of_type_AndroidViewView.setVisibility(8);
      if (!((MessageForPoke)paramafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage).isPlayed) {
        ((MessageForPoke)paramafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage).setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
      label106:
      paramafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(0, 0, 0, 0);
      return;
    }
    paramView.setPadding(0, 0, 0, 0);
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    afnk localafnk = (afnk)paramaeqi;
    MessageForPoke localMessageForPoke = (MessageForPoke)paramChatMessage;
    if (QLog.isColorLevel()) {
      QLog.d("GivingHeart", 2, "====> item num:" + paramInt1 + "  send:" + paramChatMessage.isSend());
    }
    if (aepi.jdField_b_of_type_Int > 0)
    {
      localMessageForPoke.setPlayed(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localMessageForPoke.mFrameState.c = true;
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(localMessageForPoke.uniseq));
      }
    }
    if (126 == localMessageForPoke.interactType)
    {
      localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
      localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((!localMessageForPoke.isSend()) && (localafnk.jdField_b_of_type_Int == f) && (localMessageForPoke.isPlayed) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(localMessageForPoke))) {
        localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((!localMessageForPoke.isPlayed) && (!localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()))
      {
        if (albi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).d != 1) {
          break label345;
        }
        paramInt1 = 0;
        if (paramInt1 != 0)
        {
          alaz.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "vas_poke", true);
          if (QLog.isColorLevel()) {
            QLog.i("GivingHeart.sprite", 2, "hide sprite (normal) in play.");
          }
        }
        afxl.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, localafnk, localMessageForPoke.subId, "bubble");
      }
    }
    label345:
    label378:
    label1019:
    do
    {
      Object localObject;
      do
      {
        return;
        paramInt1 = 1;
        break;
        if (localMessageForPoke.isSend())
        {
          jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          localObject = (RelativeLayout.LayoutParams)paramaeqi.a.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
          ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
          if (localMessageForPoke.interactType != 6) {
            break label584;
          }
          if (!localMessageForPoke.isSend()) {
            break label569;
          }
          paramBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
        }
        for (;;)
        {
          paramaeqi.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if ((PokeBigResHandler.jdField_a_of_type_Boolean) && (!(paramContext instanceof ChatHistoryActivity))) {
            break label601;
          }
          localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
          localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          paramChatMessage = (PokeBigResHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(117);
          if (paramChatMessage != null) {
            paramChatMessage.a(true);
          }
          if (!localMessageForPoke.isSend()) {
            break;
          }
          localMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          return;
          jdField_b_of_type_JavaUtilMap.put(Long.valueOf(localMessageForPoke.uniseq), localMessageForPoke);
          break label378;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, 0, 0);
          continue;
          paramBaseChatItemLayout.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "Strength holder = " + localafnk.jdField_a_of_type_Float);
        }
        if ((localMessageForPoke.interactType != 5) || (localafnk.jdField_a_of_type_Float != 2.0F)) {
          break label1019;
        }
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
        if (localMessageForPoke.isPlayed) {
          break label884;
        }
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362208)).a();
        if (SixCombolEffectView.jdField_a_of_type_Int != 0) {
          break label795;
        }
      } while (aepi.k);
      localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localafnk.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramChatMessage.setListener(this);
      aepi.jdField_a_of_type_Int += 1;
      paramChatMessage.a(localafnk, afxl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return;
      paramChatMessage = paramChatMessage.a();
      if (localafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage)
      {
        switch (SixCombolEffectView.jdField_a_of_type_Int)
        {
        default: 
          a(localafnk);
          return;
        }
        localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        localafnk.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      a(localafnk);
      return;
      if (SixCombolEffectView.jdField_a_of_type_Int > 0)
      {
        paramChatMessage = ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362208)).a().a();
        if ((paramChatMessage != null) && (localafnk.jdField_a_of_type_ComTencentMobileqqDataChatMessage == paramChatMessage))
        {
          switch (SixCombolEffectView.jdField_a_of_type_Int)
          {
          default: 
            a(localafnk);
            return;
          }
          localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localafnk.jdField_c_of_type_AndroidViewView.setVisibility(0);
          return;
        }
        a(localafnk);
        return;
      }
      a(localafnk);
      return;
      if (localMessageForPoke.interactType == 6)
      {
        b(localafnk, localMessageForPoke);
        return;
      }
      localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
      if ((localMessageForPoke.isPlayed) && (!localMessageForPoke.mFrameState.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GivingHeart", 2, "[status]has already played");
        }
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localafnk.jdField_b_of_type_Int == f) && (!localMessageForPoke.isSend()) && (localMessageForPoke.interactType != 126) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(localMessageForPoke))) {
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          return;
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      paramInt1 = 0;
      paramaeqi = a(localMessageForPoke.interactType);
      switch (localMessageForPoke.interactType)
      {
      default: 
        paramContext = afxh.jdField_a_of_type_JavaLangString + "/chuo_icon/chuo_icon_";
        if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType <= 0) || (localMessageForPoke.interactType > 6)) {
          if (localafnk.jdField_a_of_type_Float == 2.0F)
          {
            paramContext = new BitmapFactory.Options();
            paramContext.inSampleSize = 1;
            paramContext.inMutable = true;
          }
        }
        break;
      }
      for (;;)
      {
        try
        {
          paramContext = bdhj.a(PokeBigResHandler.b + "/chuo_caidan/chuo_caidan_" + "01.png", paramContext);
          paramContext = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramContext, afxh.a().a(), localMessageForPoke.mFrameState, paramaeqi, afxl.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
          a(paramContext);
          paramContext.a(1);
          if (!paramChatMessage.isSend())
          {
            if (localMessageForPoke.interactType == 5) {
              break label2377;
            }
            paramContext.b();
          }
          paramContext.h();
          if (!localMessageForPoke.mFrameState.jdField_a_of_type_Boolean) {
            break label2385;
          }
          localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
          localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramContext);
          paramContext.a(new afng(this, localafnk, localMessageForPoke));
          paramContext.d();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GivingHeart", 2, "[status]playing");
          return;
          paramContext = PokeBigResHandler.c + "/chuo_motion/chuo_motion_";
          paramInt1 = 35;
          break label1311;
          paramContext = PokeBigResHandler.c + "/bixin_motion/bixin_motion_";
          paramInt1 = 67;
          break label1311;
          paramContext = PokeBigResHandler.c + "/zan_motion/zan_motion_";
          paramInt1 = 20;
          break label1311;
          paramContext = PokeBigResHandler.c + "/xinsui_motion/xinsui_motion_";
          paramInt1 = 50;
          break label1311;
          if (localMessageForPoke.isSend())
          {
            paramContext = PokeBigResHandler.c + "/666send_motion/666send_motion_";
            paramInt1 = 57;
            break label1311;
          }
          paramContext = PokeBigResHandler.c + "/666receive_motion/666receive_motion_";
          continue;
          paramContext = afxh.jdField_a_of_type_JavaLangString + "/dazhao_icon/dazhao_icon_";
        }
        catch (OutOfMemoryError paramContext)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, paramContext.toString());
          }
          paramContext = null;
          continue;
        }
        paramContext = bdhj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130838528);
        paramContext = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramContext, afxh.a().a(), localMessageForPoke.mFrameState, paramaeqi, afxl.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
        b(paramContext);
        continue;
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inMutable = true;
        try
        {
          paramBaseChatItemLayout = bdhj.a(paramContext + "01.png", (BitmapFactory.Options)localObject);
          paramBaseChatItemLayout = new CustomFrameAnimationDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBaseChatItemLayout, afxh.a().a(), localMessageForPoke.mFrameState, paramaeqi, afxl.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
          paramBaseChatItemLayout.i();
          paramInt2 = 40;
          if (localMessageForPoke.interactType == 2) {
            paramInt2 = 30;
          }
          if ((localMessageForPoke.interactType == 4) && (localafnk.jdField_a_of_type_Float == 2.0F))
          {
            i = 0;
            for (;;)
            {
              if (i >= 20) {
                break label2125;
              }
              if (i + 1 >= 10) {
                break;
              }
              paramBaseChatItemLayout.a(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              i += 1;
            }
          }
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GivingHeart", 2, paramBaseChatItemLayout.toString());
            }
            paramBaseChatItemLayout = null;
            continue;
            paramBaseChatItemLayout.a(i, paramInt2, paramContext + (i + 1) + ".png");
          }
          int i = 20;
          while (i < paramInt1)
          {
            paramBaseChatItemLayout.a(i, paramInt2, paramContext + 21 + ".png");
            i += 1;
            continue;
            i = 0;
            if (i < paramInt1)
            {
              if (i + 1 < 10) {
                paramBaseChatItemLayout.a(i, paramInt2, paramContext + "0" + (i + 1) + ".png");
              }
              for (;;)
              {
                i += 1;
                break;
                paramBaseChatItemLayout.a(i, paramInt2, paramContext + (i + 1) + ".png");
              }
            }
          }
          paramContext = paramBaseChatItemLayout;
        }
        if (localMessageForPoke.mFrameState.jdField_a_of_type_Boolean)
        {
          try
          {
            paramContext = bdhj.a(paramBaseChatItemLayout.a(localMessageForPoke.mFrameState.jdField_a_of_type_Int).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
            paramBaseChatItemLayout.a(paramContext);
            paramContext = paramBaseChatItemLayout;
          }
          catch (OutOfMemoryError paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, paramContext, new Object[0]);
              }
              paramContext = null;
            }
          }
          catch (NullPointerException paramContext)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GivingHeart", 2, paramContext, new Object[0]);
              }
              paramContext = null;
            }
          }
          paramContext.a(2);
        }
      }
      if (localMessageForPoke.mFrameState.c)
      {
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.clearAnimation();
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
        localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if ((localafnk.jdField_b_of_type_Int == f) && (!localMessageForPoke.isSend()) && (!(this.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!b(localMessageForPoke))) {
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        for (;;)
        {
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
          localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("GivingHeart", 2, "[status]played");
          }
          if (!localMessageForPoke.isPlayed) {
            localMessageForPoke.setPlayed(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.containsKey(Long.valueOf(localMessageForPoke.uniseq))) {
            break;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a.remove(Long.valueOf(localMessageForPoke.uniseq));
          return;
          localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    } while (aepi.k);
    label569:
    label584:
    label601:
    label884:
    aepi.jdField_a_of_type_Int += 1;
    label795:
    label1311:
    label2125:
    label2385:
    localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    label2377:
    localafnk.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    localafnk.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    localafnk.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    paramContext.a(new afnh(this, localafnk, localMessageForPoke));
    localafnk.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(paramContext);
    paramContext.c();
    a(localMessageForPoke.uniseq, localMessageForPoke);
    label2731:
    boolean bool2;
    if (localafnk.jdField_a_of_type_Float == 2.0F)
    {
      if (localMessageForPoke.interactType == 2)
      {
        afxh.a().a(1);
        afxh.a().a(2, 1500L, localMessageForPoke.isSend());
      }
    }
    else if ((localMessageForPoke.interactType == 1) || (localMessageForPoke.interactType == 0))
    {
      paramContext = (Activity)this.jdField_a_of_type_AndroidContentContext;
      bool2 = paramChatMessage.isSend();
      if (localafnk.jdField_a_of_type_Float != 2.0F) {
        break label2896;
      }
    }
    label2896:
    for (boolean bool1 = true;; bool1 = false)
    {
      a(paramContext, bool2, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("GivingHeart", 2, "[status]start to play duobleHit:" + localMessageForPoke.doubleHitState + " type:" + localMessageForPoke.msgtype);
      return;
      if (localMessageForPoke.interactType == 3)
      {
        afxh.a().a(4);
        afxh.a().a(5, 700L);
        break label2731;
      }
      if (localMessageForPoke.interactType != 4) {
        break label2731;
      }
      afxh.a().a(13);
      afxh.a().a(14, 800L);
      break label2731;
    }
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    paramView = (aeqz)aepi.a(paramView);
    if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPoke)) && (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 0)) {
      a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, localbdpi);
    }
    acjm.a(localbdpi, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmy
 * JD-Core Version:    0.7.0.1
 */