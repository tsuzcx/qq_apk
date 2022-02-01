package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.gif.j;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private boolean afLi;
  private a afLj;
  private MMGestureGallery pIt;
  private boolean rvh;
  
  public int getLayoutId()
  {
    return R.i.gon;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39192);
    super.onCreate(paramBundle);
    setNavigationbarColor(getResources().getColor(R.e.black));
    paramBundle = getIntent().getStringExtra("key_title");
    if (!Util.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.afLi = getIntent().getBooleanExtra("key_favorite", false);
    this.rvh = getIntent().getBooleanExtra("show_menu", true);
    this.pIt = ((MMGestureGallery)findViewById(R.h.gallery));
    this.pIt.setVerticalFadingEdgeEnabled(false);
    this.pIt.setHorizontalFadingEdgeEnabled(false);
    this.afLj = new a((byte)0);
    this.afLj.imagePath = getIntent().getStringExtra("key_image_path");
    this.pIt.setAdapter(this.afLj);
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
    if (this.rvh) {
      addIconOptionMenu(0, R.k.icons_outlined_share, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39189);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (c.blq("favorite")))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.retransmits));
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.plugin_favorite_opt));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.save_to_local));
          }
          for (;;)
          {
            ex localex = new ex();
            localex.hFc.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            localex.publish();
            if (localex.hFd.hEn)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.gyu));
            }
            k.b(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", new k.e()
            {
              public final void onClick(int paramAnonymous2Int1, int paramAnonymous2Int2)
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
                  dn localdn = new dn();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    Log.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    l.a(localdn, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localdn.hDr.activity = localShowImageUI;
                    localdn.publish();
                    AppMethodBeat.o(39188);
                    return;
                    l.a(localdn, l);
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
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.retransmits));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(R.l.save_to_local));
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
      if (ImgUtil.isGif(this.imagePath))
      {
        localObject = paramViewGroup.getContext();
        paramViewGroup = this.imagePath;
        new f(paramViewGroup);
        if ((paramView == null) || (!(paramView instanceof MMAnimateView))) {}
        for (paramView = new MMAnimateView((Context)localObject);; paramView = (MMAnimateView)paramView)
        {
          paramView.jk(paramViewGroup, paramViewGroup);
          paramView.a(paramViewGroup, new j()
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
      Object localObject = r.Sg(this.imagePath);
      paramInt = Exif.fromFile(this.imagePath).getOrientationInDegree();
      Log.d("MicroMsg.ShowImageUI", "imagePath : %s degree : %d", new Object[] { this.imagePath, Integer.valueOf(paramInt) });
      localObject = BitmapUtil.rotate((Bitmap)localObject, paramInt);
      if (localObject == null)
      {
        Log.w("MicroMsg.ShowImageUI", "get image fail");
        if (paramView != null)
        {
          localObject = paramView;
          if (!(paramView instanceof MultiTouchImageView)) {}
        }
        else
        {
          localObject = View.inflate(paramViewGroup.getContext(), R.i.goo, null);
        }
        ((ImageView)((View)localObject).findViewById(R.h.image_iv)).setImageResource(R.k.download_image_icon);
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
        paramView.dU(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */