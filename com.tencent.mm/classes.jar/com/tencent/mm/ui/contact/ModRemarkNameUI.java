package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.tools.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.widget.MMEditText.b;
import java.util.ArrayList;

public class ModRemarkNameUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private TextView Aca;
  private View Acb;
  private View Acc;
  private TextView Ack;
  private EditText Aed;
  private int Aee;
  private String Aef;
  private TextView Aeg;
  private EditText Aeh;
  private TextView Aei;
  private String Aej;
  private boolean Aek;
  private ModRemarkNameUI.a Ael;
  private View Aem;
  private TextView Aen;
  private String cDt;
  private ad contact;
  private int gyR;
  private String hKa;
  private MMTagPanel pCL;
  private bv pRo;
  private ArrayList<String> pyL;
  private String pzu;
  
  public ModRemarkNameUI()
  {
    AppMethodBeat.i(33752);
    this.Aef = "";
    this.hKa = "";
    this.Aeg = null;
    this.Aeh = null;
    this.Aei = null;
    this.Aej = "";
    this.Aek = false;
    this.gyR = 9;
    this.Ael = new ModRemarkNameUI.a(this, (byte)0);
    AppMethodBeat.o(33752);
  }
  
  public int getLayoutId()
  {
    return 2130970295;
  }
  
  public void initView()
  {
    AppMethodBeat.i(33754);
    this.cDt = getIntent().getStringExtra("Contact_User");
    if ((this.cDt != null) && (this.cDt.length() > 0))
    {
      aw.aaz();
      this.contact = com.tencent.mm.model.c.YA().arw(this.cDt);
      aw.aaz();
      this.pRo = com.tencent.mm.model.c.YB().TM(this.cDt);
      if ((this.contact == null) || (ah.isNullOrNil(this.contact.field_username)))
      {
        this.contact = new ad(this.cDt);
        this.contact.jp(ah.nullAsNil(this.Aef));
        this.contact.jn(ah.nullAsNil(this.hKa));
      }
    }
    this.Aed = ((EditText)findViewById(2131823224));
    Object localObject1 = new ModRemarkNameUI.1(this);
    Object localObject2 = new g.a();
    ((g.a)localObject2).wff = ((MMEditText.b)localObject1);
    this.Aed.addTextChangedListener((TextWatcher)localObject2);
    com.tencent.mm.ui.tools.b.c.d(this.Aed).QS(100).a(null);
    if ((this.contact != null) && (this.Aee != 3))
    {
      if (this.Aee == 4)
      {
        this.Aed.setText(j.b(this, ah.nullAsNil(this.Aef), this.Aed.getTextSize()));
        this.Aed.setSelection(this.Aed.getText().length());
      }
    }
    else
    {
      if (this.Aee != 0) {
        break label1118;
      }
      setMMTitle(2131298670);
      localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.contact.field_username);
      if ((localObject1 != null) && (!ah.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ())) && (!((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ().equals(this.Aed.getText()))) {
        break label988;
      }
      label326:
      addTextOptionMenu(0, getString(2131297063), new ModRemarkNameUI.2(this));
      if ((this.Aed == null) || (this.Aed.getText().toString().trim().length() <= 0)) {
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
          AppMethodBeat.i(33746);
          ModRemarkNameUI.this.finish();
          AppMethodBeat.o(33746);
          return true;
        }
      });
      this.Aeg = ((TextView)findViewById(2131823235));
      this.Aeh = ((EditText)findViewById(2131823233));
      this.Aei = ((TextView)findViewById(2131823234));
      this.Acc = findViewById(2131823232);
      com.tencent.mm.ui.tools.b.c.d(this.Aeh).QS(800).a(null);
      this.Aei.setText(com.tencent.mm.ui.tools.f.bO(800, this.Aeh.getEditableText().toString()));
      this.Aeh.append(j.b(this, ah.nullAsNil(this.Aej), this.Aeh.getTextSize()));
      this.Aeg.append(j.b(this, ah.nullAsNil(this.Aej), this.Aeg.getTextSize()));
      if (this.pRo != null)
      {
        this.Aeh.setText(j.b(this, ah.nullAsNil(this.pRo.field_conDescription), this.Aeh.getTextSize()));
        this.Aeg.setText(j.b(this, ah.nullAsNil(this.pRo.field_conDescription), this.Aeh.getTextSize()));
      }
      this.Aeh.addTextChangedListener(new ModRemarkNameUI.b(this, (byte)0));
      this.Aeg.setOnClickListener(new ModRemarkNameUI.4(this));
      AppMethodBeat.o(33754);
      return;
      if (!ah.isNullOrNil(this.contact.field_conRemark))
      {
        if ((this.Aee == 0) && (!ah.isNullOrNil(this.hKa)))
        {
          this.Aed.setText(j.b(this, this.hKa, this.Aed.getTextSize()));
          break;
        }
        this.Aed.setText(j.b(this, ah.nullAsNil(this.contact.field_conRemark), this.Aed.getTextSize()));
        break;
      }
      if (!ah.isNullOrNil(this.hKa))
      {
        this.Aed.setText(j.b(this, ah.nullAsNil(this.hKa), this.Aed.getTextSize()));
        break;
      }
      if (!ah.isNullOrNil(this.contact.field_nickname))
      {
        if ((this.Aee == 0) && (!ah.isNullOrNil(this.Aef)) && (!com.tencent.mm.n.a.je(this.contact.field_type)))
        {
          this.Aed.setText(j.b(this, ah.nullAsNil(this.Aef), this.Aed.getTextSize()));
          break;
        }
        this.Aed.setText(j.b(this, ah.nullAsNil(this.contact.field_nickname), this.Aed.getTextSize()));
        break;
      }
      if (!ah.isNullOrNil(this.Aef))
      {
        this.Aed.setText(j.b(this, ah.nullAsNil(this.Aef), this.Aed.getTextSize()));
        break;
      }
      localObject1 = this.contact.field_nickname;
      if ((ah.isNullOrNil((String)localObject1)) || (((String)localObject1).length() > 50)) {}
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label976;
        }
        this.Aed.setText(j.b(this, ah.nullAsNil(this.contact.Of()), this.Aed.getTextSize()));
        break;
      }
      label976:
      this.Aed.setText("");
      break;
      label988:
      this.Aca = ((TextView)findViewById(2131823227));
      this.Acb = findViewById(2131823226);
      this.Acb.setVisibility(0);
      this.Aca.setText(ah.nullAsNil(getString(2131298753, new Object[] { ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ() })));
      localObject2 = new k(getString(2131305994));
      ((k)localObject2).setSpan(new ModRemarkNameUI.c(this, ((com.tencent.mm.plugin.account.friend.a.a)localObject1).apZ()), 0, ((k)localObject2).length(), 17);
      this.Aca.append(" ");
      this.Aca.append((CharSequence)localObject2);
      this.Aca.setMovementMethod(LinkMovementMethod.getInstance());
      break label326;
      label1118:
      if (this.Aee == 3)
      {
        setMMTitle(2131304227);
        this.Aed.setHint("");
        if (!ah.isNullOrNil(this.Aef)) {
          this.Aed.setText(this.Aef);
        }
        localObject1 = (TextView)findViewById(2131823223);
        ((TextView)localObject1).setText(2131303137);
        ((TextView)localObject1).setVisibility(0);
        findViewById(2131826324).setVisibility(8);
        break label326;
      }
      if (this.Aee != 4) {
        break label326;
      }
      setMMTitle(2131302740);
      this.Aed.setHint("");
      localObject1 = (TextView)findViewById(2131823223);
      ((TextView)localObject1).setText(2131302790);
      ((TextView)localObject1).setVisibility(0);
      break label326;
      label1251:
      enableOptionMenu(false);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(33753);
    super.onCreate(paramBundle);
    this.gyR = getIntent().getIntExtra("Contact_Scene", 9);
    this.Aee = getIntent().getIntExtra("Contact_mode_name_type", 0);
    this.Aef = ah.nullAsNil(getIntent().getStringExtra("Contact_Nick"));
    this.hKa = ah.nullAsNil(getIntent().getStringExtra("Contact_RemarkName"));
    this.Aek = getIntent().getBooleanExtra("Contact_ModStrangerRemark", true);
    initView();
    this.Aen = ((TextView)findViewById(2131823228));
    this.Aem = findViewById(2131826323);
    int i;
    if (this.Aee != 0)
    {
      this.Aem.setVisibility(8);
      this.Aen.setVisibility(8);
      this.pCL = ((MMTagPanel)findViewById(2131823230));
      this.pCL.setPanelClickable(false);
      this.Ack = ((TextView)findViewById(2131823229));
      this.Ack.setText(2131301604);
      this.pCL.setOnClickListener(this.Ael);
      this.Ack.setOnClickListener(this.Ael);
      if ((this.contact == null) || (!ad.arf(this.contact.field_username))) {
        break label274;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.Aed == null)
        {
          AppMethodBeat.o(33753);
          return;
          this.Aem.setVisibility(0);
          this.Aen.setVisibility(0);
          break;
          label274:
          i = 0;
          continue;
        }
        paramBundle = (ViewGroup)this.Aed.getParent();
        int k = paramBundle.getChildCount();
        i = j;
        while (i < k)
        {
          View localView = paramBundle.getChildAt(i);
          j = localView.getId();
          if ((j != 2131823223) && (j != 2131823224)) {
            localView.setVisibility(8);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(33753);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33758);
    super.onDestroy();
    AppMethodBeat.o(33758);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33755);
    super.onResume();
    aw.aaz();
    this.pRo = com.tencent.mm.model.c.YB().TM(this.cDt);
    if (this.pRo != null)
    {
      this.pzu = this.pRo.field_contactLabels;
      this.pyL = ((ArrayList)com.tencent.mm.plugin.label.a.a.bKV().RP(this.pzu));
    }
    if (!ah.isNullOrNil(this.pzu))
    {
      this.pCL.setVisibility(0);
      this.Ack.setVisibility(8);
      if ((this.pyL != null) && (!this.pyL.isEmpty()))
      {
        this.pCL.a(this.pyL, this.pyL);
        AppMethodBeat.o(33755);
      }
    }
    else
    {
      this.pCL.setVisibility(8);
      this.Ack.setVisibility(0);
    }
    AppMethodBeat.o(33755);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(33759);
    ab.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (paramm.getType() == 44)
    {
      if ((paramInt1 != 0) && (paramInt2 < 0))
      {
        ab.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
        Toast.makeText(this, getString(2131302779, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
      }
      finish();
    }
    AppMethodBeat.o(33759);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ModRemarkNameUI
 * JD-Core Version:    0.7.0.1
 */