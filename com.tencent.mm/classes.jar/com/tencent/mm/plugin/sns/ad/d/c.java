package com.tencent.mm.plugin.sns.ad.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
{
  private String aQj;
  public String drH;
  public int gfU;
  boolean hhJ;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  boolean yXJ;
  public View yXK;
  public View yXL;
  public int yXM;
  public int yXN;
  public int yXO;
  private View yXP;
  private int yXQ;
  private int yXR;
  public String yXS;
  long yXT;
  private a yXU;
  b yXV;
  int yXW;
  private int yXX;
  int yXY;
  private int yXZ;
  long yYa;
  long yYb;
  private int yYc;
  private int yYd;
  long yYe;
  private int yYf;
  private int yYg;
  long yYh;
  private int yYi;
  private int yYj;
  long yYk;
  private int yYl;
  private int yYm;
  long yYn;
  int yYo;
  int yYp;
  int yYq;
  int yYr;
  int yYs;
  int yYt;
  boolean yYu;
  
  public c(a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, b paramb)
  {
    AppMethodBeat.i(94975);
    this.yXJ = false;
    this.sceneType = 1;
    this.position = 0;
    this.yXM = 0;
    this.gfU = 0;
    this.yXN = 0;
    this.yXQ = 0;
    this.yXS = "";
    this.yXT = 0L;
    this.yXU = null;
    this.aQj = "";
    this.yXW = -10086;
    this.yXX = -10086;
    this.yXY = -10086;
    this.yXZ = -10086;
    this.yYa = 0L;
    this.yYb = 0L;
    this.yYc = -10086;
    this.yYd = -10086;
    this.yYe = 0L;
    this.yYf = -10086;
    this.yYg = -10086;
    this.yYh = 0L;
    this.yYi = -10086;
    this.yYj = -10086;
    this.yYk = 0L;
    this.yYl = -10086;
    this.yYm = -10086;
    this.yYn = 0L;
    this.yYo = 0;
    this.yYp = -1;
    this.yYq = -1;
    this.yYr = 0;
    this.yYs = 0;
    this.hhJ = false;
    this.yYt = 0;
    this.drH = "";
    this.yYu = false;
    this.position = paramInt4;
    this.yXK = paramView1;
    this.snsobj = paramSnsObject;
    this.yXV = paramb;
    this.yXU = parama;
    this.sceneType = paramInt3;
    if (parama == null)
    {
      paramView1 = "";
      this.aQj = paramView1;
      if (parama != null) {
        break label359;
      }
    }
    label359:
    for (parama = "";; parama = bt.bI(parama.dFy, ""))
    {
      this.yXS = parama;
      this.drH = paramString;
      this.yXT = paramLong;
      this.yXO = paramInt1;
      this.yXP = paramView2;
      this.yXQ = paramInt2;
      if (this.yXK != null) {
        this.yXL = this.yXK.findViewById(2131296590);
      }
      initView();
      AppMethodBeat.o(94975);
      return;
      paramView1 = bt.bI(parama.aQj, "");
      break;
    }
  }
  
  private void hx(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.yXN)
    {
      this.yYu = true;
      i = 0;
    }
    if ((paramInt2 >= this.yXN) && (i != 0)) {
      this.yYu = false;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.gfU == 0) && (this.yXK != null))
    {
      this.gfU = this.yXK.getHeight();
      if ((this.yXL != null) && (this.yXL.getVisibility() == 0)) {
        this.yXM = this.yXL.getHeight();
      }
      if (this.gfU == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.yXR = 0;
      if (this.yXP != null) {
        this.yXR = this.yXP.getBottom();
      }
      this.gfU -= this.yXM;
      this.yXN = (this.gfU / 2);
      this.yXO = (this.yXO - this.yXR - this.yXQ);
      ad.i("MicroMsg.AdViewStatic", "viewHeight " + this.gfU + " SCREEN_HEIGHT: " + this.yXO + " abottom: " + this.yXR + " stHeight: " + this.yXQ + " commentViewHeight:" + this.yXM);
    }
    AppMethodBeat.o(94976);
  }
  
  public final bw dRx()
  {
    AppMethodBeat.i(94978);
    bw localbw = new bw();
    Object localObject = ag.dUe().Ai(this.yXT);
    if (localObject != null)
    {
      localObject = ak.v((p)localObject);
      if (localObject != null)
      {
        localbw.Fuu = ((SnsObject)localObject).CommentUserList.size();
        localbw.Fut = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localbw;
      }
    }
    if (this.snsobj != null)
    {
      localbw.Fuu = this.snsobj.CommentUserListCount;
      localbw.Fut = this.snsobj.LikeUserListCount;
      AppMethodBeat.o(94978);
      return localbw;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean dRy()
  {
    return this.yYt == 1;
  }
  
  public final void ri(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.yXK != null)
    {
      initView();
      if ((this.hhJ) || (this.gfU <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.yXJ = true;
      localObject = new int[2];
      this.yXK.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.yXR - this.yXQ;
      k = m + this.gfU;
      if ((m < 0) || (k < 0) || (k > this.yXO)) {
        break label1310;
      }
      this.yYt = 1;
      if ((this.yXW == -10086) && (this.yXX == -10086))
      {
        this.yXW = m;
        this.yXX = k;
      }
      this.yXY = m;
      this.yXZ = k;
      ad.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.yXN + "| " + (this.gfU + m) + "  firsttop " + this.yXW + " endtop " + this.yXY);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.gfU;
        i1 = this.gfU - n;
        ad.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.yXN)
        {
          i = j;
          if (this.yYc == -10086)
          {
            this.yYc = m;
            this.yYd = k;
            this.yYe = System.currentTimeMillis();
            i = 0;
            ad.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gfU + " inscreenval: " + n + " outscreenval: " + i1);
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.yYe + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.yXN) && (this.yYf == -10086) && (i != 0) && (this.yYe > 0L))
        {
          this.yYf = m;
          this.yYg = k;
          this.yYh = System.currentTimeMillis();
          ad.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gfU + " inscreenval: " + n + " outscreenval: " + i1);
          ad.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.yYh - this.yYe) + ", hash=" + hashCode());
        }
        hx(n, i1);
      }
      if (k > this.yXO)
      {
        j = 1;
        n = k - this.yXO;
        i1 = this.gfU - n;
        ad.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.yXN)
        {
          i = j;
          if (this.yYc == -10086)
          {
            this.yYc = m;
            this.yYd = k;
            this.yYe = System.currentTimeMillis();
            i = 0;
            ad.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gfU + " inscreenval: " + i1 + " outscreenval: " + n);
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.yYe + ", hash=" + hashCode());
          }
        }
        if ((n >= this.yXN) && (this.yYf == -10086) && (i != 0) && (this.yYe > 0L))
        {
          this.yYf = m;
          this.yYg = k;
          this.yYh = System.currentTimeMillis();
          ad.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gfU + " inscreenval: " + i1 + " outscreenval: " + n);
          ad.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.yYh - this.yYe) + ", hash=" + hashCode());
        }
        hx(i1, n);
      }
      if ((m < 0) || (k > this.yXO)) {
        break label1318;
      }
      if (this.yYk == 0L)
      {
        this.yYi = m;
        this.yYj = k;
        this.yYk = System.currentTimeMillis();
        ad.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.yYk + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.yYp == -1) || (this.yYp > i)) {
        this.yYp = i;
      }
      if (k <= this.yXO) {
        break label1409;
      }
      i = k - this.yXO;
      if ((this.yYq == -1) || (this.yYq > i)) {
        this.yYq = i;
      }
      label1175:
      int j = this.gfU;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.yXO) {
        j = i - (k - this.yXO);
      }
      if ((this.yYo == -1) || (this.yYo < j)) {
        this.yYo = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.yYp).append(" unreadBottom:").append(this.yYq).append(" readHeight: ").append(this.yYo);
      if (!paramBoolean) {
        break label1417;
      }
    }
    label1409:
    label1417:
    for (Object localObject = " isScrooIde";; localObject = "")
    {
      ad.i("MicroMsg.AdViewStatic", (String)localObject);
      AppMethodBeat.o(94977);
      return;
      label1310:
      this.yYt = 0;
      break;
      label1318:
      if ((this.yYn != 0L) || (this.yYk == 0L)) {
        break label1107;
      }
      this.yYl = m;
      this.yYm = k;
      this.yYn = System.currentTimeMillis();
      ad.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.yYn - this.yYk) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.yYp = 0;
      break label1137;
      this.yYq = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.c
 * JD-Core Version:    0.7.0.1
 */