package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements g
{
  private TextView GUC;
  private View GUD;
  private View GUE;
  private MMTagPanel GUM;
  private TextView GUN;
  private EditText GWL;
  private int GWM;
  private String GWN;
  private TextView GWO;
  private EditText GWP;
  private TextView GWQ;
  private String GWR;
  private boolean GWS;
  private a GWT;
  private View GWU;
  private TextView GWV;
  private af contact;
  private String dtV;
  private String iaz;
  private int ima;
  private ArrayList<String> uAu;
  private String uBd;
  private bw uTk;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.GWN = "";
    this.iaz = "";
    this.GWO = null;
    this.GWP = null;
    this.GWQ = null;
    this.GWR = "";
    this.GWS = false;
    this.ima = 9;
    this.GWT = new a((byte)0);
    AppMethodBeat.o(37872);
  }
  
  public int getLayoutId()
  {
    return 2131494938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.dtV = getIntent().getStringExtra("Contact_User");
    if ((this.dtV != null) && (this.dtV.length() > 0))
    {
      az.arV();
      this.contact = com.tencent.mm.model.c.apM().aHY(this.dtV);
      az.arV();
      this.uTk = com.tencent.mm.model.c.apN().agQ(this.dtV);
      if ((this.contact == null) || (bt.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new af(this.dtV);
        this.contact.nd(bt.nullAsNil(this.GWN));
        this.contact.nb(bt.nullAsNil(this.iaz));
      }
    }
    this.GWL = ((EditText)findViewById(2131298627));
    Object localObject1 = new MMEditText.b()
    {
      public final void aJE()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    Object localObject2 = new j.a();
    ((j.a)localObject2).CmY = ((MMEditText.b)localObject1);
    this.GWL.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.d(this.GWL).aaj(32).a(null);
    if ((this.contact != null) && (this.GWM != 3))
    {
      if (this.GWM == 4)
      {
        this.GWL.setText(k.b(this, bt.nullAsNil(this.GWN), this.GWL.getTextSize()));
        this.GWL.setSelection(this.GWL.getText().length());
      }
    }
    else
    {
      if (this.GWM != 0) {
        break label1118;
      }
      setMMTitle(2131757731);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.contact.field_username);
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv().equals(this.GWL.getText()))) {
        break label988;
      }
      label326:
      addTextOptionMenu(0, getString(2131755880), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37865);
          switch (ModRemarkNameUI.b(ModRemarkNameUI.this))
          {
          }
          for (;;)
          {
            AppMethodBeat.o(37865);
            return true;
            ModRemarkNameUI.c(ModRemarkNameUI.this);
            continue;
            ModRemarkNameUI.d(ModRemarkNameUI.this);
            continue;
            ModRemarkNameUI.e(ModRemarkNameUI.this);
          }
        }
      });
      if ((this.GWL == null) || (this.GWL.getText().toString().trim().length() <= 0)) {
        break label1251;
      }
      enableOptionMenu(true);
    }
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(37866);
          ModRemarkNameUI.this.finish();
          AppMethodBeat.o(37866);
          return true;
        }
      });
      this.GWO = ((TextView)findViewById(2131298634));
      this.GWP = ((EditText)findViewById(2131298626));
      this.GWQ = ((TextView)findViewById(2131307005));
      this.GUE = findViewById(2131298625);
      com.tencent.mm.ui.tools.b.c.d(this.GWP).aaj(800).a(null);
      this.GWQ.setText(f.cJ(800, this.GWP.getEditableText().toString()));
      this.GWP.append(k.b(this, bt.nullAsNil(this.GWR), this.GWP.getTextSize()));
      this.GWO.append(k.b(this, bt.nullAsNil(this.GWR), this.GWO.getTextSize()));
      if (this.uTk != null)
      {
        this.GWP.setText(k.b(this, bt.nullAsNil(this.uTk.field_conDescription), this.GWP.getTextSize()));
        this.GWO.setText(k.b(this, bt.nullAsNil(this.uTk.field_conDescription), this.GWP.getTextSize()));
      }
      this.GWP.addTextChangedListener(new b((byte)0));
      this.GWO.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37867);
          ModRemarkNameUI.f(ModRemarkNameUI.this).setVisibility(0);
          ModRemarkNameUI.g(ModRemarkNameUI.this).setVisibility(8);
          ModRemarkNameUI.h(ModRemarkNameUI.this).requestFocus();
          ModRemarkNameUI.this.showVKB();
          AppMethodBeat.o(37867);
        }
      });
      AppMethodBeat.o(37874);
      return;
      if (!bt.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.GWM == 0) && (!bt.isNullOrNil(this.iaz)))
        {
          this.GWL.setText(k.b(this, this.iaz, this.GWL.getTextSize()));
          break;
        }
        this.GWL.setText(k.b(this, bt.nullAsNil(this.contact.field_conRemark), this.GWL.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.iaz))
      {
        this.GWL.setText(k.b(this, bt.nullAsNil(this.iaz), this.GWL.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.GWM == 0) && (!bt.isNullOrNil(this.GWN)) && (!com.tencent.mm.n.b.ls(this.contact.field_type)))
        {
          this.GWL.setText(k.b(this, bt.nullAsNil(this.GWN), this.GWL.getTextSize()));
          break;
        }
        this.GWL.setText(k.b(this, bt.nullAsNil(this.contact.field_nickname), this.GWL.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.GWN))
      {
        this.GWL.setText(k.b(this, bt.nullAsNil(this.GWN), this.GWL.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((bt.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label976;
        }
        this.GWL.setText(k.b(this, bt.nullAsNil(this.contact.ZX()), this.GWL.getTextSize()));
        break;
      }
      label976:
      this.GWL.setText("");
      break;
      label988:
      this.GUC = ((TextView)findViewById(2131302425));
      this.GUD = findViewById(2131302419);
      this.GUD.setVisibility(0);
      this.GUC.setText(bt.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIv()), 0, ((l)localObject2).length(), 17);
      this.GUC.append(" ");
      this.GUC.append((CharSequence)localObject2);
      this.GUC.setMovementMethod(LinkMovementMethod.getInstance());
      break label326;
      label1118:
      if (this.GWM == 3)
      {
        setMMTitle(2131764345);
        this.GWL.setHint("");
        if (!bt.isNullOrNil(this.GWN)) {
          this.GWL.setText(this.GWN);
        }
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131763093);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131302420).setVisibility(8);
        break label326;
      }
      if (this.GWM != 4) {
        break label326;
      }
      setMMTitle(2131762651);
      this.GWL.setHint("");
      localObject1 = (TextView)findViewById(2131298628);
      ((TextView)localObject1).setText(2131762702);
      ((TextView)localObject1).setVisibility(0);
      break label326;
      label1251:
      enableOptionMenu(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(37873);
    super.onCreate(paramBundle);
    this.ima = getIntent().getIntExtra("Contact_Scene", 9);
    this.GWM = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.GWN = bt.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.iaz = bt.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.GWS = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.GWV = ((TextView)findViewById(2131298624));
    this.GWU = findViewById(2131298622);
    int i;
    if (this.GWM != 0)
    {
      this.GWU.setVisibility(8);
      this.GWV.setVisibility(8);
      this.GUM = ((MMTagPanel)findViewById(2131298623));
      this.GUM.setPanelClickable(false);
      this.GUN = ((TextView)findViewById(2131298621));
      this.GUN.setText(2131761304);
      this.GUM.setOnClickListener(this.GWT);
      this.GUN.setOnClickListener(this.GWT);
      if ((this.contact == null) || (!af.aHH(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.GWL == null)
        {
          AppMethodBeat.o(37873);
          return;
          this.GWU.setVisibility(0);
          this.GWV.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.GWL.getParent();
        int k = paramBundle.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = paramBundle.getChildAt(i);
          j = localView.getId();
          if ((j != 2131298628) && (j != 2131298627)) {
            localView.setVisibility(8);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(37873);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37876);
    super.onDestroy();
    AppMethodBeat.o(37876);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37875);
    super.onResume();
    az.arV();
    this.uTk = com.tencent.mm.model.c.apN().agQ(this.dtV);
    if (this.uTk != null)
    {
      this.uBd = this.uTk.field_contactLabels;
      this.uAu = ((ArrayList)com.tencent.mm.plugin.label.a.a.cIS().aeJ(this.uBd));
    }
    if (!bt.isNullOrNil(this.uBd))
    {
      this.GUM.setVisibility(0);
      this.GUN.setVisibility(8);
      if ((this.uAu != null) && (!this.uAu.isEmpty()))
      {
        this.GUM.a(this.uAu, this.uAu);
        AppMethodBeat.o(37875);
      }
    }
    else
    {
      this.GUM.setVisibility(8);
      this.GUN.setVisibility(0);
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37877);
    ad.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        ad.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(2131762691, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
    AppMethodBeat.o(37877);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37868);
      ModRemarkNameUI.k(ModRemarkNameUI.this);
      AppMethodBeat.o(37868);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private int weg = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.weg = f.cJ(800, paramEditable.toString());
      if (this.weg < 0) {
        this.weg = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.weg);
      }
      ModRemarkNameUI.j(ModRemarkNameUI.this);
      AppMethodBeat.o(37869);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  final class c
    extends ClickableSpan
  {
    public String iaz;
    
    public c(String paramString)
    {
      this.iaz = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(k.b(ModRemarkNameUI.this, bt.nullAsNil(this.iaz), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
      ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
      ModRemarkNameUI.l(ModRemarkNameUI.this).setVisibility(8);
      AppMethodBeat.o(37870);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37871);
      paramTextPaint.setColor(ModRemarkNameUI.this.getResources().getColor(2131100027));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */