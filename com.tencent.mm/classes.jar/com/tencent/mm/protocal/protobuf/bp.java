package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bp
  extends cvw
{
  public String FMb;
  public String FMc;
  public String FMd;
  public String FMe;
  public String FMf;
  public String FMg;
  public int FMi;
  public String FMj;
  public long FMk;
  public cb FMl;
  public int FMm;
  public int FMn;
  public String FMo;
  public int FMp;
  public b FMq;
  public b FMr;
  public long FMs;
  public int FMt;
  public int FMu;
  public int FMv;
  public String bssid;
  public int doj;
  public String imei;
  public int scene;
  public String ssid;
  public String zmV;
  public String zpz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125693);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.zpz != null) {
        paramVarArgs.d(2, this.zpz);
      }
      paramVarArgs.aS(3, this.FMi);
      if (this.FMj != null) {
        paramVarArgs.d(4, this.FMj);
      }
      paramVarArgs.aS(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aZ(8, this.FMk);
      if (this.FMl != null)
      {
        paramVarArgs.lJ(9, this.FMl.computeSize());
        this.FMl.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.FMm);
      paramVarArgs.aS(11, this.FMn);
      paramVarArgs.aS(12, this.doj);
      if (this.FMo != null) {
        paramVarArgs.d(13, this.FMo);
      }
      paramVarArgs.aS(14, this.FMp);
      if (this.FMq != null) {
        paramVarArgs.c(15, this.FMq);
      }
      if (this.FMr != null) {
        paramVarArgs.c(16, this.FMr);
      }
      paramVarArgs.aZ(17, this.FMs);
      if (this.zmV != null) {
        paramVarArgs.d(18, this.zmV);
      }
      if (this.FMf != null) {
        paramVarArgs.d(19, this.FMf);
      }
      if (this.FMg != null) {
        paramVarArgs.d(20, this.FMg);
      }
      paramVarArgs.aS(21, this.FMt);
      paramVarArgs.aS(22, this.FMu);
      paramVarArgs.aS(23, this.FMv);
      if (this.imei != null) {
        paramVarArgs.d(24, this.imei);
      }
      if (this.FMb != null) {
        paramVarArgs.d(25, this.FMb);
      }
      if (this.FMc != null) {
        paramVarArgs.d(26, this.FMc);
      }
      if (this.FMd != null) {
        paramVarArgs.d(27, this.FMd);
      }
      if (this.FMe != null) {
        paramVarArgs.d(28, this.FMe);
      }
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1886;
      }
    }
    label1886:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zpz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.zpz);
      }
      i += f.a.a.b.b.a.bz(3, this.FMi);
      paramInt = i;
      if (this.FMj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FMj);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.p(8, this.FMk);
      paramInt = i;
      if (this.FMl != null) {
        paramInt = i + f.a.a.a.lI(9, this.FMl.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.FMm) + f.a.a.b.b.a.bz(11, this.FMn) + f.a.a.b.b.a.bz(12, this.doj);
      paramInt = i;
      if (this.FMo != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FMo);
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FMp);
      paramInt = i;
      if (this.FMq != null) {
        paramInt = i + f.a.a.b.b.a.b(15, this.FMq);
      }
      i = paramInt;
      if (this.FMr != null) {
        i = paramInt + f.a.a.b.b.a.b(16, this.FMr);
      }
      i += f.a.a.b.b.a.p(17, this.FMs);
      paramInt = i;
      if (this.zmV != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.zmV);
      }
      i = paramInt;
      if (this.FMf != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FMf);
      }
      paramInt = i;
      if (this.FMg != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FMg);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.FMt) + f.a.a.b.b.a.bz(22, this.FMu) + f.a.a.b.b.a.bz(23, this.FMv);
      paramInt = i;
      if (this.imei != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.imei);
      }
      i = paramInt;
      if (this.FMb != null) {
        i = paramInt + f.a.a.b.b.a.e(25, this.FMb);
      }
      paramInt = i;
      if (this.FMc != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FMc);
      }
      i = paramInt;
      if (this.FMd != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.FMd);
      }
      paramInt = i;
      if (this.FMe != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.FMe);
      }
      AppMethodBeat.o(125693);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bp localbp = (bp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbp.zpz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbp.FMi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbp.FMj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbp.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbp.ssid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbp.bssid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbp.FMk = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbp.FMl = ((cb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbp.FMm = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbp.FMn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbp.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbp.FMo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbp.FMp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbp.FMq = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbp.FMr = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbp.FMs = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbp.zmV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbp.FMf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbp.FMg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbp.FMt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbp.FMu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 23: 
          localbp.FMv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125693);
          return 0;
        case 24: 
          localbp.imei = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 25: 
          localbp.FMb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 26: 
          localbp.FMc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 27: 
          localbp.FMd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbp.FMe = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bp
 * JD-Core Version:    0.7.0.1
 */