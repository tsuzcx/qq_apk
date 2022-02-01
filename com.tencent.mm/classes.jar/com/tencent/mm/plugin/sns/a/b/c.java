package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
{
  private String dAM;
  public String diQ;
  public int fIO;
  boolean gna;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  boolean wwT;
  public View wwU;
  public View wwV;
  public int wwW;
  public int wwX;
  public int wwY;
  private View wwZ;
  int wxA;
  int wxB;
  int wxC;
  int wxD;
  boolean wxE;
  private int wxa;
  private int wxb;
  public String wxc;
  long wxd;
  private a wxe;
  b wxf;
  int wxg;
  private int wxh;
  int wxi;
  private int wxj;
  long wxk;
  long wxl;
  private int wxm;
  private int wxn;
  long wxo;
  private int wxp;
  private int wxq;
  long wxr;
  private int wxs;
  private int wxt;
  long wxu;
  private int wxv;
  private int wxw;
  long wxx;
  int wxy;
  int wxz;
  
  public c(a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, b paramb)
  {
    AppMethodBeat.i(94975);
    this.wwT = false;
    this.sceneType = 1;
    this.position = 0;
    this.wwW = 0;
    this.fIO = 0;
    this.wwX = 0;
    this.wxa = 0;
    this.wxc = "";
    this.wxd = 0L;
    this.wxe = null;
    this.dAM = "";
    this.wxg = -10086;
    this.wxh = -10086;
    this.wxi = -10086;
    this.wxj = -10086;
    this.wxk = 0L;
    this.wxl = 0L;
    this.wxm = -10086;
    this.wxn = -10086;
    this.wxo = 0L;
    this.wxp = -10086;
    this.wxq = -10086;
    this.wxr = 0L;
    this.wxs = -10086;
    this.wxt = -10086;
    this.wxu = 0L;
    this.wxv = -10086;
    this.wxw = -10086;
    this.wxx = 0L;
    this.wxy = 0;
    this.wxz = -1;
    this.wxA = -1;
    this.wxB = 0;
    this.wxC = 0;
    this.gna = false;
    this.wxD = 0;
    this.diQ = "";
    this.wxE = false;
    this.position = paramInt4;
    this.wwU = paramView1;
    this.snsobj = paramSnsObject;
    this.wxf = paramb;
    this.wxe = parama;
    this.sceneType = paramInt3;
    if (parama == null)
    {
      paramView1 = "";
      this.dAM = paramView1;
      if (parama != null) {
        break label359;
      }
    }
    label359:
    for (parama = "";; parama = bt.by(parama.dvK, ""))
    {
      this.wxc = parama;
      this.diQ = paramString;
      this.wxd = paramLong;
      this.wwY = paramInt1;
      this.wwZ = paramView2;
      this.wxa = paramInt2;
      if (this.wwU != null) {
        this.wwV = this.wwU.findViewById(2131296590);
      }
      initView();
      AppMethodBeat.o(94975);
      return;
      paramView1 = bt.by(parama.dAM, "");
      break;
    }
  }
  
  private void gX(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.wwX)
    {
      this.wxE = true;
      i = 0;
    }
    if ((paramInt2 >= this.wwX) && (i != 0)) {
      this.wxE = false;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.fIO == 0) && (this.wwU != null))
    {
      this.fIO = this.wwU.getHeight();
      if ((this.wwV != null) && (this.wwV.getVisibility() == 0)) {
        this.wwW = this.wwV.getHeight();
      }
      if (this.fIO == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.wxb = 0;
      if (this.wwZ != null) {
        this.wxb = this.wwZ.getBottom();
      }
      this.fIO -= this.wwW;
      this.wwX = (this.fIO / 2);
      this.wwY = (this.wwY - this.wxb - this.wxa);
      ad.i("MicroMsg.AdViewStatic", "viewHeight " + this.fIO + " SCREEN_HEIGHT: " + this.wwY + " abottom: " + this.wxb + " stHeight: " + this.wxa + " commentViewHeight:" + this.wwW);
    }
    AppMethodBeat.o(94976);
  }
  
  public final bu drt()
  {
    AppMethodBeat.i(94978);
    bu localbu = new bu();
    Object localObject = af.dtu().th(this.wxd);
    if (localObject != null)
    {
      localObject = aj.t((p)localObject);
      if (localObject != null)
      {
        localbu.CwO = ((SnsObject)localObject).CommentUserList.size();
        localbu.CwN = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localbu;
      }
    }
    if (this.snsobj != null)
    {
      localbu.CwO = this.snsobj.CommentUserListCount;
      localbu.CwN = this.snsobj.LikeUserListCount;
      AppMethodBeat.o(94978);
      return localbu;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean dru()
  {
    return this.wxD == 1;
  }
  
  public final void pG(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.wwU != null)
    {
      initView();
      if ((this.gna) || (this.fIO <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.wwT = true;
      localObject = new int[2];
      this.wwU.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.wxb - this.wxa;
      k = m + this.fIO;
      if ((m < 0) || (k < 0) || (k > this.wwY)) {
        break label1310;
      }
      this.wxD = 1;
      if ((this.wxg == -10086) && (this.wxh == -10086))
      {
        this.wxg = m;
        this.wxh = k;
      }
      this.wxi = m;
      this.wxj = k;
      ad.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.wwX + "| " + (this.fIO + m) + "  firsttop " + this.wxg + " endtop " + this.wxi);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.fIO;
        i1 = this.fIO - n;
        ad.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.wwX)
        {
          i = j;
          if (this.wxm == -10086)
          {
            this.wxm = m;
            this.wxn = k;
            this.wxo = System.currentTimeMillis();
            i = 0;
            ad.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.fIO + " inscreenval: " + n + " outscreenval: " + i1);
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.wxo + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.wwX) && (this.wxp == -10086) && (i != 0) && (this.wxo > 0L))
        {
          this.wxp = m;
          this.wxq = k;
          this.wxr = System.currentTimeMillis();
          ad.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.fIO + " inscreenval: " + n + " outscreenval: " + i1);
          ad.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.wxr - this.wxo) + ", hash=" + hashCode());
        }
        gX(n, i1);
      }
      if (k > this.wwY)
      {
        j = 1;
        n = k - this.wwY;
        i1 = this.fIO - n;
        ad.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.wwX)
        {
          i = j;
          if (this.wxm == -10086)
          {
            this.wxm = m;
            this.wxn = k;
            this.wxo = System.currentTimeMillis();
            i = 0;
            ad.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.fIO + " inscreenval: " + i1 + " outscreenval: " + n);
            ad.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.wxo + ", hash=" + hashCode());
          }
        }
        if ((n >= this.wwX) && (this.wxp == -10086) && (i != 0) && (this.wxo > 0L))
        {
          this.wxp = m;
          this.wxq = k;
          this.wxr = System.currentTimeMillis();
          ad.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.fIO + " inscreenval: " + i1 + " outscreenval: " + n);
          ad.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.wxr - this.wxo) + ", hash=" + hashCode());
        }
        gX(i1, n);
      }
      if ((m < 0) || (k > this.wwY)) {
        break label1318;
      }
      if (this.wxu == 0L)
      {
        this.wxs = m;
        this.wxt = k;
        this.wxu = System.currentTimeMillis();
        ad.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.wxu + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.wxz == -1) || (this.wxz > i)) {
        this.wxz = i;
      }
      if (k <= this.wwY) {
        break label1409;
      }
      i = k - this.wwY;
      if ((this.wxA == -1) || (this.wxA > i)) {
        this.wxA = i;
      }
      label1175:
      int j = this.fIO;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.wwY) {
        j = i - (k - this.wwY);
      }
      if ((this.wxy == -1) || (this.wxy < j)) {
        this.wxy = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.wxz).append(" unreadBottom:").append(this.wxA).append(" readHeight: ").append(this.wxy);
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
      this.wxD = 0;
      break;
      label1318:
      if ((this.wxx != 0L) || (this.wxu == 0L)) {
        break label1107;
      }
      this.wxv = m;
      this.wxw = k;
      this.wxx = System.currentTimeMillis();
      ad.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.wxx - this.wxu) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.wxz = 0;
      break label1137;
      this.wxA = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.c
 * JD-Core Version:    0.7.0.1
 */