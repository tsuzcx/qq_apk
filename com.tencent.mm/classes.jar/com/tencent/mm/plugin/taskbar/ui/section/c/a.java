package com.tencent.mm.plugin.taskbar.ui.section.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.d.c;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.e;
import com.tencent.mm.plugin.taskbar.ui.section.d;
import com.tencent.mm.plugin.taskbar.ui.section.other.a.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b;
import com.tencent.mm.plugin.taskbar.ui.section.other.b.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dbn;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionOtherViewMusicHelper;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;)V", "getDefaultImageRes", "", "data", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "getSubtitle", "", "loadFromUrl", "", "viewHolder", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "musicMultiTaskData", "Lcom/tencent/mm/protocal/protobuf/MusicMultiTaskData;", "onBindViewHolder", "pos", "viewModel", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionViewModel;", "plugin-taskbar_release"})
public final class a
  extends b
{
  public a(b.a parama)
  {
    super(parama);
    AppMethodBeat.i(214374);
    AppMethodBeat.o(214374);
  }
  
  private static void a(a.b paramb, dbn paramdbn)
  {
    String str = null;
    AppMethodBeat.i(214371);
    paramb.image.setImageDrawable(null);
    Object localObject = paramdbn.lVY;
    if (localObject != null) {
      str = ((dbr)localObject).Ruw;
    }
    localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        str = paramdbn.TIU;
      }
      if (str == null) {
        break;
      }
      Log.i("TaskBarSectionMusicView", "use url: ".concat(String.valueOf(str)));
      q.bml().a(str, paramb.image, e.Mnc);
      AppMethodBeat.o(214371);
      return;
    }
    AppMethodBeat.o(214371);
  }
  
  public final void a(int paramInt, final a.b paramb, d paramd)
  {
    AppMethodBeat.i(214369);
    p.k(paramb, "viewHolder");
    p.k(paramd, "viewModel");
    super.a(paramInt, paramb, paramd);
    final dbn localdbn = new dbn();
    for (;;)
    {
      try
      {
        localdbn.parseFrom(((MultiTaskInfo)paramd.MqV.get(paramInt)).field_data);
        localObject = paramb.Mrl;
        p.j(localObject, "viewHolder.defaultImage");
        ((ImageView)localObject).setVisibility(0);
        paramb.image.setImageDrawable(null);
        localObject = localdbn.lVY;
        if (localObject != null)
        {
          String str = ((dbr)localObject).lVZ;
          if (str != null)
          {
            localObject = localdbn.lVY;
            if (localObject == null) {
              break label262;
            }
            localObject = ((dbr)localObject).Ruw;
            localObject = (CharSequence)localObject;
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break label268;
            }
            i = 1;
            if ((i == 0) || (!u.agG(str))) {
              break label274;
            }
            localObject = h.ZvG.bg((Runnable)new a(str, this, localdbn, paramb));
            if (localObject != null) {
              continue;
            }
          }
        }
        a(paramb, localdbn);
        localObject = x.aazN;
        paramb = paramb.jMg;
        p.j(paramb, "viewHolder.title");
        paramb.setText((CharSequence)((MultiTaskInfo)paramd.MqV.get(paramInt)).fbc().title);
        AppMethodBeat.o(214369);
        return;
      }
      catch (Throwable paramb)
      {
        Log.e("TaskBarSectionMusicView", "MusicMultiTaskData parse failed");
        AppMethodBeat.o(214369);
        return;
      }
      label262:
      Object localObject = null;
      continue;
      label268:
      int i = 0;
      continue;
      label274:
      a(paramb, localdbn);
      localObject = x.aazN;
    }
  }
  
  public final String p(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214373);
    paramMultiTaskInfo = com.tencent.mm.ci.a.ba(MMApplicationContext.getContext(), d.g.MmW);
    p.j(paramMultiTaskInfo, "ResourceHelper.getString…r_section_subtitle_music)");
    AppMethodBeat.o(214373);
    return paramMultiTaskInfo;
  }
  
  public final int q(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(214372);
    p.k(paramMultiTaskInfo, "data");
    int i = d.c.Mml;
    AppMethodBeat.o(214372);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/taskbar/ui/section/music/TaskBarSectionOtherViewMusicHelper$onBindViewHolder$1$1"})
  static final class a
    implements Runnable
  {
    a(String paramString, a parama, dbn paramdbn, a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(215426);
      Bitmap localBitmap = BitmapUtil.decodeFileWithSample(this.JbK, 512, 512);
      if (localBitmap != null)
      {
        Log.i("TaskBarSectionMusicView", "use cover path: " + this.JbK);
        paramb.image.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215115);
            jdField_this.Mrc.image.setImageBitmap(this.cLr);
            AppMethodBeat.o(215115);
          }
        });
        AppMethodBeat.o(215426);
        return;
      }
      paramb.image.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(214246);
          a.b(this.Mrd.Mrc, this.Mrd.Mrb);
          AppMethodBeat.o(214246);
        }
      });
      AppMethodBeat.o(215426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c.a
 * JD-Core Version:    0.7.0.1
 */