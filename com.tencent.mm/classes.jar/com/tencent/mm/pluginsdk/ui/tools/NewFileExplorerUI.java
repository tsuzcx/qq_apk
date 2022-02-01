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
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.q;
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
  private o.a DFA;
  private FileSelectorFolderView.a DFB;
  private a DFx;
  private TextView DFy;
  private FileSelectorFolderView DFz;
  private String dfJ;
  private ListView iWK;
  private int mode;
  private TextView vXz;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.DFB = new FileSelectorFolderView.a()
    {
      public final void Xz(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        ac.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(2131759059);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(2131299915));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759059);
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apc()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apc()), null);
          NewFileExplorerUI.this.setMMTitle(2131759060);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759060);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void dqE()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.DFx).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(2131755884) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.vXz.setText(getString(2131759061, new Object[] { bs.qz(this.DFx.dsn()) }));
      this.vXz.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(2131755884));
      enableOptionMenu(1, false);
    }
    this.vXz.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void eQh()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.DFx) != null) && (a.c(this.DFx) != null))
    {
      Object localObject2 = q.B(a.c(this.DFx).mUri).replace(q.B(a.b(this.DFx).mUri), "");
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
  
  private void vw(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.DFx.eQl() != null))
      {
        this.DFx.a(this.DFx.eQl(), null);
        this.DFx.notifyDataSetChanged();
        eQh();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.DFx.eQi());
    localIntent.putStringArrayListExtra("key_select_video_list", this.DFx.eQk());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.DFx.eQj());
    localIntent.putExtra("GalleryUI_ToUser", this.dfJ);
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
      if ((paramIntent != null) && (a.a(this.DFx).size() != paramIntent.size()))
      {
        this.DFA.iJj.dismiss();
        a.a(this.DFx).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.DFx).add(new com.tencent.mm.vfs.e(str));
        }
        this.DFx.notifyDataSetChanged();
        eQh();
        dqE();
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
    this.dfJ = getIntent().getStringExtra("TO_USER");
    this.iWK = ((ListView)findViewById(2131299917));
    this.DFx = new a();
    this.vXz = ((TextView)findViewById(2131304541));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(2131759062);
      setMMSubTitle(null);
      this.DFx.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.iWK.setAdapter(this.DFx);
      this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).DEA[paramAnonymousInt];
          if (paramAnonymousAdapterView.isDirectory())
          {
            NewFileExplorerUI.b(NewFileExplorerUI.this).a(paramAnonymousAdapterView, null);
            NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
            AppMethodBeat.o(31980);
            return;
          }
          paramAnonymousView = i.VW(q.B(paramAnonymousAdapterView.mUri));
          a.b(NewFileExplorerUI.this, q.B(paramAnonymousAdapterView.mUri), paramAnonymousView, 1);
          AppMethodBeat.o(31980);
        }
      });
      this.iWK.setEmptyView(findViewById(2131299912));
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
        }, null, s.b.Hom);
      }
      dqE();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(2131759059);
      setMMSubTitle(null);
      this.DFy = ((TextView)findViewById(2131299915));
      this.DFy.setText(2131759059);
      this.DFx.c(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj()), true);
      this.DFx.a(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj()), null);
      if (this.DFx.getCount() == 0)
      {
        this.DFx.c(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apc()), false);
        this.DFx.a(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apc()), null);
        setMMTitle(2131759060);
        this.DFy.setText(2131759060);
      }
      findViewById(2131299913).setVisibility(0);
      findViewById(2131299913).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31979);
          if (NewFileExplorerUI.a(NewFileExplorerUI.this) != null)
          {
            paramAnonymousView = NewFileExplorerUI.a(NewFileExplorerUI.this);
            if (paramAnonymousView.hW) {
              break label45;
            }
          }
          label45:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.mA(bool);
            AppMethodBeat.o(31979);
            return;
          }
        }
      });
      this.DFz = ((FileSelectorFolderView)findViewById(2131299914));
      this.DFz.setListener(this.DFB);
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
      vw(false);
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
    com.tencent.mm.vfs.e[] DEA;
    private com.tencent.mm.vfs.e DEz;
    private com.tencent.mm.vfs.e DFD;
    private boolean DFE;
    private ArrayList<com.tencent.mm.vfs.e> DFF;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.DEA = new com.tencent.mm.vfs.e[0];
      this.DFE = false;
      this.DFF = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(com.tencent.mm.vfs.e[] paramArrayOfe)
    {
      AppMethodBeat.i(169799);
      if ((paramArrayOfe == null) || (paramArrayOfe.length == 0))
      {
        AppMethodBeat.o(169799);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfe.length;
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.vfs.e locale = paramArrayOfe[i];
        a locala = new a((byte)0);
        locala.kPM = locale;
        locala.time = locale.lastModified();
        if (locale.isDirectory())
        {
          locala.DFH = f.Fv(locale.getName()).toUpperCase();
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
        paramArrayOfe[i] = ((a)((Iterator)localObject2).next()).kPM;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfe[i] = ((a)((Iterator)localObject1).next()).kPM;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static boolean aE(String paramString)
    {
      AppMethodBeat.i(32001);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")))
      {
        AppMethodBeat.o(32001);
        return true;
      }
      AppMethodBeat.o(32001);
      return false;
    }
    
    static boolean aF(String paramString)
    {
      AppMethodBeat.i(32002);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
      {
        AppMethodBeat.o(32002);
        return true;
      }
      AppMethodBeat.o(32002);
      return false;
    }
    
    private static int aHN(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (aHT(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689585;
      }
      if (aHO(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131230944;
      }
      if (aHS(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689573;
      }
      if (aHX(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689576;
      }
      if (aHU(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689568;
      }
      if (aHV(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689571;
      }
      if (aHW(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689557;
      }
      if (aE(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689564;
      }
      if (aF(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689581;
      }
      if (bP(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689584;
      }
      if (aHY(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689561;
      }
      if (aHZ(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689566;
      }
      if (aIa(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689567;
      }
      AppMethodBeat.o(31999);
      return 2131689577;
    }
    
    private static boolean aHO(String paramString)
    {
      AppMethodBeat.i(32000);
      paramString = bs.nullAsNil(paramString).toLowerCase();
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
    
    private static boolean aHS(String paramString)
    {
      AppMethodBeat.i(32003);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".rar")) || (paramString.endsWith(".zip")) || (paramString.endsWith(".7z")) || (paramString.endsWith("tar")) || (paramString.endsWith(".iso")))
      {
        AppMethodBeat.o(32003);
        return true;
      }
      AppMethodBeat.o(32003);
      return false;
    }
    
    private static boolean aHT(String paramString)
    {
      AppMethodBeat.i(32004);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
      {
        AppMethodBeat.o(32004);
        return true;
      }
      AppMethodBeat.o(32004);
      return false;
    }
    
    private static boolean aHU(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = bs.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean aHV(String paramString)
    {
      AppMethodBeat.i(32006);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
      {
        AppMethodBeat.o(32006);
        return true;
      }
      AppMethodBeat.o(32006);
      return false;
    }
    
    private static boolean aHW(String paramString)
    {
      AppMethodBeat.i(32007);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
      {
        AppMethodBeat.o(32007);
        return true;
      }
      AppMethodBeat.o(32007);
      return false;
    }
    
    private static boolean aHX(String paramString)
    {
      AppMethodBeat.i(32008);
      paramString = bs.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".txt")) || (paramString.endsWith(".rtf")))
      {
        AppMethodBeat.o(32008);
        return true;
      }
      AppMethodBeat.o(32008);
      return false;
    }
    
    private static boolean aHY(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = bs.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean aHZ(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = bs.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean aIa(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = bs.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static com.tencent.mm.vfs.e[] b(com.tencent.mm.vfs.e[] paramArrayOfe)
    {
      AppMethodBeat.i(196199);
      if ((paramArrayOfe == null) || (paramArrayOfe.length == 0))
      {
        AppMethodBeat.o(196199);
        return paramArrayOfe;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfe.length;
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.vfs.e locale = paramArrayOfe[i];
        if (!locale.isDirectory()) {
          localArrayList.add(locale);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(q.B(locale.fxV())))
          {
            localHashSet.add(q.B(locale.fxV()));
            localArrayList.add(locale);
          }
        }
      }
      paramArrayOfe = (com.tencent.mm.vfs.e[])localArrayList.toArray(new com.tencent.mm.vfs.e[0]);
      AppMethodBeat.o(196199);
      return paramArrayOfe;
    }
    
    private static boolean bP(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = bs.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    public final void a(com.tencent.mm.vfs.e parame, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.DEz = parame;
      if ((this.DEz != null) && (this.DEz.canRead()) && (this.DEz.isDirectory()))
      {
        this.DEA = this.DEz.a(new com.tencent.mm.vfs.g()
        {
          public final boolean accept(com.tencent.mm.vfs.e paramAnonymouse)
          {
            AppMethodBeat.i(169795);
            if (paramAnonymouse.isHidden())
            {
              AppMethodBeat.o(169795);
              return false;
            }
            if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymouse.isDirectory()))
            {
              AppMethodBeat.o(169795);
              return false;
            }
            AppMethodBeat.o(169795);
            return true;
          }
        });
        if (this.DEA == null) {
          this.DEA = new com.tencent.mm.vfs.e[0];
        }
        if (this.DEA.length > 0)
        {
          this.DEA = b(this.DEA);
          a(this.DEA);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.DEA = new com.tencent.mm.vfs.e[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.DEA[i] = new com.tencent.mm.vfs.e((String)paramList.get(i));
          this.DFF.add(this.DEA[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void c(com.tencent.mm.vfs.e parame, boolean paramBoolean)
    {
      this.DFD = parame;
      this.DFE = paramBoolean;
    }
    
    public final int dsn()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.DFF.iterator();
      com.tencent.mm.vfs.e locale;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(locale.length() + l))
      {
        locale = (com.tencent.mm.vfs.e)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final ArrayList<String> eQi()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.DFF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.vfs.e locale = (com.tencent.mm.vfs.e)localIterator.next();
        if ((!aHO(locale.getName())) && (!aF(locale.getName()))) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> eQj()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.DFF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.vfs.e locale = (com.tencent.mm.vfs.e)localIterator.next();
        if (aHO(locale.getName())) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> eQk()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.DFF.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.vfs.e locale = (com.tencent.mm.vfs.e)localIterator.next();
        if (aF(locale.getName())) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final com.tencent.mm.vfs.e eQl()
    {
      AppMethodBeat.i(169798);
      if (this.DEz.hashCode() == this.DFD.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      com.tencent.mm.vfs.e locale = this.DEz.fxU();
      AppMethodBeat.o(169798);
      return locale;
    }
    
    public final int getCount()
    {
      return this.DEA.length;
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
        paramView.DFI = ((FrameLayout)localView.findViewById(2131301187));
        paramView.DFJ = ((CheckBox)paramView.DFI.findViewById(2131301186));
        paramView.lzC = ((ImageView)localView.findViewById(2131301154));
        paramView.iCg = ((TextView)localView.findViewById(2131301198));
        paramView.vXz = ((TextView)localView.findViewById(2131301191));
        paramView.fAz = ((TextView)localView.findViewById(2131301196));
        paramView.DFI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31988);
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            com.tencent.mm.vfs.e locale = NewFileExplorerUI.a.this.DEA[i];
            paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(2131301186);
            if (NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).contains(locale))
            {
              NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).remove(locale);
              paramAnonymousView.setChecked(false);
            }
            for (;;)
            {
              NewFileExplorerUI.h(NewFileExplorerUI.this);
              AppMethodBeat.o(31988);
              return;
              if (NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).size() >= 9)
              {
                t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759077, new Object[] { Integer.valueOf(9) }), 0).show();
                paramAnonymousView.setChecked(false);
                AppMethodBeat.o(31988);
                return;
              }
              Object localObject = com.tencent.mm.m.g.ZY().getValue("InputLimitSendFileSize");
              ac.i("MicroMsg.BoundaryConfig", "MaxSendFileSize, svrLimit:%s, localLimit:%s", new Object[] { localObject, Integer.valueOf(104857600) });
              long l = bs.getInt((String)localObject, 104857600);
              if (locale.length() >= l)
              {
                t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759076, new Object[] { bs.qz(l) }), 0).show();
                paramAnonymousView.setChecked(false);
                AppMethodBeat.o(31988);
                return;
              }
              if (NewFileExplorerUI.a.aF(locale.getName()))
              {
                localObject = com.tencent.mm.plugin.gallery.ui.a.a.agH(q.B(locale.mUri));
                ((com.tencent.mm.plugin.gallery.ui.a.a)localObject).mSize = com.tencent.mm.m.b.ZH();
                if (((com.tencent.mm.plugin.gallery.ui.a.a)localObject).bcE() == 1)
                {
                  t.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131764700, new Object[] { bs.qz(com.tencent.mm.m.b.ZH()) }), 0).show();
                  paramAnonymousView.setChecked(false);
                  AppMethodBeat.o(31988);
                  return;
                }
              }
              paramAnonymousView.setChecked(true);
              NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).add(locale);
            }
          }
        });
        localView.setTag(paramView);
      }
      paramViewGroup = (b)localView.getTag();
      com.tencent.mm.vfs.e locale = this.DEA[paramInt];
      paramViewGroup.iCg.setText(locale.getName());
      int i;
      if (locale.isDirectory())
      {
        paramViewGroup.lzC.setImageResource(2131689560);
        paramViewGroup.DFI.setVisibility(4);
        paramViewGroup.vXz.setVisibility(0);
        paramViewGroup.fAz.setVisibility(8);
        paramView = locale.a(new m()
        {
          public final boolean ui(String paramAnonymousString)
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
          paramViewGroup.vXz.setText(NewFileExplorerUI.this.getString(2131759057, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.DFJ.setChecked(this.DFF.contains(locale));
        paramViewGroup.DFI.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.DFI.setVisibility(0);
        paramViewGroup.vXz.setVisibility(0);
        paramViewGroup.fAz.setVisibility(0);
        paramViewGroup.vXz.setText(bs.qz(locale.length()));
        paramViewGroup.fAz.setText(h.c(NewFileExplorerUI.this, locale.lastModified(), true));
        if (aHO(locale.getName()))
        {
          paramView = q.B(locale.mUri);
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
            paramViewGroup.lzC.setImageBitmap(paramView);
            break;
            label508:
            localCursor.close();
          }
          label521:
          paramViewGroup.lzC.setImageResource(aHN(locale.getName()));
        }
        else
        {
          paramViewGroup.lzC.setImageResource(aHN(locale.getName()));
        }
      }
    }
    
    final class a
    {
      String DFH;
      com.tencent.mm.vfs.e kPM;
      long time;
      
      private a() {}
    }
    
    final class b
    {
      public FrameLayout DFI;
      public CheckBox DFJ;
      public TextView fAz;
      public TextView iCg;
      public ImageView lzC;
      public TextView vXz;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */