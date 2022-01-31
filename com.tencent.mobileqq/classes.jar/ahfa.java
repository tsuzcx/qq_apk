import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ahfa
  extends Handler
{
  public ahfa(GroupSearchFragment paramGroupSearchFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    label899:
    label1179:
    label1214:
    label1356:
    label1876:
    label1879:
    label2026:
    label2029:
    label2811:
    label3837:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "START_SEARCH keyword = " + this.a.jdField_b_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
      {
        this.a.c.setVisibility(8);
        this.a.b();
        this.a.a(this.a.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment onViewCreated  startSearch");
          return;
          if (QLog.isColorLevel()) {
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GET_LOCAL_MSG");
          }
          this.a.jdField_a_of_type_Long = System.currentTimeMillis();
          this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
          if ((this.a.jdField_b_of_type_JavaUtilList != null) && (!this.a.jdField_b_of_type_JavaUtilList.isEmpty()))
          {
            this.a.c();
            this.a.c.setVisibility(0);
            return;
            if (QLog.isColorLevel()) {
              QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "FINISH_LOCAL_MSG");
            }
            if ((this.a.jdField_b_of_type_JavaUtilList != null) && (!this.a.jdField_b_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.c.setVisibility(8);
              this.a.b(false);
            }
            this.a.d(false);
            this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
            return;
            if (QLog.isColorLevel()) {
              QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "FINISH_NET_MSG");
            }
            if ((this.a.jdField_b_of_type_JavaUtilList != null) && (!this.a.jdField_b_of_type_JavaUtilList.isEmpty()))
            {
              this.a.c();
              this.a.c.setVisibility(0);
              this.a.b(false);
            }
            this.a.d(false);
            this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.a.jdField_b_of_type_JavaUtilList);
            if (this.a.jdField_b_of_type_JavaUtilList == null) {}
            int k;
            int j;
            for (int i = 0;; i = this.a.jdField_b_of_type_JavaUtilList.size())
            {
              k = i;
              if (i > 2) {
                break;
              }
              k = i;
              if (this.a.jdField_b_of_type_JavaUtilList == null) {
                break;
              }
              j = 0;
              for (;;)
              {
                k = i;
                if (j >= this.a.jdField_b_of_type_JavaUtilList.size()) {
                  break;
                }
                k = i;
                if ((this.a.jdField_b_of_type_JavaUtilList.get(j) instanceof SearchResultModelForEntrance)) {
                  k = i - 1;
                }
                j += 1;
                i = k;
              }
            }
            if (k <= 0)
            {
              SearchUtils.a("all_result", "noresult_local", new String[] { "" + this.a.jdField_b_of_type_JavaLangString });
              return;
              paramMessage = (List)paramMessage.obj;
              if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
              }
              if ((paramMessage != null) && (paramMessage.size() != 0))
              {
                if (System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L)
                {
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  return;
                }
                this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                if (this.a.jdField_b_of_type_JavaUtilList != null) {
                  this.a.jdField_b_of_type_JavaUtilList.clear();
                }
                long l;
                for (;;)
                {
                  this.a.jdField_b_of_type_JavaUtilList.addAll(paramMessage);
                  if ((this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance != null) && (!this.a.jdField_b_of_type_JavaUtilList.contains(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance)))
                  {
                    this.a.jdField_b_of_type_JavaUtilList.add(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
                  }
                  l = System.currentTimeMillis();
                  if (l - this.a.jdField_a_of_type_Long < 50L) {
                    break;
                  }
                  this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                  this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(10);
                  return;
                  this.a.jdField_b_of_type_JavaUtilList = new ArrayList();
                }
                this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(10);
                this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 50L - (l - this.a.jdField_a_of_type_Long));
                return;
                Object localObject1 = (List)paramMessage.obj;
                int n = paramMessage.arg1;
                if ((n == 4) || (n == 5))
                {
                  j = 1;
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleMessage, GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status = " + n);
                  }
                  if (localObject1 != null) {
                    break label3833;
                  }
                }
                Object localObject2;
                for (paramMessage = new ArrayList();; paramMessage = localObject2)
                {
                  if ((paramMessage.size() == 0) && (j == 0)) {
                    break label3837;
                  }
                  if ((System.currentTimeMillis() - this.a.jdField_b_of_type_Long < 500L) && (j == 0))
                  {
                    this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                    return;
                    j = 0;
                    break label899;
                  }
                  this.a.jdField_b_of_type_Long = System.currentTimeMillis();
                  this.a.jdField_b_of_type_JavaUtilList = paramMessage;
                  if ((this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance != null) && (!this.a.jdField_b_of_type_JavaUtilList.contains(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance)))
                  {
                    this.a.jdField_b_of_type_JavaUtilList.add(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
                  }
                  Object localObject3;
                  Object localObject4;
                  int m;
                  Object localObject5;
                  if (j != 0)
                  {
                    if ((GroupSearchFragment.a(this.a) != 21) || (SearchEntryConfigManager.a() != 0))
                    {
                      i = 0;
                      if (i >= this.a.jdField_b_of_type_JavaUtilList.size()) {
                        break label3818;
                      }
                      if ((this.a.jdField_b_of_type_JavaUtilList.get(i) instanceof GroupSearchModelFunction))
                      {
                        localObject1 = (GroupSearchModelFunction)this.a.jdField_b_of_type_JavaUtilList.get(i);
                        localObject3 = (GroupSearchModeTitle)this.a.jdField_b_of_type_JavaUtilList.get(i - 1);
                        this.a.jdField_b_of_type_JavaUtilList.remove(localObject3);
                        this.a.jdField_b_of_type_JavaUtilList.remove(localObject1);
                        i = 0;
                        k = 0;
                        if (k >= paramMessage.size()) {
                          break label2126;
                        }
                        if ((paramMessage.get(k) instanceof GroupSearchModelLocalContact))
                        {
                          i = k + 1;
                          localObject4 = (GroupSearchModelLocalContact)paramMessage.get(k);
                          if (((GroupSearchModelLocalContact)localObject4).a() == null) {
                            break label1879;
                          }
                          m = ((GroupSearchModelLocalContact)localObject4).a().size();
                          if (m <= ((GroupSearchModelLocalContact)localObject4).a()) {
                            break label1876;
                          }
                          m = ((GroupSearchModelLocalContact)localObject4).a();
                          SearchUtils.a("all_result", "exp_contact", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + m });
                        }
                        if ((paramMessage.get(k) instanceof FTSGroupSearchModelMessage))
                        {
                          localObject4 = (FTSGroupSearchModelMessage)paramMessage.get(k);
                          if (((FTSGroupSearchModelMessage)localObject4).a() == null) {
                            break label1929;
                          }
                          m = ((FTSGroupSearchModelMessage)localObject4).a().size();
                          if (m <= ((FTSGroupSearchModelMessage)localObject4).a()) {
                            break label1926;
                          }
                          m = ((FTSGroupSearchModelMessage)localObject4).a();
                          SearchUtils.a("all_result", "exp_talk", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + m });
                        }
                        if ((paramMessage.get(k) instanceof GroupSearchModelFavorite))
                        {
                          localObject4 = (GroupSearchModelFavorite)paramMessage.get(k);
                          if (((GroupSearchModelFavorite)localObject4).a() == null) {
                            break label1979;
                          }
                          m = ((GroupSearchModelFavorite)localObject4).a().size();
                          if (m <= ((GroupSearchModelFavorite)localObject4).a()) {
                            break label1976;
                          }
                          m = ((GroupSearchModelFavorite)localObject4).a();
                          SearchUtils.a("all_result", "exp_collect", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + m });
                        }
                        if ((paramMessage.get(k) instanceof GroupSearchModelFileEntity))
                        {
                          localObject4 = (GroupSearchModelFileEntity)paramMessage.get(k);
                          if (((GroupSearchModelFileEntity)localObject4).a() == null) {
                            break label2029;
                          }
                          m = ((GroupSearchModelFileEntity)localObject4).a().size();
                          if (m <= ((GroupSearchModelFileEntity)localObject4).a()) {
                            break label2026;
                          }
                          m = ((GroupSearchModelFileEntity)localObject4).a();
                          SearchUtils.a("all_result", "exp_file", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + m });
                        }
                        if ((paramMessage.get(k) instanceof GroupSearchModelMultiChat))
                        {
                          localObject4 = (GroupSearchModelMultiChat)paramMessage.get(k);
                          if (((GroupSearchModelMultiChat)localObject4).a() == null) {
                            break label2079;
                          }
                          m = ((GroupSearchModelMultiChat)localObject4).a().size();
                          if (m <= ((GroupSearchModelMultiChat)localObject4).a()) {
                            break label2076;
                          }
                          m = ((GroupSearchModelMultiChat)localObject4).a();
                          SearchUtils.a("all_result", "exp_discuss", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + m });
                        }
                      }
                      for (;;)
                      {
                        k += 1;
                        break label1214;
                        i += 1;
                        break;
                        break label1294;
                        SearchUtils.a("all_result", "exp_contact", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "0" });
                        break label1356;
                        break label1420;
                        SearchUtils.a("all_result", "exp_talk", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "0" });
                        break label1482;
                        break label1546;
                        SearchUtils.a("all_result", "exp_collect", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "0" });
                        break label1608;
                        break label1672;
                        SearchUtils.a("all_result", "exp_file", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "0" });
                        break label1734;
                        break label1798;
                        SearchUtils.a("all_result", "exp_discuss", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "0" });
                      }
                      if ((localObject1 != null) && (((GroupSearchModelFunction)localObject1).a() != null) && (((GroupSearchModelFunction)localObject1).a().size() > 0))
                      {
                        localObject4 = new StringBuilder();
                        k = 1;
                        while (k < ((GroupSearchModelFunction)localObject1).a().size() - 1)
                        {
                          ((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject1).a().get(k)).g = (k - 1);
                          k += 1;
                        }
                        m = Math.min(((GroupSearchModelFunction)localObject1).a().size(), ((GroupSearchModelFunction)localObject1).a());
                        if (m > 0)
                        {
                          k = 0;
                          while (k < m - 1)
                          {
                            localObject5 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject1).a().get(k);
                            ((StringBuilder)localObject4).append(((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaLangString + "::");
                            k += 1;
                          }
                          localObject5 = (GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject1).a().get(m - 1);
                          ((StringBuilder)localObject4).append(((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaLangString + "");
                        }
                        if (!((GroupBaseNetSearchModelItem)((GroupSearchModelFunction)localObject1).a().get(0)).c.equals(this.a.jdField_b_of_type_JavaLangString)) {
                          break label2811;
                        }
                        this.a.jdField_b_of_type_JavaUtilList.add(0, localObject3);
                        this.a.jdField_b_of_type_JavaUtilList.add(1, localObject1);
                        SearchUtils.a("all_result", "exp_function", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "1" });
                      }
                    }
                    if (SearchEntryConfigManager.a(GroupSearchFragment.a(this.a)) != 0)
                    {
                      if (this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance == null) {
                        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance = new SearchResultModelForEntrance(this.a.jdField_b_of_type_JavaLangString, -1, 2130839204, true);
                      }
                      if (!this.a.jdField_b_of_type_JavaUtilList.contains(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance))
                      {
                        this.a.jdField_b_of_type_JavaUtilList.add(this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
                        this.a.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance.jdField_a_of_type_JavaLangString = this.a.jdField_b_of_type_JavaLangString;
                      }
                      SearchUtils.a("all_result", "exp_people_group", new String[] { this.a.jdField_b_of_type_JavaLangString });
                    }
                    if (this.a.g == 6)
                    {
                      this.a.h = 0;
                      if (this.a.g == 0)
                      {
                        paramMessage = paramMessage.iterator();
                        for (;;)
                        {
                          if (!paramMessage.hasNext()) {
                            break label2959;
                          }
                          localObject1 = paramMessage.next();
                          if (((localObject1 instanceof GroupSearchModelFavorite)) || ((localObject1 instanceof GroupSearchModelFileEntity)) || ((localObject1 instanceof GroupSearchModelLocalContact)) || ((localObject1 instanceof GroupSearchModelMultiChat)) || ((localObject1 instanceof GroupSearchModelMessage)) || ((localObject1 instanceof FTSGroupSearchModelMessage)) || (((localObject1 instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)localObject1).b() == 268435456)))
                          {
                            if ((localObject1 instanceof ISearchResultGroupModel))
                            {
                              localObject1 = (ISearchResultGroupModel)localObject1;
                              if ((localObject1 == null) || (((ISearchResultGroupModel)localObject1).a() == null)) {}
                              for (i = 0;; i = ((ISearchResultGroupModel)localObject1).a().size())
                              {
                                localObject3 = this.a;
                                k = ((GroupSearchFragment)localObject3).h;
                                ((GroupSearchFragment)localObject3).h = (Math.min(i, ((ISearchResultGroupModel)localObject1).a()) + k);
                                break label2657;
                                this.a.jdField_b_of_type_JavaUtilList.add(i, localObject3);
                                this.a.jdField_b_of_type_JavaUtilList.add(i + 1, localObject1);
                                SearchUtils.a("all_result", "exp_function", new String[] { "" + this.a.jdField_b_of_type_JavaLangString, "" + ((StringBuilder)localObject4).toString(), "", "0" });
                                break;
                              }
                            }
                            localObject1 = this.a;
                            ((GroupSearchFragment)localObject1).h += 1;
                          }
                        }
                      }
                      paramMessage = this.a;
                      if (n == 4)
                      {
                        i = 1;
                        paramMessage.jdField_b_of_type_Int = i;
                      }
                    }
                    else
                    {
                      boolean bool = false;
                      if ((this.a.getActivity() instanceof SearchInfoInterface)) {
                        bool = ((SearchInfoInterface)this.a.getActivity()).a();
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onFinish(). matchCount=" + this.a.h + " forceRequestStatus=" + this.a.g);
                      }
                      if (this.a.g == 0) {
                        this.a.g = 4;
                      }
                      if (bool) {
                        break label3422;
                      }
                      paramMessage = this.a;
                      if (n != 5) {
                        break label3417;
                      }
                      i = 4;
                      paramMessage.jdField_b_of_type_Int = i;
                      this.a.g();
                      i = 12;
                    }
                  }
                  for (;;)
                  {
                    l = System.currentTimeMillis();
                    if (l - this.a.jdField_a_of_type_Long >= 50L)
                    {
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(i);
                      if (j == 0) {
                        break label3466;
                      }
                      j = 0;
                      i = j;
                      if (this.a.jdField_b_of_type_JavaUtilList == null) {
                        break label3655;
                      }
                      i = j;
                      if (this.a.jdField_b_of_type_JavaUtilList.size() <= 0) {
                        break label3655;
                      }
                      paramMessage = this.a.jdField_b_of_type_JavaUtilList.iterator();
                      i = 0;
                      j = 0;
                      if (!paramMessage.hasNext()) {
                        break label3653;
                      }
                      localObject1 = paramMessage.next();
                      if ((!(localObject1 instanceof GroupSearchModelFavorite)) && (!(localObject1 instanceof GroupSearchModelFileEntity))) {
                        break label3468;
                      }
                      localObject3 = new SearchUtil.ObjectItemInfo();
                      k = i + 1;
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = k;
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long = SearchUtil.a((ISearchResultGroupModel)localObject1);
                      ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject1).b();
                      SearchUtil.c.put((ISearchResultGroupModel)localObject1, localObject3);
                      i = j + 1;
                      j = k;
                    }
                    for (;;)
                    {
                      k = j;
                      if ((localObject1 instanceof SearchResultModelForEntrance))
                      {
                        k = j;
                        if (((SearchResultModelForEntrance)localObject1).jdField_a_of_type_Int == -1)
                        {
                          localObject3 = new SearchUtil.ObjectItemInfo();
                          k = j + 1;
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = k;
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long = SearchUtil.a((SearchResultModelForEntrance)localObject1);
                          ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localObject1).jdField_a_of_type_JavaLangString;
                          SearchUtil.c.put((SearchResultModelForEntrance)localObject1, localObject3);
                        }
                      }
                      j = i;
                      i = k;
                      break label3212;
                      i = 2;
                      break label2972;
                      i = 3;
                      break label3100;
                      i = 11;
                      break label3115;
                      this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(i);
                      this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(i, 50L - (l - this.a.jdField_a_of_type_Long));
                      break label3160;
                      break;
                      if ((localObject1 instanceof ISearchResultGroupModel))
                      {
                        localObject3 = (ISearchResultGroupModel)localObject1;
                        localObject4 = ((ISearchResultGroupModel)localObject3).a();
                        k = i;
                        m = j;
                        if (localObject4 != null)
                        {
                          m = Math.min(((List)localObject4).size(), ((ISearchResultGroupModel)localObject3).a());
                          k = 0;
                          while (k < Math.min(((List)localObject4).size(), ((ISearchResultGroupModel)localObject3).a()))
                          {
                            localObject5 = new SearchUtil.ObjectItemInfo();
                            i += 1;
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Int = i;
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_Long = SearchUtil.a((ISearchResultGroupModel)localObject1);
                            ((SearchUtil.ObjectItemInfo)localObject5).jdField_a_of_type_JavaLangString = ((ISearchResultGroupModel)localObject1).b();
                            SearchUtil.c.put(((List)localObject4).get(k), localObject5);
                            k += 1;
                          }
                          m = j + m;
                          k = i;
                        }
                        i = m;
                        j = k;
                      }
                      else
                      {
                        k = j + 1;
                        j = i;
                        i = k;
                      }
                    }
                    i = j;
                    paramMessage = new JSONObject();
                    try
                    {
                      paramMessage.put("project", UniteSearchReportController.a());
                      paramMessage.put("event_src", "client");
                      paramMessage.put("nav_num", i);
                      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                      UniteSearchReportController.a((QQAppInterface)localObject1, new ReportModelDC02528().module("all_result").action("exp_items").ver1(this.a.jdField_b_of_type_JavaLangString).ver2(UniteSearchReportController.a(GroupSearchFragment.a(this.a))).ver7(paramMessage.toString()).session_id(((QQAppInterface)localObject1).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
                      return;
                    }
                    catch (JSONException localJSONException)
                    {
                      for (;;)
                      {
                        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
                      }
                    }
                    localObject2 = null;
                    localObject3 = null;
                    break label1179;
                    i = 10;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahfa
 * JD-Core Version:    0.7.0.1
 */