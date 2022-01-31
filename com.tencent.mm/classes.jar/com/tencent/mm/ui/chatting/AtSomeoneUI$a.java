package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.List;

final class AtSomeoneUI$a
  extends p<ad>
{
  private u efi;
  private List<String> ejc;
  String ejd;
  private String[] zsR;
  private Bitmap zsS;
  
  public AtSomeoneUI$a(Context paramContext, ad paramad, u paramu, String[] paramArrayOfString, List<String> paramList)
  {
    super(paramContext, paramad);
    AppMethodBeat.i(30390);
    this.efi = paramu;
    this.zsR = paramArrayOfString;
    this.ejc = paramList;
    this.zsS = d.u(paramContext.getResources().getDrawable(2131230931));
    AppMethodBeat.o(30390);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(30393);
    aw.aaz();
    bd localbd = c.YA();
    String[] arrayOfString1 = this.zsR;
    String str1 = this.ejd;
    String str2 = this.ejd;
    Object localObject;
    if ((this.efi == null) || (str2 == null) || (this.zsR == null))
    {
      localObject = null;
      setCursor(localbd.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.ejc));
      super.notifyDataSetChanged();
      AppMethodBeat.o(30393);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString2 = this.zsR;
    int j = arrayOfString2.length;
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localObject = arrayOfString2[i];
      String str3 = this.efi.nE((String)localObject);
      if ((str3 != null) && (str3.contains(str2))) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(30394);
    bKb();
    Ku();
    AppMethodBeat.o(30394);
  }
  
  public final int bHs()
  {
    AppMethodBeat.i(30391);
    if (AtSomeoneUI.access$100())
    {
      AppMethodBeat.o(30391);
      return 1;
    }
    AppMethodBeat.o(30391);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30392);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.context, 2130968786, null);
      paramViewGroup = new AtSomeoneUI.b((byte)0);
      paramViewGroup.ejS = ((MaskLayout)localView.findViewById(2131821557));
      paramViewGroup.ejj = ((TextView)localView.findViewById(2131821558));
      paramViewGroup.zsT = ((ImageView)localView.findViewById(2131820946));
      localView.setTag(paramViewGroup);
    }
    while ((paramInt == 0) && (AtSomeoneUI.access$100()))
    {
      paramViewGroup.zsT.setImageBitmap(this.zsS);
      paramViewGroup.ejj.setText(this.context.getResources().getString(2131297210, new Object[] { "@" }));
      AppMethodBeat.o(30392);
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
      paramView = paramViewGroup.ejj;
      Context localContext = this.context;
      if (t.oD(localad.field_username)) {
        break label374;
      }
      paramInt = 2131690768;
      label198:
      paramView.setTextColor(a.l(localContext, paramInt));
      a.b.c((ImageView)paramViewGroup.ejS.getContentView(), localad.field_username);
      if (localad.field_verifyFlag == 0) {
        break label403;
      }
      if (ao.a.flK == null) {
        break label392;
      }
      paramView = ao.a.flK.ky(localad.field_verifyFlag);
      if (paramView == null) {
        break label381;
      }
      paramView = m.sf(paramView);
      paramViewGroup.ejS.a(paramView, MaskLayout.a.znW);
      label274:
      if (ah.isNullOrNil(localad.field_conRemark)) {
        break label414;
      }
      paramView = localad.field_conRemark;
      label291:
      if (!ah.isNullOrNil(paramView)) {
        break label455;
      }
      paramView = localad.Oe();
    }
    label392:
    label403:
    label414:
    label455:
    for (;;)
    {
      if (ad.arf(localad.field_username)) {
        ((b)g.E(b.class)).a(paramViewGroup.ejj.getContext(), paramViewGroup.ejj, paramView, localad.field_openImAppid, localad.field_descWordingId, (int)paramViewGroup.ejj.getTextSize());
      }
      for (;;)
      {
        AppMethodBeat.o(30392);
        return localView;
        i = 0;
        break;
        label374:
        paramInt = 2131690769;
        break label198;
        label381:
        paramViewGroup.ejS.setMaskDrawable(null);
        break label274;
        paramViewGroup.ejS.setMaskDrawable(null);
        break label274;
        paramViewGroup.ejS.setMaskDrawable(null);
        break label274;
        paramView = AtSomeoneUI.a(this.efi, localad.field_username);
        break label291;
        paramViewGroup.ejj.setText(j.b(this.context, paramView, paramViewGroup.ejj.getTextSize()));
      }
    }
  }
  
  public final boolean xj(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI.a
 * JD-Core Version:    0.7.0.1
 */