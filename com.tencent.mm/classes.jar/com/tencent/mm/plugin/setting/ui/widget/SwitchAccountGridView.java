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
import com.tencent.mm.am.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int JlE;
  private boolean JlF;
  private boolean JlG;
  private boolean JlH;
  public String JlI;
  public AnimatorSet JlJ;
  public List<String> JlK;
  public List<d> JlL;
  public List<View> JlM;
  private b JlN;
  private a JlO;
  private c JlP;
  public boolean mLR;
  private String ndm;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.JlK = new ArrayList();
    this.JlL = new ArrayList();
    this.JlM = new ArrayList();
    JlE = getResources().getDimensionPixelOffset(b.d.BigAvatarSize) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aA(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.JlK.addAll(paramMap.keySet());
      Collections.sort(this.JlK);
    }
    Log.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.JlK.size()) });
    int i = 0;
    d locald;
    if (i < this.JlK.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(b.g.settings_switch_account_item, null);
      localImageView = (ImageView)((View)localObject1).findViewById(b.f.account_avatar);
      localObject2 = (ImageView)((View)localObject1).findViewById(b.f.account_del_btn);
      Object localObject4 = ((View)localObject1).findViewById(b.f.current_account);
      localObject3 = (String)this.JlK.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(b.f.account_username);
      locald = new d((byte)0);
      locald.mOe = localImageView;
      locald.Jkg = ((ImageView)localObject2);
      locald.Dah = localTextView;
      locald.JlT = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).wQa;
      for (;;)
      {
        try
        {
          if (!Util.isNullOrNil((String)localObject4))
          {
            if (!this.JlH) {
              continue;
            }
            Log.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = u.aY((String)localObject4, 0, (int)u.bBQ((String)localObject4));
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
          Log.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.c(locald.mOe, (String)localObject3);
          continue;
        }
        localTextView.setText(l.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.JlQ });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).aXP(this.JlQ);
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
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).aXQ(this.JlQ);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74639);
          }
        });
        this.JlL.add(locald);
        this.JlM.add(localObject1);
        i += 1;
        break;
        localObject4 = f.TL((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(b.g.settings_switch_account_item, null);
    Object localObject1 = (ImageView)paramMap.findViewById(b.f.account_avatar);
    ImageView localImageView = (ImageView)paramMap.findViewById(b.f.account_del_btn);
    Object localObject2 = (TextView)paramMap.findViewById(b.f.account_username);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).mOe = ((ImageView)localObject1);
    ((d)localObject3).Jkg = localImageView;
    ((d)localObject3).Dah = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(b.e.big_add_selector);
    ((TextView)localObject2).setText(getContext().getResources().getString(b.i.settings_switch_account));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).aXP(null);
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74640);
      }
    });
    this.JlL.add(localObject3);
    this.JlM.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void fGQ()
  {
    AppMethodBeat.i(74646);
    if (this.mLR)
    {
      Log.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(2, this.JlK.size());
    int i = 0;
    label103:
    GridLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if ((this.JlF) && (!((String)this.JlK.get(i)).equals(this.ndm)))
      {
        ((d)this.JlL.get(i)).Jkg.setVisibility(0);
        ((d)this.JlL.get(i)).JlT.setVisibility(4);
        if ((!Util.isNullOrNil(this.ndm)) && (((String)this.JlK.get(i)).equals(this.ndm)))
        {
          if (!this.JlG) {
            break label525;
          }
          ((ImageView)((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_dot)).setImageResource(b.e.grey_dot_shape);
          label194:
          if (!this.JlG) {
            break label559;
          }
          ((TextView)((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.wx_logout_processing_txt));
        }
      }
      for (;;)
      {
        ((d)this.JlL.get(i)).JlT.findViewById(b.f.account_login_progress).setVisibility(8);
        ((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_dot).setVisibility(0);
        ((d)this.JlL.get(i)).JlT.setVisibility(0);
        if ((!Util.isNullOrNil(this.JlI)) && (((String)this.JlK.get(i)).equals(this.JlI)))
        {
          ((TextView)((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.login_logining));
          ((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_dot).setVisibility(8);
          ((d)this.JlL.get(i)).JlT.findViewById(b.f.account_login_progress).setVisibility(0);
          ((d)this.JlL.get(i)).JlT.setVisibility(0);
        }
        localLayoutParams = new GridLayout.LayoutParams();
        localLayoutParams.width = JlE;
        addView((View)this.JlM.get(i), localLayoutParams);
        i += 1;
        break;
        ((d)this.JlL.get(i)).Jkg.setVisibility(4);
        break label103;
        label525:
        ((ImageView)((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_dot)).setImageResource(b.e.green_dot_shape);
        break label194;
        label559:
        ((TextView)((d)this.JlL.get(i)).JlT.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.settings_switch_account_current_tip));
      }
    }
    if (getChildCount() < 2)
    {
      ((d)this.JlL.get(this.JlL.size() - 1)).Jkg.setVisibility(4);
      localLayoutParams = new GridLayout.LayoutParams();
      localLayoutParams.width = JlE;
      addView((View)this.JlM.get(this.JlM.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.JlK.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.JlF = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.ndm = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.JlG = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.JlO = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.JlN = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.JlP = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.JlI = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.JlH = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void fGC();
  }
  
  public static abstract interface b
  {
    public abstract void aXP(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void aXQ(String paramString);
  }
  
  final class d
  {
    public TextView Dah;
    public ImageView Jkg;
    public View JlT;
    public ImageView mOe;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */