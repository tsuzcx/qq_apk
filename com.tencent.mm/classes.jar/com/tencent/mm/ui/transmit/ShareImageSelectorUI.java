package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import java.util.ArrayList;

public class ShareImageSelectorUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  private static int Hxg = 1;
  private int GYc;
  private String HuH;
  private a Hxh;
  private Dialog Hxi;
  private View.OnClickListener Hxj;
  private ImageView kPl;
  private ap mHandler;
  private ListView mListView;
  private View oCR;
  
  public ShareImageSelectorUI()
  {
    AppMethodBeat.i(39464);
    this.GYc = 2;
    this.Hxj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39454);
        ShareImageSelectorUI.a(ShareImageSelectorUI.this);
        AppMethodBeat.o(39454);
      }
    };
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(39455);
        ShareImageSelectorUI.this.finish();
        AppMethodBeat.o(39455);
      }
    };
    AppMethodBeat.o(39464);
  }
  
  private void cJV()
  {
    AppMethodBeat.i(39470);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131757975), getString(2131757977), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(39457);
        ShareImageSelectorUI.this.finish();
        AppMethodBeat.o(39457);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(39458);
        if (ShareImageSelectorUI.Hxg == 1) {
          ShareImageSelectorUI.c(ShareImageSelectorUI.this);
        }
        AppMethodBeat.o(39458);
      }
    });
    AppMethodBeat.o(39470);
  }
  
  private void feA()
  {
    AppMethodBeat.i(39474);
    cs localcs = new cs();
    g.a(localcs, 6, this.HuH);
    localcs.deQ.activity = this;
    localcs.deQ.deW = 52;
    com.tencent.mm.sdk.b.a.ESL.l(localcs);
    com.tencent.mm.plugin.report.service.h.vKh.f(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(0, 800L);
    }
    AppMethodBeat.o(39474);
  }
  
  private void fex()
  {
    AppMethodBeat.i(39471);
    if ((this.Hxi != null) && (this.Hxi.isShowing()))
    {
      AppMethodBeat.o(39471);
      return;
    }
    String str1 = getString(2131757979);
    String str2 = getString(2131757980);
    String str3 = getString(2131757978);
    AppCompatActivity localAppCompatActivity = getContext();
    String str4 = getString(2131761221);
    h.c local6 = new h.c()
    {
      public final void kM(int paramAnonymousInt)
      {
        AppMethodBeat.i(39459);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(39459);
          return;
          ShareImageSelectorUI.d(ShareImageSelectorUI.this);
          AppMethodBeat.o(39459);
          return;
          ShareImageSelectorUI.e(ShareImageSelectorUI.this);
          AppMethodBeat.o(39459);
          return;
          ShareImageSelectorUI.f(ShareImageSelectorUI.this);
        }
      }
    };
    new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(39460);
        ShareImageSelectorUI.b(ShareImageSelectorUI.this);
        AppMethodBeat.o(39460);
      }
    };
    this.Hxi = com.tencent.mm.ui.base.h.c(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6);
    AppMethodBeat.o(39471);
  }
  
  private void fey()
  {
    AppMethodBeat.i(39472);
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.GWI);
    localIntent.putExtra("titile", getString(2131755230));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.HuH);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(39472);
  }
  
  private void fez()
  {
    AppMethodBeat.i(39473);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.HuH);
    localIntent.putExtra("need_result", true);
    d.b(getContext(), "sns", ".ui.SnsUploadUI", localIntent, 1002);
    AppMethodBeat.o(39473);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495427;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39468);
    ad.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ad.w("MicroMsg.ShareImageSelectorUI", "unknow result");
      AppMethodBeat.o(39468);
      return;
    case 1001: 
      if (paramInt2 == -1)
      {
        ArrayList localArrayList = null;
        if (paramIntent != null) {
          localArrayList = paramIntent.getStringArrayListExtra("Select_Contact");
        }
        if ((localArrayList != null) && (localArrayList.size() == 1))
        {
          paramIntent = new Intent(this, ChattingUI.class);
          paramIntent.putExtra("Chat_User", (String)localArrayList.get(0));
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        finish();
        AppMethodBeat.o(39468);
        return;
      }
      ad.w("MicroMsg.ShareImageSelectorUI", "user cancle");
      AppMethodBeat.o(39468);
      return;
    }
    if (paramInt2 == -1)
    {
      Toast.makeText(getContext(), 2131757561, 0).show();
      finish();
      AppMethodBeat.o(39468);
      return;
    }
    ad.w("MicroMsg.ShareImageSelectorUI", "user cancle");
    AppMethodBeat.o(39468);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39469);
    cJV();
    AppMethodBeat.o(39469);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39465);
    super.onCreate(paramBundle);
    az.arV();
    paramBundle = c.afk().get(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        Hxg = i;
      }
    }
    setMMTitle(2131761221);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39456);
        ShareImageSelectorUI.b(ShareImageSelectorUI.this);
        AppMethodBeat.o(39456);
        return false;
      }
    });
    this.GYc = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.HuH = getIntent().getStringExtra("intent_extra_image_path");
    this.oCR = findViewById(2131301983);
    this.kPl = ((ImageView)findViewById(2131300914));
    this.kPl.setOnClickListener(this.Hxj);
    this.mListView = ((ListView)findViewById(2131301443));
    this.Hxh = new a();
    this.mListView.setAdapter(this.Hxh);
    this.mListView.setOnItemClickListener(this);
    ad.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.GYc, this.HuH });
    if (Hxg == 1)
    {
      setTitleVisibility(8);
      this.mListView.setVisibility(8);
      this.kPl.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.kPl.setPadding(0, 0, 0, 0);
      this.kPl.setOnClickListener(null);
      this.oCR.setBackgroundColor(getResources().getColor(2131100198));
      fex();
    }
    long l = System.currentTimeMillis();
    paramBundle = com.tencent.mm.platformtools.u.BA(this.HuH);
    int i = BackwardSupportUtil.ExifHelper.co(this.HuH);
    ad.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = f.a(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.kPl.setImageBitmap(paramBundle);
    }
    ad.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
    AppMethodBeat.o(39465);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39467);
    switch (paramInt)
    {
    default: 
      ad.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
      AppMethodBeat.o(39467);
      return;
    case 0: 
      fey();
      AppMethodBeat.o(39467);
      return;
    case 1: 
      fez();
      AppMethodBeat.o(39467);
      return;
    }
    feA();
    AppMethodBeat.o(39467);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39466);
    super.onResume();
    if ((Hxg == 1) && ((this.Hxi == null) || (!this.Hxi.isShowing()))) {
      fex();
    }
    AppMethodBeat.o(39466);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    public a[] Hxl;
    
    a()
    {
      AppMethodBeat.i(39461);
      this.Hxl = new a[] { new a(2131757979, 2131691163), new a(2131757980, 2131690185), new a(2131757978, 2131690845) };
      AppMethodBeat.o(39461);
    }
    
    public final int getCount()
    {
      return 3;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39462);
      if ((paramView == null) || (paramView.getTag() == null)) {
        paramView = LayoutInflater.from(ShareImageSelectorUI.this.getContext()).inflate(2131495428, null);
      }
      for (paramViewGroup = new ShareImageSelectorUI.b(ShareImageSelectorUI.this, paramView);; paramViewGroup = (ShareImageSelectorUI.b)paramView.getTag())
      {
        a locala = this.Hxl[paramInt];
        if (locala != null)
        {
          paramViewGroup.Hxp.setText(locala.Hxm);
          paramViewGroup.qhq.setImageResource(locala.Hxn);
        }
        AppMethodBeat.o(39462);
        return paramView;
      }
    }
    
    final class a
    {
      int Hxm;
      int Hxn;
      
      public a(int paramInt1, int paramInt2)
      {
        this.Hxm = paramInt1;
        this.Hxn = paramInt2;
      }
    }
  }
  
  final class b
  {
    TextView Hxp;
    MMImageView qhq;
    
    public b(View paramView)
    {
      AppMethodBeat.i(39463);
      this.qhq = ((MMImageView)paramView.findViewById(2131301154));
      this.Hxp = ((TextView)paramView.findViewById(2131301195));
      AppMethodBeat.o(39463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */