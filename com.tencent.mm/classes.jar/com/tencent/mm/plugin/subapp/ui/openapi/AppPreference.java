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
  private boolean toE;
  int yFl;
  a yFn;
  AdapterView.OnItemClickListener yFo;
  AdapterView.OnItemClickListener yFp;
  private View.OnClickListener yFq;
  private int yFr;
  private int yFs;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29137);
    this.yFo = null;
    this.yFp = null;
    this.yFq = null;
    this.yFl = 0;
    this.toE = false;
    this.yFs = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.yFr = paramContext.getInt(0, 8);
    this.toE = paramContext.getBoolean(1, false);
    this.yFs = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29137);
  }
  
  public final g OU(int paramInt)
  {
    AppMethodBeat.i(29139);
    if ((paramInt < 0) || (paramInt >= this.yFn.getCount()))
    {
      AppMethodBeat.o(29139);
      return null;
    }
    g localg = (g)this.yFn.getItem(paramInt);
    AppMethodBeat.o(29139);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29138);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131300620);
    this.yFn = new a(this.context, this.yFl);
    localMMGridView.setAdapter(this.yFn);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29135);
        if (AppPreference.a(AppPreference.this).EJ(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).qZ(false);
          AppMethodBeat.o(29135);
          return;
        }
        if (AppPreference.a(AppPreference.this).yFk)
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
    if (this.toE) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29136);
          paramAnonymousAdapterView = AppPreference.this;
          if (paramAnonymousAdapterView.yFn != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.yFn;
            if (paramAnonymousAdapterView.yFn.yFk) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.qZ(bool);
            AppMethodBeat.o(29136);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299477);
    if (this.yFn.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.yFs);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297574);
      paramView.setVisibility(this.yFr);
      paramView.setOnClickListener(this.yFq);
      AppMethodBeat.o(29138);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29141);
    if (this.yFn != null) {
      ap.cZQ().remove(this.yFn);
    }
    AppMethodBeat.o(29141);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29140);
    if (this.yFn != null) {
      ap.cZQ().add(this.yFn);
    }
    AppMethodBeat.o(29140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */