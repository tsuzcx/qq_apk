package com.tencent.mm.plugin.setting.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int zbi;
  public boolean iXG;
  private String jno;
  private boolean zbj;
  private boolean zbk;
  private boolean zbl;
  public String zbm;
  public AnimatorSet zbn;
  public List<String> zbo;
  public List<d> zbp;
  public List<View> zbq;
  private b zbr;
  private a zbs;
  private c zbt;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.zbo = new ArrayList();
    this.zbp = new ArrayList();
    this.zbq = new ArrayList();
    zbi = getResources().getDimensionPixelOffset(2131165188) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aH(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.zbo.addAll(paramMap.keySet());
      Collections.sort(this.zbo);
    }
    ae.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.zbo.size()) });
    int i = 0;
    d locald;
    if (i < this.zbo.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
      localImageView = (ImageView)((View)localObject1).findViewById(2131296329);
      localObject2 = (ImageView)((View)localObject1).findViewById(2131296332);
      Object localObject4 = ((View)localObject1).findViewById(2131298894);
      localObject3 = (String)this.zbo.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131296338);
      locald = new d((byte)0);
      locald.iZn = localImageView;
      locald.yZI = ((ImageView)localObject2);
      locald.uDY = localTextView;
      locald.zbx = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).rJY;
      for (;;)
      {
        try
        {
          if (!bu.isNullOrNil((String)localObject4))
          {
            if (!this.zbl) {
              continue;
            }
            ae.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = o.bb((String)localObject4, 0, (int)o.aZR((String)localObject4));
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
          ae.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.iZn, (String)localObject3);
          continue;
        }
        localTextView.setText(k.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.zbu });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).ayw(this.zbu);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74638);
          }
        });
        ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74639);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).ayx(this.zbu);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74639);
          }
        });
        this.zbp.add(locald);
        this.zbq.add(localObject1);
        i += 1;
        break;
        localObject4 = e.DF((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(2131495407, null);
    Object localObject1 = (ImageView)paramMap.findViewById(2131296329);
    ImageView localImageView = (ImageView)paramMap.findViewById(2131296332);
    Object localObject2 = (TextView)paramMap.findViewById(2131296338);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).iZn = ((ImageView)localObject1);
    ((d)localObject3).yZI = localImageView;
    ((d)localObject3).uDY = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(2131231164);
    ((TextView)localObject2).setText(getContext().getResources().getString(2131763439));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).ayw(null);
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74640);
      }
    });
    this.zbp.add(localObject3);
    this.zbq.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void dRM()
  {
    AppMethodBeat.i(74646);
    if (this.iXG)
    {
      ae.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.zbo.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.zbj) && (!((String)this.zbo.get(i)).equals(this.jno)))
      {
        ((d)this.zbp.get(i)).yZI.setVisibility(0);
        ((d)this.zbp.get(i)).zbx.setVisibility(4);
        if ((!bu.isNullOrNil(this.jno)) && (((String)this.zbo.get(i)).equals(this.jno)))
        {
          if (!this.zbk) {
            break label525;
          }
          ((ImageView)((d)this.zbp.get(i)).zbx.findViewById(2131298895)).setImageResource(2131232610);
          label194:
          if (!this.zbk) {
            break label559;
          }
          ((TextView)((d)this.zbp.get(i)).zbx.findViewById(2131298897)).setText(getContext().getResources().getString(2131766297));
        }
      }
      for (;;)
      {
        ((d)this.zbp.get(i)).zbx.findViewById(2131296335).setVisibility(8);
        ((d)this.zbp.get(i)).zbx.findViewById(2131298895).setVisibility(0);
        ((d)this.zbp.get(i)).zbx.setVisibility(0);
        if ((!bu.isNullOrNil(this.zbm)) && (((String)this.zbo.get(i)).equals(this.zbm)))
        {
          ((TextView)((d)this.zbp.get(i)).zbx.findViewById(2131298897)).setText(getContext().getResources().getString(2131760781));
          ((d)this.zbp.get(i)).zbx.findViewById(2131298895).setVisibility(8);
          ((d)this.zbp.get(i)).zbx.findViewById(2131296335).setVisibility(0);
          ((d)this.zbp.get(i)).zbx.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = zbi;
        addView((View)this.zbq.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.zbp.get(i)).yZI.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.zbp.get(i)).zbx.findViewById(2131298895)).setImageResource(2131232608);
        break label194;
        label559:
        ((TextView)((d)this.zbp.get(i)).zbx.findViewById(2131298897)).setText(getContext().getResources().getString(2131763442));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.zbp.get(this.zbp.size() - 1)).yZI.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = zbi;
      addView((View)this.zbq.get(this.zbq.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.zbo.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.zbj = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.jno = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.zbk = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.zbs = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.zbr = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.zbt = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.zbm = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.zbl = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void dRy();
  }
  
  public static abstract interface b
  {
    public abstract void ayw(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void ayx(String paramString);
  }
  
  final class d
  {
    public ImageView iZn;
    public TextView uDY;
    public ImageView yZI;
    public View zbx;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */