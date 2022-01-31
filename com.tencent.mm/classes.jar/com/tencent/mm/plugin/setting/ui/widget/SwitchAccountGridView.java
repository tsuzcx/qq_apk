package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int qMj;
  private String gEZ;
  private boolean qMk;
  private boolean qMl;
  private boolean qMm;
  public String qMn;
  public boolean qMo;
  public AnimatorSet qMp;
  public List<String> qMq;
  public List<SwitchAccountGridView.d> qMr;
  public List<View> qMs;
  private SwitchAccountGridView.b qMt;
  private SwitchAccountGridView.a qMu;
  private SwitchAccountGridView.c qMv;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(127708);
    this.qMq = new ArrayList();
    this.qMr = new ArrayList();
    this.qMs = new ArrayList();
    qMj = getResources().getDimensionPixelOffset(2131427497) * 2;
    AppMethodBeat.o(127708);
  }
  
  public final void ab(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(127709);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.qMq.addAll(paramMap.keySet());
      Collections.sort(this.qMq);
    }
    ab.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.qMq.size()) });
    int i = 0;
    SwitchAccountGridView.d locald;
    if (i < this.qMq.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2130970704, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131827659);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131827660);
      Object localObject4 = ((View)localObject1).findViewById(2131827662);
      localObject3 = (String)this.qMq.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131827661);
      locald = new SwitchAccountGridView.d(this, (byte)0);
      locald.gqF = localImageView;
      locald.qKC = ((ImageView)localObject2);
      locald.nCO = localTextView;
      locald.qMz = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).mBI;
      for (;;)
      {
        try
        {
          if (!bo.isNullOrNil((String)localObject4))
          {
            if (!this.qMm) {
              continue;
            }
            ab.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = e.i((String)localObject4, 0, (int)e.avI((String)localObject4));
            if (localObject4 != null)
            {
              localObject4 = BitmapFactory.decodeByteArray((byte[])localObject4, 0, localObject4.length);
              if (localObject4 != null) {
                localImageView.setImageBitmap((Bitmap)localObject4);
              }
            }
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.gqF, (String)localObject3);
          continue;
        }
        localTextView.setText(j.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new SwitchAccountGridView.1(this, (String)localObject3));
        ((ImageView)localObject2).setOnClickListener(new SwitchAccountGridView.2(this, (String)localObject3));
        this.qMr.add(locald);
        this.qMs.add(localObject1);
        i += 1;
        break;
        localObject4 = d.rd((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(2130970704, null);
    Object localObject1 = (ImageView)paramMap.findViewById(2131827659);
    ImageView localImageView = (ImageView)paramMap.findViewById(2131827660);
    Object localObject2 = (TextView)paramMap.findViewById(2131827661);
    Object localObject3 = new SwitchAccountGridView.d(this, (byte)0);
    ((SwitchAccountGridView.d)localObject3).gqF = ((ImageView)localObject1);
    ((SwitchAccountGridView.d)localObject3).qKC = localImageView;
    ((SwitchAccountGridView.d)localObject3).nCO = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2130837890);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131303457));
    ((ImageView)localObject1).setOnClickListener(new SwitchAccountGridView.3(this));
    this.qMr.add(localObject3);
    this.qMs.add(paramMap);
    AppMethodBeat.o(127709);
  }
  
  public final void ckO()
  {
    AppMethodBeat.i(127710);
    if (this.qMo)
    {
      ab.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(127710);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.qMq.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.qMk) && (!((String)this.qMq.get(i)).equals(this.gEZ)))
      {
        ((SwitchAccountGridView.d)this.qMr.get(i)).qKC.setVisibility(0);
        ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.setVisibility(4);
        if ((!bo.isNullOrNil(this.gEZ)) && (((String)this.qMq.get(i)).equals(this.gEZ)))
        {
          if (!this.qMl) {
            break label525;
          }
          ((ImageView)((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827664)).setImageResource(2130839067);
          label194:
          if (!this.qMl) {
            break label559;
          }
          ((TextView)((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827666)).setText(getContext().getResources().getString(2131306048));
        }
      }
      for (;;)
      {
        ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827665).setVisibility(8);
        ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827664).setVisibility(0);
        ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.setVisibility(0);
        if ((!bo.isNullOrNil(this.qMn)) && (((String)this.qMq.get(i)).equals(this.qMn)))
        {
          ((TextView)((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827666)).setText(getContext().getResources().getString(2131301149));
          ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827664).setVisibility(8);
          ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827665).setVisibility(0);
          ((SwitchAccountGridView.d)this.qMr.get(i)).qMz.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = qMj;
        addView((View)this.qMs.get(i), localLayoutParams);
        i += 1;
        break;
        ((SwitchAccountGridView.d)this.qMr.get(i)).qKC.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827664)).setImageResource(2130839065);
        break label194;
        label559:
        ((TextView)((SwitchAccountGridView.d)this.qMr.get(i)).qMz.findViewById(2131827666)).setText(getContext().getResources().getString(2131303460));
      }
    }
    if (getChildCount() < 2)
    {
      ((SwitchAccountGridView.d)this.qMr.get(this.qMr.size() - 1)).qKC.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = qMj;
      addView((View)this.qMs.get(this.qMs.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(127710);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(127711);
    int i = this.qMq.size();
    AppMethodBeat.o(127711);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.qMk = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.gEZ = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.qMl = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(SwitchAccountGridView.a parama)
  {
    this.qMu = parama;
  }
  
  public void setOnClickAvatarListener(SwitchAccountGridView.b paramb)
  {
    this.qMt = paramb;
  }
  
  public void setOnDeleteAvatarListener(SwitchAccountGridView.c paramc)
  {
    this.qMv = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.qMn = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.qMm = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */