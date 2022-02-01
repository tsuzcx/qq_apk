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
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.gif.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private boolean KLu;
  private a KLv;
  private MMGestureGallery iUH;
  private boolean kpF;
  
  public int getLayoutId()
  {
    return 2131495441;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39192);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!bt.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.KLu = getIntent().getBooleanExtra("key_favorite", false);
    this.kpF = getIntent().getBooleanExtra("show_menu", true);
    this.iUH = ((MMGestureGallery)findViewById(2131300335));
    this.iUH.setVerticalFadingEdgeEnabled(false);
    this.iUH.setHorizontalFadingEdgeEnabled(false);
    this.KLv = new a((byte)0);
    this.KLv.imagePath = getIntent().getStringExtra("key_image_path");
    this.iUH.setAdapter(this.KLv);
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
    if (this.kpF) {
      addIconOptionMenu(0, 2131690655, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39189);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (d.aIu("favorite")))
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
            eb localeb = new eb();
            localeb.dpg.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            a.IbL.l(localeb);
            if (localeb.dph.doF)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131757228));
            }
            h.b(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", new h.d()
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
                  cv localcv = new cv();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    ad.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    com.tencent.mm.pluginsdk.model.g.a(localcv, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localcv.dnG.activity = localShowImageUI;
                    a.IbL.l(localcv);
                    AppMethodBeat.o(39188);
                    return;
                    com.tencent.mm.pluginsdk.model.g.a(localcv, l);
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
      if (t.aQj(this.imagePath))
      {
        localObject = paramViewGroup.getContext();
        paramViewGroup = this.imagePath;
        new f(paramViewGroup);
        if ((paramView == null) || (!(paramView instanceof MMAnimateView))) {}
        for (paramView = new MMAnimateView((Context)localObject);; paramView = (MMAnimateView)paramView)
        {
          paramView.hg(paramViewGroup, paramViewGroup);
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
      Object localObject = u.IT(this.imagePath);
      paramInt = Exif.fromFile(this.imagePath).getOrientationInDegree();
      ad.d("MicroMsg.ShowImageUI", "imagePath : %s degree : %d", new Object[] { this.imagePath, Integer.valueOf(paramInt) });
      localObject = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, paramInt);
      if (localObject == null)
      {
        ad.w("MicroMsg.ShowImageUI", "get image fail");
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