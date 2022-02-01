package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends erp
{
  public String YzM;
  public bi YzR;
  public long YzS;
  public String YzT;
  public String YzU;
  public String YzV;
  public String YzW;
  public int scene;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257857);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.YzM != null) {
        paramVarArgs.g(4, this.YzM);
      }
      if (this.YzR != null)
      {
        paramVarArgs.qD(5, this.YzR.computeSize());
        this.YzR.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.YzS);
      if (this.YzT != null) {
        paramVarArgs.g(7, this.YzT);
      }
      if (this.YzU != null) {
        paramVarArgs.g(8, this.YzU);
      }
      if (this.YzV != null) {
        paramVarArgs.g(9, this.YzV);
      }
      if (this.YzW != null) {
        paramVarArgs.g(10, this.YzW);
      }
      AppMethodBeat.o(257857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.title);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YzM);
      }
      i = paramInt;
      if (this.YzR != null) {
        i = paramInt + i.a.a.a.qC(5, this.YzR.computeSize());
      }
      i += i.a.a.b.b.a.q(6, this.YzS);
      paramInt = i;
      if (this.YzT != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YzT);
      }
      i = paramInt;
      if (this.YzU != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YzU);
      }
      paramInt = i;
      if (this.YzV != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YzV);
      }
      i = paramInt;
      if (this.YzW != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YzW);
      }
      AppMethodBeat.o(257857);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257857);
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
            locali.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257857);
          return 0;
        case 2: 
          locali.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257857);
          return 0;
        case 3: 
          locali.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257857);
          return 0;
        case 4: 
          locali.YzM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257857);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bi)localObject2).parseFrom((byte[])localObject1);
            }
            locali.YzR = ((bi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257857);
          return 0;
        case 6: 
          locali.YzS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257857);
          return 0;
        case 7: 
          locali.YzT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257857);
          return 0;
        case 8: 
          locali.YzU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257857);
          return 0;
        case 9: 
          locali.YzV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257857);
          return 0;
        }
        locali.YzW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257857);
        return 0;
      }
      AppMethodBeat.o(257857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.i
 * JD-Core Version:    0.7.0.1
 */