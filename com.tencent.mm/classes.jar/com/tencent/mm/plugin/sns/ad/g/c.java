package com.tencent.mm.plugin.sns.ad.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public View Atk;
  public int DuA;
  private View DuB;
  private int DuC;
  private int DuD;
  long DuE;
  private ADInfo DuF;
  ADXml DuG;
  int DuH;
  private int DuI;
  int DuJ;
  private int DuK;
  long DuL;
  long DuM;
  private int DuN;
  private int DuO;
  long DuP;
  private int DuQ;
  private int DuR;
  long DuS;
  private int DuT;
  private int DuU;
  long DuV;
  private int DuW;
  private int DuX;
  long DuY;
  int DuZ;
  boolean Duw;
  public View Dux;
  public int Duy;
  public int Duz;
  int Dva;
  int Dvb;
  int Dvc;
  int Dvd;
  int Dve;
  boolean Dvf;
  public String dJX;
  public int gRE;
  public String gTk;
  boolean idt;
  int position;
  public int sceneType;
  public SnsObject snsobj;
  private String viewId;
  
  public c(ADInfo paramADInfo, String paramString, long paramLong, View paramView1, int paramInt1, View paramView2, int paramInt2, int paramInt3, SnsObject paramSnsObject, int paramInt4, ADXml paramADXml)
  {
    AppMethodBeat.i(94975);
    this.Duw = false;
    this.sceneType = 1;
    this.position = 0;
    this.Duy = 0;
    this.gRE = 0;
    this.Duz = 0;
    this.DuC = 0;
    this.gTk = "";
    this.DuE = 0L;
    this.DuF = null;
    this.viewId = "";
    this.DuH = -10086;
    this.DuI = -10086;
    this.DuJ = -10086;
    this.DuK = -10086;
    this.DuL = 0L;
    this.DuM = 0L;
    this.DuN = -10086;
    this.DuO = -10086;
    this.DuP = 0L;
    this.DuQ = -10086;
    this.DuR = -10086;
    this.DuS = 0L;
    this.DuT = -10086;
    this.DuU = -10086;
    this.DuV = 0L;
    this.DuW = -10086;
    this.DuX = -10086;
    this.DuY = 0L;
    this.DuZ = 0;
    this.Dva = -1;
    this.Dvb = -1;
    this.Dvc = 0;
    this.Dvd = 0;
    this.idt = false;
    this.Dve = 0;
    this.dJX = "";
    this.Dvf = false;
    this.position = paramInt4;
    this.Dux = paramView1;
    this.snsobj = paramSnsObject;
    this.DuG = paramADXml;
    this.DuF = paramADInfo;
    this.sceneType = paramInt3;
    if (paramADInfo == null)
    {
      paramView1 = "";
      this.viewId = paramView1;
      if (paramADInfo != null) {
        break label359;
      }
    }
    label359:
    for (paramADInfo = "";; paramADInfo = Util.nullAs(paramADInfo.uxInfo, ""))
    {
      this.gTk = paramADInfo;
      this.dJX = paramString;
      this.DuE = paramLong;
      this.DuA = paramInt1;
      this.DuB = paramView2;
      this.DuC = paramInt2;
      if (this.Dux != null) {
        this.Atk = this.Dux.findViewById(2131296667);
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
    AppMethodBeat.i(202033);
    if (paramSnsObject == null)
    {
      Log.e("MicroMsg.AdViewStatic", "getReportCommentCount, snsObj==null");
      AppMethodBeat.o(202033);
      return 0;
    }
    LinkedList localLinkedList = paramSnsObject.CommentUserList;
    if (localLinkedList != null)
    {
      Iterator localIterator = localLinkedList.iterator();
      dzo localdzo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localdzo = (dzo)localIterator.next();
      } while ((localdzo == null) || (!e.iY(localdzo.MYX, 32)));
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
          Log.i("MicroMsg.AdViewStatic", "getReportCommentCount, snsId=" + r.Jb(paramSnsObject.Id) + ", commentList.size=" + localLinkedList.size() + ", commentCount=" + paramSnsObject.CommentUserListCount + ", ret=" + i);
          AppMethodBeat.o(202033);
          return i;
          AppMethodBeat.o(202033);
          return 0;
        }
      }
    }
  }
  
  private void in(int paramInt1, int paramInt2)
  {
    int i = 1;
    if (paramInt1 >= this.Duz)
    {
      this.Dvf = true;
      i = 0;
    }
    if ((paramInt2 >= this.Duz) && (i != 0)) {
      this.Dvf = false;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(94976);
    if ((this.gRE == 0) && (this.Dux != null))
    {
      this.gRE = this.Dux.getHeight();
      if ((this.Atk != null) && (this.Atk.getVisibility() == 0)) {
        this.Duy = this.Atk.getHeight();
      }
      if (this.gRE == 0)
      {
        AppMethodBeat.o(94976);
        return;
      }
      this.DuD = 0;
      if (this.DuB != null) {
        this.DuD = this.DuB.getBottom();
      }
      this.gRE -= this.Duy;
      this.Duz = (this.gRE / 2);
      this.DuA = (this.DuA - this.DuD - this.DuC);
      Log.i("MicroMsg.AdViewStatic", "viewHeight " + this.gRE + " SCREEN_HEIGHT: " + this.DuA + " abottom: " + this.DuD + " stHeight: " + this.DuC + " commentViewHeight:" + this.Duy);
    }
    AppMethodBeat.o(94976);
  }
  
  public final cf eXo()
  {
    AppMethodBeat.i(94978);
    cf localcf = new cf();
    Object localObject = aj.faO().JJ(this.DuE);
    if (localObject != null)
    {
      localObject = an.C((SnsInfo)localObject);
      if (localObject != null)
      {
        localcf.KGx = a((SnsObject)localObject);
        localcf.KGw = ((SnsObject)localObject).LikeUserList.size();
        AppMethodBeat.o(94978);
        return localcf;
      }
    }
    if (this.snsobj != null)
    {
      localcf.KGx = a(this.snsobj);
      localcf.KGw = this.snsobj.LikeUserList.size();
      AppMethodBeat.o(94978);
      return localcf;
    }
    AppMethodBeat.o(94978);
    return null;
  }
  
  public final boolean eXp()
  {
    return this.Dve == 1;
  }
  
  public final void uL(boolean paramBoolean)
  {
    AppMethodBeat.i(94977);
    int m;
    int k;
    label1107:
    label1137:
    StringBuilder localStringBuilder;
    if (this.Dux != null)
    {
      initView();
      if ((this.idt) || (this.gRE <= 0))
      {
        AppMethodBeat.o(94977);
        return;
      }
      this.Duw = true;
      localObject = new int[2];
      this.Dux.getLocationOnScreen((int[])localObject);
      m = localObject[1] - this.DuD - this.DuC;
      k = m + this.gRE;
      if ((m < 0) || (k < 0) || (k > this.DuA)) {
        break label1310;
      }
      this.Dve = 1;
      if ((this.DuH == -10086) && (this.DuI == -10086))
      {
        this.DuH = m;
        this.DuI = k;
      }
      this.DuJ = m;
      this.DuK = k;
      Log.i("MicroMsg.AdViewStatic", "get top " + m + " bottom " + k + " body_half: " + this.Duz + "| " + (this.gRE + m) + "  firsttop " + this.DuH + " endtop " + this.DuJ);
      int n;
      int i1;
      if (m < 0)
      {
        n = m + this.gRE;
        i1 = this.gRE - n;
        Log.i("MicroMsg.AdViewStatic", "top " + m + " screen in " + n + " out: " + i1);
        j = 1;
        i = j;
        if (n >= this.Duz)
        {
          i = j;
          if (this.DuN == -10086)
          {
            this.DuN = m;
            this.DuO = k;
            this.DuP = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gRE + " inscreenval: " + n + " outscreenval: " + i1);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.DuP + ", hash=" + hashCode());
          }
        }
        if ((i1 >= this.Duz) && (this.DuQ == -10086) && (i != 0) && (this.DuP > 0L))
        {
          this.DuQ = m;
          this.DuR = k;
          this.DuS = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gRE + " inscreenval: " + n + " outscreenval: " + i1);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.DuS - this.DuP) + ", hash=" + hashCode());
        }
        in(n, i1);
      }
      if (k > this.DuA)
      {
        j = 1;
        n = k - this.DuA;
        i1 = this.gRE - n;
        Log.i("MicroMsg.AdViewStatic", "bottom " + k + " screen in " + i1 + " out: " + n);
        i = j;
        if (i1 >= this.Duz)
        {
          i = j;
          if (this.DuN == -10086)
          {
            this.DuN = m;
            this.DuO = k;
            this.DuP = System.currentTimeMillis();
            i = 0;
            Log.i("MicroMsg.AdViewStatic", "up first touch half" + n + " top " + m + " viewhieght " + this.gRE + " inscreenval: " + i1 + " outscreenval: " + n);
            Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.DuP + ", hash=" + hashCode());
          }
        }
        if ((n >= this.Duz) && (this.DuQ == -10086) && (i != 0) && (this.DuP > 0L))
        {
          this.DuQ = m;
          this.DuR = k;
          this.DuS = System.currentTimeMillis();
          Log.i("MicroMsg.AdViewStatic", "down first touch half" + n + " bottom " + k + " viewhieght " + this.gRE + " inscreenval: " + i1 + " outscreenval: " + n);
          Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.DuS - this.DuP) + ", hash=" + hashCode());
        }
        in(i1, n);
      }
      if ((m < 0) || (k > this.DuA)) {
        break label1318;
      }
      if (this.DuV == 0L)
      {
        this.DuT = m;
        this.DuU = k;
        this.DuV = System.currentTimeMillis();
        Log.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.DuV + ", hash=" + hashCode());
      }
      if (m >= 0) {
        break label1401;
      }
      int i = -m;
      if ((this.Dva == -1) || (this.Dva > i)) {
        this.Dva = i;
      }
      if (k <= this.DuA) {
        break label1409;
      }
      i = k - this.DuA;
      if ((this.Dvb == -1) || (this.Dvb > i)) {
        this.Dvb = i;
      }
      label1175:
      int j = this.gRE;
      i = j;
      if (m < 0) {
        i = j + m;
      }
      j = i;
      if (k > this.DuA) {
        j = i - (k - this.DuA);
      }
      if ((this.DuZ == -1) || (this.DuZ < j)) {
        this.DuZ = j;
      }
      localStringBuilder = new StringBuilder("unreadtop: ").append(this.Dva).append(" unreadBottom:").append(this.Dvb).append(" readHeight: ").append(this.DuZ);
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
      this.Dve = 0;
      break;
      label1318:
      if ((this.DuY != 0L) || (this.DuV == 0L)) {
        break label1107;
      }
      this.DuW = m;
      this.DuX = k;
      this.DuY = System.currentTimeMillis();
      Log.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.DuY - this.DuV) + ", hash=" + hashCode());
      break label1107;
      label1401:
      this.Dva = 0;
      break label1137;
      this.Dvb = 0;
      break label1175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.c
 * JD-Core Version:    0.7.0.1
 */