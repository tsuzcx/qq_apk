package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azr
  extends esc
{
  public int BeA;
  public b ZEQ;
  public bjm ZGl;
  public int ZKn;
  public int ZKo;
  public String ZKp;
  public LinkedList<cai> nUC;
  
  public azr()
  {
    AppMethodBeat.i(259056);
    this.nUC = new LinkedList();
    AppMethodBeat.o(259056);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259063);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      if (this.ZGl != null)
      {
        paramVarArgs.qD(3, this.ZGl.computeSize());
        this.ZGl.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(4, this.ZEQ);
      }
      paramVarArgs.bS(5, this.BeA);
      paramVarArgs.bS(6, this.ZKn);
      paramVarArgs.bS(7, this.ZKo);
      if (this.ZKp != null) {
        paramVarArgs.g(1000, this.ZKp);
      }
      AppMethodBeat.o(259063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label820;
      }
    }
    label820:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.nUC);
      paramInt = i;
      if (this.ZGl != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZGl.computeSize());
      }
      i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.ZEQ);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.BeA) + i.a.a.b.b.a.cJ(6, this.ZKn) + i.a.a.b.b.a.cJ(7, this.ZKo);
      paramInt = i;
      if (this.ZKp != null) {
        paramInt = i + i.a.a.b.b.a.h(1000, this.ZKp);
      }
      AppMethodBeat.o(259063);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259063);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azr localazr = (azr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259063);
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
            localazr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259063);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cai)localObject2).parseFrom((byte[])localObject1);
            }
            localazr.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259063);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bjm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bjm)localObject2).parseFrom((byte[])localObject1);
            }
            localazr.ZGl = ((bjm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259063);
          return 0;
        case 4: 
          localazr.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259063);
          return 0;
        case 5: 
          localazr.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259063);
          return 0;
        case 6: 
          localazr.ZKn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259063);
          return 0;
        case 7: 
          localazr.ZKo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259063);
          return 0;
        }
        localazr.ZKp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259063);
        return 0;
      }
      AppMethodBeat.o(259063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azr
 * JD-Core Version:    0.7.0.1
 */