package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;

public class ShareImageSelectorUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  private static int afPy = 1;
  private String GYs;
  private Dialog afPA;
  private View.OnClickListener afPB;
  private a afPz;
  private int afgm;
  private ImageView ewg;
  private MMHandler mHandler;
  private ListView mListView;
  private View xTc;
  
  public ShareImageSelectorUI()
  {
    AppMethodBeat.i(39464);
    this.afgm = 2;
    this.afPB = new ShareImageSelectorUI.1(this);
    this.mHandler = new MMHandler()
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
  
  private void fjO()
  {
    AppMethodBeat.i(39470);
    k.a(getContext(), getString(R.l.gDE), getString(R.l.gDG), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        if (ShareImageSelectorUI.afPy == 1) {
          ShareImageSelectorUI.c(ShareImageSelectorUI.this);
        }
        AppMethodBeat.o(39458);
      }
    });
    AppMethodBeat.o(39470);
  }
  
  private void jDX()
  {
    AppMethodBeat.i(39471);
    if ((this.afPA != null) && (this.afPA.isShowing()))
    {
      AppMethodBeat.o(39471);
      return;
    }
    String str1 = getString(R.l.gDI);
    String str2 = getString(R.l.gDJ);
    String str3 = getString(R.l.gDH);
    AppCompatActivity localAppCompatActivity = getContext();
    String str4 = getString(R.l.gNR);
    k.d local6 = new k.d()
    {
      public final void qz(int paramAnonymousInt)
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
    this.afPA = k.c(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6);
    AppMethodBeat.o(39471);
  }
  
  private void jDY()
  {
    AppMethodBeat.i(39472);
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", w.affw);
    localIntent.putExtra("titile", getString(R.l.gqT));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.GYs);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(39472);
  }
  
  private void jDZ()
  {
    AppMethodBeat.i(39473);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.GYs);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsUploadUI", localIntent, 1002);
    AppMethodBeat.o(39473);
  }
  
  private void jEa()
  {
    AppMethodBeat.i(39474);
    dn localdn = new dn();
    l.a(localdn, 6, this.GYs);
    localdn.hDr.activity = this;
    localdn.hDr.hDy = 52;
    localdn.publish();
    h.OAn.b(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
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
    return R.i.goj;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39468);
    Log.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      Log.w("MicroMsg.ShareImageSelectorUI", "unknow result");
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        finish();
        AppMethodBeat.o(39468);
        return;
      }
      Log.w("MicroMsg.ShareImageSelectorUI", "user cancle");
      AppMethodBeat.o(39468);
      return;
    }
    if (paramInt2 == -1)
    {
      Toast.makeText(getContext(), R.l.confirm_dialog_sent, 0).show();
      finish();
      AppMethodBeat.o(39468);
      return;
    }
    Log.w("MicroMsg.ShareImageSelectorUI", "user cancle");
    AppMethodBeat.o(39468);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39469);
    fjO();
    AppMethodBeat.o(39469);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39465);
    super.onCreate(paramBundle);
    bh.bCz();
    paramBundle = com.tencent.mm.model.c.ban().d(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        afPy = i;
      }
    }
    setMMTitle(R.l.gNR);
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
    this.afgm = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.GYs = getIntent().getStringExtra("intent_extra_image_path");
    this.xTc = findViewById(R.h.main);
    this.ewg = ((ImageView)findViewById(R.h.image));
    this.ewg.setOnClickListener(this.afPB);
    this.mListView = ((ListView)findViewById(R.h.list));
    this.afPz = new a();
    this.mListView.setAdapter(this.afPz);
    this.mListView.setOnItemClickListener(this);
    Log.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.afgm, this.GYs });
    if (afPy == 1)
    {
      setTitleVisibility(8);
      this.mListView.setVisibility(8);
      this.ewg.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.ewg.setPadding(0, 0, 0, 0);
      this.ewg.setOnClickListener(null);
      this.xTc.setBackgroundColor(getResources().getColor(R.e.dark_bg_color));
      jDX();
    }
    long l = System.currentTimeMillis();
    paramBundle = r.Sg(this.GYs);
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(this.GYs);
    Log.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = BitmapUtil.rotate(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.ewg.setImageBitmap(paramBundle);
    }
    Log.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
    AppMethodBeat.o(39465);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39467);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/transmit/ShareImageSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(39467);
      return;
      jDY();
      continue;
      jDZ();
      continue;
      jEa();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39466);
    super.onResume();
    if ((afPy == 1) && ((this.afPA == null) || (!this.afPA.isShowing()))) {
      jDX();
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
    public a[] afPD;
    
    a()
    {
      AppMethodBeat.i(39461);
      this.afPD = new a[] { new a(R.l.gDI, R.k.share_to_friend_icon), new a(R.l.gDJ, R.k.find_more_friend_photograph_icon), new a(R.l.gDH, R.k.more_my_favorite) };
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
        paramView = LayoutInflater.from(ShareImageSelectorUI.this.getContext()).inflate(R.i.gok, null);
      }
      for (paramViewGroup = new ShareImageSelectorUI.b(ShareImageSelectorUI.this, paramView);; paramViewGroup = (ShareImageSelectorUI.b)paramView.getTag())
      {
        a locala = this.afPD[paramInt];
        if (locala != null)
        {
          paramViewGroup.afPH.setText(locala.afPE);
          paramViewGroup.AkD.setImageResource(locala.afPF);
        }
        AppMethodBeat.o(39462);
        return paramView;
      }
    }
    
    final class a
    {
      int afPE;
      int afPF;
      
      public a(int paramInt1, int paramInt2)
      {
        this.afPE = paramInt1;
        this.afPF = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */