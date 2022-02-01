package com.tencent.mm.plugin.repairer.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/RepairerListFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "listFolder", "", "folderPath", "", "outputBuffer", "Ljava/lang/StringBuffer;", "layer", "prefix", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"})
public final class RepairerListFolderUI
  extends MMActivity
{
  private final void a(String paramString1, StringBuffer paramStringBuffer, int paramInt, String paramString2)
  {
    AppMethodBeat.i(226754);
    if (paramInt == 0)
    {
      AppMethodBeat.o(226754);
      return;
    }
    Object localObject1 = u.dP(paramString1, false);
    if (localObject1 != null) {
      localObject1 = j.a((Iterable)localObject1, (Comparator)new a());
    }
    while (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (com.tencent.mm.vfs.f)((Iterator)localObject1).next();
          paramStringBuffer.append(paramString2 + ((com.tencent.mm.vfs.f)localObject2).name + '\n');
          if (((com.tencent.mm.vfs.f)localObject2).YCj)
          {
            paramStringBuffer.append(paramString2 + com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd HH:mm:ss", ((com.tencent.mm.vfs.f)localObject2).YCi / 1000L) + '\n');
            localObject2 = new q(paramString1, ((com.tencent.mm.vfs.f)localObject2).name).bOF();
            p.j(localObject2, "VFSFile(folderPath, it.name).absolutePath");
            a((String)localObject2, paramStringBuffer, paramInt - 1, paramString2 + "- ");
            continue;
            localObject1 = null;
            break;
          }
        }
      }
      AppMethodBeat.o(226754);
      return;
    }
    AppMethodBeat.o(226754);
  }
  
  public final int getLayoutId()
  {
    return b.b.IwP;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(226748);
    super.onCreate(paramBundle);
    setMMTitle("扫描文件目录");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    findViewById(b.a.ok_btn).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(226748);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(226554);
      int i = kotlin.b.a.a((Comparable)Long.valueOf(((com.tencent.mm.vfs.f)paramT2).YCi), (Comparable)Long.valueOf(((com.tencent.mm.vfs.f)paramT1).YCi));
      AppMethodBeat.o(226554);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(RepairerListFolderUI paramRepairerListFolderUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(226670);
      this.IwX.finish();
      AppMethodBeat.o(226670);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(RepairerListFolderUI paramRepairerListFolderUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(226945);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.IwX.findViewById(b.a.Iwh);
      p.j(paramView, "findViewById<EditText>(R.id.folder_path_et)");
      paramView = ((EditText)paramView).getText().toString();
      try
      {
        localObject = this.IwX.findViewById(b.a.Iwm);
        p.j(localObject, "findViewById<EditText>(R.id.layer_et)");
        i = Integer.parseInt(((EditText)localObject).getText().toString());
        if (!u.agG(paramView))
        {
          w.makeText((Context)this.IwX.getContext(), (CharSequence)"路径不存在", 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(226945);
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
        RepairerListFolderUI.a(this.IwX, paramView, localStringBuffer, i, "- ");
        paramView = this.IwX.findViewById(b.a.Iwu);
        p.j(paramView, "findViewById<TextView>(R.id.output_tv)");
        ((TextView)paramView).setText((CharSequence)localStringBuffer.toString());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/repairer/ui/RepairerListFolderUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(226945);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.RepairerListFolderUI
 * JD-Core Version:    0.7.0.1
 */