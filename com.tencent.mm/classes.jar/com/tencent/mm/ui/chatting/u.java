package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.r;

public final class u
  extends r<bu>
{
  public a JCo;
  private boolean Jxs;
  private String hNh;
  public String talker;
  private String tyI;
  
  public u(Context paramContext, bu parambu, String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramContext, parambu);
    this.talker = paramString1;
    this.hNh = paramString2;
    this.Jxs = paramBoolean;
  }
  
  private String bi(bu parambu)
  {
    if (parambu.field_isSend == 1) {
      return this.hNh;
    }
    return this.talker;
  }
  
  private CharSequence bj(bu parambu)
  {
    AppMethodBeat.i(34632);
    if (parambu.field_createTime == 9223372036854775807L)
    {
      AppMethodBeat.o(34632);
      return "";
    }
    parambu = com.tencent.mm.pluginsdk.i.i.c(this.context, parambu.field_createTime, true);
    AppMethodBeat.o(34632);
    return parambu;
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(34629);
    this.tyI = paramString;
    if (!bt.isNullOrNil(this.tyI))
    {
      det();
      Zu();
    }
    AppMethodBeat.o(34629);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(34630);
    ba.aBQ();
    setCursor(c.azs().hR(this.talker, this.tyI));
    if ((this.JCo != null) && (!bt.isNullOrNil(this.tyI))) {
      this.JCo.acS(getCount());
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34630);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(34631);
    det();
    Zu();
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
      paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131297008));
      paramViewGroup.fOg = ((TextView)paramView.findViewById(2131302867));
      paramViewGroup.nUB = ((TextView)paramView.findViewById(2131306207));
      paramViewGroup.JCp = ((TextView)paramView.findViewById(2131302555));
      paramView.setTag(paramViewGroup);
      localObject = (bu)getItem(paramInt);
      if (localObject != null)
      {
        if ((!this.Jxs) || (((ei)localObject).field_isSend != 0)) {
          break label234;
        }
        String str1 = ((ei)localObject).field_content;
        String str2 = bj.Bk(str1);
        if (!bt.isNullOrNil(str2))
        {
          a.b.c(paramViewGroup.fOf, str2);
          paramViewGroup.fOg.setText(k.b(this.context, v.zf(str2), paramViewGroup.fOg.getTextSize()));
        }
        paramViewGroup.nUB.setText(bj((bu)localObject));
        localObject = bj.Bl(str1);
        paramViewGroup.JCp.setText(k.b(this.context, (CharSequence)localObject, paramViewGroup.JCp.getTextSize()));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34628);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label234:
      a.b.c(paramViewGroup.fOf, bi((bu)localObject));
      paramViewGroup.fOg.setText(k.b(this.context, v.zf(bi((bu)localObject)), paramViewGroup.fOg.getTextSize()));
      paramViewGroup.nUB.setText(bj((bu)localObject));
      paramViewGroup.JCp.setText(k.b(this.context, ((ei)localObject).field_content, paramViewGroup.JCp.getTextSize()));
    }
  }
  
  public static abstract interface a
  {
    public abstract void acS(int paramInt);
  }
  
  static final class b
  {
    public TextView JCp;
    public ImageView fOf;
    public TextView fOg;
    public TextView nUB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u
 * JD-Core Version:    0.7.0.1
 */