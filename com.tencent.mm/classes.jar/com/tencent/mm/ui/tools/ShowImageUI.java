package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.gif.k;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private boolean LhO;
  private a LhP;
  private MMGestureGallery iXA;
  private boolean showMenu;
  
  public int getLayoutId()
  {
    return 2131495441;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39192);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bu.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.LhO = getIntent().getBooleanExtra("key_favorite", false);
    this.showMenu = getIntent().getBooleanExtra("show_menu", true);
    this.iXA = ((MMGestureGallery)findViewById(2131300335));
    this.iXA.setVerticalFadingEdgeEnabled(false);
    this.iXA.setHorizontalFadingEdgeEnabled(false);
    this.LhP = new a((byte)0);
    this.LhP.imagePath = getIntent().getStringExtra("key_image_path");
    this.iXA.setAdapter(this.LhP);
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
    if (this.showMenu) {
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39189);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (d.aJN("favorite")))
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
            ec localec = new ec();
            localec.dql.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            a.IvT.l(localec);
            if (localec.dqm.dpK)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131757228));
            }
            com.tencent.mm.ui.base.h.b(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", new h.d()
            {
              public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
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
                  cw localcw = new cw();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    ae.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    g.a(localcw, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localcw.doL.activity = localShowImageUI;
                    a.IvT.l(localcw);
                    AppMethodBeat.o(39188);
                    return;
                    g.a(localcw, l);
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
  
  final class a
    extends BaseAdapter
  {
    String imagePath;
    
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(39191);
      if (com.tencent.mm.sdk.platformtools.u.aRG(this.imagePath))
      {
        localObject = paramViewGroup.getContext();
        paramViewGroup = this.imagePath;
        new f(paramViewGroup);
        if ((paramView == null) || (!(paramView instanceof MMAnimateView))) {}
        for (paramView = new MMAnimateView((Context)localObject);; paramView = (MMAnimateView)paramView)
        {
          paramView.hn(paramViewGroup, paramViewGroup);
          paramView.a(paramViewGroup, new k()
          {
            public final void invalidate()
            {
              AppMethodBeat.i(39190);
              paramView.invalidate();
              AppMethodBeat.o(39190);
            }
          });
          paramView.stop();
          paramView.start();
          AppMethodBeat.o(39191);
          return paramView;
        }
      }
      Object localObject = com.tencent.mm.platformtools.u.Js(this.imagePath);
      paramInt = Exif.fromFile(this.imagePath).getOrientationInDegree();
      ae.d("MicroMsg.ShowImageUI", "imagePath : %s degree : %d", new Object[] { this.imagePath, Integer.valueOf(paramInt) });
      localObject = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, paramInt);
      if (localObject == null)
      {
        ae.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), 2131495442, null);
        }
        ((ImageView)((View)localObject).findViewById(2131300943)).setImageResource(2131690066);
        ((View)localObject).setLayoutParams(new Gallery.LayoutParams(-1, -1));
        AppMethodBeat.o(39191);
        return localObject;
      }
      paramViewGroup = paramViewGroup.getContext();
      if ((paramView == null) || (!(paramView instanceof MultiTouchImageView))) {
        paramView = new MultiTouchImageView(paramViewGroup, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight(), (byte)0);
      }
      for (;;)
      {
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap((Bitmap)localObject);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(39191);
        return paramView;
        paramView = (MultiTouchImageView)paramView;
        paramView.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */