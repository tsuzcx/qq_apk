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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
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
import com.tencent.mm.ui.x;
import java.util.List;

public final class d
  extends x<au>
{
  protected MMSlideDelView.f MpD;
  com.tencent.mm.pluginsdk.ui.e Ycw;
  protected String afau;
  protected List<String> lMF;
  protected MMActivity lzt;
  b pSE;
  private b.b pSF;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.d vzi;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new au());
    AppMethodBeat.i(37683);
    this.afau = null;
    this.lMF = null;
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.pSE = null;
    this.pSF = null;
    this.lzt = ((MMActivity)paramContext);
    this.afau = paramString;
    this.pSE = new b(new b.a()
    {
      public final Bitmap getHeadImg(String paramAnonymousString)
      {
        AppMethodBeat.i(37680);
        paramAnonymousString = com.tencent.mm.modelavatar.d.a(paramAnonymousString, false, -1, null);
        AppMethodBeat.o(37680);
        return paramAnonymousString;
      }
    });
    AppMethodBeat.o(37683);
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37688);
    au localau = (au)getItem(paramInt1 + 1);
    if ((localau == null) || ((localau.field_showHead != paramInt2) && (!Util.isNullOrNil(aJ(localau))))) {
      parama.afcw.setBackgroundResource(0);
    }
    AppMethodBeat.o(37688);
  }
  
  private String aJ(au paramau)
  {
    AppMethodBeat.i(37689);
    if (paramau.field_showHead == 31)
    {
      AppMethodBeat.o(37689);
      return "";
    }
    if (paramau.field_showHead == 43)
    {
      paramau = this.lzt.getString(R.l.gTN);
      AppMethodBeat.o(37689);
      return paramau;
    }
    char c = (char)paramau.field_showHead;
    AppMethodBeat.o(37689);
    return String.valueOf(c);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.MpD = paramf;
  }
  
  public final void aNy()
  {
    try
    {
      AppMethodBeat.i(37686);
      bh.bCz();
      Cursor localCursor = c.bzA().g(this.afau, "", this.lMF);
      fSd();
      w(localCursor);
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
  
  public final void aNz()
  {
    AppMethodBeat.i(37685);
    aNy();
    AppMethodBeat.o(37685);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37684);
    int i = Fv().getCount();
    AppMethodBeat.o(37684);
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37687);
    if (this.pSF == null) {
      this.pSF = new b.b()
      {
        public final int bWT()
        {
          AppMethodBeat.i(37682);
          int i = d.this.getCount();
          AppMethodBeat.o(37682);
          return i;
        }
        
        public final String yq(int paramAnonymousInt)
        {
          AppMethodBeat.i(37681);
          if ((paramAnonymousInt < 0) || (paramAnonymousInt >= d.this.getCount()))
          {
            Log.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            AppMethodBeat.o(37681);
            return null;
          }
          Object localObject = (au)d.this.getItem(paramAnonymousInt);
          if (localObject == null)
          {
            AppMethodBeat.o(37681);
            return null;
          }
          localObject = ((az)localObject).field_username;
          AppMethodBeat.o(37681);
          return localObject;
        }
      };
    }
    if (this.pSE != null) {
      this.pSE.a(paramInt, this.pSF);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.lzt, R.i.geO, null);
      paramViewGroup = new a();
      paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.lNy = ((MaskLayout)paramView.findViewById(R.h.fDl));
      paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
      paramViewGroup.afcw = ((ViewGroup)paramView.findViewById(R.h.fDp));
      localObject1 = paramViewGroup.afcw.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cd.a.bs(this.lzt, R.f.ContactListHeight) * com.tencent.mm.cd.a.mo(this.lzt)));
      paramViewGroup.afcw.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (au)getItem(paramInt - 1);
      int i;
      label191:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (au)getItem(paramInt);
        if (paramInt != 0) {
          break label489;
        }
        localObject2 = aJ((au)localObject1);
        if (!Util.isNullOrNil((String)localObject2)) {
          break label458;
        }
        Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((az)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.JMf.setVisibility(8);
        label258:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.afcw.setBackgroundResource(0);
        }
        label276:
        localObject2 = paramViewGroup.lDe;
        MMActivity localMMActivity = this.lzt;
        if (ab.IV(((az)localObject1).field_username)) {
          break label662;
        }
        paramInt = R.e.mm_list_textcolor_one;
        label303:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cd.a.l(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.lNy.getContentView();
        a.b.g((ImageView)localObject2, ((az)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.Ycw != null) {
          this.Ycw.a((e.a)localObject2);
        }
        paramViewGroup.lNy.setMaskDrawable(null);
      }
      try
      {
        if (ab.IG(((az)localObject1).field_username))
        {
          localObject1 = p.d(this.lzt, aa.getDisplayName(((az)localObject1).field_username), (int)paramViewGroup.lDe.getTextSize());
          ((com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class)).a(this.lzt, paramViewGroup.lDe, (CharSequence)localObject1);
        }
        for (;;)
        {
          AppMethodBeat.o(37687);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          i = ((az)localObject1).field_showHead;
          break label191;
          label458:
          paramViewGroup.JMf.setVisibility(0);
          paramViewGroup.JMf.setText((CharSequence)localObject2);
          paramViewGroup.JMf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label258;
          label489:
          if ((paramInt > 0) && (((az)localObject1).field_showHead != i))
          {
            localObject2 = aJ((au)localObject1);
            paramViewGroup.afcw.setBackgroundResource(R.g.comm_list_item_selector);
            if (Util.isNullOrNil((String)localObject2))
            {
              Log.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((az)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.JMf.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.JMf.setVisibility(0);
              paramViewGroup.JMf.setText((CharSequence)localObject2);
              if (((az)localObject1).field_showHead == 32)
              {
                paramViewGroup.JMf.setCompoundDrawablesWithIntrinsicBounds(R.g.mm_contact_star, 0, 0, 0);
                paramViewGroup.JMf.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.JMf.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.JMf.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label276;
          label662:
          paramInt = R.e.mm_list_textcolor_spuser;
          break label303;
          localObject1 = p.d(this.lzt, aa.getDisplayName(((az)localObject1).field_username), (int)paramViewGroup.lDe.getTextSize());
          paramViewGroup.lDe.setText((CharSequence)localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramViewGroup.lDe.setText("");
        }
      }
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  protected static final class a
  {
    public TextView JMf;
    public ViewGroup afcw;
    public TextView lDe;
    public MaskLayout lNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */