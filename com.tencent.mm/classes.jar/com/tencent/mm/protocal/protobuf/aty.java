package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aty
  extends dyl
{
  public long Bkz;
  public long SGI;
  public String finderUsername;
  public int scene;
  public b xHE;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168976);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(2, this.finderUsername);
      }
      paramVarArgs.bm(3, this.Bkz);
      if (this.xHE != null) {
        paramVarArgs.c(4, this.xHE);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(5, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.SGI);
      paramVarArgs.aY(7, this.scene);
      AppMethodBeat.o(168976);
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
      int i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.finderUsername);
      }
      i += g.a.a.b.b.a.p(3, this.Bkz);
      paramInt = i;
      if (this.xHE != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.xHE);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(5, this.yjp.computeSize());
      }
      paramInt = g.a.a.b.b.a.p(6, this.SGI);
      int j = g.a.a.b.b.a.bM(7, this.scene);
      AppMethodBeat.o(168976);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aty localaty = (aty)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168976);
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
            localaty.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 2: 
          localaty.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168976);
          return 0;
        case 3: 
          localaty.Bkz = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168976);
          return 0;
        case 4: 
          localaty.xHE = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168976);
          return 0;
        case 5: 
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
            localaty.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168976);
          return 0;
        case 6: 
          localaty.SGI = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168976);
          return 0;
        }
        localaty.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(168976);
        return 0;
      }
      AppMethodBeat.o(168976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aty
 * JD-Core Version:    0.7.0.1
 */