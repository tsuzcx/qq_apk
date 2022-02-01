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
import com.tencent.mm.n.c;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
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
  private TextView Bvi;
  private a Kwh;
  private TextView Kwi;
  private FileSelectorFolderView Kwj;
  private o.a Kwk;
  private FileSelectorFolderView.a Kwl;
  private String dJw;
  private ListView krb;
  private int mode;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.Kwl = new FileSelectorFolderView.a()
    {
      public final void aiQ(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        Log.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(2131759387);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(2131300617));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759387);
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new o(com.tencent.mm.loader.j.b.aKM()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new o(com.tencent.mm.loader.j.b.aKM()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new o(com.tencent.mm.loader.j.b.aKE()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new o(com.tencent.mm.loader.j.b.aKE()), null);
          NewFileExplorerUI.this.setMMTitle(2131759388);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759388);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void Aq(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.Kwh.gst() != null))
      {
        this.Kwh.a(this.Kwh.gst(), null);
        this.Kwh.notifyDataSetChanged();
        gsC();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.Kwh.gsD());
    localIntent.putStringArrayListExtra("key_select_video_list", this.Kwh.gsF());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.Kwh.gsE());
    localIntent.putExtra("GalleryUI_ToUser", this.dJw);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(32018);
  }
  
  private void dmp()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.Kwh).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(2131755976) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.Bvi.setText(getString(2131759389, new Object[] { Util.getSizeKB(this.Kwh.eGR()) }));
      this.Bvi.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(2131755976));
      enableOptionMenu(1, false);
    }
    this.Bvi.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void gsC()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.Kwh) != null) && (a.c(this.Kwh) != null))
    {
      Object localObject2 = aa.z(a.c(this.Kwh).mUri).replace(aa.z(a.b(this.Kwh).mUri), "");
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
  
  public int getLayoutId()
  {
    return 2131495844;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(32017);
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if ((paramIntent != null) && (a.a(this.Kwh).size() != paramIntent.size()))
      {
        this.Kwk.kdo.dismiss();
        a.a(this.Kwh).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.Kwh).add(new o(str));
        }
        this.Kwh.notifyDataSetChanged();
        gsC();
        dmp();
      }
      AppMethodBeat.o(32017);
      return;
    }
    if (paramInt1 == 2) {
      a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758379, 2131758380, 1);
    }
    AppMethodBeat.o(32017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32014);
    super.onCreate(paramBundle);
    this.dJw = getIntent().getStringExtra("TO_USER");
    this.krb = ((ListView)findViewById(2131300619));
    this.Kwh = new a();
    this.Bvi = ((TextView)findViewById(2131307565));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(2131759390);
      setMMSubTitle(null);
      this.Kwh.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.krb.setAdapter(this.Kwh);
      this.krb.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).KtX[paramAnonymousInt];
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
            paramAnonymousView = s.akC(aa.z(paramAnonymousAdapterView.mUri));
            a.b(NewFileExplorerUI.this, aa.z(paramAnonymousAdapterView.mUri), paramAnonymousView, 1);
          }
        }
      });
      this.krb.setEmptyView(findViewById(2131300614));
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
        break label416;
      }
    }
    label416:
    for (int i = 2131689510;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        addTextOptionMenu(1, getString(2131755976), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(31982);
            NewFileExplorerUI.e(NewFileExplorerUI.this);
            AppMethodBeat.o(31982);
            return true;
          }
        }, null, t.b.OGU);
      }
      dmp();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(2131759387);
      setMMSubTitle(null);
      this.Kwi = ((TextView)findViewById(2131300617));
      this.Kwi.setText(2131759387);
      this.Kwh.c(new o(com.tencent.mm.loader.j.b.aKM()), true);
      this.Kwh.a(new o(com.tencent.mm.loader.j.b.aKM()), null);
      if (this.Kwh.getCount() == 0)
      {
        this.Kwh.c(new o(com.tencent.mm.loader.j.b.aKE()), false);
        this.Kwh.a(new o(com.tencent.mm.loader.j.b.aKE()), null);
        setMMTitle(2131759388);
        this.Kwi.setText(2131759388);
      }
      findViewById(2131300615).setVisibility(0);
      findViewById(2131300615).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31979);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (NewFileExplorerUI.a(NewFileExplorerUI.this) != null)
          {
            paramAnonymousView = NewFileExplorerUI.a(NewFileExplorerUI.this);
            if (paramAnonymousView.jT) {
              break label86;
            }
          }
          label86:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.pD(bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31979);
            return;
          }
        }
      });
      this.Kwj = ((FileSelectorFolderView)findViewById(2131300616));
      this.Kwj.setListener(this.Kwl);
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
      Aq(false);
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
    private o KtW;
    o[] KtX;
    private o Kva;
    private boolean Kvb;
    private ArrayList<o> Kwn;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.KtX = new o[0];
      this.Kvb = false;
      this.Kwn = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(o[] paramArrayOfo)
    {
      AppMethodBeat.i(169799);
      if ((paramArrayOfo == null) || (paramArrayOfo.length == 0))
      {
        AppMethodBeat.o(169799);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfo.length;
      int i = 0;
      if (i < j)
      {
        o localo = paramArrayOfo[i];
        a locala = new a((byte)0);
        locala.file = localo;
        locala.time = localo.lastModified();
        if (localo.isDirectory())
        {
          locala.Kvc = com.tencent.mm.platformtools.f.Sh(localo.getName()).toUpperCase();
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
        paramArrayOfo[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfo[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static o[] b(o[] paramArrayOfo)
    {
      AppMethodBeat.i(232368);
      if ((paramArrayOfo == null) || (paramArrayOfo.length == 0))
      {
        AppMethodBeat.o(232368);
        return paramArrayOfo;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfo.length;
      int i = 0;
      if (i < j)
      {
        o localo = paramArrayOfo[i];
        if (!localo.isDirectory()) {
          localArrayList.add(localo);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(aa.z(localo.her())))
          {
            localHashSet.add(aa.z(localo.her()));
            localArrayList.add(localo);
          }
        }
      }
      paramArrayOfo = (o[])localArrayList.toArray(new o[0]);
      AppMethodBeat.o(232368);
      return paramArrayOfo;
    }
    
    private static boolean bfA(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean bfB(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean bfC(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static int bfq(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (bft(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689588;
      }
      if (bfr(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131230967;
      }
      if (bfy(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689576;
      }
      if (bfz(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689579;
      }
      if (bfu(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689571;
      }
      if (bfv(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689574;
      }
      if (bfw(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689560;
      }
      if (bx(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689567;
      }
      if (by(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689584;
      }
      if (df(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689587;
      }
      if (bfA(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689564;
      }
      if (bfB(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689569;
      }
      if (bfC(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689570;
      }
      AppMethodBeat.o(31999);
      return 2131689580;
    }
    
    private static boolean bfr(String paramString)
    {
      AppMethodBeat.i(32000);
      paramString = Util.nullAsNil(paramString).toLowerCase();
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
    
    private static boolean bft(String paramString)
    {
      AppMethodBeat.i(32004);
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
      {
        AppMethodBeat.o(32004);
        return true;
      }
      AppMethodBeat.o(32004);
      return false;
    }
    
    private static boolean bfu(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean bfv(String paramString)
    {
      AppMethodBeat.i(32006);
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
      {
        AppMethodBeat.o(32006);
        return true;
      }
      AppMethodBeat.o(32006);
      return false;
    }
    
    private static boolean bfw(String paramString)
    {
      AppMethodBeat.i(32007);
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
      {
        AppMethodBeat.o(32007);
        return true;
      }
      AppMethodBeat.o(32007);
      return false;
    }
    
    private static boolean bfy(String paramString)
    {
      AppMethodBeat.i(32003);
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".rar")) || (paramString.endsWith(".zip")) || (paramString.endsWith(".7z")) || (paramString.endsWith("tar")) || (paramString.endsWith(".iso")))
      {
        AppMethodBeat.o(32003);
        return true;
      }
      AppMethodBeat.o(32003);
      return false;
    }
    
    private static boolean bfz(String paramString)
    {
      AppMethodBeat.i(32008);
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".txt")) || (paramString.endsWith(".rtf")))
      {
        AppMethodBeat.o(32008);
        return true;
      }
      AppMethodBeat.o(32008);
      return false;
    }
    
    private static boolean bx(String paramString)
    {
      AppMethodBeat.i(32001);
      paramString = Util.nullAsNil(paramString).toLowerCase();
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
      paramString = Util.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
      {
        AppMethodBeat.o(32002);
        return true;
      }
      AppMethodBeat.o(32002);
      return false;
    }
    
    private static boolean df(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    public final void a(o paramo, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.KtW = paramo;
      if ((this.KtW != null) && (this.KtW.canRead()) && (this.KtW.isDirectory()))
      {
        this.KtX = this.KtW.a(new q()
        {
          public final boolean accept(o paramAnonymouso)
          {
            AppMethodBeat.i(169795);
            if (paramAnonymouso.isHidden())
            {
              AppMethodBeat.o(169795);
              return false;
            }
            if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymouso.isDirectory()))
            {
              AppMethodBeat.o(169795);
              return false;
            }
            AppMethodBeat.o(169795);
            return true;
          }
        });
        if (this.KtX == null) {
          this.KtX = new o[0];
        }
        if (this.KtX.length > 0)
        {
          this.KtX = b(this.KtX);
          a(this.KtX);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.KtX = new o[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.KtX[i] = new o((String)paramList.get(i));
          this.Kwn.add(this.KtX[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void c(o paramo, boolean paramBoolean)
    {
      this.Kva = paramo;
      this.Kvb = paramBoolean;
    }
    
    public final int eGR()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.Kwn.iterator();
      o localo;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(localo.length() + l))
      {
        localo = (o)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final int getCount()
    {
      return this.KtX.length;
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
        localView = View.inflate(paramViewGroup.getContext(), 2131494700, null);
        paramView = new b((byte)0);
        paramView.KuC = ((FrameLayout)localView.findViewById(2131302859));
        paramView.KuD = ((CheckBox)paramView.KuC.findViewById(2131302858));
        paramView.nnL = ((ImageView)localView.findViewById(2131302812));
        paramView.jVO = ((TextView)localView.findViewById(2131302870));
        paramView.Bvi = ((TextView)localView.findViewById(2131302863));
        paramView.timeTV = ((TextView)localView.findViewById(2131302868));
        paramView.KuC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31988);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = NewFileExplorerUI.a.this.KtX[i];
            paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(2131302858);
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
                u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759409, new Object[] { Integer.valueOf(9) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              long l = c.aqr();
              if (((o)localObject).length() >= l)
              {
                u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131759408, new Object[] { Util.getSizeKB(l) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              if (NewFileExplorerUI.a.by(((o)localObject).getName()))
              {
                com.tencent.mm.plugin.gallery.ui.a.a locala = com.tencent.mm.plugin.gallery.ui.a.a.azf(aa.z(((o)localObject).mUri));
                locala.mSize = c.aqq();
                if (locala.dSv() == 1)
                {
                  u.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(2131767109, new Object[] { Util.getSizeKB(c.aqq()) }), 0).show();
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
      o localo = this.KtX[paramInt];
      paramViewGroup.jVO.setText(localo.getName());
      int i;
      if (localo.isDirectory())
      {
        paramViewGroup.nnL.setImageResource(2131689563);
        paramViewGroup.KuC.setVisibility(4);
        paramViewGroup.Bvi.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(8);
        paramView = localo.a(new w()
        {
          public final boolean accept(o paramAnonymouso, String paramAnonymousString)
          {
            AppMethodBeat.i(232367);
            if (!paramAnonymousString.startsWith("."))
            {
              AppMethodBeat.o(232367);
              return true;
            }
            AppMethodBeat.o(232367);
            return false;
          }
        });
        if (paramView != null)
        {
          i = paramView.length;
          paramViewGroup.Bvi.setText(NewFileExplorerUI.this.getString(2131759385, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.KuD.setChecked(this.Kwn.contains(localo));
        paramViewGroup.KuC.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.KuC.setVisibility(0);
        paramViewGroup.Bvi.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(0);
        paramViewGroup.Bvi.setText(Util.getSizeKB(localo.length()));
        paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.i.f.c(NewFileExplorerUI.this, localo.lastModified(), true));
        if (bfr(localo.getName()))
        {
          paramView = aa.z(localo.mUri);
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
            paramViewGroup.nnL.setImageBitmap(paramView);
            break;
            label508:
            localCursor.close();
          }
          label521:
          paramViewGroup.nnL.setImageResource(bfq(localo.getName()));
        }
        else
        {
          paramViewGroup.nnL.setImageResource(bfq(localo.getName()));
        }
      }
    }
    
    public final ArrayList<String> gsD()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Kwn.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if ((!bfr(localo.getName())) && (!by(localo.getName()))) {
          localArrayList.add(aa.z(localo.mUri));
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> gsE()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Kwn.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (bfr(localo.getName())) {
          localArrayList.add(aa.z(localo.mUri));
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> gsF()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Kwn.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (by(localo.getName())) {
          localArrayList.add(aa.z(localo.mUri));
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final o gst()
    {
      AppMethodBeat.i(169798);
      if (this.KtW.hashCode() == this.Kva.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      o localo = this.KtW.heq();
      AppMethodBeat.o(169798);
      return localo;
    }
    
    final class a
    {
      String Kvc;
      o file;
      long time;
      
      private a() {}
    }
    
    final class b
    {
      public TextView Bvi;
      public FrameLayout KuC;
      public CheckBox KuD;
      public TextView jVO;
      public ImageView nnL;
      public TextView timeTV;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */