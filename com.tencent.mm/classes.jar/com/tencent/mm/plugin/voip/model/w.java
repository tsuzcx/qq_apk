package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bsf;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dzf;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  l Cpd;
  dzx Cwc;
  private dzg Cwd;
  private int Cwe;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.Cpd = null;
    this.Cwc = new dzx();
    this.Cwd = null;
    this.Cwe = 0;
    this.Cpd = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(dzg paramdzg)
  {
    AppMethodBeat.i(115203);
    if (paramdzg == null)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.Cwe += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.Cwd == null) {
      this.Cwd = new dzg();
    }
    int i = 0;
    while (i < paramdzg.nID)
    {
      dzf localdzf = (dzf)paramdzg.nIE.get(i);
      this.Cwd.nIE.add(localdzf);
      i += 1;
    }
    this.Cwd.nID = this.Cwd.nIE.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(dzg paramdzg)
  {
    AppMethodBeat.i(115204);
    if ((this.Cwd == null) || (this.Cwd.nID <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.Cwd.nID)
    {
      dzf localdzf = (dzf)this.Cwd.nIE.get(i);
      paramdzg.nIE.add(localdzf);
      i += 1;
    }
    paramdzg.nID = paramdzg.nIE.size();
    eBK();
    AppMethodBeat.o(115204);
  }
  
  public final void Va(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = com.tencent.mm.plugin.voip.b.f.Vj(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new dzf();
      ((dzf)localObject1).Gru = 3;
      ((dzf)localObject1).Grv = ((SKBuiltinBuffer_t)localObject2);
      ((dzf)localObject1).uvG = com.tencent.mm.model.v.aAC();
      localObject2 = new dzg();
      ((dzg)localObject2).nID = 1;
      ((dzg)localObject2).nIE.add(localObject1);
      a((dzg)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final int a(dzg paramdzg, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.Cpd.Csj.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.f.abr() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.Cpd.Csp)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.f.abr() + "voip syncing, push to cache...");
      a(paramdzg);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.Cpd.Csp = true;
    if (paramdzg == null)
    {
      paramdzg = new dzg();
      paramdzg.nID = 0;
      paramdzg.nIE = new LinkedList();
    }
    for (;;)
    {
      b(paramdzg);
      this.Cwe = 0;
      if (this.Cpd.Csn == null) {
        this.Cpd.Csn = "".getBytes();
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramdzg.nID + ",syncKey.length:" + this.Cpd.Csn.length + ",selector:" + paramInt);
      new m(this.Cpd.Csj.roomId, paramdzg, this.Cpd.Csn, this.Cpd.Csj.uXg, paramInt).eBO();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final dzw paramdzw)
  {
    AppMethodBeat.i(115208);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        ar.f(new w.2(w.this, paramdzw));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final ead paramead)
  {
    AppMethodBeat.i(115209);
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramead.FTj.getBuffer().toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (dzx)new dzx().parseFrom((byte[])localObject1);
            if ((((dzx)localObject1).Idl != null) && (((dzx)localObject1).Idl.FTj != null) && (((dzx)localObject1).Idl.FTj.getBuffer() != null)) {
              w.this.Cwc.Idl = ((dzx)localObject1).Idl;
            }
            if ((((dzx)localObject1).Idm.FTj != null) && (((dzx)localObject1).Idm.FTj.getBuffer() != null)) {
              w.this.Cwc.Idm = ((dzx)localObject1).Idm;
            }
            if (((dzx)localObject1).Ifg != 0) {
              w.this.Cwc.Ifg = ((dzx)localObject1).Ifg;
            }
            if ((((dzx)localObject1).Ifh != null) && (((dzx)localObject1).Ifh.IdA != 0)) {
              w.this.Cwc.Ifh = ((dzx)localObject1).Ifh;
            }
            if ((((dzx)localObject1).Ifi != null) && (((dzx)localObject1).Ifi.IdA != 0)) {
              w.this.Cwc.Ifi = ((dzx)localObject1).Ifi;
            }
            if ((((dzx)localObject1).IfI != null) && (((dzx)localObject1).IfI.size() != 0))
            {
              w.this.Cwc.IfI = ((dzx)localObject1).IfI;
              w.this.Cwc.IfH = ((dzx)localObject1).IfI.size();
            }
            if (((dzx)localObject1).Ifk != 0) {
              w.this.Cwc.Ifk = ((dzx)localObject1).Ifk;
            }
            if (((dzx)localObject1).Ifl != 0) {
              w.this.Cwc.Ifl = ((dzx)localObject1).Ifl;
            }
            if (((dzx)localObject1).Ifp.IdA != 0) {
              w.this.Cwc.Ifp = ((dzx)localObject1).Ifp;
            }
            if (((dzx)localObject1).Ifq > 0)
            {
              w.this.Cwc.Ifq = ((dzx)localObject1).Ifq;
              if (((dzx)localObject1).uXB <= 0) {
                break label907;
              }
              w.this.Cwc.uXB = (((dzx)localObject1).uXB - 1);
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.Cwc.uXB + "] from relaydata");
              if (((dzx)localObject1).Ifr <= 0) {
                break label928;
              }
              w.this.Cwc.Ifr = ((dzx)localObject1).Ifr;
              w.this.Cwc.Ifs = ((dzx)localObject1).Ifs;
              w.this.Cwc.Ift = ((dzx)localObject1).Ift;
              w.this.Cwc.Ifu = ((dzx)localObject1).Ifu;
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((dzx)localObject1).Ifr + ", ARQRttThreshold: " + ((dzx)localObject1).Ifs + ", ARQUsedRateThreshold: " + ((dzx)localObject1).Ift + ", ARQRespRateThreshold: " + ((dzx)localObject1).Ifu);
              if (((dzx)localObject1).Ify <= 0) {
                break label938;
              }
              w.this.Cwc.Ify = ((dzx)localObject1).Ify;
              w.this.Cwc.IfB = ((dzx)localObject1).IfB;
              if (((dzx)localObject1).IfD != null) {
                w.this.Cwc.IfD = ((dzx)localObject1).IfD;
              }
              w.this.Cwc.IfG = ((dzx)localObject1).IfG;
              w.this.Cwc.IfF = ((dzx)localObject1).IfF;
              w.this.Cpd.Csx.c(((dzx)localObject1).IfG, ((dzx)localObject1).IfF, w.this.Cpd.Csj.roomId, w.this.Cpd.Csj.uXg);
              if ((w.this.Cwc.Idl == null) || (w.this.Cwc.Idl.FTj == null) || (w.this.Cwc.Idl.FTj.getBuffer() == null) || (w.this.Cwc.Ifg == 0) || (w.this.Cwc.Idm == null) || (w.this.Cwc.Idm.FTj == null) || (w.this.Cwc.Idm.FTj.getBuffer() == null) || (w.this.Cwc.Ifh == null) || (w.this.Cwc.Ifh.IdA == 0) || (w.this.Cwc.Ifi == null) || (w.this.Cwc.Ifi.IdA == 0) || (w.this.Cwc.Ifp == null) || (w.this.Cwc.Ifp.IdA == 0)) {
                break label959;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
              AppMethodBeat.o(177026);
              return;
            }
          }
          catch (IOException localIOException)
          {
            ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
            AppMethodBeat.o(177026);
            return;
          }
          w.this.Cwc.Ifq = 0;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label907:
          w.this.Cwc.uXB = 1;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label928:
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label938:
          w.this.Cwc.Ify = 0;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label959:
          i = 0;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.Cwc.IfB + " BothSideSwitchFlag = " + localIOException.IfC);
        w.this.Cpd.UQ(w.this.Cwc.Ifg);
        w.this.Cpd.bS(w.this.Cwc.Idl.FTj.getBuffer().toByteArray());
        if ((localIOException.Ifn != null) && (localIOException.Ifn.getBuffer() != null) && (localIOException.Ifz != null) && (localIOException.Ifz.getBuffer() != null)) {
          w.this.Cpd.a(localIOException.Ifn.getBuffer().toByteArray(), localIOException.Ifm, w.this.Cwc.uXB, localIOException.Ifz.getBuffer().toByteArray());
        }
        if (c.eys().eBd() != 0) {
          w.this.Cpd.bT(w.this.Cwc.Idm.FTj.getBuffer().toByteArray());
        }
        Object localObject2;
        if ((localIOException.IeZ == null) || (localIOException.IeZ.HER == 0))
        {
          localObject2 = new ctv();
          ((ctv)localObject2).Gvr = 0;
          ((ctv)localObject2).Gvs = "";
          ((ctv)localObject2).Gvt = "";
          ((ctv)localObject2).Gvu = w.this.Cpd.Csj.netType;
          ((ctv)localObject2).Gvv = 4;
          ((ctv)localObject2).Gvw = 2;
          ((ctv)localObject2).HEP = localIOException.Ifh;
          ((ctv)localObject2).HEQ = localIOException.Ifp;
          localIOException.IeZ = new ctw();
          localIOException.IeZ.HER = 1;
          localIOException.IeZ.HES = new LinkedList();
          localIOException.IeZ.HES.add(localObject2);
        }
        if ((localIOException.Ifa == null) || (localIOException.Ifa.GvC == 0))
        {
          localObject2 = new afd();
          ((afd)localObject2).Gvr = 1;
          ((afd)localObject2).Gvs = "";
          ((afd)localObject2).Gvt = "";
          ((afd)localObject2).Gvu = w.this.Cpd.Csj.netType;
          ((afd)localObject2).Gvv = 4;
          ((afd)localObject2).Gvw = 2;
          ((afd)localObject2).Gvx = localIOException.Ifi;
          ((afd)localObject2).Gvy = localIOException.IfH;
          ((afd)localObject2).Gvz = localIOException.IfI;
          localIOException.Ifa = new afe();
          localIOException.Ifa.GvC = 1;
          localIOException.Ifa.GvD = new LinkedList();
          localIOException.Ifa.GvD.add(localObject2);
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.IeZ.HER);
        try
        {
          w.this.Cpd.Csj.Cyk = localIOException.IeZ.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.Cpd.Csj.Cyl = localIOException.Ifa.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.IfJ.GUe > 0) {
                  w.this.Cpd.Csj.Cym = localIOException.IfJ.toByteArray();
                }
                com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.Cwc.IfH);
                w.this.Cpd.j(w.this.Cwc.Ifq, w.this.Cwc.Ifr, w.this.Cwc.Ifs, w.this.Cwc.Ift, w.this.Cwc.Ifu);
                w.this.Cpd.UP(w.this.Cwc.Ify);
                localObject2 = w.this.Cpd;
                i = w.this.Cwc.Ifk;
                int j = w.this.Cwc.Ifl;
                ((l)localObject2).Csj.CwN = i;
                ((l)localObject2).Csj.CwO = j;
                w.this.Cpd.UO(w.this.Cwc.IfB);
                w.this.Cpd.Csj.CxY = localIOException.IfC;
                if ((localIOException.IfE != null) && (localIOException.IfE.getBuffer() != null)) {
                  w.this.Cpd.Csj.CwR = localIOException.IfE.getBuffer().toByteArray();
                }
                if ((localIOException.Ifw != null) && (localIOException.Ifw.getBuffer() != null) && (localIOException.Ifx != null) && (localIOException.Ifx.getBuffer() != null)) {
                  w.this.Cpd.c(localIOException.Ifv, localIOException.Ifw.getBuffer().toByteArray(), localIOException.Ifx.getBuffer().toByteArray());
                }
                localObject2 = w.this.Cpd;
                bsf localbsf = w.this.Cwc.IfD;
                localObject2 = ((l)localObject2).Csj;
                com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localbsf.Hfo + " Bitrate: " + localbsf.Hfp);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localbsf.Hfn;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localbsf.Hfo;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localbsf.Hfp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localbsf.Hfq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localbsf.Hfr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localbsf.Hfs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localbsf.Hft;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localbsf.Hfw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localbsf.Hfx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localbsf.HfA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localbsf.HfB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localbsf.HfE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localbsf.HfF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localbsf.HfI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localbsf.HfJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localbsf.HfM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localbsf.HfN;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localbsf.HfQ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localbsf.HfR;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localbsf.HfU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localbsf.HfV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localbsf.HfY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localbsf.HfZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localbsf.Hgc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localbsf.Hgd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localbsf.Hgg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localbsf.Hgh;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localbsf.Hfu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localbsf.Hfv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localbsf.Hfy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localbsf.Hfz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localbsf.HfC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localbsf.HfD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localbsf.HfG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localbsf.HfH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localbsf.HfK;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localbsf.HfL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localbsf.HfO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localbsf.HfP;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localbsf.HfS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localbsf.HfT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localbsf.HfW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localbsf.HfX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localbsf.Hga;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localbsf.Hgb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localbsf.Hge;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localbsf.Hgf;
                w.this.Cpd.ezS();
                com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                AppMethodBeat.o(177026);
                return;
                localException1 = localException1;
                ae.e("MicroMsg.Voip.VoipSyncHandle", "relay conn info to byte array fail..");
                continue;
                localException2 = localException2;
                ae.e("MicroMsg.Voip.VoipSyncHandle", "direct conn info to byte array fail..");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ae.e("MicroMsg.Voip.VoipSyncHandle", "nic query info to byte array fail..");
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(115209);
  }
  
  public final void a(eao parameao, int paramInt)
  {
    AppMethodBeat.i(115207);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + parameao.nJb);
    if (parameao.nJb == 1)
    {
      this.Cpd.CrI = true;
      if (1 == paramInt) {
        this.Cpd.Csj.CyH.eAc();
      }
      if (3 == paramInt) {
        this.Cpd.Csj.CyH.eAd();
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.Cpd.Csk.dfQ();
      c.eys().Cvg.eBH();
      this.Cpd.CrJ = true;
      if (this.Cpd.CrL == true)
      {
        this.Cpd.CrL = false;
        if (this.Cpd.CrH != true) {
          break label250;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.Cpd.ezK();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(11519, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(2) });
        this.Cpd.ezS();
        this.Cpd.ezU();
        AppMethodBeat.o(115207);
        return;
        label250:
        if (this.Cpd.CrK == true)
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.Cpd.J(1, -9000, "");
        }
        else
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (parameao.nJb == 6)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.Cpd.CrL = true;
      this.Cpd.Csj.Cxv = 1;
      this.Cpd.ezS();
      AppMethodBeat.o(115207);
      return;
    }
    if (parameao.nJb == 8)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.Cpd.Csj.CyH.Ctu = 211;
      this.Cpd.Csj.CyH.Ctt = 11;
      this.Cpd.Csj.CyH.CtF = 12;
      com.tencent.mm.plugin.report.service.g.yxI.f(11519, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(3) });
      this.Cpd.J(1, 211, "");
      this.Cpd.ezU();
      AppMethodBeat.o(115207);
      return;
    }
    if (parameao.nJb == 2)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.Cpd.Csj.CyH.Ctt = 103;
      this.Cpd.Csj.CyH.CtF = 4;
      this.Cpd.Csj.CyH.CtM = ((int)(System.currentTimeMillis() - this.Cpd.Csj.CyH.beginTime));
      com.tencent.mm.plugin.report.service.g.yxI.f(11519, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(1) });
      this.Cpd.ezU();
      this.Cpd.J(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (parameao.nJb == 3)
    {
      this.Cpd.Csj.CyH.CtF = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (parameao.nJb == 4)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.Cpd.mStatus < 6) {
        this.Cpd.Csj.CyH.CtG = 1;
      }
      this.Cpd.Csj.CyH.Ctt = 110;
      this.Cpd.J(6, 0, "");
      this.Cpd.ezU();
      AppMethodBeat.o(115207);
      return;
    }
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + parameao.nJb);
    AppMethodBeat.o(115207);
  }
  
  public final void b(ead paramead)
  {
    AppMethodBeat.i(115210);
    this.Cpd.bU(paramead.FTj.getBuffer().toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(115211);
    int i = com.tencent.mm.plugin.voip.b.f.bY(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.Cpd.UK(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void eBK()
  {
    AppMethodBeat.i(115205);
    if (this.Cwd == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.Cwd.nIE.clear();
    this.Cwd.nID = 0;
    this.Cwd = null;
    this.Cwe = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void n(n paramn)
  {
    AppMethodBeat.i(115212);
    ae.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.Cpd.Csp = false;
    Object localObject1 = (eaq)((m)paramn).eBP();
    if (this.Cpd.Csn == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.Cpd.Csj.parseSyncKeyBuff(this.Cpd.Csn, this.Cpd.Csn.length);
    int j = this.Cpd.Csj.field_statusSyncKey;
    int k = this.Cpd.Csj.field_relayDataSyncKey;
    int m = this.Cpd.Csj.field_connectingStatusKey;
    this.Cpd.Csj.parseSyncKeyBuff(((eaq)localObject1).GjQ.getBuffer().toByteArray(), ((eaq)localObject1).GjQ.getILen());
    int n = this.Cpd.Csj.field_statusSyncKey;
    int i1 = this.Cpd.Csj.field_relayDataSyncKey;
    int i2 = this.Cpd.Csj.field_connectingStatusKey;
    ae.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    ae.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.Cpd.Csn = ((eaq)localObject1).GjQ.getBuffer().toByteArray();
    ae.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((eaq)localObject1).GeQ);
    localObject1 = ((eaq)localObject1).IgA.nIE;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      ae.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramn).eBN();
      ae.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramn = (dzf)((LinkedList)localObject1).get(i);
        int i3 = paramn.Gru;
        ae.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.Cpd.Csj.roomId != 0) {
              break label487;
            }
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label487:
          Object localObject2;
          try
          {
            localObject2 = (eao)new eao().parseFrom(paramn.Grv.getBuffer().toByteArray());
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramn.uvG + ",itemStatus =  " + ((eao)localObject2).nJb);
            a((eao)localObject2, 3);
          }
          catch (IOException paramn)
          {
            ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.Cpd.Csj.roomId == 0)
              {
                com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (ead)new ead().parseFrom(paramn.Grv.getBuffer().toByteArray());
                  com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((ead)localObject2).nJA + ",from user = " + paramn.uvG);
                  if (((ead)localObject2).nJA != 5) {
                    break label712;
                  }
                  a((ead)localObject2);
                }
                catch (IOException paramn)
                {
                  ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                }
                continue;
                label712:
                if (((ead)localObject2).nJA == 3)
                {
                  this.Cpd.bT(((ead)localObject2).FTj.getBuffer().toByteArray());
                  if ((((ead)localObject2).FTj != null) && (((ead)localObject2).FTj.getBuffer() != null)) {
                    this.Cwc.Idm = ((ead)localObject2);
                  }
                }
                else if (((ead)localObject2).nJA == 2)
                {
                  this.Cpd.bS(((ead)localObject2).FTj.getBuffer().toByteArray());
                  if ((((ead)localObject2).FTj != null) && (((ead)localObject2).FTj.getBuffer() != null)) {
                    this.Cwc.Idl = ((ead)localObject2);
                  }
                }
                else if (((ead)localObject2).nJA == 1)
                {
                  b((ead)localObject2);
                }
                else if (((ead)localObject2).nJA == 6)
                {
                  paramn = ((ead)localObject2).FTj.getBuffer().toByteArray();
                  try
                  {
                    paramn = (dzw)new dzw().parseFrom(paramn);
                    if (paramn == null) {
                      continue;
                    }
                    this.Cpd.Csm.a(paramn);
                  }
                  catch (IOException paramn)
                  {
                    for (;;)
                    {
                      ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                      paramn = null;
                    }
                  }
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.Cpd.Csj.roomId == 0)
            {
              ae.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramn.Grv.getBuffer().toByteArray());
                if (!paramn.uvG.equals(com.tencent.mm.model.v.aAC())) {
                  break label1018;
                }
                com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramn)
              {
                ae.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
              }
              continue;
              label1018:
              c((SKBuiltinBuffer_t)localObject2);
            }
          }
        }
      }
    }
    ae.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.Cwd != null) && (this.Cwd.nID > 0)) || (this.Cwe > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */