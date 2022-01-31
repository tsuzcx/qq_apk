package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class a
{
  public String ctV;
  boolean eRq;
  private String hpq;
  public int jgE;
  int position;
  int qYA;
  private int qYB;
  int qYC;
  private int qYD;
  long qYE;
  long qYF;
  private int qYG;
  private int qYH;
  long qYI;
  private int qYJ;
  private int qYK;
  long qYL;
  private int qYM;
  private int qYN;
  long qYO;
  private int qYP;
  private int qYQ;
  long qYR;
  int qYS;
  int qYT;
  int qYU;
  int qYV;
  int qYW;
  int qYX;
  boolean qYn;
  public View qYo;
  public View qYp;
  public int qYq;
  public int qYr;
  public int qYs;
  private View qYt;
  private int qYu;
  private int qYv;
  public String qYw;
  long qYx;
  private com.tencent.mm.plugin.sns.storage.a qYy;
  b qYz;
  public int sceneType;
  public SnsObject snsobj;
  
  public a(com.tencent.mm.plugin.sns.storage.a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, b paramb)
  {
    AppMethodBeat.i(35701);
    this.qYn = false;
    this.sceneType = 1;
    this.position = 0;
    this.qYq = 0;
    this.jgE = 0;
    this.qYr = 0;
    this.qYu = 0;
    this.qYw = "";
    this.qYx = 0L;
    this.qYy = null;
    this.hpq = "";
    this.qYA = -10086;
    this.qYB = -10086;
    this.qYC = -10086;
    this.qYD = -10086;
    this.qYE = 0L;
    this.qYF = 0L;
    this.qYG = -10086;
    this.qYH = -10086;
    this.qYI = 0L;
    this.qYJ = -10086;
    this.qYK = -10086;
    this.qYL = 0L;
    this.qYM = -10086;
    this.qYN = -10086;
    this.qYO = 0L;
    this.qYP = -10086;
    this.qYQ = -10086;
    this.qYR = 0L;
    this.qYS = 0;
    this.qYT = -1;
    this.qYU = -1;
    this.qYV = 0;
    this.qYW = 0;
    this.eRq = false;
    this.qYX = 0;
    this.ctV = "";
    this.position = paramInt4;
    this.qYo = paramView1;
    this.snsobj = paramSnsObject;
    this.qYz = paramb;
    this.qYy = parama;
    this.sceneType = paramInt3;
    if (parama == null)
    {
      paramView1 = "";
      this.hpq = paramView1;
      if (parama != null) {
        break label354;
      }
    }
    label354:
    for (parama = "";; parama = com.tencent.mm.sdk.platformtools.bo.bf(parama.cFe, ""))
    {
      this.qYw = parama;
      this.ctV = paramString;
      this.qYx = paramLong;
      this.qYs = paramInt1;
      this.qYt = paramView2;
      this.qYu = paramInt2;
      if (this.qYo != null) {
        this.qYp = this.qYo.findViewById(2131828126);
      }
      initView();
      AppMethodBeat.o(35701);
      return;
      paramView1 = com.tencent.mm.sdk.platformtools.bo.bf(parama.hpq, "");
      break;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(35702);
    if ((this.jgE == 0) && (this.qYo != null))
    {
      this.jgE = this.qYo.getHeight();
      if (this.qYp != null) {
        this.qYq = this.qYp.getHeight();
      }
      if (this.jgE == 0)
      {
        AppMethodBeat.o(35702);
        return;
      }
      this.qYv = 0;
      if (this.qYt != null) {
        this.qYv = this.qYt.getBottom();
      }
      this.jgE -= this.qYq;
      this.qYr = (this.jgE / 2);
      this.qYs = (this.qYs - this.qYv - this.qYu);
      ab.i("MicroMsg.AdViewStatic", "viewHeight " + this.jgE + " SCREEN_HEIGHT: " + this.qYs + " abottom: " + this.qYv + " stHeight: " + this.qYu + " commentViewHeight:" + this.qYq);
    }
    AppMethodBeat.o(35702);
  }
  
  public final com.tencent.mm.protocal.protobuf.bo cnD()
  {
    AppMethodBeat.i(35704);
    com.tencent.mm.protocal.protobuf.bo localbo = new com.tencent.mm.protocal.protobuf.bo();
    Object localObject = ag.cpf().lZ(this.qYx);
    if (localObject != null)
    {
      localObject = ak.q((n)localObject);
      if (localObject != null)
      {
        localbo.wof = ((SnsObject)localObject).CommentUserList.size();
        localbo.woe = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(35704);
        return localbo;
      }
    }
    if (this.snsobj != null)
    {
      localbo.wof = this.snsobj.CommentUserListCount;
      localbo.woe = this.snsobj.LikeUserListCount;
      AppMethodBeat.o(35704);
      return localbo;
    }
    AppMethodBeat.o(35704);
    return null;
  }
  
  public final boolean cnE()
  {
    return this.qYX == 1;
  }
  
  public final void kY(boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(35703);
    Object localObject;
    int m;
    int k;
    int n;
    int i1;
    if (this.qYo != null)
    {
      initView();
      if ((this.eRq) || (this.jgE <= 0))
      {
        AppMethodBeat.o(35703);
        return;
      }
      this.qYn = true;
      localObject = new int[2];
      this.qYo.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.qYv - this.qYu;
      k = m + this.jgE;
      if ((m < 0) || (k < 0) || (k > this.qYs)) {
        break label1088;
      }
      this.qYX = 1;
      if ((this.qYA == -10086) && (this.qYB == -10086))
      {
        this.qYA = m;
        this.qYB = k;
      }
      this.qYC = m;
      this.qYD = k;
      ab.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.qYr + "| " + (this.jgE + m) + "  firsttop " + this.qYA + " endtop " + this.qYC);
      if (m < 0)
      {
        n = m + this.jgE;
        i1 = this.jgE - n;
        ab.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        if ((n < this.qYr) || (this.qYG != -10086)) {
          break label1159;
        }
        this.qYG = m;
        this.qYH = k;
        this.qYI = System.currentTimeMillis();
        ab.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.jgE + " inscreenval: " + n + " outscreenval: " + i1);
      }
    }
    label1152:
    label1159:
    for (int i = 0;; i = 1)
    {
      if ((i1 >= this.qYr) && (this.qYJ == -10086) && (i != 0) && (this.qYI > 0L))
      {
        this.qYJ = m;
        this.qYK = k;
        this.qYL = System.currentTimeMillis();
        ab.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.jgE + " inscreenval: " + n + " outscreenval: " + i1);
      }
      if (k > this.qYs)
      {
        n = k - this.qYs;
        i1 = this.jgE - n;
        ab.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.qYr)
        {
          i = j;
          if (this.qYG == -10086)
          {
            this.qYG = m;
            this.qYH = k;
            this.qYI = System.currentTimeMillis();
            ab.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.jgE + " inscreenval: " + i1 + " outscreenval: " + n);
            i = 0;
          }
        }
        if ((n >= this.qYr) && (this.qYJ == -10086) && (i != 0) && (this.qYI > 0L))
        {
          this.qYJ = m;
          this.qYK = k;
          this.qYL = System.currentTimeMillis();
          ab.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.jgE + " inscreenval: " + i1 + " outscreenval: " + n);
        }
      }
      label885:
      StringBuilder localStringBuilder;
      if ((m >= 0) && (k <= this.qYs))
      {
        if (this.qYO == 0L)
        {
          this.qYM = m;
          this.qYN = k;
          this.qYO = System.currentTimeMillis();
        }
        if (m >= 0) {
          break label1136;
        }
        i = -m;
        if ((this.qYT == -1) || (this.qYT > i)) {
          this.qYT = i;
        }
        label915:
        if (k <= this.qYs) {
          break label1144;
        }
        i = k - this.qYs;
        if ((this.qYU == -1) || (this.qYU > i)) {
          this.qYU = i;
        }
        label953:
        j = this.jgE;
        i = j;
        if (m < 0) {
          i = j + m;
        }
        j = i;
        if (k > this.qYs) {
          j = i - (k - this.qYs);
        }
        if ((this.qYS == -1) || (this.qYS < j)) {
          this.qYS = j;
        }
        localStringBuilder = new StringBuilder("unreadtop: ").append(this.qYT).append(" unreadBottom:").append(this.qYU).append(" readHeight: ").append(this.qYS);
        if (!paramBoolean) {
          break label1152;
        }
      }
      for (localObject = " isScrooIde";; localObject = "")
      {
        ab.i("MicroMsg.AdViewStatic", (String)localObject);
        AppMethodBeat.o(35703);
        return;
        label1088:
        this.qYX = 0;
        break;
        if ((this.qYR != 0L) || (this.qYO == 0L)) {
          break label885;
        }
        this.qYP = m;
        this.qYQ = k;
        this.qYR = System.currentTimeMillis();
        break label885;
        label1136:
        this.qYT = 0;
        break label915;
        label1144:
        this.qYU = 0;
        break label953;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.a
 * JD-Core Version:    0.7.0.1
 */