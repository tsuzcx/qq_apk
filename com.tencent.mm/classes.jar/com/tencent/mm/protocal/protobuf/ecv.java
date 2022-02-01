package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ecv
  extends dyy
{
  public String RPV;
  public cyb RPW;
  public ciu RQB;
  public civ RQC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32424);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RPW != null)
      {
        paramVarArgs.oE(2, this.RPW.computeSize());
        this.RPW.writeFields(paramVarArgs);
      }
      if (this.RQB != null)
      {
        paramVarArgs.oE(3, this.RQB.computeSize());
        this.RQB.writeFields(paramVarArgs);
      }
      if (this.RQC != null)
      {
        paramVarArgs.oE(4, this.RQC.computeSize());
        this.RQC.writeFields(paramVarArgs);
      }
      if (this.RPV != null) {
        paramVarArgs.f(5, this.RPV);
      }
      AppMethodBeat.o(32424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RPW != null) {
        paramInt = i + g.a.a.a.oD(2, this.RPW.computeSize());
      }
      i = paramInt;
      if (this.RQB != null) {
        i = paramInt + g.a.a.a.oD(3, this.RQB.computeSize());
      }
      paramInt = i;
      if (this.RQC != null) {
        paramInt = i + g.a.a.a.oD(4, this.RQC.computeSize());
      }
      i = paramInt;
      if (this.RPV != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RPV);
      }
      AppMethodBeat.o(32424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ecv localecv = (ecv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32424);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localecv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyb)localObject2).parseFrom((byte[])localObject1);
            }
            localecv.RPW = ((cyb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ciu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ciu)localObject2).parseFrom((byte[])localObject1);
            }
            localecv.RQB = ((ciu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new civ();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((civ)localObject2).parseFrom((byte[])localObject1);
            }
            localecv.RQC = ((civ)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32424);
          return 0;
        }
        localecv.RPV = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32424);
        return 0;
      }
      AppMethodBeat.o(32424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecv
 * JD-Core Version:    0.7.0.1
 */