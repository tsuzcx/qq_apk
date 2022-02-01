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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.tools.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements i
{
  private String BeJ;
  private ArrayList<String> Bea;
  private cn BzG;
  private TextView PUO;
  private View PUP;
  private MMTagPanel PUX;
  private TextView PUY;
  private EditText PXc;
  private int PXd;
  private String PXe;
  private TextView PXf;
  private EditText PXg;
  private TextView PXh;
  private String PXi;
  private boolean PXj;
  private a PXk;
  private View PXl;
  private TextView PXm;
  private as contact;
  private String dWq;
  private int kgm;
  private String remark;
  private View uhh;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(37872);
    this.PXe = "";
    this.remark = "";
    this.PXf = null;
    this.PXg = null;
    this.PXh = null;
    this.PXi = "";
    this.PXj = false;
    this.kgm = 9;
    this.PXk = new a((byte)0);
    AppMethodBeat.o(37872);
  }
  
  public int getLayoutId()
  {
    return 2131495680;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37874);
    this.dWq = getIntent().getStringExtra("Contact_User");
    if ((this.dWq != null) && (this.dWq.length() > 0))
    {
      bg.aVF();
      this.contact = com.tencent.mm.model.c.aSN().Kn(this.dWq);
      bg.aVF();
      this.BzG = com.tencent.mm.model.c.aSO().aEZ(this.dWq);
      if ((this.contact == null) || (Util.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new as(this.dWq);
        this.contact.setNickname(Util.nullAsNil(this.PXe));
        this.contact.BD(Util.nullAsNil(this.remark));
      }
    }
    this.PXc = ((EditText)findViewById(2131299064));
    Object localObject1 = new MMEditText.b()
    {
      public final void boS()
      {
        AppMethodBeat.i(37864);
        if (ModRemarkNameUI.a(ModRemarkNameUI.this).getText().toString().trim().length() > 0) {
          ModRemarkNameUI.this.enableOptionMenu(true);
        }
        AppMethodBeat.o(37864);
      }
    };
    Object localObject2 = new l.a();
    ((l.a)localObject2).KvR = ((MMEditText.b)localObject1);
    this.PXc.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.f(this.PXc).aoq(32).a(null);
    if ((this.contact != null) && (this.PXd != 3))
    {
      if (this.PXd == 4)
      {
        this.PXc.setText(l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
        this.PXc.setSelection(this.PXc.getText().length());
      }
    }
    else
    {
      if ((this.PXd != 0) || (as.avl(this.dWq))) {
        break label1128;
      }
      setMMTitle(2131757968);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK().equals(this.PXc.getText()))) {
        break label998;
      }
      label336:
      addTextOptionMenu(0, getString(2131755970), new MenuItem.OnMenuItemClickListener()
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
      if ((this.PXc == null) || (this.PXc.getText().toString().trim().length() <= 0)) {
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
      this.PXf = ((TextView)findViewById(2131299071));
      this.PXg = ((EditText)findViewById(2131299063));
      this.PXh = ((TextView)findViewById(2131310528));
      this.uhh = findViewById(2131299062);
      com.tencent.mm.ui.tools.b.c.f(this.PXg).aoq(800).a(null);
      this.PXh.setText(f.dp(800, this.PXg.getEditableText().toString()));
      this.PXg.append(l.b(this, Util.nullAsNil(this.PXi), this.PXg.getTextSize()));
      this.PXf.append(l.b(this, Util.nullAsNil(this.PXi), this.PXf.getTextSize()));
      if (this.BzG != null)
      {
        this.PXg.setText(l.b(this, Util.nullAsNil(this.BzG.field_conDescription), this.PXg.getTextSize()));
        this.PXf.setText(l.b(this, Util.nullAsNil(this.BzG.field_conDescription), this.PXg.getTextSize()));
      }
      this.PXg.addTextChangedListener(new b((byte)0));
      this.PXf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37867);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      if (!Util.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.PXd == 0) && (!Util.isNullOrNil(this.remark)))
        {
          this.PXc.setText(l.b(this, this.remark, this.PXc.getTextSize()));
          break;
        }
        this.PXc.setText(l.b(this, Util.nullAsNil(this.contact.field_conRemark), this.PXc.getTextSize()));
        break;
      }
      if (!Util.isNullOrNil(this.remark))
      {
        this.PXc.setText(l.b(this, Util.nullAsNil(this.remark), this.PXc.getTextSize()));
        break;
      }
      if (!Util.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.PXd == 0) && (!Util.isNullOrNil(this.PXe)) && (!com.tencent.mm.contact.c.oR(this.contact.field_type)))
        {
          this.PXc.setText(l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
          break;
        }
        this.PXc.setText(l.b(this, Util.nullAsNil(this.contact.field_nickname), this.PXc.getTextSize()));
        break;
      }
      if (!Util.isNullOrNil(this.PXe))
      {
        this.PXc.setText(l.b(this, Util.nullAsNil(this.PXe), this.PXc.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((Util.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label986;
        }
        this.PXc.setText(l.b(this, Util.nullAsNil(this.contact.arJ()), this.PXc.getTextSize()));
        break;
      }
      label986:
      this.PXc.setText("");
      break;
      label998:
      this.PUO = ((TextView)findViewById(2131304824));
      this.PUP = findViewById(2131304816);
      this.PUP.setVisibility(0);
      this.PUO.setText(Util.nullAsNil(getString(2131758056, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK() })));
      localObject2 = new m(getString(2131768753));
      ((m)localObject2).setSpan(new c(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnK()), 0, ((m)localObject2).length(), 17);
      this.PUO.append(" ");
      this.PUO.append((CharSequence)localObject2);
      this.PUO.setMovementMethod(LinkMovementMethod.getInstance());
      break label336;
      label1128:
      if (this.PXd == 3)
      {
        setMMTitle(2131766604);
        this.PXc.setHint("");
        if (!Util.isNullOrNil(this.PXe)) {
          this.PXc.setText(this.PXe);
        }
        localObject1 = (TextView)findViewById(2131299065);
        ((TextView)localObject1).setText(2131765255);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131304817).setVisibility(8);
        break label336;
      }
      if (this.PXd == 4)
      {
        setMMTitle(2131764734);
        this.PXc.setHint("");
        localObject1 = (TextView)findViewById(2131299065);
        ((TextView)localObject1).setText(2131764785);
        ((TextView)localObject1).setVisibility(0);
        break label336;
      }
      if (!as.avl(this.dWq)) {
        break label336;
      }
      setMMTitle(2131766604);
      findViewById(2131302985).setVisibility(8);
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
    this.kgm = getIntent().getIntExtra("Contact_Scene", 9);
    this.PXd = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.PXe = Util.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.remark = Util.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.PXj = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.PXm = ((TextView)findViewById(2131299061));
    this.PXl = findViewById(2131299059);
    int i;
    if (this.PXd != 0)
    {
      this.PXl.setVisibility(8);
      this.PXm.setVisibility(8);
      this.PUX = ((MMTagPanel)findViewById(2131299060));
      this.PUX.setPanelClickable(false);
      this.PUY = ((TextView)findViewById(2131299058));
      this.PUY.setText(2131763130);
      this.PUX.setOnClickListener(this.PXk);
      this.PUY.setOnClickListener(this.PXk);
      if ((this.contact == null) || (!as.bjp(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.PXc == null)
        {
          AppMethodBeat.o(37873);
          return;
          this.PXl.setVisibility(0);
          this.PXm.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.PXc.getParent();
        int k = paramBundle.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = paramBundle.getChildAt(i);
          j = localView.getId();
          if ((j != 2131299065) && (j != 2131299064)) {
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
    bg.aVF();
    this.BzG = com.tencent.mm.model.c.aSO().aEZ(this.dWq);
    if (this.BzG != null)
    {
      this.BeJ = this.BzG.field_contactLabels;
      this.Bea = ((ArrayList)com.tencent.mm.plugin.label.a.a.ecg().aCI(this.BeJ));
    }
    if (!Util.isNullOrNil(this.BeJ))
    {
      this.PUX.setVisibility(0);
      this.PUY.setVisibility(8);
      if ((this.Bea != null) && (!this.Bea.isEmpty()))
      {
        this.PUX.a(this.Bea, this.Bea);
        AppMethodBeat.o(37875);
      }
    }
    else
    {
      this.PUX.setVisibility(8);
      this.PUY.setVisibility(0);
    }
    AppMethodBeat.o(37875);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37877);
    Log.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramq.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        Log.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(2131764774, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
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
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      ModRemarkNameUI.k(ModRemarkNameUI.this);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ModRemarkNameUI$LabelEditOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37868);
    }
  }
  
  final class b
    implements TextWatcher
  {
    private int CYV = 800;
    
    private b() {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(37869);
      this.CYV = f.dp(800, paramEditable.toString());
      if (this.CYV < 0) {
        this.CYV = 0;
      }
      if (ModRemarkNameUI.i(ModRemarkNameUI.this) != null) {
        ModRemarkNameUI.i(ModRemarkNameUI.this).setText(this.CYV);
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
    public String remark;
    
    public c(String paramString)
    {
      this.remark = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(37870);
      ModRemarkNameUI.a(ModRemarkNameUI.this).setText(l.b(ModRemarkNameUI.this, Util.nullAsNil(this.remark), ModRemarkNameUI.a(ModRemarkNameUI.this).getTextSize()));
      ModRemarkNameUI.a(ModRemarkNameUI.this).setSelection(ModRemarkNameUI.a(ModRemarkNameUI.this).getText().length());
      ModRemarkNameUI.l(ModRemarkNameUI.this).setVisibility(8);
      AppMethodBeat.o(37870);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(37871);
      paramTextPaint.setColor(ModRemarkNameUI.this.getResources().getColor(2131100053));
      paramTextPaint.setUnderlineText(false);
      AppMethodBeat.o(37871);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */