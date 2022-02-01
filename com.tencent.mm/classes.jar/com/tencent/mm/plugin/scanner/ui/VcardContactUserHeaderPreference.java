package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;

public class VcardContactUserHeaderPreference
  extends Preference
{
  String CHK;
  private ImageView COW;
  private TextView COX;
  private TextView COY;
  private TextView COZ;
  private TextView CPa;
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
    this.COW = ((ImageView)paramView.findViewById(2131309677));
    this.COX = ((TextView)paramView.findViewById(2131309678));
    if (this.fullName != null) {
      this.COX.setText(this.fullName);
    }
    this.COY = ((TextView)paramView.findViewById(2131309679));
    if (this.nickName != null)
    {
      this.COY.setText(this.context.getString(2131767000, new Object[] { this.nickName }));
      this.COY.setVisibility(0);
    }
    this.COZ = ((TextView)paramView.findViewById(2131309680));
    if (this.CHK != null)
    {
      this.COZ.setText(this.context.getString(2131767005, new Object[] { this.CHK }));
      this.COZ.setVisibility(0);
    }
    this.CPa = ((TextView)paramView.findViewById(2131309681));
    if (this.title != null)
    {
      this.CPa.setText(this.context.getString(2131767006, new Object[] { this.title }));
      this.CPa.setVisibility(0);
    }
    AppMethodBeat.o(52014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUserHeaderPreference
 * JD-Core Version:    0.7.0.1
 */