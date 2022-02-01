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
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "isNotifyMoment", "", "()Z", "setNotifyMoment", "(Z)V", "menuDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "mergedUserList", "Ljava/util/ArrayList;", "getMergedUserList", "()Ljava/util/ArrayList;", "setMergedUserList", "(Ljava/util/ArrayList;)V", "moreBtn", "Landroid/widget/ImageView;", "moreMenuStatusGroup", "Landroid/widget/LinearLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scene", "", "selectedChatroomList", "getSelectedChatroomList", "()Ljava/lang/String;", "setSelectedChatroomList", "(Ljava/lang/String;)V", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedLabelList", "getSelectedLabelList", "setSelectedLabelList", "selectedUserList", "getSelectedUserList", "setSelectedUserList", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cleanSelectedCache", "", "createMenuDialog", "getContactNamesFromChatroom", "chatrooms", "", "getContactNamesFromLabelsAndOtherUserName", "labels", "userNames", "getSelectIndex", "goLabelUI", "hasSelectedRange", "mergeSelectedRangeUser", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onClick", "v", "Landroid/view/View;", "release", "reset", "setScene", "setVisibility", "visibility", "updateMenuStatus", "plugin-recordvideo_release"})
public final class j
  implements View.OnClickListener, u
{
  private d APl;
  private final ImageView HMY;
  private final LinearLayout HMZ;
  private com.google.android.material.bottomsheet.a HNa;
  public boolean HNb;
  private String HNc;
  private String HNd;
  private String HNe;
  private ArrayList<String> HNf;
  private final String TAG;
  public int bhr;
  private ViewGroup parent;
  private int scene;
  
  public j(ViewGroup paramViewGroup, d paramd)
  {
    AppMethodBeat.i(75524);
    this.parent = paramViewGroup;
    this.APl = paramd;
    this.TAG = "MicroMsg.EditMenuPlugin";
    paramViewGroup = this.parent.findViewById(b.e.record_editor_more_menu);
    p.j(paramViewGroup, "parent.findViewById(R.id.record_editor_more_menu)");
    this.HMY = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.record_editor_more_menu_status_group);
    p.j(paramViewGroup, "parent.findViewById(R.id…r_more_menu_status_group)");
    this.HMZ = ((LinearLayout)paramViewGroup);
    this.HNb = true;
    this.HNf = new ArrayList();
    this.HMY.setVisibility(8);
    this.HMY.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75524);
  }
  
  private final void fwO()
  {
    this.bhr = 0;
    this.HNc = null;
    this.HNd = null;
    this.HNe = null;
  }
  
  private final void fwP()
  {
    AppMethodBeat.i(75515);
    this.HMZ.removeAllViews();
    LinearLayout.LayoutParams localLayoutParams;
    if (!this.HNb)
    {
      localObject = new ImageView(this.parent.getContext());
      ((ImageView)localObject).setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_moment_off, -1));
      localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.record_icon_size), com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.record_icon_size));
      localLayoutParams.topMargin = com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.LargePadding);
      this.HMZ.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    }
    Object localObject = (CharSequence)this.HNc;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (CharSequence)this.HNd;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label315;
        }
        i = 1;
        label168:
        if (i != 0)
        {
          localObject = (CharSequence)this.HNe;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label320;
          }
          i = 1;
          label195:
          if (i != 0) {
            break label325;
          }
        }
      }
    }
    label315:
    label320:
    label325:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new ImageView(this.parent.getContext());
        ((ImageView)localObject).setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_me_hl, -1));
        localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.record_icon_size), com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.record_icon_size));
        localLayoutParams.topMargin = com.tencent.mm.ci.a.aZ(this.parent.getContext(), b.c.LargePadding);
        this.HMZ.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
      }
      AppMethodBeat.o(75515);
      return;
      i = 0;
      break;
      i = 0;
      break label168;
      i = 0;
      break label195;
    }
  }
  
  private final void gK(List<String> paramList)
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
      Object localObject = com.tencent.mm.model.v.Pt(str1);
      if (localObject != null)
      {
        Log.d(this.TAG, "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.HNf.contains(str2)) && (ab.Ql(str2)))
          {
            Log.i(this.TAG, "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.HNf.add(str2);
          }
          if (ab.Ql(str2)) {
            localArrayList.add(str2);
          }
        }
        Log.d(this.TAG, "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
      }
    }
    AppMethodBeat.o(75516);
  }
  
  private final void v(List<String> paramList1, List<String> paramList2)
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
        localObject = com.tencent.mm.plugin.label.a.a.eLe().aMR(com.tencent.mm.plugin.label.a.a.eLe().aMO((String)localObject));
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          Log.e(this.TAG, "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.HNf = new ArrayList((Collection)localHashSet);
        if (paramList1 == null) {
          break;
        }
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext()) {
          Util.isNullOrNil((String)paramList1.next());
        }
      }
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHashSet.add(str);
        Log.d(this.TAG, "dz:name : %s", new Object[] { str });
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if (!this.HNf.contains(paramList2)) {
          this.HNf.add(paramList2);
        }
      }
    }
    AppMethodBeat.o(163428);
  }
  
  public final void bbp() {}
  
  public final String fwQ()
  {
    Object localObject3 = null;
    AppMethodBeat.i(75520);
    this.HNf.clear();
    Object localObject2;
    int i;
    if (!Util.isNullOrNil(this.HNd))
    {
      localObject1 = this.HNd;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = (CharSequence)localObject1;
      localObject1 = new k(",").u((CharSequence)localObject1, 0);
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
      for (localObject1 = kotlin.a.j.c((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);; localObject1 = (List)kotlin.a.v.aaAd)
      {
        localObject1 = ((Collection)localObject1).toArray(new String[0]);
        if (localObject1 != null) {
          break label184;
        }
        localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
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
      if (!Util.isNullOrNil(this.HNc))
      {
        localObject2 = this.HNc;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = (CharSequence)localObject2;
        localObject2 = new k(",").u((CharSequence)localObject2, 0);
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
        for (localObject2 = kotlin.a.j.c((Iterable)localObject2, localListIterator.nextIndex() + 1);; localObject2 = (List)kotlin.a.v.aaAd)
        {
          localObject2 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject2 != null) {
            break label374;
          }
          localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
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
        if (!Util.isNullOrNil(this.HNe))
        {
          localObject3 = this.HNe;
          if (localObject3 == null) {
            p.iCn();
          }
          localObject3 = (CharSequence)localObject3;
          localObject3 = new k(",").u((CharSequence)localObject3, 0);
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
          for (localObject3 = kotlin.a.j.c((Iterable)localObject3, localListIterator.nextIndex() + 1);; localObject3 = (List)kotlin.a.v.aaAd)
          {
            localObject3 = ((Collection)localObject3).toArray(new String[0]);
            if (localObject3 != null) {
              break label579;
            }
            localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
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
        v((List)localObject1, (List)localObject2);
        gK((List)localObject3);
        Log.i(this.TAG, "mergeSelectedRangeUser count:" + this.HNf.size());
        localObject1 = Util.listToString((List)this.HNf, ",");
        p.j(localObject1, "Util.listToString(mergedUserList, \",\")");
        AppMethodBeat.o(75520);
        return localObject1;
      }
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(224101);
    String str = getClass().getName();
    AppMethodBeat.o(224101);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75523);
    Log.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75523);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.bhr = paramIntent.getIntExtra("Ktag_range_index", 0);
        this.HNd = paramIntent.getStringExtra("Klabel_name_list");
        this.HNc = paramIntent.getStringExtra("Kother_user_name_list");
        this.HNe = paramIntent.getStringExtra("Kchat_room_name_list");
        fwP();
      }
    }
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75517);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = this.HNa;
    if (paramView != null) {
      paramView.dismiss();
    }
    switch (this.scene)
    {
    }
    for (paramView = null;; paramView = (com.google.android.material.bottomsheet.a)paramView)
    {
      this.HNa = paramView;
      paramView = this.HNa;
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75517);
      return;
      paramView = this.parent.getContext();
      p.j(paramView, "parent.context");
      paramView = new e(paramView);
      paramView.HZH = this.HNb;
      paramView.HZG = ((kotlin.g.a.a)new a(this));
    }
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(224104);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(224104);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(75521);
    this.HMZ.removeAllViews();
    this.HNb = true;
    fwO();
    AppMethodBeat.o(75521);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75522);
    this.HMZ.removeAllViews();
    this.HNb = true;
    fwO();
    AppMethodBeat.o(75522);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(75519);
    Log.i(this.TAG, "setScene ".concat(String.valueOf(paramInt)));
    this.scene = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(75519);
      return;
      this.HMY.setImageDrawable(au.o(this.parent.getContext(), b.g.icons_filled_more, -1));
      if (!com.tencent.mm.plugin.recordvideo.b.a.a.HKu.fvN())
      {
        this.HMY.setVisibility(8);
        AppMethodBeat.o(75519);
        return;
      }
      this.HMY.setVisibility(0);
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75518);
    this.HMY.setVisibility(paramInt);
    AppMethodBeat.o(75518);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.j
 * JD-Core Version:    0.7.0.1
 */