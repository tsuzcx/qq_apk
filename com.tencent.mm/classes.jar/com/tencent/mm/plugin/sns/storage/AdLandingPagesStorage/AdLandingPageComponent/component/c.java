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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.pluginsdk.ui.span.e;
import com.tencent.mm.pluginsdk.ui.span.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends a
{
  private ImageView EbI;
  private ImageView EbJ;
  LinearLayout EbK;
  int clickCount;
  private TextView jCB;
  LinearLayout tmh;
  
  public c(Context paramContext, d paramd, ViewGroup paramViewGroup)
  {
    super(paramContext, paramd, paramViewGroup);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96418);
    if (!super.bp(paramJSONObject))
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
      Log.printErrStackTrace("AdLandingBorderedComp", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96418);
    }
    return false;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96416);
    this.jCB.setText((CharSequence)((d)this.EcX).DXU.get(0));
    if (((d)this.EcX).DZm)
    {
      this.EbI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131235225));
      this.EbJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234687));
      this.jCB.setTextColor(-16777216);
      this.EbK.setBackgroundResource(2131230920);
    }
    for (;;)
    {
      this.EbK.setPadding((int)((d)this.EcX).paddingLeft, 0, (int)((d)this.EcX).paddingRight, 0);
      this.tmh.setPadding(0, (int)((d)this.EcX).paddingTop, 0, (int)((d)this.EcX).paddingBottom);
      a(this.EbK);
      this.EbK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(96415);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = c.this;
          paramAnonymousView.clickCount += 1;
          if (e.a.KqE == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
          }
          if (c.a(c.this).DXU.size() > 1) {
            e.a.KqE.a(c.this.context, c.a(c.this).DXU, new e.b()
            {
              public final void onDismiss()
              {
                AppMethodBeat.i(96414);
                ap.hb(c.this.context);
                AppMethodBeat.o(96414);
              }
            });
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingContactComp$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(96415);
            return;
            if (c.a(c.this).DXU.size() > 0) {
              AdLandingPagesProxy.getInstance().confirmDialPhoneNum((Activity)c.this.context, (String)c.a(c.this).DXU.get(0));
            }
          }
        }
      });
      AppMethodBeat.o(96416);
      return;
      this.EbI.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131235224));
      this.EbJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131234686));
      this.jCB.setTextColor(-1);
      this.EbK.setBackgroundResource(2131230921);
    }
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96417);
    if (((d)this.EcX).DXU.isEmpty())
    {
      AppMethodBeat.o(96417);
      return;
    }
    View localView = this.contentView;
    this.EbI = ((ImageView)localView.findViewById(2131303139));
    this.EbJ = ((ImageView)localView.findViewById(2131307076));
    this.jCB = ((TextView)localView.findViewById(2131299495));
    this.tmh = ((LinearLayout)localView.findViewById(2131299174));
    this.EbK = ((LinearLayout)localView.findViewById(2131302668));
    AppMethodBeat.o(96417);
  }
  
  protected final int getLayout()
  {
    return 2131496388;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */