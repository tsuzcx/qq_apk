package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.List;

final class AtSomeoneUI$a
  extends r<ad>
{
  private u dnL;
  private List<String> dru;
  String drv;
  private String[] ves;
  private Bitmap vet;
  
  public AtSomeoneUI$a(Context paramContext, ad paramad, u paramu, String[] paramArrayOfString, List<String> paramList)
  {
    super(paramContext, paramad);
    this.dnL = paramu;
    this.ves = paramArrayOfString;
    this.dru = paramList;
    this.vet = com.tencent.mm.sdk.platformtools.c.q(paramContext.getResources().getDrawable(R.k.at_all_avater));
  }
  
  protected final int bam()
  {
    if (AtSomeoneUI.access$100()) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, R.i.at_someone_item, null);
      paramViewGroup = new AtSomeoneUI.b((byte)0);
      paramViewGroup.dsk = ((MaskLayout)localView.findViewById(R.h.at_someone_item_avatar));
      paramViewGroup.drB = ((TextView)localView.findViewById(R.h.at_someone_item_nick));
      paramViewGroup.veu = ((ImageView)localView.findViewById(R.h.content));
      localView.setTag(paramViewGroup);
    }
    while ((paramInt == 0) && (AtSomeoneUI.access$100()))
    {
      paramViewGroup.veu.setImageBitmap(this.vet);
      paramViewGroup.drB.setText(this.context.getResources().getString(R.l.at_all, new Object[] { "@" }));
      return localView;
      paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
      localView = paramView;
    }
    int i;
    ad localad;
    if (AtSomeoneUI.access$100())
    {
      i = 1;
      localad = (ad)getItem(paramInt - i);
      paramView = paramViewGroup.drB;
      Context localContext = this.context;
      if (s.hU(localad.field_username)) {
        break label362;
      }
      paramInt = R.e.mm_list_textcolor_one;
      label192:
      paramView.setTextColor(a.h(localContext, paramInt));
      a.b.a((ImageView)paramViewGroup.dsk.getContentView(), localad.field_username);
      if (localad.field_verifyFlag == 0) {
        break label391;
      }
      if (am.a.dVA == null) {
        break label380;
      }
      paramView = am.a.dVA.hM(localad.field_verifyFlag);
      if (paramView == null) {
        break label369;
      }
      paramView = m.lk(paramView);
      paramViewGroup.dsk.a(paramView, MaskLayout.a.uZF);
      label268:
      if (ah.bl(localad.field_conRemark)) {
        break label402;
      }
      paramView = localad.field_conRemark;
      label285:
      if (!ah.bl(paramView)) {
        break label443;
      }
      paramView = localad.Bp();
    }
    label391:
    label402:
    label443:
    for (;;)
    {
      if (ad.aaU(localad.field_username)) {
        ((b)g.r(b.class)).a(paramViewGroup.drB.getContext(), paramViewGroup.drB, paramView, localad.field_openImAppid, localad.field_descWordingId, (int)paramViewGroup.drB.getTextSize());
      }
      for (;;)
      {
        return localView;
        i = 0;
        break;
        label362:
        paramInt = R.e.mm_list_textcolor_spuser;
        break label192;
        label369:
        paramViewGroup.dsk.setMaskDrawable(null);
        break label268;
        label380:
        paramViewGroup.dsk.setMaskDrawable(null);
        break label268;
        paramViewGroup.dsk.setMaskDrawable(null);
        break label268;
        paramView = AtSomeoneUI.a(this.dnL, localad.field_username);
        break label285;
        paramViewGroup.drB.setText(j.a(this.context, paramView, paramViewGroup.drB.getTextSize()));
      }
    }
  }
  
  public final boolean sk(int paramInt)
  {
    return false;
  }
  
  public final void yc()
  {
    au.Hx();
    bd localbd = com.tencent.mm.model.c.Fw();
    String[] arrayOfString1 = this.ves;
    String str1 = this.drv;
    String str2 = this.drv;
    Object localObject;
    if ((this.dnL == null) || (str2 == null) || (this.ves == null))
    {
      localObject = null;
      setCursor(localbd.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.dru));
      super.notifyDataSetChanged();
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString2 = this.ves;
    int j = arrayOfString2.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localObject = arrayOfString2[i];
      String str3 = this.dnL.gV((String)localObject);
      if ((str3 != null) && (str3.contains(str2))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI.a
 * JD-Core Version:    0.7.0.1
 */