package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static long DlT;
  private static b.a QuK;
  private static boolean WQJ;
  public static final Set<String> WYM;
  private boolean QuI;
  public boolean WYK;
  private apf qhY;
  
  static
  {
    AppMethodBeat.i(292402);
    HashSet localHashSet = new HashSet();
    WYM = localHashSet;
    localHashSet.add("app_type");
    WYM.add("app_media_id");
    WYM.add("app_msg_id");
    WYM.add("app_show_share");
    WYM.add("scene");
    WQJ = false;
    DlT = 0L;
    QuK = new b.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(292363);
        if (paramAnonymousMultiTaskInfo.field_data == null)
        {
          AppMethodBeat.o(292363);
          return;
        }
        Context localContext = MMApplicationContext.getContext();
        if (!b.hRJ())
        {
          w.g(localContext, null);
          AppMethodBeat.o(292363);
          return;
        }
        apf localapf = new apf();
        try
        {
          localapf.parseFrom(paramAnonymousMultiTaskInfo.field_data);
          str1 = localapf.filePath;
          if (!u.agG(str1))
          {
            new f.a(localContext).aR("").bBl(localContext.getString(R.l.eEZ)).HL(true).b(null).show();
            ((com.tencent.mm.plugin.taskbar.c)h.ag(com.tencent.mm.plugin.taskbar.c.class)).removeTaskInfo(paramAnonymousMultiTaskInfo.field_id, true, 0);
            AppMethodBeat.o(292363);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          String str1;
          for (;;)
          {
            Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "FileMultiTaskData parse error");
          }
          aco localaco = new aco();
          localaco.Soi = true;
          if (localapf.SCl)
          {
            paramAnonymousMultiTaskInfo = new Intent();
            paramAnonymousMultiTaskInfo.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            com.tencent.mm.plugin.multitask.f.b.a(paramAnonymousMultiTaskInfo, localapf);
            try
            {
              paramAnonymousMultiTaskInfo.putExtra("key_multi_task_common_info", localaco.toByteArray());
              paramAnonymousMultiTaskInfo.getExtras().putInt("scene", 12);
              paramAnonymousMultiTaskInfo.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMultiTaskInfo);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, paramAnonymousMultiTaskInfo.aFh(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(292363);
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
          String str2 = localException.jmx;
          String str3 = localException.appId;
          boolean bool = localException.orn;
          String str4 = localException.processName;
          if (Util.isNullOrNil(str4))
          {
            if (com.tencent.mm.pluginsdk.ui.tools.a.a(str1, str2, paramAnonymousMultiTaskInfo.fbc().title, 12, localaco))
            {
              paramAnonymousMultiTaskInfo = new Intent();
              paramAnonymousMultiTaskInfo.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              com.tencent.mm.plugin.multitask.f.b.a(paramAnonymousMultiTaskInfo, localException);
              paramAnonymousMultiTaskInfo.putExtra("scene", 12);
              paramAnonymousMultiTaskInfo.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMultiTaskInfo);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, paramAnonymousMultiTaskInfo.aFh(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(292363);
            }
          }
          else {
            ((f)h.ae(f.class)).a(localContext, str1, str2, str3, bool, str4);
          }
          AppMethodBeat.o(292363);
        }
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
    };
    AppMethodBeat.o(292402);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(292391);
    this.qhY = new apf();
    this.QuI = false;
    this.WYK = false;
    AppMethodBeat.o(292391);
  }
  
  public static void eKx()
  {
    AppMethodBeat.i(292401);
    EventCenter.instance.add(new b.1());
    AppMethodBeat.o(292401);
  }
  
  public static boolean hRJ()
  {
    AppMethodBeat.i(292400);
    long l1 = DlT;
    long l2 = System.currentTimeMillis();
    DlT = l2;
    if (l1 + 30000L < l2)
    {
      bh.beI();
      WQJ = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = WQJ;
    AppMethodBeat.o(292400);
    return bool;
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292393);
    paramBoolean = super.Q(paramInt, this.QuI);
    AppMethodBeat.o(292393);
    return paramBoolean;
  }
  
  public final void Wf(long paramLong)
  {
    AppMethodBeat.i(292398);
    if (this.qhY != null)
    {
      this.qhY.Rwe = paramLong;
      try
      {
        this.FHd.field_data = this.qhY.toByteArray();
        AppMethodBeat.o(292398);
        return;
      }
      catch (IOException localIOException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "updateFileLen", new Object[] { localIOException });
      }
    }
    AppMethodBeat.o(292398);
  }
  
  public final boolean cbG()
  {
    AppMethodBeat.i(292396);
    if ((!Util.isNullOrNil(this.qhY.filePath)) && (!u.agG(this.qhY.filePath)))
    {
      AppMethodBeat.o(292396);
      return false;
    }
    if (this.WYK)
    {
      AppMethodBeat.o(292396);
      return false;
    }
    AppMethodBeat.o(292396);
    return true;
  }
  
  public final boolean cbH()
  {
    return true;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(292397);
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    super.I(4, g.aQW(paramString1));
    this.QuI = false;
    this.qhY.filePath = paramString1;
    this.qhY.Rwe = u.bBQ(paramString1);
    if (paramBoolean)
    {
      if (this.FGb.getIntent() == null) {
        break label256;
      }
      paramString2 = this.FGb.getIntent();
      paramString1 = this.qhY;
      if (paramString1 != null)
      {
        paramString2 = paramString2.getExtras();
        if ((paramString1 != null) && (paramString2 != null))
        {
          paramString1.SCm = paramString2.getString("app_type");
          paramString1.SCn = paramString2.getString("app_media_id");
          paramString1.SCo = paramString2.getLong("app_msg_id");
          paramString1.SCp = paramString2.getBoolean("app_show_share");
          paramString1.scene = paramString2.getInt("scene");
        }
      }
      this.qhY.SCl = true;
      try
      {
        this.FHd.field_data = this.qhY.toByteArray();
        faR();
        AppMethodBeat.o(292397);
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
    this.qhY.jmx = paramString2;
    this.qhY.tNG = paramInt;
    this.qhY.SCl = false;
    try
    {
      this.FHd.field_data = this.qhY.toByteArray();
      faR();
      label256:
      AppMethodBeat.o(292397);
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
  
  public final boolean faH()
  {
    return !this.WYK;
  }
  
  public final long faO()
  {
    return 1000L;
  }
  
  public final void hTj()
  {
    AppMethodBeat.i(292394);
    this.QuI = true;
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setEnded ended:%b", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(292394);
  }
  
  public final void hTk()
  {
    AppMethodBeat.i(292395);
    dJO();
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setStart");
    AppMethodBeat.o(292395);
  }
  
  public final void oc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(292399);
    MultiTaskInfo localMultiTaskInfo = this.FHd;
    localMultiTaskInfo.fbc().title = paramString2;
    localMultiTaskInfo.fbc().jmx = paramString1;
    faR();
    AppMethodBeat.o(292399);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(292392);
    boolean bool = Q(paramInt, this.QuI);
    AppMethodBeat.o(292392);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.b
 * JD-Core Version:    0.7.0.1
 */