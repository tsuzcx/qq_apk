package com.tencent.mm.plugin.sns.ad.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public int APq;
  public View GiP;
  boolean JDU;
  public View JDV;
  public int JDW;
  public int JDX;
  private View JDY;
  private int JDZ;
  int JEA;
  int JEB;
  boolean JEC;
  private int JEa;
  long JEb;
  private ADInfo JEc;
  ADXml JEd;
  int JEe;
  private int JEf;
  int JEg;
  private int JEh;
  long JEi;
  long JEj;
  private int JEk;
  private int JEl;
  long JEm;
  private int JEn;
  private int JEo;
  long JEp;
  private int JEq;
  private int JEr;
  long JEs;
  private int JEt;
  private int JEu;
  long JEv;
  int JEw;
  int JEx;
  int JEy;
  int JEz;
  public String fCM;
  public int jCa;
  public String jDL;
  boolean kSa;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  private String viewId;
  
  public c(ADInfo paramADInfo, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, ADXml paramADXml)
  {
    AppMethodBeat.i(94975);
    this.JDU = false;
    this.sceneType = 1;
    this.position = 0;
    this.JDW = 0;
    this.jCa = 0;
    this.JDX = 0;
    this.JDZ = 0;
    this.jDL = "";
    this.JEb = 0L;
    this.JEc = null;
    this.viewId = "";
    this.JEe = -10086;
    this.JEf = -10086;
    this.JEg = -10086;
    this.JEh = -10086;
    this.JEi = 0L;
    this.JEj = 0L;
    this.JEk = -10086;
    this.JEl = -10086;
    this.JEm = 0L;
    this.JEn = -10086;
    this.JEo = -10086;
    this.JEp = 0L;
    this.JEq = -10086;
    this.JEr = -10086;
    this.JEs = 0L;
    this.JEt = -10086;
    this.JEu = -10086;
    this.JEv = 0L;
    this.JEw = 0;
    this.JEx = -1;
    this.JEy = -1;
    this.JEz = 0;
    this.JEA = 0;
    this.kSa = false;
    this.JEB = 0;
    this.fCM = "";
    this.JEC = false;
    this.position = paramInt4;
    this.JDV = paramView1;
    this.snsobj = paramSnsObject;
    this.JEd = paramADXml;
    this.JEc = paramADInfo;
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
      this.jDL = paramADInfo;
      this.fCM = paramString;
      this.JEb = paramLong;
      this.APq = paramInt1;
      this.JDY = paramView2;
      this.JDZ = paramInt2;
      if (this.JDV != null) {
        this.GiP = this.JDV.findViewById(i.f.album_list_fatherview);
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
    AppMethodBeat.i(248374);
    if (paramSnsObject == null)
    {
      Log.e("MicroMsg.AdViewStatic", "getReportCommentCount, snsObj==null");
      AppMethodBeat.o(248374);
      return 0;
    }
    LinkedList localLinkedList = paramSnsObject.CommentUserList;
    if (localLinkedList != null)
    {
      Iterator localIterator = localLinkedList.iterator();
      ejo localejo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localejo = (ejo)localIterator.next();
      } while ((localejo == null) || (!e.ki(localejo.Ulr, 32)));
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
          Log.i("MicroMsg.AdViewStatic", "getReportCommentCount, snsId=" + t.Qu(paramSnsObject.Id) + ", commentList.size=" + localLinkedList.size() + ", commentCount=" + paramSnsObject.CommentUserListCount + ", ret=" + i);
          AppMethodBeat.o(248374);
          return i;
          AppMethodBeat.o(248374);
          return 0;
        }
      }
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.jCa == 0) && (this.JDV != null))
    {
      this.jCa = this.JDV.getHeight();
      if ((this.GiP != null) && (this.GiP.getVisibility() == 0)) {
        this.JDW = this.GiP.getHeight();
      }
      if (this.jCa == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.JEa = 0;
      if (this.JDY != null) {
        this.JEa = this.JDY.getBottom();
      }
      this.jCa -= this.JDW;
      this.JDX = (this.jCa / 2);
      this.APq = (this.APq - this.JEa - this.JDZ);
      Log.i("MicroMsg.AdViewStatic", "viewHeight " + this.jCa + " SCREEN_HEIGHT: " + this.APq + " abottom: " + this.JEa + " stHeight: " + this.JDZ + " commentViewHeight:" + this.JDW);
    }
    AppMethodBeat.o(94976);
  }
  
  private void jw(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.JDX)
    {
      this.JEC = true;
      i = 0;
    }
    if ((paramInt2 >= this.JDX) && (i != 0)) {
      this.JEC = false;
    }
  }
  
  public final cd fKP()
  {
    AppMethodBeat.i(94978);
    cd localcd = new cd();
    Object localObject = aj.fOI().Rd(this.JEb);
    if (localObject != null)
    {
      localObject = an.D((SnsInfo)localObject);
      if (localObject != null)
      {
        localcd.RHP = a((SnsObject)localObject);
        localcd.CkG = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localcd;
      }
    }
    if (this.snsobj != null)
    {
      localcd.RHP = a(this.snsobj);
      localcd.CkG = this.snsobj.LikeUserList.size();
      AppMethodBeat.o(94978);
      return localcd;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean fKQ()
  {
    return this.JEB == 1;
  }
  
  public final void yn(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.JDV != null)
    {
      initView();
      if ((this.kSa) || (this.jCa <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.JDU = true;
      localObject = new int[2];
      this.JDV.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.JEa - this.JDZ;
      k = m + this.jCa;
      if ((m < 0) || (k < 0) || (k > this.APq)) {
        break label1310;
      }
      this.JEB = 1;
      if ((this.JEe == -10086) && (this.JEf == -10086))
      {
        this.JEe = m;
        this.JEf = k;
      }
      this.JEg = m;
      this.JEh = k;
      Log.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.JDX + "| " + (this.jCa + m) + "  firsttop " + this.JEe + " endtop " + this.JEg);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.jCa;
        i1 = this.jCa - n;
        Log.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.JDX)
        {
          i = j;
          if (this.JEk == -10086)
          {
            this.JEk = m;
            this.JEl = k;
            this.JEm = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.jCa + " inscreenval: " + n + " outscreenval: " + i1);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.JEm + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.JDX) && (this.JEn == -10086) && (i != 0) && (this.JEm > 0L))
        {
          this.JEn = m;
          this.JEo = k;
          this.JEp = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.jCa + " inscreenval: " + n + " outscreenval: " + i1);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.JEp - this.JEm) + ", hash=" + hashCode());
        }
        jw(n, i1);
      }
      if (k > this.APq)
      {
        j = 1;
        n = k - this.APq;
        i1 = this.jCa - n;
        Log.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.JDX)
        {
          i = j;
          if (this.JEk == -10086)
          {
            this.JEk = m;
            this.JEl = k;
            this.JEm = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.jCa + " inscreenval: " + i1 + " outscreenval: " + n);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.JEm + ", hash=" + hashCode());
          }
        }
        if ((n >= this.JDX) && (this.JEn == -10086) && (i != 0) && (this.JEm > 0L))
        {
          this.JEn = m;
          this.JEo = k;
          this.JEp = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.jCa + " inscreenval: " + i1 + " outscreenval: " + n);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.JEp - this.JEm) + ", hash=" + hashCode());
        }
        jw(i1, n);
      }
      if ((m < 0) || (k > this.APq)) {
        break label1318;
      }
      if (this.JEs == 0L)
      {
        this.JEq = m;
        this.JEr = k;
        this.JEs = System.currentTimeMillis();
        Log.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.JEs + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.JEx == -1) || (this.JEx > i)) {
        this.JEx = i;
      }
      if (k <= this.APq) {
        break label1409;
      }
      i = k - this.APq;
      if ((this.JEy == -1) || (this.JEy > i)) {
        this.JEy = i;
      }
      label1175:
      int j = this.jCa;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.APq) {
        j = i - (k - this.APq);
      }
      if ((this.JEw == -1) || (this.JEw < j)) {
        this.JEw = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.JEx).append(" unreadBottom:").append(this.JEy).append(" readHeight: ").append(this.JEw);
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
      this.JEB = 0;
      break;
      label1318:
      if ((this.JEv != 0L) || (this.JEs == 0L)) {
        break label1107;
      }
      this.JEt = m;
      this.JEu = k;
      this.JEv = System.currentTimeMillis();
      Log.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.JEv - this.JEs) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.JEx = 0;
      break label1137;
      this.JEy = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.c
 * JD-Core Version:    0.7.0.1
 */