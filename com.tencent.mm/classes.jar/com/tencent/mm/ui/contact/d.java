package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
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
import java.util.List;

public final class d
  extends com.tencent.mm.ui.r<ad>
{
  protected MMActivity bER;
  protected List<String> dru = null;
  com.tencent.mm.ui.applet.b ffG = null;
  private b.b ffH = null;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  protected MMSlideDelView.f mDS;
  com.tencent.mm.pluginsdk.ui.d scN;
  protected String vIs = null;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext, new ad());
    this.bER = ((MMActivity)paramContext);
    this.vIs = paramString;
    this.ffG = new com.tencent.mm.ui.applet.b(new d.1(this));
  }
  
  private void a(a parama, int paramInt1, int paramInt2)
  {
    ad localad = (ad)getItem(paramInt1 + 1);
    if ((localad == null) || ((localad.field_showHead != paramInt2) && (!ah.bl(ac(localad))))) {
      parama.vKd.setBackgroundResource(0);
    }
  }
  
  private String ac(ad paramad)
  {
    if (paramad.field_showHead == 31) {
      return "";
    }
    if (paramad.field_showHead == 43) {
      return this.bER.getString(R.l.room_head_name);
    }
    return String.valueOf((char)paramad.field_showHead);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mDS = paramf;
  }
  
  public final int getCount()
  {
    return getCursor().getCount();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.ffH == null) {
      this.ffH = new d.2(this);
    }
    if (this.ffG != null) {
      this.ffG.a(paramInt, this.ffH);
    }
    Object localObject1;
    if (paramView == null)
    {
      paramView = View.inflate(this.bER, R.i.chatroom_address_list_item, null);
      paramViewGroup = new a();
      paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(R.h.contactitem_avatar));
      paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
      paramViewGroup.vKd = ((ViewGroup)paramView.findViewById(R.h.contactitem_layout));
      localObject1 = paramViewGroup.vKd.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ab(this.bER, R.f.ContactListHeight) * com.tencent.mm.cb.a.fg(this.bER)));
      paramViewGroup.vKd.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = (ad)getItem(paramInt - 1);
      int i;
      label186:
      Object localObject2;
      if (localObject1 == null)
      {
        i = -1;
        localObject1 = (ad)getItem(paramInt);
        if (paramInt != 0) {
          break label458;
        }
        localObject2 = ac((ad)localObject1);
        if (!ah.bl((String)localObject2)) {
          break label427;
        }
        y.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ao)localObject1).field_username, Integer.valueOf(paramInt) });
        paramViewGroup.lvb.setVisibility(8);
        label251:
        if (getItem(paramInt + 1) == null) {
          paramViewGroup.vKd.setBackgroundResource(0);
        }
        label269:
        localObject2 = paramViewGroup.drB;
        MMActivity localMMActivity = this.bER;
        if (s.hU(((ao)localObject1).field_username)) {
          break label629;
        }
        paramInt = R.e.mm_list_textcolor_one;
        label296:
        ((TextView)localObject2).setTextColor(com.tencent.mm.cb.a.h(localMMActivity, paramInt));
        localObject2 = (ImageView)paramViewGroup.dsk.getContentView();
        a.b.a((ImageView)localObject2, ((ao)localObject1).field_username);
        localObject2 = (com.tencent.mm.pluginsdk.ui.a)((ImageView)localObject2).getDrawable();
        if (this.scN != null) {
          this.scN.a((com.tencent.mm.pluginsdk.ui.d.a)localObject2);
        }
        paramViewGroup.dsk.setMaskDrawable(null);
      }
      try
      {
        if (s.hb(((ao)localObject1).field_username))
        {
          ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).a(this.bER, paramViewGroup.drB, com.tencent.mm.model.r.gV(((ao)localObject1).field_username));
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          continue;
          i = ((ao)localObject1).field_showHead;
          break label186;
          label427:
          paramViewGroup.lvb.setVisibility(0);
          paramViewGroup.lvb.setText((CharSequence)localObject2);
          paramViewGroup.lvb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break label251;
          label458:
          if ((paramInt > 0) && (((ao)localObject1).field_showHead != i))
          {
            localObject2 = ac((ad)localObject1);
            paramViewGroup.vKd.setBackgroundResource(R.g.comm_list_item_selector);
            if (ah.bl((String)localObject2))
            {
              y.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[] { ((ao)localObject1).field_username, Integer.valueOf(paramInt) });
              paramViewGroup.lvb.setVisibility(8);
            }
            for (;;)
            {
              a(paramViewGroup, paramInt, i);
              break;
              paramViewGroup.lvb.setVisibility(0);
              paramViewGroup.lvb.setText((CharSequence)localObject2);
              if (((ao)localObject1).field_showHead == 32)
              {
                paramViewGroup.lvb.setCompoundDrawablesWithIntrinsicBounds(R.g.mm_contact_star, 0, 0, 0);
                paramViewGroup.lvb.setCompoundDrawablePadding(2);
              }
              else
              {
                paramViewGroup.lvb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
              }
            }
          }
          paramViewGroup.lvb.setVisibility(8);
          a(paramViewGroup, paramInt, i);
          break label269;
          label629:
          paramInt = R.e.mm_list_textcolor_spuser;
          break label296;
        }
        else
        {
          localObject1 = j.b(this.bER, com.tencent.mm.model.r.gV(((ao)localObject1).field_username), (int)paramViewGroup.drB.getTextSize());
          paramViewGroup.drB.setText((CharSequence)localObject1);
          return paramView;
        }
      }
      catch (Exception localException)
      {
        paramViewGroup.drB.setText("");
      }
    }
    return paramView;
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    try
    {
      au.Hx();
      Cursor localCursor = c.Fw().c(this.vIs, "", this.dru);
      bcS();
      setCursor(localCursor);
      notifyDataSetChanged();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void yd()
  {
    yc();
  }
  
  protected static final class a
  {
    public TextView drB;
    public MaskLayout dsk;
    public TextView lvb;
    public ViewGroup vKd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.d
 * JD-Core Version:    0.7.0.1
 */