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
import com.tencent.mm.ag.d;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends GridLayout
{
  private static int nXZ;
  private String fnG;
  private boolean nYa;
  private boolean nYb;
  private boolean nYc;
  public String nYd;
  public boolean nYe;
  public AnimatorSet nYf;
  public List<String> nYg = new ArrayList();
  public List<d> nYh = new ArrayList();
  public List<View> nYi = new ArrayList();
  private b nYj;
  private a nYk;
  private c nYl;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    nXZ = getResources().getDimensionPixelOffset(a.d.BigAvatarSize) * 2;
  }
  
  public final void J(Map<String, SwitchAccountModel> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.nYg.addAll(paramMap.keySet());
      Collections.sort(this.nYg);
    }
    y.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.nYg.size()) });
    int i = 0;
    d locald;
    if (i < this.nYg.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(a.g.settings_switch_account_item, null);
      localImageView = (ImageView)((View)localObject1).findViewById(a.f.account_avatar);
      localObject2 = (ImageView)((View)localObject1).findViewById(a.f.account_del_btn);
      Object localObject4 = ((View)localObject1).findViewById(a.f.current_account);
      localObject3 = (String)this.nYg.get(i);
      TextView localTextView = (TextView)((View)localObject1).findViewById(a.f.account_username);
      locald = new d((byte)0);
      locald.eYO = localImageView;
      locald.nWs = ((ImageView)localObject2);
      locald.leT = localTextView;
      locald.nYp = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject3)).kgT;
      for (;;)
      {
        try
        {
          if (!bk.bl((String)localObject4))
          {
            if (!this.nYc) {
              continue;
            }
            y.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = e.c((String)localObject4, 0, (int)e.aeQ((String)localObject4));
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
          y.printErrStackTrace("MicroMsg.SwitchAccountGridView", localException, "get avatar error", new Object[0]);
          continue;
          a.b.a(locald.eYO, (String)localObject3);
          continue;
        }
        localTextView.setText(j.a(getContext(), ((SwitchAccountModel)paramMap.get(localObject3)).username, localTextView.getTextSize()));
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            y.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.nYm });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (SwitchAccountGridView.b(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.b(SwitchAccountGridView.this).Mr(this.nYm);
            }
          }
        });
        ((ImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (SwitchAccountGridView.c(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).Ms(this.nYm);
            }
          }
        });
        this.nYh.add(locald);
        this.nYi.add(localObject1);
        i += 1;
        break;
        localObject4 = d.kj((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(a.g.settings_switch_account_item, null);
    Object localObject1 = (ImageView)paramMap.findViewById(a.f.account_avatar);
    ImageView localImageView = (ImageView)paramMap.findViewById(a.f.account_del_btn);
    Object localObject2 = (TextView)paramMap.findViewById(a.f.account_username);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).eYO = ((ImageView)localObject1);
    ((d)localObject3).nWs = localImageView;
    ((d)localObject3).leT = ((TextView)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(a.e.big_add_selector);
    ((TextView)localObject2).setText(getContext().getResources().getString(a.i.settings_switch_account));
    ((ImageView)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        y.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if (SwitchAccountGridView.b(SwitchAccountGridView.this) != null) {
          SwitchAccountGridView.b(SwitchAccountGridView.this).Mr(null);
        }
      }
    });
    this.nYh.add(localObject3);
    this.nYi.add(paramMap);
  }
  
  public final void bzE()
  {
    if (this.nYe) {
      y.i("MicroMsg.SwitchAccountGridView", "playing animation");
    }
    label91:
    do
    {
      return;
      removeAllViews();
      int j = Math.min(2, this.nYg.size());
      int i = 0;
      if (i < j)
      {
        if ((this.nYa) && (!((String)this.nYg.get(i)).equals(this.fnG)))
        {
          ((d)this.nYh.get(i)).nWs.setVisibility(0);
          ((d)this.nYh.get(i)).nYp.setVisibility(4);
          if ((!bk.bl(this.fnG)) && (((String)this.nYg.get(i)).equals(this.fnG)))
          {
            if (!this.nYb) {
              break label513;
            }
            ((ImageView)((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_dot)).setImageResource(a.e.grey_dot_shape);
            if (!this.nYb) {
              break label547;
            }
            ((TextView)((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_tip)).setText(getContext().getResources().getString(a.i.wx_logout_processing_txt));
          }
        }
        for (;;)
        {
          ((d)this.nYh.get(i)).nYp.findViewById(a.f.account_login_progress).setVisibility(8);
          ((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_dot).setVisibility(0);
          ((d)this.nYh.get(i)).nYp.setVisibility(0);
          if ((!bk.bl(this.nYd)) && (((String)this.nYg.get(i)).equals(this.nYd)))
          {
            ((TextView)((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_tip)).setText(getContext().getResources().getString(a.i.login_logining));
            ((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_dot).setVisibility(8);
            ((d)this.nYh.get(i)).nYp.findViewById(a.f.account_login_progress).setVisibility(0);
            ((d)this.nYh.get(i)).nYp.setVisibility(0);
          }
          localLayoutParams = new GridLayout.LayoutParams();
          localLayoutParams.width = nXZ;
          addView((View)this.nYi.get(i), localLayoutParams);
          i += 1;
          break;
          ((d)this.nYh.get(i)).nWs.setVisibility(4);
          break label91;
          ((ImageView)((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_dot)).setImageResource(a.e.green_dot_shape);
          break label182;
          ((TextView)((d)this.nYh.get(i)).nYp.findViewById(a.f.current_account_tip)).setText(getContext().getResources().getString(a.i.settings_switch_account_current_tip));
        }
      }
    } while (getChildCount() >= 2);
    label182:
    ((d)this.nYh.get(this.nYh.size() - 1)).nWs.setVisibility(4);
    label513:
    label547:
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams();
    localLayoutParams.width = nXZ;
    addView((View)this.nYi.get(this.nYi.size() - 1), localLayoutParams);
  }
  
  public int getAccountCount()
  {
    return this.nYg.size();
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.nYa = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.fnG = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.nYb = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.nYk = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.nYj = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.nYl = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.nYd = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.nYc = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void bzr();
  }
  
  public static abstract interface b
  {
    public abstract void Mr(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void Ms(String paramString);
  }
  
  private final class d
  {
    public ImageView eYO;
    public TextView leT;
    public ImageView nWs;
    public View nYp;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */