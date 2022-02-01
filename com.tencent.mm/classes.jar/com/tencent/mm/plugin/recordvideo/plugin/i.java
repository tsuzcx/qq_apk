package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.k;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "isNotifyMoment", "", "()Z", "setNotifyMoment", "(Z)V", "menuDialog", "Landroid/support/design/widget/BottomSheetDialog;", "mergedUserList", "Ljava/util/ArrayList;", "getMergedUserList", "()Ljava/util/ArrayList;", "setMergedUserList", "(Ljava/util/ArrayList;)V", "moreBtn", "Landroid/widget/ImageView;", "moreMenuStatusGroup", "Landroid/widget/LinearLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scene", "", "selectedChatroomList", "getSelectedChatroomList", "()Ljava/lang/String;", "setSelectedChatroomList", "(Ljava/lang/String;)V", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedLabelList", "getSelectedLabelList", "setSelectedLabelList", "selectedUserList", "getSelectedUserList", "setSelectedUserList", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cleanSelectedCache", "", "createMenuDialog", "getContactNamesFromChatroom", "chatrooms", "", "getContactNamesFromLabelsAndOtherUserName", "labels", "userNames", "getSelectIndex", "goLabelUI", "hasSelectedRange", "mergeSelectedRangeUser", "name", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onClick", "v", "Landroid/view/View;", "release", "reset", "setScene", "setVisibility", "visibility", "updateMenuStatus", "plugin-recordvideo_release"})
public final class i
  implements View.OnClickListener, t
{
  private final String TAG;
  public int bxN;
  private ViewGroup gqv;
  private d sQE;
  private int scene;
  private final ImageView xAl;
  private final LinearLayout xAm;
  private android.support.design.widget.a xAn;
  public boolean xAo;
  private String xAp;
  private String xAq;
  private String xAr;
  private ArrayList<String> xAs;
  
  public i(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75524);
    this.gqv = paramViewGroup;
    this.sQE = paramd;
    this.TAG = "MicroMsg.EditMenuPlugin";
    paramViewGroup = this.gqv.findViewById(2131303885);
    p.g(paramViewGroup, "parent.findViewById(R.id.record_editor_more_menu)");
    this.xAl = ((ImageView)paramViewGroup);
    paramViewGroup = this.gqv.findViewById(2131303886);
    p.g(paramViewGroup, "parent.findViewById(R.id…r_more_menu_status_group)");
    this.xAm = ((LinearLayout)paramViewGroup);
    this.xAo = true;
    this.xAs = new ArrayList();
    this.xAl.setVisibility(8);
    this.xAl.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75524);
  }
  
  private final void dGq()
  {
    this.bxN = 0;
    this.xAp = null;
    this.xAq = null;
    this.xAr = null;
  }
  
  private final void dGr()
  {
    AppMethodBeat.i(75515);
    this.xAm.removeAllViews();
    LinearLayout.LayoutParams localLayoutParams;
    if (!this.xAo)
    {
      localObject = new ImageView(this.gqv.getContext());
      ((ImageView)localObject).setImageDrawable(ao.k(this.gqv.getContext(), 2131690435, -1));
      localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131166749), com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131166749));
      localLayoutParams.topMargin = com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131165480);
      this.xAm.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    }
    Object localObject = (CharSequence)this.xAp;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (CharSequence)this.xAq;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label307;
        }
        i = 1;
        label164:
        if (i != 0)
        {
          localObject = (CharSequence)this.xAr;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label312;
          }
          i = 1;
          label191:
          if (i != 0) {
            break label317;
          }
        }
      }
    }
    label307:
    label312:
    label317:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new ImageView(this.gqv.getContext());
        ((ImageView)localObject).setImageDrawable(ao.k(this.gqv.getContext(), 2131690427, -1));
        localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131166749), com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131166749));
        localLayoutParams.topMargin = com.tencent.mm.cc.a.ay(this.gqv.getContext(), 2131165480);
        this.xAm.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
      }
      AppMethodBeat.o(75515);
      return;
      i = 0;
      break;
      i = 0;
      break label164;
      i = 0;
      break label191;
    }
  }
  
  private final void fc(List<String> paramList)
  {
    AppMethodBeat.i(75516);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(75516);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str1 = (String)paramList.next();
      ArrayList localArrayList = new ArrayList();
      Object localObject = com.tencent.mm.model.q.yR(str1);
      if (localObject != null)
      {
        ad.d(this.TAG, "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.xAs.contains(str2)) && (w.zD(str2)))
          {
            ad.i(this.TAG, "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.xAs.add(str2);
          }
          if (w.zD(str2)) {
            localArrayList.add(str2);
          }
        }
        ad.d(this.TAG, "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
      }
    }
    AppMethodBeat.o(75516);
  }
  
  private final void p(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(163428);
    Iterator localIterator;
    HashSet localHashSet;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      localIterator = paramList1.iterator();
      localHashSet = new HashSet();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localObject = com.tencent.mm.plugin.label.a.a.dfo().aop(com.tencent.mm.plugin.label.a.a.dfo().aom((String)localObject));
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          ad.e(this.TAG, "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.xAs = new ArrayList((Collection)localHashSet);
        if (paramList1 == null) {
          break;
        }
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext()) {
          bt.isNullOrNil((String)paramList1.next());
        }
      }
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHashSet.add(str);
        ad.d(this.TAG, "dz:name : %s", new Object[] { str });
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!this.xAs.contains(paramList2)) {
          this.xAs.add(paramList2);
        }
      }
    }
    AppMethodBeat.o(163428);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String dGs()
  {
    Object localObject3 = null;
    AppMethodBeat.i(75520);
    this.xAs.clear();
    Object localObject2;
    int i;
    if (!bt.isNullOrNil(this.xAq))
    {
      localObject1 = this.xAq;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = (CharSequence)localObject1;
      localObject1 = new k(",").q((CharSequence)localObject1, 0);
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        if (((ListIterator)localObject2).hasPrevious()) {
          if (((CharSequence)((ListIterator)localObject2).previous()).length() == 0)
          {
            i = 1;
            label112:
            if (i != 0) {
              break label172;
            }
          }
        }
      }
      for (localObject1 = j.b((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);; localObject1 = (List)d.a.v.MKE)
      {
        localObject1 = ((Collection)localObject1).toArray(new String[0]);
        if (localObject1 != null) {
          break label184;
        }
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(75520);
        throw ((Throwable)localObject1);
        i = 0;
        break label112;
        label172:
        break;
      }
      label184:
      localObject1 = (String[])localObject1;
    }
    for (Object localObject1 = Arrays.asList((String[])Arrays.copyOf((Object[])localObject1, localObject1.length));; localObject1 = null)
    {
      ListIterator localListIterator;
      if (!bt.isNullOrNil(this.xAp))
      {
        localObject2 = this.xAp;
        if (localObject2 == null) {
          p.gfZ();
        }
        localObject2 = (CharSequence)localObject2;
        localObject2 = new k(",").q((CharSequence)localObject2, 0);
        if (!((List)localObject2).isEmpty())
        {
          localListIterator = ((List)localObject2).listIterator(((List)localObject2).size());
          if (localListIterator.hasPrevious()) {
            if (((CharSequence)localListIterator.previous()).length() == 0)
            {
              i = 1;
              label301:
              if (i != 0) {
                break label362;
              }
            }
          }
        }
        for (localObject2 = j.b((Iterable)localObject2, localListIterator.nextIndex() + 1);; localObject2 = (List)d.a.v.MKE)
        {
          localObject2 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject2 != null) {
            break label374;
          }
          localObject1 = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(75520);
          throw ((Throwable)localObject1);
          i = 0;
          break label301;
          label362:
          break;
        }
        label374:
        localObject2 = (String[])localObject2;
      }
      for (localObject2 = Arrays.asList((String[])Arrays.copyOf((Object[])localObject2, localObject2.length));; localObject2 = null)
      {
        if (!bt.isNullOrNil(this.xAr))
        {
          localObject3 = this.xAr;
          if (localObject3 == null) {
            p.gfZ();
          }
          localObject3 = (CharSequence)localObject3;
          localObject3 = new k(",").q((CharSequence)localObject3, 0);
          if (!((List)localObject3).isEmpty())
          {
            localListIterator = ((List)localObject3).listIterator(((List)localObject3).size());
            if (localListIterator.hasPrevious()) {
              if (((CharSequence)localListIterator.previous()).length() == 0)
              {
                i = 1;
                label500:
                if (i != 0) {
                  break label566;
                }
              }
            }
          }
          for (localObject3 = j.b((Iterable)localObject3, localListIterator.nextIndex() + 1);; localObject3 = (List)d.a.v.MKE)
          {
            localObject3 = ((Collection)localObject3).toArray(new String[0]);
            if (localObject3 != null) {
              break label579;
            }
            localObject1 = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(75520);
            throw ((Throwable)localObject1);
            i = 0;
            break label500;
            label566:
            break;
          }
          label579:
          localObject3 = (String[])localObject3;
          localObject3 = Arrays.asList((String[])Arrays.copyOf((Object[])localObject3, localObject3.length));
        }
        p((List)localObject1, (List)localObject2);
        fc((List)localObject3);
        ad.i(this.TAG, "mergeSelectedRangeUser count:" + this.xAs.size());
        localObject1 = bt.m((List)this.xAs, ",");
        p.g(localObject1, "Util.listToString(mergedUserList, \",\")");
        AppMethodBeat.o(75520);
        return localObject1;
      }
    }
  }
  
  public final String name()
  {
    return "plugin_menu";
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75523);
    ad.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75523);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.bxN = paramIntent.getIntExtra("Ktag_range_index", 0);
        this.xAq = paramIntent.getStringExtra("Klabel_name_list");
        this.xAp = paramIntent.getStringExtra("Kother_user_name_list");
        this.xAr = paramIntent.getStringExtra("Kchat_room_name_list");
        dGr();
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75517);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = this.xAn;
    if (paramView != null) {
      paramView.dismiss();
    }
    switch (this.scene)
    {
    }
    for (paramView = null;; paramView = (android.support.design.widget.a)paramView)
    {
      this.xAn = paramView;
      paramView = this.xAn;
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75517);
      return;
      paramView = this.gqv.getContext();
      p.g(paramView, "parent.context");
      paramView = new e(paramView);
      paramView.xMv = this.xAo;
      paramView.xMu = ((d.g.a.a)new a(this));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(200312);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200312);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75521);
    this.xAm.removeAllViews();
    this.xAo = true;
    dGq();
    AppMethodBeat.o(75521);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75522);
    this.xAm.removeAllViews();
    this.xAo = true;
    dGq();
    AppMethodBeat.o(75522);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(75519);
    ad.i(this.TAG, "setScene ".concat(String.valueOf(paramInt)));
    this.scene = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75519);
      return;
      this.xAl.setImageDrawable(ao.k(this.gqv.getContext(), 2131690436, -1));
      if (!com.tencent.mm.plugin.recordvideo.b.a.a.xxI.dFz())
      {
        this.xAl.setVisibility(8);
        AppMethodBeat.o(75519);
        return;
      }
      this.xAl.setVisibility(0);
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75518);
    this.xAl.setVisibility(paramInt);
    AppMethodBeat.o(75518);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    a(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.i
 * JD-Core Version:    0.7.0.1
 */