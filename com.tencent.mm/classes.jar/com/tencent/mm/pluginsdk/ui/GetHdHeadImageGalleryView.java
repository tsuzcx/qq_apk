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
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.c;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.vfs.s;

public class GetHdHeadImageGalleryView
  extends MMGestureGallery
{
  private String CZs;
  private com.tencent.mm.ui.base.p KbQ;
  private Bitmap KbR;
  private Bitmap KbS;
  private a KbT;
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
    this.KbT = new a((byte)0);
    setVerticalFadingEdgeEnabled(false);
    setHorizontalFadingEdgeEnabled(false);
    setAdapter(this.KbT);
    setSelection(0);
    setSingleClickOverListener(new c((byte)0));
    setLongClickOverListener(new b((byte)0));
    AppMethodBeat.o(152135);
  }
  
  public void setHdHeadImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152137);
    this.KbS = paramBitmap;
    this.KbT.notifyDataSetChanged();
    AppMethodBeat.o(152137);
  }
  
  public void setHdHeadImagePath(String paramString)
  {
    this.CZs = paramString;
  }
  
  public void setParentWindow(com.tencent.mm.ui.base.p paramp)
  {
    this.KbQ = paramp;
  }
  
  public void setThumbImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(152136);
    this.KbR = paramBitmap;
    this.KbT.notifyDataSetChanged();
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
        localView = View.inflate(GetHdHeadImageGalleryView.this.getContext(), 2131496815, null);
        paramView.FLW = ((ProgressBar)localView.findViewById(2131302258));
        paramView.dPk = ((ImageView)localView.findViewById(2131302257));
        paramView.JPl = localView.findViewById(2131302259);
        localView.setTag(paramView);
        paramViewGroup = paramView;
      }
      for (;;)
      {
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        if (GetHdHeadImageGalleryView.d(GetHdHeadImageGalleryView.this) == null) {
          break;
        }
        paramViewGroup.FLW.setVisibility(8);
        paramViewGroup.dPk.setVisibility(8);
        paramViewGroup.JPl.setVisibility(8);
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
      paramViewGroup.FLW.setVisibility(0);
      paramViewGroup.JPl.setVisibility(0);
      if (GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this) != null)
      {
        paramViewGroup.dPk.setVisibility(0);
        paramViewGroup.dPk.setImageBitmap(GetHdHeadImageGalleryView.e(GetHdHeadImageGalleryView.this));
      }
      for (;;)
      {
        AppMethodBeat.o(152129);
        return localView;
        paramViewGroup.dPk.setVisibility(8);
      }
    }
    
    final class a
    {
      ProgressBar FLW;
      View JPl;
      ImageView dPk;
      
      a() {}
    }
  }
  
  final class b
    implements MMGestureGallery.c
  {
    private b() {}
    
    public final void bmu()
    {
      AppMethodBeat.i(152131);
      if ((GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this) != null) && (GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.this) != null))
      {
        String[] arrayOfString = GetHdHeadImageGalleryView.this.getContext().getResources().getStringArray(2130903052);
        h.a(GetHdHeadImageGalleryView.this.getContext(), null, arrayOfString, "", new h.d()
        {
          public final void oj(int paramAnonymousInt)
          {
            AppMethodBeat.i(152130);
            switch (paramAnonymousInt)
            {
            }
            for (;;)
            {
              AppMethodBeat.o(152130);
              return;
              com.tencent.mm.platformtools.p.a(GetHdHeadImageGalleryView.this.getContext(), new Runnable()new Runnable
              {
                public final void run()
                {
                  AppMethodBeat.i(223845);
                  String str = AndroidMediaUtil.getSysCameraDirPath() + "hdImg_" + g.getMessageDigest(GetHdHeadImageGalleryView.c(GetHdHeadImageGalleryView.this).getBytes()) + System.currentTimeMillis() + ".jpg";
                  s.deleteFile(str);
                  s.nw(GetHdHeadImageGalleryView.b(GetHdHeadImageGalleryView.this), str);
                  AndroidMediaUtil.refreshMediaScanner(str, GetHdHeadImageGalleryView.this.getContext());
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(2131761444, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
                  AppMethodBeat.o(223845);
                }
              }, new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(223846);
                  Toast.makeText(GetHdHeadImageGalleryView.this.getContext(), GetHdHeadImageGalleryView.this.getContext().getString(2131764864), 1).show();
                  AppMethodBeat.o(223846);
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
    
    public final void bmt()
    {
      AppMethodBeat.i(152132);
      if (GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this) != null) {
        GetHdHeadImageGalleryView.a(GetHdHeadImageGalleryView.this).dismiss();
      }
      AppMethodBeat.o(152132);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView
 * JD-Core Version:    0.7.0.1
 */