package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class r
  extends LinearLayout
  implements u
{
  private Context context;
  private boolean ctJ;
  private int ctK;
  private String ctV;
  private String dZZ;
  private int kwo;
  r.b rGL;
  private n rGM;
  private r.a rGN;
  private View.OnTouchListener rGO;
  private boolean rGP;
  
  public r(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(38241);
    this.rGL = new r.b(this);
    this.rGM = null;
    this.kwo = 0;
    this.ctV = "";
    this.ctJ = false;
    this.rGO = bo.dtW();
    this.dZZ = "";
    this.rGP = true;
    this.kwo = paramInt;
    this.ctJ = paramBoolean;
    init(paramContext);
    AppMethodBeat.o(38241);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38243);
    this.context = paramContext;
    if (this.kwo == -1)
    {
      AppMethodBeat.o(38243);
      return;
    }
    this.dZZ = com.tencent.mm.model.r.Zn();
    View localView = LayoutInflater.from(paramContext).inflate(2130970824, this, true);
    this.rGL.rGS = ((LinearLayout)localView.findViewById(2131827982));
    this.rGL.rHc = ((LinearLayout)localView.findViewById(2131827976));
    this.rGL.rGV = ((LinearLayout)localView.findViewById(2131827983));
    this.rGL.rGV.setOnTouchListener(this.rGO);
    this.rGL.rGW = ((ImageView)localView.findViewById(2131827984));
    this.rGL.rGX = ((LinearLayout)localView.findViewById(2131827986));
    this.rGL.rGX.setOnTouchListener(this.rGO);
    this.rGL.rGY = ((LinearLayout)localView.findViewById(2131827987));
    this.rGL.rHa = ((TextView)localView.findViewById(2131827988));
    this.rGL.rHb = ((TextView)localView.findViewById(2131827989));
    this.rGL.rGZ = ((TextView)localView.findViewById(2131827985));
    this.rGL.rGT = ((TextView)localView.findViewById(2131827975));
    this.rGL.rGU = ((LinearLayout)localView.findViewById(2131827974));
    this.rGL.hsI = ((TextView)localView.findViewById(2131827979));
    this.rGL.rHg = ((LinearLayout)localView.findViewById(2131827977));
    ((LinearLayout)localView.findViewById(2131827977)).getBackground().setAlpha(50);
    this.rGL.ehv = ((ImageView)localView.findViewById(2131827978));
    this.rGL.rHd = ((ImageView)localView.findViewById(2131827980));
    this.rGL.rHe = ((ImageView)localView.findViewById(2131827981));
    this.rGL.rHf = ((LinearLayout)localView.findViewById(2131827972));
    this.rGL.rHh = ((TextView)localView.findViewById(2131827973));
    if (this.kwo == 2)
    {
      this.rGL.rHc.setVisibility(8);
      this.rGL.rHf.setVisibility(8);
      this.rGL.rGU.setVisibility(0);
    }
    for (;;)
    {
      this.rGL.rGV.setOnClickListener(new r.1(this));
      this.rGL.rGX.setOnClickListener(new r.2(this, paramContext));
      this.rGL.rGY.setOnClickListener(new r.3(this, paramContext));
      this.rGL.rGT.setOnClickListener(new r.4(this));
      this.rGL.rHh.setOnClickListener(new r.5(this));
      AppMethodBeat.o(38243);
      return;
      if (this.kwo == 3)
      {
        this.rGL.rHc.setVisibility(8);
        this.rGL.rGU.setVisibility(8);
        this.rGL.rHf.setVisibility(0);
      }
      else
      {
        this.rGL.rHc.setVisibility(0);
        this.rGL.rGU.setVisibility(8);
        this.rGL.rHf.setVisibility(8);
      }
    }
  }
  
  public final void abX(String paramString)
  {
    AppMethodBeat.i(38246);
    setFooter(paramString);
    AppMethodBeat.o(38246);
  }
  
  public final int getFooterH()
  {
    AppMethodBeat.i(38247);
    if (this.rGL.rGS != null)
    {
      int i = this.rGL.rGS.getHeight();
      AppMethodBeat.o(38247);
      return i;
    }
    AppMethodBeat.o(38247);
    return 10;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(38244);
    if (this.kwo == -1)
    {
      AppMethodBeat.o(38244);
      return;
    }
    this.rGM = ag.cpf().abv(this.ctV);
    if ((bo.isNullOrNil(this.ctV)) || (this.rGM == null))
    {
      AppMethodBeat.o(38244);
      return;
    }
    this.rGL.rHe.setVisibility(8);
    if (ak.ad(this.rGM.field_localPrivate, this.ctJ))
    {
      this.rGL.rGX.setVisibility(8);
      this.rGL.rGV.setVisibility(8);
      localObject = ak.q(this.rGM);
      if (localObject != null)
      {
        if (this.rGM.csG())
        {
          int i = ((SnsObject)localObject).CommentCount;
          if (i <= 0) {
            break label506;
          }
          this.rGL.rHb.setText(String.valueOf(i));
          this.rGL.rHb.setVisibility(0);
          label165:
          int j = ((SnsObject)localObject).LikeCount;
          if (j <= 0) {
            break label521;
          }
          this.rGL.rHa.setText(String.valueOf(j));
          this.rGL.rHa.setVisibility(0);
          label199:
          ab.d("MicroMsg.GalleryFooter", "commentCount " + i + " " + j);
          if (this.rGM.field_likeFlag != 1) {
            break label536;
          }
          localObject = getResources().getString(2131303826);
          this.rGL.rGZ.setText((CharSequence)localObject);
          this.rGL.rGW.setImageResource(2131231358);
        }
        label278:
        if ((this.dZZ.equals(this.rGM.field_userName)) || (!this.ctJ)) {
          break label577;
        }
        this.rGL.ehv.setVisibility(0);
        a.b.c(this.rGL.ehv, this.rGM.field_userName);
      }
    }
    for (;;)
    {
      if (this.rGM.csh() != null) {
        break label592;
      }
      this.rGL.hsI.setVisibility(8);
      AppMethodBeat.o(38244);
      return;
      if (!this.rGM.csG())
      {
        this.rGL.rHg.setVisibility(0);
        this.rGL.rHc.setVisibility(0);
        this.rGL.rGS.setVisibility(8);
        this.rGL.rGY.setVisibility(8);
        this.rGL.rGX.setVisibility(8);
        this.rGL.rGV.setVisibility(8);
        break;
      }
      if (this.rGP) {
        this.rGL.rGS.setVisibility(0);
      }
      this.rGL.rGY.setVisibility(0);
      this.rGL.rGX.setVisibility(0);
      this.rGL.rGV.setVisibility(0);
      this.rGL.rHc.setVisibility(0);
      break;
      label506:
      this.rGL.rHb.setVisibility(8);
      break label165;
      label521:
      this.rGL.rHa.setVisibility(8);
      break label199;
      label536:
      localObject = getResources().getString(2131303827);
      this.rGL.rGZ.setText(String.valueOf(localObject));
      this.rGL.rGW.setImageResource(2131231359);
      break label278;
      label577:
      this.rGL.ehv.setVisibility(8);
    }
    label592:
    Object localObject = this.rGM.csh().xTP;
    if ((localObject == null) || (((String)localObject).equals("")))
    {
      this.rGL.hsI.setText("");
      this.rGL.hsI.setVisibility(8);
      if (!ak.ad(this.rGM.field_localPrivate, this.ctJ)) {
        break label796;
      }
      this.rGL.rHd.setVisibility(0);
      this.rGL.hsI.setVisibility(0);
    }
    for (;;)
    {
      if ((this.ctJ) && (this.rGM.csJ()))
      {
        this.rGL.rGY.setVisibility(0);
        this.rGL.hsI.setVisibility(0);
        this.rGL.rHe.setVisibility(0);
      }
      AppMethodBeat.o(38244);
      return;
      this.rGL.hsI.setText(j.b(getContext(), (String)localObject + " ", this.rGL.hsI.getTextSize()));
      this.rGL.hsI.setVisibility(0);
      break;
      label796:
      this.rGL.rHd.setVisibility(8);
    }
  }
  
  public final void setCallBack(r.a parama)
  {
    this.rGN = parama;
  }
  
  public final void setFooter(String paramString)
  {
    AppMethodBeat.i(38245);
    this.ctV = paramString;
    refresh();
    AppMethodBeat.o(38245);
  }
  
  public final void setSnsSource(int paramInt)
  {
    this.ctK = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    AppMethodBeat.i(38242);
    this.kwo = paramInt;
    init(this.context);
    AppMethodBeat.o(38242);
  }
  
  public final void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(38240);
    if ((this.kwo == 2) || (this.kwo == 3))
    {
      super.setVisibility(paramInt);
      if (paramInt == 8) {}
      for (;;)
      {
        this.rGP = bool;
        AppMethodBeat.o(38240);
        return;
        bool = true;
      }
    }
    if ((this.rGM != null) && (!this.rGM.csG()))
    {
      AppMethodBeat.o(38240);
      return;
    }
    if (paramInt == 8)
    {
      this.rGL.rGS.setVisibility(8);
      this.rGP = false;
      AppMethodBeat.o(38240);
      return;
    }
    if (paramInt == 0)
    {
      this.rGL.rGS.setVisibility(0);
      this.rGP = true;
    }
    AppMethodBeat.o(38240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r
 * JD-Core Version:    0.7.0.1
 */