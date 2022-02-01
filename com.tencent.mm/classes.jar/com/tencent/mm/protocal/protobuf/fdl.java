package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdl
  extends erp
{
  public int IJG;
  public int IcB;
  public long Id;
  public epj YGq;
  public gol abCX;
  public gol abCY;
  public int abCZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125766);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.Id);
      paramVarArgs.bS(3, this.IJG);
      if (this.abCX != null)
      {
        paramVarArgs.qD(4, this.abCX.computeSize());
        this.abCX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.IcB);
      if (this.abCY != null)
      {
        paramVarArgs.qD(6, this.abCY.computeSize());
        this.abCY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.abCZ);
      if (this.YGq != null)
      {
        paramVarArgs.qD(8, this.YGq.computeSize());
        this.YGq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Id) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.abCX != null) {
        paramInt = i + i.a.a.a.qC(4, this.abCX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IcB);
      paramInt = i;
      if (this.abCY != null) {
        paramInt = i + i.a.a.a.qC(6, this.abCY.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.abCZ);
      paramInt = i;
      if (this.YGq != null) {
        paramInt = i + i.a.a.a.qC(8, this.YGq.computeSize());
      }
      AppMethodBeat.o(125766);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fdl localfdl = (fdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125766);
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
            localfdl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 2: 
          localfdl.Id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125766);
          return 0;
        case 3: 
          localfdl.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125766);
          return 0;
        case 4: 
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
            localfdl.abCX = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 5: 
          localfdl.IcB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125766);
          return 0;
        case 6: 
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
            localfdl.abCY = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125766);
          return 0;
        case 7: 
          localfdl.abCZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125766);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epj)localObject2).parseFrom((byte[])localObject1);
          }
          localfdl.YGq = ((epj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125766);
        return 0;
      }
      AppMethodBeat.o(125766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdl
 * JD-Core Version:    0.7.0.1
 */