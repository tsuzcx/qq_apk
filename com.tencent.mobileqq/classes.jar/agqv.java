import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class agqv
  extends afor
  implements axkk
{
  private float jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agqw(this);
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private View.OnClickListener b = new agqx(this);
  
  public agqv(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  @NonNull
  private Drawable a(String paramString)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165881));
    float f = 8.0F * this.jdField_a_of_type_Float;
    localGradientDrawable.setCornerRadius(f);
    localGradientDrawable.setShape(0);
    int i = AIOUtils.dp2px(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    localGradientDrawable.setSize(i, i);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localGradientDrawable;
    localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
    String str = null;
    try
    {
      paramString = URLDrawable.getDrawable(NearbyImgDownloader.convertURL(paramString), localURLDrawableOptions);
      str = paramString;
      paramString.setTag(bgxc.b(i, i, (int)f));
      str = paramString;
      paramString.setDecodeHandler(bgxc.c);
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramString));
        }
        paramString = str;
      }
    }
    if (paramString == null) {
      return localGradientDrawable;
    }
    return paramString;
  }
  
  private void a(long paramLong, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (paramInt != 1)
    {
      paramImageView1.setVisibility(8);
      localObject = (RelativeLayout.LayoutParams)paramImageView2.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      paramImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramImageView2.setImageDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLong)));
      bool = bdfk.b();
      if (!paramBoolean) {
        break label144;
      }
      if (!bool) {
        break label138;
      }
    }
    label138:
    for (paramInt = 2130844925;; paramInt = 2130844924)
    {
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      FaceDrawable localFaceDrawable = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLong));
      paramImageView1.setImageDrawable((Drawable)localObject);
      paramImageView2.setImageDrawable(localFaceDrawable);
      break;
    }
    label144:
    if (bool) {}
    for (paramInt = 2130844923;; paramInt = 2130844922)
    {
      paramImageView1.setBackgroundResource(paramInt);
      paramImageView2.setBackgroundResource(paramInt);
      return;
    }
  }
  
  private void a(View paramView, String paramString)
  {
    Object localObject2 = new JSONObject(paramString);
    int i = ((JSONObject)localObject2).optInt("type");
    String str1 = ((JSONObject)localObject2).optString("icon_url");
    paramString = ((JSONObject)localObject2).optString("jump_url");
    Object localObject1 = ((JSONObject)localObject2).optString("name");
    String str2 = ((JSONObject)localObject2).optString("sub_title");
    Object localObject3 = ((JSONObject)localObject2).optString("title");
    ((JSONObject)localObject2).optString("url");
    long l = ((JSONObject)localObject2).optLong("friend_uin");
    int j = ((JSONObject)localObject2).optInt("show_both_head");
    Object localObject4 = paramView.findViewById(2131369858);
    ((View)localObject4).getLayoutParams().width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
    Object localObject5 = (ImageView)((View)localObject4).findViewById(2131368777);
    ImageView localImageView = (ImageView)((View)localObject4).findViewById(2131368778);
    ((TextView)((View)localObject4).findViewById(2131380361)).setText((CharSequence)localObject3);
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    a(l, j, (ImageView)localObject5, localImageView, bool);
    if ((i == 1) || (i == 500) || (i == 400) || (i == 401) || (i == 404) || (i == 402) || (i == 403))
    {
      paramView = ((ViewStub)paramView.findViewById(2131381213)).inflate();
      localObject2 = (TextView)paramView.findViewById(2131380358);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramView.setTag(paramString);
      paramView.setOnClickListener(this.b);
      a(bool, (TextView)localObject2);
      return;
    }
    if ((i == 100) || (i == 200) || (i == 300) || (i == 201))
    {
      paramView = ((ViewStub)paramView.findViewById(2131381211)).inflate();
      localObject3 = (URLImageView)paramView.findViewById(2131368779);
      localObject4 = (TextView)paramView.findViewById(2131380360);
      localObject5 = (TextView)paramView.findViewById(2131380359);
      ((TextView)localObject4).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(str2))
      {
        ((TextView)localObject5).setVisibility(8);
        ((URLImageView)localObject3).setImageDrawable(a(str1));
        if (i != 100) {
          break label489;
        }
        localObject1 = (ImageView)paramView.findViewById(2131368782);
        ((ImageView)localObject1).setVisibility(0);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        ((URLImageView)localObject3).setTag(localObject2);
        ((ImageView)localObject1).setTag(localObject2);
        ((URLImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ImageView)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        paramView.setTag(paramString);
        a(bool, (TextView)localObject4);
        return;
        ((TextView)localObject5).setText(str2);
        break;
        label489:
        if ((i == 201) || (i == 200)) {
          paramView.setOnClickListener(this.b);
        }
      }
    }
    ((TextView)((ViewStub)paramView.findViewById(2131381213)).inflate().findViewById(2131380358)).setText(anvx.a(2131701720));
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void a(boolean paramBoolean, TextView paramTextView)
  {
    if (!paramBoolean)
    {
      paramTextView.setTextColor(-14277082);
      return;
    }
    paramTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
  }
  
  protected afos a()
  {
    return new agqy();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramafos = paramView;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561060, null);
      if (QLog.isColorLevel()) {
        QLog.i("CommonHobbyForAIOShowItemBuilder", 0, String.format("bindData2View msg is: %s", new Object[] { paramMessageRecord.msg }));
      }
    }
    try
    {
      a(paramafos, paramMessageRecord.msg);
      this.jdField_a_of_type_Long = paramMessageRecord.uniseq;
      return paramafos;
    }
    catch (JSONException paramView)
    {
      for (;;)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView JSONException", paramView);
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e("CommonHobbyForAIOShowItemBuilder", 1, "getItemView Exception", paramView);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public String getToken()
  {
    return QQPlayerService.a(1, String.valueOf(this.jdField_a_of_type_Long));
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localImageView == null);
    Resources localResources = localImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localImageView.post(new CommonHobbyForAIOShowItemBuilder.3(this, localImageView));
      localImageView.setContentDescription(localResources.getString(2131690231));
      return;
    }
    localImageView.post(new CommonHobbyForAIOShowItemBuilder.4(this, localImageView));
    localImageView.setContentDescription(localResources.getString(2131690229));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqv
 * JD-Core Version:    0.7.0.1
 */