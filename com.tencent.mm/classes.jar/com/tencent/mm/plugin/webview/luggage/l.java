package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.statusbar.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.c;
import org.json.JSONArray;

public class l
  extends FrameLayout
{
  private TextView iJG;
  private ImageView ksT;
  protected Context mContext;
  private String mTitle;
  private e uSb;
  private com.tencent.mm.ui.statusbar.b uSr;
  private ImageView uSs;
  private TextView uSt;
  private o uSu;
  protected com.tencent.mm.plugin.webview.luggage.b.l uSv;
  private s uSw;
  public c uSx;
  private boolean uSy;
  private View.OnClickListener uSz;
  
  public l(e parame)
  {
    super(parame.mContext);
    AppMethodBeat.i(6181);
    this.uSx = null;
    this.uSy = false;
    this.uSz = new l.8(this);
    this.mContext = parame.mContext;
    this.uSb = parame;
    this.uSr = new b(this.mContext);
    addView(this.uSr, -1, -1);
    setBackgroundResource(2131689641);
    View localView = w.hM(getContext()).inflate(2130971297, this, false);
    this.uSr.addView(localView, new FrameLayout.LayoutParams(-1, getActionBarHeight()));
    this.ksT = ((ImageView)localView.findViewById(2131822975));
    this.ksT.setOnClickListener(new l.1(this));
    this.iJG = ((TextView)localView.findViewById(2131820680));
    this.uSs = ((ImageView)localView.findViewById(2131822976));
    this.uSs.setOnClickListener(new l.2(this, parame));
    this.uSs.setClickable(false);
    this.uSt = ((TextView)localView.findViewById(2131829529));
    this.uSt.setOnClickListener(new l.3(this, parame));
    this.uSt.setClickable(false);
    AppMethodBeat.o(6181);
  }
  
  private int getActionBarHeight()
  {
    AppMethodBeat.i(6188);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {}
    for (int i = this.mContext.getResources().getDimensionPixelSize(2131427558);; i = this.mContext.getResources().getDimensionPixelSize(2131427559))
    {
      AppMethodBeat.o(6188);
      return i;
    }
  }
  
  public final void K(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(6192);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().agQ(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(6192);
  }
  
  public final void L(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(6193);
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        getMenuHelp().agR(paramJSONArray.optString(i));
        i += 1;
      }
    }
    AppMethodBeat.o(6193);
  }
  
  public void bFt()
  {
    AppMethodBeat.i(6189);
    if (!this.uSb.byJ.un().ug()) {
      ((Activity)this.mContext).finish();
    }
    AppMethodBeat.o(6189);
  }
  
  public void bFu()
  {
    AppMethodBeat.i(6186);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(6175);
        l.a(l.this, new o(l.a(l.this), l.this.getMenuHelp()));
        AppMethodBeat.o(6175);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      al.p(local4, l);
      AppMethodBeat.o(6186);
      return;
    }
  }
  
  public void bFv()
  {
    AppMethodBeat.i(6187);
    if (this.uSu != null) {
      this.uSu.dbu();
    }
    AppMethodBeat.o(6187);
  }
  
  public final boolean daU()
  {
    AppMethodBeat.i(6195);
    if ((this.uSw != null) && (this.uSw.dbw()))
    {
      Object localObject1 = this.uSw.dbx();
      String str1 = this.uSw.dby();
      String str2 = this.uSw.dbz();
      ab.i("MicroMsg.GameWebViewActionBar", "use js api close window confirm info : %s, %s, %s", new Object[] { localObject1, str1, str2 });
      View localView = View.inflate(getContext(), 2130970141, null);
      Object localObject2 = (CheckBox)localView.findViewById(2131826141);
      ((CheckBox)localObject2).setChecked(false);
      ((CheckBox)localObject2).setVisibility(8);
      localObject2 = (TextView)localView.findViewById(2131826140);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131690322));
      localObject1 = (TextView)localView.findViewById(2131826142);
      ((TextView)localObject1).setTextColor(getResources().getColor(2131690322));
      ((TextView)localObject1).setVisibility(8);
      this.uSx = com.tencent.mm.ui.base.h.a(getContext(), true, "", localView, str1, str2, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(6176);
          l.b(l.this);
          l.this.bFt();
          AppMethodBeat.o(6176);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(6177);
          l.b(l.this);
          AppMethodBeat.o(6177);
        }
      });
      AppMethodBeat.o(6195);
      return true;
    }
    AppMethodBeat.o(6195);
    return false;
  }
  
  public final void dbq()
  {
    AppMethodBeat.i(6190);
    getMenuHelp().dbq();
    AppMethodBeat.o(6190);
  }
  
  public final void dbr()
  {
    AppMethodBeat.i(6191);
    getMenuHelp().dbr();
    AppMethodBeat.o(6191);
  }
  
  protected com.tencent.mm.plugin.webview.luggage.b.l getMenuHelp()
  {
    AppMethodBeat.i(6185);
    if (this.uSv == null) {
      this.uSv = new com.tencent.mm.plugin.webview.luggage.b.l();
    }
    com.tencent.mm.plugin.webview.luggage.b.l locall = this.uSv;
    AppMethodBeat.o(6185);
    return locall;
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(153117);
    ab.d("MicroMsg.GameWebViewActionBar", "setActionBarColor");
    boolean bool2 = aj.Ow(paramInt);
    com.tencent.mm.ui.statusbar.b localb = this.uSr;
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.d(localb, paramInt, bool1);
      setBackgroundColor(paramInt);
      if (bool2) {
        break;
      }
      this.iJG.setTextColor(-16777216);
      this.ksT.setColorFilter(-16777216);
      if (this.uSy) {
        break label129;
      }
      this.uSs.setImageResource(2131230740);
      AppMethodBeat.o(153117);
      return;
    }
    this.iJG.setTextColor(-1);
    this.ksT.clearColorFilter();
    if (!this.uSy) {
      this.uSs.setImageResource(2131230747);
    }
    label129:
    AppMethodBeat.o(153117);
  }
  
  public void setCloseWindowConfirmInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(6194);
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = new s(paramBundle))
    {
      this.uSw = paramBundle;
      AppMethodBeat.o(6194);
      return;
    }
  }
  
  public void setNavigationBarButtons(final Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(6197);
    if (paramBundle == null)
    {
      AppMethodBeat.o(6197);
      return;
    }
    String str3 = paramBundle.getString("set_navigation_bar_buttons_left_text_color");
    final boolean bool1 = paramBundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
    final String str1 = paramBundle.getString("set_navigation_bar_buttons_text");
    String str2 = paramBundle.getString("set_navigation_bar_buttons_icon_data");
    String str4 = paramBundle.getString("set_navigation_bar_buttons_text_color");
    final boolean bool2 = paramBundle.getBoolean("set_navigation_bar_buttons_need_click_event", false);
    final int i = com.tencent.mm.plugin.webview.ui.tools.g.by(str3, -1);
    final int j = (int)com.tencent.mm.plugin.webview.ui.tools.g.aif(str4);
    paramBundle = localObject;
    if (!bo.isNullOrNil(str2)) {}
    try
    {
      paramBundle = com.tencent.mm.plugin.webview.ui.tools.g.aig(str2);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(6178);
          if ((l.this == null) || (l.a(l.this) == null))
          {
            AppMethodBeat.o(6178);
            return;
          }
          if (bool1) {
            l.a(l.this, true);
          }
          for (;;)
          {
            Drawable localDrawable = l.this.getResources().getDrawable(2131230739).mutate();
            localDrawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            if (l.f(l.this) != null) {
              l.f(l.this).setImageDrawable(localDrawable);
            }
            AppMethodBeat.o(6178);
            return;
            l.a(l.this, false);
            if ((l.c(l.this) == null) || (l.d(l.this) == null))
            {
              AppMethodBeat.o(6178);
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
            else if (!bo.isNullOrNil(str1))
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
              l.c(l.this).setImageResource(2131230740);
              l.d(l.this).setVisibility(8);
              if (bool2) {
                l.c(l.this).setOnClickListener(l.e(l.this));
              }
            }
          }
        }
      });
      AppMethodBeat.o(6197);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameWebViewActionBar", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[] { paramBundle });
        paramBundle = localObject;
      }
    }
  }
  
  public void setOptionEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(6182);
    if (paramBoolean)
    {
      this.uSs.setClickable(true);
      this.uSt.setClickable(true);
      AppMethodBeat.o(6182);
      return;
    }
    this.uSs.setClickable(false);
    this.uSt.setClickable(false);
    AppMethodBeat.o(6182);
  }
  
  public void setTitleColor(int paramInt)
  {
    AppMethodBeat.i(6184);
    this.iJG.setTextColor(paramInt);
    AppMethodBeat.o(6184);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(6183);
    ab.d("MicroMsg.GameWebViewActionBar", "setTitleText, title: %s", new Object[] { paramString });
    this.mTitle = paramString;
    this.iJG.setText(paramString);
    AppMethodBeat.o(6183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.l
 * JD-Core Version:    0.7.0.1
 */