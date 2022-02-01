package com.tencent.mm.plugin.sns.ad.d;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
{
  public String dgl;
  private String dyy;
  public int fMu;
  boolean gNN;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  private View xIA;
  private int xIB;
  private int xIC;
  public String xID;
  long xIE;
  private a xIF;
  b xIG;
  int xIH;
  private int xII;
  int xIJ;
  private int xIK;
  long xIL;
  long xIM;
  private int xIN;
  private int xIO;
  long xIP;
  private int xIQ;
  private int xIR;
  long xIS;
  private int xIT;
  private int xIU;
  long xIV;
  private int xIW;
  private int xIX;
  long xIY;
  int xIZ;
  boolean xIu;
  public View xIv;
  public View xIw;
  public int xIx;
  public int xIy;
  public int xIz;
  int xJa;
  int xJb;
  int xJc;
  int xJd;
  int xJe;
  boolean xJf;
  
  public c(a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, b paramb)
  {
    AppMethodBeat.i(94975);
    this.xIu = false;
    this.sceneType = 1;
    this.position = 0;
    this.xIx = 0;
    this.fMu = 0;
    this.xIy = 0;
    this.xIB = 0;
    this.xID = "";
    this.xIE = 0L;
    this.xIF = null;
    this.dyy = "";
    this.xIH = -10086;
    this.xII = -10086;
    this.xIJ = -10086;
    this.xIK = -10086;
    this.xIL = 0L;
    this.xIM = 0L;
    this.xIN = -10086;
    this.xIO = -10086;
    this.xIP = 0L;
    this.xIQ = -10086;
    this.xIR = -10086;
    this.xIS = 0L;
    this.xIT = -10086;
    this.xIU = -10086;
    this.xIV = 0L;
    this.xIW = -10086;
    this.xIX = -10086;
    this.xIY = 0L;
    this.xIZ = 0;
    this.xJa = -1;
    this.xJb = -1;
    this.xJc = 0;
    this.xJd = 0;
    this.gNN = false;
    this.xJe = 0;
    this.dgl = "";
    this.xJf = false;
    this.position = paramInt4;
    this.xIv = paramView1;
    this.snsobj = paramSnsObject;
    this.xIG = paramb;
    this.xIF = parama;
    this.sceneType = paramInt3;
    if (parama == null)
    {
      paramView1 = "";
      this.dyy = paramView1;
      if (parama != null) {
        break label359;
      }
    }
    label359:
    for (parama = "";; parama = bs.bG(parama.dtx, ""))
    {
      this.xID = parama;
      this.dgl = paramString;
      this.xIE = paramLong;
      this.xIz = paramInt1;
      this.xIA = paramView2;
      this.xIB = paramInt2;
      if (this.xIv != null) {
        this.xIw = this.xIv.findViewById(2131296590);
      }
      initView();
      AppMethodBeat.o(94975);
      return;
      paramView1 = bs.bG(parama.dyy, "");
      break;
    }
  }
  
  private void hg(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.xIy)
    {
      this.xJf = true;
      i = 0;
    }
    if ((paramInt2 >= this.xIy) && (i != 0)) {
      this.xJf = false;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.fMu == 0) && (this.xIv != null))
    {
      this.fMu = this.xIv.getHeight();
      if ((this.xIw != null) && (this.xIw.getVisibility() == 0)) {
        this.xIx = this.xIw.getHeight();
      }
      if (this.fMu == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.xIC = 0;
      if (this.xIA != null) {
        this.xIC = this.xIA.getBottom();
      }
      this.fMu -= this.xIx;
      this.xIy = (this.fMu / 2);
      this.xIz = (this.xIz - this.xIC - this.xIB);
      ac.i("MicroMsg.AdViewStatic", "viewHeight " + this.fMu + " SCREEN_HEIGHT: " + this.xIz + " abottom: " + this.xIC + " stHeight: " + this.xIB + " commentViewHeight:" + this.xIx);
    }
    AppMethodBeat.o(94976);
  }
  
  public final bw dFF()
  {
    AppMethodBeat.i(94978);
    bw localbw = new bw();
    Object localObject = af.dHR().xK(this.xIE);
    if (localObject != null)
    {
      localObject = aj.t((p)localObject);
      if (localObject != null)
      {
        localbw.DPk = ((SnsObject)localObject).CommentUserList.size();
        localbw.DPj = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localbw;
      }
    }
    if (this.snsobj != null)
    {
      localbw.DPk = this.snsobj.CommentUserListCount;
      localbw.DPj = this.snsobj.LikeUserListCount;
      AppMethodBeat.o(94978);
      return localbw;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean dFG()
  {
    return this.xJe == 1;
  }
  
  public final void qF(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.xIv != null)
    {
      initView();
      if ((this.gNN) || (this.fMu <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.xIu = true;
      localObject = new int[2];
      this.xIv.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.xIC - this.xIB;
      k = m + this.fMu;
      if ((m < 0) || (k < 0) || (k > this.xIz)) {
        break label1310;
      }
      this.xJe = 1;
      if ((this.xIH == -10086) && (this.xII == -10086))
      {
        this.xIH = m;
        this.xII = k;
      }
      this.xIJ = m;
      this.xIK = k;
      ac.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.xIy + "| " + (this.fMu + m) + "  firsttop " + this.xIH + " endtop " + this.xIJ);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.fMu;
        i1 = this.fMu - n;
        ac.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.xIy)
        {
          i = j;
          if (this.xIN == -10086)
          {
            this.xIN = m;
            this.xIO = k;
            this.xIP = System.currentTimeMillis();
            i = 0;
            ac.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.fMu + " inscreenval: " + n + " outscreenval: " + i1);
            ac.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.xIP + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.xIy) && (this.xIQ == -10086) && (i != 0) && (this.xIP > 0L))
        {
          this.xIQ = m;
          this.xIR = k;
          this.xIS = System.currentTimeMillis();
          ac.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.fMu + " inscreenval: " + n + " outscreenval: " + i1);
          ac.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.xIS - this.xIP) + ", hash=" + hashCode());
        }
        hg(n, i1);
      }
      if (k > this.xIz)
      {
        j = 1;
        n = k - this.xIz;
        i1 = this.fMu - n;
        ac.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.xIy)
        {
          i = j;
          if (this.xIN == -10086)
          {
            this.xIN = m;
            this.xIO = k;
            this.xIP = System.currentTimeMillis();
            i = 0;
            ac.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.fMu + " inscreenval: " + i1 + " outscreenval: " + n);
            ac.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.xIP + ", hash=" + hashCode());
          }
        }
        if ((n >= this.xIy) && (this.xIQ == -10086) && (i != 0) && (this.xIP > 0L))
        {
          this.xIQ = m;
          this.xIR = k;
          this.xIS = System.currentTimeMillis();
          ac.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.fMu + " inscreenval: " + i1 + " outscreenval: " + n);
          ac.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.xIS - this.xIP) + ", hash=" + hashCode());
        }
        hg(i1, n);
      }
      if ((m < 0) || (k > this.xIz)) {
        break label1318;
      }
      if (this.xIV == 0L)
      {
        this.xIT = m;
        this.xIU = k;
        this.xIV = System.currentTimeMillis();
        ac.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.xIV + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.xJa == -1) || (this.xJa > i)) {
        this.xJa = i;
      }
      if (k <= this.xIz) {
        break label1409;
      }
      i = k - this.xIz;
      if ((this.xJb == -1) || (this.xJb > i)) {
        this.xJb = i;
      }
      label1175:
      int j = this.fMu;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.xIz) {
        j = i - (k - this.xIz);
      }
      if ((this.xIZ == -1) || (this.xIZ < j)) {
        this.xIZ = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.xJa).append(" unreadBottom:").append(this.xJb).append(" readHeight: ").append(this.xIZ);
      if (!paramBoolean) {
        break label1417;
      }
    }
    label1409:
    label1417:
    for (Object localObject = " isScrooIde";; localObject = "")
    {
      ac.i("MicroMsg.AdViewStatic", (String)localObject);
      AppMethodBeat.o(94977);
      return;
      label1310:
      this.xJe = 0;
      break;
      label1318:
      if ((this.xIY != 0L) || (this.xIV == 0L)) {
        break label1107;
      }
      this.xIW = m;
      this.xIX = k;
      this.xIY = System.currentTimeMillis();
      ac.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.xIY - this.xIV) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.xJa = 0;
      break label1137;
      this.xJb = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.c
 * JD-Core Version:    0.7.0.1
 */