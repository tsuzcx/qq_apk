package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onSceneEnd", "com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1;", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "topicId", "", "getTopicId", "()Ljava/lang/String;", "setTopicId", "(Ljava/lang/String;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusSquareActivity
  extends MMActivity
{
  public static final a TAq;
  private final d TAr;
  w lKp;
  private ArrayList<com.tencent.mm.plugin.textstatus.h.e.e> pUj;
  private String topicId;
  WxRecyclerView yAg;
  
  static
  {
    AppMethodBeat.i(291505);
    TAq = new a((byte)0);
    AppMethodBeat.o(291505);
  }
  
  public TextStatusSquareActivity()
  {
    AppMethodBeat.i(291488);
    this.pUj = new ArrayList();
    this.TAr = new d(this);
    AppMethodBeat.o(291488);
  }
  
  private static final boolean a(TextStatusSquareActivity paramTextStatusSquareActivity, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291497);
    s.u(paramTextStatusSquareActivity, "this$0");
    paramTextStatusSquareActivity.onBackPressed();
    AppMethodBeat.o(291497);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.TfL;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291528);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn(new TextStatusSquareActivity..ExternalSyntheticLambda0(this));
    paramBundle = getIntent().getExtras();
    Object localObject;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject = getIntent().getExtras();
      if (localObject != null) {
        break label254;
      }
      localObject = null;
      label59:
      this.topicId = ((String)localObject);
      localObject = getIntent().getExtras();
      if (localObject != null) {
        ((Bundle)localObject).getString("STATUS_ID");
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      this.pUj.add(new com.tencent.mm.plugin.textstatus.h.e.e(String.valueOf(i), "test", "", "", ""));
      if (j > 10)
      {
        this.yAg = ((WxRecyclerView)findViewById(a.e.recycler_view));
        localObject = this.yAg;
        if (localObject != null) {
          ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        }
        localObject = this.yAg;
        if (localObject != null) {
          ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new b(), this.pUj));
        }
        localObject = this.yAg;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((WxRecyclerView)localObject).getAdapter())
        {
          if (localObject != null) {
            break label276;
          }
          paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerAdapter<*>");
          AppMethodBeat.o(291528);
          throw paramBundle;
          paramBundle = paramBundle.getString("TEXT_STATUS");
          break;
          label254:
          localObject = ((Bundle)localObject).getString("TOPIC_ID");
          break label59;
        }
        label276:
        i.a((i)localObject, (i.b)new com.tencent.mm.plugin.textstatus.h.e.d(s.X("#", paramBundle), "共324人 同城23人"));
        paramBundle = this.yAg;
        if (paramBundle != null) {
          paramBundle.a((RecyclerView.h)new c(this));
        }
        AppMethodBeat.o(291528);
        return;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "p", "Landroid/os/Bundle;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291737);
      if (paramInt == -1)
      {
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.d();
        AppMethodBeat.o(291737);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.e();
      AppMethodBeat.o(291737);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onCreate$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    c(TextStatusSquareActivity paramTextStatusSquareActivity) {}
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      int i = 1;
      AppMethodBeat.i(291742);
      s.u(paramRect, "outRect");
      s.u(paramRecyclerView, "parent");
      paramRecyclerView = this.TAs.yAg;
      if (paramRecyclerView == null) {}
      while (paramInt == i - 1)
      {
        paramRect.bottom = a.fromDPToPix((Context)this.TAs, 16);
        AppMethodBeat.o(291742);
        return;
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView != null) {
          i = paramRecyclerView.getItemCount();
        }
      }
      paramRect.bottom = a.fromDPToPix((Context)this.TAs, 8);
      AppMethodBeat.o(291742);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusSquareActivity$onSceneEnd$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.am.h
  {
    d(TextStatusSquareActivity paramTextStatusSquareActivity) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(291744);
      if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.f))
      {
        com.tencent.mm.kernel.h.aZW();
        AppMethodBeat.o(291744);
        throw null;
      }
      paramString = this.TAs.lKp;
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(291744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSquareActivity
 * JD-Core Version:    0.7.0.1
 */