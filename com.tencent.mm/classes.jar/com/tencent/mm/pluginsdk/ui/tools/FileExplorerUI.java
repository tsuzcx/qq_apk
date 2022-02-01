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
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI
  extends MMActivity
{
  private int KtH = 0;
  private ListView KtI;
  private a KtJ;
  private TextView KtK;
  private TextView KtL;
  private View KtM;
  private View KtN;
  private String KtO;
  private String KtP;
  private o KtQ;
  private o KtR;
  
  private void aiP(int paramInt)
  {
    AppMethodBeat.i(141177);
    if (1 == paramInt)
    {
      this.KtH = 1;
      this.KtL.setTextColor(getResources().getColor(2131100566));
      this.KtK.setTextColor(getResources().getColor(2131100904));
      this.KtM.setVisibility(4);
      this.KtN.setVisibility(0);
      AppMethodBeat.o(141177);
      return;
    }
    this.KtH = 0;
    this.KtK.setTextColor(getResources().getColor(2131100566));
    this.KtL.setTextColor(getResources().getColor(2131100904));
    this.KtM.setVisibility(0);
    this.KtN.setVisibility(4);
    AppMethodBeat.o(141177);
  }
  
  public static int bfq(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(141178);
    paramString = paramString.toLowerCase();
    if (bft(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131689588;
    }
    if (bfr(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131234512;
    }
    String str = Util.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(141178);
      return 2131689576;
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
      AppMethodBeat.o(141178);
      return 2131689579;
    }
    if (bfu(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131689571;
    }
    if (bfv(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131689574;
    }
    if (bfw(paramString))
    {
      AppMethodBeat.o(141178);
      return 2131689560;
    }
    AppMethodBeat.o(141178);
    return 2131689580;
  }
  
  public static boolean bfr(String paramString)
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
  
  public static boolean bfs(String paramString)
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
  
  public static boolean bft(String paramString)
  {
    AppMethodBeat.i(205088);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".doc")) || (paramString.endsWith(".docx")) || (paramString.endsWith("wps")))
    {
      AppMethodBeat.o(205088);
      return true;
    }
    AppMethodBeat.o(205088);
    return false;
  }
  
  public static boolean bfu(String paramString)
  {
    AppMethodBeat.i(205089);
    boolean bool = Util.nullAsNil(paramString).toLowerCase().endsWith(".pdf");
    AppMethodBeat.o(205089);
    return bool;
  }
  
  public static boolean bfv(String paramString)
  {
    AppMethodBeat.i(205090);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".ppt")) || (paramString.endsWith(".pptx")))
    {
      AppMethodBeat.o(205090);
      return true;
    }
    AppMethodBeat.o(205090);
    return false;
  }
  
  public static boolean bfw(String paramString)
  {
    AppMethodBeat.i(205091);
    paramString = Util.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".xls")) || (paramString.endsWith(".xlsx")))
    {
      AppMethodBeat.o(205091);
      return true;
    }
    AppMethodBeat.o(205091);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495403;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(141176);
    this.KtI = ((ListView)findViewById(2131306376));
    this.KtK = ((TextView)findViewById(2131307170));
    this.KtM = findViewById(2131307171);
    this.KtL = ((TextView)findViewById(2131307344));
    this.KtN = findViewById(2131307345);
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
            FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).heq(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.gse();
            AppMethodBeat.o(141160);
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(131074, aa.z(FileExplorerUI.d(FileExplorerUI.this).her()));
        com.tencent.mm.kernel.g.aAh().azQ().set(131073, aa.z(FileExplorerUI.e(FileExplorerUI.this).her()));
        FileExplorerUI.this.finish();
        AppMethodBeat.o(141160);
        return true;
      }
    });
    this.KtO = getString(2131763983);
    this.KtP = getString(2131763984);
    final o localo1 = o.X(com.tencent.mm.compatible.util.g.getRootDirectory());
    final o localo2;
    label133:
    Object localObject1;
    if (localo1.canRead())
    {
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
        break label490;
      }
      localo2 = o.X(com.tencent.mm.compatible.util.g.getExternalStorageDirectory());
      ao localao = com.tencent.mm.kernel.g.aAh().azQ();
      if (localo1 != null) {
        break label524;
      }
      localObject1 = null;
      label148:
      localObject1 = (String)localao.get(131073, localObject1);
      if ((localObject1 == null) || (localo1 == null) || (aa.z(localo1.her()).equals(localObject1))) {
        break label536;
      }
      localObject1 = new o((String)localObject1);
      if (!((o)localObject1).exists()) {
        break label536;
      }
      label206:
      this.KtQ = ((o)localObject1);
      localao = com.tencent.mm.kernel.g.aAh().azQ();
      if (localo2 != null) {
        break label542;
      }
      localObject1 = localObject2;
      label229:
      localObject1 = (String)localao.get(131074, localObject1);
      if ((localObject1 == null) || (localo2 == null) || (aa.z(localo2.her()).equals(localObject1))) {
        break label555;
      }
      localObject1 = new o((String)localObject1);
      if (!((o)localObject1).exists()) {
        break label555;
      }
      label289:
      this.KtR = ((o)localObject1);
      this.KtJ = new a((byte)0);
      if (localo2 == null) {
        break label562;
      }
      aiP(1);
      this.KtJ.jpM = aa.z(localo2.mUri);
      this.KtJ.d(this.KtR.heq(), this.KtR);
      label351:
      localObject1 = this.KtK;
      if (localo1 == null) {
        break label621;
      }
      bool1 = true;
      label363:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.KtL;
      if (localo2 == null) {
        break label626;
      }
    }
    label490:
    label621:
    label626:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.KtI.setAdapter(this.KtJ);
      this.KtJ.notifyDataSetChanged();
      this.KtI.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(141161);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (o)FileExplorerUI.a(FileExplorerUI.this).getItem(paramAnonymousInt);
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            if (paramAnonymousAdapterView.isFile())
            {
              com.tencent.mm.kernel.g.aAh().azQ().set(131074, aa.z(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).her()));
              com.tencent.mm.kernel.g.aAh().azQ().set(131073, aa.z(FileExplorerUI.e(FileExplorerUI.this).her()));
              if (paramAnonymousAdapterView != FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this))) {
                break label324;
              }
              FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).heq(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
          for (;;)
          {
            FileExplorerUI.gse();
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
              com.tencent.mm.kernel.g.aAh().azQ().set(131073, aa.z(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)).her()));
              com.tencent.mm.kernel.g.aAh().azQ().set(131074, aa.z(FileExplorerUI.d(FileExplorerUI.this).her()));
              break;
            }
            FileExplorerUI.b(FileExplorerUI.this, paramAnonymousAdapterView);
            break;
            label324:
            if (paramAnonymousAdapterView.isDirectory())
            {
              FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.a.b(FileExplorerUI.a(FileExplorerUI.this)), paramAnonymousAdapterView);
            }
            else if (paramAnonymousAdapterView.isFile())
            {
              FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", aa.z(paramAnonymousAdapterView.her())));
              FileExplorerUI.this.finish();
            }
          }
        }
      });
      this.KtK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141162);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          FileExplorerUI.a(FileExplorerUI.this, 0);
          FileExplorerUI.a(FileExplorerUI.this).jpM = aa.z(localo1.mUri);
          FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.e(FileExplorerUI.this).heq(), FileExplorerUI.e(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141162);
        }
      });
      this.KtL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(141163);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).jpM = aa.z(localo2.mUri);
          FileExplorerUI.a(FileExplorerUI.this).d(FileExplorerUI.d(FileExplorerUI.this).heq(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileExplorerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(141163);
        }
      });
      AppMethodBeat.o(141176);
      return;
      localo1 = o.X(com.tencent.mm.compatible.util.g.getDataDirectory());
      if (localo1.canRead())
      {
        this.KtO = localo1.getName();
        break;
      }
      localo1 = null;
      break;
      localo2 = o.X(com.tencent.mm.compatible.util.g.getDownloadCacheDirectory());
      if (localo2.canRead())
      {
        this.KtP = localo2.getName();
        break label133;
      }
      localo2 = null;
      break label133;
      localObject1 = aa.z(localo1.her());
      break label148;
      localObject1 = localo1;
      break label206;
      localObject1 = aa.z(localo2.her());
      break label229;
      localObject1 = localo2;
      break label289;
      if (localo1 != null)
      {
        aiP(0);
        this.KtJ.jpM = aa.z(localo1.mUri);
        this.KtJ.d(this.KtQ.heq(), this.KtQ);
        break label351;
      }
      Log.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(141176);
      return;
      bool1 = false;
      break label363;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(141171);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (Util.isNullOrNil(paramBundle)) {
      setMMTitle(2131763985);
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
    if ((paramInt == 4) && (a.a(this.KtJ) != null))
    {
      if (1 == this.KtH) {
        this.KtR = a.a(this.KtJ);
      }
      for (;;)
      {
        this.KtJ.d(a.a(this.KtJ).heq(), a.a(this.KtJ));
        this.KtJ.notifyDataSetChanged();
        this.KtI.setSelection(0);
        AppMethodBeat.o(141175);
        return true;
        if (this.KtH == 0) {
          this.KtQ = a.a(this.KtJ);
        }
      }
    }
    if (this.KtR != null) {
      com.tencent.mm.kernel.g.aAh().azQ().set(131074, aa.z(this.KtR.her()));
    }
    if (this.KtQ != null) {
      com.tencent.mm.kernel.g.aAh().azQ().set(131073, aa.z(this.KtQ.her()));
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
    private o KtV;
    private o KtW;
    private o[] KtX;
    String jpM;
    
    private a() {}
    
    private void a(o[] paramArrayOfo)
    {
      AppMethodBeat.i(175955);
      if ((paramArrayOfo == null) || (paramArrayOfo.length == 0))
      {
        AppMethodBeat.o(175955);
        return;
      }
      Object localObject2 = new ArrayList();
      Object localObject1 = new ArrayList();
      int j = paramArrayOfo.length;
      int i = 0;
      if (i < j)
      {
        o localo = paramArrayOfo[i];
        FileExplorerUI.b localb = new FileExplorerUI.b(FileExplorerUI.this, (byte)0);
        localb.file = localo;
        localb.KtZ = f.Sh(localo.getName()).toUpperCase();
        if (localo.isDirectory()) {
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
        paramArrayOfo[i] = ((FileExplorerUI.b)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfo[i] = ((FileExplorerUI.b)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(175955);
    }
    
    public final void d(o paramo1, o paramo2)
    {
      AppMethodBeat.i(175954);
      this.KtV = paramo1;
      if (aa.z(paramo2.her()).equalsIgnoreCase(this.jpM)) {
        this.KtV = null;
      }
      this.KtW = paramo2;
      if ((this.KtW.canRead()) && (this.KtW.isDirectory()))
      {
        this.KtX = this.KtW.a(new q()
        {
          public final boolean accept(o paramAnonymouso)
          {
            AppMethodBeat.i(175953);
            if (paramAnonymouso.isHidden())
            {
              AppMethodBeat.o(175953);
              return false;
            }
            AppMethodBeat.o(175953);
            return true;
          }
        });
        if (this.KtX == null) {
          this.KtX = new o[0];
        }
        if (this.KtX.length > 0)
        {
          a(this.KtX);
          AppMethodBeat.o(175954);
        }
      }
      else
      {
        this.KtX = new o[0];
      }
      AppMethodBeat.o(175954);
    }
    
    public final int getCount()
    {
      int i = 0;
      if (this.KtX == null) {
        return 0;
      }
      int j = this.KtX.length;
      if (this.KtV != null) {
        i = 1;
      }
      return i + j;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141168);
      if ((this.KtV != null) && (paramInt == 0))
      {
        localObject = this.KtV;
        AppMethodBeat.o(141168);
        return localObject;
      }
      Log.d("FileExplorer", "pos:" + paramInt + ", subFile length:" + this.KtX.length);
      Object localObject = this.KtX;
      if (this.KtV == null) {}
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
        paramViewGroup = View.inflate(FileExplorerUI.this, 2131495404, null);
        paramView = new FileExplorerUI.c(FileExplorerUI.this, (byte)0);
        paramView.nnL = ((ImageView)paramViewGroup.findViewById(2131300622));
        paramView.kgE = ((TextView)paramViewGroup.findViewById(2131300628));
        paramView.Kua = ((TextView)paramViewGroup.findViewById(2131300635));
        paramViewGroup.setTag(paramView);
      }
      Object localObject = (FileExplorerUI.c)paramViewGroup.getTag();
      paramView = (o)getItem(paramInt);
      if (paramView == this.KtV)
      {
        ((FileExplorerUI.c)localObject).kgE.setText(paramView.getName());
        ((FileExplorerUI.c)localObject).nnL.setImageResource(2131234510);
        ((FileExplorerUI.c)localObject).Kua.setVisibility(0);
        AppMethodBeat.o(141169);
        return paramViewGroup;
      }
      ((FileExplorerUI.c)localObject).nnL.setImageResource(FileExplorerUI.ab(paramView));
      ((FileExplorerUI.c)localObject).kgE.setText(paramView.getName());
      localObject = ((FileExplorerUI.c)localObject).Kua;
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
    String KtZ;
    o file;
    
    private b() {}
  }
  
  final class c
  {
    TextView Kua;
    TextView kgE;
    ImageView nnL;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */