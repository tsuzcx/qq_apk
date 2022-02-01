package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgg
  extends dyl
{
  public String username;
  public LinkedList<aqt> wqP;
  public aqe yjp;
  
  public bgg()
  {
    AppMethodBeat.i(169028);
    this.wqP = new LinkedList();
    AppMethodBeat.o(169028);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169029);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.e(3, 8, this.wqP);
      if (this.yjp != null)
      {
        paramVarArgs.oE(4, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i += g.a.a.a.c(3, 8, this.wqP);
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(4, this.yjp.computeSize());
      }
      AppMethodBeat.o(169029);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wqP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgg localbgg = (bgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169029);
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
            localbgg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169029);
          return 0;
        case 2: 
          localbgg.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169029);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqt)localObject2).parseFrom((byte[])localObject1);
            }
            localbgg.wqP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169029);
          return 0;
        }
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
          localbgg.yjp = ((aqe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169029);
        return 0;
      }
      AppMethodBeat.o(169029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgg
 * JD-Core Version:    0.7.0.1
 */