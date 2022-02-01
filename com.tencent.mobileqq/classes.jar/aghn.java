import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aghn
  extends atfq
{
  private aghn(aghl paramaghl) {}
  
  protected void a()
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    auea.a(paramLong, paramInt, paramString);
    bmuf.a(null, paramInt);
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      auea.c(paramString2);
      return;
    }
    auea.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      auea.c(paramString);
    }
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(atqb paramatqb)
  {
    if (paramatqb == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramatqb.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramatqb.a;
      if ((paramatqb.b != null) && (paramatqb.b.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramatqb.b;
        aghl.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        aghl.a(this.a).notifyDataSetChanged();
        return;
      }
    } while (localFileManagerEntity.thumbInvalidCode != 1);
    aghl.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    aghl.a(this.a).notifyDataSetChanged();
    auea.a(paramLong, paramInteger.intValue(), paramString);
    bmuf.a(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMHelper", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    paramString1 = aghl.a(this.a).getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6)) {
      if (bmqx.a(paramInt2))
      {
        if (!paramBoolean) {
          break label158;
        }
        bmrr.a(aghl.a(this.a), aghl.a(this.a).getActivity(), AIOUtils.getTitleBarHeight(aghl.a(this.a).mContext));
      }
    }
    for (;;)
    {
      aghl.a(this.a).notifyDataSetChanged();
      return;
      label158:
      if (bmqx.b())
      {
        bmqx.a(aghl.a(this.a));
      }
      else
      {
        if (!TextUtils.isEmpty(paramString2)) {
          QQToast.a(aghl.a(this.a).getApp(), paramString2, 1).b(AIOUtils.getTitleBarHeight(aghl.a(this.a).mContext));
        }
        for (;;)
        {
          bmuf.a(null, paramInt2);
          break;
          QQToast.a(aghl.a(this.a).getApp(), 2131692594, 1).b(AIOUtils.getTitleBarHeight(aghl.a(this.a).mContext));
        }
        if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(aghl.a(this.a).sessionInfo.curFriendUin)))
        {
          auea.a(paramLong2, paramInt2, paramString2);
          bmuf.a(null, paramInt2);
        }
      }
    }
  }
  
  protected void b()
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void c()
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
  
  protected void d()
  {
    aghl.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghn
 * JD-Core Version:    0.7.0.1
 */