package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class NormalProfileHeaderPreference$a
{
  TextView nIh;
  TextView nzx;
  ImageView pBA;
  ImageView pBB;
  View pBC;
  private ImageView pBD;
  View pBE;
  private View pBF;
  private View pBh;
  private View pBi;
  private View pBj;
  private View pBk;
  private View pBl;
  private View pBm;
  ImageView pBn;
  TextView pBo;
  MMNeat7extView pBp;
  TextView pBq;
  TextView pBr;
  TextView pBs;
  TextView pBt;
  TextView pBu;
  ImageView pBv;
  FMessageListView pBw;
  private View pBx;
  private LinearLayout pBy;
  ImageView pBz;
  
  NormalProfileHeaderPreference$a(NormalProfileHeaderPreference paramNormalProfileHeaderPreference, View paramView)
  {
    AppMethodBeat.i(23655);
    this.pBh = null;
    this.pBi = null;
    this.pBj = null;
    this.pBk = null;
    this.pBl = null;
    this.pBm = null;
    this.pBn = null;
    this.nzx = null;
    this.pBo = null;
    this.pBp = null;
    this.pBq = null;
    this.nIh = null;
    this.pBr = null;
    this.pBs = null;
    this.pBt = null;
    this.pBu = null;
    this.pBv = null;
    this.pBy = null;
    this.pBC = paramView.findViewById(2131823202);
    this.pBw = ((FMessageListView)paramView.findViewById(2131823206));
    this.pBx = paramView.findViewById(2131823205);
    this.pBh = paramView.findViewById(2131823209);
    this.pBi = paramView.findViewById(2131823210);
    this.pBj = paramView.findViewById(2131823207);
    this.pBl = paramView.findViewById(2131823208);
    this.pBm = paramView.findViewById(2131823211);
    this.pBk = paramView.findViewById(2131823213);
    this.pBv = ((ImageView)paramView.findViewById(2131823188));
    this.pBq = ((TextView)paramView.findViewById(2131823196));
    this.pBp = ((MMNeat7extView)paramView.findViewById(2131823189));
    this.nzx = ((TextView)paramView.findViewById(2131823195));
    this.pBo = ((TextView)paramView.findViewById(2131823194));
    this.pBn = ((ImageView)paramView.findViewById(2131823190));
    this.nIh = ((TextView)paramView.findViewById(2131823197));
    this.pBr = ((TextView)paramView.findViewById(2131823198));
    this.pBs = ((TextView)paramView.findViewById(2131823200));
    this.pBt = ((TextView)paramView.findViewById(2131823199));
    this.pBu = ((TextView)paramView.findViewById(2131823201));
    this.pBz = ((ImageView)paramView.findViewById(2131823193));
    this.pBA = ((ImageView)paramView.findViewById(2131823192));
    this.pBB = ((ImageView)paramView.findViewById(2131823191));
    this.pBD = ((ImageView)paramView.findViewById(2131823185));
    this.pBE = paramView.findViewById(2131823184);
    this.pBF = paramView.findViewById(2131823187);
    this.pBy = ((LinearLayout)paramView.findViewById(2131823186));
    this.pBC.findViewById(2131823203).setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBC.findViewById(2131823204).setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBm.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBk.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBv.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBh.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBi.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBj.setOnClickListener(paramNormalProfileHeaderPreference);
    this.pBl.setOnClickListener(paramNormalProfileHeaderPreference);
    this.nIh.setOnTouchListener(new NormalProfileHeaderPreference.a.1(this, paramNormalProfileHeaderPreference));
    this.nIh.setOnLongClickListener(paramNormalProfileHeaderPreference);
    this.pBD.setOnClickListener(paramNormalProfileHeaderPreference);
    AppMethodBeat.o(23655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.a
 * JD-Core Version:    0.7.0.1
 */