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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.ui.editor.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "TAG", "", "isNotifyMoment", "", "()Z", "setNotifyMoment", "(Z)V", "menuDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "mergedUserList", "Ljava/util/ArrayList;", "getMergedUserList", "()Ljava/util/ArrayList;", "setMergedUserList", "(Ljava/util/ArrayList;)V", "moreBtn", "Landroid/widget/ImageView;", "moreMenuStatusGroup", "Landroid/widget/LinearLayout;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "scene", "", "selectedChatroomList", "getSelectedChatroomList", "()Ljava/lang/String;", "setSelectedChatroomList", "(Ljava/lang/String;)V", "selectedIndex", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "selectedLabelList", "getSelectedLabelList", "setSelectedLabelList", "selectedUserList", "getSelectedUserList", "setSelectedUserList", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "cleanSelectedCache", "", "createMenuDialog", "getContactNamesFromChatroom", "chatrooms", "", "getContactNamesFromLabelsAndOtherUserName", "labels", "userNames", "getSelectIndex", "goLabelUI", "hasSelectedRange", "mergeSelectedRangeUser", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onClick", "v", "Landroid/view/View;", "release", "reset", "setScene", "setVisibility", "visibility", "updateMenuStatus", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements View.OnClickListener, v
{
  private com.tencent.mm.plugin.recordvideo.plugin.parent.a GrC;
  private final ImageView NJV;
  private final LinearLayout NJW;
  private com.google.android.material.bottomsheet.a NJX;
  public boolean NJY;
  private String NJZ;
  private String NKa;
  private String NKb;
  private ArrayList<String> NKc;
  private final String TAG;
  public int dbk;
  private ViewGroup parent;
  private int scene;
  
  public k(ViewGroup paramViewGroup, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    AppMethodBeat.i(75524);
    this.parent = paramViewGroup;
    this.GrC = parama;
    this.TAG = "MicroMsg.EditMenuPlugin";
    paramViewGroup = this.parent.findViewById(b.e.record_editor_more_menu);
    s.s(paramViewGroup, "parent.findViewById(R.id.record_editor_more_menu)");
    this.NJV = ((ImageView)paramViewGroup);
    paramViewGroup = this.parent.findViewById(b.e.record_editor_more_menu_status_group);
    s.s(paramViewGroup, "parent.findViewById(R.id…r_more_menu_status_group)");
    this.NJW = ((LinearLayout)paramViewGroup);
    this.NJY = true;
    this.NKc = new ArrayList();
    this.NJV.setVisibility(8);
    this.NJV.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(75524);
  }
  
  private final void J(List<String> paramList1, List<String> paramList2)
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
        localObject = com.tencent.mm.plugin.label.a.a.fTb().aJK(com.tencent.mm.plugin.label.a.a.fTb().aJH((String)localObject));
        if ((localObject == null) || (((List)localObject).size() == 0)) {
          Log.e(this.TAG, "dz: getContactNamesFromLabelsAndOtherUserName,namelist get bu label is null");
        }
      }
      else
      {
        this.NKc = new ArrayList((Collection)localHashSet);
        if (paramList1 == null) {
          break;
        }
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext()) {
          if (Util.isNullOrNil((String)paramList1.next())) {}
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
        if (!this.NKc.contains(paramList2)) {
          this.NKc.add(paramList2);
        }
      }
    }
    AppMethodBeat.o(163428);
  }
  
  private final void gIw()
  {
    this.dbk = 0;
    this.NJZ = null;
    this.NKa = null;
    this.NKb = null;
  }
  
  private final void gIx()
  {
    AppMethodBeat.i(75515);
    this.NJW.removeAllViews();
    LinearLayout.LayoutParams localLayoutParams;
    if (!this.NJY)
    {
      localObject = new ImageView(this.parent.getContext());
      ((ImageView)localObject).setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_moment_off, -1));
      localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.record_icon_size), com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.record_icon_size));
      localLayoutParams.topMargin = com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.LargePadding);
      this.NJW.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
    }
    Object localObject = (CharSequence)this.NJZ;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = (CharSequence)this.NKa;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label317;
        }
        i = 1;
        label169:
        if (i != 0)
        {
          localObject = (CharSequence)this.NKb;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label322;
          }
          i = 1;
          label196:
          if (i != 0) {
            break label327;
          }
        }
      }
    }
    label317:
    label322:
    label327:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new ImageView(this.parent.getContext());
        ((ImageView)localObject).setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_me_hl, -1));
        localLayoutParams = new LinearLayout.LayoutParams(com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.record_icon_size), com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.record_icon_size));
        localLayoutParams.topMargin = com.tencent.mm.cd.a.bs(this.parent.getContext(), b.c.LargePadding);
        this.NJW.addView((View)localObject, (ViewGroup.LayoutParams)localLayoutParams);
      }
      AppMethodBeat.o(75515);
      return;
      i = 0;
      break;
      i = 0;
      break label169;
      i = 0;
      break label196;
    }
  }
  
  private final void jK(List<String> paramList)
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
      Object localObject = com.tencent.mm.model.v.Im(str1);
      if (localObject != null)
      {
        Log.d(this.TAG, "getContactNamesFromChatroom chatromm:%s membersCount:%s", new Object[] { str1, Integer.valueOf(((List)localObject).size()) });
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          if ((!this.NKc.contains(str2)) && (com.tencent.mm.model.ab.IR(str2)))
          {
            Log.i(this.TAG, "getContactNamesFromChatroom memberName:%s", new Object[] { str2 });
            this.NKc.add(str2);
          }
          if (com.tencent.mm.model.ab.IR(str2)) {
            localArrayList.add(str2);
          }
        }
        Log.d(this.TAG, "%s , %s", new Object[] { str1, Integer.valueOf(localArrayList.size()) });
      }
    }
    AppMethodBeat.o(75516);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(280960);
    v.a.a(this, paramRecordConfigProvider);
    AppMethodBeat.o(280960);
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(280976);
    s.u(this, "this");
    AppMethodBeat.o(280976);
  }
  
  public final String gIy()
  {
    Object localObject3 = null;
    AppMethodBeat.i(75520);
    this.NKc.clear();
    Object localObject2;
    int i;
    if (!Util.isNullOrNil(this.NKa))
    {
      localObject1 = this.NKa;
      s.checkNotNull(localObject1);
      localObject1 = (CharSequence)localObject1;
      localObject1 = new kotlin.n.k(",").o((CharSequence)localObject1, 0);
      if (!((List)localObject1).isEmpty())
      {
        localObject2 = ((List)localObject1).listIterator(((List)localObject1).size());
        if (((ListIterator)localObject2).hasPrevious()) {
          if (((CharSequence)((ListIterator)localObject2).previous()).length() == 0)
          {
            i = 1;
            label109:
            if (i != 0) {
              break label169;
            }
          }
        }
      }
      for (localObject1 = p.c((Iterable)localObject1, ((ListIterator)localObject2).nextIndex() + 1);; localObject1 = (List)kotlin.a.ab.aivy)
      {
        localObject1 = ((Collection)localObject1).toArray(new String[0]);
        if (localObject1 != null) {
          break label181;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(75520);
        throw ((Throwable)localObject1);
        i = 0;
        break label109;
        label169:
        break;
      }
      label181:
      localObject1 = (String[])localObject1;
    }
    for (Object localObject1 = Arrays.asList(Arrays.copyOf((Object[])localObject1, localObject1.length));; localObject1 = null)
    {
      ListIterator localListIterator;
      if (!Util.isNullOrNil(this.NJZ))
      {
        localObject2 = this.NJZ;
        s.checkNotNull(localObject2);
        localObject2 = (CharSequence)localObject2;
        localObject2 = new kotlin.n.k(",").o((CharSequence)localObject2, 0);
        if (!((List)localObject2).isEmpty())
        {
          localListIterator = ((List)localObject2).listIterator(((List)localObject2).size());
          if (localListIterator.hasPrevious()) {
            if (((CharSequence)localListIterator.previous()).length() == 0)
            {
              i = 1;
              label292:
              if (i != 0) {
                break label353;
              }
            }
          }
        }
        for (localObject2 = p.c((Iterable)localObject2, localListIterator.nextIndex() + 1);; localObject2 = (List)kotlin.a.ab.aivy)
        {
          localObject2 = ((Collection)localObject2).toArray(new String[0]);
          if (localObject2 != null) {
            break label365;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(75520);
          throw ((Throwable)localObject1);
          i = 0;
          break label292;
          label353:
          break;
        }
        label365:
        localObject2 = (String[])localObject2;
      }
      for (localObject2 = Arrays.asList(Arrays.copyOf((Object[])localObject2, localObject2.length));; localObject2 = null)
      {
        if (!Util.isNullOrNil(this.NKb))
        {
          localObject3 = this.NKb;
          s.checkNotNull(localObject3);
          localObject3 = (CharSequence)localObject3;
          localObject3 = new kotlin.n.k(",").o((CharSequence)localObject3, 0);
          if (!((List)localObject3).isEmpty())
          {
            localListIterator = ((List)localObject3).listIterator(((List)localObject3).size());
            if (localListIterator.hasPrevious()) {
              if (((CharSequence)localListIterator.previous()).length() == 0)
              {
                i = 1;
                label485:
                if (i != 0) {
                  break label551;
                }
              }
            }
          }
          for (localObject3 = p.c((Iterable)localObject3, localListIterator.nextIndex() + 1);; localObject3 = (List)kotlin.a.ab.aivy)
          {
            localObject3 = ((Collection)localObject3).toArray(new String[0]);
            if (localObject3 != null) {
              break label564;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            AppMethodBeat.o(75520);
            throw ((Throwable)localObject1);
            i = 0;
            break label485;
            label551:
            break;
          }
          label564:
          localObject3 = (String[])localObject3;
          localObject3 = Arrays.asList(Arrays.copyOf((Object[])localObject3, localObject3.length));
        }
        J((List)localObject1, (List)localObject2);
        jK((List)localObject3);
        Log.i(this.TAG, s.X("mergeSelectedRangeUser count:", Integer.valueOf(this.NKc.size())));
        localObject1 = Util.listToString((List)this.NKc, ",");
        s.s(localObject1, "listToString(mergedUserList, \",\")");
        AppMethodBeat.o(75520);
        return localObject1;
      }
    }
  }
  
  public final String name()
  {
    AppMethodBeat.i(280968);
    String str = v.a.b(this);
    AppMethodBeat.o(280968);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(75523);
    Log.i(this.TAG, "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2);
    if ((paramInt1 == 3) && (paramInt2 == -1) && (paramIntent != null))
    {
      this.dbk = paramIntent.getIntExtra("Ktag_range_index", 0);
      this.NKa = paramIntent.getStringExtra("Klabel_name_list");
      this.NJZ = paramIntent.getStringExtra("Kother_user_name_list");
      this.NKb = paramIntent.getStringExtra("Kchat_room_name_list");
      gIx();
    }
    AppMethodBeat.o(75523);
  }
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75517);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.NJX;
    if (paramView != null) {
      paramView.dismiss();
    }
    if (this.scene == 3)
    {
      paramView = this.parent.getContext();
      s.s(paramView, "parent.context");
      paramView = new d(paramView);
      paramView.NWn = this.NJY;
      paramView.NWm = ((kotlin.g.a.a)new a(this));
    }
    for (paramView = (com.google.android.material.bottomsheet.a)paramView;; paramView = null)
    {
      this.NJX = paramView;
      paramView = this.NJX;
      if (paramView != null) {
        paramView.show();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(75517);
      return;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(280981);
    s.u(this, "this");
    AppMethodBeat.o(280981);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280986);
    s.u(this, "this");
    AppMethodBeat.o(280986);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280989);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(280989);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(280992);
    s.u(this, "this");
    AppMethodBeat.o(280992);
  }
  
  public final void release()
  {
    AppMethodBeat.i(75521);
    this.NJW.removeAllViews();
    this.NJY = true;
    gIw();
    AppMethodBeat.o(75521);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(75522);
    this.NJW.removeAllViews();
    this.NJY = true;
    gIw();
    AppMethodBeat.o(75522);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(75519);
    Log.i(this.TAG, s.X("setScene ", Integer.valueOf(paramInt)));
    this.scene = paramInt;
    if (paramInt == 3)
    {
      this.NJV.setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_more, -1));
      if (!com.tencent.mm.plugin.recordvideo.c.a.a.NHs.gHB())
      {
        this.NJV.setVisibility(8);
        AppMethodBeat.o(75519);
        return;
      }
      this.NJV.setVisibility(0);
    }
    AppMethodBeat.o(75519);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75518);
    s.u((v)this, "this");
    this.NJV.setVisibility(paramInt);
    AppMethodBeat.o(75518);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.k
 * JD-Core Version:    0.7.0.1
 */