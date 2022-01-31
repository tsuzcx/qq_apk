package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI
  extends MMActivity
{
  private ListView gJa;
  private int mode;
  private TextView pMw;
  private String toUserName;
  private NewFileExplorerUI.a wfi;
  private TextView wfj;
  private FileSelectorFolderView wfk;
  private g.a wfl;
  private FileSelectorFolderView.a wfm;
  
  public NewFileExplorerUI()
  {
    AppMethodBeat.i(28209);
    this.mode = 0;
    this.wfm = new NewFileExplorerUI.7(this);
    AppMethodBeat.o(28209);
  }
  
  private void ccF()
  {
    AppMethodBeat.i(28215);
    int i = NewFileExplorerUI.a.a(this.wfi).size();
    if (i > 0)
    {
      if (this.mode == 0)
      {
        updateOptionMenuText(1, getString(2131297067) + "(" + i + "/9)");
        enableOptionMenu(1, true);
      }
      this.pMw.setText(getString(2131299880, new Object[] { bo.hk(this.wfi.ces()) }));
      this.pMw.setVisibility(0);
      AppMethodBeat.o(28215);
      return;
    }
    if (this.mode == 0)
    {
      updateOptionMenuText(1, getString(2131297067));
      enableOptionMenu(1, false);
    }
    this.pMw.setVisibility(8);
    AppMethodBeat.o(28215);
  }
  
  private void dpA()
  {
    AppMethodBeat.i(28216);
    if ((NewFileExplorerUI.a.b(this.wfi) != null) && (NewFileExplorerUI.a.c(this.wfi) != null))
    {
      Object localObject2 = NewFileExplorerUI.a.c(this.wfi).getPath().replace(NewFileExplorerUI.a.b(this.wfi).getPath(), "");
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
    AppMethodBeat.o(28216);
  }
  
  private void pw(boolean paramBoolean)
  {
    AppMethodBeat.i(28214);
    if (this.mode == 0)
    {
      if ((!paramBoolean) && (this.wfi.dpE() != null))
      {
        this.wfi.a(this.wfi.dpE(), null);
        this.wfi.notifyDataSetChanged();
        dpA();
        AppMethodBeat.o(28214);
        return;
      }
      setResult(0);
      finish();
      AppMethodBeat.o(28214);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("selected_file_lst", this.wfi.dpB());
    localIntent.putStringArrayListExtra("key_select_video_list", this.wfi.dpD());
    localIntent.putStringArrayListExtra("CropImage_OutputPath_List", this.wfi.dpC());
    localIntent.putExtra("GalleryUI_ToUser", this.toUserName);
    setResult(-1, localIntent);
    finish();
    AppMethodBeat.o(28214);
  }
  
  public int getLayoutId()
  {
    return 2130970357;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(28213);
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringArrayListExtra("selected_file_lst");
      if ((paramIntent != null) && (NewFileExplorerUI.a.a(this.wfi).size() != paramIntent.size()))
      {
        this.wfl.gwf.dismiss();
        NewFileExplorerUI.a.a(this.wfi).clear();
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          String str = (String)paramIntent.next();
          NewFileExplorerUI.a.a(this.wfi).add(new File(str));
        }
        this.wfi.notifyDataSetChanged();
        dpA();
        ccF();
      }
      AppMethodBeat.o(28213);
      return;
    }
    if (paramInt1 == 2) {
      a.a(this, paramInt1, paramInt2, paramIntent, true, 2131299009, 2131299010, 1);
    }
    AppMethodBeat.o(28213);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(28210);
    super.onCreate(paramBundle);
    this.toUserName = getIntent().getStringExtra("TO_USER");
    this.gJa = ((ListView)findViewById(2131826535));
    this.wfi = new NewFileExplorerUI.a(this);
    this.pMw = ((TextView)findViewById(2131826540));
    this.mode = getIntent().getIntExtra("explorer_mode", 0);
    if (this.mode == 1)
    {
      setMMTitle(2131299881);
      setMMSubTitle(null);
      this.wfi.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
      this.gJa.setAdapter(this.wfi);
      this.gJa.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(28176);
          paramAnonymousAdapterView = NewFileExplorerUI.b(NewFileExplorerUI.this).wer[paramAnonymousInt];
          if (paramAnonymousAdapterView.isDirectory())
          {
            NewFileExplorerUI.b(NewFileExplorerUI.this).a(paramAnonymousAdapterView, null);
            NewFileExplorerUI.b(NewFileExplorerUI.this).notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
            AppMethodBeat.o(28176);
            return;
          }
          paramAnonymousView = com.tencent.mm.a.e.cP(paramAnonymousAdapterView.getPath());
          a.a(NewFileExplorerUI.this, paramAnonymousAdapterView.getPath(), paramAnonymousView, 1);
          AppMethodBeat.o(28176);
        }
      });
      this.gJa.setEmptyView(findViewById(2131826536));
      paramBundle = new NewFileExplorerUI.3(this);
      if (this.mode != 0) {
        break label417;
      }
    }
    label417:
    for (int i = 2131230755;; i = 0)
    {
      setBackBtn(paramBundle, i);
      if (this.mode == 0) {
        addTextOptionMenu(1, getString(2131297067), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(28178);
            NewFileExplorerUI.e(NewFileExplorerUI.this);
            AppMethodBeat.o(28178);
            return true;
          }
        }, null, q.b.zby);
      }
      ccF();
      AppMethodBeat.o(28210);
      return;
      setMMTitle(2131299878);
      setMMSubTitle(null);
      this.wfj = ((TextView)findViewById(2131826539));
      this.wfj.setText(2131299878);
      this.wfi.c(new File(com.tencent.mm.compatible.util.e.esq), true);
      this.wfi.a(new File(com.tencent.mm.compatible.util.e.esq), null);
      if (this.wfi.getCount() == 0)
      {
        this.wfi.c(new File(com.tencent.mm.compatible.util.e.eQx), false);
        this.wfi.a(new File(com.tencent.mm.compatible.util.e.eQx), null);
        setMMTitle(2131299879);
        this.wfj.setText(2131299879);
      }
      findViewById(2131826538).setVisibility(0);
      findViewById(2131826538).setOnClickListener(new NewFileExplorerUI.1(this));
      this.wfk = ((FileSelectorFolderView)findViewById(2131826541));
      this.wfk.setListener(this.wfm);
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(28211);
    super.onDestroy();
    AppMethodBeat.o(28211);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(28212);
    if (paramInt == 4)
    {
      pw(false);
      AppMethodBeat.o(28212);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(28212);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI
 * JD-Core Version:    0.7.0.1
 */