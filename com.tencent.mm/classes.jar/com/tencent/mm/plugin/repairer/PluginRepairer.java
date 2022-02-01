package com.tencent.mm.plugin.repairer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.repairer.ui.a.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storage.as;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/PluginRepairer;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/repairer/IPluginRepairer;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "()V", "repairerActionListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RepairerActionEvent;", "getRepairerActionListener", "()Lcom/tencent/mm/sdk/event/IListener;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "getRepairerFolder", "", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "parallelsDependency", "saveFileAsync", "filePath", "fileContent", "", "needSend", "", "saveRepairerFile", "fileName", "sendContactInfo", "contact", "Lcom/tencent/mm/storage/Contact;", "ui-repairer_release"})
public final class PluginRepairer
  extends f
  implements com.tencent.mm.kernel.a.b.b, c, a
{
  private final IListener<Object> IvG;
  
  public PluginRepairer()
  {
    AppMethodBeat.i(227358);
    this.IvG = ((IListener)new a());
    AppMethodBeat.o(227358);
  }
  
  private final void saveFileAsync(String paramString, final byte[] paramArrayOfByte, final boolean paramBoolean)
  {
    AppMethodBeat.i(227348);
    com.tencent.mm.ae.d.c("RepairerConfigThread", (kotlin.g.a.a)new b(paramString, paramArrayOfByte, paramBoolean));
    AppMethodBeat.o(227348);
  }
  
  public final void execute(g paramg) {}
  
  public final IListener<Object> getRepairerActionListener()
  {
    return this.IvG;
  }
  
  public final String getRepairerFolder()
  {
    AppMethodBeat.i(227327);
    String str = com.tencent.mm.loader.j.b.aSU() + "Repairer/";
    if (!u.agG(str)) {
      u.bBD(str);
    }
    AppMethodBeat.o(227327);
    return str;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(227354);
    this.IvG.alive();
    paramc = com.tencent.mm.plugin.repairer.ui.a.a.Iyd;
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).a(25, com.tencent.mm.plugin.repairer.ui.a.a.dJI());
    }
    AppMethodBeat.o(227354);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(227352);
    this.IvG.dead();
    a.a locala = com.tencent.mm.plugin.repairer.ui.a.a.Iyd;
    if (h.ae(com.tencent.mm.plugin.ball.c.b.class) != null) {
      ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).b(25, com.tencent.mm.plugin.repairer.ui.a.a.dJI());
    }
    AppMethodBeat.o(227352);
  }
  
  public final void parallelsDependency() {}
  
  public final String saveRepairerFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(227333);
    if ((paramString != null) && (paramArrayOfByte != null))
    {
      paramString = new com.tencent.mm.vfs.q(getRepairerFolder() + paramString);
      String str = paramString.bOF();
      p.j(str, "saveFile.absolutePath");
      saveFileAsync(str, paramArrayOfByte, paramBoolean);
      paramString = paramString.bOF();
      p.j(paramString, "saveFile.absolutePath");
      AppMethodBeat.o(227333);
      return paramString;
    }
    AppMethodBeat.o(227333);
    return "";
  }
  
  public final String sendContactInfo(String paramString, as paramas)
  {
    AppMethodBeat.i(227347);
    if ((paramString != null) && (paramas != null))
    {
      Object localObject = new StringBuffer();
      ((StringBuffer)localObject).append("UIN:" + paramas.getUin() + "\n");
      ((StringBuffer)localObject).append("Username:" + paramas.getUsername() + "\n");
      ((StringBuffer)localObject).append("Alias:" + paramas.apf() + "\n");
      ((StringBuffer)localObject).append("ConRemark:" + paramas.apg() + "\n");
      ((StringBuffer)localObject).append("Nickname:" + paramas.getNickname() + "\n");
      ((StringBuffer)localObject).append("ConRemarkPYFull:" + paramas.apk() + "\n");
      ((StringBuffer)localObject).append("QuanPin:" + paramas.api() + "\n");
      ((StringBuffer)localObject).append("Type:" + Integer.toBinaryString(paramas.getType()) + "\n");
      ((StringBuffer)localObject).append("VerifyFlag:" + Integer.toBinaryString(paramas.apm()) + "\n");
      ((StringBuffer)localObject).append("BizType:" + paramas.apx() + "\n");
      ((StringBuffer)localObject).append("UsernameFlag:" + paramas.aps() + "\n");
      ((StringBuffer)localObject).append("ShowHead:" + paramas.apj() + "\n");
      paramString = new com.tencent.mm.vfs.q(getRepairerFolder() + paramString);
      paramas = paramString.bOF();
      p.j(paramas, "saveFile.absolutePath");
      localObject = ((StringBuffer)localObject).toString();
      p.j(localObject, "sb.toString()");
      Charset localCharset = kotlin.n.d.UTF_8;
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(227347);
        throw paramString;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      saveFileAsync(paramas, (byte[])localObject, true);
      paramString = paramString.bOF();
      p.j(paramString, "saveFile.absolutePath");
      AppMethodBeat.o(227347);
      return paramString;
    }
    AppMethodBeat.o(227347);
    return "";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/repairer/PluginRepairer$repairerActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/RepairerActionEvent;", "callback", "", "event", "ui-repairer_release"})
  public static final class a
    extends IListener<Object>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
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