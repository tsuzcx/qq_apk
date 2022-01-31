package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Comparator;

public class FileExplorerUI
  extends MMActivity
{
  private int web = 0;
  private ListView wec;
  private FileExplorerUI.a wed;
  private TextView wee;
  private TextView wef;
  private View weg;
  private View weh;
  private String wei;
  private String wej;
  private File wek;
  private File wel;
  
  private void Mv(int paramInt)
  {
    AppMethodBeat.i(105857);
    if (1 == paramInt)
    {
      this.web = 1;
      this.wef.setTextColor(getResources().getColor(2131690139));
      this.wee.setTextColor(getResources().getColor(2131690322));
      this.weg.setVisibility(4);
      this.weh.setVisibility(0);
      AppMethodBeat.o(105857);
      return;
    }
    this.web = 0;
    this.wee.setTextColor(getResources().getColor(2131690139));
    this.wef.setTextColor(getResources().getColor(2131690322));
    this.weg.setVisibility(0);
    this.weh.setVisibility(4);
    AppMethodBeat.o(105857);
  }
  
  public static int amF(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(105862);
    paramString = paramString.toLowerCase();
    String str = bo.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105862);
      return 2131230830;
    }
    if (amG(paramString))
    {
      AppMethodBeat.o(105862);
      return 2130840020;
    }
    str = bo.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105862);
      return 2131230818;
    }
    str = bo.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105862);
      return 2131230821;
    }
    if (bo.nullAsNil(paramString).toLowerCase().endsWith(".pdf"))
    {
      AppMethodBeat.o(105862);
      return 2131230813;
    }
    str = bo.nullAsNil(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105862);
      return 2131230816;
    }
    paramString = bo.nullAsNil(paramString).toLowerCase();
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
      AppMethodBeat.o(105862);
      return 2131230802;
    }
    AppMethodBeat.o(105862);
    return 2131230822;
  }
  
  public static boolean amG(String paramString)
  {
    AppMethodBeat.i(105863);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif")))
    {
      AppMethodBeat.o(105863);
      return true;
    }
    AppMethodBeat.o(105863);
    return false;
  }
  
  public static boolean amH(String paramString)
  {
    AppMethodBeat.i(105864);
    paramString = bo.nullAsNil(paramString).toLowerCase();
    if ((paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm")))
    {
      AppMethodBeat.o(105864);
      return true;
    }
    AppMethodBeat.o(105864);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130970063;
  }
  
  public void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    AppMethodBeat.i(105856);
    this.wec = ((ListView)findViewById(2131825874));
    this.wee = ((TextView)findViewById(2131825870));
    this.weg = findViewById(2131825871);
    this.wef = ((TextView)findViewById(2131825872));
    this.weh = findViewById(2131825873);
    setBackBtn(new FileExplorerUI.1(this));
    this.wei = getString(2131302138);
    this.wej = getString(2131302139);
    File localFile1 = h.getRootDirectory();
    final File localFile2;
    label126:
    Object localObject1;
    if (localFile1.canRead())
    {
      if (!g.RL().isSDCardAvailable()) {
        break label471;
      }
      localFile2 = h.getExternalStorageDirectory();
      z localz = g.RL().Ru();
      if (localFile1 != null) {
        break label502;
      }
      localObject1 = null;
      label141:
      localObject1 = (String)localz.get(131073, localObject1);
      if ((localObject1 == null) || (localFile1 == null) || (localFile1.getAbsolutePath().equals(localObject1))) {
        break label511;
      }
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        break label511;
      }
      label196:
      this.wek = ((File)localObject1);
      localz = g.RL().Ru();
      if (localFile2 != null) {
        break label517;
      }
      localObject1 = localObject2;
      label219:
      localObject1 = (String)localz.get(131074, localObject1);
      if ((localObject1 == null) || (localFile2 == null) || (localFile2.getAbsolutePath().equals(localObject1))) {
        break label527;
      }
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        break label527;
      }
      label276:
      this.wel = ((File)localObject1);
      this.wed = new FileExplorerUI.a(this, (byte)0);
      if (localFile2 == null) {
        break label534;
      }
      Mv(1);
      this.wed.fVd = localFile2.getPath();
      this.wed.g(this.wel.getParentFile(), this.wel);
      label335:
      localObject1 = this.wee;
      if (localFile1 == null) {
        break label590;
      }
      bool1 = true;
      label347:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.wef;
      if (localFile2 == null) {
        break label595;
      }
    }
    label517:
    label527:
    label534:
    label590:
    label595:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.wec.setAdapter(this.wed);
      this.wed.notifyDataSetChanged();
      this.wec.setOnItemClickListener(new FileExplorerUI.2(this));
      this.wee.setOnClickListener(new FileExplorerUI.3(this, localFile1));
      this.wef.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(105843);
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).fVd = localFile2.getPath();
          FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.d(FileExplorerUI.this).getParentFile(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
          AppMethodBeat.o(105843);
        }
      });
      AppMethodBeat.o(105856);
      return;
      localFile1 = h.getDataDirectory();
      if (localFile1.canRead())
      {
        this.wei = localFile1.getName();
        break;
      }
      localFile1 = null;
      break;
      label471:
      localFile2 = h.getDownloadCacheDirectory();
      if (localFile2.canRead())
      {
        this.wej = localFile2.getName();
        break label126;
      }
      localFile2 = null;
      break label126;
      label502:
      localObject1 = localFile1.getAbsolutePath();
      break label141;
      label511:
      localObject1 = localFile1;
      break label196;
      localObject1 = localFile2.getAbsolutePath();
      break label219;
      localObject1 = localFile2;
      break label276;
      if (localFile1 != null)
      {
        Mv(0);
        this.wed.fVd = localFile1.getPath();
        this.wed.g(this.wek.getParentFile(), this.wek);
        break label335;
      }
      ab.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      AppMethodBeat.o(105856);
      return;
      bool1 = false;
      break label347;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(105851);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (bo.isNullOrNil(paramBundle)) {
      setMMTitle(2131302140);
    }
    for (;;)
    {
      initView();
      AppMethodBeat.o(105851);
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(105854);
    super.onDestroy();
    AppMethodBeat.o(105854);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(105855);
    if ((paramInt == 4) && (FileExplorerUI.a.a(this.wed) != null))
    {
      if (1 == this.web) {
        this.wel = FileExplorerUI.a.a(this.wed);
      }
      for (;;)
      {
        this.wed.g(FileExplorerUI.a.a(this.wed).getParentFile(), FileExplorerUI.a.a(this.wed));
        this.wed.notifyDataSetChanged();
        this.wec.setSelection(0);
        AppMethodBeat.o(105855);
        return true;
        if (this.web == 0) {
          this.wek = FileExplorerUI.a.a(this.wed);
        }
      }
    }
    if (this.wel != null) {
      g.RL().Ru().set(131074, this.wel.getAbsolutePath());
    }
    if (this.wek != null) {
      g.RL().Ru().set(131073, this.wek.getAbsolutePath());
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(105855);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(105853);
    super.onPause();
    AppMethodBeat.o(105853);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(105852);
    super.onResume();
    AppMethodBeat.o(105852);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */