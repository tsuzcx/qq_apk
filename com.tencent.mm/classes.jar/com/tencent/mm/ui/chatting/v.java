package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.s;

public final class v
  extends s<ca>
{
  private String EFT;
  private boolean Pdm;
  public a Pit;
  public String talker;
  private String xay;
  
  public v(Context paramContext, ca paramca, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramca);
    this.talker = paramString1;
    this.EFT = paramString2;
    this.Pdm = paramBoolean;
  }
  
  private String bx(ca paramca)
  {
    if (paramca.field_isSend == 1) {
      return this.EFT;
    }
    return this.talker;
  }
  
  private CharSequence by(ca paramca)
  {
    AppMethodBeat.i(34632);
    if (paramca.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    paramca = f.c(this.context, paramca.field_createTime, true);
    AppMethodBeat.o(34632);
    return paramca;
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(34629);
    this.xay = paramString;
    if (!Util.isNullOrNil(this.xay))
    {
      ebf();
      anp();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void anp()
  {
    AppMethodBeat.i(34630);
    bg.aVF();
    setCursor(c.aSQ().iH(this.talker, this.xay));
    if ((this.Pit != null) && (!Util.isNullOrNil(this.xay))) {
      this.Pit.amk(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(34631);
    ebf();
    anp();
    AppMethodBeat.o(34631);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34628);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2131496179, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.gvv = ((ImageView)paramView.findViewById(2131297134));
      paramViewGroup.gvw = ((TextView)paramView.findViewById(2131305440));
      paramViewGroup.pld = ((TextView)paramView.findViewById(2131309606));
      paramViewGroup.Piu = ((TextView)paramView.findViewById(2131304987));
      paramView.setTag(paramViewGroup);
      localObject = (ca)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.Pdm) || (((eo)localObject).field_isSend != 0)) {
          break label234;
        }
        String str1 = ((eo)localObject).field_content;
        String str2 = bp.Ks(str1);
        if (!Util.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.gvv, str2);
          paramViewGroup.gvw.setText(l.b(this.context, aa.getDisplayName(str2), paramViewGroup.gvw.getTextSize()));
        }
        paramViewGroup.pld.setText(by((ca)localObject));
        localObject = bp.Kt(str1);
        paramViewGroup.Piu.setText(l.b(this.context, (CharSequence)localObject, paramViewGroup.Piu.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label234:
      a.b.c(paramViewGroup.gvv, bx((ca)localObject));
      paramViewGroup.gvw.setText(l.b(this.context, aa.getDisplayName(bx((ca)localObject)), paramViewGroup.gvw.getTextSize()));
      paramViewGroup.pld.setText(by((ca)localObject));
      paramViewGroup.Piu.setText(l.b(this.context, ((eo)localObject).field_content, paramViewGroup.Piu.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void amk(int paramInt);
  }
  
  static final class b
  {
    public TextView Piu;
    public ImageView gvv;
    public TextView gvw;
    public TextView pld;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v
 * JD-Core Version:    0.7.0.1
 */