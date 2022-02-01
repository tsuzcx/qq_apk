import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class aaje
  implements aakb
{
  aaje(aaiu paramaaiu) {}
  
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
                        aaej.a(aaiu.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(aaiu.a(), 1, "click comment, feedId: " + aaiu.a(this.a).id + " commentId: " + paramView.id);
                      aaiu.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(aaiu.a(), 1, "click reply, feedId: " + aaiu.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  aaiu.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                aaiu.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = aaiu.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        aaiu.a(this.a, aaiu.a(this.a).a(aaiu.a(this.a), paramView));
        aaiu.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    aaiu.a(this.a).a(aaiu.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    aaiu.c(this.a, true);
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
        aaiu.a(this.a, new aahs(aaiu.a(this.a), false, true));
        aaiu.a(this.a).a(aaiu.b(this.a).getString(2131691137), 0, new aajf(this, paramView));
        if (aaiu.a(this.a, paramView.postUser)) {
          aaiu.a(this.a).a(aaiu.d(this.a).getString(2131691320), 1, new aajg(this, paramView));
        }
        for (;;)
        {
          aaiu.a(this.a).a(aaiu.f(this.a).getString(2131690580));
          aaiu.a(this.a).show();
          return;
          aaiu.a(this.a).a(aaiu.e(this.a).getString(2131717453), 6, new aajh(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    aaiu.a(this.a, new aahs(aaiu.g(this.a), false, true));
    aaiu.a(this.a).a(aaiu.h(this.a).getString(2131691137), 0, new aaji(this, paramObject));
    if (aaiu.a(this.a, paramObject.postUser)) {
      aaiu.a(this.a).a(aaiu.j(this.a).getString(2131691320), 1, new aajj(this, paramView, paramObject));
    }
    for (;;)
    {
      aaiu.a(this.a).a(aaiu.l(this.a).getString(2131690580));
      aaiu.a(this.a).show();
      return;
      aaiu.a(this.a).a(aaiu.k(this.a).getString(2131717453), 6, new aajk(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaje
 * JD-Core Version:    0.7.0.1
 */