package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.q;

public final class u
  extends q<bl>
{
  private boolean GjM;
  public a GoJ;
  private String gUq;
  private String rtn;
  public String talker;
  
  public u(Context paramContext, bl parambl, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambl);
    this.talker = paramString1;
    this.gUq = paramString2;
    this.GjM = paramBoolean;
  }
  
  private String bd(bl parambl)
  {
    if (parambl.field_isSend == 1) {
      return this.gUq;
    }
    return this.talker;
  }
  
  private CharSequence be(bl parambl)
  {
    AppMethodBeat.i(34632);
    if (parambl.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    parambl = com.tencent.mm.pluginsdk.g.h.c(this.context, parambl.field_createTime, true);
    AppMethodBeat.o(34632);
    return parambl;
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(34629);
    this.rtn = paramString;
    if (!bt.isNullOrNil(this.rtn))
    {
      cHX();
      Wd();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(34630);
    az.arV();
    setCursor(c.apO().ho(this.talker, this.rtn));
    if ((this.GoJ != null) && (!bt.isNullOrNil(this.rtn))) {
      this.GoJ.Yx(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void We()
  {
    AppMethodBeat.i(34631);
    cHX();
    Wd();
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
      paramViewGroup.frr = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.frs = ((TextView)paramView.findViewById(2131302867));
      paramViewGroup.mRp = ((TextView)paramView.findViewById(2131306207));
      paramViewGroup.GoK = ((TextView)paramView.findViewById(2131302555));
      paramView.setTag(paramViewGroup);
      localObject = (bl)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.GjM) || (((du)localObject).field_isSend != 0)) {
          break label234;
        }
        String str1 = ((du)localObject).field_content;
        String str2 = bi.uf(str1);
        if (!bt.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.frr, str2);
          paramViewGroup.frs.setText(k.b(this.context, v.sh(str2), paramViewGroup.frs.getTextSize()));
        }
        paramViewGroup.mRp.setText(be((bl)localObject));
        localObject = bi.ug(str1);
        paramViewGroup.GoK.setText(k.b(this.context, (CharSequence)localObject, paramViewGroup.GoK.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label234:
      a.b.c(paramViewGroup.frr, bd((bl)localObject));
      paramViewGroup.frs.setText(k.b(this.context, v.sh(bd((bl)localObject)), paramViewGroup.frs.getTextSize()));
      paramViewGroup.mRp.setText(be((bl)localObject));
      paramViewGroup.GoK.setText(k.b(this.context, ((du)localObject).field_content, paramViewGroup.GoK.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void Yx(int paramInt);
  }
  
  static final class b
  {
    public TextView GoK;
    public ImageView frr;
    public TextView frs;
    public TextView mRp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */