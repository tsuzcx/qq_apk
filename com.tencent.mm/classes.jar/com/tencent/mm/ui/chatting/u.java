package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.p;

public final class u
  extends p<bi>
{
  private String fsv;
  private String mWy;
  public String talker;
  public u.a zAw;
  private boolean zvB;
  
  public u(Context paramContext, bi parambi, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambi);
    this.talker = paramString1;
    this.fsv = paramString2;
    this.zvB = paramBoolean;
  }
  
  private String aK(bi parambi)
  {
    if (parambi.field_isSend == 1) {
      return this.fsv;
    }
    return this.talker;
  }
  
  private CharSequence aL(bi parambi)
  {
    AppMethodBeat.i(30758);
    if (parambi.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(30758);
      return "";
    }
    parambi = com.tencent.mm.pluginsdk.f.h.c(this.context, parambi.field_createTime, true);
    AppMethodBeat.o(30758);
    return parambi;
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(30756);
    aw.aaz();
    setCursor(c.YC().fj(this.talker, this.mWy));
    if ((this.zAw != null) && (!ah.isNullOrNil(this.mWy))) {
      this.zAw.Ps(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(30756);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(30757);
    bKb();
    Ku();
    AppMethodBeat.o(30757);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30754);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130970626, null);
      paramViewGroup = new u.b((byte)0);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131821210));
      paramViewGroup.egr = ((TextView)paramView.findViewById(2131823254));
      paramViewGroup.jSg = ((TextView)paramView.findViewById(2131823255));
      paramViewGroup.zAx = ((TextView)paramView.findViewById(2131822982));
      paramView.setTag(paramViewGroup);
      localObject = (bi)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.zvB) || (((dd)localObject).field_isSend != 0)) {
          break label236;
        }
        String str1 = ((dd)localObject).field_content;
        String str2 = bf.pu(str1);
        if (!ah.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.egq, str2);
          paramViewGroup.egr.setText(j.b(this.context, s.nE(str2), paramViewGroup.egr.getTextSize()));
        }
        paramViewGroup.jSg.setText(aL((bi)localObject));
        localObject = bf.pv(str1);
        paramViewGroup.zAx.setText(j.b(this.context, (CharSequence)localObject, paramViewGroup.zAx.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30754);
      return paramView;
      paramViewGroup = (u.b)paramView.getTag();
      break;
      label236:
      a.b.c(paramViewGroup.egq, aK((bi)localObject));
      paramViewGroup.egr.setText(j.b(this.context, s.nE(aK((bi)localObject)), paramViewGroup.egr.getTextSize()));
      paramViewGroup.jSg.setText(aL((bi)localObject));
      paramViewGroup.zAx.setText(j.b(this.context, ((dd)localObject).field_content, paramViewGroup.zAx.getTextSize()));
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(30755);
    this.mWy = paramString;
    if (!ah.isNullOrNil(this.mWy))
    {
      bKb();
      Ku();
    }
    AppMethodBeat.o(30755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */