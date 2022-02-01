package com.tencent.mm.ui.chatting.multitask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.taskbar.d;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class b
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static c.a JwV;
  public static final Set<String> PDZ;
  private static boolean Pwq;
  private static long Pwr;
  private boolean JwT;
  public boolean PDX;
  public aoe nhp;
  
  static
  {
    AppMethodBeat.i(233479);
    HashSet localHashSet = new HashSet();
    PDZ = localHashSet;
    localHashSet.add("app_type");
    PDZ.add("app_media_id");
    PDZ.add("app_msg_id");
    PDZ.add("app_show_share");
    PDZ.add("scene");
    Pwq = false;
    Pwr = 0L;
    JwV = new c.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(233468);
        if (paramAnonymousMultiTaskInfo.field_data == null)
        {
          AppMethodBeat.o(233468);
          return;
        }
        Context localContext = MMApplicationContext.getContext();
        if (!b.gSk())
        {
          u.g(localContext, null);
          AppMethodBeat.o(233468);
          return;
        }
        aoe localaoe = new aoe();
        try
        {
          localaoe.parseFrom(paramAnonymousMultiTaskInfo.field_data);
          String str1 = localaoe.filePath;
          if (!s.YS(str1))
          {
            new f.a(localContext).aC("").bow(localContext.getString(2131759413)).Dq(true).b(null).show();
            ((d)com.tencent.mm.kernel.g.ah(d.class)).removeTaskInfo(paramAnonymousMultiTaskInfo.field_id, true, 0);
            AppMethodBeat.o(233468);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "FileMultiTaskData parse error");
          }
          paramAnonymousMultiTaskInfo = new ach();
          paramAnonymousMultiTaskInfo.LmR = true;
          Intent localIntent;
          if (localaoe.LzL)
          {
            localIntent = new Intent();
            localIntent.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            com.tencent.mm.plugin.multitask.f.b.a(localIntent, localaoe);
            try
            {
              localIntent.putExtra("key_multi_task_common_info", paramAnonymousMultiTaskInfo.toByteArray());
              localIntent.getExtras().putInt("scene", 9);
              localIntent.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, paramAnonymousMultiTaskInfo.axQ(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(233468);
              return;
            }
            catch (Exception paramAnonymousMultiTaskInfo)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", paramAnonymousMultiTaskInfo, "onTaskBarItemClicked", new Object[0]);
              }
            }
          }
          String str2 = localaoe.gCr;
          String str3 = localaoe.appId;
          boolean bool = localaoe.lwF;
          String str4 = localaoe.processName;
          if (Util.isNullOrNil(str4))
          {
            if (com.tencent.mm.pluginsdk.ui.tools.a.a(localIntent, str2, "", 9, paramAnonymousMultiTaskInfo))
            {
              paramAnonymousMultiTaskInfo = new Intent();
              paramAnonymousMultiTaskInfo.setClassName(localContext, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
              com.tencent.mm.plugin.multitask.f.b.a(paramAnonymousMultiTaskInfo, localaoe);
              paramAnonymousMultiTaskInfo.putExtra("scene", 9);
              paramAnonymousMultiTaskInfo.addFlags(268435456);
              paramAnonymousMultiTaskInfo = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMultiTaskInfo);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, paramAnonymousMultiTaskInfo.axQ(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)paramAnonymousMultiTaskInfo.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(233468);
            }
          }
          else {
            ((f)com.tencent.mm.kernel.g.af(f.class)).a(localContext, localIntent, str2, str3, bool, str4);
          }
          AppMethodBeat.o(233468);
        }
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo) {}
    };
    AppMethodBeat.o(233479);
  }
  
  public b(com.tencent.mm.plugin.multitask.a.a parama)
  {
    super(parama);
    AppMethodBeat.i(233469);
    this.nhp = new aoe();
    this.JwT = false;
    this.PDX = false;
    AppMethodBeat.o(233469);
  }
  
  public static void ebz()
  {
    AppMethodBeat.i(233478);
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(233478);
  }
  
  public static boolean gSk()
  {
    AppMethodBeat.i(233477);
    long l1 = Pwr;
    long l2 = System.currentTimeMillis();
    Pwr = l2;
    if (l1 + 30000L < l2)
    {
      bg.aVF();
      Pwq = com.tencent.mm.model.c.isSDCardAvailable();
    }
    boolean bool = Pwq;
    AppMethodBeat.o(233477);
    return bool;
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233471);
    paramBoolean = super.O(paramInt, this.JwT);
    AppMethodBeat.o(233471);
    return paramBoolean;
  }
  
  public final boolean bPp()
  {
    AppMethodBeat.i(233474);
    if ((!Util.isNullOrNil(this.nhp.filePath)) && (!s.YS(this.nhp.filePath)))
    {
      AppMethodBeat.o(233474);
      return false;
    }
    if (this.PDX)
    {
      AppMethodBeat.o(233474);
      return false;
    }
    AppMethodBeat.o(233474);
    return true;
  }
  
  public final boolean bPq()
  {
    return true;
  }
  
  public final boolean eqO()
  {
    return !this.PDX;
  }
  
  public final long eqU()
  {
    return 1000L;
  }
  
  public final void g(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(233475);
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    super.G(4, com.tencent.mm.plugin.multitask.g.aGI(paramString1));
    this.JwT = false;
    this.nhp.filePath = paramString1;
    this.nhp.LzM = s.boW(paramString1);
    if (paramBoolean)
    {
      if (this.Aak.getIntent() == null) {
        break label256;
      }
      paramString2 = this.Aak.getIntent();
      paramString1 = this.nhp;
      if (paramString1 != null)
      {
        paramString2 = paramString2.getExtras();
        if ((paramString1 != null) && (paramString2 != null))
        {
          paramString1.LzN = paramString2.getString("app_type");
          paramString1.LzO = paramString2.getString("app_media_id");
          paramString1.LzP = paramString2.getLong("app_msg_id");
          paramString1.LzQ = paramString2.getBoolean("app_show_share");
          paramString1.scene = paramString2.getInt("scene");
        }
      }
      this.nhp.LzL = true;
      try
      {
        this.Abp.field_data = this.nhp.toByteArray();
        eqX();
        AppMethodBeat.o(233475);
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
    this.nhp.gCr = paramString2;
    this.nhp.qoX = paramInt;
    this.nhp.LzL = false;
    try
    {
      this.Abp.field_data = this.nhp.toByteArray();
      eqX();
      label256:
      AppMethodBeat.o(233475);
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
  
  public final void gTD()
  {
    AppMethodBeat.i(233472);
    this.JwT = true;
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setEnded ended:%b", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(233472);
  }
  
  public final void gTE()
  {
    AppMethodBeat.i(233473);
    dkj();
    Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setStart");
    AppMethodBeat.o(233473);
  }
  
  public final void ni(String paramString1, String paramString2)
  {
    AppMethodBeat.i(233476);
    MultiTaskInfo localMultiTaskInfo = this.Abp;
    localMultiTaskInfo.erh().title = paramString2;
    localMultiTaskInfo.erh().gCr = paramString1;
    eqX();
    AppMethodBeat.o(233476);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(233470);
    boolean bool = O(paramInt, this.JwT);
    AppMethodBeat.o(233470);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.multitask.b
 * JD-Core Version:    0.7.0.1
 */