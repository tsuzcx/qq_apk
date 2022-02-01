package com.tencent.mm.plugin.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.protocal.protobuf.fvq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.vas.VASActivity;
import com.tencent.mm.ui.vas.VASActivity.a;
import com.tencent.mm.util.b.a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/WxVASInitHelper;", "Lcom/tencent/mm/ui/vas/api/IVASController;", "()V", "KEY_REPORT_ID", "", "TAG", "isVasOpen", "", "Ljava/lang/Boolean;", "mReporter", "Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "getMReporter", "()Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "needReportClassNames", "", "getNeedReportClassNames", "()Ljava/util/Set;", "removeContainerMarginClasses", "supportVASClassNames", "", "addSupportClass", "", "className", "init", "isRemoveContainerMargin", "isSupportVAS", "isSwitchOpen", "setSwitchOpen", "open", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.ui.vas.b.a
{
  public static final e Pnh;
  private static Boolean Pni;
  static final com.tencent.mm.ui.vas.d.a Pnj;
  private static final Set<String> Pnk;
  private static final Set<String> Pnl;
  private static final Set<String> Pnm;
  
  static
  {
    AppMethodBeat.i(298512);
    Pnh = new e();
    Pnj = (com.tencent.mm.ui.vas.d.a)new a();
    Pnk = ar.setOf(new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI", "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsSnsPrivacyUI", "com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPermissionIndexUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera", "com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI" });
    Pnl = ar.mutableSetOf(new String[] { "com.tencent.mm.plugin.setting.ui.setting.SettingsUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingBackgroundUI", "com.tencent.mm.plugin.backup.backupui.BackupChooseBackupModeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsSnsPrivacyUI", "com.tencent.mm.plugin.topstory.ui.home.TopStorySettingUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPermissionIndexUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI", "com.tencent.mm.plugin.setting.ui.setting.SettingDarkMode", "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera", "com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI", "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI" });
    Pnm = ar.setOf("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    AppMethodBeat.o(298512);
  }
  
  public static Set<String> gUS()
  {
    return Pnk;
  }
  
  public final boolean aVy(String paramString)
  {
    AppMethodBeat.i(298527);
    boolean bool = p.a((Iterable)Pnl, paramString);
    AppMethodBeat.o(298527);
    return bool;
  }
  
  public final boolean aVz(String paramString)
  {
    AppMethodBeat.i(298533);
    boolean bool = p.a((Iterable)Pnm, paramString);
    AppMethodBeat.o(298533);
    return bool;
  }
  
  public final boolean gUR()
  {
    AppMethodBeat.i(298520);
    Boolean localBoolean = Pni;
    if (localBoolean == null)
    {
      if (((c)h.ax(c.class)).a(c.a.zun, b.a.agqz, 1) == 1) {}
      for (bool = true;; bool = false)
      {
        Pni = Boolean.valueOf(bool);
        AppMethodBeat.o(298520);
        return bool;
      }
    }
    boolean bool = localBoolean.booleanValue();
    AppMethodBeat.o(298520);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/setting/WxVASInitHelper$mReporter$1", "Lcom/tencent/mm/ui/vas/report/IActivityPerformanceReporter;", "checkIsNeedReport", "", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "checkIsNeedReportByName", "name", "", "clearReportData", "", "id", "getReportData", "Lcom/tencent/mm/protocal/protobuf/VASPerformanceReportData;", "stepOnAnimEnd", "stepOnAnimStart", "timeStamp", "", "stepOnCreate", "stepStartActivity", "isStartVAS", "updateReportData", "reportData", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.ui.vas.d.a
  {
    private static void a(fvq paramfvq, String paramString)
    {
      AppMethodBeat.i(298498);
      s.u(paramfvq, "reportData");
      s.u(paramString, "id");
      try
      {
        ((g)h.az(g.class)).updateOnlyMemory(15, s.X("vasReport", paramString), (com.tencent.mm.bx.a)paramfvq);
        return;
      }
      finally
      {
        AppMethodBeat.o(298498);
      }
    }
    
    private static fvq aVA(String paramString)
    {
      AppMethodBeat.i(298505);
      s.u(paramString, "id");
      try
      {
        paramString = (fvq)((g)h.az(g.class)).getOnlyMemory(15, s.X("vasReport", paramString));
        AppMethodBeat.o(298505);
        return paramString;
      }
      finally
      {
        for (;;)
        {
          paramString = null;
        }
      }
    }
    
    private static boolean aVB(String paramString)
    {
      AppMethodBeat.i(298509);
      e locale = e.Pnh;
      boolean bool = p.a((Iterable)e.gUS(), paramString);
      AppMethodBeat.o(298509);
      return bool;
    }
    
    public final void a(Intent paramIntent, long paramLong)
    {
      AppMethodBeat.i(298523);
      Object localObject;
      if (paramIntent == null)
      {
        localObject = "";
        if (!n.bp((CharSequence)localObject)) {
          break label62;
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label68;
        }
        AppMethodBeat.o(298523);
        return;
        String str = paramIntent.getStringExtra("MicroMsg.VAS.reportId");
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
      }
      label68:
      Log.d("MicroMsg.VAS.WxVAS", "stepOnAnimStart() called with: intent = " + paramIntent + ", timeStamp = " + paramLong);
      paramIntent = aVA((String)localObject);
      if (paramIntent != null)
      {
        paramLong -= paramIntent.startTime;
        if (paramLong > 0L) {
          paramIntent.abTP = paramLong;
        }
        a(paramIntent, (String)localObject);
      }
      AppMethodBeat.o(298523);
    }
    
    public final void a(Intent paramIntent, Context paramContext, boolean paramBoolean)
    {
      int j = 1;
      AppMethodBeat.i(298514);
      s.u(paramContext, "context");
      if (paramIntent == null)
      {
        AppMethodBeat.o(298514);
        return;
      }
      s.u(paramIntent, "intent");
      s.u(paramContext, "context");
      Object localObject2 = paramContext.getClass().getName();
      Object localObject1 = paramIntent.getComponent();
      if (localObject1 == null)
      {
        localObject1 = "";
        if ((!aVB((String)localObject2)) && (!aVB((String)localObject1))) {
          break label113;
        }
      }
      label113:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label119;
        }
        AppMethodBeat.o(298514);
        return;
        str = ((ComponentName)localObject1).getClassName();
        localObject1 = str;
        if (str != null) {
          break;
        }
        localObject1 = "";
        break;
      }
      label119:
      Log.d("MicroMsg.VAS.WxVAS", "stepStartActivity() called with: intent = " + paramIntent + ", context = " + paramContext + ", isStartVAS = " + paramBoolean);
      long l = System.currentTimeMillis();
      String str = String.valueOf(l);
      paramIntent.putExtra("MicroMsg.VAS.reportId", str);
      localObject2 = new fvq();
      ((fvq)localObject2).startTime = l;
      ((fvq)localObject2).abTK = paramContext.getClass().getName();
      paramIntent = paramIntent.getComponent();
      if (paramIntent == null)
      {
        paramIntent = "";
        ((fvq)localObject2).abTL = paramIntent;
        if (!aVB(((fvq)localObject2).abTK)) {
          break label354;
        }
        if (!(paramContext instanceof VASActivity)) {
          break label343;
        }
        paramIntent = (VASActivity)paramContext;
        label248:
        if ((paramIntent == null) || (paramIntent.isVASValid() != true)) {
          break label348;
        }
        i = 1;
        label263:
        if (i == 0) {
          break label354;
        }
        i = 1;
        label271:
        ((fvq)localObject2).abTM = i;
        if (!aVB(((fvq)localObject2).abTL)) {
          break label360;
        }
        paramIntent = VASActivity.Companion;
        if (!VASActivity.a.jEi()) {
          break label360;
        }
      }
      label343:
      label348:
      label354:
      label360:
      for (i = j;; i = 0)
      {
        ((fvq)localObject2).abTN = i;
        a((fvq)localObject2, str);
        AppMethodBeat.o(298514);
        return;
        localObject1 = paramIntent.getClassName();
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {
          break;
        }
        paramIntent = "";
        break;
        paramIntent = null;
        break label248;
        i = 0;
        break label263;
        i = 0;
        break label271;
      }
    }
    
    public final void bs(Intent paramIntent)
    {
      AppMethodBeat.i(298518);
      Object localObject;
      if (paramIntent == null)
      {
        localObject = "";
        if (!n.bp((CharSequence)localObject)) {
          break label62;
        }
      }
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        AppMethodBeat.o(298518);
        return;
        String str = paramIntent.getStringExtra("MicroMsg.VAS.reportId");
        localObject = str;
        if (str != null) {
          break;
        }
        localObject = "";
        break;
      }
      label67:
      Log.d("MicroMsg.VAS.WxVAS", s.X("stepOnCreate() called with: intent = ", paramIntent));
      paramIntent = aVA((String)localObject);
      if (paramIntent != null)
      {
        long l = System.currentTimeMillis() - paramIntent.startTime;
        if (l > 0L) {
          paramIntent.abTO = l;
        }
        a(paramIntent, (String)localObject);
      }
      AppMethodBeat.o(298518);
    }
    
    public final void bt(Intent paramIntent)
    {
      AppMethodBeat.i(298532);
      Object localObject1;
      if (paramIntent == null)
      {
        localObject1 = "";
        if (!n.bp((CharSequence)localObject1)) {
          break label62;
        }
      }
      Object localObject3;
      label62:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label67;
        }
        AppMethodBeat.o(298532);
        return;
        localObject3 = paramIntent.getStringExtra("MicroMsg.VAS.reportId");
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        localObject1 = "";
        break;
      }
      label67:
      Log.d("MicroMsg.VAS.WxVAS", s.X("stepOnAnimEnd() called with: intent = ", paramIntent));
      Object localObject4 = aVA((String)localObject1);
      if (localObject4 != null)
      {
        long l = System.currentTimeMillis() - ((fvq)localObject4).startTime;
        if (l > 0L) {
          ((fvq)localObject4).abTQ = l;
        }
        localObject3 = new qk();
        ((qk)localObject3).jrQ = ((qk)localObject3).F("SrcPageName", ((fvq)localObject4).abTK, true);
        ((qk)localObject3).jrR = ((qk)localObject3).F("DestPageName", ((fvq)localObject4).abTL, true);
        ((qk)localObject3).jrS = ((fvq)localObject4).abTM;
        ((qk)localObject3).jrT = ((fvq)localObject4).abTN;
        ((qk)localObject3).jrU = ((fvq)localObject4).abTO;
        ((qk)localObject3).jrV = ((fvq)localObject4).abTP;
        ((qk)localObject3).jrW = ((fvq)localObject4).abTQ;
        ((qk)localObject3).bMH();
        localObject4 = e.Pnh;
        e.c((com.tencent.mm.plugin.report.a)localObject3);
        s.u(localObject1, "id");
      }
      try
      {
        ((g)h.az(g.class)).removeFromMemory(15, s.X("vasReport", localObject1));
        label258:
        if (paramIntent != null) {
          paramIntent.removeExtra("MicroMsg.VAS.reportId");
        }
        AppMethodBeat.o(298532);
        return;
      }
      finally
      {
        break label258;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.e
 * JD-Core Version:    0.7.0.1
 */