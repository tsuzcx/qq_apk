package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.r;
import java.util.List;

public final class d
  extends r<ai>
{
  com.tencent.mm.pluginsdk.ui.d Drp;
  protected String Isk;
  protected List<String> fzw;
  com.tencent.mm.ui.applet.b iKs;
  private b.b iKt;
  protected MMActivity iMV;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.d ntD;
  protected MMSlideDelView.f vkp;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new ai());
    AppMethodBeat.i(37683);
    this.Isk = null;
    this.fzw = null;
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.iKs = null;
    this.iKt = null;
    this.iMV = ((MMActivity)paramContext);
    this.Isk = paramString;
    this.iKs = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Go(String paramAnonymousString)
      {
        AppMethodBeat.i(37680);
        paramAnonymousString = com.tencent.mm.aj.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(37680);
        return paramAnonymousString;
      }
    });
    AppMethodBeat.o(37683);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37688);
    ai localai = (ai)getItem(paramInt1 + 1);
    if ((localai == null) || ((localai.field_showHead != paramInt2) && (!bs.isNullOrNil(ao(localai))))) {
      parama.Iul.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String ao(ai paramai)
  {
    AppMethodBeat.i(37689);
    if (paramai.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramai.field_showHead == 43)
    {
      paramai = this.iMV.getString(2131762623);
      AppMethodBeat.o(37689);
      return paramai;
    }
    char c = (char)paramai.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void Xb()
  {
    try
    {
      AppMethodBeat.i(37686);
      az.ayM();
      Cursor localCursor = com.tencent.mm.model.c.awB().d(this.Isk, "", this.fzw);
      cVi();
      setCursor(localCursor);
      notifyDataSetChanged();
      AppMethodBeat.o(37686);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(37685);
    Xb();
    AppMethodBeat.o(37685);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vkp = paramf;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37684);
    int i = getCursor().getCount();
    AppMethodBeat.o(37684);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37687);
    if (this.iKt == null) {
      this.iKt = new b.b()
      {
        public final int aPz()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String qN(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            ac.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (ai)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(37681);
            return null;
          }
          localObject = ((av)localObject).field_username;
          AppMethodBeat.o(37681);
          return localObject;
        }
      };
    }
    if (this.iKs != null) {
      this.iKs.a(paramInt, this.iKt);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.iMV, 2131493371, null);
      paramViewGroup = new a();
      paramViewGroup.tNT = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fAk = ((MaskLayout)paramView.findViewById(2131298721));
      paramViewGroup.fwp = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.Iul = ((ViewGroup)paramView.findViewById(2131298728));
      localObject1 = paramViewGroup.Iul.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cc.a.av(this.iMV, 2131165242) * com.tencent.mm.cc.a.ic(this.iMV)));
      paramViewGroup.Iul.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (ai)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (ai)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = ao((ai)localObject1);
        if (!bs.isNullOrNil((String)localObject2)) {
          break label433;
        }
        ac.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((av)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.tNT.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.Iul.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.fwp;
        MMActivity localMMActivity = this.iMV;
        if (w.xr(((av)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131100638;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cc.a.m(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.fAk.getContentView();
        a.b.c((ImageView)localObject2, ((av)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.Drp != null) {
          this.Drp.a((com.tencent.mm.pluginsdk.ui.d.a)localObject2);
        }
        paramViewGroup.fAk.setMaskDrawable(null);
      }
      try
      {
        if (w.wr(((av)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.iMV, paramViewGroup.fwp, v.wk(((av)localObject1).field_username));
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((av)localObject1).field_showHead;
          break label185;
          label433:
          paramViewGroup.tNT.setVisibility(0);
          paramViewGroup.tNT.setText((CharSequence)localObject2);
          paramViewGroup.tNT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((av)localObject1).field_showHead != i))
          {
            localObject2 = ao((ai)localObject1);
            paramViewGroup.Iul.setBackgroundResource(2131231818);
            if (bs.isNullOrNil((String)localObject2))
            {
              ac.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((av)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.tNT.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.tNT.setVisibility(0);
              paramViewGroup.tNT.setText((CharSequence)localObject2);
              if (((av)localObject1).field_showHead == 32)
              {
                paramViewGroup.tNT.setCompoundDrawablesWithIntrinsicBounds(2131233271, 0, 0, 0);
                paramViewGroup.tNT.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.tNT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.tNT.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131100639;
          break label297;
          localObject1 = k.b(this.iMV, v.wk(((av)localObject1).field_username), (int)paramViewGroup.fwp.getTextSize());
          paramViewGroup.fwp.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.fwp.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup Iul;
    public MaskLayout fAk;
    public TextView fwp;
    public TextView tNT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */