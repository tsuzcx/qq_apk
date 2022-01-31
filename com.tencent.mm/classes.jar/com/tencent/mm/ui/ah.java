package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;

public final class ah
  extends LinearLayout
{
  private String frh;
  private ImageButton kjB;
  private ImageView kjC;
  private Context mContext;
  private EditText uQB;
  private ah.a uQC;
  
  public ah(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(a.g.actionbar_search, this, true);
    this.kjC = ((ImageView)findViewById(a.f.actionbar_up_indicator_btn));
    this.kjC.setOnClickListener(new ah.1(this));
    this.uQB = ((EditText)findViewById(a.f.search_edit));
    this.uQB.requestFocus();
    this.kjB = ((ImageButton)findViewById(a.f.clear_btn));
    this.kjB.setOnClickListener(new ah.2(this));
    this.uQB.addTextChangedListener(new ah.3(this));
  }
  
  public final EditText getSearchEditText()
  {
    return this.uQB;
  }
  
  public final void setHint(String paramString)
  {
    this.frh = paramString;
  }
  
  public final void setSearchViewListener(ah.a parama)
  {
    this.uQC = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */