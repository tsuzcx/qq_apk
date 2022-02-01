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
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.comm.c.a;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

public class GetHdHeadImageGalleryView
  extends MMGestureGallery
{
  private String Ppq;
  private v XYB;
  private Bitmap XYC;
  private Bitmap XYD;
  private a XYE;
  private String username;
  
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
    this.XYE = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.XYE);
    setSelection(0);
    setSingleClickOverListener(new c((byte)0));
    setLongClickOverListener(new b((byte)0));
    AppMethodBeat.o(152135);
  }
  
  public void setHdHeadImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152137);
    this.XYD = paramBitmap;
    this.XYE.notifyDataSetChanged();
    AppMethodBeat.o(152137);
  }
  
  public void setHdHeadImagePath(String paramString)
  {
    this.Ppq = paramString;
  }
  
  public void setParentWindow(v paramv)
  {
    this.XYB = paramv;
  }
  
  public void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152136);
    this.XYC = paramBitmap;
    this.XYE.notifyDataSetChanged();
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
        localView = View.inflate(GetHdHeadImageGalleryView.this.getContext(), c.f.view_get_hd_avatar_dialogview, null);
        paramView.SHw = ((ProgressBar)localView.findViewById(c.e.hd_avatar_laoding_pb));
        paramView.hNV = ((ImageView)localView.findViewById(c.e.hd_avatar_iv));
        paramView.XYG = localView.findViewById(c.e.hd_avatar_mask_view);
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        if (GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this) == null) {
          break;
        }
        paramViewGroup.SHw.setVisibility(8);
        paramViewGroup.hNV.setVisibility(8);
        paramViewGroup.XYG.setVisibility(8);
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
      paramViewGroup.SHw.setVisibility(0);
      paramViewGroup.XYG.setVisibility(0);
      if (GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this) != null)
      {
        paramViewGroup.hNV.setVisibility(0);
        paramViewGroup.hNV.setImageBitmap(GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this));
      }
      for (;;)
      {
        AppMethodBeat.o(152129);
        return localView;
        paramViewGroup.hNV.setVisibility(8);
      }
    }
    
    final class a
    {
      ProgressBar SHw;
      View XYG;
      ImageView hNV;
      
      a() {}
    }
  }
  
  final class b
    implements MMGestureGallery.c
  {
    private b() {}
    
    public final void longClickOver()
    {
      AppMethodBeat.i(152131);
      if ((GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this) != null) && (GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.this) != null))
      {
        String[] arrayOfString = GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(c.a.get_hd_head_img_alert);
        k.a(GetHdHeadImageGalleryView.this.getContext(), null, arrayOfString, "", new k.d()
        {
          public final void qz(int paramAnonymousInt)
          {
            AppMethodBeat.i(152130);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(152130);
              return;
              ExportFileUtil.a(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this), new ExportFileUtil.a()
              {
                public final void cg(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(245069);
                  AndroidMediaUtil.refreshMediaScanner(paramAnonymous2String2, GetHdHeadImageGalleryView.this.getContext());
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(c.h.get_hd_head_img_save_tips, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
                  AppMethodBeat.o(245069);
                }
                
                public final void ch(String paramAnonymous2String1, String paramAnonymous2String2)
                {
                  AppMethodBeat.i(245072);
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(c.h.save_image_err), 1).show();
                  AppMethodBeat.o(245072);
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
    
    public final void singleClickOver()
    {
      AppMethodBeat.i(152132);
      if (GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this) != null) {
        GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this).dismiss();
      }
      AppMethodBeat.o(152132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView
 * JD-Core Version:    0.7.0.1
 */