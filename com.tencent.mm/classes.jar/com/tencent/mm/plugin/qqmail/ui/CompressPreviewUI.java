package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private String BqZ;
  private String BtN;
  private String BtO;
  private long BuY;
  private List<a> BuZ;
  private c Bul;
  private String Bva;
  private ListView Bvb;
  private b Bvc;
  private com.tencent.mm.plugin.qqmail.c.a Bvd;
  private ProgressBar oMO;
  private TextView xcX;
  
  public CompressPreviewUI()
  {
    AppMethodBeat.i(122976);
    this.BqZ = null;
    this.BtO = null;
    this.BuY = 0L;
    this.Bul = new c(this);
    this.BuZ = new ArrayList();
    this.Bvd = new com.tencent.mm.plugin.qqmail.c.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122969);
        if (paramAnonymousInt == -5)
        {
          CompressPreviewUI.j(CompressPreviewUI.this).a(new c.a()
          {
            public final void eGt()
            {
              AppMethodBeat.i(122967);
              CompressPreviewUI.i(CompressPreviewUI.this);
              AppMethodBeat.o(122967);
            }
            
            public final void eGu() {}
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
        int j = Util.getInt((String)paramAnonymousMap.get(".Response.result.filelist.count"), 0);
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
            int k = Util.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".size"), 0);
            int m = Util.getInt((String)paramAnonymousMap.get(paramAnonymousString + ".type"), 0);
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
            paramAnonymousString = "(" + Util.getSizeKB(k) + ")";
            continue;
            CompressPreviewUI.a(CompressPreviewUI.this, "");
          }
          catch (Exception paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.CompressPreviewUI", paramAnonymousString, "", new Object[0]);
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
  
  private void aKH(String paramString)
  {
    AppMethodBeat.i(122981);
    Log.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(paramString)));
    this.oMO.setVisibility(8);
    this.xcX.setVisibility(8);
    this.Bvb.setVisibility(0);
    a locala1 = aKI(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.BuZ.size())
    {
      a locala2 = (a)this.BuZ.get(i);
      if (((paramString.endsWith(locala2.Bvg)) && (locala2.Bvg.length() > 0)) || (locala2.Bvg.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    this.Bvc.a(locala1, localArrayList);
    this.Bvc.notifyDataSetChanged();
    this.Bvb.setSelection(0);
    AppMethodBeat.o(122981);
  }
  
  private a aKI(String paramString)
  {
    AppMethodBeat.i(122982);
    Iterator localIterator = this.BuZ.iterator();
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
  
  private void eGI()
  {
    AppMethodBeat.i(122983);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.BqZ);
    localHashMap.put("attachid", this.BtO);
    localHashMap.put("fun", "list");
    ((k)g.ah(k.class)).getNormalMailAppService().a("/cgi-bin/viewcompress", localHashMap, this.Bvd);
    AppMethodBeat.o(122983);
  }
  
  public int getLayoutId()
  {
    return 2131495402;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122978);
    this.Bvb = ((ListView)findViewById(2131298986));
    this.xcX = ((TextView)findViewById(2131298984));
    this.oMO = ((ProgressBar)findViewById(2131298985));
    if ((this.BqZ == null) || (this.BtO == null))
    {
      this.oMO.setVisibility(8);
      this.xcX.setText(2131762814);
      AppMethodBeat.o(122978);
      return;
    }
    this.Bvc = new b((byte)0);
    this.Bvb.setAdapter(this.Bvc);
    this.Bvb.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(122963);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        paramAnonymousView = CompressPreviewUI.a(CompressPreviewUI.this).Vh(paramAnonymousInt);
        localObject = paramAnonymousView.id;
        paramAnonymousAdapterView = CompressPreviewUI.a(CompressPreviewUI.this);
        if (paramAnonymousAdapterView.Bvh == null) {}
        for (paramAnonymousAdapterView = null; ((String)localObject).equals(paramAnonymousAdapterView); paramAnonymousAdapterView = paramAnonymousAdapterView.Bvh.id)
        {
          CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.a(CompressPreviewUI.this).eGK());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.eGJ())
        {
          CompressPreviewUI.a(CompressPreviewUI.this, paramAnonymousView.id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.aWI)
        {
          localObject = "mailid=" + CompressPreviewUI.b(CompressPreviewUI.this);
          String str1 = "attachid=" + paramAnonymousView.id;
          String str2 = "compressfilepath=" + CompressPreviewUI.c(CompressPreviewUI.this);
          paramAnonymousAdapterView = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
          paramAnonymousAdapterView.putExtra("uri", "/cgi-bin/viewdocument");
          paramAnonymousAdapterView.putExtra("params", new String[] { localObject, str1, str2, "texttype=html" });
          paramAnonymousAdapterView.putExtra("baseurl", v.eGq());
          paramAnonymousAdapterView.putExtra("method", "get");
          paramAnonymousAdapterView.putExtra("singleColumn", FileExplorerUI.bfr(paramAnonymousView.name));
          paramAnonymousAdapterView.putExtra("title", CompressPreviewUI.this.getString(2131764210));
          paramAnonymousView = CompressPreviewUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousAdapterView.axQ(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(122963);
      }
    });
    setBackBtn(new CompressPreviewUI.2(this));
    setToTop(new CompressPreviewUI.3(this));
    addTextOptionMenu(0, getString(2131755785), new MenuItem.OnMenuItemClickListener()
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122966);
        return true;
      }
    });
    eGI();
    AppMethodBeat.o(122978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122977);
    super.onCreate(paramBundle);
    this.BqZ = getIntent().getStringExtra("mail_id");
    this.BtO = getIntent().getStringExtra("attach_id");
    this.BuY = getIntent().getLongExtra("attach_size", 0L);
    this.BtN = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.BtN);
    AppMethodBeat.o(122977);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122979);
    super.onDestroy();
    this.Bul.release();
    AppMethodBeat.o(122979);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122980);
    if ((paramInt == 4) && (this.Bvc.eGK() != null))
    {
      aKH(this.Bvc.eGK());
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
    String Bvg;
    boolean aWI;
    String id;
    String kSm;
    String name;
    int type;
    
    public a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, boolean paramBoolean)
    {
      AppMethodBeat.i(122970);
      this.id = paramString1;
      this.name = paramString2;
      this$1 = paramString3;
      if (paramString3 == null) {
        this$1 = "";
      }
      this.Bvg = CompressPreviewUI.this;
      this.type = paramInt;
      this.kSm = paramString4;
      this.aWI = paramBoolean;
      AppMethodBeat.o(122970);
    }
    
    public final boolean eGJ()
    {
      return this.type == 1;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    CompressPreviewUI.a Bvh;
    private List<CompressPreviewUI.a> mbK = null;
    
    private b() {}
    
    public final CompressPreviewUI.a Vh(int paramInt)
    {
      AppMethodBeat.i(122973);
      if ((this.mbK != null) && (this.mbK.size() > paramInt))
      {
        CompressPreviewUI.a locala = (CompressPreviewUI.a)this.mbK.get(paramInt);
        AppMethodBeat.o(122973);
        return locala;
      }
      AppMethodBeat.o(122973);
      return null;
    }
    
    public final void a(CompressPreviewUI.a parama, List<CompressPreviewUI.a> paramList)
    {
      this.Bvh = parama;
      this.mbK = paramList;
    }
    
    public final String eGK()
    {
      AppMethodBeat.i(122971);
      if ((this.Bvh == null) || (this.Bvh.Bvg == null))
      {
        AppMethodBeat.o(122971);
        return null;
      }
      if (this.Bvh.Bvg.length() == 0)
      {
        AppMethodBeat.o(122971);
        return "";
      }
      int i = this.Bvh.id.indexOf(this.Bvh.Bvg);
      if (i >= 0)
      {
        String str = this.Bvh.id.substring(0, i) + this.Bvh.Bvg;
        AppMethodBeat.o(122971);
        return str;
      }
      AppMethodBeat.o(122971);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(122972);
      if (this.mbK != null)
      {
        int i = this.mbK.size();
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
        paramViewGroup = View.inflate(CompressPreviewUI.this.getContext(), 2131495401, null);
        paramView = new a((byte)0);
        paramView.nnL = ((ImageView)paramViewGroup.findViewById(2131300622));
        paramView.kgE = ((TextView)paramViewGroup.findViewById(2131300628));
        paramView.Bvi = ((TextView)paramViewGroup.findViewById(2131300633));
        paramView.Bvj = ((ImageView)paramViewGroup.findViewById(2131300634));
        paramViewGroup.setTag(paramView);
      }
      a locala = (a)paramViewGroup.getTag();
      CompressPreviewUI.a locala1 = Vh(paramInt);
      if ((paramInt == 0) && (eGK() != null))
      {
        paramView = locala.nnL;
        paramInt = 2131234510;
        paramView.setImageResource(paramInt);
        paramView = locala.Bvj;
        if (!locala1.aWI) {
          break label219;
        }
      }
      label219:
      for (paramInt = 0;; paramInt = 4)
      {
        paramView.setVisibility(paramInt);
        locala.kgE.setText(locala1.name);
        locala.Bvi.setText(locala1.kSm);
        AppMethodBeat.o(122974);
        return paramViewGroup;
        paramView = locala.nnL;
        if (locala1.eGJ())
        {
          paramInt = 2131234511;
          break;
        }
        paramInt = FileExplorerUI.bfq(locala1.name);
        break;
      }
    }
    
    final class a
    {
      TextView Bvi;
      ImageView Bvj;
      TextView kgE;
      ImageView nnL;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */