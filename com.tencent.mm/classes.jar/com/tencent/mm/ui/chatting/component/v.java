package com.tencent.mm.ui.chatting.component;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.plugin.textstatus.a.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.au;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.i;
import com.tencent.mm.ui.chatting.component.api.k;
import com.tencent.mm.ui.chatting.component.api.r;
import com.tencent.mm.ui.chatting.component.api.x;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.az.class)
public class v
  extends a
  implements com.tencent.mm.ui.chatting.component.api.az
{
  private boolean IqD = false;
  private boolean aero = false;
  private String aerp;
  private String aerq;
  private long aerr;
  private long aers = -1L;
  private v.a aert = v.a.aeru;
  
  private void jrV()
  {
    AppMethodBeat.i(35274);
    x localx = (x)this.hlc.cm(x.class);
    if (localx.jsd() == null)
    {
      AppMethodBeat.o(35274);
      return;
    }
    if (this.aert == v.a.aerv) {}
    for (boolean bool = true;; bool = false)
    {
      localx.jsd().Ka(bool);
      AppMethodBeat.o(35274);
      return;
    }
  }
  
  private void jrW()
  {
    AppMethodBeat.i(35275);
    x localx = (x)this.hlc.cm(x.class);
    if (localx.jsd() == null)
    {
      AppMethodBeat.o(35275);
      return;
    }
    localx.jsd().iMA();
    AppMethodBeat.o(35275);
  }
  
  public final void bL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256241);
    x localx = (x)this.hlc.cm(x.class);
    localx.jsd().by(paramString1, paramString2, paramString3);
    paramString1 = localx.jsd().getLastText();
    int j = localx.jsd().getInsertPos();
    int i = j;
    if (j > paramString1.length()) {
      i = paramString1.length();
    }
    paramString1 = paramString1.substring(0, i) + paramString3 + ' ' + paramString1.substring(i);
    j = paramString3.length();
    localx.jsd().setLastContent(paramString1);
    localx.jsd().F(paramString1, i + j + 1, false);
    jrW();
    AppMethodBeat.o(256241);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35271);
    Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark reset keybord state");
    this.aert = v.a.aeru;
    if (this.hlc.Uxa != null)
    {
      Object localObject = (e)this.hlc.cm(e.class);
      if (((e)localObject).jqV())
      {
        localObject = com.tencent.mm.an.af.bHi().iD(((e)localObject).jrk());
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.an.a.a)localObject).field_editingMsg;
          this.aerp = ((String)localObject);
          this.aerq = ((String)localObject);
        }
        AppMethodBeat.o(35271);
        return;
      }
      if (((i)this.hlc.cm(i.class)).jrA())
      {
        localObject = ((z)com.tencent.mm.kernel.h.ax(z.class)).aAu(this.hlc.getTalkerUserName());
        this.aerp = ((String)localObject);
        this.aerq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((k)this.hlc.cm(k.class)).jrF())
      {
        localObject = ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).aAu(this.hlc.getTalkerUserName());
        this.aerp = ((String)localObject);
        this.aerq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      if (((r)this.hlc.cm(r.class)).jrT())
      {
        localObject = ((s)com.tencent.mm.kernel.h.ax(s.class)).aAu(this.hlc.getTalkerUserName());
        this.aerp = ((String)localObject);
        this.aerq = ((String)localObject);
        AppMethodBeat.o(35271);
        return;
      }
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
      if (localObject != null)
      {
        String str = ((bd)localObject).field_editingMsg;
        this.aerp = str;
        this.aerq = str;
        long l = ((bd)localObject).field_editingQuoteMsgId;
        this.aerr = l;
        this.aers = l;
      }
    }
    AppMethodBeat.o(35271);
  }
  
  public final void jjh() {}
  
  public final void jji() {}
  
  public final void jjj()
  {
    AppMethodBeat.i(35272);
    Object localObject = (x)this.hlc.cm(x.class);
    x localx;
    if (((x)localObject).jsd() != null)
    {
      if (((x)localObject).jsd().HDO)
      {
        this.aert = v.a.aerv;
        Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: show");
        this.aerp = ((x)localObject).jsd().getLastText();
        this.aerr = ((x)localObject).jsd().getLastQuoteMsgId();
      }
    }
    else
    {
      localx = (x)this.hlc.cm(x.class);
      e locale = (e)this.hlc.cm(e.class);
      if (!locale.jqV()) {
        break label369;
      }
      com.tencent.mm.an.a.a locala = com.tencent.mm.an.af.bHi().iD(locale.jrk());
      localObject = locala;
      if (locala == null)
      {
        localObject = locala;
        if (localx.jsd() != null)
        {
          localObject = locala;
          if (!Util.isNullOrNil(localx.jsd().getLastText().trim()))
          {
            localObject = new com.tencent.mm.an.a.a();
            ((com.tencent.mm.an.a.a)localObject).field_bizChatId = locale.jrk();
            ((com.tencent.mm.an.a.a)localObject).field_lastMsgTime = System.currentTimeMillis();
            com.tencent.mm.an.af.bHi().a((com.tencent.mm.an.a.a)localObject);
          }
        }
      }
      if ((localObject != null) && (localx.jsd() != null) && ((this.aerq == null) || (!localx.jsd().getLastText().trim().equals(this.aerq))))
      {
        this.aerq = localx.jsd().getLastText().trim();
        ((com.tencent.mm.an.a.a)localObject).field_editingMsg = this.aerq;
        if (!Util.isNullOrNil(((com.tencent.mm.an.a.a)localObject).field_editingMsg)) {
          break label362;
        }
      }
    }
    label362:
    for (long l = ((com.tencent.mm.an.a.a)localObject).field_lastMsgTime;; l = System.currentTimeMillis())
    {
      ((com.tencent.mm.an.a.a)localObject).field_flag = com.tencent.mm.an.a.b.a((com.tencent.mm.an.a.a)localObject, 1, l);
      com.tencent.mm.an.af.bHi().b((com.tencent.mm.an.a.a)localObject);
      Log.v("MicroMsg.ChattingUI.SearchComponent", "set editMsg history");
      AppMethodBeat.o(35272);
      return;
      this.aert = v.a.aeru;
      Log.d("MicroMsg.ChattingUI.SearchComponent", "jacks mark refreshKeyBordState keybord state: hide");
      break;
    }
    label369:
    if (((i)this.hlc.cm(i.class)).jrA())
    {
      if ((localx.jsd() != null) && ((this.aerq == null) || (!localx.jsd().getLastText().trim().equals(this.aerq))))
      {
        this.aerq = localx.jsd().getLastText().trim();
        ((z)com.tencent.mm.kernel.h.ax(z.class)).ie(this.hlc.getTalkerUserName(), this.aerq);
        AppMethodBeat.o(35272);
      }
    }
    else if (((k)this.hlc.cm(k.class)).jrF())
    {
      if ((localx.jsd() != null) && ((this.aerq == null) || (!localx.jsd().getLastText().trim().equals(this.aerq))))
      {
        this.aerq = localx.jsd().getLastText().trim();
        ((com.tencent.mm.plugin.gamelife.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.c.class)).ie(this.hlc.getTalkerUserName(), this.aerq);
        AppMethodBeat.o(35272);
      }
    }
    else if (((r)this.hlc.cm(r.class)).jrT())
    {
      if ((localx.jsd() != null) && ((this.aerq == null) || (!localx.jsd().getLastText().trim().equals(this.aerq))))
      {
        this.aerq = localx.jsd().getLastText().trim();
        ((s)com.tencent.mm.kernel.h.ax(s.class)).ie(this.hlc.getTalkerUserName(), this.aerq);
        AppMethodBeat.o(35272);
      }
    }
    else
    {
      localObject = null;
      if (com.tencent.mm.kernel.h.baC().aZN())
      {
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzG().bxM(this.hlc.getTalkerUserName());
      }
      if ((localObject != null) || (localx.jsd() == null) || (Util.isNullOrNil(localx.jsd().getLastText().trim()))) {
        break label1223;
      }
      localObject = new bb(this.hlc.Uxa.field_username);
      ((bb)localObject).gR(System.currentTimeMillis());
      if (((ah)this.hlc.cm(ah.class)).jti()) {
        ((bb)localObject).rv(4194304);
      }
      bh.bCz();
      com.tencent.mm.model.c.bzG().h((bb)localObject);
    }
    label1211:
    label1218:
    label1223:
    for (;;)
    {
      if ((localObject != null) && (localx.jsd() != null))
      {
        if ((this.aerq != null) && (localx.jsd().getLastText().trim().equals(this.aerq))) {
          break label1218;
        }
        this.aerq = localx.jsd().getLastText().trim();
        ((bb)localObject).BI(localx.jsd().getLastText().trim());
        if ("hidden_conv_parent".equalsIgnoreCase(((bd)localObject).field_parentRef))
        {
          ((bb)localObject).BH(null);
          com.tencent.mm.plugin.report.service.h.OAn.b(21170, new Object[] { Integer.valueOf(4), ((bd)localObject).field_username, Integer.valueOf(ac.Jj(((bd)localObject).field_username)) });
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((this.aers == -1L) || (!Util.isEqual(localx.jsd().getLastQuoteMsgId(), this.aers)))
        {
          this.aers = localx.jsd().getLastQuoteMsgId();
          ((bd)localObject).field_editingQuoteMsgId = this.aers;
          ((bd)localObject).kbz = true;
          if ("hidden_conv_parent".equalsIgnoreCase(((bd)localObject).field_parentRef))
          {
            ((bb)localObject).BH(null);
            com.tencent.mm.plugin.report.service.h.OAn.b(21170, new Object[] { Integer.valueOf(4), ((bd)localObject).field_username, Integer.valueOf(ac.Jj(((bd)localObject).field_username)) });
          }
          i = 1;
        }
        if (i != 0) {
          if ((!Util.isNullOrNil(((bd)localObject).field_editingMsg)) || (((bd)localObject).field_editingQuoteMsgId != 0L)) {
            break label1211;
          }
        }
        for (l = ((bd)localObject).field_conversationTime;; l = System.currentTimeMillis())
        {
          ((bb)localObject).gS(com.tencent.mm.plugin.messenger.foundation.a.a.a.a((bb)localObject, 1, l));
          bh.bCz();
          com.tencent.mm.model.c.bzG().a((bb)localObject, ((bd)localObject).field_username, false);
          Log.i("MicroMsg.ChattingUI.SearchComponent", "[doDestroy] set editMsg history! content:%s quoteMsgId:%s username:%s", new Object[] { Util.secPrint(this.aerq), Long.valueOf(this.aers), this.hlc.getTalkerUserName() });
          AppMethodBeat.o(35272);
          return;
        }
      }
    }
  }
  
  public final void jjk() {}
  
  public final void jrU()
  {
    AppMethodBeat.i(35273);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(35273);
      return;
    }
    x localx = (x)this.hlc.cm(x.class);
    if (localx.jsd() != null)
    {
      if ((!Util.isNullOrNil(this.aerp)) || (this.aerr != 0L))
      {
        int i;
        boolean bool1;
        if ((localx.jsd().getMode() == 1) && (Util.isNullOrNil(localx.jsg())))
        {
          i = 1;
          bool1 = ((au)this.hlc.cm(au.class)).jtA();
          if ((i == 0) || (bool1)) {
            break label379;
          }
          jrW();
          label129:
          if (this.aerr != 0L) {
            localx.jsd().setLastQuoteMsgId(this.aerr);
          }
          boolean bool2 = ((e)this.hlc.cm(e.class)).jqW();
          if (((!this.hlc.juF()) && (!bool2)) || (!this.aero)) {
            break label386;
          }
          this.aero = false;
          String str1 = localx.jsd().getAtSomebody();
          if (!Util.isNullOrNil(str1))
          {
            int j = localx.jsd().getInsertPos();
            i = j;
            if (j > this.aerp.length()) {
              i = this.aerp.length();
            }
            Object localObject = new StringBuilder().append(this.aerp.substring(0, i)).append(str1).append(' ');
            String str2 = this.aerp;
            localObject = str2.substring(i, str2.length());
            j = str1.length();
            localx.jsd().setLastContent((String)localObject);
            localx.jsd().F((String)localObject, i + j + 1, false);
            localx.jsd().setAtSomebody(null);
            jrW();
          }
        }
        for (;;)
        {
          localx.jsj();
          AppMethodBeat.o(35273);
          return;
          i = 0;
          break;
          label379:
          jrV();
          break label129;
          label386:
          localx.jsd().setLastContent(this.aerp);
          localx.jsd().setLastText(this.aerp);
          if (((!Util.isNullOrNil(this.aerp)) || (this.aerr != 0L)) && (!bool1) && (Util.isNullOrNil(localx.jsg()))) {
            localx.jsn();
          }
        }
      }
      if (((com.tencent.mm.ui.chatting.component.api.af)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.af.class)).jtc())
      {
        localx.jsd().setLastText(this.aerp);
        localx.jsd().setHint(this.hlc.aezO.getMMResources().getString(R.l.gzX));
        localx.jsd().setLastQuoteMsgId(this.aerr);
        AppMethodBeat.o(35273);
        return;
      }
      if (localx.jsd().getIsVoiceInputPanleShow())
      {
        localx.jsj();
        AppMethodBeat.o(35273);
        return;
      }
      jrV();
    }
    AppMethodBeat.o(35273);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35268);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35268);
      return;
      if (paramIntent != null)
      {
        x localx = (x)this.hlc.cm(x.class);
        String str = paramIntent.getStringExtra("select_raw_user_name");
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (Util.isNullOrNil(paramIntent))
        {
          Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { "[nobody]" });
          localx.jsd().setAtSomebody("");
          this.aero = false;
          AppMethodBeat.o(35268);
          return;
        }
        Log.d("MicroMsg.ChattingUI.SearchComponent", "@ %s", new Object[] { paramIntent });
        localx.jsd().setAtSomebody(paramIntent);
        localx.jsd().by(this.hlc.getTalkerUserName(), str, paramIntent);
        this.aero = true;
      }
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(35270);
    paramConfiguration = (x)this.hlc.cm(x.class);
    this.aerp = paramConfiguration.jsd().getLastText();
    this.aerr = paramConfiguration.jsd().getLastQuoteMsgId();
    jrU();
    AppMethodBeat.o(35270);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35269);
    Object localObject;
    int i;
    if (paramKeyEvent.getKeyCode() == 67)
    {
      localObject = (x)this.hlc.cm(x.class);
      if (paramKeyEvent.getAction() == 0)
      {
        if (((x)localObject).jsd().getCharAtCursor() != ' ') {
          break label130;
        }
        this.IqD = true;
      }
      if ((paramKeyEvent.getAction() == 1) && (this.IqD))
      {
        this.IqD = false;
        paramKeyEvent = ((x)localObject).jsd();
        paramInt = paramKeyEvent.getSelectionStart();
        localObject = paramKeyEvent.getLastText().substring(0, paramInt);
        i = ((String)localObject).lastIndexOf('@');
        if ((i < ((String)localObject).length()) && (i >= 0)) {
          break label138;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35269);
      return false;
      label130:
      this.IqD = false;
      break;
      label138:
      localObject = ((String)localObject).substring(0, i);
      String str = paramKeyEvent.getLastText().substring(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject).append(str);
      paramKeyEvent.setLastText(localStringBuilder.toString());
      paramKeyEvent.Rqt.setSelection(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.v
 * JD-Core Version:    0.7.0.1
 */