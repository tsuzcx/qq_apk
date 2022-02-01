package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference
  extends Preference
{
  private Context context;
  private boolean uwW;
  a zSB;
  AdapterView.OnItemClickListener zSC;
  AdapterView.OnItemClickListener zSD;
  private View.OnClickListener zSE;
  private int zSF;
  private int zSG;
  int zSz;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29137);
    this.zSC = null;
    this.zSD = null;
    this.zSE = null;
    this.zSz = 0;
    this.uwW = false;
    this.zSG = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.zSF = paramContext.getInt(0, 8);
    this.uwW = paramContext.getBoolean(1, false);
    this.zSG = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29137);
  }
  
  public final g Ra(int paramInt)
  {
    AppMethodBeat.i(29139);
    if ((paramInt < 0) || (paramInt >= this.zSB.getCount()))
    {
      AppMethodBeat.o(29139);
      return null;
    }
    g localg = (g)this.zSB.getItem(paramInt);
    AppMethodBeat.o(29139);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29138);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131300620);
    this.zSB = new a(this.context, this.zSz);
    localMMGridView.setAdapter(this.zSB);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29135);
        if (AppPreference.a(AppPreference.this).GF(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).rX(false);
          AppMethodBeat.o(29135);
          return;
        }
        if (AppPreference.a(AppPreference.this).zSy)
        {
          if (AppPreference.b(AppPreference.this) != null)
          {
            AppPreference.b(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            AppMethodBeat.o(29135);
          }
        }
        else if (AppPreference.c(AppPreference.this) != null) {
          AppPreference.c(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(29135);
      }
    });
    if (this.uwW) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29136);
          paramAnonymousAdapterView = AppPreference.this;
          if (paramAnonymousAdapterView.zSB != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.zSB;
            if (paramAnonymousAdapterView.zSB.zSy) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.rX(bool);
            AppMethodBeat.o(29136);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299477);
    if (this.zSB.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.zSG);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297574);
      paramView.setVisibility(this.zSF);
      paramView.setOnClickListener(this.zSE);
      AppMethodBeat.o(29138);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29141);
    if (this.zSB != null) {
      ap.dny().remove(this.zSB);
    }
    AppMethodBeat.o(29141);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29140);
    if (this.zSB != null) {
      ap.dny().add(this.zSB);
    }
    AppMethodBeat.o(29140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */