import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.getItemView..inlined.let.lambda.1;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder;", "Lcom/tencent/mobileqq/activity/aio/AbstractChatItemBuilder;", "Lcom/tencent/mobileqq/app/face/FaceDecoder$DecodeTaskCompletionListener;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "adapter", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "info", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/widget/BaseAdapter;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V", "mAnonymousObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "mAvatarMap", "Ljava/util/HashMap;", "", "Landroid/widget/ImageView;", "Lkotlin/collections/HashMap;", "mCurrentQuestId", "mDecoder", "Lcom/tencent/mobileqq/app/face/FaceDecoder;", "mHolder", "Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$Holder;", "mLatestAnonymousInfo", "Lcom/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$LatestAnonymousInfo;", "mMsg", "Lcom/tencent/mobileqq/data/MessageForTofuAskAnonymously;", "randomHeadBgIndex", "", "bindEventListener", "", "anonymousInfo", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/bean/AnonymousQuestion;", "holder", "destroy", "getFaceBitmap", "Landroid/graphics/Bitmap;", "uin", "headView", "getItemView", "Landroid/view/View;", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "viewHolder", "Lcom/tencent/mobileqq/activity/aio/AbstractChatItemBuilder$ViewHolder;", "convertView", "parent", "Landroid/widget/LinearLayout;", "longClick", "Lcom/tencent/mobileqq/activity/aio/OnLongClickAndTouchListener;", "getMenuItem", "", "Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuItem;", "view", "(Landroid/view/View;)[Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuItem;", "initHolder", "newHolder", "onDecodeTaskCompleted", "remainingTasks", "type", "avatar", "setLikeUi", "mPraised", "", "tvLike", "Landroid/widget/TextView;", "ivLike", "totalPraiseCount", "", "shouldUseLatestInfo", "questId", "updateMsgInfo", "updateMsgView", "Companion", "Holder", "LatestAnonymousInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ahjx
  extends afor
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public static final ahjy a;
  private int jdField_a_of_type_Int = (int)(Math.random() * azzm.jdField_a_of_type_ArrayOfInt.length);
  private ahjz jdField_a_of_type_Ahjz = new ahjz();
  private ahka jdField_a_of_type_Ahka = new ahka(false, null, 0L, false, 0L, 0L, 63, null);
  private final azzo jdField_a_of_type_Azzo = (azzo)new ahkc(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private MessageForTofuAskAnonymously jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously = new MessageForTofuAskAnonymously();
  private String jdField_a_of_type_JavaLangString = "";
  private final HashMap<String, ImageView> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_Ahjy = new ahjy(null);
  }
  
  public ahjx(@NotNull QQAppInterface paramQQAppInterface, @NotNull BaseAdapter paramBaseAdapter, @NotNull Context paramContext, @NotNull SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, (AppInterface)paramQQAppInterface);
    paramBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
    if (paramBaseAdapter == null) {
      Intrinsics.throwNpe();
    }
    paramBaseAdapter.setDecodeTaskCompletionListener((FaceDecoder.DecodeTaskCompletionListener)this);
    paramQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_Azzo);
  }
  
  private final View a(View paramView, ahjz paramahjz)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558894, null);
      if (paramahjz != null) {
        paramahjz.a((ViewGroup)paramView.findViewById(2131374298));
      }
      if (paramahjz != null) {
        paramahjz.b((ViewGroup)paramView.findViewById(2131374303));
      }
      if (paramahjz != null) {
        paramahjz.c((ViewGroup)paramView.findViewById(2131374297));
      }
      if (paramahjz != null) {
        paramahjz.a((ImageView)paramView.findViewById(2131374301));
      }
      if (paramahjz != null) {
        paramahjz.b((ImageView)paramView.findViewById(2131374302));
      }
      if (paramahjz != null) {
        paramahjz.c((ImageView)paramView.findViewById(2131374295));
      }
      if (paramahjz != null) {
        paramahjz.d((ImageView)paramView.findViewById(2131374294));
      }
      if (paramahjz != null) {
        paramahjz.e((ImageView)paramView.findViewById(2131374296));
      }
      if (paramahjz != null) {
        paramahjz.a((TextView)paramView.findViewById(2131374309));
      }
      if (paramahjz != null) {
        paramahjz.d((ViewGroup)paramView.findViewById(2131374299));
      }
      if (paramahjz != null) {
        paramahjz.g((ImageView)paramView.findViewById(2131374289));
      }
      if (paramahjz != null) {
        paramahjz.f((ImageView)paramView.findViewById(2131374290));
      }
      if (paramahjz != null) {
        paramahjz.b((TextView)paramView.findViewById(2131374305));
      }
      if (paramahjz != null) {
        paramahjz.h((ImageView)paramView.findViewById(2131374291));
      }
      if (paramahjz != null) {
        paramahjz.c((TextView)paramView.findViewById(2131374306));
      }
      if (paramahjz != null) {
        paramahjz.d((TextView)paramView.findViewById(2131374308));
      }
      if (paramahjz != null) {
        paramahjz.i((ImageView)paramView.findViewById(2131374293));
      }
      if (paramahjz != null) {
        paramahjz.e((TextView)paramView.findViewById(2131374307));
      }
      localView = paramView;
      if (paramahjz != null)
      {
        paramahjz.j((ImageView)paramView.findViewById(2131374292));
        localView = paramView;
      }
    }
    return localView;
  }
  
  private final void a(azzl paramazzl, ahjz paramahjz)
  {
    paramazzl = (View.OnClickListener)new ahkb(this, paramazzl, paramahjz);
    Object localObject = paramahjz.d();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.i();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.e();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.j();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.c();
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.h();
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(paramazzl);
    }
    localObject = paramahjz.e();
    if (localObject != null) {
      ((TextView)localObject).setOnTouchListener((View.OnTouchListener)mvk.a);
    }
    localObject = paramahjz.j();
    if (localObject != null) {
      ((ImageView)localObject).setOnTouchListener((View.OnTouchListener)mvk.a);
    }
    paramahjz = paramahjz.a();
    if (paramahjz != null) {
      paramahjz.setOnClickListener(paramazzl);
    }
  }
  
  private final void a(boolean paramBoolean, TextView paramTextView, ImageView paramImageView, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
    localObject1 = ((Context)localObject1).getResources().getDrawable(2130845782);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…e_achivement_like_normal)");
    int i = Color.parseColor("#FFB0B3BF");
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext");
      localObject1 = ((Context)localObject1).getResources().getDrawable(2130845711);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mContext.resources.getDr…sConstant.likeIvDrawable)");
      i = azzm.jdField_a_of_type_Int;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        Object localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = new Object[1];
        localObject2[0] = Boolean.valueOf(paramBoolean);
        localObject2 = String.format("setLikeUi() mPraised=%b", Arrays.copyOf((Object[])localObject2, localObject2.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
        QLog.d("TofuAskAnonymouslyItemBuilder", 2, (String)localObject2);
      }
      paramTextView.setText((CharSequence)azsy.a((int)paramLong));
      paramTextView.setTextColor(i);
      paramImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
  }
  
  private final boolean a(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return false;
    }
    if ((this.jdField_a_of_type_Ahka.a()) && (StringsKt.equals$default(paramString, this.jdField_a_of_type_Ahka.a(), false, 2, null))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private final void b()
  {
    if (a(this.jdField_a_of_type_JavaLangString))
    {
      azzl localazzl = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localazzl != null) {
        localazzl.jdField_b_of_type_Boolean = this.jdField_a_of_type_Ahka.b();
      }
      localazzl = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localazzl != null) {
        localazzl.e = this.jdField_a_of_type_Ahka.a();
      }
      localazzl = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localazzl != null) {
        localazzl.f = this.jdField_a_of_type_Ahka.b();
      }
      localazzl = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
      if (localazzl != null) {
        localazzl.g = this.jdField_a_of_type_Ahka.c();
      }
    }
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
    TextView localTextView;
    Object localObject2;
    Object[] arrayOfObject;
    if (localObject1 != null)
    {
      boolean bool = ((azzl)localObject1).jdField_b_of_type_Boolean;
      localTextView = this.jdField_a_of_type_Ahjz.d();
      if (localTextView == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = this.jdField_a_of_type_Ahjz.i();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      a(bool, localTextView, (ImageView)localObject2, ((azzl)localObject1).e);
      localTextView = this.jdField_a_of_type_Ahjz.e();
      if (localTextView != null) {
        localTextView.setText((CharSequence)azsy.a((int)((azzl)localObject1).f));
      }
      localTextView = this.jdField_a_of_type_Ahjz.c();
      if (localTextView != null)
      {
        localObject2 = StringCompanionObject.INSTANCE;
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getString(2131698280);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "mContext.getString(R.str…q_anonymous_browse_count)");
        arrayOfObject = new Object[1];
        if (((azzl)localObject1).g <= 0L) {
          break label184;
        }
      }
    }
    label184:
    for (localObject1 = azsy.a((int)((azzl)localObject1).g);; localObject1 = Long.valueOf(((azzl)localObject1).g))
    {
      arrayOfObject[0] = localObject1;
      localObject1 = String.format((String)localObject2, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject1);
      return;
    }
  }
  
  @NotNull
  protected afos a()
  {
    return (afos)new ahjz();
  }
  
  @Nullable
  public final Bitmap a(@Nullable String paramString, @Nullable ImageView paramImageView)
  {
    Object localObject;
    if ((TextUtils.isEmpty((CharSequence)paramString)) || (paramImageView == null)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        Bitmap localBitmap = ((FaceDecoder)localObject).getBitmapFromCache(1, paramString);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          if (!((FaceDecoder)localObject).isPausing())
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            ((FaceDecoder)localObject).requestDecodeFace(paramString, 200, true);
            localObject = (Map)this.jdField_a_of_type_JavaUtilHashMap;
            if (paramString == null) {
              Intrinsics.throwNpe();
            }
            ((Map)localObject).put(paramString, paramImageView);
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    return bheg.a();
  }
  
  @Nullable
  protected View a(@Nullable MessageRecord paramMessageRecord, @Nullable afos paramafos, @Nullable View paramView, @Nullable LinearLayout paramLinearLayout, @Nullable aftk paramaftk)
  {
    if (paramMessageRecord == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.data.MessageForTofuAskAnonymously");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously = ((MessageForTofuAskAnonymously)paramMessageRecord);
    if (paramafos == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.item.TofuAskAnonymouslyItemBuilder.Holder");
    }
    this.jdField_a_of_type_Ahjz = ((ahjz)paramafos);
    paramafos = a(paramView, this.jdField_a_of_type_Ahjz);
    this.jdField_a_of_type_Ahjz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.uniseq);
    paramMessageRecord = this.jdField_a_of_type_Ahjz;
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.frienduin;
    Intrinsics.checkExpressionValueIsNotNull(paramView, "mMsg.frienduin");
    paramMessageRecord.a(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuAskAnonymously.getAskAnonymouslyQuestion();
    if (paramView != null)
    {
      paramView.jdField_c_of_type_Long = Long.parseLong(this.jdField_a_of_type_Ahjz.a());
      paramMessageRecord = paramView.jdField_a_of_type_JavaLangString;
      Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "it.mId");
      this.jdField_a_of_type_JavaLangString = paramMessageRecord;
      b();
      paramMessageRecord = this.jdField_a_of_type_Ahjz.a();
      if (paramMessageRecord != null) {
        paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.jdField_b_of_type_JavaLangString), 3, 16));
      }
      paramMessageRecord = this.jdField_a_of_type_Ahjz.b();
      if (paramMessageRecord != null) {
        paramMessageRecord.setText((CharSequence)new QQText((CharSequence)QzoneEmotionUtils.emCodesToQQcodes(paramView.jdField_c_of_type_JavaLangString), 3, 16));
      }
      paramMessageRecord = this.jdField_a_of_type_Ahjz.g();
      if (paramMessageRecord != null) {
        paramMessageRecord.setImageBitmap(a(this.jdField_a_of_type_Ahjz.a(), this.jdField_a_of_type_Ahjz.g()));
      }
      paramLinearLayout = this.jdField_a_of_type_Ahjz.c();
      if (paramLinearLayout != null)
      {
        paramMessageRecord = StringCompanionObject.INSTANCE;
        paramaftk = this.jdField_a_of_type_AndroidContentContext.getString(2131698280);
        Intrinsics.checkExpressionValueIsNotNull(paramaftk, "mContext.getString(R.str…q_anonymous_browse_count)");
        Object[] arrayOfObject = new Object[1];
        if (paramView.g > 0L)
        {
          paramMessageRecord = azsy.a((int)paramView.g);
          arrayOfObject[0] = paramMessageRecord;
          paramMessageRecord = String.format(paramaftk, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
          Intrinsics.checkExpressionValueIsNotNull(paramMessageRecord, "java.lang.String.format(format, *args)");
          paramLinearLayout.setText((CharSequence)paramMessageRecord);
        }
      }
      else
      {
        if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)))
        {
          paramMessageRecord = this.jdField_a_of_type_Ahjz.b();
          if (paramMessageRecord != null) {
            paramMessageRecord.setBackgroundResource(2130844812);
          }
          paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
          if (paramMessageRecord != null) {
            paramMessageRecord.setBackgroundResource(2130844811);
          }
        }
        if (ThemeUtil.isInNightMode((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          paramMessageRecord = this.jdField_a_of_type_Ahjz.b();
          if (paramMessageRecord != null) {
            paramMessageRecord.setBackgroundResource(2130845716);
          }
          paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
          if (paramMessageRecord != null) {
            paramMessageRecord.setBackgroundResource(2130845705);
          }
          paramMessageRecord = this.jdField_a_of_type_Ahjz.a();
          if (paramMessageRecord != null) {
            paramMessageRecord.setImageResource(2130844785);
          }
          paramMessageRecord = this.jdField_a_of_type_Ahjz.b();
          if (paramMessageRecord != null) {
            paramMessageRecord.setImageResource(2130844786);
          }
        }
        if (!bdfk.b()) {
          break label759;
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.d();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845722);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845719);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.e();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845721);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.f();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845707);
        }
      }
      for (;;)
      {
        int i = this.jdField_a_of_type_Int;
        int j = azzm.jdField_a_of_type_ArrayOfInt.length;
        paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
        if (paramMessageRecord != null) {
          paramMessageRecord.clearColorFilter();
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
        if (paramMessageRecord != null) {
          paramMessageRecord.setColorFilter(azzm.jdField_a_of_type_ArrayOfInt[(i % j)]);
        }
        boolean bool = paramView.jdField_b_of_type_Boolean;
        paramMessageRecord = this.jdField_a_of_type_Ahjz.d();
        if (paramMessageRecord == null) {
          Intrinsics.throwNpe();
        }
        paramLinearLayout = this.jdField_a_of_type_Ahjz.i();
        if (paramLinearLayout == null) {
          Intrinsics.throwNpe();
        }
        a(bool, paramMessageRecord, paramLinearLayout, paramView.e);
        paramMessageRecord = this.jdField_a_of_type_Ahjz.e();
        if (paramMessageRecord != null) {
          paramMessageRecord.setText((CharSequence)azsy.a((int)paramView.f));
        }
        a(paramView, this.jdField_a_of_type_Ahjz);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER);
        if (paramMessageRecord != null) {
          break label838;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler");
        paramMessageRecord = Long.valueOf(paramView.g);
        break;
        label759:
        paramMessageRecord = this.jdField_a_of_type_Ahjz.d();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845717);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.c();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845718);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.e();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845720);
        }
        paramMessageRecord = this.jdField_a_of_type_Ahjz.f();
        if (paramMessageRecord != null) {
          paramMessageRecord.setImageResource(2130845706);
        }
      }
      label838:
      paramMessageRecord = (azzn)paramMessageRecord;
      if (!this.jdField_a_of_type_Ahjz.a())
      {
        this.jdField_a_of_type_Ahjz.a(true);
        ThreadManagerV2.excute((Runnable)new TofuAskAnonymouslyItemBuilder.getItemView..inlined.let.lambda.1(this), 128, null, true);
      }
    }
    try
    {
      paramMessageRecord.b(paramView);
      bdla.b(null, "dc00898", "", this.jdField_a_of_type_Ahjz.a(), "0X800B5C0", "0X800B5C0", 0, 0, "", "", "", "");
      return paramafos;
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        QLog.e("TofuAskAnonymouslyItemBuilder", 1, "getLatestAnonymousInfo exception " + paramMessageRecord);
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      FaceDecoder localFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
      if (localFaceDecoder == null) {
        Intrinsics.throwNpe();
      }
      localFaceDecoder.destory();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_Azzo);
  }
  
  @NotNull
  public bhjs[] a(@Nullable View paramView)
  {
    return new bhjs[0];
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    paramString = (ImageView)((Map)this.jdField_a_of_type_JavaUtilHashMap).get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjx
 * JD-Core Version:    0.7.0.1
 */