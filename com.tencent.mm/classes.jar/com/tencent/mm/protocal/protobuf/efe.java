package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efe
  extends dpc
{
  public com.tencent.mm.bw.b Buffer;
  public int NeZ;
  public int NfA;
  public String Nfi;
  public efh Nfj;
  public String Nfk;
  public String Nfl;
  public int Nfm;
  public int Nfn;
  public int Nfo;
  public boolean Nfp;
  public String Nfq;
  public int Nfr;
  public int Nfs;
  public int Nft;
  public String Nfu;
  public boolean Nfv;
  public String Nfw;
  public String Nfx;
  public int Nfy;
  public eff Nfz;
  public LinkedList<efc> xJg;
  
  public efe()
  {
    AppMethodBeat.i(152706);
    this.xJg = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xJg);
      if (this.Nfj != null)
      {
        paramVarArgs.ni(3, this.Nfj.computeSize());
        this.Nfj.writeFields(paramVarArgs);
      }
      if (this.Nfk != null) {
        paramVarArgs.e(4, this.Nfk);
      }
      if (this.Nfl != null) {
        paramVarArgs.e(5, this.Nfl);
      }
      paramVarArgs.aM(6, this.Nfm);
      paramVarArgs.aM(9, this.Nfn);
      paramVarArgs.aM(10, this.Nfo);
      paramVarArgs.aM(11, this.NeZ);
      paramVarArgs.cc(12, this.Nfp);
      if (this.Nfq != null) {
        paramVarArgs.e(13, this.Nfq);
      }
      paramVarArgs.aM(14, this.Nfr);
      paramVarArgs.aM(15, this.Nfs);
      if (this.Buffer != null) {
        paramVarArgs.c(16, this.Buffer);
      }
      paramVarArgs.aM(17, this.Nft);
      if (this.Nfu != null) {
        paramVarArgs.e(18, this.Nfu);
      }
      paramVarArgs.cc(19, this.Nfv);
      if (this.Nfw != null) {
        paramVarArgs.e(20, this.Nfw);
      }
      if (this.Nfx != null) {
        paramVarArgs.e(21, this.Nfx);
      }
      paramVarArgs.aM(22, this.Nfy);
      if (this.Nfz != null)
      {
        paramVarArgs.ni(23, this.Nfz.computeSize());
        this.Nfz.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(24, this.NfA);
      if (this.Nfi != null) {
        paramVarArgs.e(25, this.Nfi);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1802;
      }
    }
    label1802:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xJg);
      paramInt = i;
      if (this.Nfj != null) {
        paramInt = i + g.a.a.a.nh(3, this.Nfj.computeSize());
      }
      i = paramInt;
      if (this.Nfk != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Nfk);
      }
      paramInt = i;
      if (this.Nfl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Nfl);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Nfm) + g.a.a.b.b.a.bu(9, this.Nfn) + g.a.a.b.b.a.bu(10, this.Nfo) + g.a.a.b.b.a.bu(11, this.NeZ) + (g.a.a.b.b.a.fS(12) + 1);
      paramInt = i;
      if (this.Nfq != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.Nfq);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.Nfr) + g.a.a.b.b.a.bu(15, this.Nfs);
      paramInt = i;
      if (this.Buffer != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.Buffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.Nft);
      paramInt = i;
      if (this.Nfu != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.Nfu);
      }
      i = paramInt + (g.a.a.b.b.a.fS(19) + 1);
      paramInt = i;
      if (this.Nfw != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.Nfw);
      }
      i = paramInt;
      if (this.Nfx != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.Nfx);
      }
      i += g.a.a.b.b.a.bu(22, this.Nfy);
      paramInt = i;
      if (this.Nfz != null) {
        paramInt = i + g.a.a.a.nh(23, this.Nfz.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.NfA);
      paramInt = i;
      if (this.Nfi != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.Nfi);
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xJg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efe localefe = (efe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefe.xJg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((efh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefe.Nfj = ((efh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localefe.Nfk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localefe.Nfl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localefe.Nfm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localefe.Nfn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localefe.Nfo = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localefe.NeZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localefe.Nfp = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localefe.Nfq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localefe.Nfr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localefe.Nfs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localefe.Buffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localefe.Nft = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localefe.Nfu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localefe.Nfv = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localefe.Nfw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localefe.Nfx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localefe.Nfy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eff();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eff)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localefe.Nfz = ((eff)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 24: 
          localefe.NfA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152707);
          return 0;
        }
        localefe.Nfi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efe
 * JD-Core Version:    0.7.0.1
 */