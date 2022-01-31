package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.d.a.d;
import com.tencent.mm.plugin.d.a.f;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.c;

final class AppChooserUI$e
{
  DialogInterface.OnDismissListener Oj;
  public c fvH;
  BaseAdapter iqN;
  Context mContext;
  String mTitle;
  DialogInterface.OnClickListener slg;
  ListViewInScrollView sls;
  AdapterView.OnItemClickListener slt;
  DialogInterface.OnClickListener slu;
  
  public AppChooserUI$e(AppChooserUI paramAppChooserUI, Context paramContext)
  {
    this.mContext = paramContext;
    this.sls = ((ListViewInScrollView)View.inflate(this.mContext, a.d.app_choose_layout, null));
  }
  
  public final void mg(boolean paramBoolean)
  {
    if (this.fvH != null)
    {
      if (!paramBoolean)
      {
        this.fvH.a(a.f.app_use_once, null);
        this.fvH.b(a.f.app_use_always, null);
      }
    }
    else {
      return;
    }
    this.fvH.a(a.f.app_use_once, this.slg);
    this.fvH.b(a.f.app_use_always, this.slu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.e
 * JD-Core Version:    0.7.0.1
 */