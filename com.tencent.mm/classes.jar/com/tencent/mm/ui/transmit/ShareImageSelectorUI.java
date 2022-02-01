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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ae;
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
  private static int IXD = 1;
  private String IVe;
  private a IXE;
  private Dialog IXF;
  private View.OnClickListener IXG;
  private int Iys;
  private ImageView lqK;
  private ao mHandler;
  private ListView mListView;
  private View pgr;
  
  public ShareImageSelectorUI()
  {
    AppMethodBeat.i(39464);
    this.Iys = 2;
    this.IXG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(39454);
        ShareImageSelectorUI.a(ShareImageSelectorUI.this);
        AppMethodBeat.o(39454);
      }
    };
    this.mHandler = new ao()
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
  
  private void cXA()
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
        if (ShareImageSelectorUI.IXD == 1) {
          ShareImageSelectorUI.c(ShareImageSelectorUI.this);
        }
        AppMethodBeat.o(39458);
      }
    });
    AppMethodBeat.o(39470);
  }
  
  private void fus()
  {
    AppMethodBeat.i(39471);
    if ((this.IXF != null) && (this.IXF.isShowing()))
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
      public final void kG(int paramAnonymousInt)
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
    this.IXF = com.tencent.mm.ui.base.h.c(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6);
    AppMethodBeat.o(39471);
  }
  
  private void fut()
  {
    AppMethodBeat.i(39472);
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.IwW);
    localIntent.putExtra("titile", getString(2131755230));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.IVe);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(39472);
  }
  
  private void fuu()
  {
    AppMethodBeat.i(39473);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.IVe);
    localIntent.putExtra("need_result", true);
    d.b(getContext(), "sns", ".ui.SnsUploadUI", localIntent, 1002);
    AppMethodBeat.o(39473);
  }
  
  private void fuv()
  {
    AppMethodBeat.i(39474);
    cs localcs = new cs();
    g.a(localcs, 6, this.IVe);
    localcs.dck.activity = this;
    localcs.dck.dcq = 52;
    com.tencent.mm.sdk.b.a.GpY.l(localcs);
    com.tencent.mm.plugin.report.service.h.wUl.f(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(0, 800L);
    }
    AppMethodBeat.o(39474);
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
    ac.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ac.w("MicroMsg.ShareImageSelectorUI", "unknow result");
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        finish();
        AppMethodBeat.o(39468);
        return;
      }
      ac.w("MicroMsg.ShareImageSelectorUI", "user cancle");
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
    ac.w("MicroMsg.ShareImageSelectorUI", "user cancle");
    AppMethodBeat.o(39468);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39469);
    cXA();
    AppMethodBeat.o(39469);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39465);
    super.onCreate(paramBundle);
    az.ayM();
    paramBundle = c.agA().get(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        IXD = i;
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
    this.Iys = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.IVe = getIntent().getStringExtra("intent_extra_image_path");
    this.pgr = findViewById(2131301983);
    this.lqK = ((ImageView)findViewById(2131300914));
    this.lqK.setOnClickListener(this.IXG);
    this.mListView = ((ListView)findViewById(2131301443));
    this.IXE = new a();
    this.mListView.setAdapter(this.IXE);
    this.mListView.setOnItemClickListener(this);
    ac.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.Iys, this.IVe });
    if (IXD == 1)
    {
      setTitleVisibility(8);
      this.mListView.setVisibility(8);
      this.lqK.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.lqK.setPadding(0, 0, 0, 0);
      this.lqK.setOnClickListener(null);
      this.pgr.setBackgroundColor(getResources().getColor(2131100198));
      fus();
    }
    long l = System.currentTimeMillis();
    paramBundle = com.tencent.mm.platformtools.u.FE(this.IVe);
    int i = BackwardSupportUtil.ExifHelper.ce(this.IVe);
    ac.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = f.a(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.lqK.setImageBitmap(paramBundle);
    }
    ac.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
    AppMethodBeat.o(39465);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39467);
    switch (paramInt)
    {
    default: 
      ac.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
      AppMethodBeat.o(39467);
      return;
    case 0: 
      fut();
      AppMethodBeat.o(39467);
      return;
    case 1: 
      fuu();
      AppMethodBeat.o(39467);
      return;
    }
    fuv();
    AppMethodBeat.o(39467);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39466);
    super.onResume();
    if ((IXD == 1) && ((this.IXF == null) || (!this.IXF.isShowing()))) {
      fus();
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
    public a[] IXI;
    
    a()
    {
      AppMethodBeat.i(39461);
      this.IXI = new a[] { new a(2131757979, 2131691163), new a(2131757980, 2131690185), new a(2131757978, 2131690845) };
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
        a locala = this.IXI[paramInt];
        if (locala != null)
        {
          paramViewGroup.IXM.setText(locala.IXJ);
          paramViewGroup.qPS.setImageResource(locala.IXK);
        }
        AppMethodBeat.o(39462);
        return paramView;
      }
    }
    
    final class a
    {
      int IXJ;
      int IXK;
      
      public a(int paramInt1, int paramInt2)
      {
        this.IXJ = paramInt1;
        this.IXK = paramInt2;
      }
    }
  }
  
  final class b
  {
    TextView IXM;
    MMImageView qPS;
    
    public b(View paramView)
    {
      AppMethodBeat.i(39463);
      this.qPS = ((MMImageView)paramView.findViewById(2131301154));
      this.IXM = ((TextView)paramView.findViewById(2131301195));
      AppMethodBeat.o(39463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */