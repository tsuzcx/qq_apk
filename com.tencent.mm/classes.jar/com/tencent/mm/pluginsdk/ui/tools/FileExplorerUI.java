package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI
  extends MMActivity
{
  private int Yrj = 0;
  private ListView Yrk;
  private a Yrl;
  private TextView Yrm;
  private TextView Yrn;
  private View Yro;
  private View Yrp;
  private String Yrq;
  private String Yrr;
  private u Yrs;
  private u Yrt;
  
  private void axc(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.Yrj = 1;
      this.Yrn.setTextColor(getResources().getColor(a.d.green_text_color));
      this.Yrm.setTextColor(getResources().getColor(a.d.normal_text_color));
      this.Yro.setVisibility(4);
      this.Yrp.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.Yrj = 0;
    this.Yrm.setTextColor(getResources().getColor(a.d.green_text_color));
    this.Yrn.setTextColor(getResources().getColor(a.d.normal_text_color));
    this.Yro.setVisibility(0);
    this.Yrp.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int brA(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    if (brD(paramString))
    {
      i = a.j.app_attach_file_icon_word;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brB(paramString))
    {
      i = a.f.qqmail_attach_img;
      AppMethodBeat.o(141178);
      return i;
    }
    String str = Util.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = a.j.app_attach_file_icon_rar;
      AppMethodBeat.o(141178);
      return i;
    }
    str = Util.nullAsNil(paramString).toLowerCase();
    if (!str.endsWith(".txt"))
    {
      i = j;
      if (!str.endsWith(".rtf")) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      i = a.j.app_attach_file_icon_txt;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brE(paramString))
    {
      i = a.j.app_attach_file_icon_pdf;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brF(paramString))
    {
      i = a.j.app_attach_file_icon_ppt;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brG(paramString))
    {
      i = a.j.app_attach_file_icon_excel;
      AppMethodBeat.o(141178);
      return i;
    }
    if (Util.nullAsNil(paramString).toLowerCase().endsWith(".ofd"))
    {
      i = a.j.app_attach_file_icon_ofd;
      AppMethodBeat.o(141178);
      return i;
    }
    i = a.j.app_attach_file_icon_unknow;
    AppMethodBeat.o(141178);
    return i;
  }
  
  public static boolean brB(String paramString)
  {
    AppMethodBeat.i(141179);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(141179);
      return true;
    }
    AppMethodBeat.o(141179);
    return false;
  }
  
  public static boolean brC(String paramString)
  {
    AppMethodBeat.i(141180);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
    {
      AppMethodBeat.o(141180);
      return true;
    }
    AppMethodBeat.o(141180);
    return false;
  }
  
  public static boolean brD(String paramString)
  {
    AppMethodBeat.i(245522);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
    {
      AppMethodBeat.o(245522);
      return true;
    }
    AppMethodBeat.o(245522);
    return false;
  }
  
  public static boolean brE(String paramString)
  {
    AppMethodBeat.i(245526);
    boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
    AppMethodBeat.o(245526);
    return bool;
  }
  
  public static boolean brF(String paramString)
  {
    AppMethodBeat.i(245529);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
    {
      AppMethodBeat.o(245529);
      return true;
    }
    AppMethodBeat.o(245529);
    return false;
  }
  
  public static boolean brG(String paramString)
  {
    AppMethodBeat.i(245532);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
    {
      AppMethodBeat.o(245532);
      return true;
    }
    AppMethodBeat.o(245532);
    return false;
  }
  
  public int getLayoutId()
  {
    return a.h.mail_file_explorer;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(141176);
    this.Yrk = ((ListView)findViewById(a.g.qqmail_file_explorer_list_lv));
    this.Yrm = ((TextView)findViewById(a.g.root_tab));
    this.Yro = findViewById(a.g.root_tab_selector);
    this.Yrn = ((TextView)findViewById(a.g.sdcard_tab));
    this.Yrp = findViewById(a.g.sdcard_tab_selector);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(141160);
        if (FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)) != null)
        {
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            FileExplorerUI.a(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
          }
          for (;;)
          {
            FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).jKP(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.iNT();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        h.baE().ban().B(131074, ah.v(FileExplorerUI.d(FileExplorerUI.this).jKT()));
        h.baE().ban().B(131073, ah.v(FileExplorerUI.e(FileExplorerUI.this).jKT()));
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.Yrq = getString(a.k.plugin_qqmail_file_explorer_root_tag);
    this.Yrr = getString(a.k.plugin_qqmail_file_explorer_sdcard_tag);
    final u localu1 = u.V(g.aQb());
    final u localu2;
    label140:
    Object localObject1;
    if (localu1.jKQ())
    {
      if (!h.baE().isSDCardAvailable()) {
        break label498;
      }
      localu2 = u.V(g.aPZ());
      aq localaq = h.baE().ban();
      if (localu1 != null) {
        break label532;
      }
      localObject1 = null;
      label155:
      localObject1 = (String)localaq.d(131073, localObject1);
      if ((localObject1 == null) || (localu1 == null) || (ah.v(localu1.jKT()).equals(localObject1))) {
        break label544;
      }
      localObject1 = new u((String)localObject1);
      if (!((u)localObject1).jKS()) {
        break label544;
      }
      label213:
      this.Yrs = ((u)localObject1);
      localaq = h.baE().ban();
      if (localu2 != null) {
        break label550;
      }
      localObject1 = localObject2;
      label236:
      localObject1 = (String)localaq.d(131074, localObject1);
      if ((localObject1 == null) || (localu2 == null) || (ah.v(localu2.jKT()).equals(localObject1))) {
        break label563;
      }
      localObject1 = new u((String)localObject1);
      if (!((u)localObject1).jKS()) {
        break label563;
      }
      label296:
      this.Yrt = ((u)localObject1);
      this.Yrl = new a((byte)0);
      if (localu2 == null) {
        break label570;
      }
      axc(1);
      this.Yrl.oYg = ah.v(localu2.mUri);
      this.Yrl.g(this.Yrt.jKP(), this.Yrt);
      label358:
      localObject1 = this.Yrm;
      if (localu1 == null) {
        break label630;
      }
      bool1 = true;
      label370:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.Yrn;
      if (localu2 == null) {
        break label635;
      }
    }
    label498:
    label630:
    label635:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.Yrk.setAdapter(this.Yrl);
      this.Yrl.notifyDataSetChanged();
      this.Yrk.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          b localb = new b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (u)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.jKV())
            {
              h.baE().ban().B(131074, ah.v(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).jKT()));
              h.baE().ban().B(131073, ah.v(FileExplorerUI.e(FileExplorerUI.this).jKT()));
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label324;
              }
              FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).jKP(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.iNT();
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(141161);
            return;
            FileExplorerUI.a(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            if (FileExplorerUI.b(FileExplorerUI.this) != 0) {
              break;
            }
            if (paramAnonymousAdapterView.jKV())
            {
              h.baE().ban().B(131073, ah.v(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).jKT()));
              h.baE().ban().B(131074, ah.v(FileExplorerUI.d(FileExplorerUI.this).jKT()));
              break;
            }
            FileExplorerUI.b(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            label324:
            if (paramAnonymousAdapterView.isDirectory())
            {
              FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)), paramAnonymousAdapterView);
            }
            else if (paramAnonymousAdapterView.jKV())
            {
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", ah.v(paramAnonymousAdapterView.jKT())));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.Yrm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).oYg = ah.v(localu1.mUri);
          FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.e(FileExplorerUI.this).jKP(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141162);
        }
      });
      this.Yrn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).oYg = ah.v(localu2.mUri);
          FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.d(FileExplorerUI.this).jKP(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      localu1 = u.V(g.aQa());
      if (localu1.jKQ())
      {
        this.Yrq = localu1.getName();
        break;
      }
      localu1 = null;
      break;
      localu2 = u.V(g.aQc());
      if (localu2.jKQ())
      {
        this.Yrr = localu2.getName();
        break label140;
      }
      localu2 = null;
      break label140;
      localObject1 = ah.v(localu1.jKT());
      break label155;
      localObject1 = localu1;
      break label213;
      localObject1 = ah.v(localu2.jKT());
      break label236;
      localObject1 = localu2;
      break label296;
      if (localu1 != null)
      {
        axc(0);
        this.Yrl.oYg = ah.v(localu1.mUri);
        this.Yrl.g(this.Yrs.jKP(), this.Yrs);
        break label358;
      }
      Log.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(141176);
      return;
      bool1 = false;
      break label370;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(141171);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (Util.isNullOrNil(paramBundle)) {
      setMMTitle(a.k.plugin_qqmail_file_explorer_ui_title);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(141171);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(141174);
    super.onDestroy();
    AppMethodBeat.o(141174);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141175);
    if ((paramInt == 4) && (a.a(this.Yrl) != null))
    {
      if (1 == this.Yrj) {
        this.Yrt = a.a(this.Yrl);
      }
      for (;;)
      {
        this.Yrl.g(a.a(this.Yrl).jKP(), a.a(this.Yrl));
        this.Yrl.notifyDataSetChanged();
        this.Yrk.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.Yrj == 0) {
          this.Yrs = a.a(this.Yrl);
        }
      }
    }
    if (this.Yrt != null) {
      h.baE().ban().B(131074, ah.v(this.Yrt.jKT()));
    }
    if (this.Yrs != null) {
      h.baE().ban().B(131073, ah.v(this.Yrs.jKT()));
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(141175);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(141173);
    super.onPause();
    AppMethodBeat.o(141173);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(141172);
    super.onResume();
    AppMethodBeat.o(141172);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private u Yrx;
    private u Yry;
    private u[] Yrz;
    String oYg;
    
    private a() {}
    
    private void a(u[] paramArrayOfu)
    {
      AppMethodBeat.i(175955);
      if ((paramArrayOfu == null) || (paramArrayOfu.length == 0))
      {
        AppMethodBeat.o(175955);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfu.length;
      int i = 0;
      if (i < j)
      {
        u localu = paramArrayOfu[i];
        FileExplorerUI.b localb = new FileExplorerUI.b(FileExplorerUI.this, (byte)0);
        localb.file = localu;
        localb.YrB = com.tencent.mm.platformtools.f.RZ(localu.getName()).toUpperCase();
        if (localu.isDirectory()) {
          ((List)localObject2).add(localb);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(localb);
        }
      }
      Collections.sort((List)localObject2, new Comparator() {});
      Collections.sort((List)localObject1, new Comparator() {});
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfu[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfu[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void g(u paramu1, u paramu2)
    {
      AppMethodBeat.i(175954);
      this.Yrx = paramu1;
      if (ah.v(paramu2.jKT()).equalsIgnoreCase(this.oYg)) {
        this.Yrx = null;
      }
      this.Yry = paramu2;
      if ((this.Yry.jKQ()) && (this.Yry.isDirectory()))
      {
        this.Yrz = this.Yry.a(new w()
        {
          public final boolean accept(u paramAnonymousu)
          {
            AppMethodBeat.i(175953);
            if (paramAnonymousu.isHidden())
            {
              AppMethodBeat.o(175953);
              return false;
            }
            AppMethodBeat.o(175953);
            return true;
          }
        });
        if (this.Yrz == null) {
          this.Yrz = new u[0];
        }
        if (this.Yrz.length > 0)
        {
          a(this.Yrz);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.Yrz = new u[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.Yrz == null) {
        return 0;
      }
      int j = this.Yrz.length;
      if (this.Yrx != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.Yrx != null) && (paramInt == 0))
      {
        localObject = this.Yrx;
        AppMethodBeat.o(141168);
        return localObject;
      }
      Log.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.Yrz.length);
      Object localObject = this.Yrz;
      if (this.Yrx == null) {}
      for (;;)
      {
        localObject = localObject[paramInt];
        AppMethodBeat.o(141168);
        return localObject;
        paramInt -= 1;
      }
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(141169);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = View.inflate(FileExplorerUI.this, a.h.mail_file_explorer_item, null);
        paramView = new FileExplorerUI.c(FileExplorerUI.this, (byte)0);
        paramView.ttT = ((ImageView)paramViewGroup.findViewById(a.g.file_icon_iv));
        paramView.pUL = ((TextView)paramViewGroup.findViewById(a.g.file_name_tv));
        paramView.YrC = ((TextView)paramViewGroup.findViewById(a.g.file_summary_tv));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (u)getItem(paramInt);
      if (paramView == this.Yrx)
      {
        ((FileExplorerUI.c)localObject).pUL.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).ttT.setImageResource(a.f.qqmail_attach_back);
        ((FileExplorerUI.c)localObject).YrC.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).ttT.setImageResource(FileExplorerUI.ae(paramView));
      ((FileExplorerUI.c)localObject).pUL.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).YrC;
      StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
      if (paramView.isDirectory()) {}
      for (paramView = "";; paramView = "  " + Util.getSizeKB(paramView.length()))
      {
        ((TextView)localObject).setText(paramView);
        break;
      }
    }
  }
  
  final class b
  {
    String YrB;
    u file;
    
    private b() {}
  }
  
  final class c
  {
    TextView YrC;
    TextView pUL;
    ImageView ttT;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */