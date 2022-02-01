package com.tencent.mm.plugin.repairer;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.autogen.a.cx.a;
import com.tencent.mm.autogen.a.uf;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.repairer.ui.b.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/PluginRepairer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/repairer/IPluginRepairer;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "configUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "getConfigUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "constantsExptMap", "", "", "", "getConstantsExptMap", "()Ljava/util/Map;", "repairerActionListener", "Lcom/tencent/mm/autogen/events/RepairerActionEvent;", "getRepairerActionListener", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getRepairerFolder", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "saveFileAsync", "filePath", "fileContent", "", "needSend", "", "saveRepairerFile", "fileName", "sendContactInfo", "contact", "Lcom/tencent/mm/storage/Contact;", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginRepairer
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, a
{
  public static final a Oti;
  private final IListener<cx> JFS;
  private final IListener<uf> Otj;
  private final Map<String, Integer> Otk;
  
  static
  {
    AppMethodBeat.i(277822);
    Oti = new a((byte)0);
    AppMethodBeat.o(277822);
  }
  
  public PluginRepairer()
  {
    AppMethodBeat.i(277816);
    this.Otj = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    this.Otk = ak.l(v.Y(c.a.yUw.name(), Integer.valueOf(0)));
    this.JFS = ((IListener)new IListener(com.tencent.mm.app.f.hfK)
    {
      private boolean a(cx paramAnonymouscx)
      {
        AppMethodBeat.i(277819);
        s.u(paramAnonymouscx, "event");
        paramAnonymouscx = paramAnonymouscx.hCR;
        Object localObject;
        int i;
        if (paramAnonymouscx != null)
        {
          paramAnonymouscx = paramAnonymouscx.hCS;
          if (paramAnonymouscx != null)
          {
            localObject = (Integer)this.Otl.getConstantsExptMap().get(paramAnonymouscx);
            if (localObject != null) {
              i = ((Number)localObject).intValue();
            }
          }
        }
        try
        {
          i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.valueOf(paramAnonymouscx), i);
          localObject = i.agtt;
          i.jj(paramAnonymouscx, i);
          Log.i("MicroMsg.Repairer.PluginRepairer", "configUpdateListener saveGlobalKey " + paramAnonymouscx + ' ' + i);
          label116:
          AppMethodBeat.o(277819);
          return false;
        }
        catch (Exception paramAnonymouscx)
        {
          break label116;
        }
      }
    });
    AppMethodBeat.o(277816);
  }
  
  private final void saveFileAsync(String paramString, final byte[] paramArrayOfByte, final boolean paramBoolean)
  {
    AppMethodBeat.i(277817);
    com.tencent.mm.ae.d.e("RepairerConfigThread", (kotlin.g.a.a)new b(paramString, paramArrayOfByte, paramBoolean));
    AppMethodBeat.o(277817);
  }
  
  public final void execute(g paramg) {}
  
  public final IListener<cx> getConfigUpdateListener()
  {
    return this.JFS;
  }
  
  public final Map<String, Integer> getConstantsExptMap()
  {
    return this.Otk;
  }
  
  public final IListener<uf> getRepairerActionListener()
  {
    return this.Otj;
  }
  
  public final String getRepairerFolder()
  {
    AppMethodBeat.i(277827);
    String str = s.X(com.tencent.mm.loader.i.b.bmI(), "Repairer/");
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    AppMethodBeat.o(277827);
    return str;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(277862);
    this.Otj.alive();
    this.JFS.alive();
    paramc = com.tencent.mm.plugin.repairer.ui.b.a.Oyk;
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).a(25, com.tencent.mm.plugin.repairer.ui.b.a.egs());
    }
    paramc = this.Otk.entrySet().iterator();
    while (paramc.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramc.next();
      try
      {
        Object localObject = c.a.valueOf((String)localEntry.getKey());
        int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a((c.a)localObject, ((Number)localEntry.getValue()).intValue());
        localObject = i.agtt;
        i.jj((String)localEntry.getKey(), i);
        Log.i("MicroMsg.Repairer.PluginRepairer", "onAccountInitialized saveGlobalKey " + (String)localEntry.getKey() + ' ' + i);
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(277862);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(277853);
    this.Otj.dead();
    this.JFS.dead();
    a.a locala = com.tencent.mm.plugin.repairer.ui.b.a.Oyk;
    if (h.ax(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).b(25, com.tencent.mm.plugin.repairer.ui.b.a.egs());
    }
    AppMethodBeat.o(277853);
  }
  
  public final void parallelsDependency() {}
  
  public final String saveRepairerFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(277834);
    if ((paramString != null) && (paramArrayOfByte != null))
    {
      paramString = new com.tencent.mm.vfs.u(s.X(getRepairerFolder(), paramString));
      String str = com.tencent.mm.vfs.ah.v(paramString.jKT());
      s.s(str, "saveFile.absolutePath");
      saveFileAsync(str, paramArrayOfByte, paramBoolean);
      paramString = com.tencent.mm.vfs.ah.v(paramString.jKT());
      s.s(paramString, "saveFile.absolutePath");
      AppMethodBeat.o(277834);
      return paramString;
    }
    AppMethodBeat.o(277834);
    return "";
  }
  
  public final String sendContactInfo(String paramString, au paramau)
  {
    AppMethodBeat.i(277841);
    if ((paramString != null) && (paramau != null))
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("UIN:" + paramau.uin + '\n');
      ((StringBuffer)localObject).append("Username:" + paramau.field_username + '\n');
      ((StringBuffer)localObject).append("Alias:" + paramau.aJs() + '\n');
      ((StringBuffer)localObject).append("ConRemark:" + paramau.field_conRemark + '\n');
      ((StringBuffer)localObject).append("Nickname:" + paramau.field_nickname + '\n');
      ((StringBuffer)localObject).append("ConRemarkPYFull:" + paramau.field_conRemarkPYFull + '\n');
      ((StringBuffer)localObject).append("QuanPin:" + paramau.aJu() + '\n');
      ((StringBuffer)localObject).append("Type:" + Integer.toBinaryString(paramau.field_type) + '\n');
      ((StringBuffer)localObject).append("VerifyFlag:" + Integer.toBinaryString(paramau.field_verifyFlag) + '\n');
      ((StringBuffer)localObject).append("BizType:" + paramau.hyY + '\n');
      ((StringBuffer)localObject).append("UsernameFlag:" + paramau.field_usernameFlag + '\n');
      ((StringBuffer)localObject).append("ShowHead:" + paramau.field_showHead + '\n');
      paramString = new com.tencent.mm.vfs.u(s.X(getRepairerFolder(), paramString));
      paramau = com.tencent.mm.vfs.ah.v(paramString.jKT());
      s.s(paramau, "saveFile.absolutePath");
      localObject = ((StringBuffer)localObject).toString();
      s.s(localObject, "sb.toString()");
      localObject = ((String)localObject).getBytes(kotlin.n.d.UTF_8);
      s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      saveFileAsync(paramau, (byte[])localObject, true);
      paramString = com.tencent.mm.vfs.ah.v(paramString.jKT());
      s.s(paramString, "saveFile.absolutePath");
      AppMethodBeat.o(277841);
      return paramString;
    }
    AppMethodBeat.o(277841);
    return "";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/PluginRepairer$Companion;", "", "()V", "TAG", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.PluginRepairer
 * JD-Core Version:    0.7.0.1
 */