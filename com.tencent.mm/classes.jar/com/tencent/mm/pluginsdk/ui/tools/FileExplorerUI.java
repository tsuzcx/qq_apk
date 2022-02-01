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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI
  extends MMActivity
{
  private com.tencent.mm.vfs.e FjA;
  private int Fjq = 0;
  private ListView Fjr;
  private a Fjs;
  private TextView Fjt;
  private TextView Fju;
  private View Fjv;
  private View Fjw;
  private String Fjx;
  private String Fjy;
  private com.tencent.mm.vfs.e Fjz;
  
  private void Zu(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.Fjq = 1;
      this.Fju.setTextColor(getResources().getColor(2131100464));
      this.Fjt.setTextColor(getResources().getColor(2131100711));
      this.Fjv.setVisibility(4);
      this.Fjw.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.Fjq = 0;
    this.Fjt.setTextColor(getResources().getColor(2131100464));
    this.Fju.setTextColor(getResources().getColor(2131100711));
    this.Fjv.setVisibility(0);
    this.Fjw.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int aNp(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    String str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689585;
    }
    if (aNq(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131233696;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689573;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689576;
    }
    if (bt.nullAsNil(paramString).toLowerCase().endsWith(".pdf"))
    {
      AppMethodBeat.o(141178);
      return 2131689568;
    }
    str = bt.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689571;
    }
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if (!paramString.endsWith(".xls"))
    {
      i = j;
      if (!paramString.endsWith(".xlsx")) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0)
    {
      AppMethodBeat.o(141178);
      return 2131689557;
    }
    AppMethodBeat.o(141178);
    return 2131689577;
  }
  
  public static boolean aNq(String paramString)
  {
    AppMethodBeat.i(141179);
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(141179);
      return true;
    }
    AppMethodBeat.o(141179);
    return false;
  }
  
  public static boolean aNr(String paramString)
  {
    AppMethodBeat.i(141180);
    paramString = bt.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
    {
      AppMethodBeat.o(141180);
      return true;
    }
    AppMethodBeat.o(141180);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494677;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(141176);
    this.Fjr = ((ListView)findViewById(2131303599));
    this.Fjt = ((TextView)findViewById(2131304249));
    this.Fjv = findViewById(2131304250);
    this.Fju = ((TextView)findViewById(2131304381));
    this.Fjw = findViewById(2131304382);
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
            FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fOJ(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.ffa();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        com.tencent.mm.kernel.g.ajC().ajl().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fOK()));
        com.tencent.mm.kernel.g.ajC().ajl().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fOK()));
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.Fjx = getString(2131761977);
    this.Fjy = getString(2131761978);
    final com.tencent.mm.vfs.e locale1 = com.tencent.mm.vfs.e.X(com.tencent.mm.compatible.util.g.getRootDirectory());
    final com.tencent.mm.vfs.e locale2;
    label132:
    Object localObject1;
    if (locale1.canRead())
    {
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        break label489;
      }
      locale2 = com.tencent.mm.vfs.e.X(com.tencent.mm.compatible.util.g.getExternalStorageDirectory());
      ai localai = com.tencent.mm.kernel.g.ajC().ajl();
      if (locale1 != null) {
        break label523;
      }
      localObject1 = null;
      label147:
      localObject1 = (String)localai.get(131073, localObject1);
      if ((localObject1 == null) || (locale1 == null) || (q.B(locale1.fOK()).equals(localObject1))) {
        break label535;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label535;
      }
      label205:
      this.Fjz = ((com.tencent.mm.vfs.e)localObject1);
      localai = com.tencent.mm.kernel.g.ajC().ajl();
      if (locale2 != null) {
        break label541;
      }
      localObject1 = localObject2;
      label228:
      localObject1 = (String)localai.get(131074, localObject1);
      if ((localObject1 == null) || (locale2 == null) || (q.B(locale2.fOK()).equals(localObject1))) {
        break label554;
      }
      localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
      if (!((com.tencent.mm.vfs.e)localObject1).exists()) {
        break label554;
      }
      label288:
      this.FjA = ((com.tencent.mm.vfs.e)localObject1);
      this.Fjs = new a((byte)0);
      if (locale2 == null) {
        break label561;
      }
      Zu(1);
      this.Fjs.irF = q.B(locale2.mUri);
      this.Fjs.c(this.FjA.fOJ(), this.FjA);
      label350:
      localObject1 = this.Fjt;
      if (locale1 == null) {
        break label620;
      }
      bool1 = true;
      label362:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.Fju;
      if (locale2 == null) {
        break label625;
      }
    }
    label489:
    label620:
    label625:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.Fjr.setAdapter(this.Fjs);
      this.Fjs.notifyDataSetChanged();
      this.Fjr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          b localb = new b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          paramAnonymousAdapterView = (com.tencent.mm.vfs.e)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.ajC().ajl().set(131074, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fOK()));
              com.tencent.mm.kernel.g.ajC().ajl().set(131073, q.B(FileExplorerUI.e(FileExplorerUI.this).fOK()));
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label324;
              }
              FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).fOJ(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.ffa();
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
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.ajC().ajl().set(131073, q.B(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).fOK()));
              com.tencent.mm.kernel.g.ajC().ajl().set(131074, q.B(FileExplorerUI.d(FileExplorerUI.this).fOK()));
              break;
            }
            FileExplorerUI.b(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            label324:
            if (paramAnonymousAdapterView.isDirectory())
            {
              FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)), paramAnonymousAdapterView);
            }
            else if (paramAnonymousAdapterView.isFile())
            {
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", q.B(paramAnonymousAdapterView.fOK())));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.Fjt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).irF = q.B(locale1.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.e(FileExplorerUI.this).fOJ(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141162);
        }
      });
      this.Fju.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).irF = q.B(locale2.mUri);
          FileExplorerUI.a(FileExplorerUI.this).c(FileExplorerUI.d(FileExplorerUI.this).fOJ(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      locale1 = com.tencent.mm.vfs.e.X(com.tencent.mm.compatible.util.g.getDataDirectory());
      if (locale1.canRead())
      {
        this.Fjx = locale1.getName();
        break;
      }
      locale1 = null;
      break;
      locale2 = com.tencent.mm.vfs.e.X(com.tencent.mm.compatible.util.g.getDownloadCacheDirectory());
      if (locale2.canRead())
      {
        this.Fjy = locale2.getName();
        break label132;
      }
      locale2 = null;
      break label132;
      localObject1 = q.B(locale1.fOK());
      break label147;
      localObject1 = locale1;
      break label205;
      localObject1 = q.B(locale2.fOK());
      break label228;
      localObject1 = locale2;
      break label288;
      if (locale1 != null)
      {
        Zu(0);
        this.Fjs.irF = q.B(locale1.mUri);
        this.Fjs.c(this.Fjz.fOJ(), this.Fjz);
        break label350;
      }
      ad.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(141176);
      return;
      bool1 = false;
      break label362;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(141171);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (bt.isNullOrNil(paramBundle)) {
      setMMTitle(2131761979);
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
    if ((paramInt == 4) && (a.a(this.Fjs) != null))
    {
      if (1 == this.Fjq) {
        this.FjA = a.a(this.Fjs);
      }
      for (;;)
      {
        this.Fjs.c(a.a(this.Fjs).fOJ(), a.a(this.Fjs));
        this.Fjs.notifyDataSetChanged();
        this.Fjr.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.Fjq == 0) {
          this.Fjz = a.a(this.Fjs);
        }
      }
    }
    if (this.FjA != null) {
      com.tencent.mm.kernel.g.ajC().ajl().set(131074, q.B(this.FjA.fOK()));
    }
    if (this.Fjz != null) {
      com.tencent.mm.kernel.g.ajC().ajl().set(131073, q.B(this.Fjz.fOK()));
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
    private com.tencent.mm.vfs.e FjE;
    private com.tencent.mm.vfs.e FjF;
    private com.tencent.mm.vfs.e[] FjG;
    String irF;
    
    private a() {}
    
    private void a(com.tencent.mm.vfs.e[] paramArrayOfe)
    {
      AppMethodBeat.i(175955);
      if ((paramArrayOfe == null) || (paramArrayOfe.length == 0))
      {
        AppMethodBeat.o(175955);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfe.length;
      int i = 0;
      if (i < j)
      {
        com.tencent.mm.vfs.e locale = paramArrayOfe[i];
        FileExplorerUI.b localb = new FileExplorerUI.b(FileExplorerUI.this, (byte)0);
        localb.aXd = locale;
        localb.FjI = f.IL(locale.getName()).toUpperCase();
        if (locale.isDirectory()) {
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
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).aXd;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfe[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).aXd;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void c(com.tencent.mm.vfs.e parame1, com.tencent.mm.vfs.e parame2)
    {
      AppMethodBeat.i(175954);
      this.FjE = parame1;
      if (q.B(parame2.fOK()).equalsIgnoreCase(this.irF)) {
        this.FjE = null;
      }
      this.FjF = parame2;
      if ((this.FjF.canRead()) && (this.FjF.isDirectory()))
      {
        this.FjG = this.FjF.a(new com.tencent.mm.vfs.g()
        {
          public final boolean accept(com.tencent.mm.vfs.e paramAnonymouse)
          {
            AppMethodBeat.i(175953);
            if (paramAnonymouse.isHidden())
            {
              AppMethodBeat.o(175953);
              return false;
            }
            AppMethodBeat.o(175953);
            return true;
          }
        });
        if (this.FjG == null) {
          this.FjG = new com.tencent.mm.vfs.e[0];
        }
        if (this.FjG.length > 0)
        {
          a(this.FjG);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.FjG = new com.tencent.mm.vfs.e[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.FjG == null) {
        return 0;
      }
      int j = this.FjG.length;
      if (this.FjE != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.FjE != null) && (paramInt == 0))
      {
        localObject = this.FjE;
        AppMethodBeat.o(141168);
        return localObject;
      }
      ad.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.FjG.length);
      Object localObject = this.FjG;
      if (this.FjE == null) {}
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
        paramViewGroup = View.inflate(FileExplorerUI.this, 2131494678, null);
        paramView = new FileExplorerUI.c(FileExplorerUI.this, (byte)0);
        paramView.lZa = ((ImageView)paramViewGroup.findViewById(2131299919));
        paramView.jfJ = ((TextView)paramViewGroup.findViewById(2131299925));
        paramView.FjJ = ((TextView)paramViewGroup.findViewById(2131299931));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (com.tencent.mm.vfs.e)getItem(paramInt);
      if (paramView == this.FjE)
      {
        ((FileExplorerUI.c)localObject).jfJ.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).lZa.setImageResource(2131233694);
        ((FileExplorerUI.c)localObject).FjJ.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).lZa.setImageResource(FileExplorerUI.X(paramView));
      ((FileExplorerUI.c)localObject).jfJ.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).FjJ;
      StringBuilder localStringBuilder = new StringBuilder().append(DateFormat.format("yyyy-MM-dd hh:mm:ss", paramView.lastModified()).toString());
      if (paramView.isDirectory()) {}
      for (paramView = "";; paramView = "  " + bt.sy(paramView.length()))
      {
        ((TextView)localObject).setText(paramView);
        break;
      }
    }
  }
  
  final class b
  {
    String FjI;
    com.tencent.mm.vfs.e aXd;
    
    private b() {}
  }
  
  final class c
  {
    TextView FjJ;
    TextView jfJ;
    ImageView lZa;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */