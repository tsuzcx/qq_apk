package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI
  extends MMActivity
{
  private a FDa;
  private TextView FDb;
  private FileSelectorFolderView FDc;
  private o.a FDd;
  private FileSelectorFolderView.a FDe;
  private String dsk;
  private ListView jsM;
  private int mode;
  private TextView xvf;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.FDe = new FileSelectorFolderView.a()
    {
      public final void aab(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        ae.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(2131759059);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(2131299915));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759059);
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new k(com.tencent.mm.loader.j.b.asm()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new k(com.tencent.mm.loader.j.b.asm()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new k(com.tencent.mm.loader.j.b.ase()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new k(com.tencent.mm.loader.j.b.ase()), null);
          NewFileExplorerUI.this.setMMTitle(2131759060);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759060);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void dEy()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.FDa).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(2131755884) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.xvf.setText(getString(2131759061, new Object[] { bu.sL(this.FDa.dGd()) }));
      this.xvf.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(2131755884));
      enableOptionMenu(1, false);
    }
    this.xvf.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void fiZ()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.FDa) != null) && (a.c(this.FDa) != null))
    {
      Object localObject2 = w.B(a.c(this.FDa).mUri).replace(w.B(a.b(this.FDa).mUri), "");
      Object localObject1 = localObject2;
      if (((String)localObject2).startsWith("/")) {
        localObject1 = ((String)localObject2).substring(1);
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject2 = null;
      }
      setMMSubTitle((String)localObject2);
    }
    AppMethodBeat.o(32020);
  }
  
  private void wq(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.FDa.fjd() != null))
      {
        this.FDa.a(this.FDa.fjd(), null);
        this.FDa.notifyDataSetChanged();
        fiZ();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.FDa.fja());
    localIntent.putStringArrayListExtra("key_select_video_list", this.FDa.fjc());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.FDa.fjb());
    localIntent.putExtra("GalleryUI_ToUser", this.dsk);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(32018);
  }
  
  public int getLayoutId()
  {
    return 2131495014;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(32017);
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if ((paramIntent != null) && (a.a(this.FDa).size() != paramIntent.size()))
      {
        this.FDd.jfl.dismiss();
        a.a(this.FDa).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.FDa).add(new k(str));
        }
        this.FDa.notifyDataSetChanged();
        fiZ();
        dEy();
      }
      AppMethodBeat.o(32017);
      return;
    }
    if (paramInt1 == 2) {
      a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758111, 2131758112, 1);
    }
    AppMethodBeat.o(32017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32014);
    super.onCreate(paramBundle);
    this.dsk = getIntent().getStringExtra("TO_USER");
    this.jsM = ((ListView)findViewById(2131299917));
    this.FDa = new a();
    this.xvf = ((TextView)findViewById(2131304541));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(2131759062);
      setMMSubTitle(null);
      this.FDa.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.jsM.setAdapter(this.FDa);
      this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).FCf[paramAnonymousInt];
          if (paramAnonymousAdapterView.isDirectory())
          {
            NewFileExplorerUI.b(NewFileExplorerUI.this).a(paramAnonymousAdapterView, null);
            NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(31980);
            return;
            paramAnonymousView = o.aaw(w.B(paramAnonymousAdapterView.mUri));
            a.b(NewFileExplorerUI.this, w.B(paramAnonymousAdapterView.mUri), paramAnonymousView, 1);
          }
        }
      });
      this.jsM.setEmptyView(findViewById(2131299912));
      paramBundle = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(31981);
          NewFileExplorerUI.d(NewFileExplorerUI.this);
          AppMethodBeat.o(31981);
          return false;
        }
      };
      if (this.mode != 0) {
        break label417;
      }
    }
    label417:
    for (int i = 2131689508;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        addTextOptionMenu(1, getString(2131755884), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(31982);
            NewFileExplorerUI.e(NewFileExplorerUI.this);
            AppMethodBeat.o(31982);
            return true;
          }
        }, null, s.b.JwA);
      }
      dEy();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(2131759059);
      setMMSubTitle(null);
      this.FDb = ((TextView)findViewById(2131299915));
      this.FDb.setText(2131759059);
      this.FDa.c(new k(com.tencent.mm.loader.j.b.asm()), true);
      this.FDa.a(new k(com.tencent.mm.loader.j.b.asm()), null);
      if (this.FDa.getCount() == 0)
      {
        this.FDa.c(new k(com.tencent.mm.loader.j.b.ase()), false);
        this.FDa.a(new k(com.tencent.mm.loader.j.b.ase()), null);
        setMMTitle(2131759060);
        this.FDb.setText(2131759060);
      }
      findViewById(2131299913).setVisibility(0);
      findViewById(2131299913).setOnClickListener(new NewFileExplorerUI.1(this));
      this.FDc = ((FileSelectorFolderView)findViewById(2131299914));
      this.FDc.setListener(this.FDe);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32015);
    super.onDestroy();
    AppMethodBeat.o(32015);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32016);
    if (paramInt == 4)
    {
      wq(false);
      AppMethodBeat.o(32016);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(32016);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends BaseAdapter
  {
    private k FCe;
    k[] FCf;
    private k FDg;
    private boolean FDh;
    private ArrayList<k> FDi;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.FCf = new k[0];
      this.FDh = false;
      this.FDi = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(k[] paramArrayOfk)
    {
      AppMethodBeat.i(169799);
      if ((paramArrayOfk == null) || (paramArrayOfk.length == 0))
      {
        AppMethodBeat.o(169799);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfk.length;
      int i = 0;
      if (i < j)
      {
        k localk = paramArrayOfk[i];
        a locala = new a((byte)0);
        locala.aXd = localk;
        locala.time = localk.lastModified();
        if (localk.isDirectory())
        {
          locala.FDk = f.Jk(localk.getName()).toUpperCase();
          ((List)localObject2).add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(locala);
        }
      }
      Collections.sort((List)localObject2, new Comparator() {});
      Collections.sort((List)localObject1, new Comparator() {});
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfk[i] = ((a)((Iterator)localObject2).next()).aXd;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfk[i] = ((a)((Iterator)localObject1).next()).aXd;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static int aOM(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (aOS(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689585;
      }
      if (aON(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131230944;
      }
      if (aOR(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689573;
      }
      if (aOW(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689576;
      }
      if (aOT(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689568;
      }
      if (aOU(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689571;
      }
      if (aOV(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689557;
      }
      if (bx(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689564;
      }
      if (by(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689581;
      }
      if (cJ(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689584;
      }
      if (aOX(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689561;
      }
      if (aOY(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689566;
      }
      if (aOZ(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689567;
      }
      AppMethodBeat.o(31999);
      return 2131689577;
    }
    
    private static boolean aON(String paramString)
    {
      AppMethodBeat.i(32000);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((Build.VERSION.SDK_INT >= 28) && (paramString.endsWith(".heic")))
      {
        AppMethodBeat.o(32000);
        return true;
      }
      if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
      {
        AppMethodBeat.o(32000);
        return true;
      }
      AppMethodBeat.o(32000);
      return false;
    }
    
    private static boolean aOR(String paramString)
    {
      AppMethodBeat.i(32003);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".rar")) || (paramString.endsWith(".zip")) || (paramString.endsWith(".7z")) || (paramString.endsWith("tar")) || (paramString.endsWith(".iso")))
      {
        AppMethodBeat.o(32003);
        return true;
      }
      AppMethodBeat.o(32003);
      return false;
    }
    
    private static boolean aOS(String paramString)
    {
      AppMethodBeat.i(32004);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
      {
        AppMethodBeat.o(32004);
        return true;
      }
      AppMethodBeat.o(32004);
      return false;
    }
    
    private static boolean aOT(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = bu.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean aOU(String paramString)
    {
      AppMethodBeat.i(32006);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
      {
        AppMethodBeat.o(32006);
        return true;
      }
      AppMethodBeat.o(32006);
      return false;
    }
    
    private static boolean aOV(String paramString)
    {
      AppMethodBeat.i(32007);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
      {
        AppMethodBeat.o(32007);
        return true;
      }
      AppMethodBeat.o(32007);
      return false;
    }
    
    private static boolean aOW(String paramString)
    {
      AppMethodBeat.i(32008);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".txt")) || (paramString.endsWith(".rtf")))
      {
        AppMethodBeat.o(32008);
        return true;
      }
      AppMethodBeat.o(32008);
      return false;
    }
    
    private static boolean aOX(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = bu.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean aOY(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = bu.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean aOZ(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = bu.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static k[] b(k[] paramArrayOfk)
    {
      AppMethodBeat.i(186826);
      if ((paramArrayOfk == null) || (paramArrayOfk.length == 0))
      {
        AppMethodBeat.o(186826);
        return paramArrayOfk;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfk.length;
      int i = 0;
      if (i < j)
      {
        k localk = paramArrayOfk[i];
        if (!localk.isDirectory()) {
          localArrayList.add(localk);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(w.B(localk.fTh())))
          {
            localHashSet.add(w.B(localk.fTh()));
            localArrayList.add(localk);
          }
        }
      }
      paramArrayOfk = (k[])localArrayList.toArray(new k[0]);
      AppMethodBeat.o(186826);
      return paramArrayOfk;
    }
    
    private static boolean bx(String paramString)
    {
      AppMethodBeat.i(32001);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")))
      {
        AppMethodBeat.o(32001);
        return true;
      }
      AppMethodBeat.o(32001);
      return false;
    }
    
    static boolean by(String paramString)
    {
      AppMethodBeat.i(32002);
      paramString = bu.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
      {
        AppMethodBeat.o(32002);
        return true;
      }
      AppMethodBeat.o(32002);
      return false;
    }
    
    private static boolean cJ(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = bu.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    public final void a(k paramk, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.FCe = paramk;
      if ((this.FCe != null) && (this.FCe.canRead()) && (this.FCe.isDirectory()))
      {
        this.FCf = this.FCe.a(new m()
        {
          public final boolean accept(k paramAnonymousk)
          {
            AppMethodBeat.i(169795);
            if (paramAnonymousk.isHidden())
            {
              AppMethodBeat.o(169795);
              return false;
            }
            if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymousk.isDirectory()))
            {
              AppMethodBeat.o(169795);
              return false;
            }
            AppMethodBeat.o(169795);
            return true;
          }
        });
        if (this.FCf == null) {
          this.FCf = new k[0];
        }
        if (this.FCf.length > 0)
        {
          this.FCf = b(this.FCf);
          a(this.FCf);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.FCf = new k[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.FCf[i] = new k((String)paramList.get(i));
          this.FDi.add(this.FCf[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void c(k paramk, boolean paramBoolean)
    {
      this.FDg = paramk;
      this.FDh = paramBoolean;
    }
    
    public final int dGd()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.FDi.iterator();
      k localk;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(localk.length() + l))
      {
        localk = (k)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final ArrayList<String> fja()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FDi.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if ((!aON(localk.getName())) && (!by(localk.getName()))) {
          localArrayList.add(w.B(localk.mUri));
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> fjb()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FDi.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (aON(localk.getName())) {
          localArrayList.add(w.B(localk.mUri));
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> fjc()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FDi.iterator();
      while (localIterator.hasNext())
      {
        k localk = (k)localIterator.next();
        if (by(localk.getName())) {
          localArrayList.add(w.B(localk.mUri));
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final k fjd()
    {
      AppMethodBeat.i(169798);
      if (this.FCe.hashCode() == this.FDg.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      k localk = this.FCe.fTg();
      AppMethodBeat.o(169798);
      return localk;
    }
    
    public final int getCount()
    {
      return this.FCf.length;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject = null;
      AppMethodBeat.i(31998);
      View localView = paramView;
      if (paramView == null)
      {
        localView = View.inflate(paramViewGroup.getContext(), 2131494145, null);
        paramView = new b((byte)0);
        paramView.FDl = ((FrameLayout)localView.findViewById(2131301187));
        paramView.FDm = ((CheckBox)paramView.FDl.findViewById(2131301186));
        paramView.mdt = ((ImageView)localView.findViewById(2131301154));
        paramView.iYj = ((TextView)localView.findViewById(2131301198));
        paramView.xvf = ((TextView)localView.findViewById(2131301191));
        paramView.fVV = ((TextView)localView.findViewById(2131301196));
        paramView.FDl.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31988);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = NewFileExplorerUI.a.this.FCf[i];
            paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(2131301186);
            if (NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).contains(localObject))
            {
              NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).remove(localObject);
              paramAnonymousView.setChecked(false);
            }
            for (;;)
            {
              NewFileExplorerUI.h(NewFileExplorerUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(31988);
              return;
              if (NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).size() >= 9)
              {
                t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759077, new Object[] { Integer.valueOf(9) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              long l = com.tencent.mm.n.b.acs();
              if (((k)localObject).length() >= l)
              {
                t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759076, new Object[] { bu.sL(l) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              if (NewFileExplorerUI.a.by(((k)localObject).getName()))
              {
                com.tencent.mm.plugin.gallery.ui.a.a locala = com.tencent.mm.plugin.gallery.ui.a.a.amc(w.B(((k)localObject).mUri));
                locala.mSize = com.tencent.mm.n.b.acr();
                if (locala.bgQ() == 1)
                {
                  t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131764700, new Object[] { bu.sL(com.tencent.mm.n.b.acr()) }), 0).show();
                  paramAnonymousView.setChecked(false);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(31988);
                  return;
                }
              }
              paramAnonymousView.setChecked(true);
              NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).add(localObject);
            }
          }
        });
        localView.setTag(paramView);
      }
      paramViewGroup = (b)localView.getTag();
      k localk = this.FCf[paramInt];
      paramViewGroup.iYj.setText(localk.getName());
      int i;
      if (localk.isDirectory())
      {
        paramViewGroup.mdt.setImageResource(2131689560);
        paramViewGroup.FDl.setVisibility(4);
        paramViewGroup.xvf.setVisibility(0);
        paramViewGroup.fVV.setVisibility(8);
        paramView = localk.a(new s()
        {
          public final boolean xH(String paramAnonymousString)
          {
            AppMethodBeat.i(169796);
            if (!paramAnonymousString.startsWith("."))
            {
              AppMethodBeat.o(169796);
              return true;
            }
            AppMethodBeat.o(169796);
            return false;
          }
        });
        if (paramView != null)
        {
          i = paramView.length;
          paramViewGroup.xvf.setText(NewFileExplorerUI.this.getString(2131759057, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.FDm.setChecked(this.FDi.contains(localk));
        paramViewGroup.FDl.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.FDl.setVisibility(0);
        paramViewGroup.xvf.setVisibility(0);
        paramViewGroup.fVV.setVisibility(0);
        paramViewGroup.xvf.setText(bu.sL(localk.length()));
        paramViewGroup.fVV.setText(i.c(NewFileExplorerUI.this, localk.lastModified(), true));
        if (aON(localk.getName()))
        {
          paramView = w.B(localk.mUri);
          Cursor localCursor = NewFileExplorerUI.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { paramView }, null);
          paramView = localObject;
          if (localCursor != null)
          {
            if (!localCursor.moveToFirst()) {
              break label508;
            }
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localCursor.close();
          }
          for (paramView = MediaStore.Images.Thumbnails.getThumbnail(NewFileExplorerUI.this.getContentResolver(), i, 3, null);; paramView = localObject)
          {
            if (paramView == null) {
              break label521;
            }
            paramViewGroup.mdt.setImageBitmap(paramView);
            break;
            label508:
            localCursor.close();
          }
          label521:
          paramViewGroup.mdt.setImageResource(aOM(localk.getName()));
        }
        else
        {
          paramViewGroup.mdt.setImageResource(aOM(localk.getName()));
        }
      }
    }
    
    final class a
    {
      String FDk;
      k aXd;
      long time;
      
      private a() {}
    }
    
    final class b
    {
      public FrameLayout FDl;
      public CheckBox FDm;
      public TextView fVV;
      public TextView iYj;
      public ImageView mdt;
      public TextView xvf;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */