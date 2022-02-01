package com.tencent.mm.wear.app.d.b;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.support.v4.app.at;
import com.tencent.mm.b.a.k;
import com.tencent.mm.b.a.l;
import com.tencent.mm.b.a.m;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.e.a.an;
import com.tencent.mm.e.a.j;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.v;
import com.tencent.mm.e.a.w;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.d.c;
import com.tencent.mm.wear.app.d.f;
import com.tencent.mm.wear.app.d.g;
import com.tencent.mm.wear.app.service.StepCountService;
import com.tencent.mm.wear.app.service.subservice.FailMsgIgnoreService;
import com.tencent.mm.wear.app.service.subservice.FailMsgOpenService;
import com.tencent.mm.wear.app.service.subservice.FailMsgResendService;
import com.tencent.mm.wear.app.service.subservice.FriendAcceptService;
import com.tencent.mm.wear.app.service.subservice.FriendIgnoreService;
import com.tencent.mm.wear.app.service.subservice.FriendOpenService;
import com.tencent.mm.wear.app.ui.message.ReplyVoipUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
  extends a
{
  private static Intent a(Context paramContext, int paramInt1, int paramInt2, String paramString, Class paramClass)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.putExtra("key_talker", paramString);
    paramContext.putExtra("key_notification_id", paramInt1);
    paramContext.putExtra("key_fun_id", paramInt2);
    return paramContext;
  }
  
  public final void a(int paramInt, final byte[] paramArrayOfByte)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      Object localObject1 = new w();
      try
      {
        ((w)localObject1).h(paramArrayOfByte);
        paramArrayOfByte = new com.tencent.mm.wear.app.d.d(MMApplication.getContext(), (w)localObject1);
        paramArrayOfByte.create();
        paramArrayOfByte.send();
        com.tencent.mm.wear.app.d.a.cg(2);
        return;
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.NotificationHandler", paramArrayOfByte);
        return;
      }
      localObject1 = new v();
      try
      {
        ((v)localObject1).h(paramArrayOfByte);
        if (((v)localObject1).XY)
        {
          ((NotificationManager)MMApplication.getContext().getSystemService("notification")).cancelAll();
          return;
        }
        g.a(MMApplication.getContext(), ((v)localObject1).XX);
        return;
        localObject1 = new com.tencent.mm.e.a.h();
      }
      catch (IOException paramArrayOfByte)
      {
        try
        {
          ((com.tencent.mm.e.a.h)localObject1).h(paramArrayOfByte);
          paramArrayOfByte = f.i(MMApplication.getContext(), "message_channel_id");
          paramArrayOfByte.aN();
          paramArrayOfByte.b(((com.tencent.mm.e.a.h)localObject1).Xr);
          paramArrayOfByte.c(((com.tencent.mm.e.a.h)localObject1).Xs);
          paramArrayOfByte.t(2130837543);
          paramArrayOfByte.a(BitmapFactory.decodeResource(MMApplication.getContext().getResources(), 2130837543));
          localObject2 = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, 11015, "", FailMsgResendService.class), 134217728);
          localObject3 = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, 11013, "", FailMsgIgnoreService.class), 134217728);
          localPendingIntent1 = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, 11014, "", FailMsgOpenService.class), 134217728);
          paramArrayOfByte.a(2130837576, com.tencent.mm.wear.app.d.d.ck(2131165223), (PendingIntent)localObject2);
          paramArrayOfByte.a(2130837578, com.tencent.mm.wear.app.d.d.ck(2131165219), (PendingIntent)localObject3);
          paramArrayOfByte.a(2130837582, com.tencent.mm.wear.app.d.d.ck(2131165221), localPendingIntent1);
          paramArrayOfByte.a(new long[] { 0L, 150L, 100L, 400L });
          g.a(MMApplication.getContext(), ((com.tencent.mm.e.a.h)localObject1).Xq, paramArrayOfByte.build());
          return;
          localObject1 = new j();
        }
        catch (IOException paramArrayOfByte)
        {
          try
          {
            PendingIntent localPendingIntent1;
            ((j)localObject1).h(paramArrayOfByte);
            localObject1 = ((j)localObject1).Xu.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            Object localObject2 = (com.tencent.mm.e.a.i)((Iterator)localObject1).next();
            Object localObject3 = f.i(MMApplication.getContext(), "message_channel_id");
            ((at)localObject3).aN();
            ((at)localObject3).b(((com.tencent.mm.e.a.i)localObject2).Xk);
            ((at)localObject3).c(((com.tencent.mm.e.a.i)localObject2).Xs);
            ((at)localObject3).t(2130837543);
            if (((com.tencent.mm.e.a.i)localObject2).Xt != null) {
              paramArrayOfByte = ((com.tencent.mm.e.a.i)localObject2).Xt.toByteArray();
            }
            for (paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);; paramArrayOfByte = BitmapFactory.decodeResource(MMApplication.getContext().getResources(), 2130837531))
            {
              ((at)localObject3).a(paramArrayOfByte);
              paramArrayOfByte = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, 11016, ((com.tencent.mm.e.a.i)localObject2).Xj, FriendAcceptService.class), 134217728);
              localPendingIntent1 = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, 11017, ((com.tencent.mm.e.a.i)localObject2).Xj, FriendIgnoreService.class), 134217728);
              PendingIntent localPendingIntent2 = PendingIntent.getService(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, a(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, 11018, ((com.tencent.mm.e.a.i)localObject2).Xj, FriendOpenService.class), 134217728);
              ((at)localObject3).a(2130837568, com.tencent.mm.wear.app.d.d.ck(2131165218), paramArrayOfByte);
              ((at)localObject3).a(2130837578, com.tencent.mm.wear.app.d.d.ck(2131165219), localPendingIntent1);
              ((at)localObject3).a(2130837582, com.tencent.mm.wear.app.d.d.ck(2131165221), localPendingIntent2);
              ((at)localObject3).a(new long[] { 0L, 150L, 100L, 400L });
              g.a(MMApplication.getContext(), ((com.tencent.mm.e.a.i)localObject2).Xq, ((at)localObject3).build());
              break;
            }
            paramArrayOfByte = new k();
            com.tencent.mm.sdk.a.a.YM.a(paramArrayOfByte);
            if (paramArrayOfByte.WV.WW) {
              continue;
            }
            paramArrayOfByte = new com.tencent.mm.wear.app.f.b(11021, null);
            com.tencent.mm.wear.app.b.h.mP().a(paramArrayOfByte);
            return;
            StepCountService.nF();
            return;
            paramArrayOfByte = new com.tencent.mm.wear.app.f.a(11003, new File(com.tencent.mm.wear.app.b.h.mW(), "log.log").getAbsolutePath());
            com.tencent.mm.wear.app.b.h.mP().a(paramArrayOfByte);
            return;
            paramArrayOfByte = new com.tencent.mm.wear.app.f.a(11000, new File(com.tencent.mm.wear.app.b.h.mV(), "crash.log").getAbsolutePath());
            com.tencent.mm.wear.app.b.h.mP().a(paramArrayOfByte);
            return;
            localObject1 = new an();
          }
          catch (IOException paramArrayOfByte)
          {
            try
            {
              ((an)localObject1).h(paramArrayOfByte);
              paramArrayOfByte = new Intent(MMApplication.getContext(), ReplyVoipUI.class);
              paramArrayOfByte.setFlags(268435456);
              paramArrayOfByte.putExtra("key_talker", ((an)localObject1).XI);
              paramArrayOfByte.putExtra("key_nickname", ((an)localObject1).Xk);
              com.tencent.mm.wear.a.b.a.amv.post(new Runnable()
              {
                public final void run()
                {
                  MMApplication.getContext().startActivity(paramArrayOfByte);
                }
              });
              return;
              paramArrayOfByte = new m();
              paramArrayOfByte.WX.WY = 0;
              com.tencent.mm.sdk.a.a.YM.a(paramArrayOfByte);
              return;
              paramArrayOfByte = new m();
              paramArrayOfByte.WX.WY = 1;
              com.tencent.mm.sdk.a.a.YM.a(paramArrayOfByte);
              return;
              localObject1 = new n();
            }
            catch (IOException paramArrayOfByte)
            {
              try
              {
                ((n)localObject1).h(paramArrayOfByte);
                new c((n)localObject1).nq();
                com.tencent.mm.wear.app.d.a.cg(2);
                return;
                localObject1 = new o();
                try
                {
                  ((o)localObject1).h(paramArrayOfByte);
                  paramArrayOfByte = new com.tencent.mm.b.a.d();
                  paramArrayOfByte.WO.WP = ((o)localObject1);
                  com.tencent.mm.sdk.a.a.YM.a(paramArrayOfByte, Looper.getMainLooper());
                  return;
                }
                catch (IOException paramArrayOfByte)
                {
                  com.tencent.mm.wear.a.c.d.a("MicroMsg.NotificationHandler", paramArrayOfByte);
                  return;
                }
                localObject1 = new aa();
              }
              catch (IOException paramArrayOfByte)
              {
                try
                {
                  for (;;)
                  {
                    ((aa)localObject1).h(paramArrayOfByte);
                    label1097:
                    paramArrayOfByte = new com.tencent.mm.b.a.i();
                    paramArrayOfByte.WT.WU = ((aa)localObject1);
                    com.tencent.mm.sdk.a.a.YM.a(paramArrayOfByte, Looper.getMainLooper());
                    return;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                    continue;
                    paramArrayOfByte = paramArrayOfByte;
                  }
                  paramArrayOfByte = paramArrayOfByte;
                }
                catch (IOException paramArrayOfByte)
                {
                  break label1097;
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected final boolean cm(int paramInt)
  {
    switch (paramInt)
    {
    case 20004: 
    case 20007: 
    case 20008: 
    case 20009: 
    case 20010: 
    case 20011: 
    case 20012: 
    case 20013: 
    default: 
      return super.cm(paramInt);
    }
    return true;
  }
  
  public final List<Integer> nE()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(20016));
    localArrayList.add(Integer.valueOf(20015));
    localArrayList.add(Integer.valueOf(20014));
    localArrayList.add(Integer.valueOf(20003));
    localArrayList.add(Integer.valueOf(20004));
    localArrayList.add(Integer.valueOf(20005));
    localArrayList.add(Integer.valueOf(20006));
    localArrayList.add(Integer.valueOf(20007));
    localArrayList.add(Integer.valueOf(20008));
    localArrayList.add(Integer.valueOf(20009));
    localArrayList.add(Integer.valueOf(20010));
    localArrayList.add(Integer.valueOf(20011));
    localArrayList.add(Integer.valueOf(20012));
    localArrayList.add(Integer.valueOf(20017));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.b.b
 * JD-Core Version:    0.7.0.1
 */