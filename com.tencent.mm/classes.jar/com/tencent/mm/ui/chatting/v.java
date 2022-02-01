package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class v
  extends com.tencent.mm.ui.v<ca>
{
  private String BMx;
  private String KTN;
  public a WBV;
  private boolean Wwx;
  public String talker;
  
  public v(Context paramContext, ca paramca, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramca);
    this.talker = paramString1;
    this.KTN = paramString2;
    this.Wwx = paramBoolean;
  }
  
  private String bR(ca paramca)
  {
    if (paramca.field_isSend == 1) {
      return this.KTN;
    }
    return this.talker;
  }
  
  private CharSequence bS(ca paramca)
  {
    AppMethodBeat.i(34632);
    if (paramca.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    paramca = f.d(this.context, paramca.field_createTime, true);
    AppMethodBeat.o(34632);
    return paramca;
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(34629);
    this.BMx = paramString;
    if (!Util.isNullOrNil(this.BMx))
    {
      eKd();
      atr();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(34630);
    bh.beI();
    v(c.bbO().iS(this.talker, this.BMx));
    if ((this.WBV != null) && (!Util.isNullOrNil(this.BMx))) {
      this.WBV.avl(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(34631);
    eKd();
    atr();
    AppMethodBeat.o(34631);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34628);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.ekF, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.iZG = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.iZH = ((TextView)paramView.findViewById(R.h.nickname_tv));
      paramViewGroup.snm = ((TextView)paramView.findViewById(R.h.update_time_tv));
      paramViewGroup.WBW = ((TextView)paramView.findViewById(R.h.msg_tv));
      paramView.setTag(paramViewGroup);
      localObject = (ca)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.Wwx) || (((et)localObject).field_isSend != 0)) {
          break label239;
        }
        String str1 = ((et)localObject).field_content;
        String str2 = bq.RL(str1);
        if (!Util.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.iZG, str2);
          paramViewGroup.iZH.setText(l.b(this.context, aa.PJ(str2), paramViewGroup.iZH.getTextSize()));
        }
        paramViewGroup.snm.setText(bS((ca)localObject));
        localObject = bq.RM(str1);
        paramViewGroup.WBW.setText(l.b(this.context, (CharSequence)localObject, paramViewGroup.WBW.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label239:
      a.b.c(paramViewGroup.iZG, bR((ca)localObject));
      paramViewGroup.iZH.setText(l.b(this.context, aa.PJ(bR((ca)localObject)), paramViewGroup.iZH.getTextSize()));
      paramViewGroup.snm.setText(bS((ca)localObject));
      paramViewGroup.WBW.setText(l.b(this.context, ((et)localObject).field_content, paramViewGroup.WBW.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void avl(int paramInt);
  }
  
  static final class b
  {
    public TextView WBW;
    public ImageView iZG;
    public TextView iZH;
    public TextView snm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v
 * JD-Core Version:    0.7.0.1
 */