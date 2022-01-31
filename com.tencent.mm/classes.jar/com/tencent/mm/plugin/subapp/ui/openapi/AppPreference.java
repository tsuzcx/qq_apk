package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference
  extends Preference
{
  private Context context;
  private boolean ovS;
  int sYL;
  a sYN;
  AdapterView.OnItemClickListener sYO;
  AdapterView.OnItemClickListener sYP;
  private View.OnClickListener sYQ;
  private int sYR;
  private int sYS;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25443);
    this.sYO = null;
    this.sYP = null;
    this.sYQ = null;
    this.sYL = 0;
    this.ovS = false;
    this.sYS = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.sYR = paramContext.getInt(0, 8);
    this.ovS = paramContext.getBoolean(1, false);
    this.sYS = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(25443);
  }
  
  public final f Gn(int paramInt)
  {
    AppMethodBeat.i(25445);
    if ((paramInt < 0) || (paramInt >= this.sYN.getCount()))
    {
      AppMethodBeat.o(25445);
      return null;
    }
    f localf = (f)this.sYN.getItem(paramInt);
    AppMethodBeat.o(25445);
    return localf;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(25444);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131821494);
    this.sYN = new a(this.context, this.sYL);
    localMMGridView.setAdapter(this.sYN);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(25441);
        if (AppPreference.a(AppPreference.this).xj(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).mv(false);
          AppMethodBeat.o(25441);
          return;
        }
        if (AppPreference.a(AppPreference.this).sYK)
        {
          if (AppPreference.b(AppPreference.this) != null)
          {
            AppPreference.b(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            AppMethodBeat.o(25441);
          }
        }
        else if (AppPreference.c(AppPreference.this) != null) {
          AppPreference.c(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(25441);
      }
    });
    if (this.ovS) {
      localMMGridView.setOnItemLongClickListener(new AppPreference.2(this));
    }
    TextView localTextView = (TextView)paramView.findViewById(2131821495);
    if (this.sYN.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.sYS);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131821496);
      paramView.setVisibility(this.sYR);
      paramView.setOnClickListener(this.sYQ);
      AppMethodBeat.o(25444);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(25447);
    if (this.sYN != null) {
      al.cac().remove(this.sYN);
    }
    AppMethodBeat.o(25447);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(25446);
    if (this.sYN != null) {
      al.cac().add(this.sYN);
    }
    AppMethodBeat.o(25446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */