package com.tencent.mm.plugin.repairer.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/RepairerListFolderUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "getLayoutId", "", "listFolder", "", "folderPath", "", "outputBuffer", "Ljava/lang/StringBuffer;", "layer", "prefix", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerListFolderUI
  extends BaseRepairerUI
{
  private static final void a(RepairerListFolderUI paramRepairerListFolderUI, View paramView)
  {
    AppMethodBeat.i(277968);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramRepairerListFolderUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerListFolderUI, "this$0");
    paramView = ((EditText)paramRepairerListFolderUI.findViewById(b.c.OtZ)).getText().toString();
    try
    {
      i = Integer.parseInt(((EditText)paramRepairerListFolderUI.findViewById(b.c.Oul)).getText().toString());
      if (!y.ZC(paramView))
      {
        aa.makeText((Context)paramRepairerListFolderUI.getContext(), (CharSequence)"路径不存在", 0).show();
        a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(277968);
        return;
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        i = 2;
      }
      StringBuffer localStringBuffer = new StringBuffer();
      paramRepairerListFolderUI.a(paramView, localStringBuffer, i, "- ");
      ((TextView)paramRepairerListFolderUI.findViewById(b.c.OuB)).setText((CharSequence)localStringBuffer.toString());
      a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277968);
    }
  }
  
  private final void a(String paramString1, StringBuffer paramStringBuffer, int paramInt, String paramString2)
  {
    AppMethodBeat.i(277949);
    if (paramInt == 0)
    {
      AppMethodBeat.o(277949);
      return;
    }
    Object localObject1 = y.eB(paramString1, false);
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 != null; localObject1 = p.a((Iterable)localObject1, (Comparator)new RepairerListFolderUI.a()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (j)((Iterator)localObject1).next();
        paramStringBuffer.append(paramString2 + ((j)localObject2).name + '\n');
        if (((j)localObject2).agxh)
        {
          paramStringBuffer.append(paramString2 + f.formatTime("yyyy-MM-dd HH:mm:ss", ((j)localObject2).agxg / 1000L) + '\n');
          localObject2 = ah.v(new u(paramString1, ((j)localObject2).name).jKT());
          s.s(localObject2, "VFSFile(folderPath, it.name).absolutePath");
          a((String)localObject2, paramStringBuffer, paramInt - 1, s.X(paramString2, "- "));
        }
      }
    }
    AppMethodBeat.o(277949);
  }
  
  private static final boolean a(RepairerListFolderUI paramRepairerListFolderUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(277959);
    s.u(paramRepairerListFolderUI, "this$0");
    paramRepairerListFolderUI.finish();
    AppMethodBeat.o(277959);
    return true;
  }
  
  public final int getLayoutId()
  {
    return b.d.OvV;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277983);
    super.onCreate(paramBundle);
    setMMTitle("扫描文件目录");
    setBackBtn(new RepairerListFolderUI..ExternalSyntheticLambda0(this));
    findViewById(b.c.ok_btn).setOnClickListener(new RepairerListFolderUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(277983);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerListFolderUI
 * JD-Core Version:    0.7.0.1
 */