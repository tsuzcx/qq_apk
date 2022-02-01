package com.tencent.mm.plugin.sns.ad.e;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  private String aQj;
  public String dsN;
  public int gim;
  boolean hkx;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  private int zoA;
  long zoB;
  long zoC;
  private int zoD;
  private int zoE;
  long zoF;
  private int zoG;
  private int zoH;
  long zoI;
  private int zoJ;
  private int zoK;
  long zoL;
  private int zoM;
  private int zoN;
  long zoO;
  int zoP;
  int zoQ;
  int zoR;
  int zoS;
  int zoT;
  int zoU;
  boolean zoV;
  boolean zok;
  public View zol;
  public View zom;
  public int zon;
  public int zoo;
  public int zop;
  private View zoq;
  private int zor;
  private int zos;
  public String zot;
  long zou;
  private a zov;
  b zow;
  int zox;
  private int zoy;
  int zoz;
  
  public c(a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, b paramb)
  {
    AppMethodBeat.i(94975);
    this.zok = false;
    this.sceneType = 1;
    this.position = 0;
    this.zon = 0;
    this.gim = 0;
    this.zoo = 0;
    this.zor = 0;
    this.zot = "";
    this.zou = 0L;
    this.zov = null;
    this.aQj = "";
    this.zox = -10086;
    this.zoy = -10086;
    this.zoz = -10086;
    this.zoA = -10086;
    this.zoB = 0L;
    this.zoC = 0L;
    this.zoD = -10086;
    this.zoE = -10086;
    this.zoF = 0L;
    this.zoG = -10086;
    this.zoH = -10086;
    this.zoI = 0L;
    this.zoJ = -10086;
    this.zoK = -10086;
    this.zoL = 0L;
    this.zoM = -10086;
    this.zoN = -10086;
    this.zoO = 0L;
    this.zoP = 0;
    this.zoQ = -1;
    this.zoR = -1;
    this.zoS = 0;
    this.zoT = 0;
    this.hkx = false;
    this.zoU = 0;
    this.dsN = "";
    this.zoV = false;
    this.position = paramInt4;
    this.zol = paramView1;
    this.snsobj = paramSnsObject;
    this.zow = paramb;
    this.zov = parama;
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
    for (parama = "";; parama = bu.bI(parama.dGD, ""))
    {
      this.zot = parama;
      this.dsN = paramString;
      this.zou = paramLong;
      this.zop = paramInt1;
      this.zoq = paramView2;
      this.zor = paramInt2;
      if (this.zol != null) {
        this.zom = this.zol.findViewById(2131296590);
      }
      initView();
      AppMethodBeat.o(94975);
      return;
      paramView1 = bu.bI(parama.aQj, "");
      break;
    }
  }
  
  private static int a(SnsObject paramSnsObject)
  {
    int j = 0;
    AppMethodBeat.i(219062);
    if (paramSnsObject == null)
    {
      ae.e("MicroMsg.AdViewStatic", "getReportCommentCount, snsObj==null");
      AppMethodBeat.o(219062);
      return 0;
    }
    LinkedList localLinkedList = paramSnsObject.CommentUserList;
    if (localLinkedList != null)
    {
      Iterator localIterator = localLinkedList.iterator();
      dgh localdgh;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdgh = (dgh)localIterator.next();
      } while ((localdgh == null) || (!e.id(localdgh.HNo, 32)));
    }
    for (int i = 1;; i = 0)
    {
      int k = localLinkedList.size();
      if (i != 0) {}
      for (i = k - 1;; i = k)
      {
        if (i < 0) {
          i = j;
        }
        for (;;)
        {
          ae.i("MicroMsg.AdViewStatic", "getReportCommentCount, snsId=" + r.zV(paramSnsObject.Id) + ", commentList.size=" + localLinkedList.size() + ", commentCount=" + paramSnsObject.CommentUserListCount + ", ret=" + i);
          AppMethodBeat.o(219062);
          return i;
          AppMethodBeat.o(219062);
          return 0;
        }
      }
    }
  }
  
  private void hz(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.zoo)
    {
      this.zoV = true;
      i = 0;
    }
    if ((paramInt2 >= this.zoo) && (i != 0)) {
      this.zoV = false;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.gim == 0) && (this.zol != null))
    {
      this.gim = this.zol.getHeight();
      if ((this.zom != null) && (this.zom.getVisibility() == 0)) {
        this.zon = this.zom.getHeight();
      }
      if (this.gim == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.zos = 0;
      if (this.zoq != null) {
        this.zos = this.zoq.getBottom();
      }
      this.gim -= this.zon;
      this.zoo = (this.gim / 2);
      this.zop = (this.zop - this.zos - this.zor);
      ae.i("MicroMsg.AdViewStatic", "viewHeight " + this.gim + " SCREEN_HEIGHT: " + this.zop + " abottom: " + this.zos + " stHeight: " + this.zor + " commentViewHeight:" + this.zon);
    }
    AppMethodBeat.o(94976);
  }
  
  public final bw dUV()
  {
    AppMethodBeat.i(94978);
    bw localbw = new bw();
    Object localObject = ah.dXE().AG(this.zou);
    if (localObject != null)
    {
      localObject = al.v((p)localObject);
      if (localObject != null)
      {
        localbw.FMS = a((SnsObject)localObject);
        localbw.FMR = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localbw;
      }
    }
    if (this.snsobj != null)
    {
      localbw.FMS = a(this.snsobj);
      localbw.FMR = this.snsobj.LikeUserList.size();
      AppMethodBeat.o(94978);
      return localbw;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean dUW()
  {
    return this.zoU == 1;
  }
  
  public final void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.zol != null)
    {
      initView();
      if ((this.hkx) || (this.gim <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.zok = true;
      localObject = new int[2];
      this.zol.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.zos - this.zor;
      k = m + this.gim;
      if ((m < 0) || (k < 0) || (k > this.zop)) {
        break label1310;
      }
      this.zoU = 1;
      if ((this.zox == -10086) && (this.zoy == -10086))
      {
        this.zox = m;
        this.zoy = k;
      }
      this.zoz = m;
      this.zoA = k;
      ae.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.zoo + "| " + (this.gim + m) + "  firsttop " + this.zox + " endtop " + this.zoz);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.gim;
        i1 = this.gim - n;
        ae.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.zoo)
        {
          i = j;
          if (this.zoD == -10086)
          {
            this.zoD = m;
            this.zoE = k;
            this.zoF = System.currentTimeMillis();
            i = 0;
            ae.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gim + " inscreenval: " + n + " outscreenval: " + i1);
            ae.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.zoF + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.zoo) && (this.zoG == -10086) && (i != 0) && (this.zoF > 0L))
        {
          this.zoG = m;
          this.zoH = k;
          this.zoI = System.currentTimeMillis();
          ae.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gim + " inscreenval: " + n + " outscreenval: " + i1);
          ae.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.zoI - this.zoF) + ", hash=" + hashCode());
        }
        hz(n, i1);
      }
      if (k > this.zop)
      {
        j = 1;
        n = k - this.zop;
        i1 = this.gim - n;
        ae.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.zoo)
        {
          i = j;
          if (this.zoD == -10086)
          {
            this.zoD = m;
            this.zoE = k;
            this.zoF = System.currentTimeMillis();
            i = 0;
            ae.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gim + " inscreenval: " + i1 + " outscreenval: " + n);
            ae.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.zoF + ", hash=" + hashCode());
          }
        }
        if ((n >= this.zoo) && (this.zoG == -10086) && (i != 0) && (this.zoF > 0L))
        {
          this.zoG = m;
          this.zoH = k;
          this.zoI = System.currentTimeMillis();
          ae.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gim + " inscreenval: " + i1 + " outscreenval: " + n);
          ae.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.zoI - this.zoF) + ", hash=" + hashCode());
        }
        hz(i1, n);
      }
      if ((m < 0) || (k > this.zop)) {
        break label1318;
      }
      if (this.zoL == 0L)
      {
        this.zoJ = m;
        this.zoK = k;
        this.zoL = System.currentTimeMillis();
        ae.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.zoL + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.zoQ == -1) || (this.zoQ > i)) {
        this.zoQ = i;
      }
      if (k <= this.zop) {
        break label1409;
      }
      i = k - this.zop;
      if ((this.zoR == -1) || (this.zoR > i)) {
        this.zoR = i;
      }
      label1175:
      int j = this.gim;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.zop) {
        j = i - (k - this.zop);
      }
      if ((this.zoP == -1) || (this.zoP < j)) {
        this.zoP = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.zoQ).append(" unreadBottom:").append(this.zoR).append(" readHeight: ").append(this.zoP);
      if (!paramBoolean) {
        break label1417;
      }
    }
    label1409:
    label1417:
    for (Object localObject = " isScrooIde";; localObject = "")
    {
      ae.i("MicroMsg.AdViewStatic", (String)localObject);
      AppMethodBeat.o(94977);
      return;
      label1310:
      this.zoU = 0;
      break;
      label1318:
      if ((this.zoO != 0L) || (this.zoL == 0L)) {
        break label1107;
      }
      this.zoM = m;
      this.zoN = k;
      this.zoO = System.currentTimeMillis();
      ae.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.zoO - this.zoL) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.zoQ = 0;
      break label1137;
      this.zoR = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.c
 * JD-Core Version:    0.7.0.1
 */