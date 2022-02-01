package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bup
  extends dyy
{
  public int RIs;
  public String TeK;
  public int TeL;
  public int TeM;
  public LinkedList<Integer> TeN;
  public LinkedList<alk> TeO;
  public int TeP;
  
  public bup()
  {
    AppMethodBeat.i(256925);
    this.TeN = new LinkedList();
    this.TeO = new LinkedList();
    AppMethodBeat.o(256925);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256926);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(256926);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TeL);
      paramVarArgs.aY(3, this.TeM);
      paramVarArgs.aY(4, this.RIs);
      paramVarArgs.e(5, 2, this.TeN);
      paramVarArgs.e(6, 8, this.TeO);
      paramVarArgs.aY(7, this.TeP);
      if (this.TeK != null) {
        paramVarArgs.f(8, this.TeK);
      }
      AppMethodBeat.o(256926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label749;
      }
    }
    label749:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TeL) + g.a.a.b.b.a.bM(3, this.TeM) + g.a.a.b.b.a.bM(4, this.RIs) + g.a.a.a.c(5, 2, this.TeN) + g.a.a.a.c(6, 8, this.TeO) + g.a.a.b.b.a.bM(7, this.TeP);
      paramInt = i;
      if (this.TeK != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TeK);
      }
      AppMethodBeat.o(256926);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TeN.clear();
        this.TeO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(256926);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bup localbup = (bup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(256926);
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
            localbup.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256926);
          return 0;
        case 2: 
          localbup.TeL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256926);
          return 0;
        case 3: 
          localbup.TeM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256926);
          return 0;
        case 4: 
          localbup.RIs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256926);
          return 0;
        case 5: 
          localbup.TeN.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(256926);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alk)localObject2).parseFrom((byte[])localObject1);
            }
            localbup.TeO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(256926);
          return 0;
        case 7: 
          localbup.TeP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(256926);
          return 0;
        }
        localbup.TeK = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(256926);
        return 0;
      }
      AppMethodBeat.o(256926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bup
 * JD-Core Version:    0.7.0.1
 */