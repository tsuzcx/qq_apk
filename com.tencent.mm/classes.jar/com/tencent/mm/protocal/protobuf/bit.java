package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bit
  extends dyl
{
  public aqe SDi;
  public String query;
  public int scene;
  public b xcQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.query != null) {
        paramVarArgs.f(3, this.query);
      }
      if (this.xcQ != null) {
        paramVarArgs.c(5, this.xcQ);
      }
      paramVarArgs.aY(6, this.scene);
      AppMethodBeat.o(208009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.query);
      }
      paramInt = i;
      if (this.xcQ != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.xcQ);
      }
      i = g.a.a.b.b.a.bM(6, this.scene);
      AppMethodBeat.o(208009);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(208009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bit localbit = (bit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(208009);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localbit.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208009);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbit.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(208009);
          return 0;
        case 3: 
          localbit.query = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(208009);
          return 0;
        case 5: 
          localbit.xcQ = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(208009);
          return 0;
        }
        localbit.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(208009);
        return 0;
      }
      AppMethodBeat.o(208009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bit
 * JD-Core Version:    0.7.0.1
 */