package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ffp
  extends erp
{
  public int ExtFlag;
  public String MD5;
  public int NkN;
  public int NkO;
  public gol YLa;
  public int ZkT;
  public int aaTG;
  public int aaTH;
  public int abFA;
  public int abFB;
  public int abFC;
  public fqo abld;
  public String crB;
  public String nUv;
  public String oOI;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125830);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(125830);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.NkO);
      paramVarArgs.bS(17, this.abFA);
      paramVarArgs.bS(4, this.NkN);
      if (this.YLa != null)
      {
        paramVarArgs.qD(5, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      if (this.nUv != null) {
        paramVarArgs.g(6, this.nUv);
      }
      paramVarArgs.bS(7, this.aaTG);
      paramVarArgs.bS(8, this.aaTH);
      if (this.crB != null) {
        paramVarArgs.g(9, this.crB);
      }
      paramVarArgs.bS(10, this.abFB);
      paramVarArgs.bS(11, this.ZkT);
      if (this.abld != null)
      {
        paramVarArgs.qD(12, this.abld.computeSize());
        this.abld.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(13, this.oOI);
      }
      paramVarArgs.bS(14, this.ExtFlag);
      if (this.MD5 != null) {
        paramVarArgs.g(15, this.MD5);
      }
      paramVarArgs.bS(16, this.abFC);
      AppMethodBeat.o(125830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1292;
      }
    }
    label1292:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ) + i.a.a.b.b.a.cJ(3, this.NkO) + i.a.a.b.b.a.cJ(17, this.abFA) + i.a.a.b.b.a.cJ(4, this.NkN);
      paramInt = i;
      if (this.YLa != null) {
        paramInt = i + i.a.a.a.qC(5, this.YLa.computeSize());
      }
      i = paramInt;
      if (this.nUv != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nUv);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.aaTG) + i.a.a.b.b.a.cJ(8, this.aaTH);
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.crB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abFB) + i.a.a.b.b.a.cJ(11, this.ZkT);
      paramInt = i;
      if (this.abld != null) {
        paramInt = i + i.a.a.a.qC(12, this.abld.computeSize());
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(14, this.ExtFlag);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.MD5);
      }
      i = i.a.a.b.b.a.cJ(16, this.abFC);
      AppMethodBeat.o(125830);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YLa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(125830);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ffp localffp = (ffp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125830);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localffp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 2: 
          localffp.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 3: 
          localffp.NkO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 17: 
          localffp.abFA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 4: 
          localffp.NkN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localffp.YLa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 6: 
          localffp.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 7: 
          localffp.aaTG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 8: 
          localffp.aaTH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 9: 
          localffp.crB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 10: 
          localffp.abFB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 11: 
          localffp.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqo)localObject2).parseFrom((byte[])localObject1);
            }
            localffp.abld = ((fqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125830);
          return 0;
        case 13: 
          localffp.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125830);
          return 0;
        case 14: 
          localffp.ExtFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125830);
          return 0;
        case 15: 
          localffp.MD5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125830);
          return 0;
        }
        localffp.abFC = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(125830);
        return 0;
      }
      AppMethodBeat.o(125830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffp
 * JD-Core Version:    0.7.0.1
 */