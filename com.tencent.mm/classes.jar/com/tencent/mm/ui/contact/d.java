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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  extends r<am>
{
  e EWt;
  protected String KiP;
  protected MMActivity fLP;
  protected List<String> fSL;
  com.tencent.mm.ui.applet.b jdB;
  private b.b jdC;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.d nUz;
  protected MMSlideDelView.f wpH;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new am());
    AppMethodBeat.i(37683);
    this.KiP = null;
    this.fSL = null;
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.jdB = null;
    this.jdC = null;
    this.fLP = ((MMActivity)paramContext);
    this.KiP = paramString;
    this.jdB = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap JD(String paramAnonymousString)
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
    am localam = (am)getItem(paramInt1 + 1);
    if ((localam == null) || ((localam.field_showHead != paramInt2) && (!bt.isNullOrNil(ao(localam))))) {
      parama.KkR.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String ao(am paramam)
  {
    AppMethodBeat.i(37689);
    if (paramam.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramam.field_showHead == 43)
    {
      paramam = this.fLP.getString(2131762623);
      AppMethodBeat.o(37689);
      return paramam;
    }
    char c = (char)paramam.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void Zu()
  {
    try
    {
      AppMethodBeat.i(37686);
      ba.aBQ();
      Cursor localCursor = com.tencent.mm.model.c.azp().d(this.KiP, "", this.fSL);
      det();
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
  
  public final void Zv()
  {
    AppMethodBeat.i(37685);
    Zu();
    AppMethodBeat.o(37685);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.wpH = paramf;
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
    if (this.jdC == null) {
      this.jdC = new b.b()
      {
        public final int aSL()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String rn(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            ad.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (am)d.this.getItem(paramAnonymousInt);
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
    if (this.jdB != null) {
      this.jdB.a(paramInt, this.jdC);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.fLP, 2131493371, null);
      paramViewGroup = new a();
      paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
      paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131298721));
      paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
      paramViewGroup.KkR = ((ViewGroup)paramView.findViewById(2131298728));
      localObject1 = paramViewGroup.KkR.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cc.a.ay(this.fLP, 2131165242) * com.tencent.mm.cc.a.il(this.fLP)));
      paramViewGroup.KkR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (am)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (am)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = ao((am)localObject1);
        if (!bt.isNullOrNil((String)localObject2)) {
          break label433;
        }
        ad.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aw)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.uQG.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.KkR.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.fPC;
        MMActivity localMMActivity = this.fLP;
        if (w.Ap(((aw)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131100638;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cc.a.m(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.fTA.getContentView();
        a.b.c((ImageView)localObject2, ((aw)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.EWt != null) {
          this.EWt.a((e.a)localObject2);
        }
        paramViewGroup.fTA.setMaskDrawable(null);
      }
      try
      {
        if (w.zm(((aw)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.fLP, paramViewGroup.fPC, v.zf(((aw)localObject1).field_username));
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
          paramViewGroup.uQG.setVisibility(0);
          paramViewGroup.uQG.setText((CharSequence)localObject2);
          paramViewGroup.uQG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((aw)localObject1).field_showHead != i))
          {
            localObject2 = ao((am)localObject1);
            paramViewGroup.KkR.setBackgroundResource(2131231818);
            if (bt.isNullOrNil((String)localObject2))
            {
              ad.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aw)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.uQG.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.uQG.setVisibility(0);
              paramViewGroup.uQG.setText((CharSequence)localObject2);
              if (((aw)localObject1).field_showHead == 32)
              {
                paramViewGroup.uQG.setCompoundDrawablesWithIntrinsicBounds(2131233271, 0, 0, 0);
                paramViewGroup.uQG.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.uQG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.uQG.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131100639;
          break label297;
          localObject1 = k.b(this.fLP, v.zf(((aw)localObject1).field_username), (int)paramViewGroup.fPC.getTextSize());
          paramViewGroup.fPC.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.fPC.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup KkR;
    public TextView fPC;
    public MaskLayout fTA;
    public TextView uQG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */