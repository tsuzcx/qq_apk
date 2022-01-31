package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.t;
import java.util.ArrayList;

public class ShareImageSelectorUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  private static int AAM = 1;
  private a AAN;
  private Dialog AAO;
  private View.OnClickListener AAP;
  private int AeK;
  private String Ayy;
  private ImageView ioq;
  private View lmC;
  private ak mHandler;
  private ListView mListView;
  
  public ShareImageSelectorUI()
  {
    AppMethodBeat.i(35257);
    this.AeK = 2;
    this.AAP = new ShareImageSelectorUI.1(this);
    this.mHandler = new ShareImageSelectorUI.2(this);
    AppMethodBeat.o(35257);
  }
  
  private void bLU()
  {
    AppMethodBeat.i(35263);
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131298895), getString(2131298897), true, new ShareImageSelectorUI.4(this), new ShareImageSelectorUI.5(this));
    AppMethodBeat.o(35263);
  }
  
  private void dOu()
  {
    AppMethodBeat.i(35264);
    if ((this.AAO != null) && (this.AAO.isShowing()))
    {
      AppMethodBeat.o(35264);
      return;
    }
    String str1 = getString(2131298899);
    String str2 = getString(2131298900);
    String str3 = getString(2131298898);
    AppCompatActivity localAppCompatActivity = getContext();
    String str4 = getString(2131301551);
    ShareImageSelectorUI.6 local6 = new ShareImageSelectorUI.6(this);
    ShareImageSelectorUI.7 local7 = new ShareImageSelectorUI.7(this);
    this.AAO = com.tencent.mm.ui.base.h.a(localAppCompatActivity, str4, new String[] { str1, str2, str3 }, null, local6, local7);
    AppMethodBeat.o(35264);
  }
  
  private void dOv()
  {
    AppMethodBeat.i(35265);
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", t.Aea);
    localIntent.putExtra("titile", getString(2131296498));
    localIntent.putExtra("list_type", 11);
    localIntent.putExtra("shareImage", true);
    localIntent.putExtra("shareImagePath", this.Ayy);
    startActivityForResult(localIntent, 1001);
    AppMethodBeat.o(35265);
  }
  
  private void dOw()
  {
    AppMethodBeat.i(35266);
    Intent localIntent = new Intent();
    localIntent.putExtra("Ksnsupload_type", 0);
    localIntent.putExtra("sns_kemdia_path", this.Ayy);
    localIntent.putExtra("need_result", true);
    com.tencent.mm.bq.d.b(getContext(), "sns", ".ui.SnsUploadUI", localIntent, 1002);
    AppMethodBeat.o(35266);
  }
  
  private void dOx()
  {
    AppMethodBeat.i(35267);
    cm localcm = new cm();
    e.a(localcm, 6, this.Ayy);
    localcm.cpR.activity = this;
    localcm.cpR.cpY = 52;
    a.ymk.l(localcm);
    com.tencent.mm.plugin.report.service.h.qsU.e(11048, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0) });
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(0, 800L);
    }
    AppMethodBeat.o(35267);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970723;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35261);
    ab.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ab.w("MicroMsg.ShareImageSelectorUI", "unknow result");
      AppMethodBeat.o(35261);
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
          startActivity(paramIntent);
        }
        finish();
        AppMethodBeat.o(35261);
        return;
      }
      ab.w("MicroMsg.ShareImageSelectorUI", "user cancle");
      AppMethodBeat.o(35261);
      return;
    }
    if (paramInt2 == -1)
    {
      Toast.makeText(getContext(), 2131298502, 0).show();
      finish();
      AppMethodBeat.o(35261);
      return;
    }
    ab.w("MicroMsg.ShareImageSelectorUI", "user cancle");
    AppMethodBeat.o(35261);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35262);
    bLU();
    AppMethodBeat.o(35262);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35258);
    super.onCreate(paramBundle);
    aw.aaz();
    paramBundle = c.Ru().get(229635, null);
    if ((paramBundle instanceof Integer))
    {
      i = ((Integer)paramBundle).intValue();
      if ((i == 0) || (i == 1)) {
        AAM = i;
      }
    }
    setMMTitle(2131301551);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35249);
        ShareImageSelectorUI.b(ShareImageSelectorUI.this);
        AppMethodBeat.o(35249);
        return false;
      }
    });
    this.AeK = getIntent().getIntExtra("Select_Conv_Type", 2);
    this.Ayy = getIntent().getStringExtra("intent_extra_image_path");
    this.lmC = findViewById(2131824652);
    this.ioq = ((ImageView)findViewById(2131820629));
    this.ioq.setOnClickListener(this.AAP);
    this.mListView = ((ListView)findViewById(2131821002));
    this.AAN = new a();
    this.mListView.setAdapter(this.AAN);
    this.mListView.setOnItemClickListener(this);
    ab.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[] { this.AeK, this.Ayy });
    if (AAM == 1)
    {
      setTitleVisibility(8);
      this.mListView.setVisibility(8);
      this.ioq.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      this.ioq.setPadding(0, 0, 0, 0);
      this.ioq.setOnClickListener(null);
      this.lmC.setBackgroundColor(getResources().getColor(2131689917));
      dOu();
    }
    long l = System.currentTimeMillis();
    paramBundle = x.wx(this.Ayy);
    int i = BackwardSupportUtil.ExifHelper.bY(this.Ayy);
    ab.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[] { Integer.valueOf(i) });
    paramBundle = com.tencent.mm.sdk.platformtools.d.b(paramBundle, i);
    if ((paramBundle != null) && (!paramBundle.isRecycled())) {
      this.ioq.setImageBitmap(paramBundle);
    }
    ab.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[] { System.currentTimeMillis() - l + "'" });
    AppMethodBeat.o(35258);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35260);
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
      AppMethodBeat.o(35260);
      return;
    case 0: 
      dOv();
      AppMethodBeat.o(35260);
      return;
    case 1: 
      dOw();
      AppMethodBeat.o(35260);
      return;
    }
    dOx();
    AppMethodBeat.o(35260);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(35259);
    super.onResume();
    if ((AAM == 1) && ((this.AAO == null) || (!this.AAO.isShowing()))) {
      dOu();
    }
    AppMethodBeat.o(35259);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    public ShareImageSelectorUI.a.a[] AAR;
    
    a()
    {
      AppMethodBeat.i(35254);
      this.AAR = new ShareImageSelectorUI.a.a[] { new ShareImageSelectorUI.a.a(this, 2131298899, 2131231977), new ShareImageSelectorUI.a.a(this, 2131298900, 2131231332), new ShareImageSelectorUI.a.a(this, 2131298898, 2131231685) };
      AppMethodBeat.o(35254);
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
      AppMethodBeat.i(35255);
      if ((paramView == null) || (paramView.getTag() == null)) {
        paramView = LayoutInflater.from(ShareImageSelectorUI.this.getContext()).inflate(2130970724, null);
      }
      for (paramViewGroup = new ShareImageSelectorUI.b(ShareImageSelectorUI.this, paramView);; paramViewGroup = (ShareImageSelectorUI.b)paramView.getTag())
      {
        ShareImageSelectorUI.a.a locala = this.AAR[paramInt];
        if (locala != null)
        {
          paramViewGroup.AAV.setText(locala.AAS);
          paramViewGroup.mzO.setImageResource(locala.AAT);
        }
        AppMethodBeat.o(35255);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.ShareImageSelectorUI
 * JD-Core Version:    0.7.0.1
 */