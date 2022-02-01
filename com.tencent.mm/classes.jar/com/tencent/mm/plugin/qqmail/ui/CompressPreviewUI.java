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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private ProgressBar nwu;
  private TextView tBf;
  private String xbf;
  private String xdT;
  private String xdU;
  private c xer;
  private long xfd;
  private List<a> xfe;
  private String xff;
  private ListView xfg;
  private b xfh;
  private com.tencent.mm.plugin.qqmail.c.a xfi;
  
  public CompressPreviewUI()
  {
    AppMethodBeat.i(122976);
    this.xbf = null;
    this.xdU = null;
    this.xfd = 0L;
    this.xer = new c(this);
    this.xfe = new ArrayList();
    this.xfi = new com.tencent.mm.plugin.qqmail.c.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122969);
        if (paramAnonymousInt == -5)
        {
          CompressPreviewUI.j(CompressPreviewUI.this).a(new c.a()
          {
            public final void dCn()
            {
              AppMethodBeat.i(122967);
              CompressPreviewUI.i(CompressPreviewUI.this);
              AppMethodBeat.o(122967);
            }
            
            public final void dCo() {}
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
        int j = bt.getInt((String)paramAnonymousMap.get(".Response.result.filelist.count"), 0);
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
            int k = bt.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".size"), 0);
            int m = bt.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".type"), 0);
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
            paramAnonymousString = "(" + bt.sy(k) + ")";
            continue;
            CompressPreviewUI.a(CompressPreviewUI.this, "");
          }
          catch (Exception paramAnonymousString)
          {
            ad.printErrStackTrace("MicroMsg.CompressPreviewUI", paramAnonymousString, "", new Object[0]);
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
  
  private void ava(String paramString)
  {
    AppMethodBeat.i(122981);
    ad.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(paramString)));
    this.nwu.setVisibility(8);
    this.tBf.setVisibility(8);
    this.xfg.setVisibility(0);
    a locala1 = avb(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.xfe.size())
    {
      a locala2 = (a)this.xfe.get(i);
      if (((paramString.endsWith(locala2.xfl)) && (locala2.xfl.length() > 0)) || (locala2.xfl.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    this.xfh.a(locala1, localArrayList);
    this.xfh.notifyDataSetChanged();
    this.xfg.setSelection(0);
    AppMethodBeat.o(122981);
  }
  
  private a avb(String paramString)
  {
    AppMethodBeat.i(122982);
    Iterator localIterator = this.xfe.iterator();
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
  
  private void dCD()
  {
    AppMethodBeat.i(122983);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.xbf);
    localHashMap.put("attachid", this.xdU);
    localHashMap.put("fun", "list");
    ((k)g.ad(k.class)).getNormalMailAppService().a("/cgi-bin/viewcompress", localHashMap, this.xfi);
    AppMethodBeat.o(122983);
  }
  
  public int getLayoutId()
  {
    return 2131494676;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122978);
    this.xfg = ((ListView)findViewById(2131298552));
    this.tBf = ((TextView)findViewById(2131298550));
    this.nwu = ((ProgressBar)findViewById(2131298551));
    if ((this.xbf == null) || (this.xdU == null))
    {
      this.nwu.setVisibility(8);
      this.tBf.setText(2131761033);
      AppMethodBeat.o(122978);
      return;
    }
    this.xfh = new b((byte)0);
    this.xfg.setAdapter(this.xfh);
    this.xfg.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(122963);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mr(paramAnonymousInt);
        ((b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahq());
        paramAnonymousView = CompressPreviewUI.a(CompressPreviewUI.this).Nm(paramAnonymousInt);
        localObject = paramAnonymousView.id;
        paramAnonymousAdapterView = CompressPreviewUI.a(CompressPreviewUI.this);
        if (paramAnonymousAdapterView.xfm == null) {}
        for (paramAnonymousAdapterView = null; ((String)localObject).equals(paramAnonymousAdapterView); paramAnonymousAdapterView = paramAnonymousAdapterView.xfm.id)
        {
          CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.a(CompressPreviewUI.this).dCF());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.dCE())
        {
          CompressPreviewUI.a(CompressPreviewUI.this, paramAnonymousView.id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.aWQ)
        {
          localObject = "mailid=" + CompressPreviewUI.b(CompressPreviewUI.this);
          String str1 = "attachid=" + paramAnonymousView.id;
          String str2 = "compressfilepath=" + CompressPreviewUI.c(CompressPreviewUI.this);
          paramAnonymousAdapterView = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
          paramAnonymousAdapterView.putExtra("uri", "/cgi-bin/viewdocument");
          paramAnonymousAdapterView.putExtra("params", new String[] { localObject, str1, str2, "texttype=html" });
          paramAnonymousAdapterView.putExtra("baseurl", v.dCk());
          paramAnonymousAdapterView.putExtra("method", "get");
          paramAnonymousAdapterView.putExtra("singleColumn", FileExplorerUI.aNq(paramAnonymousView.name));
          paramAnonymousAdapterView.putExtra("title", CompressPreviewUI.this.getString(2131762189));
          paramAnonymousView = CompressPreviewUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.ahp(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = CompressPreviewUI.d(CompressPreviewUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122966);
        return true;
      }
    });
    dCD();
    AppMethodBeat.o(122978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122977);
    super.onCreate(paramBundle);
    this.xbf = getIntent().getStringExtra("mail_id");
    this.xdU = getIntent().getStringExtra("attach_id");
    this.xfd = getIntent().getLongExtra("attach_size", 0L);
    this.xdT = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.xdT);
    AppMethodBeat.o(122977);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122979);
    super.onDestroy();
    this.xer.release();
    AppMethodBeat.o(122979);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122980);
    if ((paramInt == 4) && (this.xfh.dCF() != null))
    {
      ava(this.xfh.dCF());
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
    boolean aWQ;
    String id;
    String jMs;
    String name;
    int type;
    String xfl;
    
    public a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
    {
      AppMethodBeat.i(122970);
      this.id = paramString1;
      this.name = paramString2;
      this$1 = paramString3;
      if (paramString3 == null) {
        this$1 = "";
      }
      this.xfl = CompressPreviewUI.this;
      this.type = paramInt;
      this.jMs = paramString4;
      this.aWQ = paramBoolean;
      AppMethodBeat.o(122970);
    }
    
    public final boolean dCE()
    {
      return this.type == 1;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<CompressPreviewUI.a> kSS = null;
    CompressPreviewUI.a xfm;
    
    private b() {}
    
    public final CompressPreviewUI.a Nm(int paramInt)
    {
      AppMethodBeat.i(122973);
      if ((this.kSS != null) && (this.kSS.size() > paramInt))
      {
        CompressPreviewUI.a locala = (CompressPreviewUI.a)this.kSS.get(paramInt);
        AppMethodBeat.o(122973);
        return locala;
      }
      AppMethodBeat.o(122973);
      return null;
    }
    
    public final void a(CompressPreviewUI.a parama, List<CompressPreviewUI.a> paramList)
    {
      this.xfm = parama;
      this.kSS = paramList;
    }
    
    public final String dCF()
    {
      AppMethodBeat.i(122971);
      if ((this.xfm == null) || (this.xfm.xfl == null))
      {
        AppMethodBeat.o(122971);
        return null;
      }
      if (this.xfm.xfl.length() == 0)
      {
        AppMethodBeat.o(122971);
        return "";
      }
      int i = this.xfm.id.indexOf(this.xfm.xfl);
      if (i >= 0)
      {
        String str = this.xfm.id.substring(0, i) + this.xfm.xfl;
        AppMethodBeat.o(122971);
        return str;
      }
      AppMethodBeat.o(122971);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(122972);
      if (this.kSS != null)
      {
        int i = this.kSS.size();
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
        paramView.lZa = ((ImageView)paramViewGroup.findViewById(2131299919));
        paramView.jfJ = ((TextView)paramViewGroup.findViewById(2131299925));
        paramView.xfn = ((TextView)paramViewGroup.findViewById(2131299929));
        paramView.xfo = ((ImageView)paramViewGroup.findViewById(2131299930));
        paramViewGroup.setTag(paramView);
      }
      a locala = (a)paramViewGroup.getTag();
      CompressPreviewUI.a locala1 = Nm(paramInt);
      if ((paramInt == 0) && (dCF() != null))
      {
        paramView = locala.lZa;
        paramInt = 2131233694;
        paramView.setImageResource(paramInt);
        paramView = locala.xfo;
        if (!locala1.aWQ) {
          break label219;
        }
      }
      label219:
      for (paramInt = 0;; paramInt = 4)
      {
        paramView.setVisibility(paramInt);
        locala.jfJ.setText(locala1.name);
        locala.xfn.setText(locala1.jMs);
        AppMethodBeat.o(122974);
        return paramViewGroup;
        paramView = locala.lZa;
        if (locala1.dCE())
        {
          paramInt = 2131233695;
          break;
        }
        paramInt = FileExplorerUI.aNp(locala1.name);
        break;
      }
    }
    
    final class a
    {
      TextView jfJ;
      ImageView lZa;
      TextView xfn;
      ImageView xfo;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */