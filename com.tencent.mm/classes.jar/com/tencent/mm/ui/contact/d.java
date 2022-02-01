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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.q;
import java.util.List;

public final class d
  extends q<af>
{
  com.tencent.mm.pluginsdk.ui.d BYY;
  protected String GRX;
  protected List<String> fvP;
  com.tencent.mm.ui.applet.b ikl;
  private b.b ikm;
  protected MMActivity imP;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.d mRn;
  protected MMSlideDelView.f ubr;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new af());
    AppMethodBeat.i(37683);
    this.GRX = null;
    this.fvP = null;
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.ikl = null;
    this.ikm = null;
    this.imP = ((MMActivity)paramContext);
    this.GRX = paramString;
    this.ikl = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap Cl(String paramAnonymousString)
      {
        AppMethodBeat.i(37680);
        paramAnonymousString = com.tencent.mm.ak.c.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(37680);
        return paramAnonymousString;
      }
    });
    AppMethodBeat.o(37683);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37688);
    af localaf = (af)getItem(paramInt1 + 1);
    if ((localaf == null) || ((localaf.field_showHead != paramInt2) && (!bt.isNullOrNil(an(localaf))))) {
      parama.GUa.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String an(af paramaf)
  {
    AppMethodBeat.i(37689);
    if (paramaf.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramaf.field_showHead == 43)
    {
      paramaf = this.imP.getString(2131762623);
      AppMethodBeat.o(37689);
      return paramaf;
    }
    char c = (char)paramaf.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void Wd()
  {
    try
    {
      AppMethodBeat.i(37686);
      az.arV();
      Cursor localCursor = com.tencent.mm.model.c.apM().d(this.GRX, "", this.fvP);
      cHX();
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
  
  public final void We()
  {
    AppMethodBeat.i(37685);
    Wd();
    AppMethodBeat.o(37685);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ubr = paramf;
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
    if (this.ikm == null) {
      this.ikm = new b.b()
      {
        public final int aII()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String qa(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            ad.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (af)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(37681);
            return null;
          }
          localObject = ((au)localObject).field_username;
          AppMethodBeat.o(37681);
          return localObject;
        }
      };
    }
    if (this.ikl != null) {
      this.ikl.a(paramInt, this.ikm);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.imP, 2131493371, null);
      paramViewGroup = new a();
      paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fwD = ((MaskLayout)paramView.findViewById(2131298721));
      paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.GUa = ((ViewGroup)paramView.findViewById(2131298728));
      localObject1 = paramViewGroup.GUa.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cd.a.ap(this.imP, 2131165242) * com.tencent.mm.cd.a.hR(this.imP)));
      paramViewGroup.GUa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (af)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (af)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = an((af)localObject1);
        if (!bt.isNullOrNil((String)localObject2)) {
          break label433;
        }
        ad.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((au)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.sGm.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.GUa.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.fsI;
        MMActivity localMMActivity = this.imP;
        if (w.to(((au)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131100638;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cd.a.m(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.fwD.getContentView();
        a.b.c((ImageView)localObject2, ((au)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.BYY != null) {
          this.BYY.a((com.tencent.mm.pluginsdk.ui.d.a)localObject2);
        }
        paramViewGroup.fwD.setMaskDrawable(null);
      }
      try
      {
        if (w.so(((au)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.imP, paramViewGroup.fsI, v.sh(((au)localObject1).field_username));
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((au)localObject1).field_showHead;
          break label185;
          label433:
          paramViewGroup.sGm.setVisibility(0);
          paramViewGroup.sGm.setText((CharSequence)localObject2);
          paramViewGroup.sGm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((au)localObject1).field_showHead != i))
          {
            localObject2 = an((af)localObject1);
            paramViewGroup.GUa.setBackgroundResource(2131231818);
            if (bt.isNullOrNil((String)localObject2))
            {
              ad.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((au)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.sGm.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.sGm.setVisibility(0);
              paramViewGroup.sGm.setText((CharSequence)localObject2);
              if (((au)localObject1).field_showHead == 32)
              {
                paramViewGroup.sGm.setCompoundDrawablesWithIntrinsicBounds(2131233271, 0, 0, 0);
                paramViewGroup.sGm.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.sGm.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.sGm.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131100639;
          break label297;
          localObject1 = k.b(this.imP, v.sh(((au)localObject1).field_username), (int)paramViewGroup.fsI.getTextSize());
          paramViewGroup.fsI.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.fsI.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup GUa;
    public TextView fsI;
    public MaskLayout fwD;
    public TextView sGm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */