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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
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
  extends r<an>
{
  e FoO;
  protected String KFj;
  protected MMActivity fNT;
  protected List<String> fUR;
  b jgu;
  private b.b jgv;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.d oaf;
  protected MMSlideDelView.f wFq;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new an());
    AppMethodBeat.i(37683);
    this.KFj = null;
    this.fUR = null;
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.jgu = null;
    this.jgv = null;
    this.fNT = ((MMActivity)paramContext);
    this.KFj = paramString;
    this.jgu = new b(new b.a()
    {
      public final Bitmap Kc(String paramAnonymousString)
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
    an localan = (an)getItem(paramInt1 + 1);
    if ((localan == null) || ((localan.field_showHead != paramInt2) && (!bu.isNullOrNil(av(localan))))) {
      parama.KHl.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String av(an paraman)
  {
    AppMethodBeat.i(37689);
    if (paraman.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paraman.field_showHead == 43)
    {
      paraman = this.fNT.getString(2131762623);
      AppMethodBeat.o(37689);
      return paraman;
    }
    char c = (char)paraman.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void ZD()
  {
    try
    {
      AppMethodBeat.i(37686);
      bc.aCg();
      Cursor localCursor = com.tencent.mm.model.c.azF().d(this.KFj, "", this.fUR);
      dhl();
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
  
  public final void ZE()
  {
    AppMethodBeat.i(37685);
    ZD();
    AppMethodBeat.o(37685);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.wFq = paramf;
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
    if (this.jgv == null) {
      this.jgv = new b.b()
      {
        public final int aTk()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String rq(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            ae.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (an)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(37681);
            return null;
          }
          localObject = ((aw)localObject).field_username;
          AppMethodBeat.o(37681);
          return localObject;
        }
      };
    }
    if (this.jgu != null) {
      this.jgu.a(paramInt, this.jgv);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.fNT, 2131493371, null);
      paramViewGroup = new a();
      paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fVG = ((MaskLayout)paramView.findViewById(2131298721));
      paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.KHl = ((ViewGroup)paramView.findViewById(2131298728));
      localObject1 = paramViewGroup.KHl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ay(this.fNT, 2131165242) * com.tencent.mm.cb.a.iq(this.fNT)));
      paramViewGroup.KHl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (an)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (an)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = av((an)localObject1);
        if (!bu.isNullOrNil((String)localObject2)) {
          break label433;
        }
        ae.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aw)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.vcs.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.KHl.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.fRI;
        MMActivity localMMActivity = this.fNT;
        if (x.AZ(((aw)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131100638;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cb.a.m(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.fVG.getContentView();
        a.b.c((ImageView)localObject2, ((aw)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.FoO != null) {
          this.FoO.a((e.a)localObject2);
        }
        paramViewGroup.fVG.setMaskDrawable(null);
      }
      try
      {
        if (x.zW(((aw)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(this.fNT, paramViewGroup.fRI, w.zP(((aw)localObject1).field_username));
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((aw)localObject1).field_showHead;
          break label185;
          label433:
          paramViewGroup.vcs.setVisibility(0);
          paramViewGroup.vcs.setText((CharSequence)localObject2);
          paramViewGroup.vcs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((aw)localObject1).field_showHead != i))
          {
            localObject2 = av((an)localObject1);
            paramViewGroup.KHl.setBackgroundResource(2131231818);
            if (bu.isNullOrNil((String)localObject2))
            {
              ae.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aw)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.vcs.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.vcs.setVisibility(0);
              paramViewGroup.vcs.setText((CharSequence)localObject2);
              if (((aw)localObject1).field_showHead == 32)
              {
                paramViewGroup.vcs.setCompoundDrawablesWithIntrinsicBounds(2131233271, 0, 0, 0);
                paramViewGroup.vcs.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.vcs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.vcs.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131100639;
          break label297;
          localObject1 = k.b(this.fNT, w.zP(((aw)localObject1).field_username), (int)paramViewGroup.fRI.getTextSize());
          paramViewGroup.fRI.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.fRI.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup KHl;
    public TextView fRI;
    public MaskLayout fVG;
    public TextView vcs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */