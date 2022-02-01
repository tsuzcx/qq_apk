package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI
  extends MMActivity
{
  private int RuN = 0;
  private ListView RuO;
  private a RuP;
  private TextView RuQ;
  private TextView RuR;
  private View RuS;
  private View RuT;
  private String RuU;
  private String RuV;
  private q RuW;
  private q RuX;
  
  private void aqW(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.RuN = 1;
      this.RuR.setTextColor(getResources().getColor(a.d.green_text_color));
      this.RuQ.setTextColor(getResources().getColor(a.d.normal_text_color));
      this.RuS.setVisibility(4);
      this.RuT.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.RuN = 0;
    this.RuQ.setTextColor(getResources().getColor(a.d.green_text_color));
    this.RuR.setTextColor(getResources().getColor(a.d.normal_text_color));
    this.RuS.setVisibility(0);
    this.RuT.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int brL(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    if (brO(paramString))
    {
      i = a.j.app_attach_file_icon_word;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brM(paramString))
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
    if (brP(paramString))
    {
      i = a.j.app_attach_file_icon_pdf;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brQ(paramString))
    {
      i = a.j.app_attach_file_icon_ppt;
      AppMethodBeat.o(141178);
      return i;
    }
    if (brR(paramString))
    {
      i = a.j.app_attach_file_icon_excel;
      AppMethodBeat.o(141178);
      return i;
    }
    i = a.j.app_attach_file_icon_unknow;
    AppMethodBeat.o(141178);
    return i;
  }
  
  public static boolean brM(String paramString)
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
  
  public static boolean brN(String paramString)
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
  
  public static boolean brO(String paramString)
  {
    AppMethodBeat.i(197376);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
    {
      AppMethodBeat.o(197376);
      return true;
    }
    AppMethodBeat.o(197376);
    return false;
  }
  
  public static boolean brP(String paramString)
  {
    AppMethodBeat.i(197377);
    boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
    AppMethodBeat.o(197377);
    return bool;
  }
  
  public static boolean brQ(String paramString)
  {
    AppMethodBeat.i(197378);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
    {
      AppMethodBeat.o(197378);
      return true;
    }
    AppMethodBeat.o(197378);
    return false;
  }
  
  public static boolean brR(String paramString)
  {
    AppMethodBeat.i(197381);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
    {
      AppMethodBeat.o(197381);
      return true;
    }
    AppMethodBeat.o(197381);
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
    this.RuO = ((ListView)findViewById(a.g.qqmail_file_explorer_list_lv));
    this.RuQ = ((TextView)findViewById(a.g.root_tab));
    this.RuS = findViewById(a.g.root_tab_selector);
    this.RuR = ((TextView)findViewById(a.g.sdcard_tab));
    this.RuT = findViewById(a.g.sdcard_tab_selector);
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
            FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).ifB(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.hnd();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        h.aHG().aHp().i(131074, FileExplorerUI.d(FileExplorerUI.this).bOF());
        h.aHG().aHp().i(131073, FileExplorerUI.e(FileExplorerUI.this).bOF());
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.RuU = getString(a.k.plugin_qqmail_file_explorer_root_tag);
    this.RuV = getString(a.k.plugin_qqmail_file_explorer_sdcard_tag);
    final q localq1 = q.Q(g.avH());
    final q localq2;
    label140:
    Object localObject1;
    if (localq1.ifC())
    {
      if (!h.aHG().isSDCardAvailable()) {
        break label489;
      }
      localq2 = q.Q(g.avF());
      ao localao = h.aHG().aHp();
      if (localq1 != null) {
        break label523;
      }
      localObject1 = null;
      label155:
      localObject1 = (String)localao.b(131073, localObject1);
      if ((localObject1 == null) || (localq1 == null) || (localq1.bOF().equals(localObject1))) {
        break label532;
      }
      localObject1 = new q((String)localObject1);
      if (!((q)localObject1).ifE()) {
        break label532;
      }
      label210:
      this.RuW = ((q)localObject1);
      localao = h.aHG().aHp();
      if (localq2 != null) {
        break label538;
      }
      localObject1 = localObject2;
      label233:
      localObject1 = (String)localao.b(131074, localObject1);
      if ((localObject1 == null) || (localq2 == null) || (localq2.bOF().equals(localObject1))) {
        break label548;
      }
      localObject1 = new q((String)localObject1);
      if (!((q)localObject1).ifE()) {
        break label548;
      }
      label290:
      this.RuX = ((q)localObject1);
      this.RuP = new a((byte)0);
      if (localq2 == null) {
        break label555;
      }
      aqW(1);
      this.RuP.mfn = localq2.getPath();
      this.RuP.d(this.RuX.ifB(), this.RuX);
      label349:
      localObject1 = this.RuQ;
      if (localq1 == null) {
        break label612;
      }
      bool1 = true;
      label361:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.RuR;
      if (localq2 == null) {
        break label617;
      }
    }
    label523:
    label532:
    label538:
    label548:
    label555:
    label612:
    label617:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.RuO.setAdapter(this.RuP);
      this.RuP.notifyDataSetChanged();
      this.RuO.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          b localb = new b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (q)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.ifH())
            {
              h.aHG().aHp().i(131074, FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).bOF());
              h.aHG().aHp().i(131073, FileExplorerUI.e(FileExplorerUI.this).bOF());
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label312;
              }
              FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).ifB(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.hnd();
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
            if (paramAnonymousAdapterView.ifH())
            {
              h.aHG().aHp().i(131073, FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).bOF());
              h.aHG().aHp().i(131074, FileExplorerUI.d(FileExplorerUI.this).bOF());
              break;
            }
            FileExplorerUI.b(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            label312:
            if (paramAnonymousAdapterView.isDirectory())
            {
              FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)), paramAnonymousAdapterView);
            }
            else if (paramAnonymousAdapterView.ifH())
            {
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", paramAnonymousAdapterView.bOF()));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.RuQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).mfn = localq1.getPath();
          FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.e(FileExplorerUI.this).ifB(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141162);
        }
      });
      this.RuR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).mfn = localq2.getPath();
          FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.d(FileExplorerUI.this).ifB(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      localq1 = q.Q(g.avG());
      if (localq1.ifC())
      {
        this.RuU = localq1.getName();
        break;
      }
      localq1 = null;
      break;
      label489:
      localq2 = q.Q(g.avI());
      if (localq2.ifC())
      {
        this.RuV = localq2.getName();
        break label140;
      }
      localq2 = null;
      break label140;
      localObject1 = localq1.bOF();
      break label155;
      localObject1 = localq1;
      break label210;
      localObject1 = localq2.bOF();
      break label233;
      localObject1 = localq2;
      break label290;
      if (localq1 != null)
      {
        aqW(0);
        this.RuP.mfn = localq1.getPath();
        this.RuP.d(this.RuW.ifB(), this.RuW);
        break label349;
      }
      Log.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(141176);
      return;
      bool1 = false;
      break label361;
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
    if ((paramInt == 4) && (a.a(this.RuP) != null))
    {
      if (1 == this.RuN) {
        this.RuX = a.a(this.RuP);
      }
      for (;;)
      {
        this.RuP.d(a.a(this.RuP).ifB(), a.a(this.RuP));
        this.RuP.notifyDataSetChanged();
        this.RuO.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.RuN == 0) {
          this.RuW = a.a(this.RuP);
        }
      }
    }
    if (this.RuX != null) {
      h.aHG().aHp().i(131074, this.RuX.bOF());
    }
    if (this.RuW != null) {
      h.aHG().aHp().i(131073, this.RuW.bOF());
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
    private q Rvb;
    private q Rvc;
    private q[] Rvd;
    String mfn;
    
    private a() {}
    
    private void a(q[] paramArrayOfq)
    {
      AppMethodBeat.i(175955);
      if ((paramArrayOfq == null) || (paramArrayOfq.length == 0))
      {
        AppMethodBeat.o(175955);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfq.length;
      int i = 0;
      if (i < j)
      {
        q localq = paramArrayOfq[i];
        FileExplorerUI.b localb = new FileExplorerUI.b(FileExplorerUI.this, (byte)0);
        localb.file = localq;
        localb.Rvf = com.tencent.mm.platformtools.f.ZJ(localq.getName()).toUpperCase();
        if (localq.isDirectory()) {
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
        paramArrayOfq[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfq[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void d(q paramq1, q paramq2)
    {
      AppMethodBeat.i(175954);
      this.Rvb = paramq1;
      if (paramq2.bOF().equalsIgnoreCase(this.mfn)) {
        this.Rvb = null;
      }
      this.Rvc = paramq2;
      if ((this.Rvc.ifC()) && (this.Rvc.isDirectory()))
      {
        this.Rvd = this.Rvc.a(new s()
        {
          public final boolean accept(q paramAnonymousq)
          {
            AppMethodBeat.i(175953);
            if (paramAnonymousq.isHidden())
            {
              AppMethodBeat.o(175953);
              return false;
            }
            AppMethodBeat.o(175953);
            return true;
          }
        });
        if (this.Rvd == null) {
          this.Rvd = new q[0];
        }
        if (this.Rvd.length > 0)
        {
          a(this.Rvd);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.Rvd = new q[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.Rvd == null) {
        return 0;
      }
      int j = this.Rvd.length;
      if (this.Rvb != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.Rvb != null) && (paramInt == 0))
      {
        localObject = this.Rvb;
        AppMethodBeat.o(141168);
        return localObject;
      }
      Log.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.Rvd.length);
      Object localObject = this.Rvd;
      if (this.Rvb == null) {}
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
        paramView.qps = ((ImageView)paramViewGroup.findViewById(a.g.file_icon_iv));
        paramView.mYd = ((TextView)paramViewGroup.findViewById(a.g.file_name_tv));
        paramView.Rvg = ((TextView)paramViewGroup.findViewById(a.g.file_summary_tv));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (q)getItem(paramInt);
      if (paramView == this.Rvb)
      {
        ((FileExplorerUI.c)localObject).mYd.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).qps.setImageResource(a.f.qqmail_attach_back);
        ((FileExplorerUI.c)localObject).Rvg.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).qps.setImageResource(FileExplorerUI.ab(paramView));
      ((FileExplorerUI.c)localObject).mYd.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).Rvg;
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
    String Rvf;
    q file;
    
    private b() {}
  }
  
  final class c
  {
    TextView Rvg;
    TextView mYd;
    ImageView qps;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */