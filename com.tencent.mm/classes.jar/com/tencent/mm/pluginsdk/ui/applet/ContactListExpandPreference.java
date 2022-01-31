package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int sdg = -1;
  public i sdh;
  public k sdi;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    if (paramInt == 0) {
      cmN();
    }
    for (;;)
    {
      setLayoutResource(a.f.mm_preference_contact_list_row);
      return;
      if (paramInt == 1)
      {
        this.sdg = 1;
        this.sdi = new k();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cmN();
    setLayoutResource(a.f.mm_preference_contact_list_row);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cmN();
    setLayoutResource(a.f.mm_preference_contact_list_row);
  }
  
  private void cmN()
  {
    this.sdg = 0;
    this.sdh = new i(this.mContext);
  }
  
  public final boolean Ec(int paramInt)
  {
    if (this.sdh != null) {
      return this.sdh.scu.Ec(paramInt);
    }
    return false;
  }
  
  public final String Ed(int paramInt)
  {
    if ((this.sdh != null) && (this.sdh.scu.Ec(paramInt))) {
      return ((ad)this.sdh.scu.getItem(paramInt)).field_username;
    }
    return "";
  }
  
  public final String Ee(int paramInt)
  {
    if ((this.sdh != null) && (this.sdh.scu.Ec(paramInt))) {
      return ((ad)this.sdh.scu.getItem(paramInt)).field_nickname;
    }
    return "";
  }
  
  public final String Ef(int paramInt)
  {
    if ((this.sdh != null) && (this.sdh.scu.Ec(paramInt))) {
      return ((ad)this.sdh.scu.getItem(paramInt)).field_conRemark;
    }
    return "";
  }
  
  public final void WI(String paramString)
  {
    if (this.sdh != null) {
      this.sdh.scu.scU = paramString;
    }
  }
  
  public final void a(ContactListExpandPreference.a parama)
  {
    if (this.sdh != null) {
      this.sdh.ptQ = parama;
    }
  }
  
  public final void a(k.b paramb)
  {
    if (this.sdh != null) {
      this.sdh.scv = paramb;
    }
  }
  
  public final void a(d paramd)
  {
    if (this.sdh != null) {
      this.sdh.scu.scN = paramd;
    }
  }
  
  public final void a(f paramf, String paramString)
  {
    i locali;
    if (this.sdh != null)
    {
      locali = this.sdh;
      if ((paramf != null) && (paramString != null)) {}
    }
    else
    {
      return;
    }
    locali.dnn = paramf;
    locali.scq = paramString;
    paramf.bJ(paramString, true);
  }
  
  public final void ac(ArrayList<ad> paramArrayList)
  {
    if (this.sdh != null)
    {
      i locali = this.sdh;
      locali.scu.ab(paramArrayList);
      locali.GI(null);
    }
  }
  
  public final void bJ(List<String> paramList)
  {
    if (this.sdh != null)
    {
      j localj = this.sdh.scu;
      localj.cD(paramList);
      localj.notifyChanged();
    }
  }
  
  public final void cmO()
  {
    if (this.sdh != null) {
      this.sdh.scu.scY = false;
    }
  }
  
  public final void cmP()
  {
    if (this.sdh != null)
    {
      j localj = this.sdh.scu;
      localj.dpW = false;
      localj.notifyChanged();
    }
  }
  
  public final ContactListExpandPreference cmQ()
  {
    if (this.sdh != null) {
      this.sdh.scu.scQ = false;
    }
    return this;
  }
  
  public final void cmR()
  {
    boolean bool = false;
    if (this.sdh != null)
    {
      i locali = this.sdh;
      locali.scs = false;
      if (locali.scs) {
        bool = true;
      }
      locali.sct = bool;
    }
  }
  
  public final Object getItem(int paramInt)
  {
    if ((this.sdh != null) && (this.sdh.scu.Ec(paramInt))) {
      return this.sdh.scu.getItem(paramInt);
    }
    return null;
  }
  
  public final ContactListExpandPreference lS(boolean paramBoolean)
  {
    if (this.sdh != null) {
      this.sdh.scu.scP = paramBoolean;
    }
    return this;
  }
  
  public final ContactListExpandPreference lT(boolean paramBoolean)
  {
    if (this.sdh != null) {
      this.sdh.scu.scO = paramBoolean;
    }
    return this;
  }
  
  public final void notifyChanged()
  {
    if (this.sdh != null) {
      this.sdh.buD();
    }
  }
  
  public final void onBindView(View paramView)
  {
    ViewGroup localViewGroup;
    if (this.sdg == 1)
    {
      k localk = this.sdi;
      if (paramView.getId() == a.e.contact_list_content_layout)
      {
        localViewGroup = (ViewGroup)paramView;
        if (localk.row != 0) {
          break label235;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.c.ListPadding), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.c.MiddlePadding));
        label75:
        if (((localk.scu.scM % j.scE != j.scE - 1) && (localk.scu.scM % j.scE != 0)) || (!localk.dnG) || (localk.row != localk.scu.getCount() / j.scE - 1)) {
          break label331;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
      }
      label655:
      for (;;)
      {
        label161:
        if (localk.scu != null)
        {
          localViewGroup.setOnClickListener(localk.nuB);
          int j;
          if (localViewGroup.getChildCount() > j.scE)
          {
            j = localViewGroup.getChildCount();
            i = 0;
            for (;;)
            {
              if (i < j - j.scE)
              {
                localViewGroup.removeViewAt(i);
                i += 1;
                continue;
                localViewGroup = (ViewGroup)paramView.findViewById(a.e.contact_list_content_layout);
                break;
                label235:
                if (localk.row == localk.scu.getCount() / j.scE - 1)
                {
                  localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.c.ListPadding));
                  break label75;
                }
                localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.c.MiddlePadding), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.c.MiddlePadding));
                break label75;
                label331:
                if ((localk.dnG) || (localk.scu.scM % j.scE != 0) || (localk.row != localk.scu.getCount() / j.scE - 1)) {
                  break label161;
                }
                localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(a.c.SmallPadding));
                break label161;
              }
            }
            localViewGroup.requestLayout();
          }
          int i = 0;
          if (i < localk.sdj)
          {
            View localView;
            label460:
            LinearLayout.LayoutParams localLayoutParams;
            if (localViewGroup.getChildAt(i) == null)
            {
              localView = View.inflate(localViewGroup.getContext(), a.f.roominfo_contact, null);
              localViewGroup.addView(localView);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
              localLayoutParams.gravity = 49;
              if (j.scE != 4) {
                break label655;
              }
              j = localViewGroup.getResources().getDimensionPixelSize(a.c.NormalPadding);
              localLayoutParams.setMargins(j, 0, j, 0);
            }
            for (;;)
            {
              if ((!localk.scu.cmL()) && (localk.scu.scM == 1))
              {
                j = localViewGroup.getResources().getDimensionPixelSize(a.c.BiggerPadding);
                localLayoutParams.setMargins(j, 0, j, 0);
              }
              localView.setLayoutParams(localLayoutParams);
              j = localk.row * localk.sdj + i;
              localk.scu.getView(j, localView, localViewGroup);
              if (localk.scA != null) {
                localView.setOnClickListener(new k.3(localk, localViewGroup, j));
              }
              if (localk.sdk != null) {
                localView.setOnLongClickListener(new k.4(localk, localViewGroup, j));
              }
              i += 1;
              break;
              localView = localViewGroup.getChildAt(i);
              break label460;
              j = localViewGroup.getResources().getDimensionPixelSize(a.c.MiddlePadding);
              localLayoutParams.setMargins(j, 0, j, 0);
            }
          }
          if ((!localk.scu.cmL()) && (localk.scu.scM <= 1)) {
            break label718;
          }
          ((LinearLayout)localViewGroup).setGravity(17);
        }
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      return;
      label718:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void refresh()
  {
    if (this.sdh != null) {
      this.sdh.scu.notifyChanged();
    }
  }
  
  public final void s(String paramString, List<String> paramList)
  {
    if (this.sdh != null)
    {
      i locali = this.sdh;
      locali.username = paramString;
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      locali.scu.cD((List)localObject);
      locali.GI(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference
 * JD-Core Version:    0.7.0.1
 */