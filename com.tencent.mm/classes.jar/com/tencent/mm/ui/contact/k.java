package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.fy;
import com.tencent.mm.h.a.fy.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.q;
import java.util.ArrayList;
import java.util.List;

public final class k
  extends RelativeLayout
{
  public static Boolean vLk = Boolean.valueOf(true);
  private Context context = null;
  private View eML = null;
  private boolean isVisible = true;
  private View vLl = null;
  j.a vLm = new k.2(this);
  private boolean vLn = false;
  private final am voa = new am(new k.1(this), true);
  
  public k(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    com.tencent.mm.bh.d.RY().c(this.vLm);
    cHz();
    init();
  }
  
  public static void cHA()
  {
    au.Hx();
    if (c.Fs())
    {
      au.Hx();
      if (c.Dz().getInt(143618, 0) > 0) {
        com.tencent.mm.modelsimple.z.T("fmessage", 2);
      }
    }
    au.Hx();
    c.Dz().o(143618, Integer.valueOf(0));
  }
  
  private static void cHz()
  {
    int i = com.tencent.mm.bh.d.RY().cuU();
    y.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      au.Hx();
      c.Dz().o(143618, Integer.valueOf(i));
    }
  }
  
  private void init()
  {
    Object localObject2 = com.tencent.mm.bh.d.RY();
    y.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", new Object[] { Integer.valueOf(4) });
    Object localObject1 = new ArrayList();
    localObject2 = ((aw)localObject2).dXw.a("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4", null, 2);
    Object localObject3;
    while (((Cursor)localObject2).moveToNext())
    {
      localObject3 = new av();
      ((av)localObject3).d((Cursor)localObject2);
      if (!bk.bl(((av)localObject3).field_talker)) {
        ((List)localObject1).add(localObject3);
      }
    }
    ((Cursor)localObject2).close();
    int i = ((List)localObject1).size();
    y.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0) {
      if (this.context == null)
      {
        y.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
        localObject1 = this.eML.findViewById(R.h.fmessage_contact_header_container_ll);
        if (localObject1 != null) {
          if (!this.isVisible) {
            break label1313;
          }
        }
      }
    }
    label1313:
    for (i = 0;; i = 8)
    {
      ((View)localObject1).setVisibility(i);
      this.vLl.setOnTouchListener(new k.3(this));
      i = com.tencent.mm.bh.d.RY().cuU();
      y.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject1 = (TextView)this.eML.findViewById(R.h.fmessage_contact_unread_tv);
      ((TextView)localObject1).setBackgroundResource(q.hh(this.context));
      if (i > 0) {
        break label1319;
      }
      ((TextView)localObject1).setVisibility(8);
      vLk = Boolean.valueOf(false);
      return;
      this.eML = View.inflate(this.context, R.i.fmessage_contact_header, this);
      this.vLl = this.eML.findViewById(R.h.fmessage_contact_viewall);
      localObject1 = this.vLl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((int)(com.tencent.mm.cb.a.ab(this.context, R.f.ContactListHeight) * com.tencent.mm.cb.a.fg(this.context)));
      this.vLl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.eML.setOnClickListener(new k.4(this));
      localObject1 = (MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv);
      o.JQ();
      localObject2 = com.tencent.mm.ag.d.ki("fmessage");
      ((ImageView)((MaskLayout)localObject1).getContentView()).setImageBitmap((Bitmap)localObject2);
      break;
      if (i == 1)
      {
        localObject2 = (av)((List)localObject1).get(0);
        if (this.context == null)
        {
          y.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
          break;
        }
        label461:
        Object localObject4;
        Context localContext;
        boolean bool;
        if (com.tencent.mm.cb.a.fh(this.context))
        {
          this.eML = View.inflate(this.context, R.i.fmessage_contact_header_single_large, this);
          ((TextView)this.eML.findViewById(R.h.fmessage_header_nick_tv)).setText(j.b(this.context, ((av)localObject2).field_displayName));
          localObject3 = (TextView)this.eML.findViewById(R.h.fmessage_header_digest_tv);
          localObject4 = com.tencent.mm.bh.d.RX().abT(((av)localObject2).field_talker);
          localContext = this.context;
          i = ((ax)localObject4).field_type;
          int j = ((av)localObject2).field_addScene;
          localObject1 = ((ax)localObject4).field_msgContent;
          if (((ax)localObject4).cuX()) {
            break label704;
          }
          bool = true;
          label552:
          y.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject1, Boolean.valueOf(bool) });
          if (i != 0) {
            break label939;
          }
          if (localObject1 != null) {
            break label709;
          }
          y.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
          localObject1 = null;
          if (!ah.bl((String)localObject1)) {
            break label1001;
          }
          ((TextView)localObject3).setVisibility(8);
        }
        for (;;)
        {
          this.vLl = this.eML.findViewById(R.h.fmessage_contact_header_container_ll);
          this.eML.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              y.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
              au.Hx();
              c.Dz().o(143618, Integer.valueOf(0));
              com.tencent.mm.br.d.b(k.d(k.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
            }
          });
          a.b.a((ImageView)((MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv)).getContentView(), ((av)localObject2).field_talker);
          break;
          this.eML = View.inflate(this.context, R.i.fmessage_contact_header_single, this);
          break label461;
          label704:
          bool = false;
          break label552;
          label709:
          localObject1 = bi.a.abZ((String)localObject1);
          switch (((bi.a)localObject1).scene)
          {
          default: 
            localObject1 = localContext.getString(R.l.chatting_from_possible_friends_content);
            break;
          case 4: 
            localObject1 = localContext.getString(R.l.chatting_from_QQ_friends_content);
            break;
          case 10: 
          case 11: 
            localObject4 = new fy();
            ((fy)localObject4).bNh.bNe = ((bi.a)localObject1).uBW;
            ((fy)localObject4).bNh.bNf = ((bi.a)localObject1).uBX;
            com.tencent.mm.sdk.b.a.udP.m((b)localObject4);
            localObject1 = localContext.getString(R.l.chatting_from_mobile_friends_content, new Object[] { bk.aM(((fy)localObject4).bNi.bNj, "") });
            break;
          case 31: 
            localObject1 = localContext.getString(R.l.chatting_from_verify_facebook_content);
            break;
          case 32: 
            localObject1 = localContext.getString(R.l.chatting_from_sns_add_now);
            break;
          case 58: 
          case 59: 
          case 60: 
            localObject1 = localContext.getString(R.l.chatting_from_google_contact);
            break;
            label939:
            if (bool) {
              break;
            }
            localObject1 = bi.d.acc((String)localObject1);
            if ((((bi.d)localObject1).content != null) && (!((bi.d)localObject1).content.trim().equals("")))
            {
              localObject1 = ((bi.d)localObject1).content;
              break;
            }
            localObject1 = localContext.getString(R.l.fmessage_from_verify_digest_tip);
            break;
            label1001:
            ((TextView)localObject3).setText((CharSequence)localObject1);
          }
        }
      }
      if (this.context == null)
      {
        y.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        break;
      }
      this.eML = View.inflate(this.context, R.i.fmessage_contact_header_multi, this);
      i = ((List)localObject1).size();
      y.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
      localObject2 = (av)((List)localObject1).get(0);
      localObject3 = (MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv);
      a.b.a((ImageView)((MaskLayout)localObject3).getContentView(), ((av)localObject2).field_talker);
      ((MaskLayout)localObject3).setVisibility(0);
      localObject2 = (av)((List)localObject1).get(1);
      localObject3 = (MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv_2);
      a.b.a((ImageView)((MaskLayout)localObject3).getContentView(), ((av)localObject2).field_talker);
      ((MaskLayout)localObject3).setVisibility(0);
      if (i > 2)
      {
        localObject2 = (av)((List)localObject1).get(2);
        localObject3 = (MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv_3);
        a.b.a((ImageView)((MaskLayout)localObject3).getContentView(), ((av)localObject2).field_talker);
        ((MaskLayout)localObject3).setVisibility(0);
      }
      if (i > 3)
      {
        localObject1 = (av)((List)localObject1).get(3);
        localObject2 = (MaskLayout)this.eML.findViewById(R.h.fmessage_avatar_iv_4);
        a.b.a((ImageView)((MaskLayout)localObject2).getContentView(), ((av)localObject1).field_talker);
        ((MaskLayout)localObject2).setVisibility(0);
      }
      this.vLl = this.eML.findViewById(R.h.fmessage_contact_header_container_ll);
      this.vLl.setOnClickListener(new k.6(this));
      break;
    }
    label1319:
    ((TextView)localObject1).setVisibility(0);
    vLk = Boolean.valueOf(true);
    if (i > 99)
    {
      ((TextView)localObject1).setText(getContext().getString(R.l.unread_count_overt_100));
      return;
    }
    ((TextView)localObject1).setText(String.valueOf(i));
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.vLn = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    y.d("MicroMsg.FMessageContactView", "setVisible visible = " + paramBoolean);
    View localView = this.eML.findViewById(R.h.fmessage_contact_header_container_ll);
    if (localView != null) {
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.isVisible = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */