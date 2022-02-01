package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.pluginsdk.ui.span.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  int clickCount;
  private TextView ikp;
  LinearLayout qTW;
  private ImageView ylJ;
  private ImageView ylK;
  LinearLayout ylL;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96418);
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      AppMethodBeat.o(96418);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96418);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96417);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).yip.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.ylJ = ((ImageView)localView.findViewById(2131301384));
    this.ylK = ((ImageView)localView.findViewById(2131304172));
    this.ikp = ((TextView)localView.findViewById(2131298996));
    this.qTW = ((LinearLayout)localView.findViewById(2131298736));
    this.ylL = ((LinearLayout)localView.findViewById(2131301023));
    AppMethodBeat.o(96417);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96416);
    this.ikp.setText((CharSequence)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).yip.get(0));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).yjw)
    {
      this.ylJ.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234338));
      this.ylK.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233863));
      this.ikp.setTextColor(-16777216);
      this.ylL.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.ylL.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).paddingLeft, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).paddingRight, 0);
      this.qTW.setPadding(0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).paddingTop, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.ymQ).paddingBottom);
      a(this.ylL);
      this.ylL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (d.a.DBX == null)
          {
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).yip.size() > 1)
          {
            d.a.DBX.a(c.this.context, c.a(c.this).yip, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                al.gh(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).yip.size() > 0) {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)c.a(c.this).yip.get(0));
          }
          AppMethodBeat.o(96415);
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.ylJ.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131234337));
      this.ylK.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131233862));
      this.ikp.setTextColor(-1);
      this.ylL.setBackgroundResource(2131230901);
    }
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */