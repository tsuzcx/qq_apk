package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aup
  extends dyy
{
  public bhh SDf;
  public int SGK;
  public LinkedList<FinderObject> SGN;
  public String SGO;
  public int continueFlag;
  public int jlf;
  public com.tencent.mm.cd.b lastBuffer;
  public int zwD;
  
  public aup()
  {
    AppMethodBeat.i(168986);
    this.SGN = new LinkedList();
    AppMethodBeat.o(168986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168987);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168987);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SGN);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aY(4, this.continueFlag);
      paramVarArgs.aY(5, this.jlf);
      if (this.SGO != null) {
        paramVarArgs.f(6, this.SGO);
      }
      paramVarArgs.aY(7, this.zwD);
      paramVarArgs.aY(8, this.SGK);
      if (this.SDf != null)
      {
        paramVarArgs.oE(9, this.SDf.computeSize());
        this.SDf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168987);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label888;
      }
    }
    label888:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SGN);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.continueFlag) + g.a.a.b.b.a.bM(5, this.jlf);
      paramInt = i;
      if (this.SGO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SGO);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.zwD) + g.a.a.b.b.a.bM(8, this.SGK);
      paramInt = i;
      if (this.SDf != null) {
        paramInt = i + g.a.a.a.oD(9, this.SDf.computeSize());
      }
      AppMethodBeat.o(168987);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SGN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168987);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aup localaup = (aup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168987);
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
            localaup.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localaup.SGN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 3: 
          localaup.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168987);
          return 0;
        case 4: 
          localaup.continueFlag = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168987);
          return 0;
        case 5: 
          localaup.jlf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168987);
          return 0;
        case 6: 
          localaup.SGO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168987);
          return 0;
        case 7: 
          localaup.zwD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168987);
          return 0;
        case 8: 
          localaup.SGK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168987);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bhh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bhh)localObject2).parseFrom((byte[])localObject1);
          }
          localaup.SDf = ((bhh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      AppMethodBeat.o(168987);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aup
 * JD-Core Version:    0.7.0.1
 */