package com.tencent.mm.plugin.sns.ad.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.widget.g;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public int CCP;
  public View MdP;
  boolean PUW;
  public View PUX;
  public int PUY;
  public int PUZ;
  int PVA;
  int PVB;
  int PVC;
  int PVD;
  boolean PVE;
  private View PVa;
  private int PVb;
  private int PVc;
  long PVd;
  private ADInfo PVe;
  ADXml PVf;
  int PVg;
  private int PVh;
  int PVi;
  private int PVj;
  long PVk;
  long PVl;
  private int PVm;
  private int PVn;
  long PVo;
  private int PVp;
  private int PVq;
  long PVr;
  private int PVs;
  private int PVt;
  long PVu;
  private int PVv;
  private int PVw;
  long PVx;
  int PVy;
  int PVz;
  public String hHB;
  public int mbN;
  public String mdG;
  boolean nxG;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  private String viewId;
  
  public c(ADInfo paramADInfo, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, ADXml paramADXml)
  {
    AppMethodBeat.i(94975);
    this.PUW = false;
    this.sceneType = 1;
    this.position = 0;
    this.PUY = 0;
    this.mbN = 0;
    this.PUZ = 0;
    this.PVb = 0;
    this.mdG = "";
    this.PVd = 0L;
    this.PVe = null;
    this.viewId = "";
    this.PVg = -10086;
    this.PVh = -10086;
    this.PVi = -10086;
    this.PVj = -10086;
    this.PVk = 0L;
    this.PVl = 0L;
    this.PVm = -10086;
    this.PVn = -10086;
    this.PVo = 0L;
    this.PVp = -10086;
    this.PVq = -10086;
    this.PVr = 0L;
    this.PVs = -10086;
    this.PVt = -10086;
    this.PVu = 0L;
    this.PVv = -10086;
    this.PVw = -10086;
    this.PVx = 0L;
    this.PVy = 0;
    this.PVz = -1;
    this.PVA = -1;
    this.PVB = 0;
    this.PVC = 0;
    this.nxG = false;
    this.PVD = 0;
    this.hHB = "";
    this.PVE = false;
    this.position = paramInt4;
    this.PUX = paramView1;
    this.snsobj = paramSnsObject;
    this.PVf = paramADXml;
    this.PVe = paramADInfo;
    this.sceneType = paramInt3;
    if (paramADInfo == null)
    {
      paramView1 = "";
      this.viewId = paramView1;
      if (paramADInfo != null) {
        break label360;
      }
    }
    label360:
    for (paramADInfo = "";; paramADInfo = Util.nullAs(paramADInfo.uxInfo, ""))
    {
      this.mdG = paramADInfo;
      this.hHB = paramString;
      this.PVd = paramLong;
      this.CCP = paramInt1;
      this.PVa = paramView2;
      this.PVb = paramInt2;
      if (this.PUX != null) {
        this.MdP = this.PUX.findViewById(b.f.album_list_fatherview);
      }
      initView();
      AppMethodBeat.o(94975);
      return;
      paramView1 = Util.nullAs(paramADInfo.viewId, "");
      break;
    }
  }
  
  private static int a(SnsObject paramSnsObject)
  {
    int j = 0;
    AppMethodBeat.i(309949);
    if (paramSnsObject == null)
    {
      Log.e("MicroMsg.AdViewStatic", "getReportCommentCount, snsObj==null");
      AppMethodBeat.o(309949);
      return 0;
    }
    LinkedList localLinkedList = paramSnsObject.CommentUserList;
    if (localLinkedList != null)
    {
      Iterator localIterator = localLinkedList.iterator();
      fdv localfdv;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localfdv = (fdv)localIterator.next();
      } while ((localfdv == null) || (!g.lU(localfdv.abDl, 32)));
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
          Log.i("MicroMsg.AdViewStatic", "getReportCommentCount, snsId=" + t.uA(paramSnsObject.Id) + ", commentList.size=" + localLinkedList.size() + ", commentCount=" + paramSnsObject.CommentUserListCount + ", ret=" + i);
          AppMethodBeat.o(309949);
          return i;
          AppMethodBeat.o(309949);
          return 0;
        }
      }
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.mbN == 0) && (this.PUX != null))
    {
      this.mbN = this.PUX.getHeight();
      if ((this.MdP != null) && (this.MdP.getVisibility() == 0)) {
        this.PUY = this.MdP.getHeight();
      }
      if (this.mbN == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.PVc = 0;
      if (this.PVa != null) {
        this.PVc = this.PVa.getBottom();
      }
      this.mbN -= this.PUY;
      this.PUZ = (this.mbN / 2);
      this.CCP = (this.CCP - this.PVc - this.PVb);
      Log.i("MicroMsg.AdViewStatic", "viewHeight " + this.mbN + " SCREEN_HEIGHT: " + this.CCP + " abottom: " + this.PVc + " stHeight: " + this.PVb + " commentViewHeight:" + this.PUY);
    }
    AppMethodBeat.o(94976);
  }
  
  private void lf(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.PUZ)
    {
      this.PVE = true;
      i = 0;
    }
    if ((paramInt2 >= this.PUZ) && (i != 0)) {
      this.PVE = false;
    }
  }
  
  public final void Dr(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.PUX != null)
    {
      initView();
      if ((this.nxG) || (this.mbN <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.PUW = true;
      localObject = new int[2];
      this.PUX.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.PVc - this.PVb;
      k = m + this.mbN;
      if ((m < 0) || (k < 0) || (k > this.CCP)) {
        break label1310;
      }
      this.PVD = 1;
      if ((this.PVg == -10086) && (this.PVh == -10086))
      {
        this.PVg = m;
        this.PVh = k;
      }
      this.PVi = m;
      this.PVj = k;
      Log.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.PUZ + "| " + (this.mbN + m) + "  firsttop " + this.PVg + " endtop " + this.PVi);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.mbN;
        i1 = this.mbN - n;
        Log.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.PUZ)
        {
          i = j;
          if (this.PVm == -10086)
          {
            this.PVm = m;
            this.PVn = k;
            this.PVo = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.mbN + " inscreenval: " + n + " outscreenval: " + i1);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.PVo + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.PUZ) && (this.PVp == -10086) && (i != 0) && (this.PVo > 0L))
        {
          this.PVp = m;
          this.PVq = k;
          this.PVr = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.mbN + " inscreenval: " + n + " outscreenval: " + i1);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.PVr - this.PVo) + ", hash=" + hashCode());
        }
        lf(n, i1);
      }
      if (k > this.CCP)
      {
        j = 1;
        n = k - this.CCP;
        i1 = this.mbN - n;
        Log.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.PUZ)
        {
          i = j;
          if (this.PVm == -10086)
          {
            this.PVm = m;
            this.PVn = k;
            this.PVo = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.mbN + " inscreenval: " + i1 + " outscreenval: " + n);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.PVo + ", hash=" + hashCode());
          }
        }
        if ((n >= this.PUZ) && (this.PVp == -10086) && (i != 0) && (this.PVo > 0L))
        {
          this.PVp = m;
          this.PVq = k;
          this.PVr = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.mbN + " inscreenval: " + i1 + " outscreenval: " + n);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.PVr - this.PVo) + ", hash=" + hashCode());
        }
        lf(i1, n);
      }
      if ((m < 0) || (k > this.CCP)) {
        break label1318;
      }
      if (this.PVu == 0L)
      {
        this.PVs = m;
        this.PVt = k;
        this.PVu = System.currentTimeMillis();
        Log.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.PVu + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.PVz == -1) || (this.PVz > i)) {
        this.PVz = i;
      }
      if (k <= this.CCP) {
        break label1409;
      }
      i = k - this.CCP;
      if ((this.PVA == -1) || (this.PVA > i)) {
        this.PVA = i;
      }
      label1175:
      int j = this.mbN;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.CCP) {
        j = i - (k - this.CCP);
      }
      if ((this.PVy == -1) || (this.PVy < j)) {
        this.PVy = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.PVz).append(" unreadBottom:").append(this.PVA).append(" readHeight: ").append(this.PVy);
      if (!paramBoolean) {
        break label1417;
      }
    }
    label1409:
    label1417:
    for (Object localObject = " isScrooIde";; localObject = "")
    {
      Log.i("MicroMsg.AdViewStatic", (String)localObject);
      AppMethodBeat.o(94977);
      return;
      label1310:
      this.PVD = 0;
      break;
      label1318:
      if ((this.PVx != 0L) || (this.PVu == 0L)) {
        break label1107;
      }
      this.PVv = m;
      this.PVw = k;
      this.PVx = System.currentTimeMillis();
      Log.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.PVx - this.PVu) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.PVz = 0;
      break label1137;
      this.PVA = 0;
      break label1175;
    }
  }
  
  public final cn hbg()
  {
    AppMethodBeat.i(94978);
    cn localcn = new cn();
    Object localObject = al.hgB().vj(this.PVd);
    if (localObject != null)
    {
      localObject = ap.E((SnsInfo)localObject);
      if (localObject != null)
      {
        localcn.YES = a((SnsObject)localObject);
        localcn.HWO = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localcn;
      }
    }
    if (this.snsobj != null)
    {
      localcn.YES = a(this.snsobj);
      localcn.HWO = this.snsobj.LikeUserList.size();
      AppMethodBeat.o(94978);
      return localcn;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean hbh()
  {
    return this.PVD == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.c
 * JD-Core Version:    0.7.0.1
 */