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
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.2;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class ajav
  extends blgi
  implements aizo, Handler.Callback, bbtd, blfg, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  private aiyl jdField_a_of_type_Aiyl = new aiyl();
  private aiyr jdField_a_of_type_Aiyr;
  private aizi jdField_a_of_type_Aizi;
  private Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private bbvn jdField_a_of_type_Bbvn;
  public SystemMsgListView a;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  public XListView a;
  protected Runnable a;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<aiyz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ConcurrentLinkedQueue<Long> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public ajav(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, SystemMsgListView paramSystemMsgListView, int paramInt, FlingHandler paramFlingHandler)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new SystemMsgListAdapter.2(this);
    this.b = paramInt;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = paramSystemMsgListView;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Aizi = ((aizi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    this.jdField_a_of_type_Bbvn = ((bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bbvn.a(this);
    this.jdField_a_of_type_Aizi.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.jdField_a_of_type_Aizi.a(0);
  }
  
  private aiyz a(ajbn paramajbn, int paramInt)
  {
    Object localObject = null;
    if ((paramajbn instanceof ajbh)) {
      localObject = new aiyt(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
    }
    do
    {
      aizy localaizy;
      Handler localHandler;
      do
      {
        do
        {
          return localObject;
          if ((paramajbn instanceof ajbg))
          {
            if (this.jdField_a_of_type_Aiyr == null)
            {
              paramajbn = new aiyr(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
              this.jdField_a_of_type_Aiyr = ((aiyr)paramajbn);
              return paramajbn;
            }
            localObject = this.jdField_a_of_type_Aiyr;
            ((aiyz)localObject).a(paramajbn);
            return localObject;
          }
          if (!(paramajbn instanceof ajbi)) {
            break;
          }
          paramajbn = new ajat(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
          localObject = paramajbn;
        } while (((ajat)paramajbn).a == 0L);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(Long.valueOf(((ajat)paramajbn).a));
        return paramajbn;
        if ((paramajbn instanceof ajbq)) {
          return new ajaa(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbo)) {
          return new aizp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbl)) {
          return new aizc(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbm)) {
          return new aize(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbw)) {
          return new ajam(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbx)) {
          return new ajao(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajby)) {
          return new ajaq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbv)) {
          return new ajak(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbr)) {
          return new ajac(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if ((paramajbn instanceof ajbs))
        {
          paramajbn = new ajae(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
          boolean bool = b(paramInt);
          ((ajae)paramajbn).a(bool);
          return paramajbn;
        }
        if ((paramajbn instanceof ajbj)) {
          return new aizg(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        }
        if (!(paramajbn instanceof ajbp)) {
          break;
        }
        localaizy = new aizy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
        localHandler = this.jdField_a_of_type_AndroidOsHandler;
        localObject = localaizy;
      } while (localHandler == null);
      localHandler.removeMessages(3);
      localHandler.sendMessage(localHandler.obtainMessage(3, paramajbn));
      return localaizy;
    } while (!(paramajbn instanceof ajbt));
    return new ajag(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, paramajbn);
  }
  
  private void a(aiys paramaiys)
  {
    Bitmap localBitmap;
    if ((paramaiys.jdField_a_of_type_JavaLangString != null) && (paramaiys.jdField_a_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramaiys.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        paramaiys.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramaiys.jdField_b_of_type_JavaLangString != null) && (paramaiys.jdField_b_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramaiys.jdField_b_of_type_JavaLangString);
      if (localBitmap != null) {
        paramaiys.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramaiys.jdField_c_of_type_JavaLangString != null) && (paramaiys.jdField_c_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramaiys.jdField_c_of_type_JavaLangString);
      if (localBitmap != null) {
        paramaiys.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramaiys.jdField_d_of_type_JavaLangString != null) && (paramaiys.jdField_d_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramaiys.jdField_d_of_type_JavaLangString);
      if (localBitmap != null) {
        paramaiys.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
    if ((paramaiys.jdField_e_of_type_JavaLangString != null) && (paramaiys.jdField_e_of_type_JavaLangString.length() > 0))
    {
      localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(paramaiys.jdField_e_of_type_JavaLangString);
      if (localBitmap != null) {
        paramaiys.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      }
    }
  }
  
  private void a(ajbp paramajbp)
  {
    if ((paramajbp == null) || (paramajbp.a == null) || (paramajbp.a.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMsgListAdapter", 2, "refreshHead null");
      }
    }
    do
    {
      return;
      paramajbp = paramajbp.a;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramajbp, b());
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
      this.jdField_a_of_type_Aiyl.c();
      c();
    }
    anyb localanyb;
    Bundle localBundle;
    if ((NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext)) && (a(paramInt2)))
    {
      localanyb = (anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      localBundle = new Bundle();
      localBundle.putString("from", "3");
      if (paramInt1 > 0) {
        break label98;
      }
      localBundle.putInt("load_biz_type", 1);
      localanyb.a(4, this.jdField_a_of_type_Aiyl.jdField_a_of_type_Int, localBundle);
    }
    label98:
    while (paramInt1 >= 5) {
      return;
    }
    localBundle.putInt("load_biz_type", 3);
    localanyb.b(4, this.jdField_a_of_type_Aiyl.jdField_a_of_type_Int, localBundle);
  }
  
  public int a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition();
    if (i == 0) {
      return 0;
    }
    return i - 1;
  }
  
  public aiyl a()
  {
    return this.jdField_a_of_type_Aiyl;
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return bheg.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Aiyl != null)
    {
      this.jdField_a_of_type_Aiyl.b = paramInt2;
      this.jdField_a_of_type_Aiyl.jdField_a_of_type_Int = paramInt1;
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
  
  public void a(aiyz paramaiyz)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramaiyz);
    }
  }
  
  public void a(ajau paramajau)
  {
    if ((paramajau == null) || (paramajau.jdField_f_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    int i = paramajau.a.msg.src_id.get();
    Object localObject1;
    if ((i == 3007) || (i == 3019) || (i == 2007) || (i == 4007) || (i == 2019))
    {
      localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject1 != null) && (((anvk)localObject1).b(String.valueOf(paramajau.a.req_uin.get())))) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject2;
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(32, String.valueOf(paramajau.a.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramajau.a.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = bheg.a();
        }
        paramajau.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
        i = 1;
        break;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, String.valueOf(paramajau.a.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(String.valueOf(paramajau.a.req_uin.get()), 1, true);
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
    Iterator localIterator = ((anyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a().iterator();
    while (localIterator.hasNext()) {
      if (((aixy)localIterator.next()).jdField_a_of_type_Int == i) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = ((ajmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c();
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
  
  public void af_()
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
    if (this.jdField_a_of_type_Aiyl != null) {
      return this.jdField_a_of_type_Aiyl.jdField_a_of_type_Int;
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
    if (this.jdField_a_of_type_Aiyl != null) {
      return this.jdField_a_of_type_Aiyl.b;
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
      if ((localObject instanceof ajau)) {
        a((ajau)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof aiyu))
        {
          localObject = (aiyu)localObject;
          ((aiyu)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiyu)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof aiyw))
        {
          localObject = (aiyw)localObject;
          ((aiyw)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((aiyw)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof ajan))
        {
          localObject = (ajan)localObject;
          ((ajan)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((ajan)localObject).jdField_f_of_type_JavaLangString));
        }
        else if ((localObject instanceof aiys))
        {
          localObject = (aiys)localObject;
          if ((((aiys)localObject).jdField_a_of_type_JavaLangString != null) && (((aiys)localObject).jdField_a_of_type_JavaLangString.length() > 0)) {
            ((aiys)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiys)localObject).jdField_a_of_type_JavaLangString));
          }
          if ((((aiys)localObject).jdField_b_of_type_JavaLangString != null) && (((aiys)localObject).jdField_b_of_type_JavaLangString.length() > 0)) {
            ((aiys)localObject).jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiys)localObject).jdField_b_of_type_JavaLangString));
          }
          if ((((aiys)localObject).jdField_c_of_type_JavaLangString != null) && (((aiys)localObject).jdField_c_of_type_JavaLangString.length() > 0)) {
            ((aiys)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiys)localObject).jdField_c_of_type_JavaLangString));
          }
          if ((((aiys)localObject).jdField_d_of_type_JavaLangString != null) && (((aiys)localObject).jdField_d_of_type_JavaLangString.length() > 0)) {
            ((aiys)localObject).jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiys)localObject).jdField_d_of_type_JavaLangString));
          }
          if ((((aiys)localObject).jdField_e_of_type_JavaLangString != null) && (((aiys)localObject).jdField_e_of_type_JavaLangString.length() > 0)) {
            ((aiys)localObject).jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(a(11, ((aiys)localObject).jdField_e_of_type_JavaLangString));
          }
        }
        else if ((localObject instanceof ajal))
        {
          localObject = (ajal)localObject;
          ((ajal)localObject).jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(a(1, ((ajal)localObject).jdField_f_of_type_JavaLangString));
        }
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
  }
  
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
    }
  }
  
  public void g() {}
  
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
    paramView = ((aiyz)getItem(paramInt)).a(paramInt, paramView);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(null);
    this.jdField_a_of_type_Aizi.a(0);
    this.jdField_a_of_type_Aizi.b(this);
    this.jdField_a_of_type_Bbvn.b(this);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
        a((ajbp)paramMessage.obj);
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
        aiyz localaiyz = (aiyz)getItem(i);
        if ((localaiyz instanceof aiyv)) {
          ((aiyv)localaiyz).c();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
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
        aiyz localaiyz = (aiyz)getItem(i);
        if ((localaiyz instanceof aiyv)) {
          ((aiyv)localaiyz).b();
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
        Object localObject = (aiyz)getItem(i);
        if ((localObject instanceof aiyv))
        {
          localArrayList1.add(((aiyv)localObject).b());
          localArrayList2.add(((aiyv)localObject).a());
          localArrayList3.add(Integer.valueOf(((aiyv)localObject).b()));
          localArrayList4.add(((aiyv)localObject).a());
        }
        for (;;)
        {
          i += 1;
          break;
          if ((localObject instanceof aizy))
          {
            localObject = ((aizy)localObject).a();
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
  
  public void k_(int paramInt)
  {
    c();
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
          if (!(paramString instanceof aiys)) {
            break label73;
          }
          a((aiys)paramString);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          label73:
          if ((!(paramString instanceof ajab)) && (!(paramString instanceof aizq)) && (!(paramString instanceof aizd)) && (!(paramString instanceof aizz)) && (!(paramString instanceof ajaj)) && (!(paramString instanceof ajaf)) && (!(paramString instanceof aizh)) && (!(paramString instanceof ajah)) && (!(paramString instanceof ajad)))
          {
            paramString = (aizb)paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajav
 * JD-Core Version:    0.7.0.1
 */