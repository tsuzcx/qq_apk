package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.u;
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
  private TextView HAL;
  private String Njg;
  private String NlU;
  private String NlV;
  private c Nms;
  private long Nnh;
  private List<a> Nni;
  private String Nnj;
  private ListView Nnk;
  private b Nnl;
  private com.tencent.mm.plugin.qqmail.c.a Nnm;
  private ProgressBar uZY;
  
  public CompressPreviewUI()
  {
    AppMethodBeat.i(122976);
    this.Njg = null;
    this.NlV = null;
    this.Nnh = 0L;
    this.Nms = new c(this);
    this.Nni = new ArrayList();
    this.Nnm = new com.tencent.mm.plugin.qqmail.c.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(122969);
        if (paramAnonymousInt == -5)
        {
          CompressPreviewUI.j(CompressPreviewUI.this).a(new c.a()
          {
            public final void gEf()
            {
              AppMethodBeat.i(122967);
              CompressPreviewUI.i(CompressPreviewUI.this);
              AppMethodBeat.o(122967);
            }
            
            public final void gEg() {}
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
  
  private void aSq(String paramString)
  {
    AppMethodBeat.i(122981);
    Log.i("MicroMsg.CompressPreviewUI", "curPath=".concat(String.valueOf(paramString)));
    this.uZY.setVisibility(8);
    this.HAL.setVisibility(8);
    this.Nnk.setVisibility(0);
    a locala1 = aSr(paramString);
    ArrayList localArrayList = new ArrayList();
    if (locala1 != null) {
      localArrayList.add(locala1);
    }
    int i = 0;
    while (i < this.Nni.size())
    {
      a locala2 = (a)this.Nni.get(i);
      if (((paramString.endsWith(locala2.Nnp)) && (locala2.Nnp.length() > 0)) || (locala2.Nnp.equals(paramString))) {
        localArrayList.add(locala2);
      }
      i += 1;
    }
    this.Nnl.a(locala1, localArrayList);
    this.Nnl.notifyDataSetChanged();
    this.Nnk.setSelection(0);
    AppMethodBeat.o(122981);
  }
  
  private a aSr(String paramString)
  {
    AppMethodBeat.i(122982);
    Iterator localIterator = this.Nni.iterator();
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
  
  private void gEu()
  {
    AppMethodBeat.i(122983);
    HashMap localHashMap = new HashMap();
    localHashMap.put("mailid", this.Njg);
    localHashMap.put("attachid", this.NlV);
    localHashMap.put("fun", "list");
    ((j)h.az(j.class)).getNormalMailAppService().a("/cgi-bin/viewcompress", localHashMap, this.Nnm);
    AppMethodBeat.o(122983);
  }
  
  public int getLayoutId()
  {
    return e.f.mail_compress_preview_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(122978);
    this.Nnk = ((ListView)findViewById(e.e.compress_preview_lv));
    this.HAL = ((TextView)findViewById(e.e.compress_preview_info_tv));
    this.uZY = ((ProgressBar)findViewById(e.e.compress_preview_loading_pb));
    if ((this.Njg == null) || (this.NlV == null))
    {
      this.uZY.setVisibility(8);
      this.HAL.setText(e.i.mail_compress_preview_err_hint);
      AppMethodBeat.o(122978);
      return;
    }
    this.Nnl = new b((byte)0);
    this.Nnk.setAdapter(this.Nnl);
    this.Nnk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(122963);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        paramAnonymousView = CompressPreviewUI.a(CompressPreviewUI.this).agd(paramAnonymousInt);
        localObject = paramAnonymousView.id;
        paramAnonymousAdapterView = CompressPreviewUI.a(CompressPreviewUI.this);
        if (paramAnonymousAdapterView.Nnq == null) {}
        for (paramAnonymousAdapterView = null; ((String)localObject).equals(paramAnonymousAdapterView); paramAnonymousAdapterView = paramAnonymousAdapterView.Nnq.id)
        {
          CompressPreviewUI.a(CompressPreviewUI.this, CompressPreviewUI.a(CompressPreviewUI.this).gEw());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.gEv())
        {
          CompressPreviewUI.a(CompressPreviewUI.this, paramAnonymousView.id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(122963);
          return;
        }
        if (paramAnonymousView.preview)
        {
          localObject = "mailid=" + CompressPreviewUI.b(CompressPreviewUI.this);
          String str1 = "attachid=" + paramAnonymousView.id;
          String str2 = "compressfilepath=" + CompressPreviewUI.c(CompressPreviewUI.this);
          paramAnonymousAdapterView = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
          paramAnonymousAdapterView.putExtra("uri", "/cgi-bin/viewdocument");
          paramAnonymousAdapterView.putExtra("params", new String[] { localObject, str1, str2, "texttype=html" });
          paramAnonymousAdapterView.putExtra("baseurl", u.gEa());
          paramAnonymousAdapterView.putExtra("method", "get");
          paramAnonymousAdapterView.putExtra("singleColumn", FileExplorerUI.brB(paramAnonymousView.name));
          paramAnonymousAdapterView.putExtra("title", CompressPreviewUI.this.getString(e.i.readmail_attachment_preview));
          paramAnonymousView = CompressPreviewUI.this;
          paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, paramAnonymousAdapterView.aYi(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)paramAnonymousAdapterView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(122963);
      }
    });
    setBackBtn(new CompressPreviewUI.2(this));
    setToTop(new CompressPreviewUI.3(this));
    addTextOptionMenu(0, getString(e.i.app_download), new MenuItem.OnMenuItemClickListener()
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/qqmail/ui/CompressPreviewUI$4", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(122966);
        return true;
      }
    });
    gEu();
    AppMethodBeat.o(122978);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(122977);
    super.onCreate(paramBundle);
    this.Njg = getIntent().getStringExtra("mail_id");
    this.NlV = getIntent().getStringExtra("attach_id");
    this.Nnh = getIntent().getLongExtra("attach_size", 0L);
    this.NlU = getIntent().getStringExtra("attach_name");
    initView();
    setMMTitle(this.NlU);
    AppMethodBeat.o(122977);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(122979);
    super.onDestroy();
    this.Nms.release();
    AppMethodBeat.o(122979);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(122980);
    if ((paramInt == 4) && (this.Nnl.gEw() != null))
    {
      aSq(this.Nnl.gEw());
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
    String Nnp;
    String id;
    String name;
    boolean preview;
    String qMq;
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
      this.Nnp = CompressPreviewUI.this;
      this.type = paramInt;
      this.qMq = paramString4;
      this.preview = paramBoolean;
      AppMethodBeat.o(122970);
    }
    
    public final boolean gEv()
    {
      return this.type == 1;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    CompressPreviewUI.a Nnq;
    private List<CompressPreviewUI.a> sfd = null;
    
    private b() {}
    
    public final void a(CompressPreviewUI.a parama, List<CompressPreviewUI.a> paramList)
    {
      this.Nnq = parama;
      this.sfd = paramList;
    }
    
    public final CompressPreviewUI.a agd(int paramInt)
    {
      AppMethodBeat.i(122973);
      if ((this.sfd != null) && (this.sfd.size() > paramInt))
      {
        CompressPreviewUI.a locala = (CompressPreviewUI.a)this.sfd.get(paramInt);
        AppMethodBeat.o(122973);
        return locala;
      }
      AppMethodBeat.o(122973);
      return null;
    }
    
    public final String gEw()
    {
      AppMethodBeat.i(122971);
      if ((this.Nnq == null) || (this.Nnq.Nnp == null))
      {
        AppMethodBeat.o(122971);
        return null;
      }
      if (this.Nnq.Nnp.length() == 0)
      {
        AppMethodBeat.o(122971);
        return "";
      }
      int i = this.Nnq.id.indexOf(this.Nnq.Nnp);
      if (i >= 0)
      {
        String str = this.Nnq.id.substring(0, i) + this.Nnq.Nnp;
        AppMethodBeat.o(122971);
        return str;
      }
      AppMethodBeat.o(122971);
      return null;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(122972);
      if (this.sfd != null)
      {
        int i = this.sfd.size();
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
        paramViewGroup = View.inflate(CompressPreviewUI.this.getContext(), e.f.mail_compress_preview_item, null);
        paramView = new a((byte)0);
        paramView.ttT = ((ImageView)paramViewGroup.findViewById(e.e.file_icon_iv));
        paramView.pUL = ((TextView)paramViewGroup.findViewById(e.e.file_name_tv));
        paramView.Nnr = ((TextView)paramViewGroup.findViewById(e.e.file_size_tv));
        paramView.Nns = ((ImageView)paramViewGroup.findViewById(e.e.file_sub_tv));
        paramViewGroup.setTag(paramView);
      }
      a locala = (a)paramViewGroup.getTag();
      CompressPreviewUI.a locala1 = agd(paramInt);
      if ((paramInt == 0) && (gEw() != null))
      {
        paramView = locala.ttT;
        paramInt = e.d.qqmail_attach_back;
        paramView.setImageResource(paramInt);
        paramView = locala.Nns;
        if (!locala1.preview) {
          break label226;
        }
      }
      label226:
      for (paramInt = 0;; paramInt = 4)
      {
        paramView.setVisibility(paramInt);
        locala.pUL.setText(locala1.name);
        locala.Nnr.setText(locala1.qMq);
        AppMethodBeat.o(122974);
        return paramViewGroup;
        paramView = locala.ttT;
        if (locala1.gEv())
        {
          paramInt = e.d.qqmail_attach_folder;
          break;
        }
        paramInt = FileExplorerUI.brA(locala1.name);
        break;
      }
    }
    
    final class a
    {
      TextView Nnr;
      ImageView Nns;
      TextView pUL;
      ImageView ttT;
      
      private a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.CompressPreviewUI
 * JD-Core Version:    0.7.0.1
 */