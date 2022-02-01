package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private boolean IUq;
  private ShowImageUI.a IUr;
  private MMGestureGallery iBx;
  private boolean jVr;
  
  public int getLayoutId()
  {
    return 2131495441;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39192);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bs.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.IUq = getIntent().getBooleanExtra("key_favorite", false);
    this.jVr = getIntent().getBooleanExtra("show_menu", true);
    this.iBx = ((MMGestureGallery)findViewById(2131300335));
    this.iBx.setVerticalFadingEdgeEnabled(false);
    this.iBx.setHorizontalFadingEdgeEnabled(false);
    this.IUr = new ShowImageUI.a(this, (byte)0);
    this.IUr.imagePath = getIntent().getStringExtra("key_image_path");
    this.iBx.setAdapter(this.IUr);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(39187);
        ShowImageUI.this.finish();
        AppMethodBeat.o(39187);
        return true;
      }
    });
    if (this.jVr) {
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39189);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (d.aCT("favorite")))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131762566));
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131761941));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131762783));
          }
          for (;;)
          {
            dy localdy = new dy();
            localdy.ddK.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            a.GpY.l(localdy);
            if (localdy.ddL.ddj)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131757228));
            }
            h.b(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", new h.d()
            {
              public final void ct(int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                AppMethodBeat.i(39188);
                switch (paramAnonymous2Int2)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(39188);
                  return;
                  ShowImageUI.b(ShowImageUI.this);
                  AppMethodBeat.o(39188);
                  return;
                  ShowImageUI localShowImageUI = ShowImageUI.this;
                  cs localcs = new cs();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    ac.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    g.a(localcs, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localcs.dck.activity = localShowImageUI;
                    a.GpY.l(localcs);
                    AppMethodBeat.o(39188);
                    return;
                    g.a(localcs, l);
                  }
                  ShowImageUI.c(ShowImageUI.this);
                  AppMethodBeat.o(39188);
                  return;
                  ShowImageUI.d(ShowImageUI.this);
                }
              }
            });
            AppMethodBeat.o(39189);
            return true;
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131762566));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131762783));
          }
        }
      });
    }
    AppMethodBeat.o(39192);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */