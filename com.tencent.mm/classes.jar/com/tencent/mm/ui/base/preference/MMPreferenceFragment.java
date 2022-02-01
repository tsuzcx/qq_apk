package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.ui.MMFragment;

public abstract class MMPreferenceFragment
  extends MMFragment
{
  private int Wso = 0;
  private int Wsp = 0;
  private boolean Wsq;
  private h adapter;
  private boolean dirty = false;
  private boolean isRefreshing = false;
  private ListView list;
  private SharedPreferences sp;
  
  public int getLayoutId()
  {
    return a.h.mm_preference_fragment_list_content;
  }
  
  public View getLayoutView()
  {
    b.aIK();
    return b.d(getContext(), a.h.mm_preference_fragment_list_content);
  }
  
  public final ListView getListView()
  {
    return this.list;
  }
  
  public final f getPreferenceScreen()
  {
    return this.adapter;
  }
  
  public abstract int getResourceId();
  
  public final void hKS()
  {
    if (this.Wsq) {}
    int i;
    do
    {
      return;
      i = getResourceId();
    } while (i == -1);
    this.adapter.auC(i);
    this.Wsq = true;
  }
  
  public final boolean hKT()
  {
    return this.Wsq;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.Wsq = false;
    this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.list = ((ListView)findViewById(16908298));
    this.adapter = new h(getContext(), this.list, this.sp);
    this.adapter.b(new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        AppMethodBeat.i(142614);
        if ((!MMPreferenceFragment.a(MMPreferenceFragment.this)) && (paramAnonymousPreference.isEnabled()) && (paramAnonymousPreference.WsD))
        {
          MMPreferenceFragment.a(MMPreferenceFragment.this, true);
          if (!(paramAnonymousPreference instanceof CheckBoxPreference)) {
            break label170;
          }
          paramAnonymousObject = (CheckBoxPreference)paramAnonymousPreference;
          paramAnonymousObject.setChecked(paramAnonymousObject.isChecked());
          if (paramAnonymousObject.WsF) {
            MMPreferenceFragment.b(MMPreferenceFragment.this).edit().putBoolean(paramAnonymousPreference.mKey, paramAnonymousObject.isChecked()).commit();
          }
          MMPreferenceFragment.c(MMPreferenceFragment.this);
        }
        label170:
        for (int i = 1;; i = 0)
        {
          if (paramAnonymousPreference.mKey != null) {
            MMPreferenceFragment.this.onPreferenceTreeClick(MMPreferenceFragment.d(MMPreferenceFragment.this), paramAnonymousPreference);
          }
          if (i != 0) {
            MMPreferenceFragment.d(MMPreferenceFragment.this).notifyDataSetChanged();
          }
          MMPreferenceFragment.a(MMPreferenceFragment.this, false);
          if (i != 0)
          {
            AppMethodBeat.o(142614);
            return true;
          }
          AppMethodBeat.o(142614);
          return false;
        }
      }
    });
    this.list.setAdapter(this.adapter);
    this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142617);
        if (paramAnonymousInt < MMPreferenceFragment.e(MMPreferenceFragment.this).getHeaderViewsCount())
        {
          AppMethodBeat.o(142617);
          return;
        }
        int i = MMPreferenceFragment.e(MMPreferenceFragment.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (Preference)MMPreferenceFragment.d(MMPreferenceFragment.this).getItem(paramAnonymousInt - i);
        if ((paramAnonymousAdapterView.isEnabled()) && (paramAnonymousAdapterView.WsD))
        {
          if ((paramAnonymousAdapterView instanceof CheckBoxPreference))
          {
            AppMethodBeat.o(142617);
            return;
          }
          if ((paramAnonymousAdapterView instanceof DialogPreference))
          {
            paramAnonymousView = (DialogPreference)paramAnonymousAdapterView;
            paramAnonymousView.elK();
            paramAnonymousView.WqL = new DialogPreference.a()
            {
              public final void hKF()
              {
                AppMethodBeat.i(142615);
                MMPreferenceFragment.c(MMPreferenceFragment.this);
                if (paramAnonymousView.WsF) {
                  MMPreferenceFragment.b(MMPreferenceFragment.this).edit().putString(paramAnonymousAdapterView.mKey, paramAnonymousView.getValue()).commit();
                }
                MMPreferenceFragment.d(MMPreferenceFragment.this).notifyDataSetChanged();
                AppMethodBeat.o(142615);
              }
            };
          }
          if ((paramAnonymousAdapterView instanceof EditPreference))
          {
            paramAnonymousView = (EditPreference)paramAnonymousAdapterView;
            paramAnonymousView.elK();
            paramAnonymousView.WqN = new EditPreference.a()
            {
              public final void hKF()
              {
                AppMethodBeat.i(142616);
                MMPreferenceFragment.c(MMPreferenceFragment.this);
                if (paramAnonymousView.WsF) {
                  MMPreferenceFragment.b(MMPreferenceFragment.this).edit().putString(paramAnonymousAdapterView.mKey, paramAnonymousView.value).commit();
                }
                MMPreferenceFragment.d(MMPreferenceFragment.this).notifyDataSetChanged();
                AppMethodBeat.o(142616);
              }
            };
          }
          if (paramAnonymousAdapterView.mKey != null) {
            MMPreferenceFragment.this.onPreferenceTreeClick(MMPreferenceFragment.d(MMPreferenceFragment.this), paramAnonymousAdapterView);
          }
        }
        AppMethodBeat.o(142617);
      }
    });
    this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142618);
        if (paramAnonymousInt < MMPreferenceFragment.e(MMPreferenceFragment.this).getHeaderViewsCount())
        {
          AppMethodBeat.o(142618);
          return false;
        }
        int i = MMPreferenceFragment.e(MMPreferenceFragment.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (Preference)MMPreferenceFragment.d(MMPreferenceFragment.this).getItem(paramAnonymousInt - i);
        boolean bool = MMPreferenceFragment.this.onPreferenceTreeLongClick(MMPreferenceFragment.d(MMPreferenceFragment.this), paramAnonymousAdapterView, MMPreferenceFragment.e(MMPreferenceFragment.this));
        AppMethodBeat.o(142618);
        return bool;
      }
    });
    if (this.Wsp != 0) {
      this.list.setSelectionFromTop(0, this.Wsp);
    }
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public abstract boolean onPreferenceTreeClick(f paramf, Preference paramPreference);
  
  public boolean onPreferenceTreeLongClick(f paramf, Preference paramPreference, View paramView)
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.adapter != null) {
      this.adapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.MMPreferenceFragment
 * JD-Core Version:    0.7.0.1
 */