package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvv
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
    AppMethodBeat.i(104375);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.TbM);
      if (this.UbO != null) {
        paramVarArgs.f(3, this.UbO);
      }
      if (this.UbP != null) {
        paramVarArgs.f(4, this.UbP);
      }
      if (this.TbJ != null) {
        paramVarArgs.f(5, this.TbJ);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(6, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.CPw);
      AppMethodBeat.o(104375);
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
      int i = paramInt + g.a.a.b.b.a.p(2, this.TbM);
      paramInt = i;
      if (this.UbO != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UbO);
      }
      i = paramInt;
      if (this.UbP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UbP);
      }
      paramInt = i;
      if (this.TbJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TbJ);
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(6, this.RQU.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(7, this.CPw);
      AppMethodBeat.o(104375);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104375);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvv localdvv = (dvv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104375);
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
            localdvv.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        case 2: 
          localdvv.TbM = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(104375);
          return 0;
        case 3: 
          localdvv.UbO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 4: 
          localdvv.UbP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 5: 
          localdvv.TbJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(104375);
          return 0;
        case 6: 
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
            localdvv.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104375);
          return 0;
        }
        localdvv.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(104375);
        return 0;
      }
      AppMethodBeat.o(104375);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvv
 * JD-Core Version:    0.7.0.1
 */