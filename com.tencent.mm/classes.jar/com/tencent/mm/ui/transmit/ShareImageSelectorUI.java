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
import com.tencent.mm.g.a.cz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import java.util.ArrayList;

public class ShareImageSelectorUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  private static int QAo = 1;
  private int PYv;
  private a QAp;
  private Dialog QAq;
  private View.OnClickListener QAr;
  private String QxF;
  private ImageView cIN;
  private MMHandler mHandler;
  private ListView mListView;
  private View rhx;
  
  public ShareImageSelectorUI()
  {
    AppMethodBeat.i(39464);
    this.PYv = 2;
    this.QAr = new ShareImageSelectorUI.1(this);
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
  
  private void edw()
  {
    AppMethodBeat.i(39470);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131758224), getString(2131758226), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        if (ShareImageSelectorUI.Tp() == 1) {
          ShareImageSelectorUI.c(ShareImageSelectorUI.this);
        }
        AppMethodBeat.o(39458);
      }
    });
    AppMethodBeat.o(39470);
  }
  
  private void gYs()
  {
    AppMethodBeat.i(39471);
    if ((this.QAq != null) && (this.QAq.isShowing()))
    {
      AppMethodBeat.o(39471);
      return;
    }
    String str1 = getString(2131758228);
    String str2 = getString(2131758229);
    String str3 = getString(2131758227);
    AppCompatActivity localAppCompatActivity = getContext();
    String str4 = getString(2131763030);
    h.d local6 = new h.d()
    {
      public final void oj(int paramAnonymousInt)
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
    this.QAq = com.tencent.mm.ui.base.h.c(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6);
    AppMethodBeat.o(39471);
  }
  
  private void gYt()
  {
    AppMethodBeat.i(39472);
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.u.PWZ);
    localIntent.putExtra("titile", getString(2131755264));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.QxF);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(39472);
  }
  
  private void gYu()
  {
    AppMethodBeat.i(39473);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.QxF);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.br.c.b(getContext(), "sns", ".ui.SnsUploadUI", localIntent, 1002);
    AppMethodBeat.o(39473);
  }
  
  private void gYv()
  {
    AppMethodBeat.i(39474);
    cz localcz = new cz();
    com.tencent.mm.pluginsdk.model.h.a(localcz, 6, this.QxF);
    localcz.dFZ.activity = this;
    localcz.dFZ.dGf = 52;
    EventCenter.instance.publish(localcz);
    com.tencent.mm.plugin.report.service.h.CyF.a(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
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
    return 2131496297;
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/ShareImageSelectorUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      Toast.makeText(getContext(), 2131757788, 0).show();
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
    edw();
    AppMethodBeat.o(39469);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39465);
    super.onCreate(paramBundle);
    bg.aVF();
    paramBundle = com.tencent.mm.model.c.azQ().get(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        QAo = i;
      }
    }
    setMMTitle(2131763030);
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
    this.PYv = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.QxF = getIntent().getStringExtra("intent_extra_image_path");
    this.rhx = findViewById(2131304318);
    this.cIN = ((ImageView)findViewById(2131302526));
    this.cIN.setOnClickListener(this.QAr);
    this.mListView = ((ListView)findViewById(2131303226));
    this.QAp = new a();
    this.mListView.setAdapter(this.QAp);
    this.mListView.setOnItemClickListener(this);
    Log.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.PYv, this.QxF });
    if (QAo == 1)
    {
      setTitleVisibility(8);
      this.mListView.setVisibility(8);
      this.cIN.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.cIN.setPadding(0, 0, 0, 0);
      this.cIN.setOnClickListener(null);
      this.rhx.setBackgroundColor(getResources().getColor(2131100231));
      gYs();
    }
    long l = System.currentTimeMillis();
    paramBundle = com.tencent.mm.platformtools.u.Sq(this.QxF);
    int i = BackwardSupportUtil.ExifHelper.getExifOrientation(this.QxF);
    Log.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = BitmapUtil.rotate(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.cIN.setImageBitmap(paramBundle);
    }
    Log.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
    AppMethodBeat.o(39465);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39467);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/ShareImageSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
      gYt();
      continue;
      gYu();
      continue;
      gYv();
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39466);
    super.onResume();
    if ((QAo == 1) && ((this.QAq == null) || (!this.QAq.isShowing()))) {
      gYs();
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
    public a[] QAt;
    
    a()
    {
      AppMethodBeat.i(39461);
      this.QAt = new a[] { new a(2131758228, 2131691477), new a(2131758229, 2131690222), new a(2131758227, 2131691131) };
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
        paramView = LayoutInflater.from(ShareImageSelectorUI.this.getContext()).inflate(2131496298, null);
      }
      for (paramViewGroup = new ShareImageSelectorUI.b(ShareImageSelectorUI.this, paramView);; paramViewGroup = (ShareImageSelectorUI.b)paramView.getTag())
      {
        a locala = this.QAt[paramInt];
        if (locala != null)
        {
          paramViewGroup.QAx.setText(locala.QAu);
          paramViewGroup.thK.setImageResource(locala.QAv);
        }
        AppMethodBeat.o(39462);
        return paramView;
      }
    }
    
    final class a
    {
      int QAu;
      int QAv;
      
      public a(int paramInt1, int paramInt2)
      {
        this.QAu = paramInt1;
        this.QAv = paramInt2;
      }
    }
  }
  
  final class b
  {
    TextView QAx;
    MMImageView thK;
    
    public b(View paramView)
    {
      AppMethodBeat.i(39463);
      this.thK = ((MMImageView)paramView.findViewById(2131302812));
      this.QAx = ((TextView)paramView.findViewById(2131302867));
      AppMethodBeat.o(39463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */