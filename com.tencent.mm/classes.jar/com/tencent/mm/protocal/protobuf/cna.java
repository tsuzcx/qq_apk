package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cna
  extends dyy
{
  public LinkedList<ezy> TuF;
  public LinkedList<String> TuG;
  public String TuH;
  public LinkedList<cnf> TuI;
  public cmt Tun;
  
  public cna()
  {
    AppMethodBeat.i(82440);
    this.TuF = new LinkedList();
    this.TuG = new LinkedList();
    this.TuI = new LinkedList();
    AppMethodBeat.o(82440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tun != null)
      {
        paramVarArgs.oE(2, this.Tun.computeSize());
        this.Tun.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.TuF);
      paramVarArgs.e(4, 1, this.TuG);
      if (this.TuH != null) {
        paramVarArgs.f(5, this.TuH);
      }
      paramVarArgs.e(6, 8, this.TuI);
      AppMethodBeat.o(82441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label822;
      }
    }
    label822:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Tun != null) {
        i = paramInt + g.a.a.a.oD(2, this.Tun.computeSize());
      }
      i = i + g.a.a.a.c(3, 8, this.TuF) + g.a.a.a.c(4, 1, this.TuG);
      paramInt = i;
      if (this.TuH != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TuH);
      }
      i = g.a.a.a.c(6, 8, this.TuI);
      AppMethodBeat.o(82441);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TuF.clear();
        this.TuG.clear();
        this.TuI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cna localcna = (cna)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82441);
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
            localcna.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmt)localObject2).parseFrom((byte[])localObject1);
            }
            localcna.Tun = ((cmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ezy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ezy)localObject2).parseFrom((byte[])localObject1);
            }
            localcna.TuF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82441);
          return 0;
        case 4: 
          localcna.TuG.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(82441);
          return 0;
        case 5: 
          localcna.TuH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82441);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cnf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cnf)localObject2).parseFrom((byte[])localObject1);
          }
          localcna.TuI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82441);
        return 0;
      }
      AppMethodBeat.o(82441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cna
 * JD-Core Version:    0.7.0.1
 */