package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.w.a;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI
  extends MMActivity
{
  private ProgressBar mVX;
  private TextView sEo;
  private String vTT;
  private String vUF;
  private c vWA;
  private String vWc;
  private long vXp;
  private List<a> vXq;
  private String vXr;
  private ListView vXs;
  private b vXt;
  private w.a vXu;
  
  public CompressPreviewUI()
  {
    AppMethodBeat.i(122976);
    this.vTT = null;
    this.vUF = null;
    this.vXp = 0L;
    this.vWA = new c(this);
    this.vXq = new ArrayList();
    this.vXu = new w.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122969);
        if (paramAnonymousInt == -5)
        {
          CompressPreviewUI.j(CompressPreviewUI.this).a(new c.a()
          {
            public final void drP()
            {
              AppMethodBeat.i(122967);
              CompressPreviewUI.i(CompressPreviewUI.this);
              AppMethodBeat.o(122967);
            }
            
            public final void drQ() {}
          });
          AppMethodBeat.o(122969);
          return;
        }
        CompressPreviewUI.k(CompressPreviewUI.this).setVisibility(8);
        CompressPreviewUI.l(CompressPreviewUI.this).setVisibility(0);
        CompressPreviewUI.d(CompressPreviewUI.this).setVisibility(8);
        AppMethodBeat.o(122969);
      }
      
      public final void onSuccess(String paramAnonymousString, Map<String, String> paramAnonymousMap)
      {
        AppMethodBeat.i(122968);
        CompressPreviewUI.b(CompressPreviewUI.this, (String)paramAnonymousMap.get(".Response.result.compressfilepath"));
        int j = bs.getInt((String)paramAnonymousMap.get(".Response.result.filelist.count"), 0);
        int i = 0;
        if (i < j) {}
        for (;;)
        {
          try
          {
            Object localObject = new StringBuilder(".Response.result.filelist.list.item");
            if (i <= 0) {
              break label405;
            }
            paramAnonymousString = Integer.valueOf(i);
            paramAnonymousString = paramAnonymousString;
            localObject = (String)paramAnonymousMap.get(paramAnonymousString + ".path");
            if (localObject == null) {
              break label398;
            }
            localObject = URLDecoder.decode((String)localObject, "utf-8");
            String str1 = (String)paramAnonymousMap.get(paramAnonymousString + ".parentpath");
            int k = bs.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".size"), 0);
            int m = bs.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".type"), 0);
            boolean bool = ((String)paramAnonymousMap.get(paramAnonymousString + ".preview")).equals("1");
            String str2 = (String)paramAnonymousMap.get(paramAnonymousString + ".name");
            List localList = CompressPreviewUI.h(CompressPreviewUI.this);
            CompressPreviewUI localCompressPreviewUI = CompressPreviewUI.this;
            if (k == 0)
            {
              paramAnonymousString = "";
              localList.add(new CompressPreviewUI.a(localCompressPreviewUI, (String)localObject, str2, str1, m, paramAnonymousString, bool));
              break label398;
            }
            paramAnonymousString = "(" + bs.qz(k) + ")";
            continue;
            CompressPreviewUI.a(CompressPreviewUI.this, "");
          }
          catch (Exception paramAnonymousString)
          {
            ac.printErrStackTrace("MicroMsg.CompressPreviewUI", paramAnonymousString, "", new Object[0]);
          }
          AppMethodBeat.o(122968);
          return;
          label398:
          i += 1;
          break;
          label405:
          paramAnonymousString = "";
        }
      }
    };
    AppMethodBeat.o(122976);
  }
  
  private void aqb(String paramString)
  {
    AppMethodBeat.i(122981);
    ac.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(paramString)));
    this.mVX.setVisibility(8);
    this.sEo.setVisibility(8);
    this.vXs.setVisibility(0);
    a locala1 = aqc(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.vXq.size())
    {
      a locala2 = (a)this.vXq.get(i);
      if (((paramString.endsWith(locala2.vXx)) && (locala2.vXx.length() > 0)) || (locala2.vXx.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    this.vXt.a(locala1, localArrayList);
    this.vXt.notifyDataSetChanged();
    this.vXs.setSelection(0);
    AppMethodBeat.o(122981);
  }
  
  private a aqc(String paramString)
  {
    AppMethodBeat.i(122982);
    Iterator localIterator = this.vXq.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.id.equals(paramString))
      {
        AppMethodBeat.o(122982);
        return locala;
      }
    }
    AppMethodBeat.o(122982);
    return null;
  }
  
  private void dsf()
  {
    AppMethodBeat.i(122983);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.vTT);
    localHashMap.put("attachid", this.vUF);
    localHashMap.put("fun", "list");
    ((o)g.ad(o.class)).getNormalMailAppService().a("/cgi-bin/viewcompress", localHashMap, this.vXu);
    AppMethodBeat.o(122983);
  }
  
  public int getLayoutId()
  {
    return 2131494676;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122978);
    this.vXs = ((ListView)findViewById(2131298552));
    this.sEo = ((TextView)findViewById(2131298550));
    this.mVX = ((ProgressBar)findViewById(2131298551));
    if ((this.vTT == null) || (this.vUF == null))
    {
      this.mVX.setVisibility(8);
      this.sEo.setText(2131761033);
      AppMethodBeat.o(122978);
      return;
    }
    this.vXt = new b((byte)0);
    this.vXs.setAdapter(this.vXt);
    this.vXs.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(122963);
        paramAnonymousView = CompressPreviewUI.a(CompressPreviewUI.this).LM(paramAnonymousInt);
        String str1 = paramAnonymousView.id;
        paramAnonymousAdapterView = CompressPreviewUI.a(CompressPreviewUI.this);
        if (paramAnonymousAdapterView.vXy == null) {}
        for (paramAnonymousAdapterView = null; str1.equals(paramAnonymousAdapterView); paramAnonymousAdapterView = paramAnonymousAdapterView.vXy.id)
        {
          CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.a(CompressPreviewUI.this).dsh());
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.dsg())
        {
          CompressPreviewUI.a(CompressPreviewUI.this, paramAnonymousView.id);
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.aMz)
        {
          str1 = "mailid=" + CompressPreviewUI.b(CompressPreviewUI.this);
          String str2 = "attachid=" + paramAnonymousView.id;
          String str3 = "compressfilepath=" + CompressPreviewUI.c(CompressPreviewUI.this);
          paramAnonymousAdapterView = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
          paramAnonymousAdapterView.putExtra("uri", "/cgi-bin/viewdocument");
          paramAnonymousAdapterView.putExtra("params", new String[] { str1, str2, str3, "texttype=html" });
          paramAnonymousAdapterView.putExtra("baseurl", w.drK());
          paramAnonymousAdapterView.putExtra("method", "get");
          paramAnonymousAdapterView.putExtra("singleColumn", FileExplorerUI.aHO(paramAnonymousView.name));
          paramAnonymousAdapterView.putExtra("title", CompressPreviewUI.this.getString(2131762189));
          paramAnonymousView = CompressPreviewUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.aeD(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(122963);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(122964);
        CompressPreviewUI.this.onKeyDown(4, null);
        AppMethodBeat.o(122964);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(122965);
        paramAnonymousView = CompressPreviewUI.d(CompressPreviewUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(122965);
      }
    });
    addTextOptionMenu(0, getString(2131755714), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(122966);
        Object localObject = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
        ((Intent)localObject).putExtra("attach_name", CompressPreviewUI.e(CompressPreviewUI.this));
        ((Intent)localObject).putExtra("mail_id", CompressPreviewUI.b(CompressPreviewUI.this));
        ((Intent)localObject).putExtra("attach_id", CompressPreviewUI.f(CompressPreviewUI.this));
        ((Intent)localObject).putExtra("total_size", CompressPreviewUI.g(CompressPreviewUI.this));
        ((Intent)localObject).putExtra("is_preview", 0);
        ((Intent)localObject).putExtra("is_compress", true);
        paramAnonymousMenuItem = CompressPreviewUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122966);
        return true;
      }
    });
    dsf();
    AppMethodBeat.o(122978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122977);
    super.onCreate(paramBundle);
    this.vTT = getIntent().getStringExtra("mail_id");
    this.vUF = getIntent().getStringExtra("attach_id");
    this.vXp = getIntent().getLongExtra("attach_size", 0L);
    this.vWc = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.vWc);
    AppMethodBeat.o(122977);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122979);
    super.onDestroy();
    this.vWA.release();
    AppMethodBeat.o(122979);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122980);
    if ((paramInt == 4) && (this.vXt.dsh() != null))
    {
      aqb(this.vXt.dsh());
      AppMethodBeat.o(122980);
      return true;
    }
    if (paramKeyEvent == null)
    {
      finish();
      AppMethodBeat.o(122980);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(122980);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
  {
    boolean aMz;
    String id;
    String jsy;
    String name;
    int type;
    String vXx;
    
    public a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
    {
      AppMethodBeat.i(122970);
      this.id = paramString1;
      this.name = paramString2;
      this$1 = paramString3;
      if (paramString3 == null) {
        this$1 = "";
      }
      this.vXx = CompressPreviewUI.this;
      this.type = paramInt;
      this.jsy = paramString4;
      this.aMz = paramBoolean;
      AppMethodBeat.o(122970);
    }
    
    public final boolean dsg()
    {
      return this.type == 1;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<CompressPreviewUI.a> kwM = null;
    CompressPreviewUI.a vXy;
    
    private b() {}
    
    public final CompressPreviewUI.a LM(int paramInt)
    {
      AppMethodBeat.i(122973);
      if ((this.kwM != null) && (this.kwM.size() > paramInt))
      {
        CompressPreviewUI.a locala = (CompressPreviewUI.a)this.kwM.get(paramInt);
        AppMethodBeat.o(122973);
        return locala;
      }
      AppMethodBeat.o(122973);
      return null;
    }
    
    public final void a(CompressPreviewUI.a parama, List<CompressPreviewUI.a> paramList)
    {
      this.vXy = parama;
      this.kwM = paramList;
    }
    
    public final String dsh()
    {
      AppMethodBeat.i(122971);
      if ((this.vXy == null) || (this.vXy.vXx == null))
      {
        AppMethodBeat.o(122971);
        return null;
      }
      if (this.vXy.vXx.length() == 0)
      {
        AppMethodBeat.o(122971);
        return "";
      }
      int i = this.vXy.id.indexOf(this.vXy.vXx);
      if (i >= 0)
      {
        String str = this.vXy.id.substring(0, i) + this.vXy.vXx;
        AppMethodBeat.o(122971);
        return str;
      }
      AppMethodBeat.o(122971);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(122972);
      if (this.kwM != null)
      {
        int i = this.kwM.size();
        AppMethodBeat.o(122972);
        return i;
      }
      AppMethodBeat.o(122972);
      return 0;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(122974);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(CompressPreviewUI.this.getContext(), 2131494675, null);
        paramView = new a((byte)0);
        paramView.lzC = ((ImageView)paramViewGroup.findViewById(2131299919));
        paramView.iMz = ((TextView)paramViewGroup.findViewById(2131299925));
        paramView.vXz = ((TextView)paramViewGroup.findViewById(2131299929));
        paramView.vXA = ((ImageView)paramViewGroup.findViewById(2131299930));
        paramViewGroup.setTag(paramView);
      }
      a locala = (a)paramViewGroup.getTag();
      CompressPreviewUI.a locala1 = LM(paramInt);
      if ((paramInt == 0) && (dsh() != null))
      {
        paramView = locala.lzC;
        paramInt = 2131233694;
        paramView.setImageResource(paramInt);
        paramView = locala.vXA;
        if (!locala1.aMz) {
          break label219;
        }
      }
      label219:
      for (paramInt = 0;; paramInt = 4)
      {
        paramView.setVisibility(paramInt);
        locala.iMz.setText(locala1.name);
        locala.vXz.setText(locala1.jsy);
        AppMethodBeat.o(122974);
        return paramViewGroup;
        paramView = locala.lzC;
        if (locala1.dsg())
        {
          paramInt = 2131233695;
          break;
        }
        paramInt = FileExplorerUI.aHN(locala1.name);
        break;
      }
    }
    
    final class a
    {
      TextView iMz;
      ImageView lzC;
      ImageView vXA;
      TextView vXz;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */