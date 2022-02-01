package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public final class x
  extends com.tencent.mm.ui.x<cc>
{
  private String Hxt;
  private String JXG;
  private boolean aedO;
  public a aejp;
  public String talker;
  
  public x(Context paramContext, cc paramcc, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, paramcc);
    this.talker = paramString1;
    this.JXG = paramString2;
    this.aedO = paramBoolean;
  }
  
  private String cf(cc paramcc)
  {
    if (paramcc.field_isSend == 1) {
      return this.JXG;
    }
    return this.talker;
  }
  
  private CharSequence cg(cc paramcc)
  {
    AppMethodBeat.i(34632);
    if (paramcc.getCreateTime() == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    paramcc = f.d(this.context, paramcc.getCreateTime(), true);
    AppMethodBeat.o(34632);
    return paramcc;
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(34629);
    this.Hxt = paramString;
    if (!Util.isNullOrNil(this.Hxt))
    {
      fSd();
      aNy();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(34630);
    bh.bCz();
    w(c.bzD().kg(this.talker, this.Hxt));
    if ((this.aejp != null) && (!Util.isNullOrNil(this.Hxt))) {
      this.aejp.aBN(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(34631);
    fSd();
    aNy();
    AppMethodBeat.o(34631);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34628);
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.gnK, null);
      paramViewGroup = new b((byte)0);
      paramViewGroup.lBC = ((ImageView)paramView.findViewById(R.h.avatar_iv));
      paramViewGroup.lBD = ((TextView)paramView.findViewById(R.h.nickname_tv));
      paramViewGroup.vzk = ((TextView)paramView.findViewById(R.h.update_time_tv));
      paramViewGroup.aejq = ((TextView)paramView.findViewById(R.h.msg_tv));
      paramView.setTag(paramViewGroup);
      localObject = (cc)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.aedO) || (((fi)localObject).field_isSend != 0)) {
          break label239;
        }
        String str1 = ((fi)localObject).field_content;
        String str2 = br.JJ(str1);
        if (!Util.isNullOrNil(str2))
        {
          a.b.g(paramViewGroup.lBC, str2);
          paramViewGroup.lBD.setText(p.b(this.context, aa.getDisplayName(str2), paramViewGroup.lBD.getTextSize()));
        }
        paramViewGroup.vzk.setText(cg((cc)localObject));
        localObject = br.JK(str1);
        paramViewGroup.aejq.setText(p.b(this.context, (CharSequence)localObject, paramViewGroup.aejq.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label239:
      a.b.g(paramViewGroup.lBC, cf((cc)localObject));
      paramViewGroup.lBD.setText(p.b(this.context, aa.getDisplayName(cf((cc)localObject)), paramViewGroup.lBD.getTextSize()));
      paramViewGroup.vzk.setText(cg((cc)localObject));
      paramViewGroup.aejq.setText(p.b(this.context, ((fi)localObject).field_content, paramViewGroup.aejq.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void aBN(int paramInt);
  }
  
  static final class b
  {
    public TextView aejq;
    public ImageView lBC;
    public TextView lBD;
    public TextView vzk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */