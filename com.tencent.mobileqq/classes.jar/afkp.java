import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.CommonHobbyForAIOShowItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;

public class afkp
  extends aepl
  implements aurc
{
  private float jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
  private long jdField_a_of_type_Long;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afkq(this);
  private WeakReference<ImageView> jdField_a_of_type_JavaLangRefWeakReference;
  private View.OnClickListener b = new afkr(this);
  
  public afkp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private void a(View paramView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, "bindData2View msg is: " + paramString);
    }
    JSONObject localJSONObject;
    int j;
    String str;
    Object localObject1;
    Object localObject5;
    int i;
    boolean bool1;
    boolean bool2;
    for (;;)
    {
      long l;
      label304:
      try
      {
        localJSONObject = new JSONObject(paramString);
        j = localJSONObject.optInt("type");
        paramString = localJSONObject.optString("icon_url");
        str = localJSONObject.optString("jump_url");
        localObject1 = localJSONObject.optString("name");
        localObject5 = localJSONObject.optString("sub_title");
        localObject4 = localJSONObject.optString("title");
        localJSONObject.optString("url");
        l = localJSONObject.optLong("friend_uin");
        i = localJSONObject.optInt("show_both_head");
        localObject6 = paramView.findViewById(2131369215);
        ((View)localObject6).getLayoutParams().width = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels;
        localObject2 = (ImageView)((View)localObject6).findViewById(2131368193);
        localObject3 = (ImageView)((View)localObject6).findViewById(2131368194);
        ((TextView)((View)localObject6).findViewById(2131379190)).setText((CharSequence)localObject4);
        bool1 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        if (i == 1) {
          break label377;
        }
        ((ImageView)localObject2).setVisibility(8);
        localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).leftMargin = 0;
        ((RelativeLayout.LayoutParams)localObject4).addRule(14);
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((ImageView)localObject3).setImageDrawable(bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(l)));
        bool2 = azmk.b();
        if (!bool1) {
          break label947;
        }
        if (!bool2) {
          break label939;
        }
        i = 2130844561;
        ((ImageView)localObject2).setBackgroundResource(i);
        ((ImageView)localObject3).setBackgroundResource(i);
      }
      catch (JSONException paramView) {}
      paramView = ((ViewStub)paramView.findViewById(2131380002)).inflate();
      paramString = (TextView)paramView.findViewById(2131379187);
      paramString.setText((CharSequence)localObject1);
      paramView.setTag(str);
      paramView.setOnClickListener(this.b);
      if (bool1) {
        break label443;
      }
      paramString.setTextColor(-14277082);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramView));
      return;
      label377:
      localObject4 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      Object localObject6 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(l));
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject4);
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject6);
    }
    label426:
    ((ImageView)localObject2).setBackgroundResource(i);
    ((ImageView)localObject3).setBackgroundResource(i);
    break label882;
    label443:
    paramString.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910));
    return;
    label460:
    Object localObject2 = ((ViewStub)paramView.findViewById(2131380000)).inflate();
    Object localObject3 = (URLImageView)((View)localObject2).findViewById(2131368195);
    Object localObject4 = (TextView)((View)localObject2).findViewById(2131379189);
    paramView = (TextView)((View)localObject2).findViewById(2131379188);
    ((TextView)localObject4).setText((CharSequence)localObject1);
    label533:
    float f;
    if (TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramView.setVisibility(8);
      localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165804));
      f = 8.0F * this.jdField_a_of_type_Float;
      ((GradientDrawable)localObject1).setCornerRadius(f);
      ((GradientDrawable)localObject1).setShape(0);
      i = aepi.a(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((GradientDrawable)localObject1).setSize(i, i);
      localObject5 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = i;
      ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable;
      paramView = null;
    }
    label834:
    label1002:
    for (;;)
    {
      try
      {
        paramString = URLDrawable.getDrawable(bauz.a(paramString), (URLDrawable.URLDrawableOptions)localObject5);
        paramView = paramString;
        paramString.setTag(bcyz.b(i, i, (int)f));
        paramView = paramString;
        paramString.setDecodeHandler(bcyz.c);
        paramView = paramString;
        paramString = paramView;
        if (paramView == null) {
          paramString = (String)localObject1;
        }
        ((URLImageView)localObject3).setImageDrawable(paramString);
        if (j == 100)
        {
          paramView = (ImageView)((View)localObject2).findViewById(2131368198);
          paramView.setVisibility(0);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
          ((URLImageView)localObject3).setTag(localJSONObject);
          paramView.setTag(localJSONObject);
          ((URLImageView)localObject3).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
        ((View)localObject2).setTag(str);
        if ((j == 201) || (j == 200)) {
          ((View)localObject2).setOnClickListener(this.b);
        }
        if (bool1) {
          break label834;
        }
        ((TextView)localObject4).setTextColor(-14277082);
        return;
      }
      catch (MalformedURLException paramString)
      {
        if (!QLog.isColorLevel()) {
          break label1002;
        }
      }
      paramView.setText((CharSequence)localObject5);
      break label533;
      QLog.i("CommonHobbyForAIOShowItemBuilder", 0, Log.getStackTraceString(paramString));
      break label1002;
      ((TextView)localObject4).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910));
      return;
      label882:
      do
      {
        ((TextView)((ViewStub)paramView.findViewById(2131380002)).inflate().findViewById(2131379187)).setText(alud.a(2131702607));
        return;
        if ((j == 1) || (j == 500) || (j == 400) || (j == 401) || (j == 404) || (j == 402)) {
          break label304;
        }
        if (j == 403)
        {
          break label304;
          i = 2130844560;
          break;
          if (bool2)
          {
            i = 2130844559;
            break label426;
          }
          i = 2130844558;
          break label426;
        }
        if ((j == 100) || (j == 200) || (j == 300)) {
          break label460;
        }
      } while (j != 201);
      break label460;
    }
  }
  
  private void a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  protected aepm a()
  {
    return new afks();
  }
  
  protected View a(MessageRecord paramMessageRecord, aepm paramaepm, View paramView, LinearLayout paramLinearLayout, aetk paramaetk)
  {
    paramaepm = paramView;
    if (paramView == null)
    {
      paramaepm = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560883, null);
      a(paramaepm, paramMessageRecord.msg);
    }
    this.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    return paramaepm;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bdpk[] a(View paramView)
  {
    return new bdpk[0];
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
      localImageView.setContentDescription(localResources.getString(2131690326));
      return;
    }
    localImageView.post(new CommonHobbyForAIOShowItemBuilder.4(this, localImageView));
    localImageView.setContentDescription(localResources.getString(2131690324));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkp
 * JD-Core Version:    0.7.0.1
 */