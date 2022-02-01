package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactSocialInfoPreference
  extends Preference
{
  private TextView oOh;
  private int xgA;
  private ImageView xgp;
  private ImageView xgq;
  private ImageView xgr;
  private ImageView xgs;
  private ImageView xgt;
  private ImageView xgu;
  private int xgv;
  private int xgw;
  private int xgx;
  private int xgy;
  private int xgz;
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.xgv = 8;
    this.xgw = 8;
    this.xgx = 8;
    this.xgy = 8;
    this.xgz = 8;
    this.xgA = 8;
  }
  
  public ContactSocialInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27047);
    this.xgv = 8;
    this.xgw = 8;
    this.xgx = 8;
    this.xgy = 8;
    this.xgz = 8;
    this.xgA = 8;
    setLayoutResource(2131494804);
    AppMethodBeat.o(27047);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(27055);
    if (this.xgp != null) {
      this.xgp.setVisibility(this.xgv);
    }
    if (this.xgq != null) {
      this.xgq.setVisibility(this.xgw);
    }
    if (this.xgr != null) {
      this.xgr.setVisibility(this.xgx);
    }
    if (this.xgs != null) {
      this.xgs.setVisibility(this.xgy);
    }
    if (this.xgt != null) {
      this.xgt.setVisibility(this.xgz);
    }
    if (this.oOh != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.oOh.getLayoutParams();
      localLayoutParams.width = a.ax(this.mContext, 2131165370);
      this.oOh.setLayoutParams(localLayoutParams);
    }
    if (this.xgu != null) {
      this.xgu.setVisibility(this.xgA);
    }
    AppMethodBeat.o(27055);
  }
  
  public final void Ns(int paramInt)
  {
    AppMethodBeat.i(27051);
    this.xgw = paramInt;
    updateView();
    AppMethodBeat.o(27051);
  }
  
  public final void Nt(int paramInt)
  {
    AppMethodBeat.i(27052);
    this.xgx = paramInt;
    updateView();
    AppMethodBeat.o(27052);
  }
  
  public final void Nu(int paramInt)
  {
    AppMethodBeat.i(27053);
    this.xgz = paramInt;
    updateView();
    AppMethodBeat.o(27053);
  }
  
  public final void Nv(int paramInt)
  {
    AppMethodBeat.i(27054);
    this.xgA = paramInt;
    updateView();
    AppMethodBeat.o(27054);
  }
  
  public final void Nw(int paramInt)
  {
    AppMethodBeat.i(27050);
    this.xgv = paramInt;
    updateView();
    AppMethodBeat.o(27050);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27049);
    this.xgp = ((ImageView)paramView.findViewById(2131300953));
    this.xgq = ((ImageView)paramView.findViewById(2131300958));
    this.xgr = ((ImageView)paramView.findViewById(2131300949));
    this.xgs = ((ImageView)paramView.findViewById(2131300927));
    this.xgt = ((ImageView)paramView.findViewById(2131300937));
    this.xgu = ((ImageView)paramView.findViewById(2131300967));
    this.oOh = ((TextView)paramView.findViewById(2131305902));
    updateView();
    super.onBindView(paramView);
    AppMethodBeat.o(27049);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27048);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494848, localViewGroup);
    AppMethodBeat.o(27048);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoPreference
 * JD-Core Version:    0.7.0.1
 */