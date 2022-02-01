package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dwg
  extends esc
{
  public String Vbl;
  public boolean aaLz;
  public dke abbO;
  public String abbP;
  public arb abbQ;
  public LinkedList<aey> abbX;
  public int abbZ;
  public int abca;
  public LinkedList<aku> abcb;
  public LinkedList<eok> abcc;
  public LinkedList<jq> abcd;
  public efi abce;
  public int abcf;
  public String abcg;
  public efh abch;
  public efh abci;
  public String abcj;
  public aey abck;
  public efh abcl;
  public int ftr;
  public dkf ifY;
  public String wuA;
  public int wuz;
  
  public dwg()
  {
    AppMethodBeat.i(91561);
    this.abcb = new LinkedList();
    this.abcc = new LinkedList();
    this.abcd = new LinkedList();
    this.abbX = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.ftr);
      paramVarArgs.bS(5, this.abbZ);
      paramVarArgs.bS(6, this.abca);
      paramVarArgs.e(8, 8, this.abcb);
      if (this.abbO != null)
      {
        paramVarArgs.qD(9, this.abbO.computeSize());
        this.abbO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.abcc);
      paramVarArgs.e(11, 8, this.abcd);
      paramVarArgs.di(12, this.aaLz);
      if (this.abce != null)
      {
        paramVarArgs.qD(13, this.abce.computeSize());
        this.abce.writeFields(paramVarArgs);
      }
      if (this.abbP != null) {
        paramVarArgs.g(14, this.abbP);
      }
      if (this.abbQ != null)
      {
        paramVarArgs.qD(15, this.abbQ.computeSize());
        this.abbQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.abcf);
      if (this.abcg != null) {
        paramVarArgs.g(17, this.abcg);
      }
      if (this.abch != null)
      {
        paramVarArgs.qD(18, this.abch.computeSize());
        this.abch.writeFields(paramVarArgs);
      }
      if (this.abci != null)
      {
        paramVarArgs.qD(19, this.abci.computeSize());
        this.abci.writeFields(paramVarArgs);
      }
      if (this.abcj != null) {
        paramVarArgs.g(20, this.abcj);
      }
      if (this.abck != null)
      {
        paramVarArgs.qD(21, this.abck.computeSize());
        this.abck.writeFields(paramVarArgs);
      }
      if (this.abcl != null)
      {
        paramVarArgs.qD(22, this.abcl.computeSize());
        this.abcl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.abbX);
      if (this.ifY != null)
      {
        paramVarArgs.qD(99, this.ifY.computeSize());
        this.ifY.writeFields(paramVarArgs);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2540;
      }
    }
    label2540:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ftr) + i.a.a.b.b.a.cJ(5, this.abbZ) + i.a.a.b.b.a.cJ(6, this.abca) + i.a.a.a.c(8, 8, this.abcb);
      paramInt = i;
      if (this.abbO != null) {
        paramInt = i + i.a.a.a.qC(9, this.abbO.computeSize());
      }
      i = paramInt + i.a.a.a.c(10, 8, this.abcc) + i.a.a.a.c(11, 8, this.abcd) + (i.a.a.b.b.a.ko(12) + 1);
      paramInt = i;
      if (this.abce != null) {
        paramInt = i + i.a.a.a.qC(13, this.abce.computeSize());
      }
      i = paramInt;
      if (this.abbP != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abbP);
      }
      paramInt = i;
      if (this.abbQ != null) {
        paramInt = i + i.a.a.a.qC(15, this.abbQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.abcf);
      paramInt = i;
      if (this.abcg != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.abcg);
      }
      i = paramInt;
      if (this.abch != null) {
        i = paramInt + i.a.a.a.qC(18, this.abch.computeSize());
      }
      paramInt = i;
      if (this.abci != null) {
        paramInt = i + i.a.a.a.qC(19, this.abci.computeSize());
      }
      i = paramInt;
      if (this.abcj != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.abcj);
      }
      paramInt = i;
      if (this.abck != null) {
        paramInt = i + i.a.a.a.qC(21, this.abck.computeSize());
      }
      i = paramInt;
      if (this.abcl != null) {
        i = paramInt + i.a.a.a.qC(22, this.abcl.computeSize());
      }
      i += i.a.a.a.c(23, 8, this.abbX);
      paramInt = i;
      if (this.ifY != null) {
        paramInt = i + i.a.a.a.qC(99, this.ifY.computeSize());
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abcb.clear();
        this.abcc.clear();
        this.abcd.clear();
        this.abbX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dwg localdwg = (dwg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localdwg.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localdwg.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localdwg.ftr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localdwg.abbZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localdwg.abca = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aku)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abcb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dke)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abbO = ((dke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eok)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abcc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jq)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abcd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localdwg.aaLz = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efi)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abce = ((efi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localdwg.abbP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new arb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((arb)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abbQ = ((arb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localdwg.abcf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91562);
          return 0;
        case 17: 
          localdwg.abcg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efh)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abch = ((efh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efh)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abci = ((efh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 20: 
          localdwg.abcj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abck = ((aey)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efh)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abcl = ((efh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.abbX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 99: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkf)localObject2).parseFrom((byte[])localObject1);
            }
            localdwg.ifY = ((dkf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        }
        localdwg.Vbl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwg
 * JD-Core Version:    0.7.0.1
 */