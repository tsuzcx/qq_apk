package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI
  extends MMActivity
{
  private ListView fry;
  private int mode = 0;
  private TextView nhj;
  private NewFileExplorerUI.a smN;
  private TextView smO;
  private FileSelectorFolderView smP;
  private g.a smQ;
  private FileSelectorFolderView.a smR = new NewFileExplorerUI.7(this);
  private String toUserName;
  
  private void bwF()
  {
    int i = NewFileExplorerUI.a.a(this.smN).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(R.l.app_send) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.nhj.setText(getString(R.l.file_explorer_selected_file_size, new Object[] { bk.cm(this.smN.bug()) }));
      this.nhj.setVisibility(0);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(R.l.app_send));
      enableOptionMenu(1, false);
    }
    this.nhj.setVisibility(8);
  }
  
  private void col()
  {
    if ((NewFileExplorerUI.a.b(this.smN) != null) && (NewFileExplorerUI.a.c(this.smN) != null))
    {
      Object localObject2 = NewFileExplorerUI.a.c(this.smN).getPath().replace(NewFileExplorerUI.a.b(this.smN).getPath(), "");
      Object localObject1 = localObject2;
      if (((String)localObject2).startsWith("/")) {
        localObject1 = ((String)localObject2).substring(1);
      }
      localObject2 = localObject1;
      if (((String)localObject1).length() == 0) {
        localObject2 = null;
      }
      setMMSubTitle((String)localObject2);
    }
  }
  
  private void mh(boolean paramBoolean)
  {
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.smN.cop() != null))
      {
        this.smN.a(this.smN.cop(), null);
        this.smN.notifyDataSetChanged();
        col();
        return;
      }
      setResult(0);
      finish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.smN.com());
    localIntent.putStringArrayListExtra("key_select_video_list", this.smN.coo());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.smN.con());
    localIntent.putExtra("GalleryUI_ToUser", this.toUserName);
    setResult(-1, localIntent);
    finish();
  }
  
  protected final int getLayoutId()
  {
    return R.i.new_file_explorer_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if (NewFileExplorerUI.a.a(this.smN).size() != paramIntent.size())
      {
        this.smQ.few.dismiss();
        NewFileExplorerUI.a.a(this.smN).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          str = (String)paramIntent.next();
          NewFileExplorerUI.a.a(this.smN).add(new File(str));
        }
        this.smN.notifyDataSetChanged();
        col();
        bwF();
      }
    }
    while (paramInt1 != 2)
    {
      String str;
      return;
    }
    a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.toUserName = getIntent().getStringExtra("TO_USER");
    this.fry = ((ListView)findViewById(R.h.file_explorer_lv));
    this.smN = new NewFileExplorerUI.a(this);
    this.nhj = ((TextView)findViewById(R.h.selected_file_size));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(R.l.file_explorer_selected_mode_title);
      setMMSubTitle(null);
      this.smN.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.fry.setAdapter(this.smN);
      this.fry.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).slP[paramAnonymousInt];
          if (paramAnonymousAdapterView.isDirectory())
          {
            NewFileExplorerUI.b(NewFileExplorerUI.this).a(paramAnonymousAdapterView, null);
            NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
            return;
          }
          paramAnonymousView = com.tencent.mm.a.e.bM(paramAnonymousAdapterView.getPath());
          a.b(NewFileExplorerUI.this, paramAnonymousAdapterView.getPath(), paramAnonymousView, 1);
        }
      });
      this.fry.setEmptyView(findViewById(R.h.file_explorer_empty_view));
      paramBundle = new NewFileExplorerUI.3(this);
      if (this.mode != 0) {
        break label405;
      }
    }
    label405:
    for (int i = R.k.actionbar_quit_webview_icon;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        a(1, getString(R.l.app_send), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            NewFileExplorerUI.e(NewFileExplorerUI.this);
            return true;
          }
        }, s.b.uNx);
      }
      bwF();
      return;
      setMMTitle(R.l.file_explorer_mm_download_title);
      setMMSubTitle(null);
      this.smO = ((TextView)findViewById(R.h.file_explorer_folder_title_tv));
      this.smO.setText(R.l.file_explorer_mm_download_title);
      this.smN.c(new File(com.tencent.mm.compatible.util.e.dzB), true);
      this.smN.a(new File(com.tencent.mm.compatible.util.e.dzB), null);
      if (this.smN.getCount() == 0)
      {
        this.smN.c(new File(com.tencent.mm.compatible.util.e.bkF), false);
        this.smN.a(new File(com.tencent.mm.compatible.util.e.bkF), null);
        setMMTitle(R.l.file_explorer_mobile_dir_title);
        this.smO.setText(R.l.file_explorer_mobile_dir_title);
      }
      findViewById(R.h.file_explorer_folder).setVisibility(0);
      findViewById(R.h.file_explorer_folder).setOnClickListener(new NewFileExplorerUI.1(this));
      this.smP = ((FileSelectorFolderView)findViewById(R.h.file_explorer_folder_mgr_view));
      this.smP.setListener(this.smR);
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      mh(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  private final class a$b
  {
    public TextView dsz;
    public TextView eXO;
    public ImageView gSx;
    public TextView nhj;
    public FrameLayout smY;
    public CheckBox smZ;
    
    private a$b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */