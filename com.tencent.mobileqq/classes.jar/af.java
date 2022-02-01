import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.DLFilesViewerActivity;
import com.dataline.util.file.DLFileInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class af
  implements View.OnClickListener
{
  public af(DLFilesViewerActivity paramDLFilesViewerActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject3 = dr.a((DataLineMsgRecord)((Iterator)localObject1).next());
    } while ((((DLFileInfo)localObject3).a != 0) && (((DLFileInfo)localObject3).a != 3));
    for (int i = 1;; i = 0)
    {
      anjx localanjx = (anjx)this.a.app.a(8);
      if (i != 0)
      {
        if ((!DLFilesViewerActivity.a(this.a).isReportPause) && (DLFilesViewerActivity.a(this.a).getGroupType() == -2335))
        {
          DLFilesViewerActivity.a(this.a).isReportPause = true;
          dq.m(this.a.app);
        }
        DLFilesViewerActivity.a(this.a).setPaused(true);
        if ((!DLFilesViewerActivity.a(this.a).isSingle()) && (DLFilesViewerActivity.a(this.a).getGroupType() != -2335))
        {
          localanjx.a(DLFilesViewerActivity.a(this.a).getGroupId(), 0L, false);
          DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
        }
      }
      for (;;)
      {
        DLFilesViewerActivity.a(this.a);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject1 = DLFilesViewerActivity.a(this.a).values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DataLineMsgRecord)((Iterator)localObject1).next();
          localObject3 = dr.a((DataLineMsgRecord)localObject2);
          if ((((DLFileInfo)localObject3).a == 0) || (((DLFileInfo)localObject3).a == 3)) {
            localanjx.a(((DataLineMsgRecord)localObject2).groupId, ((DataLineMsgRecord)localObject2).sessionid, false);
          }
        }
        break;
        if (bgnt.d(this.a))
        {
          if ((atvo.a()) && (DLFilesViewerActivity.a(this.a).getFileTotalSize() > 3145728L))
          {
            localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
            atvo.a(((DataLineMsgRecord)localObject1).isSendFromLocal(), this.a, new ag(this, (DataLineMsgRecord)localObject1, localanjx));
          }
          else
          {
            localObject1 = DLFilesViewerActivity.a(this.a).getFirstItem();
            if ((localObject1 != null) && (!((DataLineMsgRecord)localObject1).isSendFromLocal()) && (((DataLineMsgRecord)localObject1).strMoloKey != null)) {
              localanjx.b(112);
            }
            DLFilesViewerActivity.a(this.a).setPaused(false);
            Iterator localIterator = DLFilesViewerActivity.a(this.a).values().iterator();
            localObject1 = null;
            if (localIterator.hasNext())
            {
              DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
              DLFileInfo localDLFileInfo = dr.a(localDataLineMsgRecord);
              if (localDLFileInfo.a == 1)
              {
                localObject3 = localObject2;
                if (localObject2 == null) {
                  localObject3 = new ArrayList();
                }
                ((ArrayList)localObject3).add(localDataLineMsgRecord);
                localObject2 = localObject3;
              }
              for (;;)
              {
                break;
                if (localDLFileInfo.a != 4)
                {
                  localObject3 = localObject1;
                  if (localDLFileInfo.a != 2) {}
                }
                else
                {
                  if ((localDataLineMsgRecord.fileMsgStatus == 1L) && (localDataLineMsgRecord.strMoloKey != null)) {
                    dq.e(this.a.app);
                  }
                  localObject3 = localObject1;
                  if (localObject1 == null) {
                    localObject3 = new ArrayList();
                  }
                  ((List)localObject3).add(Long.valueOf(localDataLineMsgRecord.sessionid));
                  localDataLineMsgRecord.fileMsgStatus = 0L;
                  i = DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid);
                  this.a.app.a().a(i).c(localDataLineMsgRecord.msgId);
                }
                localObject1 = localObject3;
              }
            }
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
              localanjx.a((ArrayList)localObject2, true);
            }
            if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
              localanjx.a((List)localObject1);
            }
            DLFilesViewerActivity.a(this.a).notifyDataSetChanged();
          }
        }
        else {
          atvf.a(2131693991);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     af
 * JD-Core Version:    0.7.0.1
 */