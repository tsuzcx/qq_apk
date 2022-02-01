package com.tencent.mm.pluginsdk.ui.tools;

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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.k.c;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a.b;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.ad;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import com.tencent.mm.vfs.y;
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
  private TextView Nnr;
  private a YtN;
  private TextView YtO;
  private FileSelectorFolderView YtP;
  private o.a YtQ;
  private FileSelectorFolderView.a YtR;
  private String hHa;
  private int mode;
  private ListView qgc;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.YtR = new FileSelectorFolderView.a()
    {
      public final void axd(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        Log.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(R.l.gHu);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(R.h.fHR));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(R.l.gHu);
          NewFileExplorerUI.b(NewFileExplorerUI.this).d(new u(com.tencent.mm.loader.i.b.bmC()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new u(com.tencent.mm.loader.i.b.bmC()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).d(new u(com.tencent.mm.loader.i.b.bmu()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new u(com.tencent.mm.loader.i.b.bmu()), null);
          NewFileExplorerUI.this.setMMTitle(R.l.gHv);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(R.l.gHv);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void Kh(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.YtN.iOp() != null))
      {
        this.YtN.a(this.YtN.iOp(), null);
        this.YtN.notifyDataSetChanged();
        iOD();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.YtN.iOE());
    localIntent.putStringArrayListExtra("key_select_video_list", this.YtN.iOG());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.YtN.iOF());
    localIntent.putExtra("GalleryUI_ToUser", this.hHa);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(32018);
  }
  
  private void evt()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.YtN).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(R.l.app_send) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.Nnr.setText(getString(R.l.gHw, new Object[] { Util.getSizeKB(this.YtN.gEF()) }));
      this.Nnr.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(R.l.app_send));
      enableOptionMenu(1, false);
    }
    this.Nnr.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void iOD()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.YtN) != null) && (a.c(this.YtN) != null))
    {
      Object localObject2 = ah.v(a.c(this.YtN).mUri).replace(ah.v(a.b(this.YtN).mUri), "");
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
    return R.i.gmy;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(32017);
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if ((paramIntent != null) && (a.a(this.YtN).size() != paramIntent.size()))
      {
        this.YtQ.pRv.dismiss();
        a.a(this.YtN).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.YtN).add(new u(str));
        }
        this.YtN.notifyDataSetChanged();
        iOD();
        evt();
      }
      AppMethodBeat.o(32017);
      return;
    }
    if (paramInt1 == 2) {
      a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    }
    AppMethodBeat.o(32017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32014);
    super.onCreate(paramBundle);
    this.hHa = getIntent().getStringExtra("TO_USER");
    this.qgc = ((ListView)findViewById(R.h.fHS));
    this.YtN = new a();
    this.Nnr = ((TextView)findViewById(R.h.fVM));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(R.l.gHx);
      setMMSubTitle(null);
      this.YtN.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.qgc.setAdapter(this.YtN);
      this.qgc.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).Yrz[paramAnonymousInt];
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
            paramAnonymousView = y.alV(ah.v(paramAnonymousAdapterView.mUri));
            a.b(NewFileExplorerUI.this, ah.v(paramAnonymousAdapterView.mUri), paramAnonymousView, 1);
          }
        }
      });
      this.qgc.setEmptyView(findViewById(R.h.fHO));
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
    for (int i = R.k.actionbar_quit_webview_icon;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        addTextOptionMenu(1, getString(R.l.app_send), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(31982);
            NewFileExplorerUI.e(NewFileExplorerUI.this);
            AppMethodBeat.o(31982);
            return true;
          }
        }, null, y.b.adEJ);
      }
      evt();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(R.l.gHu);
      setMMSubTitle(null);
      this.YtO = ((TextView)findViewById(R.h.fHR));
      this.YtO.setText(R.l.gHu);
      this.YtN.d(new u(com.tencent.mm.loader.i.b.bmC()), true);
      this.YtN.a(new u(com.tencent.mm.loader.i.b.bmC()), null);
      if (this.YtN.getCount() == 0)
      {
        this.YtN.d(new u(com.tencent.mm.loader.i.b.bmu()), false);
        this.YtN.a(new u(com.tencent.mm.loader.i.b.bmu()), null);
        setMMTitle(R.l.gHv);
        this.YtO.setText(R.l.gHv);
      }
      findViewById(R.h.fHP).setVisibility(0);
      findViewById(R.h.fHP).setOnClickListener(new NewFileExplorerUI.1(this));
      this.YtP = ((FileSelectorFolderView)findViewById(R.h.fHQ));
      this.YtP.setListener(this.YtR);
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
      Kh(false);
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
    private u Yry;
    u[] Yrz;
    private u YsG;
    private boolean YsH;
    private ArrayList<u> YtT;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.Yrz = new u[0];
      this.YsH = false;
      this.YtT = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(u[] paramArrayOfu)
    {
      AppMethodBeat.i(169799);
      if ((paramArrayOfu == null) || (paramArrayOfu.length == 0))
      {
        AppMethodBeat.o(169799);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfu.length;
      int i = 0;
      if (i < j)
      {
        u localu = paramArrayOfu[i];
        a locala = new a((byte)0);
        locala.file = localu;
        locala.time = localu.lastModified();
        if (localu.isDirectory())
        {
          locala.YsI = com.tencent.mm.platformtools.f.RZ(localu.getName()).toUpperCase();
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
        paramArrayOfu[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfu[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static u[] b(u[] paramArrayOfu)
    {
      AppMethodBeat.i(245744);
      if ((paramArrayOfu == null) || (paramArrayOfu.length == 0))
      {
        AppMethodBeat.o(245744);
        return paramArrayOfu;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfu.length;
      int i = 0;
      if (i < j)
      {
        u localu = paramArrayOfu[i];
        if (!localu.isDirectory()) {
          localArrayList.add(localu);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(ah.v(localu.jKT())))
          {
            localHashSet.add(ah.v(localu.jKT()));
            localArrayList.add(localu);
          }
        }
      }
      paramArrayOfu = (u[])localArrayList.toArray(new u[0]);
      AppMethodBeat.o(245744);
      return paramArrayOfu;
    }
    
    private static int brA(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (brD(paramString))
      {
        i = R.k.app_attach_file_icon_word;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brB(paramString))
      {
        i = R.g.app_attach_file_icon_pic;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brI(paramString))
      {
        i = R.k.app_attach_file_icon_rar;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brJ(paramString))
      {
        i = R.k.app_attach_file_icon_txt;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brE(paramString))
      {
        i = R.k.app_attach_file_icon_pdf;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brF(paramString))
      {
        i = R.k.app_attach_file_icon_ppt;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brG(paramString))
      {
        i = R.k.app_attach_file_icon_excel;
        AppMethodBeat.o(31999);
        return i;
      }
      if (df(paramString))
      {
        i = R.k.app_attach_file_icon_music;
        AppMethodBeat.o(31999);
        return i;
      }
      if (isVideo(paramString))
      {
        i = R.k.app_attach_file_icon_video;
        AppMethodBeat.o(31999);
        return i;
      }
      if (eL(paramString))
      {
        i = R.k.app_attach_file_icon_webpage;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brK(paramString))
      {
        i = R.k.app_attach_file_icon_keynote;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brL(paramString))
      {
        i = R.k.app_attach_file_icon_number;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brM(paramString))
      {
        i = R.k.app_attach_file_icon_page;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brN(paramString))
      {
        i = R.k.app_attach_file_icon_ofd;
        AppMethodBeat.o(31999);
        return i;
      }
      int i = R.k.app_attach_file_icon_unknow;
      AppMethodBeat.o(31999);
      return i;
    }
    
    private static boolean brB(String paramString)
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
    
    private static boolean brD(String paramString)
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
    
    private static boolean brE(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean brF(String paramString)
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
    
    private static boolean brG(String paramString)
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
    
    private static boolean brI(String paramString)
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
    
    private static boolean brJ(String paramString)
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
    
    private static boolean brK(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean brL(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean brM(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static boolean brN(String paramString)
    {
      AppMethodBeat.i(245793);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".ofd");
      AppMethodBeat.o(245793);
      return bool;
    }
    
    private static boolean df(String paramString)
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
    
    private static boolean eL(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    private static boolean isVideo(String paramString)
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
    
    public final void a(u paramu, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.Yry = paramu;
      if ((this.Yry != null) && (this.Yry.jKQ()) && (this.Yry.isDirectory()))
      {
        this.Yrz = this.Yry.a(new w()
        {
          public final boolean accept(u paramAnonymousu)
          {
            AppMethodBeat.i(169795);
            if (paramAnonymousu.isHidden())
            {
              AppMethodBeat.o(169795);
              return false;
            }
            if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymousu.isDirectory()))
            {
              AppMethodBeat.o(169795);
              return false;
            }
            AppMethodBeat.o(169795);
            return true;
          }
        });
        if (this.Yrz == null) {
          this.Yrz = new u[0];
        }
        if (this.Yrz.length > 0)
        {
          this.Yrz = b(this.Yrz);
          a(this.Yrz);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.Yrz = new u[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.Yrz[i] = new u((String)paramList.get(i));
          this.YtT.add(this.Yrz[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void d(u paramu, boolean paramBoolean)
    {
      this.YsG = paramu;
      this.YsH = paramBoolean;
    }
    
    public final int gEF()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.YtT.iterator();
      u localu;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(localu.length() + l))
      {
        localu = (u)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final int getCount()
    {
      return this.Yrz.length;
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
        localView = View.inflate(paramViewGroup.getContext(), R.i.gkb, null);
        paramView = new b((byte)0);
        paramView.Yse = ((FrameLayout)localView.findViewById(R.h.fLG));
        paramView.Ysf = ((CheckBox)paramView.Yse.findViewById(R.h.fLF));
        paramView.ttT = ((ImageView)localView.findViewById(R.h.item_icon));
        paramView.pJJ = ((TextView)localView.findViewById(R.h.item_title));
        paramView.Nnr = ((TextView)localView.findViewById(R.h.fLI));
        paramView.timeTV = ((TextView)localView.findViewById(R.h.fLK));
        paramView.Yse.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31988);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = NewFileExplorerUI.a.this.Yrz[i];
            paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(R.h.fLF);
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
                aa.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.l.gHN, new Object[] { Integer.valueOf(9) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              long l = c.aRk();
              if (((u)localObject).length() >= l)
              {
                aa.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.l.gHM, new Object[] { Util.getSizeKB(l) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              paramAnonymousView.setChecked(true);
              NewFileExplorerUI.a.a(NewFileExplorerUI.a.this).add(localObject);
            }
          }
        });
        localView.setTag(paramView);
      }
      paramViewGroup = (b)localView.getTag();
      u localu = this.Yrz[paramInt];
      paramViewGroup.pJJ.setText(localu.getName());
      int i;
      if (localu.isDirectory())
      {
        paramViewGroup.ttT.setImageResource(R.k.app_attach_file_icon_folders);
        paramViewGroup.Yse.setVisibility(4);
        paramViewGroup.Nnr.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(8);
        paramView = localu.a(new ad()
        {
          public final boolean accept(u paramAnonymousu, String paramAnonymousString)
          {
            AppMethodBeat.i(245628);
            if (!paramAnonymousString.startsWith("."))
            {
              AppMethodBeat.o(245628);
              return true;
            }
            AppMethodBeat.o(245628);
            return false;
          }
        });
        if (paramView != null)
        {
          i = paramView.length;
          paramViewGroup.Nnr.setText(NewFileExplorerUI.this.getString(R.l.gHs, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.Ysf.setChecked(this.YtT.contains(localu));
        paramViewGroup.Yse.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.Yse.setVisibility(0);
        paramViewGroup.Nnr.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(0);
        paramViewGroup.Nnr.setText(Util.getSizeKB(localu.length()));
        paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.platformtools.f.d(NewFileExplorerUI.this, localu.lastModified(), true));
        if (brB(localu.getName()))
        {
          paramView = ah.v(localu.mUri);
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
            paramViewGroup.ttT.setImageBitmap(paramView);
            break;
            label508:
            localCursor.close();
          }
          label521:
          paramViewGroup.ttT.setImageResource(brA(localu.getName()));
        }
        else
        {
          paramViewGroup.ttT.setImageResource(brA(localu.getName()));
        }
      }
    }
    
    public final ArrayList<String> iOE()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.YtT.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if ((!brB(localu.getName())) && (!isVideo(localu.getName()))) {
          localArrayList.add(ah.v(localu.mUri));
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> iOF()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.YtT.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (brB(localu.getName())) {
          localArrayList.add(ah.v(localu.mUri));
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> iOG()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.YtT.iterator();
      while (localIterator.hasNext())
      {
        u localu = (u)localIterator.next();
        if (isVideo(localu.getName())) {
          localArrayList.add(ah.v(localu.mUri));
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final u iOp()
    {
      AppMethodBeat.i(169798);
      if (this.Yry.hashCode() == this.YsG.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      u localu = this.Yry.jKP();
      AppMethodBeat.o(169798);
      return localu;
    }
    
    final class a
    {
      String YsI;
      u file;
      long time;
      
      private a() {}
    }
    
    final class b
    {
      public TextView Nnr;
      public FrameLayout Yse;
      public CheckBox Ysf;
      public TextView pJJ;
      public TextView timeTV;
      public ImageView ttT;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */