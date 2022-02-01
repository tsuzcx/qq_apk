package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezw
  extends dyl
{
  public int CPw;
  public eae RQU;
  public String TbJ;
  public long TbM;
  public String UbO;
  public String UbP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104379);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TbJ != null) {
        paramVarArgs.f(2, this.TbJ);
      }
      paramVarArgs.bm(3, this.TbM);
      if (this.RQU != null)
      {
        paramVarArgs.oE(4, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.UbO != null) {
        paramVarArgs.f(5, this.UbO);
      }
      if (this.UbP != null) {
        paramVarArgs.f(6, this.UbP);
      }
      paramVarArgs.aY(7, this.CPw);
      AppMethodBeat.o(104379);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TbJ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TbJ);
      }
      i += g.a.a.b.b.a.p(3, this.TbM);
      paramInt = i;
      if (this.RQU != null) {
        paramInt = i + g.a.a.a.oD(4, this.RQU.computeSize());
      }
      i = paramInt;
      if (this.UbO != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UbO);
      }
      paramInt = i;
      if (this.UbP != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UbP);
      }
      i = g.a.a.b.b.a.bM(7, this.CPw);
      AppMethodBeat.o(104379);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104379);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ezw localezw = (ezw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104379);
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
            localezw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 2: 
          localezw.TbJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 3: 
          localezw.TbM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(104379);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localezw.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104379);
          return 0;
        case 5: 
          localezw.UbO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104379);
          return 0;
        case 6: 
          localezw.UbP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104379);
          return 0;
        }
        localezw.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(104379);
        return 0;
      }
      AppMethodBeat.o(104379);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezw
 * JD-Core Version:    0.7.0.1
 */