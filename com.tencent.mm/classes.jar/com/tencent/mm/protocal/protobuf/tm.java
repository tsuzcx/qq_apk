package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tm
  extends com.tencent.mm.bw.a
{
  public String GjC;
  public String GjD;
  public String GjE;
  public int GjF;
  public String GjG;
  public ti GjH;
  public String GjI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GjC != null) {
        paramVarArgs.d(1, this.GjC);
      }
      if (this.GjD != null) {
        paramVarArgs.d(2, this.GjD);
      }
      if (this.GjE != null) {
        paramVarArgs.d(3, this.GjE);
      }
      paramVarArgs.aS(4, this.GjF);
      if (this.GjG != null) {
        paramVarArgs.d(5, this.GjG);
      }
      if (this.GjH != null)
      {
        paramVarArgs.lJ(6, this.GjH.computeSize());
        this.GjH.writeFields(paramVarArgs);
      }
      if (this.GjI != null) {
        paramVarArgs.d(7, this.GjI);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GjC == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.GjC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GjD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GjD);
      }
      i = paramInt;
      if (this.GjE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GjE);
      }
      i += f.a.a.b.b.a.bz(4, this.GjF);
      paramInt = i;
      if (this.GjG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GjG);
      }
      i = paramInt;
      if (this.GjH != null) {
        i = paramInt + f.a.a.a.lI(6, this.GjH.computeSize());
      }
      paramInt = i;
      if (this.GjI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GjI);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tm localtm = (tm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localtm.GjC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localtm.GjD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localtm.GjE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localtm.GjF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localtm.GjG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtm.GjH = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localtm.GjI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tm
 * JD-Core Version:    0.7.0.1
 */