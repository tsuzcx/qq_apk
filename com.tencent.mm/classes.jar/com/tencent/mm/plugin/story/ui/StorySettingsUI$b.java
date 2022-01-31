package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ChoiceItem;", "Lcom/tencent/mm/plugin/story/ui/StorySettingsUI$ITestMenu;", "_showtitle", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "(Lcom/tencent/mm/plugin/story/ui/StorySettingsUI;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_showtitle", "()Ljava/lang/String;", "set_showtitle", "(Ljava/lang/String;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "value", "getValue", "get", "field", "showAlert", "", "view", "Landroid/view/View;", "title", "plugin-story_release"})
public final class StorySettingsUI$b
  implements StorySettingsUI.e
{
  private String oQE;
  private String[] oQF;
  ac.a oQH;
  Object sHT;
  
  public StorySettingsUI$b(String paramString, ac.a parama, String[] paramArrayOfString, Object paramObject)
  {
    AppMethodBeat.i(110048);
    this.oQE = parama;
    this.oQH = paramArrayOfString;
    this.oQF = paramObject;
    this.sHT = localObject;
    AppMethodBeat.o(110048);
  }
  
  private final String ck(Object paramObject)
  {
    AppMethodBeat.i(110047);
    Object localObject = this.sHT;
    int j;
    int i;
    if ((localObject instanceof long[]))
    {
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(110047);
        throw paramObject;
      }
      long l = ((Long)paramObject).longValue();
      paramObject = this.sHT;
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
        AppMethodBeat.o(110047);
        throw paramObject;
      }
      j = ((long[])paramObject).length;
      i = 0;
      while (i < j)
      {
        paramObject = this.sHT;
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.LongArray");
          AppMethodBeat.o(110047);
          throw paramObject;
        }
        if ((l == ((long[])paramObject)[i]) && (i < this.oQF.length))
        {
          paramObject = this.oQF[i];
          AppMethodBeat.o(110047);
          return paramObject;
        }
        i += 1;
      }
      paramObject = this.oQF[0];
      AppMethodBeat.o(110047);
      return paramObject;
    }
    if ((localObject instanceof int[]))
    {
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(110047);
        throw paramObject;
      }
      j = ((Integer)paramObject).intValue();
      paramObject = this.sHT;
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
        AppMethodBeat.o(110047);
        throw paramObject;
      }
      int k = ((int[])paramObject).length;
      i = 0;
      while (i < k)
      {
        paramObject = this.sHT;
        if (paramObject == null)
        {
          paramObject = new v("null cannot be cast to non-null type kotlin.IntArray");
          AppMethodBeat.o(110047);
          throw paramObject;
        }
        if ((j == ((int[])paramObject)[i]) && (i < this.oQF.length))
        {
          paramObject = this.oQF[i];
          AppMethodBeat.o(110047);
          return paramObject;
        }
        i += 1;
      }
      paramObject = this.oQF[0];
      AppMethodBeat.o(110047);
      return paramObject;
    }
    AppMethodBeat.o(110047);
    return "";
  }
  
  public final String Ol()
  {
    return this.oQE;
  }
  
  public final void ek(View paramView)
  {
    AppMethodBeat.i(110046);
    j.q(paramView, "view");
    paramView = new LinkedList();
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    int j = this.oQF.length;
    while (i < j)
    {
      paramView.add(this.oQF[i]);
      localLinkedList.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)this.sHQ, "", (List)paramView, (List)localLinkedList, "", (h.d)new StorySettingsUI.b.a(this));
    AppMethodBeat.o(110046);
  }
  
  public final String value()
  {
    AppMethodBeat.i(110045);
    if ((this.sHT instanceof long[]))
    {
      localObject = StorySettingsUI.a(this.sHQ);
      if (localObject == null) {
        j.ebi();
      }
      localObject = ck(((StoryCaptureProxy)localObject).get(this.oQH, Long.valueOf(0L)));
      AppMethodBeat.o(110045);
      return localObject;
    }
    Object localObject = StorySettingsUI.a(this.sHQ);
    if (localObject == null) {
      j.ebi();
    }
    localObject = ck(((StoryCaptureProxy)localObject).get(this.oQH, Integer.valueOf(0)));
    AppMethodBeat.o(110045);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StorySettingsUI.b
 * JD-Core Version:    0.7.0.1
 */