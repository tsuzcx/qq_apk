import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class aajt
{
  private static aajt jdField_a_of_type_Aajt;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "SubscribePlayerManager";
  private Map<Integer, agrp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<agrp> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private Map<Integer, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int d = -1;
  private int e = -1;
  private int f;
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0) == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
  }
  
  public static aajt a()
  {
    if (jdField_a_of_type_Aajt == null) {
      jdField_a_of_type_Aajt = new aajt();
    }
    return jdField_a_of_type_Aajt;
  }
  
  private void a(agrp paramagrp, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramagrp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramagrp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagrp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramagrp.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    paramagrp.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramagrp.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (nmd.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    for (;;)
    {
      return;
      if ((this.f > this.jdField_c_of_type_Int) && (this.f < this.d))
      {
        QLog.d("SubscribePlayerManager", 4, "mCurrentPosition:" + this.f + "is play in screen");
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "mFirstPosition:" + this.jdField_c_of_type_Int + ",mLastPosition:" + this.d);
      int i;
      if (paramBoolean)
      {
        i = this.jdField_c_of_type_Int;
        while ((i <= this.d) && (!b(i))) {
          i += 1;
        }
      }
      else
      {
        i = this.d;
        while ((i >= this.jdField_c_of_type_Int) && (!b(i))) {
          i -= 1;
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == this.jdField_b_of_type_Int;
  }
  
  private void b(agrp paramagrp)
  {
    if (paramagrp != null) {
      while ((paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        View localView = paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).i()) {
          ((VideoPlayerView)localView).c();
        }
        ((VideoPlayerView)localView).b();
        a(paramagrp, false);
        QLog.d("SubscribePlayerManager", 4, "release videoPlayer position:" + paramagrp.jdField_b_of_type_Int);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      agrp localagrp = (agrp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localagrp != null)
      {
        Object localObject = localagrp.jdField_a_of_type_AndroidWidgetRelativeLayout;
        Rect localRect = new Rect();
        localagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(localRect);
        int i = localagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).i())
            {
              ((CleanVideoPlayerView)localObject).d();
              QLog.d("SubscribePlayerManager", 4, "play by old player position:" + localagrp.jdField_b_of_type_Int);
            }
            QLog.d("SubscribePlayerManager", 4, "is playing now position:" + localagrp.jdField_b_of_type_Int);
            a(localagrp, true);
          }
          for (;;)
          {
            return true;
            c(localagrp, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private void c(agrp paramagrp, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!nmd.a(BaseApplicationImpl.context))
      {
        biti.a().a(anni.a(2131713345));
        QLog.d("SubscribePlayerManager", 4, "network not available");
      }
    }
    else {
      return;
    }
    Object localObject;
    CleanVideoPlayerView localCleanVideoPlayerView;
    int i;
    if (!TextUtils.isEmpty(paramagrp.jdField_b_of_type_JavaLangString))
    {
      b(paramagrp);
      localObject = a(paramagrp.jdField_b_of_type_JavaLangString, "vid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        localCleanVideoPlayerView.setLoopBack(true);
        localCleanVideoPlayerView.setOutPutMute(true);
        localCleanVideoPlayerView.setWifiAutoPlay(true);
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          break label301;
        }
        if (this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramagrp.jdField_b_of_type_Int)) == null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      localCleanVideoPlayerView.setVideoPath((String)localObject, "", i);
      localCleanVideoPlayerView.setBaseVideoViewListenerSets(new aajv(this, paramagrp));
      localCleanVideoPlayerView.setRevertProgress(true);
      i = bclx.a(180.0F);
      localObject = new RelativeLayout.LayoutParams((int)(i * (paramagrp.e / paramagrp.f)), i);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
      this.f = paramInt;
      e();
      QLog.d("SubscribePlayerManager", 4, "playInner mCurrentPlayPosition: " + this.f);
      return;
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramagrp.jdField_b_of_type_Int))).intValue();
      continue;
      QLog.d("SubscribePlayerManager", 4, "vid is empty");
      return;
      QLog.d("SubscribePlayerManager", 4, "url is empty");
      return;
      label301:
      i = 0;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new SubscribePlayerManager.2(this);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private void e()
  {
    agrp localagrp1 = (agrp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      agrp localagrp2 = (agrp)localIterator.next();
      if (localagrp2 != localagrp1) {
        b(localagrp2);
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = "";
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("&");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString1 = str;
      if (i < j)
      {
        paramString1 = arrayOfString[i];
        if (paramString1.contains(paramString2)) {
          paramString1 = paramString1.replace(paramString2 + "=", "");
        }
      }
      else
      {
        return paramString1;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    agrp localagrp = (agrp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localagrp != null)
    {
      View localView = localagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (!((VideoPlayerView)localView).i()))
      {
        ((VideoPlayerView)localView).d();
        QLog.d("SubscribePlayerManager", 4, "onResume play video position:" + localagrp.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(agrp paramagrp)
  {
    View localView = paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    a(paramagrp, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).i())
      {
        ((VideoPlayerView)localView).c();
        QLog.d("SubscribePlayerManager", 4, "handleScrollOutScreen:" + paramagrp.jdField_b_of_type_Int);
      }
      ((CleanVideoPlayerView)localView).b();
      this.f = -1;
    }
  }
  
  public void a(agrp paramagrp, int paramInt)
  {
    if ((agrp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == paramagrp) {
      return;
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramagrp);
    this.jdField_a_of_type_JavaUtilSet.add(paramagrp);
    View localView = paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).i()) {
        ((VideoPlayerView)localView).c();
      }
      ((VideoPlayerView)localView).b();
    }
    a(paramagrp, false);
    paramagrp.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aaju(this, paramagrp));
    QLog.d("SubscribePlayerManager", 4, "bindViewHolder:" + paramInt + "  HolderSize:" + this.jdField_a_of_type_JavaUtilSet.size());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    QLog.d("SubscribePlayerManager", 4, "mPerFirstVisible:" + this.jdField_b_of_type_Int + "  mFiresVisible:" + this.jdField_c_of_type_Int);
    if (!this.jdField_b_of_type_Boolean)
    {
      a(true);
      QLog.d("SubscribePlayerManager", 4, "begin start");
      return;
    }
    a(false);
    QLog.d("SubscribePlayerManager", 4, "begin end");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    if (a(paramInt1))
    {
      int i = a();
      if (Math.abs(this.jdField_a_of_type_Int - i) > 0)
      {
        paramInt3 = 1;
        if (paramInt3 != 0) {
          if (this.jdField_a_of_type_Int <= i) {
            break label130;
          }
        }
      }
      label130:
      for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_Int = i;
        paramInt3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        this.jdField_c_of_type_Int = (paramInt1 - i);
        this.e = paramInt2;
        this.d = (this.jdField_c_of_type_Int + paramInt2 - paramInt3 - i);
        return;
        paramInt3 = 0;
        break;
      }
    }
    if (paramInt1 > this.jdField_b_of_type_Int) {}
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      this.jdField_a_of_type_Int = a();
      this.jdField_b_of_type_Int = paramInt1;
      break;
    }
  }
  
  public void b()
  {
    agrp localagrp = (agrp)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localagrp != null)
    {
      View localView = localagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (((VideoPlayerView)localView).i()))
      {
        ((VideoPlayerView)localView).c();
        QLog.d("SubscribePlayerManager", 4, "onStop pause video position:" + localagrp.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(agrp paramagrp, int paramInt)
  {
    if (paramagrp != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramagrp.jdField_b_of_type_Int));
      View localView = paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localView instanceof CleanVideoPlayerView))
      {
        paramagrp.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).i()) {
          ((VideoPlayerView)localView).c();
        }
        ((VideoPlayerView)localView).b();
        a(paramagrp, false);
        QLog.d("SubscribePlayerManager", 4, "unbind view position:" + paramInt);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.f = -1;
    e();
    this.jdField_c_of_type_Int = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajt
 * JD-Core Version:    0.7.0.1
 */