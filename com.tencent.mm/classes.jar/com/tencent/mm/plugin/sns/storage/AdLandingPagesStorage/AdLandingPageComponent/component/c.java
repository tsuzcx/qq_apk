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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  int clickCount;
  private TextView hJR;
  LinearLayout qlu;
  private ImageView wYV;
  private ImageView wYW;
  LinearLayout wYX;
  
  public c(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.aG(paramJSONObject))
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
      ad.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96418);
    }
    return false;
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96416);
    this.hJR.setText((CharSequence)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).wVB.get(0));
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).wWI)
    {
      this.wYV.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131234338));
      this.wYW.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131233863));
      this.hJR.setTextColor(-16777216);
      this.wYX.setBackgroundResource(2131230900);
    }
    for (;;)
    {
      this.wYX.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).paddingLeft, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).paddingRight, 0);
      this.qlu.setPadding(0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).paddingTop, 0, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).paddingBottom);
      a(this.wYX);
      this.wYX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (d.a.CjG == null)
          {
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).wVB.size() > 1)
          {
            d.a.CjG.a(c.this.context, c.a(c.this).wVB, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                al.fV(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).wVB.size() > 0) {
            AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)c.a(c.this).wVB.get(0));
          }
          AppMethodBeat.o(96415);
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.wYV.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131234337));
      this.wYW.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131233862));
      this.hJR.setTextColor(-1);
      this.wYX.setBackgroundResource(2131230901);
    }
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96417);
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d)this.xab).wVB.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.wYV = ((ImageView)localView.findViewById(2131301384));
    this.wYW = ((ImageView)localView.findViewById(2131304172));
    this.hJR = ((TextView)localView.findViewById(2131298996));
    this.qlu = ((LinearLayout)localView.findViewById(2131298736));
    this.wYX = ((LinearLayout)localView.findViewById(2131301023));
    AppMethodBeat.o(96417);
  }
  
  protected final int getLayout()
  {
    return 2131495503;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */