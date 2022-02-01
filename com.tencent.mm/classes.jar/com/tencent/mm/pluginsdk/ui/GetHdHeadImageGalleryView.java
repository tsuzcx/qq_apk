package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

public class GetHdHeadImageGalleryView
  extends MMGestureGallery
{
  private com.tencent.mm.ui.base.o FkX;
  private Bitmap FkY;
  private Bitmap FkZ;
  private a Fla;
  private String username;
  private String yUC;
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(152134);
    init();
    AppMethodBeat.o(152134);
  }
  
  public GetHdHeadImageGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(152133);
    init();
    AppMethodBeat.o(152133);
  }
  
  private void init()
  {
    AppMethodBeat.i(152135);
    this.Fla = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.Fla);
    setSelection(0);
    setSingleClickOverListener(new c((byte)0));
    setLongClickOverListener(new b((byte)0));
    AppMethodBeat.o(152135);
  }
  
  public void setHdHeadImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152137);
    this.FkZ = paramBitmap;
    this.Fla.notifyDataSetChanged();
    AppMethodBeat.o(152137);
  }
  
  public void setHdHeadImagePath(String paramString)
  {
    this.yUC = paramString;
  }
  
  public void setParentWindow(com.tencent.mm.ui.base.o paramo)
  {
    this.FkX = paramo;
  }
  
  public void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152136);
    this.FkY = paramBitmap;
    this.Fla.notifyDataSetChanged();
    AppMethodBeat.o(152136);
  }
  
  public void setUsername(String paramString)
  {
    this.username = paramString;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(152128);
      AppMethodBeat.o(152128);
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(152129);
      View localView;
      if (paramView == null)
      {
        paramView = new a();
        localView = View.inflate(GetHdHeadImageGalleryView.this.getContext(), 2131495846, null);
        paramView.BBk = ((ProgressBar)localView.findViewById(2131300689));
        paramView.dxD = ((ImageView)localView.findViewById(2131300688));
        paramView.Flc = localView.findViewById(2131300690);
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        if (GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this) == null) {
          break;
        }
        paramViewGroup.BBk.setVisibility(8);
        paramViewGroup.dxD.setVisibility(8);
        paramViewGroup.Flc.setVisibility(8);
        paramView = new MultiTouchImageView(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this).getWidth(), GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this).getHeight(), (byte)0);
        paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        paramView.setImageBitmap(GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this));
        paramView.setMaxZoomLimit(2.0F);
        paramView.setMaxZoomDoubleTab(true);
        AppMethodBeat.o(152129);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
      }
      paramViewGroup.BBk.setVisibility(0);
      paramViewGroup.Flc.setVisibility(0);
      if (GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this) != null)
      {
        paramViewGroup.dxD.setVisibility(0);
        paramViewGroup.dxD.setImageBitmap(GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this));
      }
      for (;;)
      {
        AppMethodBeat.o(152129);
        return localView;
        paramViewGroup.dxD.setVisibility(8);
      }
    }
    
    final class a
    {
      ProgressBar BBk;
      View Flc;
      ImageView dxD;
      
      a() {}
    }
  }
  
  final class b
    implements MMGestureGallery.c
  {
    private b() {}
    
    public final void aRP()
    {
      AppMethodBeat.i(152131);
      if ((GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this) != null) && (GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.this) != null))
      {
        String[] arrayOfString = GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(2130903052);
        h.a(GetHdHeadImageGalleryView.this.getContext(), null, arrayOfString, "", new h.c()
        {
          public final void lh(int paramAnonymousInt)
          {
            AppMethodBeat.i(152130);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(152130);
              return;
              p.a(GetHdHeadImageGalleryView.this.getContext(), new Runnable()new Runnable
              {
                public final void run()
                {
                  AppMethodBeat.i(218899);
                  String str = com.tencent.mm.loader.j.b.asv() + "hdImg_" + g.getMessageDigest(GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.this).getBytes()) + System.currentTimeMillis() + ".jpg";
                  com.tencent.mm.vfs.o.deleteFile(str);
                  com.tencent.mm.vfs.o.mF(GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this), str);
                  com.tencent.mm.sdk.f.b.k(str, GetHdHeadImageGalleryView.this.getContext());
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(2131760066, new Object[] { com.tencent.mm.loader.j.b.asv() }), 1).show();
                  AppMethodBeat.o(218899);
                }
              }, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(218900);
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(2131762779), 1).show();
                  AppMethodBeat.o(218900);
                }
              });
            }
          }
        });
      }
      AppMethodBeat.o(152131);
    }
  }
  
  final class c
    implements MMGestureGallery.f
  {
    private c() {}
    
    public final void aRO()
    {
      AppMethodBeat.i(152132);
      if (GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this) != null) {
        GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this).dismiss();
      }
      AppMethodBeat.o(152132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView
 * JD-Core Version:    0.7.0.1
 */