package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.r;

public final class v
  extends r<bv>
{
  private boolean JSi;
  public a JXf;
  private String hQa;
  private String tJz;
  public String talker;
  
  public v(Context paramContext, bv parambv, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambv);
    this.talker = paramString1;
    this.hQa = paramString2;
    this.JSi = paramBoolean;
  }
  
  private String bh(bv parambv)
  {
    if (parambv.field_isSend == 1) {
      return this.hQa;
    }
    return this.talker;
  }
  
  private CharSequence bi(bv parambv)
  {
    AppMethodBeat.i(34632);
    if (parambv.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    parambv = com.tencent.mm.pluginsdk.i.i.c(this.context, parambv.field_createTime, true);
    AppMethodBeat.o(34632);
    return parambv;
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(34629);
    this.tJz = paramString;
    if (!bu.isNullOrNil(this.tJz))
    {
      dhl();
      ZD();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(34630);
    bc.aCg();
    setCursor(c.azI().hY(this.talker, this.tJz));
    if ((this.JXf != null) && (!bu.isNullOrNil(this.tJz))) {
      this.JXf.adA(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(34631);
    dhl();
    ZD();
    AppMethodBeat.o(34631);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34628);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131495321, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.fQl = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.fQm = ((TextView)paramView.findViewById(2131302867));
      paramViewGroup.oah = ((TextView)paramView.findViewById(2131306207));
      paramViewGroup.JXg = ((TextView)paramView.findViewById(2131302555));
      paramView.setTag(paramViewGroup);
      localObject = (bv)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.JSi) || (((ei)localObject).field_isSend != 0)) {
          break label234;
        }
        String str1 = ((ei)localObject).field_content;
        String str2 = bl.BM(str1);
        if (!bu.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.fQl, str2);
          paramViewGroup.fQm.setText(k.b(this.context, w.zP(str2), paramViewGroup.fQm.getTextSize()));
        }
        paramViewGroup.oah.setText(bi((bv)localObject));
        localObject = bl.BN(str1);
        paramViewGroup.JXg.setText(k.b(this.context, (CharSequence)localObject, paramViewGroup.JXg.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label234:
      a.b.c(paramViewGroup.fQl, bh((bv)localObject));
      paramViewGroup.fQm.setText(k.b(this.context, w.zP(bh((bv)localObject)), paramViewGroup.fQm.getTextSize()));
      paramViewGroup.oah.setText(bi((bv)localObject));
      paramViewGroup.JXg.setText(k.b(this.context, ((ei)localObject).field_content, paramViewGroup.JXg.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void adA(int paramInt);
  }
  
  static final class b
  {
    public TextView JXg;
    public ImageView fQl;
    public TextView fQm;
    public TextView oah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v
 * JD-Core Version:    0.7.0.1
 */