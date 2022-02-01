package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI
  extends MMActivity
{
  private int ClT = 0;
  private ListView ClU;
  private a ClV;
  private TextView ClW;
  private TextView ClX;
  private View ClY;
  private View ClZ;
  private String Cma;
  private String Cmb;
  private com.tencent.mm.vfs.e Cmc;
  private com.tencent.mm.vfs.e Cmd;
  
  private void Vp(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.ClT = 1;
      this.ClX.setTextColor(getResources().getColor(2131100464));
      this.ClW.setTextColor(getResources().getColor(2131100711));
      this.ClY.setVisibility(4);
      this.ClZ.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.ClT = 0;
    this.ClW.setTextColor(getResources().getColor(2131100464));
    this.ClX.setTextColor(getResources().getColor(2131100711));
    this.ClY.setVisibility(0);
    this.ClZ.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int aCv(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    String str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689585;
    }
    if (aCw(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131233696;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689573;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689576;
    }
    if (bt.nullAsNil(paramString).toLowerCase().endsWith(".pdf"))
    {
      AppMethodBeat.o(141178);
      return 2131689568;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689571;
    }
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if (!paramString.endsWith(".xls"))
    {
      i = j;
      if (!paramString.endsWith(".xlsx")) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(141178);
      return 2131689557;
    }
    AppMethodBeat.o(141178);
    return 2131689577;
  }
  
  public static boolean aCw(String paramString)
  {
    AppMethodBeat.i(141179);
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(141179);
      return true;
    }
    AppMethodBeat.o(141179);
    return false;
  }
  
  public static boolean aCx(String paramString)
  {
    AppMethodBeat.i(141180);
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
    {
      AppMethodBeat.o(141180);
      return true;
    }
    AppMethodBeat.o(141180);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494677;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(141176);
    this.ClU = ((ListView)findViewById(2131303599));
    this.ClW = ((TextView)findViewById(2131304249));
    this.ClY = findViewById(2131304250);
    this.ClX = ((TextView)findViewById(2131304381));
    this.ClZ = findViewById(2131304382);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(141160);
        if (FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)) != null)
        {
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            FileExplorerUI.a(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
          }
          for (;;)
          {
            FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fhT(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.eAE();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        com.tencent.mm.kernel.g.afB().afk().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fhU()));
        com.tencent.mm.kernel.g.afB().afk().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fhU()));
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.Cma = getString(2131761977);
    this.Cmb = getString(2131761978);
    final com.tencent.mm.vfs.e locale1 = com.tencent.mm.vfs.e.R(com.tencent.mm.compatible.util.g.getRootDirectory());
    final com.tencent.mm.vfs.e locale2;
    label132:
    Object localObject1;
    if (locale1.canRead())
    {
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        break label489;
      }
      locale2 = com.tencent.mm.vfs.e.R(com.tencent.mm.compatible.util.g.getExternalStorageDirectory());
      ab localab = com.tencent.mm.kernel.g.afB().afk();
      if (locale1 != null) {
        break label523;
      }
      localObject1 = null;
      label147:
      localObject1 = (String)localab.get(131073, localObject1);
      if ((localObject1 == null) || (locale1 == null) || (q.B(locale1.fhU()).equals(localObject1))) {
        break label535;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label535;
      }
      label205:
      this.Cmc = ((com.tencent.mm.vfs.e)localObject1);
      localab = com.tencent.mm.kernel.g.afB().afk();
      if (locale2 != null) {
        break label541;
      }
      localObject1 = localObject2;
      label228:
      localObject1 = (String)localab.get(131074, localObject1);
      if ((localObject1 == null) || (locale2 == null) || (q.B(locale2.fhU()).equals(localObject1))) {
        break label554;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label554;
      }
      label288:
      this.Cmd = ((com.tencent.mm.vfs.e)localObject1);
      this.ClV = new a((byte)0);
      if (locale2 == null) {
        break label561;
      }
      Vp(1);
      this.ClV.hxI = q.B(locale2.mUri);
      this.ClV.c(this.Cmd.fhT(), this.Cmd);
      label350:
      localObject1 = this.ClW;
      if (locale1 == null) {
        break label620;
      }
      bool1 = true;
      label362:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.ClX;
      if (locale2 == null) {
        break label625;
      }
    }
    label489:
    label620:
    label625:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.ClU.setAdapter(this.ClV);
      this.ClV.notifyDataSetChanged();
      this.ClU.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          paramAnonymousAdapterView = (com.tencent.mm.vfs.e)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.afB().afk().set(131074, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fhU()));
              com.tencent.mm.kernel.g.afB().afk().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fhU()));
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label261;
              }
              FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fhT(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.eAE();
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            AppMethodBeat.o(141161);
            return;
            FileExplorerUI.a(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            if (FileExplorerUI.b(FileExplorerUI.this) != 0) {
              break;
            }
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.afB().afk().set(131073, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fhU()));
              com.tencent.mm.kernel.g.afB().afk().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fhU()));
              break;
            }
            FileExplorerUI.b(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            label261:
            if (paramAnonymousAdapterView.isDirectory())
            {
              FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)), paramAnonymousAdapterView);
            }
            else if (paramAnonymousAdapterView.isFile())
            {
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", q.B(paramAnonymousAdapterView.fhU())));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.ClW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).hxI = q.B(locale1.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.e(FileExplorerUI.this).fhT(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          AppMethodBeat.o(141162);
        }
      });
      this.ClX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).hxI = q.B(locale2.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.d(FileExplorerUI.this).fhT(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      locale1 = com.tencent.mm.vfs.e.R(com.tencent.mm.compatible.util.g.getDataDirectory());
      if (locale1.canRead())
      {
        this.Cma = locale1.getName();
        break;
      }
      locale1 = null;
      break;
      locale2 = com.tencent.mm.vfs.e.R(com.tencent.mm.compatible.util.g.getDownloadCacheDirectory());
      if (locale2.canRead())
      {
        this.Cmb = locale2.getName();
        break label132;
      }
      locale2 = null;
      break label132;
      localObject1 = q.B(locale1.fhU());
      break label147;
      localObject1 = locale1;
      break label205;
      localObject1 = q.B(locale2.fhU());
      break label228;
      localObject1 = locale2;
      break label288;
      if (locale1 != null)
      {
        Vp(0);
        this.ClV.hxI = q.B(locale1.mUri);
        this.ClV.c(this.Cmc.fhT(), this.Cmc);
        break label350;
      }
      ad.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(141176);
      return;
      bool1 = false;
      break label362;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(141171);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (bt.isNullOrNil(paramBundle)) {
      setMMTitle(2131761979);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(141171);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(141174);
    super.onDestroy();
    AppMethodBeat.o(141174);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141175);
    if ((paramInt == 4) && (a.a(this.ClV) != null))
    {
      if (1 == this.ClT) {
        this.Cmd = a.a(this.ClV);
      }
      for (;;)
      {
        this.ClV.c(a.a(this.ClV).fhT(), a.a(this.ClV));
        this.ClV.notifyDataSetChanged();
        this.ClU.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.ClT == 0) {
          this.Cmc = a.a(this.ClV);
        }
      }
    }
    if (this.Cmd != null) {
      com.tencent.mm.kernel.g.afB().afk().set(131074, q.B(this.Cmd.fhU()));
    }
    if (this.Cmc != null) {
      com.tencent.mm.kernel.g.afB().afk().set(131073, q.B(this.Cmc.fhU()));
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(141175);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(141173);
    super.onPause();
    AppMethodBeat.o(141173);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(141172);
    super.onResume();
    AppMethodBeat.o(141172);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private com.tencent.mm.vfs.e Cmh;
    private com.tencent.mm.vfs.e Cmi;
    private com.tencent.mm.vfs.e[] Cmj;
    String hxI;
    
    private a() {}
    
    private void a(com.tencent.mm.vfs.e[] paramArrayOfe)
    {
      AppMethodBeat.i(175955);
      if ((paramArrayOfe == null) || (paramArrayOfe.length == 0))
      {
        AppMethodBeat.o(175955);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfe.length;
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.vfs.e locale = paramArrayOfe[i];
        FileExplorerUI.b localb = new FileExplorerUI.b(FileExplorerUI.this, (byte)0);
        localb.kot = locale;
        localb.Cml = f.Br(locale.getName()).toUpperCase();
        if (locale.isDirectory()) {
          ((List)localObject2).add(localb);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(localb);
        }
      }
      Collections.sort((List)localObject2, new Comparator() {});
      Collections.sort((List)localObject1, new Comparator() {});
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).kot;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).kot;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void c(com.tencent.mm.vfs.e parame1, com.tencent.mm.vfs.e parame2)
    {
      AppMethodBeat.i(175954);
      this.Cmh = parame1;
      if (q.B(parame2.fhU()).equalsIgnoreCase(this.hxI)) {
        this.Cmh = null;
      }
      this.Cmi = parame2;
      if ((this.Cmi.canRead()) && (this.Cmi.isDirectory()))
      {
        this.Cmj = this.Cmi.a(new com.tencent.mm.vfs.g()
        {
          public final boolean accept(com.tencent.mm.vfs.e paramAnonymouse)
          {
            AppMethodBeat.i(175953);
            if (paramAnonymouse.isHidden())
            {
              AppMethodBeat.o(175953);
              return false;
            }
            AppMethodBeat.o(175953);
            return true;
          }
        });
        if (this.Cmj == null) {
          this.Cmj = new com.tencent.mm.vfs.e[0];
        }
        if (this.Cmj.length > 0)
        {
          a(this.Cmj);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.Cmj = new com.tencent.mm.vfs.e[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.Cmj == null) {
        return 0;
      }
      int j = this.Cmj.length;
      if (this.Cmh != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.Cmh != null) && (paramInt == 0))
      {
        localObject = this.Cmh;
        AppMethodBeat.o(141168);
        return localObject;
      }
      ad.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.Cmj.length);
      Object localObject = this.Cmj;
      if (this.Cmh == null) {}
      for (;;)
      {
        localObject = localObject[paramInt];
        AppMethodBeat.o(141168);
        return localObject;
        paramInt -= 1;
      }
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(141169);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(FileExplorerUI.this, 2131494678, null);
        paramView = new FileExplorerUI.c(FileExplorerUI.this, (byte)0);
        paramView.kXS = ((ImageView)paramViewGroup.findViewById(2131299919));
        paramView.imt = ((TextView)paramViewGroup.findViewById(2131299925));
        paramView.Cmm = ((TextView)paramViewGroup.findViewById(2131299931));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (com.tencent.mm.vfs.e)getItem(paramInt);
      if (paramView == this.Cmh)
      {
        ((FileExplorerUI.c)localObject).imt.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).kXS.setImageResource(2131233694);
        ((FileExplorerUI.c)localObject).Cmm.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).kXS.setImageResource(FileExplorerUI.W(paramView));
      ((FileExplorerUI.c)localObject).imt.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).Cmm;
      StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
      if (paramView.isDirectory()) {}
      for (paramView = "";; paramView = "  " + bt.mK(paramView.length()))
      {
        ((TextView)localObject).setText(paramView);
        break;
      }
    }
  }
  
  final class b
  {
    String Cml;
    com.tencent.mm.vfs.e kot;
    
    private b() {}
  }
  
  final class c
  {
    TextView Cmm;
    TextView imt;
    ImageView kXS;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */