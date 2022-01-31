package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.Comparator;

public class FileExplorerUI
  extends MMActivity
{
  private ListView slA;
  private FileExplorerUI.a slB;
  private TextView slC;
  private TextView slD;
  private View slE;
  private View slF;
  private String slG;
  private String slH;
  private File slI;
  private File slJ;
  private int slz = 0;
  
  private void Ex(int paramInt)
  {
    if (1 == paramInt)
    {
      this.slz = 1;
      this.slD.setTextColor(getResources().getColor(a.d.wechat_green));
      this.slC.setTextColor(getResources().getColor(a.d.normal_text_color));
      this.slE.setVisibility(4);
      this.slF.setVisibility(0);
      return;
    }
    this.slz = 0;
    this.slC.setTextColor(getResources().getColor(a.d.wechat_green));
    this.slD.setTextColor(getResources().getColor(a.d.normal_text_color));
    this.slE.setVisibility(0);
    this.slF.setVisibility(4);
  }
  
  public static int WV(String paramString)
  {
    int j = 0;
    paramString = paramString.toLowerCase();
    String str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".doc")) || (str.endsWith(".docx")) || (str.endsWith("wps"))) {}
    for (int i = 1; i != 0; i = 0) {
      return a.j.app_attach_file_icon_word;
    }
    if (WW(paramString)) {
      return a.f.qqmail_attach_img;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".rar")) || (str.endsWith(".zip")) || (str.endsWith(".7z")) || (str.endsWith("tar")) || (str.endsWith(".iso"))) {}
    for (i = 1; i != 0; i = 0) {
      return a.j.app_attach_file_icon_rar;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".txt")) || (str.endsWith(".rtf"))) {}
    for (i = 1; i != 0; i = 0) {
      return a.j.app_attach_file_icon_txt;
    }
    if (bk.pm(paramString).toLowerCase().endsWith(".pdf")) {
      return a.j.app_attach_file_icon_pdf;
    }
    str = bk.pm(paramString).toLowerCase();
    if ((str.endsWith(".ppt")) || (str.endsWith(".pptx"))) {}
    for (i = 1; i != 0; i = 0) {
      return a.j.app_attach_file_icon_ppt;
    }
    paramString = bk.pm(paramString).toLowerCase();
    if (!paramString.endsWith(".xls"))
    {
      i = j;
      if (!paramString.endsWith(".xlsx")) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return a.j.app_attach_file_icon_excel;
    }
    return a.j.app_attach_file_icon_unknow;
  }
  
  public static boolean WW(String paramString)
  {
    paramString = bk.pm(paramString).toLowerCase();
    return (paramString.endsWith(".bmp")) || (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".jpeg")) || (paramString.endsWith(".gif"));
  }
  
  public static boolean WX(String paramString)
  {
    paramString = bk.pm(paramString).toLowerCase();
    return (paramString.endsWith(".mp3")) || (paramString.endsWith(".wma")) || (paramString.endsWith(".mp4")) || (paramString.endsWith(".rm"));
  }
  
  protected final int getLayoutId()
  {
    return a.h.mail_file_explorer;
  }
  
  protected final void initView()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    this.slA = ((ListView)findViewById(a.g.qqmail_file_explorer_list_lv));
    this.slC = ((TextView)findViewById(a.g.root_tab));
    this.slE = findViewById(a.g.root_tab_selector);
    this.slD = ((TextView)findViewById(a.g.sdcard_tab));
    this.slF = findViewById(a.g.sdcard_tab_selector);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        if (FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)) != null)
        {
          if (1 == FileExplorerUI.b(FileExplorerUI.this)) {
            FileExplorerUI.a(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
          }
          for (;;)
          {
            FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)).getParentFile(), FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
            FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
            FileExplorerUI.cog();
            return true;
            if (FileExplorerUI.b(FileExplorerUI.this) == 0) {
              FileExplorerUI.b(FileExplorerUI.this, FileExplorerUI.a.a(FileExplorerUI.a(FileExplorerUI.this)));
            }
          }
        }
        g.DP().Dz().o(131074, FileExplorerUI.d(FileExplorerUI.this).getAbsolutePath());
        g.DP().Dz().o(131073, FileExplorerUI.e(FileExplorerUI.this).getAbsolutePath());
        FileExplorerUI.this.finish();
        return true;
      }
    });
    this.slG = getString(a.k.plugin_qqmail_file_explorer_root_tag);
    this.slH = getString(a.k.plugin_qqmail_file_explorer_sdcard_tag);
    File localFile1 = h.getRootDirectory();
    final File localFile2;
    label128:
    Object localObject1;
    if (localFile1.canRead())
    {
      if (!g.DP().isSDCardAvailable()) {
        break label468;
      }
      localFile2 = h.getExternalStorageDirectory();
      z localz = g.DP().Dz();
      if (localFile1 != null) {
        break label499;
      }
      localObject1 = null;
      label143:
      localObject1 = (String)localz.get(131073, localObject1);
      if ((localObject1 == null) || (localFile1 == null) || (localFile1.getAbsolutePath().equals(localObject1))) {
        break label508;
      }
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        break label508;
      }
      label198:
      this.slI = ((File)localObject1);
      localz = g.DP().Dz();
      if (localFile2 != null) {
        break label514;
      }
      localObject1 = localObject2;
      label221:
      localObject1 = (String)localz.get(131074, localObject1);
      if ((localObject1 == null) || (localFile2 == null) || (localFile2.getAbsolutePath().equals(localObject1))) {
        break label524;
      }
      localObject1 = new File((String)localObject1);
      if (!((File)localObject1).exists()) {
        break label524;
      }
      label278:
      this.slJ = ((File)localObject1);
      this.slB = new FileExplorerUI.a(this, (byte)0);
      if (localFile2 == null) {
        break label531;
      }
      Ex(1);
      this.slB.eFm = localFile2.getPath();
      this.slB.g(this.slJ.getParentFile(), this.slJ);
      label337:
      localObject1 = this.slC;
      if (localFile1 == null) {
        break label582;
      }
      bool1 = true;
      label349:
      ((TextView)localObject1).setEnabled(bool1);
      localObject1 = this.slD;
      if (localFile2 == null) {
        break label587;
      }
    }
    label514:
    label524:
    label531:
    label582:
    label587:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((TextView)localObject1).setEnabled(bool1);
      this.slA.setAdapter(this.slB);
      this.slB.notifyDataSetChanged();
      this.slA.setOnItemClickListener(new FileExplorerUI.2(this));
      this.slC.setOnClickListener(new FileExplorerUI.3(this, localFile1));
      this.slD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          FileExplorerUI.a(FileExplorerUI.this, 1);
          FileExplorerUI.a(FileExplorerUI.this).eFm = localFile2.getPath();
          FileExplorerUI.a(FileExplorerUI.this).g(FileExplorerUI.d(FileExplorerUI.this).getParentFile(), FileExplorerUI.d(FileExplorerUI.this));
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetInvalidated();
          FileExplorerUI.a(FileExplorerUI.this).notifyDataSetChanged();
          FileExplorerUI.c(FileExplorerUI.this).setSelection(0);
        }
      });
      return;
      localFile1 = h.getDataDirectory();
      if (localFile1.canRead())
      {
        this.slG = localFile1.getName();
        break;
      }
      localFile1 = null;
      break;
      label468:
      localFile2 = h.getDownloadCacheDirectory();
      if (localFile2.canRead())
      {
        this.slH = localFile2.getName();
        break label128;
      }
      localFile2 = null;
      break label128;
      label499:
      localObject1 = localFile1.getAbsolutePath();
      break label143;
      label508:
      localObject1 = localFile1;
      break label198;
      localObject1 = localFile2.getAbsolutePath();
      break label221;
      localObject1 = localFile2;
      break label278;
      if (localFile1 != null)
      {
        Ex(0);
        this.slB.eFm = localFile1.getPath();
        this.slB.g(this.slI.getParentFile(), this.slI);
        break label337;
      }
      y.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
      return;
      bool1 = false;
      break label349;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (bk.bl(paramBundle)) {
      setMMTitle(a.k.plugin_qqmail_file_explorer_ui_title);
    }
    for (;;)
    {
      initView();
      return;
      setMMTitle(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (FileExplorerUI.a.a(this.slB) != null))
    {
      if (1 == this.slz) {
        this.slJ = FileExplorerUI.a.a(this.slB);
      }
      for (;;)
      {
        this.slB.g(FileExplorerUI.a.a(this.slB).getParentFile(), FileExplorerUI.a.a(this.slB));
        this.slB.notifyDataSetChanged();
        this.slA.setSelection(0);
        return true;
        if (this.slz == 0) {
          this.slI = FileExplorerUI.a.a(this.slB);
        }
      }
    }
    if (this.slJ != null) {
      g.DP().Dz().o(131074, this.slJ.getAbsolutePath());
    }
    if (this.slI != null) {
      g.DP().Dz().o(131073, this.slI.getAbsolutePath());
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI
 * JD-Core Version:    0.7.0.1
 */