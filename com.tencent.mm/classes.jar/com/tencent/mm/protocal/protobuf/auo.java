package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class auo
  extends dyl
{
  public String RLN;
  public aqo SCW;
  public long SGM;
  public int fEH;
  public b lastBuffer;
  public String xcW;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168985);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SGM);
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(4, this.lastBuffer);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(5, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.xcW != null) {
        paramVarArgs.f(6, this.xcW);
      }
      paramVarArgs.aY(7, this.fEH);
      if (this.SCW != null)
      {
        paramVarArgs.oE(8, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168985);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SGM);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RLN);
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.lastBuffer);
      }
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(5, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.xcW != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.xcW);
      }
      i += g.a.a.b.b.a.bM(7, this.fEH);
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(8, this.SCW.computeSize());
      }
      AppMethodBeat.o(168985);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        auo localauo = (auo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168985);
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
            localauo.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 2: 
          localauo.SGM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(168985);
          return 0;
        case 3: 
          localauo.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 4: 
          localauo.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(168985);
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
            localauo.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168985);
          return 0;
        case 6: 
          localauo.xcW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(168985);
          return 0;
        case 7: 
          localauo.fEH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(168985);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqo)localObject2).parseFrom((byte[])localObject1);
          }
          localauo.SCW = ((aqo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168985);
        return 0;
      }
      AppMethodBeat.o(168985);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auo
 * JD-Core Version:    0.7.0.1
 */