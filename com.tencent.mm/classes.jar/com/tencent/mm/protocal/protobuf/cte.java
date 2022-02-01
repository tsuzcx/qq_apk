package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cte
  extends esc
{
  public LinkedList<cxl> IKB;
  public LinkedList<bz> ILb;
  public int aaza;
  public LinkedList<elo> aazb;
  public int aazc;
  public int aazd;
  public int aaze;
  public cxj aazf;
  
  public cte()
  {
    AppMethodBeat.i(152598);
    this.aazb = new LinkedList();
    this.ILb = new LinkedList();
    this.IKB = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaza);
      paramVarArgs.e(3, 8, this.aazb);
      paramVarArgs.bS(4, this.aazc);
      paramVarArgs.bS(5, this.aazd);
      paramVarArgs.e(6, 8, this.ILb);
      paramVarArgs.bS(7, this.aaze);
      paramVarArgs.e(8, 8, this.IKB);
      if (this.aazf != null)
      {
        paramVarArgs.qD(9, this.aazf.computeSize());
        this.aazf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label992;
      }
    }
    label992:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaza) + i.a.a.a.c(3, 8, this.aazb) + i.a.a.b.b.a.cJ(4, this.aazc) + i.a.a.b.b.a.cJ(5, this.aazd) + i.a.a.a.c(6, 8, this.ILb) + i.a.a.b.b.a.cJ(7, this.aaze) + i.a.a.a.c(8, 8, this.IKB);
      paramInt = i;
      if (this.aazf != null) {
        paramInt = i + i.a.a.a.qC(9, this.aazf.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aazb.clear();
        this.ILb.clear();
        this.IKB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cte localcte = (cte)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
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
            localcte.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localcte.aaza = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elo)localObject2).parseFrom((byte[])localObject1);
            }
            localcte.aazb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localcte.aazc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localcte.aazd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bz)localObject2).parseFrom((byte[])localObject1);
            }
            localcte.ILb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localcte.aaze = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxl)localObject2).parseFrom((byte[])localObject1);
            }
            localcte.IKB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cxj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cxj)localObject2).parseFrom((byte[])localObject1);
          }
          localcte.aazf = ((cxj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cte
 * JD-Core Version:    0.7.0.1
 */