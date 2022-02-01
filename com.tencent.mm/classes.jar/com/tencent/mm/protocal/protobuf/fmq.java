package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fmq
  extends erp
{
  public gol YOj;
  public String ZxK;
  public int abMU;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133203);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZxK != null) {
        paramVarArgs.g(2, this.ZxK);
      }
      paramVarArgs.bS(3, this.abMU);
      if (this.yts != null) {
        paramVarArgs.g(4, this.yts);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(5, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133203);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZxK != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZxK);
      }
      i += i.a.a.b.b.a.cJ(3, this.abMU);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.yts);
      }
      i = paramInt;
      if (this.YOj != null) {
        i = paramInt + i.a.a.a.qC(5, this.YOj.computeSize());
      }
      AppMethodBeat.o(133203);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133203);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fmq localfmq = (fmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133203);
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
            localfmq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133203);
          return 0;
        case 2: 
          localfmq.ZxK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133203);
          return 0;
        case 3: 
          localfmq.abMU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133203);
          return 0;
        case 4: 
          localfmq.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133203);
          return 0;
        }
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
          localfmq.YOj = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133203);
        return 0;
      }
      AppMethodBeat.o(133203);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmq
 * JD-Core Version:    0.7.0.1
 */