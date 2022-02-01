package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avg
  extends dyl
{
  public int scene;
  public String username;
  public b xaw;
  public int xcE;
  public int xdc;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168988);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.xcE);
      if (this.xaw != null) {
        paramVarArgs.c(3, this.xaw);
      }
      if (this.username != null) {
        paramVarArgs.f(4, this.username);
      }
      paramVarArgs.aY(5, this.scene);
      if (this.yjp != null)
      {
        paramVarArgs.oE(6, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.xdc);
      AppMethodBeat.o(168988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.xcE);
      paramInt = i;
      if (this.xaw != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.xaw);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.username);
      }
      i += g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(6, this.yjp.computeSize());
      }
      i = g.a.a.b.b.a.bM(7, this.xdc);
      AppMethodBeat.o(168988);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avg localavg = (avg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168988);
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
            localavg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        case 2: 
          localavg.xcE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168988);
          return 0;
        case 3: 
          localavg.xaw = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168988);
          return 0;
        case 4: 
          localavg.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168988);
          return 0;
        case 5: 
          localavg.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168988);
          return 0;
        case 6: 
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
            localavg.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        }
        localavg.xdc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168988);
        return 0;
      }
      AppMethodBeat.o(168988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avg
 * JD-Core Version:    0.7.0.1
 */