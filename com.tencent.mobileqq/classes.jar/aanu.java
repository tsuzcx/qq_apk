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

public class aanu
{
  private static aanu jdField_a_of_type_Aanu;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "SubscribePlayerManager";
  private Map<Integer, ahbd> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<ahbd> jdField_a_of_type_JavaUtilSet = new HashSet();
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
  
  public static aanu a()
  {
    if (jdField_a_of_type_Aanu == null) {
      jdField_a_of_type_Aanu = new aanu();
    }
    return jdField_a_of_type_Aanu;
  }
  
  private void a(ahbd paramahbd, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramahbd.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramahbd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramahbd.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramahbd.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    paramahbd.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramahbd.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (nny.a(BaseApplicationImpl.context) != 1) {
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
  
  private void b(ahbd paramahbd)
  {
    if (paramahbd != null) {
      while ((paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        View localView = paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).i()) {
          ((VideoPlayerView)localView).c();
        }
        ((VideoPlayerView)localView).b();
        a(paramahbd, false);
        QLog.d("SubscribePlayerManager", 4, "release videoPlayer position:" + paramahbd.jdField_b_of_type_Int);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      ahbd localahbd = (ahbd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localahbd != null)
      {
        Object localObject = localahbd.jdField_a_of_type_AndroidWidgetRelativeLayout;
        Rect localRect = new Rect();
        localahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(localRect);
        int i = localahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).i())
            {
              ((CleanVideoPlayerView)localObject).d();
              QLog.d("SubscribePlayerManager", 4, "play by old player position:" + localahbd.jdField_b_of_type_Int);
            }
            QLog.d("SubscribePlayerManager", 4, "is playing now position:" + localahbd.jdField_b_of_type_Int);
            a(localahbd, true);
          }
          for (;;)
          {
            return true;
            c(localahbd, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private void c(ahbd paramahbd, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!nny.a(BaseApplicationImpl.context))
      {
        bjuh.a().a(anzj.a(2131713454));
        QLog.d("SubscribePlayerManager", 4, "network not available");
      }
    }
    else {
      return;
    }
    Object localObject;
    CleanVideoPlayerView localCleanVideoPlayerView;
    int i;
    if (!TextUtils.isEmpty(paramahbd.jdField_b_of_type_JavaLangString))
    {
      b(paramahbd);
      localObject = a(paramahbd.jdField_b_of_type_JavaLangString, "vid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        localCleanVideoPlayerView.setLoopBack(true);
        localCleanVideoPlayerView.setOutPutMute(true);
        localCleanVideoPlayerView.setWifiAutoPlay(true);
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          break label301;
        }
        if (this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramahbd.jdField_b_of_type_Int)) == null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      localCleanVideoPlayerView.setVideoPath((String)localObject, "", i);
      localCleanVideoPlayerView.setBaseVideoViewListenerSets(new aanw(this, paramahbd));
      localCleanVideoPlayerView.setRevertProgress(true);
      i = bdep.a(180.0F);
      localObject = new RelativeLayout.LayoutParams((int)(i * (paramahbd.e / paramahbd.f)), i);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
      this.f = paramInt;
      e();
      QLog.d("SubscribePlayerManager", 4, "playInner mCurrentPlayPosition: " + this.f);
      return;
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramahbd.jdField_b_of_type_Int))).intValue();
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
    ahbd localahbd1 = (ahbd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      ahbd localahbd2 = (ahbd)localIterator.next();
      if (localahbd2 != localahbd1) {
        b(localahbd2);
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
    ahbd localahbd = (ahbd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localahbd != null)
    {
      View localView = localahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (!((VideoPlayerView)localView).i()))
      {
        ((VideoPlayerView)localView).d();
        QLog.d("SubscribePlayerManager", 4, "onResume play video position:" + localahbd.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(ahbd paramahbd)
  {
    View localView = paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    a(paramahbd, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).i())
      {
        ((VideoPlayerView)localView).c();
        QLog.d("SubscribePlayerManager", 4, "handleScrollOutScreen:" + paramahbd.jdField_b_of_type_Int);
      }
      ((CleanVideoPlayerView)localView).b();
      this.f = -1;
    }
  }
  
  public void a(ahbd paramahbd, int paramInt)
  {
    if ((ahbd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == paramahbd) {
      return;
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramahbd);
    this.jdField_a_of_type_JavaUtilSet.add(paramahbd);
    View localView = paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).i()) {
        ((VideoPlayerView)localView).c();
      }
      ((VideoPlayerView)localView).b();
    }
    a(paramahbd, false);
    paramahbd.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aanv(this, paramahbd));
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
    ahbd localahbd = (ahbd)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localahbd != null)
    {
      View localView = localahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (((VideoPlayerView)localView).i()))
      {
        ((VideoPlayerView)localView).c();
        QLog.d("SubscribePlayerManager", 4, "onStop pause video position:" + localahbd.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(ahbd paramahbd, int paramInt)
  {
    if (paramahbd != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramahbd.jdField_b_of_type_Int));
      View localView = paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localView instanceof CleanVideoPlayerView))
      {
        paramahbd.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).i()) {
          ((VideoPlayerView)localView).c();
        }
        ((VideoPlayerView)localView).b();
        a(paramahbd, false);
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
 * Qualified Name:     aanu
 * JD-Core Version:    0.7.0.1
 */