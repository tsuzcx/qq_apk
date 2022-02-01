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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
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
import com.tencent.mm.ui.s;
import java.util.List;

public final class d
  extends s<as>
{
  protected MMSlideDelView.f AAA;
  e KfF;
  protected String PSf;
  protected MMActivity gte;
  protected List<String> gzY;
  b kex;
  private b.b kez;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.d plb;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new as());
    AppMethodBeat.i(37683);
    this.PSf = null;
    this.gzY = null;
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.kex = null;
    this.kez = null;
    this.gte = ((MMActivity)paramContext);
    this.PSf = paramString;
    this.kex = new b(new b.a()
    {
      public final Bitmap Ta(String paramAnonymousString)
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
    as localas = (as)getItem(paramInt1 + 1);
    if ((localas == null) || ((localas.field_showHead != paramInt2) && (!Util.isNullOrNil(ax(localas))))) {
      parama.PUk.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String ax(as paramas)
  {
    AppMethodBeat.i(37689);
    if (paramas.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramas.field_showHead == 43)
    {
      paramas = this.gte.getString(2131764705);
      AppMethodBeat.o(37689);
      return paramas;
    }
    char c = (char)paramas.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.AAA = paramf;
  }
  
  public final void anp()
  {
    try
    {
      AppMethodBeat.i(37686);
      bg.aVF();
      Cursor localCursor = com.tencent.mm.model.c.aSN().d(this.PSf, "", this.gzY);
      ebf();
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
  
  public final void anq()
  {
    AppMethodBeat.i(37685);
    anp();
    AppMethodBeat.o(37685);
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
    if (this.kez == null) {
      this.kez = new b.b()
      {
        public final int bnW()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String vg(int paramAnonymousInt)
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
    if (this.kex != null) {
      this.kex.a(paramInt, this.kez);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.gte, 2131493462, null);
      paramViewGroup = new a();
      paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
      paramViewGroup.gAN = ((MaskLayout)paramView.findViewById(2131299159));
      paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
      paramViewGroup.PUk = ((ViewGroup)paramView.findViewById(2131299166));
      localObject1 = paramViewGroup.PUk.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.aH(this.gte, 2131165246) * com.tencent.mm.cb.a.jj(this.gte)));
      paramViewGroup.PUk.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (as)getItem(paramInt - 1);
      int i;
      label185:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (as)getItem(paramInt);
        if (paramInt != 0) {
          break label464;
        }
        localObject2 = ax((as)localObject1);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label433;
        }
        Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ax)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.yuS.setVisibility(8);
        label252:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.PUk.setBackgroundResource(0);
        }
        label270:
        localObject2 = paramViewGroup.gwR;
        MMActivity localMMActivity = this.gte;
        if (ab.JE(((ax)localObject1).field_username)) {
          break label637;
        }
        paramInt = 2131100808;
        label297:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cb.a.m(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.gAN.getContentView();
        a.b.c((ImageView)localObject2, ((ax)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.KfF != null) {
          this.KfF.a((e.a)localObject2);
        }
        paramViewGroup.gAN.setMaskDrawable(null);
      }
      try
      {
        if (ab.Iz(((ax)localObject1).field_username)) {
          ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(this.gte, paramViewGroup.gwR, aa.getDisplayName(((ax)localObject1).field_username));
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((ax)localObject1).field_showHead;
          break label185;
          label433:
          paramViewGroup.yuS.setVisibility(0);
          paramViewGroup.yuS.setText((CharSequence)localObject2);
          paramViewGroup.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label252;
          label464:
          if ((paramInt > 0) && (((ax)localObject1).field_showHead != i))
          {
            localObject2 = ax((as)localObject1);
            paramViewGroup.PUk.setBackgroundResource(2131231898);
            if (Util.isNullOrNil((String)localObject2))
            {
              Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ax)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.yuS.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.yuS.setVisibility(0);
              paramViewGroup.yuS.setText((CharSequence)localObject2);
              if (((ax)localObject1).field_showHead == 32)
              {
                paramViewGroup.yuS.setCompoundDrawablesWithIntrinsicBounds(2131233946, 0, 0, 0);
                paramViewGroup.yuS.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.yuS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.yuS.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label270;
          label637:
          paramInt = 2131100809;
          break label297;
          localObject1 = l.e(this.gte, aa.getDisplayName(((ax)localObject1).field_username), (int)paramViewGroup.gwR.getTextSize());
          paramViewGroup.gwR.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.gwR.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  protected static final class a
  {
    public ViewGroup PUk;
    public MaskLayout gAN;
    public TextView gwR;
    public TextView yuS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */