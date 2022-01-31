import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloImageShareLayout;
import com.tencent.mobileqq.apollo.store.ApolloViewController.2;
import com.tencent.mobileqq.apollo.store.ApolloViewController.3;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ajig
  implements aivc, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener, TouchWebView.OnScrollChangedListener
{
  public float a;
  int jdField_a_of_type_Int = 1;
  private aiva jdField_a_of_type_Aiva;
  private ajik jdField_a_of_type_Ajik;
  private ajil jdField_a_of_type_Ajil;
  private ajip jdField_a_of_type_Ajip;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  Button jdField_a_of_type_AndroidWidgetButton;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfob jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  BarrageView jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView;
  private ApolloImageShareLayout jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout;
  private ApolloWebAvatarParam jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam;
  String jdField_a_of_type_JavaLangString;
  private WeakReference<aivc> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<String, ApolloWebAvatarParam> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private aiva jdField_b_of_type_Aiva;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ApolloTextureView jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  public int c;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 2.0F;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float = 1.0F;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  
  public ajig(RelativeLayout paramRelativeLayout, ajip paramajip)
  {
    this.jdField_a_of_type_Ajip = paramajip;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null) {
      throw new RuntimeException("rootView must not null");
    }
    paramRelativeLayout = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(paramRelativeLayout, null);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLongPressTimeout(350);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setClickable(false);
    paramajip = new RelativeLayout.LayoutParams(100, 100);
    this.jdField_a_of_type_Aiva = new ajih(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_a_of_type_Aiva);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramajip);
    this.jdField_e_of_type_Float = (ajwc.a() / 16.0F);
    if (this.jdField_e_of_type_Float != 0.0F) {
      this.jdField_d_of_type_Float = (bbdh.a() / this.jdField_e_of_type_Float);
    }
    if (this.jdField_d_of_type_Float == 0.0F) {
      this.jdField_d_of_type_Float = bbdh.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839140);
    this.jdField_d_of_type_Int = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
    this.jdField_e_of_type_Int = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(9, -1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(10, -1);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Ajil = new ajil();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramRelativeLayout);
    paramajip = new ImageView(paramRelativeLayout);
    paramajip.setImageResource(2130839140);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(paramajip, localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-8366104);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
    paramRelativeLayout = new FrameLayout.LayoutParams(-1, -1);
    paramRelativeLayout.leftMargin = ApolloUtil.a(15.0F, this.jdField_d_of_type_Float);
    paramRelativeLayout.rightMargin = ApolloUtil.a(15.0F, this.jdField_d_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, paramRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130838441);
    paramRelativeLayout = new RelativeLayout.LayoutParams(ApolloUtil.a(81.0F, this.jdField_d_of_type_Float), ApolloUtil.a(58.0F, this.jdField_d_of_type_Float));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, paramRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    if (this.jdField_e_of_type_Float != 0.0F) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F / this.jdField_e_of_type_Float);
    }
    a();
  }
  
  private MediaPlayer a()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setOnPreparedListener(this);
    localMediaPlayer.setOnErrorListener(this);
    return localMediaPlayer;
  }
  
  public static String a(String paramString)
  {
    return "{\"result\":1,\"msg\":\"" + paramString + "\"}";
  }
  
  private String b(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return a("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return a("no apolloId");
    }
    if (!ajki.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700577), 0).a();
      return a("dresses is not download!");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam = paramApolloWebAvatarParam;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
        this.j = false;
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        if ((paramApolloWebAvatarParam.tapRectWidth > 0) && (paramApolloWebAvatarParam.tapRectHeight > 0))
        {
          float f1 = paramApolloWebAvatarParam.tapRectX * this.jdField_d_of_type_Float;
          float f2 = paramApolloWebAvatarParam.tapRectY * this.jdField_d_of_type_Float;
          ??? = new RectF(f1, f2, paramApolloWebAvatarParam.tapRectWidth * this.jdField_d_of_type_Float + f1, paramApolloWebAvatarParam.tapRectHeight * this.jdField_d_of_type_Float + f2);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTouchableRect((RectF)???);
          ??? = new RelativeLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.bringToFront();
          this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.type;
          this.jdField_g_of_type_Boolean = paramBoolean;
          this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(23, 500L);
          if (Float.compare(0.0F, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate) == 0) {
            this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate = 0.2F;
          }
          this.jdField_a_of_type_Float = ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate);
          this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * 330.0F / this.jdField_d_of_type_Float);
          ??? = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
          ((RelativeLayout.LayoutParams)???).addRule(10);
          ((RelativeLayout.LayoutParams)???).addRule(11);
          ((RelativeLayout.LayoutParams)???).width = ApolloUtil.a(81.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F, this.jdField_d_of_type_Float);
          ((RelativeLayout.LayoutParams)???).height = ApolloUtil.a(58.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F, this.jdField_d_of_type_Float);
          ((RelativeLayout.LayoutParams)???).topMargin = ((int)(paramApolloWebAvatarParam.y * this.jdField_d_of_type_Float - (float)bbdh.j() * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate));
          ((RelativeLayout.LayoutParams)???).rightMargin = ((int)((float)bbdh.i() - this.jdField_d_of_type_Float * paramApolloWebAvatarParam.x - ((RelativeLayout.LayoutParams)???).width - ApolloUtil.a(68.0F, this.jdField_d_of_type_Float) * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F));
          this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(12.0F * this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.rate / 0.289F);
          f();
          this.jdField_a_of_type_Int = 1;
          paramApolloWebAvatarParam = Message.obtain();
          paramApolloWebAvatarParam.getData().putInt("key_operation", 1);
          paramApolloWebAvatarParam.what = 18;
          this.jdField_a_of_type_Bfob.sendMessage(paramApolloWebAvatarParam);
          a(false, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
          a(false);
          this.jdField_d_of_type_JavaLangString = null;
          this.jdField_f_of_type_Boolean = false;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
          }
          return b("initAvatar成功");
        }
      }
      ??? = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y * this.jdField_d_of_type_Float));
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTouchableRect(null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setLayoutParams((ViewGroup.LayoutParams)???);
    }
  }
  
  public static String b(String paramString)
  {
    return "{\"result\":0,\"msg\":\"" + paramString + "\"}";
  }
  
  private void e()
  {
    int i1 = 0;
    if (this.jdField_h_of_type_Boolean) {}
    int k;
    label136:
    int n;
    label155:
    label356:
    label361:
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) {
          if (this.jdField_i_of_type_Int == 0) {
            try
            {
              String str = ApolloUtil.g(this.jdField_c_of_type_Int);
              if (bbdx.a(str))
              {
                if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
                  this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
                }
                if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
                  this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
                }
                if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1))
                {
                  k = 1;
                  if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2) != 0)) {
                    break label356;
                  }
                  m = 1;
                  if ((this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() != 0)) {
                    break label361;
                  }
                  n = 1;
                  if ((k != 0) || (m != 0) || (n == 0) || (!aixk.a())) {
                    continue;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ApolloViewController", 2, "[playActionSound] " + this.jdField_c_of_type_Int + " " + str);
                  }
                  try
                  {
                    bbcf.a(BaseApplicationImpl.getContext(), true);
                    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
                      this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
                    }
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(str);
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
                    return;
                  }
                  catch (Throwable localThrowable1)
                  {
                    QLog.e("ApolloViewController", 1, localThrowable1.getMessage());
                    return;
                  }
                  if (this.jdField_i_of_type_Int <= 0) {
                    break;
                  }
                }
              }
            }
            catch (Throwable localThrowable2)
            {
              QLog.e("ApolloViewController", 1, localThrowable2, new Object[] { "[playActionSound] exception" });
            }
          } else {
            for (;;)
            {
              if (!new File(ajhu.b(this.jdField_i_of_type_Int)).exists()) {
                break label395;
              }
              this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(24, (int)(this.jdField_f_of_type_Float * 1000.0F));
              return;
              k = 0;
              break;
              m = 0;
              break label136;
              n = 0;
              break label155;
              QLog.e("ApolloViewController", 1, "[playActionSound] not found file for " + localThrowable2);
            }
          }
        }
      }
      if ((!TextUtils.isEmpty(ajkj.a().jdField_a_of_type_JavaLangString)) && ("interactive".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab)))
      {
        this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(24, 0L);
        return;
      }
    } while (!this.jdField_i_of_type_Boolean);
    label395:
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1))
    {
      k = 1;
      label533:
      if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2) != 0)) {
        break label692;
      }
    }
    label692:
    for (int m = 1;; m = 0)
    {
      n = i1;
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        n = i1;
        if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() == 0) {
          n = 1;
        }
      }
      if ((!ajhu.a(this.jdField_c_of_type_Int)) || (m != 0) || (k != 0) || (n == 0)) {
        break;
      }
      try
      {
        bbcf.a(BaseApplicationImpl.getContext(), true);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(ajms.jdField_d_of_type_JavaLangString + this.jdField_c_of_type_Int + "/" + "music.amr");
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        return;
      }
      catch (Throwable localThrowable3)
      {
        QLog.e("ApolloViewController", 1, localThrowable3.getMessage());
        return;
      }
      k = 0;
      break label533;
    }
  }
  
  private void f()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()))
      {
        bbcf.a(BaseApplicationImpl.getContext(), false);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      if (this.jdField_a_of_type_Bfob != null) {
        this.jdField_a_of_type_Bfob.removeMessages(24);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloViewController", 1, localThrowable.getMessage());
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "[destoryAllAvatars]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(str);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    QLog.e("ApolloViewController", 1, "[destoryAllAvatars] surfaceView null");
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public ApolloTextureView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  }
  
  public String a()
  {
    this.jdField_i_of_type_Int = 0;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null))
    {
      this.jdField_c_of_type_Int = 5;
      String[] arrayOfString = ajki.a(10, -1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
      if ((arrayOfString.length > 0) && (!TextUtils.isEmpty(arrayOfString[0])) && (arrayOfString[0].length() - "action".length() > 0)) {}
      ajkj.a().jdField_a_of_type_JavaLangString = arrayOfString[0].substring(0, arrayOfString[0].length() - "action".length());
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, arrayOfString[0], arrayOfString[1]);
      return b("sayHi Ok");
    }
    this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(22, 100L);
    return a(ajya.a(2131700565));
  }
  
  public String a(int paramInt, boolean paramBoolean, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[initAvatar] apolloStatus=", Integer.valueOf(paramInt), ", avatarParam=", paramApolloWebAvatarParam });
    }
    if (paramApolloWebAvatarParam == null) {
      return a("no params");
    }
    if (TextUtils.isEmpty(paramApolloWebAvatarParam.apolloId)) {
      return a("no apolloId");
    }
    if (!ApolloEngine.a())
    {
      QLog.e("ApolloViewController", 1, "ApolloEngine is not ready");
      return a("ApolloEngine is not ready");
    }
    if (!ajki.a(paramApolloWebAvatarParam.uin, paramApolloWebAvatarParam.roleId, paramApolloWebAvatarParam.dressIds, null))
    {
      bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700564), 0).a();
      return a("dresses is not download!");
    }
    if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!this.jdField_e_of_type_JavaLangString.equals(paramApolloWebAvatarParam.tab)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(paramApolloWebAvatarParam.apolloId);
      }
      this.jdField_a_of_type_Bfob.postDelayed(new ApolloViewController.2(this, paramInt, paramBoolean, paramApolloWebAvatarParam), 100L);
    }
    for (;;)
    {
      return b("initAvatar成功");
      b(paramInt, paramBoolean, paramApolloWebAvatarParam);
    }
  }
  
  public String a(ajik paramajik)
  {
    if (this.j)
    {
      QLog.e("ApolloViewController", 1, "previewAction 小人已隐藏");
      return a(ajya.a(2131700570));
    }
    if (paramajik == null) {
      return a("actionData is null");
    }
    if (paramajik.jdField_a_of_type_Int > 1) {}
    for (this.jdField_a_of_type_Ajik = paramajik; (paramajik.jdField_c_of_type_Int == 1) && (!TextUtils.isEmpty(paramajik.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramajik.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)); this.jdField_a_of_type_Ajik = null) {
      return a(ajya.a(2131700575));
    }
    if ((TextUtils.isEmpty(paramajik.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)) {
      paramajik.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId;
    }
    if (TextUtils.isEmpty(paramajik.jdField_b_of_type_JavaLangString)) {
      return a("未传apolloId");
    }
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramajik.jdField_b_of_type_JavaLangString)) {
      return a(ajya.a(2131700573));
    }
    Object localObject1 = (ApolloWebAvatarParam)this.jdField_a_of_type_JavaUtilHashMap.get(paramajik.jdField_b_of_type_JavaLangString);
    if (localObject1 == null) {
      return a(ajya.a(2131700559));
    }
    int m = 0;
    int k = m;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
    {
      k = m;
      if (paramajik.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)) {
        k = 1;
      }
    }
    if ((k != 0) && (!ajki.a(((ApolloWebAvatarParam)localObject1).uin, ((ApolloWebAvatarParam)localObject1).roleId, ((ApolloWebAvatarParam)localObject1).dressIds, null)))
    {
      bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700560), 0).a();
      return a(ajya.a(2131700571));
    }
    if (!ApolloUtil.a(paramajik.jdField_b_of_type_Int, paramajik.jdField_c_of_type_Int))
    {
      if (k != 0) {
        bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700578), 0).a();
      }
      return a(ajya.a(2131700561));
    }
    if ((!this.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null))
    {
      if (k != 0) {
        bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131700576), 0).a();
      }
      return a(ajya.a(2131700566));
    }
    if (k != 0) {
      f();
    }
    this.jdField_i_of_type_Int = paramajik.m;
    this.jdField_f_of_type_Float = paramajik.jdField_a_of_type_Float;
    boolean bool;
    label556:
    label616:
    float f1;
    label837:
    label890:
    Object localObject2;
    int n;
    if (paramajik.l == 0)
    {
      bool = true;
      this.jdField_i_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = paramajik.jdField_a_of_type_Boolean;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (paramajik.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
        this.jdField_c_of_type_Int = paramajik.jdField_b_of_type_Int;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_a_of_type_Bfob.removeMessages(16);
      this.jdField_f_of_type_Int = paramajik.jdField_i_of_type_Int;
      this.jdField_d_of_type_JavaLangString = paramajik.jdField_a_of_type_JavaLangString;
      this.jdField_g_of_type_Int = paramajik.k;
      if (paramajik.j != 1) {
        break label1141;
      }
      bool = true;
      this.jdField_f_of_type_Boolean = bool;
      if ((!paramajik.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ajil != null)) {
        this.jdField_a_of_type_Ajil.a();
      }
      if ((!TextUtils.isEmpty(paramajik.jdField_a_of_type_JavaLangString)) && (!paramajik.jdField_a_of_type_Boolean)) {
        break label1147;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      }
      if (paramajik.jdField_d_of_type_Int != 0) {
        break label1518;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(50L);
      }
      if (this.jdField_a_of_type_Int != paramajik.jdField_c_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        f1 = 0.0F;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) {
          f1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - ((ApolloWebAvatarParam)localObject1).y;
        }
        if (paramajik.jdField_c_of_type_Int != 1) {
          break label1218;
        }
        if (ApolloUtil.d(this.jdField_f_of_type_Int))
        {
          float f2 = this.jdField_b_of_type_Float / 2.0F;
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, this.jdField_f_of_type_Int, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x - f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, ajhu.a(this.jdField_f_of_type_Int), null);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x + f2, f1);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
      }
      if (!paramajik.jdField_a_of_type_Boolean) {
        break label1277;
      }
      this.jdField_a_of_type_Ajil.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramajik.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, paramajik.jdField_c_of_type_Int);
      this.jdField_a_of_type_Ajil.a(paramajik.jdField_b_of_type_Float);
      this.jdField_a_of_type_Int = paramajik.jdField_c_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if (TextUtils.isEmpty(paramajik.jdField_a_of_type_JavaLangString)) {
        break label1496;
      }
      if (paramajik.k != 1) {
        break label1453;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
        n = (int)((float)bbdh.j() * ((ApolloWebAvatarParam)localObject1).rate * 1.14F);
        if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == localObject2) {
          break label1384;
        }
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
        }
        localObject2 = new RelativeLayout.LayoutParams(-1, n);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.jdField_d_of_type_Float - n));
        m = this.jdField_c_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView) - 1;
        k = m;
        if (m < 0) {
          k = 0;
        }
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, k, (ViewGroup.LayoutParams)localObject2);
        label1086:
        if (!paramajik.jdField_a_of_type_Boolean) {
          aiwa.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getWidth(), n, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", paramajik.jdField_a_of_type_JavaLangString, true);
        }
      }
    }
    for (;;)
    {
      a(false);
      return b(ajya.a(2131700574));
      bool = false;
      break;
      label1141:
      bool = false;
      break label556;
      label1147:
      if (paramajik.k == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView = new BarrageView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
          this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setClickable(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(0);
        break label616;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null) {
        break label616;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
      break label616;
      label1218:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_a_of_type_Float, ((ApolloWebAvatarParam)localObject1).x, f1);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, ((ApolloWebAvatarParam)localObject1).dressIds, null);
      break label837;
      label1277:
      ApolloUtil.a("ready resource");
      localObject2 = ajki.a(13, paramajik.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, true);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, paramajik.jdField_b_of_type_Int, 0, localObject2[0], localObject2[1]);
      if (paramajik.jdField_c_of_type_Int != 1) {
        break label890;
      }
      localObject2 = ajki.a(13, paramajik.jdField_b_of_type_Int, ((ApolloWebAvatarParam)localObject1).roleId, false);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, paramajik.jdField_b_of_type_Int, 0, localObject2[0], localObject2[1]);
      break label890;
      label1384:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getHeight() == n) {
        break label1086;
      }
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(((ApolloWebAvatarParam)localObject1).y * this.jdField_d_of_type_Float - n));
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getLayoutParams().height = n;
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label1086;
      label1453:
      ajkj.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, ((ApolloWebAvatarParam)localObject1).apolloId, 1, ((ApolloWebAvatarParam)localObject1).roleId, this.jdField_d_of_type_JavaLangString, null);
      continue;
      label1496:
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, ((ApolloWebAvatarParam)localObject1).apolloId, "Bubble");
    }
    label1518:
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!paramajik.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId))) {
      return a(ajya.a(2131700583));
    }
    a();
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), null);
      localObject1 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDisplayMetrics().heightPixels * 0.6F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDisplayMetrics();
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.init(new ajii(this, (DisplayMetrics)localObject1, paramajik));
      if (this.jdField_b_of_type_Aiva == null) {
        this.jdField_b_of_type_Aiva = new ajij(this);
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRender().setRenderCallback(this.jdField_b_of_type_Aiva);
      label1745:
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(50L);
      this.jdField_a_of_type_Bfob.removeMessages(15);
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label1995;
      }
      localObject1 = ajya.a(2131700579);
      label1800:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        break label2004;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      label1836:
      if ((paramajik.jdField_h_of_type_Int != 1) && (paramajik.jdField_e_of_type_Int > 0)) {
        break label2016;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(paramajik.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramajik.jdField_b_of_type_Int));
      break;
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      localObject1 = this.jdField_a_of_type_Bfob.obtainMessage(19, paramajik.jdField_c_of_type_Int, paramajik.jdField_b_of_type_Int);
      if (paramajik.jdField_a_of_type_Boolean) {
        ((Message)localObject1).obj = Float.valueOf(paramajik.jdField_b_of_type_Float);
      }
      this.jdField_a_of_type_Bfob.sendMessageDelayed((Message)localObject1, 100L);
      break label1745;
      label1995:
      localObject1 = this.jdField_b_of_type_JavaLangString;
      break label1800;
      label2004:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label1836;
      label2016:
      bool = bgzx.a().a();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "isSuperYellow:", Boolean.valueOf(bool) });
      }
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getString(2131690085));
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ApolloUtil.a(this.jdField_b_of_type_AndroidWidgetImageView, paramajik.jdField_e_of_type_Int);
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  public String a(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[addAvatar] avatarParams=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return a("no params");
    }
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)localObject).next();
      if (!ajki.a(localApolloWebAvatarParam.uin, localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, null))
      {
        bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700562), 0).a();
        return a("dresses is not download!");
      }
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 27;
    ((Message)localObject).getData().putSerializable("key_add_avatar_list", paramArrayList);
    this.jdField_a_of_type_Bfob.sendMessage((Message)localObject);
    return b("updateAvatar成功");
  }
  
  public String a(int[] paramArrayOfInt)
  {
    if (this.j)
    {
      QLog.e("ApolloViewController", 1, "preview 小人已隐藏");
      return a(ajya.a(2131700572));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null) {
      return a(ajya.a(2131700563));
    }
    if (!ajki.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.uin, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, paramArrayOfInt, null))
    {
      bcql.a(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext(), ajya.a(2131700580), 0).a();
      return a(ajya.a(2131700569));
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds = paramArrayOfInt;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
      }
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, paramArrayOfInt, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
    }
    a(false);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_d_of_type_JavaLangString = null;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setVisibility(8);
    }
    f();
    return b(ajya.a(2131700568));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getColor(2131166770));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, (int)((float)bbdh.j() * 0.6F));
      ((RelativeLayout.LayoutParams)localObject1).addRule(13, -1);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
      Object localObject2 = LayoutInflater.from(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext()).inflate(2131558622, null);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject2).findViewById(2131363791));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((View)localObject2).findViewById(2131362645));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131362575));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131362574));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131362572));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
      long l = Math.max(bbdh.h(), bbdh.g());
      localObject1 = new ImageView(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext());
      ((ImageView)localObject1).setId(2131362603);
      localObject2 = new RelativeLayout.LayoutParams((int)(l / 16.68D + 0.5D), (int)(l / 16.68D + 0.5D));
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(14);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(l / 19.899999999999999D + 0.5D));
      ((ImageView)localObject1).setBackgroundResource(2130838271);
      ((ImageView)localObject1).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bfob.removeMessages(23);
    this.jdField_b_of_type_Int = paramInt;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_Bfob.removeMessages(16);
      this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(16, 3000L);
    }
    label218:
    label250:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
      {
        if ("mall".equals(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.tab)) {
          if (this.jdField_b_of_type_Int == 0)
          {
            this.jdField_a_of_type_JavaLangString = ajya.a(2131700582);
            if (this.jdField_h_of_type_Int == 1) {
              this.jdField_a_of_type_JavaLangString = ajhu.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId);
            }
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)) {
              this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting;
            }
            if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
              break label218;
            }
            this.jdField_a_of_type_Bfob.sendEmptyMessage(17);
          }
        }
        for (;;)
        {
          if (this.jdField_b_of_type_Int != 1) {
            break label250;
          }
          this.jdField_a_of_type_Bfob.removeMessages(16);
          this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(16, 3000L);
          return;
          if (this.jdField_b_of_type_Int == 2)
          {
            this.jdField_a_of_type_JavaLangString = ajya.a(2131700567);
            break;
          }
          this.jdField_a_of_type_JavaLangString = null;
          break;
          this.jdField_a_of_type_JavaLangString = null;
          break;
          if (Looper.myLooper() == Looper.getMainLooper()) {
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          } else {
            this.jdField_a_of_type_Bfob.sendEmptyMessage(16);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public void a(aivc paramaivc)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaivc);
  }
  
  public void a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    c(false);
    this.jdField_a_of_type_Bfob.postDelayed(new ApolloViewController.3(this, paramActivity, paramAppInterface, paramString1, paramString2), 500L);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[destoryAvatar] apolloIdList=", paramArrayList });
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str)))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(str);
          this.jdField_a_of_type_JavaUtilHashMap.remove(str);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int k = 0;; k = 8)
    {
      localRelativeLayout.setVisibility(k);
      return;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((int)(this.jdField_d_of_type_Float * paramFloat1) - (this.jdField_d_of_type_Int >> 1));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(this.jdField_d_of_type_Float * paramFloat2 * 0.75F));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
      this.j = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "hideAndDispose");
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      if (paramInt <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b();
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1000L);
      }
      this.j = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "setApolloViewVisibility visibility:", Integer.valueOf(paramInt) });
      }
      return;
      label95:
      this.j = true;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      f();
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(0L);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.disableTouchEvent(paramBoolean);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      bbcf.a(BaseApplicationImpl.getContext(), false);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    f();
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      if (!paramBoolean) {
        break label79;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(0L);
      }
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Bfob.obtainMessage(18).sendToTarget();
      return;
      label79:
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.b();
    }
  }
  
  public void d()
  {
    ViewParent localViewParent;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localViewParent = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null)
    {
      localViewParent = this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView);
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
    }
    this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a();
    }
    g();
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloImageShareLayout.a(true);
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "[onDestroy] release player");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "onDestroy");
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    int m;
    label189:
    int n;
    label209:
    label874:
    ApolloWebAvatarParam localApolloWebAvatarParam;
    label412:
    label418:
    label1187:
    label1244:
    float f2;
    label1995:
    float f4;
    float f3;
    switch (???.what)
    {
    case 20: 
    case 26: 
    default: 
    case 24: 
    case 22: 
    case 15: 
    case 16: 
    case 17: 
    case 23: 
    case 21: 
    case 18: 
    case 27: 
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              return false;
              if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
                this.jdField_a_of_type_AndroidMediaMediaPlayer = a();
              }
              if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
                this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("audio"));
              }
              if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
                this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getSystemService("phone"));
              }
              if ((this.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode() == 1))
              {
                k = 1;
                if ((this.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(2) != 0)) {
                  break label412;
                }
                m = 1;
                if ((this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCallState() != 0)) {
                  break label418;
                }
                n = 1;
                if ((!new File(ajhu.b(this.jdField_i_of_type_Int)).exists()) || (m != 0) || (k != 0) || (n == 0)) {}
              }
              try
              {
                bbcf.a(BaseApplicationImpl.getContext(), true);
                this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
                this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(ajhu.b(this.jdField_i_of_type_Int));
                this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
                this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
                if (!TextUtils.isEmpty(ajkj.a().jdField_a_of_type_JavaLangString))
                {
                  ??? = ajkj.a().jdField_a_of_type_JavaLangString;
                  if (???.startsWith("def"))
                  {
                    ??? = ajms.jdField_c_of_type_JavaLangString + "/" + ???;
                    ajkj.a().jdField_a_of_type_JavaLangString = "";
                    ??? = ApolloUtil.a(???, "amr");
                    if (??? == null) {}
                  }
                }
              }
              catch (Throwable ???)
              {
                try
                {
                  for (;;)
                  {
                    bbcf.a(BaseApplicationImpl.getContext(), true);
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(???.getPath());
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
                    this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
                    return false;
                    k = 0;
                    break;
                    m = 0;
                    break label189;
                    n = 0;
                    break label209;
                    ??? = ???;
                    QLog.e("ApolloViewController", 1, ???.getMessage());
                  }
                  ??? = ajms.jdField_a_of_type_JavaLangString + "/" + ???;
                }
                catch (IOException ???)
                {
                  for (;;)
                  {
                    ???.printStackTrace();
                  }
                }
              }
            }
          } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null));
          ??? = ajki.a(4, -1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 5, 0, ???[0], ???[1]);
          return false;
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          }
          if (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.a(false);
          }
          this.jdField_a_of_type_Bfob.sendEmptyMessage(18);
          return true;
          if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          }
          if (this.jdField_e_of_type_Boolean)
          {
            if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null))
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
            }
            this.jdField_e_of_type_Boolean = false;
          }
          return true;
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
          }
          for (;;)
          {
            return true;
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          }
          a(this.jdField_b_of_type_Int);
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0));
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloViewController", 2, "handleMessage MSG_CODE_REFRESH_APOLLO");
        }
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_Int != 0))
        {
          k = ???.getData().getInt("key_operation");
          if (QLog.isColorLevel()) {
            QLog.d("ApolloViewController", 2, new Object[] { "handleMessage MSG_CODE_REFRESH_APOLLO, opFlag=", Integer.valueOf(k) });
          }
          if (k != 1) {
            break label1187;
          }
          g();
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose("friend");
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)))
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.y);
            if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId != 0) {
              break label1244;
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, ajhu.a, null);
          }
        }
        for (;;)
        {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam);
            if ((???.arg1 > 0) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_f_of_type_Boolean) && (this.jdField_g_of_type_Int == 0))
            {
              this.jdField_e_of_type_Boolean = false;
              ajkj.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_d_of_type_JavaLangString, null);
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
              this.jdField_a_of_type_Int = 0;
              this.jdField_d_of_type_Boolean = true;
              this.jdField_b_of_type_Boolean = false;
              if (this.jdField_a_of_type_Ajip != null) {
                this.jdField_a_of_type_Ajip.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
              }
              a(false);
              if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0)) {
                break;
              }
              this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(21, 100L);
              return false;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)
              {
                if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId)) {
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId);
                }
              }
              else
              {
                this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose("friend");
                break label874;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose();
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId <= 0) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds == null)) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
            }
          }
          if ((this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting)))
          {
            ajkj.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(8);
            this.jdField_e_of_type_Boolean = true;
            this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(8, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.greeting, null);
          }
          else
          {
            this.jdField_e_of_type_Boolean = false;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloViewController", 2, "handleMessage MSG_ADD_APOLLO");
        }
      } while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null));
      ??? = (ArrayList)???.getData().getSerializable("key_add_avatar_list");
      if ((??? != null) && (((ArrayList)???).size() > 0))
      {
        ??? = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
        if (??? != null)
        {
          ??? = ((ArrayList)???).iterator();
          while (((Iterator)???).hasNext())
          {
            localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)???).next();
            if (localApolloWebAvatarParam != null) {
              for (;;)
              {
                synchronized (this.jdField_a_of_type_JavaUtilHashMap)
                {
                  for (;;)
                  {
                    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localApolloWebAvatarParam.apolloId))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ApolloViewController", 2, new Object[] { "handleMessage MSG_ADD_APOLLO, ", localApolloWebAvatarParam.apolloId, " is showing, destroy" });
                      }
                      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
                        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose(localApolloWebAvatarParam.apolloId);
                      }
                      this.jdField_a_of_type_JavaUtilHashMap.remove(localApolloWebAvatarParam.apolloId);
                    }
                    ???.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtil.a(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - localApolloWebAvatarParam.y);
                    if (localApolloWebAvatarParam.roleId == 0)
                    {
                      ???.a(1, localApolloWebAvatarParam.apolloId, ajhu.a, null);
                      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
                      {
                        this.jdField_a_of_type_JavaUtilHashMap.put(localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam);
                      }
                    }
                  }
                }
                if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null)) {
                  ???.a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
        }
      }
      for (;;)
      {
        return false;
        QLog.e("ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, renderInterface null");
        continue;
        QLog.e("ApolloViewController", 1, "handleMessage MSG_ADD_APOLLO, avatar list null");
      }
    case 28: 
      ??? = (String)???.obj;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, new Object[] { "[handleMessage] MSG_RESET_APOLLO, apolloId=", ??? });
      }
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam != null)) {
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(???))
            {
              localApolloWebAvatarParam = (ApolloWebAvatarParam)this.jdField_a_of_type_JavaUtilHashMap.get(???);
              if (localApolloWebAvatarParam != null)
              {
                ??? = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl();
                if (??? != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onExecDispose((String)???);
                  ((aitk)???).a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.roleId, ApolloUtil.a(localApolloWebAvatarParam.rate), localApolloWebAvatarParam.x, this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight() / this.jdField_d_of_type_Float - localApolloWebAvatarParam.y);
                  if (localApolloWebAvatarParam.roleId != 0) {
                    break label1995;
                  }
                  ((aitk)???).a(1, localApolloWebAvatarParam.apolloId, ajhu.a, null);
                }
              }
            }
            while ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null))
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(15000L);
              return false;
            }
            ((aitk)???).a(1, localApolloWebAvatarParam.apolloId, localApolloWebAvatarParam.dressIds, null);
          }
        }
        QLog.e("ApolloViewController", 1, new Object[] { "[handleMessage] MSG_RESET_APOLLO, surface not ready, mSurfaceReady=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", mSurfaceView=", this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView });
        return false;
      }
      QLog.e("ApolloViewController", 1, "[handleMessage] MSG_RESET_APOLLO, apolloId null");
      return false;
    case 19: 
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam == null)) {
        return true;
      }
      m = ???.arg1;
      n = ???.arg2;
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(4);
      this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
      {
        f2 = 77.0F;
        f4 = (float)(Math.max(bbdh.h(), bbdh.g()) / 7L) / 368.0F;
        ??? = ???.obj;
        if ((??? == null) || (!(??? instanceof Float))) {
          break label2858;
        }
        f3 = ((Float)???).floatValue();
      }
      break;
    }
    for (int k = 1;; k = 0)
    {
      float f1;
      if ((m == 1) && (ApolloUtil.d(this.jdField_f_of_type_Int)))
      {
        f1 = 330.0F * f4 / bbdh.jdField_a_of_type_Float / 2.0F;
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, this.jdField_f_of_type_Int, f4, this.jdField_c_of_type_Float - f1, f2);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, ajhu.a(this.jdField_f_of_type_Int), null);
        ??? = ajki.a(13, n, this.jdField_f_of_type_Int, false);
        if (k != 0)
        {
          this.jdField_a_of_type_Ajil.a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, n, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, m);
          this.jdField_a_of_type_Ajil.a(f3);
        }
      }
      for (;;)
      {
        label2339:
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, f4, f1 + this.jdField_c_of_type_Float, f2);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.dressIds, null);
        ??? = ajki.a(13, n, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, true);
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.stopLoopDelayed(1000L);
        if (k != 0)
        {
          this.jdField_a_of_type_Ajil.a(this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView, n, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, m);
          this.jdField_a_of_type_Ajil.a(f3);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
          {
            if (this.jdField_g_of_type_Int == 1)
            {
              this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
              if (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView == null) {
                break label2851;
              }
              k = (int)((float)(bbdh.j() / 7L) * 1.14F);
              ??? = this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getParent();
              if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != ???)
              {
                if (??? != null) {
                  ((ViewGroup)???).removeView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView);
                }
                ??? = new RelativeLayout.LayoutParams(-1, k);
                ???.addRule(12, -1);
                ???.leftMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
                ???.rightMargin = ApolloUtil.a(25.0F, this.jdField_d_of_type_Float);
                ???.bottomMargin = (actj.a(f2, this.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext().getResources()) + (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight() - this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getHeight()) / 2);
                this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, 1, ???);
              }
              aiwa.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth(), k, this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView, BaseApplicationImpl.getContext(), "", this.jdField_d_of_type_JavaLangString, true);
              return true;
              f2 = 42.0F;
              break;
              this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(2, null, n, 0, ???[0], ???[1]);
              break label2339;
              this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, n, 0, ???[0], ???[1]);
              continue;
            }
            ajkj.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
            this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().b(0, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, 1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.roleId, this.jdField_d_of_type_JavaLangString, null);
            return true;
          }
        }
        this.jdField_b_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloWebAvatarParam.apolloId, "Bubble");
        return true;
        if ((this.jdField_a_of_type_Ajik == null) || (this.jdField_a_of_type_Ajik.jdField_a_of_type_Int <= 0)) {
          break;
        }
        ??? = this.jdField_a_of_type_Ajik;
        ???.jdField_a_of_type_Int -= 1;
        a(this.jdField_a_of_type_Ajik);
        return false;
        label2851:
        return true;
        f1 = 0.0F;
      }
      label2858:
      f3 = 0.0F;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362603)
    {
      this.jdField_a_of_type_Bfob.sendEmptyMessage(15);
      f();
    }
    while ((paramView != this.jdField_a_of_type_AndroidWidgetLinearLayout) && (paramView != this.jdField_a_of_type_AndroidWidgetButton)) {
      return;
    }
    f();
    if ((this.jdField_a_of_type_Ajip != null) && ((paramView.getTag() instanceof Integer))) {
      this.jdField_a_of_type_Ajip.a(((Integer)paramView.getTag()).intValue());
    }
    this.jdField_a_of_type_Bfob.sendEmptyMessage(15);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("ApolloViewController", 1, "[onError] " + paramInt1 + paramInt2);
    return false;
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((aivc)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onNotifyLongTouch(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((aivc)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onNotifyStatusChanged(paramInt, paramString);
    }
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloViewController", 2, "[onPrepared] start play");
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  @TargetApi(14)
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0))
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationX(-paramInt1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(-paramInt2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationX(-paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloBarrageBarrageView.setTranslationY(-paramInt2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationX(-paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationY(-paramInt2);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, "Avatar view is Ready.");
    }
    this.jdField_a_of_type_Bfob.sendEmptyMessage(18);
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((aivc)this.jdField_a_of_type_JavaLangRefWeakReference.get()).onSurfaceReady(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajig
 * JD-Core Version:    0.7.0.1
 */