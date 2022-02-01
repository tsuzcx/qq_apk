package com.tencent.mm.ui.chatting.multitask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static long Jfc;
  private static b.a XmI;
  private static boolean aeAd;
  public static final Set<String> aeIm;
  private boolean XmG;
  public boolean aeIk;
  private asy tmK;
  
  static
  {
    AppMethodBeat.i(254014);
    HashSet localHashSet = new HashSet();
    aeIm = localHashSet;
    localHashSet.add("app_type");
    aeIm.add("app_media_id");
    aeIm.add("app_msg_id");
    aeIm.add("app_show_share");
    aeIm.add("scene");
    aeAd = false;
    Jfc = 0L;
    XmI = new b.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(254013);
        if (paramAnonymousMultiTaskInfo.field_data == null)
        {
          AppMethodBeat.o(254013);
          return;
        }
        Context localContext = MMApplicationContext.getContext();
        if (!b.jvh())
        {
          aa.j(localContext, null);
          AppMethodBeat.o(254013);
          return;
        }
        asy localasy = new asy();
        try
        {
          localasy.parseFrom(paramAnonymousMultiTaskInfo.field_data);
          str1 = localasy.filePath;
          if (!y.ZC(str1))
          {
            new g.a(localContext).bf("").bDE(localContext.getString(R.l.gHS)).NF(true).b(null).show();
            ((com.tencent.mm.plugin.taskbar.c)h.az(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(paramAnonymousMultiTaskInfo.field_id, true, 0);
            AppMethodBeat.o(254013);
            return;
          }
        }
        finally
        {
          String str1;
          for (;;)
          {
            Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "FileMultiTaskData parse error");
          }
          aet localaet = new aet();
          localaet.ZmN = true;
          if (localasy.ZDd)
          {
            paramAnonymousMultiTaskInfo = new Intent();
            paramAnonymousMultiTaskInfo.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            com.tencent.mm.plugin.multitask.f.b.a(paramAnonymousMultiTaskInfo, localasy);
            try
            {
              paramAnonymousMultiTaskInfo.putExtra("key_multi_task_common_info", localaet.toByteArray());
              paramAnonymousMultiTaskInfo.getExtras().putInt("scene", 12);
              paramAnonymousMultiTaskInfo.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMultiTaskInfo);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, paramAnonymousMultiTaskInfo.aYi(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(254013);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", localException, "onTaskBarItemClicked", new Object[0]);
              }
            }
          }
          String str2 = localException.lPJ;
          String str3 = localException.appId;
          boolean bool = localException.rvh;
          String str4 = localException.processName;
          if (Util.isNullOrNil(str4))
          {
            if (com.tencent.mm.pluginsdk.ui.tools.a.a(str1, str2, paramAnonymousMultiTaskInfo.gkh().title, 12, localaet))
            {
              paramAnonymousMultiTaskInfo = new Intent();
              paramAnonymousMultiTaskInfo.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              com.tencent.mm.plugin.multitask.f.b.a(paramAnonymousMultiTaskInfo, localException);
              paramAnonymousMultiTaskInfo.putExtra("scene", 12);
              paramAnonymousMultiTaskInfo.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousMultiTaskInfo);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, paramAnonymousMultiTaskInfo.aYi(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(254013);
            }
          }
          else {
            ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(localContext, str1, str2, str3, bool, str4);
          }
          AppMethodBeat.o(254013);
        }
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
    };
    AppMethodBeat.o(254014);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(254000);
    this.tmK = new asy();
    this.XmG = false;
    this.aeIk = false;
    AppMethodBeat.o(254000);
  }
  
  public static void fSy()
  {
    AppMethodBeat.i(254006);
    new FilesPageMultiTaskHelper.1(f.hfK).alive();
    AppMethodBeat.o(254006);
  }
  
  public static boolean jvh()
  {
    AppMethodBeat.i(254002);
    long l1 = Jfc;
    long l2 = System.currentTimeMillis();
    Jfc = l2;
    if (l1 + 30000L < l2)
    {
      bh.bCz();
      aeAd = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = aeAd;
    AppMethodBeat.o(254002);
    return bool;
  }
  
  public final void Aq(long paramLong)
  {
    AppMethodBeat.i(254042);
    if (this.tmK != null)
    {
      this.tmK.Ysz = paramLong;
      try
      {
        this.LCE.field_data = this.tmK.toByteArray();
        AppMethodBeat.o(254042);
        return;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "updateFileLen", new Object[] { localIOException });
      }
    }
    AppMethodBeat.o(254042);
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254023);
    paramBoolean = super.af(paramInt, this.XmG);
    AppMethodBeat.o(254023);
    return paramBoolean;
  }
  
  public final boolean cBZ()
  {
    AppMethodBeat.i(254032);
    if ((!Util.isNullOrNil(this.tmK.filePath)) && (!y.ZC(this.tmK.filePath)))
    {
      AppMethodBeat.o(254032);
      return false;
    }
    if (this.aeIk)
    {
      AppMethodBeat.o(254032);
      return false;
    }
    AppMethodBeat.o(254032);
    return true;
  }
  
  public final boolean cCa()
  {
    return true;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(254037);
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    super.J(4, com.tencent.mm.plugin.multitask.g.aNO(paramString1));
    this.XmG = false;
    this.tmK.filePath = paramString1;
    this.tmK.Ysz = y.bEl(paramString1);
    if (paramBoolean)
    {
      if (this.LBU.getIntent() == null) {
        break label256;
      }
      paramString2 = this.LBU.getIntent();
      paramString1 = this.tmK;
      if (paramString1 != null)
      {
        paramString2 = paramString2.getExtras();
        if ((paramString1 != null) && (paramString2 != null))
        {
          paramString1.ZDe = paramString2.getString("app_type");
          paramString1.ZDf = paramString2.getString("app_media_id");
          paramString1.ZDg = paramString2.getLong("app_msg_id");
          paramString1.ZDh = paramString2.getBoolean("app_show_share");
          paramString1.scene = paramString2.getInt("scene");
        }
      }
      this.tmK.ZDd = true;
      try
      {
        this.LCE.field_data = this.tmK.toByteArray();
        gjW();
        AppMethodBeat.o(254037);
        return;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", new Object[] { paramString1 });
        }
      }
    }
    this.tmK.lPJ = paramString2;
    this.tmK.wQW = paramInt;
    this.tmK.ZDd = false;
    try
    {
      this.LCE.field_data = this.tmK.toByteArray();
      gjW();
      label256:
      AppMethodBeat.o(254037);
      return;
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", new Object[] { paramString1 });
      }
    }
  }
  
  public final boolean gjM()
  {
    return !this.aeIk;
  }
  
  public final long gjT()
  {
    return 1000L;
  }
  
  public final void jwK()
  {
    AppMethodBeat.i(254026);
    this.XmG = true;
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setEnded ended:%b", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(254026);
  }
  
  public final void jwL()
  {
    AppMethodBeat.i(254030);
    eCK();
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setStart");
    AppMethodBeat.o(254030);
  }
  
  public final void qa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(254047);
    MultiTaskInfo localMultiTaskInfo = this.LCE;
    localMultiTaskInfo.gkh().title = paramString2;
    localMultiTaskInfo.gkh().lPJ = paramString1;
    gjW();
    AppMethodBeat.o(254047);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(254018);
    boolean bool = af(paramInt, this.XmG);
    AppMethodBeat.o(254018);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.b
 * JD-Core Version:    0.7.0.1
 */