package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
  extends FrameLayout
{
  private f ASM;
  private com.tencent.mm.ui.statusbar.b ATT;
  protected LinearLayout ATU;
  private ImageView ATV;
  private TextView ATW;
  private n ATX;
  protected com.tencent.mm.plugin.webview.luggage.b.n ATY;
  private u ATZ;
  public d AUa;
  private boolean AUb;
  private View.OnClickListener AUc;
  private TextView kEu;
  private ImageView lEt;
  protected Context mContext;
  private String mTitle;
  
  public l(final f paramf)
  {
    super(paramf.mContext);
    AppMethodBeat.i(78384);
    this.AUa = null;
    this.AUb = false;
    this.AUc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78383);
        if (l.a(l.this) == null)
        {
          AppMethodBeat.o(78383);
          return;
        }
        l.a(l.this).caI.a(new c()
        {
          public final JSONObject AM()
          {
            AppMethodBeat.i(78382);
            JSONObject localJSONObject = new JSONObject();
            AppMethodBeat.o(78382);
            return localJSONObject;
          }
          
          public final String name()
          {
            return "onNavigationBarRightButtonClick";
          }
        });
        AppMethodBeat.o(78383);
      }
    };
    this.mContext = paramf.mContext;
    this.ASM = paramf;
    this.ATT = new b(this.mContext);
    addView(this.ATT, -1, -1);
    setBackgroundResource(2131099873);
    View localView = y.js(getContext()).inflate(2131496079, this, false);
    this.ATT.addView(localView, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.lEt = ((ImageView)localView.findViewById(2131296396));
    this.lEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        if (!l.this.ekR()) {
          l.this.cBA();
        }
        AppMethodBeat.o(78375);
      }
    });
    this.kEu = ((TextView)localView.findViewById(2131305902));
    this.ATU = ((LinearLayout)localView.findViewById(2131296410));
    this.ATV = ((ImageView)localView.findViewById(2131296409));
    this.ATV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        if (paramf.bZZ.Ba().peek() == l.a(l.this)) {
          l.this.cBB();
        }
        AppMethodBeat.o(78376);
      }
    });
    this.ATV.setClickable(false);
    this.ATW = ((TextView)localView.findViewById(2131296411));
    this.ATW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        if (paramf.bZZ.Ba().peek() == l.a(l.this)) {
          l.this.cBB();
        }
        AppMethodBeat.o(78377);
      }
    });
    this.ATW.setClickable(false);
    AppMethodBeat.o(78384);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(78391);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {}
    for (int i = this.mContext.getResources().getDimensionPixelSize(2131165251);; i = this.mContext.getResources().getDimensionPixelSize(2131165252))
    {
      AppMethodBeat.o(78391);
      return i;
    }
  }
  
  public final void M(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78395);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().awo(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78395);
  }
  
  public final void N(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(78396);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().awp(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void cBA()
  {
    AppMethodBeat.i(78392);
    this.ASM.fF(true);
    AppMethodBeat.o(78392);
  }
  
  public void cBB()
  {
    AppMethodBeat.i(78389);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(78378);
        l.a(l.this, new n(l.a(l.this), l.this.getMenuHelp()));
        AppMethodBeat.o(78378);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      aq.n(local4, l);
      AppMethodBeat.o(78389);
      return;
    }
  }
  
  public void cBC()
  {
    AppMethodBeat.i(78390);
    if (this.ATX != null) {
      this.ATX.eln();
    }
    AppMethodBeat.o(78390);
  }
  
  public final boolean ekR()
  {
    AppMethodBeat.i(78398);
    if ((this.ATZ != null) && (this.ATZ.elw()))
    {
      Object localObject1 = this.ATZ.elx();
      String str1 = this.ATZ.ely();
      String str2 = this.ATZ.elz();
      ad.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
      View localView = View.inflate(getContext(), 2131494763, null);
      Object localObject2 = (CheckBox)localView.findViewById(2131302304);
      ((CheckBox)localObject2).setChecked(false);
      ((CheckBox)localObject2).setVisibility(8);
      localObject2 = (TextView)localView.findViewById(2131302306);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131100711));
      localObject1 = (TextView)localView.findViewById(2131302305);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131100711));
      ((TextView)localObject1).setVisibility(8);
      this.AUa = h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          l.b(l.this);
          l.this.cBA();
          AppMethodBeat.o(78379);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78380);
          l.b(l.this);
          AppMethodBeat.o(78380);
        }
      });
      AppMethodBeat.o(78398);
      return true;
    }
    AppMethodBeat.o(78398);
    return false;
  }
  
  public final void ell()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().ell();
    AppMethodBeat.o(78393);
  }
  
  public final void elm()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().elm();
    AppMethodBeat.o(78394);
  }
  
  protected com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.ATY == null) {
      this.ATY = new com.tencent.mm.plugin.webview.luggage.b.n();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.ATY;
    AppMethodBeat.o(78388);
    return localn;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public void onDestroy() {}
  
  public void onForeground() {}
  
  public void setActionBarColor(int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(78399);
    ad.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(2131101179);
    }
    boolean bool2 = am.XC(i);
    com.tencent.mm.ui.statusbar.b localb = this.ATT;
    if (!bool2) {}
    for (;;)
    {
      a.e(localb, i, bool1);
      setBackgroundColor(i);
      if (bool2) {
        break;
      }
      this.kEu.setTextColor(-16777216);
      this.lEt.setColorFilter(-16777216);
      if (this.AUb) {
        break label160;
      }
      this.ATV.setImageResource(2131689493);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
    this.kEu.setTextColor(-1);
    this.lEt.clearColorFilter();
    if (!this.AUb) {
      this.ATV.setImageResource(2131689500);
    }
    label160:
    AppMethodBeat.o(78399);
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.lEt.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new u(paramBundle))
    {
      this.ATZ = paramBundle;
      AppMethodBeat.o(78397);
      return;
    }
  }
  
  public void setNavigationBarButtons(final Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(78400);
    if (paramBundle == null)
    {
      AppMethodBeat.o(78400);
      return;
    }
    String str3 = paramBundle.getString("set_navigation_bar_buttons_left_text_color");
    final boolean bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
    final String str1 = paramBundle.getString("set_navigation_bar_buttons_text");
    String str2 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
    String str4 = paramBundle.getString("set_navigation_bar_buttons_text_color");
    final boolean bool2 = paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
    final int i = com.tencent.mm.plugin.webview.ui.tools.e.fj(str3, -1);
    final int j = (int)com.tencent.mm.plugin.webview.ui.tools.e.axN(str4);
    paramBundle = localObject;
    if (!bt.isNullOrNil(str2)) {}
    try
    {
      paramBundle = com.tencent.mm.plugin.webview.ui.tools.e.axO(str2);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(78381);
          if ((l.this == null) || (l.a(l.this) == null))
          {
            AppMethodBeat.o(78381);
            return;
          }
          if (bool1) {
            l.a(l.this, true);
          }
          for (;;)
          {
            Drawable localDrawable = l.this.getResources().getDrawable(2131689508).mutate();
            localDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            if (l.f(l.this) != null) {
              l.f(l.this).setImageDrawable(localDrawable);
            }
            AppMethodBeat.o(78381);
            return;
            l.a(l.this, false);
            if ((l.c(l.this) == null) || (l.d(l.this) == null))
            {
              AppMethodBeat.o(78381);
              return;
            }
            l.b(l.this, false);
            if ((paramBundle != null) && (!paramBundle.isRecycled()))
            {
              l.c(l.this).setVisibility(0);
              l.c(l.this).setImageBitmap(paramBundle);
              l.d(l.this).setVisibility(8);
              l.b(l.this, true);
              if (bool2) {
                l.c(l.this).setOnClickListener(l.e(l.this));
              }
            }
            else if (!bt.isNullOrNil(str1))
            {
              l.c(l.this).setVisibility(8);
              l.d(l.this).setVisibility(0);
              l.d(l.this).setText(str1);
              if (j != -1) {
                l.d(l.this).setTextColor(j);
              }
              if (bool2) {
                l.d(l.this).setOnClickListener(l.e(l.this));
              }
            }
            else
            {
              l.c(l.this).setVisibility(0);
              l.c(l.this).setImageResource(2131689493);
              l.d(l.this).setVisibility(8);
              if (bool2) {
                l.c(l.this).setOnClickListener(l.e(l.this));
              }
            }
          }
        }
      });
      AppMethodBeat.o(78400);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ad.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(78385);
    if (paramBoolean)
    {
      this.ATV.setClickable(true);
      this.ATW.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.ATV.setClickable(false);
    this.ATW.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.kEu.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    ad.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.kEu.setText(paramString);
    AppMethodBeat.o(78386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */