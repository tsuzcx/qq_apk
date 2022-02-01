import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class aafd
  implements aaga
{
  aafd(aaet paramaaet) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StUser)));
                          paramView = (CertifiedAccountMeta.StUser)paramObject;
                        } while (paramView.type.get() != 1);
                        aaae.a(aaet.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(aaet.a(), 1, "click comment, feedId: " + aaet.a(this.a).id + " commentId: " + paramView.id);
                      aaet.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(aaet.a(), 1, "click reply, feedId: " + aaet.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  aaet.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                aaet.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = aaet.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        aaet.a(this.a, aaet.a(this.a).a(aaet.a(this.a), paramView));
        aaet.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    aaet.a(this.a).a(aaet.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    aaet.c(this.a, true);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        aaet.a(this.a, new aadr(aaet.a(this.a), false, true));
        aaet.a(this.a).a(aaet.b(this.a).getString(2131691137), 0, new aafe(this, paramView));
        if (aaet.a(this.a, paramView.postUser)) {
          aaet.a(this.a).a(aaet.d(this.a).getString(2131691317), 1, new aaff(this, paramView));
        }
        for (;;)
        {
          aaet.a(this.a).a(aaet.f(this.a).getString(2131690582));
          aaet.a(this.a).show();
          return;
          aaet.a(this.a).a(aaet.e(this.a).getString(2131717325), 6, new aafg(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    aaet.a(this.a, new aadr(aaet.g(this.a), false, true));
    aaet.a(this.a).a(aaet.h(this.a).getString(2131691137), 0, new aafh(this, paramObject));
    if (aaet.a(this.a, paramObject.postUser)) {
      aaet.a(this.a).a(aaet.j(this.a).getString(2131691317), 1, new aafi(this, paramView, paramObject));
    }
    for (;;)
    {
      aaet.a(this.a).a(aaet.l(this.a).getString(2131690582));
      aaet.a(this.a).show();
      return;
      aaet.a(this.a).a(aaet.k(this.a).getString(2131717325), 6, new aafj(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafd
 * JD-Core Version:    0.7.0.1
 */