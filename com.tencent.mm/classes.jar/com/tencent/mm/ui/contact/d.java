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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
import com.tencent.mm.ui.v;
import java.util.List;

public final class d
  extends v<as>
{
  protected MMSlideDelView.f GtD;
  e Rgt;
  protected String XoS;
  protected MMActivity iXq;
  protected List<String> jkb;
  b mVX;
  private b.b mVY;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.d snk;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new as());
    AppMethodBeat.i(37683);
    this.XoS = null;
    this.jkb = null;
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.mVX = null;
    this.mVY = null;
    this.iXq = ((MMActivity)paramContext);
    this.XoS = paramString;
    this.mVX = new b(new b.a()
    {
      public final Bitmap aaG(String paramAnonymousString)
      {
        AppMethodBeat.i(37680);
        paramAnonymousString = com.tencent.mm.am.d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(37680);
        return paramAnonymousString;
      }
    });
    AppMethodBeat.o(37683);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37688);
    as localas = (as)getItem(paramInt1 + 1);
    if ((localas == null) || ((localas.field_showHead != paramInt2) && (!Util.isNullOrNil(aD(localas))))) {
      parama.XqV.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String aD(as paramas)
  {
    AppMethodBeat.i(37689);
    if (paramas.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramas.field_showHead == 43)
    {
      paramas = this.iXq.getString(R.l.eRh);
      AppMethodBeat.o(37689);
      return paramas;
    }
    char c = (char)paramas.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.GtD = paramf;
  }
  
  public final void atr()
  {
    try
    {
      AppMethodBeat.i(37686);
      bh.beI();
      Cursor localCursor = c.bbL().e(this.XoS, "", this.jkb);
      eKd();
      v(localCursor);
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
  
  public final void ats()
  {
    AppMethodBeat.i(37685);
    atr();
    AppMethodBeat.o(37685);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37684);
    int i = hK().getCount();
    AppMethodBeat.o(37684);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37687);
    if (this.mVY == null) {
      this.mVY = new b.b()
      {
        public final int byf()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String yk(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            Log.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (as)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(37681);
            return null;
          }
          localObject = ((ax)localObject).field_username;
          AppMethodBeat.o(37681);
          return localObject;
        }
      };
    }
    if (this.mVX != null) {
      this.mVX.a(paramInt, this.mVY);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.iXq, R.i.ecg, null);
      paramViewGroup = new a();
      paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
      paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(R.h.dCv));
      paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
      paramViewGroup.XqV = ((ViewGroup)paramView.findViewById(R.h.dCA));
      localObject1 = paramViewGroup.XqV.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.ci.a.aZ(this.iXq, R.f.ContactListHeight) * com.tencent.mm.ci.a.kn(this.iXq)));
      paramViewGroup.XqV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (as)getItem(paramInt - 1);
      int i;
      label191:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (as)getItem(paramInt);
        if (paramInt != 0) {
          break label489;
        }
        localObject2 = aD((as)localObject1);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label458;
        }
        Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ax)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.DUW.setVisibility(8);
        label258:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.XqV.setBackgroundResource(0);
        }
        label276:
        localObject2 = paramViewGroup.jbe;
        MMActivity localMMActivity = this.iXq;
        if (ab.QX(((ax)localObject1).field_username)) {
          break label662;
        }
        paramInt = R.e.mm_list_textcolor_one;
        label303:
        ((TextView)localObject2).setTextColor(com.tencent.mm.ci.a.l(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.jkT.getContentView();
        a.b.c((ImageView)localObject2, ((ax)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.Rgt != null) {
          this.Rgt.a((e.a)localObject2);
        }
        paramViewGroup.jkT.setMaskDrawable(null);
      }
      try
      {
        if (ab.PR(((ax)localObject1).field_username))
        {
          localObject1 = l.d(this.iXq, aa.PJ(((ax)localObject1).field_username), (int)paramViewGroup.jbe.getTextSize());
          ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(this.iXq, paramViewGroup.jbe, (CharSequence)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((ax)localObject1).field_showHead;
          break label191;
          label458:
          paramViewGroup.DUW.setVisibility(0);
          paramViewGroup.DUW.setText((CharSequence)localObject2);
          paramViewGroup.DUW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label258;
          label489:
          if ((paramInt > 0) && (((ax)localObject1).field_showHead != i))
          {
            localObject2 = aD((as)localObject1);
            paramViewGroup.XqV.setBackgroundResource(R.g.comm_list_item_selector);
            if (Util.isNullOrNil((String)localObject2))
            {
              Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ax)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.DUW.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.DUW.setVisibility(0);
              paramViewGroup.DUW.setText((CharSequence)localObject2);
              if (((ax)localObject1).field_showHead == 32)
              {
                paramViewGroup.DUW.setCompoundDrawablesWithIntrinsicBounds(R.g.mm_contact_star, 0, 0, 0);
                paramViewGroup.DUW.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.DUW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.DUW.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label276;
          label662:
          paramInt = R.e.mm_list_textcolor_spuser;
          break label303;
          localObject1 = l.d(this.iXq, aa.PJ(((ax)localObject1).field_username), (int)paramViewGroup.jbe.getTextSize());
          paramViewGroup.jbe.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.jbe.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  protected static final class a
  {
    public TextView DUW;
    public ViewGroup XqV;
    public TextView jbe;
    public MaskLayout jkT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */