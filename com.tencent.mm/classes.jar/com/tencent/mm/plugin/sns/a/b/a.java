package com.tencent.mm.plugin.sns.a.b;

import android.view.View;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a
{
  public String bMB = "";
  private String fVM = "";
  boolean inQ = false;
  public int jsr = 0;
  long okA = 0L;
  private int okB = -10086;
  private int okC = -10086;
  long okD = 0L;
  private int okE = -10086;
  private int okF = -10086;
  long okG = 0L;
  int okH = 0;
  int okI = -1;
  int okJ = -1;
  int okK = 0;
  int okL = 0;
  int okM = 0;
  private boolean okN = false;
  private int okO = 0;
  boolean okc = false;
  public bto okd;
  public View oke;
  public View okf;
  public int okg = 0;
  public int okh = 0;
  public int oki;
  private View okj;
  private int okk = 0;
  public String okl = "";
  long okm = 0L;
  private com.tencent.mm.plugin.sns.storage.a okn = null;
  b oko;
  int okp = -10086;
  private int okq = -10086;
  int okr = -10086;
  private int oks = -10086;
  long okt = 0L;
  long oku = 0L;
  private int okv = -10086;
  private int okw = -10086;
  long okx = 0L;
  private int oky = -10086;
  private int okz = -10086;
  int position = 0;
  public int sceneType = 1;
  
  public a(com.tencent.mm.plugin.sns.storage.a parama, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, bto parambto, int paramInt4, b paramb)
  {
    this.position = paramInt4;
    this.oke = paramView1;
    this.okd = parambto;
    this.oko = paramb;
    this.okn = parama;
    this.sceneType = paramInt3;
    if (parama == null)
    {
      paramView1 = "";
      this.fVM = paramView1;
      if (parama != null) {
        break label355;
      }
    }
    label355:
    for (parama = "";; parama = bk.aM(parama.ovV, ""))
    {
      this.okl = parama;
      this.bMB = paramString;
      this.okm = paramLong;
      this.oki = paramInt1;
      this.okj = paramView2;
      this.okk = paramInt2;
      if (this.oke != null) {
        this.okf = this.oke.findViewById(i.f.album_list_fatherview);
      }
      initView();
      return;
      paramView1 = bk.aM(parama.fVM, "");
      break;
    }
  }
  
  private void initView()
  {
    if ((this.jsr == 0) && (this.oke != null))
    {
      BackwardSupportUtil.b.b(this.oke.getContext(), 50.0F);
      this.jsr = this.oke.getHeight();
      if (this.okf != null) {
        this.okg = this.okf.getHeight();
      }
      if (this.jsr != 0) {}
    }
    else
    {
      return;
    }
    int i = 0;
    if (this.okj != null) {
      i = this.okj.getBottom();
    }
    this.jsr -= this.okg;
    this.okh = (this.jsr / 2);
    this.oki = (this.oki - i - this.okk);
    y.i("MicroMsg.AdViewStatic", "viewHeight " + this.jsr + " SCREEN_HEIGHT: " + this.oki + " abottom: " + i + " stHeight: " + this.okk + " commentViewHeight:" + this.okg);
  }
  
  public final void bCc()
  {
    int j = 1;
    if (this.oke != null)
    {
      initView();
      if ((!this.inQ) && (this.jsr > 0)) {}
    }
    else
    {
      return;
    }
    this.okc = true;
    int k = this.oke.getTop();
    int m = this.oke.getBottom();
    int n = this.okg;
    int[] arrayOfInt;
    if (!this.okN)
    {
      arrayOfInt = new int[2];
      this.oke.getLocationOnScreen(arrayOfInt);
      if (this.okj == null) {
        break label917;
      }
    }
    label896:
    label904:
    label912:
    label917:
    for (int i = this.okj.getBottom();; i = 0)
    {
      this.okO = (k - (arrayOfInt[1] - i - this.okk));
      this.okN = true;
      k -= this.okO;
      m = m - n - this.okO;
      label151:
      int i1;
      if ((k >= 0) && (m <= this.oki))
      {
        this.okM = 1;
        if ((this.okp == -10086) && (this.okq == -10086))
        {
          this.okp = k;
          this.okq = m;
        }
        this.okr = k;
        this.oks = m;
        if (k < 0)
        {
          n = k + this.jsr;
          i1 = this.jsr - n;
          if ((n < this.okh) || (this.okv != -10086)) {
            break label912;
          }
          this.okv = k;
          this.okw = m;
          this.okx = System.currentTimeMillis();
          y.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + k + " viewhieght " + this.jsr + " inscreenval: " + n + " outscreenval: " + i1);
        }
      }
      for (i = 0;; i = 1)
      {
        if ((i1 >= this.okh) && (this.oky == -10086) && (i != 0) && (this.okx > 0L))
        {
          this.oky = k;
          this.okz = m;
          this.okA = System.currentTimeMillis();
          y.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + m + " viewhieght " + this.jsr + " inscreenval: " + n + " outscreenval: " + i1);
        }
        if (m > this.oki)
        {
          n = m - this.oki;
          i1 = this.jsr - n;
          i = j;
          if (i1 >= this.okh)
          {
            i = j;
            if (this.okv == -10086)
            {
              this.okv = k;
              this.okw = m;
              this.okx = System.currentTimeMillis();
              y.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + k + " viewhieght " + this.jsr + " inscreenval: " + i1 + " outscreenval: " + n);
              i = 0;
            }
          }
          if ((n >= this.okh) && (this.oky == -10086) && (i != 0) && (this.okx > 0L))
          {
            this.oky = k;
            this.okz = m;
            this.okA = System.currentTimeMillis();
            y.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + m + " viewhieght " + this.jsr + " inscreenval: " + i1 + " outscreenval: " + n);
          }
        }
        if ((k >= 0) && (m <= this.oki))
        {
          if (this.okD == 0L)
          {
            this.okB = k;
            this.okC = m;
            this.okD = System.currentTimeMillis();
          }
          label725:
          if (k >= 0) {
            break label896;
          }
          i = -k;
          if ((this.okI == -1) || (this.okI > i)) {
            this.okI = i;
          }
          label753:
          if (m <= this.oki) {
            break label904;
          }
          i = m - this.oki;
          if ((this.okJ != -1) && (this.okJ <= i)) {}
        }
        for (this.okJ = i;; this.okJ = 0)
        {
          j = this.jsr;
          i = j;
          if (k < 0) {
            i = j + k;
          }
          j = i;
          if (m > this.oki) {
            j = i - (m - this.oki);
          }
          if ((this.okH != -1) && (this.okH >= j)) {
            break;
          }
          this.okH = j;
          return;
          this.okM = 0;
          break label151;
          if ((this.okG != 0L) || (this.okD == 0L)) {
            break label725;
          }
          this.okE = k;
          this.okF = m;
          this.okG = System.currentTimeMillis();
          break label725;
          this.okI = 0;
          break label753;
        }
      }
    }
  }
  
  public final bi bCd()
  {
    bi localbi = new bi();
    Object localObject = af.bDF().gt(this.okm);
    if (localObject != null)
    {
      localObject = aj.q((n)localObject);
      if (localObject != null)
      {
        localbi.suZ = ((bto)localObject).tKb.size();
        localbi.like_count = ((bto)localObject).tJY.size();
        return localbi;
      }
    }
    if (this.okd != null)
    {
      localbi.suZ = this.okd.tKa;
      localbi.like_count = this.okd.tJX;
      return localbi;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.a
 * JD-Core Version:    0.7.0.1
 */