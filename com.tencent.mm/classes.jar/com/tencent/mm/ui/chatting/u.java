package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.r;

public final class u
  extends r<bo>
{
  private boolean HJB;
  public a HOA;
  private String huP;
  private String sCh;
  public String talker;
  
  public u(Context paramContext, bo parambo, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambo);
    this.talker = paramString1;
    this.huP = paramString2;
    this.HJB = paramBoolean;
  }
  
  private String bf(bo parambo)
  {
    if (parambo.field_isSend == 1) {
      return this.huP;
    }
    return this.talker;
  }
  
  private CharSequence bg(bo parambo)
  {
    AppMethodBeat.i(34632);
    if (parambo.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    parambo = com.tencent.mm.pluginsdk.g.h.c(this.context, parambo.field_createTime, true);
    AppMethodBeat.o(34632);
    return parambo;
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(34629);
    this.sCh = paramString;
    if (!bs.isNullOrNil(this.sCh))
    {
      cVi();
      Xb();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(34630);
    az.ayM();
    setCursor(c.awD().hH(this.talker, this.sCh));
    if ((this.HOA != null) && (!bs.isNullOrNil(this.sCh))) {
      this.HOA.aaI(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(34631);
    cVi();
    Xb();
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
      paramViewGroup.fuY = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.fuZ = ((TextView)paramView.findViewById(2131302867));
      paramViewGroup.ntF = ((TextView)paramView.findViewById(2131306207));
      paramViewGroup.HOB = ((TextView)paramView.findViewById(2131302555));
      paramView.setTag(paramViewGroup);
      localObject = (bo)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.HJB) || (((dy)localObject).field_isSend != 0)) {
          break label234;
        }
        String str1 = ((dy)localObject).field_content;
        String str2 = bi.yl(str1);
        if (!bs.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.fuY, str2);
          paramViewGroup.fuZ.setText(k.b(this.context, v.wk(str2), paramViewGroup.fuZ.getTextSize()));
        }
        paramViewGroup.ntF.setText(bg((bo)localObject));
        localObject = bi.ym(str1);
        paramViewGroup.HOB.setText(k.b(this.context, (CharSequence)localObject, paramViewGroup.HOB.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label234:
      a.b.c(paramViewGroup.fuY, bf((bo)localObject));
      paramViewGroup.fuZ.setText(k.b(this.context, v.wk(bf((bo)localObject)), paramViewGroup.fuZ.getTextSize()));
      paramViewGroup.ntF.setText(bg((bo)localObject));
      paramViewGroup.HOB.setText(k.b(this.context, ((dy)localObject).field_content, paramViewGroup.HOB.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void aaI(int paramInt);
  }
  
  static final class b
  {
    public TextView HOB;
    public ImageView fuY;
    public TextView fuZ;
    public TextView ntF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */