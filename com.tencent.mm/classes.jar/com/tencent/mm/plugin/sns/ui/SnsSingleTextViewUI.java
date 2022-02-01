package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.zh;
import com.tencent.mm.autogen.a.zj;
import com.tencent.mm.autogen.a.zk;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.flr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.tools.l;
import java.io.IOException;
import java.util.Map;

public class SnsSingleTextViewUI
  extends MMSecDataActivity
{
  private SnsInfo QzC;
  private String RxA;
  private String RxB;
  private int RxC;
  private byte[] RxD;
  private fdv RxE;
  private boolean RxF;
  private SnsTranslateResultView RxG;
  private IListener RxH;
  private IListener RxI;
  private IListener RxJ;
  private TextView Rxz;
  private String hHB;
  protected int requestType;
  private int sourceType;
  private String text;
  private u.i vGU;
  
  public SnsSingleTextViewUI()
  {
    AppMethodBeat.i(99134);
    this.requestType = 0;
    this.RxA = null;
    this.RxB = null;
    this.RxD = null;
    this.RxE = null;
    this.RxF = false;
    this.RxH = new IListener(com.tencent.mm.app.f.hfK) {};
    this.RxI = new IListener(com.tencent.mm.app.f.hfK) {};
    this.RxJ = new IListener(com.tencent.mm.app.f.hfK) {};
    this.vGU = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(99133);
        Object localObject1;
        Object localObject2;
        switch (paramAnonymousMenuItem.getItemId())
        {
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 13: 
        default: 
          AppMethodBeat.o(99133);
          return;
        case 0: 
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null)) {
            if (ClipboardHelper.setTextSwallowException(SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText()))
            {
              k.cZ(SnsSingleTextViewUI.this.getContext(), SnsSingleTextViewUI.this.getContext().getString(b.j.app_copy_ok));
              if (SnsSingleTextViewUI.a(SnsSingleTextViewUI.this) != null)
              {
                paramAnonymousMenuItem = com.tencent.mm.plugin.secinforeport.a.a.PlY;
                com.tencent.mm.plugin.secinforeport.a.a.x(2, Util.getUnsignedLongString(SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).field_snsId), Util.getUTF8ByteLength(SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText().toString()));
                AppMethodBeat.o(99133);
              }
            }
            else
            {
              k.cZ(SnsSingleTextViewUI.this.getContext(), SnsSingleTextViewUI.this.getContext().getString(b.j.app_copy_failed));
            }
          }
          AppMethodBeat.o(99133);
          return;
        case 1: 
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null))
          {
            paramAnonymousMenuItem = new dn();
            com.tencent.mm.plugin.sns.n.a.a(paramAnonymousMenuItem, SnsSingleTextViewUI.f(SnsSingleTextViewUI.this), SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText());
            paramAnonymousMenuItem.hDr.activity = SnsSingleTextViewUI.this;
            paramAnonymousMenuItem.hDr.hDy = 18;
            paramAnonymousMenuItem.publish();
          }
          AppMethodBeat.o(99133);
          return;
        case 6: 
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null))
          {
            localObject1 = new Intent();
            localObject2 = al.hgB().aZL(SnsSingleTextViewUI.f(SnsSingleTextViewUI.this));
            if (localObject2 != null) {
              break label471;
            }
            paramAnonymousMenuItem = "";
            ((Intent)localObject1).putExtra("k_username", paramAnonymousMenuItem);
            if (localObject2 != null) {
              break label480;
            }
          }
          for (paramAnonymousMenuItem = Integer.valueOf(0);; paramAnonymousMenuItem = ((SnsInfo)localObject2).getSnsId())
          {
            ((Intent)localObject1).putExtra("k_expose_msg_id", paramAnonymousMenuItem);
            ((Intent)localObject1).putExtra("showShare", false);
            ((Intent)localObject1).putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(33) }));
            c.b(SnsSingleTextViewUI.this, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
            AppMethodBeat.o(99133);
            return;
            paramAnonymousMenuItem = ((SnsInfo)localObject2).field_userName;
            break;
          }
        case 12: 
          label471:
          label480:
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null) && (!Util.isNullOrNil(SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText().toString())))
          {
            paramAnonymousMenuItem = SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText().toString();
            localObject1 = d.We(77);
            localObject2 = new ah();
            ((ah)localObject2).sessionId = ((String)localObject1);
            ((ah)localObject2).context = SnsSingleTextViewUI.this.getContext();
            ((ah)localObject2).query = paramAnonymousMenuItem;
            ((ah)localObject2).scene = 77;
            ((ah)localObject2).WoH = true;
            ((ah)localObject2).WoI = true;
            ((ah)localObject2).WoJ = false;
            ((ah)localObject2).WoS = true;
            ((ah)localObject2).WoL = com.tencent.mm.cd.a.w(SnsSingleTextViewUI.this.getContext(), b.c.white);
            ((ah)localObject2).WoM = false;
            ((ah)localObject2).hVt.put("chatSearch", "1");
            ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((ah)localObject2);
            if (SnsSingleTextViewUI.a(SnsSingleTextViewUI.this) == null) {
              break label1168;
            }
          }
          break;
        }
        label1034:
        label1163:
        label1168:
        for (long l = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).field_snsId;; l = 0L)
        {
          paramAnonymousInt = 0;
          if (SnsSingleTextViewUI.g(SnsSingleTextViewUI.this) == 2) {
            paramAnonymousInt = 7;
          }
          for (;;)
          {
            as.a(2, (String)localObject1, 77, 0, "", "", t.uA(l), 3, "", 0L, paramAnonymousMenuItem.length(), paramAnonymousInt, "", "", -1);
            AppMethodBeat.o(99133);
            return;
            if (SnsSingleTextViewUI.g(SnsSingleTextViewUI.this) == 1) {
              paramAnonymousInt = 6;
            }
          }
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null))
          {
            if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getContext()))
            {
              AppMethodBeat.o(99133);
              return;
            }
            av.G(al.hgB().aZL(SnsSingleTextViewUI.f(SnsSingleTextViewUI.this)));
          }
          AppMethodBeat.o(99133);
          return;
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null)) {
            av.H(al.hgB().aZL(SnsSingleTextViewUI.f(SnsSingleTextViewUI.this)));
          }
          AppMethodBeat.o(99133);
          return;
          String str1;
          String str2;
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null))
          {
            if (!WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getContext()))
            {
              AppMethodBeat.o(99133);
              return;
            }
            localObject1 = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getSnsId();
            localObject2 = SnsSingleTextViewUI.h(SnsSingleTextViewUI.this);
            str1 = SnsSingleTextViewUI.h(SnsSingleTextViewUI.this).nUB;
            str2 = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).field_userName;
            if (SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getTimeLine() == null) {
              break label1034;
            }
          }
          for (paramAnonymousMenuItem = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getTimeLine().Id;; paramAnonymousMenuItem = null)
          {
            av.a(new m(null, (String)localObject1, (fdv)localObject2, null, str1, null, 1, str2, paramAnonymousMenuItem));
            AppMethodBeat.o(99133);
            return;
          }
          if ((SnsSingleTextViewUI.e(SnsSingleTextViewUI.this) != null) && (SnsSingleTextViewUI.e(SnsSingleTextViewUI.this).getText() != null))
          {
            localObject1 = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getSnsId();
            localObject2 = SnsSingleTextViewUI.h(SnsSingleTextViewUI.this);
            str1 = SnsSingleTextViewUI.h(SnsSingleTextViewUI.this).nUB;
            str2 = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).field_userName;
            if (SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getTimeLine() == null) {
              break label1163;
            }
          }
          for (paramAnonymousMenuItem = SnsSingleTextViewUI.a(SnsSingleTextViewUI.this).getTimeLine().Id;; paramAnonymousMenuItem = null)
          {
            av.b(new m(null, (String)localObject1, (fdv)localObject2, null, str1, null, 1, str2, paramAnonymousMenuItem));
            AppMethodBeat.o(99133);
            return;
          }
        }
      }
    };
    AppMethodBeat.o(99134);
  }
  
  private boolean hpq()
  {
    boolean bool2 = false;
    AppMethodBeat.i(99138);
    boolean bool1;
    if (this.RxE == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(99138);
      return bool1;
      if (this.RxE.abDh == 0)
      {
        bool1 = bool2;
        if (this.RxE.abDj == 0L) {}
      }
      else
      {
        bool1 = bool2;
        if (!Util.isNullOrNil(this.RxE.nUB)) {
          bool1 = true;
        }
      }
    }
  }
  
  public int getLayoutId()
  {
    return b.g.sns_single_textviewui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99135);
    super.onCreate(paramBundle);
    setMMTitle(b.j.sns_all_text);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(99132);
        SnsSingleTextViewUI.this.finish();
        AppMethodBeat.o(99132);
        return true;
      }
    });
    paramBundle = com.tencent.mm.plugin.sns.j.a.QCu;
    com.tencent.mm.plugin.sns.j.a.a.jQ(this);
    this.text = getIntent().getStringExtra("sns_text_show");
    this.hHB = Util.nullAs(getIntent().getStringExtra("sns_local_id"), "");
    this.RxD = getIntent().getByteArrayExtra("sns_comment_buf");
    this.sourceType = getIntent().getIntExtra("sns_content_source", 0);
    if ((this.RxD != null) && (this.RxD.length > 0)) {
      this.RxE = new fdv();
    }
    long l;
    Object localObject2;
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        this.RxE.parseFrom(this.RxD);
        paramBundle = new StringBuilder();
        if (this.RxE.abDh == 0) {
          continue;
        }
        l = this.RxE.abDh;
        this.RxA = l;
      }
      catch (IOException paramBundle)
      {
        fdv localfdv;
        label314:
        Log.printErrStackTrace("MicroMsg.SnsSingleTextViewUI", paramBundle, "initCommentInfo error.", new Object[0]);
        label396:
        label566:
        continue;
        localObject1 = new Bundle();
        paramBundle = this.QzC.getUserName() + "#" + t.uA(this.QzC.field_snsId);
        if (this.RxE == null) {
          break label982;
        }
      }
      this.QzC = al.hgB().aZL(this.hHB);
      if (Util.isNullOrNil(this.text)) {
        this.text = "";
      }
      this.Rxz = ((TextView)findViewById(b.f.sns_text_tv));
      this.Rxz.setText(this.text, TextView.BufferType.SPANNABLE);
      localObject2 = this.Rxz;
      if (this.QzC == null)
      {
        paramBundle = null;
        p.a((TextView)localObject2, 2, 2, paramBundle);
        paramBundle = com.tencent.mm.plugin.sns.j.a.QCu;
        localObject2 = this.QzC;
        localfdv = this.RxE;
        paramBundle = this.Rxz;
        kotlin.g.b.s.u(localObject2, "snsInfo");
        kotlin.g.b.s.u(paramBundle, "view");
        localObject1 = new flr();
        if (localfdv == null) {
          break label897;
        }
        if (t.a(localfdv))
        {
          i = 5;
          ((flr)localObject1).abMf = i;
          ((flr)localObject1).abMg = (((SnsInfo)localObject2).getUserName() + '#' + t.uA(((SnsInfo)localObject2).field_snsId) + '#' + localfdv.Username + '#' + localfdv.abDh);
          ((flr)localObject1).YKn = localfdv.CreateTime;
          ((flr)localObject1).abMh = 1;
          ((flr)localObject1).abMi = ((SnsInfo)localObject2).field_type;
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.PlI;
          localObject2 = paramBundle.getContext();
          kotlin.g.b.s.s(localObject2, "view.context");
          localObject2 = com.tencent.mm.plugin.secdata.ui.a.a.jC((Context)localObject2);
          if (localObject2 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.secdata.ui.a)localObject2).gUA();
            if (localObject2 != null) {
              ((com.tencent.mm.plugin.secdata.f)localObject2).c(String.valueOf(paramBundle.hashCode()), (com.tencent.mm.bx.a)localObject1);
            }
          }
          this.Rxz.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.s());
          new l(this).a(this.Rxz, this, this.vGU);
          this.RxG = ((SnsTranslateResultView)findViewById(b.f.sns_translate_result_view));
          this.RxG.setResultTextSize(this.Rxz.getTextSize());
          if (this.QzC != null)
          {
            if (hpq()) {
              break label956;
            }
            this.RxB = this.QzC.getSnsId();
            this.RxC = 1;
            if (av.gY(this.RxB, 8))
            {
              paramBundle = av.aYE(this.RxB);
              if ((paramBundle != null) && (paramBundle.ooe))
              {
                this.RxG.setVisibility(0);
                this.RxG.a(null, this.RxC, paramBundle.result, paramBundle.brand, false);
                this.RxF = true;
              }
            }
          }
          this.RxH.alive();
          this.RxI.alive();
          this.RxJ.alive();
          AppMethodBeat.o(99135);
          return;
          l = this.RxE.abDj;
        }
      }
      else if (t.a(this.RxE))
      {
        i = 5;
        label755:
        paramBundle = paramBundle + "#" + this.RxE.Username + "#" + this.RxE.abDh;
      }
    }
    for (;;)
    {
      ((Bundle)localObject1).putInt("ShareScene", i);
      ((Bundle)localObject1).putString("ShareSceneId", paramBundle);
      if (this.RxE != null) {}
      for (l = this.RxE.CreateTime;; l = this.QzC.getCreateTime())
      {
        ((Bundle)localObject1).putLong("CreateTime", l);
        ((Bundle)localObject1).putInt("TimelineEnterSource", 1);
        ((Bundle)localObject1).putInt("SnsContentType", this.QzC.field_type);
        paramBundle = (Bundle)localObject1;
        break;
        i = 4;
        break label755;
      }
      i = 4;
      break label314;
      label897:
      ((flr)localObject1).abMf = 3;
      ((flr)localObject1).abMg = (((SnsInfo)localObject2).getUserName() + '#' + t.uA(((SnsInfo)localObject2).field_snsId));
      ((flr)localObject1).YKn = ((SnsInfo)localObject2).getCreateTime();
      break label396;
      label956:
      this.RxB = av.mj(this.QzC.getSnsId(), this.RxA);
      this.RxC = 2;
      break label566;
      label982:
      i = 3;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(99137);
    boolean bool;
    if ((paramView instanceof TextView))
    {
      if ((this.QzC != null) && (!this.QzC.isNoCopy())) {
        paramContextMenu.add(0, 0, 0, getString(b.j.app_copy));
      }
      if ((c.blq("favorite")) && (!hpq())) {
        paramContextMenu.add(0, 1, 0, getString(b.j.favorite));
      }
      paramContextMenu.add(0, 6, 1, getString(b.j.app_expose));
      if (this.RxF) {
        break label236;
      }
      if (hpq()) {
        break label230;
      }
      bool = true;
      av.a(paramContextMenu, bool);
      paramContextMenu.add(0, 12, 0, getContext().getString(b.j.find_friends_search));
      paramContextMenu = this.Rxz.getText().toString();
      if (this.QzC == null) {
        break label276;
      }
    }
    label276:
    for (long l = this.QzC.field_snsId;; l = 0L)
    {
      int i = 0;
      if (this.sourceType == 2) {
        i = 7;
      }
      for (;;)
      {
        as.a(1, d.We(77), 77, 0, "", "", t.uA(l), 3, "", 0L, paramContextMenu.length(), i, "", "", -1);
        AppMethodBeat.o(99137);
        return;
        label230:
        bool = false;
        break;
        label236:
        if (!hpq()) {}
        for (bool = true;; bool = false)
        {
          av.b(paramContextMenu, bool);
          break;
        }
        if (this.sourceType == 1) {
          i = 6;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99136);
    super.onDestroy();
    this.RxH.dead();
    this.RxI.dead();
    this.RxJ.dead();
    AppMethodBeat.o(99136);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI
 * JD-Core Version:    0.7.0.1
 */