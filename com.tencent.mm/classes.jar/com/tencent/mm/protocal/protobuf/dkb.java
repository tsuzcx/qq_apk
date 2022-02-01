package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkb
  extends cpx
{
  public String DKS;
  public String DQt;
  public String FSA;
  public String FSR;
  public String FSZ;
  public String FSz;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DKS != null) {
        paramVarArgs.d(2, this.DKS);
      }
      if (this.DQt != null) {
        paramVarArgs.d(3, this.DQt);
      }
      if (this.FSz != null) {
        paramVarArgs.d(4, this.FSz);
      }
      if (this.FSA != null) {
        paramVarArgs.d(5, this.FSA);
      }
      paramVarArgs.aR(6, this.uiK);
      if (this.FSR != null) {
        paramVarArgs.d(7, this.FSR);
      }
      if (this.FSZ != null) {
        paramVarArgs.d(8, this.FSZ);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DKS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DKS);
      }
      i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQt);
      }
      paramInt = i;
      if (this.FSz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FSz);
      }
      i = paramInt;
      if (this.FSA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FSA);
      }
      i += f.a.a.b.b.a.bx(6, this.uiK);
      paramInt = i;
      if (this.FSR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FSR);
      }
      i = paramInt;
      if (this.FSZ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FSZ);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkb localdkb = (dkb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkb.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localdkb.DKS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localdkb.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localdkb.FSz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localdkb.FSA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localdkb.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localdkb.FSR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localdkb.FSZ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkb
 * JD-Core Version:    0.7.0.1
 */