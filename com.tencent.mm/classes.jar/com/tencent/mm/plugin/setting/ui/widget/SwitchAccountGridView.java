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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.e;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SwitchAccountGridView
  extends LinearLayout
{
  private static int Pyu;
  public List<String> PyA;
  public List<d> PyB;
  public List<View> PyC;
  private b PyD;
  private a PyE;
  private c PyF;
  private boolean Pyv;
  private boolean Pyw;
  private boolean Pyx;
  private String Pyy;
  public AnimatorSet Pyz;
  public boolean pIz;
  private String qaF;
  
  public SwitchAccountGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74644);
    this.PyA = new ArrayList();
    this.PyB = new ArrayList();
    this.PyC = new ArrayList();
    Pyu = getResources().getDimensionPixelOffset(b.d.BigAvatarSize) * 2;
    AppMethodBeat.o(74644);
  }
  
  public final void aQ(Map<String, SwitchAccountModel> paramMap)
  {
    AppMethodBeat.i(74645);
    this.PyA.clear();
    this.PyB.clear();
    this.PyC.clear();
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      this.PyA.addAll(paramMap.keySet());
      Collections.sort(this.PyA);
    }
    Log.i("MicroMsg.SwitchAccountGridView", "account count %d", new Object[] { Integer.valueOf(this.PyA.size()) });
    int i = 0;
    d locald;
    if (i < this.PyA.size())
    {
      localObject1 = ((Activity)getContext()).getLayoutInflater().inflate(b.g.settings_switch_account_item_new, null);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(b.f.account_avatar);
      localButton = (Button)((View)localObject1).findViewById(b.f.account_del_btn);
      Object localObject4 = ((View)localObject1).findViewById(b.f.current_account);
      localObject2 = (String)this.PyA.get(i);
      localObject3 = (TextView)((View)localObject1).findViewById(b.f.account_username);
      locald = new d((byte)0);
      locald.pKM = localImageView;
      locald.pYm = localButton;
      locald.PyI = ((TextView)((View)localObject1).findViewById(b.f.account_nickname));
      locald.ukP = ((TextView)localObject3);
      locald.PyJ = ((View)localObject4);
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localObject4 = ((SwitchAccountModel)paramMap.get(localObject2)).AmC;
      for (;;)
      {
        try
        {
          if (!Util.isNullOrNil((String)localObject4))
          {
            if (!this.Pyx) {
              continue;
            }
            Log.i("MicroMsg.SwitchAccountGridView", "use system decoder!");
            localObject4 = y.bi((String)localObject4, 0, (int)y.bEl((String)localObject4));
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
          a.b.g(locald.pKM, (String)localObject2);
          continue;
          locald.PyI.setText(((SwitchAccountModel)paramMap.get(localObject2)).nickName);
          continue;
        }
        ((TextView)localObject3).setText(p.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject2)).username, ((TextView)localObject3).getTextSize()));
        if (!MMApplicationContext.isMainProcess()) {
          continue;
        }
        locald.PyI.setText(p.b(getContext(), ((SwitchAccountModel)paramMap.get(localObject2)).nickName, locald.PyI.getTextSize()));
        ((View)localObject1).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74638);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.PyG });
            if ((!SwitchAccountGridView.a(SwitchAccountGridView.this)) && (!SwitchAccountGridView.b(SwitchAccountGridView.this)) && (SwitchAccountGridView.c(SwitchAccountGridView.this) != null)) {
              SwitchAccountGridView.c(SwitchAccountGridView.this).aVI(this.PyG);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74638);
          }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(74639);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (SwitchAccountGridView.d(SwitchAccountGridView.this) != null) {
              SwitchAccountGridView.d(SwitchAccountGridView.this).aVH(this.PyG);
            }
            a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(74639);
          }
        });
        this.PyB.add(locald);
        this.PyC.add(localObject1);
        i += 1;
        break;
        localObject4 = AvatarStorage.LL((String)localObject4);
        if (localObject4 == null) {
          continue;
        }
        localImageView.setImageBitmap((Bitmap)localObject4);
      }
    }
    paramMap = ((Activity)getContext()).getLayoutInflater().inflate(b.g.settings_switch_account_item_new, null);
    Object localObject1 = (ImageView)paramMap.findViewById(b.f.account_avatar);
    Button localButton = (Button)paramMap.findViewById(b.f.account_del_btn);
    Object localObject2 = (TextView)paramMap.findViewById(b.f.account_username);
    Object localObject3 = new d((byte)0);
    ((d)localObject3).pKM = ((ImageView)localObject1);
    ((d)localObject3).pYm = localButton;
    ((d)localObject3).ukP = ((TextView)localObject2);
    paramMap.findViewById(b.f.account_nickname).setVisibility(8);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject1).setImageResource(b.e.big_add_selector);
    ((View)((TextView)localObject2).getParent()).setVisibility(8);
    paramMap.findViewById(b.f.account_add_text).setVisibility(0);
    paramMap.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74640);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.SwitchAccountGridView", "click addBtn");
        if ((SwitchAccountGridView.c(SwitchAccountGridView.this) != null) && (!SwitchAccountGridView.b(SwitchAccountGridView.this)) && (!SwitchAccountGridView.a(SwitchAccountGridView.this))) {
          SwitchAccountGridView.c(SwitchAccountGridView.this).aVI(null);
        }
        a.a(this, "com/tencent/mm/plugin/setting/ui/widget/SwitchAccountGridView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74640);
      }
    });
    this.PyB.add(localObject3);
    this.PyC.add(paramMap);
    AppMethodBeat.o(74645);
  }
  
  public final void gWD()
  {
    AppMethodBeat.i(74646);
    if (this.pIz)
    {
      Log.i("MicroMsg.SwitchAccountGridView", "playing animation");
      AppMethodBeat.o(74646);
      return;
    }
    removeAllViews();
    int j = Math.min(5, this.PyA.size());
    int i = 0;
    label103:
    label235:
    LinearLayout.LayoutParams localLayoutParams;
    if (i < j)
    {
      if (this.Pyv) {
        if (!((String)this.PyA.get(i)).equals(this.qaF))
        {
          ((d)this.PyB.get(i)).pYm.setVisibility(0);
          ((d)this.PyB.get(i)).PyJ.setVisibility(4);
          if ((!Util.isNullOrNil(this.qaF)) && (((String)this.PyA.get(i)).equals(this.qaF)))
          {
            if (!this.Pyw) {
              break label677;
            }
            ((ImageView)((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_dot)).setImageResource(b.e.grey_dot_shape);
            ((TextView)((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.wx_logout_processing_txt));
            ((d)this.PyB.get(i)).PyJ.findViewById(b.f.account_login_progress).setVisibility(8);
            ((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_dot).setVisibility(0);
            ((d)this.PyB.get(i)).PyJ.setVisibility(0);
          }
          if ((!Util.isNullOrNil(this.Pyy)) && (((String)this.PyA.get(i)).equals(this.Pyy)))
          {
            ((TextView)((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.login_logining));
            ((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_dot).setVisibility(8);
            ((d)this.PyB.get(i)).PyJ.findViewById(b.f.account_login_progress).setVisibility(0);
            ((d)this.PyB.get(i)).PyJ.setVisibility(0);
          }
          if (this.Pyw)
          {
            if ((Util.isNullOrNil(this.qaF)) || (!((String)this.PyA.get(i)).equals(this.qaF))) {
              break label752;
            }
            ((View)this.PyC.get(i)).setAlpha(1.0F);
          }
          label512:
          if (!Util.isNullOrNil(this.Pyy))
          {
            if (!((String)this.PyA.get(i)).equals(this.Pyy)) {
              break label774;
            }
            ((View)this.PyC.get(i)).setAlpha(1.0F);
          }
        }
      }
      for (;;)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelOffset(b.d.Edge_1_5_A);
        addView((View)this.PyC.get(i), localLayoutParams);
        i += 1;
        break;
        ((View)this.PyC.get(i)).setAlpha(0.5F);
        break label103;
        ((View)this.PyC.get(i)).setAlpha(1.0F);
        ((d)this.PyB.get(i)).pYm.setVisibility(4);
        break label103;
        label677:
        ((ImageView)((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_dot)).setImageResource(b.e.green_dot_shape);
        ((TextView)((d)this.PyB.get(i)).PyJ.findViewById(b.f.current_account_tip)).setText(getContext().getResources().getString(b.i.settings_switch_account_current_tip));
        break label235;
        label752:
        ((View)this.PyC.get(i)).setAlpha(0.5F);
        break label512;
        label774:
        ((View)this.PyC.get(i)).setAlpha(0.5F);
      }
    }
    if ((getChildCount() < 5) && (!this.Pyv) && (!this.Pyw) && (Util.isNullOrNil(this.Pyy)))
    {
      ((d)this.PyB.get(this.PyB.size() - 1)).pYm.setVisibility(4);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      addView((View)this.PyC.get(this.PyC.size() - 1), localLayoutParams);
    }
    AppMethodBeat.o(74646);
  }
  
  public int getAccountCount()
  {
    AppMethodBeat.i(74647);
    int i = this.PyA.size();
    AppMethodBeat.o(74647);
    return i;
  }
  
  public void setDeleteState(boolean paramBoolean)
  {
    this.Pyv = paramBoolean;
  }
  
  public void setLastLoginWxUsername(String paramString)
  {
    this.qaF = paramString;
  }
  
  public void setLogoutState(boolean paramBoolean)
  {
    this.Pyw = paramBoolean;
  }
  
  public void setOnAnimatorEndListener(a parama)
  {
    this.PyE = parama;
  }
  
  public void setOnClickAvatarListener(b paramb)
  {
    this.PyD = paramb;
  }
  
  public void setOnDeleteAvatarListener(c paramc)
  {
    this.PyF = paramc;
  }
  
  public void setSwitchToWxUsername(String paramString)
  {
    this.Pyy = paramString;
  }
  
  public void setUseSystemDecoder(boolean paramBoolean)
  {
    this.Pyx = paramBoolean;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void aVI(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void aVH(String paramString);
  }
  
  final class d
  {
    public TextView PyI;
    public View PyJ;
    public ImageView pKM;
    public Button pYm;
    public TextView ukP;
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView
 * JD-Core Version:    0.7.0.1
 */