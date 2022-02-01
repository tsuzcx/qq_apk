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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.z;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
  extends FrameLayout
{
  private f CkZ;
  private com.tencent.mm.ui.statusbar.b Cmg;
  protected LinearLayout Cmh;
  private ImageView Cmi;
  private TextView Cmj;
  private n Cmk;
  protected com.tencent.mm.plugin.webview.luggage.b.n Cml;
  private u Cmm;
  public d Cmn;
  private boolean Cmo;
  private View.OnClickListener Cmp;
  private TextView lfN;
  protected Context mContext;
  private String mTitle;
  private ImageView mgn;
  
  public l(final f paramf)
  {
    super(paramf.mContext);
    AppMethodBeat.i(78384);
    this.Cmn = null;
    this.Cmo = false;
    this.Cmp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78383);
        if (l.a(l.this) == null)
        {
          AppMethodBeat.o(78383);
          return;
        }
        l.a(l.this).bXF.a(new c()
        {
          public final JSONObject Aq()
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
    this.CkZ = paramf;
    this.Cmg = new b(this.mContext);
    addView(this.Cmg, -1, -1);
    setBackgroundResource(2131099873);
    View localView = z.jD(getContext()).inflate(2131496079, this, false);
    this.Cmg.addView(localView, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.mgn = ((ImageView)localView.findViewById(2131296396));
    this.mgn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78375);
        if (!l.this.eAn()) {
          l.this.cOL();
        }
        AppMethodBeat.o(78375);
      }
    });
    this.lfN = ((TextView)localView.findViewById(2131305902));
    this.Cmh = ((LinearLayout)localView.findViewById(2131296410));
    this.Cmi = ((ImageView)localView.findViewById(2131296409));
    this.Cmi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78376);
        if (paramf.bWW.AE().peek() == l.a(l.this)) {
          l.this.cOM();
        }
        AppMethodBeat.o(78376);
      }
    });
    this.Cmi.setClickable(false);
    this.Cmj = ((TextView)localView.findViewById(2131296411));
    this.Cmj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(78377);
        if (paramf.bWW.AE().peek() == l.a(l.this)) {
          l.this.cOM();
        }
        AppMethodBeat.o(78377);
      }
    });
    this.Cmj.setClickable(false);
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
        getMenuHelp().aBG(paramJSONArray.optString(i));
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
        getMenuHelp().aBH(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(78396);
  }
  
  public void cOL()
  {
    AppMethodBeat.i(78392);
    this.CkZ.gb(true);
    AppMethodBeat.o(78392);
  }
  
  public void cOM()
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
      ap.n(local4, l);
      AppMethodBeat.o(78389);
      return;
    }
  }
  
  public void cON()
  {
    AppMethodBeat.i(78390);
    if (this.Cmk != null) {
      this.Cmk.eAJ();
    }
    AppMethodBeat.o(78390);
  }
  
  public final void eAH()
  {
    AppMethodBeat.i(78393);
    getMenuHelp().eAH();
    AppMethodBeat.o(78393);
  }
  
  public final void eAI()
  {
    AppMethodBeat.i(78394);
    getMenuHelp().eAI();
    AppMethodBeat.o(78394);
  }
  
  public final boolean eAn()
  {
    AppMethodBeat.i(78398);
    if ((this.Cmm != null) && (this.Cmm.eAS()))
    {
      Object localObject1 = this.Cmm.eAT();
      String str1 = this.Cmm.eAU();
      String str2 = this.Cmm.eAV();
      ac.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
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
      this.Cmn = h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(78379);
          l.b(l.this);
          l.this.cOL();
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
  
  protected com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(78388);
    if (this.Cml == null) {
      this.Cml = new com.tencent.mm.plugin.webview.luggage.b.n();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.Cml;
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
    ac.i("MicroMsg.GameWebViewActionBar", "setActionBarColor, color : %d", new Object[] { Integer.valueOf(paramInt) });
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(2131101179);
    }
    boolean bool2 = am.ZN(i);
    com.tencent.mm.ui.statusbar.b localb = this.Cmg;
    if (!bool2) {}
    for (;;)
    {
      a.e(localb, i, bool1);
      setBackgroundColor(i);
      if (bool2) {
        break;
      }
      this.lfN.setTextColor(-16777216);
      this.mgn.setColorFilter(-16777216);
      if (this.Cmo) {
        break label160;
      }
      this.Cmi.setImageResource(2131689493);
      AppMethodBeat.o(78399);
      return;
      bool1 = false;
    }
    this.lfN.setTextColor(-1);
    this.mgn.clearColorFilter();
    if (!this.Cmo) {
      this.Cmi.setImageResource(2131689500);
    }
    label160:
    AppMethodBeat.o(78399);
  }
  
  protected void setBackBtn(int paramInt)
  {
    AppMethodBeat.i(182686);
    this.mgn.setImageResource(paramInt);
    AppMethodBeat.o(182686);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(78397);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new u(paramBundle))
    {
      this.Cmm = paramBundle;
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
    final int i = com.tencent.mm.plugin.webview.ui.tools.e.fr(str3, -1);
    final int j = (int)com.tencent.mm.plugin.webview.ui.tools.e.aDf(str4);
    paramBundle = localObject;
    if (!bs.isNullOrNil(str2)) {}
    try
    {
      paramBundle = com.tencent.mm.plugin.webview.ui.tools.e.aDg(str2);
      ap.f(new Runnable()
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
            else if (!bs.isNullOrNil(str1))
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
        ac.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(78385);
    if (paramBoolean)
    {
      this.Cmi.setClickable(true);
      this.Cmj.setClickable(true);
      AppMethodBeat.o(78385);
      return;
    }
    this.Cmi.setClickable(false);
    this.Cmj.setClickable(false);
    AppMethodBeat.o(78385);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(78387);
    this.lfN.setTextColor(paramInt);
    AppMethodBeat.o(78387);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(78386);
    ac.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.lfN.setText(paramString);
    AppMethodBeat.o(78386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */