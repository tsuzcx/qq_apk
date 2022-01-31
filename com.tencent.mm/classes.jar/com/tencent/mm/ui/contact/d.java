package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.p;
import java.util.List;

public final class d
  extends p<ad>
{
  protected MMActivity cmc;
  protected List<String> ejc;
  com.tencent.mm.ui.applet.b gxo;
  private b.b gxp;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  protected MMSlideDelView.f pdU;
  com.tencent.mm.pluginsdk.ui.d vTR;
  protected String zZK;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new ad());
    AppMethodBeat.i(33563);
    this.zZK = null;
    this.ejc = null;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.gxo = null;
    this.gxp = null;
    this.cmc = ((MMActivity)paramContext);
    this.zZK = paramString;
    this.gxo = new com.tencent.mm.ui.applet.b(new d.1(this));
    AppMethodBeat.o(33563);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33568);
    ad localad = (ad)getItem(paramInt1 + 1);
    if ((localad == null) || ((localad.field_showHead != paramInt2) && (!ah.isNullOrNil(af(localad))))) {
      parama.AbD.setBackgroundResource(0);
    }
    AppMethodBeat.o(33568);
  }
  
  private String af(ad paramad)
  {
    AppMethodBeat.i(33569);
    if (paramad.field_showHead == 31)
    {
      AppMethodBeat.o(33569);
      return "";
    }
    if (paramad.field_showHead == 43)
    {
      paramad = this.cmc.getString(2131302712);
      AppMethodBeat.o(33569);
      return paramad;
    }
    char c = (char)paramad.field_showHead;
    AppMethodBeat.o(33569);
    return String.valueOf(c);
  }
  
  public final void Ku()
  {
    try
    {
      AppMethodBeat.i(33566);
      aw.aaz();
      Cursor localCursor = c.YA().d(this.zZK, "", this.ejc);
      bKb();
      setCursor(localCursor);
      notifyDataSetChanged();
      AppMethodBeat.o(33566);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(33565);
    Ku();
    AppMethodBeat.o(33565);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pdU = paramf;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(33564);
    int i = getCursor().getCount();
    AppMethodBeat.o(33564);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33567);
    if (this.gxp == null) {
      this.gxp = new d.2(this);
    }
    if (this.gxo != null) {
      this.gxo.a(paramInt, this.gxp);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.cmc, 2130969021, null);
      paramViewGroup = new a();
      paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
      paramViewGroup.ejS = ((MaskLayout)paramView.findViewById(2131821092));
      paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
      paramViewGroup.AbD = ((ViewGroup)paramView.findViewById(2131821091));
      localObject1 = paramViewGroup.AbD.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ap(this.cmc, 2131427549) * com.tencent.mm.cb.a.gs(this.cmc)));
      paramViewGroup.AbD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (ad)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (ad)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = af((ad)localObject1);
        if (!ah.isNullOrNil((String)localObject2)) {
          break label433;
        }
        ab.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aq)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.nSs.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.AbD.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.ejj;
        MMActivity localMMActivity = this.cmc;
        if (t.oD(((aq)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131690768;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cb.a.l(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.ejS.getContentView();
        a.b.c((ImageView)localObject2, ((aq)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.vTR != null) {
          this.vTR.a((com.tencent.mm.pluginsdk.ui.d.a)localObject2);
        }
        paramViewGroup.ejS.setMaskDrawable(null);
      }
      try
      {
        if (t.nK(((aq)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(this.cmc, paramViewGroup.ejj, s.nE(((aq)localObject1).field_username));
        }
        for (;;)
        {
          AppMethodBeat.o(33567);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((aq)localObject1).field_showHead;
          break label185;
          label433:
          paramViewGroup.nSs.setVisibility(0);
          paramViewGroup.nSs.setText((CharSequence)localObject2);
          paramViewGroup.nSs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((aq)localObject1).field_showHead != i))
          {
            localObject2 = af((ad)localObject1);
            paramViewGroup.AbD.setBackgroundResource(2130838445);
            if (ah.isNullOrNil((String)localObject2))
            {
              ab.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((aq)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.nSs.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.nSs.setVisibility(0);
              paramViewGroup.nSs.setText((CharSequence)localObject2);
              if (((aq)localObject1).field_showHead == 32)
              {
                paramViewGroup.nSs.setCompoundDrawablesWithIntrinsicBounds(2130839648, 0, 0, 0);
                paramViewGroup.nSs.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.nSs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.nSs.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131690769;
          break label297;
          localObject1 = j.b(this.cmc, s.nE(((aq)localObject1).field_username), (int)paramViewGroup.ejj.getTextSize());
          paramViewGroup.ejj.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.ejj.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup AbD;
    public MaskLayout ejS;
    public TextView ejj;
    public TextView nSs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */