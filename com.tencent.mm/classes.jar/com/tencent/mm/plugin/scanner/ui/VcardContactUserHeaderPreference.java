package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String IMW;
  private TextView IUA;
  private TextView IUB;
  private TextView IUC;
  private ImageView IUy;
  private TextView IUz;
  private final Context context;
  String fullName;
  String nickName;
  String title;
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public VcardContactUserHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(52014);
    super.onBindView(paramView);
    Log.e("MicroMsg.scanner.VcardContactUserHeaderPreference", "onbindview");
    this.IUy = ((ImageView)paramView.findViewById(l.f.IDN));
    this.IUz = ((TextView)paramView.findViewById(l.f.IDO));
    if (this.fullName != null) {
      this.IUz.setText(this.fullName);
    }
    this.IUA = ((TextView)paramView.findViewById(l.f.IDP));
    if (this.nickName != null)
    {
      this.IUA.setText(this.context.getString(l.i.IFC, new Object[] { this.nickName }));
      this.IUA.setVisibility(0);
    }
    this.IUB = ((TextView)paramView.findViewById(l.f.IDQ));
    if (this.IMW != null)
    {
      this.IUB.setText(this.context.getString(l.i.IFE, new Object[] { this.IMW }));
      this.IUB.setVisibility(0);
    }
    this.IUC = ((TextView)paramView.findViewById(l.f.IDR));
    if (this.title != null)
    {
      this.IUC.setText(this.context.getString(l.i.IFF, new Object[] { this.title }));
      this.IUC.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */