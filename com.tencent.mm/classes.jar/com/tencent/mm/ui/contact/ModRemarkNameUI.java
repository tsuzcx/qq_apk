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
import com.tencent.mm.model.ba;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private MMTagPanel KlF;
  private TextView KlG;
  private TextView Klv;
  private View Klw;
  private View Klx;
  private EditText KnH;
  private int KnI;
  private String KnJ;
  private TextView KnK;
  private EditText KnL;
  private TextView KnM;
  private String KnN;
  private boolean KnO;
  private a KnP;
  private View KnQ;
  private TextView KnR;
  private am contact;
  private String dDy;
  private String iTM;
  private int jfq;
  private ArrayList<String> wQw;
  private String wRf;
  private cf xjI;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.KnJ = "";
    this.iTM = "";
    this.KnK = null;
    this.KnL = null;
    this.KnM = null;
    this.KnN = "";
    this.KnO = false;
    this.jfq = 9;
    this.KnP = new a((byte)0);
    AppMethodBeat.o(37872);
  }
  
  public int getLayoutId()
  {
    return 2131494938;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.dDy = getIntent().getStringExtra("Contact_User");
    if ((this.dDy != null) && (this.dDy.length() > 0))
    {
      ba.aBQ();
      this.contact = com.tencent.mm.model.c.azp().Bf(this.dDy);
      ba.aBQ();
      this.xjI = com.tencent.mm.model.c.azq().aqz(this.dDy);
      if ((this.contact == null) || (bt.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new am(this.dDy);
        this.contact.sT(bt.nullAsNil(this.KnJ));
        this.contact.sR(bt.nullAsNil(this.iTM));
      }
    }
    this.KnH = ((EditText)findViewById(2131298627));
    Object localObject1 = new MMEditText.b()
    {
      public final void aTH()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    Object localObject2 = new j.a();
    ((j.a)localObject2).Fkv = ((MMEditText.b)localObject1);
    this.KnH.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.d(this.KnH).aeU(32).a(null);
    if ((this.contact != null) && (this.KnI != 3))
    {
      if (this.KnI == 4)
      {
        this.KnH.setText(k.b(this, bt.nullAsNil(this.KnJ), this.KnH.getTextSize()));
        this.KnH.setSelection(this.KnH.getText().length());
      }
    }
    else
    {
      if ((this.KnI != 0) || (am.ail(this.dDy))) {
        break label1128;
      }
      setMMTitle(2131757731);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.contact.field_username);
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy().equals(this.KnH.getText()))) {
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
      if ((this.KnH == null) || (this.KnH.getText().toString().trim().length() <= 0)) {
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
      this.KnK = ((TextView)findViewById(2131298634));
      this.KnL = ((EditText)findViewById(2131298626));
      this.KnM = ((TextView)findViewById(2131307005));
      this.Klx = findViewById(2131298625);
      com.tencent.mm.ui.tools.b.c.d(this.KnL).aeU(800).a(null);
      this.KnM.setText(com.tencent.mm.ui.tools.f.cU(800, this.KnL.getEditableText().toString()));
      this.KnL.append(k.b(this, bt.nullAsNil(this.KnN), this.KnL.getTextSize()));
      this.KnK.append(k.b(this, bt.nullAsNil(this.KnN), this.KnK.getTextSize()));
      if (this.xjI != null)
      {
        this.KnL.setText(k.b(this, bt.nullAsNil(this.xjI.field_conDescription), this.KnL.getTextSize()));
        this.KnK.setText(k.b(this, bt.nullAsNil(this.xjI.field_conDescription), this.KnL.getTextSize()));
      }
      this.KnL.addTextChangedListener(new b((byte)0));
      this.KnK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
      if (!bt.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.KnI == 0) && (!bt.isNullOrNil(this.iTM)))
        {
          this.KnH.setText(k.b(this, this.iTM, this.KnH.getTextSize()));
          break;
        }
        this.KnH.setText(k.b(this, bt.nullAsNil(this.contact.field_conRemark), this.KnH.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.iTM))
      {
        this.KnH.setText(k.b(this, bt.nullAsNil(this.iTM), this.KnH.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.KnI == 0) && (!bt.isNullOrNil(this.KnJ)) && (!com.tencent.mm.o.b.lM(this.contact.field_type)))
        {
          this.KnH.setText(k.b(this, bt.nullAsNil(this.KnJ), this.KnH.getTextSize()));
          break;
        }
        this.KnH.setText(k.b(this, bt.nullAsNil(this.contact.field_nickname), this.KnH.getTextSize()));
        break;
      }
      if (!bt.isNullOrNil(this.KnJ))
      {
        this.KnH.setText(k.b(this, bt.nullAsNil(this.KnJ), this.KnH.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((bt.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label986;
        }
        this.KnH.setText(k.b(this, bt.nullAsNil(this.contact.adv()), this.KnH.getTextSize()));
        break;
      }
      label986:
      this.KnH.setText("");
      break;
      label998:
      this.Klv = ((TextView)findViewById(2131302425));
      this.Klw = findViewById(2131302419);
      this.Klw.setVisibility(0);
      this.Klv.setText(bt.nullAsNil(getString(2131757816, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy() })));
      localObject2 = new l(getString(2131766242));
      ((l)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSy()), 0, ((l)localObject2).length(), 17);
      this.Klv.append(" ");
      this.Klv.append((CharSequence)localObject2);
      this.Klv.setMovementMethod(LinkMovementMethod.getInstance());
      break label336;
      label1128:
      if (this.KnI == 3)
      {
        setMMTitle(2131764345);
        this.KnH.setHint("");
        if (!bt.isNullOrNil(this.KnJ)) {
          this.KnH.setText(this.KnJ);
        }
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131763093);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131302420).setVisibility(8);
        break label336;
      }
      if (this.KnI == 4)
      {
        setMMTitle(2131762651);
        this.KnH.setHint("");
        localObject1 = (TextView)findViewById(2131298628);
        ((TextView)localObject1).setText(2131762702);
        ((TextView)localObject1).setVisibility(0);
        break label336;
      }
      if (!am.ail(this.dDy)) {
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
    this.jfq = getIntent().getIntExtra("Contact_Scene", 9);
    this.KnI = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.KnJ = bt.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.iTM = bt.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.KnO = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.KnR = ((TextView)findViewById(2131298624));
    this.KnQ = findViewById(2131298622);
    int i;
    if (this.KnI != 0)
    {
      this.KnQ.setVisibility(8);
      this.KnR.setVisibility(8);
      this.KlF = ((MMTagPanel)findViewById(2131298623));
      this.KlF.setPanelClickable(false);
      this.KlG = ((TextView)findViewById(2131298621));
      this.KlG.setText(2131761304);
      this.KlF.setOnClickListener(this.KnP);
      this.KlG.setOnClickListener(this.KnP);
      if ((this.contact == null) || (!am.aSQ(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.KnH == null)
        {
          AppMethodBeat.o(37873);
          return;
          this.KnQ.setVisibility(0);
          this.KnR.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.KnH.getParent();
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
    ba.aBQ();
    this.xjI = com.tencent.mm.model.c.azq().aqz(this.dDy);
    if (this.xjI != null)
    {
      this.wRf = this.xjI.field_contactLabels;
      this.wQw = ((ArrayList)com.tencent.mm.plugin.label.a.a.dfo().aon(this.wRf));
    }
    if (!bt.isNullOrNil(this.wRf))
    {
      this.KlF.setVisibility(0);
      this.KlG.setVisibility(8);
      if ((this.wQw != null) && (!this.wQw.isEmpty()))
      {
        this.KlF.a(this.wQw, this.wQw);
        AppMethodBeat.o(37875);
      }
    }
    else
    {
      this.KlF.setVisibility(8);
      this.KlG.setVisibility(0);
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
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
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ModRemarkNameUI.k(ModRemarkNameUI.this);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37868);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private int yDX = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.yDX = com.tencent.mm.ui.tools.f.cU(800, paramEditable.toString());
      if (this.yDX < 0) {
        this.yDX = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.yDX);
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
    public String iTM;
    
    public c(String paramString)
    {
      this.iTM = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(k.b(ModRemarkNameUI.this, bt.nullAsNil(this.iTM), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
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