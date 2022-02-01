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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.n.c;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
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
  private TextView HpD;
  private o.a RxA;
  private FileSelectorFolderView.a RxB;
  private a Rxx;
  private TextView Rxy;
  private FileSelectorFolderView Rxz;
  private String fCl;
  private int mode;
  private ListView niO;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.RxB = new FileSelectorFolderView.a()
    {
      public final void aqX(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        Log.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(R.l.eEB);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(R.h.dGK));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(R.l.eEB);
          NewFileExplorerUI.b(NewFileExplorerUI.this).d(new q(com.tencent.mm.loader.j.b.aSO()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new q(com.tencent.mm.loader.j.b.aSO()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).d(new q(com.tencent.mm.loader.j.b.aSG()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new q(com.tencent.mm.loader.j.b.aSG()), null);
          NewFileExplorerUI.this.setMMTitle(R.l.eEC);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(R.l.eEC);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void Ev(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.Rxx.hnx() != null))
      {
        this.Rxx.a(this.Rxx.hnx(), null);
        this.Rxx.notifyDataSetChanged();
        hnK();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.Rxx.hnL());
    localIntent.putStringArrayListExtra("key_select_video_list", this.Rxx.hnN());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.Rxx.hnM());
    localIntent.putExtra("GalleryUI_ToUser", this.fCl);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(32018);
  }
  
  private void dFf()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.Rxx).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(R.l.app_send) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.HpD.setText(getString(R.l.eED, new Object[] { Util.getSizeKB(this.Rxx.fsW()) }));
      this.HpD.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(R.l.app_send));
      enableOptionMenu(1, false);
    }
    this.HpD.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void hnK()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.Rxx) != null) && (a.c(this.Rxx) != null))
    {
      Object localObject2 = a.c(this.Rxx).getPath().replace(a.b(this.Rxx).getPath(), "");
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
    return R.i.ejx;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(32017);
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if ((paramIntent != null) && (a.a(this.Rxx).size() != paramIntent.size()))
      {
        this.RxA.mUO.dismiss();
        a.a(this.Rxx).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.Rxx).add(new q(str));
        }
        this.Rxx.notifyDataSetChanged();
        hnK();
        dFf();
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
    this.fCl = getIntent().getStringExtra("TO_USER");
    this.niO = ((ListView)findViewById(R.h.dGL));
    this.Rxx = new a();
    this.HpD = ((TextView)findViewById(R.h.dTE));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(R.l.eEE);
      setMMSubTitle(null);
      this.Rxx.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.niO.setAdapter(this.Rxx);
      this.niO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).Rvd[paramAnonymousInt];
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
            paramAnonymousView = u.asq(paramAnonymousAdapterView.getPath());
            a.b(NewFileExplorerUI.this, paramAnonymousAdapterView.getPath(), paramAnonymousView, 1);
          }
        }
      });
      this.niO.setEmptyView(findViewById(R.h.dGH));
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
        }, null, w.b.Wao);
      }
      dFf();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(R.l.eEB);
      setMMSubTitle(null);
      this.Rxy = ((TextView)findViewById(R.h.dGK));
      this.Rxy.setText(R.l.eEB);
      this.Rxx.d(new q(com.tencent.mm.loader.j.b.aSO()), true);
      this.Rxx.a(new q(com.tencent.mm.loader.j.b.aSO()), null);
      if (this.Rxx.getCount() == 0)
      {
        this.Rxx.d(new q(com.tencent.mm.loader.j.b.aSG()), false);
        this.Rxx.a(new q(com.tencent.mm.loader.j.b.aSG()), null);
        setMMTitle(R.l.eEC);
        this.Rxy.setText(R.l.eEC);
      }
      findViewById(R.h.dGI).setVisibility(0);
      findViewById(R.h.dGI).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(31979);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (NewFileExplorerUI.a(NewFileExplorerUI.this) != null)
          {
            paramAnonymousView = NewFileExplorerUI.a(NewFileExplorerUI.this);
            if (paramAnonymousView.py) {
              break label86;
            }
          }
          label86:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.rY(bool);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(31979);
            return;
          }
        }
      });
      this.Rxz = ((FileSelectorFolderView)findViewById(R.h.dGJ));
      this.Rxz.setListener(this.RxB);
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
      Ev(false);
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
    private q Rvc;
    q[] Rvd;
    private q Rwl;
    private boolean Rwm;
    private ArrayList<q> RxD;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.Rvd = new q[0];
      this.Rwm = false;
      this.RxD = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(q[] paramArrayOfq)
    {
      AppMethodBeat.i(169799);
      if ((paramArrayOfq == null) || (paramArrayOfq.length == 0))
      {
        AppMethodBeat.o(169799);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfq.length;
      int i = 0;
      if (i < j)
      {
        q localq = paramArrayOfq[i];
        a locala = new a((byte)0);
        locala.file = localq;
        locala.time = localq.lastModified();
        if (localq.isDirectory())
        {
          locala.Rwn = com.tencent.mm.platformtools.f.ZJ(localq.getName()).toUpperCase();
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
        paramArrayOfq[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfq[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static q[] b(q[] paramArrayOfq)
    {
      AppMethodBeat.i(289429);
      if ((paramArrayOfq == null) || (paramArrayOfq.length == 0))
      {
        AppMethodBeat.o(289429);
        return paramArrayOfq;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfq.length;
      int i = 0;
      if (i < j)
      {
        q localq = paramArrayOfq[i];
        if (!localq.isDirectory()) {
          localArrayList.add(localq);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(localq.bOF()))
          {
            localHashSet.add(localq.bOF());
            localArrayList.add(localq);
          }
        }
      }
      paramArrayOfq = (q[])localArrayList.toArray(new q[0]);
      AppMethodBeat.o(289429);
      return paramArrayOfq;
    }
    
    private static boolean bI(String paramString)
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
    
    private static boolean bJ(String paramString)
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
    
    private static int brL(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (brO(paramString))
      {
        i = R.k.app_attach_file_icon_word;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brM(paramString))
      {
        i = R.g.app_attach_file_icon_pic;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brT(paramString))
      {
        i = R.k.app_attach_file_icon_rar;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brU(paramString))
      {
        i = R.k.app_attach_file_icon_txt;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brP(paramString))
      {
        i = R.k.app_attach_file_icon_pdf;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brQ(paramString))
      {
        i = R.k.app_attach_file_icon_ppt;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brR(paramString))
      {
        i = R.k.app_attach_file_icon_excel;
        AppMethodBeat.o(31999);
        return i;
      }
      if (bI(paramString))
      {
        i = R.k.app_attach_file_icon_music;
        AppMethodBeat.o(31999);
        return i;
      }
      if (bJ(paramString))
      {
        i = R.k.app_attach_file_icon_video;
        AppMethodBeat.o(31999);
        return i;
      }
      if (dA(paramString))
      {
        i = R.k.app_attach_file_icon_webpage;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brV(paramString))
      {
        i = R.k.app_attach_file_icon_keynote;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brW(paramString))
      {
        i = R.k.app_attach_file_icon_number;
        AppMethodBeat.o(31999);
        return i;
      }
      if (brX(paramString))
      {
        i = R.k.app_attach_file_icon_page;
        AppMethodBeat.o(31999);
        return i;
      }
      int i = R.k.app_attach_file_icon_unknow;
      AppMethodBeat.o(31999);
      return i;
    }
    
    private static boolean brM(String paramString)
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
    
    private static boolean brO(String paramString)
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
    
    private static boolean brP(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean brQ(String paramString)
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
    
    private static boolean brR(String paramString)
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
    
    private static boolean brT(String paramString)
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
    
    private static boolean brU(String paramString)
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
    
    private static boolean brV(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean brW(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean brX(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static boolean dA(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    public final void a(q paramq, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.Rvc = paramq;
      if ((this.Rvc != null) && (this.Rvc.ifC()) && (this.Rvc.isDirectory()))
      {
        this.Rvd = this.Rvc.a(new s()
        {
          public final boolean accept(q paramAnonymousq)
          {
            AppMethodBeat.i(169795);
            if (paramAnonymousq.isHidden())
            {
              AppMethodBeat.o(169795);
              return false;
            }
            if ((NewFileExplorerUI.a.d(NewFileExplorerUI.a.this)) && (paramAnonymousq.isDirectory()))
            {
              AppMethodBeat.o(169795);
              return false;
            }
            AppMethodBeat.o(169795);
            return true;
          }
        });
        if (this.Rvd == null) {
          this.Rvd = new q[0];
        }
        if (this.Rvd.length > 0)
        {
          this.Rvd = b(this.Rvd);
          a(this.Rvd);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.Rvd = new q[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.Rvd[i] = new q((String)paramList.get(i));
          this.RxD.add(this.Rvd[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void d(q paramq, boolean paramBoolean)
    {
      this.Rwl = paramq;
      this.Rwm = paramBoolean;
    }
    
    public final int fsW()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.RxD.iterator();
      q localq;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(localq.length() + l))
      {
        localq = (q)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final int getCount()
    {
      return this.Rvd.length;
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
        localView = View.inflate(paramViewGroup.getContext(), R.i.ehg, null);
        paramView = new b((byte)0);
        paramView.RvJ = ((FrameLayout)localView.findViewById(R.h.dKl));
        paramView.RvK = ((CheckBox)paramView.RvJ.findViewById(R.h.dKk));
        paramView.qps = ((ImageView)localView.findViewById(R.h.item_icon));
        paramView.mNb = ((TextView)localView.findViewById(R.h.item_title));
        paramView.HpD = ((TextView)localView.findViewById(R.h.dKn));
        paramView.timeTV = ((TextView)localView.findViewById(R.h.dKp));
        paramView.RvJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(31988);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = NewFileExplorerUI.a.this.Rvd[i];
            paramAnonymousView = (CheckBox)paramAnonymousView.findViewById(R.h.dKk);
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
                w.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.l.eEU, new Object[] { Integer.valueOf(9) }), 0).show();
                paramAnonymousView.setChecked(false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$FileExplorerAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(31988);
                return;
              }
              long l = c.awK();
              if (((q)localObject).length() >= l)
              {
                w.makeText(NewFileExplorerUI.this.getContext(), NewFileExplorerUI.this.getString(R.l.eET, new Object[] { Util.getSizeKB(l) }), 0).show();
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
      q localq = this.Rvd[paramInt];
      paramViewGroup.mNb.setText(localq.getName());
      int i;
      if (localq.isDirectory())
      {
        paramViewGroup.qps.setImageResource(R.k.app_attach_file_icon_folders);
        paramViewGroup.RvJ.setVisibility(4);
        paramViewGroup.HpD.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(8);
        paramView = localq.a(new z()
        {
          public final boolean accept(q paramAnonymousq, String paramAnonymousString)
          {
            AppMethodBeat.i(275369);
            if (!paramAnonymousString.startsWith("."))
            {
              AppMethodBeat.o(275369);
              return true;
            }
            AppMethodBeat.o(275369);
            return false;
          }
        });
        if (paramView != null)
        {
          i = paramView.length;
          paramViewGroup.HpD.setText(NewFileExplorerUI.this.getString(R.l.eEz, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.RvK.setChecked(this.RxD.contains(localq));
        paramViewGroup.RvJ.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.RvJ.setVisibility(0);
        paramViewGroup.HpD.setVisibility(0);
        paramViewGroup.timeTV.setVisibility(0);
        paramViewGroup.HpD.setText(Util.getSizeKB(localq.length()));
        paramViewGroup.timeTV.setText(com.tencent.mm.pluginsdk.j.f.d(NewFileExplorerUI.this, localq.lastModified(), true));
        if (brM(localq.getName()))
        {
          paramView = localq.getPath();
          Cursor localCursor = NewFileExplorerUI.this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { paramView }, null);
          paramView = localObject;
          if (localCursor != null)
          {
            if (!localCursor.moveToFirst()) {
              break label505;
            }
            i = localCursor.getInt(localCursor.getColumnIndex("_id"));
            localCursor.close();
          }
          for (paramView = MediaStore.Images.Thumbnails.getThumbnail(NewFileExplorerUI.this.getContentResolver(), i, 3, null);; paramView = localObject)
          {
            if (paramView == null) {
              break label518;
            }
            paramViewGroup.qps.setImageBitmap(paramView);
            break;
            label505:
            localCursor.close();
          }
          label518:
          paramViewGroup.qps.setImageResource(brL(localq.getName()));
        }
        else
        {
          paramViewGroup.qps.setImageResource(brL(localq.getName()));
        }
      }
    }
    
    public final ArrayList<String> hnL()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.RxD.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if ((!brM(localq.getName())) && (!bJ(localq.getName()))) {
          localArrayList.add(localq.getPath());
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> hnM()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.RxD.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (brM(localq.getName())) {
          localArrayList.add(localq.getPath());
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> hnN()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.RxD.iterator();
      while (localIterator.hasNext())
      {
        q localq = (q)localIterator.next();
        if (bJ(localq.getName())) {
          localArrayList.add(localq.getPath());
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final q hnx()
    {
      AppMethodBeat.i(169798);
      if (this.Rvc.hashCode() == this.Rwl.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      q localq = this.Rvc.ifB();
      AppMethodBeat.o(169798);
      return localq;
    }
    
    final class a
    {
      String Rwn;
      q file;
      long time;
      
      private a() {}
    }
    
    final class b
    {
      public TextView HpD;
      public FrameLayout RvJ;
      public CheckBox RvK;
      public TextView mNb;
      public ImageView qps;
      public TextView timeTV;
      
      private b() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */