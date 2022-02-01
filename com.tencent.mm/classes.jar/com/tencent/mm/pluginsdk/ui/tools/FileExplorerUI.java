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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
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
  private int DEk = 0;
  private ListView DEl;
  private a DEm;
  private TextView DEn;
  private TextView DEo;
  private View DEp;
  private View DEq;
  private String DEr;
  private String DEs;
  private com.tencent.mm.vfs.e DEt;
  private com.tencent.mm.vfs.e DEu;
  
  private void Xy(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.DEk = 1;
      this.DEo.setTextColor(getResources().getColor(2131100464));
      this.DEn.setTextColor(getResources().getColor(2131100711));
      this.DEp.setVisibility(4);
      this.DEq.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.DEk = 0;
    this.DEn.setTextColor(getResources().getColor(2131100464));
    this.DEo.setTextColor(getResources().getColor(2131100711));
    this.DEp.setVisibility(0);
    this.DEq.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int aHN(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    String str = bs.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689585;
    }
    if (aHO(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131233696;
    }
    str = bs.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689573;
    }
    str = bs.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689576;
    }
    if (bs.nullAsNil(paramString).toLowerCase().endsWith(".pdf"))
    {
      AppMethodBeat.o(141178);
      return 2131689568;
    }
    str = bs.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689571;
    }
    paramString = bs.nullAsNil(paramString).toLowerCase();
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
  
  public static boolean aHO(String paramString)
  {
    AppMethodBeat.i(141179);
    paramString = bs.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(141179);
      return true;
    }
    AppMethodBeat.o(141179);
    return false;
  }
  
  public static boolean aHP(String paramString)
  {
    AppMethodBeat.i(141180);
    paramString = bs.nullAsNil(paramString).toLowerCase();
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
    this.DEl = ((ListView)findViewById(2131303599));
    this.DEn = ((TextView)findViewById(2131304249));
    this.DEp = findViewById(2131304250);
    this.DEo = ((TextView)findViewById(2131304381));
    this.DEq = findViewById(2131304382);
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
            FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fxU(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.ePY();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        com.tencent.mm.kernel.g.agR().agA().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fxV()));
        com.tencent.mm.kernel.g.agR().agA().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fxV()));
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.DEr = getString(2131761977);
    this.DEs = getString(2131761978);
    final com.tencent.mm.vfs.e locale1 = com.tencent.mm.vfs.e.U(com.tencent.mm.compatible.util.g.getRootDirectory());
    final com.tencent.mm.vfs.e locale2;
    label132:
    Object localObject1;
    if (locale1.canRead())
    {
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        break label489;
      }
      locale2 = com.tencent.mm.vfs.e.U(com.tencent.mm.compatible.util.g.getExternalStorageDirectory());
      ae localae = com.tencent.mm.kernel.g.agR().agA();
      if (locale1 != null) {
        break label523;
      }
      localObject1 = null;
      label147:
      localObject1 = (String)localae.get(131073, localObject1);
      if ((localObject1 == null) || (locale1 == null) || (q.B(locale1.fxV()).equals(localObject1))) {
        break label535;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label535;
      }
      label205:
      this.DEt = ((com.tencent.mm.vfs.e)localObject1);
      localae = com.tencent.mm.kernel.g.agR().agA();
      if (locale2 != null) {
        break label541;
      }
      localObject1 = localObject2;
      label228:
      localObject1 = (String)localae.get(131074, localObject1);
      if ((localObject1 == null) || (locale2 == null) || (q.B(locale2.fxV()).equals(localObject1))) {
        break label554;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label554;
      }
      label288:
      this.DEu = ((com.tencent.mm.vfs.e)localObject1);
      this.DEm = new a((byte)0);
      if (locale2 == null) {
        break label561;
      }
      Xy(1);
      this.DEm.hYj = q.B(locale2.mUri);
      this.DEm.c(this.DEu.fxU(), this.DEu);
      label350:
      localObject1 = this.DEn;
      if (locale1 == null) {
        break label620;
      }
      bool1 = true;
      label362:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.DEo;
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
      this.DEl.setAdapter(this.DEm);
      this.DEm.notifyDataSetChanged();
      this.DEl.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          paramAnonymousAdapterView = (com.tencent.mm.vfs.e)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.agR().agA().set(131074, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fxV()));
              com.tencent.mm.kernel.g.agR().agA().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fxV()));
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label261;
              }
              FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fxU(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.ePY();
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
              com.tencent.mm.kernel.g.agR().agA().set(131073, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fxV()));
              com.tencent.mm.kernel.g.agR().agA().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fxV()));
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
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", q.B(paramAnonymousAdapterView.fxV())));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.DEn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).hYj = q.B(locale1.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.e(FileExplorerUI.this).fxU(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          AppMethodBeat.o(141162);
        }
      });
      this.DEo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).hYj = q.B(locale2.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.d(FileExplorerUI.this).fxU(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      locale1 = com.tencent.mm.vfs.e.U(com.tencent.mm.compatible.util.g.getDataDirectory());
      if (locale1.canRead())
      {
        this.DEr = locale1.getName();
        break;
      }
      locale1 = null;
      break;
      locale2 = com.tencent.mm.vfs.e.U(com.tencent.mm.compatible.util.g.getDownloadCacheDirectory());
      if (locale2.canRead())
      {
        this.DEs = locale2.getName();
        break label132;
      }
      locale2 = null;
      break label132;
      localObject1 = q.B(locale1.fxV());
      break label147;
      localObject1 = locale1;
      break label205;
      localObject1 = q.B(locale2.fxV());
      break label228;
      localObject1 = locale2;
      break label288;
      if (locale1 != null)
      {
        Xy(0);
        this.DEm.hYj = q.B(locale1.mUri);
        this.DEm.c(this.DEt.fxU(), this.DEt);
        break label350;
      }
      ac.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
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
    if (bs.isNullOrNil(paramBundle)) {
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
    if ((paramInt == 4) && (a.a(this.DEm) != null))
    {
      if (1 == this.DEk) {
        this.DEu = a.a(this.DEm);
      }
      for (;;)
      {
        this.DEm.c(a.a(this.DEm).fxU(), a.a(this.DEm));
        this.DEm.notifyDataSetChanged();
        this.DEl.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.DEk == 0) {
          this.DEt = a.a(this.DEm);
        }
      }
    }
    if (this.DEu != null) {
      com.tencent.mm.kernel.g.agR().agA().set(131074, q.B(this.DEu.fxV()));
    }
    if (this.DEt != null) {
      com.tencent.mm.kernel.g.agR().agA().set(131073, q.B(this.DEt.fxV()));
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
    private com.tencent.mm.vfs.e[] DEA;
    private com.tencent.mm.vfs.e DEy;
    private com.tencent.mm.vfs.e DEz;
    String hYj;
    
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
        localb.kPM = locale;
        localb.DEC = f.Fv(locale.getName()).toUpperCase();
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
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).kPM;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).kPM;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void c(com.tencent.mm.vfs.e parame1, com.tencent.mm.vfs.e parame2)
    {
      AppMethodBeat.i(175954);
      this.DEy = parame1;
      if (q.B(parame2.fxV()).equalsIgnoreCase(this.hYj)) {
        this.DEy = null;
      }
      this.DEz = parame2;
      if ((this.DEz.canRead()) && (this.DEz.isDirectory()))
      {
        this.DEA = this.DEz.a(new com.tencent.mm.vfs.g()
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
        if (this.DEA == null) {
          this.DEA = new com.tencent.mm.vfs.e[0];
        }
        if (this.DEA.length > 0)
        {
          a(this.DEA);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.DEA = new com.tencent.mm.vfs.e[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.DEA == null) {
        return 0;
      }
      int j = this.DEA.length;
      if (this.DEy != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.DEy != null) && (paramInt == 0))
      {
        localObject = this.DEy;
        AppMethodBeat.o(141168);
        return localObject;
      }
      ac.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.DEA.length);
      Object localObject = this.DEA;
      if (this.DEy == null) {}
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
        paramView.lzC = ((ImageView)paramViewGroup.findViewById(2131299919));
        paramView.iMz = ((TextView)paramViewGroup.findViewById(2131299925));
        paramView.DED = ((TextView)paramViewGroup.findViewById(2131299931));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (com.tencent.mm.vfs.e)getItem(paramInt);
      if (paramView == this.DEy)
      {
        ((FileExplorerUI.c)localObject).iMz.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).lzC.setImageResource(2131233694);
        ((FileExplorerUI.c)localObject).DED.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).lzC.setImageResource(FileExplorerUI.V(paramView));
      ((FileExplorerUI.c)localObject).iMz.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).DED;
      StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
      if (paramView.isDirectory()) {}
      for (paramView = "";; paramView = "  " + bs.qz(paramView.length()))
      {
        ((TextView)localObject).setText(paramView);
        break;
      }
    }
  }
  
  final class b
  {
    String DEC;
    com.tencent.mm.vfs.e kPM;
    
    private b() {}
  }
  
  final class c
  {
    TextView DED;
    TextView iMz;
    ImageView lzC;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */