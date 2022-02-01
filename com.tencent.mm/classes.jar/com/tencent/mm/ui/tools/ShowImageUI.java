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
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.f;
import com.tencent.mm.plugin.gif.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h.e;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI
  extends MMActivity
{
  private boolean QwN;
  private a QwO;
  private MMGestureGallery jUy;
  private boolean lwF;
  
  public int getLayoutId()
  {
    return 2131496313;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39192);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("key_title");
    if (!Util.isNullOrNil(paramBundle)) {
      setMMTitle(paramBundle);
    }
    this.QwN = getIntent().getBooleanExtra("key_favorite", false);
    this.lwF = getIntent().getBooleanExtra("show_menu", true);
    this.jUy = ((MMGestureGallery)findViewById(2131301853));
    this.jUy.setVerticalFadingEdgeEnabled(false);
    this.jUy.setHorizontalFadingEdgeEnabled(false);
    this.QwO = new a((byte)0);
    this.QwO.imagePath = getIntent().getStringExtra("key_image_path");
    this.jUy.setAdapter(this.QwO);
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
    if (this.lwF) {
      addIconOptionMenu(0, 2131690907, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39189);
          paramAnonymousMenuItem = new LinkedList();
          LinkedList localLinkedList = new LinkedList();
          if ((ShowImageUI.a(ShowImageUI.this)) && (c.aZU("favorite")))
          {
            localLinkedList.add(Integer.valueOf(0));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131764635));
            localLinkedList.add(Integer.valueOf(1));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131763947));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131764870));
          }
          for (;;)
          {
            ef localef = new ef();
            localef.dHy.msgId = ShowImageUI.this.getIntent().getLongExtra("key_message_id", -1L);
            EventCenter.instance.publish(localef);
            if (localef.dHz.dGX)
            {
              localLinkedList.add(Integer.valueOf(3));
              paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131757440));
            }
            com.tencent.mm.ui.base.h.b(ShowImageUI.this, "", paramAnonymousMenuItem, localLinkedList, "", new h.e()
            {
              public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
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
                  cz localcz = new cz();
                  long l = localShowImageUI.getIntent().getLongExtra("key_message_id", -1L);
                  if (-1L == l)
                  {
                    Log.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    com.tencent.mm.pluginsdk.model.h.a(localcz, localShowImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), localShowImageUI.getIntent().getStringExtra("key_image_path"));
                  }
                  for (;;)
                  {
                    localcz.dFZ.activity = localShowImageUI;
                    EventCenter.instance.publish(localcz);
                    AppMethodBeat.o(39188);
                    return;
                    com.tencent.mm.pluginsdk.model.h.a(localcz, l);
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
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131764635));
            localLinkedList.add(Integer.valueOf(2));
            paramAnonymousMenuItem.add(ShowImageUI.this.getString(2131764870));
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
          paramView.hU(paramViewGroup, paramViewGroup);
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
      Object localObject = u.Sq(this.imagePath);
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
          localObject = View.inflate(paramViewGroup.getContext(), 2131496314, null);
        }
        ((ImageView)((View)localObject).findViewById(2131302573)).setImageResource(2131690098);
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
        paramView.cN(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.ShowImageUI
 * JD-Core Version:    0.7.0.1
 */