import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.1;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aipn
  extends bfxe
  implements akbt, Handler.Callback, awcf, baxz, bfvz
{
  public int a;
  private afjl jdField_a_of_type_Afjl;
  private afmj jdField_a_of_type_Afmj = new afmj();
  private akbn jdField_a_of_type_Akbn;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private aweq jdField_a_of_type_Aweq;
  private baxy jdField_a_of_type_Baxy;
  public SystemMsgListView a;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public XListView a;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<afjt> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public aipn(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_JavaLangRunnable = new SystemMsgListAdapter.2(this);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = paramSystemMsgListView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Baxy = new baxy(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_Akbn = ((akbn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34));
    this.jdField_a_of_type_Aweq = ((aweq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aweq.a(this);
    this.jdField_a_of_type_Akbn.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_Akbn.a(0);
  }
  
  private void a(atzc paramatzc)
  {
    if ((paramatzc == null) || (paramatzc.a == null) || (paramatzc.a.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
      }
    }
    do
    {
      return;
      paramatzc = paramatzc.a;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramatzc, b());
  }
  
  private void b(int paramInt)
  {
    ThreadManager.postImmediately(new SystemMsgListAdapter.1(this, paramInt), null, true);
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramInt);
    }
    return false;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      this.jdField_a_of_type_Afmj.c();
      c();
    }
    akaa localakaa;
    Bundle localBundle;
    if ((bbfj.d(this.jdField_a_of_type_AndroidContentContext)) && (a(paramInt2)))
    {
      localakaa = (akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
      localBundle = new Bundle();
      localBundle.putString("from", "3");
      if (paramInt1 > 0) {
        break label95;
      }
      localBundle.putInt("load_biz_type", 1);
      localakaa.a(4, this.jdField_a_of_type_Afmj.jdField_a_of_type_Int, localBundle);
    }
    label95:
    while (paramInt1 >= 5) {
      return;
    }
    localBundle.putInt("load_biz_type", 3);
    localakaa.b(4, this.jdField_a_of_type_Afmj.jdField_a_of_type_Int, localBundle);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    if (i == 0) {
      return 0;
    }
    return i - 1;
  }
  
  public afmj a()
  {
    return this.jdField_a_of_type_Afmj;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Baxy.a(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.a(paramString, paramInt, true, (byte)0);
    }
    return bbef.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Afmj != null)
    {
      this.jdField_a_of_type_Afmj.b = paramInt2;
      this.jdField_a_of_type_Afmj.jdField_a_of_type_Int = paramInt1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramInt2 == 200) && (paramBitmap != null)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(long paramLong)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  public void a(afjt paramafjt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramafjt);
    }
  }
  
  public void a(aflh paramaflh)
  {
    if ((paramaflh == null) || (paramaflh.jdField_f_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramaflh.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((localObject1 != null) && (((ajxl)localObject1).b(String.valueOf(paramaflh.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_Baxy.a(32, String.valueOf(paramaflh.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxy.a())
          {
            this.jdField_a_of_type_Baxy.a(String.valueOf(paramaflh.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bbef.a();
        }
        paramaflh.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_Baxy.a(1, String.valueOf(paramaflh.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_Baxy.a())
          {
            this.jdField_a_of_type_Baxy.a(String.valueOf(paramaflh.a.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      i = 0;
    }
  }
  
  public boolean a()
  {
    int i = b();
    Iterator localIterator = ((akaa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a().iterator();
    while (localIterator.hasNext()) {
      if (((aflw)localIterator.next()).jdField_a_of_type_Int == i) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = ((afry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295)).c();
    if (paramInt == 23) {}
    for (paramInt = 1; (paramInt != 0) || (!bool); paramInt = 0) {
      return true;
    }
    return false;
  }
  
  public void a_(View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      if (!(paramView instanceof Integer)) {}
    }
    for (int i = ((Integer)paramView).intValue();; i = -1)
    {
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void ag_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onMayKnowStatesChanged");
    }
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(2);
      localHandler.sendEmptyMessageDelayed(2, 200L);
      localHandler.removeMessages(1);
      localHandler.sendEmptyMessageDelayed(1, 2000L);
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Afmj != null) {
      return this.jdField_a_of_type_Afmj.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SystemMsgListAdapter", 2, "onConnectionTabSelected tabId : " + paramInt1 + ", position =" + paramInt2);
    }
    a(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setStickHeadSelection(paramInt2);
    }
    a(0L);
  }
  
  public void b(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.iterator();
      Long localLong;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLong = (Long)localIterator.next();
      } while ((localLong == null) || (localLong.longValue() != paramLong));
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        c();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "checkIfNeedUpdate discussUin: %d needRefresh: %b", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Afmj != null) {
      return this.jdField_a_of_type_Afmj.b;
    }
    return -1;
  }
  
  public void c()
  {
    a(400L);
  }
  
  public void d()
  {
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i).getTag();
      if ((localObject instanceof aflh)) {
        a((aflh)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof afjo))
        {
          localObject = (afjo)localObject;
          ((afjo)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjo)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof afjq))
        {
          localObject = (afjq)localObject;
          ((afjq)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((afjq)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof afla))
        {
          localObject = (afla)localObject;
          ((afla)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afla)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof afjm))
        {
          localObject = (afjm)localObject;
          if ((((afjm)localObject).jdField_a_of_type_JavaLangString != null) && (((afjm)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
            ((afjm)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjm)localObject).jdField_a_of_type_JavaLangString));
          }
          if ((((afjm)localObject).jdField_b_of_type_JavaLangString != null) && (((afjm)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
            ((afjm)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjm)localObject).jdField_b_of_type_JavaLangString));
          }
          if ((((afjm)localObject).jdField_c_of_type_JavaLangString != null) && (((afjm)localObject).jdField_c_of_type_JavaLangString.length() > 0)) {
            ((afjm)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjm)localObject).jdField_c_of_type_JavaLangString));
          }
          if ((((afjm)localObject).jdField_d_of_type_JavaLangString != null) && (((afjm)localObject).jdField_d_of_type_JavaLangString.length() > 0)) {
            ((afjm)localObject).jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjm)localObject).jdField_d_of_type_JavaLangString));
          }
          if ((((afjm)localObject).jdField_e_of_type_JavaLangString != null) && (((afjm)localObject).jdField_e_of_type_JavaLangString.length() > 0)) {
            ((afjm)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((afjm)localObject).jdField_e_of_type_JavaLangString));
          }
        }
        else if ((localObject instanceof afky))
        {
          localObject = (afky)localObject;
          ((afky)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((afky)localObject).jdField_f_of_type_JavaLangString));
        }
      }
    }
  }
  
  public void e() {}
  
  public void e(boolean paramBoolean)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
      if (((FlingGestureHandler)localObject).mTopLayout != null)
      {
        localObject = ((FlingGestureHandler)localObject).mTopLayout;
        if (paramBoolean) {
          break label49;
        }
      }
    }
    label49:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
      return;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Baxy.a();
    this.jdField_a_of_type_Baxy.c();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Baxy.a()) {
      this.jdField_a_of_type_Baxy.b();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return new Object();
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((afjt)getItem(paramInt)).a(paramInt, paramView);
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
    this.jdField_a_of_type_Akbn.a(0);
    this.jdField_a_of_type_Akbn.b(this);
    this.jdField_a_of_type_Aweq.b(this);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Baxy.a(null);
    this.jdField_a_of_type_Baxy.d();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b(b());
    }
    for (;;)
    {
      return false;
      if (paramMessage.what == 2) {
        notifyDataSetChanged();
      } else if (paramMessage.what == 3) {
        a((atzc)paramMessage.obj);
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "stopVisibleExpose firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        afjt localafjt = (afjt)getItem(i);
        if ((localafjt instanceof afjp)) {
          ((afjp)localafjt).c();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void i_(int paramInt)
  {
    c();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      while ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        afjt localafjt = (afjt)getItem(i);
        if ((localafjt instanceof afjp)) {
          ((afjp)localafjt).b();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "onResume firstVisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition() + " lastvisible: " + this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition());
    }
    if ((getCount() > 0) && (this.jdField_a_of_type_ComTencentWidgetXListView.isShown()))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
      if ((i <= this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition()) && (i < getCount()))
      {
        Object localObject = (afjt)getItem(i);
        if ((localObject instanceof afjp))
        {
          localArrayList1.add(((afjp)localObject).b());
          localArrayList2.add(((afjp)localObject).a());
          localArrayList3.add(Integer.valueOf(((afjp)localObject).b()));
          localArrayList4.add(((afjp)localObject).a());
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof afkl))
          {
            localObject = ((afkl)localObject).a();
            if (localObject != null) {
              localArrayList5.addAll((Collection)localObject);
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SystemMsgListAdapter", 2, "reportRecommendFrdExpose exp_uins: " + localArrayList1 + " exp_reasons:" + localArrayList2 + " exp_positions:" + localArrayList3 + " algh_ids:" + localArrayList4);
      }
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(), localArrayList1, localArrayList2, localArrayList3, localArrayList4, 0, "3");
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.jdField_a_of_type_JavaUtilHashtable.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if (paramString != null)
        {
          if (!(paramString instanceof afjm)) {
            break label305;
          }
          paramString = (afjm)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_b_of_type_JavaLangString != null) && (paramString.jdField_b_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_b_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_c_of_type_JavaLangString != null) && (paramString.jdField_c_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_c_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_d_of_type_JavaLangString != null) && (paramString.jdField_d_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_d_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
          if ((paramString.jdField_e_of_type_JavaLangString != null) && (paramString.jdField_e_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_e_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label305:
          if ((!(paramString instanceof afko)) && (!(paramString instanceof afkd)) && (!(paramString instanceof afjx)) && (!(paramString instanceof afkm)) && (!(paramString instanceof afkw)) && (!(paramString instanceof afks)) && (!(paramString instanceof afkb)) && (!(paramString instanceof afku)) && (!(paramString instanceof afkq)))
          {
            paramString = (afjv)paramString;
            if ((paramString.jdField_f_of_type_JavaLangString != null) && (paramString.jdField_f_of_type_JavaLangString.length() > 0))
            {
              paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramString.jdField_f_of_type_JavaLangString);
              if (paramBitmap != null) {
                paramString.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
              }
            }
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aipn
 * JD-Core Version:    0.7.0.1
 */