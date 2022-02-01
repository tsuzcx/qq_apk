import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class aebs
{
  public static void a(bbox parambbox, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QZoneEntryReporterInLeba", 2, "Leba isTableModel:" + paramBoolean2);
    }
    int i3;
    int i2;
    label53:
    Object localObject1;
    int i;
    int j;
    int n;
    int m;
    int k;
    Object localObject2;
    label126:
    QZoneCountInfo localQZoneCountInfo1;
    label138:
    QZoneCountInfo localQZoneCountInfo2;
    if (parambbox != null)
    {
      i3 = parambbox.a(1);
      if (parambbox == null) {
        break label685;
      }
      i2 = parambbox.a(2);
      localObject1 = "";
      i = 0;
      j = 0;
      int i5 = 0;
      int i4 = 0;
      int i6 = 0;
      int i1 = 0;
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i3 > 0) {
        break label1008;
      }
      n = i6;
      m = i5;
      k = i;
      localObject2 = localObject1;
      if (i2 > 0) {
        break label1008;
      }
      if (parambbox == null) {
        break label691;
      }
      localObject2 = parambbox.a(6);
      if (parambbox == null) {
        break label697;
      }
      localQZoneCountInfo1 = parambbox.a(61);
      if (parambbox == null) {
        break label703;
      }
      localQZoneCountInfo2 = parambbox.a(3);
      label149:
      k = i1;
      i = j;
      parambbox = (bbox)localObject1;
      if (localObject2 != null)
      {
        k = i1;
        i = j;
        parambbox = (bbox)localObject1;
        if (((QZoneCountInfo)localObject2).friendList != null)
        {
          k = i1;
          i = j;
          parambbox = (bbox)localObject1;
          if (((QZoneCountInfo)localObject2).friendList.size() > 0)
          {
            k = i1;
            i = j;
            parambbox = (bbox)localObject1;
            if (((QZoneCountUserInfo)((QZoneCountInfo)localObject2).friendList.get(0)).uin > 0L)
            {
              k = i1;
              i = j;
              parambbox = (bbox)localObject1;
              if (((QZoneCountInfo)localObject2).uCount > 0L)
              {
                k = i1;
                i = j;
                parambbox = (bbox)localObject1;
                if (!TextUtils.isEmpty(((QZoneCountInfo)localObject2).strShowMsg))
                {
                  parambbox = ((QZoneCountInfo)localObject2).strShowMsg;
                  k = 1;
                  i = 1;
                }
              }
            }
          }
        }
      }
      i1 = k;
      j = i4;
      localObject1 = parambbox;
      if (k == 0)
      {
        i1 = k;
        j = i4;
        localObject1 = parambbox;
        if (localQZoneCountInfo1 != null)
        {
          i1 = k;
          j = i4;
          localObject1 = parambbox;
          if (localQZoneCountInfo1.friendList != null)
          {
            i1 = k;
            j = i4;
            localObject1 = parambbox;
            if (localQZoneCountInfo1.friendList.size() > 0)
            {
              i1 = k;
              j = i4;
              localObject1 = parambbox;
              if (((QZoneCountUserInfo)localQZoneCountInfo1.friendList.get(0)).uin > 0L)
              {
                i1 = k;
                j = i4;
                localObject1 = parambbox;
                if (localQZoneCountInfo1.uCount > 0L)
                {
                  i1 = k;
                  j = i4;
                  localObject1 = parambbox;
                  if (!TextUtils.isEmpty(localQZoneCountInfo1.strShowMsg))
                  {
                    localObject1 = localQZoneCountInfo1.strShowMsg;
                    i1 = 1;
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (i1 != 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localQZoneCountInfo2 == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localQZoneCountInfo2.friendList == null) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localQZoneCountInfo2.friendList.size() <= 0) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (((QZoneCountUserInfo)localQZoneCountInfo2.friendList.get(0)).uin <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (localQZoneCountInfo2.uCount <= 0L) {
        break label1008;
      }
      n = i1;
      m = j;
      k = i;
      localObject2 = localObject1;
      if (TextUtils.isEmpty(localQZoneCountInfo2.strShowMsg)) {
        break label1008;
      }
      parambbox = localQZoneCountInfo2.strShowMsg;
      n = 1;
      m = 1;
      k = i;
      i = n;
    }
    for (;;)
    {
      if (i == 0) {
        if (i3 <= 0) {
          if (i2 <= 0) {
            if (paramBoolean1)
            {
              i = 1;
              label658:
              if (!paramBoolean2) {
                break label714;
              }
              parambbox = "1";
              label665:
              LpReportInfo_pf00064.report(637, 13, i, parambbox, "0", null);
            }
          }
        }
      }
      label685:
      label691:
      label697:
      label703:
      label714:
      label733:
      label762:
      do
      {
        return;
        i3 = 0;
        break;
        i2 = 0;
        break label53;
        localObject2 = null;
        break label126;
        localQZoneCountInfo1 = null;
        break label138;
        localQZoneCountInfo2 = null;
        break label149;
        i = 2;
        break label658;
        parambbox = "2";
        break label665;
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label762;
          }
          parambbox = "1";
          if (i2 <= 1) {
            break label768;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 11, i, parambbox, (String)localObject1, null);
          return;
          i = 2;
          break;
          parambbox = "2";
          break label733;
        }
        if (i2 <= 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label812;
            }
          }
          for (parambbox = "1";; parambbox = "2")
          {
            LpReportInfo_pf00064.report(637, 12, i, parambbox, "0", null);
            return;
            i = 2;
            break;
          }
        }
        if (paramBoolean1)
        {
          i = 1;
          if (!paramBoolean2) {
            break label860;
          }
          parambbox = "1";
          if (i2 <= 1) {
            break label866;
          }
        }
        for (localObject1 = "2";; localObject1 = "1")
        {
          LpReportInfo_pf00064.report(637, 14, i, parambbox, (String)localObject1, null);
          return;
          i = 2;
          break;
          parambbox = "2";
          break label831;
        }
        if (m != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label911;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 15, i, (String)localObject1, null, parambbox);
            return;
            i = 2;
            break;
          }
        }
        if (k != 0)
        {
          if (paramBoolean1)
          {
            i = 1;
            if (!paramBoolean2) {
              break label956;
            }
          }
          for (localObject1 = "1";; localObject1 = "2")
          {
            LpReportInfo_pf00064.report(637, 17, i, (String)localObject1, null, parambbox);
            return;
            i = 2;
            break;
          }
        }
      } while (j == 0);
      label768:
      label812:
      label831:
      label860:
      label866:
      if (paramBoolean1)
      {
        i = 1;
        if (!paramBoolean2) {
          break label1001;
        }
      }
      label911:
      label956:
      label1001:
      for (localObject1 = "1";; localObject1 = "2")
      {
        LpReportInfo_pf00064.report(637, 16, i, (String)localObject1, null, parambbox);
        return;
        i = 2;
        break;
      }
      label1008:
      i = n;
      j = m;
      m = 0;
      parambbox = (bbox)localObject2;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneEntryReporterInLeba", 2, "leba 曝光上报");
    }
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.actionType = "637";
    localReportInfo.subactionType = "10";
    QZoneClickReport.report(paramQQAppInterface.getAccount(), localReportInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aebs
 * JD-Core Version:    0.7.0.1
 */