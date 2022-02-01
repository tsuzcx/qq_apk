package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.i.a.a;

public final class HeadImgNewPreference
  extends Preference
{
  private View Ydw;
  private String adYh;
  public boolean adYi;
  private boolean adYj;
  private TextView adYl;
  public a adYm;
  private ImageView dpM;
  private int height;
  public View.OnClickListener tyA;
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeadImgNewPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(164166);
    this.height = -1;
    this.adYj = false;
    this.adYm = null;
    setLayoutResource(a.h.mm_preference);
    AppMethodBeat.o(164166);
  }
  
  public final void bAh(String paramString)
  {
    AppMethodBeat.i(164168);
    this.adYh = null;
    if (this.dpM != null) {
      if (this.adYm != null) {
        this.adYm.c(paramString, this.dpM);
      }
    }
    while (paramString == null)
    {
      this.adYj = false;
      AppMethodBeat.o(164168);
      return;
      if (this.adYi)
      {
        a.h(this.dpM, paramString);
      }
      else
      {
        a.g(this.dpM, paramString);
        continue;
        this.adYh = paramString;
      }
    }
    this.adYj = true;
    AppMethodBeat.o(164168);
  }
  
  protected final void onBindView(View paramView)
  {
    AppMethodBeat.i(164169);
    super.onBindView(paramView);
    if (this.dpM == null) {
      this.dpM = ((ImageView)paramView.findViewById(a.g.image_headimg));
    }
    if (this.adYl == null) {
      this.adYl = ((TextView)paramView.findViewById(a.g.no_header_icon_tip));
    }
    if (this.Ydw == null) {
      this.Ydw = paramView.findViewById(a.g.mask_header_icon);
    }
    if (this.tyA != null) {
      this.Ydw.setOnClickListener(this.tyA);
    }
    if (this.adYh != null)
    {
      if (this.adYm != null)
      {
        this.adYm.c(this.adYh, this.dpM);
        this.adYh = null;
      }
    }
    else
    {
      if (this.adYj) {
        break label216;
      }
      this.Ydw.setVisibility(8);
      this.adYl.setVisibility(0);
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView.findViewById(a.g.mm_preference_ll_id);
      if (this.height != -1) {
        paramView.setMinimumHeight(this.height);
      }
      AppMethodBeat.o(164169);
      return;
      if (this.adYi)
      {
        a.h(this.dpM, this.adYh);
        break;
      }
      a.g(this.dpM, this.adYh);
      break;
      label216:
      this.adYl.setVisibility(8);
      this.Ydw.setVisibility(0);
      if (this.adYi) {
        this.Ydw.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_round_icon_click));
      } else {
        this.Ydw.setBackground(this.mContext.getDrawable(a.f.self_qrcode_header_icon_click));
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(164167);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, a.h.mm_preference_content_avatar, localViewGroup);
    this.dpM = ((ImageView)paramViewGroup.findViewById(a.g.image_headimg));
    this.adYl = ((TextView)paramViewGroup.findViewById(a.g.no_header_icon_tip));
    this.Ydw = paramViewGroup.findViewById(a.g.mask_header_icon);
    AppMethodBeat.o(164167);
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void c(String paramString, ImageView paramImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.HeadImgNewPreference
 * JD-Core Version:    0.7.0.1
 */