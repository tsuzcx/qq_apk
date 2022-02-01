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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI
  extends MMActivity
{
  private a FkC;
  private TextView FkD;
  private FileSelectorFolderView FkE;
  private o.a FkF;
  private FileSelectorFolderView.a FkG;
  private String drf;
  private ListView jpT;
  private int mode;
  private TextView xfn;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(32013);
    this.mode = 0;
    this.FkG = new FileSelectorFolderView.a()
    {
      public final void Zv(int paramAnonymousInt)
      {
        AppMethodBeat.i(31985);
        ad.i("MicroMsg.FileExplorerUI", "position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 0)
        {
          NewFileExplorerUI.this.setMMTitle(2131759059);
          NewFileExplorerUI.this.setMMSubTitle(null);
          NewFileExplorerUI.a(NewFileExplorerUI.this, (TextView)NewFileExplorerUI.this.findViewById(2131299915));
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759059);
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new e(com.tencent.mm.loader.j.b.arX()), true);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new e(com.tencent.mm.loader.j.b.arX()), null);
        }
        for (;;)
        {
          NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
          NewFileExplorerUI.c(NewFileExplorerUI.this);
          AppMethodBeat.o(31985);
          return;
          NewFileExplorerUI.b(NewFileExplorerUI.this).c(new e(com.tencent.mm.loader.j.b.arP()), false);
          NewFileExplorerUI.b(NewFileExplorerUI.this).a(new e(com.tencent.mm.loader.j.b.arP()), null);
          NewFileExplorerUI.this.setMMTitle(2131759060);
          NewFileExplorerUI.g(NewFileExplorerUI.this).setText(2131759060);
        }
      }
    };
    AppMethodBeat.o(32013);
  }
  
  private void dBh()
  {
    AppMethodBeat.i(32019);
    int i = a.a(this.FkC).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(2131755884) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.xfn.setText(getString(2131759061, new Object[] { bt.sy(this.FkC.dCM()) }));
      this.xfn.setVisibility(0);
      AppMethodBeat.o(32019);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(2131755884));
      enableOptionMenu(1, false);
    }
    this.xfn.setVisibility(8);
    AppMethodBeat.o(32019);
  }
  
  private void ffj()
  {
    AppMethodBeat.i(32020);
    if ((a.b(this.FkC) != null) && (a.c(this.FkC) != null))
    {
      Object localObject2 = q.B(a.c(this.FkC).mUri).replace(q.B(a.b(this.FkC).mUri), "");
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
  
  private void wi(boolean paramBoolean)
  {
    AppMethodBeat.i(32018);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.FkC.ffn() != null))
      {
        this.FkC.a(this.FkC.ffn(), null);
        this.FkC.notifyDataSetChanged();
        ffj();
        AppMethodBeat.o(32018);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(32018);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.FkC.ffk());
    localIntent.putStringArrayListExtra("key_select_video_list", this.FkC.ffm());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.FkC.ffl());
    localIntent.putExtra("GalleryUI_ToUser", this.drf);
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
      if ((paramIntent != null) && (a.a(this.FkC).size() != paramIntent.size()))
      {
        this.FkF.jcs.dismiss();
        a.a(this.FkC).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          a.a(this.FkC).add(new e(str));
        }
        this.FkC.notifyDataSetChanged();
        ffj();
        dBh();
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
    this.drf = getIntent().getStringExtra("TO_USER");
    this.jpT = ((ListView)findViewById(2131299917));
    this.FkC = new a();
    this.xfn = ((TextView)findViewById(2131304541));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(2131759062);
      setMMSubTitle(null);
      this.FkC.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.jpT.setAdapter(this.FkC);
      this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(31980);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/NewFileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).FjG[paramAnonymousInt];
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
            paramAnonymousView = com.tencent.mm.vfs.i.ZF(q.B(paramAnonymousAdapterView.mUri));
            a.b(NewFileExplorerUI.this, q.B(paramAnonymousAdapterView.mUri), paramAnonymousView, 1);
          }
        }
      });
      this.jpT.setEmptyView(findViewById(2131299912));
      paramBundle = new NewFileExplorerUI.3(this);
      if (this.mode != 0) {
        break label417;
      }
    }
    label417:
    for (int i = 2131689508;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        addTextOptionMenu(1, getString(2131755884), new NewFileExplorerUI.4(this), null, s.b.JbS);
      }
      dBh();
      AppMethodBeat.o(32014);
      return;
      setMMTitle(2131759059);
      setMMSubTitle(null);
      this.FkD = ((TextView)findViewById(2131299915));
      this.FkD.setText(2131759059);
      this.FkC.c(new e(com.tencent.mm.loader.j.b.arX()), true);
      this.FkC.a(new e(com.tencent.mm.loader.j.b.arX()), null);
      if (this.FkC.getCount() == 0)
      {
        this.FkC.c(new e(com.tencent.mm.loader.j.b.arP()), false);
        this.FkC.a(new e(com.tencent.mm.loader.j.b.arP()), null);
        setMMTitle(2131759060);
        this.FkD.setText(2131759060);
      }
      findViewById(2131299913).setVisibility(0);
      findViewById(2131299913).setOnClickListener(new NewFileExplorerUI.1(this));
      this.FkE = ((FileSelectorFolderView)findViewById(2131299914));
      this.FkE.setListener(this.FkG);
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
      wi(false);
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
    private e FjF;
    e[] FjG;
    private e FkI;
    private boolean FkJ;
    private ArrayList<e> FkK;
    
    public a()
    {
      AppMethodBeat.i(31990);
      this.FjG = new e[0];
      this.FkJ = false;
      this.FkK = new ArrayList();
      AppMethodBeat.o(31990);
    }
    
    private void a(e[] paramArrayOfe)
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
        e locale = paramArrayOfe[i];
        NewFileExplorerUI.a.a locala = new NewFileExplorerUI.a.a(this, (byte)0);
        locala.aXd = locale;
        locala.time = locale.lastModified();
        if (locale.isDirectory())
        {
          locala.FkM = f.IL(locale.getName()).toUpperCase();
          ((List)localObject2).add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(locala);
        }
      }
      Collections.sort((List)localObject2, new NewFileExplorerUI.a.2(this));
      Collections.sort((List)localObject1, new NewFileExplorerUI.a.3(this));
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfe[i] = ((NewFileExplorerUI.a.a)((Iterator)localObject2).next()).aXd;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfe[i] = ((NewFileExplorerUI.a.a)((Iterator)localObject1).next()).aXd;
        i += 1;
      }
      AppMethodBeat.o(169799);
    }
    
    private static boolean aNA(String paramString)
    {
      AppMethodBeat.i(32009);
      boolean bool = bt.nullAsNil(paramString).toLowerCase().endsWith(".key");
      AppMethodBeat.o(32009);
      return bool;
    }
    
    private static boolean aNB(String paramString)
    {
      AppMethodBeat.i(32011);
      boolean bool = bt.nullAsNil(paramString).toLowerCase().endsWith(".number");
      AppMethodBeat.o(32011);
      return bool;
    }
    
    private static boolean aNC(String paramString)
    {
      AppMethodBeat.i(32012);
      boolean bool = bt.nullAsNil(paramString).toLowerCase().endsWith(".pages");
      AppMethodBeat.o(32012);
      return bool;
    }
    
    private static int aNp(String paramString)
    {
      AppMethodBeat.i(31999);
      paramString = paramString.toLowerCase();
      if (aNv(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689585;
      }
      if (aNq(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131230944;
      }
      if (aNu(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689573;
      }
      if (aNz(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689576;
      }
      if (aNw(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689568;
      }
      if (aNx(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689571;
      }
      if (aNy(paramString))
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
      if (cI(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689584;
      }
      if (aNA(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689561;
      }
      if (aNB(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689566;
      }
      if (aNC(paramString))
      {
        AppMethodBeat.o(31999);
        return 2131689567;
      }
      AppMethodBeat.o(31999);
      return 2131689577;
    }
    
    private static boolean aNq(String paramString)
    {
      AppMethodBeat.i(32000);
      paramString = bt.nullAsNil(paramString).toLowerCase();
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
    
    private static boolean aNu(String paramString)
    {
      AppMethodBeat.i(32003);
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".rar")) || (paramString.endsWith(".zip")) || (paramString.endsWith(".7z")) || (paramString.endsWith("tar")) || (paramString.endsWith(".iso")))
      {
        AppMethodBeat.o(32003);
        return true;
      }
      AppMethodBeat.o(32003);
      return false;
    }
    
    private static boolean aNv(String paramString)
    {
      AppMethodBeat.i(32004);
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
      {
        AppMethodBeat.o(32004);
        return true;
      }
      AppMethodBeat.o(32004);
      return false;
    }
    
    private static boolean aNw(String paramString)
    {
      AppMethodBeat.i(32005);
      boolean bool = bt.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
      AppMethodBeat.o(32005);
      return bool;
    }
    
    private static boolean aNx(String paramString)
    {
      AppMethodBeat.i(32006);
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
      {
        AppMethodBeat.o(32006);
        return true;
      }
      AppMethodBeat.o(32006);
      return false;
    }
    
    private static boolean aNy(String paramString)
    {
      AppMethodBeat.i(32007);
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
      {
        AppMethodBeat.o(32007);
        return true;
      }
      AppMethodBeat.o(32007);
      return false;
    }
    
    private static boolean aNz(String paramString)
    {
      AppMethodBeat.i(32008);
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".txt")) || (paramString.endsWith(".rtf")))
      {
        AppMethodBeat.o(32008);
        return true;
      }
      AppMethodBeat.o(32008);
      return false;
    }
    
    private static e[] b(e[] paramArrayOfe)
    {
      AppMethodBeat.i(193540);
      if ((paramArrayOfe == null) || (paramArrayOfe.length == 0))
      {
        AppMethodBeat.o(193540);
        return paramArrayOfe;
      }
      HashSet localHashSet = new HashSet();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfe.length;
      int i = 0;
      if (i < j)
      {
        e locale = paramArrayOfe[i];
        if (!locale.isDirectory()) {
          localArrayList.add(locale);
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localHashSet.contains(q.B(locale.fOK())))
          {
            localHashSet.add(q.B(locale.fOK()));
            localArrayList.add(locale);
          }
        }
      }
      paramArrayOfe = (e[])localArrayList.toArray(new e[0]);
      AppMethodBeat.o(193540);
      return paramArrayOfe;
    }
    
    private static boolean bx(String paramString)
    {
      AppMethodBeat.i(32001);
      paramString = bt.nullAsNil(paramString).toLowerCase();
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
      paramString = bt.nullAsNil(paramString).toLowerCase();
      if ((paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
      {
        AppMethodBeat.o(32002);
        return true;
      }
      AppMethodBeat.o(32002);
      return false;
    }
    
    private static boolean cI(String paramString)
    {
      AppMethodBeat.i(32010);
      boolean bool = bt.nullAsNil(paramString).toLowerCase().endsWith(".html");
      AppMethodBeat.o(32010);
      return bool;
    }
    
    public final void a(e parame, List<String> paramList)
    {
      AppMethodBeat.i(169797);
      this.FjF = parame;
      if ((this.FjF != null) && (this.FjF.canRead()) && (this.FjF.isDirectory()))
      {
        this.FjG = this.FjF.a(new NewFileExplorerUI.a.1(this));
        if (this.FjG == null) {
          this.FjG = new e[0];
        }
        if (this.FjG.length > 0)
        {
          this.FjG = b(this.FjG);
          a(this.FjG);
          AppMethodBeat.o(169797);
        }
      }
      else if (paramList != null)
      {
        this.FjG = new e[paramList.size()];
        int i = 0;
        while (i < paramList.size())
        {
          this.FjG[i] = new e((String)paramList.get(i));
          this.FkK.add(this.FjG[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(169797);
    }
    
    public final void c(e parame, boolean paramBoolean)
    {
      this.FkI = parame;
      this.FkJ = paramBoolean;
    }
    
    public final int dCM()
    {
      AppMethodBeat.i(31992);
      Iterator localIterator = this.FkK.iterator();
      e locale;
      long l;
      for (int i = 0; localIterator.hasNext(); i = (int)(locale.length() + l))
      {
        locale = (e)localIterator.next();
        l = i;
      }
      AppMethodBeat.o(31992);
      return i;
    }
    
    public final ArrayList<String> ffk()
    {
      AppMethodBeat.i(31993);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FkK.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if ((!aNq(locale.getName())) && (!by(locale.getName()))) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31993);
      return localArrayList;
    }
    
    public final ArrayList<String> ffl()
    {
      AppMethodBeat.i(31994);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FkK.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (aNq(locale.getName())) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31994);
      return localArrayList;
    }
    
    public final ArrayList<String> ffm()
    {
      AppMethodBeat.i(31995);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.FkK.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (by(locale.getName())) {
          localArrayList.add(q.B(locale.mUri));
        }
      }
      AppMethodBeat.o(31995);
      return localArrayList;
    }
    
    public final e ffn()
    {
      AppMethodBeat.i(169798);
      if (this.FjF.hashCode() == this.FkI.hashCode())
      {
        AppMethodBeat.o(169798);
        return null;
      }
      e locale = this.FjF.fOJ();
      AppMethodBeat.o(169798);
      return locale;
    }
    
    public final int getCount()
    {
      return this.FjG.length;
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
        paramView = new NewFileExplorerUI.a.b(this, (byte)0);
        paramView.FkN = ((FrameLayout)localView.findViewById(2131301187));
        paramView.FkO = ((CheckBox)paramView.FkN.findViewById(2131301186));
        paramView.lZa = ((ImageView)localView.findViewById(2131301154));
        paramView.iVq = ((TextView)localView.findViewById(2131301198));
        paramView.xfn = ((TextView)localView.findViewById(2131301191));
        paramView.fTP = ((TextView)localView.findViewById(2131301196));
        paramView.FkN.setOnClickListener(new NewFileExplorerUI.a.4(this));
        localView.setTag(paramView);
      }
      paramViewGroup = (NewFileExplorerUI.a.b)localView.getTag();
      e locale = this.FjG[paramInt];
      paramViewGroup.iVq.setText(locale.getName());
      int i;
      if (locale.isDirectory())
      {
        paramViewGroup.lZa.setImageResource(2131689560);
        paramViewGroup.FkN.setVisibility(4);
        paramViewGroup.xfn.setVisibility(0);
        paramViewGroup.fTP.setVisibility(8);
        paramView = locale.a(new NewFileExplorerUI.a.5(this));
        if (paramView != null)
        {
          i = paramView.length;
          paramViewGroup.xfn.setText(NewFileExplorerUI.this.getString(2131759057, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        paramViewGroup.FkO.setChecked(this.FkK.contains(locale));
        paramViewGroup.FkN.setTag(Integer.valueOf(paramInt));
        AppMethodBeat.o(31998);
        return localView;
        i = 0;
        break;
        paramViewGroup.FkN.setVisibility(0);
        paramViewGroup.xfn.setVisibility(0);
        paramViewGroup.fTP.setVisibility(0);
        paramViewGroup.xfn.setText(bt.sy(locale.length()));
        paramViewGroup.fTP.setText(com.tencent.mm.pluginsdk.i.i.c(NewFileExplorerUI.this, locale.lastModified(), true));
        if (aNq(locale.getName()))
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
            paramViewGroup.lZa.setImageBitmap(paramView);
            break;
            label508:
            localCursor.close();
          }
          label521:
          paramViewGroup.lZa.setImageResource(aNp(locale.getName()));
        }
        else
        {
          paramViewGroup.lZa.setImageResource(aNp(locale.getName()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */