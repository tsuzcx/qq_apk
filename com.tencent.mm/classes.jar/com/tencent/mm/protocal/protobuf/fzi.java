package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzi
  extends erp
{
  public int IJG;
  public gol NkQ;
  public int YWY;
  public int YYs;
  public String abRF;
  public int abRH;
  public int abWH;
  public LinkedList<etl> abWI;
  public int abWJ;
  public etl abvh;
  public int oOu;
  
  public fzi()
  {
    AppMethodBeat.i(148668);
    this.abWI = new LinkedList();
    AppMethodBeat.o(148668);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148669);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.NkQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148669);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.NkQ != null)
      {
        paramVarArgs.qD(2, this.NkQ.computeSize());
        this.NkQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YYs);
      if (this.abRF != null) {
        paramVarArgs.g(4, this.abRF);
      }
      paramVarArgs.bS(5, this.oOu);
      paramVarArgs.bS(6, this.abRH);
      paramVarArgs.bS(7, this.YWY);
      paramVarArgs.bS(8, this.abWH);
      paramVarArgs.e(9, 8, this.abWI);
      if (this.abvh != null)
      {
        paramVarArgs.qD(10, this.abvh.computeSize());
        this.abvh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.abWJ);
      paramVarArgs.bS(12, this.IJG);
      AppMethodBeat.o(148669);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NkQ != null) {
        i = paramInt + i.a.a.a.qC(2, this.NkQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.YYs);
      paramInt = i;
      if (this.abRF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abRF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.oOu) + i.a.a.b.b.a.cJ(6, this.abRH) + i.a.a.b.b.a.cJ(7, this.YWY) + i.a.a.b.b.a.cJ(8, this.abWH) + i.a.a.a.c(9, 8, this.abWI);
      paramInt = i;
      if (this.abvh != null) {
        paramInt = i + i.a.a.a.qC(10, this.abvh.computeSize());
      }
      i = i.a.a.b.b.a.cJ(11, this.abWJ);
      int j = i.a.a.b.b.a.cJ(12, this.IJG);
      AppMethodBeat.o(148669);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.NkQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148669);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148669);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzi localfzi = (fzi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148669);
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
            localfzi.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 2: 
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
            localfzi.NkQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 3: 
          localfzi.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        case 4: 
          localfzi.abRF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(148669);
          return 0;
        case 5: 
          localfzi.oOu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        case 6: 
          localfzi.abRH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        case 7: 
          localfzi.YWY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        case 8: 
          localfzi.abWH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfzi.abWI.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfzi.abvh = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148669);
          return 0;
        case 11: 
          localfzi.abWJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148669);
          return 0;
        }
        localfzi.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148669);
        return 0;
      }
      AppMethodBeat.o(148669);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzi
 * JD-Core Version:    0.7.0.1
 */