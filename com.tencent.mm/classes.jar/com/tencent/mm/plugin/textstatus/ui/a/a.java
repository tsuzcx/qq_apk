package com.tencent.mm.plugin.textstatus.ui.a;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/card/TextStatusCardFeedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "cardsCollect", "", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "getCardsCollect", "()Ljava/util/Set;", "curCardHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCurCardHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "curCardHolderRef", "Ljava/lang/ref/WeakReference;", "isNeedShowScrollTips", "", "()Z", "setNeedShowScrollTips", "(Z)V", "lastPos", "", "getLastPos", "()I", "setLastPos", "(I)V", "lastScrollUserName", "", "getLastScrollUserName", "()Ljava/lang/String;", "setLastScrollUserName", "(Ljava/lang/String;)V", "lastSelectUserName", "getLastSelectUserName", "setLastSelectUserName", "localLikeRecords", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLocalLikeRecords", "()Ljava/util/HashMap;", "onBackPressed", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBefore", "onDestroy", "onFirstOverScroll", "onPageSelected", "position", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onPageSettle", "onPause", "onResume", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public static final a.a TAz;
  public int Ahg;
  public boolean TAA;
  public WeakReference<com.tencent.mm.view.recyclerview.j> TAB;
  public String TAC;
  public String TAD;
  public final Set<com.tencent.mm.plugin.textstatus.a.j> TAE;
  public final HashMap<String, Boolean> TAF;
  
  static
  {
    AppMethodBeat.i(291743);
    TAz = new a.a((byte)0);
    AppMethodBeat.o(291743);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(291736);
    this.TAC = "";
    this.TAD = "";
    this.TAE = ((Set)new HashSet());
    this.Ahg = -1;
    this.TAF = new HashMap();
    AppMethodBeat.o(291736);
  }
  
  public final com.tencent.mm.view.recyclerview.j hKd()
  {
    AppMethodBeat.i(291747);
    Object localObject = this.TAB;
    if (localObject == null)
    {
      AppMethodBeat.o(291747);
      return null;
    }
    localObject = (com.tencent.mm.view.recyclerview.j)((WeakReference)localObject).get();
    AppMethodBeat.o(291747);
    return localObject;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(291774);
    Object localObject = hKd();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.plugin.textstatus.a.j)) {
        break label58;
      }
    }
    label58:
    for (localObject = (com.tencent.mm.plugin.textstatus.a.j)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.textstatus.a.j)localObject).onBackPressed();
      }
      boolean bool = super.onBackPressed();
      AppMethodBeat.o(291774);
      return bool;
      localObject = ((com.tencent.mm.view.recyclerview.j)localObject).tag;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(291759);
    super.onCreate(paramBundle);
    int i = h.baE().ban().getInt(at.a.adhl, 0);
    if (i < 3) {
      bool = true;
    }
    this.TAA = bool;
    h.baE().ban().set(at.a.adhl, Integer.valueOf(i + 1));
    AppMethodBeat.o(291759);
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(291753);
    super.onCreateBefore(paramBundle);
    if (com.tencent.mm.aw.a.bLk()) {
      com.tencent.mm.aw.a.bLi();
    }
    AppMethodBeat.o(291753);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291782);
    super.onDestroy();
    Object localObject = hKd();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.plugin.textstatus.a.j)) {
        break label92;
      }
    }
    label92:
    for (localObject = (com.tencent.mm.plugin.textstatus.a.j)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.textstatus.a.j)localObject).wk(203L);
      }
      localObject = ((Iterable)this.TAE).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((com.tencent.mm.plugin.textstatus.a.j)((Iterator)localObject).next()).hFv();
      }
      localObject = ((com.tencent.mm.view.recyclerview.j)localObject).tag;
      break;
    }
    this.TAE.clear();
    this.TAF.clear();
    AppMethodBeat.o(291782);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291763);
    super.onPause();
    Object localObject = hKd();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.plugin.textstatus.a.j)) {
        break label56;
      }
    }
    label56:
    for (localObject = (com.tencent.mm.plugin.textstatus.a.j)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.textstatus.a.j)localObject).hFx();
      }
      AppMethodBeat.o(291763);
      return;
      localObject = ((com.tencent.mm.view.recyclerview.j)localObject).tag;
      break;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291770);
    super.onResume();
    Object localObject = hKd();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof com.tencent.mm.plugin.textstatus.a.j)) {
        break label56;
      }
    }
    label56:
    for (localObject = (com.tencent.mm.plugin.textstatus.a.j)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.textstatus.a.j)localObject).hFw();
      }
      AppMethodBeat.o(291770);
      return;
      localObject = ((com.tencent.mm.view.recyclerview.j)localObject).tag;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.a.a
 * JD-Core Version:    0.7.0.1
 */