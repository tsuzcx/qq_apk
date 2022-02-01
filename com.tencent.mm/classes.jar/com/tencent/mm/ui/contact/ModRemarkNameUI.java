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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private TextView KHP;
  private View KHQ;
  private View KHR;
  private MMTagPanel KHZ;
  private TextView KIa;
  private EditText KKb;
  private int KKc;
  private String KKd;
  private TextView KKe;
  private EditText KKf;
  private TextView KKg;
  private String KKh;
  private boolean KKi;
  private a KKj;
  private View KKk;
  private TextView KKl;
  private an contact;
  private String dED;
  private String iWF;
  private int jij;
  private String xgW;
  private ArrayList<String> xgn;
  private cg xzF;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.KKd = "";
    this.iWF = "";
    this.KKe = null;
    this.KKf = null;
    this.KKg = null;
    this.KKh = "";
    this.KKi = false;
    this.jij = 9;
    this.KKj = new a((byte)0);
    AppMethodBeat.o(37872);
  }
  
  public int getLayoutId()
  {
    return 2131494938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.dED = getIntent().getStringExtra("Contact_User");
    if ((this.dED != null) && (this.dED.length() > 0))
    {
      bc.aCg();
      this.contact = com.tencent.mm.model.c.azF().BH(this.dED);
      bc.aCg();
      this.xzF = com.tencent.mm.model.c.azG().arE(this.dED);
      if ((this.contact == null) || (bu.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new an(this.dED);
        this.contact.to(bu.nullAsNil(this.KKd));
        this.contact.tm(bu.nullAsNil(this.iWF));
      }
    }
    this.KKb = ((EditText)findViewById(2131298627));
    Object localObject1 = new MMEditText.b()
    {
      public final void aUg()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    Object localObject2 = new j.a();
    ((j.a)localObject2).FCT = ((MMEditText.b)localObject1);
    this.KKb.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.d(this.KKb).afD(32).a(null);
    if ((this.contact != null) && (this.KKc != 3))
    {
      if (this.KKc == 4)
      {
        this.KKb.setText(k.b(this, bu.nullAsNil(this.KKd), this.KKb.getTextSize()));
        this.KKb.setSelection(this.KKb.getText().length());
      }
    }
    else
    {
      if ((this.KKc != 0) || (an.aji(this.dED))) {
        break label1128;
      }
      setMMTitle(2131757731);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.contact.field_username);
      if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX().equals(this.KKb.getText()))) {
        break label998;
      }
      label336:
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
      if ((this.KKb == null) || (this.KKb.getText().toString().trim().length() <= 0)) {
        break label1293;
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
      this.KKe = ((TextView)findViewById(2131298634));
      this.KKf = ((EditText)findViewById(2131298626));
      this.KKg = ((TextView)findViewById(2131307005));
      this.KHR = findViewById(2131298625);
      com.tencent.mm.ui.tools.b.c.d(this.KKf).afD(800).a(null);
      this.KKg.setText(com.tencent.mm.ui.tools.f.cU(800, this.KKf.getEditableText().toString()));
      this.KKf.append(k.b(this, bu.nullAsNil(this.KKh), this.KKf.getTextSize()));
      this.KKe.append(k.b(this, bu.nullAsNil(this.KKh), this.KKe.getTextSize()));
      if (this.xzF != null)
      {
        this.KKf.setText(k.b(this, bu.nullAsNil(this.xzF.field_conDescription), this.KKf.getTextSize()));
        this.KKe.setText(k.b(this, bu.nullAsNil(this.xzF.field_conDescription), this.KKf.getTextSize()));
      }
      this.KKf.addTextChangedListener(new b((byte)0));
      this.KKe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ModRemarkNameUI.f(ModRemarkNameUI.this).setVisibility(0);
          ModRemarkNameUI.g(ModRemarkNameUI.this).setVisibility(8);
          ModRemarkNameUI.h(ModRemarkNameUI.this).requestFocus();
          ModRemarkNameUI.this.showVKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37867);
        }
      });
      AppMethodBeat.o(37874);
      return;
      if (!bu.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.KKc == 0) && (!bu.isNullOrNil(this.iWF)))
        {
          this.KKb.setText(k.b(this, this.iWF, this.KKb.getTextSize()));
          break;
        }
        this.KKb.setText(k.b(this, bu.nullAsNil(this.contact.field_conRemark), this.KKb.getTextSize()));
        break;
      }
      if (!bu.isNullOrNil(this.iWF))
      {
        this.KKb.setText(k.b(this, bu.nullAsNil(this.iWF), this.KKb.getTextSize()));
        break;
      }
      if (!bu.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.KKc == 0) && (!bu.isNullOrNil(this.KKd)) && (!com.tencent.mm.contact.c.lO(this.contact.field_type)))
        {
          this.KKb.setText(k.b(this, bu.nullAsNil(this.KKd), this.KKb.getTextSize()));
          break;
        }
        this.KKb.setText(k.b(this, bu.nullAsNil(this.contact.field_nickname), this.KKb.getTextSize()));
        break;
      }
      if (!bu.isNullOrNil(this.KKd))
      {
        this.KKb.setText(k.b(this, bu.nullAsNil(this.KKd), this.KKb.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((bu.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label986;
        }
        this.KKb.setText(k.b(this, bu.nullAsNil(this.contact.adG()), this.KKb.getTextSize()));
        break;
      }
      label986:
      this.KKb.setText("");
      break;
      label998:
      this.KHP = ((TextView)findViewById(2131302425));
      this.KHQ = findViewById(2131302419);
      this.KHQ.setVisibility(0);
      this.KHP.setText(bu.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSX()), 0, ((l)localObject2).length(), 17);
      this.KHP.append(" ");
      this.KHP.append((CharSequence)localObject2);
      this.KHP.setMovementMethod(LinkMovementMethod.getInstance());
      break label336;
      label1128:
      if (this.KKc == 3)
      {
        setMMTitle(2131764345);
        this.KKb.setHint("");
        if (!bu.isNullOrNil(this.KKd)) {
          this.KKb.setText(this.KKd);
        }
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131763093);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131302420).setVisibility(8);
        break label336;
      }
      if (this.KKc == 4)
      {
        setMMTitle(2131762651);
        this.KKb.setHint("");
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131762702);
        ((TextView)localObject1).setVisibility(0);
        break label336;
      }
      if (!an.aji(this.dED)) {
        break label336;
      }
      setMMTitle(2131764345);
      findViewById(2131301288).setVisibility(8);
      break label336;
      label1293:
      enableOptionMenu(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(37873);
    super.onCreate(paramBundle);
    this.jij = getIntent().getIntExtra("Contact_Scene", 9);
    this.KKc = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.KKd = bu.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.iWF = bu.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.KKi = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.KKl = ((TextView)findViewById(2131298624));
    this.KKk = findViewById(2131298622);
    int i;
    if (this.KKc != 0)
    {
      this.KKk.setVisibility(8);
      this.KKl.setVisibility(8);
      this.KHZ = ((MMTagPanel)findViewById(2131298623));
      this.KHZ.setPanelClickable(false);
      this.KIa = ((TextView)findViewById(2131298621));
      this.KIa.setText(2131761304);
      this.KHZ.setOnClickListener(this.KKj);
      this.KIa.setOnClickListener(this.KKj);
      if ((this.contact == null) || (!an.aUq(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.KKb == null)
        {
          AppMethodBeat.o(37873);
          return;
          this.KKk.setVisibility(0);
          this.KKl.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.KKb.getParent();
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
    bc.aCg();
    this.xzF = com.tencent.mm.model.c.azG().arE(this.dED);
    if (this.xzF != null)
    {
      this.xgW = this.xzF.field_contactLabels;
      this.xgn = ((ArrayList)com.tencent.mm.plugin.label.a.a.dig().app(this.xgW));
    }
    if (!bu.isNullOrNil(this.xgW))
    {
      this.KHZ.setVisibility(0);
      this.KIa.setVisibility(8);
      if ((this.xgn != null) && (!this.xgn.isEmpty()))
      {
        this.KHZ.a(this.xgn, this.xgn);
        AppMethodBeat.o(37875);
      }
    }
    else
    {
      this.KHZ.setVisibility(8);
      this.KIa.setVisibility(0);
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(37877);
    ae.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramn.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        ae.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
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
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ModRemarkNameUI.k(ModRemarkNameUI.this);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37868);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private int yUc = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.yUc = com.tencent.mm.ui.tools.f.cU(800, paramEditable.toString());
      if (this.yUc < 0) {
        this.yUc = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.yUc);
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
    public String iWF;
    
    public c(String paramString)
    {
      this.iWF = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(k.b(ModRemarkNameUI.this, bu.nullAsNil(this.iWF), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
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