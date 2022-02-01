package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class hv
  extends com.tencent.mm.cd.a
{
  public int CQK;
  public eae RNl;
  public cke RNm;
  public int RNn;
  public eae RNo;
  public String RNp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133152);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.RNo == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.CQK);
      if (this.RNl != null)
      {
        paramVarArgs.oE(2, this.RNl.computeSize());
        this.RNl.writeFields(paramVarArgs);
      }
      if (this.RNm != null)
      {
        paramVarArgs.oE(3, this.RNm.computeSize());
        this.RNm.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.RNn);
      if (this.RNo != null)
      {
        paramVarArgs.oE(5, this.RNo.computeSize());
        this.RNo.writeFields(paramVarArgs);
      }
      if (this.RNp != null) {
        paramVarArgs.f(6, this.RNp);
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CQK) + 0;
      paramInt = i;
      if (this.RNl != null) {
        paramInt = i + g.a.a.a.oD(2, this.RNl.computeSize());
      }
      i = paramInt;
      if (this.RNm != null) {
        i = paramInt + g.a.a.a.oD(3, this.RNm.computeSize());
      }
      i += g.a.a.b.b.a.bM(4, this.RNn);
      paramInt = i;
      if (this.RNo != null) {
        paramInt = i + g.a.a.a.oD(5, this.RNo.computeSize());
      }
      i = paramInt;
      if (this.RNp != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RNp);
      }
      AppMethodBeat.o(133152);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.RNl == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      if (this.RNo == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomKey");
        AppMethodBeat.o(133152);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      hv localhv = (hv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133152);
        return -1;
      case 1: 
        localhv.CQK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133152);
        return 0;
      case 2: 
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
          localhv.RNl = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cke();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cke)localObject2).parseFrom((byte[])localObject1);
          }
          localhv.RNm = ((cke)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      case 4: 
        localhv.RNn = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(133152);
        return 0;
      case 5: 
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
          localhv.RNo = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133152);
        return 0;
      }
      localhv.RNp = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(133152);
      return 0;
    }
    AppMethodBeat.o(133152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hv
 * JD-Core Version:    0.7.0.1
 */