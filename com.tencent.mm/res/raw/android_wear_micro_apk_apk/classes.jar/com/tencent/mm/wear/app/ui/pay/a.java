package com.tencent.mm.wear.app.ui.pay;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.wearable.view.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.wear.app.ui.MMActivity;

public final class a
  extends i
{
  private String akZ;
  private String ala;
  private Bitmap alb;
  private Bitmap alc;
  private Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final Object a(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = null;
    Object localObject;
    TextView localTextView;
    if (paramInt == 0) {
      if (MMActivity.isRect())
      {
        localView = LayoutInflater.from(this.context).inflate(2130903092, paramViewGroup, false);
        localObject = (TextView)localView.findViewById(2131558501);
        localTextView = (TextView)localView.findViewById(2131558500);
        localImageView = (ImageView)localView.findViewById(2131558449);
        ((TextView)localObject).setText(this.ala);
        localImageView.setImageBitmap(this.alb);
        localTextView.setText(this.akZ);
        paramViewGroup.addView(localView);
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        ImageView localImageView;
        return localView;
        localView = LayoutInflater.from(this.context).inflate(2130903093, paramViewGroup, false);
      }
    }
    if (MMActivity.isRect()) {}
    for (localView = LayoutInflater.from(this.context).inflate(2130903094, paramViewGroup, false);; localView = LayoutInflater.from(this.context).inflate(2130903095, paramViewGroup, false))
    {
      localObject = (ImageView)localView.findViewById(2131558449);
      localTextView = (TextView)localView.findViewById(2131558501);
      ((ImageView)localObject).setImageBitmap(this.alc);
      localTextView.setText(this.ala);
      paramViewGroup.addView(localView);
      return localView;
    }
  }
  
  public final void a(String paramString1, String paramString2, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.akZ = paramString1;
    this.ala = paramString2;
    this.alb = paramBitmap1;
    this.alc = paramBitmap2;
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView.equals(paramObject);
  }
  
  public final void b(ViewGroup paramViewGroup, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.pay.a
 * JD-Core Version:    0.7.0.1
 */