package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.threadpool.i;

public final class h
{
  static final class a
    extends c.a
  {
    public ImageView aeOS;
    public TextView aeOT;
    public TextView aeOU;
    public TextView aeOV;
    public int aeOt = 0;
    public int aePb = 0;
    public int maxSize = 0;
    
    public final a lv(View paramView)
    {
      AppMethodBeat.i(255682);
      super.create(paramView);
      this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
      this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
      this.maskView = this.convertView.findViewById(R.h.fzn);
      this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
      this.aeOS = ((ImageView)this.convertView.findViewById(R.h.frS));
      this.aeOT = ((TextView)this.convertView.findViewById(R.h.frY));
      this.aeOU = ((TextView)this.convertView.findViewById(R.h.frQ));
      this.aeOV = ((TextView)this.convertView.findViewById(R.h.fsc));
      this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
      this.aeOt = c.nn(MMApplicationContext.getContext());
      this.aePb = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize);
      this.maxSize = ((int)(com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
      AppMethodBeat.o(255682);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255690);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.gfy);
        ((View)localObject).setTag(new h.a().lv((View)localObject));
      }
      AppMethodBeat.o(255690);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255700);
      this.aeiK = parama1;
      h.a locala = (h.a)parama;
      paramString = paramcc.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aP(paramString, paramcc.field_reserved);; localObject = null)
      {
        com.tencent.mm.message.b localb;
        label193:
        long l;
        if (localObject != null)
        {
          h.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CNewFrom", false, locala);
          locala.aeOT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          localb = (com.tencent.mm.message.b)((k.b)localObject).aK(com.tencent.mm.message.b.class);
          if (paramcc.field_isSend != 1) {
            break label538;
          }
          paramString = localb.nPy;
          if (!Util.isNullOrNil(paramString)) {
            break label548;
          }
          paramString = ((k.b)localObject).description;
          locala.aeOT.setSingleLine(false);
          locala.aeOT.setMaxLines(3);
          locala.aeOT.setText(p.d(parama1.aezO.getContext(), paramString, locala.aePb));
          locala.aeOT.setTextSize(0, locala.aePb);
          if (!aw.isDarkMode()) {
            break label560;
          }
          l = Util.getLong(localb.nPK, -1L);
          if (l >= 0L) {
            locala.aeOT.setTextColor((int)l);
          }
          label270:
          localObject = locala.aeOU;
          if (paramcc.field_isSend != 1) {
            break label594;
          }
          paramString = localb.nPC;
          label293:
          ((TextView)localObject).setText(paramString);
          if (!aw.isDarkMode()) {
            break label604;
          }
          l = Util.getLong(localb.nPL, -1L);
          if (l >= 0L) {
            locala.aeOU.setTextColor((int)l);
          }
          label337:
          localObject = locala.aeOV;
          if (paramcc.field_isSend != 1) {
            break label638;
          }
          paramString = localb.nPA;
          label360:
          ((TextView)localObject).setText(paramString);
          locala.aeOS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.nPr))
          {
            if (!localb.nPr.startsWith("http")) {
              break label648;
            }
            paramString = new com.tencent.mm.modelimage.loader.a.c.a();
            bh.bCz();
            paramString.prefixPath = com.tencent.mm.model.c.bzM();
            paramString.oKp = true;
            paramString.nqa = true;
            paramString = paramString.bKx();
            r.bKe().a(localb.nPr, locala.aeOS, paramString);
          }
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(255700);
          return;
          label538:
          paramString = localb.nPx;
          break;
          label548:
          locala.aeOT.setSingleLine(true);
          break label193;
          label560:
          l = Util.getLong(localb.nPz, -1L);
          if (l < 0L) {
            break label270;
          }
          locala.aeOT.setTextColor((int)l);
          break label270;
          label594:
          paramString = localb.nPD;
          break label293;
          label604:
          l = Util.getLong(localb.nPE, -1L);
          if (l < 0L) {
            break label337;
          }
          locala.aeOU.setTextColor((int)l);
          break label337;
          label638:
          paramString = localb.nPB;
          break label360;
          label648:
          int i = MMApplicationContext.getResources().getIdentifier(localb.nPr, "drawable", MMApplicationContext.getPackageName());
          if (i > 0) {
            locala.aeOS.setImageResource(i);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255706);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255706);
        return false;
      }
      AppMethodBeat.o(255706);
      return true;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255702);
      params.a(((bz)paramView.getTag()).position, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      AppMethodBeat.o(255702);
      return false;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255708);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      if (paramView != null) {
        if (!Util.isNullOrNil(paramView.nSC)) {
          break label115;
        }
      }
      label115:
      for (paramView = paramView.url;; paramView = paramView.nSC)
      {
        if (!Util.isNullOrNil(paramView))
        {
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", paramView);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
        }
        AppMethodBeat.o(255708);
        return true;
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 536936497);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255687);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggz);
        ((View)localObject).setTag(new h.a().lv((View)localObject));
      }
      AppMethodBeat.o(255687);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255693);
      this.aeiK = parama1;
      h.a locala = (h.a)parama;
      paramString = paramcc.field_content;
      if (paramString != null) {}
      for (Object localObject = k.b.aP(paramString, paramcc.field_reserved);; localObject = null)
      {
        com.tencent.mm.message.b localb;
        label193:
        long l;
        if (localObject != null)
        {
          h.a(parama.clickArea, (k.b)localObject, "MicroMsg.ChattingItemAppMsgC2CNewTo", true, locala);
          locala.aeOT.setTypeface(Typeface.defaultFromStyle(0));
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.SmallPadding);
          parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.chattingBubblepadding);
          locala.clickArea.setPadding(0, 0, 0, 0);
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          localb = (com.tencent.mm.message.b)((k.b)localObject).aK(com.tencent.mm.message.b.class);
          if (paramcc.field_isSend != 1) {
            break label538;
          }
          paramString = localb.nPy;
          if (!Util.isNullOrNil(paramString)) {
            break label548;
          }
          paramString = ((k.b)localObject).description;
          locala.aeOT.setSingleLine(false);
          locala.aeOT.setMaxLines(3);
          locala.aeOT.setText(p.d(parama1.aezO.getContext(), paramString, locala.aePb));
          locala.aeOT.setTextSize(0, locala.aePb);
          if (!aw.isDarkMode()) {
            break label560;
          }
          l = Util.getLong(localb.nPK, -1L);
          if (l >= 0L) {
            locala.aeOT.setTextColor((int)l);
          }
          label270:
          localObject = locala.aeOU;
          if (paramcc.field_isSend != 1) {
            break label594;
          }
          paramString = localb.nPC;
          label293:
          ((TextView)localObject).setText(paramString);
          if (!aw.isDarkMode()) {
            break label604;
          }
          l = Util.getLong(localb.nPL, -1L);
          if (l >= 0L) {
            locala.aeOU.setTextColor((int)l);
          }
          label337:
          localObject = locala.aeOV;
          if (paramcc.field_isSend != 1) {
            break label638;
          }
          paramString = localb.nPA;
          label360:
          ((TextView)localObject).setText(paramString);
          locala.aeOS.setImageBitmap(null);
          if (!Util.isNullOrNil(localb.nPr))
          {
            if (!localb.nPr.startsWith("http")) {
              break label648;
            }
            paramString = new com.tencent.mm.modelimage.loader.a.c.a();
            bh.bCz();
            paramString.prefixPath = com.tencent.mm.model.c.bzM();
            paramString.oKp = true;
            paramString.nqa = true;
            paramString = paramString.bKx();
            r.bKe().a(localb.nPr, locala.aeOS, paramString);
          }
        }
        for (;;)
        {
          parama.clickArea.setOnClickListener(d(parama1));
          parama.clickArea.setOnLongClickListener(c(parama1));
          parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
          parama1 = new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000');
          parama.clickArea.setTag(parama1);
          AppMethodBeat.o(255693);
          return;
          label538:
          paramString = localb.nPx;
          break;
          label548:
          locala.aeOT.setSingleLine(true);
          break label193;
          label560:
          l = Util.getLong(localb.nPz, -1L);
          if (l < 0L) {
            break label270;
          }
          locala.aeOT.setTextColor((int)l);
          break label270;
          label594:
          paramString = localb.nPD;
          break label293;
          label604:
          l = Util.getLong(localb.nPE, -1L);
          if (l < 0L) {
            break label337;
          }
          locala.aeOU.setTextColor((int)l);
          break label337;
          label638:
          paramString = localb.nPB;
          break label360;
          label648:
          int i = MMApplicationContext.getResources().getIdentifier(localb.nPr, "drawable", MMApplicationContext.getPackageName());
          if (i > 0) {
            locala.aeOS.setImageResource(i);
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255701);
      paramMenuItem.getItemId();
      AppMethodBeat.o(255701);
      return false;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255698);
      int i = ((bz)paramView.getTag()).position;
      if (bt.F(paramcc)) {
        params.clear();
      }
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      AppMethodBeat.o(255698);
      return false;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255704);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      String str = paramcc.field_content;
      paramView = null;
      if (str != null) {
        paramView = k.b.aP(str, paramcc.field_reserved);
      }
      if (paramView != null) {
        if (!Util.isNullOrNil(paramView.nSC)) {
          break label115;
        }
      }
      label115:
      for (paramView = paramView.url;; paramView = paramView.nSC)
      {
        if (!Util.isNullOrNil(paramView))
        {
          paramcc = new Intent();
          paramcc.putExtra("rawUrl", paramView);
          com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
        }
        AppMethodBeat.o(255704);
        return true;
      }
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 536936497);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h
 * JD-Core Version:    0.7.0.1
 */