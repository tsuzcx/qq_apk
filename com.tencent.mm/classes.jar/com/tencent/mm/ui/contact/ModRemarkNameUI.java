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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements g
{
  private TextView IuP;
  private View IuQ;
  private View IuR;
  private MMTagPanel IuZ;
  private TextView Iva;
  private EditText IwZ;
  private int Ixa;
  private String Ixb;
  private TextView Ixc;
  private EditText Ixd;
  private TextView Ixe;
  private String Ixf;
  private boolean Ixg;
  private a Ixh;
  private View Ixi;
  private TextView Ixj;
  private ai contact;
  private String drG;
  private String iAC;
  private int iMg;
  private String vJW;
  private ArrayList<String> vJn;
  private bz wbZ;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.Ixb = "";
    this.iAC = "";
    this.Ixc = null;
    this.Ixd = null;
    this.Ixe = null;
    this.Ixf = "";
    this.Ixg = false;
    this.iMg = 9;
    this.Ixh = new a((byte)0);
    AppMethodBeat.o(37872);
  }
  
  public int getLayoutId()
  {
    return 2131494938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.drG = getIntent().getStringExtra("Contact_User");
    if ((this.drG != null) && (this.drG.length() > 0))
    {
      az.ayM();
      this.contact = com.tencent.mm.model.c.awB().aNt(this.drG);
      az.ayM();
      this.wbZ = com.tencent.mm.model.c.awC().alK(this.drG);
      if ((this.contact == null) || (bs.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new ai(this.drG);
        this.contact.qj(bs.nullAsNil(this.Ixb));
        this.contact.qh(bs.nullAsNil(this.iAC));
      }
    }
    this.IwZ = ((EditText)findViewById(2131298627));
    Object localObject1 = new MMEditText.b()
    {
      public final void aQv()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    Object localObject2 = new j.a();
    ((j.a)localObject2).DFq = ((MMEditText.b)localObject1);
    this.IwZ.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.d(this.IwZ).acw(32).a(null);
    if ((this.contact != null) && (this.Ixa != 3))
    {
      if (this.Ixa == 4)
      {
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.Ixb), this.IwZ.getTextSize()));
        this.IwZ.setSelection(this.IwZ.getText().length());
      }
    }
    else
    {
      if (this.Ixa != 0) {
        break label1118;
      }
      setMMTitle(2131757731);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.contact.field_username);
      if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm().equals(this.IwZ.getText()))) {
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
      if ((this.IwZ == null) || (this.IwZ.getText().toString().trim().length() <= 0)) {
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
      this.Ixc = ((TextView)findViewById(2131298634));
      this.Ixd = ((EditText)findViewById(2131298626));
      this.Ixe = ((TextView)findViewById(2131307005));
      this.IuR = findViewById(2131298625);
      com.tencent.mm.ui.tools.b.c.d(this.Ixd).acw(800).a(null);
      this.Ixe.setText(f.cM(800, this.Ixd.getEditableText().toString()));
      this.Ixd.append(k.b(this, bs.nullAsNil(this.Ixf), this.Ixd.getTextSize()));
      this.Ixc.append(k.b(this, bs.nullAsNil(this.Ixf), this.Ixc.getTextSize()));
      if (this.wbZ != null)
      {
        this.Ixd.setText(k.b(this, bs.nullAsNil(this.wbZ.field_conDescription), this.Ixd.getTextSize()));
        this.Ixc.setText(k.b(this, bs.nullAsNil(this.wbZ.field_conDescription), this.Ixd.getTextSize()));
      }
      this.Ixd.addTextChangedListener(new b((byte)0));
      this.Ixc.setOnClickListener(new View.OnClickListener()
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
      if (!bs.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.Ixa == 0) && (!bs.isNullOrNil(this.iAC)))
        {
          this.IwZ.setText(k.b(this, this.iAC, this.IwZ.getTextSize()));
          break;
        }
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.contact.field_conRemark), this.IwZ.getTextSize()));
        break;
      }
      if (!bs.isNullOrNil(this.iAC))
      {
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.iAC), this.IwZ.getTextSize()));
        break;
      }
      if (!bs.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.Ixa == 0) && (!bs.isNullOrNil(this.Ixb)) && (!com.tencent.mm.n.b.ln(this.contact.field_type)))
        {
          this.IwZ.setText(k.b(this, bs.nullAsNil(this.Ixb), this.IwZ.getTextSize()));
          break;
        }
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.contact.field_nickname), this.IwZ.getTextSize()));
        break;
      }
      if (!bs.isNullOrNil(this.Ixb))
      {
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.Ixb), this.IwZ.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((bs.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label976;
        }
        this.IwZ.setText(k.b(this, bs.nullAsNil(this.contact.aaS()), this.IwZ.getTextSize()));
        break;
      }
      label976:
      this.IwZ.setText("");
      break;
      label988:
      this.IuP = ((TextView)findViewById(2131302425));
      this.IuQ = findViewById(2131302419);
      this.IuQ.setVisibility(0);
      this.IuP.setText(bs.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPm()), 0, ((l)localObject2).length(), 17);
      this.IuP.append(" ");
      this.IuP.append((CharSequence)localObject2);
      this.IuP.setMovementMethod(LinkMovementMethod.getInstance());
      break label326;
      label1118:
      if (this.Ixa == 3)
      {
        setMMTitle(2131764345);
        this.IwZ.setHint("");
        if (!bs.isNullOrNil(this.Ixb)) {
          this.IwZ.setText(this.Ixb);
        }
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131763093);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131302420).setVisibility(8);
        break label326;
      }
      if (this.Ixa != 4) {
        break label326;
      }
      setMMTitle(2131762651);
      this.IwZ.setHint("");
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
    this.iMg = getIntent().getIntExtra("Contact_Scene", 9);
    this.Ixa = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.Ixb = bs.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.iAC = bs.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.Ixg = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.Ixj = ((TextView)findViewById(2131298624));
    this.Ixi = findViewById(2131298622);
    int i;
    if (this.Ixa != 0)
    {
      this.Ixi.setVisibility(8);
      this.Ixj.setVisibility(8);
      this.IuZ = ((MMTagPanel)findViewById(2131298623));
      this.IuZ.setPanelClickable(false);
      this.Iva = ((TextView)findViewById(2131298621));
      this.Iva.setText(2131761304);
      this.IuZ.setOnClickListener(this.Ixh);
      this.Iva.setOnClickListener(this.Ixh);
      if ((this.contact == null) || (!ai.aNc(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.IwZ == null)
        {
          AppMethodBeat.o(37873);
          return;
          this.Ixi.setVisibility(0);
          this.Ixj.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.IwZ.getParent();
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
    az.ayM();
    this.wbZ = com.tencent.mm.model.c.awC().alK(this.drG);
    if (this.wbZ != null)
    {
      this.vJW = this.wbZ.field_contactLabels;
      this.vJn = ((ArrayList)com.tencent.mm.plugin.label.a.a.cWd().ajB(this.vJW));
    }
    if (!bs.isNullOrNil(this.vJW))
    {
      this.IuZ.setVisibility(0);
      this.Iva.setVisibility(8);
      if ((this.vJn != null) && (!this.vJn.isEmpty()))
      {
        this.IuZ.a(this.vJn, this.vJn);
        AppMethodBeat.o(37875);
      }
    }
    else
    {
      this.IuZ.setVisibility(8);
      this.Iva.setVisibility(0);
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37877);
    ac.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        ac.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
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
    private int xpu = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.xpu = f.cM(800, paramEditable.toString());
      if (this.xpu < 0) {
        this.xpu = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.xpu);
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
    public String iAC;
    
    public c(String paramString)
    {
      this.iAC = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(k.b(ModRemarkNameUI.this, bs.nullAsNil(this.iAC), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */