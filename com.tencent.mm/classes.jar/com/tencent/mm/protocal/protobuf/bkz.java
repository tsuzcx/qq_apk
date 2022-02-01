package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkz
  extends dyl
{
  public String RLN;
  public aqe SDi;
  public int SGE;
  public String fGe;
  public int scene;
  public String xbM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202026);
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
      if (this.fGe != null) {
        paramVarArgs.f(3, this.fGe);
      }
      paramVarArgs.aY(4, this.SGE);
      if (this.RLN != null) {
        paramVarArgs.f(5, this.RLN);
      }
      paramVarArgs.aY(6, this.scene);
      if (this.xbM != null) {
        paramVarArgs.f(7, this.xbM);
      }
      AppMethodBeat.o(202026);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.fGe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fGe);
      }
      i += g.a.a.b.b.a.bM(4, this.SGE);
      paramInt = i;
      if (this.RLN != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RLN);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.scene);
      paramInt = i;
      if (this.xbM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.xbM);
      }
      AppMethodBeat.o(202026);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202026);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkz localbkz = (bkz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(202026);
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
            localbkz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202026);
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
            localbkz.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(202026);
          return 0;
        case 3: 
          localbkz.fGe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202026);
          return 0;
        case 4: 
          localbkz.SGE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202026);
          return 0;
        case 5: 
          localbkz.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(202026);
          return 0;
        case 6: 
          localbkz.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(202026);
          return 0;
        }
        localbkz.xbM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(202026);
        return 0;
      }
      AppMethodBeat.o(202026);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkz
 * JD-Core Version:    0.7.0.1
 */